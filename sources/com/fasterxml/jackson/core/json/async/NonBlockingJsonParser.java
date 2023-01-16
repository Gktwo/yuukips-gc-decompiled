package com.fasterxml.jackson.core.json.async;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.async.ByteArrayFeeder;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/json/async/NonBlockingJsonParser.class */
public class NonBlockingJsonParser extends NonBlockingJsonParserBase implements ByteArrayFeeder {
    private static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    private static final int[] _icUTF8 = CharTypes.getInputCodeUtf8();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();
    protected byte[] _inputBuffer = NO_BYTES;
    protected int _origBufferLen;

    public NonBlockingJsonParser(IOContext ctxt, int parserFeatures, ByteQuadsCanonicalizer sym) {
        super(ctxt, parserFeatures, sym);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ByteArrayFeeder getNonBlockingInputFeeder() {
        return this;
    }

    @Override // com.fasterxml.jackson.core.async.NonBlockingInputFeeder
    public final boolean needMoreInput() {
        return this._inputPtr >= this._inputEnd && !this._endOfInput;
    }

    @Override // com.fasterxml.jackson.core.async.ByteArrayFeeder
    public void feedInput(byte[] buf, int start, int end) throws IOException {
        if (this._inputPtr < this._inputEnd) {
            _reportError("Still have %d undecoded bytes, should not call 'feedInput'", Integer.valueOf(this._inputEnd - this._inputPtr));
        }
        if (end < start) {
            _reportError("Input end (%d) may not be before start (%d)", Integer.valueOf(end), Integer.valueOf(start));
        }
        if (this._endOfInput) {
            _reportError("Already closed, can not feed more input");
        }
        this._currInputProcessed += (long) this._origBufferLen;
        this._currInputRowStart = start - (this._inputEnd - this._currInputRowStart);
        this._currBufferStart = start;
        this._inputBuffer = buf;
        this._inputPtr = start;
        this._inputEnd = end;
        this._origBufferLen = end - start;
    }

    @Override // com.fasterxml.jackson.core.async.NonBlockingInputFeeder
    public void endOfInput() {
        this._endOfInput = true;
    }

    @Override // com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase, com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream out) throws IOException {
        int avail = this._inputEnd - this._inputPtr;
        if (avail > 0) {
            out.write(this._inputBuffer, this._inputPtr, avail);
        }
        return avail;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    protected char _decodeEscaped() throws IOException {
        VersionUtil.throwInternal();
        return ' ';
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            if (this._closed) {
                return null;
            }
            if (!this._endOfInput) {
                return JsonToken.NOT_AVAILABLE;
            }
            if (this._currToken == JsonToken.NOT_AVAILABLE) {
                return _finishTokenWithEOF();
            }
            return _eofAsNextToken();
        } else if (this._currToken == JsonToken.NOT_AVAILABLE) {
            return _finishToken();
        } else {
            this._numTypesValid = 0;
            this._tokenInputTotal = this._currInputProcessed + ((long) this._inputPtr);
            this._binaryValue = null;
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            switch (this._majorState) {
                case 0:
                    return _startDocument(ch);
                case 1:
                    return _startValue(ch);
                case 2:
                    return _startFieldName(ch);
                case 3:
                    return _startFieldNameAfterComma(ch);
                case 4:
                    return _startValueExpectColon(ch);
                case 5:
                    return _startValue(ch);
                case 6:
                    return _startValueExpectComma(ch);
                default:
                    VersionUtil.throwInternal();
                    return null;
            }
        }
    }

    protected final JsonToken _finishToken() throws IOException {
        switch (this._minorState) {
            case 1:
                return _finishBOM(this._pending32);
            case 2:
            case 3:
            case 6:
            case 11:
            case 20:
            case 21:
            case 22:
            case 27:
            case 28:
            case 29:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 46:
            case 47:
            case 48:
            case 49:
            default:
                VersionUtil.throwInternal();
                return null;
            case 4:
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                return _startFieldName(bArr[i] & 255);
            case 5:
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                return _startFieldNameAfterComma(bArr2[i2] & 255);
            case 7:
                return _parseEscapedName(this._quadLength, this._pending32, this._pendingBytes);
            case 8:
                return _finishFieldWithEscape();
            case 9:
                return _finishAposName(this._quadLength, this._pending32, this._pendingBytes);
            case 10:
                return _finishUnquotedName(this._quadLength, this._pending32, this._pendingBytes);
            case 12:
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                return _startValue(bArr3[i3] & 255);
            case 13:
                byte[] bArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                return _startValueExpectComma(bArr4[i4] & 255);
            case 14:
                byte[] bArr5 = this._inputBuffer;
                int i5 = this._inputPtr;
                this._inputPtr = i5 + 1;
                return _startValueExpectColon(bArr5[i5] & 255);
            case 15:
                byte[] bArr6 = this._inputBuffer;
                int i6 = this._inputPtr;
                this._inputPtr = i6 + 1;
                return _startValueAfterComma(bArr6[i6] & 255);
            case 16:
                return _finishKeywordToken("null", this._pending32, JsonToken.VALUE_NULL);
            case 17:
                return _finishKeywordToken(C3P0Substitutions.DEBUG, this._pending32, JsonToken.VALUE_TRUE);
            case 18:
                return _finishKeywordToken("false", this._pending32, JsonToken.VALUE_FALSE);
            case 19:
                return _finishNonStdToken(this._nonStdTokenType, this._pending32);
            case 23:
                byte[] bArr7 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                return _finishNumberMinus(bArr7[i7] & 255);
            case 24:
                return _finishNumberLeadingZeroes();
            case 25:
                return _finishNumberLeadingNegZeroes();
            case 26:
                return _finishNumberIntegralPart(this._textBuffer.getBufferWithoutReset(), this._textBuffer.getCurrentSegmentSize());
            case 30:
                return _finishFloatFraction();
            case 31:
                byte[] bArr8 = this._inputBuffer;
                int i8 = this._inputPtr;
                this._inputPtr = i8 + 1;
                return _finishFloatExponent(true, bArr8[i8] & 255);
            case 32:
                byte[] bArr9 = this._inputBuffer;
                int i9 = this._inputPtr;
                this._inputPtr = i9 + 1;
                return _finishFloatExponent(false, bArr9[i9] & 255);
            case 40:
                return _finishRegularString();
            case 41:
                int c = _decodeSplitEscaped(this._quoted32, this._quotedDigits);
                if (c < 0) {
                    return JsonToken.NOT_AVAILABLE;
                }
                this._textBuffer.append((char) c);
                if (this._minorStateAfterSplit == 45) {
                    return _finishAposString();
                }
                return _finishRegularString();
            case 42:
                TextBuffer textBuffer = this._textBuffer;
                int i10 = this._pending32;
                byte[] bArr10 = this._inputBuffer;
                int i11 = this._inputPtr;
                this._inputPtr = i11 + 1;
                textBuffer.append((char) _decodeUTF8_2(i10, bArr10[i11]));
                if (this._minorStateAfterSplit == 45) {
                    return _finishAposString();
                }
                return _finishRegularString();
            case 43:
                int i12 = this._pending32;
                int i13 = this._pendingBytes;
                byte[] bArr11 = this._inputBuffer;
                int i14 = this._inputPtr;
                this._inputPtr = i14 + 1;
                if (!_decodeSplitUTF8_3(i12, i13, bArr11[i14])) {
                    return JsonToken.NOT_AVAILABLE;
                }
                if (this._minorStateAfterSplit == 45) {
                    return _finishAposString();
                }
                return _finishRegularString();
            case 44:
                int i15 = this._pending32;
                int i16 = this._pendingBytes;
                byte[] bArr12 = this._inputBuffer;
                int i17 = this._inputPtr;
                this._inputPtr = i17 + 1;
                if (!_decodeSplitUTF8_4(i15, i16, bArr12[i17])) {
                    return JsonToken.NOT_AVAILABLE;
                }
                if (this._minorStateAfterSplit == 45) {
                    return _finishAposString();
                }
                return _finishRegularString();
            case 45:
                return _finishAposString();
            case 50:
                return _finishErrorToken();
            case 51:
                return _startSlashComment(this._pending32);
            case 52:
                return _finishCComment(this._pending32, true);
            case 53:
                return _finishCComment(this._pending32, false);
            case 54:
                return _finishCppComment(this._pending32);
            case 55:
                return _finishHashComment(this._pending32);
        }
    }

    protected final JsonToken _finishTokenWithEOF() throws IOException {
        JsonToken t = this._currToken;
        switch (this._minorState) {
            case 3:
                return _eofAsNextToken();
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 20:
            case 21:
            case 22:
            case 23:
            case 27:
            case 28:
            case 29:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 51:
            default:
                _reportInvalidEOF(": was expecting rest of token (internal state: " + this._minorState + ")", this._currToken);
                return t;
            case 12:
                return _eofAsNextToken();
            case 16:
                return _finishKeywordTokenWithEOF("null", this._pending32, JsonToken.VALUE_NULL);
            case 17:
                return _finishKeywordTokenWithEOF(C3P0Substitutions.DEBUG, this._pending32, JsonToken.VALUE_TRUE);
            case 18:
                return _finishKeywordTokenWithEOF("false", this._pending32, JsonToken.VALUE_FALSE);
            case 19:
                return _finishNonStdTokenWithEOF(this._nonStdTokenType, this._pending32);
            case 24:
            case 25:
                return _valueCompleteInt(0, "0");
            case 26:
                int len = this._textBuffer.getCurrentSegmentSize();
                if (this._numberNegative) {
                    len--;
                }
                this._intLength = len;
                return _valueComplete(JsonToken.VALUE_NUMBER_INT);
            case 30:
                this._expLength = 0;
                return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
            case 31:
                _reportInvalidEOF(": was expecting fraction after exponent marker", JsonToken.VALUE_NUMBER_FLOAT);
                _reportInvalidEOF(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                return _eofAsNextToken();
            case 32:
                return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
            case 50:
                return _finishErrorTokenWithEOF();
            case 52:
            case 53:
                _reportInvalidEOF(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                return _eofAsNextToken();
            case 54:
            case 55:
                return _eofAsNextToken();
        }
    }

    private final JsonToken _startDocument(int ch) throws IOException {
        int ch2 = ch & 255;
        if (ch2 == 239 && this._minorState != 1) {
            return _finishBOM(1);
        }
        while (ch2 <= 32) {
            if (ch2 != 32) {
                if (ch2 == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch2 == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch2 != 9) {
                    _throwInvalidSpace(ch2);
                }
            }
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 3;
                if (this._closed) {
                    return null;
                }
                if (this._endOfInput) {
                    return _eofAsNextToken();
                }
                return JsonToken.NOT_AVAILABLE;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            ch2 = bArr[i] & 255;
        }
        return _startValue(ch2);
    }

    private final JsonToken _finishBOM(int bytesHandled) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            switch (bytesHandled) {
                case 1:
                    if (ch == 187) {
                        break;
                    } else {
                        _reportError("Unexpected byte 0x%02x following 0xEF; should get 0xBB as second byte UTF-8 BOM", Integer.valueOf(ch));
                        break;
                    }
                case 2:
                    if (ch == 191) {
                        break;
                    } else {
                        _reportError("Unexpected byte 0x%02x following 0xEF 0xBB; should get 0xBF as third byte of UTF-8 BOM", Integer.valueOf(ch));
                        break;
                    }
                case 3:
                    this._currInputProcessed -= 3;
                    return _startDocument(ch);
            }
            bytesHandled++;
        }
        this._pending32 = bytesHandled;
        this._minorState = 1;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    private final JsonToken _startFieldName(int ch) throws IOException {
        String n;
        if (ch <= 32) {
            ch = _skipWS(ch);
            if (ch <= 0) {
                this._minorState = 4;
                return this._currToken;
            }
        }
        _updateTokenLocation();
        if (ch != 34) {
            if (ch == 125) {
                return _closeObjectScope();
            }
            return _handleOddName(ch);
        } else if (this._inputPtr + 13 > this._inputEnd || (n = _fastParseName()) == null) {
            return _parseEscapedName(0, 0, 0);
        } else {
            return _fieldComplete(n);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JsonToken _startFieldNameAfterComma(int ch) throws IOException {
        String n;
        if (ch <= 32) {
            ch = _skipWS(ch);
            if (ch <= 0) {
                this._minorState = 5;
                return this._currToken;
            }
        }
        if (ch != 44) {
            if (ch == 125) {
                return _closeObjectScope();
            }
            if (ch == 35) {
                return _finishHashComment(5);
            }
            if (ch == 47) {
                return _startSlashComment(5);
            }
            _reportUnexpectedChar(ch, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            this._minorState = 4;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        byte b = this._inputBuffer[ptr];
        this._inputPtr = ptr + 1;
        if (b <= 32) {
            b = _skipWS(b);
            if (b <= 0) {
                this._minorState = 4;
                return this._currToken;
            }
        }
        _updateTokenLocation();
        if (b != 34) {
            if (b != 125 || (this._features & FEAT_MASK_TRAILING_COMMA) == 0) {
                return _handleOddName(b);
            }
            return _closeObjectScope();
        } else if (this._inputPtr + 13 > this._inputEnd || (n = _fastParseName()) == null) {
            return _parseEscapedName(0, 0, 0);
        } else {
            return _fieldComplete(n);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final JsonToken _startValue(int ch) throws IOException {
        if (ch <= 32) {
            ch = _skipWS(ch);
            if (ch <= 0) {
                this._minorState = 12;
                return this._currToken;
            }
        }
        _updateTokenLocation();
        this._parsingContext.expectComma();
        if (ch == 34) {
            return _startString();
        }
        switch (ch) {
            case 35:
                return _finishHashComment(12);
            case 45:
                return _startNegativeNumber();
            case 46:
                if (isEnabled(JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS.mappedFeature())) {
                    return _startFloatThatStartsWithPeriod();
                }
                break;
            case 47:
                return _startSlashComment(12);
            case 48:
                return _startNumberLeadingZero();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return _startPositiveNumber(ch);
            case 91:
                return _startArrayScope();
            case 93:
                return _closeArrayScope();
            case 102:
                return _startFalseToken();
            case 110:
                return _startNullToken();
            case 116:
                return _startTrueToken();
            case 123:
                return _startObjectScope();
            case 125:
                return _closeObjectScope();
        }
        return _startUnexpectedValue(false, ch);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JsonToken _startValueExpectComma(int ch) throws IOException {
        if (ch <= 32) {
            ch = _skipWS(ch);
            if (ch <= 0) {
                this._minorState = 13;
                return this._currToken;
            }
        }
        if (ch != 44) {
            if (ch == 93) {
                return _closeArrayScope();
            }
            if (ch == 125) {
                return _closeObjectScope();
            }
            if (ch == 47) {
                return _startSlashComment(13);
            }
            if (ch == 35) {
                return _finishHashComment(13);
            }
            _reportUnexpectedChar(ch, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        this._parsingContext.expectComma();
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            this._minorState = 15;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        byte b = this._inputBuffer[ptr];
        this._inputPtr = ptr + 1;
        if (b <= 32) {
            b = _skipWS(b);
            if (b <= 0) {
                this._minorState = 15;
                return this._currToken;
            }
        }
        _updateTokenLocation();
        if (b == 34) {
            return _startString();
        }
        switch (b) {
            case 35:
                return _finishHashComment(15);
            case 45:
                return _startNegativeNumber();
            case 47:
                return _startSlashComment(15);
            case 48:
                return _startNumberLeadingZero();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return _startPositiveNumber(b);
            case 91:
                return _startArrayScope();
            case 93:
                if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
                    return _closeArrayScope();
                }
                break;
            case 102:
                return _startFalseToken();
            case 110:
                return _startNullToken();
            case 116:
                return _startTrueToken();
            case 123:
                return _startObjectScope();
            case 125:
                if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
                    return _closeObjectScope();
                }
                break;
        }
        return _startUnexpectedValue(true, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final JsonToken _startValueExpectColon(int ch) throws IOException {
        if (ch <= 32) {
            ch = _skipWS(ch);
            if (ch <= 0) {
                this._minorState = 14;
                return this._currToken;
            }
        }
        if (ch != 58) {
            if (ch == 47) {
                return _startSlashComment(14);
            }
            if (ch == 35) {
                return _finishHashComment(14);
            }
            _reportUnexpectedChar(ch, "was expecting a colon to separate field name and value");
        }
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            this._minorState = 12;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        byte b = this._inputBuffer[ptr];
        this._inputPtr = ptr + 1;
        if (b <= 32) {
            b = _skipWS(b);
            if (b <= 0) {
                this._minorState = 12;
                return this._currToken;
            }
        }
        _updateTokenLocation();
        if (b == 34) {
            return _startString();
        }
        switch (b) {
            case 35:
                return _finishHashComment(12);
            case 45:
                return _startNegativeNumber();
            case 47:
                return _startSlashComment(12);
            case 48:
                return _startNumberLeadingZero();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return _startPositiveNumber(b);
            case 91:
                return _startArrayScope();
            case 102:
                return _startFalseToken();
            case 110:
                return _startNullToken();
            case 116:
                return _startTrueToken();
            case 123:
                return _startObjectScope();
            default:
                return _startUnexpectedValue(false, b);
        }
    }

    private final JsonToken _startValueAfterComma(int ch) throws IOException {
        if (ch <= 32) {
            ch = _skipWS(ch);
            if (ch <= 0) {
                this._minorState = 15;
                return this._currToken;
            }
        }
        _updateTokenLocation();
        if (ch == 34) {
            return _startString();
        }
        switch (ch) {
            case 35:
                return _finishHashComment(15);
            case 45:
                return _startNegativeNumber();
            case 47:
                return _startSlashComment(15);
            case 48:
                return _startNumberLeadingZero();
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                return _startPositiveNumber(ch);
            case 91:
                return _startArrayScope();
            case 93:
                if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
                    return _closeArrayScope();
                }
                break;
            case 102:
                return _startFalseToken();
            case 110:
                return _startNullToken();
            case 116:
                return _startTrueToken();
            case 123:
                return _startObjectScope();
            case 125:
                if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0) {
                    return _closeObjectScope();
                }
                break;
        }
        return _startUnexpectedValue(true, ch);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004b, code lost:
        if (r5._parsingContext.inArray() == false) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken _startUnexpectedValue(boolean r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r7
            switch(r0) {
                case 39: goto L_0x007b;
                case 43: goto L_0x008b;
                case 44: goto L_0x0051;
                case 73: goto L_0x0099;
                case 78: goto L_0x0092;
                case 93: goto L_0x0044;
                case 125: goto L_0x0078;
                default: goto L_0x00a0;
            }
        L_0x0044:
            r0 = r5
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r0._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L_0x0051
            goto L_0x00a0
        L_0x0051:
            r0 = r5
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r0._parsingContext
            boolean r0 = r0.inRoot()
            if (r0 != 0) goto L_0x0078
            r0 = r5
            int r0 = r0._features
            int r1 = com.fasterxml.jackson.core.json.async.NonBlockingJsonParser.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0078
            r0 = r5
            r1 = r0
            int r1 = r1._inputPtr
            r2 = 1
            int r1 = r1 - r2
            r0._inputPtr = r1
            r0 = r5
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            com.fasterxml.jackson.core.JsonToken r0 = r0._valueComplete(r1)
            return r0
        L_0x0078:
            goto L_0x00a0
        L_0x007b:
            r0 = r5
            int r0 = r0._features
            int r1 = com.fasterxml.jackson.core.json.async.NonBlockingJsonParser.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00a0
            r0 = r5
            com.fasterxml.jackson.core.JsonToken r0 = r0._startAposString()
            return r0
        L_0x008b:
            r0 = r5
            r1 = 2
            r2 = 1
            com.fasterxml.jackson.core.JsonToken r0 = r0._finishNonStdToken(r1, r2)
            return r0
        L_0x0092:
            r0 = r5
            r1 = 0
            r2 = 1
            com.fasterxml.jackson.core.JsonToken r0 = r0._finishNonStdToken(r1, r2)
            return r0
        L_0x0099:
            r0 = r5
            r1 = 1
            r2 = 1
            com.fasterxml.jackson.core.JsonToken r0 = r0._finishNonStdToken(r1, r2)
            return r0
        L_0x00a0:
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "expected a valid value "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            java.lang.String r3 = r3._validJsonValueList()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0._reportUnexpectedChar(r1, r2)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingJsonParser._startUnexpectedValue(boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    private final int _skipWS(int ch) throws IOException {
        do {
            if (ch != 32) {
                if (ch == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch != 9) {
                    _throwInvalidSpace(ch);
                }
            }
            if (this._inputPtr >= this._inputEnd) {
                this._currToken = JsonToken.NOT_AVAILABLE;
                return 0;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            ch = bArr[i] & 255;
        } while (ch <= 32);
        return ch;
    }

    private final JsonToken _startSlashComment(int fromMinorState) throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd) {
            this._pending32 = fromMinorState;
            this._minorState = 51;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (b == 42) {
            return _finishCComment(fromMinorState, false);
        }
        if (b == 47) {
            return _finishCppComment(fromMinorState);
        }
        _reportUnexpectedChar(b & 255, "was expecting either '*' or '/' for a comment");
        return null;
    }

    private final JsonToken _finishHashComment(int fromMinorState) throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            _reportUnexpectedChar(35, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_YAML_COMMENTS' not enabled for parser)");
        }
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch < 32) {
                if (ch == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch != 9) {
                    _throwInvalidSpace(ch);
                }
                return _startAfterComment(fromMinorState);
            }
        }
        this._minorState = 55;
        this._pending32 = fromMinorState;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    private final JsonToken _finishCppComment(int fromMinorState) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch < 32) {
                if (ch == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch != 9) {
                    _throwInvalidSpace(ch);
                }
                return _startAfterComment(fromMinorState);
            }
        }
        this._minorState = 54;
        this._pending32 = fromMinorState;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    private final JsonToken _finishCComment(int fromMinorState, boolean gotStar) throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch < 32) {
                if (ch == 10) {
                    this._currInputRow++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch == 13) {
                    this._currInputRowAlt++;
                    this._currInputRowStart = this._inputPtr;
                } else if (ch != 9) {
                    _throwInvalidSpace(ch);
                }
            } else if (ch == 42) {
                gotStar = true;
            } else if (ch == 47 && gotStar) {
                return _startAfterComment(fromMinorState);
            }
            gotStar = false;
        }
        this._minorState = gotStar ? 52 : 53;
        this._pending32 = fromMinorState;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    private final JsonToken _startAfterComment(int fromMinorState) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = fromMinorState;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int ch = bArr[i] & 255;
        switch (fromMinorState) {
            case 4:
                return _startFieldName(ch);
            case 5:
                return _startFieldNameAfterComma(ch);
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                VersionUtil.throwInternal();
                return null;
            case 12:
                return _startValue(ch);
            case 13:
                return _startValueExpectComma(ch);
            case 14:
                return _startValueExpectColon(ch);
            case 15:
                return _startValueAfterComma(ch);
        }
    }

    protected JsonToken _startFalseToken() throws IOException {
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
                            return _valueComplete(JsonToken.VALUE_FALSE);
                        }
                    }
                }
            }
        }
        this._minorState = 18;
        return _finishKeywordToken("false", 1, JsonToken.VALUE_FALSE);
    }

    protected JsonToken _startTrueToken() throws IOException {
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
                        return _valueComplete(JsonToken.VALUE_TRUE);
                    }
                }
            }
        }
        this._minorState = 17;
        return _finishKeywordToken(C3P0Substitutions.DEBUG, 1, JsonToken.VALUE_TRUE);
    }

    protected JsonToken _startNullToken() throws IOException {
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
                        return _valueComplete(JsonToken.VALUE_NULL);
                    }
                }
            }
        }
        this._minorState = 16;
        return _finishKeywordToken("null", 1, JsonToken.VALUE_NULL);
    }

    protected JsonToken _finishKeywordToken(String expToken, int matched, JsonToken result) throws IOException {
        int end = expToken.length();
        while (this._inputPtr < this._inputEnd) {
            byte b = this._inputBuffer[this._inputPtr];
            if (matched == end) {
                if (b < 48 || b == 93 || b == 125) {
                    return _valueComplete(result);
                }
            } else if (b == expToken.charAt(matched)) {
                matched++;
                this._inputPtr++;
            }
            this._minorState = 50;
            this._textBuffer.resetWithCopy(expToken, 0, matched);
            return _finishErrorToken();
        }
        this._pending32 = matched;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    protected JsonToken _finishKeywordTokenWithEOF(String expToken, int matched, JsonToken result) throws IOException {
        if (matched == expToken.length()) {
            this._currToken = result;
            return result;
        }
        this._textBuffer.resetWithCopy(expToken, 0, matched);
        return _finishErrorTokenWithEOF();
    }

    protected JsonToken _finishNonStdToken(int type, int matched) throws IOException {
        String expToken = _nonStdToken(type);
        int end = expToken.length();
        while (this._inputPtr < this._inputEnd) {
            byte b = this._inputBuffer[this._inputPtr];
            if (matched == end) {
                if (b < 48 || b == 93 || b == 125) {
                    return _valueNonStdNumberComplete(type);
                }
            } else if (b == expToken.charAt(matched)) {
                matched++;
                this._inputPtr++;
            }
            this._minorState = 50;
            this._textBuffer.resetWithCopy(expToken, 0, matched);
            return _finishErrorToken();
        }
        this._nonStdTokenType = type;
        this._pending32 = matched;
        this._minorState = 19;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    protected JsonToken _finishNonStdTokenWithEOF(int type, int matched) throws IOException {
        String expToken = _nonStdToken(type);
        if (matched == expToken.length()) {
            return _valueNonStdNumberComplete(type);
        }
        this._textBuffer.resetWithCopy(expToken, 0, matched);
        return _finishErrorTokenWithEOF();
    }

    protected JsonToken _finishErrorToken() throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char ch = (char) bArr[i];
            if (Character.isJavaIdentifierPart(ch)) {
                this._textBuffer.append(ch);
                if (this._textBuffer.size() >= 256) {
                }
            }
            return _reportErrorToken(this._textBuffer.contentsAsString());
        }
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    protected JsonToken _finishErrorTokenWithEOF() throws IOException {
        return _reportErrorToken(this._textBuffer.contentsAsString());
    }

    protected JsonToken _reportErrorToken(String actualToken) throws IOException {
        _reportError("Unrecognized token '%s': was expecting %s", this._textBuffer.contentsAsString(), _validJsonTokenList());
        return JsonToken.NOT_AVAILABLE;
    }

    protected JsonToken _startFloatThatStartsWithPeriod() throws IOException {
        this._numberNegative = false;
        this._intLength = 0;
        return _startFloat(this._textBuffer.emptyAndGetCurrentSegment(), 0, 46);
    }

    protected JsonToken _startPositiveNumber(int ch) throws IOException {
        this._numberNegative = false;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        outBuf[0] = (char) ch;
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = 26;
            this._textBuffer.setCurrentLength(1);
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        int outPtr = 1;
        byte b = this._inputBuffer[this._inputPtr];
        while (true) {
            int ch2 = b & 255;
            if (ch2 < 48) {
                if (ch2 == 46) {
                    this._intLength = outPtr;
                    this._inputPtr++;
                    return _startFloat(outBuf, outPtr, ch2);
                }
            } else if (ch2 <= 57) {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.expandCurrentSegment();
                }
                outPtr++;
                outBuf[outPtr] = (char) ch2;
                int i = this._inputPtr + 1;
                this._inputPtr = i;
                if (i >= this._inputEnd) {
                    this._minorState = 26;
                    this._textBuffer.setCurrentLength(outPtr);
                    JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                    this._currToken = jsonToken2;
                    return jsonToken2;
                }
                b = this._inputBuffer[this._inputPtr];
            } else if (ch2 == 101 || ch2 == 69) {
                this._intLength = outPtr;
                this._inputPtr++;
                return _startFloat(outBuf, outPtr, ch2);
            }
        }
        this._intLength = outPtr;
        this._textBuffer.setCurrentLength(outPtr);
        return _valueComplete(JsonToken.VALUE_NUMBER_INT);
    }

    protected JsonToken _startNegativeNumber() throws IOException {
        this._numberNegative = true;
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = 23;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        int ch = bArr[i] & 255;
        if (ch <= 48) {
            if (ch == 48) {
                return _finishNumberLeadingNegZeroes();
            }
            reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
        } else if (ch > 57) {
            if (ch == 73) {
                return _finishNonStdToken(3, 2);
            }
            reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        outBuf[0] = '-';
        outBuf[1] = (char) ch;
        if (this._inputPtr >= this._inputEnd) {
            this._minorState = 26;
            this._textBuffer.setCurrentLength(2);
            this._intLength = 1;
            JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken2;
            return jsonToken2;
        }
        int outPtr = 2;
        int ch2 = this._inputBuffer[this._inputPtr];
        while (true) {
            if (ch2 < 48) {
                if (ch2 == 46) {
                    this._intLength = outPtr - 1;
                    this._inputPtr++;
                    int ch3 = ch2 == 1 ? 1 : 0;
                    int ch4 = ch2 == 1 ? 1 : 0;
                    int ch5 = ch2 == 1 ? 1 : 0;
                    return _startFloat(outBuf, outPtr, ch3);
                }
            } else if (ch2 <= 57) {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.expandCurrentSegment();
                }
                outPtr++;
                outBuf[outPtr] = (char) ch2;
                int i2 = this._inputPtr + 1;
                this._inputPtr = i2;
                if (i2 >= this._inputEnd) {
                    this._minorState = 26;
                    this._textBuffer.setCurrentLength(outPtr);
                    JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                    this._currToken = jsonToken3;
                    return jsonToken3;
                }
                ch2 = this._inputBuffer[this._inputPtr] & 255;
            } else if (ch2 == 101 || ch2 == 69) {
                this._intLength = outPtr - 1;
                this._inputPtr++;
                return _startFloat(outBuf, outPtr, ch2);
            }
        }
        this._intLength = outPtr - 1;
        this._textBuffer.setCurrentLength(outPtr);
        return _valueComplete(JsonToken.VALUE_NUMBER_INT);
    }

    protected JsonToken _startNumberLeadingZero() throws IOException {
        int ptr = this._inputPtr;
        if (ptr >= this._inputEnd) {
            this._minorState = 24;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        int ptr2 = ptr + 1;
        int ch = this._inputBuffer[ptr] & 255;
        if (ch < 48) {
            if (ch == 46) {
                this._inputPtr = ptr2;
                this._intLength = 1;
                char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
                outBuf[0] = '0';
                return _startFloat(outBuf, 1, ch);
            }
        } else if (ch <= 57) {
            return _finishNumberLeadingZeroes();
        } else {
            if (ch == 101 || ch == 69) {
                this._inputPtr = ptr2;
                this._intLength = 1;
                char[] outBuf2 = this._textBuffer.emptyAndGetCurrentSegment();
                outBuf2[0] = '0';
                return _startFloat(outBuf2, 1, ch);
            } else if (!(ch == 93 || ch == 125)) {
                reportUnexpectedNumberChar(ch, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
            }
        }
        return _valueCompleteInt(0, "0");
    }

    protected JsonToken _finishNumberMinus(int ch) throws IOException {
        if (ch <= 48) {
            if (ch == 48) {
                return _finishNumberLeadingNegZeroes();
            }
            reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
        } else if (ch > 57) {
            if (ch == 73) {
                return _finishNonStdToken(3, 2);
            }
            reportUnexpectedNumberChar(ch, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        outBuf[0] = '-';
        outBuf[1] = (char) ch;
        this._intLength = 1;
        return _finishNumberIntegralPart(outBuf, 2);
    }

    protected JsonToken _finishNumberLeadingZeroes() throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch < 48) {
                if (ch == 46) {
                    char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
                    outBuf[0] = '0';
                    this._intLength = 1;
                    return _startFloat(outBuf, 1, ch);
                }
            } else if (ch <= 57) {
                if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
                    reportInvalidNumber("Leading zeroes not allowed");
                }
                if (ch != 48) {
                    char[] outBuf2 = this._textBuffer.emptyAndGetCurrentSegment();
                    outBuf2[0] = (char) ch;
                    this._intLength = 1;
                    return _finishNumberIntegralPart(outBuf2, 1);
                }
            } else if (ch == 101 || ch == 69) {
                char[] outBuf3 = this._textBuffer.emptyAndGetCurrentSegment();
                outBuf3[0] = '0';
                this._intLength = 1;
                return _startFloat(outBuf3, 1, ch);
            } else if (!(ch == 93 || ch == 125)) {
                reportUnexpectedNumberChar(ch, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
            }
            this._inputPtr--;
            return _valueCompleteInt(0, "0");
        }
        this._minorState = 24;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    protected JsonToken _finishNumberLeadingNegZeroes() throws IOException {
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch < 48) {
                if (ch == 46) {
                    char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
                    outBuf[0] = '-';
                    outBuf[1] = '0';
                    this._intLength = 1;
                    return _startFloat(outBuf, 2, ch);
                }
            } else if (ch <= 57) {
                if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
                    reportInvalidNumber("Leading zeroes not allowed");
                }
                if (ch != 48) {
                    char[] outBuf2 = this._textBuffer.emptyAndGetCurrentSegment();
                    outBuf2[0] = '-';
                    outBuf2[1] = (char) ch;
                    this._intLength = 1;
                    return _finishNumberIntegralPart(outBuf2, 2);
                }
            } else if (ch == 101 || ch == 69) {
                char[] outBuf3 = this._textBuffer.emptyAndGetCurrentSegment();
                outBuf3[0] = '-';
                outBuf3[1] = '0';
                this._intLength = 1;
                return _startFloat(outBuf3, 2, ch);
            } else if (!(ch == 93 || ch == 125)) {
                reportUnexpectedNumberChar(ch, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
            }
            this._inputPtr--;
            return _valueCompleteInt(0, "0");
        }
        this._minorState = 25;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    protected JsonToken _finishNumberIntegralPart(char[] outBuf, int outPtr) throws IOException {
        int negMod = this._numberNegative ? -1 : 0;
        while (this._inputPtr < this._inputEnd) {
            int ch = this._inputBuffer[this._inputPtr] & 255;
            if (ch < 48) {
                if (ch == 46) {
                    this._intLength = outPtr + negMod;
                    this._inputPtr++;
                    return _startFloat(outBuf, outPtr, ch);
                }
            } else if (ch <= 57) {
                this._inputPtr++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.expandCurrentSegment();
                }
                outPtr++;
                outBuf[outPtr] = (char) ch;
            } else if (ch == 101 || ch == 69) {
                this._intLength = outPtr + negMod;
                this._inputPtr++;
                return _startFloat(outBuf, outPtr, ch);
            }
            this._intLength = outPtr + negMod;
            this._textBuffer.setCurrentLength(outPtr);
            return _valueComplete(JsonToken.VALUE_NUMBER_INT);
        }
        this._minorState = 26;
        this._textBuffer.setCurrentLength(outPtr);
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    protected JsonToken _startFloat(char[] outBuf, int outPtr, int ch) throws IOException {
        int fractLen = 0;
        if (ch == 46) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.expandCurrentSegment();
            }
            outPtr++;
            outBuf[outPtr] = '.';
            while (this._inputPtr < this._inputEnd) {
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                byte b = bArr[i];
                if (b < 48 || b > 57) {
                    ch = b & 255;
                    if (fractLen == 0) {
                        reportUnexpectedNumberChar(ch, "Decimal point not followed by a digit");
                    }
                } else {
                    if (outPtr >= outBuf.length) {
                        outBuf = this._textBuffer.expandCurrentSegment();
                    }
                    outPtr++;
                    outBuf[outPtr] = (char) b;
                    fractLen++;
                }
            }
            this._textBuffer.setCurrentLength(outPtr);
            this._minorState = 30;
            this._fractLength = fractLen;
            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
            this._currToken = jsonToken;
            return jsonToken;
        }
        this._fractLength = fractLen;
        int expLen = 0;
        if (ch == 101 || ch == 69) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.expandCurrentSegment();
            }
            outPtr++;
            outBuf[outPtr] = (char) ch;
            if (this._inputPtr >= this._inputEnd) {
                this._textBuffer.setCurrentLength(outPtr);
                this._minorState = 31;
                this._expLength = 0;
                JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
                this._currToken = jsonToken2;
                return jsonToken2;
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b2 = bArr2[i2];
            if (b2 == 45 || b2 == 43) {
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.expandCurrentSegment();
                }
                outPtr++;
                outBuf[outPtr] = (char) b2;
                if (this._inputPtr >= this._inputEnd) {
                    this._textBuffer.setCurrentLength(outPtr);
                    this._minorState = 32;
                    this._expLength = 0;
                    JsonToken jsonToken3 = JsonToken.NOT_AVAILABLE;
                    this._currToken = jsonToken3;
                    return jsonToken3;
                }
                byte[] bArr3 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                b2 = bArr3[i3];
            }
            while (b2 >= 48 && b2 <= 57) {
                expLen++;
                if (outPtr >= outBuf.length) {
                    outBuf = this._textBuffer.expandCurrentSegment();
                }
                outPtr++;
                outBuf[outPtr] = (char) b2;
                if (this._inputPtr >= this._inputEnd) {
                    this._textBuffer.setCurrentLength(outPtr);
                    this._minorState = 32;
                    this._expLength = expLen;
                    JsonToken jsonToken4 = JsonToken.NOT_AVAILABLE;
                    this._currToken = jsonToken4;
                    return jsonToken4;
                }
                byte[] bArr4 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                b2 = bArr4[i4];
            }
            int ch2 = b2 & 255;
            if (expLen == 0) {
                reportUnexpectedNumberChar(ch2, "Exponent indicator not followed by a digit");
            }
        }
        this._inputPtr--;
        this._textBuffer.setCurrentLength(outPtr);
        this._expLength = expLen;
        return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
    }

    protected JsonToken _finishFloatFraction() throws IOException {
        int fractLen = this._fractLength;
        char[] outBuf = this._textBuffer.getBufferWithoutReset();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        do {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            byte b = bArr[i];
            if (b < 48 || b > 57) {
                if (fractLen == 0) {
                    reportUnexpectedNumberChar(b, "Decimal point not followed by a digit");
                }
                this._fractLength = fractLen;
                this._textBuffer.setCurrentLength(outPtr);
                if (b == 101 || b == 69) {
                    this._textBuffer.append((char) b);
                    this._expLength = 0;
                    if (this._inputPtr >= this._inputEnd) {
                        this._minorState = 31;
                        return JsonToken.NOT_AVAILABLE;
                    }
                    this._minorState = 32;
                    byte[] bArr2 = this._inputBuffer;
                    int i2 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    return _finishFloatExponent(true, bArr2[i2] & 255);
                }
                this._inputPtr--;
                this._textBuffer.setCurrentLength(outPtr);
                this._expLength = 0;
                return _valueComplete(JsonToken.VALUE_NUMBER_FLOAT);
            }
            fractLen++;
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.expandCurrentSegment();
            }
            outPtr++;
            outBuf[outPtr] = (char) b;
        } while (this._inputPtr < this._inputEnd);
        this._textBuffer.setCurrentLength(outPtr);
        this._fractLength = fractLen;
        return JsonToken.NOT_AVAILABLE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        if (r8 == 43) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.fasterxml.jackson.core.JsonToken _finishFloatExponent(boolean r7, int r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.async.NonBlockingJsonParser._finishFloatExponent(boolean, int):com.fasterxml.jackson.core.JsonToken");
    }

    private final String _fastParseName() throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int ptr = this._inputPtr;
        int ptr2 = ptr + 1;
        int q0 = input[ptr] & 255;
        if (codes[q0] == 0) {
            int ptr3 = ptr2 + 1;
            int i = input[ptr2] & 255;
            if (codes[i] == 0) {
                int q = (q0 << 8) | i;
                int ptr4 = ptr3 + 1;
                int i2 = input[ptr3] & 255;
                if (codes[i2] == 0) {
                    int q2 = (q << 8) | i2;
                    int ptr5 = ptr4 + 1;
                    int i3 = input[ptr4] & 255;
                    if (codes[i3] == 0) {
                        int q3 = (q2 << 8) | i3;
                        int ptr6 = ptr5 + 1;
                        int i4 = input[ptr5] & 255;
                        if (codes[i4] == 0) {
                            this._quad1 = q3;
                            return _parseMediumName(ptr6, i4);
                        } else if (i4 != 34) {
                            return null;
                        } else {
                            this._inputPtr = ptr6;
                            return _findName(q3, 4);
                        }
                    } else if (i3 != 34) {
                        return null;
                    } else {
                        this._inputPtr = ptr5;
                        return _findName(q2, 3);
                    }
                } else if (i2 != 34) {
                    return null;
                } else {
                    this._inputPtr = ptr4;
                    return _findName(q, 2);
                }
            } else if (i != 34) {
                return null;
            } else {
                this._inputPtr = ptr3;
                return _findName(q0, 1);
            }
        } else if (q0 != 34) {
            return null;
        } else {
            this._inputPtr = ptr2;
            return "";
        }
    }

    private final String _parseMediumName(int ptr, int q2) throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int ptr2 = ptr + 1;
        int i = input[ptr] & 255;
        if (codes[i] == 0) {
            int q22 = (q2 << 8) | i;
            int ptr3 = ptr2 + 1;
            int i2 = input[ptr2] & 255;
            if (codes[i2] == 0) {
                int q23 = (q22 << 8) | i2;
                int ptr4 = ptr3 + 1;
                int i3 = input[ptr3] & 255;
                if (codes[i3] == 0) {
                    int q24 = (q23 << 8) | i3;
                    int ptr5 = ptr4 + 1;
                    int i4 = input[ptr4] & 255;
                    if (codes[i4] == 0) {
                        return _parseMediumName2(ptr5, i4, q24);
                    }
                    if (i4 != 34) {
                        return null;
                    }
                    this._inputPtr = ptr5;
                    return _findName(this._quad1, q24, 4);
                } else if (i3 != 34) {
                    return null;
                } else {
                    this._inputPtr = ptr4;
                    return _findName(this._quad1, q23, 3);
                }
            } else if (i2 != 34) {
                return null;
            } else {
                this._inputPtr = ptr3;
                return _findName(this._quad1, q22, 2);
            }
        } else if (i != 34) {
            return null;
        } else {
            this._inputPtr = ptr2;
            return _findName(this._quad1, q2, 1);
        }
    }

    private final String _parseMediumName2(int ptr, int q3, int q2) throws IOException {
        byte[] input = this._inputBuffer;
        int[] codes = _icLatin1;
        int ptr2 = ptr + 1;
        int i = input[ptr] & 255;
        if (codes[i] == 0) {
            int q32 = (q3 << 8) | i;
            int ptr3 = ptr2 + 1;
            int i2 = input[ptr2] & 255;
            if (codes[i2] == 0) {
                int q33 = (q32 << 8) | i2;
                int ptr4 = ptr3 + 1;
                int i3 = input[ptr3] & 255;
                if (codes[i3] == 0) {
                    int q34 = (q33 << 8) | i3;
                    int ptr5 = ptr4 + 1;
                    if ((input[ptr4] & 255) != 34) {
                        return null;
                    }
                    this._inputPtr = ptr5;
                    return _findName(this._quad1, q2, q34, 4);
                } else if (i3 != 34) {
                    return null;
                } else {
                    this._inputPtr = ptr4;
                    return _findName(this._quad1, q2, q33, 3);
                }
            } else if (i2 != 34) {
                return null;
            } else {
                this._inputPtr = ptr3;
                return _findName(this._quad1, q2, q32, 2);
            }
        } else if (i != 34) {
            return null;
        } else {
            this._inputPtr = ptr2;
            return _findName(this._quad1, q2, q3, 1);
        }
    }

    private final JsonToken _parseEscapedName(int qlen, int currQuad, int currQuadBytes) throws IOException {
        int[] quads = this._quadBuffer;
        int[] codes = _icLatin1;
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (codes[ch] == 0) {
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
            } else if (ch == 34) {
                if (currQuadBytes > 0) {
                    if (qlen >= quads.length) {
                        int[] growArrayBy2 = growArrayBy(quads, quads.length);
                        quads = growArrayBy2;
                        this._quadBuffer = growArrayBy2;
                    }
                    qlen++;
                    quads[qlen] = _padLastQuad(currQuad, currQuadBytes);
                } else if (qlen == 0) {
                    return _fieldComplete("");
                }
                String name = this._symbols.findName(quads, qlen);
                if (name == null) {
                    name = _addName(quads, qlen, currQuadBytes);
                }
                return _fieldComplete(name);
            } else {
                if (ch != 92) {
                    _throwUnquotedSpace(ch, "name");
                } else {
                    ch = _decodeCharEscape();
                    if (ch < 0) {
                        this._minorState = 8;
                        this._minorStateAfterSplit = 7;
                        this._quadLength = qlen;
                        this._pending32 = currQuad;
                        this._pendingBytes = currQuadBytes;
                        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                        this._currToken = jsonToken;
                        return jsonToken;
                    }
                }
                if (qlen >= quads.length) {
                    int[] growArrayBy3 = growArrayBy(quads, quads.length);
                    quads = growArrayBy3;
                    this._quadBuffer = growArrayBy3;
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
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
                if (currQuadBytes < 4) {
                    currQuadBytes++;
                    currQuad = (currQuad << 8) | ch;
                } else {
                    qlen++;
                    quads[qlen] = currQuad;
                    currQuad = ch;
                    currQuadBytes = 1;
                }
            }
        }
        this._quadLength = qlen;
        this._pending32 = currQuad;
        this._pendingBytes = currQuadBytes;
        this._minorState = 7;
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    private JsonToken _handleOddName(int ch) throws IOException {
        switch (ch) {
            case 35:
                if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) != 0) {
                    return _finishHashComment(4);
                }
                break;
            case 39:
                if ((this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
                    return _finishAposName(0, 0, 0);
                }
                break;
            case 47:
                return _startSlashComment(4);
            case 93:
                return _closeArrayScope();
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar((char) ch, "was expecting double-quote to start field name");
        }
        if (CharTypes.getInputCodeUtf8JsNames()[ch] != 0) {
            _reportUnexpectedChar(ch, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        return _finishUnquotedName(0, ch, 1);
    }

    private JsonToken _finishUnquotedName(int qlen, int currQuad, int currQuadBytes) throws IOException {
        int[] quads = this._quadBuffer;
        int[] codes = CharTypes.getInputCodeUtf8JsNames();
        while (this._inputPtr < this._inputEnd) {
            int ch = this._inputBuffer[this._inputPtr] & 255;
            if (codes[ch] != 0) {
                if (currQuadBytes > 0) {
                    if (qlen >= quads.length) {
                        int[] growArrayBy = growArrayBy(quads, quads.length);
                        quads = growArrayBy;
                        this._quadBuffer = growArrayBy;
                    }
                    qlen++;
                    quads[qlen] = currQuad;
                }
                String name = this._symbols.findName(quads, qlen);
                if (name == null) {
                    name = _addName(quads, qlen, currQuadBytes);
                }
                return _fieldComplete(name);
            }
            this._inputPtr++;
            if (currQuadBytes < 4) {
                currQuadBytes++;
                currQuad = (currQuad << 8) | ch;
            } else {
                if (qlen >= quads.length) {
                    int[] growArrayBy2 = growArrayBy(quads, quads.length);
                    quads = growArrayBy2;
                    this._quadBuffer = growArrayBy2;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
        }
        this._quadLength = qlen;
        this._pending32 = currQuad;
        this._pendingBytes = currQuadBytes;
        this._minorState = 10;
        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken;
        return jsonToken;
    }

    private JsonToken _finishAposName(int qlen, int currQuad, int currQuadBytes) throws IOException {
        int[] quads = this._quadBuffer;
        int[] codes = _icLatin1;
        while (this._inputPtr < this._inputEnd) {
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            int ch = bArr[i] & 255;
            if (ch == 39) {
                if (currQuadBytes > 0) {
                    if (qlen >= quads.length) {
                        int[] growArrayBy = growArrayBy(quads, quads.length);
                        quads = growArrayBy;
                        this._quadBuffer = growArrayBy;
                    }
                    qlen++;
                    quads[qlen] = _padLastQuad(currQuad, currQuadBytes);
                } else if (qlen == 0) {
                    return _fieldComplete("");
                }
                String name = this._symbols.findName(quads, qlen);
                if (name == null) {
                    name = _addName(quads, qlen, currQuadBytes);
                }
                return _fieldComplete(name);
            }
            if (!(ch == 34 || codes[ch] == 0)) {
                if (ch != 92) {
                    _throwUnquotedSpace(ch, "name");
                } else {
                    ch = _decodeCharEscape();
                    if (ch < 0) {
                        this._minorState = 8;
                        this._minorStateAfterSplit = 9;
                        this._quadLength = qlen;
                        this._pending32 = currQuad;
                        this._pendingBytes = currQuadBytes;
                        JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                        this._currToken = jsonToken;
                        return jsonToken;
                    }
                }
                if (ch > 127) {
                    if (currQuadBytes >= 4) {
                        if (qlen >= quads.length) {
                            int[] growArrayBy2 = growArrayBy(quads, quads.length);
                            quads = growArrayBy2;
                            this._quadBuffer = growArrayBy2;
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
                                int[] growArrayBy3 = growArrayBy(quads, quads.length);
                                quads = growArrayBy3;
                                this._quadBuffer = growArrayBy3;
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
                    int[] growArrayBy4 = growArrayBy(quads, quads.length);
                    quads = growArrayBy4;
                    this._quadBuffer = growArrayBy4;
                }
                qlen++;
                quads[qlen] = currQuad;
                currQuad = ch;
                currQuadBytes = 1;
            }
        }
        this._quadLength = qlen;
        this._pending32 = currQuad;
        this._pendingBytes = currQuadBytes;
        this._minorState = 9;
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    protected final JsonToken _finishFieldWithEscape() throws IOException {
        int currQuadBytes;
        int currQuad;
        int ch = _decodeSplitEscaped(this._quoted32, this._quotedDigits);
        if (ch < 0) {
            this._minorState = 8;
            return JsonToken.NOT_AVAILABLE;
        }
        if (this._quadLength >= this._quadBuffer.length) {
            this._quadBuffer = growArrayBy(this._quadBuffer, 32);
        }
        int currQuad2 = this._pending32;
        int currQuadBytes2 = this._pendingBytes;
        if (ch > 127) {
            if (currQuadBytes2 >= 4) {
                int[] iArr = this._quadBuffer;
                int i = this._quadLength;
                this._quadLength = i + 1;
                iArr[i] = currQuad2;
                currQuad2 = 0;
                currQuadBytes2 = 0;
            }
            if (ch < 2048) {
                currQuad2 = (currQuad2 << 8) | 192 | (ch >> 6);
                currQuadBytes2++;
            } else {
                int currQuad3 = (currQuad2 << 8) | 224 | (ch >> 12);
                int currQuadBytes3 = currQuadBytes2 + 1;
                if (currQuadBytes3 >= 4) {
                    int[] iArr2 = this._quadBuffer;
                    int i2 = this._quadLength;
                    this._quadLength = i2 + 1;
                    iArr2[i2] = currQuad3;
                    currQuad3 = 0;
                    currQuadBytes3 = 0;
                }
                currQuad2 = (currQuad3 << 8) | 128 | ((ch >> 6) & 63);
                currQuadBytes2 = currQuadBytes3 + 1;
            }
            ch = 128 | (ch & 63);
        }
        if (currQuadBytes2 < 4) {
            currQuadBytes = currQuadBytes2 + 1;
            currQuad = (currQuad2 << 8) | ch;
        } else {
            int[] iArr3 = this._quadBuffer;
            int i3 = this._quadLength;
            this._quadLength = i3 + 1;
            iArr3[i3] = currQuad2;
            currQuad = ch;
            currQuadBytes = 1;
        }
        if (this._minorStateAfterSplit == 9) {
            return _finishAposName(this._quadLength, currQuad, currQuadBytes);
        }
        return _parseEscapedName(this._quadLength, currQuad, currQuadBytes);
    }

    private int _decodeSplitEscaped(int value, int bytesRead) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            this._quoted32 = value;
            this._quotedDigits = bytesRead;
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (bytesRead == -1) {
            switch (b) {
                case 34:
                case 47:
                case 92:
                    return b;
                case 98:
                    return 8;
                case 102:
                    return 12;
                case 110:
                    return 10;
                case 114:
                    return 13;
                case 116:
                    return 9;
                case 117:
                    if (this._inputPtr < this._inputEnd) {
                        byte[] bArr2 = this._inputBuffer;
                        int i2 = this._inputPtr;
                        this._inputPtr = i2 + 1;
                        b = bArr2[i2];
                        bytesRead = 0;
                        break;
                    } else {
                        this._quotedDigits = 0;
                        this._quoted32 = 0;
                        return -1;
                    }
                default:
                    return _handleUnrecognizedCharacterEscape((char) b);
            }
        }
        byte b2 = b;
        while (true) {
            int c = b2 & 255;
            int digit = CharTypes.charToHex(c);
            if (digit < 0) {
                _reportUnexpectedChar(c & 255, "expected a hex-digit for character escape sequence");
            }
            value = (value << 4) | digit;
            bytesRead++;
            if (bytesRead == 4) {
                return value;
            }
            if (this._inputPtr >= this._inputEnd) {
                this._quotedDigits = bytesRead;
                this._quoted32 = value;
                return -1;
            }
            byte[] bArr3 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            b2 = bArr3[i3];
        }
    }

    protected JsonToken _startString() throws IOException {
        int ptr = this._inputPtr;
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
                return _valueComplete(JsonToken.VALUE_STRING);
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        this._inputPtr = ptr;
        return _finishRegularString();
    }

    private final JsonToken _finishRegularString() throws IOException {
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        char[] outBuf = this._textBuffer.getBufferWithoutReset();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        int ptr = this._inputPtr;
        int safeEnd = this._inputEnd - 5;
        while (ptr < this._inputEnd) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = Math.min(this._inputEnd, ptr + (outBuf.length - outPtr));
            while (true) {
                if (ptr < max) {
                    ptr++;
                    int c = inputBuffer[ptr] & 255;
                    if (codes[c] == 0) {
                        outPtr++;
                        outBuf[outPtr] = (char) c;
                    } else if (c == 34) {
                        this._inputPtr = ptr;
                        this._textBuffer.setCurrentLength(outPtr);
                        return _valueComplete(JsonToken.VALUE_STRING);
                    } else if (ptr >= safeEnd) {
                        this._inputPtr = ptr;
                        this._textBuffer.setCurrentLength(outPtr);
                        if (!_decodeSplitMultiByte(c, codes[c], ptr < this._inputEnd)) {
                            this._minorStateAfterSplit = 40;
                            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                            this._currToken = jsonToken;
                            return jsonToken;
                        }
                        outBuf = this._textBuffer.getBufferWithoutReset();
                        outPtr = this._textBuffer.getCurrentSegmentSize();
                        ptr = this._inputPtr;
                    } else {
                        switch (codes[c]) {
                            case 1:
                                this._inputPtr = ptr;
                                c = _decodeFastCharEscape();
                                ptr = this._inputPtr;
                                break;
                            case 2:
                                ptr++;
                                c = _decodeUTF8_2(c, this._inputBuffer[ptr]);
                                break;
                            case 3:
                                int ptr2 = ptr + 1;
                                byte b = this._inputBuffer[ptr];
                                ptr = ptr2 + 1;
                                c = _decodeUTF8_3(c, b, this._inputBuffer[ptr2]);
                                break;
                            case 4:
                                int ptr3 = ptr + 1;
                                byte b2 = this._inputBuffer[ptr];
                                int ptr4 = ptr3 + 1;
                                byte b3 = this._inputBuffer[ptr3];
                                ptr = ptr4 + 1;
                                int c2 = _decodeUTF8_4(c, b2, b3, this._inputBuffer[ptr4]);
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
                    }
                }
            }
        }
        this._inputPtr = ptr;
        this._minorState = 40;
        this._textBuffer.setCurrentLength(outPtr);
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    protected JsonToken _startAposString() throws IOException {
        int ptr = this._inputPtr;
        int outPtr = 0;
        char[] outBuf = this._textBuffer.emptyAndGetCurrentSegment();
        int[] codes = _icUTF8;
        int max = Math.min(this._inputEnd, ptr + outBuf.length);
        byte[] inputBuffer = this._inputBuffer;
        while (ptr < max) {
            int c = inputBuffer[ptr] & 255;
            if (c == 39) {
                this._inputPtr = ptr + 1;
                this._textBuffer.setCurrentLength(outPtr);
                return _valueComplete(JsonToken.VALUE_STRING);
            } else if (codes[c] != 0) {
                break;
            } else {
                ptr++;
                outPtr++;
                outBuf[outPtr] = (char) c;
            }
        }
        this._textBuffer.setCurrentLength(outPtr);
        this._inputPtr = ptr;
        return _finishAposString();
    }

    private final JsonToken _finishAposString() throws IOException {
        int[] codes = _icUTF8;
        byte[] inputBuffer = this._inputBuffer;
        char[] outBuf = this._textBuffer.getBufferWithoutReset();
        int outPtr = this._textBuffer.getCurrentSegmentSize();
        int ptr = this._inputPtr;
        int safeEnd = this._inputEnd - 5;
        while (ptr < this._inputEnd) {
            if (outPtr >= outBuf.length) {
                outBuf = this._textBuffer.finishCurrentSegment();
                outPtr = 0;
            }
            int max = Math.min(this._inputEnd, ptr + (outBuf.length - outPtr));
            while (true) {
                if (ptr < max) {
                    ptr++;
                    int c = inputBuffer[ptr] & 255;
                    if (codes[c] == 0 || c == 34) {
                        if (c == 39) {
                            this._inputPtr = ptr;
                            this._textBuffer.setCurrentLength(outPtr);
                            return _valueComplete(JsonToken.VALUE_STRING);
                        }
                        outPtr++;
                        outBuf[outPtr] = (char) c;
                    } else if (ptr >= safeEnd) {
                        this._inputPtr = ptr;
                        this._textBuffer.setCurrentLength(outPtr);
                        if (!_decodeSplitMultiByte(c, codes[c], ptr < this._inputEnd)) {
                            this._minorStateAfterSplit = 45;
                            JsonToken jsonToken = JsonToken.NOT_AVAILABLE;
                            this._currToken = jsonToken;
                            return jsonToken;
                        }
                        outBuf = this._textBuffer.getBufferWithoutReset();
                        outPtr = this._textBuffer.getCurrentSegmentSize();
                        ptr = this._inputPtr;
                    } else {
                        switch (codes[c]) {
                            case 1:
                                this._inputPtr = ptr;
                                c = _decodeFastCharEscape();
                                ptr = this._inputPtr;
                                break;
                            case 2:
                                ptr++;
                                c = _decodeUTF8_2(c, this._inputBuffer[ptr]);
                                break;
                            case 3:
                                int ptr2 = ptr + 1;
                                byte b = this._inputBuffer[ptr];
                                ptr = ptr2 + 1;
                                c = _decodeUTF8_3(c, b, this._inputBuffer[ptr2]);
                                break;
                            case 4:
                                int ptr3 = ptr + 1;
                                byte b2 = this._inputBuffer[ptr];
                                int ptr4 = ptr3 + 1;
                                byte b3 = this._inputBuffer[ptr3];
                                ptr = ptr4 + 1;
                                int c2 = _decodeUTF8_4(c, b2, b3, this._inputBuffer[ptr4]);
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
                    }
                }
            }
        }
        this._inputPtr = ptr;
        this._minorState = 45;
        this._textBuffer.setCurrentLength(outPtr);
        JsonToken jsonToken2 = JsonToken.NOT_AVAILABLE;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    private final boolean _decodeSplitMultiByte(int c, int type, boolean gotNext) throws IOException {
        switch (type) {
            case 1:
                int c2 = _decodeSplitEscaped(0, -1);
                if (c2 < 0) {
                    this._minorState = 41;
                    return false;
                }
                this._textBuffer.append((char) c2);
                return true;
            case 2:
                if (gotNext) {
                    byte[] bArr = this._inputBuffer;
                    int i = this._inputPtr;
                    this._inputPtr = i + 1;
                    this._textBuffer.append((char) _decodeUTF8_2(c, bArr[i]));
                    return true;
                }
                this._minorState = 42;
                this._pending32 = c;
                return false;
            case 3:
                int c3 = c & 15;
                if (gotNext) {
                    byte[] bArr2 = this._inputBuffer;
                    int i2 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    return _decodeSplitUTF8_3(c3, 1, bArr2[i2]);
                }
                this._minorState = 43;
                this._pending32 = c3;
                this._pendingBytes = 1;
                return false;
            case 4:
                int c4 = c & 7;
                if (gotNext) {
                    byte[] bArr3 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    return _decodeSplitUTF8_4(c4, 1, bArr3[i3]);
                }
                this._pending32 = c4;
                this._pendingBytes = 1;
                this._minorState = 44;
                return false;
            default:
                if (c < 32) {
                    _throwUnquotedSpace(c, "string value");
                } else {
                    _reportInvalidChar(c);
                }
                this._textBuffer.append((char) c);
                return true;
        }
    }

    private final boolean _decodeSplitUTF8_3(int prev, int prevCount, int next) throws IOException {
        int next2 = next;
        if (prevCount == 1) {
            if ((next & 192) != 128) {
                _reportInvalidOther(next & 255, this._inputPtr);
            }
            prev = (prev << 6) | (next & 63);
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 43;
                this._pending32 = prev;
                this._pendingBytes = 2;
                return false;
            }
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            next2 = bArr[i];
        }
        if (((next2 == 1 ? 1 : 0) & 192) != 128) {
            _reportInvalidOther(next2 & 255, this._inputPtr);
        }
        this._textBuffer.append((char) ((prev << 6) | (next2 & 63)));
        return true;
    }

    private final boolean _decodeSplitUTF8_4(int prev, int prevCount, int next) throws IOException {
        int next2 = next;
        if (prevCount == 1) {
            if ((next & 192) != 128) {
                _reportInvalidOther(next & 255, this._inputPtr);
            }
            prev = (prev << 6) | (next & 63);
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 44;
                this._pending32 = prev;
                this._pendingBytes = 2;
                return false;
            }
            prevCount = 2;
            byte[] bArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            next2 = bArr[i];
        }
        int next3 = next2;
        if (prevCount == 2) {
            if (((next2 == 1 ? 1 : 0) & 192) != 128) {
                _reportInvalidOther(next2 & 255, this._inputPtr);
            }
            prev = (prev << 6) | (next2 & 63);
            if (this._inputPtr >= this._inputEnd) {
                this._minorState = 44;
                this._pending32 = prev;
                this._pendingBytes = 3;
                return false;
            }
            byte[] bArr2 = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            next3 = bArr2[i2];
        }
        int next4 = next3 == 1 ? 1 : 0;
        int next5 = next3 == 1 ? 1 : 0;
        if ((next4 & 192) != 128) {
            _reportInvalidOther(next3 & 255, this._inputPtr);
        }
        int c = ((prev << 6) | (next3 & 63)) - 65536;
        this._textBuffer.append((char) (55296 | (c >> 10)));
        this._textBuffer.append((char) (56320 | (c & 1023)));
        return true;
    }

    private final int _decodeCharEscape() throws IOException {
        if (this._inputEnd - this._inputPtr < 5) {
            return _decodeSplitEscaped(0, -1);
        }
        return _decodeFastCharEscape();
    }

    private final int _decodeFastCharEscape() throws IOException {
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
                return 8;
            case 102:
                return 12;
            case 110:
                return 10;
            case 114:
                return 13;
            case 116:
                return 9;
            case 117:
                byte[] bArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                byte b2 = bArr2[i2];
                int digit = CharTypes.charToHex(b2);
                if (digit >= 0) {
                    byte[] bArr3 = this._inputBuffer;
                    int i3 = this._inputPtr;
                    this._inputPtr = i3 + 1;
                    b2 = bArr3[i3];
                    int digit2 = CharTypes.charToHex(b2);
                    if (digit2 >= 0) {
                        int result = (digit << 4) | digit2;
                        byte[] bArr4 = this._inputBuffer;
                        int i4 = this._inputPtr;
                        this._inputPtr = i4 + 1;
                        b2 = bArr4[i4];
                        int digit3 = CharTypes.charToHex(b2);
                        if (digit3 >= 0) {
                            int result2 = (result << 4) | digit3;
                            byte[] bArr5 = this._inputBuffer;
                            int i5 = this._inputPtr;
                            this._inputPtr = i5 + 1;
                            b2 = bArr5[i5];
                            int digit4 = CharTypes.charToHex(b2);
                            if (digit4 >= 0) {
                                return (result2 << 4) | digit4;
                            }
                        }
                    }
                }
                _reportUnexpectedChar(b2 & 255, "expected a hex-digit for character escape sequence");
                return -1;
            default:
                return _handleUnrecognizedCharacterEscape((char) b);
        }
    }

    private final int _decodeUTF8_2(int c, int d) throws IOException {
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255, this._inputPtr);
        }
        return ((c & 31) << 6) | (d & 63);
    }

    private final int _decodeUTF8_3(int c, int d, int e) throws IOException {
        int c2 = c & 15;
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255, this._inputPtr);
        }
        int c3 = (c2 << 6) | (d & 63);
        if ((e & 192) != 128) {
            _reportInvalidOther(e & 255, this._inputPtr);
        }
        return (c3 << 6) | (e & 63);
    }

    private final int _decodeUTF8_4(int c, int d, int e, int f) throws IOException {
        if ((d & 192) != 128) {
            _reportInvalidOther(d & 255, this._inputPtr);
        }
        int c2 = ((c & 7) << 6) | (d & 63);
        if ((e & 192) != 128) {
            _reportInvalidOther(e & 255, this._inputPtr);
        }
        int c3 = (c2 << 6) | (e & 63);
        if ((f & 192) != 128) {
            _reportInvalidOther(f & 255, this._inputPtr);
        }
        return ((c3 << 6) | (f & 63)) - 65536;
    }
}
