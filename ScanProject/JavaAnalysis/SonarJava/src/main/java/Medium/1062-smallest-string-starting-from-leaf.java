package main.java.Medium; /**https://leetcode.com/problems/smallest-string-starting-from-leaf/ */
//You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
//Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//As a reminder, any shorter prefix of a string is lexicographically smaller.
//For example, "ab" is lexicographically smaller than "aba".
//A leaf of a node is a node that has no children.

class TreeNode57 {
      int val;
      TreeNode57 left;
      TreeNode57 right;
      TreeNode57() {}
      TreeNode57(int val) { this.val = val; }
      TreeNode57(int val, TreeNode57 left, TreeNode57 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode57 root) {
        if(root == null){
            return "";
        }
        String[] result = new String[1];
        result[0] = "z";
        dfs(root, "", result);
        return result[0];
        
        
    }
    public void dfs(TreeNode57 root, String path, String[] result){
        if(root == null){
            return;
        }
        path = (char)(root.val + 'a') + path;
        if(root.left == null && root.right == null){
            if(path.compareTo(result[0]) < 0){
                result[0] = path;
            }
        }
        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}

    