/**https://leetcode.com/problems/longest-duplicate-substring/ */
//Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.
//Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".


/**
 * @param {string} s
 * @return {string}
 */
var longestDupSubstring = function(s) {
    let n = s.length;
    let a = 26;
    let mod = 2**32;
    let left = 1;
    let right = n;
    let ans = '';
    while(left <= right){
        let mid = Math.floor((left + right) / 2);
        let found = rabinKarp(s, mid, a, mod);
        if(found != -1){
            ans = s.substring(found, found + mid);
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
    }
    return ans;
    
    
};
function rabinKarp(s, len, a, mod){
    let h = 0;
    let aL = 1;
    for(let i = 0; i < len; i++){
        h = (h * a + s.charCodeAt(i)) % mod;
        aL = (aL * a) % mod;
    }
    let seen = new Set();
    seen.add(h);
    for(let i = 1; i <= s.length - len; i++){
        h = (h * a - s.charCodeAt(i - 1) * aL % mod + mod) % mod;
        h = (h + s.charCodeAt(i + len - 1)) % mod;
        if(seen.has(h)){
            return i;
        }
        seen.add(h);
    }
    return -1;
}

    