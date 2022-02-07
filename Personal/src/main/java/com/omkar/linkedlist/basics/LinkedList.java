package com.omkar.linkedlist.basics;

public class LinkedList
{
    private Node head;
    public Node getHead ()
    {
        return head;
    }

    private static int length;
    
    public LinkedList(Node node) {
        head = node;
    }
     public static class Node {
        private int data;
        private Node next;
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public void traverse() {
        Node trav = this.head;
        while(trav!=null) {
            System.out.println(trav.data);
            trav= trav.next;
        }
    }
    
    public void addLast(Node last) {
        Node trav = head;
        if(trav==null) {
            head = last;
            return;
        }
        
        while(trav.next!=null) {
            trav= trav.next;
        }
        trav.next =last;
        last.next =null;
    }
    
    public void addFirst(Node first) {
        first.next = head;
        head = first;
    }
    
    //Two pointer method
    public int findMid() {
        Node slow = head,fast=head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
        return slow==null?0:slow.data;
    }
    
    //Single Pointer Recursion
    public int findMid(Node n, int stackFrameNumber) {
        if(n.next==null) {
          length = stackFrameNumber;
          System.out.println(length);
          return 0;
        }
        
         int mid = findMid(n.next, stackFrameNumber+1);
         if(stackFrameNumber == (length+1)/2) {
             mid = n.data;
            System.out.println(mid); 
         }
         return mid;
    }
    
    //Reversing a linkedlist
    public void reverse() {
        Node head1 = head, head2 =null;
        while(head1!=null) {
         //remove first from original linkedlist
         Node temp = head1;
         head1=head1.next;

         //Add first to the new linkedlist
         temp.next =head2;
         head2 = temp;
        }
       this.head = head2; 
    }
    
    //reversing linkedlist using recursion or single pointer approach
    //while unwinding of the recursion stack return the node to the previous or calling stack
    public Node reverse(Node current) {
        if(current.next == null) {
            head = current;
            return current;
        }
        
        Node previous = reverse(current.next);
        previous.next = current;
        current.next = null;
        return current;
    }
    
    //to find if linkedlist contains a loop we will use fast and slow poiter technique
    public boolean isLoop() {
        Node fast=head, slow=head;
        
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                return true;            
        }       
        return false;
    }
    
    //Palindrome or not
    boolean isPalidrome() {
        //1. find mid of the list: maintain prev of slow pointer for mid or ignore one comparision         
        //2. reverse later list
        //3. start comparing
        //4. restore: reverse again later part
        return true;
    }
}
