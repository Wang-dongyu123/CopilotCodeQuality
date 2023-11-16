/**https://leetcode.com/problems/palindrome-partitioning/ */
//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.


/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let result = [];
    let current = [];
    backtrack(s, 0, current, result);
    return result;
    
};
function backtrack(s, start, current, result){
    if(start == s.length){
        result.push(current.slice());
        return;
    }
    for(let i = start; i < s.length; i++){
        if(isPalindrome(s, start, i)){
            current.push(s.substring(start, i + 1));
            backtrack(s, i + 1, current, result);
            current.pop();
        }
    }
}
function isPalindrome(s, i, j){
    while(i < j){
        if(s[i] != s[j]){
            return false;
        }
        i++;
        j--;
    }
    return true;
}

    