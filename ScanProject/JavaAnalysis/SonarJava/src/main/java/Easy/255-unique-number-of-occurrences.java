package main.java.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**https://leetcode.com/problems/unique-number-of-occurrences/ */
//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
// 
//Example 1:
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
//Example 2:
//Input: arr = [1,2]
//Output: false
//Example 3:
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
// 
//Constraints:
//	1 <= arr.length <= 1000
//	-1000 <= arr[i] <= 1000
class Solution90 {
    public boolean uniqueOccurrences(int[] arr) {

            Map<Integer, Integer> map = new HashMap<>();
            for(int num : arr){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            Set<Integer> set = new HashSet<>();
            for(int num : map.values()){
                if(!set.add(num)){
                    return false;
                }
            }
            return true;

    }
}