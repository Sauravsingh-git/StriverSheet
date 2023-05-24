package BinaryTree.MediumProblems;

public class SameBinaryTree {
    public boolean checkSameBinaryTree(TreeNode root1, TreeNode root2){
        if ( root1 == null || root2 == null ) return root1 == root2;
        return root1.val == root2.val && checkSameBinaryTree(root1.left, root2.left) && checkSameBinaryTree(root1.right, root2.right);
    }
}
