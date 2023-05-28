package BinaryTree.HardProblems;

public class ChildSumParent {
    // Given a Binary Tree. Check whether all of its nodes have the value equal to the sum of their child nodes.
    // Return 1 if it satifies otherwise return 0
    public static int isSumProperty(TreeNode root){
        return isSumUtil(root) ? 1 : 0;
    }    
    
    private static boolean isSumUtil(TreeNode root){
        if ( root == null ) return true;
        int sum = 0; 
        if( root.left != null ) sum += root.left.val;
        if( root.right != null ) sum += root.right.val;
        
        return (sum == 0 || sum == root.val) && isSumUtil(root.left) && isSumUtil(root.right);
    }
}
