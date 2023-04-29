package DoublyLinkedList;

public class DLL {
    Node head = null;
    Node tail = null;
    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int val){
            this.val = val;
            next = prev = null;
        }
    }

    public void insertAtBeg(int val){
        Node temp = new Node(val);
        if( head == null ){
            head = temp;
            tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    public void insertAtEnd(int val ){
        Node temp = new Node(val);
        if( head == null ){
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }

    public void insertAtIndex(int val, int idx ) throws Exception{
        // the valid index are in the range(0, len(list))
        if(idx == 0){
            insertAtBeg(val);
            return;
        }
        Node temp = new Node(val);
        Node curr = head;
        while(--idx > 0 && curr != null ){
            curr = curr.next;
        }
        if( curr == null )
            throw new Exception("Index out of bound");
        Node next = curr.next;
        temp.prev = curr;
        curr.next = temp;
        temp.next = next;
        if( next == null ){
            tail = temp;
            return;
        }
        next.prev = temp;
    }

    public void deleteFromBeg(){
        if( head == null || head == tail ) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev.next = null;
        head.prev = null;
    }

    public void deleteFromEnd(){
        if( head == null || head == tail){
            head = tail = null;
            return;
        }

        tail = tail.prev;
        tail.next.prev = null;
        tail.next = null;
    }
    public void reverse(){
        Node curr = head, prev = null;
        while( curr != null ){
            curr.prev = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr.prev;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void traverseFromHead(){
        if ( head == null ) {
            System.out.println("Empty List");
            return;
        }
        Node curr = head;
        while( curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void traverseFromTail(){
        if ( head == null ) {
            System.out.println("Empty List");
            return;
        }
        Node curr = tail;
        while( curr != null ){
            System.out.print(curr.val + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public void deleteEle(int ele){
        if( head == null ){
            System.out.println("List is Empty");
            return;
        }
        Node curr = head;
        while( curr.val != ele && curr != null ){
            curr = curr.next;
        }
        if(curr == null ){
            System.out.println("No such element in the list");
        } 

        if( curr == head){
            deleteFromBeg();
            return;
        }

        Node prev = curr.prev;
        prev.next = curr.next;
        if(curr.next == null ){
            tail = prev;
            return;
        }
        curr.next.prev = prev;
        curr.next = null;
        curr.prev = null;
    }
    public static void main( String [] args) throws Exception{
        DLL list = new DLL();
        list.insertAtBeg(1);
        list.insertAtBeg(2);
        list.insertAtBeg(3);
        list.insertAtBeg(4);
        list.insertAtBeg(5);
        list.insertAtEnd(0);
        list.insertAtIndex(10, 1);
        list.traverseFromHead();
        list.traverseFromTail();
        list.reverse();
        list.traverseFromHead();
        list.deleteFromBeg();
        list.traverseFromHead();
        list.deleteFromEnd();
        list.traverseFromHead();
        list.deleteEle(1);
        list.traverseFromHead();
        list.traverseFromTail();
    }
}