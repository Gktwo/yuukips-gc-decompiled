package emu.grasscutter.net.proto;

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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetParentQuestVideoKeyRspOuterClass.class */
public final class GetParentQuestVideoKeyRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fGetParentQuestVideoKeyRsp.proto\"U\n\u0019GetParentQuestVideoKeyRsp\u0012\u0010\n\bvideoKey\u0018\u0002 \u0001(\u0004\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005\u0012\u0015\n\rparentQuestId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetParentQuestVideoKeyRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetParentQuestVideoKeyRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetParentQuestVideoKeyRsp_descriptor, new String[]{"VideoKey", "Retcode", "ParentQuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetParentQuestVideoKeyRspOuterClass$GetParentQuestVideoKeyRspOrBuilder.class */
    public interface GetParentQuestVideoKeyRspOrBuilder extends MessageOrBuilder {
        long getVideoKey();

        int getRetcode();

        int getParentQuestId();
    }

    private GetParentQuestVideoKeyRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetParentQuestVideoKeyRspOuterClass$GetParentQuestVideoKeyRsp.class */
    public static final class GetParentQuestVideoKeyRsp extends GeneratedMessageV3 implements GetParentQuestVideoKeyRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int VIDEOKEY_FIELD_NUMBER = 2;
        private long videoKey_;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        public static final int PARENTQUESTID_FIELD_NUMBER = 11;
        private int parentQuestId_;
        private byte memoizedIsInitialized;
        private static final GetParentQuestVideoKeyRsp DEFAULT_INSTANCE = new GetParentQuestVideoKeyRsp();
        private static final Parser<GetParentQuestVideoKeyRsp> PARSER = new AbstractParser<GetParentQuestVideoKeyRsp>() { // from class: emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRsp.1
            @Override // com.google.protobuf.Parser
            public GetParentQuestVideoKeyRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetParentQuestVideoKeyRsp(input, extensionRegistry);
            }
        };

        private GetParentQuestVideoKeyRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetParentQuestVideoKeyRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetParentQuestVideoKeyRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetParentQuestVideoKeyRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.videoKey_ = input.readUInt64();
                                    break;
                                case 72:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 88:
                                    this.parentQuestId_ = input.readUInt32();
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
                        }
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
            return GetParentQuestVideoKeyRspOuterClass.internal_static_GetParentQuestVideoKeyRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetParentQuestVideoKeyRspOuterClass.internal_static_GetParentQuestVideoKeyRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetParentQuestVideoKeyRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRspOrBuilder
        public long getVideoKey() {
            return this.videoKey_;
        }

        @Override // emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRspOrBuilder
        public int getParentQuestId() {
            return this.parentQuestId_;
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
            if (this.videoKey_ != 0) {
                output.writeUInt64(2, this.videoKey_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
            }
            if (this.parentQuestId_ != 0) {
                output.writeUInt32(11, this.parentQuestId_);
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
            if (this.videoKey_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(2, this.videoKey_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
            }
            if (this.parentQuestId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.parentQuestId_);
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
            if (!(obj instanceof GetParentQuestVideoKeyRsp)) {
                return equals(obj);
            }
            GetParentQuestVideoKeyRsp other = (GetParentQuestVideoKeyRsp) obj;
            return getVideoKey() == other.getVideoKey() && getRetcode() == other.getRetcode() && getParentQuestId() == other.getParentQuestId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashLong(getVideoKey()))) + 9)) + getRetcode())) + 11)) + getParentQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GetParentQuestVideoKeyRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(InputStream input) throws IOException {
            return (GetParentQuestVideoKeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetParentQuestVideoKeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetParentQuestVideoKeyRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetParentQuestVideoKeyRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetParentQuestVideoKeyRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetParentQuestVideoKeyRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetParentQuestVideoKeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetParentQuestVideoKeyRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetParentQuestVideoKeyRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetParentQuestVideoKeyRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetParentQuestVideoKeyRspOuterClass$GetParentQuestVideoKeyRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetParentQuestVideoKeyRspOrBuilder {
            private long videoKey_;
            private int retcode_;
            private int parentQuestId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetParentQuestVideoKeyRspOuterClass.internal_static_GetParentQuestVideoKeyRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetParentQuestVideoKeyRspOuterClass.internal_static_GetParentQuestVideoKeyRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetParentQuestVideoKeyRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetParentQuestVideoKeyRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.videoKey_ = 0;
                this.retcode_ = 0;
                this.parentQuestId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetParentQuestVideoKeyRspOuterClass.internal_static_GetParentQuestVideoKeyRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetParentQuestVideoKeyRsp getDefaultInstanceForType() {
                return GetParentQuestVideoKeyRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetParentQuestVideoKeyRsp build() {
                GetParentQuestVideoKeyRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetParentQuestVideoKeyRsp buildPartial() {
                GetParentQuestVideoKeyRsp result = new GetParentQuestVideoKeyRsp(this);
                result.videoKey_ = this.videoKey_;
                result.retcode_ = this.retcode_;
                result.parentQuestId_ = this.parentQuestId_;
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
                if (other instanceof GetParentQuestVideoKeyRsp) {
                    return mergeFrom((GetParentQuestVideoKeyRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetParentQuestVideoKeyRsp other) {
                if (other == GetParentQuestVideoKeyRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getVideoKey() != 0) {
                    setVideoKey(other.getVideoKey());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getParentQuestId() != 0) {
                    setParentQuestId(other.getParentQuestId());
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
                GetParentQuestVideoKeyRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetParentQuestVideoKeyRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetParentQuestVideoKeyRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRspOrBuilder
            public long getVideoKey() {
                return this.videoKey_;
            }

            public Builder setVideoKey(long value) {
                this.videoKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearVideoKey() {
                this.videoKey_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetParentQuestVideoKeyRspOuterClass.GetParentQuestVideoKeyRspOrBuilder
            public int getParentQuestId() {
                return this.parentQuestId_;
            }

            public Builder setParentQuestId(int value) {
                this.parentQuestId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentQuestId() {
                this.parentQuestId_ = 0;
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

        public static GetParentQuestVideoKeyRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetParentQuestVideoKeyRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetParentQuestVideoKeyRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetParentQuestVideoKeyRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
