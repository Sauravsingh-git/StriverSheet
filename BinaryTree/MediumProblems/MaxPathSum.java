package BinaryTree.MediumProblems;
public class MaxPathSum {
    // time complexity : O(n)
    // space complexity : O(n) auxillary space
    public int maxPathSum(TreeNode root) {
        int [] maxPathSum = new int [1];
        maxPathSum[0] = Integer.MIN_VALUE;
        maxPathSumUtil(root, maxPathSum);
        return maxPathSum[0];
    }

    public int maxPathSumUtil(TreeNode root, int [] max){
        if ( root == null ) return 0;
        int leftSum = maxPathSumUtil(root.left, max);
        int rightSum = maxPathSumUtil(root.right, max);
        int temp = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);
        int candidatePath = Math.max(temp, leftSum + rightSum + root.val);
        max[0] = Math.max(max[0], candidatePath);
        return temp;
    }
}
