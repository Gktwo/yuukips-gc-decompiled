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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamChainSettleInfoOuterClass.class */
public final class TeamChainSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019TeamChainSettleInfo.proto\"v\n\u0013TeamChainSettleInfo\u0012\u0013\n\u000bisNewRecord\u0018\r \u0001(\b\u0012\u000f\n\u0007stageId\u0018\u0004 \u0001(\r\u0012\u0012\n\ntotalScore\u0018\u0003 \u0001(\r\u0012\u0012\n\ndifficulty\u0018\u000f \u0001(\r\u0012\u0011\n\tscoreList\u0018\t \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TeamChainSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TeamChainSettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TeamChainSettleInfo_descriptor, new String[]{"IsNewRecord", "StageId", "TotalScore", "Difficulty", "ScoreList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamChainSettleInfoOuterClass$TeamChainSettleInfoOrBuilder.class */
    public interface TeamChainSettleInfoOrBuilder extends MessageOrBuilder {
        boolean getIsNewRecord();

        int getStageId();

        int getTotalScore();

        int getDifficulty();

        List<Integer> getScoreListList();

        int getScoreListCount();

        int getScoreList(int i);
    }

    private TeamChainSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamChainSettleInfoOuterClass$TeamChainSettleInfo.class */
    public static final class TeamChainSettleInfo extends GeneratedMessageV3 implements TeamChainSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISNEWRECORD_FIELD_NUMBER = 13;
        private boolean isNewRecord_;
        public static final int STAGEID_FIELD_NUMBER = 4;
        private int stageId_;
        public static final int TOTALSCORE_FIELD_NUMBER = 3;
        private int totalScore_;
        public static final int DIFFICULTY_FIELD_NUMBER = 15;
        private int difficulty_;
        public static final int SCORELIST_FIELD_NUMBER = 9;
        private Internal.IntList scoreList_;
        private int scoreListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final TeamChainSettleInfo DEFAULT_INSTANCE = new TeamChainSettleInfo();
        private static final Parser<TeamChainSettleInfo> PARSER = new AbstractParser<TeamChainSettleInfo>() { // from class: emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfo.1
            @Override // com.google.protobuf.Parser
            public TeamChainSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TeamChainSettleInfo(input, extensionRegistry);
            }
        };

        private TeamChainSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.scoreListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TeamChainSettleInfo() {
            this.scoreListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.scoreList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TeamChainSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TeamChainSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.totalScore_ = input.readUInt32();
                                break;
                            case 32:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.scoreList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.scoreList_.addInt(input.readUInt32());
                                break;
                            case 74:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.scoreList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.scoreList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 104:
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 120:
                                this.difficulty_ = input.readUInt32();
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
                    this.scoreList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TeamChainSettleInfoOuterClass.internal_static_TeamChainSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TeamChainSettleInfoOuterClass.internal_static_TeamChainSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TeamChainSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public int getTotalScore() {
            return this.totalScore_;
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public int getDifficulty() {
            return this.difficulty_;
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public List<Integer> getScoreListList() {
            return this.scoreList_;
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public int getScoreListCount() {
            return this.scoreList_.size();
        }

        @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
        public int getScoreList(int index) {
            return this.scoreList_.getInt(index);
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
            if (this.totalScore_ != 0) {
                output.writeUInt32(3, this.totalScore_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(4, this.stageId_);
            }
            if (getScoreListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.scoreListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.scoreList_.size(); i++) {
                output.writeUInt32NoTag(this.scoreList_.getInt(i));
            }
            if (this.isNewRecord_) {
                output.writeBool(13, this.isNewRecord_);
            }
            if (this.difficulty_ != 0) {
                output.writeUInt32(15, this.difficulty_);
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
            if (this.totalScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.totalScore_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.stageId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.scoreList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.scoreList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getScoreListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.scoreListMemoizedSerializedSize = dataSize;
            if (this.isNewRecord_) {
                size3 += CodedOutputStream.computeBoolSize(13, this.isNewRecord_);
            }
            if (this.difficulty_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.difficulty_);
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
            if (!(obj instanceof TeamChainSettleInfo)) {
                return equals(obj);
            }
            TeamChainSettleInfo other = (TeamChainSettleInfo) obj;
            return getIsNewRecord() == other.getIsNewRecord() && getStageId() == other.getStageId() && getTotalScore() == other.getTotalScore() && getDifficulty() == other.getDifficulty() && getScoreListList().equals(other.getScoreListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsNewRecord()))) + 4)) + getStageId())) + 3)) + getTotalScore())) + 15)) + getDifficulty();
            if (getScoreListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getScoreListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TeamChainSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamChainSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamChainSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamChainSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamChainSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TeamChainSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TeamChainSettleInfo parseFrom(InputStream input) throws IOException {
            return (TeamChainSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TeamChainSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamChainSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TeamChainSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TeamChainSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TeamChainSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamChainSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TeamChainSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (TeamChainSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TeamChainSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TeamChainSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TeamChainSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TeamChainSettleInfoOuterClass$TeamChainSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TeamChainSettleInfoOrBuilder {
            private int bitField0_;
            private boolean isNewRecord_;
            private int stageId_;
            private int totalScore_;
            private int difficulty_;
            private Internal.IntList scoreList_ = TeamChainSettleInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TeamChainSettleInfoOuterClass.internal_static_TeamChainSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TeamChainSettleInfoOuterClass.internal_static_TeamChainSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TeamChainSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TeamChainSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isNewRecord_ = false;
                this.stageId_ = 0;
                this.totalScore_ = 0;
                this.difficulty_ = 0;
                this.scoreList_ = TeamChainSettleInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TeamChainSettleInfoOuterClass.internal_static_TeamChainSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TeamChainSettleInfo getDefaultInstanceForType() {
                return TeamChainSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TeamChainSettleInfo build() {
                TeamChainSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TeamChainSettleInfo buildPartial() {
                TeamChainSettleInfo result = new TeamChainSettleInfo(this);
                int i = this.bitField0_;
                result.isNewRecord_ = this.isNewRecord_;
                result.stageId_ = this.stageId_;
                result.totalScore_ = this.totalScore_;
                result.difficulty_ = this.difficulty_;
                if ((this.bitField0_ & 1) != 0) {
                    this.scoreList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.scoreList_ = this.scoreList_;
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
                if (other instanceof TeamChainSettleInfo) {
                    return mergeFrom((TeamChainSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TeamChainSettleInfo other) {
                if (other == TeamChainSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getTotalScore() != 0) {
                    setTotalScore(other.getTotalScore());
                }
                if (other.getDifficulty() != 0) {
                    setDifficulty(other.getDifficulty());
                }
                if (!other.scoreList_.isEmpty()) {
                    if (this.scoreList_.isEmpty()) {
                        this.scoreList_ = other.scoreList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureScoreListIsMutable();
                        this.scoreList_.addAll(other.scoreList_);
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
                TeamChainSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TeamChainSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TeamChainSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public boolean getIsNewRecord() {
                return this.isNewRecord_;
            }

            public Builder setIsNewRecord(boolean value) {
                this.isNewRecord_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNewRecord() {
                this.isNewRecord_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public int getTotalScore() {
                return this.totalScore_;
            }

            public Builder setTotalScore(int value) {
                this.totalScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalScore() {
                this.totalScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public int getDifficulty() {
                return this.difficulty_;
            }

            public Builder setDifficulty(int value) {
                this.difficulty_ = value;
                onChanged();
                return this;
            }

            public Builder clearDifficulty() {
                this.difficulty_ = 0;
                onChanged();
                return this;
            }

            private void ensureScoreListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.scoreList_ = TeamChainSettleInfo.mutableCopy(this.scoreList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public List<Integer> getScoreListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.scoreList_) : this.scoreList_;
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public int getScoreListCount() {
                return this.scoreList_.size();
            }

            @Override // emu.grasscutter.net.proto.TeamChainSettleInfoOuterClass.TeamChainSettleInfoOrBuilder
            public int getScoreList(int index) {
                return this.scoreList_.getInt(index);
            }

            public Builder setScoreList(int index, int value) {
                ensureScoreListIsMutable();
                this.scoreList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addScoreList(int value) {
                ensureScoreListIsMutable();
                this.scoreList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllScoreList(Iterable<? extends Integer> values) {
                ensureScoreListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.scoreList_);
                onChanged();
                return this;
            }

            public Builder clearScoreList() {
                this.scoreList_ = TeamChainSettleInfo.emptyIntList();
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

        public static TeamChainSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TeamChainSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TeamChainSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TeamChainSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
