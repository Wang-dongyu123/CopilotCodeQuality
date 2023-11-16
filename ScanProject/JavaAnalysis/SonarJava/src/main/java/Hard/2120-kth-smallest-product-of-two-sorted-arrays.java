package main.java.Hard;

/**https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/ */
//Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.


class KthSmallestProductOfTwoSortedArrays {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n = nums1.length;
        int m = nums2.length;
        long l = (long)nums1[0] * nums2[0];
        long r = (long)nums1[n - 1] * nums2[m - 1];
        while(l < r){
            long mid = l + r >> 1;
            if(count(nums1, nums2, mid) < k){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
        
        
    }
    public long count(int[] nums1, int[] nums2, long mid){
        int n = nums1.length;
        int m = nums2.length;
        long res = 0;
        for(int i = 0; i < n; i++){
            if(nums1[i] >= 0){
                int l = 0;
                int r = m - 1;
                while(l < r){
                    int mid2 = l + r + 1 >> 1;
                    if((long)nums1[i] * nums2[mid2] <= mid){
                        l = mid2;
                    }else{
                        r = mid2 - 1;
                    }
                }
                res += l + 1;
            }else{
                int l = 0;
                int r = m - 1;
                while(l < r){
                    int mid2 = l + r >> 1;
                    if((long)nums1[i] * nums2[mid2] <= mid){
                        r = mid2;
                    }else{
                        l = mid2 + 1;
                    }
                }
                res += m - l;
            }
        }
        return res;
    }
}
     
    