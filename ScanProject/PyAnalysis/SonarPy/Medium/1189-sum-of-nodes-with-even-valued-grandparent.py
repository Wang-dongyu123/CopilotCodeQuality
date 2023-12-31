#https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
#Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
#A grandparent of a node is the parent of its parent if it exists.
# 
#Example 1:
#Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
#Output: 18
#Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
#Example 2:
#Input: root = [1]
#Output: 0
# 
#Constraints:
#	The number of nodes in the tree is in the range [1, 104].
#	1 <= Node.val <= 100
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumEvenGrandparent(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # Approach 1: DFS
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # Runtime: 88 ms, faster than 99.23% of Python online submissions for Sum of Nodes with Even-Valued Grandparent.
        # Memory Usage: 20.5 MB, less than 99.23% of Python online submissions for Sum of Nodes with Even-Valued Grandparent.
        def dfs(node, parent, grandparent):
            if not node:
                return 0
            return dfs(node.left, node.val, parent) + dfs(node.right, node.val, parent) + (node.val if grandparent % 2 == 0 else 0)
        return dfs(root, 1, 1)