package com.omkar.strings;

public class LongestCommonPrefix
{

    public static String longestCommonPrefix (String[] strs)
    {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefixH (String[] strs)
    {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String binarySearchMethod (String[] str)
    {
        if (str == null || str.length == 0)
            return "";
        // find string with min length for efficiency
        int min = Integer.MAX_VALUE, low, high;
        for (int i = 0; i < str.length; i++) {
            min = Integer.min(min, str[i].length());
        }
        // start from mid of that length and compare all strings up to that
        // length
        low = 0;
        high = min-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean res = compareForLength(str, mid+1);
            if (res)
                low = mid + 1;
            else
                high = mid - 1;

        }
        if(high<0)
            return "";
        int ansIndex = (low + high) / 2;
        return str[0].substring(0, ansIndex+1);
    }

    // if thet match increment low pointer else decrease high pointer
    static boolean compareForLength (String[] str, int length)
    {
        String st = str[0].substring(0, length);
        for (int i = 1; i < str.length; i++) {
            if (!str[i].startsWith(st))
                return false;
        }
        return true;
    }
    
    public static String divideAndConquer(String[] arr) {
        if(arr==null || arr.length ==0) 
            return "";
        return divideAndConquer(arr, 0, arr.length -1);
        
    }
    
    public static String divideAndConquer(String[] arr, int left, int right) {
        if(left==right)
            return arr[left];
        int mid = (left + right)/2;
        String ans1 = divideAndConquer(arr, left, mid);
        String ans2 = divideAndConquer(arr, mid+1, right);
        //Conquer part of divide and Conquer ca be moved to separate conquer method as well
        int min = Math.min(ans1.length(), ans2.length());
        for(int i = 0 ;i<min;i++) {
            if(ans1.charAt(i)!=ans2.charAt(i)) {
                return ans1.substring(0,i+1);
            }
        }
        //or ans2.substring(0, min); will also work
        return ans1.substring(0, min);
    }

    public static void main (String[] args)
    {
        // TODO Auto-generated method stub
        String[] arr = { "leets", "leetcode", "leet", "leeds" };
        String[] arr1 = { "car", "racecar" };
        String[] arr2 = {"dog","racecar","car"};
        String[] arr3 = { "car", "car", "car", "car" };
        // System.out.println(longestCommonPrefix(arr));
        //System.out.println(longestCommonPrefixH(arr1));
        System.out.println(binarySearchMethod(arr3));
    }
    
    

}
