package org.eclipse.jetty.util;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ArrayTrie.class */
public class ArrayTrie<V> extends AbstractTrie<V> {
    private static final int ROW_SIZE = 32;
    private static final int MAX_CAPACITY = 65534;
    private static final int[] __lookup = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, 27, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, 29, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1};
    private final char[] _rowIndex;
    private final String[] _key;
    private final V[] _value;
    private char[][] _bigIndex;
    private char _rows;

    public ArrayTrie() {
        this(128);
    }

    public ArrayTrie(int capacity) {
        super(true);
        if (capacity > 65534) {
            throw new IllegalArgumentException("Capacity " + capacity + " > 65534");
        }
        this._value = (V[]) new Object[capacity + 1];
        this._rowIndex = new char[(capacity + 1) * 32];
        this._key = new String[capacity + 1];
    }

    @Override // org.eclipse.jetty.util.Trie
    public void clear() {
        this._rows = 0;
        Arrays.fill(this._value, (Object) null);
        Arrays.fill(this._rowIndex, (char) 0);
        Arrays.fill(this._key, (Object) null);
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean put(String s, V v) {
        char c = 0;
        int limit = s.length();
        if (limit > 65534) {
            return false;
        }
        for (int k = 0; k < limit; k++) {
            char c2 = s.charAt(k);
            int index = __lookup[c2 & 127];
            if (index >= 0) {
                int idx = (c * ' ') + index;
                c = this._rowIndex[idx];
                if (c == 0) {
                    this._rows = (char) MathUtils.cappedAdd(this._rows, 1, this._value.length);
                    if (this._rows == this._value.length) {
                        return false;
                    }
                    char[] cArr = this._rowIndex;
                    char c3 = this._rows;
                    cArr[idx] = c3;
                    c = c3;
                } else {
                    continue;
                }
            } else if (c2 > 127) {
                throw new IllegalArgumentException("non ascii character");
            } else {
                if (this._bigIndex == null) {
                    this._bigIndex = new char[this._value.length];
                }
                if (c >= this._bigIndex.length) {
                    return false;
                }
                char[] big = this._bigIndex[c];
                if (big == null) {
                    char[] cArr2 = new char[128];
                    this._bigIndex[c] = cArr2;
                    big = cArr2;
                }
                c = big[c2];
                if (c == 0) {
                    this._rows = (char) MathUtils.cappedAdd(this._rows, 1, this._value.length);
                    if (this._rows == this._value.length) {
                        return false;
                    }
                    char c4 = this._rows;
                    big[c2] = c4;
                    c = c4;
                } else {
                    continue;
                }
            }
        }
        if (c >= this._key.length) {
            this._rows = (char) this._key.length;
            return false;
        }
        this._key[c] = v == null ? null : s;
        this._value[c] = v;
        return true;
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(String s, int offset, int len) {
        char c = 0;
        for (int i = 0; i < len; i++) {
            char c2 = s.charAt(offset + i);
            if (c2 > 127) {
                return null;
            }
            int index = __lookup[c2 & 127];
            if (index >= 0) {
                c = this._rowIndex[(c * ' ') + index];
                if (c == 0) {
                    return null;
                }
            } else {
                char[] big = this._bigIndex == null ? null : this._bigIndex[c];
                if (big == null) {
                    return null;
                }
                c = big[c2 & 127];
                if (c == 0) {
                    return null;
                }
            }
        }
        return this._value[c];
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(ByteBuffer b, int offset, int len) {
        char c = 0;
        for (int i = 0; i < len; i++) {
            byte c2 = b.get(offset + i);
            int index = __lookup[c2 & Byte.MAX_VALUE];
            if (index >= 0) {
                c = this._rowIndex[(c * ' ') + index];
                if (c == 0) {
                    return null;
                }
            } else {
                char[] big = this._bigIndex == null ? null : this._bigIndex[c];
                if (big == null) {
                    return null;
                }
                c = big[c2];
                if (c == 0) {
                    return null;
                }
            }
        }
        return this._value[c];
    }

    @Override // org.eclipse.jetty.util.AbstractTrie, org.eclipse.jetty.util.Trie
    public V getBest(byte[] b, int offset, int len) {
        return getBest(0, b, offset, len);
    }

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(ByteBuffer b, int offset, int len) {
        if (b.hasArray()) {
            return getBest(0, b.array(), b.arrayOffset() + b.position() + offset, len);
        }
        return getBest(0, b, offset, len);
    }

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(String s, int offset, int len) {
        return getBest(0, s, offset, len);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d A[LOOP:0: B:3:0x0006->B:25:0x009d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V getBest(int r8, java.lang.String r9, int r10, int r11) {
        /*
            r7 = this;
            r0 = r10
            r12 = r0
            r0 = 0
            r13 = r0
        L_0x0006:
            r0 = r13
            r1 = r11
            if (r0 >= r1) goto L_0x00a6
            r0 = r9
            r1 = r12
            int r12 = r12 + 1
            char r0 = r0.charAt(r1)
            r14 = r0
            int[] r0 = org.eclipse.jetty.util.ArrayTrie.__lookup
            r1 = r14
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            if (r0 < 0) goto L_0x0045
            r0 = r8
            r1 = 32
            int r0 = r0 * r1
            r1 = r15
            int r0 = r0 + r1
            r17 = r0
            r0 = r7
            char[] r0 = r0._rowIndex
            r1 = r17
            char r0 = r0[r1]
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L_0x0042
            goto L_0x00a6
        L_0x0042:
            goto L_0x006f
        L_0x0045:
            r0 = r7
            char[][] r0 = r0._bigIndex
            if (r0 != 0) goto L_0x0050
            r0 = 0
            goto L_0x0056
        L_0x0050:
            r0 = r7
            char[][] r0 = r0._bigIndex
            r1 = r8
            r0 = r0[r1]
        L_0x0056:
            r17 = r0
            r0 = r17
            if (r0 != 0) goto L_0x0060
            goto L_0x00a6
        L_0x0060:
            r0 = r17
            r1 = r14
            char r0 = r0[r1]
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L_0x006f
            goto L_0x00a6
        L_0x006f:
            r0 = r7
            java.lang.String[] r0 = r0._key
            r1 = r8
            r0 = r0[r1]
            if (r0 == 0) goto L_0x009d
            r0 = r7
            r1 = r16
            r2 = r9
            r3 = r10
            r4 = r13
            int r3 = r3 + r4
            r4 = 1
            int r3 = r3 + r4
            r4 = r11
            r5 = r13
            int r4 = r4 - r5
            r5 = 1
            int r4 = r4 - r5
            java.lang.Object r0 = r0.getBest(r1, r2, r3, r4)
            r17 = r0
            r0 = r17
            if (r0 == 0) goto L_0x0096
            r0 = r17
            return r0
        L_0x0096:
            r0 = r7
            V[] r0 = r0._value
            r1 = r8
            r0 = r0[r1]
            return r0
        L_0x009d:
            r0 = r16
            r8 = r0
            int r13 = r13 + 1
            goto L_0x0006
        L_0x00a6:
            r0 = r7
            V[] r0 = r0._value
            r1 = r8
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ArrayTrie.getBest(int, java.lang.String, int, int):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090 A[LOOP:0: B:3:0x0003->B:23:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V getBest(int r8, byte[] r9, int r10, int r11) {
        /*
            r7 = this;
            r0 = 0
            r12 = r0
        L_0x0003:
            r0 = r12
            r1 = r11
            if (r0 >= r1) goto L_0x0099
            r0 = r9
            r1 = r10
            r2 = r12
            int r1 = r1 + r2
            r0 = r0[r1]
            r13 = r0
            int[] r0 = org.eclipse.jetty.util.ArrayTrie.__lookup
            r1 = r13
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            r0 = r0[r1]
            r14 = r0
            r0 = r14
            if (r0 < 0) goto L_0x003f
            r0 = r8
            r1 = 32
            int r0 = r0 * r1
            r1 = r14
            int r0 = r0 + r1
            r16 = r0
            r0 = r7
            char[] r0 = r0._rowIndex
            r1 = r16
            char r0 = r0[r1]
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x003c
            goto L_0x0099
        L_0x003c:
            goto L_0x0069
        L_0x003f:
            r0 = r7
            char[][] r0 = r0._bigIndex
            if (r0 != 0) goto L_0x004a
            r0 = 0
            goto L_0x0050
        L_0x004a:
            r0 = r7
            char[][] r0 = r0._bigIndex
            r1 = r8
            r0 = r0[r1]
        L_0x0050:
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L_0x005a
            goto L_0x0099
        L_0x005a:
            r0 = r16
            r1 = r13
            char r0 = r0[r1]
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x0069
            goto L_0x0099
        L_0x0069:
            r0 = r7
            java.lang.String[] r0 = r0._key
            r1 = r8
            r0 = r0[r1]
            if (r0 == 0) goto L_0x0090
            r0 = r7
            r1 = r15
            r2 = r9
            r3 = r10
            r4 = r12
            int r3 = r3 + r4
            r4 = 1
            int r3 = r3 + r4
            r4 = r11
            r5 = r12
            int r4 = r4 - r5
            r5 = 1
            int r4 = r4 - r5
            java.lang.Object r0 = r0.getBest(r1, r2, r3, r4)
            r16 = r0
            r0 = r16
            if (r0 == 0) goto L_0x0099
            r0 = r16
            return r0
        L_0x0090:
            r0 = r15
            r8 = r0
            int r12 = r12 + 1
            goto L_0x0003
        L_0x0099:
            r0 = r7
            V[] r0 = r0._value
            r1 = r8
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ArrayTrie.getBest(int, byte[], int, int):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9 A[LOOP:0: B:3:0x000b->B:27:0x00a9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V getBest(int r8, java.nio.ByteBuffer r9, int r10, int r11) {
        /*
            r7 = this;
            r0 = r9
            int r0 = r0.position()
            r1 = r10
            int r0 = r0 + r1
            r12 = r0
            r0 = 0
            r13 = r0
        L_0x000b:
            r0 = r13
            r1 = r11
            if (r0 >= r1) goto L_0x00b2
            r0 = r12
            r1 = r9
            int r1 = r1.limit()
            if (r0 < r1) goto L_0x001d
            r0 = 0
            return r0
        L_0x001d:
            r0 = r9
            r1 = r12
            int r12 = r12 + 1
            byte r0 = r0.get(r1)
            r14 = r0
            int[] r0 = org.eclipse.jetty.util.ArrayTrie.__lookup
            r1 = r14
            r2 = 127(0x7f, float:1.78E-43)
            r1 = r1 & r2
            r0 = r0[r1]
            r15 = r0
            r0 = r15
            if (r0 < 0) goto L_0x0055
            r0 = r8
            r1 = 32
            int r0 = r0 * r1
            r1 = r15
            int r0 = r0 + r1
            r17 = r0
            r0 = r7
            char[] r0 = r0._rowIndex
            r1 = r17
            char r0 = r0[r1]
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L_0x0052
            goto L_0x00b2
        L_0x0052:
            goto L_0x0082
        L_0x0055:
            r0 = r7
            char[][] r0 = r0._bigIndex
            if (r0 != 0) goto L_0x0060
            r0 = 0
            goto L_0x0066
        L_0x0060:
            r0 = r7
            char[][] r0 = r0._bigIndex
            r1 = r8
            r0 = r0[r1]
        L_0x0066:
            r17 = r0
            r0 = r17
            if (r0 != 0) goto L_0x0070
            goto L_0x00b2
        L_0x0070:
            r0 = r17
            r1 = r14
            char r0 = r0[r1]
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L_0x007f
            goto L_0x00b2
        L_0x007f:
            r0 = r16
            r8 = r0
        L_0x0082:
            r0 = r7
            java.lang.String[] r0 = r0._key
            r1 = r8
            r0 = r0[r1]
            if (r0 == 0) goto L_0x00a9
            r0 = r7
            r1 = r16
            r2 = r9
            r3 = r10
            r4 = r13
            int r3 = r3 + r4
            r4 = 1
            int r3 = r3 + r4
            r4 = r11
            r5 = r13
            int r4 = r4 - r5
            r5 = 1
            int r4 = r4 - r5
            java.lang.Object r0 = r0.getBest(r1, r2, r3, r4)
            r17 = r0
            r0 = r17
            if (r0 == 0) goto L_0x00b2
            r0 = r17
            return r0
        L_0x00a9:
            r0 = r16
            r8 = r0
            int r13 = r13 + 1
            goto L_0x000b
        L_0x00b2:
            r0 = r7
            V[] r0 = r0._value
            r1 = r8
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ArrayTrie.getBest(int, java.nio.ByteBuffer, int, int):java.lang.Object");
    }

    public String toString() {
        int rows = this._rows;
        if (rows == 0) {
            return "{}";
        }
        StringBuilder buf = new StringBuilder();
        char c = '{';
        for (int i = 0; i <= rows; i++) {
            String key = this._key[i];
            if (key != null) {
                buf.append(c).append(key).append('=').append(this._value[i]);
                c = ',';
            }
        }
        buf.append('}');
        return buf.toString();
    }

    @Override // org.eclipse.jetty.util.Trie
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        String[] strArr = this._key;
        for (String k : strArr) {
            if (k != null) {
                keys.add(k);
            }
        }
        return keys;
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean isFull() {
        return this._rows >= this._key.length;
    }
}
