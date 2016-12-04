public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        int n = buildings.length;
        if (n == 0) return res;
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
                else return arr2[2] - arr1[2];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[2] != arr2[2]) return arr2[2] - arr1[2];
                else return arr2[1] - arr1[1];
            }
        });
        for (int[] building : buildings) {
            while (!pq.isEmpty() && pq.peek()[1] < building[0]) {
                int[] old = pq.poll();
                while (!pq.isEmpty() && pq.peek()[1] <= old[1]) pq.poll();
                res.add(new int[]{old[1], pq.isEmpty() ? 0 : pq.peek()[2]});
            }
            if (pq.isEmpty() || building[2] > pq.peek()[2]) {
                res.add(new int[]{building[0], building[2]});
            }
            pq.add(building);
        }
        while (!pq.isEmpty()) {
            int[] old = pq.poll();
            while (!pq.isEmpty() && pq.peek()[1] <= old[1]) pq.poll();
            res.add(new int[]{old[1], pq.isEmpty() ? 0 : pq.peek()[2]});
        }
        return res;
    }
}
