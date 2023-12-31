package main.java.Easy;

/**https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/ */
//You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:
//	Characters ('a' to 'i') are represented by ('1' to '9') respectively.
//	Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
//Return the string formed after mapping.
//The test cases are generated so that a unique mapping will always exist.
// 
//Example 1:
//Input: s = "10#11#12"
//Output: "jkab"
//Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//Example 2:
//Input: s = "1326#"
//Output: "acz"
// 
//Constraints:
//	1 <= s.length <= 1000
//	s consists of digits and the '#' letter.
//	s will be a valid string such that mapping is always possible.
class Solution104 {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(i + 2 < len && s.charAt(i + 2) == '#'){
                res.append((char)(Integer.parseInt(s.substring(i, i + 2)) + 'a' - 1));
                i += 2;
            }else{
                res.append((char)(s.charAt(i) - '1' + 'a'));
            }
        }
        return res.toString();
    }
}