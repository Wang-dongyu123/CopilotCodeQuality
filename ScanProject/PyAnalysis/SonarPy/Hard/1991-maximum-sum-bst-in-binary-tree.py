#https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
#Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
#Assume a BST is defined as follows:
#The left subtree of a node contains only nodes with keys less than the node's key.
#The right subtree of a node contains only nodes with keys greater than the node's key.
#Both the left and right subtrees must also be binary search trees.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxSumBST(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """   
        #Approach: Recursion; DFS
        #Time Complexity: O(n)
        #Space Complexity: O(h) // under the hood
        #where, n is the no. of nodes in the tree
        #and, h is the height of the tree
        
        self.result = 0
        
        def dfs(node):
            if not node:
                return True, float('inf'), float('-inf'), 0
            
            isLeftBST, leftMin, leftMax, leftSum = dfs(node.left)
            isRightBST, rightMin, rightMax, rightSum = dfs(node.right)
            
            isBST = isLeftBST and isRightBST and leftMax < node.val < rightMin
            curSum = leftSum + node.val + rightSum
            
            if isBST:
                self.result = max(self.result, curSum)
                
            return isBST, min(node.val, leftMin), max(node.val, rightMax), curSum
        
        dfs(root)
        return self.result
    

        
        
        
    