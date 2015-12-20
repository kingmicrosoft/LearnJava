package com.demo.learnjunit;

/**
 * Created by wisdom on 15-12-9.
 */
public class Calculator {

    public int addTwo(int input1, int input2) {

        return input1 + input2;

    }

    public int divide(int origin, int second) throws Exception {

        if (0 == second) {
            throw new Exception("myTest");
        } else {
            return origin / second;
        }
    }

    private int mutiply(int num1, int num2) {

        return num1 * num2;
    }


}
