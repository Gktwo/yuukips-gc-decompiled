package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/node/NodeSerialization.class */
class NodeSerialization implements Serializable, Externalizable {
    protected static final int LONGEST_EAGER_ALLOC = 100000;
    private static final long serialVersionUID = 1;
    public byte[] json;

    public NodeSerialization() {
    }

    public NodeSerialization(byte[] b) {
        this.json = b;
    }

    protected Object readResolve() {
        try {
            return InternalNodeMapper.bytesToNode(this.json);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to JDK deserialize `JsonNode` value: " + e.getMessage(), e);
        }
    }

    public static NodeSerialization from(Object o) {
        try {
            return new NodeSerialization(InternalNodeMapper.valueToBytes(o));
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to JDK serialize `" + o.getClass().getSimpleName() + "` value: " + e.getMessage(), e);
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.json.length);
        out.write(this.json);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput in) throws IOException {
        this.json = _read(in, in.readInt());
    }

    private byte[] _read(ObjectInput in, int expLen) throws IOException {
        if (expLen <= LONGEST_EAGER_ALLOC) {
            byte[] result = new byte[expLen];
            in.readFully(result, 0, expLen);
            return result;
        }
        ByteArrayBuilder bb = new ByteArrayBuilder((int) LONGEST_EAGER_ALLOC);
        Throwable th = null;
        try {
            byte[] buffer = bb.resetAndGetFirstSegment();
            int outOffset = 0;
            while (true) {
                int toRead = Math.min(buffer.length - outOffset, expLen);
                in.readFully(buffer, 0, toRead);
                expLen -= toRead;
                outOffset += toRead;
                if (expLen == 0) {
                    break;
                } else if (outOffset == buffer.length) {
                    buffer = bb.finishCurrentSegment();
                    outOffset = 0;
                }
            }
            byte[] completeAndCoalesce = bb.completeAndCoalesce(outOffset);
            if (bb != null) {
                if (0 != 0) {
                    try {
                        bb.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    bb.close();
                }
            }
            return completeAndCoalesce;
        } catch (Throwable th3) {
            if (bb != null) {
                if (0 != 0) {
                    try {
                        bb.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    bb.close();
                }
            }
            throw th3;
        }
    }
}
