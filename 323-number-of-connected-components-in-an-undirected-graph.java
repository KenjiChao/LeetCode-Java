public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] graph = new int[n];
        for (int i = 0; i < n; i++) graph[i] = i;

        for (int[] edge : edges) {
            int x = find(graph, edge[0]);
            int y = find(graph, edge[1]);
            if (x != y)  {
                graph[x] = y;
                n--;
             }
        }
        return n;
    }

    private int find(int[] graph, int i) {
        while (graph[i] != i) {
            graph[i] = graph[graph[i]];
            i = graph[i];
        }
        return i;
    }
}
