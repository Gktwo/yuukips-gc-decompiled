package com.mongodb.internal.connection.tlschannel;

import java.util.Optional;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLContext;

@FunctionalInterface
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/SniSslContextFactory.class */
public interface SniSslContextFactory {
    Optional<SSLContext> getSslContext(Optional<SNIServerName> optional);
}
