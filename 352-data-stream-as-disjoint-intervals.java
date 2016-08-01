/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    TreeMap<Integer, Interval> tree;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) return;

        Integer lo = tree.lowerKey(val);
        Integer hi = tree.higherKey(val);

        if (lo != null && hi != null && val == tree.get(lo).end + 1 && val == hi - 1) {
            tree.get(lo).end = tree.get(hi).end;
            tree.remove(hi);
        } else if (lo != null && tree.get(lo).end + 1 >= val) {
            tree.get(lo).end = Math.max(tree.get(lo).end, val);
        } else if (hi != null && val == hi - 1) {
            tree.put(val, new Interval(val, tree.get(hi).end));
            tree.remove(hi);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
