package BinarySearchTree;

import java.util.List;
import java.util.ArrayList;
public class CeilInBST {
    // Function to return the ceil of given number in BST.
    // brute force solution
    // get the inorder traversal and then find the ciel value
    int findCeil1(TreeNode root, int key) {
        List<Integer> inorderTraversal = inorder(root);
        int ceil = 1;
        for ( int i = inorderTraversal.size()-1; i >= 0;  i-- ){
            if ( inorderTraversal.get(i) >= key ){
                ceil = inorderTraversal.get(i);
            }else{
                break;
            }
        }
        return ceil >= key ? ceil : -1;
    }
    
    List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorderUtil(root, list);
        return list;
    }
    
    void inorderUtil(TreeNode root, List<Integer> list){
        if( root == null ) return;
        inorderUtil(root.left, list);
        list.add(root.val);
        inorderUtil(root.right, list);
    }
    
    // more optimized approach 
    // Time complexity : O(h), h-> height of the tree
    // Space complexity : O(1)
    // maintain a ceil variable and update ceil and every step curr.val > key
    // this is will always update the right value in the ceil as we are moving closer to key everytime.

    int findCeil(TreeNode root, int key ){
        TreeNode curr = root;
        int ceil = -1;
        while ( curr != null ){
            if ( curr.val > key ) ceil = curr.val;
            if ( curr.val == key ) return key;
            else if ( curr.val > key )
                curr = curr.left;
            else 
                curr = curr.right;
        }
        return ceil;
    }
}
