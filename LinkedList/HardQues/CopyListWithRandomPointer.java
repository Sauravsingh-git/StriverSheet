package HardQues;
import java.util.Map;
import java.util.HashMap;
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // Time complexity : O(n)
        // Space complexity : O(1)
        Node curr = head;

        while ( curr != null ){
            Node next = curr.next;
            Node temp = new Node(curr.val);
            curr.next = temp;
            temp.next = next;
            curr = temp.next;
        }

        curr = head;
        while ( curr != null ){
            if(curr.random!=null)
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        Node resultHead, resCurr;
        resCurr = new Node(974);
        resultHead = resCurr;
        while ( curr != null ){
            Node next = curr.next.next;
            resCurr.next = curr.next;
            curr.next = next;
            resCurr = resCurr.next;
            curr = next;
        }
        return resultHead.next;
    }

    //----------------------------------------------------------------------------------------------------------------

    public Node copyRandomList1(Node head) {
        // Time Complexity : O(N)
        // Space Complexity : O(N)
        Map<Node, Node> map = new HashMap<>();
        Node resCurr = new Node(123), resHead = resCurr;
        Node curr = head;
        while ( curr != null ){
            resCurr.next = new Node(curr.val);
            resCurr = resCurr.next;
            map.put(curr, resCurr);
            curr = curr.next;
        }

        curr = head;
        while( curr != null ){
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return resHead.next;
    }
}

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val){
        next = random = null;
    }
}