package main.java.Hard; /**https://leetcode.com/problems/find-in-mountain-array/ */
//(This problem is an interactive problem.)
//You may recall that an array arr is a mountain array if and only if:
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
//You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
//MountainArray.get(k) returns the element of the array at index k (0-indexed).
//MountainArray.length() returns the length of the array.
//Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.



  interface MountainArray {
      public int get(int index);
      public int length();
  }

 
class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peak = left;
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
        
        
    }
    public int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean asc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            }
            if (cur < target) {
                left = asc ? mid + 1 : left;
                right = asc ? right : mid - 1;
            } else {
                right = asc ? mid - 1 : right;
                left = asc ? left : mid + 1;
            }
        }
        return -1;
    }
}
     
    