package javax.servlet;

import java.io.IOException;
import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/ReadListener.class */
public interface ReadListener extends EventListener {
    void onDataAvailable() throws IOException;

    void onAllDataRead() throws IOException;

    void onError(Throwable th);
}
