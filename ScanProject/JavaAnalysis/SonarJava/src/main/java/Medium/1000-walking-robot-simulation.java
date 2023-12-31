package main.java.Medium;

import java.util.HashSet;
import java.util.Set;

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


class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int dir = 0;
        int res = 0;
        Set<String> set = new HashSet<>();
        for(int[] obstacle : obstacles){
            set.add(obstacle[0] + " " + obstacle[1]);
        }
        for(int command : commands){
            if(command == -2){
                dir = (dir + 3) % 4;
            }else if(command == -1){
                dir = (dir + 1) % 4;
            }else{
                for(int i = 0; i < command; i++){
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];
                    if(!set.contains(nx + " " + ny)){
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }else{
                        break;
                    }
                }
            }
        }
        return res;
        
    }
}

    