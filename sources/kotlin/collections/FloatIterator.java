package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jline.builtins.Tmux;

/* compiled from: Iterators.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, m373d2 = {"Lkotlin/collections/FloatIterator;", "", "", "()V", Tmux.CMD_NEXT, "()Ljava/lang/Float;", "nextFloat", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/FloatIterator.class */
public abstract class FloatIterator implements Iterator<Float>, KMappedMarker {
    public abstract float nextFloat();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    public final Float next() {
        return Float.valueOf(nextFloat());
    }
}
