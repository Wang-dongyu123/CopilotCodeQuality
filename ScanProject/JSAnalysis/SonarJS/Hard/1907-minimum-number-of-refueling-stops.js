/**https://leetcode.com/problems/minimum-number-of-refueling-stops/ */
//A car travels from a starting position to a destination which is target miles east of the starting position.
//There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
//The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
//Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
//Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.


/**
 * @param {number} target
 * @param {number} startFuel
 * @param {number[][]} stations
 * @return {number}
 */
var minRefuelStops = function(target, startFuel, stations) {
    let n = stations.length;
    let dp = [];
    for(let i = 0; i <= n; i++){
        dp.push([]);
        for(let j = 0; j <= n; j++){
            dp[i].push(0);
        }
    }
    dp[0][0] = startFuel;
    for(let i = 1; i <= n; i++){
        for(let j = 0; j <= i; j++){
            if(j > 0){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + stations[i - 1][1]);
            }
            else{
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    for(let i = 0; i <= n; i++){
        if(dp[n][i] >= target){
            return i;
        }
    }
    return -1;
    
};

    