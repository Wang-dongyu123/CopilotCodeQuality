package main.java.Hard;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/longest-duplicate-substring/ */
//Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.
//Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".
// 
//Example 1:
//Input: s = "banana"
//Output: "ana"
//Example 2:
//Input: s = "abcd"
//Output: ""
// 
//Constraints:
//	2 <= s.length <= 3 * 104
//	s consists of lowercase English letters.
class Solution37 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = s.charAt(i) - 'a';
        }
        int base = 26;
        long mod = (long) Math.pow(2, 32);
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(search(mid, base, mod, n, nums) != -1){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int start = search(left - 1, base, mod, n, nums);
        return start == -1 ? "" : s.substring(start, start + left - 1);
    }
    private int search(int mid, int base, long mod, int n, int[] nums){
        long hash = 0;
        for(int i = 0; i < mid; i++){
            hash = (hash * base + nums[i]) % mod;
        }
        Set<Long> set = new HashSet<>();
        set.add(hash);
        long mult = 1;
        for(int i = 0; i < mid; i++){
            mult = (mult * base) % mod;
        }
        for(int i = 1; i < n - mid + 1; i++){
            hash = (hash * base - nums[i - 1] * mult % mod + mod) % mod;
            hash = (hash + nums[i + mid - 1]) % mod;
            if(set.contains(hash)){
                return i;
            }
            set.add(hash);
        }
        return -1;
    }
}