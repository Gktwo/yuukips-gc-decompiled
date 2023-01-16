package org.eclipse.jetty.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javassist.compiler.TokenId;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.client.util.BufferingResponseListener;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpRedirector.class */
public class HttpRedirector {
    private static final String SCHEME_REGEXP = "(^https?)";
    private static final String AUTHORITY_REGEXP = "([^/?#]+)";
    private static final String DESTINATION_REGEXP = "((^https?)://([^/?#]+))?";
    private static final String PATH_REGEXP = "([^?#]*)";
    private static final String QUERY_REGEXP = "([^#]*)";
    private static final String FRAGMENT_REGEXP = "(.*)";
    private final HttpClient client;
    private final ResponseNotifier notifier = new ResponseNotifier();
    private static final Logger LOG = Log.getLogger(HttpRedirector.class);
    private static final Pattern URI_PATTERN = Pattern.compile("((^https?)://([^/?#]+))?([^?#]*)([^#]*)(.*)");
    private static final String ATTRIBUTE = HttpRedirector.class.getName() + ".redirects";

    public HttpRedirector(HttpClient client) {
        this.client = client;
    }

    public boolean isRedirect(Response response) {
        switch (response.getStatus()) {
            case 301:
            case 302:
            case 303:
            case 307:
            case 308:
                return true;
            case 304:
            case 305:
            case TokenId.CHAR:
            default:
                return false;
        }
    }

    public Result redirect(Request request, Response response) throws InterruptedException, ExecutionException {
        final AtomicReference<Result> resultRef = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
        Request redirect = redirect(request, response, new BufferingResponseListener() { // from class: org.eclipse.jetty.client.HttpRedirector.1
            @Override // org.eclipse.jetty.client.util.BufferingResponseListener, org.eclipse.jetty.client.api.Response.Listener, org.eclipse.jetty.client.api.Response.CompleteListener
            public void onComplete(Result result) {
                resultRef.set(new Result(result.getRequest(), result.getRequestFailure(), new HttpContentResponse(result.getResponse(), getContent(), getMediaType(), getEncoding()), result.getResponseFailure()));
                latch.countDown();
            }
        });
        try {
            latch.await();
            Result result = resultRef.get();
            if (!result.isFailed()) {
                return result;
            }
            throw new ExecutionException(result.getFailure());
        } catch (InterruptedException x) {
            redirect.abort(x);
            throw x;
        }
    }

    public Request redirect(Request request, Response response, Response.CompleteListener listener) {
        if (isRedirect(response)) {
            String location = response.getHeaders().get("Location");
            URI newURI = extractRedirectURI(response);
            if (newURI != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Redirecting to {} (Location: {})", newURI, location);
                }
                return redirect(request, response, listener, newURI);
            }
            fail(request, response, new HttpResponseException("Invalid 'Location' header: " + location, response));
            return null;
        }
        fail(request, response, new HttpResponseException("Cannot redirect: " + response, response));
        return null;
    }

    public URI extractRedirectURI(Response response) {
        String location = response.getHeaders().get("location");
        if (location != null) {
            return sanitize(location);
        }
        return null;
    }

    private URI sanitize(String location) {
        try {
            return new URI(location);
        } catch (URISyntaxException e) {
            Matcher matcher = URI_PATTERN.matcher(location);
            if (!matcher.matches()) {
                return null;
            }
            String scheme = matcher.group(2);
            String authority = matcher.group(3);
            String path = matcher.group(4);
            String query = matcher.group(5);
            if (query.length() == 0) {
                query = null;
            }
            String fragment = matcher.group(6);
            if (fragment.length() == 0) {
                fragment = null;
            }
            try {
                return new URI(scheme, authority, path, query, fragment);
            } catch (URISyntaxException e2) {
                return null;
            }
        }
    }

    private Request redirect(Request request, Response response, Response.CompleteListener listener, URI newURI) {
        if (!newURI.isAbsolute()) {
            URI requestURI = request.getURI();
            if (requestURI == null) {
                String uri = request.getScheme() + "://" + request.getHost();
                int port = request.getPort();
                if (port > 0) {
                    uri = uri + EmitterKt.COMMENT_PREFIX + port;
                }
                requestURI = URI.create(uri);
            }
            newURI = requestURI.resolve(newURI);
        }
        int status = response.getStatus();
        switch (status) {
            case 301:
                String method = request.getMethod();
                if (HttpMethod.GET.m40is(method) || HttpMethod.HEAD.m40is(method) || HttpMethod.PUT.m40is(method)) {
                    return redirect(request, response, listener, newURI, method);
                }
                if (HttpMethod.POST.m40is(method)) {
                    return redirect(request, response, listener, newURI, HttpMethod.GET.asString());
                }
                fail(request, response, new HttpResponseException("HTTP protocol violation: received 301 for non GET/HEAD/POST/PUT request", response));
                return null;
            case 302:
                String method2 = request.getMethod();
                if (HttpMethod.HEAD.m40is(method2) || HttpMethod.PUT.m40is(method2)) {
                    return redirect(request, response, listener, newURI, method2);
                }
                return redirect(request, response, listener, newURI, HttpMethod.GET.asString());
            case 303:
                String method3 = request.getMethod();
                if (HttpMethod.HEAD.m40is(method3)) {
                    return redirect(request, response, listener, newURI, method3);
                }
                return redirect(request, response, listener, newURI, HttpMethod.GET.asString());
            case 304:
            case 305:
            case TokenId.CHAR:
            default:
                fail(request, response, new HttpResponseException("Unhandled HTTP status code " + status, response));
                return null;
            case 307:
            case 308:
                return redirect(request, response, listener, newURI, request.getMethod());
        }
    }

    private Request redirect(Request request, Response response, Response.CompleteListener listener, URI location, String method) {
        HttpRequest httpRequest = (HttpRequest) request;
        HttpConversation conversation = httpRequest.getConversation();
        Integer redirects = (Integer) conversation.getAttribute(ATTRIBUTE);
        if (redirects == null) {
            redirects = 0;
        }
        int maxRedirects = this.client.getMaxRedirects();
        if (maxRedirects < 0 || redirects.intValue() < maxRedirects) {
            conversation.setAttribute(ATTRIBUTE, Integer.valueOf(redirects.intValue() + 1));
            return sendRedirect(httpRequest, response, listener, location, method);
        }
        fail(request, response, new HttpResponseException("Max redirects exceeded " + redirects, response));
        return null;
    }

    private Request sendRedirect(HttpRequest httpRequest, Response response, Response.CompleteListener listener, URI location, String method) {
        try {
            Request redirect = this.client.copyRequest(httpRequest, location);
            long timeoutAt = httpRequest.getTimeoutAt();
            if (timeoutAt < LongCompanionObject.MAX_VALUE) {
                long newTimeout = timeoutAt - System.nanoTime();
                if (newTimeout > 0) {
                    redirect.timeout(newTimeout, TimeUnit.NANOSECONDS);
                } else {
                    fail(httpRequest, new TimeoutException("Total timeout " + httpRequest.getConversation().getTimeout() + " ms elapsed"), response);
                    return null;
                }
            }
            redirect.method(method);
            redirect.onRequestBegin(request -> {
                Throwable cause = httpRequest.getAbortCause();
                if (cause != null) {
                    request.abort(cause);
                }
            });
            redirect.send(listener);
            return redirect;
        } catch (Throwable x) {
            fail(httpRequest, x, response);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void fail(Request request, Response response, Throwable failure) {
        fail(request, null, response, failure);
    }

    protected void fail(Request request, Throwable failure, Response response) {
        fail(request, failure, response, failure);
    }

    private void fail(Request request, Throwable requestFailure, Response response, Throwable responseFailure) {
        HttpConversation conversation = ((HttpRequest) request).getConversation();
        conversation.updateResponseListeners(null);
        List<Response.ResponseListener> listeners = conversation.getResponseListeners();
        this.notifier.notifyFailure(listeners, response, responseFailure);
        this.notifier.notifyComplete(listeners, new Result(request, requestFailure, response, responseFailure));
    }
}
