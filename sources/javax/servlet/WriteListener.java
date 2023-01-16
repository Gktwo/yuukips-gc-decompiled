package javax.servlet;

import java.io.IOException;
import java.util.EventListener;

/* loaded from: grasscutter.jar:javax/servlet/WriteListener.class */
public interface WriteListener extends EventListener {
    void onWritePossible() throws IOException;

    void onError(Throwable th);
}
