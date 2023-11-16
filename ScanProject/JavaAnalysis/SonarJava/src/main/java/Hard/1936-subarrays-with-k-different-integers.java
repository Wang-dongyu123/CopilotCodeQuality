package main.java.Hard;

import java.util.HashMap;
import java.util.Map;

/**https://leetcode.com/problems/subarrays-with-k-different-integers/ */
//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//A good array is an array where the number of different integers in that array is exactly k.
//	For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.
// 
//Example 1:
//Input: nums = [1,2,1,2,3], k = 2
//Output: 7
//Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
//Example 2:
//Input: nums = [1,2,1,3,4], k = 3
//Output: 3
//Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
// 
//Constraints:
//	1 <= nums.length <= 2 * 104
//	1 <= nums[i], k <= nums.length
class Solution35 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private int atMostK(int[] nums, int k){
        int res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < nums.length; right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num, 0) + 1);
            while(map.size() > k){
                int l = nums[left];
                map.put(l, map.get(l) - 1);
                if(map.get(l) == 0){
                    map.remove(l);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}