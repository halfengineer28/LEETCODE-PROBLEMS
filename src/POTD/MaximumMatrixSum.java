package POTD;

public class MaximumMatrixSum {
    public  long maxMatrixSum(int[][] matrix){
        // Greedy Approach Count negative check if its odd subtract 2 times with the min value from totalSum if it is even return the totalSum
        int n = matrix.length;
        int m = matrix[0].length;
        long totalSum = 0;
        int min = Integer.MAX_VALUE;
        int negCount = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                totalSum += Math.abs(matrix[i][j]);
                if (matrix[i][j] < 0){
                    negCount++;

                }
                min = Math.min(min, Math.abs(matrix[i][j]));

            }
        }
        if (negCount % 2 != 0){
            totalSum -= 2 * min;
        }
        return totalSum;
    }
}
