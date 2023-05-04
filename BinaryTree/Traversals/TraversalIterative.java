package BinaryTree;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


public class TraversalIterative {
    // preorder traversal
    public List<Integer> preorderTraversal(TreeNode root ){
        List<Integer> res = new ArrayList<>();
        if(root == null ) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // preorder is node left right
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null ) stack.push(node.right);
            if(node.left != null ) stack.push(node.left);       
        }
        return res;
    }

    // inorder traversal
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr!= null || !stack.isEmpty()){
            if( curr != null ){
                stack.push(curr);
                curr = curr.left;
            }else{
                if(stack.isEmpty())
                    break;
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }


}
