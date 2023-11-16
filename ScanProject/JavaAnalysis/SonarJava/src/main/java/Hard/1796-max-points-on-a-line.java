package main.java.Hard;

/**https://leetcode.com/problems/max-points-on-a-line/ */
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
// 
//Example 1:
//Input: points = [[1,1],[2,2],[3,3]]
//Output: 3
//Example 2:
//Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//Output: 4
// 
//Constraints:
//	1 <= points.length <= 300
//	points[i].length == 2
//	-104 <= xi, yi <= 104
//	All the points are unique.
class Solution3 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n < 3) return n;
        int res = 0;
        for(int i = 0; i < n - 1; i++){
            int[] p1 = points[i];
            for(int j = i + 1; j < n; j++){
                int[] p2 = points[j];
                int count = 2;
                for(int k = j + 1; k < n; k++){
                    int[] p3 = points[k];
                    if(isSameLine(p1, p2, p3)) count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
    private boolean isSameLine(int[] p1, int[] p2, int[] p3){
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        int x3 = p3[0], y3 = p3[1];
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }
}