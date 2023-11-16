/**https://leetcode.com/problems/minimum-time-difference/ */
//Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
// 
//Example 1:
//Input: timePoints = ["23:59","00:00"]
//Output: 1
//Example 2:
//Input: timePoints = ["00:00","23:59","00:00"]
//Output: 0
// 
//Constraints:
//	2 <= timePoints.length <= 2 * 104
//	timePoints[i] is in the format "HH:MM".
/**
 * @param {string[]} timePoints
 * @return {number}
 */
var findMinDifference = function(timePoints) {
    let minutes = [];
    for (let time of timePoints) {
        let [hour, minute] = time.split(":");
        minutes.push(parseInt(hour) * 60 + parseInt(minute));
    }
    minutes.sort((a, b) => a - b);
    let min = 24 * 60;
    for (let i = 1; i < minutes.length; i++) {
        min = Math.min(min, minutes[i] - minutes[i - 1]);
    }
    min = Math.min(min, minutes[0] + 24 * 60 - minutes[minutes.length - 1]);
    return min;
};