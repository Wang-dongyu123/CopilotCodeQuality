package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/split-array-into-fibonacci-sequence/ */
//You are given a string of digits num, such as "123456579". We can split it into a Fibonacci-like sequence [123, 456, 579].
//Formally, a Fibonacci-like sequence is a list f of non-negative integers such that:
//	0 <= f[i] < 231, (that is, each integer fits in a 32-bit signed integer type),
//	f.length >= 3, and
//	f[i] + f[i + 1] == f[i + 2] for all 0 <= i < f.length - 2.
//Note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
//Return any Fibonacci-like sequence split from num, or return [] if it cannot be done.
// 
//Example 1:
//Input: num = "1101111"
//Output: [11,0,11,11]
//Explanation: The output [110, 1, 111] would also be accepted.
//Example 2:
//Input: num = "112358130"
//Output: []
//Explanation: The task is impossible.
//Example 3:
//Input: num = "0123"
//Output: []
//Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
// 
//Constraints:
//	1 <= num.length <= 200
//	num contains only digits.
class Solution572 {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList();
        dfs(num, 0, result);
        return result;
    }

    private boolean dfs(String num, int index, List<Integer> result) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }
            long temp = Long.parseLong(num.substring(index, i + 1));
            if (temp > Integer.MAX_VALUE) {
                break;
            }
            int size = result.size();
            if (size >= 2 && temp > result.get(size - 1) + result.get(size - 2)) {
                break;
            }
            if (size <= 1 || temp == result.get(size - 1) + result.get(size - 2)) {
                result.add((int)temp);
                if (dfs(num, i + 1, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}