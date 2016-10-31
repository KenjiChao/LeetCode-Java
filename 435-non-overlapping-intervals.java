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
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           }
        });
        int end = intervals[0].end;
        int overlapping = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i].start) {
                overlapping++;
                end = Math.min(end, intervals[i].end);
            } else {
                end = intervals[i].end;
            }
        }
        return overlapping;
    }
}
