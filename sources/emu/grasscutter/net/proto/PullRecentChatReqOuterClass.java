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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullRecentChatReqOuterClass.class */
public final class PullRecentChatReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017PullRecentChatReq.proto\";\n\u0011PullRecentChatReq\u0012\u0015\n\rbeginSequence\u0018\u000e \u0001(\r\u0012\u000f\n\u0007pullNum\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PullRecentChatReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PullRecentChatReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PullRecentChatReq_descriptor, new String[]{"BeginSequence", "PullNum"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullRecentChatReqOuterClass$PullRecentChatReqOrBuilder.class */
    public interface PullRecentChatReqOrBuilder extends MessageOrBuilder {
        int getBeginSequence();

        int getPullNum();
    }

    private PullRecentChatReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullRecentChatReqOuterClass$PullRecentChatReq.class */
    public static final class PullRecentChatReq extends GeneratedMessageV3 implements PullRecentChatReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEGINSEQUENCE_FIELD_NUMBER = 14;
        private int beginSequence_;
        public static final int PULLNUM_FIELD_NUMBER = 2;
        private int pullNum_;
        private byte memoizedIsInitialized;
        private static final PullRecentChatReq DEFAULT_INSTANCE = new PullRecentChatReq();
        private static final Parser<PullRecentChatReq> PARSER = new AbstractParser<PullRecentChatReq>() { // from class: emu.grasscutter.net.proto.PullRecentChatReqOuterClass.PullRecentChatReq.1
            @Override // com.google.protobuf.Parser
            public PullRecentChatReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PullRecentChatReq(input, extensionRegistry);
            }
        };

        private PullRecentChatReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PullRecentChatReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PullRecentChatReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PullRecentChatReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.pullNum_ = input.readUInt32();
                                break;
                            case 112:
                                this.beginSequence_ = input.readUInt32();
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
            return PullRecentChatReqOuterClass.internal_static_PullRecentChatReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PullRecentChatReqOuterClass.internal_static_PullRecentChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PullRecentChatReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PullRecentChatReqOuterClass.PullRecentChatReqOrBuilder
        public int getBeginSequence() {
            return this.beginSequence_;
        }

        @Override // emu.grasscutter.net.proto.PullRecentChatReqOuterClass.PullRecentChatReqOrBuilder
        public int getPullNum() {
            return this.pullNum_;
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
            if (this.pullNum_ != 0) {
                output.writeUInt32(2, this.pullNum_);
            }
            if (this.beginSequence_ != 0) {
                output.writeUInt32(14, this.beginSequence_);
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
            if (this.pullNum_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.pullNum_);
            }
            if (this.beginSequence_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.beginSequence_);
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
            if (!(obj instanceof PullRecentChatReq)) {
                return equals(obj);
            }
            PullRecentChatReq other = (PullRecentChatReq) obj;
            return getBeginSequence() == other.getBeginSequence() && getPullNum() == other.getPullNum() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getBeginSequence())) + 2)) + getPullNum())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PullRecentChatReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullRecentChatReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullRecentChatReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullRecentChatReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullRecentChatReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullRecentChatReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullRecentChatReq parseFrom(InputStream input) throws IOException {
            return (PullRecentChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PullRecentChatReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullRecentChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PullRecentChatReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PullRecentChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PullRecentChatReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullRecentChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PullRecentChatReq parseFrom(CodedInputStream input) throws IOException {
            return (PullRecentChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PullRecentChatReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullRecentChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PullRecentChatReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullRecentChatReqOuterClass$PullRecentChatReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PullRecentChatReqOrBuilder {
            private int beginSequence_;
            private int pullNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PullRecentChatReqOuterClass.internal_static_PullRecentChatReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PullRecentChatReqOuterClass.internal_static_PullRecentChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PullRecentChatReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PullRecentChatReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.beginSequence_ = 0;
                this.pullNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PullRecentChatReqOuterClass.internal_static_PullRecentChatReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PullRecentChatReq getDefaultInstanceForType() {
                return PullRecentChatReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PullRecentChatReq build() {
                PullRecentChatReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PullRecentChatReq buildPartial() {
                PullRecentChatReq result = new PullRecentChatReq(this);
                result.beginSequence_ = this.beginSequence_;
                result.pullNum_ = this.pullNum_;
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
                if (other instanceof PullRecentChatReq) {
                    return mergeFrom((PullRecentChatReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PullRecentChatReq other) {
                if (other == PullRecentChatReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getBeginSequence() != 0) {
                    setBeginSequence(other.getBeginSequence());
                }
                if (other.getPullNum() != 0) {
                    setPullNum(other.getPullNum());
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
                PullRecentChatReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PullRecentChatReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PullRecentChatReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PullRecentChatReqOuterClass.PullRecentChatReqOrBuilder
            public int getBeginSequence() {
                return this.beginSequence_;
            }

            public Builder setBeginSequence(int value) {
                this.beginSequence_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginSequence() {
                this.beginSequence_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PullRecentChatReqOuterClass.PullRecentChatReqOrBuilder
            public int getPullNum() {
                return this.pullNum_;
            }

            public Builder setPullNum(int value) {
                this.pullNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearPullNum() {
                this.pullNum_ = 0;
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

        public static PullRecentChatReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PullRecentChatReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PullRecentChatReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PullRecentChatReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
