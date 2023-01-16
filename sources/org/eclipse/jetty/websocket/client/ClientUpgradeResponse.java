package org.eclipse.jetty.websocket.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jetty.client.HttpResponse;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.common.UpgradeResponseAdapter;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/ClientUpgradeResponse.class */
public class ClientUpgradeResponse extends UpgradeResponseAdapter {
    private List<ExtensionConfig> extensions;

    public ClientUpgradeResponse() {
    }

    public ClientUpgradeResponse(HttpResponse response) {
        setStatusCode(response.getStatus());
        setStatusReason(response.getReason());
        HttpFields fields = response.getHeaders();
        Iterator<HttpField> it = fields.iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            addHeader(field.getName(), field.getValue());
        }
        HttpField extensionsField = fields.getField(HttpHeader.SEC_WEBSOCKET_EXTENSIONS);
        if (extensionsField != null) {
            this.extensions = ExtensionConfig.parseList(extensionsField.getValues());
        }
        setAcceptedSubProtocol(fields.get(HttpHeader.SEC_WEBSOCKET_SUBPROTOCOL));
    }

    @Override // org.eclipse.jetty.websocket.common.UpgradeResponseAdapter, org.eclipse.jetty.websocket.api.UpgradeResponse
    public boolean isSuccess() {
        return true;
    }

    @Override // org.eclipse.jetty.websocket.common.UpgradeResponseAdapter, org.eclipse.jetty.websocket.api.UpgradeResponse
    public List<ExtensionConfig> getExtensions() {
        return this.extensions;
    }

    @Override // org.eclipse.jetty.websocket.common.UpgradeResponseAdapter, org.eclipse.jetty.websocket.api.UpgradeResponse
    public void sendForbidden(String message) throws IOException {
        throw new UnsupportedOperationException("Not supported on client implementation");
    }
}
