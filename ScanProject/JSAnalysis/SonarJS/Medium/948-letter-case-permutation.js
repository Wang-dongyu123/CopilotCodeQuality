/**https://leetcode.com/problems/letter-case-permutation/ */
//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//Return a list of all possible strings we could create. Return the output in any order.


/**
 * @param {string} s
 * @return {string[]}
 */
var letterCasePermutation = function(s) {
    let result = [];
    let temp = "";
    dfs(0, s, temp, result);
    return result;
    
    
};
function dfs(index, s, temp, result){
    if(index == s.length){
        result.push(temp);
        return;
    }
    if(isLetter(s[index])){
        dfs(index + 1, s, temp + s[index].toLowerCase(), result);
        dfs(index + 1, s, temp + s[index].toUpperCase(), result);
    }else{
        dfs(index + 1, s, temp + s[index], result);
    }
}
function isLetter(c){
    return c.toLowerCase() != c.toUpperCase();
}

    