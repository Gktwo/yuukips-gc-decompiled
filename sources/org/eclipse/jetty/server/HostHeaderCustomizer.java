package org.eclipse.jetty.server;

import java.util.Objects;
import org.eclipse.jetty.server.HttpConfiguration;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HostHeaderCustomizer.class */
public class HostHeaderCustomizer implements HttpConfiguration.Customizer {
    private final String serverName;
    private final int serverPort;

    public HostHeaderCustomizer(String serverName) {
        this(serverName, 0);
    }

    public HostHeaderCustomizer(String serverName, int serverPort) {
        this.serverName = (String) Objects.requireNonNull(serverName);
        this.serverPort = serverPort;
    }

    @Override // org.eclipse.jetty.server.HttpConfiguration.Customizer
    public void customize(Connector connector, HttpConfiguration channelConfig, Request request) {
        if (request.getHeader("Host") == null) {
            request.setAuthority(this.serverName, this.serverPort);
        }
    }
}
