/**https://leetcode.com/problems/cat-and-mouse-ii/ */
//A game is played by a cat and a mouse named Cat and Mouse.
//The environment is represented by a grid of size rows x cols, where each element is a wall, floor, player (Cat, Mouse), or food.
//Players are represented by the characters 'C'(Cat),'M'(Mouse).
//Floors are represented by the character '.' and can be walked on.
//Walls are represented by the character '#' and cannot be walked on.
//Food is represented by the character 'F' and can be walked on.
//There is only one of each character 'C', 'M', and 'F' in grid.
//Mouse and Cat play according to the following rules:
//Mouse moves first, then they take turns to move.
//During each turn, Cat and Mouse can jump in one of the four directions (left, right, up, down). They cannot jump over the wall nor outside of the grid.
//catJump, mouseJump are the maximum lengths Cat and Mouse can jump at a time, respectively. Cat and Mouse can jump less than the maximum length.
//Staying in the same position is allowed.
//Mouse can jump over Cat.
//The game can end in 4 ways:
//If Cat occupies the same position as Mouse, Cat wins.
//If Cat reaches the food first, Cat wins.
//If Mouse reaches the food first, Mouse wins.
//If Mouse cannot get to the food within 1000 turns, Cat wins.
//Given a rows x cols matrix grid and two integers catJump and mouseJump, return true if Mouse can win the game if both Cat and Mouse play optimally, otherwise return false.


/**
 * @param {string[]} grid
 * @param {number} catJump
 * @param {number} mouseJump
 * @return {boolean}
 */
var canMouseWin = function(grid, catJump, mouseJump) {
    let n = grid.length;
    let m = grid[0].length;
    let catPos = new Array(2);
    let mousePos = new Array(2);
    let foodPos = new Array(2);
    for(let i = 0; i < n; i++){
        for(let j = 0; j < m; j++){
            if(grid[i][j] == 'C'){
                catPos[0] = i;
                catPos[1] = j;
            }else if(grid[i][j] == 'M'){
                mousePos[0] = i;
                mousePos[1] = j;
            }else if(grid[i][j] == 'F'){
                foodPos[0] = i;
                foodPos[1] = j;
            }
        }
    }
    let memo = new Map();
    let res = dfs(grid, catPos, mousePos, foodPos, catJump, mouseJump, memo);
    return res;
    
};
function dfs(grid, catPos, mousePos, foodPos, catJump, mouseJump, memo){
    let key = catPos[0] + ',' + catPos[1] + ',' + mousePos[0] + ',' + mousePos[1];
    if(memo.has(key)){
        return memo.get(key);
    }
    let n = grid.length;
    let m = grid[0].length;
    let catTurn = true;
    let res = false;
    if(catPos[0] == mousePos[0] && catPos[1] == mousePos[1]){
        res = false;
    }else if(catPos[0] == foodPos[0] && catPos[1] == foodPos[1]){
        res = false;
    }else if(mousePos[0] == foodPos[0] && mousePos[1] == foodPos[1]){
        res = true;
    }else if(mouseJump == 0){
        res = false;
    }else{
        if(catTurn){
            let nextPos = getNextPos(catPos, grid, mousePos, catJump);
            for(let i = 0; i < nextPos.length; i++){
                let next = nextPos[i];
                let nextCatPos = next[0];
                let nextMousePos = next[1];
                let nextRes = dfs(grid, nextCatPos, nextMousePos, foodPos, catJump, mouseJump, memo);
                if(nextRes){
                    res = true;
                    break;
                }
            }
            if(!res){
                res = false;
            }
        }else{
            let nextPos = getNextPos(mousePos, grid, catPos, mouseJump);
            for(let i = 0; i < nextPos.length; i++){
                let next = nextPos[i];
                let nextCatPos = next[0];
                let nextMousePos = next[1];
                let nextRes = dfs(grid, catPos, nextMousePos, foodPos, catJump, mouseJump, memo);
                if(!nextRes){
                    res = false;
                    break;
                }
            }
            if(res){
                res = true;
            }
        }
    }
    memo.set(key, res);
    return res;
}
function getNextPos(pos, grid, otherPos, jump){
    let n = grid.length;
    let m = grid[0].length;
    let res = [];
    for(let i = -jump; i <= jump; i++){
        for(let j = -jump; j <= jump; j++){
            let x = pos[0] + i;
            let y = pos[1] + j;
            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] != '#'){
                if(Math.abs(i) + Math.abs(j) <= jump){
                    if(x != otherPos[0] || y != otherPos[1]){
                        res.push([[x, y], otherPos]);
                    }
                }
            }
        }
    }
    return res;
}
    