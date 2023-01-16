package p014it.unimi.dsi.fastutil.ints;

import java.util.function.IntConsumer;

/* renamed from: it.unimi.dsi.fastutil.ints.AbstractIntSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/AbstractIntSpliterator.class */
public abstract class AbstractIntSpliterator implements IntSpliterator {
    @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator
    public final boolean tryAdvance(IntConsumer action) {
        return tryAdvance((IntConsumer) action);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntSpliterator
    public final void forEachRemaining(IntConsumer action) {
        forEachRemaining((IntConsumer) action);
    }
}
