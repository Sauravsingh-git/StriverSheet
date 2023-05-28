package BinaryTree.HardProblems;

class MaximumWidthOfBinaryTree{
    public int widthOfBinaryTree(TreeNode root){
        Queue<Node> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.add(new Node(root, 0));
        while( !queue.isEmpty()){
            int len = queue.size();
            int leftMost = 0;
            int rightMost = 0;
            for ( int i = 0; i < len; i++ ){
                Node temp = queue.remove();
                if ( i == 0 ){
                    leftMost = temp.levelIdx;
                }
                if ( i == len -1){
                    rightMost = temp.levelIdx;
                }
                if ( temp.node.left != null ){
                    queue.add(new Node(temp.node.left, 2 * temp.levelIdx + 1));
                }
                if ( temp.node.right != null ){
                    queue.add(new Node(temp.node.right, 2 * temp.levelIdx + 2));
                }
            }
            maxWidth = Math.max( maxWidth , rightMost - leftMost + 1);
        }
        return maxWidth;
    }
    class Node{
        TreeNode node;
        int levelIdx;
        public Node( TreeNode node, int levelIdx){
            this.node = node;
            this.levelIdx = levelIdx;
        }
    }
}