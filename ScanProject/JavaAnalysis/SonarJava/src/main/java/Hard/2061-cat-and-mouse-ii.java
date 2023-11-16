package main.java.Hard;

import java.util.Arrays;

/**https://leetcode.com/problems/cat-and-mouse-ii/ */
//A game is played by a cat and a mouse named Cat and Mouse.
//The environment is represented by a grid of size rows x cols, where each element is a wall, floor, player (Cat, Mouse), or food.
//	Players are represented by the characters 'C'(Cat),'M'(Mouse).
//	Floors are represented by the character '.' and can be walked on.
//	Walls are represented by the character '#' and cannot be walked on.
//	Food is represented by the character 'F' and can be walked on.
//	There is only one of each character 'C', 'M', and 'F' in grid.
//Mouse and Cat play according to the following rules:
//	Mouse moves first, then they take turns to move.
//	During each turn, Cat and Mouse can jump in one of the four directions (left, right, up, down). They cannot jump over the wall nor outside of the grid.
//	catJump, mouseJump are the maximum lengths Cat and Mouse can jump at a time, respectively. Cat and Mouse can jump less than the maximum length.
//	Staying in the same position is allowed.
//	Mouse can jump over Cat.
//The game can end in 4 ways:
//	If Cat occupies the same position as Mouse, Cat wins.
//	If Cat reaches the food first, Cat wins.
//	If Mouse reaches the food first, Mouse wins.
//	If Mouse cannot get to the food within 1000 turns, Cat wins.
//Given a rows x cols matrix grid and two integers catJump and mouseJump, return true if Mouse can win the game if both Cat and Mouse play optimally, otherwise return false.
// 
//Example 1:
//Input: grid = ["####F","#C...","M...."], catJump = 1, mouseJump = 2
//Output: true
//Explanation: Cat cannot catch Mouse on its turn nor can it get the food before Mouse.
//Example 2:
//Input: grid = ["M.C...F"], catJump = 1, mouseJump = 4
//Output: true
//Example 3:
//Input: grid = ["M.C...F"], catJump = 1, mouseJump = 3
//Output: false
// 
//Constraints:
//	rows == grid.length
//	cols = grid[i].length
//	1 <= rows, cols <= 8
//	grid[i][j] consist only of characters 'C', 'M', 'F', '.', and '#'.
//	There is only one of each character 'C', 'M', and 'F' in grid.
//	1 <= catJump, mouseJump <= 8
class Solution62 {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int m = grid.length;
        int n = grid[0].length();
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        int[] cat = new int[2];
        int[] mouse = new int[2];
        int[] food = new int[2];
        int foodIdx = 0;
        int catIdx = 0;
        int mouseIdx = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = grid[i].charAt(j);
                if(c == 'C'){
                    cat[0] = i;
                    cat[1] = j;
                    catIdx = i * n + j;
                }
                if(c == 'M'){
                    mouse[0] = i;
                    mouse[1] = j;
                    mouseIdx = i * n + j;
                }
                if(c == 'F'){
                    food[0] = i;
                    food[1] = j;
                    foodIdx = i * n + j;
                }
            }
        }
        int[][] catDist = new int[m * n][m * n];
        int[][] mouseDist = new int[m * n][m * n];
        int[] queue = new int[m * n];
        int catStart = cat[0] * n + cat[1];
        int mouseStart = mouse[0] * n + mouse[1];
        int foodStart = food[0] * n + food[1];
        bfs(grid, catDist, catJump, catStart, n, m, queue);
        bfs(grid, mouseDist, mouseJump, mouseStart, n, m, queue);
        int[][] dp = new int[m * n][m * n];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return dfs(grid, dp, catDist, mouseDist, catStart, mouseStart, foodStart, catIdx, mouseIdx, foodIdx, n, m);

    }
    private boolean dfs(String[] grid, int[][] dp, int[][] catDist, int[][] mouseDist, int catStart, int mouseStart, int foodStart, int catIdx, int mouseIdx, int foodIdx, int n, int m){
        if(dp[catStart][mouseStart] != -1){
            return dp[catStart][mouseStart] == 1;
        }
        if(catStart == foodStart){
            return false;
        }
        if(mouseStart == foodStart){
            return true;
        }
        boolean catWin = false;
        boolean mouseWin = true;
        for(int i = 0; i < m * n; i++){
            if(i == catStart || catDist[catStart][i] == Integer.MAX_VALUE){
                continue;
            }
            if(catDist[catStart][i] <= mouseDist[mouseStart][i]){
                continue;
            }
            if(i == foodStart){
                continue;
            }
            if(i == mouseStart){
                continue;
            }
            if(!dfs(grid, dp, catDist, mouseDist, i, mouseStart, foodStart, catIdx, mouseIdx, foodIdx, n, m)){
                catWin = true;
                break;
            }
        }
        for(int i = 0; i < m * n; i++){
            if(i == mouseStart || mouseDist[mouseStart][i] == Integer.MAX_VALUE){
                continue;
            }
            if(mouseDist[mouseStart][i] <= catDist[catStart][i]){
                continue;
            }
            if(i == foodStart){
                continue;
            }
            if(i == catStart){
                continue;
            }
            if(dfs(grid, dp, catDist, mouseDist, catStart, i, foodStart, catIdx, mouseIdx, foodIdx, n, m)){
                mouseWin = false;
                break;
            }
        }
        dp[catStart][mouseStart] = catWin ? 1 : (mouseWin ? 0 : -1);
        return catWin;
    }
    private void bfs(String[] grid, int[][] dist, int jump, int start, int n, int m, int[] queue){
        Arrays.fill(dist[start], Integer.MAX_VALUE);
        dist[start][start] = 0;
        int head = 0, tail = 0;
        queue[tail++] = start;
    }
}