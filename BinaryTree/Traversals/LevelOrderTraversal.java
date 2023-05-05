package BinaryTree.Traversals;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderTraversal {
    // recursive approach
    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        levelOrderUtil(root, res, 0);
        return res;
    }

    public void levelOrderUtil(TreeNode root, List<List<Integer>> res, int height){
        if( root == null ) return;
        if( height >= res.size()) res.add(new ArrayList<>());
        res.get(height).add(root.val);
        levelOrderUtil(root.left, res, height+1);
        levelOrderUtil(root.right, res, height+1);
    }

    // iterative approach
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> currList = new ArrayList<>();
            int size = queue.size();
            for( int i =0; i < size; i++ ){
                if(queue.peek().left != null ) queue.offer(queue.peek().left);
                if(queue.peek().right != null ) queue.offer(queue.peek().right);
                currList.add(queue.poll().val);
            }
            res.add(currList);
        }
        return res;
    }
}
