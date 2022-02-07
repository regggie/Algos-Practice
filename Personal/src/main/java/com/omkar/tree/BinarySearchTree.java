package com.omkar.tree;

import java.util.Stack;

public class BinarySearchTree
{
    Node root;

    class Node
    {
        int data;
        Node left;
        Node right;
        boolean visited;

        Node (int data)
        {
            this.data = data;
        }
    }

    // Form a Binary Search tree from input
    public void addNode (int data)
    {
        final Node newNode = new Node(data);
        Node trav = root;
        if (trav == null) {
            root = newNode;
            System.out.println(data);
            return;
        }

        while (true) {
            if (trav.data > newNode.data) {
                if (trav.left == null) {
                    trav.left = newNode;
                    break;
                }
                trav = trav.left;
            }
            else {
                if (trav.right == null) {
                    trav.right = newNode;
                    break;
                }
                trav = trav.right;
            }
        }

    }

    // iterative Preorder, Inorder, Postorder
    void iterativePreorder ()
    {
        Stack<Node> stack = new Stack<BinarySearchTree.Node>();
        Node trav = root;
        stack.push(trav);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            System.out.println(p.data + " ");
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }

        }

    }

    void iterativePreorderMyLogic ()
    {
        Stack<Node> stack = new Stack<BinarySearchTree.Node>();
        Node trav = root;
        while (true) {
            if (trav != null) {
                System.out.println(trav.data + "");
                if (trav.right != null) {
                    stack.push(trav.right);
                }
                trav = trav.left;
            }
            else if (!stack.isEmpty()) {
                trav = stack.pop();
            }
            else
                break;

        }
    }

    void iterativePostorderMyLogic ()
    {
        Stack<Node> stack = new Stack<BinarySearchTree.Node>();
        Node trav = root;
        while (true) {
            if (trav != null) {
                stack.push(trav);
                trav = trav.left;
            }
            else if (!stack.isEmpty()) {
                trav = stack.pop();
                if (trav.right == null || trav.right.visited) {
                    System.out.println(trav.data);
                    trav.visited = true;
                    // if we don't make it null in the next iteration same node
                    // will we pushed we have to make explicitly null so as to
                    // reach or pop next new or it's parent in the stack
                    trav = null;
                }
                else {
                    stack.push(trav);
                    trav = trav.right;
                }
            }
            else
                break;
        }

    }

    public static void main (String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(50);
        bst.addNode(30);
        bst.addNode(90);
        bst.addNode(10);
        bst.addNode(40);
        bst.addNode(70);
        bst.addNode(100);
        bst.addNode(20);
        bst.addNode(60);
        bst.addNode(80);
        System.out.println(bst.root.left.left.data + "" + bst.root.right.data);
        // bst.iterativePreorder();
        // bst.iterativePreorderMyLogic();
        bst.iterativePostorderMyLogic();
    }
}
