#https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
#A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:_x000D_
#_x000D_
#_x000D_
#	It is the empty string, or_x000D_
#	It can be written as AB (A concatenated with B), where A and B are VPS's, or_x000D_
#	It can be written as (A), where A is a VPS._x000D_
#_x000D_
#_x000D_
#We can similarly define the nesting depth depth(S) of any VPS S as follows:_x000D_
#_x000D_
#_x000D_
#	depth("") = 0_x000D_
#	depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's_x000D_
#	depth("(" + A + ")") = 1 + depth(A), where A is a VPS._x000D_
#_x000D_
#_x000D_
#For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's._x000D_
#_x000D_
# _x000D_
#_x000D_
#Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length)._x000D_
#_x000D_
#Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value._x000D_
#_x000D_
#Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them._x000D_
# 
#Example 1:
#Input: seq = "(()())"
#Output: [0,1,1,1,1,0]
#Example 2:
#Input: seq = "()(())()"
#Output: [0,0,0,1,1,0,1,1]
# 
#Constraints:
#	1 <= seq.size <= 10000
class Solution(object):
    def maxDepthAfterSplit(self, seq):
        """
        :type seq: str
        :rtype: List[int]
        """
        # Approach 1: Greedy
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # Runtime: 32 ms, faster than 99.17% of Python3 online submissions for Maximum Nesting Depth of Two Valid Parentheses Strings.
        # Memory Usage: 14.2 MB, less than 7.48% of Python3 online submissions for Maximum Nesting Depth of Two Valid Parentheses Strings.
        ans = []
        for i in range(len(seq)):
            ans.append(i & 1 if seq[i] == '(' else 1 - (i & 1))
        return ans