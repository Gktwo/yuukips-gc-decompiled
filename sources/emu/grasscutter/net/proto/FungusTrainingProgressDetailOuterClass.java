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
import emu.grasscutter.net.proto.FungusFighterMonsterDetailOuterClass;
import emu.grasscutter.net.proto.FungusTrainingPoolPreviewDetailOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingProgressDetailOuterClass.class */
public final class FungusTrainingProgressDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"FungusTrainingProgressDetail.proto\u001a%FungusTrainingPoolPreviewDetail.proto\u001a FungusFighterMonsterDetail.proto\"\u0002\n\u001cFungusTrainingProgressDetail\u0012\u001b\n\u0013Unk3300_EEOIMDJOHCM\u0018\u000f \u0003(\r\u0012\u0010\n\bcurRound\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_NLHEFGBEOAC\u0018\b \u0003(\r\u0012@\n\u0016monsterPoolPreviewList\u0018\t \u0003(\u000b2 .FungusTrainingPoolPreviewDetail\u0012\u0015\n\rtotalUsedTime\u0018\u0004 \u0001(\r\u00126\n\u0011monsterDetailList\u0018\u0002 \u0003(\u000b2\u001b.FungusFighterMonsterDetail\u0012\u0011\n\tdungeonId\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FungusTrainingPoolPreviewDetailOuterClass.getDescriptor(), FungusFighterMonsterDetailOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FungusTrainingProgressDetail_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FungusTrainingProgressDetail_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusTrainingProgressDetail_descriptor, new String[]{"Unk3300EEOIMDJOHCM", "CurRound", "Unk3300NLHEFGBEOAC", "MonsterPoolPreviewList", "TotalUsedTime", "MonsterDetailList", "DungeonId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingProgressDetailOuterClass$FungusTrainingProgressDetailOrBuilder.class */
    public interface FungusTrainingProgressDetailOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300EEOIMDJOHCMList();

        int getUnk3300EEOIMDJOHCMCount();

        int getUnk3300EEOIMDJOHCM(int i);

        int getCurRound();

        List<Integer> getUnk3300NLHEFGBEOACList();

        int getUnk3300NLHEFGBEOACCount();

        int getUnk3300NLHEFGBEOAC(int i);

        List<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail> getMonsterPoolPreviewListList();

        FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail getMonsterPoolPreviewList(int i);

        int getMonsterPoolPreviewListCount();

        List<? extends FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder> getMonsterPoolPreviewListOrBuilderList();

        FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder getMonsterPoolPreviewListOrBuilder(int i);

        int getTotalUsedTime();

        List<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail> getMonsterDetailListList();

        FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail getMonsterDetailList(int i);

        int getMonsterDetailListCount();

        List<? extends FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder> getMonsterDetailListOrBuilderList();

        FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder getMonsterDetailListOrBuilder(int i);

        int getDungeonId();
    }

    private FungusTrainingProgressDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingProgressDetailOuterClass$FungusTrainingProgressDetail.class */
    public static final class FungusTrainingProgressDetail extends GeneratedMessageV3 implements FungusTrainingProgressDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_EEOIMDJOHCM_FIELD_NUMBER = 15;
        private Internal.IntList unk3300EEOIMDJOHCM_;
        private int unk3300EEOIMDJOHCMMemoizedSerializedSize;
        public static final int CURROUND_FIELD_NUMBER = 1;
        private int curRound_;
        public static final int UNK3300_NLHEFGBEOAC_FIELD_NUMBER = 8;
        private Internal.IntList unk3300NLHEFGBEOAC_;
        private int unk3300NLHEFGBEOACMemoizedSerializedSize;
        public static final int MONSTERPOOLPREVIEWLIST_FIELD_NUMBER = 9;
        private List<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail> monsterPoolPreviewList_;
        public static final int TOTALUSEDTIME_FIELD_NUMBER = 4;
        private int totalUsedTime_;
        public static final int MONSTERDETAILLIST_FIELD_NUMBER = 2;
        private List<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail> monsterDetailList_;
        public static final int DUNGEONID_FIELD_NUMBER = 13;
        private int dungeonId_;
        private byte memoizedIsInitialized;
        private static final FungusTrainingProgressDetail DEFAULT_INSTANCE = new FungusTrainingProgressDetail();
        private static final Parser<FungusTrainingProgressDetail> PARSER = new AbstractParser<FungusTrainingProgressDetail>() { // from class: emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.1
            @Override // com.google.protobuf.Parser
            public FungusTrainingProgressDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusTrainingProgressDetail(input, extensionRegistry);
            }
        };

        private FungusTrainingProgressDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300EEOIMDJOHCMMemoizedSerializedSize = -1;
            this.unk3300NLHEFGBEOACMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FungusTrainingProgressDetail() {
            this.unk3300EEOIMDJOHCMMemoizedSerializedSize = -1;
            this.unk3300NLHEFGBEOACMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300EEOIMDJOHCM_ = emptyIntList();
            this.unk3300NLHEFGBEOAC_ = emptyIntList();
            this.monsterPoolPreviewList_ = Collections.emptyList();
            this.monsterDetailList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusTrainingProgressDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:106:0x01e1 */
        private FungusTrainingProgressDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.curRound_ = input.readUInt32();
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.monsterDetailList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.monsterDetailList_.add((FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail) input.readMessage(FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.parser(), extensionRegistry));
                                break;
                            case 32:
                                this.totalUsedTime_ = input.readUInt32();
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300NLHEFGBEOAC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300NLHEFGBEOAC_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300NLHEFGBEOAC_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300NLHEFGBEOAC_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.monsterPoolPreviewList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.monsterPoolPreviewList_.add((FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail) input.readMessage(FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.parser(), extensionRegistry));
                                break;
                            case 104:
                                this.dungeonId_ = input.readUInt32();
                                break;
                            case 120:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300EEOIMDJOHCM_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300EEOIMDJOHCM_.addInt(input.readUInt32());
                                break;
                            case 122:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300EEOIMDJOHCM_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300EEOIMDJOHCM_.addInt(input.readUInt32());
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 8) != 0) {
                    this.monsterDetailList_ = Collections.unmodifiableList(this.monsterDetailList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300NLHEFGBEOAC_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.monsterPoolPreviewList_ = Collections.unmodifiableList(this.monsterPoolPreviewList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300EEOIMDJOHCM_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FungusTrainingProgressDetailOuterClass.internal_static_FungusTrainingProgressDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusTrainingProgressDetailOuterClass.internal_static_FungusTrainingProgressDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusTrainingProgressDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public List<Integer> getUnk3300EEOIMDJOHCMList() {
            return this.unk3300EEOIMDJOHCM_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getUnk3300EEOIMDJOHCMCount() {
            return this.unk3300EEOIMDJOHCM_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getUnk3300EEOIMDJOHCM(int index) {
            return this.unk3300EEOIMDJOHCM_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getCurRound() {
            return this.curRound_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public List<Integer> getUnk3300NLHEFGBEOACList() {
            return this.unk3300NLHEFGBEOAC_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getUnk3300NLHEFGBEOACCount() {
            return this.unk3300NLHEFGBEOAC_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getUnk3300NLHEFGBEOAC(int index) {
            return this.unk3300NLHEFGBEOAC_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public List<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail> getMonsterPoolPreviewListList() {
            return this.monsterPoolPreviewList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public List<? extends FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder> getMonsterPoolPreviewListOrBuilderList() {
            return this.monsterPoolPreviewList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getMonsterPoolPreviewListCount() {
            return this.monsterPoolPreviewList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail getMonsterPoolPreviewList(int index) {
            return this.monsterPoolPreviewList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder getMonsterPoolPreviewListOrBuilder(int index) {
            return this.monsterPoolPreviewList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getTotalUsedTime() {
            return this.totalUsedTime_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public List<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail> getMonsterDetailListList() {
            return this.monsterDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public List<? extends FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder> getMonsterDetailListOrBuilderList() {
            return this.monsterDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getMonsterDetailListCount() {
            return this.monsterDetailList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail getMonsterDetailList(int index) {
            return this.monsterDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder getMonsterDetailListOrBuilder(int index) {
            return this.monsterDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
        public int getDungeonId() {
            return this.dungeonId_;
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
            if (this.curRound_ != 0) {
                output.writeUInt32(1, this.curRound_);
            }
            for (int i = 0; i < this.monsterDetailList_.size(); i++) {
                output.writeMessage(2, this.monsterDetailList_.get(i));
            }
            if (this.totalUsedTime_ != 0) {
                output.writeUInt32(4, this.totalUsedTime_);
            }
            if (getUnk3300NLHEFGBEOACList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.unk3300NLHEFGBEOACMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300NLHEFGBEOAC_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300NLHEFGBEOAC_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.monsterPoolPreviewList_.size(); i3++) {
                output.writeMessage(9, this.monsterPoolPreviewList_.get(i3));
            }
            if (this.dungeonId_ != 0) {
                output.writeUInt32(13, this.dungeonId_);
            }
            if (getUnk3300EEOIMDJOHCMList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.unk3300EEOIMDJOHCMMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.unk3300EEOIMDJOHCM_.size(); i4++) {
                output.writeUInt32NoTag(this.unk3300EEOIMDJOHCM_.getInt(i4));
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
            if (this.curRound_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.curRound_);
            }
            for (int i = 0; i < this.monsterDetailList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.monsterDetailList_.get(i));
            }
            if (this.totalUsedTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.totalUsedTime_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.unk3300NLHEFGBEOAC_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300NLHEFGBEOAC_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300NLHEFGBEOACList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300NLHEFGBEOACMemoizedSerializedSize = dataSize;
            for (int i3 = 0; i3 < this.monsterPoolPreviewList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(9, this.monsterPoolPreviewList_.get(i3));
            }
            if (this.dungeonId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.dungeonId_);
            }
            int dataSize2 = 0;
            for (int i4 = 0; i4 < this.unk3300EEOIMDJOHCM_.size(); i4++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300EEOIMDJOHCM_.getInt(i4));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300EEOIMDJOHCMList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300EEOIMDJOHCMMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FungusTrainingProgressDetail)) {
                return equals(obj);
            }
            FungusTrainingProgressDetail other = (FungusTrainingProgressDetail) obj;
            return getUnk3300EEOIMDJOHCMList().equals(other.getUnk3300EEOIMDJOHCMList()) && getCurRound() == other.getCurRound() && getUnk3300NLHEFGBEOACList().equals(other.getUnk3300NLHEFGBEOACList()) && getMonsterPoolPreviewListList().equals(other.getMonsterPoolPreviewListList()) && getTotalUsedTime() == other.getTotalUsedTime() && getMonsterDetailListList().equals(other.getMonsterDetailListList()) && getDungeonId() == other.getDungeonId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300EEOIMDJOHCMCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getUnk3300EEOIMDJOHCMList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 1)) + getCurRound();
            if (getUnk3300NLHEFGBEOACCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getUnk3300NLHEFGBEOACList().hashCode();
            }
            if (getMonsterPoolPreviewListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 9)) + getMonsterPoolPreviewListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 4)) + getTotalUsedTime();
            if (getMonsterDetailListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 2)) + getMonsterDetailListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * hash3) + 13)) + getDungeonId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static FungusTrainingProgressDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingProgressDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingProgressDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingProgressDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingProgressDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusTrainingProgressDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusTrainingProgressDetail parseFrom(InputStream input) throws IOException {
            return (FungusTrainingProgressDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingProgressDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingProgressDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingProgressDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusTrainingProgressDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusTrainingProgressDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingProgressDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusTrainingProgressDetail parseFrom(CodedInputStream input) throws IOException {
            return (FungusTrainingProgressDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusTrainingProgressDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusTrainingProgressDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusTrainingProgressDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusTrainingProgressDetailOuterClass$FungusTrainingProgressDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusTrainingProgressDetailOrBuilder {
            private int bitField0_;
            private int curRound_;
            private RepeatedFieldBuilderV3<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder> monsterPoolPreviewListBuilder_;
            private int totalUsedTime_;
            private RepeatedFieldBuilderV3<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder> monsterDetailListBuilder_;
            private int dungeonId_;
            private Internal.IntList unk3300EEOIMDJOHCM_ = FungusTrainingProgressDetail.emptyIntList();
            private Internal.IntList unk3300NLHEFGBEOAC_ = FungusTrainingProgressDetail.emptyIntList();
            private List<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail> monsterPoolPreviewList_ = Collections.emptyList();
            private List<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail> monsterDetailList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusTrainingProgressDetailOuterClass.internal_static_FungusTrainingProgressDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusTrainingProgressDetailOuterClass.internal_static_FungusTrainingProgressDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusTrainingProgressDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusTrainingProgressDetail.alwaysUseFieldBuilders) {
                    getMonsterPoolPreviewListFieldBuilder();
                    getMonsterDetailListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300EEOIMDJOHCM_ = FungusTrainingProgressDetail.emptyIntList();
                this.bitField0_ &= -2;
                this.curRound_ = 0;
                this.unk3300NLHEFGBEOAC_ = FungusTrainingProgressDetail.emptyIntList();
                this.bitField0_ &= -3;
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    this.monsterPoolPreviewList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.monsterPoolPreviewListBuilder_.clear();
                }
                this.totalUsedTime_ = 0;
                if (this.monsterDetailListBuilder_ == null) {
                    this.monsterDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.monsterDetailListBuilder_.clear();
                }
                this.dungeonId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusTrainingProgressDetailOuterClass.internal_static_FungusTrainingProgressDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusTrainingProgressDetail getDefaultInstanceForType() {
                return FungusTrainingProgressDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingProgressDetail build() {
                FungusTrainingProgressDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusTrainingProgressDetail buildPartial() {
                FungusTrainingProgressDetail result = new FungusTrainingProgressDetail(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300EEOIMDJOHCM_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300EEOIMDJOHCM_ = this.unk3300EEOIMDJOHCM_;
                result.curRound_ = this.curRound_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300NLHEFGBEOAC_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300NLHEFGBEOAC_ = this.unk3300NLHEFGBEOAC_;
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.monsterPoolPreviewList_ = Collections.unmodifiableList(this.monsterPoolPreviewList_);
                        this.bitField0_ &= -5;
                    }
                    result.monsterPoolPreviewList_ = this.monsterPoolPreviewList_;
                } else {
                    result.monsterPoolPreviewList_ = this.monsterPoolPreviewListBuilder_.build();
                }
                result.totalUsedTime_ = this.totalUsedTime_;
                if (this.monsterDetailListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.monsterDetailList_ = Collections.unmodifiableList(this.monsterDetailList_);
                        this.bitField0_ &= -9;
                    }
                    result.monsterDetailList_ = this.monsterDetailList_;
                } else {
                    result.monsterDetailList_ = this.monsterDetailListBuilder_.build();
                }
                result.dungeonId_ = this.dungeonId_;
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
                if (other instanceof FungusTrainingProgressDetail) {
                    return mergeFrom((FungusTrainingProgressDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusTrainingProgressDetail other) {
                if (other == FungusTrainingProgressDetail.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300EEOIMDJOHCM_.isEmpty()) {
                    if (this.unk3300EEOIMDJOHCM_.isEmpty()) {
                        this.unk3300EEOIMDJOHCM_ = other.unk3300EEOIMDJOHCM_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300EEOIMDJOHCMIsMutable();
                        this.unk3300EEOIMDJOHCM_.addAll(other.unk3300EEOIMDJOHCM_);
                    }
                    onChanged();
                }
                if (other.getCurRound() != 0) {
                    setCurRound(other.getCurRound());
                }
                if (!other.unk3300NLHEFGBEOAC_.isEmpty()) {
                    if (this.unk3300NLHEFGBEOAC_.isEmpty()) {
                        this.unk3300NLHEFGBEOAC_ = other.unk3300NLHEFGBEOAC_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300NLHEFGBEOACIsMutable();
                        this.unk3300NLHEFGBEOAC_.addAll(other.unk3300NLHEFGBEOAC_);
                    }
                    onChanged();
                }
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    if (!other.monsterPoolPreviewList_.isEmpty()) {
                        if (this.monsterPoolPreviewList_.isEmpty()) {
                            this.monsterPoolPreviewList_ = other.monsterPoolPreviewList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureMonsterPoolPreviewListIsMutable();
                            this.monsterPoolPreviewList_.addAll(other.monsterPoolPreviewList_);
                        }
                        onChanged();
                    }
                } else if (!other.monsterPoolPreviewList_.isEmpty()) {
                    if (this.monsterPoolPreviewListBuilder_.isEmpty()) {
                        this.monsterPoolPreviewListBuilder_.dispose();
                        this.monsterPoolPreviewListBuilder_ = null;
                        this.monsterPoolPreviewList_ = other.monsterPoolPreviewList_;
                        this.bitField0_ &= -5;
                        this.monsterPoolPreviewListBuilder_ = FungusTrainingProgressDetail.alwaysUseFieldBuilders ? getMonsterPoolPreviewListFieldBuilder() : null;
                    } else {
                        this.monsterPoolPreviewListBuilder_.addAllMessages(other.monsterPoolPreviewList_);
                    }
                }
                if (other.getTotalUsedTime() != 0) {
                    setTotalUsedTime(other.getTotalUsedTime());
                }
                if (this.monsterDetailListBuilder_ == null) {
                    if (!other.monsterDetailList_.isEmpty()) {
                        if (this.monsterDetailList_.isEmpty()) {
                            this.monsterDetailList_ = other.monsterDetailList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureMonsterDetailListIsMutable();
                            this.monsterDetailList_.addAll(other.monsterDetailList_);
                        }
                        onChanged();
                    }
                } else if (!other.monsterDetailList_.isEmpty()) {
                    if (this.monsterDetailListBuilder_.isEmpty()) {
                        this.monsterDetailListBuilder_.dispose();
                        this.monsterDetailListBuilder_ = null;
                        this.monsterDetailList_ = other.monsterDetailList_;
                        this.bitField0_ &= -9;
                        this.monsterDetailListBuilder_ = FungusTrainingProgressDetail.alwaysUseFieldBuilders ? getMonsterDetailListFieldBuilder() : null;
                    } else {
                        this.monsterDetailListBuilder_.addAllMessages(other.monsterDetailList_);
                    }
                }
                if (other.getDungeonId() != 0) {
                    setDungeonId(other.getDungeonId());
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
                FungusTrainingProgressDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusTrainingProgressDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusTrainingProgressDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300EEOIMDJOHCMIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300EEOIMDJOHCM_ = FungusTrainingProgressDetail.mutableCopy(this.unk3300EEOIMDJOHCM_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public List<Integer> getUnk3300EEOIMDJOHCMList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300EEOIMDJOHCM_) : this.unk3300EEOIMDJOHCM_;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getUnk3300EEOIMDJOHCMCount() {
                return this.unk3300EEOIMDJOHCM_.size();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getUnk3300EEOIMDJOHCM(int index) {
                return this.unk3300EEOIMDJOHCM_.getInt(index);
            }

            public Builder setUnk3300EEOIMDJOHCM(int index, int value) {
                ensureUnk3300EEOIMDJOHCMIsMutable();
                this.unk3300EEOIMDJOHCM_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300EEOIMDJOHCM(int value) {
                ensureUnk3300EEOIMDJOHCMIsMutable();
                this.unk3300EEOIMDJOHCM_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300EEOIMDJOHCM(Iterable<? extends Integer> values) {
                ensureUnk3300EEOIMDJOHCMIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300EEOIMDJOHCM_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300EEOIMDJOHCM() {
                this.unk3300EEOIMDJOHCM_ = FungusTrainingProgressDetail.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
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

            private void ensureUnk3300NLHEFGBEOACIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300NLHEFGBEOAC_ = FungusTrainingProgressDetail.mutableCopy(this.unk3300NLHEFGBEOAC_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public List<Integer> getUnk3300NLHEFGBEOACList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300NLHEFGBEOAC_) : this.unk3300NLHEFGBEOAC_;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getUnk3300NLHEFGBEOACCount() {
                return this.unk3300NLHEFGBEOAC_.size();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getUnk3300NLHEFGBEOAC(int index) {
                return this.unk3300NLHEFGBEOAC_.getInt(index);
            }

            public Builder setUnk3300NLHEFGBEOAC(int index, int value) {
                ensureUnk3300NLHEFGBEOACIsMutable();
                this.unk3300NLHEFGBEOAC_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300NLHEFGBEOAC(int value) {
                ensureUnk3300NLHEFGBEOACIsMutable();
                this.unk3300NLHEFGBEOAC_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300NLHEFGBEOAC(Iterable<? extends Integer> values) {
                ensureUnk3300NLHEFGBEOACIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300NLHEFGBEOAC_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300NLHEFGBEOAC() {
                this.unk3300NLHEFGBEOAC_ = FungusTrainingProgressDetail.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureMonsterPoolPreviewListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.monsterPoolPreviewList_ = new ArrayList(this.monsterPoolPreviewList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public List<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail> getMonsterPoolPreviewListList() {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    return Collections.unmodifiableList(this.monsterPoolPreviewList_);
                }
                return this.monsterPoolPreviewListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getMonsterPoolPreviewListCount() {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    return this.monsterPoolPreviewList_.size();
                }
                return this.monsterPoolPreviewListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail getMonsterPoolPreviewList(int index) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    return this.monsterPoolPreviewList_.get(index);
                }
                return this.monsterPoolPreviewListBuilder_.getMessage(index);
            }

            public Builder setMonsterPoolPreviewList(int index, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail value) {
                if (this.monsterPoolPreviewListBuilder_ != null) {
                    this.monsterPoolPreviewListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterPoolPreviewList(int index, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder builderForValue) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterPoolPreviewListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterPoolPreviewList(FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail value) {
                if (this.monsterPoolPreviewListBuilder_ != null) {
                    this.monsterPoolPreviewListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterPoolPreviewList(int index, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail value) {
                if (this.monsterPoolPreviewListBuilder_ != null) {
                    this.monsterPoolPreviewListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterPoolPreviewList(FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder builderForValue) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.monsterPoolPreviewListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterPoolPreviewList(int index, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder builderForValue) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterPoolPreviewListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMonsterPoolPreviewList(Iterable<? extends FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail> values) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    ensureMonsterPoolPreviewListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.monsterPoolPreviewList_);
                    onChanged();
                } else {
                    this.monsterPoolPreviewListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMonsterPoolPreviewList() {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    this.monsterPoolPreviewList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.monsterPoolPreviewListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMonsterPoolPreviewList(int index) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    ensureMonsterPoolPreviewListIsMutable();
                    this.monsterPoolPreviewList_.remove(index);
                    onChanged();
                } else {
                    this.monsterPoolPreviewListBuilder_.remove(index);
                }
                return this;
            }

            public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder getMonsterPoolPreviewListBuilder(int index) {
                return getMonsterPoolPreviewListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder getMonsterPoolPreviewListOrBuilder(int index) {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    return this.monsterPoolPreviewList_.get(index);
                }
                return this.monsterPoolPreviewListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public List<? extends FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder> getMonsterPoolPreviewListOrBuilderList() {
                if (this.monsterPoolPreviewListBuilder_ != null) {
                    return this.monsterPoolPreviewListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.monsterPoolPreviewList_);
            }

            public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder addMonsterPoolPreviewListBuilder() {
                return getMonsterPoolPreviewListFieldBuilder().addBuilder(FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.getDefaultInstance());
            }

            public FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder addMonsterPoolPreviewListBuilder(int index) {
                return getMonsterPoolPreviewListFieldBuilder().addBuilder(index, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.getDefaultInstance());
            }

            public List<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder> getMonsterPoolPreviewListBuilderList() {
                return getMonsterPoolPreviewListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetail.Builder, FungusTrainingPoolPreviewDetailOuterClass.FungusTrainingPoolPreviewDetailOrBuilder> getMonsterPoolPreviewListFieldBuilder() {
                if (this.monsterPoolPreviewListBuilder_ == null) {
                    this.monsterPoolPreviewListBuilder_ = new RepeatedFieldBuilderV3<>(this.monsterPoolPreviewList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.monsterPoolPreviewList_ = null;
                }
                return this.monsterPoolPreviewListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getTotalUsedTime() {
                return this.totalUsedTime_;
            }

            public Builder setTotalUsedTime(int value) {
                this.totalUsedTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalUsedTime() {
                this.totalUsedTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureMonsterDetailListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.monsterDetailList_ = new ArrayList(this.monsterDetailList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public List<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail> getMonsterDetailListList() {
                if (this.monsterDetailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.monsterDetailList_);
                }
                return this.monsterDetailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getMonsterDetailListCount() {
                if (this.monsterDetailListBuilder_ == null) {
                    return this.monsterDetailList_.size();
                }
                return this.monsterDetailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail getMonsterDetailList(int index) {
                if (this.monsterDetailListBuilder_ == null) {
                    return this.monsterDetailList_.get(index);
                }
                return this.monsterDetailListBuilder_.getMessage(index);
            }

            public Builder setMonsterDetailList(int index, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail value) {
                if (this.monsterDetailListBuilder_ != null) {
                    this.monsterDetailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMonsterDetailList(int index, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder builderForValue) {
                if (this.monsterDetailListBuilder_ == null) {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterDetailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterDetailList(FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail value) {
                if (this.monsterDetailListBuilder_ != null) {
                    this.monsterDetailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterDetailList(int index, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail value) {
                if (this.monsterDetailListBuilder_ != null) {
                    this.monsterDetailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMonsterDetailList(FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder builderForValue) {
                if (this.monsterDetailListBuilder_ == null) {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.monsterDetailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMonsterDetailList(int index, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder builderForValue) {
                if (this.monsterDetailListBuilder_ == null) {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.monsterDetailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMonsterDetailList(Iterable<? extends FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail> values) {
                if (this.monsterDetailListBuilder_ == null) {
                    ensureMonsterDetailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.monsterDetailList_);
                    onChanged();
                } else {
                    this.monsterDetailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMonsterDetailList() {
                if (this.monsterDetailListBuilder_ == null) {
                    this.monsterDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.monsterDetailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMonsterDetailList(int index) {
                if (this.monsterDetailListBuilder_ == null) {
                    ensureMonsterDetailListIsMutable();
                    this.monsterDetailList_.remove(index);
                    onChanged();
                } else {
                    this.monsterDetailListBuilder_.remove(index);
                }
                return this;
            }

            public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder getMonsterDetailListBuilder(int index) {
                return getMonsterDetailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder getMonsterDetailListOrBuilder(int index) {
                if (this.monsterDetailListBuilder_ == null) {
                    return this.monsterDetailList_.get(index);
                }
                return this.monsterDetailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public List<? extends FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder> getMonsterDetailListOrBuilderList() {
                if (this.monsterDetailListBuilder_ != null) {
                    return this.monsterDetailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.monsterDetailList_);
            }

            public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder addMonsterDetailListBuilder() {
                return getMonsterDetailListFieldBuilder().addBuilder(FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.getDefaultInstance());
            }

            public FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder addMonsterDetailListBuilder(int index) {
                return getMonsterDetailListFieldBuilder().addBuilder(index, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.getDefaultInstance());
            }

            public List<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder> getMonsterDetailListBuilderList() {
                return getMonsterDetailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetail.Builder, FungusFighterMonsterDetailOuterClass.FungusFighterMonsterDetailOrBuilder> getMonsterDetailListFieldBuilder() {
                if (this.monsterDetailListBuilder_ == null) {
                    this.monsterDetailListBuilder_ = new RepeatedFieldBuilderV3<>(this.monsterDetailList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.monsterDetailList_ = null;
                }
                return this.monsterDetailListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder
            public int getDungeonId() {
                return this.dungeonId_;
            }

            public Builder setDungeonId(int value) {
                this.dungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonId() {
                this.dungeonId_ = 0;
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

        public static FungusTrainingProgressDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusTrainingProgressDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusTrainingProgressDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusTrainingProgressDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FungusTrainingPoolPreviewDetailOuterClass.getDescriptor();
        FungusFighterMonsterDetailOuterClass.getDescriptor();
    }
}
