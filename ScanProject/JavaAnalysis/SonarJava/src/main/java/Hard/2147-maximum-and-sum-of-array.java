package main.java.Hard;

/**https://leetcode.com/problems/maximum-and-sum-of-array/ */
//You are given an integer array nums of length n and an integer numSlots such that 2 * numSlots >= n. There are numSlots slots numbered from 1 to numSlots.
//You have to place all n integers into the slots such that each slot contains at most two numbers. The AND sum of a given placement is the sum of the bitwise AND of every number with its respective slot number.
//For example, the AND sum of placing the numbers [1, 3] into slot 1 and [4, 6] into slot 2 is equal to (1 AND 1) + (3 AND 1) + (4 AND 2) + (6 AND 2) = 1 + 1 + 0 + 2 = 4.
//Return the maximum possible AND sum of nums given numSlots slots.


class MaximumAndSumOfArray {
    public int maximumANDSum(int[] nums, int numSlots) { 
        // 1. Find the maximum number in the array
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        
        // 2. Find the sum of all numbers in the array
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        // 3. Find the number of trailing zeros in the maximum number
        int trailingZeros = 0;
        while(max % 2 == 0){
            trailingZeros++;
            max /= 2;
        }
        
        // 4. Find the number of slots that are not empty
        int nonEmptySlots = numSlots - (int) Math.pow(2, trailingZeros);
        
        // 5. Find the sum of all numbers in the array multiplied by the number of slots that are not empty
        int res = sum * (int) Math.pow(2, nonEmptySlots);
        
        // 6. Find the sum of all numbers in the array multiplied by the number of slots that are not empty and the maximum number in the array
        for(int num : nums){
            res += num * (int) Math.pow(2, nonEmptySlots - 1);
        }
        
        return res;
        
    }
}
     
    