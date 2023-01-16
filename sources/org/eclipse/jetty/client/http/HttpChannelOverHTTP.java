package org.eclipse.jetty.client.http;

import java.util.Locale;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.client.HttpChannel;
import org.eclipse.jetty.client.HttpExchange;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.client.HttpResponseException;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.HttpVersion;
import p013io.netty.handler.ssl.ApplicationProtocolNames;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/http/HttpChannelOverHTTP.class */
public class HttpChannelOverHTTP extends HttpChannel {
    private final HttpConnectionOverHTTP connection;
    private final LongAdder outMessages = new LongAdder();
    private final HttpSenderOverHTTP sender = newHttpSender();
    private final HttpReceiverOverHTTP receiver = newHttpReceiver();

    public HttpChannelOverHTTP(HttpConnectionOverHTTP connection) {
        super(connection.getHttpDestination());
        this.connection = connection;
    }

    protected HttpSenderOverHTTP newHttpSender() {
        return new HttpSenderOverHTTP(this);
    }

    protected HttpReceiverOverHTTP newHttpReceiver() {
        return new HttpReceiverOverHTTP(this);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.client.HttpChannel
    public HttpSenderOverHTTP getHttpSender() {
        return this.sender;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.client.HttpChannel
    public HttpReceiverOverHTTP getHttpReceiver() {
        return this.receiver;
    }

    public HttpConnectionOverHTTP getHttpConnection() {
        return this.connection;
    }

    @Override // org.eclipse.jetty.client.HttpChannel
    public void send(HttpExchange exchange) {
        this.outMessages.increment();
        this.sender.send(exchange);
    }

    @Override // org.eclipse.jetty.client.HttpChannel
    public void release() {
        this.connection.release();
    }

    @Override // org.eclipse.jetty.client.HttpChannel
    public Result exchangeTerminating(HttpExchange exchange, Result result) {
        if (result.isFailed()) {
            return result;
        }
        HttpResponse response = exchange.getResponse();
        if (response.getVersion() == HttpVersion.HTTP_1_1 && response.getStatus() == 101) {
            String nextConnection = response.getHeaders().get(HttpHeader.CONNECTION);
            if (nextConnection == null || !nextConnection.toLowerCase(Locale.US).contains("upgrade")) {
                return new Result(result, new HttpResponseException("101 Switching Protocols without Connection: Upgrade not supported", response));
            }
            HttpConnectionUpgrader upgrader = (HttpConnectionUpgrader) exchange.getRequest().getConversation().getAttribute(HttpConnectionUpgrader.class.getName());
            if (upgrader != null) {
                try {
                    upgrader.upgrade(response, getHttpConnection());
                } catch (Throwable x) {
                    return new Result(result, x);
                }
            }
        }
        return result;
    }

    public void receive() {
        this.receiver.receive();
    }

    @Override // org.eclipse.jetty.client.HttpChannel
    public void exchangeTerminated(HttpExchange exchange, Result result) {
        exchangeTerminated(exchange, result);
        String method = exchange.getRequest().getMethod();
        Response response = result.getResponse();
        HttpFields responseHeaders = response.getHeaders();
        String closeReason = null;
        if (result.isFailed()) {
            closeReason = "failure";
        } else if (this.receiver.isShutdown()) {
            closeReason = "server close";
        } else if (this.sender.isShutdown()) {
            closeReason = "client close";
        }
        if (closeReason == null) {
            if (response.getVersion().compareTo(HttpVersion.HTTP_1_1) < 0) {
                boolean keepAlive = responseHeaders.contains(HttpHeader.CONNECTION, HttpHeaderValue.KEEP_ALIVE.asString());
                boolean connect = HttpMethod.CONNECT.m40is(method);
                if (!keepAlive && !connect) {
                    closeReason = "http/1.0";
                }
            } else if (responseHeaders.contains(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE.asString())) {
                closeReason = ApplicationProtocolNames.HTTP_1_1;
            }
        }
        if (closeReason != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Closing, reason: {} - {}", closeReason, this.connection);
            }
            this.connection.close();
            return;
        }
        int status = response.getStatus();
        if (status == 101 || isTunnel(method, status)) {
            this.connection.remove();
        } else {
            release();
        }
    }

    /* access modifiers changed from: protected */
    public long getMessagesIn() {
        return this.receiver.getMessagesIn();
    }

    /* access modifiers changed from: protected */
    public long getMessagesOut() {
        return this.outMessages.longValue();
    }

    /* access modifiers changed from: package-private */
    public boolean isTunnel(String method, int status) {
        return HttpMethod.CONNECT.m40is(method) && HttpStatus.isSuccess(status);
    }

    @Override // org.eclipse.jetty.client.HttpChannel
    public String toString() {
        return String.format("%s[send=%s,recv=%s]", toString(), this.sender, this.receiver);
    }
}
