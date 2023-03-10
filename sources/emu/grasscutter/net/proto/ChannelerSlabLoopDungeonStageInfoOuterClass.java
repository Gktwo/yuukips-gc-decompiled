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
import emu.grasscutter.net.proto.ChannelerSlabLoopDungeonInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonStageInfoOuterClass.class */
public final class ChannelerSlabLoopDungeonStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'ChannelerSlabLoopDungeonStageInfo.proto\u001a\"ChannelerSlabLoopDungeonInfo.proto\"µ\u0001\n!ChannelerSlabLoopDungeonStageInfo\u00126\n\u000fdungeonInfoList\u0018\n \u0003(\u000b2\u001d.ChannelerSlabLoopDungeonInfo\u0012\u0010\n\bopenTime\u0018\f \u0001(\r\u0012\u0018\n\u0010lastDifficultyId\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\b \u0001(\b\u0012\u001c\n\u0014takenRewardIndexList\u0018\t \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChannelerSlabLoopDungeonInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChannelerSlabLoopDungeonStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_ChannelerSlabLoopDungeonStageInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f671xe160a5fb = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabLoopDungeonStageInfo_descriptor, new String[]{"DungeonInfoList", "OpenTime", "LastDifficultyId", "IsOpen", "TakenRewardIndexList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonStageInfoOuterClass$ChannelerSlabLoopDungeonStageInfoOrBuilder.class */
    public interface ChannelerSlabLoopDungeonStageInfoOrBuilder extends MessageOrBuilder {
        List<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo> getDungeonInfoListList();

        ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo getDungeonInfoList(int i);

        int getDungeonInfoListCount();

        List<? extends ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder> getDungeonInfoListOrBuilderList();

        ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder getDungeonInfoListOrBuilder(int i);

        int getOpenTime();

        int getLastDifficultyId();

        boolean getIsOpen();

        List<Integer> getTakenRewardIndexListList();

        int getTakenRewardIndexListCount();

        int getTakenRewardIndexList(int i);
    }

    private ChannelerSlabLoopDungeonStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonStageInfoOuterClass$ChannelerSlabLoopDungeonStageInfo.class */
    public static final class ChannelerSlabLoopDungeonStageInfo extends GeneratedMessageV3 implements ChannelerSlabLoopDungeonStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEONINFOLIST_FIELD_NUMBER = 10;
        private List<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo> dungeonInfoList_;
        public static final int OPENTIME_FIELD_NUMBER = 12;
        private int openTime_;
        public static final int LASTDIFFICULTYID_FIELD_NUMBER = 2;
        private int lastDifficultyId_;
        public static final int ISOPEN_FIELD_NUMBER = 8;
        private boolean isOpen_;
        public static final int TAKENREWARDINDEXLIST_FIELD_NUMBER = 9;
        private Internal.IntList takenRewardIndexList_;
        private int takenRewardIndexListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabLoopDungeonStageInfo DEFAULT_INSTANCE = new ChannelerSlabLoopDungeonStageInfo();
        private static final Parser<ChannelerSlabLoopDungeonStageInfo> PARSER = new AbstractParser<ChannelerSlabLoopDungeonStageInfo>() { // from class: emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfo.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabLoopDungeonStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabLoopDungeonStageInfo(input, extensionRegistry);
            }
        };

        private ChannelerSlabLoopDungeonStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.takenRewardIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabLoopDungeonStageInfo() {
            this.takenRewardIndexListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.dungeonInfoList_ = Collections.emptyList();
            this.takenRewardIndexList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabLoopDungeonStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x0133 */
        private ChannelerSlabLoopDungeonStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.lastDifficultyId_ = input.readUInt32();
                                break;
                            case 64:
                                this.isOpen_ = input.readBool();
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.takenRewardIndexList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.takenRewardIndexList_.addInt(input.readUInt32());
                                break;
                            case 74:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.takenRewardIndexList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.takenRewardIndexList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dungeonInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.dungeonInfoList_.add((ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo) input.readMessage(ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                this.openTime_ = input.readUInt32();
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
                    this.takenRewardIndexList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.dungeonInfoList_ = Collections.unmodifiableList(this.dungeonInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChannelerSlabLoopDungeonStageInfoOuterClass.internal_static_ChannelerSlabLoopDungeonStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabLoopDungeonStageInfoOuterClass.f671xe160a5fb.ensureFieldAccessorsInitialized(ChannelerSlabLoopDungeonStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public List<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo> getDungeonInfoListList() {
            return this.dungeonInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public List<? extends ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder> getDungeonInfoListOrBuilderList() {
            return this.dungeonInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public int getDungeonInfoListCount() {
            return this.dungeonInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo getDungeonInfoList(int index) {
            return this.dungeonInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder getDungeonInfoListOrBuilder(int index) {
            return this.dungeonInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public int getLastDifficultyId() {
            return this.lastDifficultyId_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public List<Integer> getTakenRewardIndexListList() {
            return this.takenRewardIndexList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public int getTakenRewardIndexListCount() {
            return this.takenRewardIndexList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
        public int getTakenRewardIndexList(int index) {
            return this.takenRewardIndexList_.getInt(index);
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
            if (this.lastDifficultyId_ != 0) {
                output.writeUInt32(2, this.lastDifficultyId_);
            }
            if (this.isOpen_) {
                output.writeBool(8, this.isOpen_);
            }
            if (getTakenRewardIndexListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.takenRewardIndexListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.takenRewardIndexList_.size(); i++) {
                output.writeUInt32NoTag(this.takenRewardIndexList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.dungeonInfoList_.size(); i2++) {
                output.writeMessage(10, this.dungeonInfoList_.get(i2));
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(12, this.openTime_);
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
            if (this.lastDifficultyId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.lastDifficultyId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isOpen_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.takenRewardIndexList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.takenRewardIndexList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTakenRewardIndexListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.takenRewardIndexListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.dungeonInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(10, this.dungeonInfoList_.get(i2));
            }
            if (this.openTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(12, this.openTime_);
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
            if (!(obj instanceof ChannelerSlabLoopDungeonStageInfo)) {
                return equals(obj);
            }
            ChannelerSlabLoopDungeonStageInfo other = (ChannelerSlabLoopDungeonStageInfo) obj;
            return getDungeonInfoListList().equals(other.getDungeonInfoListList()) && getOpenTime() == other.getOpenTime() && getLastDifficultyId() == other.getLastDifficultyId() && getIsOpen() == other.getIsOpen() && getTakenRewardIndexListList().equals(other.getTakenRewardIndexListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDungeonInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getDungeonInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 12)) + getOpenTime())) + 2)) + getLastDifficultyId())) + 8)) + Internal.hashBoolean(getIsOpen());
            if (getTakenRewardIndexListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getTakenRewardIndexListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabLoopDungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabLoopDungeonStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabLoopDungeonStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabLoopDungeonStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabLoopDungeonStageInfoOuterClass$ChannelerSlabLoopDungeonStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabLoopDungeonStageInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder> dungeonInfoListBuilder_;
            private int openTime_;
            private int lastDifficultyId_;
            private boolean isOpen_;
            private List<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo> dungeonInfoList_ = Collections.emptyList();
            private Internal.IntList takenRewardIndexList_ = ChannelerSlabLoopDungeonStageInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabLoopDungeonStageInfoOuterClass.internal_static_ChannelerSlabLoopDungeonStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabLoopDungeonStageInfoOuterClass.f671xe160a5fb.ensureFieldAccessorsInitialized(ChannelerSlabLoopDungeonStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabLoopDungeonStageInfo.alwaysUseFieldBuilders) {
                    getDungeonInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.dungeonInfoListBuilder_ == null) {
                    this.dungeonInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dungeonInfoListBuilder_.clear();
                }
                this.openTime_ = 0;
                this.lastDifficultyId_ = 0;
                this.isOpen_ = false;
                this.takenRewardIndexList_ = ChannelerSlabLoopDungeonStageInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabLoopDungeonStageInfoOuterClass.internal_static_ChannelerSlabLoopDungeonStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabLoopDungeonStageInfo getDefaultInstanceForType() {
                return ChannelerSlabLoopDungeonStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabLoopDungeonStageInfo build() {
                ChannelerSlabLoopDungeonStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabLoopDungeonStageInfo buildPartial() {
                ChannelerSlabLoopDungeonStageInfo result = new ChannelerSlabLoopDungeonStageInfo(this);
                int i = this.bitField0_;
                if (this.dungeonInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dungeonInfoList_ = Collections.unmodifiableList(this.dungeonInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.dungeonInfoList_ = this.dungeonInfoList_;
                } else {
                    result.dungeonInfoList_ = this.dungeonInfoListBuilder_.build();
                }
                result.openTime_ = this.openTime_;
                result.lastDifficultyId_ = this.lastDifficultyId_;
                result.isOpen_ = this.isOpen_;
                if ((this.bitField0_ & 2) != 0) {
                    this.takenRewardIndexList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.takenRewardIndexList_ = this.takenRewardIndexList_;
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
                if (other instanceof ChannelerSlabLoopDungeonStageInfo) {
                    return mergeFrom((ChannelerSlabLoopDungeonStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabLoopDungeonStageInfo other) {
                if (other == ChannelerSlabLoopDungeonStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.dungeonInfoListBuilder_ == null) {
                    if (!other.dungeonInfoList_.isEmpty()) {
                        if (this.dungeonInfoList_.isEmpty()) {
                            this.dungeonInfoList_ = other.dungeonInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDungeonInfoListIsMutable();
                            this.dungeonInfoList_.addAll(other.dungeonInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dungeonInfoList_.isEmpty()) {
                    if (this.dungeonInfoListBuilder_.isEmpty()) {
                        this.dungeonInfoListBuilder_.dispose();
                        this.dungeonInfoListBuilder_ = null;
                        this.dungeonInfoList_ = other.dungeonInfoList_;
                        this.bitField0_ &= -2;
                        this.dungeonInfoListBuilder_ = ChannelerSlabLoopDungeonStageInfo.alwaysUseFieldBuilders ? getDungeonInfoListFieldBuilder() : null;
                    } else {
                        this.dungeonInfoListBuilder_.addAllMessages(other.dungeonInfoList_);
                    }
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getLastDifficultyId() != 0) {
                    setLastDifficultyId(other.getLastDifficultyId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (!other.takenRewardIndexList_.isEmpty()) {
                    if (this.takenRewardIndexList_.isEmpty()) {
                        this.takenRewardIndexList_ = other.takenRewardIndexList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTakenRewardIndexListIsMutable();
                        this.takenRewardIndexList_.addAll(other.takenRewardIndexList_);
                    }
                    onChanged();
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
                ChannelerSlabLoopDungeonStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabLoopDungeonStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabLoopDungeonStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDungeonInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dungeonInfoList_ = new ArrayList(this.dungeonInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public List<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo> getDungeonInfoListList() {
                if (this.dungeonInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonInfoList_);
                }
                return this.dungeonInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public int getDungeonInfoListCount() {
                if (this.dungeonInfoListBuilder_ == null) {
                    return this.dungeonInfoList_.size();
                }
                return this.dungeonInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo getDungeonInfoList(int index) {
                if (this.dungeonInfoListBuilder_ == null) {
                    return this.dungeonInfoList_.get(index);
                }
                return this.dungeonInfoListBuilder_.getMessage(index);
            }

            public Builder setDungeonInfoList(int index, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo value) {
                if (this.dungeonInfoListBuilder_ != null) {
                    this.dungeonInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonInfoList(int index, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder builderForValue) {
                if (this.dungeonInfoListBuilder_ == null) {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonInfoList(ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo value) {
                if (this.dungeonInfoListBuilder_ != null) {
                    this.dungeonInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonInfoList(int index, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo value) {
                if (this.dungeonInfoListBuilder_ != null) {
                    this.dungeonInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonInfoList(ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder builderForValue) {
                if (this.dungeonInfoListBuilder_ == null) {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonInfoList(int index, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder builderForValue) {
                if (this.dungeonInfoListBuilder_ == null) {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDungeonInfoList(Iterable<? extends ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo> values) {
                if (this.dungeonInfoListBuilder_ == null) {
                    ensureDungeonInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dungeonInfoList_);
                    onChanged();
                } else {
                    this.dungeonInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDungeonInfoList() {
                if (this.dungeonInfoListBuilder_ == null) {
                    this.dungeonInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dungeonInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDungeonInfoList(int index) {
                if (this.dungeonInfoListBuilder_ == null) {
                    ensureDungeonInfoListIsMutable();
                    this.dungeonInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dungeonInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder getDungeonInfoListBuilder(int index) {
                return getDungeonInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder getDungeonInfoListOrBuilder(int index) {
                if (this.dungeonInfoListBuilder_ == null) {
                    return this.dungeonInfoList_.get(index);
                }
                return this.dungeonInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public List<? extends ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder> getDungeonInfoListOrBuilderList() {
                if (this.dungeonInfoListBuilder_ != null) {
                    return this.dungeonInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dungeonInfoList_);
            }

            public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder addDungeonInfoListBuilder() {
                return getDungeonInfoListFieldBuilder().addBuilder(ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.getDefaultInstance());
            }

            public ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder addDungeonInfoListBuilder(int index) {
                return getDungeonInfoListFieldBuilder().addBuilder(index, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.getDefaultInstance());
            }

            public List<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder> getDungeonInfoListBuilderList() {
                return getDungeonInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfo.Builder, ChannelerSlabLoopDungeonInfoOuterClass.ChannelerSlabLoopDungeonInfoOrBuilder> getDungeonInfoListFieldBuilder() {
                if (this.dungeonInfoListBuilder_ == null) {
                    this.dungeonInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dungeonInfoList_ = null;
                }
                return this.dungeonInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public int getLastDifficultyId() {
                return this.lastDifficultyId_;
            }

            public Builder setLastDifficultyId(int value) {
                this.lastDifficultyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastDifficultyId() {
                this.lastDifficultyId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            private void ensureTakenRewardIndexListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.takenRewardIndexList_ = ChannelerSlabLoopDungeonStageInfo.mutableCopy(this.takenRewardIndexList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public List<Integer> getTakenRewardIndexListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.takenRewardIndexList_) : this.takenRewardIndexList_;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public int getTakenRewardIndexListCount() {
                return this.takenRewardIndexList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabLoopDungeonStageInfoOuterClass.ChannelerSlabLoopDungeonStageInfoOrBuilder
            public int getTakenRewardIndexList(int index) {
                return this.takenRewardIndexList_.getInt(index);
            }

            public Builder setTakenRewardIndexList(int index, int value) {
                ensureTakenRewardIndexListIsMutable();
                this.takenRewardIndexList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTakenRewardIndexList(int value) {
                ensureTakenRewardIndexListIsMutable();
                this.takenRewardIndexList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTakenRewardIndexList(Iterable<? extends Integer> values) {
                ensureTakenRewardIndexListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takenRewardIndexList_);
                onChanged();
                return this;
            }

            public Builder clearTakenRewardIndexList() {
                this.takenRewardIndexList_ = ChannelerSlabLoopDungeonStageInfo.emptyIntList();
                this.bitField0_ &= -3;
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

        public static ChannelerSlabLoopDungeonStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabLoopDungeonStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabLoopDungeonStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabLoopDungeonStageInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChannelerSlabLoopDungeonInfoOuterClass.getDescriptor();
    }
}
