package BinaryTree.HardProblems;
import java.util.Map;
import java.util.HashMap;

public class ConstructTreeFromPostAndIn {
    // Time complexity : O(n)
    // Space complexity : O(n) for hashMap
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < len; i++ ){
            map.put(inorder[i], i);
        }
        return buildTreeUtil(inorder, postorder, 0, len -1, 0, len -1, map);

    }

    private TreeNode buildTreeUtil( int [] inorder, int [] postorder, int iStart, int iEnd, int pStart, int pEnd, Map<Integer, Integer> map){
        if( iStart > iEnd || pEnd < pStart) return null;
        int root = postorder[pEnd];
        TreeNode node = new TreeNode(root);
        int inorderRootIdx = map.get(root);
        int leftSubtree = inorderRootIdx - iStart;
        //int rightSubtree = iEnd - inorderRootIdx;

        node.left = buildTreeUtil(inorder, postorder, iStart, inorderRootIdx - 1, pStart, pStart + leftSubtree-1, map );
        node.right= buildTreeUtil(inorder, postorder, inorderRootIdx + 1, iEnd, pStart + leftSubtree, pEnd-1,map);
        return node;
    }
    // **** common mistake : forgetting to add -1 in pEnd in node.right call

    // Without using the hashMap
    // Time complexity : O(n^2)
    // Space complexity : O(1)
    // public TreeNode buildTreeUtil(int [] inorder, int iSIdx, int iEIdx, int [] postorder, int pSIdx, int pEIdx){
    //     if(iSIdx > iEIdx || pSIdx > pEIdx) return null;
    //     int rootEle = postorder[pEIdx];
    //     TreeNode root = new TreeNode(rootEle);
    //     int rootIdx = iSIdx;
    //     for( int i = iEIdx; i >= iSIdx; i--){
    //         if(inorder[i] == rootEle){
    //             rootIdx = i;
    //             break;
    //         }
    //     }
    //     int leftSubtreeLen = rootIdx - iSIdx;
    //     int rightSubtreeLen = iEIdx - rootIdx;

    //     root.left = buildTreeUtil(inorder, iSIdx, rootIdx-1, postorder, pSIdx, pSIdx + leftSubtreeLen -1);
    //     root.right = buildTreeUtil(inorder, rootIdx + 1, iEIdx, postorder, pEIdx - rightSubtreeLen, pEIdx -1);
    //     return root;
    // }
}
