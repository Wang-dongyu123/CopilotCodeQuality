package main.java.Easy;

/**https://leetcode.com/problems/count-vowel-substrings-of-a-string/ */
//A substring is a contiguous (non-empty) sequence of characters within a string.
//A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.
//Given a string word, return the number of vowel substrings in word.
// 
//Example 1:
//Input: word = "aeiouu"
//Output: 2
//Explanation: The vowel substrings of word are as follows (underlined):
//- "aeiouu"
//- "aeiouu"
//Example 2:
//Input: word = "unicornarihan"
//Output: 0
//Explanation: Not all 5 vowels are present, so there are no vowel substrings.
//Example 3:
//Input: word = "cuaieuouac"
//Output: 7
//Explanation: The vowel substrings of word are as follows (underlined):
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
// 
//Constraints:
//	1 <= word.length <= 100
//	word consists of lowercase English letters only.
class Solution252 {
    public int countVowelSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'a') {
                count++;
            } else if (ch == 'e') {
                count++;
            } else if (ch == 'i') {
                count++;
            } else if (ch == 'o') {
                count++;
            } else if (ch == 'u') {
                count++;
            }
            for (int j = i + 1; j < word.length(); j++) {
                ch = word.charAt(j);
                if (ch == 'a') {
                    count++;
                } else if (ch == 'e') {
                    count++;
                } else if (ch == 'i') {
                    count++;
                } else if (ch == 'o') {
                    count++;
                } else if (ch == 'u') {
                    count++;
                }
            }
        }
        return count;
    }
}