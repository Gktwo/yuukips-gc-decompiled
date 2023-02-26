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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessInfoOuterClass.class */
public final class ChessInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fChessInfo.proto\"Ñ\u0001\n\tChessInfo\u0012\u0016\n\u000epunishOverTime\u0018\u0004 \u0001(\r\u0012\u0018\n\u0010contentCloseTime\u0018\n \u0001(\r\u0012\u0015\n\rplayerInfoMap\u0018\u0005 \u0001(\r\u0012\u000b\n\u0003exp\u0018\u000b \u0001(\r\u0012\u0017\n\u000fescapedMonsters\u0018\u0006 \u0001(\b\u0012\u001c\n\u0014selectedCardInfoList\u0018\b \u0001(\r\u0012\r\n\u0005level\u0018\u000e \u0001(\r\u0012\u0012\n\ntotalRound\u0018\u0007 \u0003(\r\u0012\u0014\n\fleftMonsters\u0018\u000f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ChessInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChessInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChessInfo_descriptor, new String[]{"PunishOverTime", "ContentCloseTime", "PlayerInfoMap", "Exp", "EscapedMonsters", "SelectedCardInfoList", "Level", "TotalRound", "LeftMonsters"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessInfoOuterClass$ChessInfoOrBuilder.class */
    public interface ChessInfoOrBuilder extends MessageOrBuilder {
        int getPunishOverTime();

        int getContentCloseTime();

        int getPlayerInfoMap();

        int getExp();

        boolean getEscapedMonsters();

        int getSelectedCardInfoList();

        int getLevel();

        List<Integer> getTotalRoundList();

        int getTotalRoundCount();

        int getTotalRound(int i);

        boolean getLeftMonsters();
    }

    private ChessInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessInfoOuterClass$ChessInfo.class */
    public static final class ChessInfo extends GeneratedMessageV3 implements ChessInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PUNISHOVERTIME_FIELD_NUMBER = 4;
        private int punishOverTime_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 10;
        private int contentCloseTime_;
        public static final int PLAYERINFOMAP_FIELD_NUMBER = 5;
        private int playerInfoMap_;
        public static final int EXP_FIELD_NUMBER = 11;
        private int exp_;
        public static final int ESCAPEDMONSTERS_FIELD_NUMBER = 6;
        private boolean escapedMonsters_;
        public static final int SELECTEDCARDINFOLIST_FIELD_NUMBER = 8;
        private int selectedCardInfoList_;
        public static final int LEVEL_FIELD_NUMBER = 14;
        private int level_;
        public static final int TOTALROUND_FIELD_NUMBER = 7;
        private Internal.IntList totalRound_;
        private int totalRoundMemoizedSerializedSize;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 15;
        private boolean leftMonsters_;
        private byte memoizedIsInitialized;
        private static final ChessInfo DEFAULT_INSTANCE = new ChessInfo();
        private static final Parser<ChessInfo> PARSER = new AbstractParser<ChessInfo>() { // from class: emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfo.1
            @Override // com.google.protobuf.Parser
            public ChessInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChessInfo(input, extensionRegistry);
            }
        };

        private ChessInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.totalRoundMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChessInfo() {
            this.totalRoundMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.totalRound_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChessInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChessInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.punishOverTime_ = input.readUInt32();
                                break;
                            case 40:
                                this.playerInfoMap_ = input.readUInt32();
                                break;
                            case 48:
                                this.escapedMonsters_ = input.readBool();
                                break;
                            case 56:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.totalRound_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.totalRound_.addInt(input.readUInt32());
                                break;
                            case 58:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.totalRound_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.totalRound_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 64:
                                this.selectedCardInfoList_ = input.readUInt32();
                                break;
                            case 80:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 88:
                                this.exp_ = input.readUInt32();
                                break;
                            case 112:
                                this.level_ = input.readUInt32();
                                break;
                            case 120:
                                this.leftMonsters_ = input.readBool();
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
                    this.totalRound_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChessInfoOuterClass.internal_static_ChessInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChessInfoOuterClass.internal_static_ChessInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChessInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getPunishOverTime() {
            return this.punishOverTime_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getPlayerInfoMap() {
            return this.playerInfoMap_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getExp() {
            return this.exp_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public boolean getEscapedMonsters() {
            return this.escapedMonsters_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getSelectedCardInfoList() {
            return this.selectedCardInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public List<Integer> getTotalRoundList() {
            return this.totalRound_;
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getTotalRoundCount() {
            return this.totalRound_.size();
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public int getTotalRound(int index) {
            return this.totalRound_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
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
            if (this.punishOverTime_ != 0) {
                output.writeUInt32(4, this.punishOverTime_);
            }
            if (this.playerInfoMap_ != 0) {
                output.writeUInt32(5, this.playerInfoMap_);
            }
            if (this.escapedMonsters_) {
                output.writeBool(6, this.escapedMonsters_);
            }
            if (getTotalRoundList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.totalRoundMemoizedSerializedSize);
            }
            for (int i = 0; i < this.totalRound_.size(); i++) {
                output.writeUInt32NoTag(this.totalRound_.getInt(i));
            }
            if (this.selectedCardInfoList_ != 0) {
                output.writeUInt32(8, this.selectedCardInfoList_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(10, this.contentCloseTime_);
            }
            if (this.exp_ != 0) {
                output.writeUInt32(11, this.exp_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(14, this.level_);
            }
            if (this.leftMonsters_) {
                output.writeBool(15, this.leftMonsters_);
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
            if (this.punishOverTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.punishOverTime_);
            }
            if (this.playerInfoMap_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.playerInfoMap_);
            }
            if (this.escapedMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.escapedMonsters_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.totalRound_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.totalRound_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getTotalRoundList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.totalRoundMemoizedSerializedSize = dataSize;
            if (this.selectedCardInfoList_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(8, this.selectedCardInfoList_);
            }
            if (this.contentCloseTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.contentCloseTime_);
            }
            if (this.exp_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.exp_);
            }
            if (this.level_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.level_);
            }
            if (this.leftMonsters_) {
                size3 += CodedOutputStream.computeBoolSize(15, this.leftMonsters_);
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
            if (!(obj instanceof ChessInfo)) {
                return equals(obj);
            }
            ChessInfo other = (ChessInfo) obj;
            return getPunishOverTime() == other.getPunishOverTime() && getContentCloseTime() == other.getContentCloseTime() && getPlayerInfoMap() == other.getPlayerInfoMap() && getExp() == other.getExp() && getEscapedMonsters() == other.getEscapedMonsters() && getSelectedCardInfoList() == other.getSelectedCardInfoList() && getLevel() == other.getLevel() && getTotalRoundList().equals(other.getTotalRoundList()) && getLeftMonsters() == other.getLeftMonsters() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getPunishOverTime())) + 10)) + getContentCloseTime())) + 5)) + getPlayerInfoMap())) + 11)) + getExp())) + 6)) + Internal.hashBoolean(getEscapedMonsters()))) + 8)) + getSelectedCardInfoList())) + 14)) + getLevel();
            if (getTotalRoundCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getTotalRoundList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + Internal.hashBoolean(getLeftMonsters()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChessInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChessInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChessInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChessInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChessInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChessInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChessInfo parseFrom(InputStream input) throws IOException {
            return (ChessInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChessInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChessInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChessInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChessInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChessInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChessInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChessInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChessInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChessInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChessInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChessInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChessInfoOuterClass$ChessInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChessInfoOrBuilder {
            private int bitField0_;
            private int punishOverTime_;
            private int contentCloseTime_;
            private int playerInfoMap_;
            private int exp_;
            private boolean escapedMonsters_;
            private int selectedCardInfoList_;
            private int level_;
            private Internal.IntList totalRound_ = ChessInfo.emptyIntList();
            private boolean leftMonsters_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChessInfoOuterClass.internal_static_ChessInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChessInfoOuterClass.internal_static_ChessInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChessInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChessInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.punishOverTime_ = 0;
                this.contentCloseTime_ = 0;
                this.playerInfoMap_ = 0;
                this.exp_ = 0;
                this.escapedMonsters_ = false;
                this.selectedCardInfoList_ = 0;
                this.level_ = 0;
                this.totalRound_ = ChessInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.leftMonsters_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChessInfoOuterClass.internal_static_ChessInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChessInfo getDefaultInstanceForType() {
                return ChessInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChessInfo build() {
                ChessInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChessInfo buildPartial() {
                ChessInfo result = new ChessInfo(this);
                int i = this.bitField0_;
                result.punishOverTime_ = this.punishOverTime_;
                result.contentCloseTime_ = this.contentCloseTime_;
                result.playerInfoMap_ = this.playerInfoMap_;
                result.exp_ = this.exp_;
                result.escapedMonsters_ = this.escapedMonsters_;
                result.selectedCardInfoList_ = this.selectedCardInfoList_;
                result.level_ = this.level_;
                if ((this.bitField0_ & 1) != 0) {
                    this.totalRound_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.totalRound_ = this.totalRound_;
                result.leftMonsters_ = this.leftMonsters_;
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
                if (other instanceof ChessInfo) {
                    return mergeFrom((ChessInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChessInfo other) {
                if (other == ChessInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getPunishOverTime() != 0) {
                    setPunishOverTime(other.getPunishOverTime());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getPlayerInfoMap() != 0) {
                    setPlayerInfoMap(other.getPlayerInfoMap());
                }
                if (other.getExp() != 0) {
                    setExp(other.getExp());
                }
                if (other.getEscapedMonsters()) {
                    setEscapedMonsters(other.getEscapedMonsters());
                }
                if (other.getSelectedCardInfoList() != 0) {
                    setSelectedCardInfoList(other.getSelectedCardInfoList());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (!other.totalRound_.isEmpty()) {
                    if (this.totalRound_.isEmpty()) {
                        this.totalRound_ = other.totalRound_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTotalRoundIsMutable();
                        this.totalRound_.addAll(other.totalRound_);
                    }
                    onChanged();
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
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
                ChessInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChessInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChessInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public int getPlayerInfoMap() {
                return this.playerInfoMap_;
            }

            public Builder setPlayerInfoMap(int value) {
                this.playerInfoMap_ = value;
                onChanged();
                return this;
            }

            public Builder clearPlayerInfoMap() {
                this.playerInfoMap_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public boolean getEscapedMonsters() {
                return this.escapedMonsters_;
            }

            public Builder setEscapedMonsters(boolean value) {
                this.escapedMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearEscapedMonsters() {
                this.escapedMonsters_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public int getSelectedCardInfoList() {
                return this.selectedCardInfoList_;
            }

            public Builder setSelectedCardInfoList(int value) {
                this.selectedCardInfoList_ = value;
                onChanged();
                return this;
            }

            public Builder clearSelectedCardInfoList() {
                this.selectedCardInfoList_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
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

            private void ensureTotalRoundIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.totalRound_ = ChessInfo.mutableCopy(this.totalRound_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public List<Integer> getTotalRoundList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.totalRound_) : this.totalRound_;
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public int getTotalRoundCount() {
                return this.totalRound_.size();
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public int getTotalRound(int index) {
                return this.totalRound_.getInt(index);
            }

            public Builder setTotalRound(int index, int value) {
                ensureTotalRoundIsMutable();
                this.totalRound_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTotalRound(int value) {
                ensureTotalRoundIsMutable();
                this.totalRound_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTotalRound(Iterable<? extends Integer> values) {
                ensureTotalRoundIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.totalRound_);
                onChanged();
                return this;
            }

            public Builder clearTotalRound() {
                this.totalRound_ = ChessInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChessInfoOuterClass.ChessInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
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

        public static ChessInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChessInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChessInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChessInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
