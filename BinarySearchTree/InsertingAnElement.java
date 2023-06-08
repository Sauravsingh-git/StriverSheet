package BinarySearchTree;

public class InsertingAnElement {
    // the iterative way
    public TreeNode insertIntoBST(TreeNode root, int val ){
        TreeNode temp = new TreeNode(val);
        if ( root == null ) return temp;
        TreeNode parent = null, curr = root;
        while ( curr != null ){
            parent = curr;
            if ( curr.val > val )
                curr = curr.left;
            else 
                curr = curr.right;
        }

        if ( parent.val > val )
            parent.left = temp;
        else
            parent.right = temp;
        
        return root;
    }
    // the recursive way
    public TreeNode insertIntoBSTRecur(TreeNode root, int val) {
        if ( root == null ) return new TreeNode(val);
        if( root.val  > val )
            root.left =  insertIntoBST(root.left, val);
        else 
            root.right = insertIntoBST(root.right, val);
        
        return root;
    }
}
