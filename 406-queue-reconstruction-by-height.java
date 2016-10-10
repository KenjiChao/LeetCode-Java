public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] != p2[0]) {
                    return -(p1[0] - p2[0]);
                } else {
                    return p1[1] - p2[1];
                }
        }});

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], new int[]{p[0], p[1]});
        }
        return res.toArray(new int[people.length][]);
    }
}
