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
import emu.grasscutter.net.proto.MaterialDeleteReturnTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeMaterialDeleteReturnReqOuterClass.class */
public final class TakeMaterialDeleteReturnReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!TakeMaterialDeleteReturnReq.proto\u001a\u001eMaterialDeleteReturnType.proto\"F\n\u001bTakeMaterialDeleteReturnReq\u0012'\n\u0004type\u0018\u000b \u0001(\u000e2\u0019.MaterialDeleteReturnTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MaterialDeleteReturnTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TakeMaterialDeleteReturnReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeMaterialDeleteReturnReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeMaterialDeleteReturnReq_descriptor, new String[]{"Type"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeMaterialDeleteReturnReqOuterClass$TakeMaterialDeleteReturnReqOrBuilder.class */
    public interface TakeMaterialDeleteReturnReqOrBuilder extends MessageOrBuilder {
        int getTypeValue();

        MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType getType();
    }

    private TakeMaterialDeleteReturnReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeMaterialDeleteReturnReqOuterClass$TakeMaterialDeleteReturnReq.class */
    public static final class TakeMaterialDeleteReturnReq extends GeneratedMessageV3 implements TakeMaterialDeleteReturnReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 11;
        private int type_;
        private byte memoizedIsInitialized;
        private static final TakeMaterialDeleteReturnReq DEFAULT_INSTANCE = new TakeMaterialDeleteReturnReq();
        private static final Parser<TakeMaterialDeleteReturnReq> PARSER = new AbstractParser<TakeMaterialDeleteReturnReq>() { // from class: emu.grasscutter.net.proto.TakeMaterialDeleteReturnReqOuterClass.TakeMaterialDeleteReturnReq.1
            @Override // com.google.protobuf.Parser
            public TakeMaterialDeleteReturnReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeMaterialDeleteReturnReq(input, extensionRegistry);
            }
        };

        private TakeMaterialDeleteReturnReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeMaterialDeleteReturnReq() {
            this.memoizedIsInitialized = -1;
            this.type_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeMaterialDeleteReturnReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeMaterialDeleteReturnReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 88:
                                this.type_ = input.readEnum();
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeMaterialDeleteReturnReqOuterClass.internal_static_TakeMaterialDeleteReturnReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeMaterialDeleteReturnReqOuterClass.internal_static_TakeMaterialDeleteReturnReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeMaterialDeleteReturnReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeMaterialDeleteReturnReqOuterClass.TakeMaterialDeleteReturnReqOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.TakeMaterialDeleteReturnReqOuterClass.TakeMaterialDeleteReturnReqOrBuilder
        public MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType getType() {
            MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType result = MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.valueOf(this.type_);
            return result == null ? MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.UNRECOGNIZED : result;
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
            if (this.type_ != MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.MATERIAL_DELETE_RETURN_TYPE_BAG.getNumber()) {
                output.writeEnum(11, this.type_);
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
            if (this.type_ != MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.MATERIAL_DELETE_RETURN_TYPE_BAG.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(11, this.type_);
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
            if (!(obj instanceof TakeMaterialDeleteReturnReq)) {
                return equals(obj);
            }
            TakeMaterialDeleteReturnReq other = (TakeMaterialDeleteReturnReq) obj;
            return this.type_ == other.type_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + this.type_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TakeMaterialDeleteReturnReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(InputStream input) throws IOException {
            return (TakeMaterialDeleteReturnReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeMaterialDeleteReturnReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeMaterialDeleteReturnReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeMaterialDeleteReturnReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeMaterialDeleteReturnReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeMaterialDeleteReturnReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeMaterialDeleteReturnReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeMaterialDeleteReturnReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeMaterialDeleteReturnReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeMaterialDeleteReturnReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeMaterialDeleteReturnReqOuterClass$TakeMaterialDeleteReturnReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeMaterialDeleteReturnReqOrBuilder {
            private int type_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeMaterialDeleteReturnReqOuterClass.internal_static_TakeMaterialDeleteReturnReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeMaterialDeleteReturnReqOuterClass.internal_static_TakeMaterialDeleteReturnReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeMaterialDeleteReturnReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeMaterialDeleteReturnReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeMaterialDeleteReturnReqOuterClass.internal_static_TakeMaterialDeleteReturnReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeMaterialDeleteReturnReq getDefaultInstanceForType() {
                return TakeMaterialDeleteReturnReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeMaterialDeleteReturnReq build() {
                TakeMaterialDeleteReturnReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeMaterialDeleteReturnReq buildPartial() {
                TakeMaterialDeleteReturnReq result = new TakeMaterialDeleteReturnReq(this);
                result.type_ = this.type_;
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
                if (other instanceof TakeMaterialDeleteReturnReq) {
                    return mergeFrom((TakeMaterialDeleteReturnReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeMaterialDeleteReturnReq other) {
                if (other == TakeMaterialDeleteReturnReq.getDefaultInstance()) {
                    return this;
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
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
                TakeMaterialDeleteReturnReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeMaterialDeleteReturnReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeMaterialDeleteReturnReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeMaterialDeleteReturnReqOuterClass.TakeMaterialDeleteReturnReqOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeMaterialDeleteReturnReqOuterClass.TakeMaterialDeleteReturnReqOrBuilder
            public MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType getType() {
                MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType result = MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.valueOf(this.type_);
                return result == null ? MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.UNRECOGNIZED : result;
            }

            public Builder setType(MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType value) {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TakeMaterialDeleteReturnReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeMaterialDeleteReturnReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeMaterialDeleteReturnReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeMaterialDeleteReturnReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MaterialDeleteReturnTypeOuterClass.getDescriptor();
    }
}
