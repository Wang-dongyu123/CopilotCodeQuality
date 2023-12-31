package main.java.Hard;

/**https://leetcode.com/problems/minimum-number-of-refueling-stops/ */
//A car travels from a starting position to a destination which is target miles east of the starting position.
//There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
//The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
//Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
//Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.


class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; t--) {
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
        
    }
}
     
    