package org.eclipse.jetty.server;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncRequestLogWriter.class */
public class AsyncRequestLogWriter extends RequestLogWriter {
    private static final Logger LOG = Log.getLogger(AsyncRequestLogWriter.class);
    private final BlockingQueue<String> _queue;
    private transient WriterThread _thread;
    private boolean _warnedFull;

    public AsyncRequestLogWriter() {
        this(null, null);
    }

    public AsyncRequestLogWriter(String filename) {
        this(filename, null);
    }

    public AsyncRequestLogWriter(String filename, BlockingQueue<String> queue) {
        super(filename);
        this._queue = queue == null ? new BlockingArrayQueue(1024) : queue;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncRequestLogWriter$WriterThread.class */
    private class WriterThread extends Thread {
        WriterThread() {
            setName("AsyncRequestLogWriter@" + Integer.toString(AsyncRequestLogWriter.this.hashCode(), 16));
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (AsyncRequestLogWriter.this.isRunning()) {
                try {
                    String log = (String) AsyncRequestLogWriter.this._queue.poll(10, TimeUnit.SECONDS);
                    if (log != null) {
                        AsyncRequestLogWriter.this.write(log);
                    }
                    while (!AsyncRequestLogWriter.this._queue.isEmpty()) {
                        String log2 = (String) AsyncRequestLogWriter.this._queue.poll();
                        if (log2 != null) {
                            AsyncRequestLogWriter.this.write(log2);
                        }
                    }
                } catch (InterruptedException e) {
                    AsyncRequestLogWriter.LOG.ignore(e);
                } catch (Throwable t) {
                    AsyncRequestLogWriter.LOG.warn(t);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.server.RequestLogWriter, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected synchronized void doStart() throws Exception {
        doStart();
        this._thread = new WriterThread();
        this._thread.start();
    }

    @Override // org.eclipse.jetty.server.RequestLogWriter, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        this._thread.interrupt();
        this._thread.join();
        doStop();
        this._thread = null;
    }

    @Override // org.eclipse.jetty.server.RequestLogWriter, org.eclipse.jetty.server.RequestLog.Writer
    public void write(String log) throws IOException {
        if (!this._queue.offer(log)) {
            if (this._warnedFull) {
                LOG.warn("Log Queue overflow", new Object[0]);
            }
            this._warnedFull = true;
        }
    }
}
