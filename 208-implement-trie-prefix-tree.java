class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
