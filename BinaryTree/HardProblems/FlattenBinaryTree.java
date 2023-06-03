package BinaryTree.HardProblems;

import java.util.Stack;
public class FlattenBinaryTree {
    // Approach 2 : using external stack instead of recursion
    //              Space Complexity : O(n)
    //              Time Complexity : O(n)
    public void flatten(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            if(currNode.right != null)
                stack.push(currNode.right);
            if(currNode.left != null)
                stack.push(currNode.left);
            if(!stack.isEmpty()){
                currNode.right = stack.peek();
            }
            currNode.left = null;
        }
    }
    // Approach 1 : Space Complexity : O(n)
    //              Time Complexity : O(n)
    TreeNode prev = null;
    public void flatten1(TreeNode root) {
        
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
