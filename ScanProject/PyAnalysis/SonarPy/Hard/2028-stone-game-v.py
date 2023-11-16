#https://leetcode.com/problems/stone-game-v/
#There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.
#In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.
#The game ends when there is only one stone remaining. Alice's is initially zero.
#Return the maximum score that Alice can obtain.


class Solution(object):
    def stoneGameV(self, stoneValue):
        """
        :type stoneValue: List[int]
        :rtype: int
        """ 
        n = len(stoneValue)
        prefixSum = [0] * (n+1)
        for i in range(1, n+1):
            prefixSum[i] = prefixSum[i-1] + stoneValue[i-1]
        @lru_cache(None)
        def dp(i, j):
            if i == j:
                return 0
            ans = 0
            for k in range(i, j):
                sum1 = prefixSum[k] - prefixSum[i-1]
                sum2 = prefixSum[j] - prefixSum[k]
                if sum1 < sum2:
                    ans = max(ans, sum1 + dp(i, k))
                elif sum1 > sum2:
                    ans = max(ans, sum2 + dp(k+1, j))
                else:
                    ans = max(ans, sum1 + max(dp(i, k), dp(k+1, j)))
            return ans
        return dp(1, n)
        
        
    