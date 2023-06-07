package BinarySearchTree;

public class DeletingAnElement {
    
    // Deletion from binary tree has three cases
    // case 1 : with no childern -> directly delete the children
    // case 2 : with one children -> delete the node and make its parent point to its children
    // case 3 : both children are alive -> replace the node with inorder successor and delete the inorder sucessor node
    public TreeNode deleteNode(TreeNode root, int key) {
        // find the node
        TreeNode parent = null, curr = root;
        while ( curr != null && curr.val != key ) {
            parent = curr;
            if ( curr.val > key )   
                curr = curr.left;
            else 
                curr = curr.right;
        }
        // if root is not found 
        if ( curr == null ) return root;

        // for case 1 and case 2
        if ( curr.left == null || curr.right == null ){
        // if parent is null -> the element to be delete is root
            if( parent == null ){
                if ( root.left == null )
                    return root.right;
                else 
                    return root.left;
            }else{
                if ( curr.left == null ){
                    if ( curr.val > parent.val ){
                        parent.right = curr.right;
                    }else{
                        parent.left = curr.right;
                    }
                }else{
                    if( curr.val > parent.val){
                        parent.right = curr.left;
                    }else{
                        parent.left = curr.left;
                    }
                }
            }
        }else{

                // case 3 : the node which needs to be deleted contains both the children
                TreeNode [] inorderSuccessorDetails = findInorderSuccessor(curr);

                // for inorderSuccessor we have 2 cases, when the inorderSuccessor is the right child of node to be delete and when its not
                curr.val = inorderSuccessorDetails[0].val;
                if( inorderSuccessorDetails[1] == null){
                    curr.right = inorderSuccessorDetails[0].right;
                }else{
                    inorderSuccessorDetails[1].left = inorderSuccessorDetails[0].right;
                }
            }
        return root;
    }

    TreeNode [] findInorderSuccessor(TreeNode node){
        TreeNode curr = node.right, parent = null;
        while ( curr.left != null ){
            parent = curr;
            curr = curr.left;
        }
        return new TreeNode[]{curr, parent};
    }
}
