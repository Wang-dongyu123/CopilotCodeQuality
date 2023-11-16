package main.java.Medium;

import java.util.HashMap;
import java.util.Map;

/**https://leetcode.com/problems/can-i-win/ */
//In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.
//What if we change the game so that players cannot re-use integers?
//For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.
//Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.


class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal <= maxChoosableInteger){
            return true;
        }
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal){
            return false;
        }
        return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
        
    }
    private boolean canIWin(int maxChoosableInteger, int desiredTotal, int state, Map<Integer, Boolean> map){
        if(map.containsKey(state)){
            return map.get(state);
        }
        for(int i = 0; i < maxChoosableInteger; i++){
            if((state & (1 << i)) == 0){
                if(desiredTotal <= i + 1 || !canIWin(maxChoosableInteger, desiredTotal - (i + 1), state | (1 << i), map)){
                    map.put(state, true);
                    return true;
                }
            }
        }
        map.put(state, false);
        return false;
    }
}

    