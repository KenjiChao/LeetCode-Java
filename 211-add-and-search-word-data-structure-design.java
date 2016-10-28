public class WordDictionary {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word.toCharArray(), 0, root);
    }

    private boolean find(char[] chars, int index, TrieNode node) {
        if (chars.length == index) return node.isWord;
        if (chars[index] != '.') {
            return node.children[chars[index] - 'a'] != null && find(chars, index + 1, node.children[chars[index] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && find(chars, index + 1, node.children[i])) return true;
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
