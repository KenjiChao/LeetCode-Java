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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int n = intervals.size();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < n && intervals.get(i).end < newInterval.start) res.add(intervals.get(i++));
        // merge all overlapping intervals into newInterval
        while (i < n && intervals.get(i).end >= newInterval.start && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        // add the union interval
        res.add(newInterval);
        // add the rest intervals
        while (i < n) res.add(intervals.get(i++));

        return res;
    }
}
