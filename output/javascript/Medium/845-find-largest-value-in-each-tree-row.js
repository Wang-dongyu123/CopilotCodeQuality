/**https://leetcode.com/problems/find-largest-value-in-each-tree-row/ */
//Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
// 
//Example 1:
//Input: root = [1,3,2,5,3,null,9]
//Output: [1,3,9]
//Example 2:
//Input: root = [1,2,3]
//Output: [1,3]
// 
//Constraints:
//	The number of nodes in the tree will be in the range [0, 104].
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
 * @return {number[]}
 */
var largestValues = function(root) {
    let result = [];
	let queue = [root];
	while (queue.length) {
		let size = queue.length;
		let max = -Infinity;
		for (let i = 0; i < size; i++) {
			let node = queue.shift();
			max = Math.max(max, node.val);
			if (node.left) queue.push(node.left);
			if (node.right) queue.push(node.right);
		}
		result.push(max);
	}
	return result;
};