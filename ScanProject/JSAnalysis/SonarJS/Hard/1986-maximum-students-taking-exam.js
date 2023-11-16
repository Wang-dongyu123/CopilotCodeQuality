/**https://leetcode.com/problems/maximum-students-taking-exam/ */
//Given a m * n matrix seats  that represent seats distributions in a classroom. If a seat is broken, it is denoted by '#' character otherwise it is denoted by a '.' character.
//Students can see the answers of those sitting next to the left, right, upper left and upper right, but he cannot see the answers of the student sitting directly in front or behind him. Return the maximum number of students that can take the exam together without any cheating being possible..
//Students must be placed in seats in good condition.


/**
 * @param {character[][]} seats
 * @return {number}
 */
var maxStudents = function(seats) {
    let m = seats.length;
    let n = seats[0].length;
    let dp = new Array(m + 1);
    for(let i = 0; i <= m; i++){
        dp[i] = new Array(1 << n).fill(0);
    }
    for(let i = 1; i <= m; i++){
        for(let j = 0; j < (1 << n); j++){
            if(isValid(seats[i - 1], j)){
                for(let k = 0; k < (1 << n); k++){
                    if((j & k) == 0){
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + count(j));
                    }
                }
            }
        }
    }
    return Math.max(...dp[m]);
    
    
};

function isValid(row, mask){
    for(let i = 0; i < row.length; i++){
        if((mask & (1 << i)) > 0 && row[i] == '#'){
            return false;
        }
    }
    for(let i = 0; i < row.length - 1; i++){
        if((mask & (1 << i)) > 0 && (mask & (1 << (i + 1))) > 0){
            return false;
        }
    }
    for(let i = 0; i < row.length - 1; i++){
        if((mask & (1 << i)) > 0 && (mask & (1 << (i + 1))) == 0){
            if(i < row.length - 2 && (mask & (1 << (i + 2))) > 0){
                return false;
            }
            if(i > 0 && (mask & (1 << (i - 1))) > 0){
                return false;
            }
        }
    }
    return true;
}
function count(mask){
    let count = 0;
    while(mask > 0){
        if(mask % 2 == 1){
            count++;
        }
        mask >>= 1;
    }
    return count;
}