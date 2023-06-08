package BinarySearchTree;


import java.util.*;
interface BSTIteratorInt{
    public boolean hasNext();
    public Integer next();
}

class BSTIterator implements BSTIteratorInt{
    Stack<TreeNode> stack;
    public BSTIterator (TreeNode root){
        stack = new Stack<>();
        pushAll(root);
    }

    public void pushAll(TreeNode curr){
        while( curr != null ) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext(){
        return stack.size() != 0;
    }

    public Integer next(){
        TreeNode temp = stack.pop();
        if( temp.right != null ) pushAll(temp.right);
        return temp.val;
    }

}
class BSTReverseIterator implements BSTIteratorInt{
    Stack<TreeNode> stack;
    public BSTReverseIterator (TreeNode root){
        stack = new Stack<>();
        pushAll(root);
    }

    public void pushAll(TreeNode curr){
        while( curr != null ) {
            stack.push(curr);
            curr = curr.right;
        }
    }

    public boolean hasNext(){
        return stack.size() != 0;
    }

    public Integer next(){
        TreeNode temp = stack.pop();
        if( temp.left != null ) pushAll(temp.left);
        return temp.val;
    }

}
class TwoSumInBST {
        // optimized approach 
        // We will be using two iterators one which starts from start and one which starts from last
        // Time complexity : O(n)
        // space complexity : O(h) h => height of the binary tree
        public boolean findTarget(TreeNode root, int k ){
            BSTIteratorInt itr1 = new BSTIterator(root);
            BSTIteratorInt itr2 = new BSTReverseIterator(root);
            int val1  = itr1.next(), val2 = itr2.next();
            while( itr1.hasNext() && itr2.hasNext()){
                if( val1 == val2 ) break;
                if( val1 + val2 == k ) return true;
                else if ( val1 + val2 > k ) val2 = itr2.next();
                else val1 = itr1.next();
            }
            return false;
        }


    // brute force approach
    // get the inorder traversal and use 2 pointer approach on it 
    // time complexity : O(n)
    // space complexity : O(n)
    public boolean findTarget1(TreeNode root, int k) {

        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int low = 0, high = inorder.size() - 1;
        while( low < high){
            int currSum = inorder.get(low) + inorder.get(high);
            if( currSum == k) return true;
            else if ( currSum > k ) high--;
            else low++;
        }
        return false;
    }

    public void inorderTraversal(TreeNode curr, List<Integer> list){
        if ( curr == null ) return ;
        inorderTraversal(curr.left, list);
        list.add(curr.val);
        inorderTraversal(curr.right, list);
    }
}    

