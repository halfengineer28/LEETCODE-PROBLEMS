package POTD;




public class MaximumProductofSplittedBinaryTree {
    // Get the totalSum of all nodes then for each sub Tree
    // get the subTreesum and remove that sum from totalSum
    // check the product of that subtree with max product
    // return maxProduct with mod;

    long sum = 0;
    long maxProd = 0;
    public int maxProduct(TreeNode root){
        int mod = 1000000007;
        // STEP 1;
        sum = getSum(root);
        getSum(root);
        return (int)(maxProd % mod);

    }
    public long getSum(TreeNode root){
        if (root == null){
            return 0;
        }
        long left = getSum(root.left);
        long right = getSum(root.right);
        //STEP 2 & Step 3;
        long subTreeSum = root.val + left + right;
        maxProd = Math.max(maxProd, subTreeSum *(sum-subTreeSum));
        return subTreeSum;

    }
}
