public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            // reserve left bits and ignore right bits
            for (int num : nums) set.add(num & mask);
            // check if we can make a larger xor result
            int localMax = max | 1 << i;
            for (int prefix : set) {
                if (set.contains(localMax ^ prefix)) {
                    max = localMax;
                    break;
                }
            }
        }
        return max;
    }
}

// Trie
public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        public TrieNode() {}
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) node.children[bit] = new TrieNode();
                node = node.children[bit];
            }
        }
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int curMax = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit ^ 1] != null) {
                    curMax |= (1 << i);
                    node = node.children[bit ^ 1];
                } else {
                    node = node.children[bit];
                }
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}
