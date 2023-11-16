package main.java.Medium;

/**https://leetcode.com/problems/satisfiability-of-equality-equations/ */
//You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.
//Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.


class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
        }
        for(String s : equations){
            if(s.charAt(1) == '='){
                int x = s.charAt(0) - 'a';
                int y = s.charAt(3) - 'a';
                union(parent, x, y);
            }
        }
        for(String s : equations){
            if(s.charAt(1) == '!'){
                int x = s.charAt(0) - 'a';
                int y = s.charAt(3) - 'a';
                if(find(parent, x) == find(parent, y)){
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    public void union(int[] parent, int x, int y){
        int px = find(parent, x);
        int py = find(parent, y);
        if(px != py){
            parent[px] = py;
        }
    }
}

    