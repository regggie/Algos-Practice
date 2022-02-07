package com.omkar.strings;

import java.util.ArrayList;
import java.util.List;

class ZigZagConversion {

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    
    public static String convertMyCodeMethod1(String s, int numRows)  {
        StringBuilder res = new StringBuilder();
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        
        for(int r=0;r<=Math.min(numRows-1, s.length()-1);r++) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if(currRow == 0 || currRow == numRows-1 )
                flag=!flag;
            if(flag)
                currRow++;
            else
                currRow--;
                            
        }
        
        for (StringBuilder stringBuilder : rows) {
            res.append(stringBuilder);
        }
        return res.toString();
    }
    
  /*  public static String convertMyCodeMethod2(String s, int numRows)  {
        //Rough logic below
        //calculate step to get next char in each row step = 2* (numRows -1 )
        //for(i=0;i<=numRows;i++)
        // take a row at a time and fill up all the chars in that row 
        //  for(j=i;j<=s.length()-1;j+=step)
        // res.append(s.charAt(j))
        //    missingCharIndex = j + step - i * 2
        //  if(i!=0 || i!=numRows-1 && missingCharIndex < s.length()-1)
        //    res.append(s.charAt(missingCharIndex))  
        //corner case
        if(numRows==1) 
            return s;
        StringBuilder res = new StringBuilder();
        int step = 2 * (numRows - 1);
        //loop for each row
        for(int row=0; row<=numRows-1;row++) {
            //loop for picking up characters  belonging to that row. Note that we are incrementing by step
            for(int c=row;c<=s.length()-1;c+=step) {
                res.append(s.charAt(c));
                //
                int missingCharIndex = (c + step) - 2 * row;
                if(row!=0 || row!=numRows-1 && missingCharIndex <=  s.length()-1) {
                    res.append(s.charAt(missingCharIndex));
                }
            }
        }
        
        return res.toString();
    }*/
    

    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                if(j==0) {
                    ret.append(s.charAt(j + i));
                }
                if (j!=0 && j - i < n)
                    ret.append(s.charAt(j - i));
            }
        }
        return ret.toString();
    }

    
    
    public static void main (String[] args)
    {
        String s= "PAYPALISHIRING";
        System.out.println(convert(s,3));
        System.out.println(convert2(s,3));
        
    }
}