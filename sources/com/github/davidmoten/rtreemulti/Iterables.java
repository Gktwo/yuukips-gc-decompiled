package com.github.davidmoten.rtreemulti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Iterables.class */
public final class Iterables {
    private Iterables() {
    }

    public static <T> Iterable<T> filter(Iterable<? extends T> iterable, Predicate<? super T> condition) {
        return new FilterIterable(iterable, condition);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Iterables$FilterIterable.class */
    public static final class FilterIterable<T> implements Iterable<T> {
        private final Iterable<? extends T> iterable;
        private final Predicate<? super T> condition;

        FilterIterable(Iterable<? extends T> iterable, Predicate<? super T> condition) {
            this.iterable = iterable;
            this.condition = condition;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new FilterIterator(this.iterable.iterator(), this.condition);
        }
    }

    /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Iterables$FilterIterator.class */
    static final class FilterIterator<T> implements Iterator<T> {

        /* renamed from: it */
        private Iterator<? extends T> f241it;
        private final Predicate<? super T> condition;
        private T next;

        FilterIterator(Iterator<? extends T> it, Predicate<? super T> condition) {
            this.f241it = it;
            this.condition = condition;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            load();
            return this.next != null;
        }

        @Override // java.util.Iterator
        public T next() {
            load();
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            T v = this.next;
            this.next = null;
            return v;
        }

        /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void load() {
            /*
                r3 = this;
                r0 = r3
                T r0 = r0.next
                if (r0 != 0) goto L_0x003f
                r0 = r3
                java.util.Iterator<? extends T> r0 = r0.f241it
                if (r0 == 0) goto L_0x003f
            L_0x000e:
                r0 = r3
                java.util.Iterator<? extends T> r0 = r0.f241it
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x003a
                r0 = r3
                java.util.Iterator<? extends T> r0 = r0.f241it
                java.lang.Object r0 = r0.next()
                r4 = r0
                r0 = r3
                java.util.function.Predicate<? super T> r0 = r0.condition
                r1 = r4
                boolean r0 = r0.test(r1)
                if (r0 == 0) goto L_0x0037
                r0 = r3
                r1 = r4
                r0.next = r1
                return
            L_0x0037:
                goto L_0x000e
            L_0x003a:
                r0 = r3
                r1 = 0
                r0.f241it = r1
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.davidmoten.rtreemulti.Iterables.FilterIterator.load():void");
        }
    }

    public static long size(Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        long count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }
        return count;
    }

    public static <T> List<T> toList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T item : iterable) {
            list.add(item);
        }
        return list;
    }

    public static boolean isEmpty(Iterable<?> entries) {
        return !entries.iterator().hasNext();
    }
}
