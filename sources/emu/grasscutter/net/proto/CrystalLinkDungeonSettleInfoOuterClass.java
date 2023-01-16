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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkDungeonSettleInfoOuterClass.class */
public final class CrystalLinkDungeonSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"CrystalLinkDungeonSettleInfo.proto\"´\u0001\n\u001cCrystalLinkDungeonSettleInfo\u0012\u0010\n\blevel_id\u0018\t \u0001(\r\u0012\u0013\n\u000bfinal_score\u0018\f \u0001(\r\u0012\u001f\n\u0017kill_normal_monster_num\u0018\b \u0001(\r\u0012\u0015\n\rdifficulty_id\u0018\u0003 \u0001(\r\u0012\u001e\n\u0016kill_elite_monster_num\u0018\u0002 \u0001(\r\u0012\u0015\n\ris_new_record\u0018\n \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CrystalLinkDungeonSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CrystalLinkDungeonSettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CrystalLinkDungeonSettleInfo_descriptor, new String[]{"LevelId", "FinalScore", "KillNormalMonsterNum", "DifficultyId", "KillEliteMonsterNum", "IsNewRecord"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkDungeonSettleInfoOuterClass$CrystalLinkDungeonSettleInfoOrBuilder.class */
    public interface CrystalLinkDungeonSettleInfoOrBuilder extends MessageOrBuilder {
        int getLevelId();

        int getFinalScore();

        int getKillNormalMonsterNum();

        int getDifficultyId();

        int getKillEliteMonsterNum();

        boolean getIsNewRecord();
    }

    private CrystalLinkDungeonSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkDungeonSettleInfoOuterClass$CrystalLinkDungeonSettleInfo.class */
    public static final class CrystalLinkDungeonSettleInfo extends GeneratedMessageV3 implements CrystalLinkDungeonSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_ID_FIELD_NUMBER = 9;
        private int levelId_;
        public static final int FINAL_SCORE_FIELD_NUMBER = 12;
        private int finalScore_;
        public static final int KILL_NORMAL_MONSTER_NUM_FIELD_NUMBER = 8;
        private int killNormalMonsterNum_;
        public static final int DIFFICULTY_ID_FIELD_NUMBER = 3;
        private int difficultyId_;
        public static final int KILL_ELITE_MONSTER_NUM_FIELD_NUMBER = 2;
        private int killEliteMonsterNum_;
        public static final int IS_NEW_RECORD_FIELD_NUMBER = 10;
        private boolean isNewRecord_;
        private byte memoizedIsInitialized;
        private static final CrystalLinkDungeonSettleInfo DEFAULT_INSTANCE = new CrystalLinkDungeonSettleInfo();
        private static final Parser<CrystalLinkDungeonSettleInfo> PARSER = new AbstractParser<CrystalLinkDungeonSettleInfo>() { // from class: emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfo.1
            @Override // com.google.protobuf.Parser
            public CrystalLinkDungeonSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CrystalLinkDungeonSettleInfo(input, extensionRegistry);
            }
        };

        private CrystalLinkDungeonSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CrystalLinkDungeonSettleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CrystalLinkDungeonSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CrystalLinkDungeonSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.killEliteMonsterNum_ = input.readUInt32();
                                break;
                            case 24:
                                this.difficultyId_ = input.readUInt32();
                                break;
                            case 64:
                                this.killNormalMonsterNum_ = input.readUInt32();
                                break;
                            case 72:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 80:
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 96:
                                this.finalScore_ = input.readUInt32();
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
            return CrystalLinkDungeonSettleInfoOuterClass.internal_static_CrystalLinkDungeonSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CrystalLinkDungeonSettleInfoOuterClass.internal_static_CrystalLinkDungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkDungeonSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
        public int getFinalScore() {
            return this.finalScore_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
        public int getKillNormalMonsterNum() {
            return this.killNormalMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
        public int getDifficultyId() {
            return this.difficultyId_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
        public int getKillEliteMonsterNum() {
            return this.killEliteMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
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
            if (this.killEliteMonsterNum_ != 0) {
                output.writeUInt32(2, this.killEliteMonsterNum_);
            }
            if (this.difficultyId_ != 0) {
                output.writeUInt32(3, this.difficultyId_);
            }
            if (this.killNormalMonsterNum_ != 0) {
                output.writeUInt32(8, this.killNormalMonsterNum_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(9, this.levelId_);
            }
            if (this.isNewRecord_) {
                output.writeBool(10, this.isNewRecord_);
            }
            if (this.finalScore_ != 0) {
                output.writeUInt32(12, this.finalScore_);
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
            if (this.killEliteMonsterNum_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.killEliteMonsterNum_);
            }
            if (this.difficultyId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.difficultyId_);
            }
            if (this.killNormalMonsterNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.killNormalMonsterNum_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.levelId_);
            }
            if (this.isNewRecord_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isNewRecord_);
            }
            if (this.finalScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.finalScore_);
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
            if (!(obj instanceof CrystalLinkDungeonSettleInfo)) {
                return equals(obj);
            }
            CrystalLinkDungeonSettleInfo other = (CrystalLinkDungeonSettleInfo) obj;
            return getLevelId() == other.getLevelId() && getFinalScore() == other.getFinalScore() && getKillNormalMonsterNum() == other.getKillNormalMonsterNum() && getDifficultyId() == other.getDifficultyId() && getKillEliteMonsterNum() == other.getKillEliteMonsterNum() && getIsNewRecord() == other.getIsNewRecord() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getLevelId())) + 12)) + getFinalScore())) + 8)) + getKillNormalMonsterNum())) + 3)) + getDifficultyId())) + 2)) + getKillEliteMonsterNum())) + 10)) + Internal.hashBoolean(getIsNewRecord()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(InputStream input) throws IOException {
            return (CrystalLinkDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkDungeonSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CrystalLinkDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CrystalLinkDungeonSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (CrystalLinkDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkDungeonSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CrystalLinkDungeonSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkDungeonSettleInfoOuterClass$CrystalLinkDungeonSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CrystalLinkDungeonSettleInfoOrBuilder {
            private int levelId_;
            private int finalScore_;
            private int killNormalMonsterNum_;
            private int difficultyId_;
            private int killEliteMonsterNum_;
            private boolean isNewRecord_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CrystalLinkDungeonSettleInfoOuterClass.internal_static_CrystalLinkDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CrystalLinkDungeonSettleInfoOuterClass.internal_static_CrystalLinkDungeonSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkDungeonSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CrystalLinkDungeonSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.finalScore_ = 0;
                this.killNormalMonsterNum_ = 0;
                this.difficultyId_ = 0;
                this.killEliteMonsterNum_ = 0;
                this.isNewRecord_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CrystalLinkDungeonSettleInfoOuterClass.internal_static_CrystalLinkDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CrystalLinkDungeonSettleInfo getDefaultInstanceForType() {
                return CrystalLinkDungeonSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkDungeonSettleInfo build() {
                CrystalLinkDungeonSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkDungeonSettleInfo buildPartial() {
                CrystalLinkDungeonSettleInfo result = new CrystalLinkDungeonSettleInfo(this);
                result.levelId_ = this.levelId_;
                result.finalScore_ = this.finalScore_;
                result.killNormalMonsterNum_ = this.killNormalMonsterNum_;
                result.difficultyId_ = this.difficultyId_;
                result.killEliteMonsterNum_ = this.killEliteMonsterNum_;
                result.isNewRecord_ = this.isNewRecord_;
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
                if (other instanceof CrystalLinkDungeonSettleInfo) {
                    return mergeFrom((CrystalLinkDungeonSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CrystalLinkDungeonSettleInfo other) {
                if (other == CrystalLinkDungeonSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getFinalScore() != 0) {
                    setFinalScore(other.getFinalScore());
                }
                if (other.getKillNormalMonsterNum() != 0) {
                    setKillNormalMonsterNum(other.getKillNormalMonsterNum());
                }
                if (other.getDifficultyId() != 0) {
                    setDifficultyId(other.getDifficultyId());
                }
                if (other.getKillEliteMonsterNum() != 0) {
                    setKillEliteMonsterNum(other.getKillEliteMonsterNum());
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
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
                CrystalLinkDungeonSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CrystalLinkDungeonSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CrystalLinkDungeonSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
            public int getFinalScore() {
                return this.finalScore_;
            }

            public Builder setFinalScore(int value) {
                this.finalScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinalScore() {
                this.finalScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
            public int getKillNormalMonsterNum() {
                return this.killNormalMonsterNum_;
            }

            public Builder setKillNormalMonsterNum(int value) {
                this.killNormalMonsterNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillNormalMonsterNum() {
                this.killNormalMonsterNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
            public int getDifficultyId() {
                return this.difficultyId_;
            }

            public Builder setDifficultyId(int value) {
                this.difficultyId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDifficultyId() {
                this.difficultyId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
            public int getKillEliteMonsterNum() {
                return this.killEliteMonsterNum_;
            }

            public Builder setKillEliteMonsterNum(int value) {
                this.killEliteMonsterNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillEliteMonsterNum() {
                this.killEliteMonsterNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkDungeonSettleInfoOuterClass.CrystalLinkDungeonSettleInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static CrystalLinkDungeonSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CrystalLinkDungeonSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CrystalLinkDungeonSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CrystalLinkDungeonSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
