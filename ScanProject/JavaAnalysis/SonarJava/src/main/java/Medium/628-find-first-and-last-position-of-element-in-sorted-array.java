package main.java.Medium;

/**https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ */
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//If target is not found in the array, return [-1, -1].
//You must write an algorithm with O(log n) runtime complexity.


class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
        
    }
    private int findFirst(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] >= target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
    private int findLast(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] <= target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
}

    