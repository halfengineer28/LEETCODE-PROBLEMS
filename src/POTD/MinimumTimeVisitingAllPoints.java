package POTD;

public class MinimumTimeVisitingAllPoints   {
    // used greedy approach
    public int minTimeToVisitAllPoints(int[][] points){
        int ans = 0;
        for (int i = 0; i < points.length-1; i++){
            int currx = points[i][0];
            int curry = points[i][1];
            int x = points[i+1][0];
            int y = points[i+1][1];
            ans += Math.max(Math.abs(currx-x), Math.abs(curry-y));
        }
        return ans;

    }
}
