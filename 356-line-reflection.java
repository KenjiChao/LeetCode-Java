public class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            set.add(p[0] + "|" + p[1]);
        }
        int sum = min + max;
        for (int[] p : points) {
            if (!set.contains((sum - p[0]) + "|" + p[1])) return false;
        }
        return true;
    }
}
