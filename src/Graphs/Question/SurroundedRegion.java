package Graphs.Question;

public class SurroundedRegion {
    public static void main(String[] args) {
        // https://leetcode.com/problems/surrounded-regions/description/

    }
    public void solve (char [][] board){
        int n = board.length;
        int m = board[0].length;
        int [][] vis = new int [n][m];

        int [] dx = new int []{-1, 0, 1, 0};
        int [] dy = new int [] {0, 1, 0, -1};


        // if any '0' will be present on border of board then it will be impossible to make it 'X';
        for ( int i = 0; i < m; i++){
            // first row if we get any 0 then we will do dfs and check any close 0 is there same for last row
            if (board[0][i]  == '0' && vis[0][i] != 1){
                dfs(board,vis, dy, dx, 0, i);
            }
            // last row;
            if (board[n-1][i] == '0' && vis[n-1][i] != 1){
                dfs(board, vis, dy,dx, n-1, i);
            }
        }

        for (int j = 0; j < n; j++){
            // check first and last column;
            if (board[j][0] == '0' && vis[j][0] != 1){
                dfs(board, vis, dy,dx, j, 0);
            }
            if (board[j][m-1] == '0' && vis[j][m-1] != 1){
                dfs(board,vis,dy, dx, j, m-1);
            }
        }

        for (int i = 0; i< n; i++){
            for (int j = 0; j < m; j++){
                if (vis[i][j] == 0 && board[i][j] == '0'){
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void dfs (char[][] board, int [][] vis, int [] dy, int [] dx, int i, int j){
        int n = board.length;
        int m = board[0].length;
        vis[i][j] = 1;


        for (int k = 0; k < 4; k++){
            int nrow = i + dx[k];
            int ncol = j + dy[k];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1 && board[nrow][ncol] == '0'){
                dfs(board, vis, dy,dx, nrow, ncol);
            }
        }
    }
}
