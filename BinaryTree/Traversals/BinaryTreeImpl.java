package BinaryTree.Traversals;
class BinaryTreeImpl{
    public static void main(String [] args){
        Integer [] tree = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        BinaryTreeImpl obj = new BinaryTreeImpl();
        TreeNode root = obj.generateBinaryTree(tree);
        obj.inorderTraversal(root);
        
    }

    public TreeNode generateBinaryTree(Integer [] arr){
        return generateBinaryTree(arr, 0);
    }

    public TreeNode generateBinaryTree( Integer [] arr, int idx){
        if( idx >= arr.length) return null;
        if(arr[idx] == null) return null;
        TreeNode temp = new TreeNode(arr[idx]);
        temp.left = generateBinaryTree(arr, 2*idx+1);
        temp.right = generateBinaryTree(arr, 2*idx+2);
        return temp;
    };

    public void inorderTraversal(TreeNode root ){
        if ( root == null ) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val ){
        this.val = val;
        left = right = null;
    }
}
// C++ implementation of BinaryTree
// #include <stdio.h>
// #include <stdlib.h>
//
// struct TreeNode {
// 	int value;
// 	struct TreeNode* left;
// 	struct TreeNode* right;
// };
// void inorderTraversal(struct TreeNode* root ){
// 	if( root == NULL  ) return;
// 	inorderTraversal(root->left);
// 	printf("%d ", root->value);
// 	inorderTraversal(root->right);
// }
// int main(){
// 	struct TreeNode* root = (struct TreeNode* ) malloc(sizeof(struct TreeNode));
// 	root->value = 2;
// 	root->left = (struct TreeNode* ) malloc(sizeof(struct TreeNode));
// 	root->left->value = 1;
// 	root->left->left = NULL;
// 	root->left->right = NULL;
// 	root->right =  (struct TreeNode* ) malloc(sizeof(struct TreeNode));	
// 	root->right->value = 3;
// 	root->right->left = NULL;
// 	root->right->right = NULL;
// 	inorderTraversal(root);
// 	return 0;
// }