public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] graph = new int[n];
        Arrays.fill(graph, -1);
        for (int[] edge : edges) {
            int x = find(graph, edge[0]);
            int y = find(graph, edge[1]);
            if (x == y) return false;
            graph[x] = y;
        }
        return edges.length == n - 1;
    }

    private int find(int[] graph, int i) {
        if (graph[i] == -1) return i;
        return find(graph, graph[i]);
    }
}
