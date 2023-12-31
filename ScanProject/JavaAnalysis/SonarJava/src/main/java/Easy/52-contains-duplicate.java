package main.java.Easy;

import java.util.HashSet;
import java.util.Set;

/**https://leetcode.com/problems/contains-duplicate/ */
//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.


class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
        
    }
}

    