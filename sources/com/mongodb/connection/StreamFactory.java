package com.mongodb.connection;

import com.mongodb.ServerAddress;

/* loaded from: grasscutter.jar:com/mongodb/connection/StreamFactory.class */
public interface StreamFactory {
    Stream create(ServerAddress serverAddress);
}
