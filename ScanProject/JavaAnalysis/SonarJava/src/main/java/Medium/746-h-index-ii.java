package main.java.Medium;

/**https://leetcode.com/problems/h-index-ii/ */
//Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in ascending order, return the researcher's h-index.
//According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
//You must write an algorithm that runs in logarithmic time.
// 
//Example 1:
//Input: citations = [0,1,3,5,6]
//Output: 3
//Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
//Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
//Example 2:
//Input: citations = [1,2,100]
//Output: 2
// 
//Constraints:
//	n == citations.length
//	1 <= n <= 105
//	0 <= citations[i] <= 1000
//	citations is sorted in ascending order.
class Solution468 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0, r = len - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(citations[mid] == len - mid) return len - mid;
            else if(citations[mid] > len - mid) r = mid - 1;
            else l = mid + 1;
        }
        return len - l;
    }
}