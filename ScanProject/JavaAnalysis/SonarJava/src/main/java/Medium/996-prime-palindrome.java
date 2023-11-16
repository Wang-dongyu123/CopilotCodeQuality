package main.java.Medium;

/**https://leetcode.com/problems/prime-palindrome/ */
//Given an integer n, return the smallest prime palindrome greater than or equal to n.
//An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.
//For example, 2, 3, 5, 7, 11, and 13 are all primes.
//An integer is a palindrome if it reads the same from left to right as it does from right to left.
//For example, 101 and 12321 are palindromes.
//The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].


class PrimePalindrome {
    public int primePalindrome(int n) {
        while(true){
            if(isPalindrome(n) && isPrime(n)){
                return n;
            }
            n++;
            if(10000000 < n && n < 100000000){
                n = 100000000;
            }
        }
    }
    public boolean isPalindrome(int n){
        int res = 0;
        int temp = n;
        while(temp > 0){
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return res == n;
    }
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}

    