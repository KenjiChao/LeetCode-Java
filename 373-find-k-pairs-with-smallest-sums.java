public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new Pair(0, nums1[i], nums2[0]));
        }

        while (--k >= 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            result.add(new int[]{p.num1, p.num2});
            if (p.idx < nums2.length - 1) {
                pq.add(new Pair(p.idx + 1, p.num1, nums2[p.idx + 1]));
            }
        }

        return result;
    }

    private class Pair implements Comparable<Pair> {
        int idx;  // index of num2
        int num1;
        int num2;

        public Pair(int idx, int num1, int num2) {
            this.idx = idx;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int compareTo(Pair p) {
            return this.num1 + this.num2 - p.num1 - p.num2;
        }
    }
}
