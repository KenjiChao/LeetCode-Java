public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        int len = board.length;
        if (row == len) return true;
        if (col == len) return solve(board, row + 1, 0);
        if (board[row][col] != '.') return solve(board, row, col + 1);
        for (char ch = '1'; ch <= '0' + len; ch++) {
            if (isValid(board, row, col, ch)) {
                board[row][col] = ch;
                if (solve(board, row, col + 1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        int len = board.length;
        int secLen = (int) Math.sqrt(len);
        int rowStart = secLen * (row / secLen);
        int colStart = secLen * (col / secLen);
        for (int i = 0; i < len; i++) {
            if (board[i][col] == ch) return false;
            if (board[row][i] == ch) return false;
            if (board[rowStart + i / secLen][colStart + i % secLen] == ch) return false;
        }
        return true;
    }
}
