// Time: O(n^2)
// Space: O(n)
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int m = points.length;
        if (m == 0) return 0;
        int n = points[0].length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int val : map.values()) {
                count += val * (val - 1);
            }
            map.clear();
        }
        return count;
    }

    private int getDistance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
