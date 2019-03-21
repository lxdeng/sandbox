package designlinkedlist;

public class MyLinkedList {
    
    Node dummyHead;
    int count;
    
    public static void main(String args[]) {
    	MyLinkedList list = new MyLinkedList();
    	list.addAtHead(1);
    	list.addAtTail(3);
    	list.get(1);
    	
    }
    
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new Node(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        System.out.println("count-" + count);
        if (index < 0 || index > count - 1) return -1;
        
        Node cur = dummyHead.next;
        
        for (int i = 0; i < index; i++)
            cur = cur.next;
        
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = dummyHead.next;
        dummyHead.next = node;
        ++count;
        System.out.println("count after addAtHead" + count);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(count, val);
        System.out.println("count after addAtTail" + count);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > count) return;
        
        Node cur = dummyHead;
        
        for(int i = 0; i < index; i++)
            cur = cur.next;
        
        Node newNode = new Node(val);
        newNode.next = cur.next;
        cur.next = newNode;
        
        ++count;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > count - 1) return;
        
        Node cur = dummyHead;
        
        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.next = cur.next.next;

        --count;
    }
}

class Node {
    int val;
    Node next;
    
    Node(int val) {
        this.val = val;
    }
    
}