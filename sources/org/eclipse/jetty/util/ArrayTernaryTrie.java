package org.eclipse.jetty.util;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.p015io.FastMultiByteArrayInputStream;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ArrayTernaryTrie.class */
public class ArrayTernaryTrie<V> extends AbstractTrie<V> {

    /* renamed from: LO */
    private static int f3119LO = 1;

    /* renamed from: EQ */
    private static int f3120EQ = 2;

    /* renamed from: HI */
    private static int f3121HI = 3;
    private static final int ROW_SIZE = 4;
    public static final int MAX_CAPACITY = 65534;
    private final char[] _tree;
    private final String[] _key;
    private final V[] _value;
    private char _rows;

    public ArrayTernaryTrie() {
        this(128);
    }

    public ArrayTernaryTrie(boolean insensitive) {
        this(insensitive, 128);
    }

    public ArrayTernaryTrie(int capacity) {
        this(true, capacity);
    }

    public ArrayTernaryTrie(boolean insensitive, int capacity) {
        super(insensitive);
        if (capacity > 65534) {
            throw new IllegalArgumentException("Capacity " + capacity + " > " + MAX_CAPACITY);
        }
        this._value = (V[]) new Object[capacity + 1];
        this._tree = new char[(capacity + 1) * 4];
        this._key = new String[capacity + 1];
    }

    public ArrayTernaryTrie(ArrayTernaryTrie<V> trie, double factor) {
        super(trie.isCaseInsensitive());
        int capacity = (int) (((double) trie._value.length) * factor);
        if (capacity > 65534) {
            throw new IllegalArgumentException("Capacity " + capacity + " > " + MAX_CAPACITY);
        }
        this._rows = trie._rows;
        this._value = (V[]) Arrays.copyOf(trie._value, capacity);
        this._tree = Arrays.copyOf(trie._tree, capacity * 4);
        this._key = (String[]) Arrays.copyOf(trie._key, capacity);
    }

    @Override // org.eclipse.jetty.util.Trie
    public void clear() {
        this._rows = 0;
        Arrays.fill(this._value, (Object) null);
        Arrays.fill(this._tree, (char) 0);
        Arrays.fill(this._key, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e8, code lost:
        r11 = r11 + 1;
     */
    @Override // org.eclipse.jetty.util.Trie
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean put(java.lang.String r6, V r7) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ArrayTernaryTrie.put(java.lang.String, java.lang.Object):boolean");
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(String s, int offset, int len) {
        char c = 0;
        int i = 0;
        while (i < len) {
            i++;
            char c2 = s.charAt(offset + i);
            if (isCaseInsensitive() && c2 < 128) {
                c2 = StringUtil.lowercases[c2];
            }
            while (true) {
                int row = 4 * c;
                int diff = this._tree[row] - c2;
                if (diff == 0) {
                    c = this._tree[row + f3120EQ];
                    if (c == 0) {
                        return null;
                    }
                } else {
                    c = this._tree[row + hilo(diff)];
                    if (c == 0) {
                        return null;
                    }
                }
            }
        }
        return this._value[c];
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(ByteBuffer b, int offset, int len) {
        char c = 0;
        int offset2 = offset + b.position();
        int i = 0;
        while (i < len) {
            i++;
            byte c2 = (byte) (b.get(offset2 + i) & Byte.MAX_VALUE);
            if (isCaseInsensitive()) {
                c2 = (byte) StringUtil.lowercases[c2];
            }
            while (true) {
                int row = 4 * c;
                int diff = this._tree[row] - c2;
                if (diff == 0) {
                    c = this._tree[row + f3120EQ];
                    if (c == 0) {
                        return null;
                    }
                } else {
                    c = this._tree[row + hilo(diff)];
                    if (c == 0) {
                        return null;
                    }
                }
            }
        }
        return this._value[c];
    }

    @Override // org.eclipse.jetty.util.AbstractTrie, org.eclipse.jetty.util.Trie
    public V getBest(String s) {
        return getBest(0, s, 0, s.length());
    }

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(String s, int offset, int length) {
        return getBest(0, s, offset, length);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r7v0 ??, r7v1 ??, r7v3 ??, r7v2 ??, r7v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private V getBest(
/*
[165] Method generation error in method: org.eclipse.jetty.util.ArrayTernaryTrie.getBest(int, java.lang.String, int, int):V, file: grasscutter.jar:org/eclipse/jetty/util/ArrayTernaryTrie.class
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:195)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:344)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    
*/

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(ByteBuffer b, int offset, int len) {
        if (b.hasArray()) {
            return getBest(0, b.array(), b.arrayOffset() + b.position() + offset, len);
        }
        return getBest(0, b, offset, len);
    }

    @Override // org.eclipse.jetty.util.AbstractTrie, org.eclipse.jetty.util.Trie
    public V getBest(byte[] b, int offset, int len) {
        return getBest(0, b, offset, len);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r7v0 ??, r7v1 ??, r7v3 ??, r7v2 ??, r7v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private V getBest(
/*
[160] Method generation error in method: org.eclipse.jetty.util.ArrayTernaryTrie.getBest(int, byte[], int, int):V, file: grasscutter.jar:org/eclipse/jetty/util/ArrayTernaryTrie.class
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:195)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:344)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    
*/

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r8v0 ??, r8v1 ??, r8v3 ??, r8v2 ??, r8v4 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private V getBest(
/*
[193] Method generation error in method: org.eclipse.jetty.util.ArrayTernaryTrie.getBest(int, java.nio.ByteBuffer, int, int):V, file: grasscutter.jar:org/eclipse/jetty/util/ArrayTernaryTrie.class
    jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
    	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:195)
    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:344)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
    
*/

    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int r = 0; r < this._rows; r++) {
            if (!(this._key[r] == null || this._value[r] == null)) {
                buf.append(',');
                buf.append(this._key[r]);
                buf.append('=');
                buf.append(this._value[r].toString());
            }
        }
        if (buf.length() == 0) {
            return "{}";
        }
        buf.setCharAt(0, '{');
        buf.append('}');
        return buf.toString();
    }

    @Override // org.eclipse.jetty.util.Trie
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        for (int r = 0; r < this._rows; r++) {
            if (!(this._key[r] == null || this._value[r] == null)) {
                keys.add(this._key[r]);
            }
        }
        return keys;
    }

    public int size() {
        int s = 0;
        for (int r = 0; r < this._rows; r++) {
            if (!(this._key[r] == null || this._value[r] == null)) {
                s++;
            }
        }
        return s;
    }

    public boolean isEmpty() {
        for (int r = 0; r < this._rows; r++) {
            if (!(this._key[r] == null || this._value[r] == null)) {
                return false;
            }
        }
        return true;
    }

    public Set<Map.Entry<String, V>> entrySet() {
        Set<Map.Entry<String, V>> entries = new HashSet<>();
        for (int r = 0; r < this._rows; r++) {
            if (!(this._key[r] == null || this._value[r] == null)) {
                entries.add(new AbstractMap.SimpleEntry<>(this._key[r], this._value[r]));
            }
        }
        return entries;
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean isFull() {
        return this._rows == this._key.length;
    }

    public static int hilo(int diff) {
        return 1 + ((diff | Integer.MAX_VALUE) / FastMultiByteArrayInputStream.SLICE_MASK);
    }

    public void dump() {
        for (int r = 0; r < this._rows; r++) {
            char c = this._tree[(r * 4) + 0];
            PrintStream printStream = System.err;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(r);
            objArr[1] = (c < ' ' || c > 127) ? "" + ((int) c) : "'" + c + "'";
            objArr[2] = Integer.valueOf(this._tree[(r * 4) + f3119LO]);
            objArr[3] = Integer.valueOf(this._tree[(r * 4) + f3120EQ]);
            objArr[4] = Integer.valueOf(this._tree[(r * 4) + f3121HI]);
            objArr[5] = this._key[r];
            objArr[6] = this._value[r];
            printStream.printf("%4d [%s,%d,%d,%d] '%s':%s%n", objArr);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ArrayTernaryTrie$Growing.class */
    public static class Growing<V> implements Trie<V> {
        private final int _growby;
        private ArrayTernaryTrie<V> _trie;

        public Growing() {
            this(1024, 1024);
        }

        public Growing(int capacity, int growby) {
            this._growby = growby;
            this._trie = new ArrayTernaryTrie<>(capacity);
        }

        public Growing(boolean insensitive, int capacity, int growby) {
            this._growby = growby;
            this._trie = new ArrayTernaryTrie<>(insensitive, capacity);
        }

        @Override // org.eclipse.jetty.util.Trie
        public boolean put(V v) {
            return put(v.toString(), v);
        }

        public int hashCode() {
            return this._trie.hashCode();
        }

        @Override // org.eclipse.jetty.util.Trie
        public V remove(String s) {
            return this._trie.remove(s);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V get(String s) {
            return this._trie.get(s);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V get(ByteBuffer b) {
            return this._trie.get(b);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V getBest(byte[] b, int offset, int len) {
            return this._trie.getBest(b, offset, len);
        }

        @Override // org.eclipse.jetty.util.Trie
        public boolean isCaseInsensitive() {
            return this._trie.isCaseInsensitive();
        }

        public boolean equals(Object obj) {
            return this._trie.equals(obj);
        }

        @Override // org.eclipse.jetty.util.Trie
        public void clear() {
            this._trie.clear();
        }

        @Override // org.eclipse.jetty.util.Trie
        public boolean put(String s, V v) {
            boolean added = this._trie.put(s, v);
            while (!added && this._growby > 0) {
                int newCapacity = ((ArrayTernaryTrie) this._trie)._key.length + this._growby;
                if (newCapacity > 65534) {
                    return false;
                }
                ArrayTernaryTrie<V> bigger = new ArrayTernaryTrie<>(this._trie.isCaseInsensitive(), newCapacity);
                for (Map.Entry<String, V> entry : this._trie.entrySet()) {
                    bigger.put(entry.getKey(), entry.getValue());
                }
                this._trie = bigger;
                added = this._trie.put(s, v);
            }
            return added;
        }

        @Override // org.eclipse.jetty.util.Trie
        public V get(String s, int offset, int len) {
            return this._trie.get(s, offset, len);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V get(ByteBuffer b, int offset, int len) {
            return this._trie.get(b, offset, len);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V getBest(String s) {
            return this._trie.getBest(s);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V getBest(String s, int offset, int length) {
            return this._trie.getBest(s, offset, length);
        }

        @Override // org.eclipse.jetty.util.Trie
        public V getBest(ByteBuffer b, int offset, int len) {
            return this._trie.getBest(b, offset, len);
        }

        public String toString() {
            return this._trie.toString();
        }

        @Override // org.eclipse.jetty.util.Trie
        public Set<String> keySet() {
            return this._trie.keySet();
        }

        @Override // org.eclipse.jetty.util.Trie
        public boolean isFull() {
            return false;
        }

        public void dump() {
            this._trie.dump();
        }

        public boolean isEmpty() {
            return this._trie.isEmpty();
        }

        public int size() {
            return this._trie.size();
        }
    }
}
