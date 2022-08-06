package Graph;
//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegion {
    public void solve(char[][] board){
        int nRows= board.length;
        int nCols= board[0].length;

        // 1a) Capture unsurrounded regions - top and bottom row (O -> T)
        for (int i = 0; i < nCols; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[nRows - 1][i] == 'O') dfs(board, nRows - 1, i);
        }

        // 1b) Capture unsurrounded regions - Left and right columns (O -> T)
        for (int i = 0; i < nRows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][nCols - 1] == 'O') dfs(board, i, nCols - 1);
        }

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (board[i][j]=='O') board[i][j]='X';    // 2) Capture surrounded regions (O -> X)
                if (board[i][j]=='T') board[i][j]='O';    // 3) Uncapture unsurrounded regions (T- O)
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int nRows= board.length;
        int nCols= board[0].length;

        if (r<0 || c<0 || r>=nRows || c>=nCols || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

}
