#https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
#Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
#A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxAncestorDiff(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(root, min_val, max_val):
            if not root:
                return
            self.res = max(self.res, abs(root.val - min_val), abs(root.val - max_val))
            min_val = min(min_val, root.val)
            max_val = max(max_val, root.val)
            dfs(root.left, min_val, max_val)
            dfs(root.right, min_val, max_val)
        self.res = 0
        self.dfs(root, root.val, root.val)
        return self.res
        

    