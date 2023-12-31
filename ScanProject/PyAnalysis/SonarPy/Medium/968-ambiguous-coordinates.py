#https://leetcode.com/problems/ambiguous-coordinates/
#We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we removed all commas, decimal points, and spaces and ended up with the string s.
#For example, "(1, 3)" becomes s = "(13)" and "(2, 0.5)" becomes s = "(205)".
#Return a list of strings representing all possibilities for what our original coordinates could have been.
#Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with fewer digits. Also, a decimal point within a number never occurs without at least one digit occurring before it, so we never started with numbers like ".1".
#The final answer list can be returned in any order. All coordinates in the final answer have exactly one space between them (occurring after the comma.)


class Solution(object):
    def ambiguousCoordinates(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def isValid(s):
            if len(s) == 1:
                return True
            if s[0] == '0' and s[-1] == '0':
                return False
            if s[0] == '0':
                return True
            if s[-1] == '0':
                return False
            return True
        def getValid(s):
            res = []
            if isValid(s):
                res.append(s)
            for i in range(1, len(s)):
                left = s[:i]
                right = s[i:]
                if isValid(left) and isValid(right):
                    res.append(left + '.' + right)
            return res
        s = s[1:-1]
        res = []
        for i in range(2, len(s) - 1):
            left = self.getValid(s[1:i])
            right = self.getValid(s[i:-1])
            for l in left:
                for r in right:
                    res.append("(" + l + ", " + r + ")")
        return res
        

    