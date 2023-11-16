/**https://leetcode.com/problems/couples-holding-hands/ */
//There are n couples sitting in 2n seats arranged in a row and want to hold hands.
//The people and seats are represented by an integer array row where row[i] is the ID of the person sitting in the ith seat. The couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2n - 2, 2n - 1).
//Return the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.


/**
 * @param {number[]} row
 * @return {number}
 */
var minSwapsCouples = function(row) {
    let n = row.length;
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
    