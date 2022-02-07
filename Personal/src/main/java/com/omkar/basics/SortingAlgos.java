package com.omkar.basics;

public class SortingAlgos
{
    private static void selectionSort(int[] arr) {
        
        for(int i=0; i<= arr.length-2;i++) {
            int imin=i;
            for(int j=i+1;j<=arr.length-1;j++) {
                if(arr[imin]>arr[j]) {
                    imin=j;
                }
            }
            if(imin!=i) {
                swap(i,imin,arr);
            }
        }
    }
    
    private static void bubbleSort(int[] arr) {
        //for one iteration of outterloop we are placing a highest number at the last index of the array
        // there are 0 to arr.length-1 elements indices then we have place only arr.length-1-1 elements hence the outer 
        //loop has been run  0 to arr.length-1-1 times. the last digit or digit at index 0 will be automatically in the sorted place
        for(int i=0; i<=arr.length-2;i++) {         
            //we are comparing j and j+1th position hence J can be max upto arr.length-1-1 only. 
            for(int j=0;j<=arr.length-2;j++) {
                if(arr[j]>arr[j+1]) {
                    swap(j, j+1, arr);
                }
            }
        }
    }
    
    private static void bubbleSortImproved(int[] arr) {
        //for one iteration of outterloop we are placing a highest number at the last index of the array
        // there are 0 to arr.length-1 elements indices then we have place only arr.length-1-1 elements hence the outer 
        //loop has been run  0 to arr.length-1-1 times. the last digit or digit at index 0 will be automatically in the sorted place
        int flag=0;
        for(int i=0; i<=arr.length-2;i++) {  
            flag=0;
            //we are comparing j and j+1th position hence J can be max upto arr.length-1-1 only.
            //further for every execution of below loop we are placing highest element at the last place in the array
            // for next execution of the below code or for i+1th execution we need not consider the element that we have already
            //sorted in the last iteration hence j<=arr.length-2-i
            for(int j=0;j<=arr.length-2-i;j++) {
                if(arr[j]>arr[j+1]) {
                    flag=1;
                    swap(j, j+1, arr);
                }
            }
            if(flag==0)
                break;
        }
    }
    
    private static void insertionSort(int arr[]) {
        
        for(int i=1;i<=arr.length-1;i++) {
            int value = arr[i];
            int hole = i;
            while(hole >0 && arr[hole-1] > value) {
                arr[hole] = arr[hole-1];
                hole=hole-1;
            }
            arr[hole]=value;
        }
    }
    
    private static void swap(int a, int b, int[] arr) {
        int temp =arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    
    public static void main (String[] args)
    {
       
    }
}
