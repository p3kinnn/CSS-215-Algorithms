class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return res;
    }
    public void backtrack(char[][] board, int row){
        if (row == board.length) {
            List<String>solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                String queen = new String(board[i]);
                solution.add(queen);
            }
            res.add(solution);
                   return;

        }
   
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col) == true) {
                board[row][col] = 'Q';
                 backtrack(board, row+1);
                  board[row][col] = '.';
            }
           
           

        }
    }
    public boolean isSafe(char[][] board, int row, int col){
        for (int i = 0; i < row; i++) {
            if (board[i][col] =='Q') {
                return false;
            }
        }
        int r = row-1;
        int c = col-1;
        while (r >=0 && c >=0){
            if (board[r][c]=='Q') {
                return false;
            }
            r--;
            c--;
        }
        r = row -1;
        c = col +1;
        while (c < board.length && r >=0) {
            if (board[r][c] =='Q') {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}