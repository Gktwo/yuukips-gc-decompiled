package org.eclipse.jetty.client;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.LongConsumer;
import java.util.function.ObjLongConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.CountingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ResponseNotifier.class */
public class ResponseNotifier {
    private static final Logger LOG = Log.getLogger(ResponseNotifier.class);

    public void notifyBegin(List<Response.ResponseListener> listeners, Response response) {
        for (Response.ResponseListener listener : listeners) {
            if (listener instanceof Response.BeginListener) {
                notifyBegin((Response.BeginListener) listener, response);
            }
        }
    }

    private void notifyBegin(Response.BeginListener listener, Response response) {
        try {
            listener.onBegin(response);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public boolean notifyHeader(List<Response.ResponseListener> listeners, Response response, HttpField field) {
        boolean result = true;
        for (Response.ResponseListener listener : listeners) {
            if (listener instanceof Response.HeaderListener) {
                result &= notifyHeader((Response.HeaderListener) listener, response, field);
            }
        }
        return result;
    }

    private boolean notifyHeader(Response.HeaderListener listener, Response response, HttpField field) {
        try {
            return listener.onHeader(response, field);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
            return false;
        }
    }

    public void notifyHeaders(List<Response.ResponseListener> listeners, Response response) {
        for (Response.ResponseListener listener : listeners) {
            if (listener instanceof Response.HeadersListener) {
                notifyHeaders((Response.HeadersListener) listener, response);
            }
        }
    }

    private void notifyHeaders(Response.HeadersListener listener, Response response) {
        try {
            listener.onHeaders(response);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyBeforeContent(Response response, ObjLongConsumer<Object> demand, List<Response.DemandedContentListener> contentListeners) {
        for (Response.DemandedContentListener listener : contentListeners) {
            notifyBeforeContent(listener, response, d -> {
                demand.accept(listener, d);
            });
        }
    }

    private void notifyBeforeContent(Response.DemandedContentListener listener, Response response, LongConsumer demand) {
        try {
            listener.onBeforeContent(response, demand);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyContent(Response response, ObjLongConsumer<Object> demand, ByteBuffer buffer, Callback callback, List<Response.DemandedContentListener> contentListeners) {
        int count = contentListeners.size();
        if (count == 0) {
            callback.succeeded();
            demand.accept(null, 1);
        } else if (count == 1) {
            Response.DemandedContentListener listener = contentListeners.get(0);
            notifyContent(listener, response, d -> {
                demand.accept(listener, d);
            }, buffer.slice(), callback);
        } else {
            Callback callback2 = new CountingCallback(callback, count);
            for (Response.DemandedContentListener listener2 : contentListeners) {
                notifyContent(listener2, response, d -> {
                    demand.accept(listener2, d);
                }, buffer.slice(), callback2);
            }
        }
    }

    private void notifyContent(Response.DemandedContentListener listener, Response response, LongConsumer demand, ByteBuffer buffer, Callback callback) {
        try {
            listener.onContent(response, demand, buffer, callback);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifySuccess(List<Response.ResponseListener> listeners, Response response) {
        for (Response.ResponseListener listener : listeners) {
            if (listener instanceof Response.SuccessListener) {
                notifySuccess((Response.SuccessListener) listener, response);
            }
        }
    }

    private void notifySuccess(Response.SuccessListener listener, Response response) {
        try {
            listener.onSuccess(response);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyFailure(List<Response.ResponseListener> listeners, Response response, Throwable failure) {
        for (Response.ResponseListener listener : listeners) {
            if (listener instanceof Response.FailureListener) {
                notifyFailure((Response.FailureListener) listener, response, failure);
            }
        }
    }

    private void notifyFailure(Response.FailureListener listener, Response response, Throwable failure) {
        try {
            listener.onFailure(response, failure);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void notifyComplete(List<Response.ResponseListener> listeners, Result result) {
        for (Response.ResponseListener listener : listeners) {
            if (listener instanceof Response.CompleteListener) {
                notifyComplete((Response.CompleteListener) listener, result);
            }
        }
    }

    private void notifyComplete(Response.CompleteListener listener, Result result) {
        try {
            listener.onComplete(result);
        } catch (Throwable x) {
            LOG.info("Exception while notifying listener " + listener, x);
        }
    }

    public void forwardSuccess(List<Response.ResponseListener> listeners, Response response) {
        forwardEvents(listeners, response);
        notifySuccess(listeners, response);
    }

    public void forwardSuccessComplete(List<Response.ResponseListener> listeners, Request request, Response response) {
        forwardSuccess(listeners, response);
        notifyComplete(listeners, new Result(request, response));
    }

    public void forwardFailure(List<Response.ResponseListener> listeners, Response response, Throwable failure) {
        forwardEvents(listeners, response);
        notifyFailure(listeners, response, failure);
    }

    private void forwardEvents(List<Response.ResponseListener> listeners, Response response) {
        byte[] content;
        notifyBegin(listeners, response);
        Iterator<HttpField> iterator = response.getHeaders().iterator();
        while (iterator.hasNext()) {
            if (!notifyHeader(listeners, response, iterator.next())) {
                iterator.remove();
            }
        }
        notifyHeaders(listeners, response);
        if ((response instanceof ContentResponse) && (content = ((ContentResponse) response).getContent()) != null && content.length > 0) {
            Stream<Response.ResponseListener> stream = listeners.stream();
            Objects.requireNonNull(Response.DemandedContentListener.class);
            Stream<Response.ResponseListener> filter = stream.filter((v1) -> {
                return r1.isInstance(v1);
            });
            Objects.requireNonNull(Response.DemandedContentListener.class);
            List<Response.DemandedContentListener> contentListeners = (List) filter.map((v1) -> {
                return r1.cast(v1);
            }).collect(Collectors.toList());
            ObjLongConsumer<Object> demand = context, value -> {
            };
            notifyBeforeContent(response, demand, contentListeners);
            notifyContent(response, demand, ByteBuffer.wrap(content), Callback.NOOP, contentListeners);
        }
    }

    public void forwardFailureComplete(List<Response.ResponseListener> listeners, Request request, Throwable requestFailure, Response response, Throwable responseFailure) {
        forwardFailure(listeners, response, responseFailure);
        notifyComplete(listeners, new Result(request, requestFailure, response, responseFailure));
    }
}
