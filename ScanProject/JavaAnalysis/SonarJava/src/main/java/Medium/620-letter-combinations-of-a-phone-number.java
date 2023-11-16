package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, 0, "", res, map);
        return res;
        
        
    }
    private void dfs(String digits, int index, String curr, List<String> res, String[] map){
        if(index == digits.length()){
            res.add(curr);
            return;
        }
        String letters = map[digits.charAt(index) - '2'];
        for(int i = 0; i < letters.length(); i++){
            dfs(digits, index + 1, curr + letters.charAt(i), res, map);
        }
    }
}

    