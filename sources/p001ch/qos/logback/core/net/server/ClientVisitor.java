package p001ch.qos.logback.core.net.server;

import p001ch.qos.logback.core.net.server.Client;

/* renamed from: ch.qos.logback.core.net.server.ClientVisitor */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/ClientVisitor.class */
public interface ClientVisitor<T extends Client> {
    void visit(T t);
}
