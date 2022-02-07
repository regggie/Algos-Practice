package com.omkar.dp;

public class LongestIncreasingSubsequence
{
    static int globalMax = 1;
    static int globalMaxMemozation =1;
    
    public static int lis (int arr[], int index)
    {
        int maxlis = 1;
        if (index == 0)
            return 1;
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < arr[index]) {
                int lis = lis(arr, i);
                if(maxlis < lis+1)
                    maxlis = lis+1;
            }

        }
        if(globalMax < maxlis)
            globalMax = maxlis;
        return maxlis;
    }
    
    /**
     * Memoization is top down approach as we approach top issue first
     * @return
     */
    public static int lisMemoization (int arr[], int cache[], int index)
    {
        int res = 1;
        if(index==0)
            return 1;
        if(cache[index]!=Integer.MIN_VALUE) {
            return cache[index];
        }
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < arr[index]) {                
                int lis = lisMemoization(arr, cache, i);                
                if(lis+1 > res)
                    res =lis+1;                
            }
        }
        if(cache[index]==Integer.MIN_VALUE )
            cache[index] = res;
        return res;
    }
    
    public static int lisTabulization(int arr[]) {
        int lis=1;
        int res[] = new int[arr.length];
        for(int i=0; i< arr.length;i++) {
            res[i] = 1;
        }
        //lis ending at i = max(lis'es ending at j where j < i) + 1
        for(int i=1; i< res.length;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j] < arr[i] && res[j]+1 > res[i]) {
                    res[i] = res[j]+1;
                    if(res[i] > lis) {
                        lis = res[i];
                    }
                }
            }
        }
        return lis;
    }

    public static void main (String[] args)
    {
        int arr[] = { 50, 3, 10, 7, 40, 80 };  
        int startingIndex = arr.length-1;
        lis(arr, startingIndex);
        int cache[] = new int[arr.length];
        for (int i : cache) {
            cache[i]=Integer.MIN_VALUE;
        }
        lisMemoization(arr, cache, startingIndex);
        
    }
}
