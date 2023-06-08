package BinarySearchTree;

public class KthSmallestInBST {
    // best approach
    // can also be used for kth largest
    // for kthLargest we just change the order of calls in inorder
    // first call will be the rigth instead of the left
    // i.e., inorder(root.right) ele[0]-- inorder(root.left)
    public int kthSmallest(TreeNode root, int k ){
        int [] ele = {k};
        return inorderKthSmallest(root, ele).val;
    }

    public TreeNode inorderKthSmallest(TreeNode root, int [] ele){
        if( root == null ) return null;
        TreeNode left = inorderKthSmallest(root.left, ele);
        if ( left != null ) return left;
        ele[0]--;
        if( ele[0] == 0 ) return root;
        
        return inorderKthSmallest(root.right, ele);
    }

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!! Important  !!!!!!!!!!!!!!!!!!!!!!!
    // public TreeNode inorderKthLargest(TreeNode root, int [] ele){
    //     if ( root == null ) return null;
    //     TreeNode right = inorderKthLargest(roo.right, ele);
    //     if( --ele[0] == 0 ) return root;

    //     return inoder(root.left, ele);
    // }


    // improved algorithm
    // time complexity : O(h+k) where h => height of tree
    // space complexity : O(h+k)
    // iterative version ( recursive solution will have the same time and space complexity )
    // public int kthSmallest(TreeNode root, int k){
    //     List<Integer> inorder=  new ArrayList<>();
    //     TreeNode curr = root;
    //     Stack<TreeNode> stack = new Stack<>();
    //     while( curr != null || !stack.isEmpty() ){
    //         if( curr != null ){
    //             stack.push(curr);
    //             curr = curr.left;
    //         }else{
    //             if( !stack.isEmpty() ){
    //                 curr = stack.pop();
    //                 if( --k == 0 )
    //                     return curr.val;
    //                 curr = curr.right;
    //             }

    //         }
    //     }
    //     return -1;        
    // }
    // brute force solution
    // time complexity : O(n)
    // space compelxity : O(n)
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> inorder = new ArrayList<>();
    //     inorderTraversal(root, inorder);
    //     return inorder.get(k-1);
    // }

    // private void inorderTraversal(TreeNode root, List<Integer> list){
    //     if(root == null ) return;
    //     inorderTraversal(root.left, list);
    //     list.add(root.val);
    //     inorderTraversal(root.right, list);
    // }
}
