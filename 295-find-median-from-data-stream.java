public class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == 0) maxHeap.add(num);
        else {
            if (num <= maxHeap.peek()) {
                maxHeap.add(num);
                if (maxHeap.size() > 1 + minHeap.size()) minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
                if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else return maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
