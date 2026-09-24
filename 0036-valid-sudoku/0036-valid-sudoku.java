class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];
        for (int q = 0; q < 9; q++) {
            rows[q] = new HashSet<>();
            columns[q] = new HashSet<>();
            squares[q] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr == '.') {
                    continue;
                } 
                if (Character.isDigit(curr)) {
                    int squareIndex = (i / 3) * 3 + (j / 3);
                    if (rows[i].contains(curr) || columns[j].contains(curr) || squares[squareIndex].contains(curr)) {
                        return false;
                    }
                    rows[i].add(curr);
                    columns[j].add(curr);
                    squares[squareIndex].add(curr);
                }
            }
        }
        return true;
    }
}