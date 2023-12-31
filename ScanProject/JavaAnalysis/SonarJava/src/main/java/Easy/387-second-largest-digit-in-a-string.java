package main.java.Easy;

/**https://leetcode.com/problems/second-largest-digit-in-a-string/ */
//Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
//An alphanumeric string is a string consisting of lowercase English letters and digits.
// 
//Example 1:
//Input: s = "dfa12321afd"
//Output: 2
//Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
//Example 2:
//Input: s = "abc1111"
//Output: -1
//Explanation: The digits that appear in s are [1]. There is no second largest digit. 
// 
//Constraints:
//	1 <= s.length <= 500
//	s consists of only lowercase English letters and/or digits.
class Solution199 {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int number = Character.getNumericValue(s.charAt(i));
                if(number > first){
                    second = first;
                    first = number;
                }else if(number < first && number > second){
                    second = number;
                }
            }
        }
        return second;
    }
}