package GreedyAlgorithm.Medium;

import java.util.*;

class LeastRecentlyUsed {
    // optimized approach
    // using doubly linkedlist to store cache, since it provides insertion and deleteion in constant time
    // for lookup we will be maintaining a hashMap
    // we will be using a dummy head and a dummy pointer in our doubly linkedList
    DoublyLinkedList cache;
    int capacity;
    HashMap<Integer, DoublyLinkedListNode> map;
    public LeastRecentlyUsed(int capacity) {
        cache = new DoublyLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if( map.containsKey(key)){
            DoublyLinkedListNode currNode = map.get(key);
            cache.delete(currNode);
            cache.add(currNode);
            return currNode.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if( map.containsKey(key)){
            DoublyLinkedListNode currNode = map.get(key);
            cache.delete(currNode);
        }
        DoublyLinkedListNode temp = new DoublyLinkedListNode(key, value);
        cache.add(temp);
        map.put(key, temp);
        if ( map.size() > capacity ){
            DoublyLinkedListNode nodeToBeDeleted = cache.head.next;
            map.remove(nodeToBeDeleted.key);
            cache.delete(nodeToBeDeleted);
        }   
    }
}
class DoublyLinkedList{
    DoublyLinkedListNode head, tail;
    public DoublyLinkedList(){
        head = new DoublyLinkedListNode(-1, -1);
        tail = new DoublyLinkedListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void delete( DoublyLinkedListNode node ){
        DoublyLinkedListNode prevNode = node.prev;
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;        
    }

    public void add(DoublyLinkedListNode node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}

class DoublyLinkedListNode{
    int key, value;
    DoublyLinkedListNode next, prev;
    public DoublyLinkedListNode(int key, int value ){
        this.key = key;
        this.value = value;
        next = prev = null;
    }
}
// Brute force approach using a linked list
// time complexity : get() => O(n)
//                   put() => O(n)
// space complexity : O(n)
// Problem with brute force approach
// It takes O(n) time to insert a node in cache
// It takes O(n) time to get a node from cache
// here n, is the capacity of the node
//     LinkedList<Pair> cache;
//     int capacity;
//     public LRUCache(int capacity) {
//         cache = new LinkedList<>();
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         ListIterator<Pair> itr = cache.listIterator();
//         boolean keyInCache = false;
//         Pair temp = null;
//         while(itr.hasNext()){
//             temp = itr.next();
//             if( temp.key == key ){
//                 keyInCache = true;
//                 itr.remove();
//                 break;
//             }
//         }
//         if(keyInCache)
//             cache.offerLast(temp);

//         return keyInCache ? temp.value : -1;
//     }
    
//     public void put(int key, int value) {
//         // search in the list if the element already exists
//         // if already exists delete the element from the pos and add it to the top
//         // if it does not exist in the list, delete the first element of the list and add the element
//         ListIterator<Pair> itr = cache.listIterator();
//         boolean keyInCache = false;
//         while(itr.hasNext()){
//             Pair temp = itr.next();
//             if( temp.key == key ){
//                 itr.remove();
//                 keyInCache = true;
//             }
//         }
//         if( cache.size() >= capacity && !keyInCache){
//             cache.removeFirst();
//         }
//         cache.addLast(new Pair(key, value));
//     }
// }


// class Pair{
//     int key, value;
//     public Pair(int key, int value){
//         this.key = key;
//         this.value = value;
//     }
// }

