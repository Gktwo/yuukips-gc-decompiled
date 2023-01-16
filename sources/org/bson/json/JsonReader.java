package org.bson.json;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.bson.AbstractBsonReader;
import org.bson.BsonBinary;
import org.bson.BsonBinarySubType;
import org.bson.BsonContextType;
import org.bson.BsonDbPointer;
import org.bson.BsonInvalidOperationException;
import org.bson.BsonReaderMark;
import org.bson.BsonRegularExpression;
import org.bson.BsonTimestamp;
import org.bson.BsonType;
import org.bson.BsonUndefined;
import org.bson.internal.Base64;
import org.bson.types.Decimal128;
import org.bson.types.MaxKey;
import org.bson.types.MinKey;
import org.bson.types.ObjectId;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* loaded from: grasscutter.jar:org/bson/json/JsonReader.class */
public class JsonReader extends AbstractBsonReader {
    private final JsonScanner scanner;
    private JsonToken pushedToken;
    private Object currentValue;

    public JsonReader(String json) {
        this(new JsonScanner(json));
    }

    public JsonReader(Reader reader) {
        this(new JsonScanner(reader));
    }

    private JsonReader(JsonScanner scanner) {
        this.scanner = scanner;
        setContext(new Context(null, BsonContextType.TOP_LEVEL));
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonBinary doReadBinaryData() {
        return (BsonBinary) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected byte doPeekBinarySubType() {
        return doReadBinaryData().getType();
    }

    @Override // org.bson.AbstractBsonReader
    protected int doPeekBinarySize() {
        return doReadBinaryData().getData().length;
    }

    @Override // org.bson.AbstractBsonReader
    protected boolean doReadBoolean() {
        return ((Boolean) this.currentValue).booleanValue();
    }

    @Override // org.bson.AbstractBsonReader, org.bson.BsonReader
    public BsonType readBsonType() {
        if (isClosed()) {
            throw new IllegalStateException("This instance has been closed");
        }
        if (getState() == AbstractBsonReader.State.INITIAL || getState() == AbstractBsonReader.State.DONE || getState() == AbstractBsonReader.State.SCOPE_DOCUMENT) {
            setState(AbstractBsonReader.State.TYPE);
        }
        if (getState() != AbstractBsonReader.State.TYPE) {
            throwInvalidState("readBSONType", AbstractBsonReader.State.TYPE);
        }
        if (getContext().getContextType() == BsonContextType.DOCUMENT) {
            JsonToken nameToken = popToken();
            switch (nameToken.getType()) {
                case STRING:
                case UNQUOTED_STRING:
                    setCurrentName((String) nameToken.getValue(String.class));
                    JsonToken colonToken = popToken();
                    if (colonToken.getType() != JsonTokenType.COLON) {
                        throw new JsonParseException("JSON reader was expecting ':' but found '%s'.", colonToken.getValue());
                    }
                    break;
                case END_OBJECT:
                    setState(AbstractBsonReader.State.END_OF_DOCUMENT);
                    return BsonType.END_OF_DOCUMENT;
                default:
                    throw new JsonParseException("JSON reader was expecting a name but found '%s'.", nameToken.getValue());
            }
        }
        JsonToken token = popToken();
        if (getContext().getContextType() == BsonContextType.ARRAY && token.getType() == JsonTokenType.END_ARRAY) {
            setState(AbstractBsonReader.State.END_OF_ARRAY);
            return BsonType.END_OF_DOCUMENT;
        }
        boolean noValueFound = false;
        switch (token.getType()) {
            case STRING:
                setCurrentBsonType(BsonType.STRING);
                this.currentValue = token.getValue();
                break;
            case UNQUOTED_STRING:
                String value = (String) token.getValue(String.class);
                if (!"false".equals(value) && !C3P0Substitutions.DEBUG.equals(value)) {
                    if (!"Infinity".equals(value)) {
                        if (!"NaN".equals(value)) {
                            if (!"null".equals(value)) {
                                if (!"undefined".equals(value)) {
                                    if (!"MinKey".equals(value)) {
                                        if (!"MaxKey".equals(value)) {
                                            if (!"BinData".equals(value)) {
                                                if (!"Date".equals(value)) {
                                                    if (!"HexData".equals(value)) {
                                                        if (!"ISODate".equals(value)) {
                                                            if (!"NumberInt".equals(value)) {
                                                                if (!"NumberLong".equals(value)) {
                                                                    if (!"NumberDecimal".equals(value)) {
                                                                        if (!"ObjectId".equals(value)) {
                                                                            if (!"Timestamp".equals(value)) {
                                                                                if (!"RegExp".equals(value)) {
                                                                                    if (!"DBPointer".equals(value)) {
                                                                                        if (!"UUID".equals(value)) {
                                                                                            if (!"new".equals(value)) {
                                                                                                noValueFound = true;
                                                                                                break;
                                                                                            } else {
                                                                                                visitNew();
                                                                                                break;
                                                                                            }
                                                                                        } else {
                                                                                            setCurrentBsonType(BsonType.BINARY);
                                                                                            this.currentValue = visitUUIDConstructor();
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        setCurrentBsonType(BsonType.DB_POINTER);
                                                                                        this.currentValue = visitDBPointerConstructor();
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    setCurrentBsonType(BsonType.REGULAR_EXPRESSION);
                                                                                    this.currentValue = visitRegularExpressionConstructor();
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                setCurrentBsonType(BsonType.TIMESTAMP);
                                                                                this.currentValue = visitTimestampConstructor();
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            setCurrentBsonType(BsonType.OBJECT_ID);
                                                                            this.currentValue = visitObjectIdConstructor();
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        setCurrentBsonType(BsonType.DECIMAL128);
                                                                        this.currentValue = visitNumberDecimalConstructor();
                                                                        break;
                                                                    }
                                                                } else {
                                                                    setCurrentBsonType(BsonType.INT64);
                                                                    this.currentValue = Long.valueOf(visitNumberLongConstructor());
                                                                    break;
                                                                }
                                                            } else {
                                                                setCurrentBsonType(BsonType.INT32);
                                                                this.currentValue = Integer.valueOf(visitNumberIntConstructor());
                                                                break;
                                                            }
                                                        } else {
                                                            setCurrentBsonType(BsonType.DATE_TIME);
                                                            this.currentValue = Long.valueOf(visitISODateTimeConstructor());
                                                            break;
                                                        }
                                                    } else {
                                                        setCurrentBsonType(BsonType.BINARY);
                                                        this.currentValue = visitHexDataConstructor();
                                                        break;
                                                    }
                                                } else {
                                                    this.currentValue = visitDateTimeConstructorWithOutNew();
                                                    setCurrentBsonType(BsonType.STRING);
                                                    break;
                                                }
                                            } else {
                                                setCurrentBsonType(BsonType.BINARY);
                                                this.currentValue = visitBinDataConstructor();
                                                break;
                                            }
                                        } else {
                                            visitEmptyConstructor();
                                            setCurrentBsonType(BsonType.MAX_KEY);
                                            this.currentValue = new MaxKey();
                                            break;
                                        }
                                    } else {
                                        visitEmptyConstructor();
                                        setCurrentBsonType(BsonType.MIN_KEY);
                                        this.currentValue = new MinKey();
                                        break;
                                    }
                                } else {
                                    setCurrentBsonType(BsonType.UNDEFINED);
                                    break;
                                }
                            } else {
                                setCurrentBsonType(BsonType.NULL);
                                break;
                            }
                        } else {
                            setCurrentBsonType(BsonType.DOUBLE);
                            this.currentValue = Double.valueOf(Double.NaN);
                            break;
                        }
                    } else {
                        setCurrentBsonType(BsonType.DOUBLE);
                        this.currentValue = Double.valueOf(Double.POSITIVE_INFINITY);
                        break;
                    }
                } else {
                    setCurrentBsonType(BsonType.BOOLEAN);
                    this.currentValue = Boolean.valueOf(Boolean.parseBoolean(value));
                    break;
                }
                break;
            case END_OBJECT:
            default:
                noValueFound = true;
                break;
            case BEGIN_ARRAY:
                setCurrentBsonType(BsonType.ARRAY);
                break;
            case BEGIN_OBJECT:
                visitExtendedJSON();
                break;
            case DOUBLE:
                setCurrentBsonType(BsonType.DOUBLE);
                this.currentValue = token.getValue();
                break;
            case END_OF_FILE:
                setCurrentBsonType(BsonType.END_OF_DOCUMENT);
                break;
            case INT32:
                setCurrentBsonType(BsonType.INT32);
                this.currentValue = token.getValue();
                break;
            case INT64:
                setCurrentBsonType(BsonType.INT64);
                this.currentValue = token.getValue();
                break;
            case REGULAR_EXPRESSION:
                setCurrentBsonType(BsonType.REGULAR_EXPRESSION);
                this.currentValue = token.getValue();
                break;
        }
        if (noValueFound) {
            throw new JsonParseException("JSON reader was expecting a value but found '%s'.", token.getValue());
        }
        if (getContext().getContextType() == BsonContextType.ARRAY || getContext().getContextType() == BsonContextType.DOCUMENT) {
            JsonToken commaToken = popToken();
            if (commaToken.getType() != JsonTokenType.COMMA) {
                pushToken(commaToken);
            }
        }
        switch (getContext().getContextType()) {
            case DOCUMENT:
            case SCOPE_DOCUMENT:
            default:
                setState(AbstractBsonReader.State.NAME);
                break;
            case ARRAY:
            case JAVASCRIPT_WITH_SCOPE:
            case TOP_LEVEL:
                setState(AbstractBsonReader.State.VALUE);
                break;
        }
        return getCurrentBsonType();
    }

    @Override // org.bson.AbstractBsonReader
    public Decimal128 doReadDecimal128() {
        return (Decimal128) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected long doReadDateTime() {
        return ((Long) this.currentValue).longValue();
    }

    @Override // org.bson.AbstractBsonReader
    protected double doReadDouble() {
        return ((Double) this.currentValue).doubleValue();
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadEndArray() {
        setContext(getContext().getParentContext());
        if (getContext().getContextType() == BsonContextType.ARRAY || getContext().getContextType() == BsonContextType.DOCUMENT) {
            JsonToken commaToken = popToken();
            if (commaToken.getType() != JsonTokenType.COMMA) {
                pushToken(commaToken);
            }
        }
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadEndDocument() {
        setContext(getContext().getParentContext());
        if (getContext() != null && getContext().getContextType() == BsonContextType.SCOPE_DOCUMENT) {
            setContext(getContext().getParentContext());
            verifyToken(JsonTokenType.END_OBJECT);
        }
        if (getContext() == null) {
            throw new JsonParseException("Unexpected end of document.");
        } else if (getContext().getContextType() == BsonContextType.ARRAY || getContext().getContextType() == BsonContextType.DOCUMENT) {
            JsonToken commaToken = popToken();
            if (commaToken.getType() != JsonTokenType.COMMA) {
                pushToken(commaToken);
            }
        }
    }

    @Override // org.bson.AbstractBsonReader
    protected int doReadInt32() {
        return ((Integer) this.currentValue).intValue();
    }

    @Override // org.bson.AbstractBsonReader
    protected long doReadInt64() {
        return ((Long) this.currentValue).longValue();
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadJavaScript() {
        return (String) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadJavaScriptWithScope() {
        return (String) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadMaxKey() {
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadMinKey() {
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadNull() {
    }

    @Override // org.bson.AbstractBsonReader
    protected ObjectId doReadObjectId() {
        return (ObjectId) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonRegularExpression doReadRegularExpression() {
        return (BsonRegularExpression) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonDbPointer doReadDBPointer() {
        return (BsonDbPointer) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadStartArray() {
        setContext(new Context(getContext(), BsonContextType.ARRAY));
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadStartDocument() {
        setContext(new Context(getContext(), BsonContextType.DOCUMENT));
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadString() {
        return (String) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadSymbol() {
        return (String) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonTimestamp doReadTimestamp() {
        return (BsonTimestamp) this.currentValue;
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadUndefined() {
    }

    @Override // org.bson.AbstractBsonReader
    protected void doSkipName() {
    }

    @Override // org.bson.AbstractBsonReader
    protected void doSkipValue() {
        switch (getCurrentBsonType()) {
            case ARRAY:
                readStartArray();
                while (readBsonType() != BsonType.END_OF_DOCUMENT) {
                    skipValue();
                }
                readEndArray();
                return;
            case BINARY:
                readBinaryData();
                return;
            case BOOLEAN:
                readBoolean();
                return;
            case DATE_TIME:
                readDateTime();
                return;
            case DOCUMENT:
                readStartDocument();
                while (readBsonType() != BsonType.END_OF_DOCUMENT) {
                    skipName();
                    skipValue();
                }
                readEndDocument();
                return;
            case DOUBLE:
                readDouble();
                return;
            case INT32:
                readInt32();
                return;
            case INT64:
                readInt64();
                return;
            case DECIMAL128:
                readDecimal128();
                return;
            case JAVASCRIPT:
                readJavaScript();
                return;
            case JAVASCRIPT_WITH_SCOPE:
                readJavaScriptWithScope();
                readStartDocument();
                while (readBsonType() != BsonType.END_OF_DOCUMENT) {
                    skipName();
                    skipValue();
                }
                readEndDocument();
                return;
            case MAX_KEY:
                readMaxKey();
                return;
            case MIN_KEY:
                readMinKey();
                return;
            case NULL:
                readNull();
                return;
            case OBJECT_ID:
                readObjectId();
                return;
            case REGULAR_EXPRESSION:
                readRegularExpression();
                return;
            case STRING:
                readString();
                return;
            case SYMBOL:
                readSymbol();
                return;
            case TIMESTAMP:
                readTimestamp();
                return;
            case UNDEFINED:
                readUndefined();
                return;
            default:
                return;
        }
    }

    private JsonToken popToken() {
        if (this.pushedToken == null) {
            return this.scanner.nextToken();
        }
        JsonToken token = this.pushedToken;
        this.pushedToken = null;
        return token;
    }

    private void pushToken(JsonToken token) {
        if (this.pushedToken == null) {
            this.pushedToken = token;
            return;
        }
        throw new BsonInvalidOperationException("There is already a pending token.");
    }

    private void verifyToken(JsonTokenType expectedType) {
        JsonToken token = popToken();
        if (expectedType != token.getType()) {
            throw new JsonParseException("JSON reader expected token type '%s' but found '%s'.", expectedType, token.getValue());
        }
    }

    private void verifyToken(JsonTokenType expectedType, Object expectedValue) {
        JsonToken token = popToken();
        if (expectedType != token.getType()) {
            throw new JsonParseException("JSON reader expected token type '%s' but found '%s'.", expectedType, token.getValue());
        } else if (!expectedValue.equals(token.getValue())) {
            throw new JsonParseException("JSON reader expected '%s' but found '%s'.", expectedValue, token.getValue());
        }
    }

    private void verifyString(String expected) {
        if (expected == null) {
            throw new IllegalArgumentException("Can't be null");
        }
        JsonToken token = popToken();
        JsonTokenType type = token.getType();
        if ((type != JsonTokenType.STRING && type != JsonTokenType.UNQUOTED_STRING) || !expected.equals(token.getValue())) {
            throw new JsonParseException("JSON reader expected '%s' but found '%s'.", expected, token.getValue());
        }
    }

    private void visitNew() {
        JsonToken typeToken = popToken();
        if (typeToken.getType() != JsonTokenType.UNQUOTED_STRING) {
            throw new JsonParseException("JSON reader expected a type name but found '%s'.", typeToken.getValue());
        }
        String value = (String) typeToken.getValue(String.class);
        if ("MinKey".equals(value)) {
            visitEmptyConstructor();
            setCurrentBsonType(BsonType.MIN_KEY);
            this.currentValue = new MinKey();
        } else if ("MaxKey".equals(value)) {
            visitEmptyConstructor();
            setCurrentBsonType(BsonType.MAX_KEY);
            this.currentValue = new MaxKey();
        } else if ("BinData".equals(value)) {
            this.currentValue = visitBinDataConstructor();
            setCurrentBsonType(BsonType.BINARY);
        } else if ("Date".equals(value)) {
            this.currentValue = Long.valueOf(visitDateTimeConstructor());
            setCurrentBsonType(BsonType.DATE_TIME);
        } else if ("HexData".equals(value)) {
            this.currentValue = visitHexDataConstructor();
            setCurrentBsonType(BsonType.BINARY);
        } else if ("ISODate".equals(value)) {
            this.currentValue = Long.valueOf(visitISODateTimeConstructor());
            setCurrentBsonType(BsonType.DATE_TIME);
        } else if ("NumberInt".equals(value)) {
            this.currentValue = Integer.valueOf(visitNumberIntConstructor());
            setCurrentBsonType(BsonType.INT32);
        } else if ("NumberLong".equals(value)) {
            this.currentValue = Long.valueOf(visitNumberLongConstructor());
            setCurrentBsonType(BsonType.INT64);
        } else if ("NumberDecimal".equals(value)) {
            this.currentValue = visitNumberDecimalConstructor();
            setCurrentBsonType(BsonType.DECIMAL128);
        } else if ("ObjectId".equals(value)) {
            this.currentValue = visitObjectIdConstructor();
            setCurrentBsonType(BsonType.OBJECT_ID);
        } else if ("RegExp".equals(value)) {
            this.currentValue = visitRegularExpressionConstructor();
            setCurrentBsonType(BsonType.REGULAR_EXPRESSION);
        } else if ("DBPointer".equals(value)) {
            this.currentValue = visitDBPointerConstructor();
            setCurrentBsonType(BsonType.DB_POINTER);
        } else if ("UUID".equals(value)) {
            this.currentValue = visitUUIDConstructor();
            setCurrentBsonType(BsonType.BINARY);
        } else {
            throw new JsonParseException("JSON reader expected a type name but found '%s'.", value);
        }
    }

    private void visitExtendedJSON() {
        JsonToken nameToken = popToken();
        String value = (String) nameToken.getValue(String.class);
        JsonTokenType type = nameToken.getType();
        if (type == JsonTokenType.STRING || type == JsonTokenType.UNQUOTED_STRING) {
            if ("$binary".equals(value) || "$type".equals(value)) {
                this.currentValue = visitBinDataExtendedJson(value);
                if (this.currentValue != null) {
                    setCurrentBsonType(BsonType.BINARY);
                    return;
                }
            }
            if ("$uuid".equals(value)) {
                this.currentValue = visitUuidExtendedJson();
                setCurrentBsonType(BsonType.BINARY);
                return;
            } else if ("$regex".equals(value) || "$options".equals(value)) {
                this.currentValue = visitRegularExpressionExtendedJson(value);
                if (this.currentValue != null) {
                    setCurrentBsonType(BsonType.REGULAR_EXPRESSION);
                    return;
                }
            } else if ("$code".equals(value)) {
                visitJavaScriptExtendedJson();
                return;
            } else if ("$date".equals(value)) {
                this.currentValue = Long.valueOf(visitDateTimeExtendedJson());
                setCurrentBsonType(BsonType.DATE_TIME);
                return;
            } else if ("$maxKey".equals(value)) {
                this.currentValue = visitMaxKeyExtendedJson();
                setCurrentBsonType(BsonType.MAX_KEY);
                return;
            } else if ("$minKey".equals(value)) {
                this.currentValue = visitMinKeyExtendedJson();
                setCurrentBsonType(BsonType.MIN_KEY);
                return;
            } else if ("$oid".equals(value)) {
                this.currentValue = visitObjectIdExtendedJson();
                setCurrentBsonType(BsonType.OBJECT_ID);
                return;
            } else if ("$regularExpression".equals(value)) {
                this.currentValue = visitNewRegularExpressionExtendedJson();
                setCurrentBsonType(BsonType.REGULAR_EXPRESSION);
                return;
            } else if ("$symbol".equals(value)) {
                this.currentValue = visitSymbolExtendedJson();
                setCurrentBsonType(BsonType.SYMBOL);
                return;
            } else if ("$timestamp".equals(value)) {
                this.currentValue = visitTimestampExtendedJson();
                setCurrentBsonType(BsonType.TIMESTAMP);
                return;
            } else if ("$undefined".equals(value)) {
                this.currentValue = visitUndefinedExtendedJson();
                setCurrentBsonType(BsonType.UNDEFINED);
                return;
            } else if ("$numberLong".equals(value)) {
                this.currentValue = visitNumberLongExtendedJson();
                setCurrentBsonType(BsonType.INT64);
                return;
            } else if ("$numberInt".equals(value)) {
                this.currentValue = visitNumberIntExtendedJson();
                setCurrentBsonType(BsonType.INT32);
                return;
            } else if ("$numberDouble".equals(value)) {
                this.currentValue = visitNumberDoubleExtendedJson();
                setCurrentBsonType(BsonType.DOUBLE);
                return;
            } else if ("$numberDecimal".equals(value)) {
                this.currentValue = visitNumberDecimalExtendedJson();
                setCurrentBsonType(BsonType.DECIMAL128);
                return;
            } else if ("$dbPointer".equals(value)) {
                this.currentValue = visitDbPointerExtendedJson();
                setCurrentBsonType(BsonType.DB_POINTER);
                return;
            }
        }
        pushToken(nameToken);
        setCurrentBsonType(BsonType.DOCUMENT);
    }

    private void visitEmptyConstructor() {
        JsonToken nextToken = popToken();
        if (nextToken.getType() == JsonTokenType.LEFT_PAREN) {
            verifyToken(JsonTokenType.RIGHT_PAREN);
        } else {
            pushToken(nextToken);
        }
    }

    private BsonBinary visitBinDataConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken subTypeToken = popToken();
        if (subTypeToken.getType() != JsonTokenType.INT32) {
            throw new JsonParseException("JSON reader expected a binary subtype but found '%s'.", subTypeToken.getValue());
        }
        verifyToken(JsonTokenType.COMMA);
        JsonToken bytesToken = popToken();
        if (bytesToken.getType() == JsonTokenType.UNQUOTED_STRING || bytesToken.getType() == JsonTokenType.STRING) {
            verifyToken(JsonTokenType.RIGHT_PAREN);
            return new BsonBinary(((Integer) subTypeToken.getValue(Integer.class)).byteValue(), Base64.decode((String) bytesToken.getValue(String.class)));
        }
        throw new JsonParseException("JSON reader expected a string but found '%s'.", bytesToken.getValue());
    }

    private BsonBinary visitUUIDConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        String hexString = readStringFromExtendedJson().replace("-", "");
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return new BsonBinary(BsonBinarySubType.UUID_STANDARD, decodeHex(hexString));
    }

    private BsonRegularExpression visitRegularExpressionConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        String pattern = readStringFromExtendedJson();
        String options = "";
        JsonToken commaToken = popToken();
        if (commaToken.getType() == JsonTokenType.COMMA) {
            options = readStringFromExtendedJson();
        } else {
            pushToken(commaToken);
        }
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return new BsonRegularExpression(pattern, options);
    }

    private ObjectId visitObjectIdConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        ObjectId objectId = new ObjectId(readStringFromExtendedJson());
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return objectId;
    }

    private BsonTimestamp visitTimestampConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken timeToken = popToken();
        if (timeToken.getType() != JsonTokenType.INT32) {
            throw new JsonParseException("JSON reader expected an integer but found '%s'.", timeToken.getValue());
        }
        int time = ((Integer) timeToken.getValue(Integer.class)).intValue();
        verifyToken(JsonTokenType.COMMA);
        JsonToken incrementToken = popToken();
        if (incrementToken.getType() != JsonTokenType.INT32) {
            throw new JsonParseException("JSON reader expected an integer but found '%s'.", timeToken.getValue());
        }
        int increment = ((Integer) incrementToken.getValue(Integer.class)).intValue();
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return new BsonTimestamp(time, increment);
    }

    private BsonDbPointer visitDBPointerConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        String namespace = readStringFromExtendedJson();
        verifyToken(JsonTokenType.COMMA);
        ObjectId id = new ObjectId(readStringFromExtendedJson());
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return new BsonDbPointer(namespace, id);
    }

    private int visitNumberIntConstructor() {
        int value;
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken valueToken = popToken();
        if (valueToken.getType() == JsonTokenType.INT32) {
            value = ((Integer) valueToken.getValue(Integer.class)).intValue();
        } else if (valueToken.getType() == JsonTokenType.STRING) {
            value = Integer.parseInt((String) valueToken.getValue(String.class));
        } else {
            throw new JsonParseException("JSON reader expected an integer or a string but found '%s'.", valueToken.getValue());
        }
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return value;
    }

    private long visitNumberLongConstructor() {
        long value;
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken valueToken = popToken();
        if (valueToken.getType() == JsonTokenType.INT32 || valueToken.getType() == JsonTokenType.INT64) {
            value = ((Long) valueToken.getValue(Long.class)).longValue();
        } else if (valueToken.getType() == JsonTokenType.STRING) {
            value = Long.parseLong((String) valueToken.getValue(String.class));
        } else {
            throw new JsonParseException("JSON reader expected an integer or a string but found '%s'.", valueToken.getValue());
        }
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return value;
    }

    private Decimal128 visitNumberDecimalConstructor() {
        Decimal128 value;
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken valueToken = popToken();
        if (valueToken.getType() == JsonTokenType.INT32 || valueToken.getType() == JsonTokenType.INT64 || valueToken.getType() == JsonTokenType.DOUBLE) {
            value = (Decimal128) valueToken.getValue(Decimal128.class);
        } else if (valueToken.getType() == JsonTokenType.STRING) {
            value = Decimal128.parse((String) valueToken.getValue(String.class));
        } else {
            throw new JsonParseException("JSON reader expected a number or a string but found '%s'.", valueToken.getValue());
        }
        verifyToken(JsonTokenType.RIGHT_PAREN);
        return value;
    }

    private long visitISODateTimeConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken token = popToken();
        if (token.getType() == JsonTokenType.RIGHT_PAREN) {
            return new Date().getTime();
        }
        if (token.getType() != JsonTokenType.STRING) {
            throw new JsonParseException("JSON reader expected a string but found '%s'.", token.getValue());
        }
        verifyToken(JsonTokenType.RIGHT_PAREN);
        String dateTimeString = (String) token.getValue(String.class);
        try {
            return DateTimeFormatter.parse(dateTimeString);
        } catch (DateTimeParseException e) {
            throw new JsonParseException("Failed to parse string as a date: " + dateTimeString, e);
        }
    }

    private BsonBinary visitHexDataConstructor() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken subTypeToken = popToken();
        if (subTypeToken.getType() != JsonTokenType.INT32) {
            throw new JsonParseException("JSON reader expected a binary subtype but found '%s'.", subTypeToken.getValue());
        }
        verifyToken(JsonTokenType.COMMA);
        String hex = readStringFromExtendedJson();
        verifyToken(JsonTokenType.RIGHT_PAREN);
        if ((hex.length() & 1) != 0) {
            hex = "0" + hex;
        }
        BsonBinarySubType[] values = BsonBinarySubType.values();
        for (BsonBinarySubType subType : values) {
            if (subType.getValue() == ((Integer) subTypeToken.getValue(Integer.class)).intValue()) {
                return new BsonBinary(subType, decodeHex(hex));
            }
        }
        return new BsonBinary(decodeHex(hex));
    }

    private long visitDateTimeConstructor() {
        DateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken token = popToken();
        if (token.getType() == JsonTokenType.RIGHT_PAREN) {
            return new Date().getTime();
        }
        if (token.getType() == JsonTokenType.STRING) {
            verifyToken(JsonTokenType.RIGHT_PAREN);
            String s = (String) token.getValue(String.class);
            ParsePosition pos = new ParsePosition(0);
            Date dateTime = format.parse(s, pos);
            if (dateTime != null && pos.getIndex() == s.length()) {
                return dateTime.getTime();
            }
            throw new JsonParseException("JSON reader expected a date in 'EEE MMM dd yyyy HH:mm:ss z' format but found '%s'.", s);
        } else if (token.getType() == JsonTokenType.INT32 || token.getType() == JsonTokenType.INT64) {
            long[] values = new long[7];
            int pos2 = 0;
            while (true) {
                if (pos2 < values.length) {
                    pos2++;
                    values[pos2] = ((Long) token.getValue(Long.class)).longValue();
                }
                JsonToken token2 = popToken();
                if (token2.getType() == JsonTokenType.RIGHT_PAREN) {
                    if (pos2 == 1) {
                        return values[0];
                    }
                    if (pos2 < 3 || pos2 > 7) {
                        throw new JsonParseException("JSON reader expected 1 or 3-7 integers but found %d.", Integer.valueOf(pos2));
                    }
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                    calendar.set(1, (int) values[0]);
                    calendar.set(2, (int) values[1]);
                    calendar.set(5, (int) values[2]);
                    calendar.set(11, (int) values[3]);
                    calendar.set(12, (int) values[4]);
                    calendar.set(13, (int) values[5]);
                    calendar.set(14, (int) values[6]);
                    return calendar.getTimeInMillis();
                } else if (token2.getType() != JsonTokenType.COMMA) {
                    throw new JsonParseException("JSON reader expected a ',' or a ')' but found '%s'.", token2.getValue());
                } else {
                    token = popToken();
                    if (token.getType() != JsonTokenType.INT32 && token.getType() != JsonTokenType.INT64) {
                        throw new JsonParseException("JSON reader expected an integer but found '%s'.", token.getValue());
                    }
                }
            }
        } else {
            throw new JsonParseException("JSON reader expected an integer or a string but found '%s'.", token.getValue());
        }
    }

    private String visitDateTimeConstructorWithOutNew() {
        verifyToken(JsonTokenType.LEFT_PAREN);
        JsonToken token = popToken();
        if (token.getType() != JsonTokenType.RIGHT_PAREN) {
            while (token.getType() != JsonTokenType.END_OF_FILE) {
                token = popToken();
                if (token.getType() == JsonTokenType.RIGHT_PAREN) {
                    break;
                }
            }
            if (token.getType() != JsonTokenType.RIGHT_PAREN) {
                throw new JsonParseException("JSON reader expected a ')' but found '%s'.", token.getValue());
            }
        }
        return new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH).format(new Date());
    }

    private BsonBinary visitBinDataExtendedJson(String firstKey) {
        byte type;
        byte[] data;
        Mark mark = new Mark();
        try {
            verifyToken(JsonTokenType.COLON);
            if (!firstKey.equals("$binary")) {
                mark.reset();
                BsonBinary visitLegacyBinaryExtendedJson = visitLegacyBinaryExtendedJson(firstKey);
                mark.discard();
                return visitLegacyBinaryExtendedJson;
            } else if (popToken().getType() == JsonTokenType.BEGIN_OBJECT) {
                String firstNestedKey = (String) popToken().getValue(String.class);
                if (firstNestedKey.equals("base64")) {
                    verifyToken(JsonTokenType.COLON);
                    data = Base64.decode(readStringFromExtendedJson());
                    verifyToken(JsonTokenType.COMMA);
                    verifyString("subType");
                    verifyToken(JsonTokenType.COLON);
                    type = readBinarySubtypeFromExtendedJson();
                } else if (firstNestedKey.equals("subType")) {
                    verifyToken(JsonTokenType.COLON);
                    type = readBinarySubtypeFromExtendedJson();
                    verifyToken(JsonTokenType.COMMA);
                    verifyString("base64");
                    verifyToken(JsonTokenType.COLON);
                    data = Base64.decode(readStringFromExtendedJson());
                } else {
                    throw new JsonParseException("Unexpected key for $binary: " + firstNestedKey);
                }
                verifyToken(JsonTokenType.END_OBJECT);
                verifyToken(JsonTokenType.END_OBJECT);
                BsonBinary bsonBinary = new BsonBinary(type, data);
                mark.discard();
                return bsonBinary;
            } else {
                mark.reset();
                BsonBinary visitLegacyBinaryExtendedJson2 = visitLegacyBinaryExtendedJson(firstKey);
                mark.discard();
                return visitLegacyBinaryExtendedJson2;
            }
        } catch (Throwable th) {
            mark.discard();
            throw th;
        }
    }

    private BsonBinary visitLegacyBinaryExtendedJson(String firstKey) {
        Mark mark;
        byte type;
        byte[] data;
        try {
            mark = new Mark();
            try {
                verifyToken(JsonTokenType.COLON);
                if (firstKey.equals("$binary")) {
                    data = Base64.decode(readStringFromExtendedJson());
                    verifyToken(JsonTokenType.COMMA);
                    verifyString("$type");
                    verifyToken(JsonTokenType.COLON);
                    type = readBinarySubtypeFromExtendedJson();
                } else {
                    type = readBinarySubtypeFromExtendedJson();
                    verifyToken(JsonTokenType.COMMA);
                    verifyString("$binary");
                    verifyToken(JsonTokenType.COLON);
                    data = Base64.decode(readStringFromExtendedJson());
                }
                verifyToken(JsonTokenType.END_OBJECT);
                BsonBinary bsonBinary = new BsonBinary(type, data);
                mark.discard();
                return bsonBinary;
            } catch (NumberFormatException e) {
                mark.reset();
                mark.discard();
                return null;
            } catch (JsonParseException e2) {
                mark.reset();
                mark.discard();
                return null;
            }
        } catch (Throwable th) {
            mark.discard();
            throw th;
        }
    }

    private byte readBinarySubtypeFromExtendedJson() {
        JsonToken subTypeToken = popToken();
        if (subTypeToken.getType() != JsonTokenType.STRING && subTypeToken.getType() != JsonTokenType.INT32) {
            throw new JsonParseException("JSON reader expected a string or number but found '%s'.", subTypeToken.getValue());
        } else if (subTypeToken.getType() == JsonTokenType.STRING) {
            return (byte) Integer.parseInt((String) subTypeToken.getValue(String.class), 16);
        } else {
            return ((Integer) subTypeToken.getValue(Integer.class)).byteValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long visitDateTimeExtendedJson() {
        /*
            r8 = this;
            r0 = r8
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.COLON
            r0.verifyToken(r1)
            r0 = r8
            org.bson.json.JsonToken r0 = r0.popToken()
            r11 = r0
            r0 = r11
            org.bson.json.JsonTokenType r0 = r0.getType()
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.BEGIN_OBJECT
            if (r0 != r1) goto L_0x005b
            r0 = r8
            org.bson.json.JsonToken r0 = r0.popToken()
            r12 = r0
            r0 = r12
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.Object r0 = r0.getValue(r1)
            java.lang.String r0 = (java.lang.String) r0
            r13 = r0
            r0 = r13
            java.lang.String r1 = "$numberLong"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0049
            org.bson.json.JsonParseException r0 = new org.bson.json.JsonParseException
            r1 = r0
            java.lang.String r2 = "JSON reader expected $numberLong within $date, but found %s"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r3
            r5 = 0
            r6 = r13
            r4[r5] = r6
            java.lang.String r2 = java.lang.String.format(r2, r3)
            r1.<init>(r2)
            throw r0
        L_0x0049:
            r0 = r8
            java.lang.Long r0 = r0.visitNumberLongExtendedJson()
            long r0 = r0.longValue()
            r9 = r0
            r0 = r8
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.END_OBJECT
            r0.verifyToken(r1)
            goto L_0x00cc
        L_0x005b:
            r0 = r11
            org.bson.json.JsonTokenType r0 = r0.getType()
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.INT32
            if (r0 == r1) goto L_0x006f
            r0 = r11
            org.bson.json.JsonTokenType r0 = r0.getType()
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.INT64
            if (r0 != r1) goto L_0x007f
        L_0x006f:
            r0 = r11
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            java.lang.Object r0 = r0.getValue(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r9 = r0
            goto L_0x00c5
        L_0x007f:
            r0 = r11
            org.bson.json.JsonTokenType r0 = r0.getType()
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.STRING
            if (r0 != r1) goto L_0x00af
            r0 = r11
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.Object r0 = r0.getValue(r1)
            java.lang.String r0 = (java.lang.String) r0
            r12 = r0
            r0 = r12
            long r0 = org.bson.json.DateTimeFormatter.parse(r0)     // Catch: DateTimeParseException -> 0x009d
            r9 = r0
            goto L_0x00ac
        L_0x009d:
            r13 = move-exception
            org.bson.json.JsonParseException r0 = new org.bson.json.JsonParseException
            r1 = r0
            java.lang.String r2 = "Failed to parse string as a date"
            r3 = r13
            r1.<init>(r2, r3)
            throw r0
        L_0x00ac:
            goto L_0x00c5
        L_0x00af:
            org.bson.json.JsonParseException r0 = new org.bson.json.JsonParseException
            r1 = r0
            java.lang.String r2 = "JSON reader expected an integer or string but found '%s'."
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r3
            r5 = 0
            r6 = r11
            java.lang.Object r6 = r6.getValue()
            r4[r5] = r6
            r1.<init>(r2, r3)
            throw r0
        L_0x00c5:
            r0 = r8
            org.bson.json.JsonTokenType r1 = org.bson.json.JsonTokenType.END_OBJECT
            r0.verifyToken(r1)
        L_0x00cc:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bson.json.JsonReader.visitDateTimeExtendedJson():long");
    }

    private MaxKey visitMaxKeyExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        verifyToken(JsonTokenType.INT32, 1);
        verifyToken(JsonTokenType.END_OBJECT);
        return new MaxKey();
    }

    private MinKey visitMinKeyExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        verifyToken(JsonTokenType.INT32, 1);
        verifyToken(JsonTokenType.END_OBJECT);
        return new MinKey();
    }

    private ObjectId visitObjectIdExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        ObjectId objectId = new ObjectId(readStringFromExtendedJson());
        verifyToken(JsonTokenType.END_OBJECT);
        return objectId;
    }

    private BsonRegularExpression visitNewRegularExpressionExtendedJson() {
        String options;
        String pattern;
        verifyToken(JsonTokenType.COLON);
        verifyToken(JsonTokenType.BEGIN_OBJECT);
        String firstKey = readStringFromExtendedJson();
        if (firstKey.equals("pattern")) {
            verifyToken(JsonTokenType.COLON);
            pattern = readStringFromExtendedJson();
            verifyToken(JsonTokenType.COMMA);
            verifyString("options");
            verifyToken(JsonTokenType.COLON);
            options = readStringFromExtendedJson();
        } else if (firstKey.equals("options")) {
            verifyToken(JsonTokenType.COLON);
            options = readStringFromExtendedJson();
            verifyToken(JsonTokenType.COMMA);
            verifyString("pattern");
            verifyToken(JsonTokenType.COLON);
            pattern = readStringFromExtendedJson();
        } else {
            throw new JsonParseException("Expected 't' and 'i' fields in $timestamp document but found " + firstKey);
        }
        verifyToken(JsonTokenType.END_OBJECT);
        verifyToken(JsonTokenType.END_OBJECT);
        return new BsonRegularExpression(pattern, options);
    }

    private BsonRegularExpression visitRegularExpressionExtendedJson(String firstKey) {
        Mark extendedJsonMark;
        String options;
        String pattern;
        try {
            extendedJsonMark = new Mark();
            try {
                verifyToken(JsonTokenType.COLON);
                if (firstKey.equals("$regex")) {
                    pattern = readStringFromExtendedJson();
                    verifyToken(JsonTokenType.COMMA);
                    verifyString("$options");
                    verifyToken(JsonTokenType.COLON);
                    options = readStringFromExtendedJson();
                } else {
                    options = readStringFromExtendedJson();
                    verifyToken(JsonTokenType.COMMA);
                    verifyString("$regex");
                    verifyToken(JsonTokenType.COLON);
                    pattern = readStringFromExtendedJson();
                }
                verifyToken(JsonTokenType.END_OBJECT);
                BsonRegularExpression bsonRegularExpression = new BsonRegularExpression(pattern, options);
                extendedJsonMark.discard();
                return bsonRegularExpression;
            } catch (JsonParseException e) {
                extendedJsonMark.reset();
                extendedJsonMark.discard();
                return null;
            }
        } catch (Throwable th) {
            extendedJsonMark.discard();
            throw th;
        }
    }

    private String readStringFromExtendedJson() {
        JsonToken patternToken = popToken();
        if (patternToken.getType() == JsonTokenType.STRING) {
            return (String) patternToken.getValue(String.class);
        }
        throw new JsonParseException("JSON reader expected a string but found '%s'.", patternToken.getValue());
    }

    private String visitSymbolExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        String symbol = readStringFromExtendedJson();
        verifyToken(JsonTokenType.END_OBJECT);
        return symbol;
    }

    private BsonTimestamp visitTimestampExtendedJson() {
        int increment;
        int time;
        verifyToken(JsonTokenType.COLON);
        verifyToken(JsonTokenType.BEGIN_OBJECT);
        String firstKey = readStringFromExtendedJson();
        if (firstKey.equals("t")) {
            verifyToken(JsonTokenType.COLON);
            time = readIntFromExtendedJson();
            verifyToken(JsonTokenType.COMMA);
            verifyString(IntegerTokenConverter.CONVERTER_KEY);
            verifyToken(JsonTokenType.COLON);
            increment = readIntFromExtendedJson();
        } else if (firstKey.equals(IntegerTokenConverter.CONVERTER_KEY)) {
            verifyToken(JsonTokenType.COLON);
            increment = readIntFromExtendedJson();
            verifyToken(JsonTokenType.COMMA);
            verifyString("t");
            verifyToken(JsonTokenType.COLON);
            time = readIntFromExtendedJson();
        } else {
            throw new JsonParseException("Expected 't' and 'i' fields in $timestamp document but found " + firstKey);
        }
        verifyToken(JsonTokenType.END_OBJECT);
        verifyToken(JsonTokenType.END_OBJECT);
        return new BsonTimestamp(time, increment);
    }

    private int readIntFromExtendedJson() {
        int value;
        JsonToken nextToken = popToken();
        if (nextToken.getType() == JsonTokenType.INT32) {
            value = ((Integer) nextToken.getValue(Integer.class)).intValue();
        } else if (nextToken.getType() == JsonTokenType.INT64) {
            value = ((Long) nextToken.getValue(Long.class)).intValue();
        } else {
            throw new JsonParseException("JSON reader expected an integer but found '%s'.", nextToken.getValue());
        }
        return value;
    }

    private BsonBinary visitUuidExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        String uuidString = readStringFromExtendedJson();
        verifyToken(JsonTokenType.END_OBJECT);
        try {
            return new BsonBinary(UUID.fromString(uuidString));
        } catch (IllegalArgumentException e) {
            throw new JsonParseException(e);
        }
    }

    private void visitJavaScriptExtendedJson() {
        JsonToken nextToken;
        verifyToken(JsonTokenType.COLON);
        String code = readStringFromExtendedJson();
        switch (popToken().getType()) {
            case END_OBJECT:
                this.currentValue = code;
                setCurrentBsonType(BsonType.JAVASCRIPT);
                return;
            case COMMA:
                verifyString("$scope");
                verifyToken(JsonTokenType.COLON);
                setState(AbstractBsonReader.State.VALUE);
                this.currentValue = code;
                setCurrentBsonType(BsonType.JAVASCRIPT_WITH_SCOPE);
                setContext(new Context(getContext(), BsonContextType.SCOPE_DOCUMENT));
                return;
            default:
                throw new JsonParseException("JSON reader expected ',' or '}' but found '%s'.", nextToken);
        }
    }

    private BsonUndefined visitUndefinedExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        JsonToken valueToken = popToken();
        if (!((String) valueToken.getValue(String.class)).equals(C3P0Substitutions.DEBUG)) {
            throw new JsonParseException("JSON reader requires $undefined to have the value of true but found '%s'.", valueToken.getValue());
        }
        verifyToken(JsonTokenType.END_OBJECT);
        return new BsonUndefined();
    }

    private Long visitNumberLongExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        String longAsString = readStringFromExtendedJson();
        try {
            Long value = Long.valueOf(longAsString);
            verifyToken(JsonTokenType.END_OBJECT);
            return value;
        } catch (NumberFormatException e) {
            throw new JsonParseException(String.format("Exception converting value '%s' to type %s", longAsString, Long.class.getName()), e);
        }
    }

    private Integer visitNumberIntExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        String intAsString = readStringFromExtendedJson();
        try {
            Integer value = Integer.valueOf(intAsString);
            verifyToken(JsonTokenType.END_OBJECT);
            return value;
        } catch (NumberFormatException e) {
            throw new JsonParseException(String.format("Exception converting value '%s' to type %s", intAsString, Integer.class.getName()), e);
        }
    }

    private Double visitNumberDoubleExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        String doubleAsString = readStringFromExtendedJson();
        try {
            Double value = Double.valueOf(doubleAsString);
            verifyToken(JsonTokenType.END_OBJECT);
            return value;
        } catch (NumberFormatException e) {
            throw new JsonParseException(String.format("Exception converting value '%s' to type %s", doubleAsString, Double.class.getName()), e);
        }
    }

    private Decimal128 visitNumberDecimalExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        String decimal128AsString = readStringFromExtendedJson();
        try {
            Decimal128 value = Decimal128.parse(decimal128AsString);
            verifyToken(JsonTokenType.END_OBJECT);
            return value;
        } catch (NumberFormatException e) {
            throw new JsonParseException(String.format("Exception converting value '%s' to type %s", decimal128AsString, Decimal128.class.getName()), e);
        }
    }

    private BsonDbPointer visitDbPointerExtendedJson() {
        ObjectId oid;
        String ref;
        verifyToken(JsonTokenType.COLON);
        verifyToken(JsonTokenType.BEGIN_OBJECT);
        String firstKey = readStringFromExtendedJson();
        if (firstKey.equals("$ref")) {
            verifyToken(JsonTokenType.COLON);
            ref = readStringFromExtendedJson();
            verifyToken(JsonTokenType.COMMA);
            verifyString("$id");
            oid = readDbPointerIdFromExtendedJson();
            verifyToken(JsonTokenType.END_OBJECT);
        } else if (firstKey.equals("$id")) {
            oid = readDbPointerIdFromExtendedJson();
            verifyToken(JsonTokenType.COMMA);
            verifyString("$ref");
            verifyToken(JsonTokenType.COLON);
            ref = readStringFromExtendedJson();
        } else {
            throw new JsonParseException("Expected $ref and $id fields in $dbPointer document but found " + firstKey);
        }
        verifyToken(JsonTokenType.END_OBJECT);
        return new BsonDbPointer(ref, oid);
    }

    private ObjectId readDbPointerIdFromExtendedJson() {
        verifyToken(JsonTokenType.COLON);
        verifyToken(JsonTokenType.BEGIN_OBJECT);
        verifyToken(JsonTokenType.STRING, "$oid");
        return visitObjectIdExtendedJson();
    }

    @Override // org.bson.BsonReader
    public BsonReaderMark getMark() {
        return new Mark();
    }

    /* access modifiers changed from: protected */
    @Override // org.bson.AbstractBsonReader
    public Context getContext() {
        return (Context) getContext();
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/bson/json/JsonReader$Mark.class */
    public class Mark extends AbstractBsonReader.Mark {
        private final JsonToken pushedToken;
        private final Object currentValue;
        private final int markPos;

        protected Mark() {
            super();
            this.pushedToken = JsonReader.this.pushedToken;
            this.currentValue = JsonReader.this.currentValue;
            this.markPos = JsonReader.this.scanner.mark();
        }

        @Override // org.bson.AbstractBsonReader.Mark, org.bson.BsonReaderMark
        public void reset() {
            reset();
            JsonReader.this.pushedToken = this.pushedToken;
            JsonReader.this.currentValue = this.currentValue;
            JsonReader.this.scanner.reset(this.markPos);
            JsonReader.this.setContext(new Context(getParentContext(), getContextType()));
        }

        public void discard() {
            JsonReader.this.scanner.discard(this.markPos);
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/bson/json/JsonReader$Context.class */
    public class Context extends AbstractBsonReader.Context {
        protected Context(AbstractBsonReader.Context parentContext, BsonContextType contextType) {
            super(parentContext, contextType);
        }

        /* access modifiers changed from: protected */
        @Override // org.bson.AbstractBsonReader.Context
        public Context getParentContext() {
            return (Context) getParentContext();
        }

        @Override // org.bson.AbstractBsonReader.Context
        protected BsonContextType getContextType() {
            return getContextType();
        }
    }

    private static byte[] decodeHex(String hex) {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException("A hex string must contain an even number of characters: " + hex);
        }
        byte[] out = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            int high = Character.digit(hex.charAt(i), 16);
            int low = Character.digit(hex.charAt(i + 1), 16);
            if (high == -1 || low == -1) {
                throw new IllegalArgumentException("A hex string can only contain the characters 0-9, A-F, a-f: " + hex);
            }
            out[i / 2] = (byte) ((high * 16) + low);
        }
        return out;
    }
}
