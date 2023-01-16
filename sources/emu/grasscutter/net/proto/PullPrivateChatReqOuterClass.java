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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatReqOuterClass.class */
public final class PullPrivateChatReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018PullPrivateChatReq.proto\"Q\n\u0012PullPrivateChatReq\u0012\u0015\n\rfrom_sequence\u0018\u0005 \u0001(\r\u0012\u0012\n\ntarget_uid\u0018\f \u0001(\r\u0012\u0010\n\bpull_num\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PullPrivateChatReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PullPrivateChatReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PullPrivateChatReq_descriptor, new String[]{"FromSequence", "TargetUid", "PullNum"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatReqOuterClass$PullPrivateChatReqOrBuilder.class */
    public interface PullPrivateChatReqOrBuilder extends MessageOrBuilder {
        int getFromSequence();

        int getTargetUid();

        int getPullNum();
    }

    private PullPrivateChatReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatReqOuterClass$PullPrivateChatReq.class */
    public static final class PullPrivateChatReq extends GeneratedMessageV3 implements PullPrivateChatReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FROM_SEQUENCE_FIELD_NUMBER = 5;
        private int fromSequence_;
        public static final int TARGET_UID_FIELD_NUMBER = 12;
        private int targetUid_;
        public static final int PULL_NUM_FIELD_NUMBER = 11;
        private int pullNum_;
        private byte memoizedIsInitialized;
        private static final PullPrivateChatReq DEFAULT_INSTANCE = new PullPrivateChatReq();
        private static final Parser<PullPrivateChatReq> PARSER = new AbstractParser<PullPrivateChatReq>() { // from class: emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReq.1
            @Override // com.google.protobuf.Parser
            public PullPrivateChatReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PullPrivateChatReq(input, extensionRegistry);
            }
        };

        private PullPrivateChatReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PullPrivateChatReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PullPrivateChatReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PullPrivateChatReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.fromSequence_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.pullNum_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.targetUid_ = input.readUInt32();
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
            return PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PullPrivateChatReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder
        public int getFromSequence() {
            return this.fromSequence_;
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        @Override // emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder
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
            if (this.fromSequence_ != 0) {
                output.writeUInt32(5, this.fromSequence_);
            }
            if (this.pullNum_ != 0) {
                output.writeUInt32(11, this.pullNum_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(12, this.targetUid_);
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
            if (this.fromSequence_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.fromSequence_);
            }
            if (this.pullNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.pullNum_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.targetUid_);
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
            if (!(obj instanceof PullPrivateChatReq)) {
                return equals(obj);
            }
            PullPrivateChatReq other = (PullPrivateChatReq) obj;
            return getFromSequence() == other.getFromSequence() && getTargetUid() == other.getTargetUid() && getPullNum() == other.getPullNum() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getFromSequence())) + 12)) + getTargetUid())) + 11)) + getPullNum())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PullPrivateChatReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullPrivateChatReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullPrivateChatReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullPrivateChatReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullPrivateChatReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PullPrivateChatReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PullPrivateChatReq parseFrom(InputStream input) throws IOException {
            return (PullPrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PullPrivateChatReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullPrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PullPrivateChatReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PullPrivateChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PullPrivateChatReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullPrivateChatReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PullPrivateChatReq parseFrom(CodedInputStream input) throws IOException {
            return (PullPrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PullPrivateChatReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PullPrivateChatReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PullPrivateChatReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PullPrivateChatReqOuterClass$PullPrivateChatReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PullPrivateChatReqOrBuilder {
            private int fromSequence_;
            private int targetUid_;
            private int pullNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PullPrivateChatReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PullPrivateChatReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.fromSequence_ = 0;
                this.targetUid_ = 0;
                this.pullNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PullPrivateChatReqOuterClass.internal_static_PullPrivateChatReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PullPrivateChatReq getDefaultInstanceForType() {
                return PullPrivateChatReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PullPrivateChatReq build() {
                PullPrivateChatReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PullPrivateChatReq buildPartial() {
                PullPrivateChatReq result = new PullPrivateChatReq(this);
                result.fromSequence_ = this.fromSequence_;
                result.targetUid_ = this.targetUid_;
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
                if (other instanceof PullPrivateChatReq) {
                    return mergeFrom((PullPrivateChatReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PullPrivateChatReq other) {
                if (other == PullPrivateChatReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getFromSequence() != 0) {
                    setFromSequence(other.getFromSequence());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
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
                PullPrivateChatReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PullPrivateChatReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PullPrivateChatReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder
            public int getFromSequence() {
                return this.fromSequence_;
            }

            public Builder setFromSequence(int value) {
                this.fromSequence_ = value;
                onChanged();
                return this;
            }

            public Builder clearFromSequence() {
                this.fromSequence_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PullPrivateChatReqOuterClass.PullPrivateChatReqOrBuilder
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

        public static PullPrivateChatReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PullPrivateChatReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PullPrivateChatReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PullPrivateChatReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
