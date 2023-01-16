package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoInterruptedException;
import com.mongodb.connection.AsyncCompletionHandler;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/FutureAsyncCompletionHandler.class */
class FutureAsyncCompletionHandler<T> implements AsyncCompletionHandler<T> {
    private final CountDownLatch latch = new CountDownLatch(1);
    private volatile T result;
    private volatile Throwable error;

    FutureAsyncCompletionHandler() {
    }

    @Override // com.mongodb.connection.AsyncCompletionHandler
    public void completed(T result) {
        this.result = result;
        this.latch.countDown();
    }

    @Override // com.mongodb.connection.AsyncCompletionHandler
    public void failed(Throwable t) {
        this.error = t;
        this.latch.countDown();
    }

    public void getOpen() throws IOException {
        get("Opening");
    }

    public void getWrite() throws IOException {
        get("Writing to");
    }

    public T getRead() throws IOException {
        return get("Reading from");
    }

    private T get(String prefix) throws IOException {
        try {
            this.latch.await();
            if (this.error == null) {
                return this.result;
            }
            if (this.error instanceof IOException) {
                throw ((IOException) this.error);
            } else if (this.error instanceof MongoException) {
                throw ((MongoException) this.error);
            } else {
                throw new MongoInternalException(prefix + " the AsynchronousSocketChannelStream failed", this.error);
            }
        } catch (InterruptedException e) {
            throw new MongoInterruptedException(prefix + " the AsynchronousSocketChannelStream failed", e);
        }
    }
}
