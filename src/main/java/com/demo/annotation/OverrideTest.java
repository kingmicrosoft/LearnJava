package com.demo.annotation;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wisdom on 15-12-13.
 */
@SuppressWarnings("deprecation")
public class OverrideTest {

    @Override
    public String toString(){

        return "override test";
    }

    @Deprecated
    public void testDeprecateAnnotation(){

        System.out.println("anno-deprecated method");
    }

    public static void main(String[] args) {
        OverrideTest test=new OverrideTest();
        System.out.println(test);
        test.testDeprecateAnnotation();
        Map map =new TreeMap();
        map.put("sd", "sd value");
        System.out.println(map.get("sd"));
        Date date=new Date();
        date.getDate();

    }
}
