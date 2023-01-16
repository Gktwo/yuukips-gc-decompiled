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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.DungeonEntryInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryPointInfoOuterClass.class */
public final class DungeonEntryPointInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bDungeonEntryPointInfo.proto\u001a\u0016DungeonEntryInfo.proto\"\u0001\n\u0015DungeonEntryPointInfo\u0012\u0010\n\bscene_id\u0018\f \u0001(\r\u0012-\n\u0012dungeon_entry_list\u0018\u000e \u0003(\u000b2\u0011.DungeonEntryInfo\u0012\u001c\n\u0014recommend_dungeon_id\u0018\u0004 \u0001(\r\u0012\u0010\n\bpoint_id\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DungeonEntryInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonEntryPointInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonEntryPointInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonEntryPointInfo_descriptor, new String[]{"SceneId", "DungeonEntryList", "RecommendDungeonId", "PointId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryPointInfoOuterClass$DungeonEntryPointInfoOrBuilder.class */
    public interface DungeonEntryPointInfoOrBuilder extends MessageOrBuilder {
        int getSceneId();

        List<DungeonEntryInfoOuterClass.DungeonEntryInfo> getDungeonEntryListList();

        DungeonEntryInfoOuterClass.DungeonEntryInfo getDungeonEntryList(int i);

        int getDungeonEntryListCount();

        List<? extends DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListOrBuilderList();

        DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getDungeonEntryListOrBuilder(int i);

        int getRecommendDungeonId();

        int getPointId();
    }

    private DungeonEntryPointInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryPointInfoOuterClass$DungeonEntryPointInfo.class */
    public static final class DungeonEntryPointInfo extends GeneratedMessageV3 implements DungeonEntryPointInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_ID_FIELD_NUMBER = 12;
        private int sceneId_;
        public static final int DUNGEON_ENTRY_LIST_FIELD_NUMBER = 14;
        private List<DungeonEntryInfoOuterClass.DungeonEntryInfo> dungeonEntryList_;
        public static final int RECOMMEND_DUNGEON_ID_FIELD_NUMBER = 4;
        private int recommendDungeonId_;
        public static final int POINT_ID_FIELD_NUMBER = 1;
        private int pointId_;
        private byte memoizedIsInitialized;
        private static final DungeonEntryPointInfo DEFAULT_INSTANCE = new DungeonEntryPointInfo();
        private static final Parser<DungeonEntryPointInfo> PARSER = new AbstractParser<DungeonEntryPointInfo>() { // from class: emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.1
            @Override // com.google.protobuf.Parser
            public DungeonEntryPointInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonEntryPointInfo(input, extensionRegistry);
            }
        };

        private DungeonEntryPointInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DungeonEntryPointInfo() {
            this.memoizedIsInitialized = -1;
            this.dungeonEntryList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonEntryPointInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonEntryPointInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.pointId_ = input.readUInt32();
                                break;
                            case 32:
                                this.recommendDungeonId_ = input.readUInt32();
                                break;
                            case 96:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dungeonEntryList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.dungeonEntryList_.add((DungeonEntryInfoOuterClass.DungeonEntryInfo) input.readMessage(DungeonEntryInfoOuterClass.DungeonEntryInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.dungeonEntryList_ = Collections.unmodifiableList(this.dungeonEntryList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonEntryPointInfoOuterClass.internal_static_DungeonEntryPointInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonEntryPointInfoOuterClass.internal_static_DungeonEntryPointInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryPointInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public List<DungeonEntryInfoOuterClass.DungeonEntryInfo> getDungeonEntryListList() {
            return this.dungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public List<? extends DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListOrBuilderList() {
            return this.dungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public int getDungeonEntryListCount() {
            return this.dungeonEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public DungeonEntryInfoOuterClass.DungeonEntryInfo getDungeonEntryList(int index) {
            return this.dungeonEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getDungeonEntryListOrBuilder(int index) {
            return this.dungeonEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public int getRecommendDungeonId() {
            return this.recommendDungeonId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
        public int getPointId() {
            return this.pointId_;
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
            if (this.pointId_ != 0) {
                output.writeUInt32(1, this.pointId_);
            }
            if (this.recommendDungeonId_ != 0) {
                output.writeUInt32(4, this.recommendDungeonId_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(12, this.sceneId_);
            }
            for (int i = 0; i < this.dungeonEntryList_.size(); i++) {
                output.writeMessage(14, this.dungeonEntryList_.get(i));
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
            if (this.pointId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.pointId_);
            }
            if (this.recommendDungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.recommendDungeonId_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.sceneId_);
            }
            for (int i = 0; i < this.dungeonEntryList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.dungeonEntryList_.get(i));
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
            if (!(obj instanceof DungeonEntryPointInfo)) {
                return equals(obj);
            }
            DungeonEntryPointInfo other = (DungeonEntryPointInfo) obj;
            return getSceneId() == other.getSceneId() && getDungeonEntryListList().equals(other.getDungeonEntryListList()) && getRecommendDungeonId() == other.getRecommendDungeonId() && getPointId() == other.getPointId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getSceneId();
            if (getDungeonEntryListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getDungeonEntryListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getRecommendDungeonId())) + 1)) + getPointId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonEntryPointInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryPointInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryPointInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryPointInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryPointInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryPointInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryPointInfo parseFrom(InputStream input) throws IOException {
            return (DungeonEntryPointInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryPointInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryPointInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryPointInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonEntryPointInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonEntryPointInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryPointInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryPointInfo parseFrom(CodedInputStream input) throws IOException {
            return (DungeonEntryPointInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryPointInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryPointInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonEntryPointInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryPointInfoOuterClass$DungeonEntryPointInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonEntryPointInfoOrBuilder {
            private int bitField0_;
            private int sceneId_;
            private List<DungeonEntryInfoOuterClass.DungeonEntryInfo> dungeonEntryList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<DungeonEntryInfoOuterClass.DungeonEntryInfo, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder, DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> dungeonEntryListBuilder_;
            private int recommendDungeonId_;
            private int pointId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonEntryPointInfoOuterClass.internal_static_DungeonEntryPointInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonEntryPointInfoOuterClass.internal_static_DungeonEntryPointInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryPointInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonEntryPointInfo.alwaysUseFieldBuilders) {
                    getDungeonEntryListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneId_ = 0;
                if (this.dungeonEntryListBuilder_ == null) {
                    this.dungeonEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dungeonEntryListBuilder_.clear();
                }
                this.recommendDungeonId_ = 0;
                this.pointId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonEntryPointInfoOuterClass.internal_static_DungeonEntryPointInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonEntryPointInfo getDefaultInstanceForType() {
                return DungeonEntryPointInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryPointInfo build() {
                DungeonEntryPointInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryPointInfo buildPartial() {
                DungeonEntryPointInfo result = new DungeonEntryPointInfo(this);
                int i = this.bitField0_;
                result.sceneId_ = this.sceneId_;
                if (this.dungeonEntryListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dungeonEntryList_ = Collections.unmodifiableList(this.dungeonEntryList_);
                        this.bitField0_ &= -2;
                    }
                    result.dungeonEntryList_ = this.dungeonEntryList_;
                } else {
                    result.dungeonEntryList_ = this.dungeonEntryListBuilder_.build();
                }
                result.recommendDungeonId_ = this.recommendDungeonId_;
                result.pointId_ = this.pointId_;
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
                if (other instanceof DungeonEntryPointInfo) {
                    return mergeFrom((DungeonEntryPointInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonEntryPointInfo other) {
                if (other == DungeonEntryPointInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (this.dungeonEntryListBuilder_ == null) {
                    if (!other.dungeonEntryList_.isEmpty()) {
                        if (this.dungeonEntryList_.isEmpty()) {
                            this.dungeonEntryList_ = other.dungeonEntryList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDungeonEntryListIsMutable();
                            this.dungeonEntryList_.addAll(other.dungeonEntryList_);
                        }
                        onChanged();
                    }
                } else if (!other.dungeonEntryList_.isEmpty()) {
                    if (this.dungeonEntryListBuilder_.isEmpty()) {
                        this.dungeonEntryListBuilder_.dispose();
                        this.dungeonEntryListBuilder_ = null;
                        this.dungeonEntryList_ = other.dungeonEntryList_;
                        this.bitField0_ &= -2;
                        this.dungeonEntryListBuilder_ = DungeonEntryPointInfo.alwaysUseFieldBuilders ? getDungeonEntryListFieldBuilder() : null;
                    } else {
                        this.dungeonEntryListBuilder_.addAllMessages(other.dungeonEntryList_);
                    }
                }
                if (other.getRecommendDungeonId() != 0) {
                    setRecommendDungeonId(other.getRecommendDungeonId());
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
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
                DungeonEntryPointInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonEntryPointInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonEntryPointInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
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

            private void ensureDungeonEntryListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dungeonEntryList_ = new ArrayList(this.dungeonEntryList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public List<DungeonEntryInfoOuterClass.DungeonEntryInfo> getDungeonEntryListList() {
                if (this.dungeonEntryListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonEntryList_);
                }
                return this.dungeonEntryListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public int getDungeonEntryListCount() {
                if (this.dungeonEntryListBuilder_ == null) {
                    return this.dungeonEntryList_.size();
                }
                return this.dungeonEntryListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public DungeonEntryInfoOuterClass.DungeonEntryInfo getDungeonEntryList(int index) {
                if (this.dungeonEntryListBuilder_ == null) {
                    return this.dungeonEntryList_.get(index);
                }
                return this.dungeonEntryListBuilder_.getMessage(index);
            }

            public Builder setDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.dungeonEntryListBuilder_ != null) {
                    this.dungeonEntryListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonEntryList(DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.dungeonEntryListBuilder_ != null) {
                    this.dungeonEntryListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.dungeonEntryListBuilder_ != null) {
                    this.dungeonEntryListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonEntryList(DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDungeonEntryList(Iterable<? extends DungeonEntryInfoOuterClass.DungeonEntryInfo> values) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dungeonEntryList_);
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDungeonEntryList() {
                if (this.dungeonEntryListBuilder_ == null) {
                    this.dungeonEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDungeonEntryList(int index) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.remove(index);
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.remove(index);
                }
                return this;
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder getDungeonEntryListBuilder(int index) {
                return getDungeonEntryListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getDungeonEntryListOrBuilder(int index) {
                if (this.dungeonEntryListBuilder_ == null) {
                    return this.dungeonEntryList_.get(index);
                }
                return this.dungeonEntryListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public List<? extends DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListOrBuilderList() {
                if (this.dungeonEntryListBuilder_ != null) {
                    return this.dungeonEntryListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dungeonEntryList_);
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder addDungeonEntryListBuilder() {
                return getDungeonEntryListFieldBuilder().addBuilder(DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance());
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder addDungeonEntryListBuilder(int index) {
                return getDungeonEntryListFieldBuilder().addBuilder(index, DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance());
            }

            public List<DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder> getDungeonEntryListBuilderList() {
                return getDungeonEntryListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DungeonEntryInfoOuterClass.DungeonEntryInfo, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder, DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListFieldBuilder() {
                if (this.dungeonEntryListBuilder_ == null) {
                    this.dungeonEntryListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonEntryList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dungeonEntryList_ = null;
                }
                return this.dungeonEntryListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public int getRecommendDungeonId() {
                return this.recommendDungeonId_;
            }

            public Builder setRecommendDungeonId(int value) {
                this.recommendDungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecommendDungeonId() {
                this.recommendDungeonId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
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

        public static DungeonEntryPointInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonEntryPointInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonEntryPointInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonEntryPointInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DungeonEntryInfoOuterClass.getDescriptor();
    }
}
