public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k <= 0) return false;
        Map<Long, Long> map = new HashMap<>(); // store (bucketId, value) pair
        long width = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getBucketId(nums[i], width);
            if (map.containsKey(id)) return true;
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) <= t) return true;
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) <= t) return true;
            map.put(id, (long) nums[i]);
            if (i >= k) map.remove(getBucketId(nums[i - k], width));
        }
        return false;
    }

    private long getBucketId(long val, long width) {
        return val >= 0 ? val / width : (val + 1) / width - 1;
    }
}
