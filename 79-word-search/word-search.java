    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(dfs(board , i , j , 0 , word)) return true;
                }
            }
            return false;
        }
        public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        
        boolean found = dfs(board, i + 1, j, count + 1, word) || // Down
                        dfs(board, i - 1, j, count + 1, word) || // Up
                        dfs(board, i, j + 1, count + 1, word) || // Right
                        dfs(board, i, j - 1, count + 1, word);   // Left

        board[i][j] = temp;   
        return found;
    }

}