package main.java.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**https://leetcode.com/problems/verbal-arithmetic-puzzle/ */
//Given an equation, represented by words on the left side and the result on the right side.
//You need to check if the equation is solvable under the following rules:
//	Each character is decoded as one digit (0 - 9).
//	No two characters can map to the same digit.
//	Each words[i] and result are decoded as one number without leading zeros.
//	Sum of numbers on the left side (words) will equal to the number on the right side (result).
//Return true if the equation is solvable, otherwise return false.
// 
//Example 1:
//Input: words = ["SEND","MORE"], result = "MONEY"
//Output: true
//Explanation: Map 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
//Such that: "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
//Example 2:
//Input: words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
//Output: true
//Explanation: Map 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
//Such that: "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
//Example 3:
//Input: words = ["LEET","CODE"], result = "POINT"
//Output: false
//Explanation: There is no possible mapping to satisfy the equation, so we return false.
//Note that two different characters cannot map to the same digit.
// 
//Constraints:
//	2 <= words.length <= 5
//	1 <= words[i].length, result.length <= 7
//	words[i], result contain only uppercase English letters.
//	The number of different characters used in the expression is at most 10.
class Solution46 {
    public boolean isSolvable(String[] words, String result) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                set.add(c);
            }
        }
        for(char c : result.toCharArray()){
            set.add(c);
        }
        int[] nums = new int[set.size()];
        int i = 0;
        for(char c : set){
            nums[i++] = c - 'A';
        }
        return dfs(words, result, nums, 0, map);
    }
    private boolean dfs(String[] words, String result, int[] nums, int index, Map<Character, Integer> map){
        if(index == nums.length){
            return check(words, result, map);
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, i, index);
            map.put((char)('A' + nums[index]), 0);
            if(dfs(words, result, nums, index + 1, map)){
                return true;
            }
            swap(nums, i, index);
        }
        return false;
    }
    private boolean check(String[] words, String result, Map<Character, Integer> map){
        int sum = 0;
        for(String word : words){
            int cur = 0;
            for(int i = 0; i < word.length(); i++){
                cur = cur * 10 + map.get(word.charAt(i));
            }
            sum += cur;
        }
        int res = 0;
        for(int i = 0; i < result.length(); i++){
            res = res * 10 + map.get(result.charAt(i));
        }
        return sum == res;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]= tmp;
    }
}