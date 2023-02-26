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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriInfoOuterClass.class */
public final class MichiaeMatsuriInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018MichiaeMatsuriInfo.proto\u001a)MichiaeMatsuriChallengePositionInfo.proto\u001a%MichiaeMatsuriChestPositionInfo.proto\u001a\u0019MichiaeMatsuriStage.proto\"ï\u0001\n\u0012MichiaeMatsuriInfo\u0012>\n\u0010challengePosList\u0018\b \u0003(\u000b2$.MichiaeMatsuriChallengePositionInfo\u0012 \n\u0018unlockedCrystalSkillList\u0018\u0004 \u0003(\r\u0012\u0016\n\u000egainCrystalExp\u0018\u0005 \u0001(\r\u00126\n\fchestPosList\u0018\u000b \u0003(\u000b2 .MichiaeMatsuriChestPositionInfo\u0012'\n\tstageList\u0018\u0007 \u0003(\u000b2\u0014.MichiaeMatsuriStageB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MichiaeMatsuriChallengePositionInfoOuterClass.getDescriptor(), MichiaeMatsuriChestPositionInfoOuterClass.getDescriptor(), MichiaeMatsuriStageOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MichiaeMatsuriInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MichiaeMatsuriInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MichiaeMatsuriInfo_descriptor, new String[]{"ChallengePosList", "UnlockedCrystalSkillList", "GainCrystalExp", "ChestPosList", "StageList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriInfoOuterClass$MichiaeMatsuriInfoOrBuilder.class */
    public interface MichiaeMatsuriInfoOrBuilder extends MessageOrBuilder {
        List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> getChallengePosListList();

        MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo getChallengePosList(int i);

        int getChallengePosListCount();

        List<? extends MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> getChallengePosListOrBuilderList();

        MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder getChallengePosListOrBuilder(int i);

        List<Integer> getUnlockedCrystalSkillListList();

        int getUnlockedCrystalSkillListCount();

        int getUnlockedCrystalSkillList(int i);

        int getGainCrystalExp();

        List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> getChestPosListList();

        MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo getChestPosList(int i);

        int getChestPosListCount();

        List<? extends MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> getChestPosListOrBuilderList();

        MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder getChestPosListOrBuilder(int i);

        List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> getStageListList();

        MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage getStageList(int i);

        int getStageListCount();

        List<? extends MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> getStageListOrBuilderList();

        MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder getStageListOrBuilder(int i);
    }

    private MichiaeMatsuriInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriInfoOuterClass$MichiaeMatsuriInfo.class */
    public static final class MichiaeMatsuriInfo extends GeneratedMessageV3 implements MichiaeMatsuriInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGEPOSLIST_FIELD_NUMBER = 8;
        private List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> challengePosList_;
        public static final int UNLOCKEDCRYSTALSKILLLIST_FIELD_NUMBER = 4;
        private Internal.IntList unlockedCrystalSkillList_;
        private int unlockedCrystalSkillListMemoizedSerializedSize;
        public static final int GAINCRYSTALEXP_FIELD_NUMBER = 5;
        private int gainCrystalExp_;
        public static final int CHESTPOSLIST_FIELD_NUMBER = 11;
        private List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> chestPosList_;
        public static final int STAGELIST_FIELD_NUMBER = 7;
        private List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> stageList_;
        private byte memoizedIsInitialized;
        private static final MichiaeMatsuriInfo DEFAULT_INSTANCE = new MichiaeMatsuriInfo();
        private static final Parser<MichiaeMatsuriInfo> PARSER = new AbstractParser<MichiaeMatsuriInfo>() { // from class: emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.1
            @Override // com.google.protobuf.Parser
            public MichiaeMatsuriInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MichiaeMatsuriInfo(input, extensionRegistry);
            }
        };

        private MichiaeMatsuriInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockedCrystalSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MichiaeMatsuriInfo() {
            this.unlockedCrystalSkillListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.challengePosList_ = Collections.emptyList();
            this.unlockedCrystalSkillList_ = emptyIntList();
            this.chestPosList_ = Collections.emptyList();
            this.stageList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MichiaeMatsuriInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x0179 */
        private MichiaeMatsuriInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unlockedCrystalSkillList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unlockedCrystalSkillList_.addInt(input.readUInt32());
                                break;
                            case 34:
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
                            case 40:
                                this.gainCrystalExp_ = input.readUInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.stageList_.add((MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage) input.readMessage(MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.parser(), extensionRegistry));
                                break;
                            case 66:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.challengePosList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.challengePosList_.add((MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo) input.readMessage(MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.parser(), extensionRegistry));
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.chestPosList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.chestPosList_.add((MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo) input.readMessage(MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unlockedCrystalSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.challengePosList_ = Collections.unmodifiableList(this.challengePosList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.chestPosList_ = Collections.unmodifiableList(this.chestPosList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MichiaeMatsuriInfoOuterClass.internal_static_MichiaeMatsuriInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MichiaeMatsuriInfoOuterClass.internal_static_MichiaeMatsuriInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MichiaeMatsuriInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> getChallengePosListList() {
            return this.challengePosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<? extends MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> getChallengePosListOrBuilderList() {
            return this.challengePosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public int getChallengePosListCount() {
            return this.challengePosList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo getChallengePosList(int index) {
            return this.challengePosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder getChallengePosListOrBuilder(int index) {
            return this.challengePosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<Integer> getUnlockedCrystalSkillListList() {
            return this.unlockedCrystalSkillList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public int getUnlockedCrystalSkillListCount() {
            return this.unlockedCrystalSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public int getUnlockedCrystalSkillList(int index) {
            return this.unlockedCrystalSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public int getGainCrystalExp() {
            return this.gainCrystalExp_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> getChestPosListList() {
            return this.chestPosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<? extends MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> getChestPosListOrBuilderList() {
            return this.chestPosList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public int getChestPosListCount() {
            return this.chestPosList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo getChestPosList(int index) {
            return this.chestPosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder getChestPosListOrBuilder(int index) {
            return this.chestPosList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public List<? extends MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
        public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
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
            if (getUnlockedCrystalSkillListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.unlockedCrystalSkillListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unlockedCrystalSkillList_.size(); i++) {
                output.writeUInt32NoTag(this.unlockedCrystalSkillList_.getInt(i));
            }
            if (this.gainCrystalExp_ != 0) {
                output.writeUInt32(5, this.gainCrystalExp_);
            }
            for (int i2 = 0; i2 < this.stageList_.size(); i2++) {
                output.writeMessage(7, this.stageList_.get(i2));
            }
            for (int i3 = 0; i3 < this.challengePosList_.size(); i3++) {
                output.writeMessage(8, this.challengePosList_.get(i3));
            }
            for (int i4 = 0; i4 < this.chestPosList_.size(); i4++) {
                output.writeMessage(11, this.chestPosList_.get(i4));
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
            for (int i = 0; i < this.unlockedCrystalSkillList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockedCrystalSkillList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnlockedCrystalSkillListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockedCrystalSkillListMemoizedSerializedSize = dataSize;
            if (this.gainCrystalExp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.gainCrystalExp_);
            }
            for (int i2 = 0; i2 < this.stageList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.stageList_.get(i2));
            }
            for (int i3 = 0; i3 < this.challengePosList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.challengePosList_.get(i3));
            }
            for (int i4 = 0; i4 < this.chestPosList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.chestPosList_.get(i4));
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
            if (!(obj instanceof MichiaeMatsuriInfo)) {
                return equals(obj);
            }
            MichiaeMatsuriInfo other = (MichiaeMatsuriInfo) obj;
            return getChallengePosListList().equals(other.getChallengePosListList()) && getUnlockedCrystalSkillListList().equals(other.getUnlockedCrystalSkillListList()) && getGainCrystalExp() == other.getGainCrystalExp() && getChestPosListList().equals(other.getChestPosListList()) && getStageListList().equals(other.getStageListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getChallengePosListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getChallengePosListList().hashCode();
            }
            if (getUnlockedCrystalSkillListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getUnlockedCrystalSkillListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 5)) + getGainCrystalExp();
            if (getChestPosListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getChestPosListList().hashCode();
            }
            if (getStageListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getStageListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static MichiaeMatsuriInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriInfo parseFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriInfo parseFrom(CodedInputStream input) throws IOException {
            return (MichiaeMatsuriInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MichiaeMatsuriInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriInfoOuterClass$MichiaeMatsuriInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MichiaeMatsuriInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo.Builder, MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder> challengePosListBuilder_;
            private int gainCrystalExp_;
            private RepeatedFieldBuilderV3<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.Builder, MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder> chestPosListBuilder_;
            private RepeatedFieldBuilderV3<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.Builder, MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder> stageListBuilder_;
            private List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> challengePosList_ = Collections.emptyList();
            private Internal.IntList unlockedCrystalSkillList_ = MichiaeMatsuriInfo.emptyIntList();
            private List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> chestPosList_ = Collections.emptyList();
            private List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> stageList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return MichiaeMatsuriInfoOuterClass.internal_static_MichiaeMatsuriInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MichiaeMatsuriInfoOuterClass.internal_static_MichiaeMatsuriInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MichiaeMatsuriInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MichiaeMatsuriInfo.alwaysUseFieldBuilders) {
                    getChallengePosListFieldBuilder();
                    getChestPosListFieldBuilder();
                    getStageListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.challengePosListBuilder_ == null) {
                    this.challengePosList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.challengePosListBuilder_.clear();
                }
                this.unlockedCrystalSkillList_ = MichiaeMatsuriInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.gainCrystalExp_ = 0;
                if (this.chestPosListBuilder_ == null) {
                    this.chestPosList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.chestPosListBuilder_.clear();
                }
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MichiaeMatsuriInfoOuterClass.internal_static_MichiaeMatsuriInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MichiaeMatsuriInfo getDefaultInstanceForType() {
                return MichiaeMatsuriInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriInfo build() {
                MichiaeMatsuriInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriInfo buildPartial() {
                MichiaeMatsuriInfo result = new MichiaeMatsuriInfo(this);
                int i = this.bitField0_;
                if (this.challengePosListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.challengePosList_ = Collections.unmodifiableList(this.challengePosList_);
                        this.bitField0_ &= -2;
                    }
                    result.challengePosList_ = this.challengePosList_;
                } else {
                    result.challengePosList_ = this.challengePosListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.unlockedCrystalSkillList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unlockedCrystalSkillList_ = this.unlockedCrystalSkillList_;
                result.gainCrystalExp_ = this.gainCrystalExp_;
                if (this.chestPosListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.chestPosList_ = Collections.unmodifiableList(this.chestPosList_);
                        this.bitField0_ &= -5;
                    }
                    result.chestPosList_ = this.chestPosList_;
                } else {
                    result.chestPosList_ = this.chestPosListBuilder_.build();
                }
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -9;
                    }
                    result.stageList_ = this.stageList_;
                } else {
                    result.stageList_ = this.stageListBuilder_.build();
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
                if (other instanceof MichiaeMatsuriInfo) {
                    return mergeFrom((MichiaeMatsuriInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MichiaeMatsuriInfo other) {
                if (other == MichiaeMatsuriInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.challengePosListBuilder_ == null) {
                    if (!other.challengePosList_.isEmpty()) {
                        if (this.challengePosList_.isEmpty()) {
                            this.challengePosList_ = other.challengePosList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.challengePosListBuilder_ = MichiaeMatsuriInfo.alwaysUseFieldBuilders ? getChallengePosListFieldBuilder() : null;
                    } else {
                        this.challengePosListBuilder_.addAllMessages(other.challengePosList_);
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
                if (other.getGainCrystalExp() != 0) {
                    setGainCrystalExp(other.getGainCrystalExp());
                }
                if (this.chestPosListBuilder_ == null) {
                    if (!other.chestPosList_.isEmpty()) {
                        if (this.chestPosList_.isEmpty()) {
                            this.chestPosList_ = other.chestPosList_;
                            this.bitField0_ &= -5;
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
                        this.bitField0_ &= -5;
                        this.chestPosListBuilder_ = MichiaeMatsuriInfo.alwaysUseFieldBuilders ? getChestPosListFieldBuilder() : null;
                    } else {
                        this.chestPosListBuilder_.addAllMessages(other.chestPosList_);
                    }
                }
                if (this.stageListBuilder_ == null) {
                    if (!other.stageList_.isEmpty()) {
                        if (this.stageList_.isEmpty()) {
                            this.stageList_ = other.stageList_;
                            this.bitField0_ &= -9;
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
                        this.bitField0_ &= -9;
                        this.stageListBuilder_ = MichiaeMatsuriInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
                    } else {
                        this.stageListBuilder_.addAllMessages(other.stageList_);
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
                MichiaeMatsuriInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MichiaeMatsuriInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MichiaeMatsuriInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureChallengePosListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.challengePosList_ = new ArrayList(this.challengePosList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public List<MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfo> getChallengePosListList() {
                if (this.challengePosListBuilder_ == null) {
                    return Collections.unmodifiableList(this.challengePosList_);
                }
                return this.challengePosListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public int getChallengePosListCount() {
                if (this.challengePosListBuilder_ == null) {
                    return this.challengePosList_.size();
                }
                return this.challengePosListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                    this.bitField0_ &= -2;
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

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public MichiaeMatsuriChallengePositionInfoOuterClass.MichiaeMatsuriChallengePositionInfoOrBuilder getChallengePosListOrBuilder(int index) {
                if (this.challengePosListBuilder_ == null) {
                    return this.challengePosList_.get(index);
                }
                return this.challengePosListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                    this.challengePosListBuilder_ = new RepeatedFieldBuilderV3<>(this.challengePosList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.challengePosList_ = null;
                }
                return this.challengePosListBuilder_;
            }

            private void ensureUnlockedCrystalSkillListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unlockedCrystalSkillList_ = MichiaeMatsuriInfo.mutableCopy(this.unlockedCrystalSkillList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public List<Integer> getUnlockedCrystalSkillListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unlockedCrystalSkillList_) : this.unlockedCrystalSkillList_;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public int getUnlockedCrystalSkillListCount() {
                return this.unlockedCrystalSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                this.unlockedCrystalSkillList_ = MichiaeMatsuriInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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

            private void ensureChestPosListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.chestPosList_ = new ArrayList(this.chestPosList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public List<MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo> getChestPosListList() {
                if (this.chestPosListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chestPosList_);
                }
                return this.chestPosListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public int getChestPosListCount() {
                if (this.chestPosListBuilder_ == null) {
                    return this.chestPosList_.size();
                }
                return this.chestPosListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                    this.bitField0_ &= -5;
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

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder getChestPosListOrBuilder(int index) {
                if (this.chestPosListBuilder_ == null) {
                    return this.chestPosList_.get(index);
                }
                return this.chestPosListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                    this.chestPosListBuilder_ = new RepeatedFieldBuilderV3<>(this.chestPosList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.chestPosList_ = null;
                }
                return this.chestPosListBuilder_;
            }

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public List<MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                    this.bitField0_ &= -9;
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

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
            public MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder
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
                    this.stageListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.stageList_ = null;
                }
                return this.stageListBuilder_;
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

        public static MichiaeMatsuriInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MichiaeMatsuriInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MichiaeMatsuriInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MichiaeMatsuriInfo getDefaultInstanceForType() {
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
