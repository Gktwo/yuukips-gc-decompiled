package org.eclipse.jetty.http;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.URIUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpScheme.class */
public enum HttpScheme {
    HTTP(URIUtil.HTTP),
    HTTPS(URIUtil.HTTPS),
    WS("ws"),
    WSS("wss");
    
    public static final Trie<HttpScheme> CACHE = new ArrayTrie();
    private final String _string;
    private final ByteBuffer _buffer;

    static {
        HttpScheme[] values = values();
        for (HttpScheme version : values) {
            CACHE.put(version.asString(), version);
        }
    }

    HttpScheme(String s) {
        this._string = s;
        this._buffer = BufferUtil.toBuffer(s);
    }

    public ByteBuffer asByteBuffer() {
        return this._buffer.asReadOnlyBuffer();
    }

    /* renamed from: is */
    public boolean m39is(String s) {
        return s != null && this._string.equalsIgnoreCase(s);
    }

    public String asString() {
        return this._string;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this._string;
    }
}
