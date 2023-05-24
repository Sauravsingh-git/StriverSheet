package BinaryTree.MediumProblems;

import java.util.*;
public class TopView {
    class Pair {
        int pos;
        TreeNode node;
        public Pair(TreeNode node, int pos){
            this.node = node;
            this.pos  = pos;
        }
    }
    class Solution
    {
        // Top view of the binary tree
        // Time complexity : O(n) -> to traverse the tree
        //                 + O(nlogn) -> to enter the element in the treeMap
        //                 = O(nlogn)
        // Space complexity : O(n)
        // Approach : We assign position to every node present in the tree
        //            -> a node left to the parent will pos = parentPos -1
        //            -> a node right to the parent will pos = parentPos + 1
        // for top if node is present at a pos at higher level we do not include the element at the same pos at the bottom level
        // we maintain a TreeMap to store the entries at position in sorted order

        // ** further optimisation we record a leastPos and maxPos
        // and store the entries in HashMap instead of TreeMap which would further reduce the timecomplexity to O(n) from O(nlogn)
        public ArrayList<Integer> topView(TreeNode root){
            if ( root == null ) return new ArrayList<>();
            Queue < Pair > queue = new LinkedList<>();
            Map < Integer, Integer> map = new TreeMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            queue.offer(new Pair(root, 0));
            while( !queue.isEmpty() ){
                Pair temp = queue.poll();
                if(!map.containsKey(temp.pos)){
                    map.put(temp.pos, temp.node.val);
                }
                if( temp.node.left != null ) queue.offer(new Pair(temp.node.left, temp.pos -1));
                if( temp.node.right != null ) queue.offer(new Pair( temp.node.right, temp.pos + 1));
            }
            for ( Map.Entry<Integer, Integer> entry  : map.entrySet()){
                result.add(entry.getValue());
            }
            return result;
        }
    }

    // Bottom view of the tree
    // approach : the only difference between the top view and the bottom view is that
    // in bottom view we do not need to check if the node at a given position is already present
    public ArrayList<Integer> bottomView(TreeNode root){
        if ( root == null ) return new ArrayList<>();
        Queue < Pair > queue = new LinkedList<>();
        Map < Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.offer(new Pair(root, 0));
        while( !queue.isEmpty() ){
            Pair temp = queue.poll();
                map.put(temp.pos, temp.node.val);
            if( temp.node.left != null ) queue.offer(new Pair(temp.node.left, temp.pos -1));
            if( temp.node.right != null ) queue.offer(new Pair( temp.node.right, temp.pos + 1));
        }
        for ( Map.Entry<Integer, Integer> entry  : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}

