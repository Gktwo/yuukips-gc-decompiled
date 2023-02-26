package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: UShortArray.kt */
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010��\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001��¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001��¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001��¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001��¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0002ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0002ø\u0001��¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0002ø\u0001��¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8��X\u0004¢\u0006\b\n��\u0012\u0004\b\f\u0010\r\u0001\u0007\u0001\u00020\bø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, m373d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([SLjava/lang/Object;)Z", BeanUtil.PREFIX_GETTER_GET, "index", "get-Mh2AYeg", "([SI)S", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", Printer.TO_STRING, "", "toString-impl", "([S)Ljava/lang/String;", "Iterator", "kotlin-stdlib"})
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: grasscutter.jar:kotlin/UShortArray.class */
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    @NotNull
    private final short[] storage;

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7397toStringimpl(short[] arg0) {
        return "UShortArray(storage=" + Arrays.toString(arg0) + ')';
    }

    @Override // java.lang.Object
    public String toString() {
        return m7397toStringimpl(this.storage);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7398hashCodeimpl(short[] arg0) {
        return Arrays.hashCode(arg0);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return m7398hashCodeimpl(this.storage);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7399equalsimpl(short[] arg0, Object other) {
        return (other instanceof UShortArray) && Intrinsics.areEqual(arg0, ((UShortArray) other).m7403unboximpl());
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object other) {
        return m7399equalsimpl(this.storage, other);
    }

    /* renamed from: add-xj2QHRw  reason: not valid java name */
    public boolean m7400addxj2QHRw(short element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m7401constructorimpl(@NotNull short[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShortArray m7402boximpl(short[] v) {
        return new UShortArray(v);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short[] m7403unboximpl() {
        return this.storage;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7404equalsimpl0(short[] p1, short[] p2) {
        return Intrinsics.areEqual(p1, p2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object element) {
        if (!(element instanceof UShort)) {
            return false;
        }
        return m7394containsxj2QHRw(((UShort) element).m7385unboximpl());
    }

    @PublishedApi
    private /* synthetic */ UShortArray(short[] storage) {
        this.storage = storage;
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m7388constructorimpl(int size) {
        return m7401constructorimpl(new short[size]);
    }

    /* renamed from: get-Mh2AYeg  reason: not valid java name */
    public static final short m7389getMh2AYeg(short[] arg0, int index) {
        return UShort.m7383constructorimpl(arg0[index]);
    }

    /* renamed from: set-01HTLdE  reason: not valid java name */
    public static final void m7390set01HTLdE(short[] arg0, int index, short value) {
        arg0[index] = value;
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m7391getSizeimpl(short[] arg0) {
        return arg0.length;
    }

    /* renamed from: getSize */
    public int size() {
        return m7391getSizeimpl(this.storage);
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<UShort> m7392iteratorimpl(short[] arg0) {
        return new Iterator(arg0);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public java.util.Iterator<UShort> iterator() {
        return m7392iteratorimpl(this.storage);
    }

    /* compiled from: UShortArray.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\nH\u0016ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\r"}, m373d2 = {"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextUShort", "Lkotlin/UShort;", "nextUShort-Mh2AYeg", "()S", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/UShortArray$Iterator.class */
    public static final class Iterator extends UShortIterator {
        @NotNull
        private final short[] array;
        private int index;

        public Iterator(@NotNull short[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.UShortIterator
        /* renamed from: nextUShort-Mh2AYeg  reason: not valid java name */
        public short mo7405nextUShortMh2AYeg() {
            if (this.index < this.array.length) {
                short[] sArr = this.array;
                int i = this.index;
                this.index = i + 1;
                return UShort.m7383constructorimpl(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public boolean m7394containsxj2QHRw(short element) {
        return m7393containsxj2QHRw(this.storage, element);
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public static boolean m7393containsxj2QHRw(short[] arg0, short element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m7395containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m7395containsAllimpl(short[] arg0, @NotNull Collection<UShort> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<UShort> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!(element$iv instanceof UShort) || !ArraysKt.contains(arg0, ((UShort) element$iv).m7385unboximpl())) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m7396isEmptyimpl(short[] arg0) {
        return arg0.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m7396isEmptyimpl(this.storage);
    }
}
