package main.java.Hard;

/**https://leetcode.com/problems/super-palindromes/ */
//Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
//Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].


class SuperPalindromes {
    public int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int MAGIC = 100000;
        int ans = 0;

        // count odd length;
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > r)
                break;
            if (v >= l && isPalindrome(v))
                ans++;
        }

        // count even length;
        for (int k = 1; k < MAGIC; ++k) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > r)
                break;
            if (v >= l && isPalindrome(v))
                ans++;
        }

        return ans;
    }
    public boolean isPalindrome(long x) {
        return x == reverse(x);
    }
    public long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
        
    }
}
     
    