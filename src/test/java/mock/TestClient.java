package mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wisdom on 15-12-20.
 */
public class TestClient {

    @Before
    public void init(){


    }

    @Test
    public void testClient() throws Exception {
        InputStream inputStream = new ByteArrayInputStream("hello".getBytes());
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory(inputStream);
        WebClient client = new WebClient(mockConnectionFactory);
        assertEquals("hello", client.getContent().trim());
//        Assert.assertSame("hello",client.getContent());




    }
}
