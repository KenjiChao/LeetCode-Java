// O(N)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry entry : map.entrySet()) {
            int key = (Integer) entry.getKey();
            int val = (Integer) entry.getValue();
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = nums.length; i >= 0 && ret.size() < k; i--) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }

        return ret;
    }
}

// O(Nlogk)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k + 1, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                    return e1.getValue() - e2.getValue();
                }
            });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(0, pq.poll().getKey());
        }

        return ret;
    }
}
