/**https://leetcode.com/problems/maximize-grid-happiness/ */
//You are given four integers, m, n, introvertsCount, and extrovertsCount. You have an m x n grid, and there are two types of people: introverts and extroverts. There are introvertsCount introverts and extrovertsCount extroverts.
//You should decide how many people you want to live in the grid and assign each of them one grid cell. Note that you do not have to have all the people living in the grid.
//The happiness of each person is calculated as follows:
//Introverts start with 120 happiness and lose 30 happiness for each neighbor (introvert or extrovert).
//Extroverts start with 40 happiness and gain 20 happiness for each neighbor (introvert or extrovert).
//Neighbors live in the directly adjacent cells north, east, south, and west of a person's cell.
//The grid happiness is the sum of each person's happiness. Return the maximum possible grid happiness.


/**
 * @param {number[]} nums
 * @param {number[]} quantity
 * @return {boolean}
 */
var canDistribute = function(nums, quantity) {
    let map = new Map();
    for(let i = 0; i < nums.length; i++){
        if(!map.has(nums[i])){
            map.set(nums[i], 1);
        }else{
            map.set(nums[i], map.get(nums[i]) + 1);
        }
    }
    let arr = Array.from(map.values());
    arr.sort((a, b) => b - a);
    quantity.sort((a, b) => b - a);
    return dfs(arr, quantity, 0);
};

    