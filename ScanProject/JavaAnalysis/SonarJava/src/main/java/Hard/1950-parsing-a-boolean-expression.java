package main.java.Hard;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/parsing-a-boolean-expression/ */
//A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
//	't' that evaluates to true.
//	'f' that evaluates to false.
//	'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
//	'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//	'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
//Given a string expression that represents a boolean expression, return the evaluation of that expression.
//It is guaranteed that the given expression is valid and follows the given rules.
// 
//Example 1:
//Input: expression = "&(|(f))"
//Output: false
//Explanation: 
//First, evaluate |(f) --> f. The expression is now "&(f)".
//Then, evaluate &(f) --> f. The expression is now "f".
//Finally, return false.
//Example 2:
//Input: expression = "|(f,f,f,t)"
//Output: true
//Explanation: The evaluation of (false OR false OR false OR true) is true.
//Example 3:
//Input: expression = "!(&(f,t))"
//Output: true
//Explanation: 
//First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
//Then, evaluate !(f) --> NOT false --> true. We return true.
// 
//Constraints:
//	1 <= expression.length <= 2 * 104
//	expression[i] is one following characters: '(', ')', '&', '|', '!', 't', 'f', and ','.
class Solution39 {
    public boolean parseBoolExpr(String expression) {
        return helper(expression, 0, expression.length() - 1);
    }
    
    private boolean helper(String s, int l, int r) {
        if (l == r) {
            return s.charAt(l) == 't';
        }
        char op = s.charAt(l);
        int start = l + 2;
        List<Boolean> operands = new ArrayList<>();
        for (int i = l + 2, cnt = 0; i <= r; i++) {
            if (cnt == 0 && s.charAt(i) == ',') {
                operands.add(helper(s, start, i - 1));
                start = i + 1;
            } else if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        operands.add(helper(s, start, r - 1));
        if (op == '!') {
            return !operands.get(0);
        } else if (op == '&') {
            for (boolean operand : operands) {
                if (!operand) {
                    return false;
                }
            }
            return true;
        } else {
            for (boolean operand : operands) {
                if (operand) {
                    return true;
                }
            }
            return false;
        }
    }
    }
