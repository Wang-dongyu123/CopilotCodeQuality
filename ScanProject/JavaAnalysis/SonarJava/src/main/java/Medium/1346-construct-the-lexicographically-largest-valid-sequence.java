package main.java.Medium;

/**https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/ */
//Given an integer n, find a sequence that satisfies all of the following:
//The integer 1 occurs once in the sequence.
//Each integer between 2 and n occurs twice in the sequence.
//For every integer i between 2 and n, the distance between the two occurrences of i is exactly i.
//The distance between two numbers on the sequence, a[i] and a[j], is the absolute difference of their indices, |j - i|.
//Return the lexicographically largest sequence. It is guaranteed that under the given constraints, there is always a solution.
//A sequence a is lexicographically larger than a sequence b (of the same length) if in the first position where a and b differ, sequence a has a number greater than the corresponding number in b. For example, [0,1,9,0] is lexicographically larger than [0,1,5,6] because the first position they differ is at the third number, and 9 is greater than 5.


class ConstructTheLexicographicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        dfs(res, used, 0);
        return res;
        
        
    }
    public boolean dfs(int[] res, boolean[] used, int index){
        if(index == res.length){
            return true;
        }
        if(res[index] != 0){
            return dfs(res, used, index + 1);
        }
        for(int i = used.length - 1; i > 0; i--){
            if(used[i]){
                continue;
            }
            if(i == 1){
                res[index] = 1;
                used[i] = true;
                if(dfs(res, used, index + 1)){
                    return true;
                }
                used[i] = false;
                res[index] = 0;
            }else{
                if(index + i < res.length && res[index + i] == 0){
                    res[index] = i;
                    res[index + i] = i;
                    used[i] = true;
                    if(dfs(res, used, index + 1)){
                        return true;
                    }
                    used[i] = false;
                    res[index] = 0;
                    res[index + i] = 0;
                }
            }
        }
        return false;
    }
}
     
    