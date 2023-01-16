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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AttackResultOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtBeingHitInfoOuterClass.class */
public final class EvtBeingHitInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015EvtBeingHitInfo.proto\u001a\u0012AttackResult.proto\"[\n\u000fEvtBeingHitInfo\u0012\u0011\n\tframe_num\u0018\u000b \u0001(\r\u0012\u000f\n\u0007peer_id\u0018\u0002 \u0001(\r\u0012$\n\rattack_result\u0018\u0006 \u0001(\u000b2\r.AttackResultB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AttackResultOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtBeingHitInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtBeingHitInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtBeingHitInfo_descriptor, new String[]{"FrameNum", "PeerId", "AttackResult"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtBeingHitInfoOuterClass$EvtBeingHitInfoOrBuilder.class */
    public interface EvtBeingHitInfoOrBuilder extends MessageOrBuilder {
        int getFrameNum();

        int getPeerId();

        boolean hasAttackResult();

        AttackResultOuterClass.AttackResult getAttackResult();

        AttackResultOuterClass.AttackResultOrBuilder getAttackResultOrBuilder();
    }

    private EvtBeingHitInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtBeingHitInfoOuterClass$EvtBeingHitInfo.class */
    public static final class EvtBeingHitInfo extends GeneratedMessageV3 implements EvtBeingHitInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FRAME_NUM_FIELD_NUMBER = 11;
        private int frameNum_;
        public static final int PEER_ID_FIELD_NUMBER = 2;
        private int peerId_;
        public static final int ATTACK_RESULT_FIELD_NUMBER = 6;
        private AttackResultOuterClass.AttackResult attackResult_;
        private byte memoizedIsInitialized;
        private static final EvtBeingHitInfo DEFAULT_INSTANCE = new EvtBeingHitInfo();
        private static final Parser<EvtBeingHitInfo> PARSER = new AbstractParser<EvtBeingHitInfo>() { // from class: emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfo.1
            @Override // com.google.protobuf.Parser
            public EvtBeingHitInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtBeingHitInfo(input, extensionRegistry);
            }
        };

        private EvtBeingHitInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtBeingHitInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtBeingHitInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtBeingHitInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.peerId_ = input.readUInt32();
                                    break;
                                case 50:
                                    AttackResultOuterClass.AttackResult.Builder subBuilder = this.attackResult_ != null ? this.attackResult_.toBuilder() : null;
                                    this.attackResult_ = (AttackResultOuterClass.AttackResult) input.readMessage(AttackResultOuterClass.AttackResult.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.attackResult_);
                                        this.attackResult_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 88:
                                    this.frameNum_ = input.readUInt32();
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
            return EvtBeingHitInfoOuterClass.internal_static_EvtBeingHitInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtBeingHitInfoOuterClass.internal_static_EvtBeingHitInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtBeingHitInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
        public int getFrameNum() {
            return this.frameNum_;
        }

        @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
        public boolean hasAttackResult() {
            return this.attackResult_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
        public AttackResultOuterClass.AttackResult getAttackResult() {
            return this.attackResult_ == null ? AttackResultOuterClass.AttackResult.getDefaultInstance() : this.attackResult_;
        }

        @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
        public AttackResultOuterClass.AttackResultOrBuilder getAttackResultOrBuilder() {
            return getAttackResult();
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
            if (this.peerId_ != 0) {
                output.writeUInt32(2, this.peerId_);
            }
            if (this.attackResult_ != null) {
                output.writeMessage(6, getAttackResult());
            }
            if (this.frameNum_ != 0) {
                output.writeUInt32(11, this.frameNum_);
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
            if (this.peerId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.peerId_);
            }
            if (this.attackResult_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getAttackResult());
            }
            if (this.frameNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.frameNum_);
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
            if (!(obj instanceof EvtBeingHitInfo)) {
                return equals(obj);
            }
            EvtBeingHitInfo other = (EvtBeingHitInfo) obj;
            if (getFrameNum() == other.getFrameNum() && getPeerId() == other.getPeerId() && hasAttackResult() == other.hasAttackResult()) {
                return (!hasAttackResult() || getAttackResult().equals(other.getAttackResult())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getFrameNum())) + 2)) + getPeerId();
            if (hasAttackResult()) {
                hash = (53 * ((37 * hash) + 6)) + getAttackResult().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtBeingHitInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtBeingHitInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtBeingHitInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtBeingHitInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtBeingHitInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtBeingHitInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtBeingHitInfo parseFrom(InputStream input) throws IOException {
            return (EvtBeingHitInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtBeingHitInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtBeingHitInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtBeingHitInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtBeingHitInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtBeingHitInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtBeingHitInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtBeingHitInfo parseFrom(CodedInputStream input) throws IOException {
            return (EvtBeingHitInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtBeingHitInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtBeingHitInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtBeingHitInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtBeingHitInfoOuterClass$EvtBeingHitInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtBeingHitInfoOrBuilder {
            private int frameNum_;
            private int peerId_;
            private AttackResultOuterClass.AttackResult attackResult_;
            private SingleFieldBuilderV3<AttackResultOuterClass.AttackResult, AttackResultOuterClass.AttackResult.Builder, AttackResultOuterClass.AttackResultOrBuilder> attackResultBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtBeingHitInfoOuterClass.internal_static_EvtBeingHitInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtBeingHitInfoOuterClass.internal_static_EvtBeingHitInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtBeingHitInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtBeingHitInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.frameNum_ = 0;
                this.peerId_ = 0;
                if (this.attackResultBuilder_ == null) {
                    this.attackResult_ = null;
                } else {
                    this.attackResult_ = null;
                    this.attackResultBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtBeingHitInfoOuterClass.internal_static_EvtBeingHitInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtBeingHitInfo getDefaultInstanceForType() {
                return EvtBeingHitInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtBeingHitInfo build() {
                EvtBeingHitInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtBeingHitInfo buildPartial() {
                EvtBeingHitInfo result = new EvtBeingHitInfo(this);
                result.frameNum_ = this.frameNum_;
                result.peerId_ = this.peerId_;
                if (this.attackResultBuilder_ == null) {
                    result.attackResult_ = this.attackResult_;
                } else {
                    result.attackResult_ = this.attackResultBuilder_.build();
                }
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
                if (other instanceof EvtBeingHitInfo) {
                    return mergeFrom((EvtBeingHitInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtBeingHitInfo other) {
                if (other == EvtBeingHitInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getFrameNum() != 0) {
                    setFrameNum(other.getFrameNum());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (other.hasAttackResult()) {
                    mergeAttackResult(other.getAttackResult());
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
                EvtBeingHitInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtBeingHitInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtBeingHitInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
            public int getFrameNum() {
                return this.frameNum_;
            }

            public Builder setFrameNum(int value) {
                this.frameNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearFrameNum() {
                this.frameNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
            public boolean hasAttackResult() {
                return (this.attackResultBuilder_ == null && this.attackResult_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
            public AttackResultOuterClass.AttackResult getAttackResult() {
                if (this.attackResultBuilder_ == null) {
                    return this.attackResult_ == null ? AttackResultOuterClass.AttackResult.getDefaultInstance() : this.attackResult_;
                }
                return this.attackResultBuilder_.getMessage();
            }

            public Builder setAttackResult(AttackResultOuterClass.AttackResult value) {
                if (this.attackResultBuilder_ != null) {
                    this.attackResultBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.attackResult_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAttackResult(AttackResultOuterClass.AttackResult.Builder builderForValue) {
                if (this.attackResultBuilder_ == null) {
                    this.attackResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.attackResultBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAttackResult(AttackResultOuterClass.AttackResult value) {
                if (this.attackResultBuilder_ == null) {
                    if (this.attackResult_ != null) {
                        this.attackResult_ = AttackResultOuterClass.AttackResult.newBuilder(this.attackResult_).mergeFrom(value).buildPartial();
                    } else {
                        this.attackResult_ = value;
                    }
                    onChanged();
                } else {
                    this.attackResultBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAttackResult() {
                if (this.attackResultBuilder_ == null) {
                    this.attackResult_ = null;
                    onChanged();
                } else {
                    this.attackResult_ = null;
                    this.attackResultBuilder_ = null;
                }
                return this;
            }

            public AttackResultOuterClass.AttackResult.Builder getAttackResultBuilder() {
                onChanged();
                return getAttackResultFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass.EvtBeingHitInfoOrBuilder
            public AttackResultOuterClass.AttackResultOrBuilder getAttackResultOrBuilder() {
                if (this.attackResultBuilder_ != null) {
                    return this.attackResultBuilder_.getMessageOrBuilder();
                }
                return this.attackResult_ == null ? AttackResultOuterClass.AttackResult.getDefaultInstance() : this.attackResult_;
            }

            private SingleFieldBuilderV3<AttackResultOuterClass.AttackResult, AttackResultOuterClass.AttackResult.Builder, AttackResultOuterClass.AttackResultOrBuilder> getAttackResultFieldBuilder() {
                if (this.attackResultBuilder_ == null) {
                    this.attackResultBuilder_ = new SingleFieldBuilderV3<>(getAttackResult(), getParentForChildren(), isClean());
                    this.attackResult_ = null;
                }
                return this.attackResultBuilder_;
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

        public static EvtBeingHitInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtBeingHitInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtBeingHitInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtBeingHitInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AttackResultOuterClass.getDescriptor();
    }
}
