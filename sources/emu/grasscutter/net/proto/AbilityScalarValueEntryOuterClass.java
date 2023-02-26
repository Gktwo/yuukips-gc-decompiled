package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityScalarTypeOuterClass;
import emu.grasscutter.net.proto.AbilityStringOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarValueEntryOuterClass.class */
public final class AbilityScalarValueEntryOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAbilityScalarValueEntry.proto\u001a\u0013AbilityString.proto\u001a\u0017AbilityScalarType.proto\"À\u0001\n\u0017AbilityScalarValueEntry\u0012\u001b\n\u0003key\u0018\u0001 \u0001(\u000b2\u000e.AbilityString\u0012%\n\tvalueType\u0018\u0002 \u0001(\u000e2\u0012.AbilityScalarType\u0012\u0015\n\u000bfloat_value\u0018\u0003 \u0001(\u0002H��\u0012\u0016\n\fstring_value\u0018\u0004 \u0001(\tH��\u0012\u0013\n\tint_value\u0018\u0005 \u0001(\u0005H��\u0012\u0014\n\nuint_value\u0018\u0006 \u0001(\rH��B\u0007\n\u0005valueB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityStringOuterClass.getDescriptor(), AbilityScalarTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityScalarValueEntry_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityScalarValueEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityScalarValueEntry_descriptor, new String[]{"Key", "ValueType", "FloatValue", "StringValue", "IntValue", "UintValue", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarValueEntryOuterClass$AbilityScalarValueEntryOrBuilder.class */
    public interface AbilityScalarValueEntryOrBuilder extends MessageOrBuilder {
        boolean hasKey();

        AbilityStringOuterClass.AbilityString getKey();

        AbilityStringOuterClass.AbilityStringOrBuilder getKeyOrBuilder();

        int getValueTypeValue();

        AbilityScalarTypeOuterClass.AbilityScalarType getValueType();

        boolean hasFloatValue();

        float getFloatValue();

        boolean hasStringValue();

        String getStringValue();

        ByteString getStringValueBytes();

        boolean hasIntValue();

        int getIntValue();

        boolean hasUintValue();

        int getUintValue();

        AbilityScalarValueEntry.ValueCase getValueCase();
    }

    private AbilityScalarValueEntryOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarValueEntryOuterClass$AbilityScalarValueEntry.class */
    public static final class AbilityScalarValueEntry extends GeneratedMessageV3 implements AbilityScalarValueEntryOrBuilder {
        private static final long serialVersionUID = 0;
        private int valueCase_;
        private Object value_;
        public static final int KEY_FIELD_NUMBER = 1;
        private AbilityStringOuterClass.AbilityString key_;
        public static final int VALUETYPE_FIELD_NUMBER = 2;
        private int valueType_;
        public static final int FLOAT_VALUE_FIELD_NUMBER = 3;
        public static final int STRING_VALUE_FIELD_NUMBER = 4;
        public static final int INT_VALUE_FIELD_NUMBER = 5;
        public static final int UINT_VALUE_FIELD_NUMBER = 6;
        private byte memoizedIsInitialized;
        private static final AbilityScalarValueEntry DEFAULT_INSTANCE = new AbilityScalarValueEntry();
        private static final Parser<AbilityScalarValueEntry> PARSER = new AbstractParser<AbilityScalarValueEntry>() { // from class: emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.1
            @Override // com.google.protobuf.Parser
            public AbilityScalarValueEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityScalarValueEntry(input, extensionRegistry);
            }
        };

        private AbilityScalarValueEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.valueCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private AbilityScalarValueEntry() {
            this.valueCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.valueType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityScalarValueEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityScalarValueEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    AbilityStringOuterClass.AbilityString.Builder subBuilder = this.key_ != null ? this.key_.toBuilder() : null;
                                    this.key_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.key_);
                                        this.key_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 16:
                                    this.valueType_ = input.readEnum();
                                    break;
                                case 29:
                                    this.valueCase_ = 3;
                                    this.value_ = Float.valueOf(input.readFloat());
                                    break;
                                case 34:
                                    String s = input.readStringRequireUtf8();
                                    this.valueCase_ = 4;
                                    this.value_ = s;
                                    break;
                                case 40:
                                    this.valueCase_ = 5;
                                    this.value_ = Integer.valueOf(input.readInt32());
                                    break;
                                case 48:
                                    this.valueCase_ = 6;
                                    this.value_ = Integer.valueOf(input.readUInt32());
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilityScalarValueEntryOuterClass.internal_static_AbilityScalarValueEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityScalarValueEntryOuterClass.internal_static_AbilityScalarValueEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityScalarValueEntry.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarValueEntryOuterClass$AbilityScalarValueEntry$ValueCase.class */
        public enum ValueCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            FLOAT_VALUE(3),
            STRING_VALUE(4),
            INT_VALUE(5),
            UINT_VALUE(6),
            VALUE_NOT_SET(0);
            
            private final int value;

            ValueCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ValueCase valueOf(int value) {
                return forNumber(value);
            }

            public static ValueCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return VALUE_NOT_SET;
                    case 1:
                    case 2:
                    default:
                        return null;
                    case 3:
                        return FLOAT_VALUE;
                    case 4:
                        return STRING_VALUE;
                    case 5:
                        return INT_VALUE;
                    case 6:
                        return UINT_VALUE;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public boolean hasKey() {
            return this.key_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public AbilityStringOuterClass.AbilityString getKey() {
            return this.key_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.key_;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getKeyOrBuilder() {
            return getKey();
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public int getValueTypeValue() {
            return this.valueType_;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public AbilityScalarTypeOuterClass.AbilityScalarType getValueType() {
            AbilityScalarTypeOuterClass.AbilityScalarType result = AbilityScalarTypeOuterClass.AbilityScalarType.valueOf(this.valueType_);
            return result == null ? AbilityScalarTypeOuterClass.AbilityScalarType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public boolean hasFloatValue() {
            return this.valueCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public float getFloatValue() {
            if (this.valueCase_ == 3) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public boolean hasStringValue() {
            return this.valueCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public String getStringValue() {
            Object ref = "";
            if (this.valueCase_ == 4) {
                ref = this.value_;
            }
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            if (this.valueCase_ == 4) {
                this.value_ = s;
            }
            return s;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public ByteString getStringValueBytes() {
            Object ref = "";
            if (this.valueCase_ == 4) {
                ref = this.value_;
            }
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            if (this.valueCase_ == 4) {
                this.value_ = b;
            }
            return b;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public boolean hasIntValue() {
            return this.valueCase_ == 5;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public int getIntValue() {
            if (this.valueCase_ == 5) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public boolean hasUintValue() {
            return this.valueCase_ == 6;
        }

        @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
        public int getUintValue() {
            if (this.valueCase_ == 6) {
                return ((Integer) this.value_).intValue();
            }
            return 0;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.key_ != null) {
                output.writeMessage(1, getKey());
            }
            if (this.valueType_ != AbilityScalarTypeOuterClass.AbilityScalarType.ABILITY_SCALAR_TYPE_UNKNOWN.getNumber()) {
                output.writeEnum(2, this.valueType_);
            }
            if (this.valueCase_ == 3) {
                output.writeFloat(3, ((Float) this.value_).floatValue());
            }
            if (this.valueCase_ == 4) {
                GeneratedMessageV3.writeString(output, 4, this.value_);
            }
            if (this.valueCase_ == 5) {
                output.writeInt32(5, ((Integer) this.value_).intValue());
            }
            if (this.valueCase_ == 6) {
                output.writeUInt32(6, ((Integer) this.value_).intValue());
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.key_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, getKey());
            }
            if (this.valueType_ != AbilityScalarTypeOuterClass.AbilityScalarType.ABILITY_SCALAR_TYPE_UNKNOWN.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.valueType_);
            }
            if (this.valueCase_ == 3) {
                size2 += CodedOutputStream.computeFloatSize(3, ((Float) this.value_).floatValue());
            }
            if (this.valueCase_ == 4) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.value_);
            }
            if (this.valueCase_ == 5) {
                size2 += CodedOutputStream.computeInt32Size(5, ((Integer) this.value_).intValue());
            }
            if (this.valueCase_ == 6) {
                size2 += CodedOutputStream.computeUInt32Size(6, ((Integer) this.value_).intValue());
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbilityScalarValueEntry)) {
                return equals(obj);
            }
            AbilityScalarValueEntry other = (AbilityScalarValueEntry) obj;
            if (hasKey() != other.hasKey()) {
                return false;
            }
            if ((hasKey() && !getKey().equals(other.getKey())) || this.valueType_ != other.valueType_ || !getValueCase().equals(other.getValueCase())) {
                return false;
            }
            switch (this.valueCase_) {
                case 3:
                    if (Float.floatToIntBits(getFloatValue()) != Float.floatToIntBits(other.getFloatValue())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!getStringValue().equals(other.getStringValue())) {
                        return false;
                    }
                    break;
                case 5:
                    if (getIntValue() != other.getIntValue()) {
                        return false;
                    }
                    break;
                case 6:
                    if (getUintValue() != other.getUintValue()) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasKey()) {
                hash = (53 * ((37 * hash) + 1)) + getKey().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 2)) + this.valueType_;
            switch (this.valueCase_) {
                case 3:
                    hash2 = (53 * ((37 * hash2) + 3)) + Float.floatToIntBits(getFloatValue());
                    break;
                case 4:
                    hash2 = (53 * ((37 * hash2) + 4)) + getStringValue().hashCode();
                    break;
                case 5:
                    hash2 = (53 * ((37 * hash2) + 5)) + getIntValue();
                    break;
                case 6:
                    hash2 = (53 * ((37 * hash2) + 6)) + getUintValue();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static AbilityScalarValueEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityScalarValueEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityScalarValueEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityScalarValueEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityScalarValueEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityScalarValueEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityScalarValueEntry parseFrom(InputStream input) throws IOException {
            return (AbilityScalarValueEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityScalarValueEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityScalarValueEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityScalarValueEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityScalarValueEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityScalarValueEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityScalarValueEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityScalarValueEntry parseFrom(CodedInputStream input) throws IOException {
            return (AbilityScalarValueEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityScalarValueEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityScalarValueEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityScalarValueEntry prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarValueEntryOuterClass$AbilityScalarValueEntry$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityScalarValueEntryOrBuilder {
            private Object value_;
            private AbilityStringOuterClass.AbilityString key_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> keyBuilder_;
            private int valueCase_ = 0;
            private int valueType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityScalarValueEntryOuterClass.internal_static_AbilityScalarValueEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityScalarValueEntryOuterClass.internal_static_AbilityScalarValueEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityScalarValueEntry.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityScalarValueEntry.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.keyBuilder_ == null) {
                    this.key_ = null;
                } else {
                    this.key_ = null;
                    this.keyBuilder_ = null;
                }
                this.valueType_ = 0;
                this.valueCase_ = 0;
                this.value_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityScalarValueEntryOuterClass.internal_static_AbilityScalarValueEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityScalarValueEntry getDefaultInstanceForType() {
                return AbilityScalarValueEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityScalarValueEntry build() {
                AbilityScalarValueEntry result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityScalarValueEntry buildPartial() {
                AbilityScalarValueEntry result = new AbilityScalarValueEntry(this);
                if (this.keyBuilder_ == null) {
                    result.key_ = this.key_;
                } else {
                    result.key_ = this.keyBuilder_.build();
                }
                result.valueType_ = this.valueType_;
                if (this.valueCase_ == 3) {
                    result.value_ = this.value_;
                }
                if (this.valueCase_ == 4) {
                    result.value_ = this.value_;
                }
                if (this.valueCase_ == 5) {
                    result.value_ = this.value_;
                }
                if (this.valueCase_ == 6) {
                    result.value_ = this.value_;
                }
                result.valueCase_ = this.valueCase_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof AbilityScalarValueEntry) {
                    return mergeFrom((AbilityScalarValueEntry) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityScalarValueEntry other) {
                if (other == AbilityScalarValueEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.hasKey()) {
                    mergeKey(other.getKey());
                }
                if (other.valueType_ != 0) {
                    setValueTypeValue(other.getValueTypeValue());
                }
                switch (other.getValueCase()) {
                    case FLOAT_VALUE:
                        setFloatValue(other.getFloatValue());
                        break;
                    case STRING_VALUE:
                        this.valueCase_ = 4;
                        this.value_ = other.value_;
                        onChanged();
                        break;
                    case INT_VALUE:
                        setIntValue(other.getIntValue());
                        break;
                    case UINT_VALUE:
                        setUintValue(other.getUintValue());
                        break;
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AbilityScalarValueEntry parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityScalarValueEntry.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityScalarValueEntry) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public ValueCase getValueCase() {
                return ValueCase.forNumber(this.valueCase_);
            }

            public Builder clearValue() {
                this.valueCase_ = 0;
                this.value_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public boolean hasKey() {
                return (this.keyBuilder_ == null && this.key_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public AbilityStringOuterClass.AbilityString getKey() {
                if (this.keyBuilder_ == null) {
                    return this.key_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.key_;
                }
                return this.keyBuilder_.getMessage();
            }

            public Builder setKey(AbilityStringOuterClass.AbilityString value) {
                if (this.keyBuilder_ != null) {
                    this.keyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.key_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setKey(AbilityStringOuterClass.AbilityString.Builder builderForValue) {
                if (this.keyBuilder_ == null) {
                    this.key_ = builderForValue.build();
                    onChanged();
                } else {
                    this.keyBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeKey(AbilityStringOuterClass.AbilityString value) {
                if (this.keyBuilder_ == null) {
                    if (this.key_ != null) {
                        this.key_ = AbilityStringOuterClass.AbilityString.newBuilder(this.key_).mergeFrom(value).buildPartial();
                    } else {
                        this.key_ = value;
                    }
                    onChanged();
                } else {
                    this.keyBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearKey() {
                if (this.keyBuilder_ == null) {
                    this.key_ = null;
                    onChanged();
                } else {
                    this.key_ = null;
                    this.keyBuilder_ = null;
                }
                return this;
            }

            public AbilityStringOuterClass.AbilityString.Builder getKeyBuilder() {
                onChanged();
                return getKeyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public AbilityStringOuterClass.AbilityStringOrBuilder getKeyOrBuilder() {
                if (this.keyBuilder_ != null) {
                    return this.keyBuilder_.getMessageOrBuilder();
                }
                return this.key_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.key_;
            }

            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> getKeyFieldBuilder() {
                if (this.keyBuilder_ == null) {
                    this.keyBuilder_ = new SingleFieldBuilderV3<>(getKey(), getParentForChildren(), isClean());
                    this.key_ = null;
                }
                return this.keyBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public int getValueTypeValue() {
                return this.valueType_;
            }

            public Builder setValueTypeValue(int value) {
                this.valueType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public AbilityScalarTypeOuterClass.AbilityScalarType getValueType() {
                AbilityScalarTypeOuterClass.AbilityScalarType result = AbilityScalarTypeOuterClass.AbilityScalarType.valueOf(this.valueType_);
                return result == null ? AbilityScalarTypeOuterClass.AbilityScalarType.UNRECOGNIZED : result;
            }

            public Builder setValueType(AbilityScalarTypeOuterClass.AbilityScalarType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.valueType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearValueType() {
                this.valueType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public boolean hasFloatValue() {
                return this.valueCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public float getFloatValue() {
                if (this.valueCase_ == 3) {
                    return ((Float) this.value_).floatValue();
                }
                return 0.0f;
            }

            public Builder setFloatValue(float value) {
                this.valueCase_ = 3;
                this.value_ = Float.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearFloatValue() {
                if (this.valueCase_ == 3) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public boolean hasStringValue() {
                return this.valueCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public String getStringValue() {
                Object ref = "";
                if (this.valueCase_ == 4) {
                    ref = this.value_;
                }
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                if (this.valueCase_ == 4) {
                    this.value_ = s;
                }
                return s;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public ByteString getStringValueBytes() {
                Object ref = "";
                if (this.valueCase_ == 4) {
                    ref = this.value_;
                }
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                if (this.valueCase_ == 4) {
                    this.value_ = b;
                }
                return b;
            }

            public Builder setStringValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.valueCase_ = 4;
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearStringValue() {
                if (this.valueCase_ == 4) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                    onChanged();
                }
                return this;
            }

            public Builder setStringValueBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AbilityScalarValueEntry.checkByteStringIsUtf8(value);
                this.valueCase_ = 4;
                this.value_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public boolean hasIntValue() {
                return this.valueCase_ == 5;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public int getIntValue() {
                if (this.valueCase_ == 5) {
                    return ((Integer) this.value_).intValue();
                }
                return 0;
            }

            public Builder setIntValue(int value) {
                this.valueCase_ = 5;
                this.value_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearIntValue() {
                if (this.valueCase_ == 5) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public boolean hasUintValue() {
                return this.valueCase_ == 6;
            }

            @Override // emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder
            public int getUintValue() {
                if (this.valueCase_ == 6) {
                    return ((Integer) this.value_).intValue();
                }
                return 0;
            }

            public Builder setUintValue(int value) {
                this.valueCase_ = 6;
                this.value_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearUintValue() {
                if (this.valueCase_ == 6) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AbilityScalarValueEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityScalarValueEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityScalarValueEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityScalarValueEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityStringOuterClass.getDescriptor();
        AbilityScalarTypeOuterClass.getDescriptor();
    }
}
