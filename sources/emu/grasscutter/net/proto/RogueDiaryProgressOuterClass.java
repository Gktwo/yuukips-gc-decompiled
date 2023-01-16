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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryProgressOuterClass.class */
public final class RogueDiaryProgressOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018RogueDiaryProgress.proto\"\u0001\n\u0012RogueDiaryProgress\u0012\u0012\n\ndifficulty\u0018\n \u0001(\r\u0012\u0018\n\u0010is_enter_dungeon\u0018\u0003 \u0001(\b\u0012\u0010\n\bstage_id\u0018\u0006 \u0001(\r\u0012\u001a\n\u0012optional_card_list\u0018\u0005 \u0003(\r\u0012\u0011\n\tcur_round\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RogueDiaryProgress_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueDiaryProgress_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueDiaryProgress_descriptor, new String[]{"Difficulty", "IsEnterDungeon", "StageId", "OptionalCardList", "CurRound"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryProgressOuterClass$RogueDiaryProgressOrBuilder.class */
    public interface RogueDiaryProgressOrBuilder extends MessageOrBuilder {
        int getDifficulty();

        boolean getIsEnterDungeon();

        int getStageId();

        List<Integer> getOptionalCardListList();

        int getOptionalCardListCount();

        int getOptionalCardList(int i);

        int getCurRound();
    }

    private RogueDiaryProgressOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryProgressOuterClass$RogueDiaryProgress.class */
    public static final class RogueDiaryProgress extends GeneratedMessageV3 implements RogueDiaryProgressOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DIFFICULTY_FIELD_NUMBER = 10;
        private int difficulty_;
        public static final int IS_ENTER_DUNGEON_FIELD_NUMBER = 3;
        private boolean isEnterDungeon_;
        public static final int STAGE_ID_FIELD_NUMBER = 6;
        private int stageId_;
        public static final int OPTIONAL_CARD_LIST_FIELD_NUMBER = 5;
        private Internal.IntList optionalCardList_;
        private int optionalCardListMemoizedSerializedSize;
        public static final int CUR_ROUND_FIELD_NUMBER = 4;
        private int curRound_;
        private byte memoizedIsInitialized;
        private static final RogueDiaryProgress DEFAULT_INSTANCE = new RogueDiaryProgress();
        private static final Parser<RogueDiaryProgress> PARSER = new AbstractParser<RogueDiaryProgress>() { // from class: emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgress.1
            @Override // com.google.protobuf.Parser
            public RogueDiaryProgress parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueDiaryProgress(input, extensionRegistry);
            }
        };

        private RogueDiaryProgress(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.optionalCardListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private RogueDiaryProgress() {
            this.optionalCardListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.optionalCardList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueDiaryProgress();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueDiaryProgress(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isEnterDungeon_ = input.readBool();
                                break;
                            case 32:
                                this.curRound_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.optionalCardList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.optionalCardList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.optionalCardList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.optionalCardList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                this.stageId_ = input.readUInt32();
                                break;
                            case 80:
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
                    this.optionalCardList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RogueDiaryProgressOuterClass.internal_static_RogueDiaryProgress_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueDiaryProgressOuterClass.internal_static_RogueDiaryProgress_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryProgress.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public int getDifficulty() {
            return this.difficulty_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public boolean getIsEnterDungeon() {
            return this.isEnterDungeon_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public List<Integer> getOptionalCardListList() {
            return this.optionalCardList_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public int getOptionalCardListCount() {
            return this.optionalCardList_.size();
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public int getOptionalCardList(int index) {
            return this.optionalCardList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
        public int getCurRound() {
            return this.curRound_;
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
            if (this.isEnterDungeon_) {
                output.writeBool(3, this.isEnterDungeon_);
            }
            if (this.curRound_ != 0) {
                output.writeUInt32(4, this.curRound_);
            }
            if (getOptionalCardListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.optionalCardListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.optionalCardList_.size(); i++) {
                output.writeUInt32NoTag(this.optionalCardList_.getInt(i));
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(6, this.stageId_);
            }
            if (this.difficulty_ != 0) {
                output.writeUInt32(10, this.difficulty_);
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
            if (this.isEnterDungeon_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isEnterDungeon_);
            }
            if (this.curRound_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.curRound_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.optionalCardList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.optionalCardList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getOptionalCardListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.optionalCardListMemoizedSerializedSize = dataSize;
            if (this.stageId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.stageId_);
            }
            if (this.difficulty_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.difficulty_);
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
            if (!(obj instanceof RogueDiaryProgress)) {
                return equals(obj);
            }
            RogueDiaryProgress other = (RogueDiaryProgress) obj;
            return getDifficulty() == other.getDifficulty() && getIsEnterDungeon() == other.getIsEnterDungeon() && getStageId() == other.getStageId() && getOptionalCardListList().equals(other.getOptionalCardListList()) && getCurRound() == other.getCurRound() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getDifficulty())) + 3)) + Internal.hashBoolean(getIsEnterDungeon()))) + 6)) + getStageId();
            if (getOptionalCardListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getOptionalCardListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getCurRound())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static RogueDiaryProgress parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryProgress parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryProgress parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryProgress parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryProgress parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryProgress parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryProgress parseFrom(InputStream input) throws IOException {
            return (RogueDiaryProgress) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryProgress parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryProgress) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryProgress parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueDiaryProgress) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueDiaryProgress parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryProgress) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryProgress parseFrom(CodedInputStream input) throws IOException {
            return (RogueDiaryProgress) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryProgress parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryProgress) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueDiaryProgress prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryProgressOuterClass$RogueDiaryProgress$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueDiaryProgressOrBuilder {
            private int bitField0_;
            private int difficulty_;
            private boolean isEnterDungeon_;
            private int stageId_;
            private Internal.IntList optionalCardList_ = RogueDiaryProgress.emptyIntList();
            private int curRound_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueDiaryProgressOuterClass.internal_static_RogueDiaryProgress_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueDiaryProgressOuterClass.internal_static_RogueDiaryProgress_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryProgress.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueDiaryProgress.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.difficulty_ = 0;
                this.isEnterDungeon_ = false;
                this.stageId_ = 0;
                this.optionalCardList_ = RogueDiaryProgress.emptyIntList();
                this.bitField0_ &= -2;
                this.curRound_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueDiaryProgressOuterClass.internal_static_RogueDiaryProgress_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueDiaryProgress getDefaultInstanceForType() {
                return RogueDiaryProgress.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryProgress build() {
                RogueDiaryProgress result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryProgress buildPartial() {
                RogueDiaryProgress result = new RogueDiaryProgress(this);
                int i = this.bitField0_;
                result.difficulty_ = this.difficulty_;
                result.isEnterDungeon_ = this.isEnterDungeon_;
                result.stageId_ = this.stageId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.optionalCardList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.optionalCardList_ = this.optionalCardList_;
                result.curRound_ = this.curRound_;
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
                if (other instanceof RogueDiaryProgress) {
                    return mergeFrom((RogueDiaryProgress) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueDiaryProgress other) {
                if (other == RogueDiaryProgress.getDefaultInstance()) {
                    return this;
                }
                if (other.getDifficulty() != 0) {
                    setDifficulty(other.getDifficulty());
                }
                if (other.getIsEnterDungeon()) {
                    setIsEnterDungeon(other.getIsEnterDungeon());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (!other.optionalCardList_.isEmpty()) {
                    if (this.optionalCardList_.isEmpty()) {
                        this.optionalCardList_ = other.optionalCardList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOptionalCardListIsMutable();
                        this.optionalCardList_.addAll(other.optionalCardList_);
                    }
                    onChanged();
                }
                if (other.getCurRound() != 0) {
                    setCurRound(other.getCurRound());
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
                RogueDiaryProgress parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueDiaryProgress.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueDiaryProgress) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
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

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
            public boolean getIsEnterDungeon() {
                return this.isEnterDungeon_;
            }

            public Builder setIsEnterDungeon(boolean value) {
                this.isEnterDungeon_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEnterDungeon() {
                this.isEnterDungeon_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
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

            private void ensureOptionalCardListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.optionalCardList_ = RogueDiaryProgress.mutableCopy(this.optionalCardList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
            public List<Integer> getOptionalCardListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.optionalCardList_) : this.optionalCardList_;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
            public int getOptionalCardListCount() {
                return this.optionalCardList_.size();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
            public int getOptionalCardList(int index) {
                return this.optionalCardList_.getInt(index);
            }

            public Builder setOptionalCardList(int index, int value) {
                ensureOptionalCardListIsMutable();
                this.optionalCardList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOptionalCardList(int value) {
                ensureOptionalCardListIsMutable();
                this.optionalCardList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOptionalCardList(Iterable<? extends Integer> values) {
                ensureOptionalCardListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.optionalCardList_);
                onChanged();
                return this;
            }

            public Builder clearOptionalCardList() {
                this.optionalCardList_ = RogueDiaryProgress.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder
            public int getCurRound() {
                return this.curRound_;
            }

            public Builder setCurRound(int value) {
                this.curRound_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurRound() {
                this.curRound_ = 0;
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

        public static RogueDiaryProgress getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueDiaryProgress> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueDiaryProgress> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueDiaryProgress getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
