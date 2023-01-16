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
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityMoveNotifyOuterClass.class */
public final class SceneEntityMoveNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bSceneEntityMoveNotify.proto\u001a\u0010MotionInfo.proto\"v\n\u0015SceneEntityMoveNotify\u0012\u0014\n\freliable_seq\u0018\u0003 \u0001(\r\u0012\u0012\n\nscene_time\u0018\u000f \u0001(\r\u0012\u0011\n\tentity_id\u0018\u000b \u0001(\r\u0012 \n\u000bmotion_info\u0018\u000e \u0001(\u000b2\u000b.MotionInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MotionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneEntityMoveNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneEntityMoveNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneEntityMoveNotify_descriptor, new String[]{"ReliableSeq", "SceneTime", "EntityId", "MotionInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityMoveNotifyOuterClass$SceneEntityMoveNotifyOrBuilder.class */
    public interface SceneEntityMoveNotifyOrBuilder extends MessageOrBuilder {
        int getReliableSeq();

        int getSceneTime();

        int getEntityId();

        boolean hasMotionInfo();

        MotionInfoOuterClass.MotionInfo getMotionInfo();

        MotionInfoOuterClass.MotionInfoOrBuilder getMotionInfoOrBuilder();
    }

    private SceneEntityMoveNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityMoveNotifyOuterClass$SceneEntityMoveNotify.class */
    public static final class SceneEntityMoveNotify extends GeneratedMessageV3 implements SceneEntityMoveNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RELIABLE_SEQ_FIELD_NUMBER = 3;
        private int reliableSeq_;
        public static final int SCENE_TIME_FIELD_NUMBER = 15;
        private int sceneTime_;
        public static final int ENTITY_ID_FIELD_NUMBER = 11;
        private int entityId_;
        public static final int MOTION_INFO_FIELD_NUMBER = 14;
        private MotionInfoOuterClass.MotionInfo motionInfo_;
        private byte memoizedIsInitialized;
        private static final SceneEntityMoveNotify DEFAULT_INSTANCE = new SceneEntityMoveNotify();
        private static final Parser<SceneEntityMoveNotify> PARSER = new AbstractParser<SceneEntityMoveNotify>() { // from class: emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotify.1
            @Override // com.google.protobuf.Parser
            public SceneEntityMoveNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneEntityMoveNotify(input, extensionRegistry);
            }
        };

        private SceneEntityMoveNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneEntityMoveNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneEntityMoveNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneEntityMoveNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.reliableSeq_ = input.readUInt32();
                                break;
                            case 88:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 114:
                                MotionInfoOuterClass.MotionInfo.Builder subBuilder = this.motionInfo_ != null ? this.motionInfo_.toBuilder() : null;
                                this.motionInfo_ = (MotionInfoOuterClass.MotionInfo) input.readMessage(MotionInfoOuterClass.MotionInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.motionInfo_);
                                    this.motionInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 120:
                                this.sceneTime_ = input.readUInt32();
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
            return SceneEntityMoveNotifyOuterClass.internal_static_SceneEntityMoveNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneEntityMoveNotifyOuterClass.internal_static_SceneEntityMoveNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityMoveNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
        public int getReliableSeq() {
            return this.reliableSeq_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
        public int getSceneTime() {
            return this.sceneTime_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
        public boolean hasMotionInfo() {
            return this.motionInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
        public MotionInfoOuterClass.MotionInfo getMotionInfo() {
            return this.motionInfo_ == null ? MotionInfoOuterClass.MotionInfo.getDefaultInstance() : this.motionInfo_;
        }

        @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
        public MotionInfoOuterClass.MotionInfoOrBuilder getMotionInfoOrBuilder() {
            return getMotionInfo();
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
            if (this.reliableSeq_ != 0) {
                output.writeUInt32(3, this.reliableSeq_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(11, this.entityId_);
            }
            if (this.motionInfo_ != null) {
                output.writeMessage(14, getMotionInfo());
            }
            if (this.sceneTime_ != 0) {
                output.writeUInt32(15, this.sceneTime_);
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
            if (this.reliableSeq_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.reliableSeq_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.entityId_);
            }
            if (this.motionInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getMotionInfo());
            }
            if (this.sceneTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.sceneTime_);
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
            if (!(obj instanceof SceneEntityMoveNotify)) {
                return equals(obj);
            }
            SceneEntityMoveNotify other = (SceneEntityMoveNotify) obj;
            if (getReliableSeq() == other.getReliableSeq() && getSceneTime() == other.getSceneTime() && getEntityId() == other.getEntityId() && hasMotionInfo() == other.hasMotionInfo()) {
                return (!hasMotionInfo() || getMotionInfo().equals(other.getMotionInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getReliableSeq())) + 15)) + getSceneTime())) + 11)) + getEntityId();
            if (hasMotionInfo()) {
                hash = (53 * ((37 * hash) + 14)) + getMotionInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneEntityMoveNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityMoveNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityMoveNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityMoveNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityMoveNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneEntityMoveNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneEntityMoveNotify parseFrom(InputStream input) throws IOException {
            return (SceneEntityMoveNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityMoveNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityMoveNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityMoveNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneEntityMoveNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneEntityMoveNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityMoveNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneEntityMoveNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneEntityMoveNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneEntityMoveNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneEntityMoveNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneEntityMoveNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneEntityMoveNotifyOuterClass$SceneEntityMoveNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneEntityMoveNotifyOrBuilder {
            private int reliableSeq_;
            private int sceneTime_;
            private int entityId_;
            private MotionInfoOuterClass.MotionInfo motionInfo_;
            private SingleFieldBuilderV3<MotionInfoOuterClass.MotionInfo, MotionInfoOuterClass.MotionInfo.Builder, MotionInfoOuterClass.MotionInfoOrBuilder> motionInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneEntityMoveNotifyOuterClass.internal_static_SceneEntityMoveNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneEntityMoveNotifyOuterClass.internal_static_SceneEntityMoveNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneEntityMoveNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneEntityMoveNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.reliableSeq_ = 0;
                this.sceneTime_ = 0;
                this.entityId_ = 0;
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfo_ = null;
                } else {
                    this.motionInfo_ = null;
                    this.motionInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneEntityMoveNotifyOuterClass.internal_static_SceneEntityMoveNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneEntityMoveNotify getDefaultInstanceForType() {
                return SceneEntityMoveNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityMoveNotify build() {
                SceneEntityMoveNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneEntityMoveNotify buildPartial() {
                SceneEntityMoveNotify result = new SceneEntityMoveNotify(this);
                result.reliableSeq_ = this.reliableSeq_;
                result.sceneTime_ = this.sceneTime_;
                result.entityId_ = this.entityId_;
                if (this.motionInfoBuilder_ == null) {
                    result.motionInfo_ = this.motionInfo_;
                } else {
                    result.motionInfo_ = this.motionInfoBuilder_.build();
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
                if (other instanceof SceneEntityMoveNotify) {
                    return mergeFrom((SceneEntityMoveNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneEntityMoveNotify other) {
                if (other == SceneEntityMoveNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getReliableSeq() != 0) {
                    setReliableSeq(other.getReliableSeq());
                }
                if (other.getSceneTime() != 0) {
                    setSceneTime(other.getSceneTime());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.hasMotionInfo()) {
                    mergeMotionInfo(other.getMotionInfo());
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
                SceneEntityMoveNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneEntityMoveNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneEntityMoveNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
            public int getReliableSeq() {
                return this.reliableSeq_;
            }

            public Builder setReliableSeq(int value) {
                this.reliableSeq_ = value;
                onChanged();
                return this;
            }

            public Builder clearReliableSeq() {
                this.reliableSeq_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
            public int getSceneTime() {
                return this.sceneTime_;
            }

            public Builder setSceneTime(int value) {
                this.sceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneTime() {
                this.sceneTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
            public boolean hasMotionInfo() {
                return (this.motionInfoBuilder_ == null && this.motionInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
            public MotionInfoOuterClass.MotionInfo getMotionInfo() {
                if (this.motionInfoBuilder_ == null) {
                    return this.motionInfo_ == null ? MotionInfoOuterClass.MotionInfo.getDefaultInstance() : this.motionInfo_;
                }
                return this.motionInfoBuilder_.getMessage();
            }

            public Builder setMotionInfo(MotionInfoOuterClass.MotionInfo value) {
                if (this.motionInfoBuilder_ != null) {
                    this.motionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.motionInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMotionInfo(MotionInfoOuterClass.MotionInfo.Builder builderForValue) {
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.motionInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMotionInfo(MotionInfoOuterClass.MotionInfo value) {
                if (this.motionInfoBuilder_ == null) {
                    if (this.motionInfo_ != null) {
                        this.motionInfo_ = MotionInfoOuterClass.MotionInfo.newBuilder(this.motionInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.motionInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.motionInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMotionInfo() {
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfo_ = null;
                    onChanged();
                } else {
                    this.motionInfo_ = null;
                    this.motionInfoBuilder_ = null;
                }
                return this;
            }

            public MotionInfoOuterClass.MotionInfo.Builder getMotionInfoBuilder() {
                onChanged();
                return getMotionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneEntityMoveNotifyOuterClass.SceneEntityMoveNotifyOrBuilder
            public MotionInfoOuterClass.MotionInfoOrBuilder getMotionInfoOrBuilder() {
                if (this.motionInfoBuilder_ != null) {
                    return this.motionInfoBuilder_.getMessageOrBuilder();
                }
                return this.motionInfo_ == null ? MotionInfoOuterClass.MotionInfo.getDefaultInstance() : this.motionInfo_;
            }

            private SingleFieldBuilderV3<MotionInfoOuterClass.MotionInfo, MotionInfoOuterClass.MotionInfo.Builder, MotionInfoOuterClass.MotionInfoOrBuilder> getMotionInfoFieldBuilder() {
                if (this.motionInfoBuilder_ == null) {
                    this.motionInfoBuilder_ = new SingleFieldBuilderV3<>(getMotionInfo(), getParentForChildren(), isClean());
                    this.motionInfo_ = null;
                }
                return this.motionInfoBuilder_;
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

        public static SceneEntityMoveNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneEntityMoveNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneEntityMoveNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneEntityMoveNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MotionInfoOuterClass.getDescriptor();
    }
}
