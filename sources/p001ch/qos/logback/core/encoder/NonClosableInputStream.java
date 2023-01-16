package p001ch.qos.logback.core.encoder;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ch.qos.logback.core.encoder.NonClosableInputStream */
/* loaded from: grasscutter.jar:ch/qos/logback/core/encoder/NonClosableInputStream.class */
public class NonClosableInputStream extends FilterInputStream {
    NonClosableInputStream(InputStream is) {
        super(is);
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() {
    }

    public void realClose() throws IOException {
        close();
    }
}
