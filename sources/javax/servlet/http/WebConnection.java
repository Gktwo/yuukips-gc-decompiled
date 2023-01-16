package javax.servlet.http;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

/* loaded from: grasscutter.jar:javax/servlet/http/WebConnection.class */
public interface WebConnection extends AutoCloseable {
    ServletInputStream getInputStream() throws IOException;

    ServletOutputStream getOutputStream() throws IOException;
}
