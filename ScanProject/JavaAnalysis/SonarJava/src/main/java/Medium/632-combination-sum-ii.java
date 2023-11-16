package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/combination-sum-ii/ */
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
//Note: The solution set must not contain duplicate combinations.
// 
//Example 1:
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//Example 2:
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//Constraints:
//	1 <= candidates.length <= 100
//	1 <= candidates[i] <= 50
//	1 <= target <= 30
class Solution448 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}