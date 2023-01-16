package com.mongodb.connection;

import com.mongodb.ConnectionString;
import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import java.util.concurrent.TimeUnit;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/SocketSettings.class */
public final class SocketSettings {
    private final long connectTimeoutMS;
    private final long readTimeoutMS;
    private final int receiveBufferSize;
    private final int sendBufferSize;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SocketSettings socketSettings) {
        return builder().applySettings(socketSettings);
    }

    /* loaded from: grasscutter.jar:com/mongodb/connection/SocketSettings$Builder.class */
    public static final class Builder {
        private long connectTimeoutMS;
        private long readTimeoutMS;
        private int receiveBufferSize;
        private int sendBufferSize;

        private Builder() {
            this.connectTimeoutMS = AbstractComponentTracker.LINGERING_TIMEOUT;
        }

        public Builder applySettings(SocketSettings socketSettings) {
            Assertions.notNull("socketSettings", socketSettings);
            this.connectTimeoutMS = socketSettings.connectTimeoutMS;
            this.readTimeoutMS = socketSettings.readTimeoutMS;
            this.receiveBufferSize = socketSettings.receiveBufferSize;
            this.sendBufferSize = socketSettings.sendBufferSize;
            return this;
        }

        public Builder connectTimeout(int connectTimeout, TimeUnit timeUnit) {
            this.connectTimeoutMS = TimeUnit.MILLISECONDS.convert((long) connectTimeout, timeUnit);
            return this;
        }

        public Builder readTimeout(int readTimeout, TimeUnit timeUnit) {
            this.readTimeoutMS = TimeUnit.MILLISECONDS.convert((long) readTimeout, timeUnit);
            return this;
        }

        public Builder receiveBufferSize(int receiveBufferSize) {
            this.receiveBufferSize = receiveBufferSize;
            return this;
        }

        public Builder sendBufferSize(int sendBufferSize) {
            this.sendBufferSize = sendBufferSize;
            return this;
        }

        public Builder applyConnectionString(ConnectionString connectionString) {
            Integer connectTimeout = connectionString.getConnectTimeout();
            if (connectTimeout != null) {
                connectTimeout(connectTimeout.intValue(), TimeUnit.MILLISECONDS);
            }
            Integer socketTimeout = connectionString.getSocketTimeout();
            if (socketTimeout != null) {
                readTimeout(socketTimeout.intValue(), TimeUnit.MILLISECONDS);
            }
            return this;
        }

        public SocketSettings build() {
            return new SocketSettings(this);
        }
    }

    public int getConnectTimeout(TimeUnit timeUnit) {
        return (int) timeUnit.convert(this.connectTimeoutMS, TimeUnit.MILLISECONDS);
    }

    public int getReadTimeout(TimeUnit timeUnit) {
        return (int) timeUnit.convert(this.readTimeoutMS, TimeUnit.MILLISECONDS);
    }

    public int getReceiveBufferSize() {
        return this.receiveBufferSize;
    }

    public int getSendBufferSize() {
        return this.sendBufferSize;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SocketSettings that = (SocketSettings) o;
        if (this.connectTimeoutMS == that.connectTimeoutMS && this.readTimeoutMS == that.readTimeoutMS && this.receiveBufferSize == that.receiveBufferSize && this.sendBufferSize == that.sendBufferSize) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((int) (this.connectTimeoutMS ^ (this.connectTimeoutMS >>> 32)))) + ((int) (this.readTimeoutMS ^ (this.readTimeoutMS >>> 32))))) + this.receiveBufferSize)) + this.sendBufferSize;
    }

    public String toString() {
        return "SocketSettings{connectTimeoutMS=" + this.connectTimeoutMS + ", readTimeoutMS=" + this.readTimeoutMS + ", receiveBufferSize=" + this.receiveBufferSize + ", sendBufferSize=" + this.sendBufferSize + '}';
    }

    private SocketSettings(Builder builder) {
        this.connectTimeoutMS = builder.connectTimeoutMS;
        this.readTimeoutMS = builder.readTimeoutMS;
        this.receiveBufferSize = builder.receiveBufferSize;
        this.sendBufferSize = builder.sendBufferSize;
    }
}
