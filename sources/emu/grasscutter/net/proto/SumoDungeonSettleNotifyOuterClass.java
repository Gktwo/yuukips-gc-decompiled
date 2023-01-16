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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoDungeonSettleNotifyOuterClass.class */
public final class SumoDungeonSettleNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dSumoDungeonSettleNotify.proto\"¨\u0001\n\u0017SumoDungeonSettleNotify\u0012\u0015\n\ris_new_record\u0018\u0004 \u0001(\b\u0012\u0018\n\u0010kill_monster_num\u0018\f \u0001(\r\u0012\u0015\n\rdifficulty_id\u0018\u0003 \u0001(\r\u0012\u0013\n\u000bfinal_score\u0018\u0002 \u0001(\r\u0012\u001e\n\u0016kill_elite_monster_num\u0018\u000f \u0001(\r\u0012\u0010\n\bstage_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SumoDungeonSettleNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SumoDungeonSettleNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SumoDungeonSettleNotify_descriptor, new String[]{"IsNewRecord", "KillMonsterNum", "DifficultyId", "FinalScore", "KillEliteMonsterNum", "StageId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoDungeonSettleNotifyOuterClass$SumoDungeonSettleNotifyOrBuilder.class */
    public interface SumoDungeonSettleNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsNewRecord();

        int getKillMonsterNum();

        int getDifficultyId();

        int getFinalScore();

        int getKillEliteMonsterNum();

        int getStageId();
    }

    private SumoDungeonSettleNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoDungeonSettleNotifyOuterClass$SumoDungeonSettleNotify.class */
    public static final class SumoDungeonSettleNotify extends GeneratedMessageV3 implements SumoDungeonSettleNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_NEW_RECORD_FIELD_NUMBER = 4;
        private boolean isNewRecord_;
        public static final int KILL_MONSTER_NUM_FIELD_NUMBER = 12;
        private int killMonsterNum_;
        public static final int DIFFICULTY_ID_FIELD_NUMBER = 3;
        private int difficultyId_;
        public static final int FINAL_SCORE_FIELD_NUMBER = 2;
        private int finalScore_;
        public static final int KILL_ELITE_MONSTER_NUM_FIELD_NUMBER = 15;
        private int killEliteMonsterNum_;
        public static final int STAGE_ID_FIELD_NUMBER = 11;
        private int stageId_;
        private byte memoizedIsInitialized;
        private static final SumoDungeonSettleNotify DEFAULT_INSTANCE = new SumoDungeonSettleNotify();
        private static final Parser<SumoDungeonSettleNotify> PARSER = new AbstractParser<SumoDungeonSettleNotify>() { // from class: emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotify.1
            @Override // com.google.protobuf.Parser
            public SumoDungeonSettleNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SumoDungeonSettleNotify(input, extensionRegistry);
            }
        };

        private SumoDungeonSettleNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SumoDungeonSettleNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SumoDungeonSettleNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SumoDungeonSettleNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.finalScore_ = input.readUInt32();
                                break;
                            case 24:
                                this.difficultyId_ = input.readUInt32();
                                break;
                            case 32:
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 88:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 96:
                                this.killMonsterNum_ = input.readUInt32();
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
            return SumoDungeonSettleNotifyOuterClass.internal_static_SumoDungeonSettleNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SumoDungeonSettleNotifyOuterClass.internal_static_SumoDungeonSettleNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoDungeonSettleNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
        }

        @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
        public int getKillMonsterNum() {
            return this.killMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
        public int getDifficultyId() {
            return this.difficultyId_;
        }

        @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
        public int getFinalScore() {
            return this.finalScore_;
        }

        @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
        public int getKillEliteMonsterNum() {
            return this.killEliteMonsterNum_;
        }

        @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
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
            if (this.finalScore_ != 0) {
                output.writeUInt32(2, this.finalScore_);
            }
            if (this.difficultyId_ != 0) {
                output.writeUInt32(3, this.difficultyId_);
            }
            if (this.isNewRecord_) {
                output.writeBool(4, this.isNewRecord_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(11, this.stageId_);
            }
            if (this.killMonsterNum_ != 0) {
                output.writeUInt32(12, this.killMonsterNum_);
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
            if (this.finalScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.finalScore_);
            }
            if (this.difficultyId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.difficultyId_);
            }
            if (this.isNewRecord_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isNewRecord_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.stageId_);
            }
            if (this.killMonsterNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.killMonsterNum_);
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
            if (!(obj instanceof SumoDungeonSettleNotify)) {
                return equals(obj);
            }
            SumoDungeonSettleNotify other = (SumoDungeonSettleNotify) obj;
            return getIsNewRecord() == other.getIsNewRecord() && getKillMonsterNum() == other.getKillMonsterNum() && getDifficultyId() == other.getDifficultyId() && getFinalScore() == other.getFinalScore() && getKillEliteMonsterNum() == other.getKillEliteMonsterNum() && getStageId() == other.getStageId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsNewRecord()))) + 12)) + getKillMonsterNum())) + 3)) + getDifficultyId())) + 2)) + getFinalScore())) + 15)) + getKillEliteMonsterNum())) + 11)) + getStageId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SumoDungeonSettleNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoDungeonSettleNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoDungeonSettleNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoDungeonSettleNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoDungeonSettleNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SumoDungeonSettleNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SumoDungeonSettleNotify parseFrom(InputStream input) throws IOException {
            return (SumoDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoDungeonSettleNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoDungeonSettleNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SumoDungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SumoDungeonSettleNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoDungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SumoDungeonSettleNotify parseFrom(CodedInputStream input) throws IOException {
            return (SumoDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SumoDungeonSettleNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SumoDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SumoDungeonSettleNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SumoDungeonSettleNotifyOuterClass$SumoDungeonSettleNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SumoDungeonSettleNotifyOrBuilder {
            private boolean isNewRecord_;
            private int killMonsterNum_;
            private int difficultyId_;
            private int finalScore_;
            private int killEliteMonsterNum_;
            private int stageId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SumoDungeonSettleNotifyOuterClass.internal_static_SumoDungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SumoDungeonSettleNotifyOuterClass.internal_static_SumoDungeonSettleNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SumoDungeonSettleNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SumoDungeonSettleNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isNewRecord_ = false;
                this.killMonsterNum_ = 0;
                this.difficultyId_ = 0;
                this.finalScore_ = 0;
                this.killEliteMonsterNum_ = 0;
                this.stageId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SumoDungeonSettleNotifyOuterClass.internal_static_SumoDungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SumoDungeonSettleNotify getDefaultInstanceForType() {
                return SumoDungeonSettleNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoDungeonSettleNotify build() {
                SumoDungeonSettleNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SumoDungeonSettleNotify buildPartial() {
                SumoDungeonSettleNotify result = new SumoDungeonSettleNotify(this);
                result.isNewRecord_ = this.isNewRecord_;
                result.killMonsterNum_ = this.killMonsterNum_;
                result.difficultyId_ = this.difficultyId_;
                result.finalScore_ = this.finalScore_;
                result.killEliteMonsterNum_ = this.killEliteMonsterNum_;
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
                if (other instanceof SumoDungeonSettleNotify) {
                    return mergeFrom((SumoDungeonSettleNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SumoDungeonSettleNotify other) {
                if (other == SumoDungeonSettleNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
                }
                if (other.getKillMonsterNum() != 0) {
                    setKillMonsterNum(other.getKillMonsterNum());
                }
                if (other.getDifficultyId() != 0) {
                    setDifficultyId(other.getDifficultyId());
                }
                if (other.getFinalScore() != 0) {
                    setFinalScore(other.getFinalScore());
                }
                if (other.getKillEliteMonsterNum() != 0) {
                    setKillEliteMonsterNum(other.getKillEliteMonsterNum());
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
                SumoDungeonSettleNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SumoDungeonSettleNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SumoDungeonSettleNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
            public int getKillMonsterNum() {
                return this.killMonsterNum_;
            }

            public Builder setKillMonsterNum(int value) {
                this.killMonsterNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearKillMonsterNum() {
                this.killMonsterNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.SumoDungeonSettleNotifyOuterClass.SumoDungeonSettleNotifyOrBuilder
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

        public static SumoDungeonSettleNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SumoDungeonSettleNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SumoDungeonSettleNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SumoDungeonSettleNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
