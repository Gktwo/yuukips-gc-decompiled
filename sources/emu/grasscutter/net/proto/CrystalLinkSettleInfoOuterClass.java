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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkSettleInfoOuterClass.class */
public final class CrystalLinkSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bCrystalLinkSettleInfo.proto\"¢\u0001\n\u0015CrystalLinkSettleInfo\u0012\u001c\n\u0014killNormalMonsterNum\u0018\u000b \u0001(\r\u0012\u0013\n\u000bisNewRecord\u0018\u0006 \u0001(\b\u0012\u0012\n\nfinalScore\u0018\r \u0001(\r\u0012\u001b\n\u0013killEliteMonsterNum\u0018\u000f \u0001(\r\u0012\u0014\n\fdifficultyId\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007levelId\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CrystalLinkSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CrystalLinkSettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CrystalLinkSettleInfo_descriptor, new String[]{"KillNormalMonsterNum", "IsNewRecord", "FinalScore", "KillEliteMonsterNum", "DifficultyId", "LevelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkSettleInfoOuterClass$CrystalLinkSettleInfoOrBuilder.class */
    public interface CrystalLinkSettleInfoOrBuilder extends MessageOrBuilder {
        int getKillNormalMonsterNum();

        boolean getIsNewRecord();

        int getFinalScore();

        int getKillEliteMonsterNum();

        int getDifficultyId();

        int getLevelId();
    }

    private CrystalLinkSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkSettleInfoOuterClass$CrystalLinkSettleInfo.class */
    public static final class CrystalLinkSettleInfo extends GeneratedMessageV3 implements CrystalLinkSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int KILLNORMALMONSTERNUM_FIELD_NUMBER = 11;
        private int killNormalMonsterNum_;
        public static final int ISNEWRECORD_FIELD_NUMBER = 6;
        private boolean isNewRecord_;
        public static final int FINALSCORE_FIELD_NUMBER = 13;
        private int finalScore_;
        public static final int KILLELITEMONSTERNUM_FIELD_NUMBER = 15;
        private int killEliteMonsterNum_;
        public static final int DIFFICULTYID_FIELD_NUMBER = 3;
        private int difficultyId_;
        public static final int LEVELID_FIELD_NUMBER = 10;
        private int levelId_;
        private byte memoizedIsInitialized;
        private static final CrystalLinkSettleInfo DEFAULT_INSTANCE = new CrystalLinkSettleInfo();
        private static final Parser<CrystalLinkSettleInfo> PARSER = new AbstractParser<CrystalLinkSettleInfo>() { // from class: emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfo.1
            @Override // com.google.protobuf.Parser
            public CrystalLinkSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CrystalLinkSettleInfo(input, extensionRegistry);
            }
        };

        private CrystalLinkSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CrystalLinkSettleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CrystalLinkSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CrystalLinkSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.difficultyId_ = input.readUInt32();
                                break;
                            case 48:
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 80:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 88:
                                this.killNormalMonsterNum_ = input.readUInt32();
                                break;
                            case 104:
                                this.finalScore_ = input.readUInt32();
                                break;
                            case 120:
                                this.killEliteMonsterNum_ = input.readUInt32();
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
            return CrystalLinkSettleInfoOuterClass.internal_static_CrystalLinkSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CrystalLinkSettleInfoOuterClass.internal_static_CrystalLinkSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
        public int getKillNormalMonsterNum() {
            return this.killNormalMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
        public int getFinalScore() {
            return this.finalScore_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
        public int getKillEliteMonsterNum() {
            return this.killEliteMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
        public int getDifficultyId() {
            return this.difficultyId_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
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
            if (this.difficultyId_ != 0) {
                output.writeUInt32(3, this.difficultyId_);
            }
            if (this.isNewRecord_) {
                output.writeBool(6, this.isNewRecord_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(10, this.levelId_);
            }
            if (this.killNormalMonsterNum_ != 0) {
                output.writeUInt32(11, this.killNormalMonsterNum_);
            }
            if (this.finalScore_ != 0) {
                output.writeUInt32(13, this.finalScore_);
            }
            if (this.killEliteMonsterNum_ != 0) {
                output.writeUInt32(15, this.killEliteMonsterNum_);
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
            if (this.difficultyId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.difficultyId_);
            }
            if (this.isNewRecord_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isNewRecord_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.levelId_);
            }
            if (this.killNormalMonsterNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.killNormalMonsterNum_);
            }
            if (this.finalScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.finalScore_);
            }
            if (this.killEliteMonsterNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.killEliteMonsterNum_);
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
            if (!(obj instanceof CrystalLinkSettleInfo)) {
                return equals(obj);
            }
            CrystalLinkSettleInfo other = (CrystalLinkSettleInfo) obj;
            return getKillNormalMonsterNum() == other.getKillNormalMonsterNum() && getIsNewRecord() == other.getIsNewRecord() && getFinalScore() == other.getFinalScore() && getKillEliteMonsterNum() == other.getKillEliteMonsterNum() && getDifficultyId() == other.getDifficultyId() && getLevelId() == other.getLevelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getKillNormalMonsterNum())) + 6)) + Internal.hashBoolean(getIsNewRecord()))) + 13)) + getFinalScore())) + 15)) + getKillEliteMonsterNum())) + 3)) + getDifficultyId())) + 10)) + getLevelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CrystalLinkSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkSettleInfo parseFrom(InputStream input) throws IOException {
            return (CrystalLinkSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CrystalLinkSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CrystalLinkSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (CrystalLinkSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CrystalLinkSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkSettleInfoOuterClass$CrystalLinkSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CrystalLinkSettleInfoOrBuilder {
            private int killNormalMonsterNum_;
            private boolean isNewRecord_;
            private int finalScore_;
            private int killEliteMonsterNum_;
            private int difficultyId_;
            private int levelId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CrystalLinkSettleInfoOuterClass.internal_static_CrystalLinkSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CrystalLinkSettleInfoOuterClass.internal_static_CrystalLinkSettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CrystalLinkSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.killNormalMonsterNum_ = 0;
                this.isNewRecord_ = false;
                this.finalScore_ = 0;
                this.killEliteMonsterNum_ = 0;
                this.difficultyId_ = 0;
                this.levelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CrystalLinkSettleInfoOuterClass.internal_static_CrystalLinkSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CrystalLinkSettleInfo getDefaultInstanceForType() {
                return CrystalLinkSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkSettleInfo build() {
                CrystalLinkSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkSettleInfo buildPartial() {
                CrystalLinkSettleInfo result = new CrystalLinkSettleInfo(this);
                result.killNormalMonsterNum_ = this.killNormalMonsterNum_;
                result.isNewRecord_ = this.isNewRecord_;
                result.finalScore_ = this.finalScore_;
                result.killEliteMonsterNum_ = this.killEliteMonsterNum_;
                result.difficultyId_ = this.difficultyId_;
                result.levelId_ = this.levelId_;
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
                if (other instanceof CrystalLinkSettleInfo) {
                    return mergeFrom((CrystalLinkSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CrystalLinkSettleInfo other) {
                if (other == CrystalLinkSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getKillNormalMonsterNum() != 0) {
                    setKillNormalMonsterNum(other.getKillNormalMonsterNum());
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
                }
                if (other.getFinalScore() != 0) {
                    setFinalScore(other.getFinalScore());
                }
                if (other.getKillEliteMonsterNum() != 0) {
                    setKillEliteMonsterNum(other.getKillEliteMonsterNum());
                }
                if (other.getDifficultyId() != 0) {
                    setDifficultyId(other.getDifficultyId());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
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
                CrystalLinkSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CrystalLinkSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CrystalLinkSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.CrystalLinkSettleInfoOuterClass.CrystalLinkSettleInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static CrystalLinkSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CrystalLinkSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CrystalLinkSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CrystalLinkSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
