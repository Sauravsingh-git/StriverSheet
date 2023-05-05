package BinaryTree.Traversals;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class AllTraversalIn1Itr {
    public void preInPosTraversal(TreeNode root ){
        Stack<Pair> st = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if( root == null ) return;
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair temp = st.pop();
            if( temp.num == 1){
                temp.num++;
                st.push(temp);
                pre.add(temp.node.val);
                if(temp.node.left != null )
                    st.push(new Pair(temp.node.left, 1));
            }else if (temp.num == 2){
                in.add(temp.node.val);
                temp.num++;
                st.push(temp);
                if(temp.node.right != null )
                    st.push(new Pair(temp.node.right, 1));
            }else{
                post.add(temp.node.val);    
            }
        }
    }
}

class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num ){
        this.node = node;
        this.num = num;
    }
}
