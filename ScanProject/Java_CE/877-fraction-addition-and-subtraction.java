package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/fraction-addition-and-subtraction/ */
//Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
//The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
// 
//Example 1:
//Input: expression = "-1/2+1/2"
//Output: "0/1"
//Example 2:
//Input: expression = "-1/2+1/2+1/3"
//Output: "1/3"
//Example 3:
//Input: expression = "1/3-1/2"
//Output: "-1/6"
// 
//Constraints:
//	The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
//	Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
//	The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
//	The number of given fractions will be in the range [1, 10].
//	The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
class Solution528 {
    public String fractionAddition(String expression) {
        List<int[]> list = new ArrayList<>();
        int n = expression.length();
        int i = 0;
        while (i < n) {
            int[] fraction = new int[2];
            int j = i;
            while (j < n && expression.charAt(j) != '/') {
                j++;
            }
            fraction[0] = Integer.parseInt(expression.substring(i, j));
            i = j + 1;
            j = i;
            while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            fraction[1] = Integer.parseInt(expression.substring(i, j));
            if (expression.charAt(i - 1) == '-') {
                fraction[0] = -fraction[0];
            }
            list.add(fraction);
            i = j;
        }
        int[] res = new int[2];
        for (int[] fraction : list) {
            res = add(res, fraction);
        }
        return res[0] + "/" + res[1];
    }

    private int[] add(int[] fraction1, int[] fraction2) {
        int numerator = fraction1[0] * fraction2[1] + fraction1[1] * fraction2[0];
        int denominator = fraction1[1] * fraction2[1];
        return new int[]{numerator, denominator};
    }
}
    
