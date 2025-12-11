package Graphs.Question;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        // https://leetcode.com/problems/number-of-enclaves/description/
    }
    public int  numEnclave(int [][] grid){
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int [n][m];
        int [] row = new int []{-1, 0, 1, 0};
        int [] col = new int []{0, 1, 0, -1};

        for (int i = 0; i < m; i++){
            if (grid[0][i] == 1 && vis[0][i] != 1){
                dfs(grid, vis, row,col, 0, i);
            }
            if (grid[n-1][i] == 1 && vis[n-1][i] != 1){
                dfs(grid, vis, row, col, n-1, i);
            }

        }

        for ( int j = 0; j < n; j++){
            if (grid[j][0] == 1 && vis[j][0] != 1){
                dfs(grid, vis, row, col, j, 0);
            }
            if(grid[j][m-1] == 1 && vis[j][m-1] != 1){
                dfs(grid, vis,row,col, j, m-1);
            }

        }

        for (int i = 0; i< n; i++ ){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1 && vis[i][j] != 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void  dfs(int [][] grid, int [][] vis,int [] row, int [] col, int i, int j){
        vis[i][j] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int k = 0; k < 4; k++){
            int nrow = i + row[k];
            int ncol = j + col[k];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1 && grid[nrow][ncol] == 1){
                dfs(grid, vis, row, col, nrow, ncol);
            }
        }
    }
}
