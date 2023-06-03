package BinaryTree.HardProblems;
import java.util.List;
import java.util.ArrayList;
public class InorderMorisTraversal {
    // Morris order traversal
    // for this algorithm we will have three cases
    // case 1 : when there is no left subtree -> just add the element to the list
    // case 2 : when the rightmost node of the left subtree points to null 
    // case 3 : When the rightmost node of the left subtree points to the curr node
    //          i.e., the  leftsubtree has already been traversed, add the curr ele and we need to move 
    //          towards the rightsubtree
    public List<Integer> inorderTraversal(TreeNode root ){
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while ( curr != null ){
            if( curr.left == null ){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode temp = curr.left;
                while( temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if( temp.right == null ){
                    temp.right = curr;
                    curr = curr.left;
                }
                else{
                    temp.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }
                
            }
        }
        return list;
    }
}
