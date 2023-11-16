package main.java.Medium;

/**https://leetcode.com/problems/angle-between-hands-of-a-clock/ */
//Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
//Answers within 10-5 of the actual value will be accepted as correct.
// 
//Example 1:
//Input: hour = 12, minutes = 30
//Output: 165
//Example 2:
//Input: hour = 3, minutes = 30
//Output: 75
//Example 3:
//Input: hour = 3, minutes = 15
//Output: 7.5
// 
//Constraints:
//	1 <= hour <= 12
//	0 <= minutes <= 59
class Solution83 {
    public double angleClock(int hour, int minutes) {
        double m = minutes*6;
        double h = hour*30+minutes*0.5;
        double ans = Math.abs(m-h);
        return ans > 180 ? 360-ans : ans;
    }
}