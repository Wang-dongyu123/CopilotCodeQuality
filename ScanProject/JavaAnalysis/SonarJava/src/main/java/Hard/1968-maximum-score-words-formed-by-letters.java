package main.java.Hard;

/**https://leetcode.com/problems/maximum-score-words-formed-by-letters/ */
//Given a list of words, list of  single letters (might be repeating) and score of every character.
//Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).
//It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.


class MaximumScoreWordsFormedByLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return dfs(words, count, score, 0);
        
    }
    public int dfs(String[] words, int[] count, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }
        int res = 0;
        int[] temp = count.clone();
        boolean isValid = true;
        for (char c : words[idx].toCharArray()) {
            temp[c - 'a']--;
            if (temp[c - 'a'] < 0) {
                isValid = false;
            }
            res += score[c - 'a'];
        }
        if (isValid) {
            res += dfs(words, temp, score, idx + 1);
        }
        res = Math.max(res, dfs(words, count, score, idx + 1));
        return res;
    }
}
     
    