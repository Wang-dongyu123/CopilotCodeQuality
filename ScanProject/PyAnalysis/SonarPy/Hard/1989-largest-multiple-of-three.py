#https://leetcode.com/problems/largest-multiple-of-three/
#Given an array of digits digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order. If there is no answer return an empty string.
#Since the answer may not fit in an integer data type, return the answer as a string. Note that the returning answer must not contain unnecessary leading zeros.


class Solution(object):
    def largestMultipleOfThree(self, digits):
        """
        :type digits: List[int]
        :rtype: str
        """   
        """
        :type digits: List[int]
        :rtype: str
        """        
        #Approach: Greedy
        #Intuition: We will keep adding the maximum element in the array until all elements are 1.
        #           If the maximum element is 1, then we have reached the target.
        #           If the maximum element is > 1, then we will have to subtract the sum of all other elements from it.
        #           If the sum of all other elements is 0, then we have reached the target.
        #           If the sum of all other elements is > 0, then we will have to subtract the sum of all other elements from it.
        #           If the sum of all other elements is < 0, then we can never reach the target.
        #Time Complexity: O(n log n)
        #Space Complexity: O(n)
        #where, n is the length of target array
        
        digits.sort()
        digits.reverse()
        
        sum = 0
        for num in digits:
            sum += num
        
        if sum % 3 == 0:
            return ''.join(map(str, digits))
        
        if sum % 3 == 1:
            for i in range(len(digits)):
                if digits[i] % 3 == 1:
                    digits.pop(i)
                    break
            else:
                count = 0
                for i in range(len(digits)):
                    if digits[i] % 3 == 2:
                        digits.pop(i)
                        count += 1
                        if count == 2:
                            break
                else:
                    return ''
        
        if sum % 3 == 2:
            for i in range(len(digits)):
                if digits[i] % 3 == 2:
                    digits.pop(i)
                    break
            else:
                count = 0
                for i in range(len(digits)):
                    if digits[i] % 3 == 1:
                        digits.pop(i)
                        count += 1
                        if count == 2:
                            break
                else:
                    return ''
        
        return ''.join(map(str, digits))
        

        
        
        
    