#https://leetcode.com/problems/prime-palindrome/
#Given an integer n, return the smallest prime palindrome greater than or equal to n.
#An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.
#For example, 2, 3, 5, 7, 11, and 13 are all primes.
#An integer is a palindrome if it reads the same from left to right as it does from right to left.
#For example, 101 and 12321 are palindromes.
#The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].


class Solution(object):
    def primePalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        def is_prime(n):
            if n < 2:
                return False
            for i in range(2, int(n**0.5)+1):
                if n % i == 0:
                    return False
            return True
        
        def is_palindrome(n):
            s = str(n)
            return s == s[::-1]
        
        if 8 <= n <= 11:
            return 11
        for i in range(10**(len(str(n))//2), 10**5):
            s = str(i)
            x = int(s + s[-2::-1])
            if x >= n and is_prime(x):
                return x
        return -1

    