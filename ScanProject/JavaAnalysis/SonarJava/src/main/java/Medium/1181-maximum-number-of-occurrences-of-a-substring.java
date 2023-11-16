package main.java.Medium;

/**https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/ */
//Given a string s, return the maximum number of ocurrences of any substring under the following rules:
//The number of unique characters in the substring must be less than or equal to maxLetters.
//The substring size must be between minSize and maxSize inclusive.


class MaximumNumberOfOccurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        int[] count = new int[26];
        int res = 0;
        int unique = 0;
        for(int i = 0; i < n; i++){
            if(count[s.charAt(i) - 'a']++ == 0){
                unique++;
            }
            if(i >= minSize && count[s.charAt(i - minSize) - 'a']-- == 1){
                unique--;
            }
            if(i >= minSize - 1 && unique <= maxLetters){
                res = Math.max(res, count(s, s.substring(i - minSize + 1, i + 1), minSize));
            }
        }
        return res;
        
    }
    public int count(String s, String word, int minSize){
        int res = 0;
        for(int i = 0; i <= s.length() - minSize; i++){
            if(s.substring(i, i + minSize).equals(word)){
                res++;
            }
        }
        return res;
    }
}

    