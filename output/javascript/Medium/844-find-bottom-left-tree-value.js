/**https://leetcode.com/problems/find-bottom-left-tree-value/ */
//Given the root of a binary tree, return the leftmost value in the last row of the tree.
// 
//Example 1:
//Input: root = [2,1,3]
//Output: 1
//Example 2:
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
// 
//Constraints:
//	The number of nodes in the tree is in the range [1, 104].
//	-231 <= Node.val <= 231 - 1
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var findBottomLeftValue = function(root) {
    let queue = [root];
    let result = root.val;
    while (queue.length) {
        let size = queue.length;
        result = queue[0].val;
        for (let i = 0; i < size; i++) {
            let node = queue.shift();
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
    }
    return result;
};