package main.java.Hard;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/stamping-the-sequence/ */
//You are given two strings stamp and target. Initially, there is a string s of length target.length with all s[i] == '?'.
//In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.
//	For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:
//	
//		place stamp at index 0 of s to obtain "abc??",
//		place stamp at index 1 of s to obtain "?abc?", or
//		place stamp at index 2 of s to obtain "??abc".
//	
//	Note that stamp must be fully contained in the boundaries of s in order to stamp (i.e., you cannot place stamp at index 3 of s).
//We want to convert s to target using at most 10 * target.length turns.
//Return an array of the index of the left-most letter being stamped at each turn. If we cannot obtain target from s within 10 * target.length turns, return an empty array.
// 
//Example 1:
//Input: stamp = "abc", target = "ababc"
//Output: [0,2]
//Explanation: Initially s = "?????".
//- Place stamp at index 0 to get "abc??".
//- Place stamp at index 2 to get "ababc".
//[1,0,2] would also be accepted as an answer, as well as some other answers.
//Example 2:
//Input: stamp = "abca", target = "aabcaca"
//Output: [3,0,1]
//Explanation: Initially s = "???????".
//- Place stamp at index 3 to get "???abca".
//- Place stamp at index 0 to get "abcabca".
//- Place stamp at index 1 to get "aabcaca".
// 
//Constraints:
//	1 <= stamp.length <= target.length <= 1000
//	stamp and target consist of lowercase English letters.
class Solution32 {
    public int[] movesToStamp(String stamp, String target) {
        int m = stamp.length();
        int n = target.length();
        char[] sc = stamp.toCharArray();
        char[] tc = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        while(count < n){
            boolean found = false;
            for(int i = 0; i <= n - m; i++){
                if(!visited[i] && canReplace(tc, i, sc)){
                    count = replace(tc, i, m, count);
                    res.add(i);
                    visited[i] = true;
                    found = true;
                    if(count == n){
                        break;
                    }
                }
            }
            if(!found){
                return new int[0];
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(res.size() - 1 - i);
        }
        return ans;
    }
    private boolean canReplace(char[] tc, int i, char[] sc){
        for(int j = 0; j < sc.length; j++){
            if(tc[i + j] != '*' && tc[i + j] != sc[j]){
                return false;
            }
        }
        return true;
    }
    private int replace(char[] tc, int i, int m, int count){
        for(int j = 0; j < m; j++){
            if(tc[i + j] != '*'){
                tc[i + j] = '*';
                count++;
            }
        }
        return count;
    }
}