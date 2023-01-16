package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleSpliterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleSpliterator.class */
public abstract class AbstractDoubleSpliterator implements DoubleSpliterator {
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
    public final boolean tryAdvance(DoubleConsumer action) {
        return tryAdvance((DoubleConsumer) action);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleSpliterator
    public final void forEachRemaining(DoubleConsumer action) {
        forEachRemaining((DoubleConsumer) action);
    }
}
