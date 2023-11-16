package main.java.Hard;

/**https://leetcode.com/problems/count-fertile-pyramids-in-a-land/ */
//A farmer has a rectangular grid of land with m rows and n columns that can be divided into unit cells. Each cell is either fertile (represented by a 1) or barren (represented by a 0). All cells outside the grid are considered barren.
//A pyramidal plot of land can be defined as a set of cells with the following criteria:
//The number of cells in the set has to be greater than 1 and all cells must be fertile.
//The apex of a pyramid is the topmost cell of the pyramid. The height of a pyramid is the number of rows it covers. Let (r, c) be the apex of the pyramid, and its height be h. Then, the plot comprises of cells (i, j) where r <= i <= r + h - 1 and c - (i - r) <= j <= c + (i - r).
//An inverse pyramidal plot of land can be defined as a set of cells with similar criteria:
//The number of cells in the set has to be greater than 1 and all cells must be fertile.
//The apex of an inverse pyramid is the bottommost cell of the inverse pyramid. The height of an inverse pyramid is the number of rows it covers. Let (r, c) be the apex of the pyramid, and its height be h. Then, the plot comprises of cells (i, j) where r - h + 1 <= i <= r and c - (r - i) <= j <= c + (r - i).
//Some examples of valid and invalid pyramidal (and inverse pyramidal) plots are shown below. Black cells indicate fertile cells.
//Given a 0-indexed m x n binary matrix grid representing the farmland, return the total number of pyramidal and inverse pyramidal plots that can be found in grid.


class CountFertilePyramidsInALand {
    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int h = 1;
                    while (i + h < m && j - h >= 0 && j + h < n && grid[i + h][j - h] == 1 && grid[i + h][j + h] == 1) {
                        h++;
                    }
                    if (h > 1) {
                        res++;
                    }
                    h = 1;
                    while (i - h >= 0 && j - h >= 0 && j + h < n && grid[i - h][j - h] == 1 && grid[i - h][j + h] == 1) {
                        h++;
                    }
                    if (h > 1) {
                        res++;
                    }
                }
            }
        }
        return res;
        
    }
}
     
    