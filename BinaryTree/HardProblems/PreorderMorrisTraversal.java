package BinaryTree.HardProblems;
 import java.util.*;
public class PreorderMorrisTraversal {
     // preorder morris traversal
     public List<Integer> preorderTraversal(TreeNode root ){
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while ( curr != null ){
            if( curr.left == null ) {
                preorder.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode temp = curr.left;
                while ( temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if ( temp.right != curr ){
                    preorder.add(curr.val);
                    temp.right = curr;
                    curr = curr.left;
                }else{
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}
