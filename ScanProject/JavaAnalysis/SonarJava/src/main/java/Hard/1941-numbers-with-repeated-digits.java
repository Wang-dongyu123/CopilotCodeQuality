package main.java.Hard;

/**https://leetcode.com/problems/numbers-with-repeated-digits/ */
//Given an integer n, return the number of positive integers in the range [1, n] that have at least one repeated digit.


class NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (hasRepeatedDigits(i)) {
                count++;
            }
        }
        return count;
        

    }
    public boolean hasRepeatedDigits(int n){
        boolean[] seen = new boolean[10];
        while(n > 0){
            int digit = n % 10;
            if(seen[digit]){
                return true;
            }
            seen[digit] = true;
            n /= 10;
        }
        return false;
    }
}
     
    