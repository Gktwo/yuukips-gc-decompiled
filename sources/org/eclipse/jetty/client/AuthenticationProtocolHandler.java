package org.eclipse.jetty.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.Connection;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.QuotedCSV;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/AuthenticationProtocolHandler.class */
public abstract class AuthenticationProtocolHandler implements ProtocolHandler {
    public static final int DEFAULT_MAX_CONTENT_LENGTH = 16384;
    private final HttpClient client;
    private final int maxContentLength;
    private final ResponseNotifier notifier = new ResponseNotifier();
    public static final Logger LOG = Log.getLogger(AuthenticationProtocolHandler.class);
    private static final Pattern CHALLENGE_PATTERN = Pattern.compile("(?<schemeOnly>[!#$%&'*+\\-.^_`|~0-9A-Za-z]+)|(?:(?<scheme>[!#$%&'*+\\-.^_`|~0-9A-Za-z]+)\\s+)?(?:(?<token68>[a-zA-Z0-9\\-._~+/]+=*)|(?<paramName>[!#$%&'*+\\-.^_`|~0-9A-Za-z]+)\\s*=\\s*(?:(?<paramValue>.*)))");

    protected abstract HttpHeader getAuthenticateHeader();

    protected abstract HttpHeader getAuthorizationHeader();

    protected abstract URI getAuthenticationURI(Request request);

    protected abstract String getAuthenticationAttribute();

    /* access modifiers changed from: protected */
    public AuthenticationProtocolHandler(HttpClient client, int maxContentLength) {
        this.client = client;
        this.maxContentLength = maxContentLength;
    }

    protected HttpClient getHttpClient() {
        return this.client;
    }

    @Override // org.eclipse.jetty.client.ProtocolHandler
    public Response.Listener getResponseListener() {
        return new AuthenticationListener();
    }

    protected List<Authentication.HeaderInfo> getHeaderInfo(String header) throws IllegalArgumentException {
        List<Authentication.HeaderInfo> headerInfos = new ArrayList<>();
        Iterator<String> it = new QuotedCSV(true, header).iterator();
        while (it.hasNext()) {
            Matcher m = CHALLENGE_PATTERN.matcher(it.next());
            if (m.matches()) {
                if (m.group("schemeOnly") != null) {
                    headerInfos.add(new Authentication.HeaderInfo(getAuthorizationHeader(), m.group(1), new HashMap()));
                } else {
                    if (m.group("scheme") != null) {
                        headerInfos.add(new Authentication.HeaderInfo(getAuthorizationHeader(), m.group("scheme"), new HashMap()));
                    }
                    if (headerInfos.isEmpty()) {
                        throw new IllegalArgumentException("Parameters without auth-scheme");
                    }
                    Map<String, String> authParams = headerInfos.get(headerInfos.size() - 1).getParameters();
                    if (m.group("paramName") != null) {
                        authParams.put(m.group("paramName"), QuotedCSV.unquote(m.group("paramValue")));
                    } else if (m.group("token68") == null) {
                        continue;
                    } else if (!authParams.isEmpty()) {
                        throw new IllegalArgumentException("token68 after auth-params");
                    } else {
                        authParams.put("base64", m.group("token68"));
                    }
                }
            }
        }
        return headerInfos;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/AuthenticationProtocolHandler$AuthenticationListener.class */
    private class AuthenticationListener extends BufferingResponseListener {
        private AuthenticationListener() {
            super(AuthenticationProtocolHandler.this.maxContentLength);
        }

        @Override // org.eclipse.jetty.client.util.BufferingResponseListener, org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
        public void onComplete(Result result) {
            HttpRequest request = (HttpRequest) result.getRequest();
            ContentResponse response = new HttpContentResponse(result.getResponse(), getContent(), getMediaType(), getEncoding());
            if (result.getResponseFailure() != null) {
                if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                    AuthenticationProtocolHandler.LOG.debug("Authentication challenge failed {}", result.getFailure());
                }
                forwardFailureComplete(request, result.getRequestFailure(), response, result.getResponseFailure());
                return;
            }
            String authenticationAttribute = AuthenticationProtocolHandler.this.getAuthenticationAttribute();
            HttpConversation conversation = request.getConversation();
            if (conversation.getAttribute(authenticationAttribute) != null) {
                if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                    AuthenticationProtocolHandler.LOG.debug("Bad credentials for {}", request);
                }
                forwardSuccessComplete(request, response);
                return;
            }
            HttpHeader header = AuthenticationProtocolHandler.this.getAuthenticateHeader();
            List<Authentication.HeaderInfo> headerInfos = parseAuthenticateHeader(response, header);
            if (headerInfos.isEmpty()) {
                if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                    AuthenticationProtocolHandler.LOG.debug("Authentication challenge without {} header", header);
                }
                forwardFailureComplete(request, result.getRequestFailure(), response, new HttpResponseException("HTTP protocol violation: Authentication challenge without " + header + " header", response));
                return;
            }
            Authentication authentication = null;
            Authentication.HeaderInfo headerInfo = null;
            URI authURI = resolveURI(request, AuthenticationProtocolHandler.this.getAuthenticationURI(request));
            if (authURI != null) {
                Iterator<Authentication.HeaderInfo> it = headerInfos.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Authentication.HeaderInfo element = it.next();
                    authentication = AuthenticationProtocolHandler.this.client.getAuthenticationStore().findAuthentication(element.getType(), authURI, element.getRealm());
                    if (authentication != null) {
                        headerInfo = element;
                        break;
                    }
                }
            }
            if (authentication == null) {
                if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                    AuthenticationProtocolHandler.LOG.debug("No authentication available for {}", request);
                }
                forwardSuccessComplete(request, response);
                return;
            }
            ContentProvider requestContent = request.getContent();
            if (requestContent == null || requestContent.isReproducible()) {
                try {
                    Authentication.Result authnResult = authentication.authenticate(request, response, headerInfo, conversation);
                    if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                        AuthenticationProtocolHandler.LOG.debug("Authentication result {}", authnResult);
                    }
                    if (authnResult == null) {
                        forwardSuccessComplete(request, response);
                        return;
                    }
                    conversation.setAttribute(authenticationAttribute, true);
                    URI requestURI = request.getURI();
                    String path = null;
                    if (requestURI == null) {
                        requestURI = resolveURI(request, null);
                        path = request.getPath();
                    }
                    Request newRequest = AuthenticationProtocolHandler.this.client.copyRequest(request, requestURI);
                    long timeoutAt = request.getTimeoutAt();
                    if (timeoutAt < LongCompanionObject.MAX_VALUE) {
                        long newTimeout = timeoutAt - System.nanoTime();
                        if (newTimeout > 0) {
                            newRequest.timeout(newTimeout, TimeUnit.NANOSECONDS);
                        } else {
                            TimeoutException failure = new TimeoutException("Total timeout " + request.getConversation().getTimeout() + " ms elapsed");
                            forwardFailureComplete(request, failure, response, failure);
                            return;
                        }
                    }
                    if (path != null) {
                        newRequest.path(path);
                    }
                    authnResult.apply(newRequest);
                    copyIfAbsent(request, newRequest, HttpHeader.AUTHORIZATION);
                    copyIfAbsent(request, newRequest, HttpHeader.PROXY_AUTHORIZATION);
                    AfterAuthenticationListener listener = new AfterAuthenticationListener(authnResult);
                    Connection connection = (Connection) request.getAttributes().get(Connection.class.getName());
                    if (connection != null) {
                        connection.send(newRequest, listener);
                    } else {
                        newRequest.send(listener);
                    }
                } catch (Throwable x) {
                    if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                        AuthenticationProtocolHandler.LOG.debug("Authentication failed", x);
                    }
                    forwardFailureComplete(request, null, response, x);
                }
            } else {
                if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                    AuthenticationProtocolHandler.LOG.debug("Request content not reproducible for {}", request);
                }
                forwardSuccessComplete(request, response);
            }
        }

        private URI resolveURI(HttpRequest request, URI uri) {
            if (uri != null) {
                return uri;
            }
            String target = request.getScheme() + "://" + request.getHost();
            int port = request.getPort();
            if (port > 0) {
                target = target + EmitterKt.COMMENT_PREFIX + port;
            }
            return URI.create(target);
        }

        private void copyIfAbsent(HttpRequest oldRequest, Request newRequest, HttpHeader header) {
            HttpField field = oldRequest.getHeaders().getField(header);
            if (field != null && !newRequest.getHeaders().contains(header)) {
                newRequest.getHeaders().put(field);
            }
        }

        private void forwardSuccessComplete(HttpRequest request, Response response) {
            HttpConversation conversation = request.getConversation();
            conversation.updateResponseListeners(null);
            AuthenticationProtocolHandler.this.notifier.forwardSuccessComplete(conversation.getResponseListeners(), request, response);
        }

        private void forwardFailureComplete(HttpRequest request, Throwable requestFailure, Response response, Throwable responseFailure) {
            HttpConversation conversation = request.getConversation();
            conversation.updateResponseListeners(null);
            List<Response.ResponseListener> responseListeners = conversation.getResponseListeners();
            if (responseFailure == null) {
                AuthenticationProtocolHandler.this.notifier.forwardSuccess(responseListeners, response);
            } else {
                AuthenticationProtocolHandler.this.notifier.forwardFailure(responseListeners, response, responseFailure);
            }
            AuthenticationProtocolHandler.this.notifier.notifyComplete(responseListeners, new Result(request, requestFailure, response, responseFailure));
        }

        private List<Authentication.HeaderInfo> parseAuthenticateHeader(Response response, HttpHeader header) {
            List<Authentication.HeaderInfo> result = new ArrayList<>();
            for (String value : response.getHeaders().getValuesList(header)) {
                try {
                    result.addAll(AuthenticationProtocolHandler.this.getHeaderInfo(value));
                } catch (IllegalArgumentException e) {
                    if (AuthenticationProtocolHandler.LOG.isDebugEnabled()) {
                        AuthenticationProtocolHandler.LOG.debug("Failed to parse authentication header", e);
                    }
                }
            }
            return result;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/AuthenticationProtocolHandler$AfterAuthenticationListener.class */
    private class AfterAuthenticationListener extends Response.Listener.Adapter {
        private final Authentication.Result authenticationResult;

        private AfterAuthenticationListener(Authentication.Result authenticationResult) {
            this.authenticationResult = authenticationResult;
        }

        @Override // org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.SuccessListener
        public void onSuccess(Response response) {
            int status = response.getStatus();
            if (HttpStatus.isSuccess(status) || HttpStatus.isRedirection(status)) {
                AuthenticationProtocolHandler.this.client.getAuthenticationStore().addAuthenticationResult(this.authenticationResult);
            }
        }
    }
}
