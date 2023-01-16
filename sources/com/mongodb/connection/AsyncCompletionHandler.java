package com.mongodb.connection;

/* loaded from: grasscutter.jar:com/mongodb/connection/AsyncCompletionHandler.class */
public interface AsyncCompletionHandler<T> {
    void completed(T t);

    void failed(Throwable th);
}
