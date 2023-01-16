package org.eclipse.jetty.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiPartOutputStream.class */
public class MultiPartOutputStream extends FilterOutputStream {
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};
    public static final String MULTIPART_MIXED = "multipart/mixed";
    public static final String MULTIPART_X_MIXED_REPLACE = "multipart/x-mixed-replace";
    private final String boundary;
    private final byte[] boundaryBytes;
    private boolean inPart;

    public MultiPartOutputStream(OutputStream out) throws IOException {
        super(out);
        this.inPart = false;
        this.boundary = "jetty" + System.identityHashCode(this) + Long.toString(System.currentTimeMillis(), 36);
        this.boundaryBytes = this.boundary.getBytes(StandardCharsets.ISO_8859_1);
    }

    public MultiPartOutputStream(OutputStream out, String boundary) throws IOException {
        super(out);
        this.inPart = false;
        this.boundary = boundary;
        this.boundaryBytes = boundary.getBytes(StandardCharsets.ISO_8859_1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (this.inPart) {
                this.out.write(CRLF);
            }
            this.out.write(DASHDASH);
            this.out.write(this.boundaryBytes);
            this.out.write(DASHDASH);
            this.out.write(CRLF);
            this.inPart = false;
        } finally {
            close();
        }
    }

    public String getBoundary() {
        return this.boundary;
    }

    public OutputStream getOut() {
        return this.out;
    }

    public void startPart(String contentType) throws IOException {
        if (this.inPart) {
            this.out.write(CRLF);
        }
        this.inPart = true;
        this.out.write(DASHDASH);
        this.out.write(this.boundaryBytes);
        this.out.write(CRLF);
        if (contentType != null) {
            this.out.write(("Content-Type: " + contentType).getBytes(StandardCharsets.ISO_8859_1));
            this.out.write(CRLF);
        }
        this.out.write(CRLF);
    }

    public void startPart(String contentType, String[] headers) throws IOException {
        if (this.inPart) {
            this.out.write(CRLF);
        }
        this.inPart = true;
        this.out.write(DASHDASH);
        this.out.write(this.boundaryBytes);
        this.out.write(CRLF);
        if (contentType != null) {
            this.out.write(("Content-Type: " + contentType).getBytes(StandardCharsets.ISO_8859_1));
            this.out.write(CRLF);
        }
        int i = 0;
        while (headers != null && i < headers.length) {
            this.out.write(headers[i].getBytes(StandardCharsets.ISO_8859_1));
            this.out.write(CRLF);
            i++;
        }
        this.out.write(CRLF);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
    }
}
