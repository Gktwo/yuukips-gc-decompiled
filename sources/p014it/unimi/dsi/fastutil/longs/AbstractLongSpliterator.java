package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongConsumer;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongSpliterator.class */
public abstract class AbstractLongSpliterator implements LongSpliterator {
    @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
    public final boolean tryAdvance(LongConsumer action) {
        return tryAdvance((LongConsumer) action);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongSpliterator
    public final void forEachRemaining(LongConsumer action) {
        forEachRemaining((LongConsumer) action);
    }
}
