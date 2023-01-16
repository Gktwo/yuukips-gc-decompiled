package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/json/UTF8DataInputJsonParser.class */
public class UTF8DataInputJsonParser extends ParserBase {
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
    protected int[] _quadBuffer = new int[16];
    protected boolean _tokenIncomplete;
    private int _quad1;
    protected DataInput _inputData;
    protected int _nextByte;

    public UTF8DataInputJsonParser(IOContext ctxt, int features, DataInput inputData, ObjectCodec codec, ByteQuadsCanonicalizer sym, int firstByte) {
        super(ctxt, features);
        this._nextByte = -1;
        this._objectCodec = codec;
        this._symbols = sym;
        this._inputData = inputData;
        this._nextByte = firstByte;
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
        return 0;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._inputData;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _closeInput() throws IOException {
    }

    /* access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() throws IOException {
        _releaseBuffers();
        this._symbols.release();
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

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        if (this._currToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.size();
        } else if (this._currToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName().length();
        } else {
            if (this._currToken == null) {
                return 0;
            }
            if (this._currToken.isNumeric()) {
                return this._textBuffer.size();
            }
            return this._currToken.asCharArray().length;
        }
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

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0203, code lost:
        r7._tokenIncomplete = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x020a, code lost:
        if (r11 <= 0) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x020d, code lost:
        r13 = r13 + r11;
        r9.write(r10, 0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x021e, code lost:
        return r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected int _readBinary(com.fasterxml.jackson.core.Base64Variant r8, java.io.OutputStream r9, byte[] r10) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 543
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._readBinary(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        JsonToken t;
        if (this._closed) {
            return null;
        }
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
        this._tokenInputRow = this._currInputRow;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            if (i != 44) {
                _reportUnexpectedChar(i, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
            }
            i = _skipWS();
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i == 93 || i == 125)) {
                _closeScope(i);
                return this._currToken;
            }
        }
        if (!this._parsingContext.inObject()) {
            return _nextTokenNotInObject(i);
        }
        this._parsingContext.setCurrentName(_parseName(i));
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipColon();
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
                _matchToken("false", 1);
                t = JsonToken.VALUE_FALSE;
                break;
            case 110:
                _matchToken("null", 1);
                t = JsonToken.VALUE_NULL;
                break;
            case 116:
                _matchToken(C3P0Substitutions.DEBUG, 1);
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
                _matchToken("false", 1);
                JsonToken jsonToken3 = JsonToken.VALUE_FALSE;
                this._currToken = jsonToken3;
                return jsonToken3;
            case 110:
                _matchToken("null", 1);
                JsonToken jsonToken4 = JsonToken.VALUE_NULL;
                this._currToken = jsonToken4;
                return jsonToken4;
            case 116:
                _matchToken(C3P0Substitutions.DEBUG, 1);
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
        int i = _skipWS();
        this._binaryValue = null;
        this._tokenInputRow = this._currInputRow;
        if (i == 93 || i == 125) {
            _closeScope(i);
            return null;
        }
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
            _nextTokenNotInObject(i);
            return null;
        }
        String nameStr = _parseName(i);
        this._parsingContext.setCurrentName(nameStr);
        this._currToken = JsonToken.FIELD_NAME;
        int i2 = _skipColon();
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
                _parseFloatThatStartsWithPeriod();
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
                _matchToken("false", 1);
                t = JsonToken.VALUE_FALSE;
                break;
            case 110:
                _matchToken("null", 1);
                t = JsonToken.VALUE_NULL;
                break;
            case 116:
                _matchToken(C3P0Substitutions.DEBUG, 1);
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
        int outPtr;
        int c2;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        if (c == 48) {
            c2 = _handleLeadingZeroes();
            if (c2 > 57 || c2 < 48) {
                outBuf[0] = '0';
                outPtr = 1;
            } else {
                outPtr = 0;
            }
        } else {
            outBuf[0] = (char) c;
            c2 = this._inputData.readUnsignedByte();
            outPtr = 1;
        }
        int intLen = outPtr;
        while (c2 <= 57 && c2 >= 48) {
            intLen++;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            outPtr++;
            outBuf[outPtr] = (char) c2;
            c2 = this._inputData.readUnsignedByte();
        }
        if (c2 == 46 || c2 == 101 || c2 == 69) {
            return _parseFloat(outBuf, outPtr, c2, false, intLen);
        }
        this._textBuffer.setCurrentLength(outPtr);
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        } else {
            this._nextByte = c2;
        }
        return resetInt(false, intLen);
    }

    protected JsonToken _parseNegNumber() throws IOException {
        int c;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int outPtr = 0 + 1;
        outBuf[0] = '-';
        int c2 = this._inputData.readUnsignedByte();
        int outPtr2 = outPtr + 1;
        outBuf[outPtr] = (char) c2;
        if (c2 <= 48) {
            if (c2 != 48) {
                return _handleInvalidNumberStart(c2, true);
            }
            c = _handleLeadingZeroes();
        } else if (c2 > 57) {
            return _handleInvalidNumberStart(c2, true);
        } else {
            c = this._inputData.readUnsignedByte();
        }
        int intLen = 1;
        while (c <= 57 && c >= 48) {
            intLen++;
            outPtr2++;
            outBuf[outPtr2] = (char) c;
            c = this._inputData.readUnsignedByte();
        }
        if (c == 46 || c == 101 || c == 69) {
            return _parseFloat(outBuf, outPtr2, c, true, intLen);
        }
        this._textBuffer.setCurrentLength(outPtr2);
        this._nextByte = c;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        return resetInt(true, intLen);
    }

    private final int _handleLeadingZeroes() throws IOException {
        int ch = this._inputData.readUnsignedByte();
        if (ch < 48 || ch > 57) {
            return ch;
        }
        if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        while (ch == 48) {
            ch = this._inputData.readUnsignedByte();
        }
        return ch;
    }

    private final JsonToken _parseFloat(char[] outBuf, int outPtr, int c, boolean negative, int integerPartLength) throws IOException {
        int fractLen = 0;
        if (c == 46) {
            outPtr++;
            outBuf[outPtr] = (char) c;
            while (true) {
                c = this._inputData.readUnsignedByte();
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
            c = this._inputData.readUnsignedByte();
            if (c == 45 || c == 43) {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                c = this._inputData.readUnsignedByte();
            }
            while (c <= 57 && c >= 48) {
                expLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                c = this._inputData.readUnsignedByte();
            }
            if (expLen == 0) {
                reportUnexpectedNumberChar(c, "Exponent indicator not followed by a digit");
            }
        }
        this._nextByte = c;
        if (this._parsingContext.inRoot()) {
            _verifyRootSpace();
        }
        this._textBuffer.setCurrentLength(outPtr);
        return resetFloat(negative, integerPartLength, fractLen, expLen);
    }

    private final void _verifyRootSpace() throws IOException {
        int ch = this._nextByte;
        if (ch <= 32) {
            this._nextByte = -1;
            if (ch == 13 || ch == 10) {
                this._currInputRow++;
                return;
            }
            return;
        }
        _reportMissingRootWS(ch);
    }

    protected final String _parseName(int i) throws IOException {
        if (i != 34) {
            return _handleOddName(i);
        }
        int[] codes = _icLatin1;
        int q = this._inputData.readUnsignedByte();
        if (codes[q] == 0) {
            int i2 = this._inputData.readUnsignedByte();
            if (codes[i2] == 0) {
                int q2 = (q << 8) | i2;
                int i3 = this._inputData.readUnsignedByte();
                if (codes[i3] == 0) {
                    int q3 = (q2 << 8) | i3;
                    int i4 = this._inputData.readUnsignedByte();
                    if (codes[i4] == 0) {
                        int q4 = (q3 << 8) | i4;
                        int i5 = this._inputData.readUnsignedByte();
                        if (codes[i5] == 0) {
                            this._quad1 = q4;
                            return _parseMediumName(i5);
                        } else if (i5 == 34) {
                            return findName(q4, 4);
                        } else {
                            return parseName(q4, i5, 4);
                        }
                    } else if (i4 == 34) {
                        return findName(q3, 3);
                    } else {
                        return parseName(q3, i4, 3);
                    }
                } else if (i3 == 34) {
                    return findName(q2, 2);
                } else {
                    return parseName(q2, i3, 2);
                }
            } else if (i2 == 34) {
                return findName(q, 1);
            } else {
                return parseName(q, i2, 1);
            }
        } else if (q == 34) {
            return "";
        } else {
            return parseName(0, q, 0);
        }
    }

    private final String _parseMediumName(int q2) throws IOException {
        int[] codes = _icLatin1;
        int i = this._inputData.readUnsignedByte();
        if (codes[i] == 0) {
            int q22 = (q2 << 8) | i;
            int i2 = this._inputData.readUnsignedByte();
            if (codes[i2] == 0) {
                int q23 = (q22 << 8) | i2;
                int i3 = this._inputData.readUnsignedByte();
                if (codes[i3] == 0) {
                    int q24 = (q23 << 8) | i3;
                    int i4 = this._inputData.readUnsignedByte();
                    if (codes[i4] == 0) {
                        return _parseMediumName2(i4, q24);
                    }
                    if (i4 == 34) {
                        return findName(this._quad1, q24, 4);
                    }
                    return parseName(this._quad1, q24, i4, 4);
                } else if (i3 == 34) {
                    return findName(this._quad1, q23, 3);
                } else {
                    return parseName(this._quad1, q23, i3, 3);
                }
            } else if (i2 == 34) {
                return findName(this._quad1, q22, 2);
            } else {
                return parseName(this._quad1, q22, i2, 2);
            }
        } else if (i == 34) {
            return findName(this._quad1, q2, 1);
        } else {
            return parseName(this._quad1, q2, i, 1);
        }
    }

    private final String _parseMediumName2(int q3, int q2) throws IOException {
        int[] codes = _icLatin1;
        int i = this._inputData.readUnsignedByte();
        if (codes[i] == 0) {
            int q32 = (q3 << 8) | i;
            int i2 = this._inputData.readUnsignedByte();
            if (codes[i2] == 0) {
                int q33 = (q32 << 8) | i2;
                int i3 = this._inputData.readUnsignedByte();
                if (codes[i3] == 0) {
                    int q34 = (q33 << 8) | i3;
                    int i4 = this._inputData.readUnsignedByte();
                    if (codes[i4] == 0) {
                        return _parseLongName(i4, q2, q34);
                    }
                    if (i4 == 34) {
                        return findName(this._quad1, q2, q34, 4);
                    }
                    return parseName(this._quad1, q2, q34, i4, 4);
                } else if (i3 == 34) {
                    return findName(this._quad1, q2, q33, 3);
                } else {
                    return parseName(this._quad1, q2, q33, i3, 3);
                }
            } else if (i2 == 34) {
                return findName(this._quad1, q2, q32, 2);
            } else {
                return parseName(this._quad1, q2, q32, i2, 2);
            }
        } else if (i == 34) {
            return findName(this._quad1, q2, q3, 1);
        } else {
            return parseName(this._quad1, q2, q3, i, 1);
        }
    }

    private final String _parseLongName(int q, int q2, int q3) throws IOException {
        this._quadBuffer[0] = this._quad1;
        this._quadBuffer[1] = q2;
        this._quadBuffer[2] = q3;
        int[] codes = _icLatin1;
        int qlen = 3;
        while (true) {
            int i = this._inputData.readUnsignedByte();
            if (codes[i] == 0) {
                int q4 = (q << 8) | i;
                int i2 = this._inputData.readUnsignedByte();
                if (codes[i2] == 0) {
                    int q5 = (q4 << 8) | i2;
                    int i3 = this._inputData.readUnsignedByte();
                    if (codes[i3] == 0) {
                        int q6 = (q5 << 8) | i3;
                        int i4 = this._inputData.readUnsignedByte();
                        if (codes[i4] == 0) {
                            if (qlen >= this._quadBuffer.length) {
                                this._quadBuffer = _growArrayBy(this._quadBuffer, qlen);
                            }
                            qlen++;
                            this._quadBuffer[qlen] = q6;
                            q = i4;
                        } else if (i4 == 34) {
                            return findName(this._quadBuffer, qlen, q6, 4);
                        } else {
                            return parseEscapedName(this._quadBuffer, qlen, q6, i4, 4);
                        }
                    } else if (i3 == 34) {
                        return findName(this._quadBuffer, qlen, q5, 3);
                    } else {
                        return parseEscapedName(this._quadBuffer, qlen, q5, i3, 3);
                    }
                } else if (i2 == 34) {
                    return findName(this._quadBuffer, qlen, q4, 2);
                } else {
                    return parseEscapedName(this._quadBuffer, qlen, q4, i2, 2);
                }
            } else if (i == 34) {
                return findName(this._quadBuffer, qlen, q, 1);
            } else {
                return parseEscapedName(this._quadBuffer, qlen, q, i, 1);
            }
        }
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
                            int[] _growArrayBy = _growArrayBy(quads, quads.length);
                            quads = _growArrayBy;
                            this._quadBuffer = _growArrayBy;
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
                                int[] _growArrayBy2 = _growArrayBy(quads, quads.length);
                                quads = _growArrayBy2;
                                this._quadBuffer = _growArrayBy2;
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
                    int[] _growArrayBy3 = _growArrayBy(quads, quads.length);
                    quads = _growArrayBy3;
                    this._quadBuffer = _growArrayBy3;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            ch = this._inputData.readUnsignedByte();
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                int[] _growArrayBy4 = _growArrayBy(quads, quads.length);
                quads = _growArrayBy4;
                this._quadBuffer = _growArrayBy4;
            }
            qlen++;
            quads[qlen] = pad(currQuad, currQuadBytes);
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
        do {
            if (currQuadBytes < 4) {
                currQuadBytes++;
                currQuad = (currQuad << 8) | ch;
            } else {
                if (qlen >= quads.length) {
                    int[] _growArrayBy = _growArrayBy(quads, quads.length);
                    quads = _growArrayBy;
                    this._quadBuffer = _growArrayBy;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            ch = this._inputData.readUnsignedByte();
        } while (codes[ch] == 0);
        this._nextByte = ch;
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                int[] _growArrayBy2 = _growArrayBy(quads, quads.length);
                quads = _growArrayBy2;
                this._quadBuffer = _growArrayBy2;
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
        int ch = this._inputData.readUnsignedByte();
        if (ch == 39) {
            return "";
        }
        int[] quads = this._quadBuffer;
        int qlen = 0;
        int currQuad = 0;
        int currQuadBytes = 0;
        int[] codes = _icLatin1;
        while (ch != 39) {
            if (!(ch == 34 || codes[ch] == 0)) {
                if (ch != 92) {
                    _throwUnquotedSpace(ch, "name");
                } else {
                    ch = _decodeEscaped();
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            int[] _growArrayBy = _growArrayBy(quads, quads.length);
                            quads = _growArrayBy;
                            this._quadBuffer = _growArrayBy;
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
                                int[] _growArrayBy2 = _growArrayBy(quads, quads.length);
                                quads = _growArrayBy2;
                                this._quadBuffer = _growArrayBy2;
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
                    int[] _growArrayBy3 = _growArrayBy(quads, quads.length);
                    quads = _growArrayBy3;
                    this._quadBuffer = _growArrayBy3;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
            ch = this._inputData.readUnsignedByte();
        }
        if (currQuadBytes > 0) {
            if (qlen >= quads.length) {
                int[] _growArrayBy4 = _growArrayBy(quads, quads.length);
                quads = _growArrayBy4;
                this._quadBuffer = _growArrayBy4;
            }
            qlen++;
            quads[qlen] = pad(currQuad, currQuadBytes);
        }
        String name = this._symbols.findName(quads, qlen);
        if (name == null) {
            name = addName(quads, qlen, currQuadBytes);
        }
        return name;
    }

    private final String findName(int q1, int lastQuadBytes) throws JsonParseException {
        int q12 = pad(q1, lastQuadBytes);
        String name = this._symbols.findName(q12);
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q12;
        return addName(this._quadBuffer, 1, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int lastQuadBytes) throws JsonParseException {
        int q22 = pad(q2, lastQuadBytes);
        String name = this._symbols.findName(q1, q22);
        if (name != null) {
            return name;
        }
        this._quadBuffer[0] = q1;
        this._quadBuffer[1] = q22;
        return addName(this._quadBuffer, 2, lastQuadBytes);
    }

    private final String findName(int q1, int q2, int q3, int lastQuadBytes) throws JsonParseException {
        int q32 = pad(q3, lastQuadBytes);
        String name = this._symbols.findName(q1, q2, q32);
        if (name != null) {
            return name;
        }
        int[] quads = this._quadBuffer;
        quads[0] = q1;
        quads[1] = q2;
        quads[2] = pad(q32, lastQuadBytes);
        return addName(quads, 3, lastQuadBytes);
    }

    private final String findName(int[] quads, int qlen, int lastQuad, int lastQuadBytes) throws JsonParseException {
        if (qlen >= quads.length) {
            int[] _growArrayBy = _growArrayBy(quads, quads.length);
            quads = _growArrayBy;
            this._quadBuffer = _growArrayBy;
        }
        int qlen2 = qlen + 1;
        quads[qlen] = pad(lastQuad, lastQuadBytes);
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
                if ((ch2 & PacketOpcodes.WorldPlayerLocationNotify) == 192) {
                    ch = ch2 & 31;
                    needed = 1;
                } else if ((ch2 & PacketOpcodes.ExecuteGadgetLuaRsp) == 224) {
                    ch = ch2 & 15;
                    needed = 2;
                } else if ((ch2 & PacketOpcodes.ScenePlayerLocationNotify) == 240) {
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

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected void _finishString() throws IOException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int outEnd = outBuf.length;
        do {
            int c = this._inputData.readUnsignedByte();
            if (codes[c] == 0) {
                outPtr++;
                outBuf[outPtr] = (char) c;
            } else if (c == 34) {
                this._textBuffer.setCurrentLength(outPtr);
                return;
            } else {
                _finishString2(outBuf, outPtr, c);
                return;
            }
        } while (outPtr < outEnd);
        _finishString2(outBuf, outPtr, this._inputData.readUnsignedByte());
    }

    private String _finishAndReturnString() throws IOException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int outEnd = outBuf.length;
        do {
            int c = this._inputData.readUnsignedByte();
            if (codes[c] == 0) {
                outPtr++;
                outBuf[outPtr] = (char) c;
            } else if (c == 34) {
                return this._textBuffer.setCurrentAndReturn(outPtr);
            } else {
                _finishString2(outBuf, outPtr, c);
                return this._textBuffer.contentsAsString();
            }
        } while (outPtr < outEnd);
        _finishString2(outBuf, outPtr, this._inputData.readUnsignedByte());
        return this._textBuffer.contentsAsString();
    }

    private final void _finishString2(char[] outBuf, int outPtr, int c) throws IOException {
        int[] codes = _icUTF8;
        int outEnd = outBuf.length;
        while (true) {
            if (codes[c] == 0) {
                if (outPtr >= outEnd) {
                    outBuf = this._textBuffer.finishCurrentSegment();
                    outPtr = 0;
                    outEnd = outBuf.length;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                c = this._inputData.readUnsignedByte();
            } else if (c == 34) {
                this._textBuffer.setCurrentLength(outPtr);
                return;
            } else {
                switch (codes[c]) {
                    case 1:
                        c = _decodeEscaped();
                        break;
                    case 2:
                        c = _decodeUtf8_2(c);
                        break;
                    case 3:
                        c = _decodeUtf8_3(c);
                        break;
                    case 4:
                        int c2 = _decodeUtf8_4(c);
                        if (outPtr >= outBuf.length) {
                            outBuf = this._textBuffer.finishCurrentSegment();
                            outPtr = 0;
                            outEnd = outBuf.length;
                        }
                        outPtr++;
                        outBuf[outPtr] = (char) (55296 | (c2 >> 10));
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
                    outEnd = outBuf.length;
                }
                outPtr++;
                outBuf[outPtr] = (char) c;
                c = this._inputData.readUnsignedByte();
            }
        }
    }

    protected void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int[] codes = _icUTF8;
        while (true) {
            int c = this._inputData.readUnsignedByte();
            if (codes[c] != 0) {
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
                            _skipUtf8_4();
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
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004b, code lost:
        if (r5._parsingContext.inArray() == false) goto L_0x00df;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken _handleUnexpectedValue(int r6) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 288
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.UTF8DataInputJsonParser._handleUnexpectedValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    protected JsonToken _handleApos() throws IOException {
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        while (true) {
            int outEnd = outBuf.length;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
                outEnd = outBuf.length;
            }
            while (true) {
                int c = this._inputData.readUnsignedByte();
                if (c == 39) {
                    this._textBuffer.setCurrentLength(outPtr);
                    return JsonToken.VALUE_STRING;
                } else if (codes[c] == 0 || c == 34) {
                    outPtr++;
                    outBuf[outPtr] = (char) c;
                    if (outPtr >= outEnd) {
                        break;
                    }
                } else {
                    switch (codes[c]) {
                        case 1:
                            c = _decodeEscaped();
                            break;
                        case 2:
                            c = _decodeUtf8_2(c);
                            break;
                        case 3:
                            c = _decodeUtf8_3(c);
                            break;
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

    protected JsonToken _handleInvalidNumberStart(int ch, boolean neg) throws IOException {
        String match;
        while (ch == 73) {
            ch = this._inputData.readUnsignedByte();
            if (ch != 78) {
                if (ch != 110) {
                    break;
                }
                match = neg ? "-Infinity" : "+Infinity";
            } else {
                match = neg ? "-INF" : "+INF";
            }
            _matchToken(match, 3);
            if ((this._features & FEAT_MASK_NON_NUM_NUMBERS) != 0) {
                return resetAsNaN(match, neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
            }
            _reportError("Non-standard token '" + match + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
        reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    protected final void _matchToken(String matchStr, int i) throws IOException {
        int len = matchStr.length();
        do {
            int ch = this._inputData.readUnsignedByte();
            if (ch != matchStr.charAt(i)) {
                _reportInvalidToken(ch, matchStr.substring(0, i));
            }
            i++;
        } while (i < len);
        int ch2 = this._inputData.readUnsignedByte();
        if (!(ch2 < 48 || ch2 == 93 || ch2 == 125)) {
            _checkMatchEnd(matchStr, i, ch2);
        }
        this._nextByte = ch2;
    }

    private final void _checkMatchEnd(String matchStr, int i, int ch) throws IOException {
        char c = (char) _decodeCharForError(ch);
        if (Character.isJavaIdentifierPart(c)) {
            _reportInvalidToken(c, matchStr.substring(0, i));
        }
    }

    private final int _skipWS() throws IOException {
        int i = this._nextByte;
        if (i < 0) {
            i = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        while (i <= 32) {
            if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
        if (i == 47 || i == 35) {
            return _skipWSComment(i);
        }
        return i;
    }

    private final int _skipWSOrEnd() throws IOException {
        int i = this._nextByte;
        if (i < 0) {
            try {
                i = this._inputData.readUnsignedByte();
            } catch (EOFException e) {
                return _eofAsNextChar();
            }
        } else {
            this._nextByte = -1;
        }
        while (i <= 32) {
            if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            try {
                i = this._inputData.readUnsignedByte();
            } catch (EOFException e2) {
                return _eofAsNextChar();
            }
        }
        if (i == 47 || i == 35) {
            return _skipWSComment(i);
        }
        return i;
    }

    private final int _skipWSComment(int i) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35) {
                    return i;
                } else {
                    if (!_skipYAMLComment()) {
                        return i;
                    }
                }
            } else if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
    }

    private final int _skipColon() throws IOException {
        int i = this._nextByte;
        if (i < 0) {
            i = this._inputData.readUnsignedByte();
        } else {
            this._nextByte = -1;
        }
        if (i == 58) {
            int i2 = this._inputData.readUnsignedByte();
            if (i2 <= 32) {
                if (i2 == 32 || i2 == 9) {
                    i2 = this._inputData.readUnsignedByte();
                    if (i2 > 32) {
                        if (i2 == 47 || i2 == 35) {
                            return _skipColon2(i2, true);
                        }
                        return i2;
                    }
                }
                return _skipColon2(i2, true);
            } else if (i2 == 47 || i2 == 35) {
                return _skipColon2(i2, true);
            } else {
                return i2;
            }
        } else {
            if (i == 32 || i == 9) {
                i = this._inputData.readUnsignedByte();
            }
            if (i != 58) {
                return _skipColon2(i, false);
            }
            int i3 = this._inputData.readUnsignedByte();
            if (i3 <= 32) {
                if (i3 == 32 || i3 == 9) {
                    i3 = this._inputData.readUnsignedByte();
                    if (i3 > 32) {
                        if (i3 == 47 || i3 == 35) {
                            return _skipColon2(i3, true);
                        }
                        return i3;
                    }
                }
                return _skipColon2(i3, true);
            } else if (i3 == 47 || i3 == 35) {
                return _skipColon2(i3, true);
            } else {
                return i3;
            }
        }
    }

    private final int _skipColon2(int i, boolean gotColon) throws IOException {
        while (true) {
            if (i > 32) {
                if (i == 47) {
                    _skipComment();
                } else if (i != 35 || !_skipYAMLComment()) {
                    if (gotColon) {
                        return i;
                    }
                    if (i != 58) {
                        _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
                    }
                    gotColon = true;
                }
            } else if (i == 13 || i == 10) {
                this._currInputRow++;
            }
            i = this._inputData.readUnsignedByte();
        }
    }

    private final void _skipComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        int c = this._inputData.readUnsignedByte();
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
        int i = this._inputData.readUnsignedByte();
        while (true) {
            int code = codes[i];
            if (code != 0) {
                switch (code) {
                    case 2:
                        _skipUtf8_2();
                        break;
                    case 3:
                        _skipUtf8_3();
                        break;
                    case 4:
                        _skipUtf8_4();
                        break;
                    case 10:
                    case 13:
                        this._currInputRow++;
                        break;
                    case 42:
                        i = this._inputData.readUnsignedByte();
                        if (i != 47) {
                            continue;
                        } else {
                            return;
                        }
                    default:
                        _reportInvalidChar(i);
                        break;
                }
            }
            i = this._inputData.readUnsignedByte();
        }
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
            int i = this._inputData.readUnsignedByte();
            int code = codes[i];
            if (code != 0) {
                switch (code) {
                    case 2:
                        _skipUtf8_2();
                        continue;
                    case 3:
                        _skipUtf8_3();
                        continue;
                    case 4:
                        _skipUtf8_4();
                        continue;
                    case 10:
                    case 13:
                        this._currInputRow++;
                        return;
                    case 42:
                        break;
                    default:
                        if (code < 0) {
                            _reportInvalidChar(i);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected char _decodeEscaped() throws IOException {
        int c = this._inputData.readUnsignedByte();
        switch (c) {
            case 34:
            case 47:
            case 92:
                return (char) c;
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
                for (int i = 0; i < 4; i++) {
                    int ch = this._inputData.readUnsignedByte();
                    int digit = CharTypes.charToHex(ch);
                    if (digit < 0) {
                        _reportUnexpectedChar(ch, "expected a hex-digit for character escape sequence");
                    }
                    value = (value << 4) | digit;
                }
                return (char) value;
            default:
                return _handleUnrecognizedCharacterEscape((char) _decodeCharForError(c));
        }
    }

    protected int _decodeCharForError(int firstByte) throws IOException {
        int needed;
        int c = firstByte & 255;
        if (c > 127) {
            if ((c & PacketOpcodes.WorldPlayerLocationNotify) == 192) {
                c &= 31;
                needed = 1;
            } else if ((c & PacketOpcodes.ExecuteGadgetLuaRsp) == 224) {
                c &= 15;
                needed = 2;
            } else if ((c & PacketOpcodes.ScenePlayerLocationNotify) == 240) {
                c &= 7;
                needed = 3;
            } else {
                _reportInvalidInitial(c & 255);
                needed = 1;
            }
            int d = this._inputData.readUnsignedByte();
            if ((d & 192) != 128) {
                _reportInvalidOther(d & 255);
            }
            c = (c << 6) | (d & 63);
            if (needed > 1) {
                int d2 = this._inputData.readUnsignedByte();
                if ((d2 & 192) != 128) {
                    _reportInvalidOther(d2 & 255);
                }
                c = (c << 6) | (d2 & 63);
                if (needed > 2) {
                    int d3 = this._inputData.readUnsignedByte();
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
        int d = this._inputData.readUnsignedByte();
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255);
        }
        return ((c & 31) << 6) | (d & 63);
    }

    private final int _decodeUtf8_3(int c1) throws IOException {
        int c12 = c1 & 15;
        int d = this._inputData.readUnsignedByte();
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255);
        }
        int c = (c12 << 6) | (d & 63);
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & 255);
        }
        return (c << 6) | (d2 & 63);
    }

    private final int _decodeUtf8_4(int c) throws IOException {
        int d = this._inputData.readUnsignedByte();
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255);
        }
        int c2 = ((c & 7) << 6) | (d & 63);
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & 255);
        }
        int c3 = (c2 << 6) | (d2 & 63);
        int d3 = this._inputData.readUnsignedByte();
        if ((d3 & 192) != 128) {
            _reportInvalidOther(d3 & 255);
        }
        return ((c3 << 6) | (d3 & 63)) - 65536;
    }

    private final void _skipUtf8_2() throws IOException {
        int c = this._inputData.readUnsignedByte();
        if ((c & 192) != 128) {
            _reportInvalidOther(c & 255);
        }
    }

    private final void _skipUtf8_3() throws IOException {
        int c = this._inputData.readUnsignedByte();
        if ((c & 192) != 128) {
            _reportInvalidOther(c & 255);
        }
        int c2 = this._inputData.readUnsignedByte();
        if ((c2 & 192) != 128) {
            _reportInvalidOther(c2 & 255);
        }
    }

    private final void _skipUtf8_4() throws IOException {
        int d = this._inputData.readUnsignedByte();
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255);
        }
        int d2 = this._inputData.readUnsignedByte();
        if ((d2 & 192) != 128) {
            _reportInvalidOther(d2 & 255);
        }
        int d3 = this._inputData.readUnsignedByte();
        if ((d3 & 192) != 128) {
            _reportInvalidOther(d3 & 255);
        }
    }

    protected void _reportInvalidToken(int ch, String matchedPart) throws IOException {
        _reportInvalidToken(ch, matchedPart, _validJsonTokenList());
    }

    protected void _reportInvalidToken(int ch, String matchedPart, String msg) throws IOException {
        StringBuilder sb = new StringBuilder(matchedPart);
        while (true) {
            char c = (char) _decodeCharForError(ch);
            if (!Character.isJavaIdentifierPart(c)) {
                _reportError("Unrecognized token '" + sb.toString() + "': was expecting " + msg);
                return;
            } else {
                sb.append(c);
                ch = this._inputData.readUnsignedByte();
            }
        }
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

    private void _reportInvalidOther(int mask) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(mask));
    }

    private static int[] _growArrayBy(int[] arr, int more) {
        if (arr == null) {
            return new int[more];
        }
        return Arrays.copyOf(arr, arr.length + more);
    }

    protected final byte[] _decodeBase64(Base64Variant b64variant) throws IOException {
        int ch;
        ByteArrayBuilder builder = _getByteArrayBuilder();
        while (true) {
            int ch2 = this._inputData.readUnsignedByte();
            if (ch2 > 32) {
                int bits = b64variant.decodeBase64Char(ch2);
                if (bits < 0) {
                    if (ch2 == 34) {
                        return builder.toByteArray();
                    }
                    bits = _decodeBase64Escape(b64variant, ch2, 0);
                    if (bits < 0) {
                        continue;
                    }
                }
                int ch3 = this._inputData.readUnsignedByte();
                int bits2 = b64variant.decodeBase64Char(ch3);
                if (bits2 < 0) {
                    bits2 = _decodeBase64Escape(b64variant, ch3, 1);
                }
                int decodedData = (bits << 6) | bits2;
                int ch4 = this._inputData.readUnsignedByte();
                int bits3 = b64variant.decodeBase64Char(ch4);
                if (bits3 < 0) {
                    if (bits3 != -2) {
                        if (ch4 == 34) {
                            builder.append(decodedData >> 4);
                            if (b64variant.usesPadding()) {
                                _handleBase64MissingPadding(b64variant);
                            }
                            return builder.toByteArray();
                        }
                        bits3 = _decodeBase64Escape(b64variant, ch4, 2);
                    }
                    if (bits3 == -2) {
                        ch = this._inputData.readUnsignedByte();
                        if (b64variant.usesPaddingChar(ch) || (ch == 92 && _decodeBase64Escape(b64variant, ch, 3) == -2)) {
                            builder.append(decodedData >> 4);
                        }
                    }
                }
                int decodedData2 = (decodedData << 6) | bits3;
                int ch5 = this._inputData.readUnsignedByte();
                int bits4 = b64variant.decodeBase64Char(ch5);
                if (bits4 < 0) {
                    if (bits4 != -2) {
                        if (ch5 == 34) {
                            builder.appendTwoBytes(decodedData2 >> 2);
                            if (b64variant.usesPadding()) {
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
        throw reportInvalidBase64Char(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return new JsonLocation(_contentReference(), -1L, -1L, this._tokenInputRow, -1);
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return new JsonLocation(_contentReference(), -1L, -1L, this._currInputRow, -1);
    }

    private void _closeScope(int i) throws JsonParseException {
        if (i == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_ARRAY;
        }
        if (i == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_OBJECT;
        }
    }

    private static final int pad(int q, int bytes) {
        return bytes == 4 ? q : q | (-1 << (bytes << 3));
    }
}
