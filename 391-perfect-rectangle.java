public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int m = rectangles.length;
        if (m == 0) return false;
        int n = rectangles[0].length;
        Set<Integer> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            addRectangle(set, rect);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        }
        if (!set.contains(Objects.hash(x1, y1)) || !set.contains(Objects.hash(x1, y2)) || !set.contains(Objects.hash(x2, y1)) || !set.contains(Objects.hash(x2, y2)) || set.size() != 4) return false;
        return area == (x2 - x1) * (y2 - y1);
    }

    private void addRectangle(Set<Integer> set, int[] rect) {
        int hash1 = Objects.hash(rect[0], rect[1]);
        int hash2 = Objects.hash(rect[0], rect[3]);
        int hash3 = Objects.hash(rect[2], rect[1]);
        int hash4 = Objects.hash(rect[2], rect[3]);
        if (!set.add(hash1)) set.remove(hash1);
        if (!set.add(hash2)) set.remove(hash2);
        if (!set.add(hash3)) set.remove(hash3);
        if (!set.add(hash4)) set.remove(hash4);
    }
}
