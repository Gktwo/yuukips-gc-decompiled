package com.mongodb.connection;

/* loaded from: grasscutter.jar:com/mongodb/connection/StreamFactoryFactory.class */
public interface StreamFactoryFactory {
    StreamFactory create(SocketSettings socketSettings, SslSettings sslSettings);
}
