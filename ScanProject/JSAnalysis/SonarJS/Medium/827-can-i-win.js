/**https://leetcode.com/problems/can-i-win/ */
//In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
//What if we change the game so that players cannot re-use integers?
//For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.
//Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.


/**
 * @param {number} maxChoosableInteger
 * @param {number} desiredTotal
 * @return {boolean}
 */
var canIWin = function(maxChoosableInteger, desiredTotal) {
    if(desiredTotal <= maxChoosableInteger){
        return true;
    }
    if((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal){
        return false;
    }
    let map = new Map();
    return helper(map, maxChoosableInteger, desiredTotal, 0);
    
    
};
function helper(map, max, total, state){
    if(total <= 0){
        return false;
    }
    if(map.has(state)){
        return map.get(state);
    }
    for(let i = 0; i < max; i++){
        if((state & (1 << i)) != 0){
            continue;
        }
        if(!helper(map, max, total - i - 1, state | (1 << i))){
            map.set(state, true);
            return true;
        }
    }
    map.set(state, false);
    return false;
}

    