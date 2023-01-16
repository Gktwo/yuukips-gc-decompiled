package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongConsumer;

/* renamed from: it.unimi.dsi.fastutil.longs.AbstractLongIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/AbstractLongIterator.class */
public abstract class AbstractLongIterator implements LongIterator {
    @Override // p014it.unimi.dsi.fastutil.longs.LongIterator
    public final void forEachRemaining(LongConsumer action) {
        forEachRemaining((LongConsumer) action);
    }
}
