package BinaryTree.MediumProblems;

public class CheckBalancedTree {
    // optimized solution
    // time complexity : O(n)
    // space comlexity : O(n) auxillary space
    public boolean isBalanced(TreeNode root ){
        return height(root) != -1;
    }

    public int height(TreeNode root ){
        if( root == null ) return 0;

        int left = height(root.left);
        if( left == -1  ) return -1;
        int right = height(root.right);
        if ( right == -1 ) return -1;

        if( Math.abs(left - right ) > 1) return -1;
        return 1+Math.max(left, right);
    }
    // brute force solution
    // Time complexity : O(n^2)
    // Space complexity : O(n) ( auxillary space)
    // public boolean isBalanced(TreeNode root) {
    //     if( root == null ) return true;
    //     return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    // }

    // public int height(TreeNode root ){
    //     if ( root == null ) return 0;
    //     return 1+Math.max(height(root.left), height(root.right));
    // }
}
