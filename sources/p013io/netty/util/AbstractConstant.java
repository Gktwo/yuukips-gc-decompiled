package p013io.netty.util;

import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.util.AbstractConstant;

/* renamed from: io.netty.util.AbstractConstant */
/* loaded from: grasscutter.jar:io/netty/util/AbstractConstant.class */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();

    /* renamed from: id */
    private final int f1034id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.netty.util.AbstractConstant<T extends io.netty.util.AbstractConstant<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((AbstractConstant<T>) ((AbstractConstant) obj));
    }

    /* access modifiers changed from: protected */
    public AbstractConstant(int id, String name) {
        this.f1034id = id;
        this.name = name;
    }

    @Override // p013io.netty.util.Constant
    public final String name() {
        return this.name;
    }

    @Override // p013io.netty.util.Constant
    /* renamed from: id */
    public final int mo1173id() {
        return this.f1034id;
    }

    @Override // java.lang.Object
    public final String toString() {
        return name();
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return hashCode();
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        return equals(obj);
    }

    public final int compareTo(T o) {
        if (this == o) {
            return 0;
        }
        int returnCode = hashCode() - o.hashCode();
        if (returnCode != 0) {
            return returnCode;
        }
        if (this.uniquifier < o.uniquifier) {
            return -1;
        }
        if (this.uniquifier > o.uniquifier) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
