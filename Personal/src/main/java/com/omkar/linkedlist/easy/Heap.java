package com.omkar.linkedlist.easy;

import java.util.Arrays;

public class Heap
{
    Integer[] arr = null;
    int size;

    Heap ()
    {
    }

    Heap (Integer[] arr)
    {
        this.arr = arr;
        size = arr.length;
    }

    public void heapify (int start)
    {
        int parent = start;
        while (parent <= size - 1) {
            int largest = parent;
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            if (left <= size - 1 && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right <= size - 1 && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest == parent)
                break;
            swap(largest, parent);
            parent = largest;
        }
    }

    public void swap (int s, int d)
    {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }

    public void formHeap ()
    {
        // Left=2Parent + 1
        int lastNode = size - 1;
        int start = (lastNode - 1) / 2;
        for (int i = start; i >= 0; i--) {
            heapify(i);
        }
    }
    
    public void printHeap() {
        System.out.println(Arrays.toString(arr));
    }
    
    public int returnAndDelMax() {
        int max = arr[0];
        int newRoot = arr[size-1];
        arr[0] = newRoot;
        size--;
        heapify(0);
        return max;
    }
    
   public int findKthLargest(int k) {
       int kthmax=0;
       //for 1 to k times
        //call delMax()
          //save root of the tree
          //delete the root 
          //place the last element to the root
          //call heapify on the new root       
          //return saved in the last iteration 
       for(int i=1;i<=k;i++) {
           kthmax = returnAndDelMax();
       }
       return kthmax;
   }
    

    public static void main (String[] args)
    {
        Integer[] arr = { 20, 12, 35, 15, 10, 80, 30, 17, 2, 1 };        
        System.out.println(Arrays.toString(arr));
        final Heap heap = new Heap(arr);
        heap.formHeap();
        heap.printHeap();
        //find kth largest
        int kthLarge = heap.findKthLargest(2);
        System.out.println(kthLarge);
        heap.printHeap();
    }
}
