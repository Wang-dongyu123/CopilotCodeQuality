package main.java.Hard;

import java.util.*;

/**https://leetcode.com/problems/palindrome-pairs/ */
//You are given a 0-indexed array of unique strings words.
//A palindrome pair is a pair of integers (i, j) such that:
//	0 <= i, j < words.length,
//	i != j, and
//	words[i] + words[j] (the concatenation of the two strings) is a palindrome.
//Return an array of all the palindrome pairs of words.
//You must write an algorithm with O(sum of words[i].length) runtime complexity.
// 
//Example 1:
//Input: words = ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]]
//Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
//Example 2:
//Input: words = ["bat","tab","cat"]
//Output: [[0,1],[1,0]]
//Explanation: The palindromes are ["battab","tabbat"]
//Example 3:
//Input: words = ["a",""]
//Output: [[0,1],[1,0]]
//Explanation: The palindromes are ["a","a"]
// 
//Constraints:
//	1 <= words.length <= 5000
//	0 <= words[i].length <= 300
//	words[i] consists of lowercase English letters.
class Solution8 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int n = word.length();
            for(int j = 0; j <= n; j++){
                String left = word.substring(0, j);
                String right = word.substring(j);
                if(isPalindrome(left)){
                    String revRight = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(revRight) && map.get(revRight) != i){
                        res.add(Arrays.asList(map.get(revRight), i));
                    }
                }
                if(isPalindrome(right)){
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(revLeft) && map.get(revLeft) != i && right.length() != 0){
                        res.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

}