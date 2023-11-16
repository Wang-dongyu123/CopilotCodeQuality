/**https://leetcode.com/problems/remove-letter-to-equalize-frequency/ */
//You are given a 0-indexed string word, consisting of lowercase English letters. You need to select one index and remove the letter at that index from word so that the frequency of every letter present in word is equal.
//Return true if it is possible to remove one letter so that the frequency of all letters in word are equal, and false otherwise.
//Note:
//	The frequency of a letter x is the number of times it occurs in the string.
//	You must remove exactly one letter and cannot chose to do nothing.
// 
//Example 1:
//Input: word = "abcc"
//Output: true
//Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
//Example 2:
//Input: word = "aazz"
//Output: false
//Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
// 
//Constraints:
//	2 <= word.length <= 100
//	word consists of lowercase English letters only.
class Solution {
    public boolean equalFrequency(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int i = 0;
        while (i < 26 && count[i] == 0) {
            i++;
        }
        int min = count[i];
        int max = count[25];
        if (min == max) {
            return true;
        } else if (max - min == 1) {
            return max > count[24];
        } else {
            return min == count[i + 1];
        }
    }
}