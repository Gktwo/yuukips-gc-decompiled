package org.eclipse.jetty.websocket.common.p025io.http;

import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Utf8LineParser;

/* renamed from: org.eclipse.jetty.websocket.common.io.http.HttpResponseHeaderParser */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/http/HttpResponseHeaderParser.class */
public class HttpResponseHeaderParser {
    private static final Pattern PAT_HEADER = Pattern.compile("([^:]+):\\s*(.*)");
    private static final Pattern PAT_STATUS_LINE = Pattern.compile("^HTTP/1.[01]\\s+(\\d+)\\s+(.*)", 2);
    private final HttpResponseHeaderParseListener listener;
    private final Utf8LineParser lineParser = new Utf8LineParser();
    private State state = State.STATUS_LINE;

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.websocket.common.io.http.HttpResponseHeaderParser$State */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/http/HttpResponseHeaderParser$State.class */
    public enum State {
        STATUS_LINE,
        HEADER,
        END
    }

    /* renamed from: org.eclipse.jetty.websocket.common.io.http.HttpResponseHeaderParser$ParseException */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/http/HttpResponseHeaderParser$ParseException.class */
    public static class ParseException extends RuntimeException {
        public ParseException(String message) {
            super(message);
        }

        public ParseException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public HttpResponseHeaderParser(HttpResponseHeaderParseListener listener) {
        this.listener = listener;
    }

    public boolean isDone() {
        return this.state == State.END;
    }

    public HttpResponseHeaderParseListener parse(ByteBuffer buf) throws ParseException {
        while (!isDone() && buf.remaining() > 0) {
            String line = this.lineParser.parse(buf);
            if (line != null && parseHeader(line)) {
                ByteBuffer copy = ByteBuffer.allocate(buf.remaining());
                BufferUtil.put(buf, copy);
                BufferUtil.flipToFlush(copy, 0);
                this.listener.setRemainingBuffer(copy);
                return this.listener;
            }
        }
        return null;
    }

    private boolean parseHeader(String line) throws ParseException {
        switch (this.state) {
            case STATUS_LINE:
                Matcher mat = PAT_STATUS_LINE.matcher(line);
                if (!mat.matches()) {
                    throw new ParseException("Unexpected HTTP response status line [" + line + "]");
                }
                try {
                    this.listener.setStatusCode(Integer.parseInt(mat.group(1)));
                    this.listener.setStatusReason(mat.group(2));
                    this.state = State.HEADER;
                    return false;
                } catch (NumberFormatException e) {
                    throw new ParseException("Unexpected HTTP response status code", e);
                }
            case HEADER:
                if (StringUtil.isBlank(line)) {
                    this.state = State.END;
                    return parseHeader(line);
                }
                Matcher header = PAT_HEADER.matcher(line);
                if (!header.matches()) {
                    return false;
                }
                this.listener.addHeader(header.group(1), header.group(2));
                return false;
            case END:
                this.state = State.STATUS_LINE;
                return true;
            default:
                return false;
        }
    }
}
