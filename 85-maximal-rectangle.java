public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < m; i++) {
            int cur_left = 0;
            int cur_right = n;
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(cur_right, right[j]);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update left, height, and area
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(cur_left, left[j]);
                    height[j]++;
                    maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
                } else {
                    left[j] = 0;
                    height[j] = 0;
                    cur_left = j + 1;
                }
            }
        }
        return maxArea;
    }
}
