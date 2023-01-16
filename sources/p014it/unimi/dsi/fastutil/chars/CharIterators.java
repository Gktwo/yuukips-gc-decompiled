package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import kotlin.jvm.internal.LongCompanionObject;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntIterators;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIterators */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators.class */
public final class CharIterators {
    public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator();

    private CharIterators() {
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$EmptyIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$EmptyIterator.class */
    public static class EmptyIterator implements CharListIterator, Serializable, Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyIterator() {
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            throw new NoSuchElementException();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            return 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
        }

        @Override // java.lang.Object
        public Object clone() {
            return CharIterators.EMPTY_ITERATOR;
        }

        private Object readResolve() {
            return CharIterators.EMPTY_ITERATOR;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$SingletonIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$SingletonIterator.class */
    public static class SingletonIterator implements CharListIterator {
        private final char element;
        private byte curr;

        public SingletonIterator(char element) {
            this.element = element;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr == 0;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr == 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.curr = 1;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            this.curr = 0;
            return this.element;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            Objects.requireNonNull(action);
            if (this.curr == 0) {
                action.accept(this.element);
                this.curr = 1;
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.curr;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.curr - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n == 0 || this.curr < 1) {
                return 0;
            } else {
                this.curr = 1;
                return 1;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n == 0 || this.curr > 0) {
                return 0;
            } else {
                this.curr = 0;
                return 1;
            }
        }
    }

    public static CharListIterator singleton(char element) {
        return new SingletonIterator(element);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$ArrayIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$ArrayIterator.class */
    private static class ArrayIterator implements CharListIterator {
        private final char[] array;
        private final int offset;
        private final int length;
        private int curr;

        public ArrayIterator(char[] array, int offset, int length) {
            this.array = array;
            this.offset = offset;
            this.length = length;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr < this.length;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            char[] cArr = this.array;
            int i = this.offset;
            int i2 = this.curr;
            this.curr = i2 + 1;
            return cArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            char[] cArr = this.array;
            int i = this.offset;
            int i2 = this.curr - 1;
            this.curr = i2;
            return cArr[i + i2];
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.length) {
                action.accept(this.array[this.offset + this.curr]);
                this.curr++;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n <= this.length - this.curr) {
                this.curr += n;
                return n;
            } else {
                int n2 = this.length - this.curr;
                this.curr = this.length;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (n <= this.curr) {
                this.curr -= n;
                return n;
            } else {
                int n2 = this.curr;
                this.curr = 0;
                return n2;
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.curr;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.curr - 1;
        }
    }

    public static CharListIterator wrap(char[] array, int offset, int length) {
        CharArrays.ensureOffsetLength(array, offset, length);
        return new ArrayIterator(array, offset, length);
    }

    public static CharListIterator wrap(char[] array) {
        return new ArrayIterator(array, 0, array.length);
    }

    public static int unwrap(CharIterator i, char[] array, int offset, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        } else if (offset < 0 || offset + max > array.length) {
            throw new IllegalArgumentException();
        } else {
            int j = max;
            while (true) {
                j--;
                if (j == 0 || !i.hasNext()) {
                    break;
                }
                offset++;
                array[offset] = i.nextChar();
            }
            return (max - j) - 1;
        }
    }

    public static int unwrap(CharIterator i, char[] array) {
        return unwrap(i, array, 0, array.length);
    }

    public static char[] unwrap(CharIterator i, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        char[] array = new char[16];
        int j = 0;
        while (true) {
            max--;
            if (max == 0 || !i.hasNext()) {
                break;
            }
            if (j == array.length) {
                array = CharArrays.grow(array, j + 1);
            }
            j++;
            array[j] = i.nextChar();
        }
        return CharArrays.trim(array, j);
    }

    public static char[] unwrap(CharIterator i) {
        return unwrap(i, Integer.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: char[][] */
    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [long] */
    public static long unwrap(CharIterator i, char[][] array, long offset, long max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        } else if (offset < 0 || offset + max > BigArrays.length(array)) {
            throw new IllegalArgumentException();
        } else {
            char c = max;
            while (true) {
                c--;
                if (c == 0 || !i.hasNext()) {
                    break;
                }
                offset++;
                BigArrays.set(array, (long) array, i.nextChar());
            }
            return (max - c) - 1;
        }
    }

    public static long unwrap(CharIterator i, char[][] array) {
        return unwrap(i, array, 0, BigArrays.length(array));
    }

    public static int unwrap(CharIterator i, CharCollection c, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            c.add(i.nextChar());
        }
        return (max - j) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r1v2, types: [long] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static char[][] unwrapBig(p014it.unimi.dsi.fastutil.chars.CharIterator r8, long r9) {
        /*
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0026
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "The maximum number of elements ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r9
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is negative"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0026:
            r0 = 16
            char[][] r0 = p014it.unimi.dsi.fastutil.chars.CharBigArrays.newBigArray(r0)
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x0030:
            r0 = r9
            r1 = r0; r0 = r0; 
            r2 = 1
            long r1 = r1 - r2
            r9 = r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x006a
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x006a
            r0 = r12
            r1 = r11
            long r1 = p014it.unimi.dsi.fastutil.BigArrays.length(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0056
            r0 = r11
            r1 = r12
            r2 = 1
            long r1 = r1 + r2
            char[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.grow(r0, r1)
            r11 = r0
        L_0x0056:
            r0 = r11
            r1 = r12
            r2 = r1; r0 = r0; 
            r3 = 1
            long r2 = r2 + r3
            r12 = r2
            r2 = r8
            char r2 = r2.nextChar()
            p014it.unimi.dsi.fastutil.BigArrays.set(r0, r1, r2)
            goto L_0x0030
        L_0x006a:
            r0 = r11
            r1 = r12
            char[][] r0 = p014it.unimi.dsi.fastutil.BigArrays.trim(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.chars.CharIterators.unwrapBig(it.unimi.dsi.fastutil.chars.CharIterator, long):char[][]");
    }

    public static char[][] unwrapBig(CharIterator i) {
        return unwrapBig(i, LongCompanionObject.MAX_VALUE);
    }

    public static long unwrap(CharIterator i, CharCollection c) {
        long n = 0;
        while (i.hasNext()) {
            c.add(i.nextChar());
            n++;
        }
        return n;
    }

    public static int pour(CharIterator i, CharCollection s, int max) {
        if (max < 0) {
            throw new IllegalArgumentException("The maximum number of elements (" + max + ") is negative");
        }
        int j = max;
        while (true) {
            j--;
            if (j == 0 || !i.hasNext()) {
                break;
            }
            s.add(i.nextChar());
        }
        return (max - j) - 1;
    }

    public static int pour(CharIterator i, CharCollection s) {
        return pour(i, s, Integer.MAX_VALUE);
    }

    public static CharList pour(CharIterator i, int max) {
        CharArrayList l = new CharArrayList();
        pour(i, l, max);
        l.trim();
        return l;
    }

    public static CharList pour(CharIterator i) {
        return pour(i, Integer.MAX_VALUE);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$IteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$IteratorWrapper.class */
    private static class IteratorWrapper implements CharIterator {

        /* renamed from: i */
        final Iterator<Character> f1508i;

        public IteratorWrapper(Iterator<Character> i) {
            this.f1508i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1508i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1508i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return this.f1508i.next().charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1508i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
            this.f1508i.forEachRemaining(action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$PrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$PrimitiveIteratorWrapper.class */
    private static class PrimitiveIteratorWrapper implements CharIterator {

        /* renamed from: i */
        final PrimitiveIterator.OfInt f1510i;

        public PrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            this.f1510i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1510i.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f1510i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return (char) this.f1510i.nextInt();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1510i.forEachRemaining((IntConsumer) action);
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$CheckedPrimitiveIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$CheckedPrimitiveIteratorWrapper.class */
    private static class CheckedPrimitiveIteratorWrapper extends PrimitiveIteratorWrapper {
        public CheckedPrimitiveIteratorWrapper(PrimitiveIterator.OfInt i) {
            super(i);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return SafeMath.safeIntToChar(this.f1510i.nextInt());
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterators.PrimitiveIteratorWrapper, p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1510i.forEachRemaining(value -> {
                action.accept(SafeMath.safeIntToChar(value));
            });
        }
    }

    public static CharIterator asCharIterator(Iterator i) {
        return i instanceof CharIterator ? (CharIterator) i : new IteratorWrapper(i);
    }

    public static CharIterator narrow(PrimitiveIterator.OfInt i) {
        return new CheckedPrimitiveIteratorWrapper(i);
    }

    public static CharIterator uncheckedNarrow(PrimitiveIterator.OfInt i) {
        return new PrimitiveIteratorWrapper(i);
    }

    public static IntIterator widen(CharIterator i) {
        return IntIterators.wrap(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$ListIteratorWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$ListIteratorWrapper.class */
    private static class ListIteratorWrapper implements CharListIterator {

        /* renamed from: i */
        final ListIterator<Character> f1509i;

        public ListIteratorWrapper(ListIterator<Character> i) {
            this.f1509i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1509i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1509i.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1509i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1509i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
        public void set(char k) {
            this.f1509i.set(Character.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
        public void add(char k) {
            this.f1509i.add(Character.valueOf(k));
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.Iterator, java.util.ListIterator
        public void remove() {
            this.f1509i.remove();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return this.f1509i.next().charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1509i.previous().charValue();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1509i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
            this.f1509i.forEachRemaining(action);
        }
    }

    public static CharListIterator asCharIterator(ListIterator i) {
        return i instanceof CharListIterator ? (CharListIterator) i : new ListIteratorWrapper(i);
    }

    public static boolean any(CharIterator iterator, CharPredicate predicate) {
        return indexOf(iterator, predicate) != -1;
    }

    public static boolean any(CharIterator iterator, IntPredicate predicate) {
        CharPredicate charPredicate;
        if (predicate instanceof CharPredicate) {
            charPredicate = (CharPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            charPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return any(iterator, charPredicate);
    }

    public static boolean all(CharIterator iterator, CharPredicate predicate) {
        Objects.requireNonNull(predicate);
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.nextChar())) {
                return false;
            }
        }
        return true;
    }

    public static boolean all(CharIterator iterator, IntPredicate predicate) {
        CharPredicate charPredicate;
        if (predicate instanceof CharPredicate) {
            charPredicate = (CharPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            charPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return all(iterator, charPredicate);
    }

    public static int indexOf(CharIterator iterator, CharPredicate predicate) {
        Objects.requireNonNull(predicate);
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.test(iterator.nextChar())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(CharIterator iterator, IntPredicate predicate) {
        CharPredicate charPredicate;
        if (predicate instanceof CharPredicate) {
            charPredicate = (CharPredicate) predicate;
        } else {
            Objects.requireNonNull(predicate);
            charPredicate = (v1) -> {
                return r1.test(v1);
            };
        }
        return indexOf(iterator, charPredicate);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$AbstractIndexBasedIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$AbstractIndexBasedIterator.class */
    public static abstract class AbstractIndexBasedIterator extends AbstractCharIterator {
        protected final int minPos;
        protected int pos;
        protected int lastReturned;

        protected abstract char get(int i);

        protected abstract void remove(int i);

        protected abstract int getMaxPos();

        protected AbstractIndexBasedIterator(int minPos, int initialPos) {
            this.minPos = minPos;
            this.pos = initialPos;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < getMaxPos();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.pos;
            this.pos = i + 1;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.Iterator, p014it.unimi.dsi.fastutil.chars.CharListIterator, java.util.ListIterator
        public void remove() {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            remove(this.lastReturned);
            if (this.lastReturned < this.pos) {
                this.pos--;
            }
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            while (this.pos < getMaxPos()) {
                int i = this.pos;
                this.pos = i + 1;
                this.lastReturned = i;
                action.accept(get(i));
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int max = getMaxPos();
            int remaining = max - this.pos;
            if (n < remaining) {
                this.pos += n;
            } else {
                n = remaining;
                this.pos = max;
            }
            this.lastReturned = this.pos - 1;
            return n;
        }
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$AbstractIndexBasedListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$AbstractIndexBasedListIterator.class */
    public static abstract class AbstractIndexBasedListIterator extends AbstractIndexBasedIterator implements CharListIterator {
        protected abstract void add(int i, char c);

        protected abstract void set(int i, char c);

        /* access modifiers changed from: protected */
        public AbstractIndexBasedListIterator(int minPos, int initialPos) {
            super(minPos, initialPos);
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.pos > this.minPos;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            int i = this.pos - 1;
            this.pos = i;
            this.lastReturned = i;
            return get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.pos;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.pos - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
        public void add(char k) {
            int i = this.pos;
            this.pos = i + 1;
            add(i, k);
            this.lastReturned = -1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharListIterator
        public void set(char k) {
            if (this.lastReturned == -1) {
                throw new IllegalStateException();
            }
            set(this.lastReturned, k);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            int remaining = this.pos - this.minPos;
            if (n < remaining) {
                this.pos -= n;
            } else {
                n = remaining;
                this.pos = this.minPos;
            }
            this.lastReturned = this.pos;
            return n;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$IntervalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$IntervalIterator.class */
    public static class IntervalIterator implements CharListIterator {
        private final char from;

        /* renamed from: to */
        private final char f1506to;
        char curr;

        public IntervalIterator(char from, char to) {
            this.curr = from;
            this.from = from;
            this.f1506to = to;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.curr < this.f1506to;
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.curr > this.from;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            char c = this.curr;
            this.curr = (char) (c + 1);
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            char c = (char) (this.curr - 1);
            this.curr = c;
            return c;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            Objects.requireNonNull(action);
            while (this.curr < this.f1506to) {
                action.accept(this.curr);
                this.curr = (char) (this.curr + 1);
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.curr - this.from;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.curr - this.from) - 1;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            } else if (this.curr + n <= this.f1506to) {
                this.curr = (char) (this.curr + n);
                return n;
            } else {
                int n2 = this.f1506to - this.curr;
                this.curr = this.f1506to;
                return n2;
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator
        public int back(int n) {
            if (this.curr - n >= this.from) {
                this.curr = (char) (this.curr - n);
                return n;
            }
            int n2 = this.curr - this.from;
            this.curr = this.from;
            return n2;
        }
    }

    public static CharListIterator fromTo(char from, char to) {
        return new IntervalIterator(from, to);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$IteratorConcatenator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$IteratorConcatenator.class */
    public static class IteratorConcatenator implements CharIterator {

        /* renamed from: a */
        final CharIterator[] f1507a;
        int offset;
        int length;
        int lastOffset = -1;

        public IteratorConcatenator(CharIterator[] a, int offset, int length) {
            this.f1507a = a;
            this.offset = offset;
            this.length = length;
            advance();
        }

        private void advance() {
            while (this.length != 0 && !this.f1507a[this.offset].hasNext()) {
                this.length--;
                this.offset++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.length > 0;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            CharIterator[] charIteratorArr = this.f1507a;
            int i = this.offset;
            this.lastOffset = i;
            char next = charIteratorArr[i].nextChar();
            advance();
            return next;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            while (this.length > 0) {
                CharIterator[] charIteratorArr = this.f1507a;
                int i = this.offset;
                this.lastOffset = i;
                charIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
            while (this.length > 0) {
                CharIterator[] charIteratorArr = this.f1507a;
                int i = this.offset;
                this.lastOffset = i;
                charIteratorArr[i].forEachRemaining(action);
                advance();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastOffset == -1) {
                throw new IllegalStateException();
            }
            this.f1507a[this.lastOffset].remove();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator, p014it.unimi.dsi.fastutil.objects.ObjectIterator
        public int skip(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Argument must be nonnegative: " + n);
            }
            this.lastOffset = -1;
            int skipped = 0;
            while (skipped < n && this.length != 0) {
                skipped += this.f1507a[this.offset].skip(n - skipped);
                if (this.f1507a[this.offset].hasNext()) {
                    break;
                }
                this.length--;
                this.offset++;
            }
            return skipped;
        }
    }

    public static CharIterator concat(CharIterator... a) {
        return concat(a, 0, a.length);
    }

    public static CharIterator concat(CharIterator[] a, int offset, int length) {
        return new IteratorConcatenator(a, offset, length);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$UnmodifiableIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$UnmodifiableIterator.class */
    public static class UnmodifiableIterator implements CharIterator {

        /* renamed from: i */
        protected final CharIterator f1512i;

        public UnmodifiableIterator(CharIterator i) {
            this.f1512i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1512i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return this.f1512i.nextChar();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1512i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
            this.f1512i.forEachRemaining(action);
        }
    }

    public static CharIterator unmodifiable(CharIterator i) {
        return new UnmodifiableIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$UnmodifiableBidirectionalIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$UnmodifiableBidirectionalIterator.class */
    public static class UnmodifiableBidirectionalIterator implements CharBidirectionalIterator {

        /* renamed from: i */
        protected final CharBidirectionalIterator f1511i;

        public UnmodifiableBidirectionalIterator(CharBidirectionalIterator i) {
            this.f1511i = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1511i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1511i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return this.f1511i.nextChar();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1511i.previousChar();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1511i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
            this.f1511i.forEachRemaining(action);
        }
    }

    public static CharBidirectionalIterator unmodifiable(CharBidirectionalIterator i) {
        return new UnmodifiableBidirectionalIterator(i);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.CharIterators$UnmodifiableListIterator */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIterators$UnmodifiableListIterator.class */
    public static class UnmodifiableListIterator implements CharListIterator {

        /* renamed from: i */
        protected final CharListIterator f1513i;

        public UnmodifiableListIterator(CharListIterator i) {
            this.f1513i = i;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return this.f1513i.hasNext();
        }

        @Override // p014it.unimi.dsi.fastutil.BidirectionalIterator
        public boolean hasPrevious() {
            return this.f1513i.hasPrevious();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            return this.f1513i.nextChar();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator
        public char previousChar() {
            return this.f1513i.previousChar();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1513i.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1513i.previousIndex();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public void forEachRemaining(CharConsumer action) {
            this.f1513i.forEachRemaining(action);
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
        @Deprecated
        public void forEachRemaining(Consumer<? super Character> action) {
            this.f1513i.forEachRemaining(action);
        }
    }

    public static CharListIterator unmodifiable(CharListIterator i) {
        return new UnmodifiableListIterator(i);
    }
}
