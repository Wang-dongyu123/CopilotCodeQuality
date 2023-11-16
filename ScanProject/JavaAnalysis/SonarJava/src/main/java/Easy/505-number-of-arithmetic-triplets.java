package main.java.Easy;

import java.util.HashMap;
import java.util.Map;

/**https://leetcode.com/problems/number-of-arithmetic-triplets/ */
//You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
//	i < j < k,
//	nums[j] - nums[i] == diff, and
//	nums[k] - nums[j] == diff.
//Return the number of unique arithmetic triplets.
// 
//Example 1:
//Input: nums = [0,1,4,6,7,10], diff = 3
//Output: 2
//Explanation:
//(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
//(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3. 
//Example 2:
//Input: nums = [4,5,6,7,8,9], diff = 2
//Output: 2
//Explanation:
//(0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
//(1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.
// 
//Constraints:
//	3 <= nums.length <= 200
//	0 <= nums[i] <= 200
//	1 <= diff <= 50
//	nums is strictly increasing.
class Solution314 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i] - diff;
            int k = nums[i] + diff;
            if (map.containsKey(j)) {
                res += map.get(j);
            }
            if (map.containsKey(k)) {
                res += map.get(k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}