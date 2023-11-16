/**https://leetcode.com/problems/maximal-rectangle/ */
//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.


/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    let m = matrix.length;
    if(m === 0){
        return 0;
    }
    let n = matrix[0].length;
    let max = 0;
    let heights = [];
    for(let i = 0; i < n; i++){
        heights.push(0);
    }
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(matrix[i][j] === "1"){
                heights[j] = heights[j] + 1;
            }else{
                heights[j] = 0;
            }
        }
        max = Math.max(max, largestRectangleArea(heights));
    }
    return max;
    
    
};
function largestRectangleArea(heights) {
    let max = 0;
    let stack = [];
    for(let i = 0; i <= heights.length; i++){
        let h = i === heights.length ? 0 : heights[i];
        if(stack.length === 0 || h >= heights[stack[stack.length - 1]]){
            stack.push(i);
        }else{
            let top = stack.pop();
            let start = stack.length === 0 ? -1 : stack[stack.length - 1];
            max = Math.max(max, heights[top] * (i - start - 1));
            i--;
        }
    }
    return max;
}
    