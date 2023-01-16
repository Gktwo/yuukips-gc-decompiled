package org.eclipse.jetty.server;

import java.nio.ByteBuffer;
import java.util.List;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectionFactory.class */
public interface ConnectionFactory {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectionFactory$Detecting.class */
    public interface Detecting extends ConnectionFactory {

        /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectionFactory$Detecting$Detection.class */
        public enum Detection {
            RECOGNIZED,
            NOT_RECOGNIZED,
            NEED_MORE_BYTES
        }

        Detection detect(ByteBuffer byteBuffer);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectionFactory$Upgrading.class */
    public interface Upgrading extends ConnectionFactory {
        Connection upgradeConnection(Connector connector, EndPoint endPoint, MetaData.Request request, HttpFields httpFields) throws BadMessageException;
    }

    String getProtocol();

    List<String> getProtocols();

    Connection newConnection(Connector connector, EndPoint endPoint);
}
