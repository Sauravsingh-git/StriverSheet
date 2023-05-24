package BinaryTree.MediumProblems;

import java.util.*;
public class RightSideView {
    // approach 1 : maintaing a hashmap to keep track of rightmost element at every level
    // time complexity : O(n)
    // space complexity : O(n)
    public List<Integer> rightSideView1(TreeNode root) {
        if( root == null ) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int level = 1;
        queue.offer(root);
        while( !queue.isEmpty() ){
            int size = queue.size();
            for( int i = 0; i < size; i++ ){
                TreeNode temp = queue.poll();
                map.put(level, temp.val);
                if(temp.left != null ) queue.offer(temp.left);
                if(temp.right != null ) queue.offer(temp.right);
            }
            level++;
        }

        for( int i = 1; i < level; i++ ){
            result.add(map.get(i));
        }
        return result;
    }

    // approach 2 : using recursion and always move to right node first to 
    // get to the right most possible at a level
    // time complexity : O(n)
    // space complexity : O(h)

    public List<Integer> rightSideView(TreeNode root ){
        List<Integer> result = new ArrayList<>();
        rightSideViewUtil(root, 0, result);
        return result;
    }

    public void rightSideViewUtil(TreeNode root, int level, List<Integer> list){
        if( root == null ) return;
        if(list.size() == level){
            list.add(root.val);
        }
        rightSideViewUtil(root.right, level + 1, list);
        rightSideViewUtil(root.left, level + 1, list);
    }


    public List<Integer> leftSideView (TreeNode root){
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public void leftSideViewUtil(TreeNode root, int level, List<Integer> list){
        if( root == null ) return;
        if(list.size() == level)
            list.add(root.val);
        leftSideViewUtil(root.left, level+1, list);
        leftSideViewUtil(root.right, level + 1, list);
    }
}
