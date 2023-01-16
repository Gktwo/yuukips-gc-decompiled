package org.eclipse.jetty.client.util;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.jetty.client.HttpContentResponse;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Result;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/FutureResponseListener.class */
public class FutureResponseListener extends BufferingResponseListener implements Future<ContentResponse> {
    private final CountDownLatch latch;
    private final Request request;
    private ContentResponse response;
    private Throwable failure;
    private volatile boolean cancelled;

    public FutureResponseListener(Request request) {
        this(request, 2097152);
    }

    public FutureResponseListener(Request request, int maxLength) {
        super(maxLength);
        this.latch = new CountDownLatch(1);
        this.request = request;
    }

    public Request getRequest() {
        return this.request;
    }

    @Override // org.eclipse.jetty.client.util.BufferingResponseListener, org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
    public void onComplete(Result result) {
        this.response = new HttpContentResponse(result.getResponse(), getContent(), getMediaType(), getEncoding());
        this.failure = result.getFailure();
        this.latch.countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        this.cancelled = true;
        return this.request.abort(new CancellationException());
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.latch.getCount() == 0 || isCancelled();
    }

    @Override // java.util.concurrent.Future
    public ContentResponse get() throws InterruptedException, ExecutionException {
        this.latch.await();
        return getResult();
    }

    @Override // java.util.concurrent.Future
    public ContentResponse get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!(!this.latch.await(timeout, unit))) {
            return getResult();
        }
        throw new TimeoutException();
    }

    private ContentResponse getResult() throws ExecutionException {
        if (isCancelled()) {
            throw ((CancellationException) new CancellationException().initCause(this.failure));
        } else if (this.failure == null) {
            return this.response;
        } else {
            throw new ExecutionException(this.failure);
        }
    }
}
