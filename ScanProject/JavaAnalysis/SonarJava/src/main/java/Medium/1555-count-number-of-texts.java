package main.java.Medium;

/**https://leetcode.com/problems/count-number-of-texts/ */
//Alice is texting Bob using her phone. The mapping of digits to letters is shown in the figure below.
//In order to add a letter, Alice has to press the key of the corresponding digit i times, where i is the position of the letter in the key.
//	For example, to add the letter 's', Alice has to press '7' four times. Similarly, to add the letter 'k', Alice has to press '5' twice.
//	Note that the digits '0' and '1' do not map to any letters, so Alice does not use them.
//However, due to an error in transmission, Bob did not receive Alice's text message but received a string of pressed keys instead.
//	For example, when Alice sent the message "bob", Bob received the string "2266622".
//Given a string pressedKeys representing the string received by Bob, return the total number of possible text messages Alice could have sent.
//Since the answer may be very large, return it modulo 109 + 7.
// 
//Example 1:
//Input: pressedKeys = "22233"
//Output: 8
//Explanation:
//The possible text messages Alice could have sent are:
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae", and "ce".
//Since there are 8 possible messages, we return 8.
//Example 2:
//Input: pressedKeys = "222222222222222222222222222222222222"
//Output: 82876089
//Explanation:
//There are 2082876103 possible text messages Alice could have sent.
//Since we need to return the answer modulo 109 + 7, we return 2082876103 % (109 + 7) = 82876089.
// 
//Constraints:
//	1 <= pressedKeys.length <= 105
//	pressedKeys only consists of digits from '2' - '9'.
class Solution312 {
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int mod = (int)1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (pressedKeys.charAt(j) != pressedKeys.charAt(i - 1)) {
                    break;
                }
                count += dp[j];
            }
            dp[i] = (count + 1) % mod;
        }
        return (int)dp[n];
    }
}