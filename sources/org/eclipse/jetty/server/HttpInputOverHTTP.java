package org.eclipse.jetty.server;

import java.io.IOException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInputOverHTTP.class */
public class HttpInputOverHTTP extends HttpInput {
    public HttpInputOverHTTP(HttpChannelState state) {
        super(state);
    }

    @Override // org.eclipse.jetty.server.HttpInput
    protected void produceContent() throws IOException {
        ((HttpConnection) getHttpChannelState().getHttpChannel().getEndPoint().getConnection()).fillAndParseForContent();
    }
}
