package BinarySearchTree;

public class ValidateBST {
    // approach 1 : check if the node is in the range
    // since we can have nodes with value Integer.MAX_VALUE and Integer.MIN_VALUE
    // we cannot pass Integer.MAX_VALUE and Integer.MIN_VALUE
    
    public boolean isBST1( TreeNode root ){
        return isBSTUtil(root, null, null);
    }

    public boolean isBSTUtil(TreeNode root, Integer min, Integer max){
        if( root == null ) return true;
        
        if( ( min != null && root.val <= min ) && ( max != null && root.val >= max)) return false;

        return isBSTUtil(root.left, min, root.val) && isBSTUtil(root.right, root.val, max);
    }

    // approach 2 : using inorder traversal to check if the given tree is bst
    
    Integer prev = null;
    public boolean isBST2(TreeNode root ){
        return isBSTUtil(root);
    }

    public boolean isBSTUtil(TreeNode root){
        if(root==null)
            return true;

        boolean left = isBSTUtil(root.left);
        if(!left) return false;
        if ( prev != null && root.val <= prev) return false;
        prev = root.val;
        return isBSTUtil(root.right);
    }
}
