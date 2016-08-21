package mock;
import com.demo.learnjunit.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 *测试类的私有方法.
 */
public class PrivateMethodTest {

    private Calculator calculator;
    @Before
    public void init(){
        calculator=new Calculator();


    }


    @Test
    public void testPrivateMutiply() throws Exception{
        Object result=null;
        try {
            ////获得method.注意,这里不能使用getMethod方法,因为这个方法只能获取public修饰的方法.
            Method method=calculator.getClass().getDeclaredMethod("mutiply", int.class, int.class);
            //要访问私有方法必须将accessible设置为true，否则抛java.lang.IllegalAccessException
            method.setAccessible(true);
             result=method.invoke(calculator,2,4);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assertEquals(2 * 4, result);


    }


}
