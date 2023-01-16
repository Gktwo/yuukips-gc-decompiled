package p013io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;

/* access modifiers changed from: package-private */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.util.internal.LongAdderCounter */
/* loaded from: grasscutter.jar:io/netty/util/internal/LongAdderCounter.class */
public final class LongAdderCounter extends LongAdder implements LongCounter {
    @Override // p013io.netty.util.internal.LongCounter
    public long value() {
        return longValue();
    }
}
