package BinaryTree.MediumProblems;

public class HeightOfBinaryTree {
    // height and depth program  are similar
    public int maxHeight(TreeNode root) {
        if( root == null ) return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
