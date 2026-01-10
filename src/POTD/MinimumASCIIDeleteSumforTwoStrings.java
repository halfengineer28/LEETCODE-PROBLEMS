package POTD;

import java.util.Arrays;

public class MinimumASCIIDeleteSumforTwoStrings {
    int [][] dp;
    public int minimumDeleteSum(String s1, String s2){
        dp = new int [s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(s1, s2, 0, 0);

    }
    public int helper(String s1, String s2, int i,int j){
        if (i >= s1.length() || j >= s2.length()){
            return remain(s1, i) + remain(s2, j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = helper(s1,s2, i+1, j+1);
        }else {
            ans = Math.min(s1.charAt(i) + helper(s1,s2, i+1, j), s2.charAt(j) + helper(s1,s2, i, j+1));
        }
        return ans;
    }
    public int remain (String s, int index){
        int sum = 0;
        for (int i = index; i < s.length(); i++){
            sum += s.charAt(i);

        }
    }
}
