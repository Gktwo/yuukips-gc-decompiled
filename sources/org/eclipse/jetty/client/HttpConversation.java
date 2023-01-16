package org.eclipse.jetty.client;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpConversation.class */
public class HttpConversation extends AttributesMap {
    private static final Logger LOG = Log.getLogger(HttpConversation.class);
    private final Deque<HttpExchange> exchanges = new ConcurrentLinkedDeque();
    private volatile List<Response.ResponseListener> listeners;

    public Deque<HttpExchange> getExchanges() {
        return this.exchanges;
    }

    public List<Response.ResponseListener> getResponseListeners() {
        return this.listeners;
    }

    public void updateResponseListeners(Response.ResponseListener overrideListener) {
        HttpExchange firstExchange = this.exchanges.peekFirst();
        HttpExchange lastExchange = this.exchanges.peekLast();
        List<Response.ResponseListener> listeners = new ArrayList<>(firstExchange.getResponseListeners().size() + lastExchange.getResponseListeners().size());
        if (firstExchange != lastExchange) {
            listeners.addAll(lastExchange.getResponseListeners());
            if (overrideListener != null) {
                listeners.add(overrideListener);
            } else {
                listeners.addAll(firstExchange.getResponseListeners());
            }
        } else if (overrideListener != null) {
            listeners.add(overrideListener);
        } else {
            listeners.addAll(firstExchange.getResponseListeners());
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Exchanges in conversation {}, override={}, listeners={}", Integer.valueOf(this.exchanges.size()), overrideListener, listeners);
        }
        this.listeners = listeners;
    }

    public long getTimeout() {
        HttpExchange firstExchange = this.exchanges.peekFirst();
        if (firstExchange == null) {
            return 0;
        }
        return firstExchange.getRequest().getTimeout();
    }

    public boolean abort(Throwable cause) {
        HttpExchange exchange = this.exchanges.peekLast();
        return exchange != null && exchange.abort(cause);
    }

    @Override // org.eclipse.jetty.util.AttributesMap
    public String toString() {
        return String.format("%s[%x]", HttpConversation.class.getSimpleName(), Integer.valueOf(hashCode()));
    }
}
