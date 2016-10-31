/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        int[] res = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i].start, i);
        }
        for (int i = 0; i < n; i++) {
            Integer ceiling = map.ceilingKey(intervals[i].end);
            res[i] = ceiling == null ? -1 : map.get(ceiling);
        }
        return res;
    }
}
