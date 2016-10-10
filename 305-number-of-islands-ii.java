public class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] p : positions) {
            int id = p[0] * n + p[1];
            roots[id] = id;
            count++;
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = x * n + y;
                if (x < 0 || x == m || y < 0 || y == n || roots[nb] == -1) continue;

                int rootNb = findIsland(roots, nb);
                if (rootNb != id) {
                    roots[rootNb] = id;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int findIsland(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
