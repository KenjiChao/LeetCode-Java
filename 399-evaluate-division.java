public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            if (!map.containsKey(equations[i][0])) map.put(equations[i][0], new HashMap<>());
            if (!map.containsKey(equations[i][1])) map.put(equations[i][1], new HashMap<>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = dfs(map, queries[i][0], queries[i][1], new HashSet<>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String start, String end, Set<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (start.equals(end)) return 1.0;
        visited.add(start);
        for (String key : map.get(start).keySet()) {
            if (!visited.contains(key)) {
                double ret = dfs(map, key, end, visited);
                if (ret != -1) return map.get(start).get(key) * ret;
            }
        }
        return -1.0;
    }
}
