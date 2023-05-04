package BinaryTree;
import java.util.*;
public class PostorderTraversalIterative {
    // using one stack 
    public List<Integer> postorderTraversal(TreeNode root ){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if( root == null ) return list;
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null ){
            if( curr != null ){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null ){
                    temp = stack.pop();
                    list.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        list.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return list;
    }
    // using two stacks
    public List<Integer> postorderTraversal1(TreeNode root ){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if( root == null ) return list;
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left != null ) s1.push(temp.left);
            if(temp.right != null ) s1.push(temp.right);
        }
        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }
}
