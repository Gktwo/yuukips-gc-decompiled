package org.eclipse.jetty.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/TreeTrie.class */
public class TreeTrie<V> extends AbstractTrie<V> {
    private static final int[] LOOKUP = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, 27, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, 29, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1};
    private static final int INDEX = 32;
    private final TreeTrie<V>[] _nextIndex;
    private final List<TreeTrie<V>> _nextOther;

    /* renamed from: _c */
    private final char f3163_c;
    private String _key;
    private V _value;

    public TreeTrie() {
        super(true);
        this._nextOther = new ArrayList();
        this._nextIndex = new TreeTrie[32];
        this.f3163_c = 0;
    }

    private TreeTrie(char c) {
        super(true);
        this._nextOther = new ArrayList();
        this._nextIndex = new TreeTrie[32];
        this.f3163_c = c;
    }

    @Override // org.eclipse.jetty.util.Trie
    public void clear() {
        Arrays.fill(this._nextIndex, (Object) null);
        this._nextOther.clear();
        this._key = null;
        this._value = null;
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean put(String s, V v) {
        TreeTrie<V> t = this;
        int limit = s.length();
        for (int k = 0; k < limit; k++) {
            char c = s.charAt(k);
            int index = (c < 0 || c >= 127) ? -1 : LOOKUP[c];
            if (index >= 0) {
                if (t._nextIndex[index] == null) {
                    t._nextIndex[index] = new TreeTrie<>(c);
                }
                t = t._nextIndex[index];
            } else {
                TreeTrie<V> n = null;
                int i = t._nextOther.size();
                while (true) {
                    i--;
                    if (i <= 0) {
                        break;
                    }
                    n = t._nextOther.get(i);
                    if (n.f3163_c == c) {
                        break;
                    }
                    n = null;
                }
                if (n == null) {
                    n = new TreeTrie<>(c);
                    t._nextOther.add(n);
                }
                t = n;
            }
        }
        t._key = v == null ? null : s;
        t._value = v;
        return true;
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(String s, int offset, int len) {
        TreeTrie<V> t = this;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(offset + i);
            int index = (c < 0 || c >= 127) ? -1 : LOOKUP[c];
            if (index < 0) {
                TreeTrie<V> n = null;
                int j = t._nextOther.size();
                while (true) {
                    j--;
                    if (j <= 0) {
                        break;
                    }
                    n = t._nextOther.get(j);
                    if (n.f3163_c == c) {
                        break;
                    }
                    n = null;
                }
                if (n == null) {
                    return null;
                }
                t = n;
            } else if (t._nextIndex[index] == null) {
                return null;
            } else {
                t = t._nextIndex[index];
            }
        }
        return t._value;
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(ByteBuffer b, int offset, int len) {
        TreeTrie<V> t = this;
        for (int i = 0; i < len; i++) {
            byte c = b.get(offset + i);
            int index = (c < 0 || c >= Byte.MAX_VALUE) ? -1 : LOOKUP[c];
            if (index < 0) {
                TreeTrie<V> n = null;
                int j = t._nextOther.size();
                while (true) {
                    j--;
                    if (j <= 0) {
                        break;
                    }
                    n = t._nextOther.get(j);
                    if (n.f3163_c == c) {
                        break;
                    }
                    n = null;
                }
                if (n == null) {
                    return null;
                }
                t = n;
            } else if (t._nextIndex[index] == null) {
                return null;
            } else {
                t = t._nextIndex[index];
            }
        }
        return t._value;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b7 A[LOOP:0: B:3:0x0006->B:31:0x00b7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009b A[SYNTHETIC] */
    @Override // org.eclipse.jetty.util.AbstractTrie, org.eclipse.jetty.util.Trie
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V getBest(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r6
            r10 = r0
            r0 = 0
            r11 = r0
        L_0x0006:
            r0 = r11
            r1 = r9
            if (r0 >= r1) goto L_0x00bd
            r0 = r7
            r1 = r8
            r2 = r11
            int r1 = r1 + r2
            r0 = r0[r1]
            r12 = r0
            r0 = r12
            if (r0 < 0) goto L_0x0029
            r0 = r12
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L_0x0029
            int[] r0 = org.eclipse.jetty.util.TreeTrie.LOOKUP
            r1 = r12
            r0 = r0[r1]
            goto L_0x002a
        L_0x0029:
            r0 = -1
        L_0x002a:
            r13 = r0
            r0 = r13
            if (r0 < 0) goto L_0x004c
            r0 = r10
            org.eclipse.jetty.util.TreeTrie<V>[] r0 = r0._nextIndex
            r1 = r13
            r0 = r0[r1]
            if (r0 != 0) goto L_0x003f
            goto L_0x00bd
        L_0x003f:
            r0 = r10
            org.eclipse.jetty.util.TreeTrie<V>[] r0 = r0._nextIndex
            r1 = r13
            r0 = r0[r1]
            r10 = r0
            goto L_0x0093
        L_0x004c:
            r0 = 0
            r14 = r0
            r0 = r10
            java.util.List<org.eclipse.jetty.util.TreeTrie<V>> r0 = r0._nextOther
            int r0 = r0.size()
            r15 = r0
        L_0x005b:
            r0 = r15
            int r15 = r15 + -1
            if (r0 <= 0) goto L_0x0087
            r0 = r10
            java.util.List<org.eclipse.jetty.util.TreeTrie<V>> r0 = r0._nextOther
            r1 = r15
            java.lang.Object r0 = r0.get(r1)
            org.eclipse.jetty.util.TreeTrie r0 = (org.eclipse.jetty.util.TreeTrie) r0
            r14 = r0
            r0 = r14
            char r0 = r0.f3163_c
            r1 = r12
            if (r0 != r1) goto L_0x0081
            goto L_0x0087
        L_0x0081:
            r0 = 0
            r14 = r0
            goto L_0x005b
        L_0x0087:
            r0 = r14
            if (r0 != 0) goto L_0x008f
            goto L_0x00bd
        L_0x008f:
            r0 = r14
            r10 = r0
        L_0x0093:
            r0 = r10
            java.lang.String r0 = r0._key
            if (r0 == 0) goto L_0x00b7
            r0 = r10
            r1 = r7
            r2 = r8
            r3 = r11
            int r2 = r2 + r3
            r3 = 1
            int r2 = r2 + r3
            r3 = r9
            r4 = r11
            int r3 = r3 - r4
            r4 = 1
            int r3 = r3 - r4
            java.lang.Object r0 = r0.getBest(r1, r2, r3)
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L_0x00bd
            r0 = r14
            return r0
        L_0x00b7:
            int r11 = r11 + 1
            goto L_0x0006
        L_0x00bd:
            r0 = r10
            V r0 = r0._value
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.TreeTrie.getBest(byte[], int, int):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be A[LOOP:0: B:3:0x0006->B:31:0x00be, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a2 A[SYNTHETIC] */
    @Override // org.eclipse.jetty.util.Trie
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V getBest(java.lang.String r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r6
            r10 = r0
            r0 = 0
            r11 = r0
        L_0x0006:
            r0 = r11
            r1 = r9
            if (r0 >= r1) goto L_0x00c4
            r0 = 255(0xff, float:3.57E-43)
            r1 = r7
            r2 = r8
            r3 = r11
            int r2 = r2 + r3
            char r1 = r1.charAt(r2)
            r0 = r0 & r1
            byte r0 = (byte) r0
            r12 = r0
            r0 = r12
            if (r0 < 0) goto L_0x0030
            r0 = r12
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L_0x0030
            int[] r0 = org.eclipse.jetty.util.TreeTrie.LOOKUP
            r1 = r12
            r0 = r0[r1]
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            r13 = r0
            r0 = r13
            if (r0 < 0) goto L_0x0053
            r0 = r10
            org.eclipse.jetty.util.TreeTrie<V>[] r0 = r0._nextIndex
            r1 = r13
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0046
            goto L_0x00c4
        L_0x0046:
            r0 = r10
            org.eclipse.jetty.util.TreeTrie<V>[] r0 = r0._nextIndex
            r1 = r13
            r0 = r0[r1]
            r10 = r0
            goto L_0x009a
        L_0x0053:
            r0 = 0
            r14 = r0
            r0 = r10
            java.util.List<org.eclipse.jetty.util.TreeTrie<V>> r0 = r0._nextOther
            int r0 = r0.size()
            r15 = r0
        L_0x0062:
            r0 = r15
            int r15 = r15 + -1
            if (r0 <= 0) goto L_0x008e
            r0 = r10
            java.util.List<org.eclipse.jetty.util.TreeTrie<V>> r0 = r0._nextOther
            r1 = r15
            java.lang.Object r0 = r0.get(r1)
            org.eclipse.jetty.util.TreeTrie r0 = (org.eclipse.jetty.util.TreeTrie) r0
            r14 = r0
            r0 = r14
            char r0 = r0.f3163_c
            r1 = r12
            if (r0 != r1) goto L_0x0088
            goto L_0x008e
        L_0x0088:
            r0 = 0
            r14 = r0
            goto L_0x0062
        L_0x008e:
            r0 = r14
            if (r0 != 0) goto L_0x0096
            goto L_0x00c4
        L_0x0096:
            r0 = r14
            r10 = r0
        L_0x009a:
            r0 = r10
            java.lang.String r0 = r0._key
            if (r0 == 0) goto L_0x00be
            r0 = r10
            r1 = r7
            r2 = r8
            r3 = r11
            int r2 = r2 + r3
            r3 = 1
            int r2 = r2 + r3
            r3 = r9
            r4 = r11
            int r3 = r3 - r4
            r4 = 1
            int r3 = r3 - r4
            java.lang.Object r0 = r0.getBest(r1, r2, r3)
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L_0x00c4
            r0 = r14
            return r0
        L_0x00be:
            int r11 = r11 + 1
            goto L_0x0006
        L_0x00c4:
            r0 = r10
            V r0 = r0._value
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.TreeTrie.getBest(java.lang.String, int, int):java.lang.Object");
    }

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(ByteBuffer b, int offset, int len) {
        if (b.hasArray()) {
            return getBest(b.array(), b.arrayOffset() + b.position() + offset, len);
        }
        return getBestByteBuffer(b, offset, len);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c2 A[LOOP:0: B:3:0x000e->B:31:0x00c2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V getBestByteBuffer(java.nio.ByteBuffer r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = r6
            r10 = r0
            r0 = r7
            int r0 = r0.position()
            r1 = r8
            int r0 = r0 + r1
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x000e:
            r0 = r12
            r1 = r9
            if (r0 >= r1) goto L_0x00c8
            r0 = r7
            r1 = r11
            int r11 = r11 + 1
            byte r0 = r0.get(r1)
            r13 = r0
            r0 = r13
            if (r0 < 0) goto L_0x0034
            r0 = r13
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L_0x0034
            int[] r0 = org.eclipse.jetty.util.TreeTrie.LOOKUP
            r1 = r13
            r0 = r0[r1]
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            r14 = r0
            r0 = r14
            if (r0 < 0) goto L_0x0057
            r0 = r10
            org.eclipse.jetty.util.TreeTrie<V>[] r0 = r0._nextIndex
            r1 = r14
            r0 = r0[r1]
            if (r0 != 0) goto L_0x004a
            goto L_0x00c8
        L_0x004a:
            r0 = r10
            org.eclipse.jetty.util.TreeTrie<V>[] r0 = r0._nextIndex
            r1 = r14
            r0 = r0[r1]
            r10 = r0
            goto L_0x009e
        L_0x0057:
            r0 = 0
            r15 = r0
            r0 = r10
            java.util.List<org.eclipse.jetty.util.TreeTrie<V>> r0 = r0._nextOther
            int r0 = r0.size()
            r16 = r0
        L_0x0066:
            r0 = r16
            int r16 = r16 + -1
            if (r0 <= 0) goto L_0x0092
            r0 = r10
            java.util.List<org.eclipse.jetty.util.TreeTrie<V>> r0 = r0._nextOther
            r1 = r16
            java.lang.Object r0 = r0.get(r1)
            org.eclipse.jetty.util.TreeTrie r0 = (org.eclipse.jetty.util.TreeTrie) r0
            r15 = r0
            r0 = r15
            char r0 = r0.f3163_c
            r1 = r13
            if (r0 != r1) goto L_0x008c
            goto L_0x0092
        L_0x008c:
            r0 = 0
            r15 = r0
            goto L_0x0066
        L_0x0092:
            r0 = r15
            if (r0 != 0) goto L_0x009a
            goto L_0x00c8
        L_0x009a:
            r0 = r15
            r10 = r0
        L_0x009e:
            r0 = r10
            java.lang.String r0 = r0._key
            if (r0 == 0) goto L_0x00c2
            r0 = r10
            r1 = r7
            r2 = r8
            r3 = r12
            int r2 = r2 + r3
            r3 = 1
            int r2 = r2 + r3
            r3 = r9
            r4 = r12
            int r3 = r3 - r4
            r4 = 1
            int r3 = r3 - r4
            java.lang.Object r0 = r0.getBest(r1, r2, r3)
            r15 = r0
            r0 = r15
            if (r0 == 0) goto L_0x00c8
            r0 = r15
            return r0
        L_0x00c2:
            int r12 = r12 + 1
            goto L_0x000e
        L_0x00c8:
            r0 = r10
            V r0 = r0._value
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.TreeTrie.getBestByteBuffer(java.nio.ByteBuffer, int, int):java.lang.Object");
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        toString(buf, this);
        if (buf.length() == 0) {
            return "{}";
        }
        buf.setCharAt(0, '{');
        buf.append('}');
        return buf.toString();
    }

    private static <V> void toString(Appendable out, TreeTrie<V> t) {
        if (t != null) {
            if (((TreeTrie) t)._value != null) {
                try {
                    out.append(',');
                    out.append(((TreeTrie) t)._key);
                    out.append('=');
                    out.append(((TreeTrie) t)._value.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 0; i < 32; i++) {
                if (((TreeTrie) t)._nextIndex[i] != null) {
                    toString(out, ((TreeTrie) t)._nextIndex[i]);
                }
            }
            int i2 = ((TreeTrie) t)._nextOther.size();
            while (true) {
                i2--;
                if (i2 > 0) {
                    toString(out, ((TreeTrie) t)._nextOther.get(i2));
                } else {
                    return;
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.Trie
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        keySet(keys, this);
        return keys;
    }

    private static <V> void keySet(Set<String> set, TreeTrie<V> t) {
        if (t != null) {
            if (((TreeTrie) t)._key != null) {
                set.add(((TreeTrie) t)._key);
            }
            for (int i = 0; i < 32; i++) {
                if (((TreeTrie) t)._nextIndex[i] != null) {
                    keySet(set, ((TreeTrie) t)._nextIndex[i]);
                }
            }
            int i2 = ((TreeTrie) t)._nextOther.size();
            while (true) {
                i2--;
                if (i2 > 0) {
                    keySet(set, ((TreeTrie) t)._nextOther.get(i2));
                } else {
                    return;
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean isFull() {
        return false;
    }
}
