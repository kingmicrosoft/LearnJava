package mock;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wisdom on 15-12-20.
 */
public class MockInputStream extends InputStream {


    @Override
    public int read() throws IOException {
        return 0;
    }


}
