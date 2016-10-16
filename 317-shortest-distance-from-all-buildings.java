public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        int[][] state = new int[m][n];
        int walk = 0;
        int min = -1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    min = -1;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j, 0});
                    while (!q.isEmpty()) {
                        int[] cell = q.poll();
                        int level = cell[2] + 1;
                        for (int[] dir : dirs) {
                            int row = cell[0] + dir[0];
                            int col = cell[1] + dir[1];
                            if (row < 0 || col < 0 || row == m || col == n || grid[row][col] != walk) continue;
                            grid[row][col]--;
                            state[row][col] += level;
                            q.add(new int[]{row, col, level});
                            min = min == -1 ? state[row][col] : Math.min(min, state[row][col]);
                        }
                    }
                    walk--;
                }
            }
        }
        return min;
    }
}

// my solution
public class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        int[][] state = new int[m][n];

        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, state, candidates, i, j);
                    if (candidates.isEmpty()) return -1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer c : candidates) min = Math.min(min, state[c / n][c % n]);
        return min;
    }

    private void bfs(int[][] grid, int[][] state, Set<Integer> candidates, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 0});
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int level = cell[2] + 1;
            for (int[] dir : dirs) {
                int row = dir[0] + cell[0];
                int col = dir[1] + cell[1];
                int id = row * n + col;
                if (row < 0 || col < 0 || row == m || col == n || grid[row][col] != 0 || (candidates.size() > 0 && !candidates.contains(id)) || set.contains(id)) continue;
                set.add(id);
                state[row][col] += level;
                q.add(new int[]{row, col, level});
            }
        }
        candidates.clear();
        candidates.addAll(set);
    }
}
