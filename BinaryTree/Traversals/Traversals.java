package BinaryTree;


public class Traversals {
    public static void main(String [] args){
        BinaryTreeImpl obj = new BinaryTreeImpl();
        Integer [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode root = obj.generateBinaryTree(arr);
        System.out.print("preorder traversal : ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("inorder traversal : ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("postorder traversal : ");
        postorderTraversal(root);
    }

    // preorder
    public static void preorderTraversal(TreeNode root ){
        if( root == null ) return;
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // inorder travresal
    public static void inorderTraversal(TreeNode root ){
        if( root == null ) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    // postorder traversal
    public static void postorderTraversal(TreeNode root){
        if ( root == null ) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }
}
