package org.eclipse.jetty.http;

import java.nio.ByteBuffer;
import java.util.EnumSet;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Trie;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpHeaderValue.class */
public enum HttpHeaderValue {
    CLOSE("close"),
    CHUNKED("chunked"),
    GZIP(GzipHandler.GZIP),
    IDENTITY("identity"),
    KEEP_ALIVE("keep-alive"),
    CONTINUE("100-continue"),
    PROCESSING("102-processing"),
    TE("TE"),
    BYTES("bytes"),
    NO_CACHE("no-cache"),
    UPGRADE("Upgrade"),
    UNKNOWN("::UNKNOWN::");
    
    public static final Trie<HttpHeaderValue> CACHE = new ArrayTrie();
    private final String _string;
    private final ByteBuffer _buffer;
    private static EnumSet<HttpHeader> __known;

    static {
        HttpHeaderValue[] values = values();
        for (HttpHeaderValue value : values) {
            if (value != UNKNOWN) {
                CACHE.put(value.toString(), value);
            }
        }
        __known = EnumSet.of(HttpHeader.CONNECTION, HttpHeader.TRANSFER_ENCODING, HttpHeader.CONTENT_ENCODING);
    }

    HttpHeaderValue(String s) {
        this._string = s;
        this._buffer = BufferUtil.toBuffer(s);
    }

    public ByteBuffer toBuffer() {
        return this._buffer.asReadOnlyBuffer();
    }

    /* renamed from: is */
    public boolean m41is(String s) {
        return this._string.equalsIgnoreCase(s);
    }

    public String asString() {
        return this._string;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this._string;
    }

    public static boolean hasKnownValues(HttpHeader header) {
        if (header == null) {
            return false;
        }
        return __known.contains(header);
    }
}
