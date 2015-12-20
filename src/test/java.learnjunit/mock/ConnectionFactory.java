package mock;

import java.io.InputStream;

/**
 * Created by wisdom on 15-12-20.
 */
public interface ConnectionFactory {

    InputStream getData() throws Exception;
}
