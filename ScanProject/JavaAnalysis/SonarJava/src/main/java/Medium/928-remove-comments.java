package main.java.Medium;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/remove-comments/ */
//Given a C++ program, remove comments from it. The program source is an array of strings source where source[i] is the ith line of the source code. This represents the result of splitting the original source code string by the newline character '
//'.
//In C++, there are two types of comments, line comments, and block comments.
//The string "//" denotes a line comment, which represents that it and the rest of the characters to the right of it in the same line should be ignored.
//The string "/*" denotes a block comment, which represents that all characters until the next (non-overlapping) occurrence of "*/" should be ignored. (Here, occurrences happen in reading order: line by line from left to right.) To be clear, the string "/*/" does not yet end the block comment, as the ending would be overlapping the beginning.
//The first effective comment takes precedence over others.
//For example, if the string "//" occurs in a block comment, it is ignored.
//Similarly, if the string "/*" occurs in a line or block comment, it is also ignored.
//If a certain line of code is empty after removing comments, you must not output that line: each string in the answer list will be non-empty.
//There will be no control characters, single quote, or double quote characters.
//For example, source = "string s = "/* Not a comment. */";" will not be a test case.
//Also, nothing else such as defines or macros will interfere with the comments.
//It is guaranteed that every open block comment will eventually be closed, so "/*" outside of a line or block comment always starts a new comment.
//Finally, implicit newline characters can be deleted by block comments. Please see the examples below for details.
//After removing the comments from the source code, return the source code in the same format.


class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        for(String line : source){
            int i = 0;
            char[] chars = line.toCharArray();
            if(!inBlock){
                sb = new StringBuilder();
            }
            while(i < chars.length){
                if(!inBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*'){
                    inBlock = true;
                    i++;
                }else if(inBlock && i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/'){
                    inBlock = false;
                    i++;
                }else if(!inBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/'){
                    break;
                }else if(!inBlock){
                    sb.append(chars[i]);
                }
                i++;
            }
            if(!inBlock && sb.length() > 0){
                res.add(sb.toString());
            }
        }
        return res;
        
    }
}

    