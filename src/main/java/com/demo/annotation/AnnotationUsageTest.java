package com.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnnotation(value = "test for class ", url = "www.baidu.com")
public class AnnotationUsageTest {

    @Deprecated
    @MyAnnotation(value = "test for method", url = "www.google.com")
    public void myMethod() {

        System.out.println("my method have been used!");
    }

    public void outPutUrl(@MyAnnotation(
            value = "test for params",
            url = "www.bing.com") String kind) throws Exception {

        Class<AnnotationUsageTest> c = AnnotationUsageTest.class;
        Method method = c.getMethod("outPutUrl", new Class[]{String.class});
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class[] params = method.getParameterTypes();
        int i = 0;
        for (Annotation[] annotations : parameterAnnotations) {
            Class param = params[i];
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) annotation;
                    System.out.println("value is :" + myAnnotation.value());
                    System.out.println("url is" + myAnnotation.url());
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //1.访问方法的所有注解
        Class<AnnotationUsageTest> c = AnnotationUsageTest.class;
        Method method = c.getMethod("myMethod", new Class[]{});

        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println(myAnnotation.value());
                System.out.println(myAnnotation.url());
            } else {
                System.out.println(annotation.toString());
            }
        }

        //2. 访问方法的特定的注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            AnnotationUsageTest test = new AnnotationUsageTest();
            method.invoke(test, new Object[]{});
            MyAnnotation myAnnotation_certain = method.getAnnotation(MyAnnotation.class);
            System.out.println("method annotation test 2:" + myAnnotation_certain.value() + " and url is :" + myAnnotation_certain.url());
        }

        //3. 访问类注解
        Class<AnnotationUsageTest> classType = AnnotationUsageTest.class;
        Annotation[] annotation_array = classType.getDeclaredAnnotations();
        for (Annotation annotation : annotation_array) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println(myAnnotation.value());
                System.out.println(myAnnotation.url());
            }
        }

        //4.测试参数注解
        //将注解的获取放到方法本身里面了,同样可以运行
        AnnotationUsageTest annotationUsageTest = new AnnotationUsageTest();
        annotationUsageTest.outPutUrl(null);


    }
}
