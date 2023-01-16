package org.eclipse.jetty.server;

import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/PushBuilder.class */
public interface PushBuilder {
    PushBuilder method(String str);

    PushBuilder queryString(String str);

    PushBuilder sessionId(String str);

    PushBuilder conditional(boolean z);

    PushBuilder setHeader(String str, String str2);

    PushBuilder addHeader(String str, String str2);

    PushBuilder removeHeader(String str);

    PushBuilder path(String str);

    PushBuilder etag(String str);

    PushBuilder lastModified(String str);

    void push();

    String getMethod();

    String getQueryString();

    String getSessionId();

    boolean isConditional();

    Set<String> getHeaderNames();

    String getHeader(String str);

    String getPath();

    String getEtag();

    String getLastModified();
}
