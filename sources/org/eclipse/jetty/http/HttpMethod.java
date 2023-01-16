package org.eclipse.jetty.http;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.nio.ByteBuffer;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Trie;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpMethod.class */
public enum HttpMethod {
    ACL(Type.IDEMPOTENT),
    BASELINE_CONTROL(Type.IDEMPOTENT),
    BIND(Type.IDEMPOTENT),
    CHECKIN(Type.IDEMPOTENT),
    CHECKOUT(Type.IDEMPOTENT),
    CONNECT(Type.NORMAL),
    COPY(Type.IDEMPOTENT),
    DELETE(Type.IDEMPOTENT),
    GET(Type.SAFE),
    HEAD(Type.SAFE),
    LABEL(Type.IDEMPOTENT),
    LINK(Type.IDEMPOTENT),
    LOCK(Type.NORMAL),
    MERGE(Type.IDEMPOTENT),
    MKACTIVITY(Type.IDEMPOTENT),
    MKCALENDAR(Type.IDEMPOTENT),
    MKCOL(Type.IDEMPOTENT),
    MKREDIRECTREF(Type.IDEMPOTENT),
    MKWORKSPACE(Type.IDEMPOTENT),
    MOVE(Type.IDEMPOTENT),
    OPTIONS(Type.SAFE),
    ORDERPATCH(Type.IDEMPOTENT),
    PATCH(Type.NORMAL),
    POST(Type.NORMAL),
    PRI(Type.SAFE),
    PROPFIND(Type.SAFE),
    PROPPATCH(Type.IDEMPOTENT),
    PUT(Type.IDEMPOTENT),
    REBIND(Type.IDEMPOTENT),
    REPORT(Type.SAFE),
    SEARCH(Type.SAFE),
    TRACE(Type.SAFE),
    UNBIND(Type.IDEMPOTENT),
    UNCHECKOUT(Type.IDEMPOTENT),
    UNLINK(Type.IDEMPOTENT),
    UNLOCK(Type.IDEMPOTENT),
    UPDATE(Type.IDEMPOTENT),
    UPDATEREDIRECTREF(Type.IDEMPOTENT),
    VERSION_CONTROL(Type.IDEMPOTENT),
    PROXY(Type.NORMAL);
    
    private final String _method = name().replace('_', '-');
    private final byte[] _bytes = StringUtil.getBytes(this._method);
    private final ByteBuffer _buffer = ByteBuffer.wrap(this._bytes);
    private final Type _type;
    public static final Trie<HttpMethod> INSENSITIVE_CACHE = new ArrayTrie(PacketOpcodes.PersonalSceneJumpReq);
    public static final Trie<HttpMethod> CACHE = new ArrayTernaryTrie(false, 300);
    public static final Trie<HttpMethod> LOOK_AHEAD = new ArrayTernaryTrie(false, 330);
    public static final int ACL_AS_INT = 1094929440;
    public static final int GET_AS_INT = 1195725856;
    public static final int PRI_AS_INT = 1347569952;
    public static final int PUT_AS_INT = 1347769376;
    public static final int POST_AS_INT = 1347375956;
    public static final int HEAD_AS_INT = 1212498244;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpMethod$Type.class */
    private enum Type {
        NORMAL,
        IDEMPOTENT,
        SAFE
    }

    static {
        HttpMethod[] values = values();
        for (HttpMethod method : values) {
            if (!INSENSITIVE_CACHE.put(method.asString(), method)) {
                throw new IllegalStateException("INSENSITIVE_CACHE too small: " + method);
            } else if (!CACHE.put(method.asString(), method)) {
                throw new IllegalStateException("CACHE too small: " + method);
            } else if (!LOOK_AHEAD.put(method.asString() + ' ', method)) {
                throw new IllegalStateException("LOOK_AHEAD too small: " + method);
            }
        }
    }

    HttpMethod(Type type) {
        this._type = type;
    }

    public byte[] getBytes() {
        return this._bytes;
    }

    /* renamed from: is */
    public boolean m40is(String s) {
        return toString().equalsIgnoreCase(s);
    }

    public boolean isSafe() {
        return this._type == Type.SAFE;
    }

    public boolean isIdempotent() {
        return this._type.ordinal() >= Type.IDEMPOTENT.ordinal();
    }

    public ByteBuffer asBuffer() {
        return this._buffer.asReadOnlyBuffer();
    }

    public String asString() {
        return this._method;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this._method;
    }

    @Deprecated
    public static HttpMethod lookAheadGet(byte[] bytes, int position, int limit) {
        return LOOK_AHEAD.getBest(bytes, position, limit - position);
    }

    public static HttpMethod lookAheadGet(ByteBuffer buffer) {
        int len = buffer.remaining();
        if (len > 3) {
            switch (buffer.getInt(buffer.position())) {
                case ACL_AS_INT:
                    return ACL;
                case GET_AS_INT:
                    return GET;
                case HEAD_AS_INT:
                    if (len > 4 && buffer.get(buffer.position() + 4) == 32) {
                        return HEAD;
                    }
                    break;
                case POST_AS_INT:
                    if (len > 4 && buffer.get(buffer.position() + 4) == 32) {
                        return POST;
                    }
                    break;
                case PRI_AS_INT:
                    return PRI;
                case PUT_AS_INT:
                    return PUT;
            }
        }
        return LOOK_AHEAD.getBest(buffer, 0, len);
    }

    public static HttpMethod fromString(String method) {
        return CACHE.get(method);
    }
}
