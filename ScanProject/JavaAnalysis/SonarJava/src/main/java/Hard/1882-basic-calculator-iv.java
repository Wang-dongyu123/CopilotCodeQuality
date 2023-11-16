package main.java.Hard;

import java.util.*;

/**https://leetcode.com/problems/basic-calculator-iv/ */
//Given an expression such as expression = "e + 8 - a + 5" and an evaluation map such as {"e": 1} (given in terms of evalvars = ["e"] and evalints = [1]), return a list of tokens representing the simplified expression, such as ["-1*a","14"]
//	An expression alternates chunks and symbols, with a space separating each chunk and symbol.
//	A chunk is either an expression in parentheses, a variable, or a non-negative integer.
//	A variable is a string of lowercase letters (not including digits.) Note that variables can be multiple letters, and note that variables never have a leading coefficient or unary operator like "2x" or "-x".
//Expressions are evaluated in the usual order: brackets first, then multiplication, then addition and subtraction.
//	For example, expression = "1 + 2 * 3" has an answer of ["7"].
//The format of the output is as follows:
//	For each term of free variables with a non-zero coefficient, we write the free variables within a term in sorted order lexicographically.
//	
//		For example, we would never write a term like "b*a*c", only "a*b*c".
//	
//	
//	Terms have degrees equal to the number of free variables being multiplied, counting multiplicity. We write the largest degree terms of our answer first, breaking ties by lexicographic order ignoring the leading coefficient of the term.
//	
//		For example, "a*a*b*c" has degree 4.
//	
//	
//	The leading coefficient of the term is placed directly to the left with an asterisk separating it from the variables (if they exist.) A leading coefficient of 1 is still printed.
//	An example of a well-formatted answer is ["-2*a*a*a", "3*a*a*b", "3*b*b", "4*a", "5*c", "-6"].
//	Terms (including constant terms) with coefficient 0 are not included.
//	
//		For example, an expression of "0" has an output of [].
//	
//	
//Note: You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
// 
//Example 1:
//Input: expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
//Output: ["-1*a","14"]
//Example 2:
//Input: expression = "e - 8 + temperature - pressure", evalvars = ["e", "temperature"], evalints = [1, 12]
//Output: ["-1*pressure","5"]
//Example 3:
//Input: expression = "(e + 8) * (e - 8)", evalvars = [], evalints = []
//Output: ["1*e*e","-64"]
// 
//Constraints:
//	1 <= expression.length <= 250
//	expression consists of lowercase English letters, digits, '+', '-', '*', '(', ')', ' '.
//	expression does not contain any leading or trailing spaces.
//	All the tokens in expression are separated by a single space.
//	0 <= evalvars.length <= 100
//	1 <= evalvars[i].length <= 20
//	evalvars[i] consists of lowercase English letters.
//	evalints.length == evalvars.length
//	-100 <= evalints[i] <= 100
class Solution26 {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < evalvars.length; i++){
            map.put(evalvars[i], evalints[i]);
        }
        return helper(expression, map);
    }
    private List<String> helper(String expr, Map<String, Integer> map){
        List<String> res = new ArrayList<>();
        if(expr.charAt(0) != '('){
            if(Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-'){
                res.add(expr);
            }
            else{
                String val = map.containsKey(expr) ? String.valueOf(map.get(expr)) : "1*" + expr;
                res.add(val);
            }
            return res;
        }
        List<String> tokens = parse(expr.substring(1, expr.length() - 1));
        if(expr.startsWith("(a")){
            List<String> left = helper(tokens.get(0), map);
            List<String> right = helper(tokens.get(1), map);
            merge(res, left, right, map, true);
        }
        else if(expr.startsWith("(m")){
            List<String> left = helper(tokens.get(0), map);
            List<String> right = helper(tokens.get(1), map);
            merge(res, left, right, map, false);
        }
        else{
            for(int i = 0; i < tokens.size() - 2; i+=2){
                map.put(tokens.get(i), Integer.parseInt(tokens.get(i + 1)));
            }
            res = helper(tokens.get(tokens.size() - 1), map);
        }
        return res;
    }
    private List<String> parse(String expr){
        List<String> res = new ArrayList<>();
        int bal = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : expr.toCharArray()){
            if(c == '('){
                bal++;
            }
            if(c == ')'){
                bal--;
            }
            if(bal == 0 && c == ' '){
                res.add(sb.toString());
                sb = new StringBuilder();
            }
            else{
                sb.append(c);
            }
        }
        if(sb.length() > 0){
            res.add(sb.toString());
        }
        return res;
    }
    private void merge(List<String> res, List<String> left, List<String> right, Map<String, Integer> map, boolean isAdd){
        int i = 0;
        int j = 0;
        while(i < left.size() && j < right.size()){
            String s1 = left.get(i);
            String s2 = right.get(j);
            if(s1.equals(s2)){
                int val = isAdd ? map.getOrDefault(s1, 0) + map.getOrDefault(s2, 0) : map.getOrDefault(s1, 0) * map.getOrDefault(s2, 0);
                if(val != 0){
                    res.add(val + "*" + s1);
                }
                i++;
                j++;
            }
            else if(isGreater(s1, s2)){
                res.add(s1);
                i++;
            }
            else{
                res.add(s2);
                j++;
            }
        }
        while(i < left.size()){
            res.add(left.get(i++));
        }
        while(j < right.size()){
            res.add(right.get(j++));
        }
    }
    private boolean isGreater(String s1, String s2){
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                return s1.charAt(i) > s2.charAt(j);
            }
            i++;
            j++;
        }
        return s1.length() > s2.length();
    }
}