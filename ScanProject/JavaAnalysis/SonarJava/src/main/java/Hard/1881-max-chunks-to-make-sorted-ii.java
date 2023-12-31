package main.java.Hard;

/**https://leetcode.com/problems/max-chunks-to-make-sorted-ii/ */
//You are given an integer array arr.
//We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
//Return the largest number of chunks we can make to sort the array.


class MaxChunksToMakeSortedIi {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = arr[0];
        min[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
            min[n - i - 1] = Math.min(min[n - i], arr[n - i - 1]);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (max[i] <= min[i + 1]) {
                ans++;
            }
        }
        return ans;
        
    }
}
     
    