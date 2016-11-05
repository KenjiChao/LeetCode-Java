public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int maxSize = 0;
        int[] size = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int pre = size[0];
            for (int j = 0; j < n; j++) {
                int val = (matrix[i][j] == '1') ? Math.min(size[j], Math.min(size[j + 1], pre)) + 1 : 0;
                pre = size[j + 1];
                size[j + 1] = val;
                maxSize = Math.max(maxSize, size[j + 1]);
            }
        }

        return maxSize * maxSize;
    }
}
