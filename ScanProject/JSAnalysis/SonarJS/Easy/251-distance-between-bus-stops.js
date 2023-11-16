/**https://leetcode.com/problems/distance-between-bus-stops/ */
//A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n._x000D_
//_x000D_
//The bus goes along both directions i.e. clockwise and counterclockwise._x000D_
//_x000D_
//Return the shortest distance between the given start and destination stops._x000D_
//_x000D_
// _x000D_
//Example 1:_x000D_
//_x000D_
//_x000D_
//_x000D_
//_x000D_
//Input: distance = [1,2,3,4], start = 0, destination = 1_x000D_
//Output: 1_x000D_
//Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1._x000D_
//_x000D_
// _x000D_
//_x000D_
//Example 2:_x000D_
//_x000D_
//_x000D_
//_x000D_
//_x000D_
//Input: distance = [1,2,3,4], start = 0, destination = 2_x000D_
//Output: 3_x000D_
//Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3._x000D_
//_x000D_
//_x000D_
// _x000D_
//_x000D_
//Example 3:_x000D_
//_x000D_
//_x000D_
//_x000D_
//_x000D_
//Input: distance = [1,2,3,4], start = 0, destination = 3_x000D_
//Output: 4_x000D_
//Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4._x000D_
//_x000D_
//_x000D_
// _x000D_
//Constraints:_x000D_
//_x000D_
//_x000D_
//	1 <= n <= 10^4_x000D_
//	distance.length == n_x000D_
//	0 <= start, destination < n_x000D_
//	0 <= distance[i] <= 10^4_x000D_
/**
 * @param {number[]} distance
 * @param {number} start
 * @param {number} destination
 * @return {number}
 */
var distanceBetweenBusStops = function(distance, start, destination) {
    let total = 0;
	for (let i = 0; i < distance.length; i++) {
		total += distance[i];
	}
	let clockwise = 0;
	let i = start;
	while (i !== destination) {
		clockwise += distance[i];
		i = (i + 1) % distance.length;
	}
	let counterclockwise = total - clockwise;
	return Math.min(clockwise, counterclockwise);
};