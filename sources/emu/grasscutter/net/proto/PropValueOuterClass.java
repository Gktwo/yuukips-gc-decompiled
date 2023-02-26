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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropValueOuterClass.class */
public final class PropValueOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fPropValue.proto\"O\n\tPropValue\u0012\f\n\u0004type\u0018\u0001 \u0001(\r\u0012\u000e\n\u0004ival\u0018\u0002 \u0001(\u0003H��\u0012\u000e\n\u0004fval\u0018\u0003 \u0001(\u0002H��\u0012\u000b\n\u0003val\u0018\u0004 \u0001(\u0003B\u0007\n\u0005valueB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PropValue_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PropValue_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PropValue_descriptor, new String[]{"Type", "Ival", "Fval", "Val", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropValueOuterClass$PropValueOrBuilder.class */
    public interface PropValueOrBuilder extends MessageOrBuilder {
        int getType();

        boolean hasIval();

        long getIval();

        boolean hasFval();

        float getFval();

        long getVal();

        PropValue.ValueCase getValueCase();
    }

    private PropValueOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropValueOuterClass$PropValue.class */
    public static final class PropValue extends GeneratedMessageV3 implements PropValueOrBuilder {
        private static final long serialVersionUID = 0;
        private int valueCase_;
        private Object value_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int IVAL_FIELD_NUMBER = 2;
        public static final int FVAL_FIELD_NUMBER = 3;
        public static final int VAL_FIELD_NUMBER = 4;
        private long val_;
        private byte memoizedIsInitialized;
        private static final PropValue DEFAULT_INSTANCE = new PropValue();
        private static final Parser<PropValue> PARSER = new AbstractParser<PropValue>() { // from class: emu.grasscutter.net.proto.PropValueOuterClass.PropValue.1
            @Override // com.google.protobuf.Parser
            public PropValue parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PropValue(input, extensionRegistry);
            }
        };

        private PropValue(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.valueCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private PropValue() {
            this.valueCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PropValue();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PropValue(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.type_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.valueCase_ = 2;
                                    this.value_ = Long.valueOf(input.readInt64());
                                    break;
                                case 29:
                                    this.valueCase_ = 3;
                                    this.value_ = Float.valueOf(input.readFloat());
                                    break;
                                case 32:
                                    this.val_ = input.readInt64();
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
            return PropValueOuterClass.internal_static_PropValue_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PropValueOuterClass.internal_static_PropValue_fieldAccessorTable.ensureFieldAccessorsInitialized(PropValue.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropValueOuterClass$PropValue$ValueCase.class */
        public enum ValueCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            IVAL(2),
            FVAL(3),
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
                    default:
                        return null;
                    case 2:
                        return IVAL;
                    case 3:
                        return FVAL;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public boolean hasIval() {
            return this.valueCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public long getIval() {
            if (this.valueCase_ == 2) {
                return ((Long) this.value_).longValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public boolean hasFval() {
            return this.valueCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public float getFval() {
            if (this.valueCase_ == 3) {
                return ((Float) this.value_).floatValue();
            }
            return 0.0f;
        }

        @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
        public long getVal() {
            return this.val_;
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
            if (this.type_ != 0) {
                output.writeUInt32(1, this.type_);
            }
            if (this.valueCase_ == 2) {
                output.writeInt64(2, ((Long) this.value_).longValue());
            }
            if (this.valueCase_ == 3) {
                output.writeFloat(3, ((Float) this.value_).floatValue());
            }
            if (this.val_ != 0) {
                output.writeInt64(4, this.val_);
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
            if (this.type_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.type_);
            }
            if (this.valueCase_ == 2) {
                size2 += CodedOutputStream.computeInt64Size(2, ((Long) this.value_).longValue());
            }
            if (this.valueCase_ == 3) {
                size2 += CodedOutputStream.computeFloatSize(3, ((Float) this.value_).floatValue());
            }
            if (this.val_ != 0) {
                size2 += CodedOutputStream.computeInt64Size(4, this.val_);
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
            if (!(obj instanceof PropValue)) {
                return equals(obj);
            }
            PropValue other = (PropValue) obj;
            if (getType() != other.getType() || getVal() != other.getVal() || !getValueCase().equals(other.getValueCase())) {
                return false;
            }
            switch (this.valueCase_) {
                case 2:
                    if (getIval() != other.getIval()) {
                        return false;
                    }
                    break;
                case 3:
                    if (Float.floatToIntBits(getFval()) != Float.floatToIntBits(other.getFval())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getType())) + 4)) + Internal.hashLong(getVal());
            switch (this.valueCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + Internal.hashLong(getIval());
                    break;
                case 3:
                    hash = (53 * ((37 * hash) + 3)) + Float.floatToIntBits(getFval());
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static PropValue parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PropValue parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PropValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PropValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PropValue parseFrom(InputStream input) throws IOException {
            return (PropValue) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PropValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropValue) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PropValue parseDelimitedFrom(InputStream input) throws IOException {
            return (PropValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PropValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropValue) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PropValue parseFrom(CodedInputStream input) throws IOException {
            return (PropValue) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PropValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PropValue) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PropValue prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropValueOuterClass$PropValue$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PropValueOrBuilder {
            private int valueCase_ = 0;
            private Object value_;
            private int type_;
            private long val_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PropValueOuterClass.internal_static_PropValue_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PropValueOuterClass.internal_static_PropValue_fieldAccessorTable.ensureFieldAccessorsInitialized(PropValue.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PropValue.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                this.val_ = 0;
                this.valueCase_ = 0;
                this.value_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PropValueOuterClass.internal_static_PropValue_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PropValue getDefaultInstanceForType() {
                return PropValue.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PropValue build() {
                PropValue result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PropValue buildPartial() {
                PropValue result = new PropValue(this);
                result.type_ = this.type_;
                if (this.valueCase_ == 2) {
                    result.value_ = this.value_;
                }
                if (this.valueCase_ == 3) {
                    result.value_ = this.value_;
                }
                result.val_ = this.val_;
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
                if (other instanceof PropValue) {
                    return mergeFrom((PropValue) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PropValue other) {
                if (other == PropValue.getDefaultInstance()) {
                    return this;
                }
                if (other.getType() != 0) {
                    setType(other.getType());
                }
                if (other.getVal() != 0) {
                    setVal(other.getVal());
                }
                switch (other.getValueCase()) {
                    case IVAL:
                        setIval(other.getIval());
                        break;
                    case FVAL:
                        setFval(other.getFval());
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
                PropValue parsedMessage = null;
                try {
                    try {
                        parsedMessage = PropValue.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PropValue) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public ValueCase getValueCase() {
                return ValueCase.forNumber(this.valueCase_);
            }

            public Builder clearValue() {
                this.valueCase_ = 0;
                this.value_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public boolean hasIval() {
                return this.valueCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public long getIval() {
                if (this.valueCase_ == 2) {
                    return ((Long) this.value_).longValue();
                }
                return 0;
            }

            public Builder setIval(long value) {
                this.valueCase_ = 2;
                this.value_ = Long.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearIval() {
                if (this.valueCase_ == 2) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public boolean hasFval() {
                return this.valueCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public float getFval() {
                if (this.valueCase_ == 3) {
                    return ((Float) this.value_).floatValue();
                }
                return 0.0f;
            }

            public Builder setFval(float value) {
                this.valueCase_ = 3;
                this.value_ = Float.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearFval() {
                if (this.valueCase_ == 3) {
                    this.valueCase_ = 0;
                    this.value_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.PropValueOuterClass.PropValueOrBuilder
            public long getVal() {
                return this.val_;
            }

            public Builder setVal(long value) {
                this.val_ = value;
                onChanged();
                return this;
            }

            public Builder clearVal() {
                this.val_ = 0;
                onChanged();
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

        public static PropValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PropValue> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PropValue> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PropValue getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
