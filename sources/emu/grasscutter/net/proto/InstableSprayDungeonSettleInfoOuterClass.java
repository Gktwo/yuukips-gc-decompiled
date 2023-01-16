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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayDungeonSettleInfoOuterClass.class */
public final class InstableSprayDungeonSettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$InstableSprayDungeonSettleInfo.proto\"q\n\u001eInstableSprayDungeonSettleInfo\u0012\u0010\n\bstage_id\u0018\f \u0001(\r\u0012\u0012\n\ndifficulty\u0018\u000f \u0001(\r\u0012\u0015\n\ris_new_record\u0018\t \u0001(\b\u0012\u0012\n\nscore_list\u0018\u0003 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_InstableSprayDungeonSettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_InstableSprayDungeonSettleInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f764xe951d8d7 = new GeneratedMessageV3.FieldAccessorTable(internal_static_InstableSprayDungeonSettleInfo_descriptor, new String[]{"StageId", "Difficulty", "IsNewRecord", "ScoreList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayDungeonSettleInfoOuterClass$InstableSprayDungeonSettleInfoOrBuilder.class */
    public interface InstableSprayDungeonSettleInfoOrBuilder extends MessageOrBuilder {
        int getStageId();

        int getDifficulty();

        boolean getIsNewRecord();

        List<Integer> getScoreListList();

        int getScoreListCount();

        int getScoreList(int i);
    }

    private InstableSprayDungeonSettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayDungeonSettleInfoOuterClass$InstableSprayDungeonSettleInfo.class */
    public static final class InstableSprayDungeonSettleInfo extends GeneratedMessageV3 implements InstableSprayDungeonSettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 12;
        private int stageId_;
        public static final int DIFFICULTY_FIELD_NUMBER = 15;
        private int difficulty_;
        public static final int IS_NEW_RECORD_FIELD_NUMBER = 9;
        private boolean isNewRecord_;
        public static final int SCORE_LIST_FIELD_NUMBER = 3;
        private Internal.IntList scoreList_;
        private int scoreListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final InstableSprayDungeonSettleInfo DEFAULT_INSTANCE = new InstableSprayDungeonSettleInfo();
        private static final Parser<InstableSprayDungeonSettleInfo> PARSER = new AbstractParser<InstableSprayDungeonSettleInfo>() { // from class: emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfo.1
            @Override // com.google.protobuf.Parser
            public InstableSprayDungeonSettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InstableSprayDungeonSettleInfo(input, extensionRegistry);
            }
        };

        private InstableSprayDungeonSettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.scoreListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private InstableSprayDungeonSettleInfo() {
            this.scoreListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.scoreList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InstableSprayDungeonSettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InstableSprayDungeonSettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.scoreList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.scoreList_.addInt(input.readUInt32());
                                break;
                            case 26:
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
                            case 72:
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 96:
                                this.stageId_ = input.readUInt32();
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
            return InstableSprayDungeonSettleInfoOuterClass.internal_static_InstableSprayDungeonSettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstableSprayDungeonSettleInfoOuterClass.f764xe951d8d7.ensureFieldAccessorsInitialized(InstableSprayDungeonSettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
        public int getDifficulty() {
            return this.difficulty_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
        public List<Integer> getScoreListList() {
            return this.scoreList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
        public int getScoreListCount() {
            return this.scoreList_.size();
        }

        @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
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
            if (getScoreListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.scoreListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.scoreList_.size(); i++) {
                output.writeUInt32NoTag(this.scoreList_.getInt(i));
            }
            if (this.isNewRecord_) {
                output.writeBool(9, this.isNewRecord_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(12, this.stageId_);
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
            int dataSize = 0;
            for (int i = 0; i < this.scoreList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.scoreList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getScoreListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.scoreListMemoizedSerializedSize = dataSize;
            if (this.isNewRecord_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isNewRecord_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.stageId_);
            }
            if (this.difficulty_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.difficulty_);
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
            if (!(obj instanceof InstableSprayDungeonSettleInfo)) {
                return equals(obj);
            }
            InstableSprayDungeonSettleInfo other = (InstableSprayDungeonSettleInfo) obj;
            return getStageId() == other.getStageId() && getDifficulty() == other.getDifficulty() && getIsNewRecord() == other.getIsNewRecord() && getScoreListList().equals(other.getScoreListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getStageId())) + 15)) + getDifficulty())) + 9)) + Internal.hashBoolean(getIsNewRecord());
            if (getScoreListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getScoreListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static InstableSprayDungeonSettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(InputStream input) throws IOException {
            return (InstableSprayDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayDungeonSettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (InstableSprayDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InstableSprayDungeonSettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayDungeonSettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (InstableSprayDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayDungeonSettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayDungeonSettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InstableSprayDungeonSettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayDungeonSettleInfoOuterClass$InstableSprayDungeonSettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InstableSprayDungeonSettleInfoOrBuilder {
            private int bitField0_;
            private int stageId_;
            private int difficulty_;
            private boolean isNewRecord_;
            private Internal.IntList scoreList_ = InstableSprayDungeonSettleInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return InstableSprayDungeonSettleInfoOuterClass.internal_static_InstableSprayDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstableSprayDungeonSettleInfoOuterClass.f764xe951d8d7.ensureFieldAccessorsInitialized(InstableSprayDungeonSettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InstableSprayDungeonSettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                this.difficulty_ = 0;
                this.isNewRecord_ = false;
                this.scoreList_ = InstableSprayDungeonSettleInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstableSprayDungeonSettleInfoOuterClass.internal_static_InstableSprayDungeonSettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InstableSprayDungeonSettleInfo getDefaultInstanceForType() {
                return InstableSprayDungeonSettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayDungeonSettleInfo build() {
                InstableSprayDungeonSettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayDungeonSettleInfo buildPartial() {
                InstableSprayDungeonSettleInfo result = new InstableSprayDungeonSettleInfo(this);
                int i = this.bitField0_;
                result.stageId_ = this.stageId_;
                result.difficulty_ = this.difficulty_;
                result.isNewRecord_ = this.isNewRecord_;
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
                if (other instanceof InstableSprayDungeonSettleInfo) {
                    return mergeFrom((InstableSprayDungeonSettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InstableSprayDungeonSettleInfo other) {
                if (other == InstableSprayDungeonSettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getDifficulty() != 0) {
                    setDifficulty(other.getDifficulty());
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
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
                InstableSprayDungeonSettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = InstableSprayDungeonSettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InstableSprayDungeonSettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
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

            private void ensureScoreListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.scoreList_ = InstableSprayDungeonSettleInfo.mutableCopy(this.scoreList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
            public List<Integer> getScoreListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.scoreList_) : this.scoreList_;
            }

            @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
            public int getScoreListCount() {
                return this.scoreList_.size();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayDungeonSettleInfoOuterClass.InstableSprayDungeonSettleInfoOrBuilder
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
                this.scoreList_ = InstableSprayDungeonSettleInfo.emptyIntList();
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

        public static InstableSprayDungeonSettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InstableSprayDungeonSettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InstableSprayDungeonSettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InstableSprayDungeonSettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
