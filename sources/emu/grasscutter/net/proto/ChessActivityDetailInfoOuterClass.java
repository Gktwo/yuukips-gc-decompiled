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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessActivityDetailInfoOuterClass.class */
public final class ChessActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dChessActivityDetailInfo.proto\"\u0002\n\u0017ChessActivityDetailInfo\u0012\u0018\n\u0010punish_over_time\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_LPDDFGGKGBP\u0018\u0004 \u0001(\r\u0012\r\n\u0005level\u0018\u000e \u0001(\r\u0012\u000b\n\u0003exp\u0018\u0006 \u0001(\r\u0012\u001b\n\u0013Unk3300_HBGEGIPIANG\u0018\u000f \u0001(\r\u0012\u001a\n\u0012content_close_time\u0018\u0001 \u0001(\r\u0012!\n\u0019is_teach_dungeon_finished\u0018\u000b \u0001(\b\u0012\u0019\n\u0011is_content_closed\u0018\u0005 \u0001(\b\u0012\u001c\n\u0014finished_map_id_list\u0018\r \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChessActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChessActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChessActivityDetailInfo_descriptor, new String[]{"PunishOverTime", "Unk3300LPDDFGGKGBP", "Level", "Exp", "Unk3300HBGEGIPIANG", "ContentCloseTime", "IsTeachDungeonFinished", "IsContentClosed", "FinishedMapIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessActivityDetailInfoOuterClass$ChessActivityDetailInfoOrBuilder.class */
    public interface ChessActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getPunishOverTime();

        int getUnk3300LPDDFGGKGBP();

        int getLevel();

        int getExp();

        int getUnk3300HBGEGIPIANG();

        int getContentCloseTime();

        boolean getIsTeachDungeonFinished();

        boolean getIsContentClosed();

        List<Integer> getFinishedMapIdListList();

        int getFinishedMapIdListCount();

        int getFinishedMapIdList(int i);
    }

    private ChessActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessActivityDetailInfoOuterClass$ChessActivityDetailInfo.class */
    public static final class ChessActivityDetailInfo extends GeneratedMessageV3 implements ChessActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PUNISH_OVER_TIME_FIELD_NUMBER = 9;
        private int punishOverTime_;
        public static final int UNK3300_LPDDFGGKGBP_FIELD_NUMBER = 4;
        private int unk3300LPDDFGGKGBP_;
        public static final int LEVEL_FIELD_NUMBER = 14;
        private int level_;
        public static final int EXP_FIELD_NUMBER = 6;
        private int exp_;
        public static final int UNK3300_HBGEGIPIANG_FIELD_NUMBER = 15;
        private int unk3300HBGEGIPIANG_;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 1;
        private int contentCloseTime_;
        public static final int IS_TEACH_DUNGEON_FINISHED_FIELD_NUMBER = 11;
        private boolean isTeachDungeonFinished_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 5;
        private boolean isContentClosed_;
        public static final int FINISHED_MAP_ID_LIST_FIELD_NUMBER = 13;
        private Internal.IntList finishedMapIdList_;
        private int finishedMapIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ChessActivityDetailInfo DEFAULT_INSTANCE = new ChessActivityDetailInfo();
        private static final Parser<ChessActivityDetailInfo> PARSER = new AbstractParser<ChessActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public ChessActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChessActivityDetailInfo(input, extensionRegistry);
            }
        };

        private ChessActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishedMapIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChessActivityDetailInfo() {
            this.finishedMapIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.finishedMapIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChessActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChessActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 32:
                                this.unk3300LPDDFGGKGBP_ = input.readUInt32();
                                break;
                            case 40:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 48:
                                this.exp_ = input.readUInt32();
                                break;
                            case 72:
                                this.punishOverTime_ = input.readUInt32();
                                break;
                            case 88:
                                this.isTeachDungeonFinished_ = input.readBool();
                                break;
                            case 104:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.finishedMapIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.finishedMapIdList_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishedMapIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishedMapIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 112:
                                this.level_ = input.readUInt32();
                                break;
                            case 120:
                                this.unk3300HBGEGIPIANG_ = input.readUInt32();
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
                    this.finishedMapIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChessActivityDetailInfoOuterClass.internal_static_ChessActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChessActivityDetailInfoOuterClass.internal_static_ChessActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChessActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getPunishOverTime() {
            return this.punishOverTime_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getUnk3300LPDDFGGKGBP() {
            return this.unk3300LPDDFGGKGBP_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getExp() {
            return this.exp_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getUnk3300HBGEGIPIANG() {
            return this.unk3300HBGEGIPIANG_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public boolean getIsTeachDungeonFinished() {
            return this.isTeachDungeonFinished_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public List<Integer> getFinishedMapIdListList() {
            return this.finishedMapIdList_;
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getFinishedMapIdListCount() {
            return this.finishedMapIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
        public int getFinishedMapIdList(int index) {
            return this.finishedMapIdList_.getInt(index);
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
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(1, this.contentCloseTime_);
            }
            if (this.unk3300LPDDFGGKGBP_ != 0) {
                output.writeUInt32(4, this.unk3300LPDDFGGKGBP_);
            }
            if (this.isContentClosed_) {
                output.writeBool(5, this.isContentClosed_);
            }
            if (this.exp_ != 0) {
                output.writeUInt32(6, this.exp_);
            }
            if (this.punishOverTime_ != 0) {
                output.writeUInt32(9, this.punishOverTime_);
            }
            if (this.isTeachDungeonFinished_) {
                output.writeBool(11, this.isTeachDungeonFinished_);
            }
            if (getFinishedMapIdListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.finishedMapIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishedMapIdList_.size(); i++) {
                output.writeUInt32NoTag(this.finishedMapIdList_.getInt(i));
            }
            if (this.level_ != 0) {
                output.writeUInt32(14, this.level_);
            }
            if (this.unk3300HBGEGIPIANG_ != 0) {
                output.writeUInt32(15, this.unk3300HBGEGIPIANG_);
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
            if (this.contentCloseTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.contentCloseTime_);
            }
            if (this.unk3300LPDDFGGKGBP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.unk3300LPDDFGGKGBP_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isContentClosed_);
            }
            if (this.exp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.exp_);
            }
            if (this.punishOverTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.punishOverTime_);
            }
            if (this.isTeachDungeonFinished_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isTeachDungeonFinished_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.finishedMapIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishedMapIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getFinishedMapIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishedMapIdListMemoizedSerializedSize = dataSize;
            if (this.level_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.level_);
            }
            if (this.unk3300HBGEGIPIANG_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.unk3300HBGEGIPIANG_);
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
            if (!(obj instanceof ChessActivityDetailInfo)) {
                return equals(obj);
            }
            ChessActivityDetailInfo other = (ChessActivityDetailInfo) obj;
            return getPunishOverTime() == other.getPunishOverTime() && getUnk3300LPDDFGGKGBP() == other.getUnk3300LPDDFGGKGBP() && getLevel() == other.getLevel() && getExp() == other.getExp() && getUnk3300HBGEGIPIANG() == other.getUnk3300HBGEGIPIANG() && getContentCloseTime() == other.getContentCloseTime() && getIsTeachDungeonFinished() == other.getIsTeachDungeonFinished() && getIsContentClosed() == other.getIsContentClosed() && getFinishedMapIdListList().equals(other.getFinishedMapIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getPunishOverTime())) + 4)) + getUnk3300LPDDFGGKGBP())) + 14)) + getLevel())) + 6)) + getExp())) + 15)) + getUnk3300HBGEGIPIANG())) + 1)) + getContentCloseTime())) + 11)) + Internal.hashBoolean(getIsTeachDungeonFinished()))) + 5)) + Internal.hashBoolean(getIsContentClosed());
            if (getFinishedMapIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getFinishedMapIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChessActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChessActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChessActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChessActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChessActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChessActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChessActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (ChessActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChessActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChessActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChessActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChessActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChessActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChessActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChessActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChessActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChessActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChessActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChessActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessActivityDetailInfoOuterClass$ChessActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChessActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int punishOverTime_;
            private int unk3300LPDDFGGKGBP_;
            private int level_;
            private int exp_;
            private int unk3300HBGEGIPIANG_;
            private int contentCloseTime_;
            private boolean isTeachDungeonFinished_;
            private boolean isContentClosed_;
            private Internal.IntList finishedMapIdList_ = ChessActivityDetailInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ChessActivityDetailInfoOuterClass.internal_static_ChessActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChessActivityDetailInfoOuterClass.internal_static_ChessActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChessActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChessActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.punishOverTime_ = 0;
                this.unk3300LPDDFGGKGBP_ = 0;
                this.level_ = 0;
                this.exp_ = 0;
                this.unk3300HBGEGIPIANG_ = 0;
                this.contentCloseTime_ = 0;
                this.isTeachDungeonFinished_ = false;
                this.isContentClosed_ = false;
                this.finishedMapIdList_ = ChessActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChessActivityDetailInfoOuterClass.internal_static_ChessActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChessActivityDetailInfo getDefaultInstanceForType() {
                return ChessActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChessActivityDetailInfo build() {
                ChessActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChessActivityDetailInfo buildPartial() {
                ChessActivityDetailInfo result = new ChessActivityDetailInfo(this);
                int i = this.bitField0_;
                result.punishOverTime_ = this.punishOverTime_;
                result.unk3300LPDDFGGKGBP_ = this.unk3300LPDDFGGKGBP_;
                result.level_ = this.level_;
                result.exp_ = this.exp_;
                result.unk3300HBGEGIPIANG_ = this.unk3300HBGEGIPIANG_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.isTeachDungeonFinished_ = this.isTeachDungeonFinished_;
                result.isContentClosed_ = this.isContentClosed_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishedMapIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishedMapIdList_ = this.finishedMapIdList_;
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
                if (other instanceof ChessActivityDetailInfo) {
                    return mergeFrom((ChessActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChessActivityDetailInfo other) {
                if (other == ChessActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPunishOverTime() != 0) {
                    setPunishOverTime(other.getPunishOverTime());
                }
                if (other.getUnk3300LPDDFGGKGBP() != 0) {
                    setUnk3300LPDDFGGKGBP(other.getUnk3300LPDDFGGKGBP());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getExp() != 0) {
                    setExp(other.getExp());
                }
                if (other.getUnk3300HBGEGIPIANG() != 0) {
                    setUnk3300HBGEGIPIANG(other.getUnk3300HBGEGIPIANG());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getIsTeachDungeonFinished()) {
                    setIsTeachDungeonFinished(other.getIsTeachDungeonFinished());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (!other.finishedMapIdList_.isEmpty()) {
                    if (this.finishedMapIdList_.isEmpty()) {
                        this.finishedMapIdList_ = other.finishedMapIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishedMapIdListIsMutable();
                        this.finishedMapIdList_.addAll(other.finishedMapIdList_);
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
                ChessActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChessActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChessActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getPunishOverTime() {
                return this.punishOverTime_;
            }

            public Builder setPunishOverTime(int value) {
                this.punishOverTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearPunishOverTime() {
                this.punishOverTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getUnk3300LPDDFGGKGBP() {
                return this.unk3300LPDDFGGKGBP_;
            }

            public Builder setUnk3300LPDDFGGKGBP(int value) {
                this.unk3300LPDDFGGKGBP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LPDDFGGKGBP() {
                this.unk3300LPDDFGGKGBP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getExp() {
                return this.exp_;
            }

            public Builder setExp(int value) {
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.exp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getUnk3300HBGEGIPIANG() {
                return this.unk3300HBGEGIPIANG_;
            }

            public Builder setUnk3300HBGEGIPIANG(int value) {
                this.unk3300HBGEGIPIANG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HBGEGIPIANG() {
                this.unk3300HBGEGIPIANG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public boolean getIsTeachDungeonFinished() {
                return this.isTeachDungeonFinished_;
            }

            public Builder setIsTeachDungeonFinished(boolean value) {
                this.isTeachDungeonFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTeachDungeonFinished() {
                this.isTeachDungeonFinished_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            private void ensureFinishedMapIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishedMapIdList_ = ChessActivityDetailInfo.mutableCopy(this.finishedMapIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public List<Integer> getFinishedMapIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishedMapIdList_) : this.finishedMapIdList_;
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getFinishedMapIdListCount() {
                return this.finishedMapIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder
            public int getFinishedMapIdList(int index) {
                return this.finishedMapIdList_.getInt(index);
            }

            public Builder setFinishedMapIdList(int index, int value) {
                ensureFinishedMapIdListIsMutable();
                this.finishedMapIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishedMapIdList(int value) {
                ensureFinishedMapIdListIsMutable();
                this.finishedMapIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishedMapIdList(Iterable<? extends Integer> values) {
                ensureFinishedMapIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishedMapIdList_);
                onChanged();
                return this;
            }

            public Builder clearFinishedMapIdList() {
                this.finishedMapIdList_ = ChessActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
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

        public static ChessActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChessActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChessActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChessActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
