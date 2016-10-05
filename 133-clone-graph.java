/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }
        return clone;
    }
}

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        dfs(node, root, map);
        return root;
    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode copy, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        map.put(node, copy);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                copy.neighbors.add(map.get(neighbor));
            } else {
                UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                copy.neighbors.add(neighborCopy);
                dfs(neighbor, neighborCopy, map);
            }
        }
    }
}
