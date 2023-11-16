package main.java.Hard;

/**https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/ */
//Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3 * ... * x and by convention, 0! = 1.
//For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has two zeroes at the end.
//Given an integer k, return the number of non-negative integers x have the property that f(x) = k.


class PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int k) {
        long lo = 0;
        long hi = 5L * (k + 1);
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            if (trailingZeroes(mi) < k) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return trailingZeroes(lo) == k ? 5 : 0;
        
    }
    public long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }
        return res;
    }

}
     
    