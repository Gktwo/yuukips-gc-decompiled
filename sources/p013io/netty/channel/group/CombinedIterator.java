package p013io.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.group.CombinedIterator */
/* loaded from: grasscutter.jar:io/netty/channel/group/CombinedIterator.class */
final class CombinedIterator<E> implements Iterator<E> {

    /* renamed from: i1 */
    private final Iterator<E> f947i1;

    /* renamed from: i2 */
    private final Iterator<E> f948i2;
    private Iterator<E> currentIterator;

    /* access modifiers changed from: package-private */
    public CombinedIterator(Iterator<E> i1, Iterator<E> i2) {
        this.f947i1 = (Iterator) ObjectUtil.checkNotNull(i1, "i1");
        this.f948i2 = (Iterator) ObjectUtil.checkNotNull(i2, "i2");
        this.currentIterator = i1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.f947i1) {
                return false;
            }
            this.currentIterator = this.f948i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e) {
                if (this.currentIterator == this.f947i1) {
                    this.currentIterator = this.f948i2;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
