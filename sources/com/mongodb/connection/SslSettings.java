package com.mongodb.connection;

import com.mongodb.ConnectionString;
import com.mongodb.annotations.Immutable;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import javax.net.ssl.SSLContext;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/SslSettings.class */
public class SslSettings {
    private final boolean enabled;
    private final boolean invalidHostNameAllowed;
    private final SSLContext context;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SslSettings sslSettings) {
        return builder().applySettings(sslSettings);
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/connection/SslSettings$Builder.class */
    public static final class Builder {
        private boolean enabled;
        private boolean invalidHostNameAllowed;
        private SSLContext context;

        private Builder() {
        }

        public Builder applySettings(SslSettings sslSettings) {
            Assertions.notNull("sslSettings", sslSettings);
            this.enabled = sslSettings.enabled;
            this.invalidHostNameAllowed = sslSettings.invalidHostNameAllowed;
            this.context = sslSettings.context;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder invalidHostNameAllowed(boolean invalidHostNameAllowed) {
            this.invalidHostNameAllowed = invalidHostNameAllowed;
            return this;
        }

        public Builder context(SSLContext context) {
            this.context = context;
            return this;
        }

        public Builder applyConnectionString(ConnectionString connectionString) {
            Boolean sslEnabled = connectionString.getSslEnabled();
            if (sslEnabled != null) {
                this.enabled = sslEnabled.booleanValue();
            }
            Boolean sslInvalidHostnameAllowed = connectionString.getSslInvalidHostnameAllowed();
            if (sslInvalidHostnameAllowed != null) {
                this.invalidHostNameAllowed = sslInvalidHostnameAllowed.booleanValue();
            }
            return this;
        }

        public SslSettings build() {
            return new SslSettings(this);
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isInvalidHostNameAllowed() {
        return this.invalidHostNameAllowed;
    }

    public SSLContext getContext() {
        return this.context;
    }

    SslSettings(Builder builder) {
        this.enabled = builder.enabled;
        this.invalidHostNameAllowed = builder.invalidHostNameAllowed;
        this.context = builder.context;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SslSettings that = (SslSettings) o;
        if (this.enabled == that.enabled && this.invalidHostNameAllowed == that.invalidHostNameAllowed) {
            return this.context != null ? this.context.equals(that.context) : that.context == null;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * (this.enabled ? 1 : 0)) + (this.invalidHostNameAllowed ? 1 : 0))) + (this.context != null ? this.context.hashCode() : 0);
    }

    public String toString() {
        return "SslSettings{enabled=" + this.enabled + ", invalidHostNameAllowed=" + this.invalidHostNameAllowed + ", context=" + this.context + '}';
    }
}
