#https://leetcode.com/problems/unique-binary-search-trees-ii/
#Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        def clone(node, offset):
            if not node:
                return None
            root = TreeNode(node.val + offset)
            root.left = clone(node.left, offset)
            root.right = clone(node.right, offset)
            return root
        def helper(start, end):
            if start > end:
                return [None]
            if start == end:
                return [TreeNode(start)]
            res = []
            for i in range(start, end + 1):
                left = helper(start, i - 1)
                right = helper(i + 1, end)
                for l in left:
                    for r in right:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        res.append(root)
            return res
    