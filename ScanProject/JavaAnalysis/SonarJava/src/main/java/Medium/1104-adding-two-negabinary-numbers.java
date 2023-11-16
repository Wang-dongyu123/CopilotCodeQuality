package main.java.Medium;

import java.util.Arrays;

/**https://leetcode.com/problems/adding-two-negabinary-numbers/ */
//Given two numbers arr1 and arr2 in base -2, return the result of adding them together.
//Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.  For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array, format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
//Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.
// 
//Example 1:
//Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
//Output: [1,0,0,0,0]
//Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.
//Example 2:
//Input: arr1 = [0], arr2 = [0]
//Output: [0]
//Example 3:
//Input: arr1 = [0], arr2 = [1]
//Output: [1]
// 
//Constraints:
//	1 <= arr1.length, arr2.length <= 1000
//	arr1[i] and arr2[i] are 0 or 1
//	arr1 and arr2 have no leading zeros
class Solution16 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[Math.max(n, m)+2];
        int i=n-1, j=m-1, k=res.length-1;
        int carry = 0;
        while(i>=0 || j>=0 || carry!=0) {
            if(i>=0) {
                carry += arr1[i--];
            }
            if(j>=0) {
                carry += arr2[j--];
            }
            res[k--] = carry & 1;
            carry = -(carry >> 1);
        }
        while(k<res.length-1 && res[k+1] == 0) {
            k++;
        }
        return Arrays.copyOfRange(res, k, res.length);
    } 

}