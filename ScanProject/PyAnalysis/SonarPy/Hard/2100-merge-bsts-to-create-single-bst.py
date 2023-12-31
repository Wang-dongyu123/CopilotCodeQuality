#https://leetcode.com/problems/merge-bsts-to-create-single-bst/
#You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array trees (0-indexed). Each BST in trees has at most 3 nodes, and no two roots have the same value. In one operation, you can:
#Select two distinct indices i and j such that the value stored at one of the leaves of trees[i] is equal to the root value of trees[j].
#Replace the leaf node in trees[i] with trees[j].
#Remove trees[j] from trees.
#Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1 operations, or null if it is impossible to create a valid BST.
#A BST (binary search tree) is a binary tree where each node satisfies the following property:
#Every node in the node's left subtree has a value strictly less than the node's value.
#Every node in the node's right subtree has a value strictly greater than the node's value.
#A leaf is a node that has no children.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def canMerge(self, trees):
        """
        :type trees: List[TreeNode]
        :rtype: TreeNode
        """ 
        
        n = len(trees)
        if n == 1:
            return trees[0]
        root = None
        roots = {}
        for tree in trees:
            roots[tree.val] = tree
        for tree in trees:
            if tree.left and tree.left.val in roots:
                if tree.right and tree.right.val in roots:
                    return None
                else:
                    roots[tree.val].left = roots[tree.left.val]
            elif tree.right and tree.right.val in roots:
                roots[tree.val].left = roots[tree.right.val]
            else:
                root = tree
        
    