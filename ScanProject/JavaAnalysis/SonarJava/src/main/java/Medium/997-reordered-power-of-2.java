package main.java.Medium;

/**https://leetcode.com/problems/reordered-power-of-2/ */
//You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
//Return true if and only if we can do this so that the resulting number is a power of two.
// 
//Example 1:
//Input: n = 1
//Output: true
//Example 2:
//Input: n = 10
//Output: false
// 
//Constraints:
//	1 <= n <= 109
class Solution574 {
    public boolean reorderedPowerOf2(int n) {
        int[] digits = new int[10];
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
        }
        return dfs(digits, 0);
    }

    private boolean dfs(int[] digits, int index) {
        if (index == 10) {
            return isPowerOf2(digits);
        }
        if (digits[index] == 0) {
            return dfs(digits, index + 1);
        }
        for (int i = index; i < 10; i++) {
            if (digits[i] == 0) {
                continue;
            }
            digits[i]--;
            if (dfs(digits, index + 1)) {
                return true;
            }
            digits[i]++;
        }
        return false;
    }

    private boolean isPowerOf2(int[] digits) {
        int n = 0;
        for (int i = 0; i < 10; i++) {
            n += digits[i] * (int)Math.pow(10, i);
        }
        return n != 0 && (n & (n - 1)) == 0;
    }
}