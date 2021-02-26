package com.enterprise.util;

import com.enterprise.annotations.TestMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestDiscovery {

    public void getClassMethods(){

        Method[] methods = A.class.getMethods();
        for(Method m : methods){
            if(m.getDeclaredAnnotations().length>0){
                System.out.println(Arrays.toString(m.getDeclaredAnnotations()));
            }
        }


    }

    public Method[] getTestMethods( Class clazz){
        // TODO: replace with collection that is dynamic in size, good for frequently adding
        //      does not allow duplicates,
        if(clazz == null) {
            return new Method[0];
        }
        Method[] tempArr = new Method[clazz.getMethods().length];
        int currentIndex = 0;
        for(Method m : clazz.getMethods()){
            if(m.getDeclaredAnnotation(TestMethod.class) != null){
                tempArr[currentIndex++] = m;
            }
        }

        return tempArr;
    }

    public static void main(String[] args) {
        System.out.println(new TestDiscovery().getTestMethods(A.class)[0].getName());
    }
}


class A{

    @TestMethod
    public void doSomething(){

    }
}
