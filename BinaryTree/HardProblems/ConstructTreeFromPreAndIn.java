package BinaryTree.HardProblems;


import java.util.Map;
import java.util.HashMap;
public class ConstructTreeFromPreAndIn {
    // Time complexity : O(n)
    // Space complexity : O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < len; i++ ){
            map.put(inorder[i], i);
        }
        return buildTreeUtil(preorder, inorder, 0, len-1, 0, len-1, map);
    }

    private TreeNode buildTreeUtil(int [] preorder, int [] inorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> map ){
        if(pEnd < pStart || iEnd < iStart) return null;
        int ele = preorder[pStart];
        TreeNode node = new TreeNode(ele);
        int inorderIdx = map.get(ele);
        int leftSubtree = inorderIdx - iStart;
        //int rightSubtree = iEnd - inorderIdx;
        node.left = buildTreeUtil(preorder, inorder, pStart + 1, pStart + leftSubtree, iStart, inorderIdx -1, map);
        node.right = buildTreeUtil(preorder, inorder, pStart + leftSubtree + 1, pEnd, inorderIdx +1, iEnd, map);
        return node;
    }
}
