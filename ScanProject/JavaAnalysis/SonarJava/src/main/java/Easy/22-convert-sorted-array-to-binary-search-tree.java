package main.java.Easy; /**https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/ */
//Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

class TreeNode27 {
      int val;
     TreeNode27 left;
      TreeNode27 right;
      TreeNode27() {}
      TreeNode27(int val) { this.val = val; }
      TreeNode27(int val, TreeNode27 left, TreeNode27 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class ConvertSortedArrayToBinarySearchTree {
    public TreeNode27 sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
        

    }
    private TreeNode27 helper(int[] nums, int low, int high){
        if(low > high){
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode27 node = new TreeNode27(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}

    