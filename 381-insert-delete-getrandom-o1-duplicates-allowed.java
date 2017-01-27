public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> nums;
    Random random;
    int size;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        random = new Random();
        size = 0;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) map.put(val, new LinkedHashSet<>());
        if (size < nums.size()) nums.set(size, val);
        else nums.add(val);
        map.get(val).add(size++);
        return !contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> indices = map.get(val);
        int index = nums.get(--size) == val ? size : indices.iterator().next();
        if (index < size) {
            nums.set(index, nums.get(size));
            Set<Integer> indices_last = map.get(nums.get(size));
            indices_last.remove(size);
            indices_last.add(index);
        }
        indices.remove(index);
        if (indices.size() == 0) map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(size));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
