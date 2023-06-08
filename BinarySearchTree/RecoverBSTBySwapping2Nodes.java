package BinarySearchTree;
import java.util.*;

public class RecoverBSTBySwapping2Nodes {
   // optimized approach
   // there will be 2 cases : 
   // i) when the anomalies are adjacent ii) when they are adjancent
   // find the first anomaly where prev node is greater than the curr node
   // find the second anomaly where prev node is greater than the curr node
   // if two anomalies are found swap them 
   // otherwise swap first anomaly with the middle node
    // Time complexity : O(n)
    // Space complexity : O(1)
    TreeNode prev, first, middle, last;
    public void recoverTree(TreeNode root){
        prev = first = middle = last = null;
        inorder(root);
        if( first != null && last != null ){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else{
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public void inorder(TreeNode root){
        if( root == null ) return;
        inorder(root.left);
        if( prev != null && prev.val > root.val){
            if( first == null ){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
    // brute force Approach
    // approach : get the inorder traversal and find the anomalies in the traversal
    // after finding the anomalies correct the tree by replacing value in both the nodes
    // time complexity : O(n)
    // space complexity : O(n)
    public void recoverTree1(TreeNode root) {
        // get the inorder traversal to find the anomaly
        List<Integer> inorder = new ArrayList<>();
        inorderUtil( root, inorder );
        Integer firstEle = null, secondEle = null;
        // find the first anomaly
        for ( int i = 0 ; i < inorder.size(); i++ ){
            if(inorder.get(i) > inorder.get(i+1)){
                firstEle = inorder.get(i);
                break;
            }
        }
        // find the second anomaly
        for ( int i = inorder.size() -1; i >= 0; i-- ){
            if( inorder.get(i) < inorder.get(i-1)){
                secondEle = inorder.get(i);
                break;
            }
        }

        correctTree(root, firstEle, secondEle);

    }

    public void correctTree(TreeNode root, int firstEle, int secondEle){
        if( root == null ) return;
        if( root.val == firstEle){
            root.val = secondEle;
        }else if (root.val == secondEle){
            root.val = firstEle;
        }
        correctTree(root.left, firstEle, secondEle);
        correctTree(root.right, firstEle, secondEle);
    }
    public void inorderUtil(TreeNode root, List<Integer> inorder){
        if ( root == null ) return;
        inorderUtil(root.left, inorder);
        inorder.add(root.val);
        inorderUtil(root.right, inorder);
    }
}
