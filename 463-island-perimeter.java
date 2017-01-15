// clever island and neighbour solution
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int islands = 0, neighbours = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i + 1 < m && grid[i + 1][j] == 1) neighbours++;
                    if (j + 1 < n && grid[i][j + 1] == 1) neighbours++;
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}

// straight forward solution
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count += check(grid, m, n, i - 1, j);
                    count += check(grid, m, n, i + 1, j);
                    count += check(grid, m, n, i, j - 1);
                    count += check(grid, m, n, i, j + 1);
                }
            }
        }
        return count;
    }

    private int check(int[][] grid, int m, int n, int i, int j) {
        return i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 ? 1 : 0;
    }
}
