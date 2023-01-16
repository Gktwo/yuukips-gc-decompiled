package com.mongodb.internal.connection;

import com.mongodb.UnixServerAddress;
import com.mongodb.connection.BufferProvider;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.SslSettings;
import java.io.IOException;
import java.net.Socket;
import javax.net.SocketFactory;
import jnr.unixsocket.UnixSocketChannel;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/UnixSocketChannelStream.class */
public class UnixSocketChannelStream extends SocketStream {
    private final UnixServerAddress address;

    public UnixSocketChannelStream(UnixServerAddress address, SocketSettings settings, SslSettings sslSettings, BufferProvider bufferProvider) {
        super(address, settings, sslSettings, SocketFactory.getDefault(), bufferProvider);
        this.address = address;
    }

    @Override // com.mongodb.internal.connection.SocketStream
    protected Socket initializeSocket() throws IOException {
        return UnixSocketChannel.open(this.address.getUnixSocketAddress()).socket();
    }
}
