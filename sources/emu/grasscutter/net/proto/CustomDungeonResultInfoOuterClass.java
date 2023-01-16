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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ChallengeBriefOuterClass;
import emu.grasscutter.net.proto.CustomDungeonFinishTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomDungeonResultInfoOuterClass.class */
public final class CustomDungeonResultInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCustomDungeonResultInfo.proto\u001a\u0014ChallengeBrief.proto\u001a\u001dCustomDungeonFinishType.proto\"õ\u0001\n\u0017CustomDungeonResultInfo\u0012\u0010\n\bis_liked\u0018\r \u0001(\b\u0012\u0018\n\u0010is_arrive_finish\u0018\u0002 \u0001(\b\u0012\u0014\n\fdungeon_guid\u0018\u0005 \u0001(\u0004\u0012-\n\u000bfinish_type\u0018\b \u0001(\u000e2\u0018.CustomDungeonFinishType\u0012-\n\u0014child_challenge_list\u0018\u0001 \u0003(\u000b2\u000f.ChallengeBrief\u0012\u0011\n\tis_stored\u0018\u0006 \u0001(\b\u0012\u0011\n\ttime_cost\u0018\t \u0001(\r\u0012\u0014\n\fgot_coin_num\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChallengeBriefOuterClass.getDescriptor(), CustomDungeonFinishTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CustomDungeonResultInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CustomDungeonResultInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CustomDungeonResultInfo_descriptor, new String[]{"IsLiked", "IsArriveFinish", "DungeonGuid", "FinishType", "ChildChallengeList", "IsStored", "TimeCost", "GotCoinNum"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomDungeonResultInfoOuterClass$CustomDungeonResultInfoOrBuilder.class */
    public interface CustomDungeonResultInfoOrBuilder extends MessageOrBuilder {
        boolean getIsLiked();

        boolean getIsArriveFinish();

        long getDungeonGuid();

        int getFinishTypeValue();

        CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType getFinishType();

        List<ChallengeBriefOuterClass.ChallengeBrief> getChildChallengeListList();

        ChallengeBriefOuterClass.ChallengeBrief getChildChallengeList(int i);

        int getChildChallengeListCount();

        List<? extends ChallengeBriefOuterClass.ChallengeBriefOrBuilder> getChildChallengeListOrBuilderList();

        ChallengeBriefOuterClass.ChallengeBriefOrBuilder getChildChallengeListOrBuilder(int i);

        boolean getIsStored();

        int getTimeCost();

        int getGotCoinNum();
    }

    private CustomDungeonResultInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomDungeonResultInfoOuterClass$CustomDungeonResultInfo.class */
    public static final class CustomDungeonResultInfo extends GeneratedMessageV3 implements CustomDungeonResultInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_LIKED_FIELD_NUMBER = 13;
        private boolean isLiked_;
        public static final int IS_ARRIVE_FINISH_FIELD_NUMBER = 2;
        private boolean isArriveFinish_;
        public static final int DUNGEON_GUID_FIELD_NUMBER = 5;
        private long dungeonGuid_;
        public static final int FINISH_TYPE_FIELD_NUMBER = 8;
        private int finishType_;
        public static final int CHILD_CHALLENGE_LIST_FIELD_NUMBER = 1;
        private List<ChallengeBriefOuterClass.ChallengeBrief> childChallengeList_;
        public static final int IS_STORED_FIELD_NUMBER = 6;
        private boolean isStored_;
        public static final int TIME_COST_FIELD_NUMBER = 9;
        private int timeCost_;
        public static final int GOT_COIN_NUM_FIELD_NUMBER = 4;
        private int gotCoinNum_;
        private byte memoizedIsInitialized;
        private static final CustomDungeonResultInfo DEFAULT_INSTANCE = new CustomDungeonResultInfo();
        private static final Parser<CustomDungeonResultInfo> PARSER = new AbstractParser<CustomDungeonResultInfo>() { // from class: emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfo.1
            @Override // com.google.protobuf.Parser
            public CustomDungeonResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CustomDungeonResultInfo(input, extensionRegistry);
            }
        };

        private CustomDungeonResultInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CustomDungeonResultInfo() {
            this.memoizedIsInitialized = -1;
            this.finishType_ = 0;
            this.childChallengeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CustomDungeonResultInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CustomDungeonResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.childChallengeList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.childChallengeList_.add((ChallengeBriefOuterClass.ChallengeBrief) input.readMessage(ChallengeBriefOuterClass.ChallengeBrief.parser(), extensionRegistry));
                                break;
                            case 16:
                                this.isArriveFinish_ = input.readBool();
                                break;
                            case 32:
                                this.gotCoinNum_ = input.readUInt32();
                                break;
                            case 40:
                                this.dungeonGuid_ = input.readUInt64();
                                break;
                            case 48:
                                this.isStored_ = input.readBool();
                                break;
                            case 64:
                                this.finishType_ = input.readEnum();
                                break;
                            case 72:
                                this.timeCost_ = input.readUInt32();
                                break;
                            case 104:
                                this.isLiked_ = input.readBool();
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
                    this.childChallengeList_ = Collections.unmodifiableList(this.childChallengeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CustomDungeonResultInfoOuterClass.internal_static_CustomDungeonResultInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CustomDungeonResultInfoOuterClass.internal_static_CustomDungeonResultInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomDungeonResultInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public boolean getIsLiked() {
            return this.isLiked_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public boolean getIsArriveFinish() {
            return this.isArriveFinish_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public long getDungeonGuid() {
            return this.dungeonGuid_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public int getFinishTypeValue() {
            return this.finishType_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType getFinishType() {
            CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType result = CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.valueOf(this.finishType_);
            return result == null ? CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public List<ChallengeBriefOuterClass.ChallengeBrief> getChildChallengeListList() {
            return this.childChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public List<? extends ChallengeBriefOuterClass.ChallengeBriefOrBuilder> getChildChallengeListOrBuilderList() {
            return this.childChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public int getChildChallengeListCount() {
            return this.childChallengeList_.size();
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public ChallengeBriefOuterClass.ChallengeBrief getChildChallengeList(int index) {
            return this.childChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public ChallengeBriefOuterClass.ChallengeBriefOrBuilder getChildChallengeListOrBuilder(int index) {
            return this.childChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public boolean getIsStored() {
            return this.isStored_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public int getTimeCost() {
            return this.timeCost_;
        }

        @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
        public int getGotCoinNum() {
            return this.gotCoinNum_;
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
            for (int i = 0; i < this.childChallengeList_.size(); i++) {
                output.writeMessage(1, this.childChallengeList_.get(i));
            }
            if (this.isArriveFinish_) {
                output.writeBool(2, this.isArriveFinish_);
            }
            if (this.gotCoinNum_ != 0) {
                output.writeUInt32(4, this.gotCoinNum_);
            }
            if (this.dungeonGuid_ != 0) {
                output.writeUInt64(5, this.dungeonGuid_);
            }
            if (this.isStored_) {
                output.writeBool(6, this.isStored_);
            }
            if (this.finishType_ != CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.CUSTOM_DUNGEON_FINISH_TYPE_PLAY_NORMAL.getNumber()) {
                output.writeEnum(8, this.finishType_);
            }
            if (this.timeCost_ != 0) {
                output.writeUInt32(9, this.timeCost_);
            }
            if (this.isLiked_) {
                output.writeBool(13, this.isLiked_);
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
            for (int i = 0; i < this.childChallengeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.childChallengeList_.get(i));
            }
            if (this.isArriveFinish_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isArriveFinish_);
            }
            if (this.gotCoinNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.gotCoinNum_);
            }
            if (this.dungeonGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(5, this.dungeonGuid_);
            }
            if (this.isStored_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isStored_);
            }
            if (this.finishType_ != CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.CUSTOM_DUNGEON_FINISH_TYPE_PLAY_NORMAL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(8, this.finishType_);
            }
            if (this.timeCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.timeCost_);
            }
            if (this.isLiked_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isLiked_);
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
            if (!(obj instanceof CustomDungeonResultInfo)) {
                return equals(obj);
            }
            CustomDungeonResultInfo other = (CustomDungeonResultInfo) obj;
            return getIsLiked() == other.getIsLiked() && getIsArriveFinish() == other.getIsArriveFinish() && getDungeonGuid() == other.getDungeonGuid() && this.finishType_ == other.finishType_ && getChildChallengeListList().equals(other.getChildChallengeListList()) && getIsStored() == other.getIsStored() && getTimeCost() == other.getTimeCost() && getGotCoinNum() == other.getGotCoinNum() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsLiked()))) + 2)) + Internal.hashBoolean(getIsArriveFinish()))) + 5)) + Internal.hashLong(getDungeonGuid()))) + 8)) + this.finishType_;
            if (getChildChallengeListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getChildChallengeListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 6)) + Internal.hashBoolean(getIsStored()))) + 9)) + getTimeCost())) + 4)) + getGotCoinNum())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CustomDungeonResultInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomDungeonResultInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomDungeonResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomDungeonResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomDungeonResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CustomDungeonResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CustomDungeonResultInfo parseFrom(InputStream input) throws IOException {
            return (CustomDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CustomDungeonResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CustomDungeonResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CustomDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CustomDungeonResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomDungeonResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CustomDungeonResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (CustomDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CustomDungeonResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CustomDungeonResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CustomDungeonResultInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomDungeonResultInfoOuterClass$CustomDungeonResultInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CustomDungeonResultInfoOrBuilder {
            private int bitField0_;
            private boolean isLiked_;
            private boolean isArriveFinish_;
            private long dungeonGuid_;
            private int finishType_ = 0;
            private List<ChallengeBriefOuterClass.ChallengeBrief> childChallengeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ChallengeBriefOuterClass.ChallengeBrief, ChallengeBriefOuterClass.ChallengeBrief.Builder, ChallengeBriefOuterClass.ChallengeBriefOrBuilder> childChallengeListBuilder_;
            private boolean isStored_;
            private int timeCost_;
            private int gotCoinNum_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CustomDungeonResultInfoOuterClass.internal_static_CustomDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CustomDungeonResultInfoOuterClass.internal_static_CustomDungeonResultInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CustomDungeonResultInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CustomDungeonResultInfo.alwaysUseFieldBuilders) {
                    getChildChallengeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isLiked_ = false;
                this.isArriveFinish_ = false;
                this.dungeonGuid_ = 0;
                this.finishType_ = 0;
                if (this.childChallengeListBuilder_ == null) {
                    this.childChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.childChallengeListBuilder_.clear();
                }
                this.isStored_ = false;
                this.timeCost_ = 0;
                this.gotCoinNum_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CustomDungeonResultInfoOuterClass.internal_static_CustomDungeonResultInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CustomDungeonResultInfo getDefaultInstanceForType() {
                return CustomDungeonResultInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CustomDungeonResultInfo build() {
                CustomDungeonResultInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CustomDungeonResultInfo buildPartial() {
                CustomDungeonResultInfo result = new CustomDungeonResultInfo(this);
                int i = this.bitField0_;
                result.isLiked_ = this.isLiked_;
                result.isArriveFinish_ = this.isArriveFinish_;
                result.dungeonGuid_ = this.dungeonGuid_;
                result.finishType_ = this.finishType_;
                if (this.childChallengeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.childChallengeList_ = Collections.unmodifiableList(this.childChallengeList_);
                        this.bitField0_ &= -2;
                    }
                    result.childChallengeList_ = this.childChallengeList_;
                } else {
                    result.childChallengeList_ = this.childChallengeListBuilder_.build();
                }
                result.isStored_ = this.isStored_;
                result.timeCost_ = this.timeCost_;
                result.gotCoinNum_ = this.gotCoinNum_;
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
                if (other instanceof CustomDungeonResultInfo) {
                    return mergeFrom((CustomDungeonResultInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CustomDungeonResultInfo other) {
                if (other == CustomDungeonResultInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsLiked()) {
                    setIsLiked(other.getIsLiked());
                }
                if (other.getIsArriveFinish()) {
                    setIsArriveFinish(other.getIsArriveFinish());
                }
                if (other.getDungeonGuid() != 0) {
                    setDungeonGuid(other.getDungeonGuid());
                }
                if (other.finishType_ != 0) {
                    setFinishTypeValue(other.getFinishTypeValue());
                }
                if (this.childChallengeListBuilder_ == null) {
                    if (!other.childChallengeList_.isEmpty()) {
                        if (this.childChallengeList_.isEmpty()) {
                            this.childChallengeList_ = other.childChallengeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChildChallengeListIsMutable();
                            this.childChallengeList_.addAll(other.childChallengeList_);
                        }
                        onChanged();
                    }
                } else if (!other.childChallengeList_.isEmpty()) {
                    if (this.childChallengeListBuilder_.isEmpty()) {
                        this.childChallengeListBuilder_.dispose();
                        this.childChallengeListBuilder_ = null;
                        this.childChallengeList_ = other.childChallengeList_;
                        this.bitField0_ &= -2;
                        this.childChallengeListBuilder_ = CustomDungeonResultInfo.alwaysUseFieldBuilders ? getChildChallengeListFieldBuilder() : null;
                    } else {
                        this.childChallengeListBuilder_.addAllMessages(other.childChallengeList_);
                    }
                }
                if (other.getIsStored()) {
                    setIsStored(other.getIsStored());
                }
                if (other.getTimeCost() != 0) {
                    setTimeCost(other.getTimeCost());
                }
                if (other.getGotCoinNum() != 0) {
                    setGotCoinNum(other.getGotCoinNum());
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
                CustomDungeonResultInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CustomDungeonResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CustomDungeonResultInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public boolean getIsLiked() {
                return this.isLiked_;
            }

            public Builder setIsLiked(boolean value) {
                this.isLiked_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLiked() {
                this.isLiked_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public boolean getIsArriveFinish() {
                return this.isArriveFinish_;
            }

            public Builder setIsArriveFinish(boolean value) {
                this.isArriveFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsArriveFinish() {
                this.isArriveFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public long getDungeonGuid() {
                return this.dungeonGuid_;
            }

            public Builder setDungeonGuid(long value) {
                this.dungeonGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonGuid() {
                this.dungeonGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public int getFinishTypeValue() {
                return this.finishType_;
            }

            public Builder setFinishTypeValue(int value) {
                this.finishType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType getFinishType() {
                CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType result = CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.valueOf(this.finishType_);
                return result == null ? CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.UNRECOGNIZED : result;
            }

            public Builder setFinishType(CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.finishType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFinishType() {
                this.finishType_ = 0;
                onChanged();
                return this;
            }

            private void ensureChildChallengeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.childChallengeList_ = new ArrayList(this.childChallengeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public List<ChallengeBriefOuterClass.ChallengeBrief> getChildChallengeListList() {
                if (this.childChallengeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.childChallengeList_);
                }
                return this.childChallengeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public int getChildChallengeListCount() {
                if (this.childChallengeListBuilder_ == null) {
                    return this.childChallengeList_.size();
                }
                return this.childChallengeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public ChallengeBriefOuterClass.ChallengeBrief getChildChallengeList(int index) {
                if (this.childChallengeListBuilder_ == null) {
                    return this.childChallengeList_.get(index);
                }
                return this.childChallengeListBuilder_.getMessage(index);
            }

            public Builder setChildChallengeList(int index, ChallengeBriefOuterClass.ChallengeBrief value) {
                if (this.childChallengeListBuilder_ != null) {
                    this.childChallengeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChildChallengeList(int index, ChallengeBriefOuterClass.ChallengeBrief.Builder builderForValue) {
                if (this.childChallengeListBuilder_ == null) {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.childChallengeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChildChallengeList(ChallengeBriefOuterClass.ChallengeBrief value) {
                if (this.childChallengeListBuilder_ != null) {
                    this.childChallengeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChildChallengeList(int index, ChallengeBriefOuterClass.ChallengeBrief value) {
                if (this.childChallengeListBuilder_ != null) {
                    this.childChallengeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChildChallengeList(ChallengeBriefOuterClass.ChallengeBrief.Builder builderForValue) {
                if (this.childChallengeListBuilder_ == null) {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.childChallengeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChildChallengeList(int index, ChallengeBriefOuterClass.ChallengeBrief.Builder builderForValue) {
                if (this.childChallengeListBuilder_ == null) {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.childChallengeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChildChallengeList(Iterable<? extends ChallengeBriefOuterClass.ChallengeBrief> values) {
                if (this.childChallengeListBuilder_ == null) {
                    ensureChildChallengeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.childChallengeList_);
                    onChanged();
                } else {
                    this.childChallengeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChildChallengeList() {
                if (this.childChallengeListBuilder_ == null) {
                    this.childChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.childChallengeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChildChallengeList(int index) {
                if (this.childChallengeListBuilder_ == null) {
                    ensureChildChallengeListIsMutable();
                    this.childChallengeList_.remove(index);
                    onChanged();
                } else {
                    this.childChallengeListBuilder_.remove(index);
                }
                return this;
            }

            public ChallengeBriefOuterClass.ChallengeBrief.Builder getChildChallengeListBuilder(int index) {
                return getChildChallengeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public ChallengeBriefOuterClass.ChallengeBriefOrBuilder getChildChallengeListOrBuilder(int index) {
                if (this.childChallengeListBuilder_ == null) {
                    return this.childChallengeList_.get(index);
                }
                return this.childChallengeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public List<? extends ChallengeBriefOuterClass.ChallengeBriefOrBuilder> getChildChallengeListOrBuilderList() {
                if (this.childChallengeListBuilder_ != null) {
                    return this.childChallengeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.childChallengeList_);
            }

            public ChallengeBriefOuterClass.ChallengeBrief.Builder addChildChallengeListBuilder() {
                return getChildChallengeListFieldBuilder().addBuilder(ChallengeBriefOuterClass.ChallengeBrief.getDefaultInstance());
            }

            public ChallengeBriefOuterClass.ChallengeBrief.Builder addChildChallengeListBuilder(int index) {
                return getChildChallengeListFieldBuilder().addBuilder(index, ChallengeBriefOuterClass.ChallengeBrief.getDefaultInstance());
            }

            public List<ChallengeBriefOuterClass.ChallengeBrief.Builder> getChildChallengeListBuilderList() {
                return getChildChallengeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChallengeBriefOuterClass.ChallengeBrief, ChallengeBriefOuterClass.ChallengeBrief.Builder, ChallengeBriefOuterClass.ChallengeBriefOrBuilder> getChildChallengeListFieldBuilder() {
                if (this.childChallengeListBuilder_ == null) {
                    this.childChallengeListBuilder_ = new RepeatedFieldBuilderV3<>(this.childChallengeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.childChallengeList_ = null;
                }
                return this.childChallengeListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public boolean getIsStored() {
                return this.isStored_;
            }

            public Builder setIsStored(boolean value) {
                this.isStored_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsStored() {
                this.isStored_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public int getTimeCost() {
                return this.timeCost_;
            }

            public Builder setTimeCost(int value) {
                this.timeCost_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimeCost() {
                this.timeCost_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CustomDungeonResultInfoOuterClass.CustomDungeonResultInfoOrBuilder
            public int getGotCoinNum() {
                return this.gotCoinNum_;
            }

            public Builder setGotCoinNum(int value) {
                this.gotCoinNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearGotCoinNum() {
                this.gotCoinNum_ = 0;
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

        public static CustomDungeonResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CustomDungeonResultInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CustomDungeonResultInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CustomDungeonResultInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChallengeBriefOuterClass.getDescriptor();
        CustomDungeonFinishTypeOuterClass.getDescriptor();
    }
}
