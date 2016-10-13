public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[numCourses]; // number of prerequisites courses
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] pair : prerequisites) {
            degree[pair[0]]++;
            graph.get(pair[1]).add(pair[0]); // pre -> cur
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int neighbor : graph.get(course)) {
                degree[neighbor]--;
                if (degree[neighbor] == 0) q.add(neighbor);
            }
        }
        return count == numCourses;
    }
}
