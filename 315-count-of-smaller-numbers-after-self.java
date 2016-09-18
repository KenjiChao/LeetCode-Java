// Merge Sort
public class Solution {
    class Node {
        int val, index;
        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] count = new Integer[n];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)  {
            count[i] = 0;
            nodes[i] = new Node(nums[i], i);
        }
        countWhileMergeSort(nodes, 0, n, count);
        return Arrays.asList(count);
    }

    private void countWhileMergeSort(Node[] nodes, int start, int end, Integer[] count) {
        if (end - start <= 1) return;
        int mid = start + (end - start) / 2;
        countWhileMergeSort(nodes, start, mid, count);
        countWhileMergeSort(nodes, mid, end, count);
        Node[] cache = new Node[end - start];
        int j = mid;
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (j < end && nodes[j].val < nodes[i].val) {
                cache[r++] = nodes[j++];
            }
            cache[r] = nodes[i];
            count[nodes[i].index] += (j - mid);
        }
        System.arraycopy(cache, 0, nodes, start, j - start);
    }
}

// Binary Search
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ret = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            sorted.add(index, nums[i]);
            ret[i] = index;
        }

        return Arrays.asList(ret);
    }

    private int findIndex(List<Integer> sorted, int target) {
        int size = sorted.size();
        if (size == 0) return 0;

        int lo = 0, hi = size - 1;
        if (target <= sorted.get(lo)) return 0;
        if (target > sorted.get(hi)) return size;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > sorted.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return target <= sorted.get(lo) ? lo : hi;
    }
}

// BST
public class Solution {
    class Node {
        int val, leftSum, count;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if (nums.length == 0) return Arrays.asList(count);

        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = insert(root, nums[i]);
        }

        return Arrays.asList(count);
    }

    private int insert(Node node, int target) {
        int sum = 0;
        while (node.val != target) {
            if (target < node.val) {
                node.leftSum++;
                if (node.left == null) node.left = new Node(target);
                node = node.left;
            } else {
                sum += node.leftSum + node.count;
                if (node.right == null) node.right = new Node(target);
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }
}
