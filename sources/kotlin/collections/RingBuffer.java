package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: SlidingWindow.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��>\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010��\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n��\n\u0002\u0010(\n\u0002\b\b\b\u0002\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028��¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028��0��2\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00028��2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028��0\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0006J\u0015\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014¢\u0006\u0002\u0010#J'\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\t\"\u0004\b\u0001\u0010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0014¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u0006*\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\bR\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u000e¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��¨\u0006'"}, m373d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "capacity", "", "(I)V", "buffer", "", "", "filledSize", "([Ljava/lang/Object;I)V", "[Ljava/lang/Object;", "<set-?>", "size", "getSize", "()I", "startIndex", BeanUtil.PREFIX_ADDER, "", "element", "(Ljava/lang/Object;)V", "expanded", "maxCapacity", BeanUtil.PREFIX_GETTER_GET, "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "removeFirst", "n", "toArray", "()[Ljava/lang/Object;", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "forward", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/collections/RingBuffer.class */
public final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    @NotNull
    private final Object[] buffer;
    private final int capacity;
    private int startIndex;
    private int size;

    public RingBuffer(@NotNull Object[] buffer, int filledSize) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (!(filledSize >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + filledSize).toString());
        }
        if (!(filledSize <= this.buffer.length)) {
            throw new IllegalArgumentException(("ring buffer filled size: " + filledSize + " cannot be larger than the buffer size: " + this.buffer.length).toString());
        }
        this.capacity = this.buffer.length;
        this.size = filledSize;
    }

    public RingBuffer(int capacity) {
        this(new Object[capacity], 0);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer$iterator$1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
                this.count = r4.size();
                this.index = RingBuffer.access$getStartIndex$p(r4);
            }

            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                if (this.count == 0) {
                    done();
                    return;
                }
                setNext(RingBuffer.access$getBuffer$p(this.this$0)[this.index]);
                this.index = (this.index + 1) % RingBuffer.access$getCapacity$p(this.this$0);
                this.count--;
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: T[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v23, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        Object[] result;
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (tArr.length < size()) {
            result = (T[]) Arrays.copyOf(tArr, size());
            Intrinsics.checkNotNullExpressionValue(result, "copyOf(this, newSize)");
        } else {
            result = tArr;
        }
        int size = size();
        int widx = 0;
        int idx = this.startIndex;
        while (widx < size && idx < this.capacity) {
            result[widx] = this.buffer[idx];
            widx++;
            idx++;
        }
        int idx2 = 0;
        while (widx < size) {
            result[widx] = this.buffer[idx2];
            widx++;
            idx2++;
        }
        if (result.length > size()) {
            result[size()] = null;
        }
        return (T[]) result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.collections.RingBuffer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.collections.RingBuffer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final RingBuffer<T> expanded(int maxCapacity) {
        Object[] newBuffer;
        int newCapacity = RangesKt.coerceAtMost(this.capacity + (this.capacity >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            newBuffer = Arrays.copyOf(this.buffer, newCapacity);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, newSize)");
        } else {
            newBuffer = toArray(new Object[newCapacity]);
        }
        return new RingBuffer<>(newBuffer, size());
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final void add(T t) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = t;
        this.size = size() + 1;
    }

    public final void removeFirst(int n) {
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + n).toString());
        }
        if (!(n <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n + ", size = " + size()).toString());
        } else if (n > 0) {
            int start = this.startIndex;
            int end = (start + n) % this.capacity;
            if (start > end) {
                ArraysKt.fill(this.buffer, (Object) null, start, this.capacity);
                ArraysKt.fill(this.buffer, (Object) null, 0, end);
            } else {
                ArraysKt.fill(this.buffer, (Object) null, start, end);
            }
            this.startIndex = end;
            this.size = size() - n;
        }
    }

    private final int forward(int $this$forward, int n) {
        return ($this$forward + n) % this.capacity;
    }
}
