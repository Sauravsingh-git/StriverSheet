package BinaryTree.MediumProblems;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Collections;
public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // approach 1 : Firstly, we do level order traversal than reverse the alternating levels
        // time complexity : O(n)
        // space complexity : O(n)
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for ( int i = 0; i < size; i++ ){
                TreeNode temp = queue.poll();
                tempList.add(temp.val);
                if( temp.left != null ) queue.offer(temp.left);
                if( temp.right != null ) queue.offer(temp.right);
            }
            result.add(tempList);
        }

        for(int i=1; i<result.size(); i += 2){
            Collections.reverse(result.get(i));
        }
        return result;
    }


    // approach 2 : 
    // time complexity : O(n)
    // space complexity : O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if ( root == null ) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack <TreeNode> currStack = new Stack<>();
        boolean reverseOrder = false;
        currStack.push(root);

        while( !currStack.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            int size = currStack.size();
            for ( int i = 0; i < size; i++ ){
                TreeNode temp = currStack.pop();
                tempList.add(temp.val);
                if( reverseOrder ){
                    if(temp.right != null ) tempStack.push(temp.right);
                    if( temp.left != null ) tempStack.push(temp.left);
                }else{
                    if( temp.left != null ) tempStack.push(temp.left);
                    if( temp.right != null ) tempStack.push(temp.right);
                }
            }
            reverseOrder = !reverseOrder;
            currStack = tempStack;
            result.add(tempList);
        }
        return result;

    }
}
