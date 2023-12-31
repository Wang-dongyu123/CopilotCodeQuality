package main.java.Medium;

/**https://leetcode.com/problems/image-overlap/ */
//You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
//We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
//Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
//Return the largest possible overlap.


class ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, Math.max(helper(img1, img2, i, j), helper(img2, img1, i, j)));
            }
        }
        return res;
    }
    private int helper(int[][] img1, int[][] img2, int rowOffset, int colOffset){
        int n = img1.length;
        int res = 0;
        for(int i = rowOffset; i < n; i++){
            for(int j = colOffset; j < n; j++){
                res += img1[i][j] * img2[i - rowOffset][j - colOffset];
            }
        }
        return res;
    }
}

    