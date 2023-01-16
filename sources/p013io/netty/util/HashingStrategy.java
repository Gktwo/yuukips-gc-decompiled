package p013io.netty.util;

/* renamed from: io.netty.util.HashingStrategy */
/* loaded from: grasscutter.jar:io/netty/util/HashingStrategy.class */
public interface HashingStrategy<T> {
    public static final HashingStrategy JAVA_HASHER = new HashingStrategy() { // from class: io.netty.util.HashingStrategy.1
        @Override // p013io.netty.util.HashingStrategy
        public int hashCode(Object obj) {
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        @Override // p013io.netty.util.HashingStrategy
        public boolean equals(Object a, Object b) {
            return a == b || (a != null && a.equals(b));
        }
    };

    int hashCode(T t);

    boolean equals(T t, T t2);
}
