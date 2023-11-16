/**https://leetcode.com/problems/single-element-in-a-sorted-array/ */
//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//Return the single element that appears only once.
//Your solution must run in O(log n) time and O(1) space.
// 
//Example 1:
//Input: nums = [1,1,2,3,3,4,4,8,8]
//Output: 2
//Example 2:
//Input: nums = [3,3,7,7,10,11,11]
//Output: 10
// 
//Constraints:
//	1 <= nums.length <= 105
//	0 <= nums[i] <= 105
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}