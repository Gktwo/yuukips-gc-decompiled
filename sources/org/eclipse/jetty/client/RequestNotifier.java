package org.eclipse.jetty.client;

import java.nio.ByteBuffer;
import java.util.List;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/RequestNotifier.class */
public class RequestNotifier {
    private static final Logger LOG = Log.getLogger(ResponseNotifier.class);
    private final HttpClient client;

    public RequestNotifier(HttpClient client) {
        this.client = client;
    }

    public void notifyQueued(Request request) {
        List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
        for (int i = 0; i < requestListeners.size(); i++) {
            Request.RequestListener listener = requestListeners.get(i);
            if (listener instanceof Request.QueuedListener) {
                notifyQueued((Request.QueuedListener) listener, request);
            }
        }
        List<Request.Listener> listeners = this.client.getRequestListeners();
        for (int i2 = 0; i2 < listeners.size(); i2++) {
            notifyQueued(listeners.get(i2), request);
        }
    }

    private void notifyQueued(Request.QueuedListener listener, Request request) {
        try {
            listener.onQueued(request);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyBegin(Request request) {
        List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
        for (int i = 0; i < requestListeners.size(); i++) {
            Request.RequestListener listener = requestListeners.get(i);
            if (listener instanceof Request.BeginListener) {
                notifyBegin((Request.BeginListener) listener, request);
            }
        }
        List<Request.Listener> listeners = this.client.getRequestListeners();
        for (int i2 = 0; i2 < listeners.size(); i2++) {
            notifyBegin(listeners.get(i2), request);
        }
    }

    private void notifyBegin(Request.BeginListener listener, Request request) {
        try {
            listener.onBegin(request);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyHeaders(Request request) {
        List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
        for (int i = 0; i < requestListeners.size(); i++) {
            Request.RequestListener listener = requestListeners.get(i);
            if (listener instanceof Request.HeadersListener) {
                notifyHeaders((Request.HeadersListener) listener, request);
            }
        }
        List<Request.Listener> listeners = this.client.getRequestListeners();
        for (int i2 = 0; i2 < listeners.size(); i2++) {
            notifyHeaders(listeners.get(i2), request);
        }
    }

    private void notifyHeaders(Request.HeadersListener listener, Request request) {
        try {
            listener.onHeaders(request);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyCommit(Request request) {
        List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
        for (int i = 0; i < requestListeners.size(); i++) {
            Request.RequestListener listener = requestListeners.get(i);
            if (listener instanceof Request.CommitListener) {
                notifyCommit((Request.CommitListener) listener, request);
            }
        }
        List<Request.Listener> listeners = this.client.getRequestListeners();
        for (int i2 = 0; i2 < listeners.size(); i2++) {
            notifyCommit(listeners.get(i2), request);
        }
    }

    private void notifyCommit(Request.CommitListener listener, Request request) {
        try {
            listener.onCommit(request);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyContent(Request request, ByteBuffer content) {
        ByteBuffer content2 = content.slice();
        if (content2.hasRemaining()) {
            List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
            for (int i = 0; i < requestListeners.size(); i++) {
                Request.RequestListener listener = requestListeners.get(i);
                if (listener instanceof Request.ContentListener) {
                    content2.clear();
                    notifyContent((Request.ContentListener) listener, request, content2);
                }
            }
            List<Request.Listener> listeners = this.client.getRequestListeners();
            for (int i2 = 0; i2 < listeners.size(); i2++) {
                content2.clear();
                notifyContent(listeners.get(i2), request, content2);
            }
        }
    }

    private void notifyContent(Request.ContentListener listener, Request request, ByteBuffer content) {
        try {
            listener.onContent(request, content);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifySuccess(Request request) {
        List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
        for (int i = 0; i < requestListeners.size(); i++) {
            Request.RequestListener listener = requestListeners.get(i);
            if (listener instanceof Request.SuccessListener) {
                notifySuccess((Request.SuccessListener) listener, request);
            }
        }
        List<Request.Listener> listeners = this.client.getRequestListeners();
        for (int i2 = 0; i2 < listeners.size(); i2++) {
            notifySuccess(listeners.get(i2), request);
        }
    }

    private void notifySuccess(Request.SuccessListener listener, Request request) {
        try {
            listener.onSuccess(request);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyFailure(Request request, Throwable failure) {
        List<Request.RequestListener> requestListeners = request.getRequestListeners(null);
        for (int i = 0; i < requestListeners.size(); i++) {
            Request.RequestListener listener = requestListeners.get(i);
            if (listener instanceof Request.FailureListener) {
                notifyFailure((Request.FailureListener) listener, request, failure);
            }
        }
        List<Request.Listener> listeners = this.client.getRequestListeners();
        for (int i2 = 0; i2 < listeners.size(); i2++) {
            notifyFailure(listeners.get(i2), request, failure);
        }
    }

    private void notifyFailure(Request.FailureListener listener, Request request, Throwable failure) {
        try {
            listener.onFailure(request, failure);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }
}
