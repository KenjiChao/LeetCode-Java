public class Solution {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) map.put(stones[i], new HashSet<>());
        map.get(0).add(0);
        for (int i = 0; i < len - 1; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(step + stones[i])) {
                        map.get(step + stones[i]).add(step);
                    }
                }
            }
        }
        return map.get(stones[len - 1]).size() > 0;
    }
}
