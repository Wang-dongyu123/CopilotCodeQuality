package main.java.Hard;

/**https://leetcode.com/problems/word-search-ii/ */
//Given an m x n board of characters and a list of strings words, return all words on the board.
//Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.


class WordSearchIi {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, ans);
            }
        }
        return ans;
        

        
    }
    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode root, List<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;
        char c = board[i][j];
        if (root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        visited[i][j] = true;
        dfs(board, visited, i + 1, j, root, ans);
        dfs(board, visited, i, j + 1, root, ans);
        dfs(board, visited, i - 1, j, root, ans);
        dfs(board, visited, i, j - 1, root, ans);
        visited[i][j] = false;
    }

}
class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.word = word;
        }
    }

     
    