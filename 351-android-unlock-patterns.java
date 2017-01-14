public class Solution {
    public int numberOfPatterns(int m, int n) {
        int count = 0;
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        for (int i = m; i <= n; i++) {
            count += search(skip, visited, i - 1, 1) * 4; // 1, 3, 7, 9 are symmetric
            count += search(skip, visited, i - 1, 2) * 4; // 2, 4, 6, 8 are symmetric
            count += search(skip, visited, i - 1, 5);
        }
        return count;
    }

    private int search(int[][] skip, boolean[] visited, int n, int digit) {
        if (n == 0) return 1;
        int count = 0;
        visited[digit] = true;
        for (int i = 1; i <= 9; i++) {
            if (visited[i] || (skip[digit][i] != 0 && !visited[skip[digit][i]])) continue;
            count += search(skip, visited, n - 1, i);
        }
        visited[digit] = false;
        return count;
    }
}
