package mock;

import java.io.InputStream;

/**
 * Created by wisdom on 15-12-20.
 */
public class WebClient {
    private  MockConnectionFactory mockConnectionFactory;

    public WebClient(MockConnectionFactory mockConnectionFactory) {
        this.mockConnectionFactory = mockConnectionFactory;
    }

    public String getContent() throws Exception {
        StringBuffer content = new StringBuffer();
        InputStream inputStream = mockConnectionFactory.getData();
        byte[] buffer = new byte[1024];
        int count;

        while (-1!=(count = inputStream.read(buffer))){
            
            content.append(new String(buffer));
        }



        return content.toString();
    }

}
