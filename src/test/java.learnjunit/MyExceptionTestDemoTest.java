import com.demo.learnjunit.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by wisdom on 15-12-9.
 */
/*
有的时候面临的一个场景：大量不同的输入，但处理逻辑的业务不变，对其结果进行验证也会有不同的期望值。按照之前的一些思路，往往会为每一组输入和输入写一个case，
达成大量的代码冗余。

基于上面的场景，junit4给出了参数化的特性，从而实现了不同的输入对应相同的代码。


再进一步想想,这个数据集合能不能从外部导入呢?
测试数据与代码分离的测试:
http://www.wangyuxiong.com/archives/51662

 */

@RunWith(Parameterized.class)
public class MyExceptionTestDemoTest {
    private Calculator calculator;
    private int excepted;
    private int inputParams1;
    private int inputParams2;


    @Before
    public void init() {
        this.calculator = new Calculator();
    }



/*
Constructor.
        * The JUnit test runner will instantiate this class once for every
        * element in the Collection returned by the method annotated with
        * @Parameters.
 */
    @Parameterized.Parameters
    public static Collection prepareData() {

        return Arrays.asList(new Object[][]{
                {12, 6, 6},
                {13, 7, 6},
                {14, 1, 13}
        });

    }

    public MyExceptionTestDemoTest(int excepted, int inputParams1, int inputParams2) {
        this.excepted = excepted;
        this.inputParams1 = inputParams1;
        this.inputParams2 = inputParams2;
    }

    @Test
    public void testParameterAdd() {

        Assert.assertEquals(this.excepted, calculator.addTwo(inputParams1, inputParams2));
    }

}


