/**https://leetcode.com/problems/word-search-ii/ */
//Given an m x n board of characters and a list of strings words, return all words on the board.
//Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.


/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    let result = [];
    let trie = new Trie();
    for(let i = 0; i < words.length; i++){
        trie.insert(words[i]);
    }
    for(let i = 0; i < board.length; i++){
        for(let j = 0; j < board[0].length; j++){
            dfs(board, i, j, trie.root, result);
        }
    }
    return result;
    
    
};
function dfs(board, i, j, node, result){
    let c = board[i][j];
    if(c === "#" || !node.children.has(c)){
        return;
    }
    node = node.children.get(c);
    if(node.word != null){
        result.push(node.word);
        node.word = null;
    }
    board[i][j] = "#";
    if(i > 0){
        dfs(board, i - 1, j, node, result);
    }
    if(j > 0){
        dfs(board, i, j - 1, node, result);
    }
    if(i < board.length - 1){
        dfs(board, i + 1, j, node, result);
    }
    if(j < board[0].length - 1){
        dfs(board, i, j + 1, node, result);
    }
    board[i][j] = c;
}
class TrieNode{
    constructor(){
        this.children = new Map();
        this.word = null;
    }
}
class Trie{
    constructor(){
        this.root = new TrieNode();
    }
    insert(word){
        let node = this.root;
        for(let i = 0; i < word.length; i++){
            let c = word[i];
            if(!node.children.has(c)){
                node.children.set(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.word = word;
    }
}

    