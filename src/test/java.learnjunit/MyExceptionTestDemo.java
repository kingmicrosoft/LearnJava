import com.demo.learnjunit.Calculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.*;

/**
 *test exception using excepted Optional Element Summary of @Test,and @Rule Annatation
 */
public class MyExceptionTestDemo {
    private Calculator calculator;


    @Before
    public void init() {
        calculator = new Calculator();


    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRuleExceptionDivide() throws Exception {

        thrown.expect(Exception.class);
        thrown.expectMessage("myTest");
        calculator.divide(20, 0);

    }


    @Test(expected = Exception.class)
    public void testDivide() throws Exception {


        int result = calculator.divide(10, 2);
        assertEquals(10 / 2, result);
        result = calculator.divide(10, 0);

    }


}
