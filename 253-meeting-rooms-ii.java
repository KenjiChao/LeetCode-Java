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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length <= 1) return intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare (Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                pq.add(intervals[i]);
            }
            pq.add(interval);
        }
        return pq.size();
    }
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[endIndex]) rooms++;
            else endIndex++;
        }
        return rooms;
    }
}
