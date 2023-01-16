package org.eclipse.jetty.websocket.api.extensions;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/extensions/Frame.class */
public interface Frame {
    byte[] getMask();

    byte getOpCode();

    ByteBuffer getPayload();

    int getPayloadLength();

    Type getType();

    boolean hasPayload();

    boolean isFin();

    @Deprecated
    boolean isLast();

    boolean isMasked();

    boolean isRsv1();

    boolean isRsv2();

    boolean isRsv3();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/extensions/Frame$Type.class */
    public enum Type {
        CONTINUATION((byte) 0),
        TEXT((byte) 1),
        BINARY((byte) 2),
        CLOSE((byte) 8),
        PING((byte) 9),
        PONG((byte) 10);
        
        private byte opcode;

        public static Type from(byte op) {
            Type[] values = values();
            for (Type type : values) {
                if (type.opcode == op) {
                    return type;
                }
            }
            throw new IllegalArgumentException("OpCode " + ((int) op) + " is not a valid Frame.Type");
        }

        Type(byte code) {
            this.opcode = code;
        }

        public byte getOpCode() {
            return this.opcode;
        }

        public boolean isControl() {
            return this.opcode >= CLOSE.getOpCode();
        }

        public boolean isData() {
            return this.opcode == TEXT.getOpCode() || this.opcode == BINARY.getOpCode();
        }

        public boolean isContinuation() {
            return this.opcode == CONTINUATION.getOpCode();
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return name();
        }
    }
}
