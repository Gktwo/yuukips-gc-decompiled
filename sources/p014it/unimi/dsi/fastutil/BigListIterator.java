package p014it.unimi.dsi.fastutil;

/* renamed from: it.unimi.dsi.fastutil.BigListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/BigListIterator.class */
public interface BigListIterator<K> extends BidirectionalIterator<K> {
    long nextIndex();

    long previousIndex();

    default void set(K e) {
        throw new UnsupportedOperationException();
    }

    default void add(K e) {
        throw new UnsupportedOperationException();
    }
}
