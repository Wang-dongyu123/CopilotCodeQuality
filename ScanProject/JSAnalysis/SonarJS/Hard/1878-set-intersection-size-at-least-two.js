/**https://leetcode.com/problems/set-intersection-size-at-least-two/ */
//You are given a 2D integer array intervals where intervals[i] = [starti, endi] represents all the integers from starti to endi inclusively.
//A containing set is an array nums where each interval from intervals has at least two integers in nums.
//For example, if intervals = [[1,3], [3,7], [8,9]], then [1,2,4,7,8,9] and [2,3,4,8,9] are containing sets.
//Return the minimum possible size of a containing set.


/**
 * @param {number[][]} intervals
 * @return {number}
 */
var intersectionSizeTwo = function(intervals) {
    let n = intervals.length;
    let dp = [];
    for(let i = 0; i <= n; i++){
        dp.push([]);
        for(let j = 0; j <= n; j++){
            dp[i].push(0);
        }
    }
    for(let i = 0; i <= n; i++){
        dp[i][i] = 1;
    }
    for(let i = 1; i <= n; i++){
        for(let j = i - 1; j >= 0; j--){
            if(s[i - 1] === s[j]){
                dp[i][j] = dp[i - 1][j];
            }else{
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + 1;
            }
        }
    }
    return dp[n][0];
    
    
};
function isSimilar(s1, s2){
    if(s1.length != s2.length){
        return false;
    }
    let map1 = new Map();
    let map2 = new Map();
    for(let i = 0; i < s1.length; i++){
        if(map1.has(s1[i])){
            map1.set(s1[i], map1.get(s1[i]) + 1);
        }else{
            map1.set(s1[i], 1);
        }
        if(map2.has(s2[i])){
            map2.set(s2[i], map2.get(s2[i]) + 1);
        }else{
            map2.set(s2[i], 1);
        }
    }
    for(let [key, val] of map1){
        if(!map2.has(key) || map2.get(key) != val){
            return false;
        }
    }
    return true;
}

    