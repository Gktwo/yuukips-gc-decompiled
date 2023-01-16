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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerLevelInfoOuterClass.class */
public final class BrickBreakerLevelInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bBrickBreakerLevelInfo.proto\"\u0001\n\u0015BrickBreakerLevelInfo\u0012\u001a\n\u0012chosen_avatar_list\u0018\u0005 \u0003(\r\u0012\u0010\n\blevel_id\u0018\u0003 \u0001(\r\u0012\u0011\n\tis_finish\u0018\r \u0001(\b\u0012\u0011\n\tmax_score\u0018\b \u0001(\r\u0012\u0019\n\u0011chosen_skill_list\u0018\u000e \u0003(\r\u0012\u0014\n\fis_can_start\u0018\u0001 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BrickBreakerLevelInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BrickBreakerLevelInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BrickBreakerLevelInfo_descriptor, new String[]{"ChosenAvatarList", "LevelId", "IsFinish", "MaxScore", "ChosenSkillList", "IsCanStart"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerLevelInfoOuterClass$BrickBreakerLevelInfoOrBuilder.class */
    public interface BrickBreakerLevelInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getChosenAvatarListList();

        int getChosenAvatarListCount();

        int getChosenAvatarList(int i);

        int getLevelId();

        boolean getIsFinish();

        int getMaxScore();

        List<Integer> getChosenSkillListList();

        int getChosenSkillListCount();

        int getChosenSkillList(int i);

        boolean getIsCanStart();
    }

    private BrickBreakerLevelInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerLevelInfoOuterClass$BrickBreakerLevelInfo.class */
    public static final class BrickBreakerLevelInfo extends GeneratedMessageV3 implements BrickBreakerLevelInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHOSEN_AVATAR_LIST_FIELD_NUMBER = 5;
        private Internal.IntList chosenAvatarList_;
        private int chosenAvatarListMemoizedSerializedSize;
        public static final int LEVEL_ID_FIELD_NUMBER = 3;
        private int levelId_;
        public static final int IS_FINISH_FIELD_NUMBER = 13;
        private boolean isFinish_;
        public static final int MAX_SCORE_FIELD_NUMBER = 8;
        private int maxScore_;
        public static final int CHOSEN_SKILL_LIST_FIELD_NUMBER = 14;
        private Internal.IntList chosenSkillList_;
        private int chosenSkillListMemoizedSerializedSize;
        public static final int IS_CAN_START_FIELD_NUMBER = 1;
        private boolean isCanStart_;
        private byte memoizedIsInitialized;
        private static final BrickBreakerLevelInfo DEFAULT_INSTANCE = new BrickBreakerLevelInfo();
        private static final Parser<BrickBreakerLevelInfo> PARSER = new AbstractParser<BrickBreakerLevelInfo>() { // from class: emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfo.1
            @Override // com.google.protobuf.Parser
            public BrickBreakerLevelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BrickBreakerLevelInfo(input, extensionRegistry);
            }
        };

        private BrickBreakerLevelInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.chosenAvatarListMemoizedSerializedSize = -1;
            this.chosenSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BrickBreakerLevelInfo() {
            this.chosenAvatarListMemoizedSerializedSize = -1;
            this.chosenSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.chosenAvatarList_ = emptyIntList();
            this.chosenSkillList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BrickBreakerLevelInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0188 */
        private BrickBreakerLevelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.isCanStart_ = input.readBool();
                                    break;
                                case 24:
                                    this.levelId_ = input.readUInt32();
                                    break;
                                case 40:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.chosenAvatarList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.chosenAvatarList_.addInt(input.readUInt32());
                                    break;
                                case 42:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.chosenAvatarList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.chosenAvatarList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 64:
                                    this.maxScore_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 112:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.chosenSkillList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.chosenSkillList_.addInt(input.readUInt32());
                                    break;
                                case 114:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.chosenSkillList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.chosenSkillList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.chosenAvatarList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.chosenSkillList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BrickBreakerLevelInfoOuterClass.internal_static_BrickBreakerLevelInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BrickBreakerLevelInfoOuterClass.internal_static_BrickBreakerLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BrickBreakerLevelInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public List<Integer> getChosenAvatarListList() {
            return this.chosenAvatarList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public int getChosenAvatarListCount() {
            return this.chosenAvatarList_.size();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public int getChosenAvatarList(int index) {
            return this.chosenAvatarList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public int getMaxScore() {
            return this.maxScore_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public List<Integer> getChosenSkillListList() {
            return this.chosenSkillList_;
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public int getChosenSkillListCount() {
            return this.chosenSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public int getChosenSkillList(int index) {
            return this.chosenSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
        public boolean getIsCanStart() {
            return this.isCanStart_;
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
            if (this.isCanStart_) {
                output.writeBool(1, this.isCanStart_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(3, this.levelId_);
            }
            if (getChosenAvatarListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.chosenAvatarListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.chosenAvatarList_.size(); i++) {
                output.writeUInt32NoTag(this.chosenAvatarList_.getInt(i));
            }
            if (this.maxScore_ != 0) {
                output.writeUInt32(8, this.maxScore_);
            }
            if (this.isFinish_) {
                output.writeBool(13, this.isFinish_);
            }
            if (getChosenSkillListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.chosenSkillListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.chosenSkillList_.size(); i2++) {
                output.writeUInt32NoTag(this.chosenSkillList_.getInt(i2));
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
            if (this.isCanStart_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isCanStart_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.levelId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.chosenAvatarList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.chosenAvatarList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getChosenAvatarListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.chosenAvatarListMemoizedSerializedSize = dataSize;
            if (this.maxScore_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(8, this.maxScore_);
            }
            if (this.isFinish_) {
                size3 += CodedOutputStream.computeBoolSize(13, this.isFinish_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.chosenSkillList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.chosenSkillList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getChosenSkillListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.chosenSkillListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BrickBreakerLevelInfo)) {
                return equals(obj);
            }
            BrickBreakerLevelInfo other = (BrickBreakerLevelInfo) obj;
            return getChosenAvatarListList().equals(other.getChosenAvatarListList()) && getLevelId() == other.getLevelId() && getIsFinish() == other.getIsFinish() && getMaxScore() == other.getMaxScore() && getChosenSkillListList().equals(other.getChosenSkillListList()) && getIsCanStart() == other.getIsCanStart() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getChosenAvatarListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getChosenAvatarListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getLevelId())) + 13)) + Internal.hashBoolean(getIsFinish()))) + 8)) + getMaxScore();
            if (getChosenSkillListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getChosenSkillListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 1)) + Internal.hashBoolean(getIsCanStart()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static BrickBreakerLevelInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerLevelInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerLevelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerLevelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerLevelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BrickBreakerLevelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BrickBreakerLevelInfo parseFrom(InputStream input) throws IOException {
            return (BrickBreakerLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BrickBreakerLevelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BrickBreakerLevelInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BrickBreakerLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BrickBreakerLevelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BrickBreakerLevelInfo parseFrom(CodedInputStream input) throws IOException {
            return (BrickBreakerLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BrickBreakerLevelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BrickBreakerLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BrickBreakerLevelInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BrickBreakerLevelInfoOuterClass$BrickBreakerLevelInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BrickBreakerLevelInfoOrBuilder {
            private int bitField0_;
            private int levelId_;
            private boolean isFinish_;
            private int maxScore_;
            private boolean isCanStart_;
            private Internal.IntList chosenAvatarList_ = BrickBreakerLevelInfo.emptyIntList();
            private Internal.IntList chosenSkillList_ = BrickBreakerLevelInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BrickBreakerLevelInfoOuterClass.internal_static_BrickBreakerLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BrickBreakerLevelInfoOuterClass.internal_static_BrickBreakerLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BrickBreakerLevelInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BrickBreakerLevelInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.chosenAvatarList_ = BrickBreakerLevelInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.levelId_ = 0;
                this.isFinish_ = false;
                this.maxScore_ = 0;
                this.chosenSkillList_ = BrickBreakerLevelInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.isCanStart_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BrickBreakerLevelInfoOuterClass.internal_static_BrickBreakerLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BrickBreakerLevelInfo getDefaultInstanceForType() {
                return BrickBreakerLevelInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BrickBreakerLevelInfo build() {
                BrickBreakerLevelInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BrickBreakerLevelInfo buildPartial() {
                BrickBreakerLevelInfo result = new BrickBreakerLevelInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.chosenAvatarList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.chosenAvatarList_ = this.chosenAvatarList_;
                result.levelId_ = this.levelId_;
                result.isFinish_ = this.isFinish_;
                result.maxScore_ = this.maxScore_;
                if ((this.bitField0_ & 2) != 0) {
                    this.chosenSkillList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.chosenSkillList_ = this.chosenSkillList_;
                result.isCanStart_ = this.isCanStart_;
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
                if (other instanceof BrickBreakerLevelInfo) {
                    return mergeFrom((BrickBreakerLevelInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BrickBreakerLevelInfo other) {
                if (other == BrickBreakerLevelInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.chosenAvatarList_.isEmpty()) {
                    if (this.chosenAvatarList_.isEmpty()) {
                        this.chosenAvatarList_ = other.chosenAvatarList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureChosenAvatarListIsMutable();
                        this.chosenAvatarList_.addAll(other.chosenAvatarList_);
                    }
                    onChanged();
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getMaxScore() != 0) {
                    setMaxScore(other.getMaxScore());
                }
                if (!other.chosenSkillList_.isEmpty()) {
                    if (this.chosenSkillList_.isEmpty()) {
                        this.chosenSkillList_ = other.chosenSkillList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureChosenSkillListIsMutable();
                        this.chosenSkillList_.addAll(other.chosenSkillList_);
                    }
                    onChanged();
                }
                if (other.getIsCanStart()) {
                    setIsCanStart(other.getIsCanStart());
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
                BrickBreakerLevelInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BrickBreakerLevelInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BrickBreakerLevelInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureChosenAvatarListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chosenAvatarList_ = BrickBreakerLevelInfo.mutableCopy(this.chosenAvatarList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public List<Integer> getChosenAvatarListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.chosenAvatarList_) : this.chosenAvatarList_;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public int getChosenAvatarListCount() {
                return this.chosenAvatarList_.size();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public int getChosenAvatarList(int index) {
                return this.chosenAvatarList_.getInt(index);
            }

            public Builder setChosenAvatarList(int index, int value) {
                ensureChosenAvatarListIsMutable();
                this.chosenAvatarList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addChosenAvatarList(int value) {
                ensureChosenAvatarListIsMutable();
                this.chosenAvatarList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllChosenAvatarList(Iterable<? extends Integer> values) {
                ensureChosenAvatarListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chosenAvatarList_);
                onChanged();
                return this;
            }

            public Builder clearChosenAvatarList() {
                this.chosenAvatarList_ = BrickBreakerLevelInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public int getMaxScore() {
                return this.maxScore_;
            }

            public Builder setMaxScore(int value) {
                this.maxScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxScore() {
                this.maxScore_ = 0;
                onChanged();
                return this;
            }

            private void ensureChosenSkillListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.chosenSkillList_ = BrickBreakerLevelInfo.mutableCopy(this.chosenSkillList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public List<Integer> getChosenSkillListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.chosenSkillList_) : this.chosenSkillList_;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public int getChosenSkillListCount() {
                return this.chosenSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public int getChosenSkillList(int index) {
                return this.chosenSkillList_.getInt(index);
            }

            public Builder setChosenSkillList(int index, int value) {
                ensureChosenSkillListIsMutable();
                this.chosenSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addChosenSkillList(int value) {
                ensureChosenSkillListIsMutable();
                this.chosenSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllChosenSkillList(Iterable<? extends Integer> values) {
                ensureChosenSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chosenSkillList_);
                onChanged();
                return this;
            }

            public Builder clearChosenSkillList() {
                this.chosenSkillList_ = BrickBreakerLevelInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BrickBreakerLevelInfoOuterClass.BrickBreakerLevelInfoOrBuilder
            public boolean getIsCanStart() {
                return this.isCanStart_;
            }

            public Builder setIsCanStart(boolean value) {
                this.isCanStart_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCanStart() {
                this.isCanStart_ = false;
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

        public static BrickBreakerLevelInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BrickBreakerLevelInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BrickBreakerLevelInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BrickBreakerLevelInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
