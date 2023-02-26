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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PostEnterSceneRspOuterClass.class */
public final class PostEnterSceneRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017PostEnterSceneRsp.proto\"=\n\u0011PostEnterSceneRsp\u0012\u0017\n\u000fenterSceneToken\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PostEnterSceneRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PostEnterSceneRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PostEnterSceneRsp_descriptor, new String[]{"EnterSceneToken", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PostEnterSceneRspOuterClass$PostEnterSceneRspOrBuilder.class */
    public interface PostEnterSceneRspOrBuilder extends MessageOrBuilder {
        int getEnterSceneToken();

        int getRetcode();
    }

    private PostEnterSceneRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PostEnterSceneRspOuterClass$PostEnterSceneRsp.class */
    public static final class PostEnterSceneRsp extends GeneratedMessageV3 implements PostEnterSceneRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTERSCENETOKEN_FIELD_NUMBER = 3;
        private int enterSceneToken_;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final PostEnterSceneRsp DEFAULT_INSTANCE = new PostEnterSceneRsp();
        private static final Parser<PostEnterSceneRsp> PARSER = new AbstractParser<PostEnterSceneRsp>() { // from class: emu.grasscutter.net.proto.PostEnterSceneRspOuterClass.PostEnterSceneRsp.1
            @Override // com.google.protobuf.Parser
            public PostEnterSceneRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PostEnterSceneRsp(input, extensionRegistry);
            }
        };

        private PostEnterSceneRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PostEnterSceneRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PostEnterSceneRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PostEnterSceneRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.enterSceneToken_ = input.readUInt32();
                                break;
                            case 104:
                                this.retcode_ = input.readInt32();
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
            return PostEnterSceneRspOuterClass.internal_static_PostEnterSceneRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PostEnterSceneRspOuterClass.internal_static_PostEnterSceneRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PostEnterSceneRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PostEnterSceneRspOuterClass.PostEnterSceneRspOrBuilder
        public int getEnterSceneToken() {
            return this.enterSceneToken_;
        }

        @Override // emu.grasscutter.net.proto.PostEnterSceneRspOuterClass.PostEnterSceneRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.enterSceneToken_ != 0) {
                output.writeUInt32(3, this.enterSceneToken_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
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
            if (this.enterSceneToken_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.enterSceneToken_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.retcode_);
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
            if (!(obj instanceof PostEnterSceneRsp)) {
                return equals(obj);
            }
            PostEnterSceneRsp other = (PostEnterSceneRsp) obj;
            return getEnterSceneToken() == other.getEnterSceneToken() && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getEnterSceneToken())) + 13)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PostEnterSceneRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PostEnterSceneRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PostEnterSceneRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PostEnterSceneRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PostEnterSceneRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PostEnterSceneRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PostEnterSceneRsp parseFrom(InputStream input) throws IOException {
            return (PostEnterSceneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PostEnterSceneRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PostEnterSceneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PostEnterSceneRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PostEnterSceneRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PostEnterSceneRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PostEnterSceneRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PostEnterSceneRsp parseFrom(CodedInputStream input) throws IOException {
            return (PostEnterSceneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PostEnterSceneRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PostEnterSceneRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PostEnterSceneRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PostEnterSceneRspOuterClass$PostEnterSceneRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PostEnterSceneRspOrBuilder {
            private int enterSceneToken_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PostEnterSceneRspOuterClass.internal_static_PostEnterSceneRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PostEnterSceneRspOuterClass.internal_static_PostEnterSceneRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PostEnterSceneRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PostEnterSceneRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.enterSceneToken_ = 0;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PostEnterSceneRspOuterClass.internal_static_PostEnterSceneRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PostEnterSceneRsp getDefaultInstanceForType() {
                return PostEnterSceneRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PostEnterSceneRsp build() {
                PostEnterSceneRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PostEnterSceneRsp buildPartial() {
                PostEnterSceneRsp result = new PostEnterSceneRsp(this);
                result.enterSceneToken_ = this.enterSceneToken_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof PostEnterSceneRsp) {
                    return mergeFrom((PostEnterSceneRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PostEnterSceneRsp other) {
                if (other == PostEnterSceneRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getEnterSceneToken() != 0) {
                    setEnterSceneToken(other.getEnterSceneToken());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                PostEnterSceneRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PostEnterSceneRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PostEnterSceneRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PostEnterSceneRspOuterClass.PostEnterSceneRspOrBuilder
            public int getEnterSceneToken() {
                return this.enterSceneToken_;
            }

            public Builder setEnterSceneToken(int value) {
                this.enterSceneToken_ = value;
                onChanged();
                return this;
            }

            public Builder clearEnterSceneToken() {
                this.enterSceneToken_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PostEnterSceneRspOuterClass.PostEnterSceneRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PostEnterSceneRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PostEnterSceneRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PostEnterSceneRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PostEnterSceneRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
