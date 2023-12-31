package main.java.Hard;

/**https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/ */
//You are given a 0-indexed string s and are tasked with finding two non-intersecting palindromic substrings of odd length such that the product of their lengths is maximized.
//More formally, you want to choose four integers i, j, k, l such that 0 <= i <= j < k <= l < s.length and both the substrings s[i...j] and s[k...l] are palindromes and have odd lengths. s[i...j] denotes a substring from index i to index j inclusive.
//Return the maximum possible product of the lengths of the two non-intersecting palindromic substrings.
//A palindrome is a string that is the same forward and backward. A substring is a contiguous sequence of characters in a string.


class MaximumProductOfTheLengthOfTwoPalindromicSubstrings {
    public long maxProduct(String s) {
        int n = s.length();
        int[] dp = new int[1 << n];
        for(int i = 0; i < (1 << n); i++){
            int l = 0;
            int r = n - 1;
            while(l < r){
                if(((i >> l) & 1) == 0){
                    l++;
                }else if(((i >> r) & 1) == 0){
                    r--;
                }else{
                    if(s.charAt(l) != s.charAt(r)){
                        break;
                    }
                    l++;
                    r--;
                }
            }
            if(l >= r){
                dp[i] = Integer.bitCount(i);
            }
        }
        long res = 0;
        for(int i = 0; i < (1 << n); i++){
            for(int j = i; j > 0; j = (j - 1) & i){
                res = Math.max(res, (long)dp[i] * dp[j]);
            }
        }
        return res;
        
    }
}
     
    