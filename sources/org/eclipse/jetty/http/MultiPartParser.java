package org.eclipse.jetty.http;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import org.eclipse.jetty.http.HttpTokens;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.SearchPattern;
import org.eclipse.jetty.util.Utf8StringBuilder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartParser.class */
public class MultiPartParser {
    public static final Logger LOG = Log.getLogger(MultiPartParser.class);
    private static final EnumSet<State> __delimiterStates = EnumSet.of(State.DELIMITER, State.DELIMITER_CLOSE, State.DELIMITER_PADDING);
    private static final int MAX_HEADER_LINE_LENGTH = 998;
    private final Handler _handler;
    private final SearchPattern _delimiterSearch;
    private String _fieldName;
    private String _fieldValue;
    private boolean _cr;
    private ByteBuffer _patternBuffer;
    private int _length;
    private final boolean debug = LOG.isDebugEnabled();
    private State _state = State.PREAMBLE;
    private FieldState _fieldState = FieldState.FIELD;
    private int _partialBoundary = 2;
    private final Utf8StringBuilder _string = new Utf8StringBuilder();
    private int _totalHeaderLineLength = -1;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartParser$FieldState.class */
    public enum FieldState {
        FIELD,
        IN_NAME,
        AFTER_NAME,
        VALUE,
        IN_VALUE
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartParser$State.class */
    public enum State {
        PREAMBLE,
        DELIMITER,
        DELIMITER_PADDING,
        DELIMITER_CLOSE,
        BODY_PART,
        FIRST_OCTETS,
        OCTETS,
        EPILOGUE,
        END
    }

    public MultiPartParser(Handler handler, String boundary) {
        this._handler = handler;
        this._patternBuffer = ByteBuffer.wrap(("\r\n--" + boundary).getBytes(StandardCharsets.US_ASCII));
        this._delimiterSearch = SearchPattern.compile(this._patternBuffer.array());
    }

    public void reset() {
        this._state = State.PREAMBLE;
        this._fieldState = FieldState.FIELD;
        this._partialBoundary = 2;
    }

    public Handler getHandler() {
        return this._handler;
    }

    public State getState() {
        return this._state;
    }

    public boolean isState(State state) {
        return this._state == state;
    }

    private static boolean hasNextByte(ByteBuffer buffer) {
        return BufferUtil.hasContent(buffer);
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
                return null;
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

    private void setString(String s) {
        this._string.reset();
        this._string.append(s);
        this._length = s.length();
    }

    private String takeString() {
        String s = this._string.toString();
        if (s.length() > this._length) {
            s = s.substring(0, this._length);
        }
        this._string.reset();
        this._length = -1;
        return s;
    }

    public boolean parse(ByteBuffer buffer, boolean last) {
        boolean handle = false;
        while (!handle && BufferUtil.hasContent(buffer)) {
            switch (this._state) {
                case PREAMBLE:
                    parsePreamble(buffer);
                    break;
                case DELIMITER:
                case DELIMITER_PADDING:
                case DELIMITER_CLOSE:
                    parseDelimiter(buffer);
                    break;
                case BODY_PART:
                    handle = parseMimePartHeaders(buffer);
                    break;
                case FIRST_OCTETS:
                case OCTETS:
                    handle = parseOctetContent(buffer);
                    break;
                case EPILOGUE:
                    BufferUtil.clear(buffer);
                    break;
                case END:
                    handle = true;
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
        if (!last || !BufferUtil.isEmpty(buffer)) {
            return handle;
        }
        if (this._state == State.EPILOGUE) {
            this._state = State.END;
            if (LOG.isDebugEnabled()) {
                LOG.debug("messageComplete {}", this);
            }
            return this._handler.messageComplete();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("earlyEOF {}", this);
        }
        this._handler.earlyEOF();
        return true;
    }

    private void parsePreamble(ByteBuffer buffer) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("parsePreamble({})", BufferUtil.toDetailString(buffer));
        }
        if (this._partialBoundary > 0) {
            int partial = this._delimiterSearch.startsWith(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining(), this._partialBoundary);
            if (partial <= 0) {
                this._partialBoundary = 0;
            } else if (partial == this._delimiterSearch.getLength()) {
                buffer.position((buffer.position() + partial) - this._partialBoundary);
                this._partialBoundary = 0;
                setState(State.DELIMITER);
                return;
            } else {
                this._partialBoundary = partial;
                BufferUtil.clear(buffer);
                return;
            }
        }
        int delimiter = this._delimiterSearch.match(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
        if (delimiter >= 0) {
            buffer.position((delimiter - buffer.arrayOffset()) + this._delimiterSearch.getLength());
            setState(State.DELIMITER);
            return;
        }
        this._partialBoundary = this._delimiterSearch.endsWith(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
        BufferUtil.clear(buffer);
    }

    private void parseDelimiter(ByteBuffer buffer) {
        HttpTokens.Token t;
        if (LOG.isDebugEnabled()) {
            LOG.debug("parseDelimiter({})", BufferUtil.toDetailString(buffer));
        }
        while (__delimiterStates.contains(this._state) && hasNextByte(buffer) && (t = next(buffer)) != null) {
            if (t.getType() != HttpTokens.Type.LF) {
                switch (this._state) {
                    case DELIMITER:
                        if (t.getChar() != '-') {
                            setState(State.DELIMITER_PADDING);
                            break;
                        } else {
                            setState(State.DELIMITER_CLOSE);
                            break;
                        }
                    case DELIMITER_CLOSE:
                        if (t.getChar() != '-') {
                            setState(State.DELIMITER_PADDING);
                            break;
                        } else {
                            setState(State.EPILOGUE);
                            return;
                        }
                }
            } else {
                setState(State.BODY_PART);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("startPart {}", this);
                }
                this._handler.startPart();
                return;
            }
        }
    }

    protected boolean parseMimePartHeaders(ByteBuffer buffer) {
        HttpTokens.Token t;
        if (LOG.isDebugEnabled()) {
            LOG.debug("parseMimePartHeaders({})", BufferUtil.toDetailString(buffer));
        }
        while (this._state == State.BODY_PART && hasNextByte(buffer) && (t = next(buffer)) != null) {
            if (t.getType() != HttpTokens.Type.LF) {
                this._totalHeaderLineLength++;
            }
            if (this._totalHeaderLineLength > 998) {
                throw new IllegalStateException("Header Line Exceeded Max Length");
            }
            switch (this._fieldState) {
                case FIELD:
                    switch (t.getType()) {
                        case LF:
                            handleField();
                            setState(State.FIRST_OCTETS);
                            this._partialBoundary = 2;
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("headerComplete {}", this);
                            }
                            if (this._handler.headerComplete()) {
                                return true;
                            }
                            continue;
                        case CR:
                        case VCHAR:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                            handleField();
                            setState(FieldState.IN_NAME);
                            this._string.reset();
                            this._string.append(t.getChar());
                            this._length = 1;
                            continue;
                        case HTAB:
                        case SPACE:
                            if (this._fieldName == null) {
                                throw new IllegalStateException("First field folded");
                            }
                            if (this._fieldValue == null) {
                                this._string.reset();
                                this._length = 0;
                            } else {
                                setString(this._fieldValue);
                                this._string.append(' ');
                                this._length++;
                                this._fieldValue = null;
                            }
                            setState(FieldState.VALUE);
                            continue;
                    }
                case IN_NAME:
                    switch (t.getType()) {
                        case LF:
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Line Feed in Name {}", this);
                            }
                            handleField();
                            setState(FieldState.FIELD);
                            continue;
                        case CR:
                        case VCHAR:
                        case HTAB:
                        case OTEXT:
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                        case ALPHA:
                        case DIGIT:
                        case TCHAR:
                            this._string.append(t.getChar());
                            this._length = this._string.length();
                            continue;
                        case SPACE:
                            setState(FieldState.AFTER_NAME);
                            continue;
                        case COLON:
                            this._fieldName = takeString();
                            this._length = -1;
                            setState(FieldState.VALUE);
                            continue;
                    }
                case AFTER_NAME:
                    switch (t.getType()) {
                        case LF:
                            this._fieldName = takeString();
                            this._string.reset();
                            this._fieldValue = "";
                            this._length = -1;
                            continue;
                        case SPACE:
                            break;
                        case COLON:
                            this._fieldName = takeString();
                            this._length = -1;
                            setState(FieldState.VALUE);
                            continue;
                        default:
                            throw new IllegalCharacterException(this._state, t, buffer);
                    }
                case VALUE:
                    switch (t.getType()) {
                        case LF:
                            this._string.reset();
                            this._fieldValue = "";
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
                            this._string.append(t.getByte());
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
                                this._fieldValue = takeString();
                                this._length = -1;
                                this._totalHeaderLineLength = -1;
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
                            this._string.append(t.getByte());
                            this._length = this._string.length();
                            continue;
                        case HTAB:
                        case SPACE:
                            this._string.append(' ');
                            continue;
                    }
                default:
                    throw new IllegalStateException(this._state.toString());
            }
        }
        return false;
    }

    private void handleField() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("parsedField:  _fieldName={} _fieldValue={} {}", this._fieldName, this._fieldValue, this);
        }
        if (!(this._fieldName == null || this._fieldValue == null)) {
            this._handler.parsedField(this._fieldName, this._fieldValue);
        }
        this._fieldValue = null;
        this._fieldName = null;
    }

    protected boolean parseOctetContent(ByteBuffer buffer) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("parseOctetContent({})", BufferUtil.toDetailString(buffer));
        }
        if (this._partialBoundary > 0) {
            int partial = this._delimiterSearch.startsWith(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining(), this._partialBoundary);
            if (partial <= 0) {
                ByteBuffer content = this._patternBuffer.slice();
                if (this._state == State.FIRST_OCTETS) {
                    setState(State.OCTETS);
                    content.position(2);
                }
                content.limit(this._partialBoundary);
                this._partialBoundary = 0;
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Content={}, Last={} {}", BufferUtil.toDetailString(content), false, this);
                }
                if (this._handler.content(content, false)) {
                    return true;
                }
            } else if (partial == this._delimiterSearch.getLength()) {
                buffer.position((buffer.position() + this._delimiterSearch.getLength()) - this._partialBoundary);
                setState(State.DELIMITER);
                this._partialBoundary = 0;
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Content={}, Last={} {}", BufferUtil.toDetailString(BufferUtil.EMPTY_BUFFER), true, this);
                }
                return this._handler.content(BufferUtil.EMPTY_BUFFER, true);
            } else {
                this._partialBoundary = partial;
                BufferUtil.clear(buffer);
                return false;
            }
        }
        int delimiter = this._delimiterSearch.match(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
        if (delimiter >= 0) {
            ByteBuffer content2 = buffer.slice();
            content2.limit((delimiter - buffer.arrayOffset()) - buffer.position());
            buffer.position((delimiter - buffer.arrayOffset()) + this._delimiterSearch.getLength());
            setState(State.DELIMITER);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Content={}, Last={} {}", BufferUtil.toDetailString(content2), true, this);
            }
            return this._handler.content(content2, true);
        }
        this._partialBoundary = this._delimiterSearch.endsWith(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
        if (this._partialBoundary > 0) {
            ByteBuffer content3 = buffer.slice();
            content3.limit(content3.limit() - this._partialBoundary);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Content={}, Last={} {}", BufferUtil.toDetailString(content3), false, this);
            }
            BufferUtil.clear(buffer);
            return this._handler.content(content3, false);
        }
        ByteBuffer content4 = buffer.slice();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Content={}, Last={} {}", BufferUtil.toDetailString(content4), false, this);
        }
        BufferUtil.clear(buffer);
        return this._handler.content(content4, false);
    }

    private void setState(State state) {
        if (this.debug) {
            LOG.debug("{} --> {}", this._state, state);
        }
        this._state = state;
    }

    private void setState(FieldState state) {
        if (this.debug) {
            LOG.debug("{}:{} --> {}", this._state, this._fieldState, state);
        }
        this._fieldState = state;
    }

    public String toString() {
        return String.format("%s{s=%s}", getClass().getSimpleName(), this._state);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartParser$Handler.class */
    public interface Handler {
        default void startPart() {
        }

        default void parsedField(String name, String value) {
        }

        default boolean headerComplete() {
            return false;
        }

        default boolean content(ByteBuffer item, boolean last) {
            return false;
        }

        default boolean messageComplete() {
            return false;
        }

        default void earlyEOF() {
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartParser$IllegalCharacterException.class */
    public static class IllegalCharacterException extends BadMessageException {
        private IllegalCharacterException(State state, HttpTokens.Token token, ByteBuffer buffer) {
            super(400, String.format("Illegal character %s", token));
            if (MultiPartParser.LOG.isDebugEnabled()) {
                MultiPartParser.LOG.debug(String.format("Illegal character %s in state=%s for buffer %s", token, state, BufferUtil.toDetailString(buffer)), new Object[0]);
            }
        }
    }
}
