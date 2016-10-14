public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] degree = new int[numCourses];
        // init graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for (int[] e : prerequisites) {
            degree[e[0]]++;
            graph.get(e[1]).add(e[0]); // pre -> cur
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (degree[i] == 0) q.add(i);
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order[index++] = node;
            for (int next : graph.get(node)) {
                degree[next]--;
                if (degree[next] == 0) q.add(next);
            }
        }
        return index == numCourses ? order : new int[0];
    }
}
