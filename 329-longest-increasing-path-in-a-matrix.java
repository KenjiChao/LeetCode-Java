public class Solution {
    public static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 1;
        int[][] cache = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cache[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, i, j, cache));
                }
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            max = Math.max(max, 1 + dfs(matrix, x, y, cache));
        }

        cache[i][j] = max;
        return max;
    }
}
