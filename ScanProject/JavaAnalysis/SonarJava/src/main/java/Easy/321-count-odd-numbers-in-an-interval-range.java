package main.java.Easy;

/**https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/ */
//Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive)._x000D_
//_x000D_
// _x000D_
//Example 1:_x000D_
//_x000D_
//_x000D_
//Input: low = 3, high = 7_x000D_
//Output: 3_x000D_
//Explanation: The odd numbers between 3 and 7 are [3,5,7]._x000D_
//_x000D_
//Example 2:_x000D_
//_x000D_
//_x000D_
//Input: low = 8, high = 10_x000D_
//Output: 1_x000D_
//Explanation: The odd numbers between 8 and 10 are [9]._x000D_
//_x000D_
// _x000D_
//Constraints:_x000D_
//_x000D_
//_x000D_
//	0 <= low <= high <= 10^9_x000D_
class Solution147 {
    public int countOdds(int low, int high) {
        int count = 0;
        if(low % 2 == 0){
            low++;
        }
        if(high % 2 == 0){
            high--;
        }
        return (high - low) / 2 + 1;
    }
}