package BinaryTree.HardProblems;

public class SerializeDeserializeBT {
    // Approach 2 :  using preorder traversal to serialize the binary tree
    String NULL = "#";
    String sep = " ";
    // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(TreeNode curr, StringBuilder sb ){
        if( curr == null ){
            sb.append(NULL).append(sep);
            return;
        }
        sb.append(curr.val).append(sep);
        serializeUtil(curr.left, sb);
        serializeUtil(curr.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int [] idx = new int [1];
        idx[0] = 0;
        String [] nodes = data.split(" ");
        return deserializeUtil(nodes, idx);
    }

    private TreeNode deserializeUtil(String [] nodes, int [] idx){
        if( nodes[idx[0]].equals(NULL) ){
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;
        TreeNode leftSubtree = deserializeUtil(nodes, idx);
        TreeNode rightSubtree = deserializeUtil(nodes, idx);
        root.left = leftSubtree;
        root.right = rightSubtree;
        return root;
    }
    // Approach 1 : using level order travesal to serialize the binary tree
    // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     StringBuffer sb = new StringBuffer();
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while( !queue.isEmpty() ){
    //         TreeNode curr = queue.poll();
    //         if( curr == null ){
    //             sb.append("# ");
    //             continue;
    //         }
    //         sb.append(curr.val + " ");
    //         queue.offer(curr.left);
    //         queue.offer(curr.right);
    //     }
    //     return sb.toString();
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     if(data.length() == 2) return null;
    //     String [] nodes = data.split(" ");
    //     int idx= 0;
    //     TreeNode root = new TreeNode(Integer.parseInt(nodes[idx]));
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while ( idx < nodes.length-1){
    //         TreeNode curr = queue.poll();
    //         if( !nodes[++idx].equals("#") ){
    //             curr.left = new TreeNode(Integer.parseInt(nodes[idx]));
    //             queue.offer(curr.left);
    //         }

    //         if( !nodes[++idx].equals("#") ){
    //             curr.right = new TreeNode(Integer.parseInt(nodes[idx]));
    //             queue.offer(curr.right);
    //         }
    //     }

    //     return root;
    // }
}
