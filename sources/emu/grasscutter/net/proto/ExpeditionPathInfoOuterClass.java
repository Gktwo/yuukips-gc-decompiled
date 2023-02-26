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
import emu.grasscutter.net.proto.ExpeditionStateOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionPathInfoOuterClass.class */
public final class ExpeditionPathInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ExpeditionPathInfo.proto\u001a\u0015ExpeditionState.proto\"\u0002\n\u0012ExpeditionPathInfo\u0012\u0011\n\tstartTime\u0018\u000f \u0001(\r\u0012\u001b\n\u0013Unk3300_LFIFDGAGFDC\u0018\u0007 \u0001(\r\u0012\u000e\n\u0006pathId\u0018\u000b \u0001(\r\u0012\u0014\n\favatarIdList\u0018\u0002 \u0003(\r\u0012\u0013\n\u000bchallengeId\u0018\u0003 \u0001(\r\u0012\u001f\n\u0005state\u0018\t \u0001(\u000e2\u0010.ExpeditionState\u0012\u001b\n\u0013Unk3300_AIEJKADFLKG\u0018\n \u0001(\r\u0012\u001b\n\u0013Unk3300_LKAHOEBNBBI\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_AFGPGIIGAKA\u0018\u000e \u0001(\r\u0012\u0018\n\u0010bonusProbability\u0018\b \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ExpeditionStateOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ExpeditionPathInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ExpeditionPathInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ExpeditionPathInfo_descriptor, new String[]{"StartTime", "Unk3300LFIFDGAGFDC", "PathId", "AvatarIdList", "ChallengeId", "State", "Unk3300AIEJKADFLKG", "Unk3300LKAHOEBNBBI", "Unk3300AFGPGIIGAKA", "BonusProbability"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionPathInfoOuterClass$ExpeditionPathInfoOrBuilder.class */
    public interface ExpeditionPathInfoOrBuilder extends MessageOrBuilder {
        int getStartTime();

        int getUnk3300LFIFDGAGFDC();

        int getPathId();

        List<Integer> getAvatarIdListList();

        int getAvatarIdListCount();

        int getAvatarIdList(int i);

        int getChallengeId();

        int getStateValue();

        ExpeditionStateOuterClass.ExpeditionState getState();

        int getUnk3300AIEJKADFLKG();

        int getUnk3300LKAHOEBNBBI();

        int getUnk3300AFGPGIIGAKA();

        float getBonusProbability();
    }

    private ExpeditionPathInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionPathInfoOuterClass$ExpeditionPathInfo.class */
    public static final class ExpeditionPathInfo extends GeneratedMessageV3 implements ExpeditionPathInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STARTTIME_FIELD_NUMBER = 15;
        private int startTime_;
        public static final int UNK3300_LFIFDGAGFDC_FIELD_NUMBER = 7;
        private int unk3300LFIFDGAGFDC_;
        public static final int PATHID_FIELD_NUMBER = 11;
        private int pathId_;
        public static final int AVATARIDLIST_FIELD_NUMBER = 2;
        private Internal.IntList avatarIdList_;
        private int avatarIdListMemoizedSerializedSize;
        public static final int CHALLENGEID_FIELD_NUMBER = 3;
        private int challengeId_;
        public static final int STATE_FIELD_NUMBER = 9;
        private int state_;
        public static final int UNK3300_AIEJKADFLKG_FIELD_NUMBER = 10;
        private int unk3300AIEJKADFLKG_;
        public static final int UNK3300_LKAHOEBNBBI_FIELD_NUMBER = 1;
        private int unk3300LKAHOEBNBBI_;
        public static final int UNK3300_AFGPGIIGAKA_FIELD_NUMBER = 14;
        private int unk3300AFGPGIIGAKA_;
        public static final int BONUSPROBABILITY_FIELD_NUMBER = 8;
        private float bonusProbability_;
        private byte memoizedIsInitialized;
        private static final ExpeditionPathInfo DEFAULT_INSTANCE = new ExpeditionPathInfo();
        private static final Parser<ExpeditionPathInfo> PARSER = new AbstractParser<ExpeditionPathInfo>() { // from class: emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfo.1
            @Override // com.google.protobuf.Parser
            public ExpeditionPathInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ExpeditionPathInfo(input, extensionRegistry);
            }
        };

        private ExpeditionPathInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ExpeditionPathInfo() {
            this.avatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarIdList_ = emptyIntList();
            this.state_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ExpeditionPathInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ExpeditionPathInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.unk3300LKAHOEBNBBI_ = input.readUInt32();
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.avatarIdList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.avatarIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.avatarIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.challengeId_ = input.readUInt32();
                                break;
                            case 56:
                                this.unk3300LFIFDGAGFDC_ = input.readUInt32();
                                break;
                            case 69:
                                this.bonusProbability_ = input.readFloat();
                                break;
                            case 72:
                                this.state_ = input.readEnum();
                                break;
                            case 80:
                                this.unk3300AIEJKADFLKG_ = input.readUInt32();
                                break;
                            case 88:
                                this.pathId_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300AFGPGIIGAKA_ = input.readUInt32();
                                break;
                            case 120:
                                this.startTime_ = input.readUInt32();
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
                    this.avatarIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ExpeditionPathInfoOuterClass.internal_static_ExpeditionPathInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ExpeditionPathInfoOuterClass.internal_static_ExpeditionPathInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionPathInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getUnk3300LFIFDGAGFDC() {
            return this.unk3300LFIFDGAGFDC_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getPathId() {
            return this.pathId_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public List<Integer> getAvatarIdListList() {
            return this.avatarIdList_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getAvatarIdListCount() {
            return this.avatarIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getAvatarIdList(int index) {
            return this.avatarIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getChallengeId() {
            return this.challengeId_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getStateValue() {
            return this.state_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public ExpeditionStateOuterClass.ExpeditionState getState() {
            ExpeditionStateOuterClass.ExpeditionState result = ExpeditionStateOuterClass.ExpeditionState.valueOf(this.state_);
            return result == null ? ExpeditionStateOuterClass.ExpeditionState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getUnk3300AIEJKADFLKG() {
            return this.unk3300AIEJKADFLKG_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getUnk3300LKAHOEBNBBI() {
            return this.unk3300LKAHOEBNBBI_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public int getUnk3300AFGPGIIGAKA() {
            return this.unk3300AFGPGIIGAKA_;
        }

        @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
        public float getBonusProbability() {
            return this.bonusProbability_;
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
            if (this.unk3300LKAHOEBNBBI_ != 0) {
                output.writeUInt32(1, this.unk3300LKAHOEBNBBI_);
            }
            if (getAvatarIdListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.avatarIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarIdList_.size(); i++) {
                output.writeUInt32NoTag(this.avatarIdList_.getInt(i));
            }
            if (this.challengeId_ != 0) {
                output.writeUInt32(3, this.challengeId_);
            }
            if (this.unk3300LFIFDGAGFDC_ != 0) {
                output.writeUInt32(7, this.unk3300LFIFDGAGFDC_);
            }
            if (this.bonusProbability_ != 0.0f) {
                output.writeFloat(8, this.bonusProbability_);
            }
            if (this.state_ != ExpeditionStateOuterClass.ExpeditionState.EXPEDITION_STATE_NONE.getNumber()) {
                output.writeEnum(9, this.state_);
            }
            if (this.unk3300AIEJKADFLKG_ != 0) {
                output.writeUInt32(10, this.unk3300AIEJKADFLKG_);
            }
            if (this.pathId_ != 0) {
                output.writeUInt32(11, this.pathId_);
            }
            if (this.unk3300AFGPGIIGAKA_ != 0) {
                output.writeUInt32(14, this.unk3300AFGPGIIGAKA_);
            }
            if (this.startTime_ != 0) {
                output.writeUInt32(15, this.startTime_);
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
            if (this.unk3300LKAHOEBNBBI_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300LKAHOEBNBBI_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.avatarIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.avatarIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getAvatarIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarIdListMemoizedSerializedSize = dataSize;
            if (this.challengeId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(3, this.challengeId_);
            }
            if (this.unk3300LFIFDGAGFDC_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(7, this.unk3300LFIFDGAGFDC_);
            }
            if (this.bonusProbability_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(8, this.bonusProbability_);
            }
            if (this.state_ != ExpeditionStateOuterClass.ExpeditionState.EXPEDITION_STATE_NONE.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(9, this.state_);
            }
            if (this.unk3300AIEJKADFLKG_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.unk3300AIEJKADFLKG_);
            }
            if (this.pathId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.pathId_);
            }
            if (this.unk3300AFGPGIIGAKA_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(14, this.unk3300AFGPGIIGAKA_);
            }
            if (this.startTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.startTime_);
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
            if (!(obj instanceof ExpeditionPathInfo)) {
                return equals(obj);
            }
            ExpeditionPathInfo other = (ExpeditionPathInfo) obj;
            return getStartTime() == other.getStartTime() && getUnk3300LFIFDGAGFDC() == other.getUnk3300LFIFDGAGFDC() && getPathId() == other.getPathId() && getAvatarIdListList().equals(other.getAvatarIdListList()) && getChallengeId() == other.getChallengeId() && this.state_ == other.state_ && getUnk3300AIEJKADFLKG() == other.getUnk3300AIEJKADFLKG() && getUnk3300LKAHOEBNBBI() == other.getUnk3300LKAHOEBNBBI() && getUnk3300AFGPGIIGAKA() == other.getUnk3300AFGPGIIGAKA() && Float.floatToIntBits(getBonusProbability()) == Float.floatToIntBits(other.getBonusProbability()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getStartTime())) + 7)) + getUnk3300LFIFDGAGFDC())) + 11)) + getPathId();
            if (getAvatarIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getAvatarIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + getChallengeId())) + 9)) + this.state_)) + 10)) + getUnk3300AIEJKADFLKG())) + 1)) + getUnk3300LKAHOEBNBBI())) + 14)) + getUnk3300AFGPGIIGAKA())) + 8)) + Float.floatToIntBits(getBonusProbability()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ExpeditionPathInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionPathInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionPathInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionPathInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionPathInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ExpeditionPathInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ExpeditionPathInfo parseFrom(InputStream input) throws IOException {
            return (ExpeditionPathInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExpeditionPathInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionPathInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExpeditionPathInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ExpeditionPathInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ExpeditionPathInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionPathInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ExpeditionPathInfo parseFrom(CodedInputStream input) throws IOException {
            return (ExpeditionPathInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ExpeditionPathInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExpeditionPathInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ExpeditionPathInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionPathInfoOuterClass$ExpeditionPathInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExpeditionPathInfoOrBuilder {
            private int bitField0_;
            private int startTime_;
            private int unk3300LFIFDGAGFDC_;
            private int pathId_;
            private int challengeId_;
            private int unk3300AIEJKADFLKG_;
            private int unk3300LKAHOEBNBBI_;
            private int unk3300AFGPGIIGAKA_;
            private float bonusProbability_;
            private Internal.IntList avatarIdList_ = ExpeditionPathInfo.emptyIntList();
            private int state_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return ExpeditionPathInfoOuterClass.internal_static_ExpeditionPathInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ExpeditionPathInfoOuterClass.internal_static_ExpeditionPathInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionPathInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ExpeditionPathInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.startTime_ = 0;
                this.unk3300LFIFDGAGFDC_ = 0;
                this.pathId_ = 0;
                this.avatarIdList_ = ExpeditionPathInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.challengeId_ = 0;
                this.state_ = 0;
                this.unk3300AIEJKADFLKG_ = 0;
                this.unk3300LKAHOEBNBBI_ = 0;
                this.unk3300AFGPGIIGAKA_ = 0;
                this.bonusProbability_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ExpeditionPathInfoOuterClass.internal_static_ExpeditionPathInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ExpeditionPathInfo getDefaultInstanceForType() {
                return ExpeditionPathInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExpeditionPathInfo build() {
                ExpeditionPathInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ExpeditionPathInfo buildPartial() {
                ExpeditionPathInfo result = new ExpeditionPathInfo(this);
                int i = this.bitField0_;
                result.startTime_ = this.startTime_;
                result.unk3300LFIFDGAGFDC_ = this.unk3300LFIFDGAGFDC_;
                result.pathId_ = this.pathId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarIdList_ = this.avatarIdList_;
                result.challengeId_ = this.challengeId_;
                result.state_ = this.state_;
                result.unk3300AIEJKADFLKG_ = this.unk3300AIEJKADFLKG_;
                result.unk3300LKAHOEBNBBI_ = this.unk3300LKAHOEBNBBI_;
                result.unk3300AFGPGIIGAKA_ = this.unk3300AFGPGIIGAKA_;
                result.bonusProbability_ = this.bonusProbability_;
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
                if (other instanceof ExpeditionPathInfo) {
                    return mergeFrom((ExpeditionPathInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ExpeditionPathInfo other) {
                if (other == ExpeditionPathInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getStartTime() != 0) {
                    setStartTime(other.getStartTime());
                }
                if (other.getUnk3300LFIFDGAGFDC() != 0) {
                    setUnk3300LFIFDGAGFDC(other.getUnk3300LFIFDGAGFDC());
                }
                if (other.getPathId() != 0) {
                    setPathId(other.getPathId());
                }
                if (!other.avatarIdList_.isEmpty()) {
                    if (this.avatarIdList_.isEmpty()) {
                        this.avatarIdList_ = other.avatarIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAvatarIdListIsMutable();
                        this.avatarIdList_.addAll(other.avatarIdList_);
                    }
                    onChanged();
                }
                if (other.getChallengeId() != 0) {
                    setChallengeId(other.getChallengeId());
                }
                if (other.state_ != 0) {
                    setStateValue(other.getStateValue());
                }
                if (other.getUnk3300AIEJKADFLKG() != 0) {
                    setUnk3300AIEJKADFLKG(other.getUnk3300AIEJKADFLKG());
                }
                if (other.getUnk3300LKAHOEBNBBI() != 0) {
                    setUnk3300LKAHOEBNBBI(other.getUnk3300LKAHOEBNBBI());
                }
                if (other.getUnk3300AFGPGIIGAKA() != 0) {
                    setUnk3300AFGPGIIGAKA(other.getUnk3300AFGPGIIGAKA());
                }
                if (other.getBonusProbability() != 0.0f) {
                    setBonusProbability(other.getBonusProbability());
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
                ExpeditionPathInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ExpeditionPathInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ExpeditionPathInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getStartTime() {
                return this.startTime_;
            }

            public Builder setStartTime(int value) {
                this.startTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartTime() {
                this.startTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getUnk3300LFIFDGAGFDC() {
                return this.unk3300LFIFDGAGFDC_;
            }

            public Builder setUnk3300LFIFDGAGFDC(int value) {
                this.unk3300LFIFDGAGFDC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LFIFDGAGFDC() {
                this.unk3300LFIFDGAGFDC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getPathId() {
                return this.pathId_;
            }

            public Builder setPathId(int value) {
                this.pathId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPathId() {
                this.pathId_ = 0;
                onChanged();
                return this;
            }

            private void ensureAvatarIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarIdList_ = ExpeditionPathInfo.mutableCopy(this.avatarIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public List<Integer> getAvatarIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarIdList_) : this.avatarIdList_;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getAvatarIdListCount() {
                return this.avatarIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getAvatarIdList(int index) {
                return this.avatarIdList_.getInt(index);
            }

            public Builder setAvatarIdList(int index, int value) {
                ensureAvatarIdListIsMutable();
                this.avatarIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarIdList(int value) {
                ensureAvatarIdListIsMutable();
                this.avatarIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarIdList(Iterable<? extends Integer> values) {
                ensureAvatarIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarIdList_);
                onChanged();
                return this;
            }

            public Builder clearAvatarIdList() {
                this.avatarIdList_ = ExpeditionPathInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getChallengeId() {
                return this.challengeId_;
            }

            public Builder setChallengeId(int value) {
                this.challengeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeId() {
                this.challengeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getStateValue() {
                return this.state_;
            }

            public Builder setStateValue(int value) {
                this.state_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public ExpeditionStateOuterClass.ExpeditionState getState() {
                ExpeditionStateOuterClass.ExpeditionState result = ExpeditionStateOuterClass.ExpeditionState.valueOf(this.state_);
                return result == null ? ExpeditionStateOuterClass.ExpeditionState.UNRECOGNIZED : result;
            }

            public Builder setState(ExpeditionStateOuterClass.ExpeditionState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.state_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.state_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getUnk3300AIEJKADFLKG() {
                return this.unk3300AIEJKADFLKG_;
            }

            public Builder setUnk3300AIEJKADFLKG(int value) {
                this.unk3300AIEJKADFLKG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AIEJKADFLKG() {
                this.unk3300AIEJKADFLKG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getUnk3300LKAHOEBNBBI() {
                return this.unk3300LKAHOEBNBBI_;
            }

            public Builder setUnk3300LKAHOEBNBBI(int value) {
                this.unk3300LKAHOEBNBBI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LKAHOEBNBBI() {
                this.unk3300LKAHOEBNBBI_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public int getUnk3300AFGPGIIGAKA() {
                return this.unk3300AFGPGIIGAKA_;
            }

            public Builder setUnk3300AFGPGIIGAKA(int value) {
                this.unk3300AFGPGIIGAKA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AFGPGIIGAKA() {
                this.unk3300AFGPGIIGAKA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ExpeditionPathInfoOuterClass.ExpeditionPathInfoOrBuilder
            public float getBonusProbability() {
                return this.bonusProbability_;
            }

            public Builder setBonusProbability(float value) {
                this.bonusProbability_ = value;
                onChanged();
                return this;
            }

            public Builder clearBonusProbability() {
                this.bonusProbability_ = 0.0f;
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

        public static ExpeditionPathInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExpeditionPathInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ExpeditionPathInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExpeditionPathInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ExpeditionStateOuterClass.getDescriptor();
    }
}
