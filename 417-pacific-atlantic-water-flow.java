public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        int[][] state = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            state[i][0] |= 1;
            if (i == m - 1 || n == 1) state[i][0] |= 2;
            if (state[i][0] == 3) res.add(new int[]{i, 0});
            q.add(new int[]{i, 0});
            if (n > 1) {
                state[i][n - 1] |= 2;
                if (i == 0) state[i][n - 1] |= 1;
                if (state[i][n - 1] == 3) res.add(new int[]{i, n - 1});
                q.add(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            state[0][j] |= 1;
            if (m == 1) state[0][j] |= 2;
            if (state[0][j] == 3) res.add(new int[]{0, j});
            q.add(new int[]{0, j});
            if (m > 1) {
                state[m - 1][j] |= 2;
                if (state[m - 1][j] == 3) res.add(new int[]{m - 1, j});
                q.add(new int[]{m - 1, j});
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];
                if (row < 0 || col < 0 || row == m || col == n || matrix[row][col] < matrix[cell[0]][cell[1]] || ((state[cell[0]][cell[1]] | state[row][col]) == state[row][col])) continue;
                state[row][col] |= state[cell[0]][cell[1]];
                if (state[row][col] == 3) res.add(new int[]{row, col});
                q.add(new int[]{row, col});
            }
        }
        return res;
    }
}
