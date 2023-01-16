package org.eclipse.jetty.util;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiPartWriter.class */
public class MultiPartWriter extends FilterWriter {
    private static final String CRLF = "\r\n";
    private static final String DASHDASH = "--";
    public static final String MULTIPART_MIXED = "multipart/mixed";
    public static final String MULTIPART_X_MIXED_REPLACE = "multipart/x-mixed-replace";
    private String boundary = "jetty" + System.identityHashCode(this) + Long.toString(System.currentTimeMillis(), 36);
    private boolean inPart;

    public MultiPartWriter(Writer out) throws IOException {
        super(out);
        this.inPart = false;
        this.inPart = false;
    }

    @Override // java.io.FilterWriter, java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (this.inPart) {
                this.out.write("\r\n");
            }
            this.out.write(DASHDASH);
            this.out.write(this.boundary);
            this.out.write(DASHDASH);
            this.out.write("\r\n");
            this.inPart = false;
        } finally {
            close();
        }
    }

    public String getBoundary() {
        return this.boundary;
    }

    public void startPart(String contentType) throws IOException {
        if (this.inPart) {
            this.out.write("\r\n");
        }
        this.out.write(DASHDASH);
        this.out.write(this.boundary);
        this.out.write("\r\n");
        this.out.write("Content-Type: ");
        this.out.write(contentType);
        this.out.write("\r\n");
        this.out.write("\r\n");
        this.inPart = true;
    }

    public void endPart() throws IOException {
        if (this.inPart) {
            this.out.write("\r\n");
        }
        this.inPart = false;
    }

    public void startPart(String contentType, String[] headers) throws IOException {
        if (this.inPart) {
            this.out.write("\r\n");
        }
        this.out.write(DASHDASH);
        this.out.write(this.boundary);
        this.out.write("\r\n");
        this.out.write("Content-Type: ");
        this.out.write(contentType);
        this.out.write("\r\n");
        int i = 0;
        while (headers != null && i < headers.length) {
            this.out.write(headers[i]);
            this.out.write("\r\n");
            i++;
        }
        this.out.write("\r\n");
        this.inPart = true;
    }
}
