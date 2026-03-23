class Solution {
    public List<List<String>> solveNQueens(int n) {
        Character[][] board = new Character[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        ArrayList<List<String>> ans = new ArrayList<>();
        nQueens(0 , board , ans);
        return ans;
    }
    public void nQueens(int row, Character[][] board, ArrayList<List<String>> ans) {
        int n = board.length;
        if (row == n) {
            ArrayList<String> curr =  new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    str += board[i][j];
                }
                curr.add(str);
            }
            ans.add(curr);
            return;
        }

        for(int col = 0; col < n; col++){
            if(canQueenPlaced(row , col , board)) {
                board[row][col] = 'Q';           // mark
                nQueens(row + 1, board, ans);    // move to the next row
                board[row][col] = '.';           // unmark backtracking
            }
        }
    }

    public boolean canQueenPlaced(int row, int col, Character[][] board) {
        int n = board.length;
        // check col
        int i = row - 1;
        while(i >= 0){
            if(board[i][col] == 'Q') return false;
            i--;
        }
        // check for  the left diagonal
        i = row-1;
        int j = col - 1;
        while(j >= 0 && i >= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // check for the right diagonal
        i = row-1;
        j = col+1;
        while(i >= 0 && j < n){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}