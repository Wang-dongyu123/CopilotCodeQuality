package main.java.Medium;

/**https://leetcode.com/problems/count-and-say/ */
//The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//countAndSay(1) = "1"
//countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
//To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
//For example, the saying and conversion for digit string "3322251":
// 


class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            res = helper(res);
        }
        return res;
        
        
    }
    private String helper(String s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            int count = 0;
            while(i < s.length() && s.charAt(i) == c){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(c);
        }
        return sb.toString();
    }
}

    