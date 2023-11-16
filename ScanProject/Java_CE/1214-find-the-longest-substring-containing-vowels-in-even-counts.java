package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/ */
//Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.


class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, mask = 0;
        int[] dp = new int[32];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        String vowels = "aeiou";
        for (int i = 0; i < n; ++i) {
            int idx = vowels.indexOf(s.charAt(i));
            if (idx != -1) {
                mask ^= 1 << idx;
            }
            if (dp[mask] == -1) {
                dp[mask] = i + 1;
            }
            ans = Math.max(ans, i + 1 - dp[mask]);
        }
        return ans;
    }
}

    