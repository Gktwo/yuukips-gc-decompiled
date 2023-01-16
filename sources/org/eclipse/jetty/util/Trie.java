package org.eclipse.jetty.util;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Trie.class */
public interface Trie<V> {
    boolean put(String str, V v);

    boolean put(V v);

    V remove(String str);

    V get(String str);

    V get(String str, int i, int i2);

    V get(ByteBuffer byteBuffer);

    V get(ByteBuffer byteBuffer, int i, int i2);

    V getBest(String str);

    V getBest(String str, int i, int i2);

    V getBest(byte[] bArr, int i, int i2);

    V getBest(ByteBuffer byteBuffer, int i, int i2);

    Set<String> keySet();

    boolean isFull();

    boolean isCaseInsensitive();

    void clear();

    default V getBest(byte[] b) {
        return getBest(b, 0, b.length);
    }

    default V getBest(ByteBuffer b) {
        return getBest(b, 0, b.remaining());
    }

    static <T> Trie<T> empty(final boolean caseInsensitive) {
        return new Trie<T>() { // from class: org.eclipse.jetty.util.Trie.1
            @Override // org.eclipse.jetty.util.Trie
            public boolean put(String s, Object o) {
                return false;
            }

            @Override // org.eclipse.jetty.util.Trie
            public boolean put(Object o) {
                return false;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T remove(String s) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T get(String s) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T get(String s, int offset, int len) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T get(ByteBuffer b) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T get(ByteBuffer b, int offset, int len) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T getBest(String s) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T getBest(String s, int offset, int len) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T getBest(byte[] b, int offset, int len) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public T getBest(ByteBuffer b, int offset, int len) {
                return null;
            }

            @Override // org.eclipse.jetty.util.Trie
            public Set<String> keySet() {
                return Collections.emptySet();
            }

            @Override // org.eclipse.jetty.util.Trie
            public boolean isFull() {
                return true;
            }

            @Override // org.eclipse.jetty.util.Trie
            public boolean isCaseInsensitive() {
                return caseInsensitive;
            }

            @Override // org.eclipse.jetty.util.Trie
            public void clear() {
            }
        };
    }
}
