package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ObstacleInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PathfindingEnterSceneReqOuterClass.class */
public final class PathfindingEnterSceneReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001ePathfindingEnterSceneReq.proto\u001a\u0012ObstacleInfo.proto\"¾\u0001\n\u0018PathfindingEnterSceneReq\u0012\u0012\n\nactivityId\u0018\b \u0003(\r\u0012\u001b\n\u0013Unk3300_JHLKDOHPIFB\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007sceneId\u0018\u000b \u0001(\r\u0012\u0010\n\bisEditor\u0018\r \u0001(\b\u0012\u000f\n\u0007version\u0018\u0006 \u0001(\r\u0012\u001b\n\u0013Unk3300_MGGFOILELKH\u0018\u0003 \u0001(\r\u0012 \n\tobstacles\u0018\n \u0003(\u000b2\r.ObstacleInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ObstacleInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PathfindingEnterSceneReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PathfindingEnterSceneReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PathfindingEnterSceneReq_descriptor, new String[]{"ActivityId", "Unk3300JHLKDOHPIFB", "SceneId", "IsEditor", "Version", "Unk3300MGGFOILELKH", "Obstacles"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PathfindingEnterSceneReqOuterClass$PathfindingEnterSceneReqOrBuilder.class */
    public interface PathfindingEnterSceneReqOrBuilder extends MessageOrBuilder {
        List<Integer> getActivityIdList();

        int getActivityIdCount();

        int getActivityId(int i);

        int getUnk3300JHLKDOHPIFB();

        int getSceneId();

        boolean getIsEditor();

        int getVersion();

        int getUnk3300MGGFOILELKH();

        List<ObstacleInfoOuterClass.ObstacleInfo> getObstaclesList();

        ObstacleInfoOuterClass.ObstacleInfo getObstacles(int i);

        int getObstaclesCount();

        List<? extends ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getObstaclesOrBuilderList();

        ObstacleInfoOuterClass.ObstacleInfoOrBuilder getObstaclesOrBuilder(int i);
    }

    private PathfindingEnterSceneReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PathfindingEnterSceneReqOuterClass$PathfindingEnterSceneReq.class */
    public static final class PathfindingEnterSceneReq extends GeneratedMessageV3 implements PathfindingEnterSceneReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITYID_FIELD_NUMBER = 8;
        private Internal.IntList activityId_;
        private int activityIdMemoizedSerializedSize;
        public static final int UNK3300_JHLKDOHPIFB_FIELD_NUMBER = 1;
        private int unk3300JHLKDOHPIFB_;
        public static final int SCENEID_FIELD_NUMBER = 11;
        private int sceneId_;
        public static final int ISEDITOR_FIELD_NUMBER = 13;
        private boolean isEditor_;
        public static final int VERSION_FIELD_NUMBER = 6;
        private int version_;
        public static final int UNK3300_MGGFOILELKH_FIELD_NUMBER = 3;
        private int unk3300MGGFOILELKH_;
        public static final int OBSTACLES_FIELD_NUMBER = 10;
        private List<ObstacleInfoOuterClass.ObstacleInfo> obstacles_;
        private byte memoizedIsInitialized;
        private static final PathfindingEnterSceneReq DEFAULT_INSTANCE = new PathfindingEnterSceneReq();
        private static final Parser<PathfindingEnterSceneReq> PARSER = new AbstractParser<PathfindingEnterSceneReq>() { // from class: emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReq.1
            @Override // com.google.protobuf.Parser
            public PathfindingEnterSceneReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PathfindingEnterSceneReq(input, extensionRegistry);
            }
        };

        private PathfindingEnterSceneReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.activityIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PathfindingEnterSceneReq() {
            this.activityIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.activityId_ = emptyIntList();
            this.obstacles_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PathfindingEnterSceneReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x0159 */
        private PathfindingEnterSceneReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.unk3300JHLKDOHPIFB_ = input.readUInt32();
                                break;
                            case 24:
                                this.unk3300MGGFOILELKH_ = input.readUInt32();
                                break;
                            case 48:
                                this.version_ = input.readUInt32();
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.activityId_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.activityId_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.activityId_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.activityId_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.obstacles_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.obstacles_.add((ObstacleInfoOuterClass.ObstacleInfo) input.readMessage(ObstacleInfoOuterClass.ObstacleInfo.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 104:
                                this.isEditor_ = input.readBool();
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.activityId_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.obstacles_ = Collections.unmodifiableList(this.obstacles_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PathfindingEnterSceneReqOuterClass.internal_static_PathfindingEnterSceneReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PathfindingEnterSceneReqOuterClass.internal_static_PathfindingEnterSceneReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PathfindingEnterSceneReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public List<Integer> getActivityIdList() {
            return this.activityId_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getActivityIdCount() {
            return this.activityId_.size();
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getActivityId(int index) {
            return this.activityId_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getUnk3300JHLKDOHPIFB() {
            return this.unk3300JHLKDOHPIFB_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public boolean getIsEditor() {
            return this.isEditor_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getUnk3300MGGFOILELKH() {
            return this.unk3300MGGFOILELKH_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public List<ObstacleInfoOuterClass.ObstacleInfo> getObstaclesList() {
            return this.obstacles_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public List<? extends ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getObstaclesOrBuilderList() {
            return this.obstacles_;
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public int getObstaclesCount() {
            return this.obstacles_.size();
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public ObstacleInfoOuterClass.ObstacleInfo getObstacles(int index) {
            return this.obstacles_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
        public ObstacleInfoOuterClass.ObstacleInfoOrBuilder getObstaclesOrBuilder(int index) {
            return this.obstacles_.get(index);
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
            getSerializedSize();
            if (this.unk3300JHLKDOHPIFB_ != 0) {
                output.writeUInt32(1, this.unk3300JHLKDOHPIFB_);
            }
            if (this.unk3300MGGFOILELKH_ != 0) {
                output.writeUInt32(3, this.unk3300MGGFOILELKH_);
            }
            if (this.version_ != 0) {
                output.writeUInt32(6, this.version_);
            }
            if (getActivityIdList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.activityIdMemoizedSerializedSize);
            }
            for (int i = 0; i < this.activityId_.size(); i++) {
                output.writeUInt32NoTag(this.activityId_.getInt(i));
            }
            for (int i2 = 0; i2 < this.obstacles_.size(); i2++) {
                output.writeMessage(10, this.obstacles_.get(i2));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(11, this.sceneId_);
            }
            if (this.isEditor_) {
                output.writeBool(13, this.isEditor_);
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
            if (this.unk3300JHLKDOHPIFB_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300JHLKDOHPIFB_);
            }
            if (this.unk3300MGGFOILELKH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unk3300MGGFOILELKH_);
            }
            if (this.version_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.version_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.activityId_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.activityId_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getActivityIdList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.activityIdMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.obstacles_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(10, this.obstacles_.get(i2));
            }
            if (this.sceneId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.sceneId_);
            }
            if (this.isEditor_) {
                size3 += CodedOutputStream.computeBoolSize(13, this.isEditor_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PathfindingEnterSceneReq)) {
                return equals(obj);
            }
            PathfindingEnterSceneReq other = (PathfindingEnterSceneReq) obj;
            return getActivityIdList().equals(other.getActivityIdList()) && getUnk3300JHLKDOHPIFB() == other.getUnk3300JHLKDOHPIFB() && getSceneId() == other.getSceneId() && getIsEditor() == other.getIsEditor() && getVersion() == other.getVersion() && getUnk3300MGGFOILELKH() == other.getUnk3300MGGFOILELKH() && getObstaclesList().equals(other.getObstaclesList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getActivityIdCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getActivityIdList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getUnk3300JHLKDOHPIFB())) + 11)) + getSceneId())) + 13)) + Internal.hashBoolean(getIsEditor()))) + 6)) + getVersion())) + 3)) + getUnk3300MGGFOILELKH();
            if (getObstaclesCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getObstaclesList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PathfindingEnterSceneReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PathfindingEnterSceneReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PathfindingEnterSceneReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PathfindingEnterSceneReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PathfindingEnterSceneReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PathfindingEnterSceneReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PathfindingEnterSceneReq parseFrom(InputStream input) throws IOException {
            return (PathfindingEnterSceneReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PathfindingEnterSceneReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PathfindingEnterSceneReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PathfindingEnterSceneReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PathfindingEnterSceneReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PathfindingEnterSceneReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PathfindingEnterSceneReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PathfindingEnterSceneReq parseFrom(CodedInputStream input) throws IOException {
            return (PathfindingEnterSceneReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PathfindingEnterSceneReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PathfindingEnterSceneReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PathfindingEnterSceneReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PathfindingEnterSceneReqOuterClass$PathfindingEnterSceneReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PathfindingEnterSceneReqOrBuilder {
            private int bitField0_;
            private int unk3300JHLKDOHPIFB_;
            private int sceneId_;
            private boolean isEditor_;
            private int version_;
            private int unk3300MGGFOILELKH_;
            private RepeatedFieldBuilderV3<ObstacleInfoOuterClass.ObstacleInfo, ObstacleInfoOuterClass.ObstacleInfo.Builder, ObstacleInfoOuterClass.ObstacleInfoOrBuilder> obstaclesBuilder_;
            private Internal.IntList activityId_ = PathfindingEnterSceneReq.emptyIntList();
            private List<ObstacleInfoOuterClass.ObstacleInfo> obstacles_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PathfindingEnterSceneReqOuterClass.internal_static_PathfindingEnterSceneReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PathfindingEnterSceneReqOuterClass.internal_static_PathfindingEnterSceneReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PathfindingEnterSceneReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PathfindingEnterSceneReq.alwaysUseFieldBuilders) {
                    getObstaclesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activityId_ = PathfindingEnterSceneReq.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300JHLKDOHPIFB_ = 0;
                this.sceneId_ = 0;
                this.isEditor_ = false;
                this.version_ = 0;
                this.unk3300MGGFOILELKH_ = 0;
                if (this.obstaclesBuilder_ == null) {
                    this.obstacles_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.obstaclesBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PathfindingEnterSceneReqOuterClass.internal_static_PathfindingEnterSceneReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PathfindingEnterSceneReq getDefaultInstanceForType() {
                return PathfindingEnterSceneReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PathfindingEnterSceneReq build() {
                PathfindingEnterSceneReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PathfindingEnterSceneReq buildPartial() {
                PathfindingEnterSceneReq result = new PathfindingEnterSceneReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.activityId_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.activityId_ = this.activityId_;
                result.unk3300JHLKDOHPIFB_ = this.unk3300JHLKDOHPIFB_;
                result.sceneId_ = this.sceneId_;
                result.isEditor_ = this.isEditor_;
                result.version_ = this.version_;
                result.unk3300MGGFOILELKH_ = this.unk3300MGGFOILELKH_;
                if (this.obstaclesBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.obstacles_ = Collections.unmodifiableList(this.obstacles_);
                        this.bitField0_ &= -3;
                    }
                    result.obstacles_ = this.obstacles_;
                } else {
                    result.obstacles_ = this.obstaclesBuilder_.build();
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
                if (other instanceof PathfindingEnterSceneReq) {
                    return mergeFrom((PathfindingEnterSceneReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PathfindingEnterSceneReq other) {
                if (other == PathfindingEnterSceneReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.activityId_.isEmpty()) {
                    if (this.activityId_.isEmpty()) {
                        this.activityId_ = other.activityId_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureActivityIdIsMutable();
                        this.activityId_.addAll(other.activityId_);
                    }
                    onChanged();
                }
                if (other.getUnk3300JHLKDOHPIFB() != 0) {
                    setUnk3300JHLKDOHPIFB(other.getUnk3300JHLKDOHPIFB());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getIsEditor()) {
                    setIsEditor(other.getIsEditor());
                }
                if (other.getVersion() != 0) {
                    setVersion(other.getVersion());
                }
                if (other.getUnk3300MGGFOILELKH() != 0) {
                    setUnk3300MGGFOILELKH(other.getUnk3300MGGFOILELKH());
                }
                if (this.obstaclesBuilder_ == null) {
                    if (!other.obstacles_.isEmpty()) {
                        if (this.obstacles_.isEmpty()) {
                            this.obstacles_ = other.obstacles_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureObstaclesIsMutable();
                            this.obstacles_.addAll(other.obstacles_);
                        }
                        onChanged();
                    }
                } else if (!other.obstacles_.isEmpty()) {
                    if (this.obstaclesBuilder_.isEmpty()) {
                        this.obstaclesBuilder_.dispose();
                        this.obstaclesBuilder_ = null;
                        this.obstacles_ = other.obstacles_;
                        this.bitField0_ &= -3;
                        this.obstaclesBuilder_ = PathfindingEnterSceneReq.alwaysUseFieldBuilders ? getObstaclesFieldBuilder() : null;
                    } else {
                        this.obstaclesBuilder_.addAllMessages(other.obstacles_);
                    }
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
                PathfindingEnterSceneReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PathfindingEnterSceneReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PathfindingEnterSceneReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureActivityIdIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.activityId_ = PathfindingEnterSceneReq.mutableCopy(this.activityId_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public List<Integer> getActivityIdList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.activityId_) : this.activityId_;
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public int getActivityIdCount() {
                return this.activityId_.size();
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public int getActivityId(int index) {
                return this.activityId_.getInt(index);
            }

            public Builder setActivityId(int index, int value) {
                ensureActivityIdIsMutable();
                this.activityId_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addActivityId(int value) {
                ensureActivityIdIsMutable();
                this.activityId_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllActivityId(Iterable<? extends Integer> values) {
                ensureActivityIdIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activityId_);
                onChanged();
                return this;
            }

            public Builder clearActivityId() {
                this.activityId_ = PathfindingEnterSceneReq.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public int getUnk3300JHLKDOHPIFB() {
                return this.unk3300JHLKDOHPIFB_;
            }

            public Builder setUnk3300JHLKDOHPIFB(int value) {
                this.unk3300JHLKDOHPIFB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JHLKDOHPIFB() {
                this.unk3300JHLKDOHPIFB_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public boolean getIsEditor() {
                return this.isEditor_;
            }

            public Builder setIsEditor(boolean value) {
                this.isEditor_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEditor() {
                this.isEditor_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public int getVersion() {
                return this.version_;
            }

            public Builder setVersion(int value) {
                this.version_ = value;
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.version_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public int getUnk3300MGGFOILELKH() {
                return this.unk3300MGGFOILELKH_;
            }

            public Builder setUnk3300MGGFOILELKH(int value) {
                this.unk3300MGGFOILELKH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MGGFOILELKH() {
                this.unk3300MGGFOILELKH_ = 0;
                onChanged();
                return this;
            }

            private void ensureObstaclesIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.obstacles_ = new ArrayList(this.obstacles_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public List<ObstacleInfoOuterClass.ObstacleInfo> getObstaclesList() {
                if (this.obstaclesBuilder_ == null) {
                    return Collections.unmodifiableList(this.obstacles_);
                }
                return this.obstaclesBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public int getObstaclesCount() {
                if (this.obstaclesBuilder_ == null) {
                    return this.obstacles_.size();
                }
                return this.obstaclesBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public ObstacleInfoOuterClass.ObstacleInfo getObstacles(int index) {
                if (this.obstaclesBuilder_ == null) {
                    return this.obstacles_.get(index);
                }
                return this.obstaclesBuilder_.getMessage(index);
            }

            public Builder setObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo value) {
                if (this.obstaclesBuilder_ != null) {
                    this.obstaclesBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureObstaclesIsMutable();
                    this.obstacles_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo.Builder builderForValue) {
                if (this.obstaclesBuilder_ == null) {
                    ensureObstaclesIsMutable();
                    this.obstacles_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.obstaclesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addObstacles(ObstacleInfoOuterClass.ObstacleInfo value) {
                if (this.obstaclesBuilder_ != null) {
                    this.obstaclesBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureObstaclesIsMutable();
                    this.obstacles_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo value) {
                if (this.obstaclesBuilder_ != null) {
                    this.obstaclesBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureObstaclesIsMutable();
                    this.obstacles_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addObstacles(ObstacleInfoOuterClass.ObstacleInfo.Builder builderForValue) {
                if (this.obstaclesBuilder_ == null) {
                    ensureObstaclesIsMutable();
                    this.obstacles_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.obstaclesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo.Builder builderForValue) {
                if (this.obstaclesBuilder_ == null) {
                    ensureObstaclesIsMutable();
                    this.obstacles_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.obstaclesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllObstacles(Iterable<? extends ObstacleInfoOuterClass.ObstacleInfo> values) {
                if (this.obstaclesBuilder_ == null) {
                    ensureObstaclesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.obstacles_);
                    onChanged();
                } else {
                    this.obstaclesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearObstacles() {
                if (this.obstaclesBuilder_ == null) {
                    this.obstacles_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.obstaclesBuilder_.clear();
                }
                return this;
            }

            public Builder removeObstacles(int index) {
                if (this.obstaclesBuilder_ == null) {
                    ensureObstaclesIsMutable();
                    this.obstacles_.remove(index);
                    onChanged();
                } else {
                    this.obstaclesBuilder_.remove(index);
                }
                return this;
            }

            public ObstacleInfoOuterClass.ObstacleInfo.Builder getObstaclesBuilder(int index) {
                return getObstaclesFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public ObstacleInfoOuterClass.ObstacleInfoOrBuilder getObstaclesOrBuilder(int index) {
                if (this.obstaclesBuilder_ == null) {
                    return this.obstacles_.get(index);
                }
                return this.obstaclesBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PathfindingEnterSceneReqOuterClass.PathfindingEnterSceneReqOrBuilder
            public List<? extends ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getObstaclesOrBuilderList() {
                if (this.obstaclesBuilder_ != null) {
                    return this.obstaclesBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.obstacles_);
            }

            public ObstacleInfoOuterClass.ObstacleInfo.Builder addObstaclesBuilder() {
                return getObstaclesFieldBuilder().addBuilder(ObstacleInfoOuterClass.ObstacleInfo.getDefaultInstance());
            }

            public ObstacleInfoOuterClass.ObstacleInfo.Builder addObstaclesBuilder(int index) {
                return getObstaclesFieldBuilder().addBuilder(index, ObstacleInfoOuterClass.ObstacleInfo.getDefaultInstance());
            }

            public List<ObstacleInfoOuterClass.ObstacleInfo.Builder> getObstaclesBuilderList() {
                return getObstaclesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ObstacleInfoOuterClass.ObstacleInfo, ObstacleInfoOuterClass.ObstacleInfo.Builder, ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getObstaclesFieldBuilder() {
                if (this.obstaclesBuilder_ == null) {
                    this.obstaclesBuilder_ = new RepeatedFieldBuilderV3<>(this.obstacles_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.obstacles_ = null;
                }
                return this.obstaclesBuilder_;
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

        public static PathfindingEnterSceneReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PathfindingEnterSceneReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PathfindingEnterSceneReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PathfindingEnterSceneReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ObstacleInfoOuterClass.getDescriptor();
    }
}
