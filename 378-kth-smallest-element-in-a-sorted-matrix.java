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
