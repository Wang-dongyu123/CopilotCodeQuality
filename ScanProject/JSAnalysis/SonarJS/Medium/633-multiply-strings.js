/**https://leetcode.com/problems/multiply-strings/ */
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.


/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    let result = [];
    let carry = 0;
    for(let i = num1.length - 1; i >= 0; i--){
        let current = [];
        for(let j = num2.length - 1; j >= 0; j--){
            let product = (num1[i] - '0') * (num2[j] - '0') + carry;
            carry = Math.floor(product / 10);
            current.unshift(product % 10);
        }
        if(carry > 0){
            current.unshift(carry);
            carry = 0;
        }
        for(let k = 0; k < num1.length - 1 - i; k++){
            current.push(0);
        }
        result = add(result, current);
    }
    return result.join('');
    
    
};
function add(num1, num2){
    let result = [];
    let carry = 0;
    let i = num1.length - 1;
    let j = num2.length - 1;
    while(i >= 0 && j >= 0){
        let sum = num1[i] + num2[j] + carry;
        carry = Math.floor(sum / 10);
        result.unshift(sum % 10);
        i--;
        j--;
    }
    while(i >= 0){
        let sum = num1[i] + carry;
        carry = Math.floor(sum / 10);
        result.unshift(sum % 10);
        i--;
    }
    while(j >= 0){
        let sum = num2[j] + carry;
        carry = Math.floor(sum / 10);
        result.unshift(sum % 10);
        j--;
    }
    if(carry > 0){
        result.unshift(carry);
    }
    return result;
}
    