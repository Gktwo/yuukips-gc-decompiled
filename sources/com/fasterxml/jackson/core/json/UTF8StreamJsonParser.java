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
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/json/UTF8StreamJsonParser.class */
public class UTF8StreamJsonParser extends ParserBase {
    static final byte BYTE_LF = 10;
    private static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int FEAT_MASK_NON_NUM_NUMBERS = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] _icUTF8 = CharTypes.getInputCodeUtf8();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
    protected ObjectCodec _objectCodec;
    protected final ByteQuadsCanonicalizer _symbols;
    protected int[] _quadBuffer;
    protected boolean _tokenIncomplete;
    private int _quad1;
    protected int _nameStartOffset;
    protected int _nameStartRow;
    protected int _nameStartCol;
    protected InputStream _inputStream;
    protected byte[] _inputBuffer;
    protected boolean _bufferRecyclable;

    @Deprecated
    public UTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, ByteQuadsCanonicalizer sym, byte[] inputBuffer, int start, int end, boolean bufferRecyclable) {
        this(ctxt, features, in, codec, sym, inputBuffer, start, end, 0, bufferRecyclable);
    }

    public UTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, ByteQuadsCanonicalizer sym, byte[] inputBuffer, int start, int end, int bytesPreProcessed, boolean bufferRecyclable) {
        super(ctxt, features);
        this._quadBuffer = new int[16];
        this._inputStream = in;
        this._objectCodec = codec;
        this._symbols = sym;
        this._inputBuffer = inputBuffer;
        this._inputPtr = start;
        this._inputEnd = end;
        this._currInputRowStart = start - bytesPreProcessed;
        this._currInputProcessed = (long) ((-start) + bytesPreProcessed);
        this._bufferRecyclable = bufferRecyclable;
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
    public int releaseBuffered(OutputStream out) throws IOException {
        int count = this._inputEnd - this._inputPtr;
        if (count < 1) {
            return 0;
        }
        int origPtr = this._inputPtr;
        this._inputPtr += count;
        out.write(this._inputBuffer, origPtr, count);
        return count;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._inputStream;
    }

    protected final boolean _loadMore() throws IOException {
        int space;
        if (this._inputStream == null || (space = this._inputBuffer.length) == 0) {
            return false;
        }
        int count = this._inputStream.read(this._inputBuffer, 0, space);
        if (count > 0) {
            int bufSize = this._inputEnd;
            this._currInputProcessed += (long) bufSize;
            this._currInputRowStart -= bufSize;
            this._nameStartOffset -= bufSize;
            this._inputPtr = 0;
            this._inputEnd = count;
            return true;
        }
        _closeInput();
        if (count != 0) {
            return false;
        }
        throw new IOException("InputStream.read() returned 0 characters when trying to read " + this._inputBuffer.length + " bytes");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _closeInput() throws IOException {
        if (this._inputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._inputStream.close();
            }
            this._inputStream = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() throws IOException {
        byte[] buf;
        _releaseBuffers();
        this._symbols.release();
        if (this._bufferRecyclable && (buf = this._inputBuffer) != null && buf != NO_BYTES) {
            this._inputBuffer = NO_BYTES;
            this._ioContext.releaseReadIOBuffer(buf);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        if (this._currToken != JsonToken.VALUE_STRING) {
            return _getText2(this._currToken);
        }
        if (!this._tokenIncomplete) {
            return this._textBuffer.contentsAsString();
        }
        this._tokenIncomplete = false;
        return _finishAndReturnString();
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
    public String getValueAsString() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (!this._tokenIncomplete) {
                return this._textBuffer.contentsAsString();
            }
            this._tokenIncomplete = false;
            return _finishAndReturnString();
        } else if (this._currToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return getValueAsString(null);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String defValue) throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (!this._tokenIncomplete) {
                return this._textBuffer.contentsAsString();
            }
            this._tokenIncomplete = false;
            return _finishAndReturnString();
        } else if (this._currToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        } else {
            return getValueAsString(defValue);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() throws IOException {
        JsonToken t = this._currToken;
        if (t != JsonToken.VALUE_NUMBER_INT && t != JsonToken.VALUE_NUMBER_FLOAT) {
            return getValueAsInt(0);
        }
        if ((this._numTypesValid & 1) == 0) {
            if (this._numTypesValid == 0) {
                return _parseIntValue();
            }
            if ((this._numTypesValid & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int defValue) throws IOException {
        JsonToken t = this._currToken;
        if (t != JsonToken.VALUE_NUMBER_INT && t != JsonToken.VALUE_NUMBER_FLOAT) {
            return getValueAsInt(defValue);
        }
        if ((this._numTypesValid & 1) == 0) {
            if (this._numTypesValid == 0) {
                return _parseIntValue();
            }
            if ((this._numTypesValid & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
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
    public char[] getTextCharacters() throws IOException {
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
    public int getTextLength() throws IOException {
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
    public int getTextOffset() throws IOException {
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
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
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
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch > 32) {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == 34) {
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
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int ch2 = bArr2[i2] & 255;
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData = (bits << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int ch3 = bArr3[i3] & 255;
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 == 34) {
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
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        int ch4 = bArr4[i4] & 255;
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
                byte[] bArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int ch5 = bArr5[i5] & 255;
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 == 34) {
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

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
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
        if (i == 93) {
            _closeArrayScope();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            this._currToken = jsonToken;
            return jsonToken;
        } else if (i == 125) {
            _closeObjectScope();
            JsonToken jsonToken2 = JsonToken.END_OBJECT;
            this._currToken = jsonToken2;
            return jsonToken2;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i != 44) {
                    _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
                }
                i = _skipWS();
                if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                    return _closeScope(i);
                }
            }
            if (!this._parsingContext.inObject()) {
                _updateLocation();
                return _nextTokenNotInObject(i);
            }
            _updateNameLocation();
            this._parsingContext.setCurrentName(_parseName(i));
            this._currToken = JsonToken.FIELD_NAME;
            int i2 = _skipColon();
            _updateLocation();
            if (i2 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return this._currToken;
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
                    t = _handleUnexpectedValue(i2);
                    break;
            }
            this._nextToken = t;
            return this._currToken;
        }
    }

    private final JsonToken _nextTokenNotInObject(int i) throws IOException {
        if (i == 34) {
            this._tokenIncomplete = true;
            JsonToken jsonToken = JsonToken.VALUE_STRING;
            this._currToken = jsonToken;
            return jsonToken;
        }
        switch (i) {
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
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                this._currToken = jsonToken2;
                return jsonToken2;
            case 102:
                _matchFalse();
                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                this._currToken = jsonToken3;
                return jsonToken3;
            case 110:
                _matchNull();
                JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                this._currToken = jsonToken4;
                return jsonToken4;
            case 116:
                _matchTrue();
                JsonToken jsonToken5 = JsonToken.VALUE_TRUE;
                this._currToken = jsonToken5;
                return jsonToken5;
            case 123:
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                JsonToken jsonToken6 = JsonToken.START_OBJECT;
                this._currToken = jsonToken6;
                return jsonToken6;
            default:
                JsonToken _handleUnexpectedValue = _handleUnexpectedValue(i);
                this._currToken = _handleUnexpectedValue;
                return _handleUnexpectedValue;
        }
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
    public boolean nextFieldName(SerializableString str) throws IOException {
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
        if (i == 93) {
            _closeArrayScope();
            this._currToken = JsonToken.END_ARRAY;
            return false;
        } else if (i == 125) {
            _closeObjectScope();
            this._currToken = JsonToken.END_OBJECT;
            return false;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i != 44) {
                    _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
                }
                i = _skipWS();
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
                byte[] nameBytes = str.asQuotedUTF8();
                int len = nameBytes.length;
                if (this._inputPtr + len + 4 < this._inputEnd) {
                    int end = this._inputPtr + len;
                    if (this._inputBuffer[end] == 34) {
                        int offset = 0;
                        int ptr = this._inputPtr;
                        while (ptr != end) {
                            if (nameBytes[offset] == this._inputBuffer[ptr]) {
                                offset++;
                                ptr++;
                            }
                        }
                        this._parsingContext.setCurrentName(str.getValue());
                        _isNextTokenNameYes(_skipColonFast(ptr + 1));
                        return true;
                    }
                }
            }
            return _isNextTokenNameMaybe(i, str);
        }
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
        if (i == 93) {
            _closeArrayScope();
            this._currToken = JsonToken.END_ARRAY;
            return null;
        } else if (i == 125) {
            _closeObjectScope();
            this._currToken = JsonToken.END_OBJECT;
            return null;
        } else {
            if (this._parsingContext.expectComma()) {
                if (i != 44) {
                    _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
                }
                i = _skipWS();
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
            String nameStr = _parseName(i);
            this._parsingContext.setCurrentName(nameStr);
            this._currToken = JsonToken.FIELD_NAME;
            int i2 = _skipColon();
            _updateLocation();
            if (i2 == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return nameStr;
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
                    t = _handleUnexpectedValue(i2);
                    break;
            }
            this._nextToken = t;
            return nameStr;
        }
    }

    private final int _skipColonFast(int ptr) throws IOException {
        int ptr2 = ptr + 1;
        byte b = this._inputBuffer[ptr];
        if (b == 58) {
            int ptr3 = ptr2 + 1;
            byte b2 = this._inputBuffer[ptr2];
            if (b2 > 32) {
                if (!(b2 == 47 || b2 == 35)) {
                    this._inputPtr = ptr3;
                    return b2;
                }
            } else if (b2 == 32 || b2 == 9) {
                ptr3++;
                byte b3 = this._inputBuffer[ptr3];
                if (!(b3 <= 32 || b3 == 47 || b3 == 35)) {
                    this._inputPtr = ptr3;
                    return b3;
                }
            }
            this._inputPtr = ptr3 - 1;
            return _skipColon2(true);
        }
        if (b == 32 || b == 9) {
            ptr2++;
            b = this._inputBuffer[ptr2];
        }
        if (b == 58) {
            int ptr4 = ptr2 + 1;
            byte b4 = this._inputBuffer[ptr2];
            if (b4 > 32) {
                if (!(b4 == 47 || b4 == 35)) {
                    this._inputPtr = ptr4;
                    return b4;
                }
            } else if (b4 == 32 || b4 == 9) {
                ptr4++;
                byte b5 = this._inputBuffer[ptr4];
                if (!(b5 <= 32 || b5 == 47 || b5 == 35)) {
                    this._inputPtr = ptr4;
                    return b5;
                }
            }
            this._inputPtr = ptr4 - 1;
            return _skipColon2(true);
        }
        this._inputPtr = ptr2 - 1;
        return _skipColon2(false);
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
                _matchFalse();
                this._nextToken = JsonToken.VALUE_FALSE;
                return;
            case 110:
                _matchNull();
                this._nextToken = JsonToken.VALUE_NULL;
                return;
            case 116:
                _matchTrue();
                this._nextToken = JsonToken.VALUE_TRUE;
                return;
            case 123:
                this._nextToken = JsonToken.START_OBJECT;
                return;
            default:
                this._nextToken = _handleUnexpectedValue(i);
                return;
        }
    }

    private final boolean _isNextTokenNameMaybe(int i, SerializableString str) throws IOException {
        JsonToken t;
        String n = _parseName(i);
        this._parsingContext.setCurrentName(n);
        boolean match = n.equals(str.getValue());
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipColon();
        _updateLocation();
        if (i2 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return match;
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
                t = _handleUnexpectedValue(i2);
                break;
        }
        this._nextToken = t;
        return match;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextTextValue() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            this._nameCopied = false;
            JsonToken t = this._nextToken;
            this._nextToken = null;
            this._currToken = t;
            if (t == JsonToken.VALUE_STRING) {
                if (!this._tokenIncomplete) {
                    return this._textBuffer.contentsAsString();
                }
                this._tokenIncomplete = false;
                return _finishAndReturnString();
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
    public int nextIntValue(int defaultValue) throws IOException {
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
    public long nextLongValue(long defaultValue) throws IOException {
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
    public Boolean nextBooleanValue() throws IOException {
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
            if (t2 == JsonToken.VALUE_TRUE) {
                return Boolean.TRUE;
            }
            if (t2 == JsonToken.VALUE_FALSE) {
                return Boolean.FALSE;
            }
            return null;
        }
    }

    protected final JsonToken _parseFloatThatStartsWithPeriod() throws IOException {
        if (!isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
            return _handleUnexpectedValue(46);
        }
        return _parseFloat(this._textBuffer.emptyAndGetCurrentSegment(), 0, 46, false, 0);
    }

    protected JsonToken _parsePosNumber(int c) throws IOException {
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        if (c == 48) {
            c = _verifyNoLeadingZeroes();
        }
        outBuf[0] = (char) c;
        int intLen = 1;
        int outPtr = 1;
        int end = Math.min(this._inputEnd, (this._inputPtr + outBuf.length) - 1);
        while (this._inputPtr < end) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int c2 = bArr[i] & 255;
            if (c2 >= 48 && c2 <= 57) {
                intLen++;
                outPtr++;
                outBuf[outPtr] = (char) c2;
            } else if (c2 == 46 || c2 == 101 || c2 == 69) {
                return _parseFloat(outBuf, outPtr, c2, false, intLen);
            } else {
                this._inputPtr--;
                this._textBuffer.setCurrentLength(outPtr);
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c2);
                }
                return resetInt(false, intLen);
            }
        }
        return _parseNumber2(outBuf, outPtr, false, intLen);
    }

    protected JsonToken _parseNegNumber() throws IOException {
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = 0 + 1;
        outBuf[0] = '-';
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int c = bArr[i] & 255;
        if (c <= 48) {
            if (c != 48) {
                return _handleInvalidNumberStart(c, true);
            }
            c = _verifyNoLeadingZeroes();
        } else if (c > 57) {
            return _handleInvalidNumberStart(c, true);
        }
        int outPtr2 = outPtr + 1;
        outBuf[outPtr] = (char) c;
        int intLen = 1;
        int end = Math.min(this._inputEnd, (this._inputPtr + outBuf.length) - outPtr2);
        while (this._inputPtr < end) {
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            int c2 = bArr2[i2] & 255;
            if (c2 >= 48 && c2 <= 57) {
                intLen++;
                outPtr2++;
                outBuf[outPtr2] = (char) c2;
            } else if (c2 == 46 || c2 == 101 || c2 == 69) {
                return _parseFloat(outBuf, outPtr2, c2, true, intLen);
            } else {
                this._inputPtr--;
                this._textBuffer.setCurrentLength(outPtr2);
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c2);
                }
                return resetInt(true, intLen);
            }
        }
        return _parseNumber2(outBuf, outPtr2, true, intLen);
    }

    private final JsonToken _parseNumber2(char[] outBuf, int outPtr, boolean negative, int intPartLength) throws IOException {
        int c;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                c = bArr[i] & 255;
                if (c > 57 || c < 48) {
                    break;
                }
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                intPartLength++;
            } else {
                this._textBuffer.setCurrentLength(outPtr);
                return resetInt(negative, intPartLength);
            }
        }
        if (c == 46 || c == 101 || c == 69) {
            return _parseFloat(outBuf, outPtr, c, negative, intPartLength);
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(outPtr);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace(this._inputBuffer[this._inputPtr] & 255);
        }
        return resetInt(negative, intPartLength);
    }

    private final int _verifyNoLeadingZeroes() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return 48;
        }
        int ch = this._inputBuffer[this._inputPtr] & 255;
        if (ch < 48 || ch > 57) {
            return 48;
        }
        if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (ch == 48) {
            do {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    break;
                }
                ch = this._inputBuffer[this._inputPtr] & 255;
                if (ch < 48 || ch > 57) {
                    return 48;
                }
                this._inputPtr++;
            } while (ch == 48);
        }
        return ch;
    }

    private final JsonToken _parseFloat(char[] outBuf, int outPtr, int c, boolean negative, int integerPartLength) throws IOException {
        int fractLen = 0;
        boolean eof = false;
        if (c == 46) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = (char) c;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    eof = true;
                    break;
                }
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                c = bArr[i] & 255;
                if (c < 48 || c > 57) {
                    break;
                }
                fractLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
            }
            if (fractLen == 0) {
                reportUnexpectedNumberChar(c, "Decimal point not followed by a digit");
            }
        }
        int expLen = 0;
        if (c == 101 || c == 69) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = (char) c;
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            c = bArr2[i2] & 255;
            if (c == 45 || c == 43) {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                c = bArr3[i3] & 255;
            }
            while (true) {
                if (c < 48 || c > 57) {
                    break;
                }
                expLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    eof = true;
                    break;
                }
                byte[] bArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                c = bArr4[i4] & 255;
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
        return resetFloat(negative, integerPartLength, fractLen, expLen);
    }

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

    protected final String _parseName(int i) throws IOException {
        if (i != 34) {
            return _handleOddName(i);
        }
        if (this._inputPtr + 13 > this._inputEnd) {
            return slowParseName();
        }
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        int q = input[i2] & 255;
        if (codes[q] == 0) {
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & 255;
            if (codes[i4] == 0) {
                int q2 = (q << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & 255;
                if (codes[i6] == 0) {
                    int q3 = (q2 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = input[i7] & 255;
                    if (codes[i8] == 0) {
                        int q4 = (q3 << 8) | i8;
                        int i9 = this._inputPtr;
                        this._inputPtr = i9 + 1;
                        int i10 = input[i9] & 255;
                        if (codes[i10] == 0) {
                            this._quad1 = q4;
                            return parseMediumName(i10);
                        } else if (i10 == 34) {
                            return findName(q4, 4);
                        } else {
                            return parseName(q4, i10, 4);
                        }
                    } else if (i8 == 34) {
                        return findName(q3, 3);
                    } else {
                        return parseName(q3, i8, 3);
                    }
                } else if (i6 == 34) {
                    return findName(q2, 2);
                } else {
                    return parseName(q2, i6, 2);
                }
            } else if (i4 == 34) {
                return findName(q, 1);
            } else {
                return parseName(q, i4, 1);
            }
        } else if (q == 34) {
            return "";
        } else {
            return parseName(0, q, 0);
        }
    }

    protected final String parseMediumName(int q2) throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = input[i] & 255;
        if (codes[i2] == 0) {
            int q22 = (q2 << 8) | i2;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & 255;
            if (codes[i4] == 0) {
                int q23 = (q22 << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & 255;
                if (codes[i6] == 0) {
                    int q24 = (q23 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = input[i7] & 255;
                    if (codes[i8] == 0) {
                        return parseMediumName2(i8, q24);
                    }
                    if (i8 == 34) {
                        return findName(this._quad1, q24, 4);
                    }
                    return parseName(this._quad1, q24, i8, 4);
                } else if (i6 == 34) {
                    return findName(this._quad1, q23, 3);
                } else {
                    return parseName(this._quad1, q23, i6, 3);
                }
            } else if (i4 == 34) {
                return findName(this._quad1, q22, 2);
            } else {
                return parseName(this._quad1, q22, i4, 2);
            }
        } else if (i2 == 34) {
            return findName(this._quad1, q2, 1);
        } else {
            return parseName(this._quad1, q2, i2, 1);
        }
    }

    protected final String parseMediumName2(int q3, int q2) throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = input[i] & 255;
        if (codes[i2] == 0) {
            int q32 = (q3 << 8) | i2;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            int i4 = input[i3] & 255;
            if (codes[i4] == 0) {
                int q33 = (q32 << 8) | i4;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int i6 = input[i5] & 255;
                if (codes[i6] == 0) {
                    int q34 = (q33 << 8) | i6;
                    int i7 = this._inputPtr;
                    this._inputPtr = i7 + 1;
                    int i8 = input[i7] & 255;
                    if (codes[i8] == 0) {
                        return parseLongName(i8, q2, q34);
                    }
                    if (i8 == 34) {
                        return findName(this._quad1, q2, q34, 4);
                    }
                    return parseName(this._quad1, q2, q34, i8, 4);
                } else if (i6 == 34) {
                    return findName(this._quad1, q2, q33, 3);
                } else {
                    return parseName(this._quad1, q2, q33, i6, 3);
                }
            } else if (i4 == 34) {
                return findName(this._quad1, q2, q32, 2);
            } else {
                return parseName(this._quad1, q2, q32, i4, 2);
            }
        } else if (i2 == 34) {
            return findName(this._quad1, q2, q3, 1);
        } else {
            return parseName(this._quad1, q2, q3, i2, 1);
        }
    }

    protected final String parseLongName(int q, int q2, int q3) throws IOException {
        this._quadBuffer[0] = this._quad1;
        this._quadBuffer[1] = q2;
        this._quadBuffer[2] = q3;
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int qlen = 3;
        while (this._inputPtr + 4 <= this._inputEnd) {
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = input[i] & 255;
            if (codes[i2] == 0) {
                int q4 = (q << 8) | i2;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int i4 = input[i3] & 255;
                if (codes[i4] == 0) {
                    int q5 = (q4 << 8) | i4;
                    int i5 = this._inputPtr;
                    this._inputPtr = i5 + 1;
                    int i6 = input[i5] & 255;
                    if (codes[i6] == 0) {
                        int q6 = (q5 << 8) | i6;
                        int i7 = this._inputPtr;
                        this._inputPtr = i7 + 1;
                        int i8 = input[i7] & 255;
                        if (codes[i8] == 0) {
                            if (qlen >= this._quadBuffer.length) {
                                this._quadBuffer = growArrayBy(this._quadBuffer, qlen);
                            }
                            qlen++;
                            this._quadBuffer[qlen] = q6;
                            q = i8;
                        } else if (i8 == 34) {
                            return findName(this._quadBuffer, qlen, q6, 4);
                        } else {
                            return parseEscapedName(this._quadBuffer, qlen, q6, i8, 4);
                        }
                    } else if (i6 == 34) {
                        return findName(this._quadBuffer, qlen, q5, 3);
                    } else {
                        return parseEscapedName(this._quadBuffer, qlen, q5, i6, 3);
                    }
                } else if (i4 == 34) {
                    return findName(this._quadBuffer, qlen, q4, 2);
                } else {
                    return parseEscapedName(this._quadBuffer, qlen, q4, i4, 2);
                }
            } else if (i2 == 34) {
                return findName(this._quadBuffer, qlen, q, 1);
            } else {
                return parseEscapedName(this._quadBuffer, qlen, q, i2, 1);
            }
        }
        return parseEscapedName(this._quadBuffer, qlen, 0, q, 0);
    }

    protected String slowParseName() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(": was expecting closing '\"' for name", JsonToken.FIELD_NAME);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 == 34) {
            return "";
        }
        return parseEscapedName(this._quadBuffer, 0, 0, i2, 0);
    }

    private final String parseName(int q1, int ch, int lastQuadBytes) throws IOException {
        return parseEscapedName(this._quadBuffer, 0, q1, ch, lastQuadBytes);
    }

    private final String parseName(int q1, int q2, int ch, int lastQuadBytes) throws IOException {
        this._quadBuffer[0] = q1;
        return parseEscapedName(this._quadBuffer, 1, q2, ch, lastQuadBytes);
    }

    private final String parseName(int q1, int q2, int q3, int ch, int lastQuadBytes) throws IOException {
        this._quadBuffer[0] = q1;
        this._quadBuffer[1] = q2;
        return parseEscapedName(this._quadBuffer, 2, q3, ch, lastQuadBytes);
    }

    protected final String parseEscapedName(int[] quads, int qlen, int currQuad, int ch, int currQuadBytes) throws IOException {
        int[] codes = _icLatin1;
        while (true) {
            if (codes[ch] != 0) {
                if (ch == 34) {
                    break;
                }
                if (ch != 92) {
                    _throwUnquotedSpace(ch, "name");
                } else {
                    ch = _decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            int[] growArrayBy = growArrayBy(quads, quads.length);
                            quads = growArrayBy;
                            this._quadBuffer = growArrayBy;
                        }
                        qlen++;
                        quads[qlen] = currQuad;
                        currQuad = 0;
                        currQuadBytes = 0;
                    }
                    if (ch < 2048) {
                        currQuad = (currQuad << 8) | 192 | (ch >> 6);
                        currQuadBytes++;
                    } else {
                        int currQuad2 = (currQuad << 8) | 224 | (ch >> 12);
                        int currQuadBytes2 = currQuadBytes + 1;
                        if (currQuadBytes2 >= 4) {
                            if (qlen >= quads.length) {
                                int[] growArrayBy2 = growArrayBy(quads, quads.length);
                                quads = growArrayBy2;
                                this._quadBuffer = growArrayBy2;
                            }
                            qlen++;
                            quads[qlen] = currQuad2;
                            currQuad2 = 0;
                            currQuadBytes2 = 0;
                        }
                        currQuad = (currQuad2 << 8) | 128 | ((ch >> 6) & 63);
                        currQuadBytes = currQuadBytes2 + 1;
                    }
                    ch = 128 | (ch & 63);
                }
            }
            if (currQuadBytes < 4) {
                currQuadBytes++;
                currQuad = (currQuad << 8) | ch;
            } else {
                if (qlen >= quads.length) {
                    int[] growArrayBy3 = growArrayBy(quads, quads.length);
                    quads = growArrayBy3;
                    this._quadBuffer = growArrayBy3;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            ch = bArr[i] & 255;
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                int[] growArrayBy4 = growArrayBy(quads, quads.length);
                quads = growArrayBy4;
                this._quadBuffer = growArrayBy4;
            }
            qlen++;
            quads[qlen] = _padLastQuad(currQuad, currQuadBytes);
        }
        String name = this._symbols.findName(quads, qlen);
        if (name == null) {
            name = addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    protected String _handleOddName(int ch) throws IOException {
        if (ch == 39 && (this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return _parseAposName();
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar((char) _decodeCharForError(ch), "was expecting double-quote to start field name");
        }
        int[] codes = CharTypes.getInputCodeUtf8JsNames();
        if (codes[ch] != 0) {
            _reportUnexpectedChar(ch, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] quads = this._quadBuffer;
        int qlen = 0;
        int currQuad = 0;
        int currQuadBytes = 0;
        while (true) {
            if (currQuadBytes < 4) {
                currQuadBytes++;
                currQuad = (currQuad << 8) | ch;
            } else {
                if (qlen >= quads.length) {
                    int[] growArrayBy = growArrayBy(quads, quads.length);
                    quads = growArrayBy;
                    this._quadBuffer = growArrayBy;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            ch = this._inputBuffer[this._inputPtr] & 255;
            if (codes[ch] != 0) {
                break;
            }
            this._inputPtr++;
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                int[] growArrayBy2 = growArrayBy(quads, quads.length);
                quads = growArrayBy2;
                this._quadBuffer = growArrayBy2;
            }
            qlen++;
            quads[qlen] = currQuad;
        }
        String name = this._symbols.findName(quads, qlen);
        if (name == null) {
            name = addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    protected String _parseAposName() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(": was expecting closing ''' for field name", JsonToken.FIELD_NAME);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int ch = bArr[i] & 255;
        if (ch == 39) {
            return "";
        }
        int[] quads = this._quadBuffer;
        int qlen = 0;
        int currQuad = 0;
        int currQuadBytes = 0;
        int[] codes = _icLatin1;
        while (ch != 39) {
            if (!(codes[ch] == 0 || ch == 34)) {
                if (ch != 92) {
                    _throwUnquotedSpace(ch, "name");
                } else {
                    ch = _decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            int[] growArrayBy = growArrayBy(quads, quads.length);
                            quads = growArrayBy;
                            this._quadBuffer = growArrayBy;
                        }
                        qlen++;
                        quads[qlen] = currQuad;
                        currQuad = 0;
                        currQuadBytes = 0;
                    }
                    if (ch < 2048) {
                        currQuad = (currQuad << 8) | 192 | (ch >> 6);
                        currQuadBytes++;
                    } else {
                        int currQuad2 = (currQuad << 8) | 224 | (ch >> 12);
                        int currQuadBytes2 = currQuadBytes + 1;
                        if (currQuadBytes2 >= 4) {
                            if (qlen >= quads.length) {
                                int[] growArrayBy2 = growArrayBy(quads, quads.length);
                                quads = growArrayBy2;
                                this._quadBuffer = growArrayBy2;
                            }
                            qlen++;
                            quads[qlen] = currQuad2;
                            currQuad2 = 0;
                            currQuadBytes2 = 0;
                        }
                        currQuad = (currQuad2 << 8) | 128 | ((ch >> 6) & 63);
                        currQuadBytes = currQuadBytes2 + 1;
                    }
                    ch = 128 | (ch & 63);
                }
            }
            if (currQuadBytes < 4) {
                currQuadBytes++;
                currQuad = (currQuad << 8) | ch;
            } else {
                if (qlen >= quads.length) {
                    int[] growArrayBy3 = growArrayBy(quads, quads.length);
                    quads = growArrayBy3;
                    this._quadBuffer = growArrayBy3;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            ch = bArr2[i2] & 255;
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                int[] growArrayBy4 = growArrayBy(quads, quads.length);
                quads = growArrayBy4;
                this._quadBuffer = growArrayBy4;
            }
            qlen++;
            quads[qlen] = _padLastQuad(currQuad, currQuadBytes);
        }
        String name = this._symbols.findName(quads, qlen);
        if (name == null) {
            name = addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    private final String findName(int q1, int lastQuadBytes) throws JsonParseException {
        int q12 = _padLastQuad(q1, lastQuadBytes);
        String name = this._symbols.findName(q12);
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q12;
        return addName(this._quadBuffer, 1, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int lastQuadBytes) throws JsonParseException {
        int q22 = _padLastQuad(q2, lastQuadBytes);
        String name = this._symbols.findName(q1, q22);
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q1;
        this._quadBuffer[1] = q22;
        return addName(this._quadBuffer, 2, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int q3, int lastQuadBytes) throws JsonParseException {
        int q32 = _padLastQuad(q3, lastQuadBytes);
        String name = this._symbols.findName(q1, q2, q32);
        if (name != null) {
            return name;
        }
        int[] quads = this._quadBuffer;
        quads[0] = q1;
        quads[1] = q2;
        quads[2] = _padLastQuad(q32, lastQuadBytes);
        return addName(quads, 3, lastQuadBytes);
    }

    private final String findName(int[] quads, int qlen, int lastQuad, int lastQuadBytes) throws JsonParseException {
        if (qlen >= quads.length) {
            int[] growArrayBy = growArrayBy(quads, quads.length);
            quads = growArrayBy;
            this._quadBuffer = growArrayBy;
        }
        int qlen2 = qlen + 1;
        quads[qlen] = _padLastQuad(lastQuad, lastQuadBytes);
        String name = this._symbols.findName(quads, qlen2);
        if (name == null) {
            return addName(quads, qlen2, lastQuadBytes);
        }
        return name;
    }

    private final String addName(int[] quads, int qlen, int lastQuadBytes) throws JsonParseException {
        int lastQuad;
        int needed;
        int ch;
        int byteLen = ((qlen << 2) - 4) + lastQuadBytes;
        if (lastQuadBytes < 4) {
            lastQuad = quads[qlen - 1];
            quads[qlen - 1] = lastQuad << ((4 - lastQuadBytes) << 3);
        } else {
            lastQuad = 0;
        }
        char[] cbuf = this._textBuffer.emptyAndGetCurrentSegment();
        int cix = 0;
        int ix = 0;
        while (ix < byteLen) {
            int ch2 = (quads[ix >> 2] >> ((3 - (ix & 3)) << 3)) & 255;
            ix++;
            if (ch2 > 127) {
                if ((ch2 & PacketOpcodes.SceneAvatarStaminaStepRsp) == 192) {
                    ch = ch2 & 31;
                    needed = 1;
                } else if ((ch2 & PacketOpcodes.SceneKickPlayerRsp) == 224) {
                    ch = ch2 & 15;
                    needed = 2;
                } else if ((ch2 & PacketOpcodes.EnterSceneDoneReq) == 240) {
                    ch = ch2 & 7;
                    needed = 3;
                } else {
                    _reportInvalidInitial(ch2);
                    ch = 1;
                    needed = 1;
                }
                if (ix + needed > byteLen) {
                    _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
                }
                int ch22 = quads[ix >> 2] >> ((3 - (ix & 3)) << 3);
                ix++;
                if ((ch22 & 192) != 128) {
                    _reportInvalidOther(ch22);
                }
                ch2 = (ch << 6) | (ch22 & 63);
                if (needed > 1) {
                    int ch23 = quads[ix >> 2] >> ((3 - (ix & 3)) << 3);
                    ix++;
                    if ((ch23 & 192) != 128) {
                        _reportInvalidOther(ch23);
                    }
                    ch2 = (ch2 << 6) | (ch23 & 63);
                    if (needed > 2) {
                        int ch24 = quads[ix >> 2] >> ((3 - (ix & 3)) << 3);
                        ix++;
                        if ((ch24 & 192) != 128) {
                            _reportInvalidOther(ch24 & 255);
                        }
                        ch2 = (ch2 << 6) | (ch24 & 63);
                    }
                }
                if (needed > 2) {
                    int ch3 = ch2 - 65536;
                    if (cix >= cbuf.length) {
                        cbuf = this._textBuffer.expandCurrentSegment();
                    }
                    cix++;
                    cbuf[cix] = (char) (55296 + (ch3 >> 10));
                    ch2 = 56320 | (ch3 & 1023);
                }
            }
            if (cix >= cbuf.length) {
                cbuf = this._textBuffer.expandCurrentSegment();
            }
            cix++;
            cbuf[cix] = (char) ch2;
        }
        String baseName = new String(cbuf, 0, cix);
        if (lastQuadBytes < 4) {
            quads[qlen - 1] = lastQuad;
        }
        return this._symbols.addName(baseName, quads, qlen);
    }

    private static final int _padLastQuad(int q, int bytes) {
        return bytes == 4 ? q : q | (-1 << (bytes << 3));
    }

    protected void _loadMoreGuaranteed() throws IOException {
        if (!_loadMore()) {
            _reportInvalidEOF();
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _finishString() throws IOException {
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            _loadMoreGuaranteed();
            ptr = this._inputPtr;
        }
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int max = Math.min(this._inputEnd, ptr + outBuf.length);
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (ptr >= max) {
                break;
            }
            int c = inputBuffer[ptr] & 255;
            if (codes[c] == 0) {
                ptr++;
                outPtr++;
                outBuf[outPtr] = (char) c;
            } else if (c == 34) {
                this._inputPtr = ptr + 1;
                this._textBuffer.setCurrentLength(outPtr);
                return;
            }
        }
        this._inputPtr = ptr;
        _finishString2(outBuf, outPtr);
    }

    protected String _finishAndReturnString() throws IOException {
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            _loadMoreGuaranteed();
            ptr = this._inputPtr;
        }
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int max = Math.min(this._inputEnd, ptr + outBuf.length);
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (ptr >= max) {
                break;
            }
            int c = inputBuffer[ptr] & 255;
            if (codes[c] == 0) {
                ptr++;
                outPtr++;
                outBuf[outPtr] = (char) c;
            } else if (c == 34) {
                this._inputPtr = ptr + 1;
                return this._textBuffer.setCurrentAndReturn(outPtr);
            }
        }
        this._inputPtr = ptr;
        _finishString2(outBuf, outPtr);
        return this._textBuffer.contentsAsString();
    }

    private final void _finishString2(char[] outBuf, int outPtr) throws IOException {
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            int ptr = this._inputPtr;
            if (ptr >= this._inputEnd) {
                _loadMoreGuaranteed();
                ptr = this._inputPtr;
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = Math.min(this._inputEnd, ptr + (outBuf.length - outPtr));
            while (true) {
                if (ptr < max) {
                    ptr++;
                    int c = inputBuffer[ptr] & 255;
                    if (codes[c] != 0) {
                        this._inputPtr = ptr;
                        if (c == 34) {
                            this._textBuffer.setCurrentLength(outPtr);
                            return;
                        }
                        switch (codes[c]) {
                            case 1:
                                c = _decodeEscaped();
                                break;
                            case 2:
                                c = _decodeUtf8_2(c);
                                break;
                            case 3:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    c = _decodeUtf8_3(c);
                                    break;
                                } else {
                                    c = _decodeUtf8_3fast(c);
                                    break;
                                }
                            case 4:
                                int c2 = _decodeUtf8_4(c);
                                outPtr++;
                                outBuf[outPtr] = (char) (55296 | (c2 >> 10));
                                if (outPtr >= outBuf.length) {
                                    outBuf = this._textBuffer.finishCurrentSegment();
                                    outPtr = 0;
                                }
                                c = 56320 | (c2 & 1023);
                                break;
                            default:
                                if (c >= 32) {
                                    _reportInvalidChar(c);
                                    break;
                                } else {
                                    _throwUnquotedSpace(c, "string value");
                                    break;
                                }
                        }
                        if (outPtr >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr = 0;
                        }
                        outPtr++;
                        outBuf[outPtr] = (char) c;
                    } else {
                        outPtr++;
                        outBuf[outPtr] = (char) c;
                    }
                } else {
                    this._inputPtr = ptr;
                }
            }
        }
    }

    protected void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            int ptr = this._inputPtr;
            int max = this._inputEnd;
            if (ptr >= max) {
                _loadMoreGuaranteed();
                ptr = this._inputPtr;
                max = this._inputEnd;
            }
            while (true) {
                if (ptr < max) {
                    ptr++;
                    int c = inputBuffer[ptr] & 255;
                    if (codes[c] != 0) {
                        this._inputPtr = ptr;
                        if (c != 34) {
                            switch (codes[c]) {
                                case 1:
                                    _decodeEscaped();
                                    continue;
                                case 2:
                                    _skipUtf8_2();
                                    continue;
                                case 3:
                                    _skipUtf8_3();
                                    continue;
                                case 4:
                                    _skipUtf8_4(c);
                                    continue;
                                default:
                                    if (c >= 32) {
                                        _reportInvalidChar(c);
                                        break;
                                    } else {
                                        _throwUnquotedSpace(c, "string value");
                                        continue;
                                    }
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    this._inputPtr = ptr;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004b, code lost:
        if (r7._parsingContext.inArray() == false) goto L_0x0109;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken _handleUnexpectedValue(int r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._handleUnexpectedValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken _handleApos() throws IOException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = this._inputEnd;
            int max2 = this._inputPtr + (outBuf.length - outPtr);
            if (max2 < max) {
                max = max2;
            }
            while (true) {
                if (this._inputPtr < max) {
                    int i = this._inputPtr;
                    this._inputPtr = i + 1;
                    int c = inputBuffer[i] & 255;
                    if (c == 39) {
                        this._textBuffer.setCurrentLength(outPtr);
                        return JsonToken.VALUE_STRING;
                    } else if (codes[c] == 0 || c == 34) {
                        outPtr++;
                        outBuf[outPtr] = (char) c;
                    } else {
                        switch (codes[c]) {
                            case 1:
                                c = _decodeEscaped();
                                break;
                            case 2:
                                c = _decodeUtf8_2(c);
                                break;
                            case 3:
                                if (this._inputEnd - this._inputPtr < 2) {
                                    c = _decodeUtf8_3(c);
                                    break;
                                } else {
                                    c = _decodeUtf8_3fast(c);
                                    break;
                                }
                            case 4:
                                int c2 = _decodeUtf8_4(c);
                                outPtr++;
                                outBuf[outPtr] = (char) (55296 | (c2 >> 10));
                                if (outPtr >= outBuf.length) {
                                    outBuf = this._textBuffer.finishCurrentSegment();
                                    outPtr = 0;
                                }
                                c = 56320 | (c2 & 1023);
                                break;
                            default:
                                if (c < 32) {
                                    _throwUnquotedSpace(c, "string value");
                                }
                                _reportInvalidChar(c);
                                break;
                        }
                        if (outPtr >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr = 0;
                        }
                        outPtr++;
                        outBuf[outPtr] = (char) c;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x008a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:0:?, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(int r7, boolean r8) throws java.io.IOException {
        /*
            r6 = this;
        L_0x0000:
            r0 = r7
            r1 = 73
            if (r0 != r1) goto L_0x008a
            r0 = r6
            int r0 = r0._inputPtr
            r1 = r6
            int r1 = r1._inputEnd
            if (r0 < r1) goto L_0x001f
            r0 = r6
            boolean r0 = r0._loadMore()
            if (r0 != 0) goto L_0x001f
            r0 = r6
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_FLOAT
            r0._reportInvalidEOFInValue(r1)
        L_0x001f:
            r0 = r6
            byte[] r0 = r0._inputBuffer
            r1 = r6
            r2 = r1
            int r2 = r2._inputPtr
            r3 = r2; r2 = r1; r1 = r3; 
            r4 = 1
            int r3 = r3 + r4
            r2._inputPtr = r3
            r0 = r0[r1]
            r7 = r0
            r0 = r7
            r1 = 78
            if (r0 != r1) goto L_0x0047
            r0 = r8
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = "-INF"
            goto L_0x0043
        L_0x0040:
            java.lang.String r0 = "+INF"
        L_0x0043:
            r9 = r0
            goto L_0x005b
        L_0x0047:
            r0 = r7
            r1 = 110(0x6e, float:1.54E-43)
            if (r0 != r1) goto L_0x008a
            r0 = r8
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = "-Infinity"
            goto L_0x005a
        L_0x0057:
            java.lang.String r0 = "+Infinity"
        L_0x005a:
            r9 = r0
        L_0x005b:
            r0 = r6
            r1 = r9
            r2 = 3
            r0._matchToken(r1, r2)
            r0 = r6
            int r0 = r0._features
            int r1 = com.fasterxml.jackson.core.json.UTF8StreamJsonParser.FEAT_MASK_NON_NUM_NUMBERS
            r0 = r0 & r1
            if (r0 == 0) goto L_0x007f
            r0 = r6
            r1 = r9
            r2 = r8
            if (r2 == 0) goto L_0x0078
            r2 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            goto L_0x007b
        L_0x0078:
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
        L_0x007b:
            com.fasterxml.jackson.core.JsonToken r0 = r0.resetAsNaN(r1, r2)
            return r0
        L_0x007f:
            r0 = r6
            java.lang.String r1 = "Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r2 = r9
            r0._reportError(r1, r2)
            goto L_0x0000
        L_0x008a:
            r0 = r6
            r1 = r7
            java.lang.String r2 = "expected digit (0-9) to follow minus sign, for valid numeric value"
            r0.reportUnexpectedNumberChar(r1, r2)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8StreamJsonParser._handleInvalidNumberStart(int, boolean):com.fasterxml.jackson.core.JsonToken");
    }

    protected final void _matchTrue() throws IOException {
        int ch;
        int ptr = this._inputPtr;
        if (ptr + 3 < this._inputEnd) {
            byte[] buf = this._inputBuffer;
            int ptr2 = ptr + 1;
            if (buf[ptr] == 114) {
                int ptr3 = ptr2 + 1;
                if (buf[ptr2] == 117) {
                    int ptr4 = ptr3 + 1;
                    if (buf[ptr3] == 101 && ((ch = buf[ptr4] & 255) < 48 || ch == 93 || ch == 125)) {
                        this._inputPtr = ptr4;
                        return;
                    }
                }
            }
        }
        _matchToken2(C3P0Substitutions.DEBUG, 1);
    }

    protected final void _matchFalse() throws IOException {
        int ch;
        int ptr = this._inputPtr;
        if (ptr + 4 < this._inputEnd) {
            byte[] buf = this._inputBuffer;
            int ptr2 = ptr + 1;
            if (buf[ptr] == 97) {
                int ptr3 = ptr2 + 1;
                if (buf[ptr2] == 108) {
                    int ptr4 = ptr3 + 1;
                    if (buf[ptr3] == 115) {
                        int ptr5 = ptr4 + 1;
                        if (buf[ptr4] == 101 && ((ch = buf[ptr5] & 255) < 48 || ch == 93 || ch == 125)) {
                            this._inputPtr = ptr5;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken2("false", 1);
    }

    protected final void _matchNull() throws IOException {
        int ch;
        int ptr = this._inputPtr;
        if (ptr + 3 < this._inputEnd) {
            byte[] buf = this._inputBuffer;
            int ptr2 = ptr + 1;
            if (buf[ptr] == 117) {
                int ptr3 = ptr2 + 1;
                if (buf[ptr2] == 108) {
                    int ptr4 = ptr3 + 1;
                    if (buf[ptr3] == 108 && ((ch = buf[ptr4] & 255) < 48 || ch == 93 || ch == 125)) {
                        this._inputPtr = ptr4;
                        return;
                    }
                }
            }
        }
        _matchToken2("null", 1);
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
        int ch = this._inputBuffer[this._inputPtr] & 255;
        if (ch >= 48 && ch != 93 && ch != 125) {
            _checkMatchEnd(matchStr, i, ch);
        }
    }

    private final void _matchToken2(String matchStr, int i) throws IOException {
        int ch;
        int len = matchStr.length();
        do {
            if ((this._inputPtr >= this._inputEnd && !_loadMore()) || this._inputBuffer[this._inputPtr] != matchStr.charAt(i)) {
                _reportInvalidToken(matchStr.substring(0, i));
            }
            this._inputPtr++;
            i++;
        } while (i < len);
        if ((this._inputPtr < this._inputEnd || _loadMore()) && (ch = this._inputBuffer[this._inputPtr] & 255) >= 48 && ch != 93 && ch != 125) {
            _checkMatchEnd(matchStr, i, ch);
        }
    }

    private final void _checkMatchEnd(String matchStr, int i, int ch) throws IOException {
        if (Character.isJavaIdentifierPart((char) _decodeCharForError(ch))) {
            _reportInvalidToken(matchStr.substring(0, i));
        }
    }

    private final int _skipWS() throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int i2 = bArr[i] & 255;
            if (i2 > 32) {
                if (i2 != 47 && i2 != 35) {
                    return i2;
                }
                this._inputPtr--;
                return _skipWS2();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                }
            }
        }
        return _skipWS2();
    }

    private final int _skipWS2() throws IOException {
        int i;
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                i = bArr[i2] & 255;
                if (i > 32) {
                    if (i == 47) {
                        _skipComment();
                    } else if (i != 35 || !_skipYAMLComment()) {
                        break;
                    }
                } else if (i != 32) {
                    if (i == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (i == 13) {
                        _skipCR();
                    } else if (i != 9) {
                        _throwInvalidSpace(i);
                    }
                }
            } else {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.typeDesc() + " entries");
            }
        }
        return i;
    }

    private final int _skipWSOrEnd() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return _eofAsNextChar();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int i2 = bArr[i] & 255;
        if (i2 <= 32) {
            if (i2 != 32) {
                if (i2 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i2 == 13) {
                    _skipCR();
                } else if (i2 != 9) {
                    _throwInvalidSpace(i2);
                }
            }
            while (this._inputPtr < this._inputEnd) {
                byte[] bArr2 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int i4 = bArr2[i3] & 255;
                if (i4 > 32) {
                    if (i4 != 47 && i4 != 35) {
                        return i4;
                    }
                    this._inputPtr--;
                    return _skipWSOrEnd2();
                } else if (i4 != 32) {
                    if (i4 == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (i4 == 13) {
                        _skipCR();
                    } else if (i4 != 9) {
                        _throwInvalidSpace(i4);
                    }
                }
            }
            return _skipWSOrEnd2();
        } else if (i2 != 47 && i2 != 35) {
            return i2;
        } else {
            this._inputPtr--;
            return _skipWSOrEnd2();
        }
    }

    private final int _skipWSOrEnd2() throws IOException {
        int i;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            i = bArr[i2] & 255;
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    break;
                }
            } else if (i != 32) {
                if (i == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (i == 13) {
                    _skipCR();
                } else if (i != 9) {
                    _throwInvalidSpace(i);
                }
            }
        }
        return i;
    }

    private final int _skipColon() throws IOException {
        if (this._inputPtr + 4 >= this._inputEnd) {
            return _skipColon2(false);
        }
        byte b = this._inputBuffer[this._inputPtr];
        if (b == 58) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr + 1;
            this._inputPtr = i;
            byte b2 = bArr[i];
            if (b2 <= 32) {
                if (b2 == 32 || b2 == 9) {
                    byte[] bArr2 = this._inputBuffer;
                    int i2 = this._inputPtr + 1;
                    this._inputPtr = i2;
                    byte b3 = bArr2[i2];
                    if (b3 > 32) {
                        if (b3 == 47 || b3 == 35) {
                            return _skipColon2(true);
                        }
                        this._inputPtr++;
                        return b3;
                    }
                }
                return _skipColon2(true);
            } else if (b2 == 47 || b2 == 35) {
                return _skipColon2(true);
            } else {
                this._inputPtr++;
                return b2;
            }
        } else {
            if (b == 32 || b == 9) {
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr + 1;
                this._inputPtr = i3;
                b = bArr3[i3];
            }
            if (b != 58) {
                return _skipColon2(false);
            }
            byte[] bArr4 = this._inputBuffer;
            int i4 = this._inputPtr + 1;
            this._inputPtr = i4;
            byte b4 = bArr4[i4];
            if (b4 <= 32) {
                if (b4 == 32 || b4 == 9) {
                    byte[] bArr5 = this._inputBuffer;
                    int i5 = this._inputPtr + 1;
                    this._inputPtr = i5;
                    byte b5 = bArr5[i5];
                    if (b5 > 32) {
                        if (b5 == 47 || b5 == 35) {
                            return _skipColon2(true);
                        }
                        this._inputPtr++;
                        return b5;
                    }
                }
                return _skipColon2(true);
            } else if (b4 == 47 || b4 == 35) {
                return _skipColon2(true);
            } else {
                this._inputPtr++;
                return b4;
            }
        }
    }

    private final int _skipColon2(boolean gotColon) throws IOException {
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & 255;
                if (i2 > 32) {
                    if (i2 == 47) {
                        _skipComment();
                    } else if (i2 != 35 || !_skipYAMLComment()) {
                        if (gotColon) {
                            return i2;
                        }
                        if (i2 != 58) {
                            _reportUnexpectedChar(i2, "was expecting a colon to separate field name and value");
                        }
                        gotColon = true;
                    }
                } else if (i2 != 32) {
                    if (i2 == 10) {
                        this._currInputRow++;
                        this._currInputRowStart = this._inputPtr;
                    } else if (i2 == 13) {
                        _skipCR();
                    } else if (i2 != 9) {
                        _throwInvalidSpace(i2);
                    }
                }
            } else {
                _reportInvalidEOF(" within/between " + this._parsingContext.typeDesc() + " entries", null);
                return -1;
            }
        }
    }

    private final void _skipComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in a comment", null);
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int c = bArr[i] & 255;
        if (c == 47) {
            _skipLine();
        } else if (c == 42) {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipCComment() throws IOException {
        int[] codes = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & 255;
                int code = codes[i2];
                if (code != 0) {
                    switch (code) {
                        case 2:
                            _skipUtf8_2();
                            continue;
                        case 3:
                            _skipUtf8_3();
                            continue;
                        case 4:
                            _skipUtf8_4(i2);
                            continue;
                        case 10:
                            this._currInputRow++;
                            this._currInputRowStart = this._inputPtr;
                            continue;
                        case 13:
                            _skipCR();
                            continue;
                        case 42:
                            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                                break;
                            } else if (this._inputBuffer[this._inputPtr] == 47) {
                                this._inputPtr++;
                                return;
                            } else {
                                continue;
                            }
                            break;
                        default:
                            _reportInvalidChar(i2);
                            continue;
                    }
                }
            }
        }
        _reportInvalidEOF(" in a comment", null);
    }

    private final boolean _skipYAMLComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _skipLine() throws IOException {
        int[] codes = CharTypes.getInputCodeComment();
        while (true) {
            if (this._inputPtr < this._inputEnd || _loadMore()) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                int i2 = bArr[i] & 255;
                int code = codes[i2];
                if (code != 0) {
                    switch (code) {
                        case 2:
                            _skipUtf8_2();
                            continue;
                        case 3:
                            _skipUtf8_3();
                            continue;
                        case 4:
                            _skipUtf8_4(i2);
                            continue;
                        case 10:
                            this._currInputRow++;
                            this._currInputRowStart = this._inputPtr;
                            return;
                        case 13:
                            _skipCR();
                            return;
                        case 42:
                            break;
                        default:
                            if (code < 0) {
                                _reportInvalidChar(i2);
                                break;
                            } else {
                                continue;
                            }
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
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        switch (b) {
            case 34:
            case 47:
            case 92:
                return (char) b;
            case 98:
                return '\b';
            case 102:
                return '\f';
            case 110:
                return '\n';
            case 114:
                return '\r';
            case 116:
                return '\t';
            case 117:
                int value = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                        _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
                    }
                    byte[] bArr2 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    byte b2 = bArr2[i3];
                    int digit = CharTypes.charToHex(b2);
                    if (digit < 0) {
                        _reportUnexpectedChar(b2 & 255, "expected a hex-digit for character escape sequence");
                    }
                    value = (value << 4) | digit;
                }
                return (char) value;
            default:
                return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(b));
        }
    }

    protected int _decodeCharForError(int firstByte) throws IOException {
        int needed;
        int c = firstByte & 255;
        if (c > 127) {
            if ((c & PacketOpcodes.SceneAvatarStaminaStepRsp) == 192) {
                c &= 31;
                needed = 1;
            } else if ((c & PacketOpcodes.SceneKickPlayerRsp) == 224) {
                c &= 15;
                needed = 2;
            } else if ((c & PacketOpcodes.EnterSceneDoneReq) == 240) {
                c &= 7;
                needed = 3;
            } else {
                _reportInvalidInitial(c & 255);
                needed = 1;
            }
            int d = nextByte();
            if ((d & 192) != 128) {
                _reportInvalidOther(d & 255);
            }
            c = (c << 6) | (d & 63);
            if (needed > 1) {
                int d2 = nextByte();
                if ((d2 & 192) != 128) {
                    _reportInvalidOther(d2 & 255);
                }
                c = (c << 6) | (d2 & 63);
                if (needed > 2) {
                    int d3 = nextByte();
                    if ((d3 & 192) != 128) {
                        _reportInvalidOther(d3 & 255);
                    }
                    c = (c << 6) | (d3 & 63);
                }
            }
        }
        return c;
    }

    private final int _decodeUtf8_2(int c) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
        return ((c & 31) << 6) | (b & 63);
    }

    private final int _decodeUtf8_3(int c1) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        int c12 = c1 & 15;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
        int c = (c12 << 6) | (b & 63);
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b2 = bArr2[i2];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & 255, this._inputPtr);
        }
        return (c << 6) | (b2 & 63);
    }

    private final int _decodeUtf8_3fast(int c1) throws IOException {
        int c12 = c1 & 15;
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
        int c = (c12 << 6) | (b & 63);
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b2 = bArr2[i2];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & 255, this._inputPtr);
        }
        return (c << 6) | (b2 & 63);
    }

    private final int _decodeUtf8_4(int c) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
        int c2 = ((c & 7) << 6) | (b & 63);
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b2 = bArr2[i2];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & 255, this._inputPtr);
        }
        int c3 = (c2 << 6) | (b2 & 63);
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b3 = bArr3[i3];
        if ((b3 & 192) != 128) {
            _reportInvalidOther(b3 & 255, this._inputPtr);
        }
        return ((c3 << 6) | (b3 & 63)) - 65536;
    }

    private final void _skipUtf8_2() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
    }

    private final void _skipUtf8_3() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b2 = bArr2[i2];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & 255, this._inputPtr);
        }
    }

    private final void _skipUtf8_4(int c) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if ((b & 192) != 128) {
            _reportInvalidOther(b & 255, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b2 = bArr2[i2];
        if ((b2 & 192) != 128) {
            _reportInvalidOther(b2 & 255, this._inputPtr);
        }
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i3 = this._inputPtr;
        this._inputPtr = i3 + 1;
        byte b3 = bArr3[i3];
        if ((b3 & 192) != 128) {
            _reportInvalidOther(b3 & 255, this._inputPtr);
        }
    }

    protected final void _skipCR() throws IOException {
        if ((this._inputPtr < this._inputEnd || _loadMore()) && this._inputBuffer[this._inputPtr] == 10) {
            this._inputPtr++;
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private int nextByte() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            _loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & 255;
    }

    protected void _reportInvalidToken(String matchedPart, int ptr) throws IOException {
        this._inputPtr = ptr;
        _reportInvalidToken(matchedPart, _validJsonTokenList());
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
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = (char) _decodeCharForError(bArr[i]);
            if (Character.isJavaIdentifierPart(c)) {
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

    protected void _reportInvalidChar(int c) throws JsonParseException {
        if (c < 32) {
            _throwInvalidSpace(c);
        }
        _reportInvalidInitial(c);
    }

    protected void _reportInvalidInitial(int mask) throws JsonParseException {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(mask));
    }

    protected void _reportInvalidOther(int mask) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(mask));
    }

    protected void _reportInvalidOther(int mask, int ptr) throws JsonParseException {
        this._inputPtr = ptr;
        _reportInvalidOther(mask);
    }

    protected final byte[] _decodeBase64(Base64Variant b64variant) throws IOException {
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch > 32) {
                int bits = b64variant.decodeBase64Char(ch);
                if (bits < 0) {
                    if (ch == 34) {
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
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                int ch2 = bArr2[i2] & 255;
                int bits2 = b64variant.decodeBase64Char(ch2);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch2, 1);
                }
                int decodedData = (bits << 6) | bits2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                int ch3 = bArr3[i3] & 255;
                int bits3 = b64variant.decodeBase64Char(ch3);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch3 == 34) {
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
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        int ch4 = bArr4[i4] & 255;
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
                byte[] bArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                int ch5 = bArr5[i5] & 255;
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 == 34) {
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
            return new JsonLocation(_contentReference(), this._tokenInputTotal - 1, -1L, this._tokenInputRow, this._tokenInputCol);
        }
        return new JsonLocation(_contentReference(), this._currInputProcessed + ((long) (this._nameStartOffset - 1)), -1L, this._nameStartRow, this._nameStartCol);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return new JsonLocation(_contentReference(), this._currInputProcessed + ((long) this._inputPtr), -1L, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    private final void _updateLocation() {
        this._tokenInputRow = this._currInputRow;
        int ptr = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + ((long) ptr);
        this._tokenInputCol = ptr - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        this._nameStartRow = this._currInputRow;
        int ptr = this._inputPtr;
        this._nameStartOffset = ptr;
        this._nameStartCol = ptr - this._currInputRowStart;
    }

    private final JsonToken _closeScope(int i) throws JsonParseException {
        if (i == 125) {
            _closeObjectScope();
            JsonToken jsonToken = JsonToken.END_OBJECT;
            this._currToken = jsonToken;
            return jsonToken;
        }
        _closeArrayScope();
        JsonToken jsonToken2 = JsonToken.END_ARRAY;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    private final void _closeArrayScope() throws JsonParseException {
        _updateLocation();
        if (!this._parsingContext.inArray()) {
            _reportMismatchedEndMarker(93, '}');
        }
        this._parsingContext = this._parsingContext.clearAndGetParent();
    }

    private final void _closeObjectScope() throws JsonParseException {
        _updateLocation();
        if (!this._parsingContext.inObject()) {
            _reportMismatchedEndMarker(125, ']');
        }
        this._parsingContext = this._parsingContext.clearAndGetParent();
    }
}
