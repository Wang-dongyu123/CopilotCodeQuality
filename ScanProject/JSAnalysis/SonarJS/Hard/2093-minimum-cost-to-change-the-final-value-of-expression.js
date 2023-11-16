/**https://leetcode.com/problems/minimum-cost-to-change-the-final-value-of-expression/ */
//You are given a valid boolean expression as a string expression consisting of the characters '1','0','&' (bitwise AND operator),'|' (bitwise OR operator),'(', and ')'.
//For example, "()1|1" and "(1)&()" are not valid while "1", "(((1))|(0))", and "1|(0&(1))" are valid expressions.
//Return the minimum cost to change the final value of the expression.
//For example, if expression = "1|1|(0&0)&1", its value is 1|1|(0&0)&1 = 1|1|0&1 = 1|0&1 = 1&1 = 1. We want to apply operations so that the new expression evaluates to 0.
//The cost of changing the final value of an expression is the number of operations performed on the expression. The types of operations are described as follows:
//Turn a '1' into a '0'.
//Turn a '0' into a '1'.
//Turn a '&' into a '|'.
//Turn a '|' into a '&'.
//Note: '&' does not take precedence over '|' in the order of calculation. Evaluate parentheses first, then in left-to-right order.


/**
 * @param {string} expression
 * @return {number}
 */
var minOperationsToFlip = function(expression) {
    let result = 0;
    let map = new Map();
    for (let i = 0; i < expression.length; i++) {
        let char = expression[i];
        if (char === '(') {
            let count = 1;
            let j = i + 1;
            while (j < expression.length) {
                if (expression[j] === '(') {
                    count++;
                } else if (expression[j] === ')') {
                    count--;
                }
                if (count === 0) {
                    break;
                }
                j++;
            }
            let sub = expression.substring(i + 1, j);
            let subResult = minOperationsToFlip(sub);
            result += subResult;
            i = j;
        } else if (char === '1') {
            result++;
        }
    }
    return result;
    
    
};

    