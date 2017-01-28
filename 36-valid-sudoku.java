public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length != board.length) return false;
        int len = board.length;
        int secLen = (int) Math.sqrt(len);
        for (int i = 0; i < len; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> secSet = new HashSet<>();
            for (int j = 0; j < len; j++) {
                if (board[i][j] != '.' && (board[i][j] < '1' || board[i][j] > '9' || !rowSet.add(board[i][j]))) return false;
                if (board[j][i] != '.' && (board[j][i] < '1' || board[j][i] > '9' || !colSet.add(board[j][i]))) return false;
                int row = secLen * (i / secLen) + j / secLen;
                int col = secLen * (i % secLen) + j % secLen;
                if (board[row][col] != '.' && (board[row][col] < '1' || board[row][col] > '9' || !secSet.add(board[row][col]))) return false;
            }
        }
        return true;
    }
}
