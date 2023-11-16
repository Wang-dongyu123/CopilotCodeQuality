package main.java.Easy;

/**https://leetcode.com/problems/jewels-and-stones/ */
//You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
//Letters are case sensitive, so "a" is considered a different type of stone from "A".
// 
//Example 1:
//Input: jewels = "aA", stones = "aAAbbbb"
//Output: 3
//Example 2:
//Input: jewels = "z", stones = "ZZ"
//Output: 0
// 
//Constraints:
//	1 <= jewels.length, stones.length <= 50
//	jewels and stones consist of only English letters.
//	All the characters of jewels are unique.
class Solution17 {
    public int numJewelsInStones(String jewels, String stones) {
        int[] map = new int[128];
        for (char c : jewels.toCharArray()) {
            map[c] = 1;
        }
        int res = 0;
        for (char c : stones.toCharArray()) {
            res += map[c];
        }
        return res;
    }
}