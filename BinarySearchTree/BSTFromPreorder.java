package BinarySearchTree;

import java.util.*;
public class BSTFromPreorder {
    // approach 3 : 
    // time complexity : O(n)
    // space complexity : o(1)
    public TreeNode bstFromPreorder(int [] preorder){
        return bstFromPreorderUtil( preorder, 1001, new int[]{0});
    }

    public TreeNode bstFromPreorderUtil(int [] preorder, int upperBound, int [] idx){
        if(idx[0] == preorder.length || preorder[idx[0]] > upperBound) return null;
        TreeNode curr = new TreeNode(preorder[idx[0]++]);
        curr.left = bstFromPreorderUtil(preorder, curr.val, idx);
        curr.right = bstFromPreorderUtil(preorder, upperBound, idx);
        return curr;
    }


    // approach 2 : 
    // sort the preorder to get inorder traversal and then create tree from inorder traversal and preorder
    // time complexity : O(nlogn + n) nlogn -> sorting the array
    //                                n -> creating the tree
    // Space complexity : O(n) for maintianing the hashMap for inorderMap
    public TreeNode bstFromPreorder1(int [] preorder){
        // creating the inorder array
        int [] inorder = preorder.clone();
        Arrays.sort(inorder);
        return buildTree(preorder, inorder);
    }

    public TreeNode buildTree( int [] preorder, int [] inorder){
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for ( int i = 0; i < inorder.length; i++ ){
            inorderMap.put(inorder[i], i);
        }
        return buildTreeUtil( preorder, 0, preorder.length -1, inorder, 0, inorder.length -1, inorderMap);
    }

    public TreeNode buildTreeUtil(int [] preorder, int pS, int pE, int [] inorder, int iS, int iE, Map<Integer, Integer> inorderMap){
        if ( pS > pE || iS > iE) return null;
        TreeNode root = new TreeNode(preorder[pS]);
        int inorderIdx = inorderMap.get(root.val);
        int leftSubtree = inorderIdx - iS;
        //int rightSubtree = iE - inorderIdx;
        root.left = buildTreeUtil(preorder, pS+1, pS+leftSubtree, inorder, iS, inorderIdx-1, inorderMap);
        root.right = buildTreeUtil(preorder, pS+leftSubtree+1, pE, inorder, inorderIdx+1, iE, inorderMap);
        return root;
    }
    // brute force solution 
    // simply insert all the elements in the binary tree
    // time complexity : O(n^2)
    public TreeNode bstFromPreorder2(int[] preorder) {
        TreeNode root = null;
        for( int ele : preorder){
            root = insert(root, ele);
        }
        return root;
    }

    TreeNode insert(TreeNode curr, int val){
        if( curr == null ) return new TreeNode(val);

        if( curr.val > val ) curr.left  = insert(curr.left, val);
        if( curr.val < val ) curr.right = insert(curr.right, val);
        return curr;
    }
}
