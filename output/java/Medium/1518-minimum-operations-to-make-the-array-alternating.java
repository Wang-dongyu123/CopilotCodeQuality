/**https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/ */
//You are given a 0-indexed array nums consisting of n positive integers.
//The array nums is called alternating if:
//	nums[i - 2] == nums[i], where 2 <= i <= n - 1.
//	nums[i - 1] != nums[i], where 1 <= i <= n - 1.
//In one operation, you can choose an index i and change nums[i] into any positive integer.
//Return the minimum number of operations required to make the array alternating.
// 
//Example 1:
//Input: nums = [3,1,3,2,4,3]
//Output: 3
//Explanation:
//One way to make the array alternating is by converting it to [3,1,3,1,3,1].
//The number of operations required in this case is 3.
//It can be proven that it is not possible to make the array alternating in less than 3 operations. 
//Example 2:
//Input: nums = [1,2,2,2,2]
//Output: 2
//Explanation:
//One way to make the array alternating is by converting it to [1,2,1,2,1].
//The number of operations required in this case is 2.
//Note that the array cannot be converted to [2,2,2,2,2] because in this case nums[0] == nums[1] which violates the conditions of an alternating array.
// 
//Constraints:
//	1 <= nums.length <= 105
//	1 <= nums[i] <= 105
class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (nums[i - 1] > nums[i - 2]) {
                pre[i]++;
            }
        }
        int res = Math.min(pre[n], n - pre[n]);
        for (int i = 1; i <= n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] < nums[i - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int cnt = pre[i - 1] - pre[l];
            l = 0;
            r = i - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] > nums[i - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            cnt += i - 1 - l - (pre[i - 1] - pre[l]);
            res = Math.min(res, cnt);
        }
        return res;
    }
}