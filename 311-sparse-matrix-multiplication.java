public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0) return null;
        int p = B[0].length;
        int[][] res = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < p; k++) {
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
