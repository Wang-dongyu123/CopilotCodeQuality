package main.java.Medium;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/card-flipping-game/ */
//You are given two 0-indexed integer arrays fronts and backs of length n, where the ith card has the positive integer fronts[i] printed on the front and backs[i] printed on the back. Initially, each card is placed on a table such that the front number is facing up and the other is facing down. You may flip over any number of cards (possibly zero).
//After flipping the cards, an integer is considered good if it is facing down on some card and not facing up on any card.
//Return the minimum possible good integer after flipping the cards. If there are no good integers, return 0.


class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        int n = fronts.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(fronts[i] == backs[i]){
                set.add(fronts[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(!set.contains(fronts[i])){
                res = Math.min(res, fronts[i]);
            }
            if(!set.contains(backs[i])){
                res = Math.min(res, backs[i]);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
        
    }
}

    