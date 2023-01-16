package p013io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.nio.SelectedSelectionKeySet */
/* loaded from: grasscutter.jar:io/netty/channel/nio/SelectedSelectionKeySet.class */
public final class SelectedSelectionKeySet extends AbstractSet<SelectionKey> {
    SelectionKey[] keys = new SelectionKey[1024];
    int size;

    public boolean add(SelectionKey o) {
        if (o == null) {
            return false;
        }
        SelectionKey[] selectionKeyArr = this.keys;
        int i = this.size;
        this.size = i + 1;
        selectionKeyArr[i] = o;
        if (this.size != this.keys.length) {
            return true;
        }
        increaseCapacity();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<SelectionKey> iterator() {
        return new Iterator<SelectionKey>() { // from class: io.netty.channel.nio.SelectedSelectionKeySet.1
            private int idx;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.idx < SelectedSelectionKeySet.this.size;
            }

            @Override // java.util.Iterator
            public SelectionKey next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                SelectionKey[] selectionKeyArr = SelectedSelectionKeySet.this.keys;
                int i = this.idx;
                this.idx = i + 1;
                return selectionKeyArr[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        reset(0);
    }

    /* access modifiers changed from: package-private */
    public void reset(int start) {
        Arrays.fill(this.keys, start, this.size, (Object) null);
        this.size = 0;
    }

    private void increaseCapacity() {
        SelectionKey[] newKeys = new SelectionKey[this.keys.length << 1];
        System.arraycopy(this.keys, 0, newKeys, 0, this.size);
        this.keys = newKeys;
    }
}
