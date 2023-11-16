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


/**
 * @param {number[][]} grid
 * @return {number}
 */
var countPyramids = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let ans = 0;
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == 1){
                ans += dfs(grid, i, j);
            }
        }
    }
    return ans;
    
    
};

function dfs(grid, r, c){
    let m = grid.length;
    let n = grid[0].length;
    let ans = 0;
    let height = 0;
    for(let i = r; i < m; i++){
        let width = 0;
        for(let j = c; j < n; j++){
            if(grid[i][j] == 1){
                width++;
                if(width == 1){
                    ans++;
                }else{
                    if(height >= width){
                        ans++;
                    }
                }
            }else{
                break;
            }
        }
        height++;
    }
    return ans;
}