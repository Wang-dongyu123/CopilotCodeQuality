/**https://leetcode.com/problems/restore-ip-addresses/ */
//A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.


/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    let result = [];
    if(s.length < 4 || s.length > 12){
        return result;
    }
    let current = [];
    helper(s, 0, current, result);
    return result;
    
    
    
};
function helper(s, index, current, result){
    if(current.length == 4){
        if(index == s.length){
            result.push(current.join("."));
        }
        return;
    }
    for(let i = index; i < s.length; i++){
        if(i > index && s[index] == "0"){
            break;
        }
        let temp = s.substring(index, i + 1);
        if(temp.length > 3 || parseInt(temp) > 255){
            break;
        }
        current.push(temp);
        helper(s, i + 1, current, result);
        current.pop();
    }
}

    