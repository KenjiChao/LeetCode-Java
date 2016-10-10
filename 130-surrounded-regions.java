public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            mark(board, i, 0);
            if (n > 1) mark(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            mark(board, 0, j);
            if (m > 1) mark(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    private void mark(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 1) mark(board, i - 1, j);
            if (j > 1) mark(board, i, j - 1);
            if (i + 1 < board.length) mark(board, i + 1, j);
            if (j + 1 < board[0].length) mark(board, i, j + 1);
        }
    }
}
