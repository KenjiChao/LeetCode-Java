public class LFUCache {
    class Node {
        int count;
        Set<Integer> keys;
        Node prev, next;
        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
        }
    }
    Map<Integer, Node> node_map; // key to freq node
    Map<Integer, Integer> val_map; // key to value
    int capacity;
    Node head;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        node_map = new HashMap<>();
        val_map = new HashMap<>();
        head = new Node(0);
    }

    public int get(int key) {
        if (val_map.containsKey(key)) {
            addCount(key);
            return val_map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (val_map.containsKey(key)) {
            val_map.put(key, value);
        } else {
            if (val_map.size() == capacity) {
                removeLFU();
            }
            val_map.put(key, value);
            addToHead(key);
        }
        addCount(key);
    }

    private void addToHead(int key) {
        head.keys.add(key);
        node_map.put(key, head);
    }

    private void addCount(int key) {
        Node node = node_map.get(key);
        node.keys.remove(key);
        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
        } else if (node.next.count != node.count + 1) {
            Node next = new Node(node.count + 1);
            next.next = node.next;
            node.next = next;
            next.prev = node;
            next.next.prev = next;
        }
        node.next.keys.add(key);
        node_map.put(key, node.next);
        if (node.keys.size() == 0 && node.count > 0) removeNode(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    private void removeLFU() {
        Node node = head.next;
        int key = 0;
        for (int i : node.keys) {
            key = i;
            break;
        }
        node.keys.remove(key);
        if (node.keys.size() == 0) removeNode(node);
        node_map.remove(key);
        val_map.remove(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
