public class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            map.put(num, left + right + 1);
            len = Math.max(len, left + right + 1);
            map.put(num - left, left + right + 1);
            map.put(num + right, left + right + 1);
        }
        return len;
    }
}
