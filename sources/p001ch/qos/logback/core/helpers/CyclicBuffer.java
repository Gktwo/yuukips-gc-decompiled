package p001ch.qos.logback.core.helpers;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ch.qos.logback.core.helpers.CyclicBuffer */
/* loaded from: grasscutter.jar:ch/qos/logback/core/helpers/CyclicBuffer.class */
public class CyclicBuffer<E> {

    /* renamed from: ea */
    E[] f10ea;
    int first;
    int last;
    int numElems;
    int maxSize;

    public CyclicBuffer(int maxSize) throws IllegalArgumentException {
        if (maxSize < 1) {
            throw new IllegalArgumentException("The maxSize argument (" + maxSize + ") is not a positive integer.");
        }
        init(maxSize);
    }

    public CyclicBuffer(CyclicBuffer<E> other) {
        this.maxSize = other.maxSize;
        this.f10ea = (E[]) new Object[this.maxSize];
        System.arraycopy(other.f10ea, 0, this.f10ea, 0, this.maxSize);
        this.last = other.last;
        this.first = other.first;
        this.numElems = other.numElems;
    }

    private void init(int maxSize) {
        this.maxSize = maxSize;
        this.f10ea = (E[]) new Object[maxSize];
        this.first = 0;
        this.last = 0;
        this.numElems = 0;
    }

    public void clear() {
        init(this.maxSize);
    }

    public void add(E event) {
        this.f10ea[this.last] = event;
        int i = this.last + 1;
        this.last = i;
        if (i == this.maxSize) {
            this.last = 0;
        }
        if (this.numElems < this.maxSize) {
            this.numElems++;
            return;
        }
        int i2 = this.first + 1;
        this.first = i2;
        if (i2 == this.maxSize) {
            this.first = 0;
        }
    }

    public E get(int i) {
        if (i < 0 || i >= this.numElems) {
            return null;
        }
        return this.f10ea[(this.first + i) % this.maxSize];
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public E get() {
        E r = null;
        if (this.numElems > 0) {
            this.numElems--;
            r = this.f10ea[this.first];
            this.f10ea[this.first] = null;
            int i = this.first + 1;
            this.first = i;
            if (i == this.maxSize) {
                this.first = 0;
            }
        }
        return r;
    }

    public List<E> asList() {
        List<E> tList = new ArrayList<>();
        for (int i = 0; i < length(); i++) {
            tList.add(get(i));
        }
        return tList;
    }

    public int length() {
        return this.numElems;
    }

    public void resize(int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("Negative array size [" + newSize + "] not allowed.");
        } else if (newSize != this.numElems) {
            E[] temp = (E[]) new Object[newSize];
            int loopLen = newSize < this.numElems ? newSize : this.numElems;
            for (int i = 0; i < loopLen; i++) {
                temp[i] = this.f10ea[this.first];
                this.f10ea[this.first] = null;
                int i2 = this.first + 1;
                this.first = i2;
                if (i2 == this.numElems) {
                    this.first = 0;
                }
            }
            this.f10ea = temp;
            this.first = 0;
            this.numElems = loopLen;
            this.maxSize = newSize;
            if (loopLen == newSize) {
                this.last = 0;
            } else {
                this.last = loopLen;
            }
        }
    }
}
