public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return ret;
        int n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) ret.add(matrix[rowStart][i]);
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) ret.add(matrix[i][colEnd]);
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) ret.add(matrix[rowEnd][i]);
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) ret.add(matrix[i][colStart]);
                colStart++;
            }
        }
        return ret;
    }
}
