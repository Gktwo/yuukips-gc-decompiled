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
import emu.grasscutter.net.proto.MichiaeMatsuriChallengePositionInfoOuterClass;
import emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass;
import emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriActivityDetailInfoOuterClass.class */
public final class MichiaeMatsuriActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&MichiaeMatsuriActivityDetailInfo.proto\u001a)MichiaeMatsuriChallengePositionInfo.proto\u001a%MichiaeMatsuriChestPositionInfo.proto\u001a\u0019MichiaeMatsuriStage.proto\"\u0002\n MichiaeMatsuriActivityDetailInfo\u0012\u0018\n\u0010gain_crystal_exp\u0018\u000b \u0001(\r\u0012(\n\nstage_list\u0018\u000e \u0003(\u000b2\u0014.MichiaeMatsuriStage\u0012#\n\u001bunlocked_crystal_skill_list\u0018\u0005 \u0003(\r\u0012@\n\u0012challenge_pos_list\u0018\u0003 \u0003(\u000b2$.MichiaeMatsuriChallengePositionInfo\u00128\n\u000echest_pos_list\u0018\f \u0003(\u000b2 .MichiaeMatsuriChestPositionInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MichiaeMatsuriChallengePositionInfoOuterClass.getDescriptor(), MichiaeMatsuriChestPositionInfoOuterClass.getDescriptor(), MichiaeMatsuriStageOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MichiaeMatsuriActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MichiaeMatsuriActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f798xee3810e2 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MichiaeMatsuriActivityDetailInfo_descriptor, new String[]{"GainCrystalExp", "StageList", "UnlockedCrystalSkillList", "ChallengePosList", "ChestPosList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriActivityDetailInfoOuterClass$MichiaeMatsuriActivityDetailInfoOrBuilder.class */
    public interface MichiaeMatsuriActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getGainCrystalExp();

        List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> getStageListList();

        MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage getStageList(int i);

        int getStageListCount();

        List<? extends MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> getStageListOrBuilderList();

        MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder getStageListOrBuilder(int i);

        List<Integer> getUnlockedCrystalSkillListList();

        int getUnlockedCrystalSkillListCount();

        int getUnlockedCrystalSkillList(int i);

        List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> getChallengePosListList();

        MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo getChallengePosList(int i);

        int getChallengePosListCount();

        List<? extends MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> getChallengePosListOrBuilderList();

        MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder getChallengePosListOrBuilder(int i);

        List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> getChestPosListList();

        MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo getChestPosList(int i);

        int getChestPosListCount();

        List<? extends MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> getChestPosListOrBuilderList();

        MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder getChestPosListOrBuilder(int i);
    }

    private MichiaeMatsuriActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriActivityDetailInfoOuterClass$MichiaeMatsuriActivityDetailInfo.class */
    public static final class MichiaeMatsuriActivityDetailInfo extends GeneratedMessageV3 implements MichiaeMatsuriActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GAIN_CRYSTAL_EXP_FIELD_NUMBER = 11;
        private int gainCrystalExp_;
        public static final int STAGE_LIST_FIELD_NUMBER = 14;
        private List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> stageList_;
        public static final int UNLOCKED_CRYSTAL_SKILL_LIST_FIELD_NUMBER = 5;
        private Internal.IntList unlockedCrystalSkillList_;
        private int unlockedCrystalSkillListMemoizedSerializedSize;
        public static final int CHALLENGE_POS_LIST_FIELD_NUMBER = 3;
        private List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> challengePosList_;
        public static final int CHEST_POS_LIST_FIELD_NUMBER = 12;
        private List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> chestPosList_;
        private byte memoizedIsInitialized;
        private static final MichiaeMatsuriActivityDetailInfo DEFAULT_INSTANCE = new MichiaeMatsuriActivityDetailInfo();
        private static final Parser<MichiaeMatsuriActivityDetailInfo> PARSER = new AbstractParser<MichiaeMatsuriActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public MichiaeMatsuriActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MichiaeMatsuriActivityDetailInfo(input, extensionRegistry);
            }
        };

        private MichiaeMatsuriActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockedCrystalSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MichiaeMatsuriActivityDetailInfo() {
            this.unlockedCrystalSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.stageList_ = Collections.emptyList();
            this.unlockedCrystalSkillList_ = emptyIntList();
            this.challengePosList_ = Collections.emptyList();
            this.chestPosList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MichiaeMatsuriActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x0179 */
        private MichiaeMatsuriActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.challengePosList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.challengePosList_.add((MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo) input.readMessage(MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.parser(), extensionRegistry));
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unlockedCrystalSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unlockedCrystalSkillList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unlockedCrystalSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unlockedCrystalSkillList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.gainCrystalExp_ = input.readUInt32();
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.chestPosList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.chestPosList_.add((MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo) input.readMessage(MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.parser(), extensionRegistry));
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.stageList_.add((MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage) input.readMessage(MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.parser(), extensionRegistry));
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 4) != 0) {
                    this.challengePosList_ = Collections.unmodifiableList(this.challengePosList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unlockedCrystalSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.chestPosList_ = Collections.unmodifiableList(this.chestPosList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MichiaeMatsuriActivityDetailInfoOuterClass.internal_static_MichiaeMatsuriActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MichiaeMatsuriActivityDetailInfoOuterClass.f798xee3810e2.ensureFieldAccessorsInitialized(MichiaeMatsuriActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public int getGainCrystalExp() {
            return this.gainCrystalExp_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<? extends MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<Integer> getUnlockedCrystalSkillListList() {
            return this.unlockedCrystalSkillList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public int getUnlockedCrystalSkillListCount() {
            return this.unlockedCrystalSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public int getUnlockedCrystalSkillList(int index) {
            return this.unlockedCrystalSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> getChallengePosListList() {
            return this.challengePosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<? extends MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> getChallengePosListOrBuilderList() {
            return this.challengePosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public int getChallengePosListCount() {
            return this.challengePosList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo getChallengePosList(int index) {
            return this.challengePosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder getChallengePosListOrBuilder(int index) {
            return this.challengePosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> getChestPosListList() {
            return this.chestPosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public List<? extends MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> getChestPosListOrBuilderList() {
            return this.chestPosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public int getChestPosListCount() {
            return this.chestPosList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo getChestPosList(int index) {
            return this.chestPosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
        public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder getChestPosListOrBuilder(int index) {
            return this.chestPosList_.get(index);
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
            for (int i = 0; i < this.challengePosList_.size(); i++) {
                output.writeMessage(3, this.challengePosList_.get(i));
            }
            if (getUnlockedCrystalSkillListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.unlockedCrystalSkillListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unlockedCrystalSkillList_.size(); i2++) {
                output.writeUInt32NoTag(this.unlockedCrystalSkillList_.getInt(i2));
            }
            if (this.gainCrystalExp_ != 0) {
                output.writeUInt32(11, this.gainCrystalExp_);
            }
            for (int i3 = 0; i3 < this.chestPosList_.size(); i3++) {
                output.writeMessage(12, this.chestPosList_.get(i3));
            }
            for (int i4 = 0; i4 < this.stageList_.size(); i4++) {
                output.writeMessage(14, this.stageList_.get(i4));
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
            for (int i = 0; i < this.challengePosList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.challengePosList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.unlockedCrystalSkillList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockedCrystalSkillList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getUnlockedCrystalSkillListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockedCrystalSkillListMemoizedSerializedSize = dataSize;
            if (this.gainCrystalExp_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.gainCrystalExp_);
            }
            for (int i3 = 0; i3 < this.chestPosList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(12, this.chestPosList_.get(i3));
            }
            for (int i4 = 0; i4 < this.stageList_.size(); i4++) {
                size3 += CodedOutputStream.computeMessageSize(14, this.stageList_.get(i4));
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
            if (!(obj instanceof MichiaeMatsuriActivityDetailInfo)) {
                return equals(obj);
            }
            MichiaeMatsuriActivityDetailInfo other = (MichiaeMatsuriActivityDetailInfo) obj;
            return getGainCrystalExp() == other.getGainCrystalExp() && getStageListList().equals(other.getStageListList()) && getUnlockedCrystalSkillListList().equals(other.getUnlockedCrystalSkillListList()) && getChallengePosListList().equals(other.getChallengePosListList()) && getChestPosListList().equals(other.getChestPosListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getGainCrystalExp();
            if (getStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getStageListList().hashCode();
            }
            if (getUnlockedCrystalSkillListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getUnlockedCrystalSkillListList().hashCode();
            }
            if (getChallengePosListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getChallengePosListList().hashCode();
            }
            if (getChestPosListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getChestPosListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (MichiaeMatsuriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MichiaeMatsuriActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriActivityDetailInfoOuterClass$MichiaeMatsuriActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MichiaeMatsuriActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int gainCrystalExp_;
            private RepeatedFieldBuilderV3<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> stageListBuilder_;
            private RepeatedFieldBuilderV3<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> challengePosListBuilder_;
            private RepeatedFieldBuilderV3<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> chestPosListBuilder_;
            private List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> stageList_ = Collections.emptyList();
            private Internal.IntList unlockedCrystalSkillList_ = MichiaeMatsuriActivityDetailInfo.emptyIntList();
            private List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> challengePosList_ = Collections.emptyList();
            private List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> chestPosList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return MichiaeMatsuriActivityDetailInfoOuterClass.internal_static_MichiaeMatsuriActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MichiaeMatsuriActivityDetailInfoOuterClass.f798xee3810e2.ensureFieldAccessorsInitialized(MichiaeMatsuriActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MichiaeMatsuriActivityDetailInfo.alwaysUseFieldBuilders) {
                    getStageListFieldBuilder();
                    getChallengePosListFieldBuilder();
                    getChestPosListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gainCrystalExp_ = 0;
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageListBuilder_.clear();
                }
                this.unlockedCrystalSkillList_ = MichiaeMatsuriActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.challengePosListBuilder_ == null) {
                    this.challengePosList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.challengePosListBuilder_.clear();
                }
                if (this.chestPosListBuilder_ == null) {
                    this.chestPosList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.chestPosListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MichiaeMatsuriActivityDetailInfoOuterClass.internal_static_MichiaeMatsuriActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MichiaeMatsuriActivityDetailInfo getDefaultInstanceForType() {
                return MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriActivityDetailInfo build() {
                MichiaeMatsuriActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriActivityDetailInfo buildPartial() {
                MichiaeMatsuriActivityDetailInfo result = new MichiaeMatsuriActivityDetailInfo(this);
                int i = this.bitField0_;
                result.gainCrystalExp_ = this.gainCrystalExp_;
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageList_ = this.stageList_;
                } else {
                    result.stageList_ = this.stageListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.unlockedCrystalSkillList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unlockedCrystalSkillList_ = this.unlockedCrystalSkillList_;
                if (this.challengePosListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.challengePosList_ = Collections.unmodifiableList(this.challengePosList_);
                        this.bitField0_ &= -5;
                    }
                    result.challengePosList_ = this.challengePosList_;
                } else {
                    result.challengePosList_ = this.challengePosListBuilder_.build();
                }
                if (this.chestPosListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.chestPosList_ = Collections.unmodifiableList(this.chestPosList_);
                        this.bitField0_ &= -9;
                    }
                    result.chestPosList_ = this.chestPosList_;
                } else {
                    result.chestPosList_ = this.chestPosListBuilder_.build();
                }
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
                if (other instanceof MichiaeMatsuriActivityDetailInfo) {
                    return mergeFrom((MichiaeMatsuriActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MichiaeMatsuriActivityDetailInfo other) {
                if (other == MichiaeMatsuriActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getGainCrystalExp() != 0) {
                    setGainCrystalExp(other.getGainCrystalExp());
                }
                if (this.stageListBuilder_ == null) {
                    if (!other.stageList_.isEmpty()) {
                        if (this.stageList_.isEmpty()) {
                            this.stageList_ = other.stageList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageListIsMutable();
                            this.stageList_.addAll(other.stageList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageList_.isEmpty()) {
                    if (this.stageListBuilder_.isEmpty()) {
                        this.stageListBuilder_.dispose();
                        this.stageListBuilder_ = null;
                        this.stageList_ = other.stageList_;
                        this.bitField0_ &= -2;
                        this.stageListBuilder_ = MichiaeMatsuriActivityDetailInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
                    } else {
                        this.stageListBuilder_.addAllMessages(other.stageList_);
                    }
                }
                if (!other.unlockedCrystalSkillList_.isEmpty()) {
                    if (this.unlockedCrystalSkillList_.isEmpty()) {
                        this.unlockedCrystalSkillList_ = other.unlockedCrystalSkillList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnlockedCrystalSkillListIsMutable();
                        this.unlockedCrystalSkillList_.addAll(other.unlockedCrystalSkillList_);
                    }
                    onChanged();
                }
                if (this.challengePosListBuilder_ == null) {
                    if (!other.challengePosList_.isEmpty()) {
                        if (this.challengePosList_.isEmpty()) {
                            this.challengePosList_ = other.challengePosList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureChallengePosListIsMutable();
                            this.challengePosList_.addAll(other.challengePosList_);
                        }
                        onChanged();
                    }
                } else if (!other.challengePosList_.isEmpty()) {
                    if (this.challengePosListBuilder_.isEmpty()) {
                        this.challengePosListBuilder_.dispose();
                        this.challengePosListBuilder_ = null;
                        this.challengePosList_ = other.challengePosList_;
                        this.bitField0_ &= -5;
                        this.challengePosListBuilder_ = MichiaeMatsuriActivityDetailInfo.alwaysUseFieldBuilders ? getChallengePosListFieldBuilder() : null;
                    } else {
                        this.challengePosListBuilder_.addAllMessages(other.challengePosList_);
                    }
                }
                if (this.chestPosListBuilder_ == null) {
                    if (!other.chestPosList_.isEmpty()) {
                        if (this.chestPosList_.isEmpty()) {
                            this.chestPosList_ = other.chestPosList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureChestPosListIsMutable();
                            this.chestPosList_.addAll(other.chestPosList_);
                        }
                        onChanged();
                    }
                } else if (!other.chestPosList_.isEmpty()) {
                    if (this.chestPosListBuilder_.isEmpty()) {
                        this.chestPosListBuilder_.dispose();
                        this.chestPosListBuilder_ = null;
                        this.chestPosList_ = other.chestPosList_;
                        this.bitField0_ &= -9;
                        this.chestPosListBuilder_ = MichiaeMatsuriActivityDetailInfo.alwaysUseFieldBuilders ? getChestPosListFieldBuilder() : null;
                    } else {
                        this.chestPosListBuilder_.addAllMessages(other.chestPosList_);
                    }
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
                MichiaeMatsuriActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MichiaeMatsuriActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MichiaeMatsuriActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public int getGainCrystalExp() {
                return this.gainCrystalExp_;
            }

            public Builder setGainCrystalExp(int value) {
                this.gainCrystalExp_ = value;
                onChanged();
                return this;
            }

            public Builder clearGainCrystalExp() {
                this.gainCrystalExp_ = 0;
                onChanged();
                return this;
            }

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage getStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessage(index);
            }

            public Builder setStageList(int index, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageList(int index, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(int index, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(int index, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageList(Iterable<? extends MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> values) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageList_);
                    onChanged();
                } else {
                    this.stageListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageList() {
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.remove(index);
                    onChanged();
                } else {
                    this.stageListBuilder_.remove(index);
                }
                return this;
            }

            public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder getStageListBuilder(int index) {
                return getStageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<? extends MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> getStageListOrBuilderList() {
                if (this.stageListBuilder_ != null) {
                    return this.stageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageList_);
            }

            public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder addStageListBuilder() {
                return getStageListFieldBuilder().addBuilder(MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.getDefaultInstance());
            }

            public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder addStageListBuilder(int index) {
                return getStageListFieldBuilder().addBuilder(index, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.getDefaultInstance());
            }

            public List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder> getStageListBuilderList() {
                return getStageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> getStageListFieldBuilder() {
                if (this.stageListBuilder_ == null) {
                    this.stageListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageList_ = null;
                }
                return this.stageListBuilder_;
            }

            private void ensureUnlockedCrystalSkillListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unlockedCrystalSkillList_ = MichiaeMatsuriActivityDetailInfo.mutableCopy(this.unlockedCrystalSkillList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<Integer> getUnlockedCrystalSkillListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unlockedCrystalSkillList_) : this.unlockedCrystalSkillList_;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public int getUnlockedCrystalSkillListCount() {
                return this.unlockedCrystalSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public int getUnlockedCrystalSkillList(int index) {
                return this.unlockedCrystalSkillList_.getInt(index);
            }

            public Builder setUnlockedCrystalSkillList(int index, int value) {
                ensureUnlockedCrystalSkillListIsMutable();
                this.unlockedCrystalSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockedCrystalSkillList(int value) {
                ensureUnlockedCrystalSkillListIsMutable();
                this.unlockedCrystalSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockedCrystalSkillList(Iterable<? extends Integer> values) {
                ensureUnlockedCrystalSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockedCrystalSkillList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockedCrystalSkillList() {
                this.unlockedCrystalSkillList_ = MichiaeMatsuriActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureChallengePosListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.challengePosList_ = new ArrayList(this.challengePosList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> getChallengePosListList() {
                if (this.challengePosListBuilder_ == null) {
                    return Collections.unmodifiableList(this.challengePosList_);
                }
                return this.challengePosListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public int getChallengePosListCount() {
                if (this.challengePosListBuilder_ == null) {
                    return this.challengePosList_.size();
                }
                return this.challengePosListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo getChallengePosList(int index) {
                if (this.challengePosListBuilder_ == null) {
                    return this.challengePosList_.get(index);
                }
                return this.challengePosListBuilder_.getMessage(index);
            }

            public Builder setChallengePosList(int index, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo value) {
                if (this.challengePosListBuilder_ != null) {
                    this.challengePosListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChallengePosList(int index, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder builderForValue) {
                if (this.challengePosListBuilder_ == null) {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengePosListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChallengePosList(MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo value) {
                if (this.challengePosListBuilder_ != null) {
                    this.challengePosListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengePosList(int index, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo value) {
                if (this.challengePosListBuilder_ != null) {
                    this.challengePosListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChallengePosList(MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder builderForValue) {
                if (this.challengePosListBuilder_ == null) {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.challengePosListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChallengePosList(int index, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder builderForValue) {
                if (this.challengePosListBuilder_ == null) {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.challengePosListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChallengePosList(Iterable<? extends MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> values) {
                if (this.challengePosListBuilder_ == null) {
                    ensureChallengePosListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.challengePosList_);
                    onChanged();
                } else {
                    this.challengePosListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChallengePosList() {
                if (this.challengePosListBuilder_ == null) {
                    this.challengePosList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.challengePosListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChallengePosList(int index) {
                if (this.challengePosListBuilder_ == null) {
                    ensureChallengePosListIsMutable();
                    this.challengePosList_.remove(index);
                    onChanged();
                } else {
                    this.challengePosListBuilder_.remove(index);
                }
                return this;
            }

            public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder getChallengePosListBuilder(int index) {
                return getChallengePosListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder getChallengePosListOrBuilder(int index) {
                if (this.challengePosListBuilder_ == null) {
                    return this.challengePosList_.get(index);
                }
                return this.challengePosListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<? extends MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> getChallengePosListOrBuilderList() {
                if (this.challengePosListBuilder_ != null) {
                    return this.challengePosListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.challengePosList_);
            }

            public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder addChallengePosListBuilder() {
                return getChallengePosListFieldBuilder().addBuilder(MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.getDefaultInstance());
            }

            public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder addChallengePosListBuilder(int index) {
                return getChallengePosListFieldBuilder().addBuilder(index, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.getDefaultInstance());
            }

            public List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder> getChallengePosListBuilderList() {
                return getChallengePosListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> getChallengePosListFieldBuilder() {
                if (this.challengePosListBuilder_ == null) {
                    this.challengePosListBuilder_ = new RepeatedFieldBuilderV3<>(this.challengePosList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.challengePosList_ = null;
                }
                return this.challengePosListBuilder_;
            }

            private void ensureChestPosListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.chestPosList_ = new ArrayList(this.chestPosList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> getChestPosListList() {
                if (this.chestPosListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chestPosList_);
                }
                return this.chestPosListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public int getChestPosListCount() {
                if (this.chestPosListBuilder_ == null) {
                    return this.chestPosList_.size();
                }
                return this.chestPosListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo getChestPosList(int index) {
                if (this.chestPosListBuilder_ == null) {
                    return this.chestPosList_.get(index);
                }
                return this.chestPosListBuilder_.getMessage(index);
            }

            public Builder setChestPosList(int index, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo value) {
                if (this.chestPosListBuilder_ != null) {
                    this.chestPosListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChestPosList(int index, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder builderForValue) {
                if (this.chestPosListBuilder_ == null) {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chestPosListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChestPosList(MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo value) {
                if (this.chestPosListBuilder_ != null) {
                    this.chestPosListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChestPosList(int index, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo value) {
                if (this.chestPosListBuilder_ != null) {
                    this.chestPosListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChestPosList(MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder builderForValue) {
                if (this.chestPosListBuilder_ == null) {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.chestPosListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChestPosList(int index, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder builderForValue) {
                if (this.chestPosListBuilder_ == null) {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chestPosListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChestPosList(Iterable<? extends MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> values) {
                if (this.chestPosListBuilder_ == null) {
                    ensureChestPosListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chestPosList_);
                    onChanged();
                } else {
                    this.chestPosListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChestPosList() {
                if (this.chestPosListBuilder_ == null) {
                    this.chestPosList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.chestPosListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChestPosList(int index) {
                if (this.chestPosListBuilder_ == null) {
                    ensureChestPosListIsMutable();
                    this.chestPosList_.remove(index);
                    onChanged();
                } else {
                    this.chestPosListBuilder_.remove(index);
                }
                return this;
            }

            public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder getChestPosListBuilder(int index) {
                return getChestPosListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder getChestPosListOrBuilder(int index) {
                if (this.chestPosListBuilder_ == null) {
                    return this.chestPosList_.get(index);
                }
                return this.chestPosListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder
            public List<? extends MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> getChestPosListOrBuilderList() {
                if (this.chestPosListBuilder_ != null) {
                    return this.chestPosListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.chestPosList_);
            }

            public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder addChestPosListBuilder() {
                return getChestPosListFieldBuilder().addBuilder(MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.getDefaultInstance());
            }

            public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder addChestPosListBuilder(int index) {
                return getChestPosListFieldBuilder().addBuilder(index, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.getDefaultInstance());
            }

            public List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder> getChestPosListBuilderList() {
                return getChestPosListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> getChestPosListFieldBuilder() {
                if (this.chestPosListBuilder_ == null) {
                    this.chestPosListBuilder_ = new RepeatedFieldBuilderV3<>(this.chestPosList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.chestPosList_ = null;
                }
                return this.chestPosListBuilder_;
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

        public static MichiaeMatsuriActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MichiaeMatsuriActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MichiaeMatsuriActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MichiaeMatsuriActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MichiaeMatsuriChallengePositionInfoOuterClass.getDescriptor();
        MichiaeMatsuriChestPositionInfoOuterClass.getDescriptor();
        MichiaeMatsuriStageOuterClass.getDescriptor();
    }
}
