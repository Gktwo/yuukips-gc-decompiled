package com.mongodb.internal.connection;

import com.mongodb.MongoSocketException;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoSocketReadException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.AsyncCompletionHandler;
import com.mongodb.connection.BufferProvider;
import com.mongodb.connection.SocketSettings;
import com.mongodb.connection.SslSettings;
import com.mongodb.connection.Stream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import org.bson.ByteBuf;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SocketStream.class */
public class SocketStream implements Stream {
    private final ServerAddress address;
    private final SocketSettings settings;
    private final SslSettings sslSettings;
    private final SocketFactory socketFactory;
    private final BufferProvider bufferProvider;
    private volatile Socket socket;
    private volatile OutputStream outputStream;
    private volatile InputStream inputStream;
    private volatile boolean isClosed;

    public SocketStream(ServerAddress address, SocketSettings settings, SslSettings sslSettings, SocketFactory socketFactory, BufferProvider bufferProvider) {
        this.address = (ServerAddress) Assertions.notNull("address", address);
        this.settings = (SocketSettings) Assertions.notNull("settings", settings);
        this.sslSettings = (SslSettings) Assertions.notNull("sslSettings", sslSettings);
        this.socketFactory = (SocketFactory) Assertions.notNull("socketFactory", socketFactory);
        this.bufferProvider = (BufferProvider) Assertions.notNull("bufferProvider", bufferProvider);
    }

    @Override // com.mongodb.connection.Stream
    public void open() {
        try {
            this.socket = initializeSocket();
            this.outputStream = this.socket.getOutputStream();
            this.inputStream = this.socket.getInputStream();
        } catch (IOException e) {
            close();
            throw new MongoSocketOpenException("Exception opening socket", getAddress(), e);
        }
    }

    protected Socket initializeSocket() throws IOException {
        Iterator<InetSocketAddress> inetSocketAddresses = this.address.getSocketAddresses().iterator();
        while (inetSocketAddresses.hasNext()) {
            Socket socket = this.socketFactory.createSocket();
            try {
                SocketStreamHelper.initialize(socket, inetSocketAddresses.next(), this.settings, this.sslSettings);
                return socket;
            } catch (SocketTimeoutException e) {
                if (!inetSocketAddresses.hasNext()) {
                    throw e;
                }
            }
        }
        throw new MongoSocketException("Exception opening socket", getAddress());
    }

    @Override // com.mongodb.connection.BufferProvider
    public ByteBuf getBuffer(int size) {
        return this.bufferProvider.getBuffer(size);
    }

    @Override // com.mongodb.connection.Stream
    public void write(List<ByteBuf> buffers) throws IOException {
        for (ByteBuf cur : buffers) {
            this.outputStream.write(cur.array(), 0, cur.limit());
        }
    }

    @Override // com.mongodb.connection.Stream
    public ByteBuf read(int numBytes) throws IOException {
        ByteBuf buffer = this.bufferProvider.getBuffer(numBytes);
        int totalBytesRead = 0;
        byte[] bytes = buffer.array();
        while (totalBytesRead < buffer.limit()) {
            int bytesRead = this.inputStream.read(bytes, totalBytesRead, buffer.limit() - totalBytesRead);
            if (bytesRead == -1) {
                buffer.release();
                throw new MongoSocketReadException("Prematurely reached end of stream", getAddress());
            }
            totalBytesRead += bytesRead;
        }
        return buffer;
    }

    @Override // com.mongodb.connection.Stream
    public boolean supportsAdditionalTimeout() {
        return true;
    }

    @Override // com.mongodb.connection.Stream
    public ByteBuf read(int numBytes, int additionalTimeout) throws IOException {
        int curTimeout = this.socket.getSoTimeout();
        if (curTimeout > 0 && additionalTimeout > 0) {
            this.socket.setSoTimeout(curTimeout + additionalTimeout);
        }
        try {
            ByteBuf read = read(numBytes);
            this.socket.setSoTimeout(curTimeout);
            return read;
        } catch (Throwable th) {
            this.socket.setSoTimeout(curTimeout);
            throw th;
        }
    }

    @Override // com.mongodb.connection.Stream
    public void openAsync(AsyncCompletionHandler<Void> handler) {
        throw new UnsupportedOperationException(getClass() + " does not support asynchronous operations.");
    }

    @Override // com.mongodb.connection.Stream
    public void writeAsync(List<ByteBuf> buffers, AsyncCompletionHandler<Void> handler) {
        throw new UnsupportedOperationException(getClass() + " does not support asynchronous operations.");
    }

    @Override // com.mongodb.connection.Stream
    public void readAsync(int numBytes, AsyncCompletionHandler<ByteBuf> handler) {
        throw new UnsupportedOperationException(getClass() + " does not support asynchronous operations.");
    }

    @Override // com.mongodb.connection.Stream
    public ServerAddress getAddress() {
        return this.address;
    }

    SocketSettings getSettings() {
        return this.settings;
    }

    @Override // com.mongodb.connection.Stream
    public void close() {
        try {
            this.isClosed = true;
            if (this.socket != null) {
                this.socket.close();
            }
        } catch (IOException e) {
        }
    }

    @Override // com.mongodb.connection.Stream
    public boolean isClosed() {
        return this.isClosed;
    }
}
