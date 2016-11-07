public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0 || word.length() == 0) return false;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkWord(board, m, n, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean checkWord(char[][] board, int m, int n, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(index)) return false;
        board[i][j] = '.';
        boolean res = checkWord(board, m, n, i + 1, j, word, index + 1) || checkWord(board, m, n, i - 1, j, word, index + 1) || checkWord(board, m, n, i, j + 1, word, index + 1) || checkWord(board, m, n, i, j - 1, word, index + 1);
        board[i][j] = word.charAt(index);
        return res;
    }
}
