package com.omkar.linkedlist.easy;

import com.omkar.linkedlist.basics.LinkedList;
import com.omkar.linkedlist.basics.LinkedList.Node;

public class LinkedListTypical
{
    private LinkedList list;    

    public LinkedListTypical ()
    {
        list = new LinkedList(new LinkedList.Node(10,null));
        init();
    }

    private void init ()
    {
        for (int i = 20; i <= 70; i = i + 10) {
            Node n = new LinkedList.Node(i,null);
            list.addLast(n);
        }
       // list.traverse();
    }

    
    
    public static void main (String[] args)
    {
        LinkedListTypical demo = new LinkedListTypical();
        //demo.list.findMid();
        //demo.list.findMid(demo.list.getHead(), 1);
        demo.list.reverse();
        demo.list.traverse();
        demo.list.reverse(demo.list.getHead());
        demo.list.traverse();
    }
}
