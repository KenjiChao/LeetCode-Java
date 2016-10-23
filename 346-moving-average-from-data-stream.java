public class MovingAverage {
    int size = 0;
    Queue<Integer> q;
    double avg = 0.0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        if (q.size() < size) avg = avg * q.size() / (double) (q.size() + 1) + val / (double) (q.size() + 1);
        else avg += (val - q.remove()) / (double) size;
        q.add(val);
        return avg;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
