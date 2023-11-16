package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/letter-case-permutation/ */
//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//Return a list of all possible strings we could create. Return the output in any order.
// 
//Example 1:
//Input: s = "a1b2"
//Output: ["a1b2","a1B2","A1b2","A1B2"]
//Example 2:
//Input: s = "3z4"
//Output: ["3z4","3Z4"]
// 
//Constraints:
//	1 <= s.length <= 12
//	s consists of lowercase English letters, uppercase English letters, and digits.
class Solution568 {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList();
        dfs(s.toCharArray(), 0, result);
        return result;
    }

    private void dfs(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        if (Character.isDigit(chars[index])) {
            dfs(chars, index + 1, result);
            return;
        }
        chars[index] = Character.toLowerCase(chars[index]);
        dfs(chars, index + 1, result);
        chars[index] = Character.toUpperCase(chars[index]);
        dfs(chars, index + 1, result);
    }
}