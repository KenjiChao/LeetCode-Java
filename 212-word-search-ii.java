public class Solution {
    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
    }

    class Trie {
        TrieNode root;
        char[][] board;
        int m;
        int n;
        public Trie(char[][] board) {
            root = new TrieNode();
            this.board = board;
            m = board.length;
            n = board[0].length;
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode();
                node = node.children[ch - 'a'];
            }
            node.word = word;
        }

        public void findWord(int i, int j, List<String> res, TrieNode node) {
            if (i < 0 || j < 0 || i >= m || j >= n) return;
            char ch = board[i][j];
            if (ch == '.' || node.children[ch - 'a'] == null) return;
            node = node.children[ch - 'a'];
            board[i][j] = '.';
            if (node.word != null) {
                res.add(node.word);
                node.word = null;
            }
            findWord(i + 1, j, res, node);
            findWord(i - 1, j, res, node);
            findWord(i, j + 1, res, node);
            findWord(i, j - 1, res, node);
            board[i][j] = ch;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if (m == 0) return new ArrayList<>();
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        Trie trie = new Trie(board);
        for (String word : words) trie.insert(word);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trie.findWord(i, j, res, trie.root);
            }
        }
        return res;
    }
}
