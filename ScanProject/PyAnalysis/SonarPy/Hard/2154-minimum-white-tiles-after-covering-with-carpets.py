#https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/
#You are given a 0-indexed binary string floor, which represents the colors of tiles on a floor:
#floor[i] = '0' denotes that the ith tile of the floor is colored black.
#On the other hand, floor[i] = '1' denotes that the ith tile of the floor is colored white.
#You are also given numCarpets and carpetLen. You have numCarpets black carpets, each of length carpetLen tiles. Cover the tiles with the given carpets such that the number of white tiles still visible is minimum. Carpets may overlap one another.
#Return the minimum number of white tiles still visible.


class Solution(object):
    def minimumWhiteTiles(self, floor, numCarpets, carpetLen):
        """
        :type floor: str
        :type numCarpets: int
        :type carpetLen: int
        :rtype: int
        """       
        n = len(floor)
        presum = [0]
        for x in floor:
            presum.append(presum[-1] + int(x))
        res = n
        for i in range(n + 1):
            res = min(res, presum[i] + (n - i - (presum[-1] - presum[i])))
        return res
        
        
    