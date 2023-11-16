/**https://leetcode.com/problems/valid-parenthesis-string/ */
//Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//The following rules define a valid string:
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    let left = 0;
    let right = 0;
    for(let i = 0; i < s.length; i++){
        if(s[i] == "("){
            left++;
            right++;
        }else if(s[i] == ")"){
            left--;
            right--;
        }else{
            left--;
            right++;
        }
        if(right < 0){
            return false;
        }
        left = Math.max(left, 0);
    }
    return left == 0;
    
};

    