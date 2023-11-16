package main.java.Hard;

/**https://leetcode.com/problems/lexicographically-smallest-beautiful-string/ */
//A string is beautiful if:
//	It consists of the first k letters of the English lowercase alphabet.
//	It does not contain any substring of length 2 or more which is a palindrome.
//You are given a beautiful string s of length n and a positive integer k.
//Return the lexicographically smallest string of length n, which is larger than s and is beautiful. If there is no such string, return an empty string.
//A string a is lexicographically larger than a string b (of the same length) if in the first position where a and b differ, a has a character strictly larger than the corresponding character in b.
//	For example, "abcd" is lexicographically larger than "abcc" because the first position they differ is at the fourth character, and d is greater than c.
// 
//Example 1:
//Input: s = "abcz", k = 26
//Output: "abda"
//Explanation: The string "abda" is beautiful and lexicographically larger than the string "abcz".
//It can be proven that there is no string that is lexicographically larger than the string "abcz", beautiful, and lexicographically smaller than the string "abda".
//Example 2:
//Input: s = "dc", k = 4
//Output: ""
//Explanation: It can be proven that there is no string that is lexicographically larger than the string "dc" and is beautiful.
// 
//Constraints:
//	1 <= n == s.length <= 105
//	4 <= k <= 26
//	s is a beautiful string.
class Solution131 {
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        char[] ans = new char[n];
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        int idx = 0;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                ans[idx++] = (char)('a' + i);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (idx == k) {
                break;
            }
            for (int j = 0; j < 26; ++j) {
                if (cnt[j] == 0) {
                    continue;
                }
                --cnt[j];
                if (isValid(cnt)) {
                    ans[idx++] = (char)('a' + j);
                    break;
                }
                ++cnt[j];
            }
        }
        if (idx < k) {
            return "";
        }
        return new String(ans);
    }
    private boolean isValid(int[] cnt) {
        int sum = 0;
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                ++sum;
            } else {
                sum = 0;
            }
            if (sum >= 2) {
                return false;
            }
        }
        return true;
    }
}