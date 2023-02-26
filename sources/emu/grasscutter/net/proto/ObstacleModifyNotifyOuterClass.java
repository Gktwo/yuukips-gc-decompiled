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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleModifyNotifyOuterClass.class */
public final class ObstacleModifyNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aObstacleModifyNotify.proto\u001a\u0012ObstacleInfo.proto\"g\n\u0014ObstacleModifyNotify\u0012#\n\faddObstacles\u0018\u000e \u0003(\u000b2\r.ObstacleInfo\u0012\u0019\n\u0011removeObstacleIds\u0018\u0007 \u0003(\u0005\u0012\u000f\n\u0007sceneId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ObstacleInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ObstacleModifyNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ObstacleModifyNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ObstacleModifyNotify_descriptor, new String[]{"AddObstacles", "RemoveObstacleIds", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleModifyNotifyOuterClass$ObstacleModifyNotifyOrBuilder.class */
    public interface ObstacleModifyNotifyOrBuilder extends MessageOrBuilder {
        List<ObstacleInfoOuterClass.ObstacleInfo> getAddObstaclesList();

        ObstacleInfoOuterClass.ObstacleInfo getAddObstacles(int i);

        int getAddObstaclesCount();

        List<? extends ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getAddObstaclesOrBuilderList();

        ObstacleInfoOuterClass.ObstacleInfoOrBuilder getAddObstaclesOrBuilder(int i);

        List<Integer> getRemoveObstacleIdsList();

        int getRemoveObstacleIdsCount();

        int getRemoveObstacleIds(int i);

        int getSceneId();
    }

    private ObstacleModifyNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleModifyNotifyOuterClass$ObstacleModifyNotify.class */
    public static final class ObstacleModifyNotify extends GeneratedMessageV3 implements ObstacleModifyNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ADDOBSTACLES_FIELD_NUMBER = 14;
        private List<ObstacleInfoOuterClass.ObstacleInfo> addObstacles_;
        public static final int REMOVEOBSTACLEIDS_FIELD_NUMBER = 7;
        private Internal.IntList removeObstacleIds_;
        private int removeObstacleIdsMemoizedSerializedSize;
        public static final int SCENEID_FIELD_NUMBER = 9;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final ObstacleModifyNotify DEFAULT_INSTANCE = new ObstacleModifyNotify();
        private static final Parser<ObstacleModifyNotify> PARSER = new AbstractParser<ObstacleModifyNotify>() { // from class: emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotify.1
            @Override // com.google.protobuf.Parser
            public ObstacleModifyNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ObstacleModifyNotify(input, extensionRegistry);
            }
        };

        private ObstacleModifyNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.removeObstacleIdsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ObstacleModifyNotify() {
            this.removeObstacleIdsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.addObstacles_ = Collections.emptyList();
            this.removeObstacleIds_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ObstacleModifyNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x010d */
        private ObstacleModifyNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 56:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.removeObstacleIds_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.removeObstacleIds_.addInt(input.readInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.removeObstacleIds_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.removeObstacleIds_.addInt(input.readInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 72:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.addObstacles_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.addObstacles_.add((ObstacleInfoOuterClass.ObstacleInfo) input.readMessage(ObstacleInfoOuterClass.ObstacleInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.removeObstacleIds_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.addObstacles_ = Collections.unmodifiableList(this.addObstacles_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ObstacleModifyNotifyOuterClass.internal_static_ObstacleModifyNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ObstacleModifyNotifyOuterClass.internal_static_ObstacleModifyNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ObstacleModifyNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public List<ObstacleInfoOuterClass.ObstacleInfo> getAddObstaclesList() {
            return this.addObstacles_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public List<? extends ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getAddObstaclesOrBuilderList() {
            return this.addObstacles_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public int getAddObstaclesCount() {
            return this.addObstacles_.size();
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public ObstacleInfoOuterClass.ObstacleInfo getAddObstacles(int index) {
            return this.addObstacles_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public ObstacleInfoOuterClass.ObstacleInfoOrBuilder getAddObstaclesOrBuilder(int index) {
            return this.addObstacles_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public List<Integer> getRemoveObstacleIdsList() {
            return this.removeObstacleIds_;
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public int getRemoveObstacleIdsCount() {
            return this.removeObstacleIds_.size();
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public int getRemoveObstacleIds(int index) {
            return this.removeObstacleIds_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (getRemoveObstacleIdsList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.removeObstacleIdsMemoizedSerializedSize);
            }
            for (int i = 0; i < this.removeObstacleIds_.size(); i++) {
                output.writeInt32NoTag(this.removeObstacleIds_.getInt(i));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(9, this.sceneId_);
            }
            for (int i2 = 0; i2 < this.addObstacles_.size(); i2++) {
                output.writeMessage(14, this.addObstacles_.get(i2));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.removeObstacleIds_.size(); i++) {
                dataSize += CodedOutputStream.computeInt32SizeNoTag(this.removeObstacleIds_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getRemoveObstacleIdsList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.removeObstacleIdsMemoizedSerializedSize = dataSize;
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.sceneId_);
            }
            for (int i2 = 0; i2 < this.addObstacles_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.addObstacles_.get(i2));
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
            if (!(obj instanceof ObstacleModifyNotify)) {
                return equals(obj);
            }
            ObstacleModifyNotify other = (ObstacleModifyNotify) obj;
            return getAddObstaclesList().equals(other.getAddObstaclesList()) && getRemoveObstacleIdsList().equals(other.getRemoveObstacleIdsList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAddObstaclesCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getAddObstaclesList().hashCode();
            }
            if (getRemoveObstacleIdsCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getRemoveObstacleIdsList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ObstacleModifyNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ObstacleModifyNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObstacleModifyNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ObstacleModifyNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObstacleModifyNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ObstacleModifyNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ObstacleModifyNotify parseFrom(InputStream input) throws IOException {
            return (ObstacleModifyNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ObstacleModifyNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObstacleModifyNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ObstacleModifyNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ObstacleModifyNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ObstacleModifyNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObstacleModifyNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ObstacleModifyNotify parseFrom(CodedInputStream input) throws IOException {
            return (ObstacleModifyNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ObstacleModifyNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObstacleModifyNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ObstacleModifyNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ObstacleModifyNotifyOuterClass$ObstacleModifyNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ObstacleModifyNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ObstacleInfoOuterClass.ObstacleInfo, ObstacleInfoOuterClass.ObstacleInfo.Builder, ObstacleInfoOuterClass.ObstacleInfoOrBuilder> addObstaclesBuilder_;
            private int sceneId_;
            private List<ObstacleInfoOuterClass.ObstacleInfo> addObstacles_ = Collections.emptyList();
            private Internal.IntList removeObstacleIds_ = ObstacleModifyNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ObstacleModifyNotifyOuterClass.internal_static_ObstacleModifyNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ObstacleModifyNotifyOuterClass.internal_static_ObstacleModifyNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ObstacleModifyNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ObstacleModifyNotify.alwaysUseFieldBuilders) {
                    getAddObstaclesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.addObstaclesBuilder_ == null) {
                    this.addObstacles_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.addObstaclesBuilder_.clear();
                }
                this.removeObstacleIds_ = ObstacleModifyNotify.emptyIntList();
                this.bitField0_ &= -3;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ObstacleModifyNotifyOuterClass.internal_static_ObstacleModifyNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ObstacleModifyNotify getDefaultInstanceForType() {
                return ObstacleModifyNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ObstacleModifyNotify build() {
                ObstacleModifyNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ObstacleModifyNotify buildPartial() {
                ObstacleModifyNotify result = new ObstacleModifyNotify(this);
                int i = this.bitField0_;
                if (this.addObstaclesBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.addObstacles_ = Collections.unmodifiableList(this.addObstacles_);
                        this.bitField0_ &= -2;
                    }
                    result.addObstacles_ = this.addObstacles_;
                } else {
                    result.addObstacles_ = this.addObstaclesBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.removeObstacleIds_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.removeObstacleIds_ = this.removeObstacleIds_;
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof ObstacleModifyNotify) {
                    return mergeFrom((ObstacleModifyNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ObstacleModifyNotify other) {
                if (other == ObstacleModifyNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.addObstaclesBuilder_ == null) {
                    if (!other.addObstacles_.isEmpty()) {
                        if (this.addObstacles_.isEmpty()) {
                            this.addObstacles_ = other.addObstacles_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAddObstaclesIsMutable();
                            this.addObstacles_.addAll(other.addObstacles_);
                        }
                        onChanged();
                    }
                } else if (!other.addObstacles_.isEmpty()) {
                    if (this.addObstaclesBuilder_.isEmpty()) {
                        this.addObstaclesBuilder_.dispose();
                        this.addObstaclesBuilder_ = null;
                        this.addObstacles_ = other.addObstacles_;
                        this.bitField0_ &= -2;
                        this.addObstaclesBuilder_ = ObstacleModifyNotify.alwaysUseFieldBuilders ? getAddObstaclesFieldBuilder() : null;
                    } else {
                        this.addObstaclesBuilder_.addAllMessages(other.addObstacles_);
                    }
                }
                if (!other.removeObstacleIds_.isEmpty()) {
                    if (this.removeObstacleIds_.isEmpty()) {
                        this.removeObstacleIds_ = other.removeObstacleIds_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureRemoveObstacleIdsIsMutable();
                        this.removeObstacleIds_.addAll(other.removeObstacleIds_);
                    }
                    onChanged();
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                ObstacleModifyNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ObstacleModifyNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ObstacleModifyNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAddObstaclesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.addObstacles_ = new ArrayList(this.addObstacles_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public List<ObstacleInfoOuterClass.ObstacleInfo> getAddObstaclesList() {
                if (this.addObstaclesBuilder_ == null) {
                    return Collections.unmodifiableList(this.addObstacles_);
                }
                return this.addObstaclesBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public int getAddObstaclesCount() {
                if (this.addObstaclesBuilder_ == null) {
                    return this.addObstacles_.size();
                }
                return this.addObstaclesBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public ObstacleInfoOuterClass.ObstacleInfo getAddObstacles(int index) {
                if (this.addObstaclesBuilder_ == null) {
                    return this.addObstacles_.get(index);
                }
                return this.addObstaclesBuilder_.getMessage(index);
            }

            public Builder setAddObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo value) {
                if (this.addObstaclesBuilder_ != null) {
                    this.addObstaclesBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAddObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo.Builder builderForValue) {
                if (this.addObstaclesBuilder_ == null) {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.addObstaclesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAddObstacles(ObstacleInfoOuterClass.ObstacleInfo value) {
                if (this.addObstaclesBuilder_ != null) {
                    this.addObstaclesBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAddObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo value) {
                if (this.addObstaclesBuilder_ != null) {
                    this.addObstaclesBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAddObstacles(ObstacleInfoOuterClass.ObstacleInfo.Builder builderForValue) {
                if (this.addObstaclesBuilder_ == null) {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.addObstaclesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAddObstacles(int index, ObstacleInfoOuterClass.ObstacleInfo.Builder builderForValue) {
                if (this.addObstaclesBuilder_ == null) {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.addObstaclesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAddObstacles(Iterable<? extends ObstacleInfoOuterClass.ObstacleInfo> values) {
                if (this.addObstaclesBuilder_ == null) {
                    ensureAddObstaclesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.addObstacles_);
                    onChanged();
                } else {
                    this.addObstaclesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAddObstacles() {
                if (this.addObstaclesBuilder_ == null) {
                    this.addObstacles_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.addObstaclesBuilder_.clear();
                }
                return this;
            }

            public Builder removeAddObstacles(int index) {
                if (this.addObstaclesBuilder_ == null) {
                    ensureAddObstaclesIsMutable();
                    this.addObstacles_.remove(index);
                    onChanged();
                } else {
                    this.addObstaclesBuilder_.remove(index);
                }
                return this;
            }

            public ObstacleInfoOuterClass.ObstacleInfo.Builder getAddObstaclesBuilder(int index) {
                return getAddObstaclesFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public ObstacleInfoOuterClass.ObstacleInfoOrBuilder getAddObstaclesOrBuilder(int index) {
                if (this.addObstaclesBuilder_ == null) {
                    return this.addObstacles_.get(index);
                }
                return this.addObstaclesBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public List<? extends ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getAddObstaclesOrBuilderList() {
                if (this.addObstaclesBuilder_ != null) {
                    return this.addObstaclesBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.addObstacles_);
            }

            public ObstacleInfoOuterClass.ObstacleInfo.Builder addAddObstaclesBuilder() {
                return getAddObstaclesFieldBuilder().addBuilder(ObstacleInfoOuterClass.ObstacleInfo.getDefaultInstance());
            }

            public ObstacleInfoOuterClass.ObstacleInfo.Builder addAddObstaclesBuilder(int index) {
                return getAddObstaclesFieldBuilder().addBuilder(index, ObstacleInfoOuterClass.ObstacleInfo.getDefaultInstance());
            }

            public List<ObstacleInfoOuterClass.ObstacleInfo.Builder> getAddObstaclesBuilderList() {
                return getAddObstaclesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ObstacleInfoOuterClass.ObstacleInfo, ObstacleInfoOuterClass.ObstacleInfo.Builder, ObstacleInfoOuterClass.ObstacleInfoOrBuilder> getAddObstaclesFieldBuilder() {
                if (this.addObstaclesBuilder_ == null) {
                    this.addObstaclesBuilder_ = new RepeatedFieldBuilderV3<>(this.addObstacles_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.addObstacles_ = null;
                }
                return this.addObstaclesBuilder_;
            }

            private void ensureRemoveObstacleIdsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.removeObstacleIds_ = ObstacleModifyNotify.mutableCopy(this.removeObstacleIds_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public List<Integer> getRemoveObstacleIdsList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.removeObstacleIds_) : this.removeObstacleIds_;
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public int getRemoveObstacleIdsCount() {
                return this.removeObstacleIds_.size();
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
            public int getRemoveObstacleIds(int index) {
                return this.removeObstacleIds_.getInt(index);
            }

            public Builder setRemoveObstacleIds(int index, int value) {
                ensureRemoveObstacleIdsIsMutable();
                this.removeObstacleIds_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRemoveObstacleIds(int value) {
                ensureRemoveObstacleIdsIsMutable();
                this.removeObstacleIds_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRemoveObstacleIds(Iterable<? extends Integer> values) {
                ensureRemoveObstacleIdsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.removeObstacleIds_);
                onChanged();
                return this;
            }

            public Builder clearRemoveObstacleIds() {
                this.removeObstacleIds_ = ObstacleModifyNotify.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ObstacleModifyNotifyOuterClass.ObstacleModifyNotifyOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ObstacleModifyNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ObstacleModifyNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ObstacleModifyNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ObstacleModifyNotify getDefaultInstanceForType() {
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
