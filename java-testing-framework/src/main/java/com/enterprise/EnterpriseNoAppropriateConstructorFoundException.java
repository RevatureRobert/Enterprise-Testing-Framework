package com.enterprise;

public class EnterpriseNoAppropriateConstructorFoundException extends Exception{
    public EnterpriseNoAppropriateConstructorFoundException(){
        super("The Enterprise testing framework requires a no arg constructor to be present in the class");
    }
}
