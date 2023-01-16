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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionLevelDataOuterClass.class */
public final class PotionLevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015PotionLevelData.proto\"]\n\u000fPotionLevelData\u0012\u0018\n\u0010difficulty_level\u0018\u0003 \u0001(\r\u0012\u000f\n\u0007mode_id\u0018\u0007 \u0001(\r\u0012\r\n\u0005score\u0018\u0001 \u0001(\r\u0012\u0010\n\blevel_id\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PotionLevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PotionLevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PotionLevelData_descriptor, new String[]{"DifficultyLevel", "ModeId", "Score", "LevelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionLevelDataOuterClass$PotionLevelDataOrBuilder.class */
    public interface PotionLevelDataOrBuilder extends MessageOrBuilder {
        int getDifficultyLevel();

        int getModeId();

        int getScore();

        int getLevelId();
    }

    private PotionLevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionLevelDataOuterClass$PotionLevelData.class */
    public static final class PotionLevelData extends GeneratedMessageV3 implements PotionLevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DIFFICULTY_LEVEL_FIELD_NUMBER = 3;
        private int difficultyLevel_;
        public static final int MODE_ID_FIELD_NUMBER = 7;
        private int modeId_;
        public static final int SCORE_FIELD_NUMBER = 1;
        private int score_;
        public static final int LEVEL_ID_FIELD_NUMBER = 9;
        private int levelId_;
        private byte memoizedIsInitialized;
        private static final PotionLevelData DEFAULT_INSTANCE = new PotionLevelData();
        private static final Parser<PotionLevelData> PARSER = new AbstractParser<PotionLevelData>() { // from class: emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelData.1
            @Override // com.google.protobuf.Parser
            public PotionLevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PotionLevelData(input, extensionRegistry);
            }
        };

        private PotionLevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PotionLevelData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PotionLevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PotionLevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.score_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.difficultyLevel_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.modeId_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.levelId_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PotionLevelDataOuterClass.internal_static_PotionLevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PotionLevelDataOuterClass.internal_static_PotionLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionLevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
        public int getDifficultyLevel() {
            return this.difficultyLevel_;
        }

        @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
        public int getModeId() {
            return this.modeId_;
        }

        @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
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
            if (this.score_ != 0) {
                output.writeUInt32(1, this.score_);
            }
            if (this.difficultyLevel_ != 0) {
                output.writeUInt32(3, this.difficultyLevel_);
            }
            if (this.modeId_ != 0) {
                output.writeUInt32(7, this.modeId_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(9, this.levelId_);
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
            if (this.score_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.score_);
            }
            if (this.difficultyLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.difficultyLevel_);
            }
            if (this.modeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.modeId_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.levelId_);
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
            if (!(obj instanceof PotionLevelData)) {
                return equals(obj);
            }
            PotionLevelData other = (PotionLevelData) obj;
            return getDifficultyLevel() == other.getDifficultyLevel() && getModeId() == other.getModeId() && getScore() == other.getScore() && getLevelId() == other.getLevelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getDifficultyLevel())) + 7)) + getModeId())) + 1)) + getScore())) + 9)) + getLevelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PotionLevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionLevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionLevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionLevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionLevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionLevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionLevelData parseFrom(InputStream input) throws IOException {
            return (PotionLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionLevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionLevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (PotionLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PotionLevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionLevelData parseFrom(CodedInputStream input) throws IOException {
            return (PotionLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionLevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PotionLevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionLevelDataOuterClass$PotionLevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PotionLevelDataOrBuilder {
            private int difficultyLevel_;
            private int modeId_;
            private int score_;
            private int levelId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return PotionLevelDataOuterClass.internal_static_PotionLevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PotionLevelDataOuterClass.internal_static_PotionLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionLevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PotionLevelData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.difficultyLevel_ = 0;
                this.modeId_ = 0;
                this.score_ = 0;
                this.levelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PotionLevelDataOuterClass.internal_static_PotionLevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PotionLevelData getDefaultInstanceForType() {
                return PotionLevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionLevelData build() {
                PotionLevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionLevelData buildPartial() {
                PotionLevelData result = new PotionLevelData(this);
                result.difficultyLevel_ = this.difficultyLevel_;
                result.modeId_ = this.modeId_;
                result.score_ = this.score_;
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
                if (other instanceof PotionLevelData) {
                    return mergeFrom((PotionLevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PotionLevelData other) {
                if (other == PotionLevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getDifficultyLevel() != 0) {
                    setDifficultyLevel(other.getDifficultyLevel());
                }
                if (other.getModeId() != 0) {
                    setModeId(other.getModeId());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
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
                PotionLevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = PotionLevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PotionLevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionLevelDataOuterClass.PotionLevelDataOrBuilder
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

        public static PotionLevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PotionLevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PotionLevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PotionLevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
