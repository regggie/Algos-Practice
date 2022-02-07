package com.omkar.innerclass;

public class Outer
{
    int data;
    static Integer staticMember;
    
    public void memeberFunction(final int parameter) {
        //Below variable has to be final or effectively final
        int localVariabl=10;
        
        class LocalClass {
            int local;            
            final static int test =7;
            public LocalClass ()
            {
             local++;
             data++;
             staticMember++;
             //localVariable++;
             System.out.println(localVariabl);
           //Local variable localVariabl defined in an enclosing scope must be final or effectively final
           // localVariabl++;
             System.out.println(parameter);
            }
            
        }
        
    }
    
    

}
