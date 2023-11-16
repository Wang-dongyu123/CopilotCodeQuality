package main.java.Medium; /**https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/ */
//You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.
//Return the number of good leaf node pairs in the tree.

class TreeNode75 {
      int val;
      TreeNode75 left;
      TreeNode75 right;
      TreeNode75() {}
      TreeNode75(int val) { this.val = val; }
      TreeNode75(int val, TreeNode75 left, TreeNode75 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class NumberOfGoodLeafNodesPairs {
    public int countPairs(TreeNode75 root, int distance) {
        int[] count = new int[1];
        dfs(root, distance, count);
        return count[0];
        
    }
    public int[] dfs(TreeNode75 root, int distance, int[] count){
        if(root == null){
            return new int[11];
        }
        int[] left = dfs(root.left, distance, count);
        int[] right = dfs(root.right, distance, count);
        int[] res = new int[11];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10 - i; j++){
                if(left[i] != 0 && right[j] != 0 && i + j + 2 <= distance){
                    count[0] += left[i] * right[j];
                }
            }
        }
        for(int i = 0; i < 10; i++){
            if(left[i] != 0){
                res[i + 1] = left[i] + 1;
            }
            if(right[i] != 0){
                res[i + 1] += right[i] + 1;
            }
        }
        return res;
    }
}

    