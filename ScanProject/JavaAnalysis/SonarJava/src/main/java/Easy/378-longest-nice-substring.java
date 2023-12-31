package main.java.Easy;

/**https://leetcode.com/problems/longest-nice-substring/ */
//A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
//Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
// 
//Example 1:
//Input: s = "YazaAay"
//Output: "aAa"
//Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
//"aAa" is the longest nice substring.
//Example 2:
//Input: s = "Bb"
//Output: "Bb"
//Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
//Example 3:
//Input: s = "c"
//Output: ""
//Explanation: There are no nice substrings.
// 
//Constraints:
//	1 <= s.length <= 100
//	s consists of uppercase and lowercase English letters.
class Solution193 {
    public String longestNiceSubstring(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                String str = s.substring(i, j);
                if(isNice(str) && str.length() > res.length()){
                    res = str;
                }
            }
        }
        return res;
    }
    public boolean isNice(String s){
        for(int i = 0; i < s.length(); i++){
            if(!s.contains(String.valueOf(s.charAt(i)).toUpperCase()) || !s.contains(String.valueOf(s.charAt(i)).toLowerCase())){
                return false;
            }
        }
        return true;
    }
}