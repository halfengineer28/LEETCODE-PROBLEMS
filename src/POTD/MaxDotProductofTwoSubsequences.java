package POTD;

public class MaxDotProductofTwoSubsequences {
    Integer [][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2){
        dp = new Integer[nums1.length][nums2.length];
        return helper(0, 0, nums1, nums2);
    }
    public int helper(int i, int j, int []nums1, int [] nums2){
        // Choices are to take element in nums1;
        // to take element from nums2;
        // to take element from both with their product;
        if (i >= nums1.length || j >= nums2.length){
            return Integer.MIN_VALUE;
            // base case;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        // skip index from nums1;
        int skipI = helper(i+1,j, nums1, nums2);
        // skip index from nums2;
        int skipJ = helper(i, j+1, nums1, nums2);
        // make product and move with both index check the max value;
        int max = nums1[i] *  nums2[j] + Math.max(0,helper(i+1, j+1, nums1, nums2));

        return Math.max(skipI, Math.max(skipJ, max));

    }
}
