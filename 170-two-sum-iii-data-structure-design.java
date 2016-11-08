public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (int key : map.keySet()) {
            if (map.containsKey(value - key) && (key != value - key || map.get(key) > 1)) return true;
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
