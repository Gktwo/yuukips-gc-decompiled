package p014it.unimi.dsi.fastutil.objects;

import java.util.Spliterator;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectSpliterator.class */
public interface ObjectSpliterator<K> extends Spliterator<K> {
    @Override // java.util.Spliterator
    ObjectSpliterator<K> trySplit();

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    default long skip(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        char c = n;
        do {
            c--;
            if (c == 0) {
                break;
            }
        } while (tryAdvance(unused -> {
        }));
        return (n - c) - 1;
    }
}
