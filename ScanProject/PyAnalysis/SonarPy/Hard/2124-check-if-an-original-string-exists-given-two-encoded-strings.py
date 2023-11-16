#https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/
#An original string, consisting of lowercase English letters, can be encoded by the following steps:
#Arbitrarily split it into a sequence of some number of non-empty substrings.
#Arbitrarily choose some elements (possibly none) of the sequence, and replace each with its length (as a numeric string).
#Concatenate the sequence as the encoded string.
#For example, one way to encode an original string "abcdefghijklmnop" might be:
#Split it as a sequence: ["ab", "cdefghijklmn", "o", "p"].
#Choose the second and third elements to be replaced by their lengths, respectively. The sequence becomes ["ab", "12", "1", "p"].
#Concatenate the elements of the sequence to get the encoded string: "ab121p".
#Given two encoded strings s1 and s2, consisting of lowercase English letters and digits 1-9 (inclusive), return true if there exists an original string that could be encoded as both s1 and s2. Otherwise, return false.
#Note: The test cases are generated such that the number of consecutive digits in s1 and s2 does not exceed 3.


class Solution(object):
    def possiblyEquals(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        def decode(s):
            n = len(s)
            ans = []
            i = 0
            while i < n:
                if s[i].isdigit():
                    j = i
                    while j < n and s[j].isdigit():
                        j += 1
                    ans.append(s[i:j])
                    i = j
                else:
                    ans.append(s[i])
                    i += 1
            return ans
        
        return decode(s1) == decode(s2)
        
        
    