package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/* renamed from: it.unimi.dsi.fastutil.chars.CharArrayPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharArrayPriorityQueue.class */
public class CharArrayPriorityQueue implements CharPriorityQueue, Serializable {
    private static final long serialVersionUID = 1;
    protected transient char[] array;
    protected int size;

    /* renamed from: c */
    protected CharComparator f1447c;
    protected transient int firstIndex;
    protected transient boolean firstIndexValid;

    public CharArrayPriorityQueue(int capacity, CharComparator c) {
        this.array = CharArrays.EMPTY_ARRAY;
        if (capacity > 0) {
            this.array = new char[capacity];
        }
        this.f1447c = c;
    }

    public CharArrayPriorityQueue(int capacity) {
        this(capacity, (CharComparator) null);
    }

    public CharArrayPriorityQueue(CharComparator c) {
        this(0, c);
    }

    public CharArrayPriorityQueue() {
        this(0, (CharComparator) null);
    }

    public CharArrayPriorityQueue(char[] a, int size, CharComparator c) {
        this(c);
        this.array = a;
        this.size = size;
    }

    public CharArrayPriorityQueue(char[] a, CharComparator c) {
        this(a, a.length, c);
    }

    public CharArrayPriorityQueue(char[] a, int size) {
        this(a, size, null);
    }

    public CharArrayPriorityQueue(char[] a) {
        this(a, a.length);
    }

    private int findFirst() {
        if (this.firstIndexValid) {
            return this.firstIndex;
        }
        this.firstIndexValid = true;
        int i = this.size - 1;
        int firstIndex = i;
        char first = this.array[firstIndex];
        if (this.f1447c != null) {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.f1447c.compare(this.array[i], first) < 0) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        } else {
            while (true) {
                i--;
                if (i == 0) {
                    break;
                } else if (this.array[i] < first) {
                    firstIndex = i;
                    first = this.array[i];
                }
            }
        }
        this.firstIndex = firstIndex;
        return firstIndex;
    }

    private void ensureNonEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
    public void enqueue(char x) {
        if (this.size == this.array.length) {
            this.array = CharArrays.grow(this.array, this.size + 1);
        }
        if (!this.firstIndexValid) {
            this.firstIndexValid = false;
        } else if (this.f1447c == null) {
            if (x < this.array[this.firstIndex]) {
                this.firstIndex = this.size;
            }
        } else if (this.f1447c.compare(x, this.array[this.firstIndex]) < 0) {
            this.firstIndex = this.size;
        }
        char[] cArr = this.array;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = x;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
    public char dequeueChar() {
        ensureNonEmpty();
        int first = findFirst();
        char result = this.array[first];
        char[] cArr = this.array;
        int i = this.size - 1;
        this.size = i;
        System.arraycopy(this.array, first + 1, cArr, first, i - first);
        this.firstIndexValid = false;
        return result;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue
    public char firstChar() {
        ensureNonEmpty();
        return this.array[findFirst()];
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void changed() {
        ensureNonEmpty();
        this.firstIndexValid = false;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public int size() {
        return this.size;
    }

    @Override // p014it.unimi.dsi.fastutil.PriorityQueue
    public void clear() {
        this.size = 0;
        this.firstIndexValid = false;
    }

    public void trim() {
        this.array = CharArrays.trim(this.array, this.size);
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.chars.CharPriorityQueue, p014it.unimi.dsi.fastutil.PriorityQueue
    public Comparator<? super Character> comparator() {
        return this.f1447c;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.array.length);
        for (int i = 0; i < this.size; i++) {
            s.writeChar(this.array[i]);
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.array = new char[s.readInt()];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = s.readChar();
        }
    }
}
