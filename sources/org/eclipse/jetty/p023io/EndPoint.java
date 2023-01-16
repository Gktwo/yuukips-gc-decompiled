package org.eclipse.jetty.p023io;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ReadPendingException;
import java.nio.channels.WritePendingException;
import org.eclipse.jetty.util.Callback;

/* renamed from: org.eclipse.jetty.io.EndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/EndPoint.class */
public interface EndPoint extends Closeable {
    InetSocketAddress getLocalAddress();

    InetSocketAddress getRemoteAddress();

    boolean isOpen();

    long getCreatedTimeStamp();

    void shutdownOutput();

    boolean isOutputShutdown();

    boolean isInputShutdown();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int fill(ByteBuffer byteBuffer) throws IOException;

    boolean flush(ByteBuffer... byteBufferArr) throws IOException;

    Object getTransport();

    long getIdleTimeout();

    void setIdleTimeout(long j);

    void fillInterested(Callback callback) throws ReadPendingException;

    boolean tryFillInterested(Callback callback);

    boolean isFillInterested();

    void write(Callback callback, ByteBuffer... byteBufferArr) throws WritePendingException;

    Connection getConnection();

    void setConnection(Connection connection);

    void onOpen();

    void onClose();

    boolean isOptimizedForDirectBuffers();

    void upgrade(Connection connection);
}
