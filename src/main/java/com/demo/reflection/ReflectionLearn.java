package com.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wisdom on 15-12-13.
 */
public class ReflectionLearn {

    public void sayHello(String string){

        System.out.println("hello,"+string);
    }

public     int getNumber(int plusNum1,int plusNum2){
        return plusNum1*plusNum2;

    }


    public static void main(String[] args) throws Exception {

//        Class<?> classType=Class.forName(args[0]);
        Class<?> cl=ReflectionLearn.class;
        Object invokeTest=cl.newInstance();
       Method method= cl.getMethod("sayHello", String.class);
        method.invoke(invokeTest,"cain");

        Method method1=cl.getMethod("getNumber",new Class[]{int.class,int.class});
       Object result= method1.invoke(invokeTest, new Object[]{10,12});
       System.out.println("result is"+result);
//        Method[] methods=cl.getDeclaredMethods();

//        for(Method method:methods){
//method.invoke("String",new Object[]{});
//            System.out.println(method.toString());
//        }


        Class<?> class_Test=Class.forName("ReflectionLearn");
        System.out.println(class_Test.getName());

    }
}
