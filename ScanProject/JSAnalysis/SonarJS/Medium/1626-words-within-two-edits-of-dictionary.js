/**https://leetcode.com/problems/words-within-two-edits-of-dictionary/ */
//You are given two string arrays, queries and dictionary. All words in each array comprise of lowercase English letters and have the same length.
//In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
//Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits. Return the words in the same order they appear in queries.


/**
 * @param {string[]} queries
 * @param {string[]} dictionary
 * @return {string[]}
 */
var twoEditWords = function(queries, dictionary) {
    let set = new Set(dictionary);
    let result = [];
    for (let i = 0; i < queries.length; i++) {
        let query = queries[i];
        if (set.has(query)) {
            result.push(query);
        } else {
            if (oneEdit(query, set)) {
                result.push(query);
            }
        }
    }
    return result;
    
    
    
};
function oneEdit(query, set) {
    for (let i = 0; i < query.length; i++) {
        for (let j = 0; j < 26; j++) {
            let cur = String.fromCharCode(97 + j);
            let newStr = query.substring(0, i) + cur + query.substring(i + 1, query.length);
            if (set.has(newStr)) {
                return true;
            }
        }
    }
    for (let i = 0; i < query.length - 1; i++) {
        let newStr = query.substring(0, i) + query.substring(i + 1, i + 2) + query.substring(i, i + 1) + query.substring(i + 2, query.length);
        if (set.has(newStr)) {
            return true;
        }
    }
    return false;
}
    