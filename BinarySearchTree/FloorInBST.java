package BinarySearchTree;

import java.util.*;
public class FloorInBST {
    // brute force approach 
    // get the inorder traversal and find the floor
    // Time complexity & Space complexity : O(n)
    public static int floor1(TreeNode root, int x) {
        List<Integer> inorder = inorder(root);
        int ceil = -1;
        for ( int i = 0; i < inorder.size(); i++ ){
            if( inorder.get(i) <= x )
                ceil = inorder.get(i);
            else
                break;
        }
        return ceil;
    }
    
    public static List<Integer> inorder(TreeNode curr){
        List<Integer> inorder = new ArrayList<>();
        inorderUtil(curr, inorder);
        return inorder;
    }
    
    public static void inorderUtil(TreeNode curr, List<Integer> list){
        if ( curr == null ) return;
        inorderUtil(curr.left, list);
        list.add(curr.val);
        inorderUtil(curr.right, list);
    }
    

    // optimized approach
    // time complexity : O(h) h -> height of the tree
    // space complexity : O(1)
    public static int floor(TreeNode root, int key){
        TreeNode curr = root;
        int floor = -1;
        while ( curr != null ){
            if ( curr.val <= key )
                floor = curr.val;
            if( curr.val == key )
                break;
            else if ( curr.val < key )
                curr = curr.right;
            else 
                curr = curr.left;
        }
        return floor;
    }
}
