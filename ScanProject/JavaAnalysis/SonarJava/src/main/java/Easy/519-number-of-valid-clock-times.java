package main.java.Easy;

/**https://leetcode.com/problems/number-of-valid-clock-times/ */
//You are given a string of length 5 called time, representing the current time on a digital clock in the format "hh:mm". The earliest possible time is "00:00" and the latest possible time is "23:59".
//In the string time, the digits represented by the ? symbol are unknown, and must be replaced with a digit from 0 to 9.
//Return an integer answer, the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.
// 
//Example 1:
//Input: time = "?5:00"
//Output: 2
//Explanation: We can replace the ? with either a 0 or 1, producing "05:00" or "15:00". Note that we cannot replace it with a 2, since the time "25:00" is invalid. In total, we have two choices.
//Example 2:
//Input: time = "0?:0?"
//Output: 100
//Explanation: Each ? can be replaced by any digit from 0 to 9, so we have 100 total choices.
//Example 3:
//Input: time = "??:??"
//Output: 1440
//Explanation: There are 24 possible choices for the hours, and 60 possible choices for the minutes. In total, we have 24 * 60 = 1440 choices.
// 
//Constraints:
//	time is a valid string of length 5 in the format "hh:mm".
//	"00" <= hh <= "23"
//	"00" <= mm <= "59"
//	Some of the digits might be replaced with '?' and need to be replaced with digits from 0 to 9.
class Solution328 {
    public int countTime(String time) {
        char[] c = time.toCharArray();
        int res = 0;
        for (int i = 0; i < 5; i++) {
            if (c[i] == '?') {
                if (i == 0) {
                    if (c[1] == '?' || c[1] <= '3') {
                        res += 2;
                    }
                } else if (i == 1) {
                    if (c[0] == '2' || c[0] == '?') {
                        res += 3;
                    } else {
                        res += 9;
                    }
                } else if (i == 3) {
                    res += 6;
                } else {
                    res += 10;
                }
            }
        }
        return res;
    }
}