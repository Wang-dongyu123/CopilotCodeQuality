package main.java.Medium;

/**https://leetcode.com/problems/split-two-strings-to-make-palindrome/ */
//You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
//When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
//Return true if it is possible to form a palindrome string, otherwise return false.
//Notice that x + y denotes the concatenation of strings x and y.
// 
//Example 1:
//Input: a = "x", b = "y"
//Output: true
//Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
//aprefix = "", asuffix = "x"
//bprefix = "", bsuffix = "y"
//Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
//Example 2:
//Input: a = "xbdef", b = "xecab"
//Output: false
//Example 3:
//Input: a = "ulacfd", b = "jizalu"
//Output: true
//Explaination: Split them at index 3:
//aprefix = "ula", asuffix = "cfd"
//bprefix = "jiz", bsuffix = "alu"
//Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
// 
//Constraints:
//	1 <= a.length, b.length <= 105
//	a.length == b.length
//	a and b consist of lowercase English letters
class Solution136 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        int len = a.length();
        for (int i = 0; i < len / 2; i++) {
            if (a.charAt(i) != b.charAt(len - 1 - i)) {
                return isPalindrome(a, i, len - 1 - i) || isPalindrome(b, i, len - 1 - i);
            }
        }
        return true;
    }
    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start; i <= start + (end - start) / 2; i++) {
            if (s.charAt(i) != s.charAt(end - i + start)) {
                return false;
            }
        }
        return true;
    }
}