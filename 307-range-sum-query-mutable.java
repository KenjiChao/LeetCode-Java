// Segment Tree
public class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n << 1];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        for (int i = n; i < n << 1; i++) {
            tree[i] = nums[i - n];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }

    void update(int i, int val) {
        for (tree[i += n] = val; i > 0; i >>= 1) {
            tree[i >> 1] = tree[i] + tree[i ^ 1];
        }
    }

    public int sumRange(int i, int j) {
        int ret = 0;
        for (i += n, j += n; i <= j; i >>= 1, j >>= 1) {
            if ((i & 1) == 1) ret += tree[i++];
            if ((j & 1) == 0) ret += tree[j--];
        }
        return ret;
    }
}

// Binary Indexed Tree
public class NumArray {
    int[] nums;
    int[] BITree;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BITree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            buildTree(i, nums[i]);
        }
    }

    private void buildTree(int i, int val) {
        i++;
        while (i <= n) {
            BITree[i] += val;
            i += i & (-i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        buildTree(i, diff);
    }

    private int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BITree[i];
            i &= (i - 1);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
