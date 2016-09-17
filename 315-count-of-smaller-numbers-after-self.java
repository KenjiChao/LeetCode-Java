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
