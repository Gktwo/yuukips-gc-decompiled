package org.eclipse.jetty.client;

import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ContinueProtocolHandler.class */
public class ContinueProtocolHandler implements ProtocolHandler {
    public static final String NAME = "continue";
    private static final String ATTRIBUTE = ContinueProtocolHandler.class.getName() + ".100continue";
    private final ResponseNotifier notifier = new ResponseNotifier();

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public String getName() {
        return NAME;
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public boolean accept(Request request, Response response) {
        return ((response.getStatus() == 100) || request.getHeaders().contains(HttpHeader.EXPECT, HttpHeaderValue.CONTINUE.asString())) && !request.getAttributes().containsKey(ATTRIBUTE);
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public Response.Listener getResponseListener() {
        return new ContinueListener();
    }

    protected void onContinue(Request request) {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ContinueProtocolHandler$ContinueListener.class */
    protected class ContinueListener extends BufferingResponseListener {
        static final /* synthetic */ boolean $assertionsDisabled;

        protected ContinueListener() {
        }

        static {
            $assertionsDisabled = !ContinueProtocolHandler.class.desiredAssertionStatus();
        }

        @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.SuccessListener
        public void onSuccess(Response response) {
            Request request = response.getRequest();
            HttpConversation conversation = ((HttpRequest) request).getConversation();
            request.attribute(ContinueProtocolHandler.ATTRIBUTE, Boolean.TRUE);
            conversation.updateResponseListeners(null);
            HttpExchange exchange = conversation.getExchanges().peekLast();
            if (response.getStatus() == 100) {
                exchange.resetResponse();
                exchange.proceed(null);
                ContinueProtocolHandler.this.onContinue(request);
                return;
            }
            ContinueProtocolHandler.this.notifier.forwardSuccess(exchange.getResponseListeners(), new HttpContentResponse(response, getContent(), getMediaType(), getEncoding()));
            exchange.proceed(new HttpRequestException("Expectation failed", request));
        }

        @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.FailureListener
        public void onFailure(Response response, Throwable failure) {
            HttpConversation conversation = ((HttpRequest) response.getRequest()).getConversation();
            conversation.setAttribute(ContinueProtocolHandler.ATTRIBUTE, Boolean.TRUE);
            conversation.updateResponseListeners(null);
            HttpExchange exchange = conversation.getExchanges().peekLast();
            if ($assertionsDisabled || exchange.getResponse() == response) {
                ContinueProtocolHandler.this.notifier.forwardFailureComplete(exchange.getResponseListeners(), exchange.getRequest(), exchange.getRequestFailure(), new HttpContentResponse(response, getContent(), getMediaType(), getEncoding()), failure);
                return;
            }
            throw new AssertionError();
        }

        @Override // org.eclipse.jetty.client.util.BufferingResponseListener, org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
        public void onComplete(Result result) {
        }
    }
}
