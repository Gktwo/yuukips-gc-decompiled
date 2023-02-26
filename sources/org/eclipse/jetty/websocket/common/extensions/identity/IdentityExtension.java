package org.eclipse.jetty.websocket.common.extensions.identity;

import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.extensions.AbstractExtension;

@ManagedObject("Identity Extension")
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/identity/IdentityExtension.class */
public class IdentityExtension extends AbstractExtension {

    /* renamed from: id */
    private String f3145id;

    public String getParam(String key) {
        return getConfig().getParameter(key, "?");
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return "identity";
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        nextIncomingFrame(frame);
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        nextOutgoingFrame(frame, callback, batchMode);
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension
    public void setConfig(ExtensionConfig config) {
        setConfig(config);
        StringBuilder s = new StringBuilder();
        s.append(config.getName());
        s.append("@").append(Integer.toHexString(hashCode()));
        s.append("[");
        boolean delim = false;
        for (String param : config.getParameterKeys()) {
            if (delim) {
                s.append(';');
            }
            s.append(param).append('=').append(QuotedStringTokenizer.quoteIfNeeded(config.getParameter(param, ""), ";="));
            delim = true;
        }
        s.append("]");
        this.f3145id = s.toString();
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return this.f3145id;
    }
}
