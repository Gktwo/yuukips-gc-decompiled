package org.eclipse.jetty.server;

import java.util.concurrent.BlockingQueue;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AsyncNCSARequestLog.class */
public class AsyncNCSARequestLog extends NCSARequestLog {
    public AsyncNCSARequestLog() {
        this(null, null);
    }

    public AsyncNCSARequestLog(String filename, BlockingQueue<String> queue) {
        super(new AsyncRequestLogWriter(filename, queue));
    }
}
