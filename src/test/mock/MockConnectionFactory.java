package mock;

import java.io.InputStream;

/**
 * Created by wisdom on 15-12-20.
 */
public class MockConnectionFactory implements ConnectionFactory {
    private InputStream inputStream;

    public MockConnectionFactory(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getData() throws Exception {
        return this.inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
