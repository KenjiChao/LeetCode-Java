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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        Interval interval = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (interval.end >= intervals.get(i).start) {
                interval.end = Math.max(interval.end, intervals.get(i).end);
            } else {
                res.add(interval);
                interval = new Interval(intervals.get(i).start, intervals.get(i).end);
            }
        }
        res.add(interval);
        return res;
    }
}
