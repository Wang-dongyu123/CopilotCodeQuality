package main.java.Hard;

import java.util.ArrayList;
import java.util.List;

/**https://leetcode.com/problems/count-of-smaller-numbers-after-self/ */
//Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].


class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        int[] counts = new int[n];
        mergeSort(nums, indexes, counts, 0, n - 1);
        List<Integer> ans = new ArrayList<Integer>();
        for (int count : counts) {
            ans.add(count);
        }
        return ans;
        
        
    }
    private void mergeSort(int[] nums, int[] indexes, int[] counts, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, counts, start, mid);
        mergeSort(nums, indexes, counts, mid + 1, end);
        merge(nums, indexes, counts, start, end);
    }
    private void merge(int[] nums, int[] indexes, int[] counts, int start, int end) {
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int rightCount = 0;
        int[] newIndexes = new int[end - start + 1];
        int sortIndex = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[indexes[rightIndex]] < nums[indexes[leftIndex]]) {
                newIndexes[sortIndex] = indexes[rightIndex];
                rightCount++;
                rightIndex++;
            } else {
                newIndexes[sortIndex] = indexes[leftIndex];
                counts[indexes[leftIndex]] += rightCount;
                leftIndex++;
            }
            sortIndex++;
        }
        while (leftIndex <= mid) {
            newIndexes[sortIndex] = indexes[leftIndex];
            counts[indexes[leftIndex]] += rightCount;
            leftIndex++;
            sortIndex++;
        }
        while (rightIndex <= end) {
            newIndexes[sortIndex++] = indexes[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }
}
     
    