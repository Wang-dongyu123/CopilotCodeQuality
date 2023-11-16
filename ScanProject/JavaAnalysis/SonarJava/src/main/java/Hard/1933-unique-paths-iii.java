package main.java.Hard;

/**https://leetcode.com/problems/unique-paths-iii/ */
//You are given an m x n integer array grid where grid[i][j] could be:
//1 representing the starting square. There is exactly one starting square.
//2 representing the ending square. There is exactly one ending square.
//0 representing empty squares we can walk over.
//-1 representing obstacles that we cannot walk over.
//Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.


class UniquePathsIii {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int start = 0;
        int end = 0;
        int empty = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) start = i*n+j;
                else if(grid[i][j]==2) end = i*n+j;
                else if(grid[i][j]==0) empty++;
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int[] res = new int[1];
        dfs(grid,start,end,empty,dirs,res);
        return res[0];
        
    }
    public void dfs(int[][] grid,int cur,int end,int empty,int[][] dirs,int[] res){
        if(cur==end && empty==0){
            res[0]++;
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        int i = cur/n;
        int j = cur%n;
        int temp = grid[i][j];
        grid[i][j] = -1;
        for(int[] dir : dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]!=-1){
                dfs(grid,x*n+y,end,empty-1,dirs,res);
            }
        }
        grid[i][j] = temp;
    }
}
     
    