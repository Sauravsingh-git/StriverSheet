package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBST {
     // we could also further optimize the solution by using memoization
    // the memoization would implemented through a hashMap<Pair<start, end>, TreeNode>
    // time complexity : O(n * catlanNumber(n))
    // space complexity : O(n * catlanNumber(n))
    public List<TreeNode> generateTrees(int n) {
        return generateTreeUtil(1, n);
    }

    // intution : every node be root once
    // for that root generate all the possible left subtrees and right subtrees
    // the left subtrees would be from ( start, currNode -1) and right subtrees would be from ( currNode + 1, end )
    
    public List<TreeNode> generateTreeUtil(int start, int end ){
        List<TreeNode> list = new ArrayList<>();
        if ( start > end ){
            list.add(null);
            return list;
        }

        List<TreeNode> leftSubtrees;
        List<TreeNode> rightSubtrees;
        for ( int currNode = start; currNode <= end; currNode++ ){
            leftSubtrees = generateTreeUtil(start, currNode-1);
            rightSubtrees = generateTreeUtil(currNode+1, end);

            for ( TreeNode leftNode : leftSubtrees){
                for ( TreeNode rightNode : rightSubtrees){
                    TreeNode currRoot = new TreeNode(currNode);
                    currRoot.left = leftNode;
                    currRoot.right = rightNode;
                    list.add(currRoot);
                }
            }
        }
        return list;
    }
}
