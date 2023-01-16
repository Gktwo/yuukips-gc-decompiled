package org.eclipse.jetty.server;

import java.io.IOException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/RequestLog.class */
public interface RequestLog {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/RequestLog$Writer.class */
    public interface Writer {
        void write(String str) throws IOException;
    }

    void log(Request request, Response response);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/RequestLog$Collection.class */
    public static class Collection implements RequestLog {
        private final RequestLog[] _logs;

        public Collection(RequestLog... logs) {
            this._logs = logs;
        }

        @Override // org.eclipse.jetty.server.RequestLog
        public void log(Request request, Response response) {
            for (RequestLog log : this._logs) {
                log.log(request, response);
            }
        }
    }
}
