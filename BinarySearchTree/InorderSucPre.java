package BinarySearchTree;

public class InorderSucPre {
    TreeNode suc = null, pre = null;

    // find the inorder successor and predeccesor in a tree
    // optimized approach
    // time complexity : o(h) h-> height of the tree
    // space complexity : O(1), constant time
    public void findPreSuc(TreeNode root, int key){
        // there will be 2 cases
        // when element is in the tree
        // either the node with key will have child in which the pre and suc will be found in them and can be found how we find inorder suc and pre
        // If it does not have right and left child either we have already traversed them of it does not have them;
        // when element is not in the tree
        // if element is not in the tree we will always be moving the branch where we could have found the element it was present in the tree
        // therefore we will always pass through the element just bigger and just smaller than it.
        // and hence updating the pre and suc variables
        TreeNode curr = root;
        while( curr != null ){
            // if the element is present in the tree
            if( curr.val == key ){
                if ( curr.left != null ){
                    pre = curr.left;
                    while ( pre.right != null )
                        pre = pre.right;
                }
                if ( curr.right != null ){
                    suc = curr.right;
                    while( suc.left != null)
                        suc = suc.left;
                }
                break;
            }
            else if ( curr.val > key ){
                suc = curr;
                curr = curr.left;
            }else{
                pre = curr;
                curr = curr.right;
            }
        }
    }

    // approach 2 : 
    // the code needed to find the ceil and floor
    // but you will need to adjust the if else condition accordingly for the cases when the element is in the tree
    // we cannot return the element like we did in the floor/ ceil question
    // so when finding the successor, we will handle if ( curr.val  < key ){ curr = curr.left }else { ... we will move to rightsubtree}
    // similary when finding the predeccesor, will will handle as if ( curr.val > key){curr = curr.right }else{ ... we will move to leftsubtree}
    public  void findPreSuc1(TreeNode root, int key){
        TreeNode curr = root;
        // finding the succesor
        while ( curr != null ){
            if ( curr.val > key ) suc = curr;
            if ( curr.val > key )
                curr = curr.left;
            else 
                curr = curr.right;
        }
        // finding the predeccessor
        curr = root;
        while ( curr != null ){
            if ( curr.val < key ) pre = curr;
            if ( curr.val < key )
                curr = curr.right;
            else 
                curr = curr.left;
        }
    }

    // approach 3 : find the inorder traversal and then return the inorder successor as well and inorder predecessor usign traversal
}
