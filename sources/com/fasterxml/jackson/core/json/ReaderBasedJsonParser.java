package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/json/ReaderBasedJsonParser.class */
public class ReaderBasedJsonParser extends ParserBase {
    private static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int FEAT_MASK_NON_NUM_NUMBERS = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
    protected Reader _reader;
    protected char[] _inputBuffer;
    protected boolean _bufferRecyclable;
    protected ObjectCodec _objectCodec;
    protected final CharsToNameCanonicalizer _symbols;
    protected final int _hashSeed;
    protected boolean _tokenIncomplete;
    protected long _nameStartOffset;
    protected int _nameStartRow;
    protected int _nameStartCol;

    public ReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st, char[] inputBuffer, int start, int end, boolean bufferRecyclable) {
        super(ctxt, features);
        this._reader = r;
        this._objectCodec = codec;
        this._inputBuffer = inputBuffer;
        this._inputPtr = start;
        this._inputEnd = end;
        this._currInputRowStart = start;
        this._currInputProcessed = (long) (-start);
        this._symbols = st;
        this._hashSeed = st.hashSeed();
        this._bufferRecyclable = bufferRecyclable;
    }

    public ReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st) {
        super(ctxt, features);
        this._reader = r;
        this._inputBuffer = ctxt.allocTokenBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._objectCodec = codec;
        this._symbols = st;
        this._hashSeed = st.hashSeed();
        this._bufferRecyclable = true;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec c) {
        this._objectCodec = c;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JSON_READ_CAPABILITIES;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(Writer w) throws IOException {
        int count = this._inputEnd - this._inputPtr;
        if (count < 1) {
            return 0;
        }
        int origPtr = this._inputPtr;
        this._inputPtr += count;
        w.write(this._inputBuffer, origPtr, count);
        return count;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._reader;
    }

    @Deprecated
    protected char getNextChar(String eofMsg) throws IOException {
        return getNextChar(eofMsg, null);
    }

    protected char getNextChar(String eofMsg, JsonToken forToken) throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(eofMsg, forToken);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return cArr[i];
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _closeInput() throws IOException {
        if (this._reader != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._reader.close();
            }
            this._reader = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() throws IOException {
        char[] buf;
        _releaseBuffers();
        this._symbols.release();
        if (this._bufferRecyclable && (buf = this._inputBuffer) != null) {
            this._inputBuffer = null;
            this._ioContext.releaseTokenBuffer(buf);
        }
    }

    protected void _loadMoreGuaranteed() throws IOException {
        if (!_loadMore()) {
            _reportInvalidEOF();
        }
    }

    protected boolean _loadMore() throws IOException {
        if (this._reader == null) {
            return false;
        }
        int count = this._reader.read(this._inputBuffer, 0, this._inputBuffer.length);
        if (count > 0) {
            int bufSize = this._inputEnd;
            this._currInputProcessed += (long) bufSize;
            this._currInputRowStart -= bufSize;
            this._nameStartOffset -= (long) bufSize;
            this._inputPtr = 0;
            this._inputEnd = count;
            return true;
        }
        _closeInput();
        if (count != 0) {
            return false;
        }
        throw new IOException("Reader returned 0 characters when trying to read " + this._inputEnd);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getText() throws IOException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return _getText2(this._currToken);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        JsonToken t = this._currToken;
        if (t == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsToWriter(writer);
        } else if (t == JsonToken.FIELD_NAME) {
            String n = this._parsingContext.getCurrentName();
            writer.write(n);
            return n.length();
        } else if (t == null) {
            return 0;
        } else {
            if (t.isNumeric()) {
                return this._textBuffer.contentsToWriter(writer);
            }
            char[] ch = t.asCharArray();
            writer.write(ch);
            return ch.length;
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getValueAsString() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        } else if (this._currToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return getValueAsString(null);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getValueAsString(String defValue) throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        } else if (this._currToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return getValueAsString(defValue);
        }
    }

    protected final String _getText2(JsonToken t) {
        if (t == null) {
            return null;
        }
        switch (t.m1480id()) {
            case 5:
                return this._parsingContext.getCurrentName();
            case 6:
            case 7:
            case 8:
                return this._textBuffer.contentsAsString();
            default:
                return t.asString();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final char[] getTextCharacters() throws IOException {
        if (this._currToken == null) {
            return null;
        }
        switch (this._currToken.m1480id()) {
            case 5:
                if (!this._nameCopied) {
                    String name = this._parsingContext.getCurrentName();
                    int nameLen = name.length();
                    if (this._nameCopyBuffer == null) {
                        this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(nameLen);
                    } else if (this._nameCopyBuffer.length < nameLen) {
                        this._nameCopyBuffer = new char[nameLen];
                    }
                    name.getChars(0, nameLen, this._nameCopyBuffer, 0);
                    this._nameCopied = true;
                }
                return this._nameCopyBuffer;
            case 6:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return this._currToken.asCharArray();
        }
        return this._textBuffer.getTextBuffer();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final int getTextLength() throws IOException {
        if (this._currToken == null) {
            return 0;
        }
        switch (this._currToken.m1480id()) {
            case 5:
                return this._parsingContext.getCurrentName().length();
            case 6:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return this._currToken.asCharArray().length;
        }
        return this._textBuffer.size();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final int getTextOffset() throws IOException {
        if (this._currToken == null) {
            return 0;
        }
        switch (this._currToken.m1480id()) {
            case 5:
                return 0;
            case 6:
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                    break;
                }
                break;
            case 7:
            case 8:
                break;
            default:
                return 0;
        }
        return this._textBuffer.getTextOffset();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException {
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT && this._binaryValue != null) {
            return this._binaryValue;
        }
        if (this._currToken != JsonToken.VALUE_STRING) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(b64variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException iae) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + b64variant + "): " + iae.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder builder = _getByteArrayBuilder();
            _decodeBase64(getText(), builder, b64variant);
            this._binaryValue = builder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] b = getBinaryValue(b64variant);
            out.write(b);
            return b.length;
        }
        byte[] buf = this._ioContext.allocBase64Buffer();
        try {
            int _readBinary = _readBinary(b64variant, out, buf);
            this._ioContext.releaseBase64Buffer(buf);
            return _readBinary;
        } catch (Throwable th) {
            this._ioContext.releaseBase64Buffer(buf);
            throw th;
        }
    }

    protected int _readBinary(Base64Variant b64variant, OutputStream out, byte[] buffer) throws IOException {
        int outputPtr = 0;
        int outputEnd = buffer.length - 3;
        int outputCount = 0;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char ch = cArr[i];
            if (ch > ' ') {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == '\"') {
                        break;
                    }
                    bits = _decodeBase64Escape(b64variant, ch, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                if (outputPtr > outputEnd) {
                    outputCount += outputPtr;
                    out.write(buffer, 0, outputPtr);
                    outputPtr = 0;
                }
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                char ch2 = cArr2[i2];
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData = (bits << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                char ch3 = cArr3[i3];
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 == '\"') {
                            outputPtr++;
                            buffer[outputPtr] = (byte) (decodedData >> 4);
                            if (b64variant.usesPadding()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(b64variant);
                            }
                        } else {
                            bits3 = _decodeBase64Escape(b64variant, ch3, 2);
                        }
                    }
                    if (bits3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        char ch4 = cArr4[i4];
                        if (b64variant.usesPaddingChar(ch4) || _decodeBase64Escape(b64variant, ch4, 3) == -2) {
                            outputPtr++;
                            buffer[outputPtr] = (byte) (decodedData >> 4);
                        } else {
                            throw reportInvalidBase64Char(b64variant, ch4, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                        }
                    }
                }
                int decodedData2 = (decodedData << 6) | bits3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                char ch5 = cArr5[i5];
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 == '\"') {
                            int decodedData3 = decodedData2 >> 2;
                            int outputPtr2 = outputPtr + 1;
                            buffer[outputPtr] = (byte) (decodedData3 >> 8);
                            outputPtr = outputPtr2 + 1;
                            buffer[outputPtr2] = (byte) decodedData3;
                            if (b64variant.usesPadding()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(b64variant);
                            }
                        } else {
                            bits4 = _decodeBase64Escape(b64variant, ch5, 3);
                        }
                    }
                    if (bits4 == -2) {
                        int decodedData4 = decodedData2 >> 2;
                        int outputPtr3 = outputPtr + 1;
                        buffer[outputPtr] = (byte) (decodedData4 >> 8);
                        outputPtr = outputPtr3 + 1;
                        buffer[outputPtr3] = (byte) decodedData4;
                    }
                }
                int decodedData5 = (decodedData2 << 6) | bits4;
                int outputPtr4 = outputPtr + 1;
                buffer[outputPtr] = (byte) (decodedData5 >> 16);
                int outputPtr5 = outputPtr4 + 1;
                buffer[outputPtr4] = (byte) (decodedData5 >> 8);
                outputPtr = outputPtr5 + 1;
                buffer[outputPtr5] = (byte) decodedData5;
            }
        }
        this._tokenIncomplete = false;
        if (outputPtr > 0) {
            outputCount += outputPtr;
            out.write(buffer, 0, outputPtr);
        }
        return outputCount;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final JsonToken nextToken() throws IOException {
        JsonToken t;
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            i = _skipComma(i);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                _closeScope(i);
                return this._currToken;
            }
        }
        boolean inObject = this._parsingContext.inObject();
        if (inObject) {
            _updateNameLocation();
            this._parsingContext.setCurrentName(i == 34 ? _parseName() : _handleOddName(i));
            this._currToken = JsonToken.FIELD_NAME;
            i = _skipColon();
        }
        _updateLocation();
        switch (i) {
            case 34:
                this._tokenIncomplete = true;
                t = JsonToken.VALUE_STRING;
                break;
            case 45:
                t = _parseNegNumber();
                break;
            case 46:
                t = _parseFloatThatStartsWithPeriod();
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                t = _parsePosNumber(i);
                break;
            case 91:
                if (!inObject) {
                    this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                }
                t = JsonToken.START_ARRAY;
                break;
            case 102:
                _matchFalse();
                t = JsonToken.VALUE_FALSE;
                break;
            case 110:
                _matchNull();
                t = JsonToken.VALUE_NULL;
                break;
            case 116:
                _matchTrue();
                t = JsonToken.VALUE_TRUE;
                break;
            case 123:
                if (!inObject) {
                    this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                }
                t = JsonToken.START_OBJECT;
                break;
            case 125:
                _reportUnexpectedChar(i, "expected a value");
                _matchTrue();
                t = JsonToken.VALUE_TRUE;
                break;
            default:
                t = _handleOddValue(i);
                break;
        }
        if (inObject) {
            this._nextToken = t;
            return this._currToken;
        }
        this._currToken = t;
        return t;
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = t;
        return t;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void finishToken() throws IOException {
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean nextFieldName(SerializableString sstr) throws IOException {
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return false;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return false;
        }
        this._binaryValue = null;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return false;
        }
        if (this._parsingContext.expectComma()) {
            i = _skipComma(i);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                _closeScope(i);
                return false;
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            _nextTokenNotInObject(i);
            return false;
        }
        _updateNameLocation();
        if (i == 34) {
            char[] nameChars = sstr.asQuotedChars();
            int len = nameChars.length;
            if (this._inputPtr + len + 4 < this._inputEnd) {
                int end = this._inputPtr + len;
                if (this._inputBuffer[end] == '\"') {
                    int offset = 0;
                    int ptr = this._inputPtr;
                    while (ptr != end) {
                        if (nameChars[offset] == this._inputBuffer[ptr]) {
                            offset++;
                            ptr++;
                        }
                    }
                    this._parsingContext.setCurrentName(sstr.getValue());
                    _isNextTokenNameYes(_skipColonFast(ptr + 1));
                    return true;
                }
            }
        }
        return _isNextTokenNameMaybe(i, sstr.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextFieldName() throws IOException {
        JsonToken t;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return null;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i = _skipWSOrEnd();
        if (i < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return null;
        }
        if (this._parsingContext.expectComma()) {
            i = _skipComma(i);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                _closeScope(i);
                return null;
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            _nextTokenNotInObject(i);
            return null;
        }
        _updateNameLocation();
        String name = i == 34 ? _parseName() : _handleOddName(i);
        this._parsingContext.setCurrentName(name);
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipColon();
        _updateLocation();
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return name;
        }
        switch (i2) {
            case 45:
                t = _parseNegNumber();
                break;
            case 46:
                t = _parseFloatThatStartsWithPeriod();
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                t = _parsePosNumber(i2);
                break;
            case 91:
                t = JsonToken.START_ARRAY;
                break;
            case 102:
                _matchFalse();
                t = JsonToken.VALUE_FALSE;
                break;
            case 110:
                _matchNull();
                t = JsonToken.VALUE_NULL;
                break;
            case 116:
                _matchTrue();
                t = JsonToken.VALUE_TRUE;
                break;
            case 123:
                t = JsonToken.START_OBJECT;
                break;
            default:
                t = _handleOddValue(i2);
                break;
        }
        this._nextToken = t;
        return name;
    }

    private final void _isNextTokenNameYes(int i) throws IOException {
        this._currToken = JsonToken.FIELD_NAME;
        _updateLocation();
        switch (i) {
            case 34:
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return;
            case 45:
                this._nextToken = _parseNegNumber();
                return;
            case 46:
                this._nextToken = _parseFloatThatStartsWithPeriod();
                return;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                this._nextToken = _parsePosNumber(i);
                return;
            case 91:
                this._nextToken = JsonToken.START_ARRAY;
                return;
            case 102:
                _matchToken("false", 1);
                this._nextToken = JsonToken.VALUE_FALSE;
                return;
            case 110:
                _matchToken("null", 1);
                this._nextToken = JsonToken.VALUE_NULL;
                return;
            case 116:
                _matchToken(C3P0Substitutions.DEBUG, 1);
                this._nextToken = JsonToken.VALUE_TRUE;
                return;
            case 123:
                this._nextToken = JsonToken.START_OBJECT;
                return;
            default:
                this._nextToken = _handleOddValue(i);
                return;
        }
    }

    protected boolean _isNextTokenNameMaybe(int i, String nameToMatch) throws IOException {
        JsonToken t;
        String name = i == 34 ? _parseName() : _handleOddName(i);
        this._parsingContext.setCurrentName(name);
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipColon();
        _updateLocation();
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return nameToMatch.equals(name);
        }
        switch (i2) {
            case 45:
                t = _parseNegNumber();
                break;
            case 46:
                t = _parseFloatThatStartsWithPeriod();
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                t = _parsePosNumber(i2);
                break;
            case 91:
                t = JsonToken.START_ARRAY;
                break;
            case 102:
                _matchFalse();
                t = JsonToken.VALUE_FALSE;
                break;
            case 110:
                _matchNull();
                t = JsonToken.VALUE_NULL;
                break;
            case 116:
                _matchTrue();
                t = JsonToken.VALUE_TRUE;
                break;
            case 123:
                t = JsonToken.START_OBJECT;
                break;
            default:
                t = _handleOddValue(i2);
                break;
        }
        this._nextToken = t;
        return nameToMatch.equals(name);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final JsonToken _nextTokenNotInObject(int i) throws IOException {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        }
        switch (i) {
            case 44:
                if (!this._parsingContext.inRoot() && (this._features & FEAT_MASK_ALLOW_MISSING) != 0) {
                    this._inputPtr--;
                    JsonToken jsonToken2 = JsonToken.VALUE_NULL;
                    this._currToken = jsonToken2;
                    return jsonToken2;
                }
                break;
            case 45:
                JsonToken _parseNegNumber = _parseNegNumber();
                this._currToken = _parseNegNumber;
                return _parseNegNumber;
            case 46:
                JsonToken _parseFloatThatStartsWithPeriod = _parseFloatThatStartsWithPeriod();
                this._currToken = _parseFloatThatStartsWithPeriod;
                return _parseFloatThatStartsWithPeriod;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                JsonToken _parsePosNumber = _parsePosNumber(i);
                this._currToken = _parsePosNumber;
                return _parsePosNumber;
            case 91:
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken3 = JsonToken.START_ARRAY;
                this._currToken = jsonToken3;
                return jsonToken3;
            case 102:
                _matchToken("false", 1);
                JsonToken jsonToken4 = JsonToken.VALUE_FALSE;
                this._currToken = jsonToken4;
                return jsonToken4;
            case 110:
                _matchToken("null", 1);
                JsonToken jsonToken5 = JsonToken.VALUE_NULL;
                this._currToken = jsonToken5;
                return jsonToken5;
            case 116:
                _matchToken(C3P0Substitutions.DEBUG, 1);
                JsonToken jsonToken6 = JsonToken.VALUE_TRUE;
                this._currToken = jsonToken6;
                return jsonToken6;
            case 123:
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken7 = JsonToken.START_OBJECT;
                this._currToken = jsonToken7;
                return jsonToken7;
        }
        JsonToken _handleOddValue = _handleOddValue(i);
        this._currToken = _handleOddValue;
        return _handleOddValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String nextTextValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_STRING) {
                if (this._tokenIncomplete) {
                    this._tokenIncomplete = false;
                    _finishString();
                }
                return this._textBuffer.contentsAsString();
            } else if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            } else if (t != JsonToken.START_OBJECT) {
                return null;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            }
        } else if (nextToken() == JsonToken.VALUE_STRING) {
            return getText();
        } else {
            return null;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int nextIntValue(int defaultValue) throws IOException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : defaultValue;
        }
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        this._currToken = t;
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return defaultValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final long nextLongValue(long defaultValue) throws IOException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : defaultValue;
        }
        this._nameCopied = false;
        JsonToken t = this._nextToken;
        this._nextToken = null;
        this._currToken = t;
        if (t == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        }
        if (t == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (t == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return defaultValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final Boolean nextBooleanValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            if (t == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            } else if (t != JsonToken.START_OBJECT) {
                return null;
            } else {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                return null;
            }
        } else {
            JsonToken t2 = nextToken();
            if (t2 == null) {
                return null;
            }
            int id = t2.m1480id();
            if (id == 9) {
                return Boolean.TRUE;
            }
            if (id == 10) {
                return Boolean.FALSE;
            }
            return null;
        }
    }

    protected final JsonToken _parseFloatThatStartsWithPeriod() throws IOException {
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return _handleOddValue(46);
        }
        return _parseFloat(46, this._inputPtr - 1, this._inputPtr, false, 0);
    }

    protected final JsonToken _parsePosNumber(int ch) throws IOException {
        int ptr = this._inputPtr;
        int startPtr = ptr - 1;
        int inputLen = this._inputEnd;
        if (ch == 48) {
            return _parseNumber2(false, startPtr);
        }
        int intLen = 1;
        while (ptr < inputLen) {
            ptr++;
            char c = this._inputBuffer[ptr];
            if (c >= '0' && c <= '9') {
                intLen++;
            } else if (c == '.' || c == 'e' || c == 'E') {
                this._inputPtr = ptr;
                return _parseFloat(c, startPtr, ptr, false, intLen);
            } else {
                int ptr2 = ptr - 1;
                this._inputPtr = ptr2;
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c);
                }
                this._textBuffer.resetWithShared(this._inputBuffer, startPtr, ptr2 - startPtr);
                return resetInt(false, intLen);
            }
        }
        this._inputPtr = startPtr;
        return _parseNumber2(false, startPtr);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r7v0 ??, r7v1 ??, r7v8 ??, r7v2 ??, r7v5 ??, r7v4 ??, r7v7 ??, r7v3 ??, r7v6 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private final com.fasterxml.jackson.core.JsonToken _parseFloat(
/*
[271] Method generation error in method: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._parseFloat(int, int, int, boolean, int):com.fasterxml.jackson.core.JsonToken, file: grasscutter.jar:com/fasterxml/jackson/core/json/ReaderBasedJsonParser.class
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

    protected final JsonToken _parseNegNumber() throws IOException {
        int ptr = this._inputPtr;
        int startPtr = ptr - 1;
        int inputLen = this._inputEnd;
        if (ptr >= inputLen) {
            return _parseNumber2(true, startPtr);
        }
        int ptr2 = ptr + 1;
        char c = this._inputBuffer[ptr];
        if (c > '9' || c < '0') {
            this._inputPtr = ptr2;
            return _handleInvalidNumberStart(c, true);
        } else if (c == '0') {
            return _parseNumber2(true, startPtr);
        } else {
            int intLen = 1;
            while (ptr2 < inputLen) {
                ptr2++;
                char c2 = this._inputBuffer[ptr2];
                if (c2 >= '0' && c2 <= '9') {
                    intLen++;
                } else if (c2 == '.' || c2 == 'e' || c2 == 'E') {
                    this._inputPtr = ptr2;
                    return _parseFloat(c2, startPtr, ptr2, true, intLen);
                } else {
                    int ptr3 = ptr2 - 1;
                    this._inputPtr = ptr3;
                    if (this._parsingContext.inRoot()) {
                        _verifyRootSpace(c2);
                    }
                    this._textBuffer.resetWithShared(this._inputBuffer, startPtr, ptr3 - startPtr);
                    return resetInt(true, intLen);
                }
            }
            return _parseNumber2(true, startPtr);
        }
    }

    private final JsonToken _parseNumber2(boolean neg, int startPtr) throws IOException {
        char c;
        this._inputPtr = neg ? startPtr + 1 : startPtr;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = 0;
        if (neg) {
            outPtr = 0 + 1;
            outBuf[0] = '-';
        }
        int intLen = 0;
        if (this._inputPtr < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            c = cArr[i];
        } else {
            c = getNextChar("No digit following minus sign", JsonToken.VALUE_NUMBER_INT);
        }
        if (c == '0') {
            c = _verifyNoLeadingZeroes();
        }
        boolean eof = false;
        while (true) {
            if (c < '0' || c > '9') {
                break;
            }
            intLen++;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = c;
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                c = 0;
                eof = true;
                break;
            }
            char[] cArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            c = cArr2[i2];
        }
        if (intLen == 0) {
            return _handleInvalidNumberStart(c, neg);
        }
        int fractLen = 0;
        if (c == '.') {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = c;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    eof = true;
                    break;
                }
                char[] cArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                c = cArr3[i3];
                if (c < '0' || c > '9') {
                    break;
                }
                fractLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = c;
            }
            if (fractLen == 0) {
                reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
            }
        }
        int expLen = 0;
        if (c == 'e' || c == 'E') {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = c;
            if (this._inputPtr < this._inputEnd) {
                char[] cArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                c = cArr4[i4];
            } else {
                c = getNextChar("expected a digit for number exponent");
            }
            if (c == '-' || c == '+') {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = c;
                if (this._inputPtr < this._inputEnd) {
                    char[] cArr5 = this._inputBuffer;
                    int i5 = this._inputPtr;
                    this._inputPtr = i5 + 1;
                    c = cArr5[i5];
                } else {
                    c = getNextChar("expected a digit for number exponent");
                }
            }
            while (true) {
                if (c > '9' || c < '0') {
                    break;
                }
                expLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = c;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    eof = true;
                    break;
                }
                char[] cArr6 = this._inputBuffer;
                int i6 = this._inputPtr;
                this._inputPtr = i6 + 1;
                c = cArr6[i6];
            }
            if (expLen == 0) {
                reportUnexpectedNumberChar(c, "Exponent indicator not followed by a digit");
            }
        }
        if (!eof) {
            this._inputPtr--;
            if (this._parsingContext.inRoot()) {
                _verifyRootSpace(c);
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        return reset(neg, intLen, fractLen, expLen);
    }

    private final char _verifyNoLeadingZeroes() throws IOException {
        char ch;
        if (this._inputPtr >= this._inputEnd || ((ch = this._inputBuffer[this._inputPtr]) >= '0' && ch <= '9')) {
            return _verifyNLZ2();
        }
        return '0';
    }

    private char _verifyNLZ2() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return '0';
        }
        char ch = this._inputBuffer[this._inputPtr];
        if (ch < '0' || ch > '9') {
            return '0';
        }
        if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (ch == '0') {
            do {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    break;
                }
                ch = this._inputBuffer[this._inputPtr];
                if (ch < '0' || ch > '9') {
                    return '0';
                }
                this._inputPtr++;
            } while (ch == '0');
        }
        return ch;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r7v0 ??, r7v1 ??, r7v2 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    protected com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(
/*
[224] Method generation error in method: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleInvalidNumberStart(int, boolean):com.fasterxml.jackson.core.JsonToken, file: grasscutter.jar:com/fasterxml/jackson/core/json/ReaderBasedJsonParser.class
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

    private final void _verifyRootSpace(int ch) throws IOException {
        this._inputPtr++;
        switch (ch) {
            case 9:
            case 32:
                return;
            case 10:
                this._currInputRow++;
                this._currInputRowStart = this._inputPtr;
                return;
            case 13:
                _skipCR();
                return;
            default:
                _reportMissingRootWS(ch);
                return;
        }
    }

    protected final String _parseName() throws IOException {
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int[] codes = _icLatin1;
        while (true) {
            if (ptr >= this._inputEnd) {
                break;
            }
            char c = this._inputBuffer[ptr];
            if (c >= codes.length || codes[c] == 0) {
                hash = (hash * 33) + c;
                ptr++;
            } else if (c == '\"') {
                int start = this._inputPtr;
                this._inputPtr = ptr + 1;
                return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
            }
        }
        int start2 = this._inputPtr;
        this._inputPtr = ptr;
        return _parseName2(start2, hash, 34);
    }

    private String _parseName2(int startPtr, int hash, int endChar) throws IOException {
        this._textBuffer.resetWithShared(this._inputBuffer, startPtr, this._inputPtr - startPtr);
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = _decodeEscaped();
                } else if (c <= endChar) {
                    if (c == endChar) {
                        this._textBuffer.setCurrentLength(outPtr);
                        TextBuffer tb = this._textBuffer;
                        return this._symbols.findSymbol(tb.getTextBuffer(), tb.getTextOffset(), tb.size(), hash);
                    } else if (c < ' ') {
                        _throwUnquotedSpace(c, "name");
                    }
                }
            }
            hash = (hash * 33) + c;
            outPtr++;
            outBuf[outPtr] = c;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
        }
    }

    protected String _handleOddName(int i) throws IOException {
        boolean firstOk;
        if (i == 39 && (this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return _parseAposName();
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        }
        int[] codes = CharTypes.getInputCodeLatin1JsNames();
        int maxCode = codes.length;
        if (i < maxCode) {
            firstOk = codes[i] == 0;
        } else {
            firstOk = Character.isJavaIdentifierPart((char) i);
        }
        if (!firstOk) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            do {
                char c = this._inputBuffer[ptr];
                if (c < maxCode) {
                    if (codes[c] != 0) {
                        int start = this._inputPtr - 1;
                        this._inputPtr = ptr;
                        return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
                    }
                } else if (!Character.isJavaIdentifierPart((char) c)) {
                    int start2 = this._inputPtr - 1;
                    this._inputPtr = ptr;
                    return this._symbols.findSymbol(this._inputBuffer, start2, ptr - start2, hash);
                }
                hash = (hash * 33) + c;
                ptr++;
            } while (ptr < inputLen);
            this._inputPtr = ptr;
            return _handleOddName2(this._inputPtr - 1, hash, codes);
        }
        this._inputPtr = ptr;
        return _handleOddName2(this._inputPtr - 1, hash, codes);
    }

    protected String _parseAposName() throws IOException {
        int ptr = this._inputPtr;
        int hash = this._hashSeed;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = _icLatin1;
            int maxCode = codes.length;
            do {
                char c = this._inputBuffer[ptr];
                if (c != '\'') {
                    if (c < maxCode && codes[c] != 0) {
                        break;
                    }
                    hash = (hash * 33) + c;
                    ptr++;
                } else {
                    int start = this._inputPtr;
                    this._inputPtr = ptr + 1;
                    return this._symbols.findSymbol(this._inputBuffer, start, ptr - start, hash);
                }
            } while (ptr < inputLen);
        }
        int start2 = this._inputPtr;
        this._inputPtr = ptr;
        return _parseName2(start2, hash, 39);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0053, code lost:
        if (r7._parsingContext.inArray() == false) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken _handleOddValue(int r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken _handleApos() throws IOException {
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = _decodeEscaped();
                } else if (c <= '\'') {
                    if (c == '\'') {
                        this._textBuffer.setCurrentLength(outPtr);
                        return JsonToken.VALUE_STRING;
                    } else if (c < ' ') {
                        _throwUnquotedSpace(c, "string value");
                    }
                }
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = c;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0028 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String _handleOddName2(int r7, int r8, int[] r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddName2(int, int, int[]):java.lang.String");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected final void _finishString() throws IOException {
        int ptr = this._inputPtr;
        int inputLen = this._inputEnd;
        if (ptr < inputLen) {
            int[] codes = _icLatin1;
            int maxCode = codes.length;
            while (true) {
                char c = this._inputBuffer[ptr];
                if (c >= maxCode || codes[c] == 0) {
                    ptr++;
                    if (ptr >= inputLen) {
                        break;
                    }
                } else if (c == '\"') {
                    this._textBuffer.resetWithShared(this._inputBuffer, this._inputPtr, ptr - this._inputPtr);
                    this._inputPtr = ptr + 1;
                    return;
                }
            }
        }
        this._textBuffer.resetWithCopy(this._inputBuffer, this._inputPtr, ptr - this._inputPtr);
        this._inputPtr = ptr;
        _finishString2();
    }

    protected void _finishString2() throws IOException {
        char[] outBuf = this._textBuffer.getCurrentSegment();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        int[] codes = _icLatin1;
        int maxCode = codes.length;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c < maxCode && codes[c] != 0) {
                if (c == '\"') {
                    this._textBuffer.setCurrentLength(outPtr);
                    return;
                } else if (c == '\\') {
                    c = _decodeEscaped();
                } else if (c < ' ') {
                    _throwUnquotedSpace(c, "string value");
                }
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = c;
        }
    }

    protected final void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int inPtr = this._inputPtr;
        int inLen = this._inputEnd;
        char[] inBuf = this._inputBuffer;
        while (true) {
            if (inPtr >= inLen) {
                this._inputPtr = inPtr;
                if (!_loadMore()) {
                    _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                }
                inPtr = this._inputPtr;
                inLen = this._inputEnd;
            }
            inPtr++;
            char c = inBuf[inPtr];
            if (c <= '\\') {
                if (c == '\\') {
                    this._inputPtr = inPtr;
                    _decodeEscaped();
                    inPtr = this._inputPtr;
                    inLen = this._inputEnd;
                } else if (c > '\"') {
                    continue;
                } else if (c == '\"') {
                    this._inputPtr = inPtr;
                    return;
                } else if (c < ' ') {
                    this._inputPtr = inPtr;
                    _throwUnquotedSpace(c, "string value");
                }
            }
        }
    }

    protected final void _skipCR() throws IOException {
        if ((this._inputPtr < this._inputEnd || _loadMore()) && this._inputBuffer[this._inputPtr] == '\n') {
            this._inputPtr++;
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private final int _skipColon() throws IOException {
        if (this._inputPtr + 4 >= this._inputEnd) {
            return _skipColon2(false);
        }
        char c = this._inputBuffer[this._inputPtr];
        if (c == ':') {
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr + 1;
            this._inputPtr = i;
            char c2 = cArr[i];
            if (c2 <= ' ') {
                if (c2 == ' ' || c2 == '\t') {
                    char[] cArr2 = this._inputBuffer;
                    int i2 = this._inputPtr + 1;
                    this._inputPtr = i2;
                    char c3 = cArr2[i2];
                    if (c3 > ' ') {
                        if (c3 == '/' || c3 == '#') {
                            return _skipColon2(true);
                        }
                        this._inputPtr++;
                        return c3;
                    }
                }
                return _skipColon2(true);
            } else if (c2 == '/' || c2 == '#') {
                return _skipColon2(true);
            } else {
                this._inputPtr++;
                return c2;
            }
        } else {
            if (c == ' ' || c == '\t') {
                char[] cArr3 = this._inputBuffer;
                int i3 = this._inputPtr + 1;
                this._inputPtr = i3;
                c = cArr3[i3];
            }
            if (c != ':') {
                return _skipColon2(false);
            }
            char[] cArr4 = this._inputBuffer;
            int i4 = this._inputPtr + 1;
            this._inputPtr = i4;
            char c4 = cArr4[i4];
            if (c4 <= ' ') {
                if (c4 == ' ' || c4 == '\t') {
                    char[] cArr5 = this._inputBuffer;
                    int i5 = this._inputPtr + 1;
                    this._inputPtr = i5;
                    char c5 = cArr5[i5];
                    if (c5 > ' ') {
                        if (c5 == '/' || c5 == '#') {
                            return _skipColon2(true);
                        }
                        this._inputPtr++;
                        return c5;
                    }
                }
                return _skipColon2(true);
            } else if (c4 == '/' || c4 == '#') {
                return _skipColon2(true);
            } else {
                this._inputPtr++;
                return c4;
            }
        }
    }

    private final int _skipColon2(boolean gotColon) throws IOException {
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                if (c > ' ') {
                    if (c == '/') {
                        _skipComment();
                    } else if (c != '#' || !_skipYAMLComment()) {
                        if (gotColon) {
                            return c;
                        }
                        if (c != ':') {
                            _reportUnexpectedChar(c, "was expecting a colon to separate field name and value");
                        }
                        gotColon = true;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (c == '\r') {
                        _skipCR();
                    } else if (c != '\t') {
                        _throwInvalidSpace(c);
                    }
                }
            } else {
                _reportInvalidEOF(" within/between " + this._parsingContext.typeDesc() + " entries", null);
                return -1;
            }
        }
    }

    private final int _skipColonFast(int ptr) throws IOException {
        int ptr2 = ptr + 1;
        char c = this._inputBuffer[ptr];
        if (c == ':') {
            int ptr3 = ptr2 + 1;
            char c2 = this._inputBuffer[ptr2];
            if (c2 > ' ') {
                if (!(c2 == '/' || c2 == '#')) {
                    this._inputPtr = ptr3;
                    return c2;
                }
            } else if (c2 == ' ' || c2 == '\t') {
                ptr3++;
                char c3 = this._inputBuffer[ptr3];
                if (!(c3 <= ' ' || c3 == '/' || c3 == '#')) {
                    this._inputPtr = ptr3;
                    return c3;
                }
            }
            this._inputPtr = ptr3 - 1;
            return _skipColon2(true);
        }
        if (c == ' ' || c == '\t') {
            ptr2++;
            c = this._inputBuffer[ptr2];
        }
        boolean gotColon = c == ':';
        if (gotColon) {
            ptr2++;
            char c4 = this._inputBuffer[ptr2];
            if (c4 > ' ') {
                if (!(c4 == '/' || c4 == '#')) {
                    this._inputPtr = ptr2;
                    return c4;
                }
            } else if (c4 == ' ' || c4 == '\t') {
                ptr2++;
                char c5 = this._inputBuffer[ptr2];
                if (!(c5 <= ' ' || c5 == '/' || c5 == '#')) {
                    this._inputPtr = ptr2;
                    return c5;
                }
            }
        }
        this._inputPtr = ptr2 - 1;
        return _skipColon2(gotColon);
    }

    private final int _skipComma(int i) throws IOException {
        if (i != 44) {
            _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        while (this._inputPtr < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            char c = cArr[i2];
            if (c > ' ') {
                if (c != '/' && c != '#') {
                    return c;
                }
                this._inputPtr--;
                return _skipAfterComma2();
            } else if (c < ' ') {
                if (c == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (c == '\r') {
                    _skipCR();
                } else if (c != '\t') {
                    _throwInvalidSpace(c);
                }
            }
        }
        return _skipAfterComma2();
    }

    private final int _skipAfterComma2() throws IOException {
        char c;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                c = cArr[i];
                if (c > ' ') {
                    if (c == '/') {
                        _skipComment();
                    } else if (c != '#' || !_skipYAMLComment()) {
                        break;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (c == '\r') {
                        _skipCR();
                    } else if (c != '\t') {
                        _throwInvalidSpace(c);
                    }
                }
            } else {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.typeDesc() + " entries");
            }
        }
        return c;
    }

    private final int _skipWSOrEnd() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return _eofAsNextChar();
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        if (c <= ' ') {
            if (c != ' ') {
                if (c == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (c == '\r') {
                    _skipCR();
                } else if (c != '\t') {
                    _throwInvalidSpace(c);
                }
            }
            while (this._inputPtr < this._inputEnd) {
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                char c2 = cArr2[i2];
                if (c2 > ' ') {
                    if (c2 != '/' && c2 != '#') {
                        return c2;
                    }
                    this._inputPtr--;
                    return _skipWSOrEnd2();
                } else if (c2 != ' ') {
                    if (c2 == '\n') {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (c2 == '\r') {
                        _skipCR();
                    } else if (c2 != '\t') {
                        _throwInvalidSpace(c2);
                    }
                }
            }
            return _skipWSOrEnd2();
        } else if (c != '/' && c != '#') {
            return c;
        } else {
            this._inputPtr--;
            return _skipWSOrEnd2();
        }
    }

    private int _skipWSOrEnd2() throws IOException {
        char c;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            c = cArr[i];
            if (c > ' ') {
                if (c == '/') {
                    _skipComment();
                } else if (c != '#' || !_skipYAMLComment()) {
                    break;
                }
            } else if (c != ' ') {
                if (c == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (c == '\r') {
                    _skipCR();
                } else if (c != '\t') {
                    _throwInvalidSpace(c);
                }
            }
        }
        return c;
    }

    private void _skipComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in a comment", null);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        if (c == '/') {
            _skipLine();
        } else if (c == '*') {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private void _skipCComment() throws IOException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        break;
                    } else if (this._inputBuffer[this._inputPtr] == '/') {
                        this._inputPtr++;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (c == '\r') {
                        _skipCR();
                    } else if (c != '\t') {
                        _throwInvalidSpace(c);
                    }
                }
            }
        }
        _reportInvalidEOF(" in a comment", null);
    }

    private boolean _skipYAMLComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private void _skipLine() throws IOException {
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == '\n') {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                        return;
                    } else if (c == '\r') {
                        _skipCR();
                        return;
                    } else if (c != '\t') {
                        _throwInvalidSpace(c);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected char _decodeEscaped() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        switch (c) {
            case '\"':
            case '/':
            case '\\':
                return c;
            case 'b':
                return '\b';
            case 'f':
                return '\f';
            case 'n':
                return '\n';
            case 'r':
                return '\r';
            case 't':
                return '\t';
            case 'u':
                int value = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
                    }
                    char[] cArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    char c2 = cArr2[i3];
                    int digit = CharTypes.charToHex(c2);
                    if (digit < 0) {
                        _reportUnexpectedChar(c2, "expected a hex-digit for character escape sequence");
                    }
                    value = (value << 4) | digit;
                }
                return (char) value;
            default:
                return _handleUnrecognizedCharacterEscape(c);
        }
    }

    private final void _matchTrue() throws IOException {
        int ptr;
        char c;
        int ptr2 = this._inputPtr;
        if (ptr2 + 3 < this._inputEnd) {
            char[] b = this._inputBuffer;
            if (b[ptr2] == 'r') {
                int ptr3 = ptr2 + 1;
                if (b[ptr3] == 'u') {
                    int ptr4 = ptr3 + 1;
                    if (b[ptr4] == 'e' && ((c = b[(ptr = ptr4 + 1)]) < '0' || c == ']' || c == '}')) {
                        this._inputPtr = ptr;
                        return;
                    }
                }
            }
        }
        _matchToken(C3P0Substitutions.DEBUG, 1);
    }

    private final void _matchFalse() throws IOException {
        int ptr;
        char c;
        int ptr2 = this._inputPtr;
        if (ptr2 + 4 < this._inputEnd) {
            char[] b = this._inputBuffer;
            if (b[ptr2] == 'a') {
                int ptr3 = ptr2 + 1;
                if (b[ptr3] == 'l') {
                    int ptr4 = ptr3 + 1;
                    if (b[ptr4] == 's') {
                        int ptr5 = ptr4 + 1;
                        if (b[ptr5] == 'e' && ((c = b[(ptr = ptr5 + 1)]) < '0' || c == ']' || c == '}')) {
                            this._inputPtr = ptr;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken("false", 1);
    }

    private final void _matchNull() throws IOException {
        int ptr;
        char c;
        int ptr2 = this._inputPtr;
        if (ptr2 + 3 < this._inputEnd) {
            char[] b = this._inputBuffer;
            if (b[ptr2] == 'u') {
                int ptr3 = ptr2 + 1;
                if (b[ptr3] == 'l') {
                    int ptr4 = ptr3 + 1;
                    if (b[ptr4] == 'l' && ((c = b[(ptr = ptr4 + 1)]) < '0' || c == ']' || c == '}')) {
                        this._inputPtr = ptr;
                        return;
                    }
                }
            }
        }
        _matchToken("null", 1);
    }

    protected final void _matchToken(String matchStr, int i) throws IOException {
        int len = matchStr.length();
        if (this._inputPtr + len >= this._inputEnd) {
            _matchToken2(matchStr, i);
            return;
        }
        do {
            if (this._inputBuffer[this._inputPtr] != matchStr.charAt(i)) {
                _reportInvalidToken(matchStr.substring(0, i));
            }
            this._inputPtr++;
            i++;
        } while (i < len);
        char c = this._inputBuffer[this._inputPtr];
        if (c >= '0' && c != ']' && c != '}') {
            _checkMatchEnd(matchStr, i, c);
        }
    }

    private final void _matchToken2(String matchStr, int i) throws IOException {
        char c;
        int len = matchStr.length();
        do {
            if ((this._inputPtr >= this._inputEnd && !_loadMore()) || this._inputBuffer[this._inputPtr] != matchStr.charAt(i)) {
                _reportInvalidToken(matchStr.substring(0, i));
            }
            this._inputPtr++;
            i++;
        } while (i < len);
        if ((this._inputPtr < this._inputEnd || _loadMore()) && (c = this._inputBuffer[this._inputPtr]) >= '0' && c != ']' && c != '}') {
            _checkMatchEnd(matchStr, i, c);
        }
    }

    private final void _checkMatchEnd(String matchStr, int i, int c) throws IOException {
        if (Character.isJavaIdentifierPart((char) c)) {
            _reportInvalidToken(matchStr.substring(0, i));
        }
    }

    protected byte[] _decodeBase64(Base64Variant b64variant) throws IOException {
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char ch = cArr[i];
            if (ch > ' ') {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == '\"') {
                        return builder.toByteArray();
                    }
                    bits = _decodeBase64Escape(b64variant, ch, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                char ch2 = cArr2[i2];
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData = (bits << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                char ch3 = cArr3[i3];
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 == '\"') {
                            builder.append(decodedData >> 4);
                            if (b64variant.usesPadding()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(b64variant);
                            }
                            return builder.toByteArray();
                        }
                        bits3 = _decodeBase64Escape(b64variant, ch3, 2);
                    }
                    if (bits3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        char ch4 = cArr4[i4];
                        if (b64variant.usesPaddingChar(ch4) || _decodeBase64Escape(b64variant, ch4, 3) == -2) {
                            builder.append(decodedData >> 4);
                        } else {
                            throw reportInvalidBase64Char(b64variant, ch4, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
                        }
                    }
                }
                int decodedData2 = (decodedData << 6) | bits3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                char ch5 = cArr5[i5];
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 == '\"') {
                            builder.appendTwoBytes(decodedData2 >> 2);
                            if (b64variant.usesPadding()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(b64variant);
                            }
                            return builder.toByteArray();
                        }
                        bits4 = _decodeBase64Escape(b64variant, ch5, 3);
                    }
                    if (bits4 == -2) {
                        builder.appendTwoBytes(decodedData2 >> 2);
                    }
                }
                builder.appendThreeBytes((decodedData2 << 6) | bits4);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return new JsonLocation(_contentReference(), -1L, this._tokenInputTotal - 1, this._tokenInputRow, this._tokenInputCol);
        }
        return new JsonLocation(_contentReference(), -1L, this._currInputProcessed + (this._nameStartOffset - 1), this._nameStartRow, this._nameStartCol);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return new JsonLocation(_contentReference(), -1L, this._currInputProcessed + ((long) this._inputPtr), this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    private final void _updateLocation() {
        int ptr = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + ((long) ptr);
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = ptr - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        int ptr = this._inputPtr;
        this._nameStartOffset = (long) ptr;
        this._nameStartRow = this._currInputRow;
        this._nameStartCol = ptr - this._currInputRowStart;
    }

    protected void _reportInvalidToken(String matchedPart) throws IOException {
        _reportInvalidToken(matchedPart, _validJsonTokenList());
    }

    protected void _reportInvalidToken(String matchedPart, String msg) throws IOException {
        StringBuilder sb = new StringBuilder(matchedPart);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char c = this._inputBuffer[this._inputPtr];
            if (Character.isJavaIdentifierPart(c)) {
                this._inputPtr++;
                sb.append(c);
                if (sb.length() >= 256) {
                    sb.append("...");
                    break;
                }
            } else {
                break;
            }
        }
        _reportError("Unrecognized token '%s': was expecting %s", sb, msg);
    }

    private void _closeScope(int i) throws JsonParseException {
        if (i == 93) {
            _updateLocation();
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_ARRAY;
        }
        if (i == 125) {
            _updateLocation();
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_OBJECT;
        }
    }
}
