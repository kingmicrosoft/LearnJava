package mock;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wisdom on 15-12-20.
 */
public class HttpURLConnectionFactory implements ConnectionFactory {
    private URL url;
    public HttpURLConnectionFactory(URL url) {
        this.url = url;

    }

    public InputStream getData() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream stream = connection.getInputStream();
        return stream;
    }
}
