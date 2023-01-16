package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: ULongArray.kt */
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010��\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0014\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001��¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001��¢\u0006\u0004\b\u0005\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002ø\u0001��¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001��¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H\u0002ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0002ø\u0001��¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0002H\u0002ø\u0001��¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8��X\u0004¢\u0006\b\n��\u0012\u0004\b\f\u0010\r\u0001\u0007\u0001\u00020\bø\u0001��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00063"}, m373d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", BeanUtil.PREFIX_GETTER_GET, "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", Printer.TO_STRING, "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"})
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: grasscutter.jar:kotlin/ULongArray.class */
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    @NotNull
    private final long[] storage;

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7294toStringimpl(long[] arg0) {
        return "ULongArray(storage=" + Arrays.toString(arg0) + ')';
    }

    @Override // java.lang.Object
    public String toString() {
        return m7294toStringimpl(this.storage);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7295hashCodeimpl(long[] arg0) {
        return Arrays.hashCode(arg0);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return m7295hashCodeimpl(this.storage);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7296equalsimpl(long[] arg0, Object other) {
        return (other instanceof ULongArray) && Intrinsics.areEqual(arg0, ((ULongArray) other).m7300unboximpl());
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object other) {
        return m7296equalsimpl(this.storage, other);
    }

    /* renamed from: add-VKZWuLQ  reason: not valid java name */
    public boolean m7297addVKZWuLQ(long element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
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
    public static long[] m7298constructorimpl(@NotNull long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULongArray m7299boximpl(long[] v) {
        return new ULongArray(v);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long[] m7300unboximpl() {
        return this.storage;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7301equalsimpl0(long[] p1, long[] p2) {
        return Intrinsics.areEqual(p1, p2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
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
        if (!(element instanceof ULong)) {
            return false;
        }
        return m7291containsVKZWuLQ(((ULong) element).m7282unboximpl());
    }

    @PublishedApi
    private /* synthetic */ ULongArray(long[] storage) {
        this.storage = storage;
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m7285constructorimpl(int size) {
        return m7298constructorimpl(new long[size]);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public static final long m7286getsVKNKU(long[] arg0, int index) {
        return ULong.m7280constructorimpl(arg0[index]);
    }

    /* renamed from: set-k8EXiF4  reason: not valid java name */
    public static final void m7287setk8EXiF4(long[] arg0, int index, long value) {
        arg0[index] = value;
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m7288getSizeimpl(long[] arg0) {
        return arg0.length;
    }

    /* renamed from: getSize */
    public int size() {
        return m7288getSizeimpl(this.storage);
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<ULong> m7289iteratorimpl(long[] arg0) {
        return new Iterator(arg0);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public java.util.Iterator<ULong> iterator() {
        return m7289iteratorimpl(this.storage);
    }

    /* compiled from: ULongArray.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0015\u0010\t\u001a\u00020\nH\u0016ø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\r"}, m373d2 = {"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/ULongArray$Iterator.class */
    public static final class Iterator extends ULongIterator {
        @NotNull
        private final long[] array;
        private int index;

        public Iterator(@NotNull long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // kotlin.collections.ULongIterator
        /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
        public long mo7302nextULongsVKNKU() {
            if (this.index < this.array.length) {
                long[] jArr = this.array;
                int i = this.index;
                this.index = i + 1;
                return ULong.m7280constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m7291containsVKZWuLQ(long element) {
        return m7290containsVKZWuLQ(this.storage, element);
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public static boolean m7290containsVKZWuLQ(long[] arg0, long element) {
        return ArraysKt.contains(arg0, element);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return m7292containsAllimpl(this.storage, collection);
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m7292containsAllimpl(long[] arg0, @NotNull Collection<ULong> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<ULong> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!(element$iv instanceof ULong) || !ArraysKt.contains(arg0, ((ULong) element$iv).m7282unboximpl())) {
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
    public static boolean m7293isEmptyimpl(long[] arg0) {
        return arg0.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m7293isEmptyimpl(this.storage);
    }
}
