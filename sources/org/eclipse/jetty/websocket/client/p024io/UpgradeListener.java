package org.eclipse.jetty.websocket.client.p024io;

import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.UpgradeResponse;

/* renamed from: org.eclipse.jetty.websocket.client.io.UpgradeListener */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/io/UpgradeListener.class */
public interface UpgradeListener {
    void onHandshakeRequest(UpgradeRequest upgradeRequest);

    void onHandshakeResponse(UpgradeResponse upgradeResponse);
}
