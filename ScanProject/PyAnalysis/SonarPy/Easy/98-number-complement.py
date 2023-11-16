#https://leetcode.com/problems/number-complement/
#The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
#For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
#Given an integer num, return its complement.


class Solution(object):
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """ 
        return int(''.join(['1' if x=='0' else '0' for x in bin(num)[2:]]),2)

    