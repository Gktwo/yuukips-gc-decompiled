package org.eclipse.jetty.p023io;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* renamed from: org.eclipse.jetty.io.Connection */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/Connection.class */
public interface Connection extends Closeable {

    /* renamed from: org.eclipse.jetty.io.Connection$UpgradeFrom */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/Connection$UpgradeFrom.class */
    public interface UpgradeFrom {
        ByteBuffer onUpgradeFrom();
    }

    /* renamed from: org.eclipse.jetty.io.Connection$UpgradeTo */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/Connection$UpgradeTo.class */
    public interface UpgradeTo {
        void onUpgradeTo(ByteBuffer byteBuffer);
    }

    void addListener(Listener listener);

    void removeListener(Listener listener);

    void onOpen();

    void onClose();

    EndPoint getEndPoint();

    @Override // java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    void close();

    boolean onIdleExpired();

    long getMessagesIn();

    long getMessagesOut();

    long getBytesIn();

    long getBytesOut();

    long getCreatedTimeStamp();

    /* renamed from: org.eclipse.jetty.io.Connection$Listener */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/Connection$Listener.class */
    public interface Listener {
        void onOpened(Connection connection);

        void onClosed(Connection connection);

        /* renamed from: org.eclipse.jetty.io.Connection$Listener$Adapter */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/io/Connection$Listener$Adapter.class */
        public static class Adapter implements Listener {
            @Override // org.eclipse.jetty.p023io.Connection.Listener
            public void onOpened(Connection connection) {
            }

            @Override // org.eclipse.jetty.p023io.Connection.Listener
            public void onClosed(Connection connection) {
            }
        }
    }
}
