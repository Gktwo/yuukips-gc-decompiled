package p013io.netty.util.internal;

import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.Cleaner */
/* loaded from: grasscutter.jar:io/netty/util/internal/Cleaner.class */
public interface Cleaner {
    void freeDirectBuffer(ByteBuffer byteBuffer);
}
