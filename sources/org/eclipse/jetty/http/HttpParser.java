package org.eclipse.jetty.http;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import org.eclipse.jetty.http.HttpTokens;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.Utf8StringBuilder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser.class */
public class HttpParser {
    @Deprecated
    public static final String __STRICT = "org.eclipse.jetty.http.HttpParser.STRICT";
    public static final int INITIAL_URI_LENGTH = 256;
    private static final int MAX_CHUNK_LENGTH = 134217711;
    private final boolean debug;
    private final HttpHandler _handler;
    private final RequestHandler _requestHandler;
    private final ResponseHandler _responseHandler;
    private final ComplianceHandler _complianceHandler;
    private final int _maxHeaderBytes;
    private final HttpCompliance _compliance;
    private final EnumSet<HttpComplianceSection> _compliances;
    private final Utf8StringBuilder _uri;
    private HttpField _field;
    private HttpHeader _header;
    private String _headerString;
    private String _valueString;
    private int _responseStatus;
    private int _headerBytes;
    private boolean _host;
    private boolean _headerComplete;
    private volatile State _state;
    private volatile FieldState _fieldState;
    private volatile boolean _eof;
    private HttpMethod _method;
    private String _methodString;
    private HttpVersion _version;
    private HttpTokens.EndOfContent _endOfContent;
    private boolean _hasContentLength;
    private boolean _hasTransferEncoding;
    private long _contentLength;
    private long _contentPosition;
    private int _chunkLength;
    private int _chunkPosition;
    private boolean _headResponse;
    private boolean _cr;
    private ByteBuffer _contentChunk;
    private Trie<HttpField> _fieldCache;
    private int _length;
    private final StringBuilder _string;
    public static final Logger LOG = Log.getLogger(HttpParser.class);
    public static final Trie<HttpField> CACHE = new ArrayTrie(2048);
    private static final Trie<HttpField> NO_CACHE = Trie.empty(true);
    private static final EnumSet<State> __idleStates = EnumSet.of(State.START, State.END, State.CLOSE, State.CLOSED);
    private static final EnumSet<State> __completeStates = EnumSet.of(State.END, State.CLOSE, State.CLOSED);
    private static final EnumSet<State> __terminatedStates = EnumSet.of(State.CLOSE, State.CLOSED);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$FieldState.class */
    public enum FieldState {
        FIELD,
        IN_NAME,
        VALUE,
        IN_VALUE,
        WS_AFTER_NAME
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$RequestHandler.class */
    public interface RequestHandler extends HttpHandler {
        boolean startRequest(String str, String str2, HttpVersion httpVersion);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$ResponseHandler.class */
    public interface ResponseHandler extends HttpHandler {
        boolean startResponse(HttpVersion httpVersion, int i, String str);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$State.class */
    public enum State {
        START,
        METHOD,
        RESPONSE_VERSION,
        SPACE1,
        STATUS,
        URI,
        SPACE2,
        REQUEST_VERSION,
        REASON,
        PROXY,
        HEADER,
        CONTENT,
        EOF_CONTENT,
        CHUNKED_CONTENT,
        CHUNK_SIZE,
        CHUNK_PARAMS,
        CHUNK,
        CONTENT_END,
        TRAILER,
        END,
        CLOSE,
        CLOSED
    }

    static {
        CACHE.put(new HttpField(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE));
        CACHE.put(new HttpField(HttpHeader.CONNECTION, HttpHeaderValue.KEEP_ALIVE));
        CACHE.put(new HttpField(HttpHeader.CONNECTION, HttpHeaderValue.UPGRADE));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_ENCODING, GzipHandler.GZIP));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_ENCODING, "gzip, deflate"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_ENCODING, "gzip, deflate, br"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_ENCODING, "gzip,deflate,sdch"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_LANGUAGE, "en-US,en;q=0.5"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_LANGUAGE, "en-GB,en-US;q=0.8,en;q=0.6"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_LANGUAGE, "en-AU,en;q=0.9,it-IT;q=0.8,it;q=0.7,en-GB;q=0.6,en-US;q=0.5"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_CHARSET, "ISO-8859-1,utf-8;q=0.7,*;q=0.3"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT, "*/*"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT, "image/png,image/*;q=0.8,*/*;q=0.5"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        CACHE.put(new HttpField(HttpHeader.ACCEPT_RANGES, HttpHeaderValue.BYTES));
        CACHE.put(new HttpField(HttpHeader.PRAGMA, "no-cache"));
        CACHE.put(new HttpField(HttpHeader.CACHE_CONTROL, "private, no-cache, no-cache=Set-Cookie, proxy-revalidate"));
        CACHE.put(new HttpField(HttpHeader.CACHE_CONTROL, "no-cache"));
        CACHE.put(new HttpField(HttpHeader.CACHE_CONTROL, "max-age=0"));
        CACHE.put(new HttpField(HttpHeader.CONTENT_LENGTH, "0"));
        CACHE.put(new HttpField(HttpHeader.CONTENT_ENCODING, GzipHandler.GZIP));
        CACHE.put(new HttpField(HttpHeader.CONTENT_ENCODING, GzipHandler.DEFLATE));
        CACHE.put(new HttpField(HttpHeader.TRANSFER_ENCODING, "chunked"));
        CACHE.put(new HttpField(HttpHeader.EXPIRES, "Fri, 01 Jan 1990 00:00:00 GMT"));
        String[] strArr = {ContentType.PLAIN, ContentType.HTML, ContentType.XML, "text/json", ContentType.JSON, "application/x-www-form-urlencoded"};
        for (String type : strArr) {
            CACHE.put(new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, type));
            String[] strArr2 = {StringUtil.__UTF8, StringUtil.__ISO_8859_1};
            for (String charset : strArr2) {
                CACHE.put(new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, type + ";charset=" + charset));
                CACHE.put(new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, type + "; charset=" + charset));
                CACHE.put(new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, type + ";charset=" + charset.toUpperCase(Locale.ENGLISH)));
                CACHE.put(new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, type + "; charset=" + charset.toUpperCase(Locale.ENGLISH)));
            }
        }
        HttpHeader[] values = HttpHeader.values();
        for (HttpHeader h : values) {
            if (!h.isPseudo() && !CACHE.put(new HttpField(h, (String) null))) {
                throw new IllegalStateException("CACHE FULL");
            }
        }
    }

    private static HttpCompliance compliance() {
        if (!Boolean.getBoolean(__STRICT)) {
            return HttpCompliance.RFC7230;
        }
        LOG.warn("Deprecated property used: org.eclipse.jetty.http.HttpParser.STRICT", new Object[0]);
        return HttpCompliance.LEGACY;
    }

    public HttpParser(RequestHandler handler) {
        this(handler, -1, compliance());
    }

    public HttpParser(ResponseHandler handler) {
        this(handler, -1, compliance());
    }

    public HttpParser(RequestHandler handler, int maxHeaderBytes) {
        this(handler, maxHeaderBytes, compliance());
    }

    public HttpParser(ResponseHandler handler, int maxHeaderBytes) {
        this(handler, maxHeaderBytes, compliance());
    }

    @Deprecated
    public HttpParser(RequestHandler handler, int maxHeaderBytes, boolean strict) {
        this(handler, maxHeaderBytes, strict ? HttpCompliance.LEGACY : compliance());
    }

    @Deprecated
    public HttpParser(ResponseHandler handler, int maxHeaderBytes, boolean strict) {
        this(handler, maxHeaderBytes, strict ? HttpCompliance.LEGACY : compliance());
    }

    public HttpParser(RequestHandler handler, HttpCompliance compliance) {
        this(handler, -1, compliance);
    }

    public HttpParser(RequestHandler handler, int maxHeaderBytes, HttpCompliance compliance) {
        this(handler, null, maxHeaderBytes, compliance == null ? compliance() : compliance);
    }

    public HttpParser(ResponseHandler handler, int maxHeaderBytes, HttpCompliance compliance) {
        this(null, handler, maxHeaderBytes, compliance == null ? compliance() : compliance);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: org.eclipse.jetty.http.HttpParser$ResponseHandler */
    /* JADX WARN: Multi-variable type inference failed */
    private HttpParser(RequestHandler requestHandler, ResponseHandler responseHandler, int maxHeaderBytes, HttpCompliance compliance) {
        this.debug = LOG.isDebugEnabled();
        this._uri = new Utf8StringBuilder(256);
        this._state = State.START;
        this._fieldState = FieldState.FIELD;
        this._contentLength = -1;
        this._string = new StringBuilder();
        this._handler = requestHandler != null ? requestHandler : responseHandler;
        this._requestHandler = requestHandler;
        this._responseHandler = responseHandler;
        this._maxHeaderBytes = maxHeaderBytes;
        this._compliance = compliance;
        this._compliances = compliance.sections();
        this._complianceHandler = (ComplianceHandler) (this._handler instanceof ComplianceHandler ? this._handler : null);
    }

    public HttpHandler getHandler() {
        return this._handler;
    }

    public HttpCompliance getHttpCompliance() {
        return this._compliance;
    }

    protected boolean complianceViolation(HttpComplianceSection violation) {
        return complianceViolation(violation, null);
    }

    protected boolean complianceViolation(HttpComplianceSection violation, String reason) {
        if (this._compliances.contains(violation)) {
            return true;
        }
        if (reason == null) {
            reason = violation.description;
        }
        if (this._complianceHandler == null) {
            return false;
        }
        this._complianceHandler.onComplianceViolation(this._compliance, violation, reason);
        return false;
    }

    protected void handleViolation(HttpComplianceSection section, String reason) {
        if (this._complianceHandler != null) {
            this._complianceHandler.onComplianceViolation(this._compliance, section, reason);
        }
    }

    protected String caseInsensitiveHeader(String orig, String normative) {
        if (this._compliances.contains(HttpComplianceSection.FIELD_NAME_CASE_INSENSITIVE)) {
            return normative;
        }
        if (!orig.equals(normative)) {
            handleViolation(HttpComplianceSection.FIELD_NAME_CASE_INSENSITIVE, orig);
        }
        return orig;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public long getContentRead() {
        return this._contentPosition;
    }

    public int getHeaderLength() {
        return this._headerBytes;
    }

    public void setHeadResponse(boolean head) {
        this._headResponse = head;
    }

    protected void setResponseStatus(int status) {
        this._responseStatus = status;
    }

    public State getState() {
        return this._state;
    }

    public boolean inContentState() {
        return this._state.ordinal() >= State.CONTENT.ordinal() && this._state.ordinal() < State.END.ordinal();
    }

    public boolean inHeaderState() {
        return this._state.ordinal() < State.CONTENT.ordinal();
    }

    public boolean isChunking() {
        return this._endOfContent == HttpTokens.EndOfContent.CHUNKED_CONTENT;
    }

    public boolean isStart() {
        return isState(State.START);
    }

    public boolean isClose() {
        return isState(State.CLOSE);
    }

    public boolean isClosed() {
        return isState(State.CLOSED);
    }

    public boolean isIdle() {
        return __idleStates.contains(this._state);
    }

    public boolean isComplete() {
        return __completeStates.contains(this._state);
    }

    public boolean isTerminated() {
        return __terminatedStates.contains(this._state);
    }

    public boolean isState(State state) {
        return this._state == state;
    }

    private HttpTokens.Token next(ByteBuffer buffer) {
        HttpTokens.Token t = HttpTokens.TOKENS[255 & buffer.get()];
        switch (t.getType()) {
            case CNTL:
                throw new IllegalCharacterException(this._state, t, buffer);
            case LF:
                this._cr = false;
                break;
            case CR:
                if (this._cr) {
                    throw new BadMessageException("Bad EOL");
                }
                this._cr = true;
                if (!buffer.hasRemaining()) {
                    return null;
                }
                if (this._maxHeaderBytes > 0 && (this._state == State.HEADER || this._state == State.TRAILER)) {
                    this._headerBytes++;
                }
                return next(buffer);
            case ALPHA:
            case DIGIT:
            case TCHAR:
            case VCHAR:
            case HTAB:
            case SPACE:
            case OTEXT:
            case COLON:
                if (this._cr) {
                    throw new BadMessageException("Bad EOL");
                }
                break;
        }
        return t;
    }

    private boolean quickStart(ByteBuffer buffer) {
        HttpTokens.Token t;
        if (this._requestHandler != null) {
            this._method = HttpMethod.lookAheadGet(buffer);
            if (this._method != null) {
                this._methodString = this._method.asString();
                buffer.position(buffer.position() + this._methodString.length() + 1);
                setState(State.SPACE1);
                return false;
            }
        } else if (this._responseHandler != null) {
            this._version = HttpVersion.lookAheadGet(buffer);
            if (this._version != null) {
                buffer.position(buffer.position() + this._version.asString().length() + 1);
                setState(State.SPACE1);
                return false;
            }
        }
        while (this._state == State.START && buffer.hasRemaining() && (t = next(buffer)) != null) {
            switch (t.getType()) {
                case ALPHA:
                case DIGIT:
                case TCHAR:
                case VCHAR:
                    this._string.setLength(0);
                    this._string.append(t.getChar());
                    setState(this._requestHandler != null ? State.METHOD : State.RESPONSE_VERSION);
                    return false;
                case HTAB:
                case SPACE:
                case OTEXT:
                    throw new IllegalCharacterException(this._state, t, buffer);
                default:
                    if (this._maxHeaderBytes > 0) {
                        int i = this._headerBytes + 1;
                        this._headerBytes = i;
                        if (i > this._maxHeaderBytes) {
                            LOG.warn("padding is too large >" + this._maxHeaderBytes, new Object[0]);
                            throw new BadMessageException(400);
                        }
                    }
            }
        }
        return false;
    }

    private void setString(String s) {
        this._string.setLength(0);
        this._string.append(s);
        this._length = s.length();
    }

    private String takeString() {
        this._string.setLength(this._length);
        String s = this._string.toString();
        this._string.setLength(0);
        this._length = -1;
        return s;
    }

    private boolean handleHeaderContentMessage() {
        boolean handleHeader = this._handler.headerComplete();
        this._headerComplete = true;
        if (handleHeader) {
            return true;
        }
        setState(State.CONTENT_END);
        return handleContentMessage();
    }

    private boolean handleContentMessage() {
        if (this._handler.contentComplete()) {
            return true;
        }
        setState(State.END);
        return this._handler.messageComplete();
    }

    private boolean parseLine(ByteBuffer buffer) {
        HttpTokens.Token t;
        HttpVersion version;
        int pos;
        boolean handle = false;
        while (this._state.ordinal() < State.HEADER.ordinal() && buffer.hasRemaining() && !handle && (t = next(buffer)) != null) {
            if (this._maxHeaderBytes > 0) {
                int i = this._headerBytes + 1;
                this._headerBytes = i;
                if (i > this._maxHeaderBytes) {
                    if (this._state == State.URI) {
                        LOG.warn("URI is too large >" + this._maxHeaderBytes, new Object[0]);
                        throw new BadMessageException(414);
                    }
                    if (this._requestHandler != null) {
                        LOG.warn("request is too large >" + this._maxHeaderBytes, new Object[0]);
                    } else {
                        LOG.warn("response is too large >" + this._maxHeaderBytes, new Object[0]);
                    }
                    throw new BadMessageException((int) HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE_431);
                }
            }
            switch (this._state) {
                case METHOD:
                    switch (t.getType()) {
                        case LF:
                            throw new BadMessageException("No URI");
                        case CR:
                        case VCHAR:
                        case HTAB:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                            this._string.append(t.getChar());
                            continue;
                        case SPACE:
                            this._length = this._string.length();
                            this._methodString = takeString();
                            if (this._compliances.contains(HttpComplianceSection.METHOD_CASE_SENSITIVE)) {
                                HttpMethod method = HttpMethod.CACHE.get(this._methodString);
                                if (method != null) {
                                    this._methodString = method.asString();
                                }
                            } else {
                                HttpMethod method2 = HttpMethod.INSENSITIVE_CACHE.get(this._methodString);
                                if (method2 != null) {
                                    if (!method2.asString().equals(this._methodString)) {
                                        handleViolation(HttpComplianceSection.METHOD_CASE_SENSITIVE, this._methodString);
                                    }
                                    this._methodString = method2.asString();
                                }
                            }
                            setState(State.SPACE1);
                            continue;
                    }
                case RESPONSE_VERSION:
                    switch (t.getType()) {
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case COLON:
                            this._string.append(t.getChar());
                            continue;
                        case HTAB:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case SPACE:
                            this._length = this._string.length();
                            this._version = HttpVersion.CACHE.get(takeString());
                            checkVersion();
                            setState(State.SPACE1);
                            continue;
                    }
                case SPACE1:
                    switch (t.getType()) {
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case COLON:
                            if (this._responseHandler == null) {
                                this._uri.reset();
                                setState(State.URI);
                                if (!buffer.hasArray()) {
                                    this._uri.append(t.getByte());
                                    break;
                                } else {
                                    byte[] array = buffer.array();
                                    int p = buffer.arrayOffset() + buffer.position();
                                    int l = buffer.arrayOffset() + buffer.limit();
                                    int i2 = p;
                                    while (i2 < l && array[i2] > 32) {
                                        i2++;
                                    }
                                    int len = i2 - p;
                                    this._headerBytes += len;
                                    if (this._maxHeaderBytes > 0) {
                                        int i3 = this._headerBytes + 1;
                                        this._headerBytes = i3;
                                        if (i3 > this._maxHeaderBytes) {
                                            LOG.warn("URI is too large >" + this._maxHeaderBytes, new Object[0]);
                                            throw new BadMessageException(414);
                                        }
                                    }
                                    this._uri.append(array, p - 1, len + 1);
                                    buffer.position(i2 - buffer.arrayOffset());
                                    break;
                                }
                            } else if (t.getType() != HttpTokens.Type.DIGIT) {
                                throw new IllegalCharacterException(this._state, t, buffer);
                            } else {
                                setState(State.STATUS);
                                setResponseStatus(t.getByte() - 48);
                                continue;
                            }
                        case HTAB:
                        case OTEXT:
                        default:
                            throw new BadMessageException(400, this._requestHandler != null ? "No URI" : "No Status");
                        case SPACE:
                            break;
                    }
                case STATUS:
                    switch (t.getType()) {
                        case LF:
                            setState(State.HEADER);
                            this._responseHandler.startResponse(this._version, this._responseStatus, null);
                            continue;
                        case DIGIT:
                            this._responseStatus = (this._responseStatus * 10) + (t.getByte() - 48);
                            if (this._responseStatus >= 1000) {
                                throw new BadMessageException("Bad status");
                            }
                            continue;
                        case SPACE:
                            setState(State.SPACE2);
                            continue;
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                    }
                case URI:
                    switch (t.getType()) {
                        case LF:
                            if (complianceViolation(HttpComplianceSection.NO_HTTP_0_9, "No request version")) {
                                throw new BadMessageException(505, "HTTP/0.9 not supported");
                            }
                            this._requestHandler.startRequest(this._methodString, this._uri.toString(), HttpVersion.HTTP_0_9);
                            setState(State.CONTENT);
                            this._endOfContent = HttpTokens.EndOfContent.NO_CONTENT;
                            BufferUtil.clear(buffer);
                            handle = handleHeaderContentMessage();
                            continue;
                        case CR:
                        case HTAB:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case OTEXT:
                        case COLON:
                            this._uri.append(t.getByte());
                            continue;
                        case SPACE:
                            setState(State.SPACE2);
                            continue;
                    }
                case SPACE2:
                    switch (t.getType()) {
                        case LF:
                            if (this._responseHandler == null) {
                                if (!complianceViolation(HttpComplianceSection.NO_HTTP_0_9, "No request version")) {
                                    this._requestHandler.startRequest(this._methodString, this._uri.toString(), HttpVersion.HTTP_0_9);
                                    setState(State.CONTENT);
                                    this._endOfContent = HttpTokens.EndOfContent.NO_CONTENT;
                                    BufferUtil.clear(buffer);
                                    handle = handleHeaderContentMessage();
                                    break;
                                } else {
                                    throw new BadMessageException("HTTP/0.9 not supported");
                                }
                            } else {
                                setState(State.HEADER);
                                this._responseHandler.startResponse(this._version, this._responseStatus, null);
                                continue;
                            }
                        case CR:
                        case HTAB:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case COLON:
                            this._string.setLength(0);
                            this._string.append(t.getChar());
                            if (this._responseHandler == null) {
                                setState(State.REQUEST_VERSION);
                                if (buffer.position() <= 0 || !buffer.hasArray()) {
                                    version = HttpVersion.CACHE.getBest(buffer, 0, buffer.remaining());
                                } else {
                                    version = HttpVersion.lookAheadGet(buffer.array(), (buffer.arrayOffset() + buffer.position()) - 1, buffer.arrayOffset() + buffer.limit());
                                }
                                if (version != null && (pos = (buffer.position() + version.asString().length()) - 1) < buffer.limit()) {
                                    byte n = buffer.get(pos);
                                    if (n != 13) {
                                        if (n != 10) {
                                            break;
                                        } else {
                                            this._version = version;
                                            checkVersion();
                                            this._string.setLength(0);
                                            buffer.position(pos);
                                            break;
                                        }
                                    } else {
                                        this._cr = true;
                                        this._version = version;
                                        checkVersion();
                                        this._string.setLength(0);
                                        buffer.position(pos + 1);
                                        break;
                                    }
                                }
                            } else {
                                this._length = 1;
                                setState(State.REASON);
                                continue;
                            }
                            break;
                        case SPACE:
                            break;
                    }
                case REQUEST_VERSION:
                    switch (t.getType()) {
                        case LF:
                            if (this._version == null) {
                                this._length = this._string.length();
                                this._version = HttpVersion.CACHE.get(takeString());
                            }
                            checkVersion();
                            setState(State.HEADER);
                            this._requestHandler.startRequest(this._methodString, this._uri.toString(), this._version);
                            continue;
                        case CR:
                        case HTAB:
                        case SPACE:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case COLON:
                            this._string.append(t.getChar());
                            continue;
                    }
                case REASON:
                    switch (t.getType()) {
                        case LF:
                            String reason = takeString();
                            setState(State.HEADER);
                            this._responseHandler.startResponse(this._version, this._responseStatus, reason);
                            continue;
                        case CR:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case OTEXT:
                        case COLON:
                            this._string.append(t.getChar());
                            this._length = this._string.length();
                            continue;
                        case HTAB:
                        case SPACE:
                            this._string.append(t.getChar());
                            continue;
                    }
                default:
                    throw new IllegalStateException(this._state.toString());
            }
        }
        return handle;
    }

    private void checkVersion() {
        if (this._version == null) {
            throw new BadMessageException(505, "Unknown Version");
        } else if (this._version.getVersion() < 10 || this._version.getVersion() > 20) {
            throw new BadMessageException(505, "Unsupported Version");
        }
    }

    private void parsedHeader() {
        Trie<HttpField> trie;
        if (!(this._headerString == null && this._valueString == null)) {
            if (this._header != null) {
                boolean addToFieldCache = false;
                switch (this._header) {
                    case CONTENT_LENGTH:
                        if (!this._hasTransferEncoding || !complianceViolation(HttpComplianceSection.TRANSFER_ENCODING_WITH_CONTENT_LENGTH)) {
                            if (this._hasContentLength) {
                                if (complianceViolation(HttpComplianceSection.MULTIPLE_CONTENT_LENGTHS)) {
                                    throw new BadMessageException(400, HttpComplianceSection.MULTIPLE_CONTENT_LENGTHS.description);
                                } else if (convertContentLength(this._valueString) != this._contentLength) {
                                    throw new BadMessageException(400, HttpComplianceSection.MULTIPLE_CONTENT_LENGTHS.description);
                                }
                            }
                            this._hasContentLength = true;
                            if (this._endOfContent != HttpTokens.EndOfContent.CHUNKED_CONTENT) {
                                this._contentLength = convertContentLength(this._valueString);
                                if (this._contentLength <= 0) {
                                    this._endOfContent = HttpTokens.EndOfContent.NO_CONTENT;
                                    break;
                                } else {
                                    this._endOfContent = HttpTokens.EndOfContent.CONTENT_LENGTH;
                                    break;
                                }
                            }
                        } else {
                            throw new BadMessageException(400, "Transfer-Encoding and Content-Length");
                        }
                        break;
                    case TRANSFER_ENCODING:
                        this._hasTransferEncoding = true;
                        if (this._hasContentLength && complianceViolation(HttpComplianceSection.TRANSFER_ENCODING_WITH_CONTENT_LENGTH)) {
                            throw new BadMessageException(400, "Transfer-Encoding and Content-Length");
                        } else if (this._endOfContent != HttpTokens.EndOfContent.CHUNKED_CONTENT) {
                            if (HttpHeaderValue.CHUNKED.m41is(this._valueString)) {
                                this._endOfContent = HttpTokens.EndOfContent.CHUNKED_CONTENT;
                                this._contentLength = -1;
                                break;
                            } else {
                                List<String> values = new QuotedCSV(this._valueString).getValues();
                                int chunked = -1;
                                int len = values.size();
                                for (int i = 0; i < len; i++) {
                                    if (HttpHeaderValue.CHUNKED.m41is(values.get(i))) {
                                        if (chunked != -1) {
                                            throw new BadMessageException(400, "Bad Transfer-Encoding, multiple chunked tokens");
                                        }
                                        chunked = i;
                                        this._endOfContent = HttpTokens.EndOfContent.CHUNKED_CONTENT;
                                        this._contentLength = -1;
                                    } else if (this._endOfContent == HttpTokens.EndOfContent.CHUNKED_CONTENT) {
                                        throw new BadMessageException(400, "Bad Transfer-Encoding, chunked not last");
                                    }
                                }
                                break;
                            }
                        } else {
                            throw new BadMessageException(400, "Bad Transfer-Encoding, chunked not last");
                        }
                        break;
                    case HOST:
                        this._host = true;
                        if (!(this._field instanceof HostPortHttpField) && this._valueString != null && !this._valueString.isEmpty()) {
                            this._field = new HostPortHttpField(this._header, this._compliances.contains(HttpComplianceSection.FIELD_NAME_CASE_INSENSITIVE) ? this._header.asString() : this._headerString, this._valueString);
                            addToFieldCache = true;
                            break;
                        }
                        break;
                    case CONNECTION:
                        if (this._field == null) {
                            this._field = new HttpField(this._header, caseInsensitiveHeader(this._headerString, this._header.asString()), this._valueString);
                        }
                        if (this._handler.getHeaderCacheSize() > 0 && this._field.contains(HttpHeaderValue.CLOSE.asString())) {
                            this._fieldCache = NO_CACHE;
                            break;
                        }
                        break;
                    case AUTHORIZATION:
                    case ACCEPT:
                    case ACCEPT_CHARSET:
                    case ACCEPT_ENCODING:
                    case ACCEPT_LANGUAGE:
                    case COOKIE:
                    case CACHE_CONTROL:
                    case USER_AGENT:
                        addToFieldCache = this._field == null;
                        break;
                }
                if (!(!addToFieldCache || this._header == null || this._valueString == null)) {
                    if (this._fieldCache == null) {
                        if (this._handler.getHeaderCacheSize() <= 0 || this._version == null || this._version != HttpVersion.HTTP_1_1) {
                            trie = NO_CACHE;
                        } else {
                            trie = new ArrayTernaryTrie<>(this._handler.getHeaderCacheSize());
                        }
                        this._fieldCache = trie;
                    }
                    if (!this._fieldCache.isFull()) {
                        if (this._field == null) {
                            this._field = new HttpField(this._header, caseInsensitiveHeader(this._headerString, this._header.asString()), this._valueString);
                        }
                        this._fieldCache.put(this._field);
                    }
                }
            }
            this._handler.parsedHeader(this._field != null ? this._field : new HttpField(this._header, this._headerString, this._valueString));
        }
        this._valueString = null;
        this._headerString = null;
        this._header = null;
        this._field = null;
    }

    private void parsedTrailer() {
        if (!(this._headerString == null && this._valueString == null)) {
            this._handler.parsedTrailer(this._field != null ? this._field : new HttpField(this._header, this._headerString, this._valueString));
        }
        this._valueString = null;
        this._headerString = null;
        this._header = null;
        this._field = null;
    }

    private long convertContentLength(String valueString) {
        try {
            return Long.parseLong(valueString);
        } catch (NumberFormatException e) {
            LOG.ignore(e);
            throw new BadMessageException(400, "Invalid Content-Length Value", e);
        }
    }

    protected boolean parseFields(ByteBuffer buffer) {
        HttpTokens.Token t;
        int i;
        while (true) {
            if ((this._state != State.HEADER && this._state != State.TRAILER) || !buffer.hasRemaining() || (t = next(buffer)) == null) {
                return false;
            }
            if (this._maxHeaderBytes > 0) {
                int i2 = this._headerBytes + 1;
                this._headerBytes = i2;
                if (i2 > this._maxHeaderBytes) {
                    boolean header = this._state == State.HEADER;
                    Logger logger = LOG;
                    Object[] objArr = new Object[3];
                    objArr[0] = header ? "Header" : "Trailer";
                    objArr[1] = Integer.valueOf(this._headerBytes);
                    objArr[2] = Integer.valueOf(this._maxHeaderBytes);
                    logger.warn("{} is too large {}>{}", objArr);
                    if (header) {
                        i = HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE_431;
                    } else {
                        i = 413;
                    }
                    throw new BadMessageException(i);
                }
            }
            switch (this._fieldState) {
                case FIELD:
                    switch (t.getType()) {
                        case LF:
                            if (this._state == State.HEADER) {
                                parsedHeader();
                            } else {
                                parsedTrailer();
                            }
                            this._contentPosition = 0;
                            if (this._state == State.TRAILER) {
                                setState(State.END);
                                return this._handler.messageComplete();
                            } else if (this._hasTransferEncoding && this._endOfContent != HttpTokens.EndOfContent.CHUNKED_CONTENT && (this._responseHandler == null || this._endOfContent != HttpTokens.EndOfContent.EOF_CONTENT)) {
                                throw new BadMessageException(400, "Bad Transfer-Encoding, chunked not last");
                            } else if (this._host || this._version != HttpVersion.HTTP_1_1 || this._requestHandler == null) {
                                if (this._responseHandler != null && (this._responseStatus == 304 || this._responseStatus == 204 || this._responseStatus < 200)) {
                                    this._endOfContent = HttpTokens.EndOfContent.NO_CONTENT;
                                } else if (this._endOfContent == HttpTokens.EndOfContent.UNKNOWN_CONTENT) {
                                    if (this._responseStatus == 0 || this._responseStatus == 304 || this._responseStatus == 204 || this._responseStatus < 200) {
                                        this._endOfContent = HttpTokens.EndOfContent.NO_CONTENT;
                                    } else {
                                        this._endOfContent = HttpTokens.EndOfContent.EOF_CONTENT;
                                    }
                                }
                                switch (this._endOfContent) {
                                    case EOF_CONTENT:
                                        setState(State.EOF_CONTENT);
                                        boolean handle = this._handler.headerComplete();
                                        this._headerComplete = true;
                                        return handle;
                                    case CHUNKED_CONTENT:
                                        setState(State.CHUNKED_CONTENT);
                                        boolean handle2 = this._handler.headerComplete();
                                        this._headerComplete = true;
                                        return handle2;
                                    default:
                                        setState(State.CONTENT);
                                        boolean handle3 = this._handler.headerComplete();
                                        this._headerComplete = true;
                                        return handle3;
                                }
                            } else {
                                throw new BadMessageException(400, "No Host");
                            }
                        case CR:
                        case VCHAR:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                            if (this._state == State.HEADER) {
                                parsedHeader();
                            } else {
                                parsedTrailer();
                            }
                            if (buffer.hasRemaining()) {
                                HttpField cachedField = this._fieldCache == null ? null : this._fieldCache.getBest(buffer, -1, buffer.remaining());
                                if (cachedField == null) {
                                    cachedField = CACHE.getBest(buffer, -1, buffer.remaining());
                                }
                                if (cachedField != null) {
                                    String n = cachedField.getName();
                                    String v = cachedField.getValue();
                                    if (!this._compliances.contains(HttpComplianceSection.FIELD_NAME_CASE_INSENSITIVE)) {
                                        String en = BufferUtil.toString(buffer, buffer.position() - 1, n.length(), StandardCharsets.US_ASCII);
                                        if (!n.equals(en)) {
                                            handleViolation(HttpComplianceSection.FIELD_NAME_CASE_INSENSITIVE, en);
                                            n = en;
                                            cachedField = new HttpField(cachedField.getHeader(), n, v);
                                        }
                                    }
                                    if (v != null && !this._compliances.contains(HttpComplianceSection.CASE_INSENSITIVE_FIELD_VALUE_CACHE)) {
                                        String ev = BufferUtil.toString(buffer, buffer.position() + n.length() + 1, v.length(), StandardCharsets.ISO_8859_1);
                                        if (!v.equals(ev)) {
                                            handleViolation(HttpComplianceSection.CASE_INSENSITIVE_FIELD_VALUE_CACHE, ev + "!=" + v);
                                            v = ev;
                                            cachedField = new HttpField(cachedField.getHeader(), n, v);
                                        }
                                    }
                                    this._header = cachedField.getHeader();
                                    this._headerString = n;
                                    if (v != null) {
                                        int pos = buffer.position() + n.length() + v.length() + 1;
                                        byte peek = buffer.get(pos);
                                        if (peek != 13 && peek != 10) {
                                            setState(FieldState.IN_VALUE);
                                            setString(v);
                                            buffer.position(pos);
                                            break;
                                        } else {
                                            this._field = cachedField;
                                            this._valueString = v;
                                            setState(FieldState.IN_VALUE);
                                            if (peek != 13) {
                                                buffer.position(pos);
                                                break;
                                            } else {
                                                this._cr = true;
                                                buffer.position(pos + 1);
                                                break;
                                            }
                                        }
                                    } else {
                                        setState(FieldState.VALUE);
                                        this._string.setLength(0);
                                        this._length = 0;
                                        buffer.position(buffer.position() + n.length() + 1);
                                        continue;
                                    }
                                }
                            }
                            setState(FieldState.IN_NAME);
                            this._string.setLength(0);
                            this._string.append(t.getChar());
                            this._length = 1;
                            break;
                        case HTAB:
                        case SPACE:
                        case COLON:
                            if (complianceViolation(HttpComplianceSection.NO_FIELD_FOLDING, this._headerString)) {
                                throw new BadMessageException(400, "Header Folding");
                            }
                            if (StringUtil.isEmpty(this._valueString)) {
                                this._string.setLength(0);
                                this._length = 0;
                            } else {
                                setString(this._valueString);
                                this._string.append(' ');
                                this._length++;
                                this._valueString = null;
                            }
                            setState(FieldState.VALUE);
                            continue;
                    }
                case IN_NAME:
                    switch (t.getType()) {
                        case LF:
                            this._headerString = takeString();
                            this._header = HttpHeader.CACHE.get(this._headerString);
                            this._string.setLength(0);
                            this._valueString = "";
                            this._length = -1;
                            if (!complianceViolation(HttpComplianceSection.FIELD_COLON, this._headerString)) {
                                setState(FieldState.FIELD);
                                continue;
                            } else {
                                throw new IllegalCharacterException(this._state, t, buffer);
                            }
                        case CR:
                        case VCHAR:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                            this._string.append(t.getChar());
                            this._length = this._string.length();
                            continue;
                        case HTAB:
                        case SPACE:
                            if (!complianceViolation(HttpComplianceSection.NO_WS_AFTER_FIELD_NAME, null)) {
                                this._headerString = takeString();
                                this._header = HttpHeader.CACHE.get(this._headerString);
                                this._length = -1;
                                setState(FieldState.WS_AFTER_NAME);
                                continue;
                            } else {
                                throw new IllegalCharacterException(this._state, t, buffer);
                            }
                        case COLON:
                            this._headerString = takeString();
                            this._header = HttpHeader.CACHE.get(this._headerString);
                            this._length = -1;
                            setState(FieldState.VALUE);
                            continue;
                    }
                case WS_AFTER_NAME:
                    switch (t.getType()) {
                        case LF:
                            if (!complianceViolation(HttpComplianceSection.FIELD_COLON, this._headerString)) {
                                setState(FieldState.FIELD);
                                continue;
                            } else {
                                throw new IllegalCharacterException(this._state, t, buffer);
                            }
                        case CR:
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case HTAB:
                        case SPACE:
                            break;
                        case COLON:
                            setState(FieldState.VALUE);
                            continue;
                    }
                case VALUE:
                    switch (t.getType()) {
                        case LF:
                            this._string.setLength(0);
                            this._valueString = "";
                            this._length = -1;
                            setState(FieldState.FIELD);
                            continue;
                        case CR:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case OTEXT:
                        case COLON:
                            this._string.append(t.getChar());
                            this._length = this._string.length();
                            setState(FieldState.IN_VALUE);
                            continue;
                        case HTAB:
                        case SPACE:
                            break;
                    }
                case IN_VALUE:
                    switch (t.getType()) {
                        case LF:
                            if (this._length > 0) {
                                this._valueString = takeString();
                                this._length = -1;
                            }
                            setState(FieldState.FIELD);
                            continue;
                        case CR:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                        case VCHAR:
                        case OTEXT:
                        case COLON:
                            this._string.append(t.getChar());
                            this._length = this._string.length();
                            continue;
                        case HTAB:
                        case SPACE:
                            this._string.append(t.getChar());
                            continue;
                    }
                default:
                    throw new IllegalStateException(this._state.toString());
            }
        }
    }

    public boolean parseNext(ByteBuffer buffer) {
        if (this.debug) {
            LOG.debug("parseNext s={} {}", this._state, BufferUtil.toDetailString(buffer));
        }
        try {
            if (this._state == State.START) {
                this._version = null;
                this._method = null;
                this._methodString = null;
                this._endOfContent = HttpTokens.EndOfContent.UNKNOWN_CONTENT;
                this._header = null;
                if (quickStart(buffer)) {
                    return true;
                }
            }
            if (this._state.ordinal() >= State.START.ordinal() && this._state.ordinal() < State.HEADER.ordinal() && parseLine(buffer)) {
                return true;
            }
            if (this._state == State.HEADER && parseFields(buffer)) {
                return true;
            }
            if (this._state.ordinal() >= State.CONTENT.ordinal() && this._state.ordinal() < State.TRAILER.ordinal()) {
                if (this._responseStatus <= 0 || !this._headResponse) {
                    if (parseContent(buffer)) {
                        return true;
                    }
                } else if (this._state != State.CONTENT_END) {
                    setState(State.CONTENT_END);
                    return handleContentMessage();
                } else {
                    setState(State.END);
                    return this._handler.messageComplete();
                }
            }
            if (this._state == State.TRAILER && parseFields(buffer)) {
                return true;
            }
            if (this._state == State.END) {
                int whiteSpace = 0;
                while (buffer.remaining() > 0 && ((b = buffer.get(buffer.position())) == 13 || b == 10)) {
                    buffer.get();
                    whiteSpace++;
                }
                if (this.debug && whiteSpace > 0) {
                    LOG.debug("Discarded {} CR or LF characters", (long) whiteSpace);
                }
            } else if (isTerminated()) {
                BufferUtil.clear(buffer);
            }
            if (isAtEOF() && !buffer.hasRemaining()) {
                switch (this._state) {
                    case CLOSED:
                        break;
                    case END:
                    case CLOSE:
                        setState(State.CLOSED);
                        break;
                    case EOF_CONTENT:
                    case TRAILER:
                        if (this._fieldState != FieldState.FIELD) {
                            setState(State.CLOSED);
                            this._handler.earlyEOF();
                            break;
                        } else {
                            setState(State.CONTENT_END);
                            boolean handle = handleContentMessage();
                            if (handle && this._state == State.CONTENT_END) {
                                return true;
                            }
                            setState(State.CLOSED);
                            return handle;
                        }
                    case START:
                    case CONTENT:
                    case CHUNKED_CONTENT:
                    case CHUNK_SIZE:
                    case CHUNK_PARAMS:
                    case CHUNK:
                        setState(State.CLOSED);
                        this._handler.earlyEOF();
                        break;
                    default:
                        if (this.debug) {
                            LOG.debug("{} EOF in {}", this, this._state);
                        }
                        setState(State.CLOSED);
                        this._handler.badMessage(new BadMessageException(400));
                        break;
                }
            }
            return false;
        } catch (BadMessageException x) {
            BufferUtil.clear(buffer);
            badMessage(x);
            return false;
        } catch (Throwable x2) {
            BufferUtil.clear(buffer);
            badMessage(new BadMessageException(400, this._requestHandler != null ? "Bad Request" : "Bad Response", x2));
            return false;
        }
    }

    protected void badMessage(BadMessageException x) {
        if (this.debug) {
            LOG.debug("Parse exception: " + this + " for " + this._handler, x);
        }
        setState(State.CLOSE);
        if (this._headerComplete) {
            this._handler.earlyEOF();
        } else {
            this._handler.badMessage(x);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x039a, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean parseContent(java.nio.ByteBuffer r8) {
        /*
        // Method dump skipped, instructions count: 932
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.HttpParser.parseContent(java.nio.ByteBuffer):boolean");
    }

    public boolean isAtEOF() {
        return this._eof;
    }

    public void atEOF() {
        if (this.debug) {
            LOG.debug("atEOF {}", this);
        }
        this._eof = true;
    }

    public void close() {
        if (this.debug) {
            LOG.debug("close {}", this);
        }
        setState(State.CLOSE);
    }

    public void reset() {
        if (this.debug) {
            LOG.debug("reset {}", this);
        }
        if (this._state != State.CLOSE && this._state != State.CLOSED) {
            setState(State.START);
            this._endOfContent = HttpTokens.EndOfContent.UNKNOWN_CONTENT;
            this._contentLength = -1;
            this._hasContentLength = false;
            this._hasTransferEncoding = false;
            this._contentPosition = 0;
            this._responseStatus = 0;
            this._contentChunk = null;
            this._headerBytes = 0;
            this._host = false;
            this._headerComplete = false;
        }
    }

    protected void setState(State state) {
        if (this.debug) {
            LOG.debug("{} --> {}", this._state, state);
        }
        this._state = state;
    }

    protected void setState(FieldState state) {
        if (this.debug) {
            Logger logger = LOG;
            Object[] objArr = new Object[3];
            objArr[0] = this._state;
            objArr[1] = this._field != null ? this._field : this._headerString != null ? this._headerString : this._string;
            objArr[2] = state;
            logger.debug("{}:{} --> {}", objArr);
        }
        this._fieldState = state;
    }

    public Trie<HttpField> getFieldCache() {
        return this._fieldCache;
    }

    public String toString() {
        return String.format("%s{s=%s,%d of %d}", getClass().getSimpleName(), this._state, Long.valueOf(getContentRead()), Long.valueOf(getContentLength()));
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$HttpHandler.class */
    public interface HttpHandler {
        boolean content(ByteBuffer byteBuffer);

        boolean headerComplete();

        boolean contentComplete();

        boolean messageComplete();

        void parsedHeader(HttpField httpField);

        void earlyEOF();

        int getHeaderCacheSize();

        default void parsedTrailer(HttpField field) {
        }

        default void badMessage(BadMessageException failure) {
            badMessage(failure.getCode(), failure.getReason());
        }

        @Deprecated
        default void badMessage(int status, String reason) {
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$ComplianceHandler.class */
    public interface ComplianceHandler extends HttpHandler {
        @Deprecated
        default void onComplianceViolation(HttpCompliance compliance, HttpCompliance required, String reason) {
        }

        default void onComplianceViolation(HttpCompliance compliance, HttpComplianceSection violation, String details) {
            onComplianceViolation(compliance, HttpCompliance.requiredCompliance(violation), details);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpParser$IllegalCharacterException.class */
    public static class IllegalCharacterException extends BadMessageException {
        private IllegalCharacterException(State state, HttpTokens.Token token, ByteBuffer buffer) {
            super(400, String.format("Illegal character %s", token));
            if (HttpParser.LOG.isDebugEnabled()) {
                HttpParser.LOG.debug(String.format("Illegal character %s in state=%s for buffer %s", token, state, BufferUtil.toDetailString(buffer)), new Object[0]);
            }
        }
    }
}
