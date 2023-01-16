package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleConsumer;

/* renamed from: it.unimi.dsi.fastutil.doubles.AbstractDoubleIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/AbstractDoubleIterator.class */
public abstract class AbstractDoubleIterator implements DoubleIterator {
    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator
    public final void forEachRemaining(DoubleConsumer action) {
        forEachRemaining((DoubleConsumer) action);
    }
}
