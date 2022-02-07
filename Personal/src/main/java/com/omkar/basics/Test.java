package com.omkar.basics;

public class Test
{
    public static void test() throws Exception {
        int i =0;
        while(i <10) {
            try {
            System.out.println(i);
            i++;
            throw new Exception("Testing");
            }
            catch (Exception ex) {               
                System.out.println("Logging ex");
                throw new Exception("Testing again");
            }
            finally {
                System.out.println("Inside finally");
            }
        }
        
        System.out.println("Clean up has been done"); 
    }
    
    public static void main (String[] args) throws Exception
    {
      test();  
        
    }
}
