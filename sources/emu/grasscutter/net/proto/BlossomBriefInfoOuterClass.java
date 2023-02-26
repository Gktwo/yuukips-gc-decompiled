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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlossomBriefInfoOuterClass.class */
public final class BlossomBriefInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016BlossomBriefInfo.proto\u001a\fVector.proto\"Ï\u0001\n\u0010BlossomBriefInfo\u0012\u0015\n\risGuideOpened\u0018\u0006 \u0001(\b\u0012\r\n\u0005resin\u0018\u0003 \u0001(\r\u0012\u0014\n\u0003pos\u0018\t \u0001(\u000b2\u0007.Vector\u0012\u000f\n\u0007sceneId\u0018\r \u0001(\r\u0012\r\n\u0005state\u0018\n \u0001(\r\u0012\u000e\n\u0006cityId\u0018\b \u0001(\r\u0012\u0010\n\brewardId\u0018\u000b \u0001(\r\u0012\u0014\n\fcircleCampId\u0018\u0002 \u0001(\r\u0012\u0014\n\fmonsterLevel\u0018\u000f \u0001(\r\u0012\u0011\n\trefreshId\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BlossomBriefInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BlossomBriefInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BlossomBriefInfo_descriptor, new String[]{"IsGuideOpened", "Resin", "Pos", "SceneId", "State", "CityId", "RewardId", "CircleCampId", "MonsterLevel", "RefreshId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlossomBriefInfoOuterClass$BlossomBriefInfoOrBuilder.class */
    public interface BlossomBriefInfoOrBuilder extends MessageOrBuilder {
        boolean getIsGuideOpened();

        int getResin();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getSceneId();

        int getState();

        int getCityId();

        int getRewardId();

        int getCircleCampId();

        int getMonsterLevel();

        int getRefreshId();
    }

    private BlossomBriefInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlossomBriefInfoOuterClass$BlossomBriefInfo.class */
    public static final class BlossomBriefInfo extends GeneratedMessageV3 implements BlossomBriefInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISGUIDEOPENED_FIELD_NUMBER = 6;
        private boolean isGuideOpened_;
        public static final int RESIN_FIELD_NUMBER = 3;
        private int resin_;
        public static final int POS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector pos_;
        public static final int SCENEID_FIELD_NUMBER = 13;
        private int sceneId_;
        public static final int STATE_FIELD_NUMBER = 10;
        private int state_;
        public static final int CITYID_FIELD_NUMBER = 8;
        private int cityId_;
        public static final int REWARDID_FIELD_NUMBER = 11;
        private int rewardId_;
        public static final int CIRCLECAMPID_FIELD_NUMBER = 2;
        private int circleCampId_;
        public static final int MONSTERLEVEL_FIELD_NUMBER = 15;
        private int monsterLevel_;
        public static final int REFRESHID_FIELD_NUMBER = 5;
        private int refreshId_;
        private byte memoizedIsInitialized;
        private static final BlossomBriefInfo DEFAULT_INSTANCE = new BlossomBriefInfo();
        private static final Parser<BlossomBriefInfo> PARSER = new AbstractParser<BlossomBriefInfo>() { // from class: emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfo.1
            @Override // com.google.protobuf.Parser
            public BlossomBriefInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BlossomBriefInfo(input, extensionRegistry);
            }
        };

        private BlossomBriefInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BlossomBriefInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BlossomBriefInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BlossomBriefInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.circleCampId_ = input.readUInt32();
                                break;
                            case 24:
                                this.resin_ = input.readUInt32();
                                break;
                            case 40:
                                this.refreshId_ = input.readUInt32();
                                break;
                            case 48:
                                this.isGuideOpened_ = input.readBool();
                                break;
                            case 64:
                                this.cityId_ = input.readUInt32();
                                break;
                            case 74:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 80:
                                this.state_ = input.readUInt32();
                                break;
                            case 88:
                                this.rewardId_ = input.readUInt32();
                                break;
                            case 104:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 120:
                                this.monsterLevel_ = input.readUInt32();
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
            return BlossomBriefInfoOuterClass.internal_static_BlossomBriefInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BlossomBriefInfoOuterClass.internal_static_BlossomBriefInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlossomBriefInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public boolean getIsGuideOpened() {
            return this.isGuideOpened_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getResin() {
            return this.resin_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getCityId() {
            return this.cityId_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getRewardId() {
            return this.rewardId_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getCircleCampId() {
            return this.circleCampId_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getMonsterLevel() {
            return this.monsterLevel_;
        }

        @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
        public int getRefreshId() {
            return this.refreshId_;
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
            if (this.circleCampId_ != 0) {
                output.writeUInt32(2, this.circleCampId_);
            }
            if (this.resin_ != 0) {
                output.writeUInt32(3, this.resin_);
            }
            if (this.refreshId_ != 0) {
                output.writeUInt32(5, this.refreshId_);
            }
            if (this.isGuideOpened_) {
                output.writeBool(6, this.isGuideOpened_);
            }
            if (this.cityId_ != 0) {
                output.writeUInt32(8, this.cityId_);
            }
            if (this.pos_ != null) {
                output.writeMessage(9, getPos());
            }
            if (this.state_ != 0) {
                output.writeUInt32(10, this.state_);
            }
            if (this.rewardId_ != 0) {
                output.writeUInt32(11, this.rewardId_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(13, this.sceneId_);
            }
            if (this.monsterLevel_ != 0) {
                output.writeUInt32(15, this.monsterLevel_);
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
            if (this.circleCampId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.circleCampId_);
            }
            if (this.resin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.resin_);
            }
            if (this.refreshId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.refreshId_);
            }
            if (this.isGuideOpened_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isGuideOpened_);
            }
            if (this.cityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.cityId_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getPos());
            }
            if (this.state_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.state_);
            }
            if (this.rewardId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.rewardId_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.sceneId_);
            }
            if (this.monsterLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.monsterLevel_);
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
            if (!(obj instanceof BlossomBriefInfo)) {
                return equals(obj);
            }
            BlossomBriefInfo other = (BlossomBriefInfo) obj;
            if (getIsGuideOpened() == other.getIsGuideOpened() && getResin() == other.getResin() && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getSceneId() == other.getSceneId() && getState() == other.getState() && getCityId() == other.getCityId() && getRewardId() == other.getRewardId() && getCircleCampId() == other.getCircleCampId() && getMonsterLevel() == other.getMonsterLevel() && getRefreshId() == other.getRefreshId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashBoolean(getIsGuideOpened()))) + 3)) + getResin();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 9)) + getPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 13)) + getSceneId())) + 10)) + getState())) + 8)) + getCityId())) + 11)) + getRewardId())) + 2)) + getCircleCampId())) + 15)) + getMonsterLevel())) + 5)) + getRefreshId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BlossomBriefInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlossomBriefInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlossomBriefInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlossomBriefInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlossomBriefInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BlossomBriefInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BlossomBriefInfo parseFrom(InputStream input) throws IOException {
            return (BlossomBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlossomBriefInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlossomBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlossomBriefInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BlossomBriefInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BlossomBriefInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlossomBriefInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BlossomBriefInfo parseFrom(CodedInputStream input) throws IOException {
            return (BlossomBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BlossomBriefInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BlossomBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BlossomBriefInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BlossomBriefInfoOuterClass$BlossomBriefInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BlossomBriefInfoOrBuilder {
            private boolean isGuideOpened_;
            private int resin_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int sceneId_;
            private int state_;
            private int cityId_;
            private int rewardId_;
            private int circleCampId_;
            private int monsterLevel_;
            private int refreshId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BlossomBriefInfoOuterClass.internal_static_BlossomBriefInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BlossomBriefInfoOuterClass.internal_static_BlossomBriefInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BlossomBriefInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BlossomBriefInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isGuideOpened_ = false;
                this.resin_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.sceneId_ = 0;
                this.state_ = 0;
                this.cityId_ = 0;
                this.rewardId_ = 0;
                this.circleCampId_ = 0;
                this.monsterLevel_ = 0;
                this.refreshId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BlossomBriefInfoOuterClass.internal_static_BlossomBriefInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BlossomBriefInfo getDefaultInstanceForType() {
                return BlossomBriefInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlossomBriefInfo build() {
                BlossomBriefInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BlossomBriefInfo buildPartial() {
                BlossomBriefInfo result = new BlossomBriefInfo(this);
                result.isGuideOpened_ = this.isGuideOpened_;
                result.resin_ = this.resin_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
                result.state_ = this.state_;
                result.cityId_ = this.cityId_;
                result.rewardId_ = this.rewardId_;
                result.circleCampId_ = this.circleCampId_;
                result.monsterLevel_ = this.monsterLevel_;
                result.refreshId_ = this.refreshId_;
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
                if (other instanceof BlossomBriefInfo) {
                    return mergeFrom((BlossomBriefInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BlossomBriefInfo other) {
                if (other == BlossomBriefInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsGuideOpened()) {
                    setIsGuideOpened(other.getIsGuideOpened());
                }
                if (other.getResin() != 0) {
                    setResin(other.getResin());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getState() != 0) {
                    setState(other.getState());
                }
                if (other.getCityId() != 0) {
                    setCityId(other.getCityId());
                }
                if (other.getRewardId() != 0) {
                    setRewardId(other.getRewardId());
                }
                if (other.getCircleCampId() != 0) {
                    setCircleCampId(other.getCircleCampId());
                }
                if (other.getMonsterLevel() != 0) {
                    setMonsterLevel(other.getMonsterLevel());
                }
                if (other.getRefreshId() != 0) {
                    setRefreshId(other.getRefreshId());
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
                BlossomBriefInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BlossomBriefInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BlossomBriefInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public boolean getIsGuideOpened() {
                return this.isGuideOpened_;
            }

            public Builder setIsGuideOpened(boolean value) {
                this.isGuideOpened_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsGuideOpened() {
                this.isGuideOpened_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getResin() {
                return this.resin_;
            }

            public Builder setResin(int value) {
                this.resin_ = value;
                onChanged();
                return this;
            }

            public Builder clearResin() {
                this.resin_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getState() {
                return this.state_;
            }

            public Builder setState(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getCityId() {
                return this.cityId_;
            }

            public Builder setCityId(int value) {
                this.cityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCityId() {
                this.cityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getRewardId() {
                return this.rewardId_;
            }

            public Builder setRewardId(int value) {
                this.rewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRewardId() {
                this.rewardId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getCircleCampId() {
                return this.circleCampId_;
            }

            public Builder setCircleCampId(int value) {
                this.circleCampId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCircleCampId() {
                this.circleCampId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getMonsterLevel() {
                return this.monsterLevel_;
            }

            public Builder setMonsterLevel(int value) {
                this.monsterLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearMonsterLevel() {
                this.monsterLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BlossomBriefInfoOuterClass.BlossomBriefInfoOrBuilder
            public int getRefreshId() {
                return this.refreshId_;
            }

            public Builder setRefreshId(int value) {
                this.refreshId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRefreshId() {
                this.refreshId_ = 0;
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

        public static BlossomBriefInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BlossomBriefInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BlossomBriefInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BlossomBriefInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
