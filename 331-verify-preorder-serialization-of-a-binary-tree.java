// outdegree - indegree
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1; // diff = outdegree - indegree
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        
        return diff == 0;
    }
}

// recursive
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        return nextNodeIndex(nodes, 0) == nodes.length;
    }

    private int nextNodeIndex(String[] nodes, int start) {
        if (start < 0 || start >= nodes.length) return -1;
        if (nodes[start].equals("#")) return start + 1;
        int right = nextNodeIndex(nodes, start + 1);
        return nextNodeIndex(nodes, right);
    }
}
