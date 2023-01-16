package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.FireWorkTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkInstanceOuterClass.class */
public final class FireWorkInstanceOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016FireWorkInstance.proto\u001a\u0012FireWorkType.proto\">\n\u0010FireWorkInstance\u0012\u001b\n\u0004type\u0018\u0001 \u0001(\u000e2\r.FireWorkType\u0012\r\n\u0005value\u0018\u0002 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FireWorkTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FireWorkInstance_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FireWorkInstance_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FireWorkInstance_descriptor, new String[]{"Type", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkInstanceOuterClass$FireWorkInstanceOrBuilder.class */
    public interface FireWorkInstanceOrBuilder extends MessageOrBuilder {
        int getTypeValue();

        FireWorkTypeOuterClass.FireWorkType getType();

        int getValue();
    }

    private FireWorkInstanceOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkInstanceOuterClass$FireWorkInstance.class */
    public static final class FireWorkInstance extends GeneratedMessageV3 implements FireWorkInstanceOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int value_;
        private byte memoizedIsInitialized;
        private static final FireWorkInstance DEFAULT_INSTANCE = new FireWorkInstance();
        private static final Parser<FireWorkInstance> PARSER = new AbstractParser<FireWorkInstance>() { // from class: emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstance.1
            @Override // com.google.protobuf.Parser
            public FireWorkInstance parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FireWorkInstance(input, extensionRegistry);
            }
        };

        private FireWorkInstance(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FireWorkInstance() {
            this.memoizedIsInitialized = -1;
            this.type_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FireWorkInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FireWorkInstance(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.type_ = input.readEnum();
                                    break;
                                case 16:
                                    this.value_ = input.readInt32();
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
            return FireWorkInstanceOuterClass.internal_static_FireWorkInstance_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FireWorkInstanceOuterClass.internal_static_FireWorkInstance_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkInstance.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder
        public FireWorkTypeOuterClass.FireWorkType getType() {
            FireWorkTypeOuterClass.FireWorkType result = FireWorkTypeOuterClass.FireWorkType.valueOf(this.type_);
            return result == null ? FireWorkTypeOuterClass.FireWorkType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder
        public int getValue() {
            return this.value_;
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
            if (this.type_ != FireWorkTypeOuterClass.FireWorkType.FireWorkType_ODJKANKMPPJ.getNumber()) {
                output.writeEnum(1, this.type_);
            }
            if (this.value_ != 0) {
                output.writeInt32(2, this.value_);
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
            if (this.type_ != FireWorkTypeOuterClass.FireWorkType.FireWorkType_ODJKANKMPPJ.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.type_);
            }
            if (this.value_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(2, this.value_);
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
            if (!(obj instanceof FireWorkInstance)) {
                return equals(obj);
            }
            FireWorkInstance other = (FireWorkInstance) obj;
            return this.type_ == other.type_ && getValue() == other.getValue() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + this.type_)) + 2)) + getValue())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FireWorkInstance parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkInstance parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkInstance parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkInstance parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkInstance parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkInstance parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkInstance parseFrom(InputStream input) throws IOException {
            return (FireWorkInstance) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkInstance parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkInstance) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkInstance parseDelimitedFrom(InputStream input) throws IOException {
            return (FireWorkInstance) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FireWorkInstance parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkInstance) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkInstance parseFrom(CodedInputStream input) throws IOException {
            return (FireWorkInstance) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkInstance parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkInstance) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FireWorkInstance prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkInstanceOuterClass$FireWorkInstance$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FireWorkInstanceOrBuilder {
            private int type_ = 0;
            private int value_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FireWorkInstanceOuterClass.internal_static_FireWorkInstance_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FireWorkInstanceOuterClass.internal_static_FireWorkInstance_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkInstance.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FireWorkInstance.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                this.value_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FireWorkInstanceOuterClass.internal_static_FireWorkInstance_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FireWorkInstance getDefaultInstanceForType() {
                return FireWorkInstance.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkInstance build() {
                FireWorkInstance result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkInstance buildPartial() {
                FireWorkInstance result = new FireWorkInstance(this);
                result.type_ = this.type_;
                result.value_ = this.value_;
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
                if (other instanceof FireWorkInstance) {
                    return mergeFrom((FireWorkInstance) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FireWorkInstance other) {
                if (other == FireWorkInstance.getDefaultInstance()) {
                    return this;
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
                }
                if (other.getValue() != 0) {
                    setValue(other.getValue());
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
                FireWorkInstance parsedMessage = null;
                try {
                    try {
                        parsedMessage = FireWorkInstance.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FireWorkInstance) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder
            public FireWorkTypeOuterClass.FireWorkType getType() {
                FireWorkTypeOuterClass.FireWorkType result = FireWorkTypeOuterClass.FireWorkType.valueOf(this.type_);
                return result == null ? FireWorkTypeOuterClass.FireWorkType.UNRECOGNIZED : result;
            }

            public Builder setType(FireWorkTypeOuterClass.FireWorkType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder
            public int getValue() {
                return this.value_;
            }

            public Builder setValue(int value) {
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.value_ = 0;
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

        public static FireWorkInstance getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FireWorkInstance> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FireWorkInstance> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FireWorkInstance getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FireWorkTypeOuterClass.getDescriptor();
    }
}
