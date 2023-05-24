package BinaryTree.MediumProblems;

import java.util.*;
public class VerticalOrderTraversal {
    // intuition : for vertical order traversal, we will need cols and well as row position
    // we can either use this approach or we could add a feild level in pair class
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int maxPos, minPos;
        int level = 1;
        maxPos = minPos = 0;
        queue.offer( new Pair(root, 0 ));
        while( !queue.isEmpty() ){
            int size = queue.size();
            for ( int i = 0; i < size; i++){
                Pair temp = queue.poll();
                maxPos = Math.max(maxPos, temp.pos);
                minPos = Math.min(minPos, temp.pos);
                map.computeIfAbsent(temp.pos, x-> new TreeMap<>()).computeIfAbsent(level, x-> new PriorityQueue<>()).offer(temp.node.val);
                if( temp.node.left != null ) queue.add(new Pair (temp.node.left, temp.pos - 1));
                if( temp.node.right != null ) queue.add(new Pair(temp.node.right, temp.pos+1));
            }
            level++;
        }

        for( int i = minPos; i <= maxPos; i++ ){
            Map<Integer, PriorityQueue<Integer>> temp = map.get(i);
            List<Integer> tempList = new ArrayList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> entry : temp.entrySet()){
                Queue<Integer> tempQueue = entry.getValue();
                while( tempQueue.size() > 0){
                    tempList.add(tempQueue.poll());
                }
            }
            result.add(tempList);
        }
        return result;
    }

    class Pair{
        TreeNode node;
        int pos;
        public Pair(TreeNode node, int pos){
            this.pos = pos;
            this.node = node;
        }
    }
}
