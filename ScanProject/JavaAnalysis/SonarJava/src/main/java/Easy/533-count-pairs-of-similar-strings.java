package main.java.Easy;

/**https://leetcode.com/problems/count-pairs-of-similar-strings/ */
//You are given a 0-indexed string array words.
//Two strings are similar if they consist of the same characters.
//For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
//However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
//Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and the two strings words[i] and words[j] are similar.


class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if (isSimilar(word1, word2)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isSimilar(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    
    


}

    