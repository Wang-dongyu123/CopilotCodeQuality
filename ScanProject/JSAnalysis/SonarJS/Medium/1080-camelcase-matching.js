/**https://leetcode.com/problems/camelcase-matching/ */
//Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
//A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.


/**
 * @param {string[]} queries
 * @param {string} pattern
 * @return {boolean[]}
 */
var camelMatch = function(queries, pattern) {
    let n = queries.length;
    let result = [];
    for(let i = 0; i < n; i++){
        result.push(isMatch(queries[i], pattern));
    }
    return result;
    
    
    
};
function isMatch(query, pattern){
    let i = 0;
    let j = 0;
    while(i < query.length){
        if(j < pattern.length && query[i] == pattern[j]){
            i++;
            j++;
        }else if(query[i] == query[i].toLowerCase()){
            i++;
        }else{
            return false;
        }
    }
    return j == pattern.length;
}

    