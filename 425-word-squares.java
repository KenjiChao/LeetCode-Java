public class Solution {
    class TrieNode {
        Set<String> startsWith;
        TrieNode[] children;
        public TrieNode() {
            startsWith = new HashSet<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                add(word);
            }
        }

        private void add(String word) {
            TrieNode cur = root;
            cur.startsWith.add(word);
            for (char ch : word.toCharArray()) {
                if (cur.children[ch - 'a'] == null) cur.children[ch - 'a'] = new TrieNode();
                cur = cur.children[ch - 'a'];
                cur.startsWith.add(word);
            }
        }

        public Set<String> getPrefixWords(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                if (cur.children[ch - 'a'] == null) return new HashSet<>();
                cur = cur.children[ch - 'a'];
            }
            return cur.startsWith;
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<>();
        if (words == null || words.length == 0) return ret;
        Trie trie = new Trie(words);
        search(words, trie, ret, new ArrayList<>(), words[0].length());
        return ret;
    }

    private void search(String[] words, Trie trie, List<List<String>> ret, List<String> ans, int wordLen) {
        if (ans.size() == wordLen) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        int idx = ans.size();
        StringBuilder prefix = new StringBuilder();
        for (String word : ans) prefix.append(word.charAt(idx));
        for (String word : trie.getPrefixWords(prefix.toString())) {
            ans.add(word);
            search(words, trie, ret, ans, wordLen);
            ans.remove(ans.size() - 1);
        }
    }
}
