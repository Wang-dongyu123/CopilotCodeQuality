package main.java.Medium;

/**https://leetcode.com/problems/expressive-words/ */
//Sometimes people repeat letters to represent extra feeling. For example:
//"hello" -> "heeellooo"
//"hi" -> "hiiii"
//In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".
//You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.
//For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
//Return the number of query strings that are stretchy.


class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for(String word : words){
            if(isStretchy(s, word)){
                res++;
            }
        }
        return res;
        
        
    }
    public boolean isStretchy(String s, String word){
        int n = s.length();
        int m = word.length();
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(s.charAt(i) != word.charAt(j)){
                return false;
            }
            int len1 = count(s, i);
            int len2 = count(word, j);
            if(len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2){
                return false;
            }
            i += len1;
            j += len2;
        }
        return i == n && j == m;
    }
    public int count(String s, int idx){
        int i = idx + 1;
        while(i < s.length() && s.charAt(i) == s.charAt(idx)){
            i++;
        }
        return i - idx;
    }
}

    