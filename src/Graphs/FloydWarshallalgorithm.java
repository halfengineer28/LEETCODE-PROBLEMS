package Graphs;

public class FloydWarshallalgorithm {
    public static void floydWarshall(int[][] dist, int v){

        int [][] dis = new int[v][v];
        // create matrix with max value and zero

        for (int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                if (i == j){
                    dis[i][j] = 0;
                }else {
                    dis[i][j] = Integer.MAX_VALUE;
                }

            }
        }
        // Floyd Warshall
        for (int k = 0; k < v; k++){
            for (int i = 0; i < v; i++){
                for (int j = 0; j < v; j++){
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis [k][j]);
                }
            }
        }

    }
}
