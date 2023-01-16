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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleReqOuterClass.class */
public final class MusicGameSettleReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018MusicGameSettleReq.proto\"Ò\u0003\n\u0012MusicGameSettleReq\u0012\u001b\n\u0013Unk3300_MLLDAPCIDDO\u0018\u000e \u0003(\r\u0012\u001c\n\u0013Unk3300_HHBCEPNLCLL\u0018ï\u0007 \u0003(\r\u0012\u001c\n\u0013Unk3300_DMLNKOLOAAH\u0018À\u000f \u0001(\b\u0012\u001b\n\u0013Unk3300_EBOJMGOCPLE\u0018R \u0001(\r\u0012\u0011\n\tmax_combo\u0018\n \u0001(\r\u0012\u0015\n\ris_save_score\u0018\u0007 \u0001(\b\u0012\u000e\n\u0005speed\u0018\u0006 \u0001(\u0002\u0012\u001b\n\u0013Unk3300_MDHEJNFHBBI\u0018\u000f \u0001(\r\u0012\r\n\u0005score\u0018\b \u0001(\r\u0012\u001c\n\u0013Unk3300_BHIGAMNDFML\u0018£\u0002 \u0001(\b\u0012\u0013\n\u000bcorrect_hit\u0018\u000b \u0001(\r\u0012\u001b\n\u0013Unk3300_HEPJNCAOEMP\u0018\u0001 \u0001(\r\u0012\r\n\u0005combo\u0018\u0004 \u0001(\r\u0012\u001c\n\u0013Unk3300_IPODKENCAOK\u0018°\u0002 \u0001(\r\u0012\u0010\n\bugc_guid\u0018\u0003 \u0001(\u0004\u0012\u001b\n\u0013Unk3300_AHAGHAHGPLD\u0018\f \u0001(\r\u0012\u0016\n\u000emusic_basic_id\u0018\u0005 \u0001(\r\u0012\u001c\n\u0013Unk3300_GJMIIDIOOMM\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MusicGameSettleReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameSettleReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameSettleReq_descriptor, new String[]{"Unk3300MLLDAPCIDDO", "Unk3300HHBCEPNLCLL", "Unk3300DMLNKOLOAAH", "Unk3300EBOJMGOCPLE", "MaxCombo", "IsSaveScore", "Speed", "Unk3300MDHEJNFHBBI", "Score", "Unk3300BHIGAMNDFML", "CorrectHit", "Unk3300HEPJNCAOEMP", "Combo", "Unk3300IPODKENCAOK", "UgcGuid", "Unk3300AHAGHAHGPLD", "MusicBasicId", "Unk3300GJMIIDIOOMM"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleReqOuterClass$MusicGameSettleReqOrBuilder.class */
    public interface MusicGameSettleReqOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300MLLDAPCIDDOList();

        int getUnk3300MLLDAPCIDDOCount();

        int getUnk3300MLLDAPCIDDO(int i);

        List<Integer> getUnk3300HHBCEPNLCLLList();

        int getUnk3300HHBCEPNLCLLCount();

        int getUnk3300HHBCEPNLCLL(int i);

        boolean getUnk3300DMLNKOLOAAH();

        int getUnk3300EBOJMGOCPLE();

        int getMaxCombo();

        boolean getIsSaveScore();

        float getSpeed();

        int getUnk3300MDHEJNFHBBI();

        int getScore();

        boolean getUnk3300BHIGAMNDFML();

        int getCorrectHit();

        int getUnk3300HEPJNCAOEMP();

        int getCombo();

        int getUnk3300IPODKENCAOK();

        long getUgcGuid();

        int getUnk3300AHAGHAHGPLD();

        int getMusicBasicId();

        int getUnk3300GJMIIDIOOMM();
    }

    private MusicGameSettleReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleReqOuterClass$MusicGameSettleReq.class */
    public static final class MusicGameSettleReq extends GeneratedMessageV3 implements MusicGameSettleReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_MLLDAPCIDDO_FIELD_NUMBER = 14;
        private Internal.IntList unk3300MLLDAPCIDDO_;
        private int unk3300MLLDAPCIDDOMemoizedSerializedSize;
        public static final int UNK3300_HHBCEPNLCLL_FIELD_NUMBER = 1007;
        private Internal.IntList unk3300HHBCEPNLCLL_;
        private int unk3300HHBCEPNLCLLMemoizedSerializedSize;
        public static final int UNK3300_DMLNKOLOAAH_FIELD_NUMBER = 1984;
        private boolean unk3300DMLNKOLOAAH_;
        public static final int UNK3300_EBOJMGOCPLE_FIELD_NUMBER = 82;
        private int unk3300EBOJMGOCPLE_;
        public static final int MAX_COMBO_FIELD_NUMBER = 10;
        private int maxCombo_;
        public static final int IS_SAVE_SCORE_FIELD_NUMBER = 7;
        private boolean isSaveScore_;
        public static final int SPEED_FIELD_NUMBER = 790;
        private float speed_;
        public static final int UNK3300_MDHEJNFHBBI_FIELD_NUMBER = 15;
        private int unk3300MDHEJNFHBBI_;
        public static final int SCORE_FIELD_NUMBER = 8;
        private int score_;
        public static final int UNK3300_BHIGAMNDFML_FIELD_NUMBER = 291;
        private boolean unk3300BHIGAMNDFML_;
        public static final int CORRECT_HIT_FIELD_NUMBER = 11;
        private int correctHit_;
        public static final int UNK3300_HEPJNCAOEMP_FIELD_NUMBER = 1;
        private int unk3300HEPJNCAOEMP_;
        public static final int COMBO_FIELD_NUMBER = 4;
        private int combo_;
        public static final int UNK3300_IPODKENCAOK_FIELD_NUMBER = 304;
        private int unk3300IPODKENCAOK_;
        public static final int UGC_GUID_FIELD_NUMBER = 3;
        private long ugcGuid_;
        public static final int UNK3300_AHAGHAHGPLD_FIELD_NUMBER = 12;
        private int unk3300AHAGHAHGPLD_;
        public static final int MUSIC_BASIC_ID_FIELD_NUMBER = 5;
        private int musicBasicId_;
        public static final int UNK3300_GJMIIDIOOMM_FIELD_NUMBER = 1951;
        private int unk3300GJMIIDIOOMM_;
        private byte memoizedIsInitialized;
        private static final MusicGameSettleReq DEFAULT_INSTANCE = new MusicGameSettleReq();
        private static final Parser<MusicGameSettleReq> PARSER = new AbstractParser<MusicGameSettleReq>() { // from class: emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReq.1
            @Override // com.google.protobuf.Parser
            public MusicGameSettleReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameSettleReq(input, extensionRegistry);
            }
        };

        private MusicGameSettleReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300MLLDAPCIDDOMemoizedSerializedSize = -1;
            this.unk3300HHBCEPNLCLLMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MusicGameSettleReq() {
            this.unk3300MLLDAPCIDDOMemoizedSerializedSize = -1;
            this.unk3300HHBCEPNLCLLMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300MLLDAPCIDDO_ = emptyIntList();
            this.unk3300HHBCEPNLCLL_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameSettleReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x026c */
        private MusicGameSettleReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300HEPJNCAOEMP_ = input.readUInt32();
                                break;
                            case 24:
                                this.ugcGuid_ = input.readUInt64();
                                break;
                            case 32:
                                this.combo_ = input.readUInt32();
                                break;
                            case 40:
                                this.musicBasicId_ = input.readUInt32();
                                break;
                            case 56:
                                this.isSaveScore_ = input.readBool();
                                break;
                            case 64:
                                this.score_ = input.readUInt32();
                                break;
                            case 80:
                                this.maxCombo_ = input.readUInt32();
                                break;
                            case 88:
                                this.correctHit_ = input.readUInt32();
                                break;
                            case 96:
                                this.unk3300AHAGHAHGPLD_ = input.readUInt32();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300MLLDAPCIDDO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300MLLDAPCIDDO_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300MLLDAPCIDDO_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300MLLDAPCIDDO_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
                                this.unk3300MDHEJNFHBBI_ = input.readUInt32();
                                break;
                            case 656:
                                this.unk3300EBOJMGOCPLE_ = input.readUInt32();
                                break;
                            case 2328:
                                this.unk3300BHIGAMNDFML_ = input.readBool();
                                break;
                            case 2432:
                                this.unk3300IPODKENCAOK_ = input.readUInt32();
                                break;
                            case 6325:
                                this.speed_ = input.readFloat();
                                break;
                            case 8056:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300HHBCEPNLCLL_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300HHBCEPNLCLL_.addInt(input.readUInt32());
                                break;
                            case 8058:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300HHBCEPNLCLL_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300HHBCEPNLCLL_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 15608:
                                this.unk3300GJMIIDIOOMM_ = input.readUInt32();
                                break;
                            case 15872:
                                this.unk3300DMLNKOLOAAH_ = input.readBool();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300MLLDAPCIDDO_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300HHBCEPNLCLL_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicGameSettleReqOuterClass.internal_static_MusicGameSettleReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameSettleReqOuterClass.internal_static_MusicGameSettleReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSettleReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public List<Integer> getUnk3300MLLDAPCIDDOList() {
            return this.unk3300MLLDAPCIDDO_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300MLLDAPCIDDOCount() {
            return this.unk3300MLLDAPCIDDO_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300MLLDAPCIDDO(int index) {
            return this.unk3300MLLDAPCIDDO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public List<Integer> getUnk3300HHBCEPNLCLLList() {
            return this.unk3300HHBCEPNLCLL_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300HHBCEPNLCLLCount() {
            return this.unk3300HHBCEPNLCLL_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300HHBCEPNLCLL(int index) {
            return this.unk3300HHBCEPNLCLL_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public boolean getUnk3300DMLNKOLOAAH() {
            return this.unk3300DMLNKOLOAAH_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300EBOJMGOCPLE() {
            return this.unk3300EBOJMGOCPLE_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getMaxCombo() {
            return this.maxCombo_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public boolean getIsSaveScore() {
            return this.isSaveScore_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public float getSpeed() {
            return this.speed_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300MDHEJNFHBBI() {
            return this.unk3300MDHEJNFHBBI_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public boolean getUnk3300BHIGAMNDFML() {
            return this.unk3300BHIGAMNDFML_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getCorrectHit() {
            return this.correctHit_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300HEPJNCAOEMP() {
            return this.unk3300HEPJNCAOEMP_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getCombo() {
            return this.combo_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300IPODKENCAOK() {
            return this.unk3300IPODKENCAOK_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300AHAGHAHGPLD() {
            return this.unk3300AHAGHAHGPLD_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getMusicBasicId() {
            return this.musicBasicId_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
        public int getUnk3300GJMIIDIOOMM() {
            return this.unk3300GJMIIDIOOMM_;
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
            if (this.unk3300HEPJNCAOEMP_ != 0) {
                output.writeUInt32(1, this.unk3300HEPJNCAOEMP_);
            }
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(3, this.ugcGuid_);
            }
            if (this.combo_ != 0) {
                output.writeUInt32(4, this.combo_);
            }
            if (this.musicBasicId_ != 0) {
                output.writeUInt32(5, this.musicBasicId_);
            }
            if (this.isSaveScore_) {
                output.writeBool(7, this.isSaveScore_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(8, this.score_);
            }
            if (this.maxCombo_ != 0) {
                output.writeUInt32(10, this.maxCombo_);
            }
            if (this.correctHit_ != 0) {
                output.writeUInt32(11, this.correctHit_);
            }
            if (this.unk3300AHAGHAHGPLD_ != 0) {
                output.writeUInt32(12, this.unk3300AHAGHAHGPLD_);
            }
            if (getUnk3300MLLDAPCIDDOList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.unk3300MLLDAPCIDDOMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300MLLDAPCIDDO_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300MLLDAPCIDDO_.getInt(i));
            }
            if (this.unk3300MDHEJNFHBBI_ != 0) {
                output.writeUInt32(15, this.unk3300MDHEJNFHBBI_);
            }
            if (this.unk3300EBOJMGOCPLE_ != 0) {
                output.writeUInt32(82, this.unk3300EBOJMGOCPLE_);
            }
            if (this.unk3300BHIGAMNDFML_) {
                output.writeBool(291, this.unk3300BHIGAMNDFML_);
            }
            if (this.unk3300IPODKENCAOK_ != 0) {
                output.writeUInt32(304, this.unk3300IPODKENCAOK_);
            }
            if (this.speed_ != 0.0f) {
                output.writeFloat(SPEED_FIELD_NUMBER, this.speed_);
            }
            if (getUnk3300HHBCEPNLCLLList().size() > 0) {
                output.writeUInt32NoTag(8058);
                output.writeUInt32NoTag(this.unk3300HHBCEPNLCLLMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300HHBCEPNLCLL_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300HHBCEPNLCLL_.getInt(i2));
            }
            if (this.unk3300GJMIIDIOOMM_ != 0) {
                output.writeUInt32(1951, this.unk3300GJMIIDIOOMM_);
            }
            if (this.unk3300DMLNKOLOAAH_) {
                output.writeBool(1984, this.unk3300DMLNKOLOAAH_);
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
            if (this.unk3300HEPJNCAOEMP_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300HEPJNCAOEMP_);
            }
            if (this.ugcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.ugcGuid_);
            }
            if (this.combo_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.combo_);
            }
            if (this.musicBasicId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.musicBasicId_);
            }
            if (this.isSaveScore_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isSaveScore_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.score_);
            }
            if (this.maxCombo_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.maxCombo_);
            }
            if (this.correctHit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.correctHit_);
            }
            if (this.unk3300AHAGHAHGPLD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300AHAGHAHGPLD_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300MLLDAPCIDDO_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300MLLDAPCIDDO_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300MLLDAPCIDDOList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300MLLDAPCIDDOMemoizedSerializedSize = dataSize;
            if (this.unk3300MDHEJNFHBBI_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.unk3300MDHEJNFHBBI_);
            }
            if (this.unk3300EBOJMGOCPLE_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(82, this.unk3300EBOJMGOCPLE_);
            }
            if (this.unk3300BHIGAMNDFML_) {
                size3 += CodedOutputStream.computeBoolSize(291, this.unk3300BHIGAMNDFML_);
            }
            if (this.unk3300IPODKENCAOK_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(304, this.unk3300IPODKENCAOK_);
            }
            if (this.speed_ != 0.0f) {
                size3 += CodedOutputStream.computeFloatSize(SPEED_FIELD_NUMBER, this.speed_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300HHBCEPNLCLL_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300HHBCEPNLCLL_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300HHBCEPNLCLLList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300HHBCEPNLCLLMemoizedSerializedSize = dataSize2;
            if (this.unk3300GJMIIDIOOMM_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(1951, this.unk3300GJMIIDIOOMM_);
            }
            if (this.unk3300DMLNKOLOAAH_) {
                size4 += CodedOutputStream.computeBoolSize(1984, this.unk3300DMLNKOLOAAH_);
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MusicGameSettleReq)) {
                return equals(obj);
            }
            MusicGameSettleReq other = (MusicGameSettleReq) obj;
            return getUnk3300MLLDAPCIDDOList().equals(other.getUnk3300MLLDAPCIDDOList()) && getUnk3300HHBCEPNLCLLList().equals(other.getUnk3300HHBCEPNLCLLList()) && getUnk3300DMLNKOLOAAH() == other.getUnk3300DMLNKOLOAAH() && getUnk3300EBOJMGOCPLE() == other.getUnk3300EBOJMGOCPLE() && getMaxCombo() == other.getMaxCombo() && getIsSaveScore() == other.getIsSaveScore() && Float.floatToIntBits(getSpeed()) == Float.floatToIntBits(other.getSpeed()) && getUnk3300MDHEJNFHBBI() == other.getUnk3300MDHEJNFHBBI() && getScore() == other.getScore() && getUnk3300BHIGAMNDFML() == other.getUnk3300BHIGAMNDFML() && getCorrectHit() == other.getCorrectHit() && getUnk3300HEPJNCAOEMP() == other.getUnk3300HEPJNCAOEMP() && getCombo() == other.getCombo() && getUnk3300IPODKENCAOK() == other.getUnk3300IPODKENCAOK() && getUgcGuid() == other.getUgcGuid() && getUnk3300AHAGHAHGPLD() == other.getUnk3300AHAGHAHGPLD() && getMusicBasicId() == other.getMusicBasicId() && getUnk3300GJMIIDIOOMM() == other.getUnk3300GJMIIDIOOMM() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300MLLDAPCIDDOCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getUnk3300MLLDAPCIDDOList().hashCode();
            }
            if (getUnk3300HHBCEPNLCLLCount() > 0) {
                hash = (53 * ((37 * hash) + 1007)) + getUnk3300HHBCEPNLCLLList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 1984)) + Internal.hashBoolean(getUnk3300DMLNKOLOAAH()))) + 82)) + getUnk3300EBOJMGOCPLE())) + 10)) + getMaxCombo())) + 7)) + Internal.hashBoolean(getIsSaveScore()))) + SPEED_FIELD_NUMBER)) + Float.floatToIntBits(getSpeed()))) + 15)) + getUnk3300MDHEJNFHBBI())) + 8)) + getScore())) + 291)) + Internal.hashBoolean(getUnk3300BHIGAMNDFML()))) + 11)) + getCorrectHit())) + 1)) + getUnk3300HEPJNCAOEMP())) + 4)) + getCombo())) + 304)) + getUnk3300IPODKENCAOK())) + 3)) + Internal.hashLong(getUgcGuid()))) + 12)) + getUnk3300AHAGHAHGPLD())) + 5)) + getMusicBasicId())) + 1951)) + getUnk3300GJMIIDIOOMM())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicGameSettleReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSettleReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSettleReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSettleReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSettleReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameSettleReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameSettleReq parseFrom(InputStream input) throws IOException {
            return (MusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSettleReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSettleReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameSettleReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameSettleReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSettleReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameSettleReq parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameSettleReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameSettleReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameSettleReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameSettleReqOuterClass$MusicGameSettleReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameSettleReqOrBuilder {
            private int bitField0_;
            private Internal.IntList unk3300MLLDAPCIDDO_ = MusicGameSettleReq.emptyIntList();
            private Internal.IntList unk3300HHBCEPNLCLL_ = MusicGameSettleReq.emptyIntList();
            private boolean unk3300DMLNKOLOAAH_;
            private int unk3300EBOJMGOCPLE_;
            private int maxCombo_;
            private boolean isSaveScore_;
            private float speed_;
            private int unk3300MDHEJNFHBBI_;
            private int score_;
            private boolean unk3300BHIGAMNDFML_;
            private int correctHit_;
            private int unk3300HEPJNCAOEMP_;
            private int combo_;
            private int unk3300IPODKENCAOK_;
            private long ugcGuid_;
            private int unk3300AHAGHAHGPLD_;
            private int musicBasicId_;
            private int unk3300GJMIIDIOOMM_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameSettleReqOuterClass.internal_static_MusicGameSettleReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameSettleReqOuterClass.internal_static_MusicGameSettleReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameSettleReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameSettleReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300MLLDAPCIDDO_ = MusicGameSettleReq.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300HHBCEPNLCLL_ = MusicGameSettleReq.emptyIntList();
                this.bitField0_ &= -3;
                this.unk3300DMLNKOLOAAH_ = false;
                this.unk3300EBOJMGOCPLE_ = 0;
                this.maxCombo_ = 0;
                this.isSaveScore_ = false;
                this.speed_ = 0.0f;
                this.unk3300MDHEJNFHBBI_ = 0;
                this.score_ = 0;
                this.unk3300BHIGAMNDFML_ = false;
                this.correctHit_ = 0;
                this.unk3300HEPJNCAOEMP_ = 0;
                this.combo_ = 0;
                this.unk3300IPODKENCAOK_ = 0;
                this.ugcGuid_ = 0;
                this.unk3300AHAGHAHGPLD_ = 0;
                this.musicBasicId_ = 0;
                this.unk3300GJMIIDIOOMM_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameSettleReqOuterClass.internal_static_MusicGameSettleReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameSettleReq getDefaultInstanceForType() {
                return MusicGameSettleReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSettleReq build() {
                MusicGameSettleReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameSettleReq buildPartial() {
                MusicGameSettleReq result = new MusicGameSettleReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300MLLDAPCIDDO_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300MLLDAPCIDDO_ = this.unk3300MLLDAPCIDDO_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300HHBCEPNLCLL_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300HHBCEPNLCLL_ = this.unk3300HHBCEPNLCLL_;
                result.unk3300DMLNKOLOAAH_ = this.unk3300DMLNKOLOAAH_;
                result.unk3300EBOJMGOCPLE_ = this.unk3300EBOJMGOCPLE_;
                result.maxCombo_ = this.maxCombo_;
                result.isSaveScore_ = this.isSaveScore_;
                result.speed_ = this.speed_;
                result.unk3300MDHEJNFHBBI_ = this.unk3300MDHEJNFHBBI_;
                result.score_ = this.score_;
                result.unk3300BHIGAMNDFML_ = this.unk3300BHIGAMNDFML_;
                result.correctHit_ = this.correctHit_;
                result.unk3300HEPJNCAOEMP_ = this.unk3300HEPJNCAOEMP_;
                result.combo_ = this.combo_;
                result.unk3300IPODKENCAOK_ = this.unk3300IPODKENCAOK_;
                result.ugcGuid_ = this.ugcGuid_;
                result.unk3300AHAGHAHGPLD_ = this.unk3300AHAGHAHGPLD_;
                result.musicBasicId_ = this.musicBasicId_;
                result.unk3300GJMIIDIOOMM_ = this.unk3300GJMIIDIOOMM_;
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
                if (other instanceof MusicGameSettleReq) {
                    return mergeFrom((MusicGameSettleReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameSettleReq other) {
                if (other == MusicGameSettleReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300MLLDAPCIDDO_.isEmpty()) {
                    if (this.unk3300MLLDAPCIDDO_.isEmpty()) {
                        this.unk3300MLLDAPCIDDO_ = other.unk3300MLLDAPCIDDO_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300MLLDAPCIDDOIsMutable();
                        this.unk3300MLLDAPCIDDO_.addAll(other.unk3300MLLDAPCIDDO_);
                    }
                    onChanged();
                }
                if (!other.unk3300HHBCEPNLCLL_.isEmpty()) {
                    if (this.unk3300HHBCEPNLCLL_.isEmpty()) {
                        this.unk3300HHBCEPNLCLL_ = other.unk3300HHBCEPNLCLL_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300HHBCEPNLCLLIsMutable();
                        this.unk3300HHBCEPNLCLL_.addAll(other.unk3300HHBCEPNLCLL_);
                    }
                    onChanged();
                }
                if (other.getUnk3300DMLNKOLOAAH()) {
                    setUnk3300DMLNKOLOAAH(other.getUnk3300DMLNKOLOAAH());
                }
                if (other.getUnk3300EBOJMGOCPLE() != 0) {
                    setUnk3300EBOJMGOCPLE(other.getUnk3300EBOJMGOCPLE());
                }
                if (other.getMaxCombo() != 0) {
                    setMaxCombo(other.getMaxCombo());
                }
                if (other.getIsSaveScore()) {
                    setIsSaveScore(other.getIsSaveScore());
                }
                if (other.getSpeed() != 0.0f) {
                    setSpeed(other.getSpeed());
                }
                if (other.getUnk3300MDHEJNFHBBI() != 0) {
                    setUnk3300MDHEJNFHBBI(other.getUnk3300MDHEJNFHBBI());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (other.getUnk3300BHIGAMNDFML()) {
                    setUnk3300BHIGAMNDFML(other.getUnk3300BHIGAMNDFML());
                }
                if (other.getCorrectHit() != 0) {
                    setCorrectHit(other.getCorrectHit());
                }
                if (other.getUnk3300HEPJNCAOEMP() != 0) {
                    setUnk3300HEPJNCAOEMP(other.getUnk3300HEPJNCAOEMP());
                }
                if (other.getCombo() != 0) {
                    setCombo(other.getCombo());
                }
                if (other.getUnk3300IPODKENCAOK() != 0) {
                    setUnk3300IPODKENCAOK(other.getUnk3300IPODKENCAOK());
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                if (other.getUnk3300AHAGHAHGPLD() != 0) {
                    setUnk3300AHAGHAHGPLD(other.getUnk3300AHAGHAHGPLD());
                }
                if (other.getMusicBasicId() != 0) {
                    setMusicBasicId(other.getMusicBasicId());
                }
                if (other.getUnk3300GJMIIDIOOMM() != 0) {
                    setUnk3300GJMIIDIOOMM(other.getUnk3300GJMIIDIOOMM());
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
                MusicGameSettleReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameSettleReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameSettleReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300MLLDAPCIDDOIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300MLLDAPCIDDO_ = MusicGameSettleReq.mutableCopy(this.unk3300MLLDAPCIDDO_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public List<Integer> getUnk3300MLLDAPCIDDOList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300MLLDAPCIDDO_) : this.unk3300MLLDAPCIDDO_;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300MLLDAPCIDDOCount() {
                return this.unk3300MLLDAPCIDDO_.size();
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300MLLDAPCIDDO(int index) {
                return this.unk3300MLLDAPCIDDO_.getInt(index);
            }

            public Builder setUnk3300MLLDAPCIDDO(int index, int value) {
                ensureUnk3300MLLDAPCIDDOIsMutable();
                this.unk3300MLLDAPCIDDO_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300MLLDAPCIDDO(int value) {
                ensureUnk3300MLLDAPCIDDOIsMutable();
                this.unk3300MLLDAPCIDDO_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300MLLDAPCIDDO(Iterable<? extends Integer> values) {
                ensureUnk3300MLLDAPCIDDOIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300MLLDAPCIDDO_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300MLLDAPCIDDO() {
                this.unk3300MLLDAPCIDDO_ = MusicGameSettleReq.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk3300HHBCEPNLCLLIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300HHBCEPNLCLL_ = MusicGameSettleReq.mutableCopy(this.unk3300HHBCEPNLCLL_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public List<Integer> getUnk3300HHBCEPNLCLLList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300HHBCEPNLCLL_) : this.unk3300HHBCEPNLCLL_;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300HHBCEPNLCLLCount() {
                return this.unk3300HHBCEPNLCLL_.size();
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300HHBCEPNLCLL(int index) {
                return this.unk3300HHBCEPNLCLL_.getInt(index);
            }

            public Builder setUnk3300HHBCEPNLCLL(int index, int value) {
                ensureUnk3300HHBCEPNLCLLIsMutable();
                this.unk3300HHBCEPNLCLL_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300HHBCEPNLCLL(int value) {
                ensureUnk3300HHBCEPNLCLLIsMutable();
                this.unk3300HHBCEPNLCLL_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300HHBCEPNLCLL(Iterable<? extends Integer> values) {
                ensureUnk3300HHBCEPNLCLLIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300HHBCEPNLCLL_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300HHBCEPNLCLL() {
                this.unk3300HHBCEPNLCLL_ = MusicGameSettleReq.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public boolean getUnk3300DMLNKOLOAAH() {
                return this.unk3300DMLNKOLOAAH_;
            }

            public Builder setUnk3300DMLNKOLOAAH(boolean value) {
                this.unk3300DMLNKOLOAAH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DMLNKOLOAAH() {
                this.unk3300DMLNKOLOAAH_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300EBOJMGOCPLE() {
                return this.unk3300EBOJMGOCPLE_;
            }

            public Builder setUnk3300EBOJMGOCPLE(int value) {
                this.unk3300EBOJMGOCPLE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EBOJMGOCPLE() {
                this.unk3300EBOJMGOCPLE_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getMaxCombo() {
                return this.maxCombo_;
            }

            public Builder setMaxCombo(int value) {
                this.maxCombo_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxCombo() {
                this.maxCombo_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public boolean getIsSaveScore() {
                return this.isSaveScore_;
            }

            public Builder setIsSaveScore(boolean value) {
                this.isSaveScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSaveScore() {
                this.isSaveScore_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public float getSpeed() {
                return this.speed_;
            }

            public Builder setSpeed(float value) {
                this.speed_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpeed() {
                this.speed_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300MDHEJNFHBBI() {
                return this.unk3300MDHEJNFHBBI_;
            }

            public Builder setUnk3300MDHEJNFHBBI(int value) {
                this.unk3300MDHEJNFHBBI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MDHEJNFHBBI() {
                this.unk3300MDHEJNFHBBI_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public boolean getUnk3300BHIGAMNDFML() {
                return this.unk3300BHIGAMNDFML_;
            }

            public Builder setUnk3300BHIGAMNDFML(boolean value) {
                this.unk3300BHIGAMNDFML_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BHIGAMNDFML() {
                this.unk3300BHIGAMNDFML_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getCorrectHit() {
                return this.correctHit_;
            }

            public Builder setCorrectHit(int value) {
                this.correctHit_ = value;
                onChanged();
                return this;
            }

            public Builder clearCorrectHit() {
                this.correctHit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300HEPJNCAOEMP() {
                return this.unk3300HEPJNCAOEMP_;
            }

            public Builder setUnk3300HEPJNCAOEMP(int value) {
                this.unk3300HEPJNCAOEMP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HEPJNCAOEMP() {
                this.unk3300HEPJNCAOEMP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getCombo() {
                return this.combo_;
            }

            public Builder setCombo(int value) {
                this.combo_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombo() {
                this.combo_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300IPODKENCAOK() {
                return this.unk3300IPODKENCAOK_;
            }

            public Builder setUnk3300IPODKENCAOK(int value) {
                this.unk3300IPODKENCAOK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IPODKENCAOK() {
                this.unk3300IPODKENCAOK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public long getUgcGuid() {
                return this.ugcGuid_;
            }

            public Builder setUgcGuid(long value) {
                this.ugcGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUgcGuid() {
                this.ugcGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300AHAGHAHGPLD() {
                return this.unk3300AHAGHAHGPLD_;
            }

            public Builder setUnk3300AHAGHAHGPLD(int value) {
                this.unk3300AHAGHAHGPLD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AHAGHAHGPLD() {
                this.unk3300AHAGHAHGPLD_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getMusicBasicId() {
                return this.musicBasicId_;
            }

            public Builder setMusicBasicId(int value) {
                this.musicBasicId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicBasicId() {
                this.musicBasicId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameSettleReqOuterClass.MusicGameSettleReqOrBuilder
            public int getUnk3300GJMIIDIOOMM() {
                return this.unk3300GJMIIDIOOMM_;
            }

            public Builder setUnk3300GJMIIDIOOMM(int value) {
                this.unk3300GJMIIDIOOMM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GJMIIDIOOMM() {
                this.unk3300GJMIIDIOOMM_ = 0;
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

        public static MusicGameSettleReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameSettleReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameSettleReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameSettleReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
