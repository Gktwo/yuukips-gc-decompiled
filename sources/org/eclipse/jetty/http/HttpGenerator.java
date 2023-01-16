package org.eclipse.jetty.http;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.HttpTokens;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.util.ArrayTrie;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpGenerator.class */
public class HttpGenerator {
    public static final int CHUNK_SIZE = 12;
    private State _state;
    private HttpTokens.EndOfContent _endOfContent;
    private long _contentPrepared;
    private boolean _noContentResponse;
    private Boolean _persistent;
    private Supplier<HttpFields> _trailers;
    private final int _send;
    private static final int SEND_SERVER = 1;
    private static final int SEND_XPOWEREDBY = 2;
    private boolean _needCRLF;
    private static final Logger LOG = Log.getLogger(HttpGenerator.class);
    public static final boolean __STRICT = Boolean.getBoolean("org.eclipse.jetty.http.HttpGenerator.STRICT");
    private static final byte[] __colon_space = {58, 32};
    public static final MetaData.Response CONTINUE_100_INFO = new MetaData.Response(HttpVersion.HTTP_1_1, 100, null, null, -1);
    public static final MetaData.Response PROGRESS_102_INFO = new MetaData.Response(HttpVersion.HTTP_1_1, 102, null, null, -1);
    public static final MetaData.Response RESPONSE_500_INFO = new MetaData.Response(HttpVersion.HTTP_1_1, 500, null, new HttpFields() { // from class: org.eclipse.jetty.http.HttpGenerator.1
        {
            put(HttpHeader.CONNECTION, HttpHeaderValue.CLOSE);
        }
    }, 0);
    private static final Trie<Boolean> ASSUMED_CONTENT_METHODS = new ArrayTrie(8);
    private static final byte[] ZERO_CHUNK = {48, 13, 10};
    private static final byte[] LAST_CHUNK = {48, 13, 10, 13, 10};
    private static final byte[] CONTENT_LENGTH_0 = StringUtil.getBytes("Content-Length: 0\r\n");
    private static final byte[] CONNECTION_CLOSE = StringUtil.getBytes("Connection: close\r\n");
    private static final byte[] HTTP_1_1_SPACE = StringUtil.getBytes(HttpVersion.HTTP_1_1 + " ");
    private static final byte[] TRANSFER_ENCODING_CHUNKED = StringUtil.getBytes("Transfer-Encoding: chunked\r\n");
    private static final byte[][] SEND = {new byte[0], StringUtil.getBytes("Server: Jetty(9.x.x)\r\n"), StringUtil.getBytes("X-Powered-By: Jetty(9.x.x)\r\n"), StringUtil.getBytes("Server: Jetty(9.x.x)\r\nX-Powered-By: Jetty(9.x.x)\r\n")};
    private static final PreparedResponse[] __preprepared = new PreparedResponse[512];

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpGenerator$Result.class */
    public enum Result {
        NEED_CHUNK,
        NEED_INFO,
        NEED_HEADER,
        HEADER_OVERFLOW,
        NEED_CHUNK_TRAILER,
        FLUSH,
        CONTINUE,
        SHUTDOWN_OUT,
        DONE
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpGenerator$State.class */
    public enum State {
        START,
        COMMITTED,
        COMPLETING,
        COMPLETING_1XX,
        END
    }

    static {
        ASSUMED_CONTENT_METHODS.put(HttpMethod.POST.asString(), Boolean.TRUE);
        ASSUMED_CONTENT_METHODS.put(HttpMethod.PUT.asString(), Boolean.TRUE);
        int versionLength = HttpVersion.HTTP_1_1.toString().length();
        for (int i = 0; i < __preprepared.length; i++) {
            HttpStatus.Code code = HttpStatus.getCode(i);
            if (code != null) {
                String reason = code.getMessage();
                byte[] line = new byte[versionLength + 5 + reason.length() + 2];
                HttpVersion.HTTP_1_1.toBuffer().get(line, 0, versionLength);
                line[versionLength + 0] = 32;
                line[versionLength + 1] = (byte) (48 + (i / 100));
                line[versionLength + 2] = (byte) (48 + ((i % 100) / 10));
                line[versionLength + 3] = (byte) (48 + (i % 10));
                line[versionLength + 4] = 32;
                for (int j = 0; j < reason.length(); j++) {
                    line[versionLength + 5 + j] = (byte) reason.charAt(j);
                }
                line[versionLength + 5 + reason.length()] = 13;
                line[versionLength + 6 + reason.length()] = 10;
                __preprepared[i] = new PreparedResponse();
                __preprepared[i]._schemeCode = Arrays.copyOfRange(line, 0, versionLength + 5);
                __preprepared[i]._reason = Arrays.copyOfRange(line, versionLength + 5, line.length - 2);
                __preprepared[i]._responseLine = line;
            }
        }
    }

    public static void setJettyVersion(String serverVersion) {
        SEND[1] = StringUtil.getBytes("Server: " + serverVersion + "\r\n");
        SEND[2] = StringUtil.getBytes("X-Powered-By: " + serverVersion + "\r\n");
        SEND[3] = StringUtil.getBytes("Server: " + serverVersion + "\r\nX-Powered-By: " + serverVersion + "\r\n");
    }

    public HttpGenerator() {
        this(false, false);
    }

    public HttpGenerator(boolean sendServerVersion, boolean sendXPoweredBy) {
        this._state = State.START;
        this._endOfContent = HttpTokens.EndOfContent.UNKNOWN_CONTENT;
        this._contentPrepared = 0;
        this._noContentResponse = false;
        this._persistent = null;
        this._trailers = null;
        this._needCRLF = false;
        this._send = (sendServerVersion ? 1 : 0) | (sendXPoweredBy ? 2 : 0);
    }

    public void reset() {
        this._state = State.START;
        this._endOfContent = HttpTokens.EndOfContent.UNKNOWN_CONTENT;
        this._noContentResponse = false;
        this._persistent = null;
        this._contentPrepared = 0;
        this._needCRLF = false;
        this._trailers = null;
    }

    @Deprecated
    public boolean getSendServerVersion() {
        return (this._send & 1) != 0;
    }

    @Deprecated
    public void setSendServerVersion(boolean sendServerVersion) {
        throw new UnsupportedOperationException();
    }

    public State getState() {
        return this._state;
    }

    public boolean isState(State state) {
        return this._state == state;
    }

    public boolean isIdle() {
        return this._state == State.START;
    }

    public boolean isEnd() {
        return this._state == State.END;
    }

    public boolean isCommitted() {
        return this._state.ordinal() >= State.COMMITTED.ordinal();
    }

    public boolean isChunking() {
        return this._endOfContent == HttpTokens.EndOfContent.CHUNKED_CONTENT;
    }

    public boolean isNoContent() {
        return this._noContentResponse;
    }

    public void setPersistent(boolean persistent) {
        this._persistent = Boolean.valueOf(persistent);
    }

    public boolean isPersistent() {
        return Boolean.TRUE.equals(this._persistent);
    }

    public boolean isWritten() {
        return this._contentPrepared > 0;
    }

    public long getContentPrepared() {
        return this._contentPrepared;
    }

    public void abort() {
        this._persistent = false;
        this._state = State.END;
        this._endOfContent = null;
    }

    public Result generateRequest(MetaData.Request info, ByteBuffer header, ByteBuffer chunk, ByteBuffer content, boolean last) throws IOException {
        int pos;
        switch (this._state) {
            case START:
                if (info == null) {
                    return Result.NEED_INFO;
                }
                if (header == null) {
                    return Result.NEED_HEADER;
                }
                try {
                    pos = BufferUtil.flipToFill(header);
                    try {
                        generateRequestLine(info, header);
                        if (info.getHttpVersion() == HttpVersion.HTTP_0_9) {
                            throw new BadMessageException(500, "HTTP/0.9 not supported");
                        }
                        generateHeaders(info, header, content, last);
                        if (info.getFields().contains(HttpHeader.EXPECT, HttpHeaderValue.CONTINUE.asString())) {
                            this._state = State.COMMITTED;
                        } else {
                            int len = BufferUtil.length(content);
                            if (len > 0) {
                                this._contentPrepared += (long) len;
                                if (isChunking()) {
                                    prepareChunk(header, len);
                                }
                            }
                            this._state = last ? State.COMPLETING : State.COMMITTED;
                        }
                        Result result = Result.FLUSH;
                        BufferUtil.flipToFlush(header, pos);
                        return result;
                    } catch (BufferOverflowException e) {
                        LOG.ignore(e);
                        Result result2 = Result.HEADER_OVERFLOW;
                        BufferUtil.flipToFlush(header, pos);
                        return result2;
                    } catch (BadMessageException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new BadMessageException(500, e3.getMessage(), e3);
                    }
                } catch (Throwable th) {
                    BufferUtil.flipToFlush(header, pos);
                    throw th;
                }
            case COMMITTED:
                return committed(chunk, content, last);
            case COMPLETING:
                return completing(chunk, content);
            case END:
                if (BufferUtil.hasContent(content)) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("discarding content in COMPLETING", new Object[0]);
                    }
                    BufferUtil.clear(content);
                }
                return Result.DONE;
            default:
                throw new IllegalStateException();
        }
    }

    private Result committed(ByteBuffer chunk, ByteBuffer content, boolean last) {
        int len = BufferUtil.length(content);
        if (len > 0) {
            if (isChunking()) {
                if (chunk == null) {
                    return Result.NEED_CHUNK;
                }
                BufferUtil.clearToFill(chunk);
                prepareChunk(chunk, len);
                BufferUtil.flipToFlush(chunk, 0);
            }
            this._contentPrepared += (long) len;
        }
        if (!last) {
            return len > 0 ? Result.FLUSH : Result.DONE;
        }
        this._state = State.COMPLETING;
        return len > 0 ? Result.FLUSH : Result.CONTINUE;
    }

    private Result completing(ByteBuffer chunk, ByteBuffer content) {
        if (BufferUtil.hasContent(content)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("discarding content in COMPLETING", new Object[0]);
            }
            BufferUtil.clear(content);
        }
        if (isChunking()) {
            if (this._trailers != null) {
                if (chunk == null || chunk.capacity() <= 12) {
                    return Result.NEED_CHUNK_TRAILER;
                }
                HttpFields trailers = this._trailers.get();
                if (trailers != null) {
                    BufferUtil.clearToFill(chunk);
                    generateTrailers(chunk, trailers);
                    BufferUtil.flipToFlush(chunk, 0);
                    this._endOfContent = HttpTokens.EndOfContent.UNKNOWN_CONTENT;
                    return Result.FLUSH;
                }
            }
            if (chunk == null) {
                return Result.NEED_CHUNK;
            }
            BufferUtil.clearToFill(chunk);
            prepareChunk(chunk, 0);
            BufferUtil.flipToFlush(chunk, 0);
            this._endOfContent = HttpTokens.EndOfContent.UNKNOWN_CONTENT;
            return Result.FLUSH;
        }
        this._state = State.END;
        return Boolean.TRUE.equals(this._persistent) ? Result.DONE : Result.SHUTDOWN_OUT;
    }

    @Deprecated
    public Result generateResponse(MetaData.Response info, ByteBuffer header, ByteBuffer chunk, ByteBuffer content, boolean last) throws IOException {
        return generateResponse(info, false, header, chunk, content, last);
    }

    public Result generateResponse(MetaData.Response info, boolean head, ByteBuffer header, ByteBuffer chunk, ByteBuffer content, boolean last) throws IOException {
        int pos;
        switch (this._state) {
            case START:
                if (info == null) {
                    return Result.NEED_INFO;
                }
                HttpVersion version = info.getHttpVersion();
                if (version == null) {
                    throw new BadMessageException(500, "No version");
                } else if (version == HttpVersion.HTTP_0_9) {
                    this._persistent = false;
                    this._endOfContent = HttpTokens.EndOfContent.EOF_CONTENT;
                    if (BufferUtil.hasContent(content)) {
                        this._contentPrepared += (long) content.remaining();
                    }
                    this._state = last ? State.COMPLETING : State.COMMITTED;
                    return Result.FLUSH;
                } else if (header == null) {
                    return Result.NEED_HEADER;
                } else {
                    try {
                        pos = BufferUtil.flipToFill(header);
                        try {
                            try {
                                try {
                                    generateResponseLine(info, header);
                                    int status = info.getStatus();
                                    if (status >= 100 && status < 200) {
                                        this._noContentResponse = true;
                                        if (status != 101) {
                                            header.put(HttpTokens.CRLF);
                                            this._state = State.COMPLETING_1XX;
                                            Result result = Result.FLUSH;
                                            BufferUtil.flipToFlush(header, pos);
                                            return result;
                                        }
                                    } else if (status == 204 || status == 304) {
                                        this._noContentResponse = true;
                                    }
                                    generateHeaders(info, header, content, last);
                                    int len = BufferUtil.length(content);
                                    if (len > 0) {
                                        this._contentPrepared += (long) len;
                                        if (isChunking() && !head) {
                                            prepareChunk(header, len);
                                        }
                                    }
                                    this._state = last ? State.COMPLETING : State.COMMITTED;
                                    BufferUtil.flipToFlush(header, pos);
                                    return Result.FLUSH;
                                } catch (Exception e) {
                                    throw new BadMessageException(500, e.getMessage(), e);
                                }
                            } catch (BadMessageException e2) {
                                throw e2;
                            }
                        } catch (BufferOverflowException e3) {
                            LOG.ignore(e3);
                            Result result2 = Result.HEADER_OVERFLOW;
                            BufferUtil.flipToFlush(header, pos);
                            return result2;
                        }
                    } catch (Throwable th) {
                        BufferUtil.flipToFlush(header, pos);
                        throw th;
                    }
                }
            case COMMITTED:
                return committed(chunk, content, last);
            case COMPLETING:
                return completing(chunk, content);
            case END:
                if (BufferUtil.hasContent(content)) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("discarding content in COMPLETING", new Object[0]);
                    }
                    BufferUtil.clear(content);
                }
                return Result.DONE;
            case COMPLETING_1XX:
                reset();
                return Result.DONE;
            default:
                throw new IllegalStateException();
        }
    }

    private void prepareChunk(ByteBuffer chunk, int remaining) {
        if (this._needCRLF) {
            BufferUtil.putCRLF(chunk);
        }
        if (remaining > 0) {
            BufferUtil.putHexInt(chunk, remaining);
            BufferUtil.putCRLF(chunk);
            this._needCRLF = true;
            return;
        }
        chunk.put(LAST_CHUNK);
        this._needCRLF = false;
    }

    private void generateTrailers(ByteBuffer buffer, HttpFields trailer) {
        if (this._needCRLF) {
            BufferUtil.putCRLF(buffer);
        }
        buffer.put(ZERO_CHUNK);
        int n = trailer.size();
        for (int f = 0; f < n; f++) {
            putTo(trailer.getField(f), buffer);
        }
        BufferUtil.putCRLF(buffer);
    }

    private void generateRequestLine(MetaData.Request request, ByteBuffer header) {
        header.put(StringUtil.getBytes(request.getMethod()));
        header.put((byte) 32);
        header.put(StringUtil.getBytes(request.getURIString()));
        header.put((byte) 32);
        header.put(request.getHttpVersion().toBytes());
        header.put(HttpTokens.CRLF);
    }

    private void generateResponseLine(MetaData.Response response, ByteBuffer header) {
        int status = response.getStatus();
        PreparedResponse preprepared = status < __preprepared.length ? __preprepared[status] : null;
        String reason = response.getReason();
        if (preprepared == null) {
            header.put(HTTP_1_1_SPACE);
            header.put((byte) (48 + (status / 100)));
            header.put((byte) (48 + ((status % 100) / 10)));
            header.put((byte) (48 + (status % 10)));
            header.put((byte) 32);
            if (reason == null) {
                header.put((byte) (48 + (status / 100)));
                header.put((byte) (48 + ((status % 100) / 10)));
                header.put((byte) (48 + (status % 10)));
            } else {
                header.put(getReasonBytes(reason));
            }
            header.put(HttpTokens.CRLF);
        } else if (reason == null) {
            header.put(preprepared._responseLine);
        } else {
            header.put(preprepared._schemeCode);
            header.put(getReasonBytes(reason));
            header.put(HttpTokens.CRLF);
        }
    }

    private byte[] getReasonBytes(String reason) {
        if (reason.length() > 1024) {
            reason = reason.substring(0, 1024);
        }
        byte[] bytes = StringUtil.getBytes(reason);
        int i = bytes.length;
        while (true) {
            i--;
            if (i <= 0) {
                return bytes;
            }
            if (bytes[i] == 13 || bytes[i] == 10) {
                bytes[i] = 63;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:200:0x021e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:198:0x0224 */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    /* JADX WARN: Type inference failed for: r0v191, types: [long] */
    private void generateHeaders(MetaData info, ByteBuffer header, ByteBuffer content, boolean last) {
        MetaData.Request request = info instanceof MetaData.Request ? (MetaData.Request) info : null;
        MetaData.Response response = info instanceof MetaData.Response ? (MetaData.Response) info : null;
        if (LOG.isDebugEnabled()) {
            LOG.debug("generateHeaders {} last={} content={}", info, Boolean.valueOf(last), BufferUtil.toDetailString(content));
            LOG.debug(info.getFields().toString(), new Object[0]);
        }
        int send = this._send;
        HttpField transferEncoding = null;
        boolean http11 = info.getHttpVersion() == HttpVersion.HTTP_1_1;
        boolean close = false;
        this._trailers = http11 ? info.getTrailerSupplier() : null;
        boolean chunkedHint = this._trailers != null;
        boolean contentType = false;
        char contentLength = info.getContentLength();
        boolean contentLengthField = false;
        HttpFields fields = info.getFields();
        if (fields != null) {
            int n = fields.size();
            int f = 0;
            close = false;
            contentType = false;
            contentLength = contentLength;
            contentLengthField = false;
            while (f < n) {
                HttpField field = fields.getField(f);
                HttpHeader h = field.getHeader();
                if (h == null) {
                    putTo(field, header);
                } else {
                    switch (h) {
                        case CONTENT_LENGTH:
                            if (contentLength < 0) {
                                contentLength = field.getLongValue();
                            } else {
                                int i = (contentLength > field.getLongValue() ? 1 : (contentLength == field.getLongValue() ? 0 : -1));
                                contentLength = contentLength;
                                if (i != 0) {
                                    throw new BadMessageException(500, String.format("Incorrect Content-Length %d!=%d", Long.valueOf(contentLength), Long.valueOf(field.getLongValue())));
                                }
                            }
                            contentLengthField = true;
                            continue;
                        case CONTENT_TYPE:
                            contentType = true;
                            putTo(field, header);
                            continue;
                        case TRANSFER_ENCODING:
                            if (http11) {
                                transferEncoding = field;
                                chunkedHint = field.contains(HttpHeaderValue.CHUNKED.asString());
                                break;
                            } else {
                                continue;
                            }
                        case CONNECTION:
                            boolean keepAlive = field.contains(HttpHeaderValue.KEEP_ALIVE.asString());
                            if (keepAlive && info.getHttpVersion() == HttpVersion.HTTP_1_0 && this._persistent == null) {
                                this._persistent = true;
                            }
                            close = close;
                            if (field.contains(HttpHeaderValue.CLOSE.asString())) {
                                close = true;
                                this._persistent = false;
                            }
                            if (keepAlive && Boolean.FALSE.equals(this._persistent)) {
                                field = new HttpField(HttpHeader.CONNECTION, (String) Stream.of((Object[]) field.getValues()).filter(s -> {
                                    return !HttpHeaderValue.KEEP_ALIVE.m41is(s);
                                }).collect(Collectors.joining(", ")));
                            }
                            putTo(field, header);
                            continue;
                        case SERVER:
                            send &= -2;
                            putTo(field, header);
                            continue;
                        default:
                            putTo(field, header);
                            continue;
                    }
                }
                f++;
                close = close;
                contentType = contentType;
                contentLength = contentLength;
                contentLengthField = contentLengthField;
            }
        }
        long contentLength2 = contentLength;
        if (last) {
            int i2 = ((contentLength == 1 ? 1 : 0) > 0 ? 1 : ((contentLength == 1 ? 1 : 0) == 0 ? 0 : -1));
            contentLength2 = contentLength;
            if (i2 < 0) {
                contentLength2 = contentLength;
                if (this._trailers == null) {
                    contentLength2 = this._contentPrepared + ((long) BufferUtil.length(content));
                }
            }
        }
        boolean assumedContentRequest = request != null && Boolean.TRUE.equals(ASSUMED_CONTENT_METHODS.get(request.getMethod()));
        boolean assumedContent = assumedContentRequest || contentType || chunkedHint;
        boolean nocontentRequest = request != null && (contentLength2 == 1 ? 1 : 0) <= 0 && !assumedContent;
        if (this._persistent == null) {
            this._persistent = Boolean.valueOf(http11 || (request != null && HttpMethod.CONNECT.m40is(request.getMethod())));
        }
        if (this._noContentResponse || nocontentRequest) {
            this._endOfContent = HttpTokens.EndOfContent.NO_CONTENT;
            if (this._contentPrepared > 0) {
                throw new BadMessageException(500, "Content for no content response");
            } else if (contentLengthField) {
                if (response != null && response.getStatus() == 304) {
                    putContentLength(header, contentLength2);
                } else if (contentLength2 > 0) {
                    if (this._contentPrepared != 0 || !last) {
                        throw new BadMessageException(500, "Content for no content response");
                    }
                    content.clear();
                }
            }
        } else if (http11 && (chunkedHint || (contentLength2 < 0 && (this._persistent.booleanValue() || assumedContentRequest)))) {
            this._endOfContent = HttpTokens.EndOfContent.CHUNKED_CONTENT;
            if (transferEncoding == null) {
                header.put(TRANSFER_ENCODING_CHUNKED);
            } else if (transferEncoding.toString().endsWith(HttpHeaderValue.CHUNKED.toString())) {
                putTo(transferEncoding, header);
                transferEncoding = null;
            } else if (!chunkedHint) {
                putTo(new HttpField(HttpHeader.TRANSFER_ENCODING, transferEncoding.getValue() + ",chunked"), header);
                transferEncoding = null;
            } else {
                throw new BadMessageException(500, "Bad Transfer-Encoding");
            }
        } else if (contentLength2 >= 0 && (request != null || this._persistent.booleanValue())) {
            this._endOfContent = HttpTokens.EndOfContent.CONTENT_LENGTH;
            putContentLength(header, contentLength2);
        } else if (response != null) {
            this._endOfContent = HttpTokens.EndOfContent.EOF_CONTENT;
            this._persistent = false;
            if (contentLength2 >= 0 && (contentLength2 > 0 || assumedContent || contentLengthField)) {
                putContentLength(header, contentLength2);
            }
            if (http11 && !close) {
                header.put(CONNECTION_CLOSE);
            }
        } else {
            throw new BadMessageException(500, "Unknown content length for request");
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(this._endOfContent.toString(), new Object[0]);
        }
        if (transferEncoding != null) {
            if (chunkedHint) {
                String v = transferEncoding.getValue();
                int c = v.lastIndexOf(44);
                if (c > 0 && v.lastIndexOf(HttpHeaderValue.CHUNKED.toString(), c) > c) {
                    putTo(new HttpField(HttpHeader.TRANSFER_ENCODING, v.substring(0, c).trim()), header);
                }
            } else {
                putTo(transferEncoding, header);
            }
        }
        if ((response != null ? response.getStatus() : -1) > 199) {
            header.put(SEND[send]);
        }
        header.put(HttpTokens.CRLF);
    }

    private static void putContentLength(ByteBuffer header, long contentLength) {
        if (contentLength == 0) {
            header.put(CONTENT_LENGTH_0);
            return;
        }
        header.put(HttpHeader.CONTENT_LENGTH.getBytesColonSpace());
        BufferUtil.putDecLong(header, contentLength);
        header.put(HttpTokens.CRLF);
    }

    public static byte[] getReasonBuffer(int code) {
        PreparedResponse status = code < __preprepared.length ? __preprepared[code] : null;
        if (status != null) {
            return status._reason;
        }
        return null;
    }

    public String toString() {
        return String.format("%s@%x{s=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._state);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpGenerator$PreparedResponse.class */
    public static class PreparedResponse {
        byte[] _reason;
        byte[] _schemeCode;
        byte[] _responseLine;

        private PreparedResponse() {
        }
    }

    private static void putSanitisedName(String s, ByteBuffer buffer) {
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c < 0 || c > 255 || c == '\r' || c == '\n' || c == ':') {
                buffer.put((byte) 63);
            } else {
                buffer.put((byte) (255 & c));
            }
        }
    }

    private static void putSanitisedValue(String s, ByteBuffer buffer) {
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c < 0 || c > 255 || c == '\r' || c == '\n') {
                buffer.put((byte) 32);
            } else {
                buffer.put((byte) (255 & c));
            }
        }
    }

    public static void putTo(HttpField field, ByteBuffer bufferInFillMode) {
        if (field instanceof PreEncodedHttpField) {
            ((PreEncodedHttpField) field).putTo(bufferInFillMode, HttpVersion.HTTP_1_0);
            return;
        }
        HttpHeader header = field.getHeader();
        if (header != null) {
            bufferInFillMode.put(header.getBytesColonSpace());
            putSanitisedValue(field.getValue(), bufferInFillMode);
        } else {
            putSanitisedName(field.getName(), bufferInFillMode);
            bufferInFillMode.put(__colon_space);
            putSanitisedValue(field.getValue(), bufferInFillMode);
        }
        BufferUtil.putCRLF(bufferInFillMode);
    }

    public static void putTo(HttpFields fields, ByteBuffer bufferInFillMode) {
        Iterator<HttpField> it = fields.iterator();
        while (it.hasNext()) {
            HttpField field = it.next();
            if (field != null) {
                putTo(field, bufferInFillMode);
            }
        }
        BufferUtil.putCRLF(bufferInFillMode);
    }
}
