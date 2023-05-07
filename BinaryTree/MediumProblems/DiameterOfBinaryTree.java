package BinaryTree.MediumProblems;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root ){
        int [] diameter = new int [1];
        height (root, diameter);
        return diameter[0];
    }

    public int height(TreeNode node, int [] diameter){
        if ( node == null ) return 0;
        int left = height(node.left, diameter);
        int right = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1 + Math.max(left, right);
    }
    //************************** Naive approach ******************************

    // A daimeter is just height(leftSubtree) + height(rightSubtree)
    // check every node to find the diameter of BinaryTree
    // Time complexity : O(n^2)
    // space complexity : O(n) auxillary space
    // public int diameterOfBinaryTree(TreeNode root) {
    //     int [] diameter = new int [1];
    //     diameterOfBinaryTree(root, diameter);
    //     return diameter[0];
    // }

    // public void diameterOfBinaryTree(TreeNode root, int [] arr ){
    //     if(root == null ) return;
    //     arr[0] = Math.max(arr[0], height(root.left) + height(root.right));
    //     diameterOfBinaryTree(root.left, arr);
    //     diameterOfBinaryTree(root.right, arr);
    // }

    // public int height(TreeNode root ){
    //     if ( root == null ) return 0;
    //     int left = height(root.left);
    //     int right = height(root.right);
    //     return Math.max(left, right )+1;
    // }
}
