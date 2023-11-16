package main.java.Hard;

import java.util.HashMap;
import java.util.Map;

/**https://leetcode.com/problems/arithmetic-slices-ii-subsequence/ */
//Given an integer array nums, return the number of all the arithmetic subsequences of nums.
//A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
//For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
//For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
//A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
//For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
//The test cases are generated so that the answer fits in 32-bit integer.


class ArithmeticSlicesIiSubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[] map = new Map[n];
        for(int i = 0; i < n; i++){
            map[i] = new HashMap<>();
            for(int j = 0; j < i; j++){
                long diff = (long)nums[i] - nums[j];
                if(diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE){
                    continue;
                }
                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
        return res;
        
    }
}
     
    