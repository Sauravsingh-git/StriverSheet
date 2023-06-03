package BinaryTree.HardProblems;

public class TotalNodesInCompleteBinaryTree {
    // Time complexity : O(logn)
    // space complexity : O(1)
    // intution : we find the height of the leftmost branch and rightmost branch
    // If both are equal, the last level is completely filled and we will return 2^height - 1
    // If they are not equal, we recursively find the nodes in the subtrees 
    // and return the nodes in leftSubtree + nodes in right Subtree + 1 ( for the root node )
    public int countNodes(TreeNode root ){
        if( root == null ) return 0;
        TreeNode curr = root;
        int leftHeight = 0;
        while( curr != null ){
            curr = curr.left;
            leftHeight++;
        }

        curr = root;
        int rightHeight = 0;
        while(curr != null){
            curr = curr.right;
            rightHeight++;
        }
        if ( rightHeight == leftHeight )
            return (int)Math.pow(2, rightHeight) -1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // intuition : we traverse the whole tree in inorder traversal(we can use any traversal) and increase the counter when we encounter a node
    public int countNodesBruteForce(TreeNode root) {
        // Brute force approach
        // traverse the whole tree using any traversal 
        // Time complexity : O(n)
        // Space complexity : O(n) Auxillary Space
        int [] arr = new int[1];
        countNodesUtil(root, arr);
        return  arr[0];
    }

    public void countNodesUtil(TreeNode curr, int [] arr){
        if ( curr == null ) return;
        countNodesUtil(curr.left, arr);
        arr[0]++;
        countNodesUtil(curr.right, arr);
    }
}
