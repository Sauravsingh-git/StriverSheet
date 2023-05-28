package BinaryTree.HardProblems;

import java.util.*;
public class PathToGivenNode {
    // find the path to the given node from the root node
    // It is always gauranteed that node will be present in the tree
    public ArrayList<Integer> findPath(TreeNode A, int B) {
        ArrayList<Integer> list  = new ArrayList<>();
        findPathUtil(A, B, list);
        Collections.reverse(list);
        return list;
    }
    
    public boolean findPathUtil(TreeNode root, int target, ArrayList<Integer> list){
        if( root == null ) return false;
        if ( root.val == target ){ 
            list.add(root.val);
            return true;
        }
        boolean left = findPathUtil(root.left, target, list);
        boolean right = findPathUtil(root.right, target , list);
        if( left || right ) list.add(root.val);
        return left || right;
    }
}
