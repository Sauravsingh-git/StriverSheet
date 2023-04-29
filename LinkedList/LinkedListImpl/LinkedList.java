package LinkedList;
// Implementation of LinkedList

public class LinkedList{
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            next = null;
        }
    }
    Node head;
    public void insert( int val ){
        Node temp = new Node(val);
        if ( head == null ){
            head = temp;
            return;
        }
    Node curr = head;
    while ( curr.next != null ){
        curr = curr.next;
    }
    curr.next = temp;
    }
    // inserting into list
    public void insertAtBeg(int val){
        Node temp = new Node(val);
        if ( head == null ){
            head = temp;
            return;
        }  
        temp.next = head;
        head = temp;
    }
    // inserting at any index
    public void insertAtIndex( int val, int idx ) throws Exception{
        // the valid index is in range [0, len(List)]
        if ( idx == 0 ){
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
        curr.next = temp;
        temp.next = next;
    }
    // printing the list
    public void printList(){
        Node temp = head;
        while( temp != null ){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    // delete the element at begining
    public void deleteEleAtBeg() throws Exception{
        if ( head == null ) 
            throw new Exception("List is empty");
        Node next = head.next;
        head.next = null;
        head = next;
    }
    // delete the element at last
    public void deleteEleAtLast() throws Exception{
        if( head == null )
            throw new Exception("List is empty");
        Node curr = head;
        if ( curr.next == null ){
            head = null;
            return;
        }
        while(curr.next.next != null ){
            curr = curr.next;
        }
        curr.next = null;
    }
    
    // delete the value from the list, if value is present in the list
    public void delete( int val ) throws Exception{
        
        if ( head == null ) 
            throw new Exception("List is empty");
        
        if ( head.val == val){
            deleteEleAtBeg();
            return;
        }
        Node curr = head;
        while ( curr.next != null && curr.next.val != val){
            curr = curr.next;
        }
        if(curr.next == null ) return;
        curr.next = curr.next.next;
    }

    // returns the length of the list
    public int length(){
        int counter = 0;
        Node curr = head;
        while ( curr != null ){
            counter++;
            curr = curr.next;
        }
        return counter;

    }

    // searches the element in the list and returns the idx of the list
    // returns -1 if element is not found in the list
    public int findElementIndex(int val){
        if( head == null ) return -1;
        Node curr = head;
        int idx = 0;
        while( curr!= null && curr.val != val ){
            curr = curr.next;
            idx++;
        }
        if ( curr != null ) return idx;
        return -1;
    }
    public static void main(String [] args) throws Exception{
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insertAtBeg(10);
        list.insertAtIndex(11, 0);
        list.insertAtIndex(12, 1);
        list.insertAtIndex(13, 2);
        list.insertAtIndex(0, 9);
        list.printList();
        System.out.println();
        list.deleteEleAtLast();
        list.printList();
        System.out.println();
        list.delete(12);
        list.printList();
        System.out.println();
        System.out.println("The index of the element 13 is : " + list.findElementIndex(13));
        System.out.println("The index of the element 0 is : " + list.findElementIndex(0));
        System.out.println("The index of the element 5 is : " + list.findElementIndex(5));
    }

}
