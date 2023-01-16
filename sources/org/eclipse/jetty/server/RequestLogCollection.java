package org.eclipse.jetty.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/RequestLogCollection.class */
public class RequestLogCollection implements RequestLog {
    private final ArrayList<RequestLog> delegates;

    public RequestLogCollection(RequestLog... requestLogs) {
        this.delegates = new ArrayList<>(Arrays.asList(requestLogs));
    }

    public void add(RequestLog requestLog) {
        this.delegates.add(requestLog);
    }

    @Override // org.eclipse.jetty.server.RequestLog
    public void log(Request request, Response response) {
        Iterator<RequestLog> it = this.delegates.iterator();
        while (it.hasNext()) {
            it.next().log(request, response);
        }
    }
}
