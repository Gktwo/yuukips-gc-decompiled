package org.eclipse.jetty.server.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.jetty.util.C5739IO;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/resource/InputStreamRangeWriter.class */
public class InputStreamRangeWriter implements RangeWriter {
    public static final int NO_PROGRESS_LIMIT = 3;
    private final InputStreamSupplier inputStreamSupplier;
    private boolean closed = false;
    private InputStream inputStream;
    private long pos;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/resource/InputStreamRangeWriter$InputStreamSupplier.class */
    public interface InputStreamSupplier {
        InputStream newInputStream() throws IOException;
    }

    public InputStreamRangeWriter(InputStreamSupplier inputStreamSupplier) {
        this.inputStreamSupplier = inputStreamSupplier;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        if (this.inputStream != null) {
            this.inputStream.close();
        }
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    @Override // org.eclipse.jetty.server.resource.RangeWriter
    public void writeTo(OutputStream outputStream, long skipTo, long length) throws IOException {
        if (this.closed) {
            throw new IOException("RangeWriter is closed");
        }
        if (this.inputStream == null) {
            this.inputStream = this.inputStreamSupplier.newInputStream();
            this.pos = 0;
        }
        if (skipTo < this.pos) {
            this.inputStream.close();
            this.inputStream = this.inputStreamSupplier.newInputStream();
            this.pos = 0;
        }
        if (this.pos < skipTo) {
            char c = this.pos;
            int noProgressLoopLimit = 3;
            while (noProgressLoopLimit > 0 && c < skipTo) {
                long actualSkipped = this.inputStream.skip(skipTo - c);
                if (actualSkipped == 0) {
                    noProgressLoopLimit--;
                } else if (actualSkipped > 0) {
                    c += actualSkipped;
                    noProgressLoopLimit = 3;
                } else {
                    throw new IOException("EOF reached before InputStream skip destination");
                }
            }
            if (noProgressLoopLimit <= 0) {
                throw new IOException("No progress made to reach InputStream skip position " + (skipTo - this.pos));
            }
            this.pos = skipTo;
        }
        C5739IO.copy(this.inputStream, outputStream, length);
        this.pos += length;
    }
}
