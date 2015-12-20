package com.demo.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.AbstractCollection;

public class ReflectionCopyObject {

    public Object copyObject(Object obj) throws Exception {

        //get the Class object
        Class<?> classType = obj.getClass();

//        Class<?> classType = Class.forName("com.demo.reflection.User");
        //by the constructor with parameters
        Constructor con = classType.getConstructor(new Class[]{String.class, int.class});
        //create target class
        Object objectClass = con.newInstance(new Object[]{"Mao", 10});


        Field[] fields = classType.getDeclaredFields();
        for (Field field : fields) {
            String filedName = field.getName();

            String getMethodName = "get"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);
            String setMethodName = "set"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);

            Method getMethod = classType.getMethod(getMethodName, new Class[]{});
            Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});

            Object value = getMethod.invoke(obj, new Object[]{});
            //invoke  the target Obj's method
            setMethod.invoke(objectClass, value);
        }

        return objectClass;
    }

    public static void main(String[] args) throws Exception {
        User user=new User("cain",20);
        User result= (User) new ReflectionCopyObject().copyObject(user);
        System.out.println("result object name is:" + result.getName() + ", and age is :" + result.getAge());


        //test Array Class
        int [] intArray= (int[]) Array.newInstance(int.class,3);

        Array.set(intArray,0,12);
        Array.set(intArray,1,100);
        Array.set(intArray, 2, 102);
        System.out.println(Array.get(intArray, 0));
        System.out.println(Array.get(intArray, 1));
        System.out.println(Array.get(intArray, 2));



    }
}
