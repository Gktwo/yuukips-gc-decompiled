package org.eclipse.jetty.client.api;

import java.nio.ByteBuffer;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;
import java.util.function.LongConsumer;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.util.Callback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response.class */
public interface Response {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$BeginListener.class */
    public interface BeginListener extends ResponseListener {
        void onBegin(Response response);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$CompleteListener.class */
    public interface CompleteListener extends ResponseListener {
        void onComplete(Result result);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$FailureListener.class */
    public interface FailureListener extends ResponseListener {
        void onFailure(Response response, Throwable th);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$HeaderListener.class */
    public interface HeaderListener extends ResponseListener {
        boolean onHeader(Response response, HttpField httpField);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$HeadersListener.class */
    public interface HeadersListener extends ResponseListener {
        void onHeaders(Response response);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$ResponseListener.class */
    public interface ResponseListener extends EventListener {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$SuccessListener.class */
    public interface SuccessListener extends ResponseListener {
        void onSuccess(Response response);
    }

    Request getRequest();

    <T extends ResponseListener> List<T> getListeners(Class<T> cls);

    HttpVersion getVersion();

    int getStatus();

    String getReason();

    HttpFields getHeaders();

    boolean abort(Throwable th);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$ContentListener.class */
    public interface ContentListener extends AsyncContentListener {
        void onContent(Response response, ByteBuffer byteBuffer);

        @Override // org.eclipse.jetty.client.api.Response.AsyncContentListener
        default void onContent(Response response, ByteBuffer content, Callback callback) {
            try {
                onContent(response, content);
                callback.succeeded();
            } catch (Throwable x) {
                callback.failed(x);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$AsyncContentListener.class */
    public interface AsyncContentListener extends DemandedContentListener {
        void onContent(Response response, ByteBuffer byteBuffer, Callback callback);

        @Override // org.eclipse.jetty.client.api.Response.DemandedContentListener
        default void onContent(Response response, LongConsumer demand, ByteBuffer content, Callback callback) {
            Runnable r3 = () -> {
                callback.succeeded();
                demand.accept(1);
            };
            Objects.requireNonNull(callback);
            onContent(response, content, Callback.from(r3, this::failed));
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$DemandedContentListener.class */
    public interface DemandedContentListener extends ResponseListener {
        void onContent(Response response, LongConsumer longConsumer, ByteBuffer byteBuffer, Callback callback);

        default void onBeforeContent(Response response, LongConsumer demand) {
            demand.accept(1);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$Listener.class */
    public interface Listener extends BeginListener, HeaderListener, HeadersListener, ContentListener, SuccessListener, FailureListener, CompleteListener {

        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Response$Listener$Adapter.class */
        public static class Adapter implements Listener {
        }

        @Override // org.eclipse.jetty.client.api.Response.BeginListener
        default void onBegin(Response response) {
        }

        @Override // org.eclipse.jetty.client.api.Response.HeaderListener
        default boolean onHeader(Response response, HttpField field) {
            return true;
        }

        @Override // org.eclipse.jetty.client.api.Response.HeadersListener
        default void onHeaders(Response response) {
        }

        @Override // org.eclipse.jetty.client.api.Response.ContentListener
        default void onContent(Response response, ByteBuffer content) {
        }

        @Override // org.eclipse.jetty.client.api.Response.SuccessListener
        default void onSuccess(Response response) {
        }

        @Override // org.eclipse.jetty.client.api.Response.FailureListener
        default void onFailure(Response response, Throwable failure) {
        }

        @Override // org.eclipse.jetty.client.api.Response.CompleteListener
        default void onComplete(Result result) {
        }
    }
}
