package p014it.unimi.dsi.fastutil.bytes;

import java.util.Iterator;
import java.util.Set;

/* renamed from: it.unimi.dsi.fastutil.bytes.AbstractByteSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/AbstractByteSet.class */
public abstract class AbstractByteSet extends AbstractByteCollection implements Cloneable, ByteSet {
    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteIterator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.bytes.ByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteIterable, p014it.unimi.dsi.fastutil.bytes.ByteSet, java.util.Set
    public abstract Iterator<Byte> iterator();

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Set)) {
            return false;
        }
        Set<?> s = (Set) o;
        if (s.size() != size()) {
            return false;
        }
        if (s instanceof ByteSet) {
            return containsAll((ByteSet) s);
        }
        return containsAll(s);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [it.unimi.dsi.fastutil.bytes.ByteIterator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.Collection, java.lang.Object, java.util.Set
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r3 = this;
            r0 = 0
            r4 = r0
            r0 = r3
            int r0 = r0.size()
            r5 = r0
            r0 = r3
            it.unimi.dsi.fastutil.bytes.ByteIterator r0 = r0.iterator()
            r6 = r0
        L_0x000c:
            r0 = r5
            int r5 = r5 + -1
            if (r0 == 0) goto L_0x0023
            r0 = r6
            byte r0 = r0.nextByte()
            r7 = r0
            r0 = r4
            r1 = r7
            int r0 = r0 + r1
            r4 = r0
            goto L_0x000c
        L_0x0023:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.bytes.AbstractByteSet.hashCode():int");
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteSet
    public boolean remove(byte k) {
        return rem(k);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteCollection, p014it.unimi.dsi.fastutil.bytes.ByteCollection
    @Deprecated
    public boolean rem(byte k) {
        return remove(k);
    }
}
