package main.java.Medium;

/**https://leetcode.com/problems/queries-on-a-permutation-with-key/ */
//Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:
//In the beginning, you have the permutation P=[1,2,3,...,m].
//For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
//Return an array containing the result for the given queries.


class QueriesOnAPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        int[] P = new int[m];
        for(int i = 0; i < m; i++){
            P[i] = i + 1;
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int index = 0;
            for(int j = 0; j < m; j++){
                if(P[j] == queries[i]){
                    index = j;
                    break;
                }
            }
            result[i] = index;
            int temp = P[index];
            for(int j = index; j > 0; j--){
                P[j] = P[j - 1];
            }
            P[0] = temp;
        }
        return result;
        
    }
}

    