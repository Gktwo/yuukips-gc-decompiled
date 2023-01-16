package javax.servlet.http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;
import javax.servlet.ServletOutputStream;

/* compiled from: HttpServlet.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:javax/servlet/http/NoBodyResponse.class */
public class NoBodyResponse extends HttpServletResponseWrapper {
    private static final ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");
    private NoBodyOutputStream noBody = new NoBodyOutputStream();
    private PrintWriter writer;
    private boolean didSetContentLength;
    private boolean usingOutputStream;

    /* access modifiers changed from: package-private */
    public NoBodyResponse(HttpServletResponse r) {
        super(r);
    }

    /* access modifiers changed from: package-private */
    public void setContentLength() {
        if (!this.didSetContentLength) {
            if (this.writer != null) {
                this.writer.flush();
            }
            setContentLength(this.noBody.getContentLength());
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void setContentLength(int len) {
        setContentLength(len);
        this.didSetContentLength = true;
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public void setContentLengthLong(long len) {
        setContentLengthLong(len);
        this.didSetContentLength = true;
    }

    @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
    public void setHeader(String name, String value) {
        setHeader(name, value);
        checkHeader(name);
    }

    @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
    public void addHeader(String name, String value) {
        addHeader(name, value);
        checkHeader(name);
    }

    @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
    public void setIntHeader(String name, int value) {
        setIntHeader(name, value);
        checkHeader(name);
    }

    @Override // javax.servlet.http.HttpServletResponseWrapper, javax.servlet.http.HttpServletResponse
    public void addIntHeader(String name, int value) {
        addIntHeader(name, value);
        checkHeader(name);
    }

    private void checkHeader(String name) {
        if ("content-length".equalsIgnoreCase(name)) {
            this.didSetContentLength = true;
        }
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.writer != null) {
            throw new IllegalStateException(lStrings.getString("err.ise.getOutputStream"));
        }
        this.usingOutputStream = true;
        return this.noBody;
    }

    @Override // javax.servlet.ServletResponseWrapper, javax.servlet.ServletResponse
    public PrintWriter getWriter() throws UnsupportedEncodingException {
        if (this.usingOutputStream) {
            throw new IllegalStateException(lStrings.getString("err.ise.getWriter"));
        }
        if (this.writer == null) {
            this.writer = new PrintWriter(new OutputStreamWriter(this.noBody, getCharacterEncoding()));
        }
        return this.writer;
    }
}
