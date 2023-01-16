package javax.servlet.http;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/* compiled from: HttpServlet.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:javax/servlet/http/NoBodyOutputStream.class */
public class NoBodyOutputStream extends ServletOutputStream {
    private static final String LSTRING_FILE = "javax.servlet.http.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle(LSTRING_FILE);
    private int contentLength = 0;

    /* access modifiers changed from: package-private */
    public int getContentLength() {
        return this.contentLength;
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        this.contentLength++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int offset, int len) throws IOException {
        if (buf == null) {
            throw new NullPointerException(lStrings.getString("err.io.nullArray"));
        } else if (offset < 0 || len < 0 || offset + len > buf.length) {
            throw new IndexOutOfBoundsException(MessageFormat.format(lStrings.getString("err.io.indexOutOfBounds"), Integer.valueOf(offset), Integer.valueOf(len), Integer.valueOf(buf.length)));
        } else {
            this.contentLength += len;
        }
    }

    @Override // javax.servlet.ServletOutputStream
    public boolean isReady() {
        return false;
    }

    @Override // javax.servlet.ServletOutputStream
    public void setWriteListener(WriteListener writeListener) {
    }
}
