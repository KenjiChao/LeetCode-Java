public class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n <= 1) return n;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });

        int minArrows = 1;
        int arrowEnd = points[0][1];
        for (int i = 1; i < n; i++) {
            if (arrowEnd < points[i][0]) {
                arrowEnd = points[i][1];
                minArrows++;
            } else {
                arrowEnd = Math.min(arrowEnd, points[i][1]);
            }
        }
        return minArrows;
    }
}
