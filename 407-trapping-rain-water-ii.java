public class Solution {
    class Node implements Comparable<Node> {
        int row;
        int col;
        int height;
        public Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
        @Override
        public int compareTo(Node node) {
            return this.height - node.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        boolean[][] used = new boolean[m][n];
        int water = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.add(new Node(i, 0, heightMap[i][0]));
            used[i][0] = true;
            if (n > 1) {
                pq.add(new Node(i, n - 1, heightMap[i][n - 1]));
                used[i][n - 1] = true;
            }
        }
        for (int j = 1; j < n - 1; j++) {
            pq.add(new Node(0, j, heightMap[0][j]));
            used[0][j] = true;
            if (m > 1) {
                pq.add(new Node(m - 1, j, heightMap[m - 1][j]));
                used[m - 1][j] = true;
            }
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int[] dir : dirs) {
                int row = node.row + dir[0];
                int col = node.col + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n || used[row][col]) continue;
                used[row][col] = true;
                water += Math.max(0, node.height - heightMap[row][col]);
                pq.add(new Node(row, col, Math.max(node.height, heightMap[row][col])));
            }
        }
        return water;
    }
}
