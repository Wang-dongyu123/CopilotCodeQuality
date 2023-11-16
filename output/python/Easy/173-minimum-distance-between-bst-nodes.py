#https://leetcode.com/problems/minimum-distance-between-bst-nodes/
#Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
# 
#Example 1:
#Input: root = [4,2,6,1,3]
#Output: 1
#Example 2:
#Input: root = [1,0,48,null,null,12,49]
#Output: 1
# 
#Constraints:
#	The number of nodes in the tree is in the range [2, 100].
#	0 <= Node.val <= 105
# 
#Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def minDiffInBST(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def inorder(root):
            if not root:
                return []
            return inorder(root.left) + [root.val] + inorder(root.right)
        nums = inorder(root)
        return min([nums[i+1] - nums[i] for i in range(len(nums)-1)])
