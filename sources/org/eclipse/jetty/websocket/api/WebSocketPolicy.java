package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketPolicy.class */
public class WebSocketPolicy {

    /* renamed from: KB */
    private static final int f3140KB = 1024;
    private int maxTextMessageSize = 65536;
    private int maxTextMessageBufferSize = 32768;
    private int maxBinaryMessageSize = 65536;
    private int maxBinaryMessageBufferSize = 32768;
    private long asyncWriteTimeout = 60000;
    private long idleTimeout = 300000;
    private int inputBufferSize = 4096;
    private final WebSocketBehavior behavior;

    public static WebSocketPolicy newClientPolicy() {
        return new WebSocketPolicy(WebSocketBehavior.CLIENT);
    }

    public static WebSocketPolicy newServerPolicy() {
        return new WebSocketPolicy(WebSocketBehavior.SERVER);
    }

    public WebSocketPolicy(WebSocketBehavior behavior) {
        this.behavior = behavior;
    }

    private void assertLessThan(String name, long size, String otherName, long otherSize) {
        if (size > otherSize) {
            throw new IllegalArgumentException(String.format("%s [%d] must be less than %s [%d]", name, Long.valueOf(size), otherName, Long.valueOf(otherSize)));
        }
    }

    private void assertGreaterThan(String name, long size, long minSize) {
        if (size < minSize) {
            throw new IllegalArgumentException(String.format("%s [%d] must be a greater than or equal to " + minSize, name, Long.valueOf(size)));
        }
    }

    public void assertValidBinaryMessageSize(int requestedSize) {
        if (this.maxBinaryMessageSize > 0 && requestedSize > this.maxBinaryMessageSize) {
            throw new MessageTooLargeException("Binary message size [" + requestedSize + "] exceeds maximum size [" + this.maxBinaryMessageSize + "]");
        }
    }

    public void assertValidTextMessageSize(int requestedSize) {
        if (this.maxTextMessageSize > 0 && requestedSize > this.maxTextMessageSize) {
            throw new MessageTooLargeException("Text message size [" + requestedSize + "] exceeds maximum size [" + this.maxTextMessageSize + "]");
        }
    }

    public WebSocketPolicy clonePolicy() {
        WebSocketPolicy clone = new WebSocketPolicy(this.behavior);
        clone.idleTimeout = getIdleTimeout();
        clone.maxTextMessageSize = getMaxTextMessageSize();
        clone.maxTextMessageBufferSize = getMaxTextMessageBufferSize();
        clone.maxBinaryMessageSize = getMaxBinaryMessageSize();
        clone.maxBinaryMessageBufferSize = getMaxBinaryMessageBufferSize();
        clone.inputBufferSize = getInputBufferSize();
        clone.asyncWriteTimeout = getAsyncWriteTimeout();
        return clone;
    }

    @Deprecated
    public WebSocketPolicy clonePolicy(WebSocketBehavior behavior) {
        return delegateAs(behavior);
    }

    public WebSocketPolicy delegateAs(WebSocketBehavior behavior) {
        if (behavior == this.behavior) {
            return this;
        }
        return new Delegated(this, behavior);
    }

    @Deprecated
    public long getAsyncWriteTimeout() {
        return this.asyncWriteTimeout;
    }

    public WebSocketBehavior getBehavior() {
        return this.behavior;
    }

    public long getIdleTimeout() {
        return this.idleTimeout;
    }

    public int getInputBufferSize() {
        return this.inputBufferSize;
    }

    public int getMaxBinaryMessageBufferSize() {
        return this.maxBinaryMessageBufferSize;
    }

    public int getMaxBinaryMessageSize() {
        return this.maxBinaryMessageSize;
    }

    public int getMaxTextMessageBufferSize() {
        return this.maxTextMessageBufferSize;
    }

    public int getMaxTextMessageSize() {
        return this.maxTextMessageSize;
    }

    public void setAsyncWriteTimeout(long ms) {
        assertLessThan("AsyncWriteTimeout", ms, "IdleTimeout", this.idleTimeout);
        this.asyncWriteTimeout = ms;
    }

    public void setIdleTimeout(long ms) {
        assertGreaterThan("IdleTimeout", ms, 0);
        this.idleTimeout = ms;
    }

    public void setInputBufferSize(int size) {
        assertGreaterThan("InputBufferSize", (long) size, 1);
        this.inputBufferSize = size;
    }

    public void setMaxBinaryMessageBufferSize(int size) {
        assertGreaterThan("MaxBinaryMessageBufferSize", (long) size, 1);
        this.maxBinaryMessageBufferSize = size;
    }

    public void setMaxBinaryMessageSize(int size) {
        assertGreaterThan("MaxBinaryMessageSize", (long) size, -1);
        this.maxBinaryMessageSize = size;
    }

    public void setMaxTextMessageBufferSize(int size) {
        assertGreaterThan("MaxTextMessageBufferSize", (long) size, 1);
        this.maxTextMessageBufferSize = size;
    }

    public void setMaxTextMessageSize(int size) {
        assertGreaterThan("MaxTextMessageSize", (long) size, -1);
        this.maxTextMessageSize = size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append("@").append(Integer.toHexString(hashCode()));
        builder.append("[behavior=").append(getBehavior());
        builder.append(",maxTextMessageSize=").append(getMaxTextMessageSize());
        builder.append(",maxTextMessageBufferSize=").append(getMaxTextMessageBufferSize());
        builder.append(",maxBinaryMessageSize=").append(getMaxBinaryMessageSize());
        builder.append(",maxBinaryMessageBufferSize=").append(getMaxTextMessageBufferSize());
        builder.append(",asyncWriteTimeout=").append(getAsyncWriteTimeout());
        builder.append(",idleTimeout=").append(getIdleTimeout());
        builder.append(",inputBufferSize=").append(getInputBufferSize());
        builder.append("]");
        return builder.toString();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketPolicy$Delegated.class */
    public class Delegated extends WebSocketPolicy {
        private final WebSocketPolicy delegated;

        public Delegated(WebSocketPolicy policy, WebSocketBehavior behavior) {
            super(behavior);
            this.delegated = policy;
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void assertValidBinaryMessageSize(int requestedSize) {
            this.delegated.assertValidBinaryMessageSize(requestedSize);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void assertValidTextMessageSize(int requestedSize) {
            this.delegated.assertValidTextMessageSize(requestedSize);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public WebSocketPolicy clonePolicy() {
            return this.delegated.clonePolicy();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public WebSocketPolicy clonePolicy(WebSocketBehavior behavior) {
            return this.delegated.clonePolicy(behavior);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public WebSocketPolicy delegateAs(WebSocketBehavior behavior) {
            return this.delegated.delegateAs(behavior);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public long getAsyncWriteTimeout() {
            return this.delegated.getAsyncWriteTimeout();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public long getIdleTimeout() {
            return this.delegated.getIdleTimeout();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public int getInputBufferSize() {
            return this.delegated.getInputBufferSize();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public int getMaxBinaryMessageBufferSize() {
            return this.delegated.getMaxBinaryMessageBufferSize();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public int getMaxBinaryMessageSize() {
            return this.delegated.getMaxBinaryMessageSize();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public int getMaxTextMessageBufferSize() {
            return this.delegated.getMaxTextMessageBufferSize();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public int getMaxTextMessageSize() {
            return this.delegated.getMaxTextMessageSize();
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setAsyncWriteTimeout(long ms) {
            this.delegated.setAsyncWriteTimeout(ms);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setIdleTimeout(long ms) {
            this.delegated.setIdleTimeout(ms);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setInputBufferSize(int size) {
            this.delegated.setInputBufferSize(size);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setMaxBinaryMessageBufferSize(int size) {
            this.delegated.setMaxBinaryMessageBufferSize(size);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setMaxBinaryMessageSize(int size) {
            this.delegated.setMaxBinaryMessageSize(size);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setMaxTextMessageBufferSize(int size) {
            this.delegated.setMaxTextMessageBufferSize(size);
        }

        @Override // org.eclipse.jetty.websocket.api.WebSocketPolicy
        public void setMaxTextMessageSize(int size) {
            this.delegated.setMaxTextMessageSize(size);
        }
    }
}
