package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/the-k-strongest-values-in-an-array/ */
//Given an array of integers arr and an integer k.
//A value arr[i] is said to be stronger than a value arr[j] if |arr[i] - m| > |arr[j] - m| where m is the median of the array.
//If |arr[i] - m| == |arr[j] - m|, then arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].
//Return a list of the strongest k values in the array. return the answer in any arbitrary order.
//Median is the middle value in an ordered integer list. More formally, if the length of the list is n, the median is the element in position ((n - 1) / 2) in the sorted list (0-indexed).
//For arr = [6, -3, 7, 2, 11], n = 5 and the median is obtained by sorting the array arr = [-3, 2, 6, 7, 11] and the median is arr[m] where m = ((5 - 1) / 2) = 2. The median is 6.
//For arr = [-7, 22, 17,3], n = 4 and the median is obtained by sorting the array arr = [-7, 3, 17, 22] and the median is arr[m] where m = ((4 - 1) / 2) = 1. The median is 3.


class TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int[] result = new int[k];
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while(count < k){
            if(Math.abs(arr[left] - median) > Math.abs(arr[right] - median)){
                result[count] = arr[left];
                left++;
            }else{
                result[count] = arr[right];
                right--;
            }
            count++;
        }
        return result;
        
    }
}

    