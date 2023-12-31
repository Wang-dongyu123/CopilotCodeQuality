#https://leetcode.com/problems/maximize-number-of-nice-divisors/
#You are given a positive integer primeFactors. You are asked to construct a positive integer n that satisfies the following conditions:
#The number of prime factors of n (not necessarily distinct) is at most primeFactors.
#The number of nice divisors of n is maximized. Note that a divisor of n is nice if it is divisible by every prime factor of n. For example, if n = 12, then its prime factors are [2,2,3], then 6 and 12 are nice divisors, while 3 and 4 are not.
#Return the number of nice divisors of n. Since that number can be too large, return it modulo 109 + 7.
#Note that a prime number is a natural number greater than 1 that is not a product of two smaller natural numbers. The prime factors of a number n is a list of prime numbers such that their product equals n.


class Solution(object):
    def maxNiceDivisors(self, primeFactors):
        """
        :type primeFactors: int
        :rtype: int
        """       
        if primeFactors == 1:
            return 1
        if primeFactors == 2:
            return 2
        if primeFactors%3 == 0:
            return pow(3, primeFactors//3, 10**9+7)
        if primeFactors%3 == 1:
            return pow(3, primeFactors//3-1, 10**9+7) * 4 % (10**9+7)
        return pow(3, primeFactors//3, 10**9+7) * 2 % (10**9+7)

        
        
    