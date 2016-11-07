// klogk
public class Solution {
    class Tuple implements Comparable<Tuple> {
        int val;
        int row;
        int col;
        public Tuple(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Tuple tuple) {
            return this.val - tuple.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int size = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            pq.add(new Tuple(matrix[i][0], i, 0));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();
            if (tuple.col == size - 1) continue;
            pq.add(new Tuple(matrix[tuple.row][tuple.col + 1], tuple.row, tuple.col + 1));
        }
        return pq.peek().val;
    }
}

// nlog(max - min)
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return -1;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessOrEqual(matrix, mid);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private int getLessOrEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int i = n - 1, j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > mid) i--;
            else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}
