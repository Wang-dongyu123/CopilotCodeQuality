package main.java.Hard;

/**https://leetcode.com/problems/building-boxes/ */
//You have a cubic storeroom where the width, length, and height of the room are all equal to n units. You are asked to place n boxes in this room where each box is a cube of unit side length. There are however some rules to placing the boxes:
//You can place the boxes anywhere on the floor.
//If box x is placed on top of the box y, then each side of the four vertical sides of the box y must either be adjacent to another box or to a wall.
//Given an integer n, return the minimum possible number of boxes touching the floor.


class BuildingBoxes {
    public int minimumBoxes(int n) {
        int res = 0;
        int i = 1;
        while(n > 0){
            n -= i;
            res += i;
            i++;
        }
        if(n < 0){
            res += n;
        }
        return res;
        
    }
}
     
    