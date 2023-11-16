/**https://leetcode.com/problems/stamping-the-sequence/ */
//You are given two strings stamp and target. Initially, there is a string s of length target.length with all s[i] == '?'.
//In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.
//For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:
//place stamp at index 0 of s to obtain "abc??",
//place stamp at index 1 of s to obtain "?abc?", or
//place stamp at index 2 of s to obtain "??abc".
//Note that stamp must be fully contained in the boundaries of s in order to stamp (i.e., you cannot place stamp at index 3 of s).
//We want to convert s to target using at most 10 * target.length turns.
//Return an array of the index of the left-most letter being stamped at each turn. If we cannot obtain target from s within 10 * target.length turns, return an empty array.


/**
 * @param {string} stamp
 * @param {string} target
 * @return {number[]}
 */
var movesToStamp = function(stamp, target) {
    
        let result = [];
        let done = new Array(target.length).fill(false);
        let stars = 0;
        while(stars < target.length){
            let stampFound = false;
            for(let size = target.length; size > 0; size--){
                for(let i = 0; i <= target.length - size; i++){
                    if(!done[i] && canStamp(stamp, target.substring(i, i + size), i, result)){
                        stars = doStamp(target, i, size, stars);
                        stampFound = true;
                        done[i] = true;
                        break;
                    }
                }
                if(stampFound){
                    break;
                }
            }
            if(!stampFound){
                return [];
            }
        }
        reverse(result);
        return result;
    
};

    