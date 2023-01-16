package org.eclipse.jetty.server.handler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Objects;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.handler.BufferedResponseHandler;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/FileBufferedResponseHandler.class */
public class FileBufferedResponseHandler extends BufferedResponseHandler {
    private static final Logger LOG = Log.getLogger(FileBufferedResponseHandler.class);
    private Path _tempDir = new File(System.getProperty("java.io.tmpdir")).toPath();

    public Path getTempDir() {
        return this._tempDir;
    }

    public void setTempDir(Path tempDir) {
        this._tempDir = (Path) Objects.requireNonNull(tempDir);
    }

    @Override // org.eclipse.jetty.server.handler.BufferedResponseHandler
    protected BufferedResponseHandler.BufferedInterceptor newBufferedInterceptor(HttpChannel httpChannel, HttpOutput.Interceptor interceptor) {
        return new FileBufferedInterceptor(httpChannel, interceptor);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/FileBufferedResponseHandler$FileBufferedInterceptor.class */
    class FileBufferedInterceptor implements BufferedResponseHandler.BufferedInterceptor {
        private static final int MAX_MAPPED_BUFFER_SIZE = 1073741823;
        private final HttpOutput.Interceptor _next;
        private final HttpChannel _channel;
        private Boolean _aggregating;
        private Path _filePath;
        private OutputStream _fileOutputStream;

        public FileBufferedInterceptor(HttpChannel httpChannel, HttpOutput.Interceptor interceptor) {
            this._next = interceptor;
            this._channel = httpChannel;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public HttpOutput.Interceptor getNextInterceptor() {
            return this._next;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public boolean isOptimizedForDirectBuffers() {
            return false;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public void resetBuffer() {
            dispose();
            resetBuffer();
        }

        private void closeFileOutput() {
            if (this._fileOutputStream != null) {
                try {
                    this._fileOutputStream.flush();
                } catch (IOException e) {
                    FileBufferedResponseHandler.LOG.debug("flush failure", e);
                }
                C5747IO.close(this._fileOutputStream);
                this._fileOutputStream = null;
            }
        }

        protected void dispose() {
            closeFileOutput();
            this._aggregating = null;
            if (this._filePath != null) {
                try {
                    Files.deleteIfExists(this._filePath);
                } catch (Throwable t) {
                    FileBufferedResponseHandler.LOG.debug("Could not immediately delete file (delaying to jvm exit) {}", this._filePath, t);
                    this._filePath.toFile().deleteOnExit();
                }
                this._filePath = null;
            }
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public void write(ByteBuffer content, boolean last, Callback callback) {
            if (FileBufferedResponseHandler.LOG.isDebugEnabled()) {
                FileBufferedResponseHandler.LOG.debug("{} write last={} {}", this, Boolean.valueOf(last), BufferUtil.toDetailString(content));
            }
            if (this._aggregating == null) {
                this._aggregating = Boolean.valueOf(FileBufferedResponseHandler.this.shouldBuffer(this._channel, last));
            }
            if (!this._aggregating.booleanValue()) {
                getNextInterceptor().write(content, last, callback);
                return;
            }
            if (FileBufferedResponseHandler.LOG.isDebugEnabled()) {
                FileBufferedResponseHandler.LOG.debug("{} aggregating", this);
            }
            try {
                if (BufferUtil.hasContent(content)) {
                    aggregate(content);
                }
                if (last) {
                    commit(callback);
                } else {
                    callback.succeeded();
                }
            } catch (Throwable t) {
                dispose();
                callback.failed(t);
            }
        }

        private void aggregate(ByteBuffer content) throws IOException {
            if (this._fileOutputStream == null) {
                this._filePath = Files.createTempFile(FileBufferedResponseHandler.this._tempDir, "BufferedResponse", "", new FileAttribute[0]);
                this._fileOutputStream = Files.newOutputStream(this._filePath, StandardOpenOption.WRITE);
            }
            BufferUtil.writeTo(content, this._fileOutputStream);
        }

        private void commit(final Callback callback) {
            if (this._fileOutputStream == null) {
                getNextInterceptor().write(BufferUtil.EMPTY_BUFFER, true, callback);
                return;
            }
            try {
                closeFileOutput();
                new IteratingCallback() { // from class: org.eclipse.jetty.server.handler.FileBufferedResponseHandler.FileBufferedInterceptor.1
                    private final long fileLength;
                    private long _pos = 0;
                    private boolean _last = false;

                    {
                        this.fileLength = FileBufferedInterceptor.this._filePath.toFile().length();
                    }

                    @Override // org.eclipse.jetty.util.IteratingCallback
                    protected IteratingCallback.Action process() throws Exception {
                        if (this._last) {
                            return IteratingCallback.Action.SUCCEEDED;
                        }
                        long len = Math.min(1073741823L, this.fileLength - this._pos);
                        this._last = this._pos + len == this.fileLength;
                        FileBufferedInterceptor.this.getNextInterceptor().write(BufferUtil.toMappedBuffer(FileBufferedInterceptor.this._filePath, this._pos, len), this._last, this);
                        this._pos += len;
                        return IteratingCallback.Action.SCHEDULED;
                    }

                    /* access modifiers changed from: protected */
                    @Override // org.eclipse.jetty.util.IteratingCallback
                    public void onCompleteSuccess() {
                        FileBufferedInterceptor.this.dispose();
                        callback.succeeded();
                    }

                    /* access modifiers changed from: protected */
                    @Override // org.eclipse.jetty.util.IteratingCallback
                    public void onCompleteFailure(Throwable cause) {
                        FileBufferedInterceptor.this.dispose();
                        callback.failed(cause);
                    }
                }.iterate();
            } catch (Throwable t) {
                dispose();
                callback.failed(t);
            }
        }
    }
}
