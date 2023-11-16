#https://leetcode.com/problems/path-sum-iii/
#Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
#The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: int
        """
        def dfs(root, targetSum, path):
            if not root:
                return 0
            res = 0
            path.append(root.val)
            tmp = 0
            for i in range(len(path) - 1, -1, -1):
                tmp += path[i]
                if tmp == targetSum:
                    res += 1
            res += dfs(root.left, targetSum, path)
            res += dfs(root.right, targetSum, path)
            path.pop()
            return res
        return dfs(root, targetSum, [])
    