public class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        if (size < 3) return false;
        int last = 0;
        for (int i = 2; i <= size + 1; i++) {
            int cross = crossProduct(points.get((i - 2) % size), points.get((i - 1) % size), points.get(i % size));
            if (cross != 0) {
                if (cross * last < 0) return false;
                last = cross;
            }
        }
        return true;
    }

    private int crossProduct(List<Integer> prev_point, List<Integer> point, List<Integer> next_point) {
        int x1 = prev_point.get(0);
        int y1 = prev_point.get(1);
        int x2 = point.get(0);
        int y2 = point.get(1);
        int x3 = next_point.get(0);
        int y3 = next_point.get(1);
        int val = (x2 - x1) * (y3 - y2) - (x3 - x2) * (y2 - y1);
        return val > 0 ? 1 : (val < 0 ? -1 : 0);
    }
}
