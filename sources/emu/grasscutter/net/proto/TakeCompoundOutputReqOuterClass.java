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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCompoundOutputReqOuterClass.class */
public final class TakeCompoundOutputReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bTakeCompoundOutputReq.proto\"D\n\u0015TakeCompoundOutputReq\u0012\u0012\n\ncompoundId\u0018\r \u0001(\r\u0012\u0017\n\u000fcompoundGroupId\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakeCompoundOutputReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeCompoundOutputReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeCompoundOutputReq_descriptor, new String[]{"CompoundId", "CompoundGroupId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCompoundOutputReqOuterClass$TakeCompoundOutputReqOrBuilder.class */
    public interface TakeCompoundOutputReqOrBuilder extends MessageOrBuilder {
        int getCompoundId();

        int getCompoundGroupId();
    }

    private TakeCompoundOutputReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCompoundOutputReqOuterClass$TakeCompoundOutputReq.class */
    public static final class TakeCompoundOutputReq extends GeneratedMessageV3 implements TakeCompoundOutputReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMPOUNDID_FIELD_NUMBER = 13;
        private int compoundId_;
        public static final int COMPOUNDGROUPID_FIELD_NUMBER = 4;
        private int compoundGroupId_;
        private byte memoizedIsInitialized;
        private static final TakeCompoundOutputReq DEFAULT_INSTANCE = new TakeCompoundOutputReq();
        private static final Parser<TakeCompoundOutputReq> PARSER = new AbstractParser<TakeCompoundOutputReq>() { // from class: emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass.TakeCompoundOutputReq.1
            @Override // com.google.protobuf.Parser
            public TakeCompoundOutputReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeCompoundOutputReq(input, extensionRegistry);
            }
        };

        private TakeCompoundOutputReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeCompoundOutputReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeCompoundOutputReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeCompoundOutputReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.compoundGroupId_ = input.readUInt32();
                                break;
                            case 104:
                                this.compoundId_ = input.readUInt32();
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
            return TakeCompoundOutputReqOuterClass.internal_static_TakeCompoundOutputReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeCompoundOutputReqOuterClass.internal_static_TakeCompoundOutputReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeCompoundOutputReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass.TakeCompoundOutputReqOrBuilder
        public int getCompoundId() {
            return this.compoundId_;
        }

        @Override // emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass.TakeCompoundOutputReqOrBuilder
        public int getCompoundGroupId() {
            return this.compoundGroupId_;
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
            if (this.compoundGroupId_ != 0) {
                output.writeUInt32(4, this.compoundGroupId_);
            }
            if (this.compoundId_ != 0) {
                output.writeUInt32(13, this.compoundId_);
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
            if (this.compoundGroupId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.compoundGroupId_);
            }
            if (this.compoundId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.compoundId_);
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
            if (!(obj instanceof TakeCompoundOutputReq)) {
                return equals(obj);
            }
            TakeCompoundOutputReq other = (TakeCompoundOutputReq) obj;
            return getCompoundId() == other.getCompoundId() && getCompoundGroupId() == other.getCompoundGroupId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getCompoundId())) + 4)) + getCompoundGroupId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TakeCompoundOutputReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCompoundOutputReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCompoundOutputReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCompoundOutputReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCompoundOutputReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCompoundOutputReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCompoundOutputReq parseFrom(InputStream input) throws IOException {
            return (TakeCompoundOutputReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeCompoundOutputReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCompoundOutputReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeCompoundOutputReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeCompoundOutputReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeCompoundOutputReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCompoundOutputReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeCompoundOutputReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeCompoundOutputReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeCompoundOutputReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCompoundOutputReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeCompoundOutputReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCompoundOutputReqOuterClass$TakeCompoundOutputReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeCompoundOutputReqOrBuilder {
            private int compoundId_;
            private int compoundGroupId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeCompoundOutputReqOuterClass.internal_static_TakeCompoundOutputReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeCompoundOutputReqOuterClass.internal_static_TakeCompoundOutputReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeCompoundOutputReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeCompoundOutputReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.compoundId_ = 0;
                this.compoundGroupId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeCompoundOutputReqOuterClass.internal_static_TakeCompoundOutputReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeCompoundOutputReq getDefaultInstanceForType() {
                return TakeCompoundOutputReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeCompoundOutputReq build() {
                TakeCompoundOutputReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeCompoundOutputReq buildPartial() {
                TakeCompoundOutputReq result = new TakeCompoundOutputReq(this);
                result.compoundId_ = this.compoundId_;
                result.compoundGroupId_ = this.compoundGroupId_;
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
                if (other instanceof TakeCompoundOutputReq) {
                    return mergeFrom((TakeCompoundOutputReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeCompoundOutputReq other) {
                if (other == TakeCompoundOutputReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getCompoundId() != 0) {
                    setCompoundId(other.getCompoundId());
                }
                if (other.getCompoundGroupId() != 0) {
                    setCompoundGroupId(other.getCompoundGroupId());
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
                TakeCompoundOutputReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeCompoundOutputReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeCompoundOutputReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass.TakeCompoundOutputReqOrBuilder
            public int getCompoundId() {
                return this.compoundId_;
            }

            public Builder setCompoundId(int value) {
                this.compoundId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCompoundId() {
                this.compoundId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass.TakeCompoundOutputReqOrBuilder
            public int getCompoundGroupId() {
                return this.compoundGroupId_;
            }

            public Builder setCompoundGroupId(int value) {
                this.compoundGroupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCompoundGroupId() {
                this.compoundGroupId_ = 0;
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

        public static TakeCompoundOutputReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeCompoundOutputReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeCompoundOutputReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeCompoundOutputReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
