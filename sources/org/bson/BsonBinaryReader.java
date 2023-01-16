package org.bson;

import java.nio.ByteBuffer;
import org.bson.AbstractBsonReader;
import org.bson.assertions.Assertions;
import org.bson.p022io.BsonInput;
import org.bson.p022io.BsonInputMark;
import org.bson.p022io.ByteBufferBsonInput;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/BsonBinaryReader.class */
public class BsonBinaryReader extends AbstractBsonReader {
    private final BsonInput bsonInput;

    public BsonBinaryReader(ByteBuffer byteBuffer) {
        this(new ByteBufferBsonInput(new ByteBufNIO((ByteBuffer) Assertions.notNull("byteBuffer", byteBuffer))));
    }

    public BsonBinaryReader(BsonInput bsonInput) {
        if (bsonInput == null) {
            throw new IllegalArgumentException("bsonInput is null");
        }
        this.bsonInput = bsonInput;
        setContext(new Context(null, BsonContextType.TOP_LEVEL, 0, 0));
    }

    @Override // org.bson.AbstractBsonReader, org.bson.BsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close();
    }

    public BsonInput getBsonInput() {
        return this.bsonInput;
    }

    @Override // org.bson.AbstractBsonReader, org.bson.BsonReader
    public BsonType readBsonType() {
        if (isClosed()) {
            throw new IllegalStateException("BSONBinaryWriter");
        } else if (getState() == AbstractBsonReader.State.INITIAL || getState() == AbstractBsonReader.State.DONE || getState() == AbstractBsonReader.State.SCOPE_DOCUMENT) {
            setCurrentBsonType(BsonType.DOCUMENT);
            setState(AbstractBsonReader.State.VALUE);
            return getCurrentBsonType();
        } else {
            if (getState() != AbstractBsonReader.State.TYPE) {
                throwInvalidState("ReadBSONType", AbstractBsonReader.State.TYPE);
            }
            byte bsonTypeByte = this.bsonInput.readByte();
            BsonType bsonType = BsonType.findByValue(bsonTypeByte);
            if (bsonType == null) {
                throw new BsonSerializationException(String.format("Detected unknown BSON type \"\\x%x\" for fieldname \"%s\". Are you using the latest driver version?", Byte.valueOf(bsonTypeByte), this.bsonInput.readCString()));
            }
            setCurrentBsonType(bsonType);
            if (getCurrentBsonType() == BsonType.END_OF_DOCUMENT) {
                switch (getContext().getContextType()) {
                    case ARRAY:
                        setState(AbstractBsonReader.State.END_OF_ARRAY);
                        return BsonType.END_OF_DOCUMENT;
                    case DOCUMENT:
                    case SCOPE_DOCUMENT:
                        setState(AbstractBsonReader.State.END_OF_DOCUMENT);
                        return BsonType.END_OF_DOCUMENT;
                    default:
                        throw new BsonSerializationException(String.format("BSONType EndOfDocument is not valid when ContextType is %s.", getContext().getContextType()));
                }
            } else {
                switch (getContext().getContextType()) {
                    case ARRAY:
                        this.bsonInput.skipCString();
                        setState(AbstractBsonReader.State.VALUE);
                        break;
                    case DOCUMENT:
                    case SCOPE_DOCUMENT:
                        setCurrentName(this.bsonInput.readCString());
                        setState(AbstractBsonReader.State.NAME);
                        break;
                    default:
                        throw new BSONException("Unexpected ContextType.");
                }
                return getCurrentBsonType();
            }
        }
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonBinary doReadBinaryData() {
        int numBytes = readSize();
        byte type = this.bsonInput.readByte();
        if (type == BsonBinarySubType.OLD_BINARY.getValue()) {
            if (this.bsonInput.readInt32() != numBytes - 4) {
                throw new BsonSerializationException("Binary sub type OldBinary has inconsistent sizes");
            }
            numBytes -= 4;
        }
        byte[] bytes = new byte[numBytes];
        this.bsonInput.readBytes(bytes);
        return new BsonBinary(type, bytes);
    }

    @Override // org.bson.AbstractBsonReader
    protected byte doPeekBinarySubType() {
        Mark mark = new Mark();
        readSize();
        byte type = this.bsonInput.readByte();
        mark.reset();
        return type;
    }

    @Override // org.bson.AbstractBsonReader
    protected int doPeekBinarySize() {
        Mark mark = new Mark();
        int size = readSize();
        mark.reset();
        return size;
    }

    @Override // org.bson.AbstractBsonReader
    protected boolean doReadBoolean() {
        byte booleanByte = this.bsonInput.readByte();
        if (booleanByte == 0 || booleanByte == 1) {
            return booleanByte == 1;
        }
        throw new BsonSerializationException(String.format("Expected a boolean value but found %d", Byte.valueOf(booleanByte)));
    }

    @Override // org.bson.AbstractBsonReader
    protected long doReadDateTime() {
        return this.bsonInput.readInt64();
    }

    @Override // org.bson.AbstractBsonReader
    protected double doReadDouble() {
        return this.bsonInput.readDouble();
    }

    @Override // org.bson.AbstractBsonReader
    protected int doReadInt32() {
        return this.bsonInput.readInt32();
    }

    @Override // org.bson.AbstractBsonReader
    protected long doReadInt64() {
        return this.bsonInput.readInt64();
    }

    @Override // org.bson.AbstractBsonReader
    public Decimal128 doReadDecimal128() {
        return Decimal128.fromIEEE754BIDEncoding(this.bsonInput.readInt64(), this.bsonInput.readInt64());
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadJavaScript() {
        return this.bsonInput.readString();
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadJavaScriptWithScope() {
        setContext(new Context(getContext(), BsonContextType.JAVASCRIPT_WITH_SCOPE, this.bsonInput.getPosition(), readSize()));
        return this.bsonInput.readString();
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
        return this.bsonInput.readObjectId();
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonRegularExpression doReadRegularExpression() {
        return new BsonRegularExpression(this.bsonInput.readCString(), this.bsonInput.readCString());
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonDbPointer doReadDBPointer() {
        return new BsonDbPointer(this.bsonInput.readString(), this.bsonInput.readObjectId());
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadString() {
        return this.bsonInput.readString();
    }

    @Override // org.bson.AbstractBsonReader
    protected String doReadSymbol() {
        return this.bsonInput.readString();
    }

    @Override // org.bson.AbstractBsonReader
    protected BsonTimestamp doReadTimestamp() {
        return new BsonTimestamp(this.bsonInput.readInt64());
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadUndefined() {
    }

    @Override // org.bson.AbstractBsonReader
    public void doReadStartArray() {
        setContext(new Context(getContext(), BsonContextType.ARRAY, this.bsonInput.getPosition(), readSize()));
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadStartDocument() {
        setContext(new Context(getContext(), getState() == AbstractBsonReader.State.SCOPE_DOCUMENT ? BsonContextType.SCOPE_DOCUMENT : BsonContextType.DOCUMENT, this.bsonInput.getPosition(), readSize()));
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadEndArray() {
        setContext(getContext().popContext(this.bsonInput.getPosition()));
    }

    @Override // org.bson.AbstractBsonReader
    protected void doReadEndDocument() {
        setContext(getContext().popContext(this.bsonInput.getPosition()));
        if (getContext().getContextType() == BsonContextType.JAVASCRIPT_WITH_SCOPE) {
            setContext(getContext().popContext(this.bsonInput.getPosition()));
        }
    }

    @Override // org.bson.AbstractBsonReader
    protected void doSkipName() {
    }

    @Override // org.bson.AbstractBsonReader
    protected void doSkipValue() {
        int skip;
        if (isClosed()) {
            throw new IllegalStateException("BSONBinaryWriter");
        }
        if (getState() != AbstractBsonReader.State.VALUE) {
            throwInvalidState("skipValue", AbstractBsonReader.State.VALUE);
        }
        switch (getCurrentBsonType()) {
            case ARRAY:
                skip = readSize() - 4;
                break;
            case BINARY:
                skip = readSize() + 1;
                break;
            case BOOLEAN:
                skip = 1;
                break;
            case DATE_TIME:
                skip = 8;
                break;
            case DOCUMENT:
                skip = readSize() - 4;
                break;
            case DOUBLE:
                skip = 8;
                break;
            case INT32:
                skip = 4;
                break;
            case INT64:
                skip = 8;
                break;
            case DECIMAL128:
                skip = 16;
                break;
            case JAVASCRIPT:
                skip = readSize();
                break;
            case JAVASCRIPT_WITH_SCOPE:
                skip = readSize() - 4;
                break;
            case MAX_KEY:
                skip = 0;
                break;
            case MIN_KEY:
                skip = 0;
                break;
            case NULL:
                skip = 0;
                break;
            case OBJECT_ID:
                skip = 12;
                break;
            case REGULAR_EXPRESSION:
                this.bsonInput.skipCString();
                this.bsonInput.skipCString();
                skip = 0;
                break;
            case STRING:
                skip = readSize();
                break;
            case SYMBOL:
                skip = readSize();
                break;
            case TIMESTAMP:
                skip = 8;
                break;
            case UNDEFINED:
                skip = 0;
                break;
            case DB_POINTER:
                skip = readSize() + 12;
                break;
            default:
                throw new BSONException("Unexpected BSON type: " + getCurrentBsonType());
        }
        this.bsonInput.skip(skip);
        setState(AbstractBsonReader.State.TYPE);
    }

    private int readSize() {
        int size = this.bsonInput.readInt32();
        if (size >= 0) {
            return size;
        }
        throw new BsonSerializationException(String.format("Size %s is not valid because it is negative.", Integer.valueOf(size)));
    }

    /* access modifiers changed from: protected */
    @Override // org.bson.AbstractBsonReader
    public Context getContext() {
        return (Context) getContext();
    }

    @Override // org.bson.BsonReader
    public BsonReaderMark getMark() {
        return new Mark();
    }

    /* loaded from: grasscutter.jar:org/bson/BsonBinaryReader$Mark.class */
    protected class Mark extends AbstractBsonReader.Mark {
        private final int startPosition;
        private final int size;
        private final BsonInputMark bsonInputMark;

        protected Mark() {
            super();
            this.startPosition = BsonBinaryReader.this.getContext().startPosition;
            this.size = BsonBinaryReader.this.getContext().size;
            this.bsonInputMark = BsonBinaryReader.this.bsonInput.getMark(Integer.MAX_VALUE);
        }

        @Override // org.bson.AbstractBsonReader.Mark, org.bson.BsonReaderMark
        public void reset() {
            reset();
            this.bsonInputMark.reset();
            BsonBinaryReader.this.setContext(new Context((Context) getParentContext(), getContextType(), this.startPosition, this.size));
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/bson/BsonBinaryReader$Context.class */
    public class Context extends AbstractBsonReader.Context {
        private final int startPosition;
        private final int size;

        Context(Context parentContext, BsonContextType contextType, int startPosition, int size) {
            super(parentContext, contextType);
            this.startPosition = startPosition;
            this.size = size;
        }

        Context popContext(int position) {
            int actualSize = position - this.startPosition;
            if (actualSize == this.size) {
                return getParentContext();
            }
            throw new BsonSerializationException(String.format("Expected size to be %d, not %d.", Integer.valueOf(this.size), Integer.valueOf(actualSize)));
        }

        /* access modifiers changed from: protected */
        @Override // org.bson.AbstractBsonReader.Context
        public Context getParentContext() {
            return (Context) getParentContext();
        }
    }
}
