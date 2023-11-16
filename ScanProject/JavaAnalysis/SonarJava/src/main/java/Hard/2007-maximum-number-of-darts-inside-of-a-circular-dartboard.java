package main.java.Hard;

/**https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/ */
//Alice is throwing n darts on a very large wall. You are given an array darts where darts[i] = [xi, yi] is the position of the ith dart that Alice threw on the wall.
//Bob knows the positions of the n darts on the wall. He wants to place a dartboard of radius r on the wall so that the maximum number of darts that Alice throws lies on the dartboard.
//Given the integer r, return the maximum number of darts that can lie on the dartboard.


class MaximumNumberOfDartsInsideOfACircularDartboard {
    public int numPoints(int[][] darts, int r) {
        int n = darts.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = darts[i];
                int[] p2 = darts[j];
                int[] center = getCenter(p1, p2, r);
                if (center == null) {
                    continue;
                }
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (inCircle(darts[k], center, r)) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
        
    }
    public int[] getCenter(int[] p1, int[] p2, int r) {
        int[] center = new int[2];
        double d = dist(p1, p2);
        if (d > 2 * r) {
            return null;
        }
        double midX = (p1[0] + p2[0]) / 2.0;
        double midY = (p1[1] + p2[1]) / 2.0;
        double t = Math.sqrt(r * r - d * d / 4.0);
        double x1 = midX + t * (p1[1] - p2[1]) / d;
        double y1 = midY + t * (p2[0] - p1[0]) / d;
        double x2 = midX - t * (p1[1] - p2[1]) / d;
        double y2 = midY - t * (p2[0] - p1[0]) / d;
        if (x1 < x2 || (x1 == x2 && y1 < y2)) {
            center[0] = (int)x1;
            center[1] = (int)y1;
        } else {
            center[0] = (int)x2;
            center[1] = (int)y2;
        }
        return center;
    }
    public boolean inCircle(int[] p, int[] center, int r) {
        return dist(p, center) <= r * r;
    }
    public double dist(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * 1.0 * (p1[0] - p2[0]) + (p1[1] - p2[1]) * 1.0 * (p1[1] - p2[1]));
    }
}
     
    