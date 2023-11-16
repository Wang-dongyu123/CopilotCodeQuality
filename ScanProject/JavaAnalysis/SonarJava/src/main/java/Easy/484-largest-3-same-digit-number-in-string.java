package main.java.Easy;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/largest-3-same-digit-number-in-string/ */
//You are given a string num representing a large integer. An integer is good if it meets the following conditions:
//	It is a substring of num with length 3.
//	It consists of only one unique digit.
//Return the maximum good integer as a string or an empty string "" if no such integer exists.
//Note:
//	A substring is a contiguous sequence of characters within a string.
//	There may be leading zeroes in num or a good integer.
// 
//Example 1:
//Input: num = "6777133339"
//Output: "777"
//Explanation: There are two distinct good integers: "777" and "333".
//"777" is the largest, so we return "777".
//Example 2:
//Input: num = "2300019"
//Output: "000"
//Explanation: "000" is the only good integer.
//Example 3:
//Input: num = "42352338"
//Output: ""
//Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
// 
//Constraints:
//	3 <= num.length <= 1000
//	num only consists of digits.
class Solution294 {
    public String largestGoodInteger(String num) {
        int n = num.length();
        for (int i = n - 3; i >= 0; i--) {
            String s = num.substring(i, i + 3);
            if (isGood(s)) return s;
        }
        return "";
    }
    private boolean isGood(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(s.charAt(i));
        }
        return set.size() == 1;
    }
}