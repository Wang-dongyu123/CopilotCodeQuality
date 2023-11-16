package main.java.Hard;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/cracking-the-safe/ */
//There is a safe protected by a password. The password is a sequence of n digits where each digit can be in the range [0, k - 1].
//The safe has a peculiar way of checking the password. When you enter in a sequence, it checks the most recent n digits that were entered each time you type a digit.
//	For example, the correct password is "345" and you enter in "012345":
//	
//		After typing 0, the most recent 3 digits is "0", which is incorrect.
//		After typing 1, the most recent 3 digits is "01", which is incorrect.
//		After typing 2, the most recent 3 digits is "012", which is incorrect.
//		After typing 3, the most recent 3 digits is "123", which is incorrect.
//		After typing 4, the most recent 3 digits is "234", which is incorrect.
//		After typing 5, the most recent 3 digits is "345", which is correct and the safe unlocks.
//	
//	
//Return any string of minimum length that will unlock the safe at some point of entering it.
// 
//Example 1:
//Input: n = 1, k = 2
//Output: "10"
//Explanation: The password is a single digit, so enter each digit. "01" would also unlock the safe.
//Example 2:
//Input: n = 2, k = 2
//Output: "01100"
//Explanation: For each possible password:
//- "00" is typed in starting from the 4th digit.
//- "01" is typed in starting from the 1st digit.
//- "10" is typed in starting from the 3rd digit.
//- "11" is typed in starting from the 2nd digit.
//Thus "01100" will unlock the safe. "10011", and "11001" would also unlock the safe.
// 
//Constraints:
//	1 <= n <= 4
//	1 <= k <= 10
//	1 <= kn <= 4096
class Solution24 {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("0");
        }
        int total = (int)Math.pow(k, n);
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, visited, total, n, k);
        return sb.toString();
    }
    private boolean dfs(StringBuilder sb, Set<String> visited, int total, int n, int k){
        if(visited.size() == total){
            return true;
        }
        String prev = sb.substring(sb.length() - n + 1);
        for(int i = 0; i < k; i++){
            String next = prev + i;
            if(!visited.contains(next)){
                sb.append(i);
                visited.add(next);
                if(dfs(sb, visited, total, n, k)){
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(next);
            }
        }
        return false;
    }
}