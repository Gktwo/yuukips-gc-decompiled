package p014it.unimi.dsi.fastutil.ints;

import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntIterator.class */
public abstract class AbstractIntIterator implements IntIterator {
    @Override // p014it.unimi.dsi.fastutil.ints.IntIterator
    public final void forEachRemaining(IntConsumer action) {
        forEachRemaining((IntConsumer) action);
    }
}
