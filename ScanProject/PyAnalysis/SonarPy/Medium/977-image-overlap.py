#https://leetcode.com/problems/image-overlap/
#You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
#We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
#Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
#Return the largest possible overlap.


class Solution(object):
    def largestOverlap(self, img1, img2):
        """
        :type img1: List[List[int]]
        :type img2: List[List[int]]
        :rtype: int
        """
        res = 0
        for i in range(len(img1)):
            for j in range(len(img1)):
                if img1[i][j] == 1:
                    res = max(res, self.count(img1, img2, i, j))
        return res
    def count(img1, img2, x, y):
            res = 0
            for i in range(len(img1)):
                for j in range(len(img1)):
                    if img1[i][j] == 1 and img2[i+x][j+y] == 1:
                        res += 1
            return res
        

    