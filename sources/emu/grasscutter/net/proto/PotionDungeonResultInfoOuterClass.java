package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionDungeonResultInfoOuterClass.class */
public final class PotionDungeonResultInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dPotionDungeonResultInfo.proto\"\u0001\n\u0017PotionDungeonResultInfo\u0012\u000e\n\u0006modeId\u0018\f \u0001(\r\u0012\u0017\n\u000fdifficultyLevel\u0018\u0001 \u0001(\r\u0012\u0010\n\bleftTime\u0018\u0006 \u0001(\r\u0012\u000f\n\u0007levelId\u0018\u0002 \u0001(\r\u0012\u0012\n\nfinalScore\u0018\n \u0001(\r\u0012\u000f\n\u0007stageId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PotionDungeonResultInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PotionDungeonResultInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PotionDungeonResultInfo_descriptor, new String[]{"ModeId", "DifficultyLevel", "LeftTime", "LevelId", "FinalScore", "StageId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionDungeonResultInfoOuterClass$PotionDungeonResultInfoOrBuilder.class */
    public interface PotionDungeonResultInfoOrBuilder extends MessageOrBuilder {
        int getModeId();

        int getDifficultyLevel();

        int getLeftTime();

        int getLevelId();

        int getFinalScore();

        int getStageId();
    }

    private PotionDungeonResultInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionDungeonResultInfoOuterClass$PotionDungeonResultInfo.class */
    public static final class PotionDungeonResultInfo extends GeneratedMessageV3 implements PotionDungeonResultInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MODEID_FIELD_NUMBER = 12;
        private int modeId_;
        public static final int DIFFICULTYLEVEL_FIELD_NUMBER = 1;
        private int difficultyLevel_;
        public static final int LEFTTIME_FIELD_NUMBER = 6;
        private int leftTime_;
        public static final int LEVELID_FIELD_NUMBER = 2;
        private int levelId_;
        public static final int FINALSCORE_FIELD_NUMBER = 10;
        private int finalScore_;
        public static final int STAGEID_FIELD_NUMBER = 9;
        private int stageId_;
        private byte memoizedIsInitialized;
        private static final PotionDungeonResultInfo DEFAULT_INSTANCE = new PotionDungeonResultInfo();
        private static final Parser<PotionDungeonResultInfo> PARSER = new AbstractParser<PotionDungeonResultInfo>() { // from class: emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfo.1
            @Override // com.google.protobuf.Parser
            public PotionDungeonResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PotionDungeonResultInfo(input, extensionRegistry);
            }
        };

        private PotionDungeonResultInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PotionDungeonResultInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PotionDungeonResultInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PotionDungeonResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.difficultyLevel_ = input.readUInt32();
                                break;
                            case 16:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 48:
                                this.leftTime_ = input.readUInt32();
                                break;
                            case 72:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 80:
                                this.finalScore_ = input.readUInt32();
                                break;
                            case 96:
                                this.modeId_ = input.readUInt32();
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
            return PotionDungeonResultInfoOuterClass.internal_static_PotionDungeonResultInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PotionDungeonResultInfoOuterClass.internal_static_PotionDungeonResultInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionDungeonResultInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
        public int getModeId() {
            return this.modeId_;
        }

        @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
        public int getDifficultyLevel() {
            return this.difficultyLevel_;
        }

        @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
        public int getLeftTime() {
            return this.leftTime_;
        }

        @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
        public int getFinalScore() {
            return this.finalScore_;
        }

        @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
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
            if (this.difficultyLevel_ != 0) {
                output.writeUInt32(1, this.difficultyLevel_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(2, this.levelId_);
            }
            if (this.leftTime_ != 0) {
                output.writeUInt32(6, this.leftTime_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(9, this.stageId_);
            }
            if (this.finalScore_ != 0) {
                output.writeUInt32(10, this.finalScore_);
            }
            if (this.modeId_ != 0) {
                output.writeUInt32(12, this.modeId_);
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
            if (this.difficultyLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.difficultyLevel_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.levelId_);
            }
            if (this.leftTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.leftTime_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.stageId_);
            }
            if (this.finalScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.finalScore_);
            }
            if (this.modeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.modeId_);
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
            if (!(obj instanceof PotionDungeonResultInfo)) {
                return equals(obj);
            }
            PotionDungeonResultInfo other = (PotionDungeonResultInfo) obj;
            return getModeId() == other.getModeId() && getDifficultyLevel() == other.getDifficultyLevel() && getLeftTime() == other.getLeftTime() && getLevelId() == other.getLevelId() && getFinalScore() == other.getFinalScore() && getStageId() == other.getStageId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getModeId())) + 1)) + getDifficultyLevel())) + 6)) + getLeftTime())) + 2)) + getLevelId())) + 10)) + getFinalScore())) + 9)) + getStageId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PotionDungeonResultInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionDungeonResultInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionDungeonResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionDungeonResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionDungeonResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionDungeonResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionDungeonResultInfo parseFrom(InputStream input) throws IOException {
            return (PotionDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionDungeonResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionDungeonResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (PotionDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PotionDungeonResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionDungeonResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (PotionDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionDungeonResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PotionDungeonResultInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionDungeonResultInfoOuterClass$PotionDungeonResultInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PotionDungeonResultInfoOrBuilder {
            private int modeId_;
            private int difficultyLevel_;
            private int leftTime_;
            private int levelId_;
            private int finalScore_;
            private int stageId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PotionDungeonResultInfoOuterClass.internal_static_PotionDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PotionDungeonResultInfoOuterClass.internal_static_PotionDungeonResultInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionDungeonResultInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PotionDungeonResultInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.modeId_ = 0;
                this.difficultyLevel_ = 0;
                this.leftTime_ = 0;
                this.levelId_ = 0;
                this.finalScore_ = 0;
                this.stageId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PotionDungeonResultInfoOuterClass.internal_static_PotionDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PotionDungeonResultInfo getDefaultInstanceForType() {
                return PotionDungeonResultInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionDungeonResultInfo build() {
                PotionDungeonResultInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionDungeonResultInfo buildPartial() {
                PotionDungeonResultInfo result = new PotionDungeonResultInfo(this);
                result.modeId_ = this.modeId_;
                result.difficultyLevel_ = this.difficultyLevel_;
                result.leftTime_ = this.leftTime_;
                result.levelId_ = this.levelId_;
                result.finalScore_ = this.finalScore_;
                result.stageId_ = this.stageId_;
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
                if (other instanceof PotionDungeonResultInfo) {
                    return mergeFrom((PotionDungeonResultInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PotionDungeonResultInfo other) {
                if (other == PotionDungeonResultInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getModeId() != 0) {
                    setModeId(other.getModeId());
                }
                if (other.getDifficultyLevel() != 0) {
                    setDifficultyLevel(other.getDifficultyLevel());
                }
                if (other.getLeftTime() != 0) {
                    setLeftTime(other.getLeftTime());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getFinalScore() != 0) {
                    setFinalScore(other.getFinalScore());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
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
                PotionDungeonResultInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = PotionDungeonResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PotionDungeonResultInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
            public int getModeId() {
                return this.modeId_;
            }

            public Builder setModeId(int value) {
                this.modeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModeId() {
                this.modeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
            public int getDifficultyLevel() {
                return this.difficultyLevel_;
            }

            public Builder setDifficultyLevel(int value) {
                this.difficultyLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearDifficultyLevel() {
                this.difficultyLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
            public int getLeftTime() {
                return this.leftTime_;
            }

            public Builder setLeftTime(int value) {
                this.leftTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftTime() {
                this.leftTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.PotionDungeonResultInfoOuterClass.PotionDungeonResultInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static PotionDungeonResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PotionDungeonResultInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PotionDungeonResultInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PotionDungeonResultInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
