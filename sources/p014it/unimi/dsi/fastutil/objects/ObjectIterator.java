package p014it.unimi.dsi.fastutil.objects;

import java.util.Iterator;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectIterator.class */
public interface ObjectIterator<K> extends Iterator<K> {
    default int skip(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument must be nonnegative: " + n);
        }
        int i = n;
        while (true) {
            i--;
            if (i == 0 || !hasNext()) {
                break;
            }
            next();
        }
        return (n - i) - 1;
    }
}
