package org.eclipse.jetty.client;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.util.component.Dumpable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ProtocolHandlers.class */
public class ProtocolHandlers implements Dumpable {
    private final Map<String, ProtocolHandler> handlers = new LinkedHashMap();

    public ProtocolHandler put(ProtocolHandler protocolHandler) {
        return this.handlers.put(protocolHandler.getName(), protocolHandler);
    }

    public ProtocolHandler remove(String name) {
        return this.handlers.remove(name);
    }

    public void clear() {
        this.handlers.clear();
    }

    public ProtocolHandler find(Request request, Response response) {
        for (ProtocolHandler handler : this.handlers.values()) {
            if (handler.accept(request, response)) {
                return handler;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, this.handlers);
    }
}
