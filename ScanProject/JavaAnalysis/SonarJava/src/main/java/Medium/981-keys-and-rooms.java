package main.java.Medium;

import java.util.List;

/**https://leetcode.com/problems/keys-and-rooms/ */
//There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
//When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
//Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.


class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
        
        
    }
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited){
        if(visited[room]){
            return;
        }
        visited[room] = true;
        for(int key : rooms.get(room)){
            dfs(rooms, key, visited);
        }
    }
}

    