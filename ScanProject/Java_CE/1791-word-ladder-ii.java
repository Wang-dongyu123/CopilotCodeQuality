package main.java.Hard;

/**https://leetcode.com/problems/word-ladder-ii/ */
//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].


class WordLadderIi {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, dict, map, distance);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, map, distance, path, res);
        return res;
        
    }
    private void dfs(String cur, String endWord, Map<String, List<String>> map, Map<String, Integer> distance, List<String> path, List<List<String>> res) {
        if (cur.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (String next : map.getOrDefault(cur, new ArrayList<>())) {
            if (distance.get(next) == distance.get(cur) + 1) {
                path.add(next);
                dfs(next, endWord, map, distance, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> map, Map<String, Integer> distance) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        distance.put(beginWord, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<>());
        }
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (String next : getNext(cur, dict)) {
                map.get(next).add(cur);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(cur) + 1);
                    q.offer(next);
                }
            }
        }
    }
    private List<String> getNext(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] array = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (array[i] == c) continue;
                array[i] = c;
                String next = new String(array);
                if (dict.contains(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }
}
     
    