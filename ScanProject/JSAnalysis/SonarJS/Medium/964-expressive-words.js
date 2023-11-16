/**https://leetcode.com/problems/expressive-words/ */
//Sometimes people repeat letters to represent extra feeling. For example:
//"hello" -> "heeellooo"
//"hi" -> "hiiii"
//In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
//You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.
//For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
//Return the number of query strings that are stretchy.


/**
 * @param {string} s
 * @param {string[]} words
 * @return {number}
 */
var expressiveWords = function(s, words) {
    let result = 0;
    for(let i = 0; i < words.length; i++){
        if(isStretchy(s, words[i])){
            result++;
        }
    }
    return result;
    
    
    
};
function isStretchy(s1, s2){
    if(s1.length < s2.length){
        return false;
    }
    let i = 0;
    let j = 0;
    while(i < s1.length && j < s2.length){
        if(s1[i] != s2[j]){
            return false;
        }
        let count1 = 0;
        let count2 = 0;
        let char = s1[i];
        while(i < s1.length && s1[i] == char){
            count1++;
            i++;
        }
        while(j < s2.length && s2[j] == char){
            count2++;
            j++;
        }
        if(count1 < count2){
            return false;
        }
        if(count1 != count2 && count1 < 3){
            return false;
        }
    }
    if(i != s1.length || j != s2.length){
        return false;
    }
    return true;
}

    