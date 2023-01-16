package org.eclipse.jetty.client;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ContentDecoder.class */
public interface ContentDecoder {
    ByteBuffer decode(ByteBuffer byteBuffer);

    default void release(ByteBuffer decoded) {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ContentDecoder$Factory.class */
    public static abstract class Factory {
        private final String encoding;

        public abstract ContentDecoder newContentDecoder();

        /* access modifiers changed from: protected */
        public Factory(String encoding) {
            this.encoding = encoding;
        }

        public String getEncoding() {
            return this.encoding;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Factory)) {
                return false;
            }
            return this.encoding.equals(((Factory) obj).encoding);
        }

        public int hashCode() {
            return this.encoding.hashCode();
        }
    }
}
