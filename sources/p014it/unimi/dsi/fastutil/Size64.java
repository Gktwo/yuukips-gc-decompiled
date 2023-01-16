package p014it.unimi.dsi.fastutil;

import java.util.Collection;
import java.util.Map;

/* renamed from: it.unimi.dsi.fastutil.Size64 */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/Size64.class */
public interface Size64 {
    long size64();

    @Override // p014it.unimi.dsi.fastutil.Size64
    @Deprecated
    default int size() {
        return (int) Math.min(2147483647L, size64());
    }

    static long sizeOf(Collection<?> c) {
        return c instanceof Size64 ? ((Size64) c).size64() : (long) c.size();
    }

    static long sizeOf(Map<?, ?> m) {
        return m instanceof Size64 ? ((Size64) m).size64() : (long) m.size();
    }
}
