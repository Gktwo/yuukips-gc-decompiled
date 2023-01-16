package org.eclipse.jetty.client;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.p023io.CyclicTimeout;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/client/TimeoutCompleteListener.class */
public class TimeoutCompleteListener extends CyclicTimeout implements Response.CompleteListener {
    private static final Logger LOG = Log.getLogger(TimeoutCompleteListener.class);
    private final AtomicReference<Request> requestTimeout = new AtomicReference<>();

    public TimeoutCompleteListener(Scheduler scheduler) {
        super(scheduler);
    }

    @Override // org.eclipse.jetty.p023io.CyclicTimeout
    public void onTimeoutExpired() {
        Request request = this.requestTimeout.getAndSet(null);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Total timeout {} ms elapsed for {} on {}", Long.valueOf(request.getTimeout()), request, this);
        }
        if (request != null) {
            request.abort(new TimeoutException("Total timeout " + request.getTimeout() + " ms elapsed"));
        }
    }

    @Override // org.eclipse.jetty.client.api.Response.CompleteListener
    public void onComplete(Result result) {
        Request request = this.requestTimeout.getAndSet(null);
        if (request != null) {
            boolean cancelled = cancel();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Cancelled ({}) timeout for {} on {}", Boolean.valueOf(cancelled), request, this);
            }
        }
    }

    void schedule(HttpRequest request, long timeoutAt) {
        if (this.requestTimeout.compareAndSet(null, request)) {
            long delay = Math.max(0L, timeoutAt - System.nanoTime());
            if (LOG.isDebugEnabled()) {
                LOG.debug("Scheduling timeout in {} ms for {} on {}", Long.valueOf(TimeUnit.NANOSECONDS.toMillis(delay)), request, this);
            }
            schedule(delay, TimeUnit.NANOSECONDS);
        }
    }
}
