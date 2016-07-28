public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // Let m <= n
        int m = Math.min(row, col);
        int n = Math.max(row, col);
        int maxSum = Integer.MIN_VALUE;
        // if true => m = row, n = col
        boolean isColLarger = col > row;

        for (int i = 0; i < m; i++) {
            int[] subSum = new int[n];
            for (int j = i; j < m; j++) {
                // Searching for the max sum of 1D subarray where the sum is no larger than k
                TreeSet<Integer> set = new TreeSet<>();
                int cum = 0;
                set.add(cum);
                for (int l = 0; l < n; l++) {
                    subSum[l] += isColLarger ? matrix[j][l] : matrix[l][j];
                    cum += subSum[l];
                    Integer ceiling = set.ceiling(cum - k);
                    if (ceiling != null) {
                        maxSum = Math.max(maxSum, cum - ceiling);
                    }
                    set.add(cum);
                }
            }
        }

        return maxSum;
    }
}
