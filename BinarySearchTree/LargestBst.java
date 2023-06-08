package BinarySearchTree;


class NodeValues{
    int minEle, maxEle, size;
    public NodeValues(int minEle, int maxEle, int size){
        this.minEle = minEle;
        this.maxEle = maxEle;
        this.size = size;
    }
}
public class LargestBst {
    // optimized appraoch 
    // key the track of the maxEle , minEle and size of the tree
    // if  leftSubtree.maxVal < root.val < rightSubtree.minVal
    // then return the currSize of the tree 
    // else return the max value of bst's present in the left and right subtrees
    // time complexity : O(n)
    // space complexity : O(1)
    static int largestBst(TreeNode root){
        return largestBstUtil(root).size;
    }
    
    static NodeValues largestBstUtil(TreeNode root ){
        if ( root == null ) return new NodeValues(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeValues left = largestBstUtil(root.left);
        NodeValues right = largestBstUtil(root.right);
        if( left.maxEle < root.val && right.minEle > root.val ){
            // It is a bst
            return new NodeValues(Math.min(root.val, left.minEle), Math.max(right.maxEle, root.val), 1 + left.size + right.size);
        }else{
            return new NodeValues(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        }
    }
    // Brute force approach
    // check the root, and use validate bst
    // if valid bst return it
    // otherwise make recursive calls on left and right subtree
    // time complexity : O(n^2)
    // space complexity : O(1)
    static TreeNode prev;
    static int largestBst1(TreeNode root)
    {
        if ( root == null ) return 0;
        prev = null;
        if ( validateBinaryTree(root)){
            int [] size = new int [1];
            countTreeNode(root, size);
             return size[0];
        }else{
            int left = largestBst(root.left);
            int right = largestBst(root.right);
            return Math.max(left, right);
        }
    }
    public static void countTreeNode(TreeNode root, int [] nodes){
        if ( root == null ) return;
        countTreeNode(root.left, nodes);
        nodes[0]++;
        countTreeNode(root.right, nodes);
    }
    public  static boolean validateBinaryTree(TreeNode root){
        if ( root == null  ) return true;
        boolean left = validateBinaryTree(root.left);
        if (!left) return false;
        if ( prev != null && prev.val >= root.val) return false;
        prev = root;
        return validateBinaryTree(root.right);
    }
}
