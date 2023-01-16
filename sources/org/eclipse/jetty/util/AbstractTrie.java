package org.eclipse.jetty.util;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/AbstractTrie.class */
public abstract class AbstractTrie<V> implements Trie<V> {
    final boolean _caseInsensitive;

    /* access modifiers changed from: protected */
    public AbstractTrie(boolean insensitive) {
        this._caseInsensitive = insensitive;
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean put(V v) {
        return put(v.toString(), v);
    }

    @Override // org.eclipse.jetty.util.Trie
    public V remove(String s) {
        V o = get(s);
        put(s, null);
        return o;
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(String s) {
        return get(s, 0, s.length());
    }

    @Override // org.eclipse.jetty.util.Trie
    public V get(ByteBuffer b) {
        return get(b, 0, b.remaining());
    }

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(String s) {
        return getBest(s, 0, s.length());
    }

    @Override // org.eclipse.jetty.util.Trie
    public V getBest(byte[] b, int offset, int len) {
        return getBest(new String(b, offset, len, StandardCharsets.ISO_8859_1));
    }

    @Override // org.eclipse.jetty.util.Trie
    public boolean isCaseInsensitive() {
        return this._caseInsensitive;
    }
}
