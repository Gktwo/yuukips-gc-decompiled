package kotlin.collections;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jline.builtins.Tmux;

/* compiled from: UIterators.kt */
@Deprecated(message = "This class is not going to be stabilized and is to be removed soon.", level = DeprecationLevel.ERROR)
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, m373d2 = {"Lkotlin/collections/UIntIterator;", "", "Lkotlin/UInt;", "()V", Tmux.CMD_NEXT, "next-pVg5ArA", "()I", "nextUInt", "nextUInt-pVg5ArA", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/UIntIterator.class */
public abstract class UIntIterator implements Iterator<UInt>, KMappedMarker {
    /* renamed from: nextUInt-pVg5ArA */
    public abstract int mo7220nextUIntpVg5ArA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m7199boximpl(m7531nextpVg5ArA());
    }

    /* renamed from: next-pVg5ArA  reason: not valid java name */
    public final int m7531nextpVg5ArA() {
        return mo7220nextUIntpVg5ArA();
    }
}
