/**https://leetcode.com/problems/walking-robot-simulation/ */
//A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these three possible types of commands:
//-2: Turn left 90 degrees.
//-1: Turn right 90 degrees.
//1 <= k <= 9: Move forward k units, one unit at a time.
//Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.
//Return the maximum Euclidean distance that the robot ever gets from the origin squared (i.e. if the distance is 5, return 25).
//Note:
//North means +Y direction.
//East means +X direction.
//South means -Y direction.
//West means -X direction.


/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    let x = 0;
    let y = 0;
    let max = 0;
    let dir = 0;
    let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let obs = new Set();
    for(let i = 0; i < obstacles.length; i++){
        obs.add(obstacles[i][0] + " " + obstacles[i][1]);
    }
    for(let i = 0; i < commands.length; i++){
        if(commands[i] == -1){
            dir = (dir + 1) % 4;
        }else if(commands[i] == -2){
            dir = (dir + 3) % 4;
        }else{
            for(let j = 0; j < commands[i]; j++){
                let newX = x + dirs[dir][0];
                let newY = y + dirs[dir][1];
                if(!obs.has(newX + " " + newY)){
                    x = newX;
                    y = newY;
                    max = Math.max(max, x * x + y * y);
                }else{
                    break;
                }
            }
        }
    }
    return max;
    
};

    