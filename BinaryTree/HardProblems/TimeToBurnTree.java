package BinaryTree.HardProblems;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
public class TimeToBurnTree {

    // Time complexity : O(n)
    // Space complexity : O(n)
    public static int minTime(TreeNode root, int target){
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);
        // Note : we dont consider the time for burning the startNode
        // So if tree contains only one node it will take 0 seconds to burn
        int time = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        TreeNode startTreeNode = findTreeNode(root, target);
        queue.offer(startTreeNode);
        while( !queue.isEmpty() ){
            int size = queue.size();
            if (visited.size() == parentMap.size() ) break;
            for ( int i = 0; i < size; i++ ){
                TreeNode temp = queue.poll();
                visited.add(temp.val);
                if (temp.left != null && !visited.contains(temp.left.val))
                    queue.offer(temp.left);
                if( temp.right != null && !visited.contains(temp.right.val))
                    queue.offer(temp.right);
                TreeNode parent = parentMap.get(temp);
                if( parent != null && !visited.contains(parent.val))
                    queue.offer(parent);
            }
            time++;
        }
        return time;
    }
    
    public static void buildParentMap(TreeNode curr, TreeNode parent, Map<TreeNode, TreeNode> map){
        if( curr == null ) return;
        map.put(curr, parent);
        if( curr.left != null ) buildParentMap(curr.left, curr, map);
        if( curr.right != null ) buildParentMap(curr.right, curr, map);
    }
    
    public static TreeNode findTreeNode(TreeNode curr, int target){
        if( curr == null || curr.val == target) return curr;
        TreeNode left = findTreeNode(curr.left, target);
        TreeNode right = findTreeNode( curr.right, target);
        return left == null ? right : left;
    }
}
