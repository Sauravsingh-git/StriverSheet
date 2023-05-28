package BinaryTree.MediumProblems;
import java.util.Queue;
import java.util.LinkedList;
public class SymmetricTree {
    // iterative approach
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if( first == null && second == null ) continue;
            if( first == null || second == null ) return false;
            if ( first.val != second.val) return false;
            queue.offer(first.left);
            queue.offer(second.right);
            queue.offer(first.right);
            queue.offer(second.left);
        }
        return true;
    }
    //recursive approach : fastest approach
    // Intuition : for 2 trees to be symetric, containing only three elements 
    // at every node, the right child of tree1 should be symmetric to left child of tree2
    // similary left child of tree1 should be equal to right child of tree2
    public boolean isSymmetricRec(TreeNode root){
        return isSymmetricRecUtil(root.left, root.right);
    }

    public boolean isSymmetricRecUtil(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if( left == null || right == null ) return false;
        if(left.val == right.val) return isSymmetricRecUtil(left.left, right.right) && isSymmetricRecUtil(left.right, right.left);
        else return false;
    }
    // Brute force approach
    // invert the right subtree and then check if both the trees are equal
    // public boolean isSymmetric(TreeNode root) {
    //     root.right = invert(root.right);
    //     return checkSimilarTree(root.left, root.right);
    // }

    // public boolean checkSimilarTree(TreeNode root1, TreeNode root2){
    //     if(root1 == null && root2 == null) return true;
    //     if( root2 == null || root1 == null) return false;
    //     if( root1.val == root2.val) return checkSimilarTree(root1.left, root2.left) && checkSimilarTree(root1.right, root2.right);
    //     else return false;
    // }

    // public TreeNode invert(TreeNode root){
    //     if( root == null) return root;
    //     TreeNode leftSubTree = invert(root.left);
    //     TreeNode rightSubTree = invert(root.right);
    //     root.left = rightSubTree;
    //     root.right = leftSubTree;
    //     return root;
    // }
}
