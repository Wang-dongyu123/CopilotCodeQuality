/**https://leetcode.com/problems/escape-a-large-maze/ */
//There is a 1 million by 1 million grid on an XY-plane, and the coordinates of each grid square are (x, y).
//We start at the source = [sx, sy] square and want to reach the target = [tx, ty] square. There is also an array of blocked squares, where each blocked[i] = [xi, yi] represents a blocked square with coordinates (xi, yi).
//Each move, we can walk one square north, east, south, or west if the square is not in the array of blocked squares. We are also not allowed to walk outside of the grid.
//Return true if and only if it is possible to reach the target square from the source square through a sequence of valid moves.


/**
 * @param {number[][]} blocked
 * @param {number[]} source
 * @param {number[]} target
 * @return {boolean}
 */
var isEscapePossible = function(blocked, source, target) {
    let blockedSet = new Set();
    for(let i = 0; i < blocked.length; i++){
        blockedSet.add(blocked[i][0] + ',' + blocked[i][1]);
    }
    let sourceVisited = new Set();
    let targetVisited = new Set();
    return bfs(source, target, blockedSet, sourceVisited) && bfs(target, source, blockedSet, targetVisited);
    
};

function bfs(source, target, blockedSet, visited){
    let queue = [];
    queue.push(source);
    visited.add(source[0] + ',' + source[1]);
    let dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    while(queue.length > 0){
        let size = queue.length;
        for(let i = 0; i < size; i++){
            let [x, y] = queue.shift();
            for(let j = 0; j < dirs.length; j++){
                let newX = x + dirs[j][0];
                let newY = y + dirs[j][1];
                if(newX < 0 || newX >= 1000000 || newY < 0 || newY >= 1000000 || blockedSet.has(newX + ',' + newY) || visited.has(newX + ',' + newY)){
                    continue;
                }
                if(newX == target[0] && newY == target[1]){
                    return true;
                }
                queue.push([newX, newY]);
                visited.add(newX + ',' + newY);
            }
        }
        if(visited.size > 20000){
            return true;
        }
    }
    return false;
}
