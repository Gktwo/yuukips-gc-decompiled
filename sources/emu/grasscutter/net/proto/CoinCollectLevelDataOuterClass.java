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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.CoinCollectTeamInfoDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectLevelDataOuterClass.class */
public final class CoinCollectLevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aCoinCollectLevelData.proto\u001a\u001dCoinCollectTeamInfoData.proto\"\u0003\n\u0014CoinCollectLevelData\u0012\u0015\n\ris_level_open\u0018\u0006 \u0001(\b\u0012\u001b\n\u0013Unk3300_GNFGEFHKHEF\u0018\u000e \u0001(\r\u0012\u0010\n\blevel_id\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_ONPKNIAHPHM\u0018\u0004 \u0001(\r\u0012\u001b\n\u0013Unk3300_GDKMJJNFIPP\u0018\r \u0001(\b\u00127\n\u0015single_best_team_info\u0018\b \u0001(\u000b2\u0018.CoinCollectTeamInfoData\u0012\u001b\n\u0013Unk3300_HINHOCILNJC\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_ALILGJBDOMD\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013Unk3300_OLNMJJHJAGK\u0018\n \u0001(\b\u0012\u001b\n\u0013Unk3300_LOPHGLMNDCP\u0018\u000b \u0001(\r\u0012<\n\u001adouble_best_team_info_list\u0018\u0002 \u0003(\u000b2\u0018.CoinCollectTeamInfoData\u0012\u001b\n\u0013Unk3300_JDBOOHBJFCP\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CoinCollectTeamInfoDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CoinCollectLevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CoinCollectLevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CoinCollectLevelData_descriptor, new String[]{"IsLevelOpen", "Unk3300GNFGEFHKHEF", "LevelId", "Unk3300ONPKNIAHPHM", "Unk3300GDKMJJNFIPP", "SingleBestTeamInfo", "Unk3300HINHOCILNJC", "Unk3300ALILGJBDOMD", "Unk3300OLNMJJHJAGK", "Unk3300LOPHGLMNDCP", "DoubleBestTeamInfoList", "Unk3300JDBOOHBJFCP"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectLevelDataOuterClass$CoinCollectLevelDataOrBuilder.class */
    public interface CoinCollectLevelDataOrBuilder extends MessageOrBuilder {
        boolean getIsLevelOpen();

        int getUnk3300GNFGEFHKHEF();

        int getLevelId();

        int getUnk3300ONPKNIAHPHM();

        boolean getUnk3300GDKMJJNFIPP();

        boolean hasSingleBestTeamInfo();

        CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData getSingleBestTeamInfo();

        CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder getSingleBestTeamInfoOrBuilder();

        int getUnk3300HINHOCILNJC();

        int getUnk3300ALILGJBDOMD();

        boolean getUnk3300OLNMJJHJAGK();

        int getUnk3300LOPHGLMNDCP();

        List<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData> getDoubleBestTeamInfoListList();

        CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData getDoubleBestTeamInfoList(int i);

        int getDoubleBestTeamInfoListCount();

        List<? extends CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> getDoubleBestTeamInfoListOrBuilderList();

        CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder getDoubleBestTeamInfoListOrBuilder(int i);

        boolean getUnk3300JDBOOHBJFCP();
    }

    private CoinCollectLevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectLevelDataOuterClass$CoinCollectLevelData.class */
    public static final class CoinCollectLevelData extends GeneratedMessageV3 implements CoinCollectLevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_LEVEL_OPEN_FIELD_NUMBER = 6;
        private boolean isLevelOpen_;
        public static final int UNK3300_GNFGEFHKHEF_FIELD_NUMBER = 14;
        private int unk3300GNFGEFHKHEF_;
        public static final int LEVEL_ID_FIELD_NUMBER = 7;
        private int levelId_;
        public static final int UNK3300_ONPKNIAHPHM_FIELD_NUMBER = 4;
        private int unk3300ONPKNIAHPHM_;
        public static final int UNK3300_GDKMJJNFIPP_FIELD_NUMBER = 13;
        private boolean unk3300GDKMJJNFIPP_;
        public static final int SINGLE_BEST_TEAM_INFO_FIELD_NUMBER = 8;
        private CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData singleBestTeamInfo_;
        public static final int UNK3300_HINHOCILNJC_FIELD_NUMBER = 1;
        private int unk3300HINHOCILNJC_;
        public static final int UNK3300_ALILGJBDOMD_FIELD_NUMBER = 3;
        private int unk3300ALILGJBDOMD_;
        public static final int UNK3300_OLNMJJHJAGK_FIELD_NUMBER = 10;
        private boolean unk3300OLNMJJHJAGK_;
        public static final int UNK3300_LOPHGLMNDCP_FIELD_NUMBER = 11;
        private int unk3300LOPHGLMNDCP_;
        public static final int DOUBLE_BEST_TEAM_INFO_LIST_FIELD_NUMBER = 2;
        private List<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData> doubleBestTeamInfoList_;
        public static final int UNK3300_JDBOOHBJFCP_FIELD_NUMBER = 9;
        private boolean unk3300JDBOOHBJFCP_;
        private byte memoizedIsInitialized;
        private static final CoinCollectLevelData DEFAULT_INSTANCE = new CoinCollectLevelData();
        private static final Parser<CoinCollectLevelData> PARSER = new AbstractParser<CoinCollectLevelData>() { // from class: emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelData.1
            @Override // com.google.protobuf.Parser
            public CoinCollectLevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CoinCollectLevelData(input, extensionRegistry);
            }
        };

        private CoinCollectLevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CoinCollectLevelData() {
            this.memoizedIsInitialized = -1;
            this.doubleBestTeamInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CoinCollectLevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CoinCollectLevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.unk3300HINHOCILNJC_ = input.readUInt32();
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.doubleBestTeamInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.doubleBestTeamInfoList_.add((CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData) input.readMessage(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.parser(), extensionRegistry));
                                    break;
                                case 24:
                                    this.unk3300ALILGJBDOMD_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.unk3300ONPKNIAHPHM_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.isLevelOpen_ = input.readBool();
                                    break;
                                case 56:
                                    this.levelId_ = input.readUInt32();
                                    break;
                                case 66:
                                    CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder subBuilder = this.singleBestTeamInfo_ != null ? this.singleBestTeamInfo_.toBuilder() : null;
                                    this.singleBestTeamInfo_ = (CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData) input.readMessage(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.singleBestTeamInfo_);
                                        this.singleBestTeamInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 72:
                                    this.unk3300JDBOOHBJFCP_ = input.readBool();
                                    break;
                                case 80:
                                    this.unk3300OLNMJJHJAGK_ = input.readBool();
                                    break;
                                case 88:
                                    this.unk3300LOPHGLMNDCP_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.unk3300GDKMJJNFIPP_ = input.readBool();
                                    break;
                                case 112:
                                    this.unk3300GNFGEFHKHEF_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.doubleBestTeamInfoList_ = Collections.unmodifiableList(this.doubleBestTeamInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CoinCollectLevelDataOuterClass.internal_static_CoinCollectLevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CoinCollectLevelDataOuterClass.internal_static_CoinCollectLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectLevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public boolean getIsLevelOpen() {
            return this.isLevelOpen_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getUnk3300GNFGEFHKHEF() {
            return this.unk3300GNFGEFHKHEF_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getUnk3300ONPKNIAHPHM() {
            return this.unk3300ONPKNIAHPHM_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public boolean getUnk3300GDKMJJNFIPP() {
            return this.unk3300GDKMJJNFIPP_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public boolean hasSingleBestTeamInfo() {
            return this.singleBestTeamInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData getSingleBestTeamInfo() {
            return this.singleBestTeamInfo_ == null ? CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.getDefaultInstance() : this.singleBestTeamInfo_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder getSingleBestTeamInfoOrBuilder() {
            return getSingleBestTeamInfo();
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getUnk3300HINHOCILNJC() {
            return this.unk3300HINHOCILNJC_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getUnk3300ALILGJBDOMD() {
            return this.unk3300ALILGJBDOMD_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public boolean getUnk3300OLNMJJHJAGK() {
            return this.unk3300OLNMJJHJAGK_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getUnk3300LOPHGLMNDCP() {
            return this.unk3300LOPHGLMNDCP_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public List<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData> getDoubleBestTeamInfoListList() {
            return this.doubleBestTeamInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public List<? extends CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> getDoubleBestTeamInfoListOrBuilderList() {
            return this.doubleBestTeamInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public int getDoubleBestTeamInfoListCount() {
            return this.doubleBestTeamInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData getDoubleBestTeamInfoList(int index) {
            return this.doubleBestTeamInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder getDoubleBestTeamInfoListOrBuilder(int index) {
            return this.doubleBestTeamInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
        public boolean getUnk3300JDBOOHBJFCP() {
            return this.unk3300JDBOOHBJFCP_;
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
            if (this.unk3300HINHOCILNJC_ != 0) {
                output.writeUInt32(1, this.unk3300HINHOCILNJC_);
            }
            for (int i = 0; i < this.doubleBestTeamInfoList_.size(); i++) {
                output.writeMessage(2, this.doubleBestTeamInfoList_.get(i));
            }
            if (this.unk3300ALILGJBDOMD_ != 0) {
                output.writeUInt32(3, this.unk3300ALILGJBDOMD_);
            }
            if (this.unk3300ONPKNIAHPHM_ != 0) {
                output.writeUInt32(4, this.unk3300ONPKNIAHPHM_);
            }
            if (this.isLevelOpen_) {
                output.writeBool(6, this.isLevelOpen_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(7, this.levelId_);
            }
            if (this.singleBestTeamInfo_ != null) {
                output.writeMessage(8, getSingleBestTeamInfo());
            }
            if (this.unk3300JDBOOHBJFCP_) {
                output.writeBool(9, this.unk3300JDBOOHBJFCP_);
            }
            if (this.unk3300OLNMJJHJAGK_) {
                output.writeBool(10, this.unk3300OLNMJJHJAGK_);
            }
            if (this.unk3300LOPHGLMNDCP_ != 0) {
                output.writeUInt32(11, this.unk3300LOPHGLMNDCP_);
            }
            if (this.unk3300GDKMJJNFIPP_) {
                output.writeBool(13, this.unk3300GDKMJJNFIPP_);
            }
            if (this.unk3300GNFGEFHKHEF_ != 0) {
                output.writeUInt32(14, this.unk3300GNFGEFHKHEF_);
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
            if (this.unk3300HINHOCILNJC_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300HINHOCILNJC_);
            }
            for (int i = 0; i < this.doubleBestTeamInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.doubleBestTeamInfoList_.get(i));
            }
            if (this.unk3300ALILGJBDOMD_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unk3300ALILGJBDOMD_);
            }
            if (this.unk3300ONPKNIAHPHM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.unk3300ONPKNIAHPHM_);
            }
            if (this.isLevelOpen_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isLevelOpen_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.levelId_);
            }
            if (this.singleBestTeamInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getSingleBestTeamInfo());
            }
            if (this.unk3300JDBOOHBJFCP_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.unk3300JDBOOHBJFCP_);
            }
            if (this.unk3300OLNMJJHJAGK_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.unk3300OLNMJJHJAGK_);
            }
            if (this.unk3300LOPHGLMNDCP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.unk3300LOPHGLMNDCP_);
            }
            if (this.unk3300GDKMJJNFIPP_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.unk3300GDKMJJNFIPP_);
            }
            if (this.unk3300GNFGEFHKHEF_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300GNFGEFHKHEF_);
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
            if (!(obj instanceof CoinCollectLevelData)) {
                return equals(obj);
            }
            CoinCollectLevelData other = (CoinCollectLevelData) obj;
            if (getIsLevelOpen() == other.getIsLevelOpen() && getUnk3300GNFGEFHKHEF() == other.getUnk3300GNFGEFHKHEF() && getLevelId() == other.getLevelId() && getUnk3300ONPKNIAHPHM() == other.getUnk3300ONPKNIAHPHM() && getUnk3300GDKMJJNFIPP() == other.getUnk3300GDKMJJNFIPP() && hasSingleBestTeamInfo() == other.hasSingleBestTeamInfo()) {
                return (!hasSingleBestTeamInfo() || getSingleBestTeamInfo().equals(other.getSingleBestTeamInfo())) && getUnk3300HINHOCILNJC() == other.getUnk3300HINHOCILNJC() && getUnk3300ALILGJBDOMD() == other.getUnk3300ALILGJBDOMD() && getUnk3300OLNMJJHJAGK() == other.getUnk3300OLNMJJHJAGK() && getUnk3300LOPHGLMNDCP() == other.getUnk3300LOPHGLMNDCP() && getDoubleBestTeamInfoListList().equals(other.getDoubleBestTeamInfoListList()) && getUnk3300JDBOOHBJFCP() == other.getUnk3300JDBOOHBJFCP() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashBoolean(getIsLevelOpen()))) + 14)) + getUnk3300GNFGEFHKHEF())) + 7)) + getLevelId())) + 4)) + getUnk3300ONPKNIAHPHM())) + 13)) + Internal.hashBoolean(getUnk3300GDKMJJNFIPP());
            if (hasSingleBestTeamInfo()) {
                hash = (53 * ((37 * hash) + 8)) + getSingleBestTeamInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + getUnk3300HINHOCILNJC())) + 3)) + getUnk3300ALILGJBDOMD())) + 10)) + Internal.hashBoolean(getUnk3300OLNMJJHJAGK()))) + 11)) + getUnk3300LOPHGLMNDCP();
            if (getDoubleBestTeamInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 2)) + getDoubleBestTeamInfoListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 9)) + Internal.hashBoolean(getUnk3300JDBOOHBJFCP()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static CoinCollectLevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectLevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectLevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectLevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectLevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CoinCollectLevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CoinCollectLevelData parseFrom(InputStream input) throws IOException {
            return (CoinCollectLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectLevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectLevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (CoinCollectLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CoinCollectLevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CoinCollectLevelData parseFrom(CodedInputStream input) throws IOException {
            return (CoinCollectLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CoinCollectLevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CoinCollectLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CoinCollectLevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoinCollectLevelDataOuterClass$CoinCollectLevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CoinCollectLevelDataOrBuilder {
            private int bitField0_;
            private boolean isLevelOpen_;
            private int unk3300GNFGEFHKHEF_;
            private int levelId_;
            private int unk3300ONPKNIAHPHM_;
            private boolean unk3300GDKMJJNFIPP_;
            private CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData singleBestTeamInfo_;
            private SingleFieldBuilderV3<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> singleBestTeamInfoBuilder_;
            private int unk3300HINHOCILNJC_;
            private int unk3300ALILGJBDOMD_;
            private boolean unk3300OLNMJJHJAGK_;
            private int unk3300LOPHGLMNDCP_;
            private List<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData> doubleBestTeamInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> doubleBestTeamInfoListBuilder_;
            private boolean unk3300JDBOOHBJFCP_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CoinCollectLevelDataOuterClass.internal_static_CoinCollectLevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CoinCollectLevelDataOuterClass.internal_static_CoinCollectLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(CoinCollectLevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CoinCollectLevelData.alwaysUseFieldBuilders) {
                    getDoubleBestTeamInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isLevelOpen_ = false;
                this.unk3300GNFGEFHKHEF_ = 0;
                this.levelId_ = 0;
                this.unk3300ONPKNIAHPHM_ = 0;
                this.unk3300GDKMJJNFIPP_ = false;
                if (this.singleBestTeamInfoBuilder_ == null) {
                    this.singleBestTeamInfo_ = null;
                } else {
                    this.singleBestTeamInfo_ = null;
                    this.singleBestTeamInfoBuilder_ = null;
                }
                this.unk3300HINHOCILNJC_ = 0;
                this.unk3300ALILGJBDOMD_ = 0;
                this.unk3300OLNMJJHJAGK_ = false;
                this.unk3300LOPHGLMNDCP_ = 0;
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    this.doubleBestTeamInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.doubleBestTeamInfoListBuilder_.clear();
                }
                this.unk3300JDBOOHBJFCP_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CoinCollectLevelDataOuterClass.internal_static_CoinCollectLevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CoinCollectLevelData getDefaultInstanceForType() {
                return CoinCollectLevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectLevelData build() {
                CoinCollectLevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CoinCollectLevelData buildPartial() {
                CoinCollectLevelData result = new CoinCollectLevelData(this);
                int i = this.bitField0_;
                result.isLevelOpen_ = this.isLevelOpen_;
                result.unk3300GNFGEFHKHEF_ = this.unk3300GNFGEFHKHEF_;
                result.levelId_ = this.levelId_;
                result.unk3300ONPKNIAHPHM_ = this.unk3300ONPKNIAHPHM_;
                result.unk3300GDKMJJNFIPP_ = this.unk3300GDKMJJNFIPP_;
                if (this.singleBestTeamInfoBuilder_ == null) {
                    result.singleBestTeamInfo_ = this.singleBestTeamInfo_;
                } else {
                    result.singleBestTeamInfo_ = this.singleBestTeamInfoBuilder_.build();
                }
                result.unk3300HINHOCILNJC_ = this.unk3300HINHOCILNJC_;
                result.unk3300ALILGJBDOMD_ = this.unk3300ALILGJBDOMD_;
                result.unk3300OLNMJJHJAGK_ = this.unk3300OLNMJJHJAGK_;
                result.unk3300LOPHGLMNDCP_ = this.unk3300LOPHGLMNDCP_;
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.doubleBestTeamInfoList_ = Collections.unmodifiableList(this.doubleBestTeamInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.doubleBestTeamInfoList_ = this.doubleBestTeamInfoList_;
                } else {
                    result.doubleBestTeamInfoList_ = this.doubleBestTeamInfoListBuilder_.build();
                }
                result.unk3300JDBOOHBJFCP_ = this.unk3300JDBOOHBJFCP_;
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
                if (other instanceof CoinCollectLevelData) {
                    return mergeFrom((CoinCollectLevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CoinCollectLevelData other) {
                if (other == CoinCollectLevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsLevelOpen()) {
                    setIsLevelOpen(other.getIsLevelOpen());
                }
                if (other.getUnk3300GNFGEFHKHEF() != 0) {
                    setUnk3300GNFGEFHKHEF(other.getUnk3300GNFGEFHKHEF());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getUnk3300ONPKNIAHPHM() != 0) {
                    setUnk3300ONPKNIAHPHM(other.getUnk3300ONPKNIAHPHM());
                }
                if (other.getUnk3300GDKMJJNFIPP()) {
                    setUnk3300GDKMJJNFIPP(other.getUnk3300GDKMJJNFIPP());
                }
                if (other.hasSingleBestTeamInfo()) {
                    mergeSingleBestTeamInfo(other.getSingleBestTeamInfo());
                }
                if (other.getUnk3300HINHOCILNJC() != 0) {
                    setUnk3300HINHOCILNJC(other.getUnk3300HINHOCILNJC());
                }
                if (other.getUnk3300ALILGJBDOMD() != 0) {
                    setUnk3300ALILGJBDOMD(other.getUnk3300ALILGJBDOMD());
                }
                if (other.getUnk3300OLNMJJHJAGK()) {
                    setUnk3300OLNMJJHJAGK(other.getUnk3300OLNMJJHJAGK());
                }
                if (other.getUnk3300LOPHGLMNDCP() != 0) {
                    setUnk3300LOPHGLMNDCP(other.getUnk3300LOPHGLMNDCP());
                }
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    if (!other.doubleBestTeamInfoList_.isEmpty()) {
                        if (this.doubleBestTeamInfoList_.isEmpty()) {
                            this.doubleBestTeamInfoList_ = other.doubleBestTeamInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDoubleBestTeamInfoListIsMutable();
                            this.doubleBestTeamInfoList_.addAll(other.doubleBestTeamInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.doubleBestTeamInfoList_.isEmpty()) {
                    if (this.doubleBestTeamInfoListBuilder_.isEmpty()) {
                        this.doubleBestTeamInfoListBuilder_.dispose();
                        this.doubleBestTeamInfoListBuilder_ = null;
                        this.doubleBestTeamInfoList_ = other.doubleBestTeamInfoList_;
                        this.bitField0_ &= -2;
                        this.doubleBestTeamInfoListBuilder_ = CoinCollectLevelData.alwaysUseFieldBuilders ? getDoubleBestTeamInfoListFieldBuilder() : null;
                    } else {
                        this.doubleBestTeamInfoListBuilder_.addAllMessages(other.doubleBestTeamInfoList_);
                    }
                }
                if (other.getUnk3300JDBOOHBJFCP()) {
                    setUnk3300JDBOOHBJFCP(other.getUnk3300JDBOOHBJFCP());
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
                CoinCollectLevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = CoinCollectLevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CoinCollectLevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public boolean getIsLevelOpen() {
                return this.isLevelOpen_;
            }

            public Builder setIsLevelOpen(boolean value) {
                this.isLevelOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLevelOpen() {
                this.isLevelOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public int getUnk3300GNFGEFHKHEF() {
                return this.unk3300GNFGEFHKHEF_;
            }

            public Builder setUnk3300GNFGEFHKHEF(int value) {
                this.unk3300GNFGEFHKHEF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GNFGEFHKHEF() {
                this.unk3300GNFGEFHKHEF_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public int getUnk3300ONPKNIAHPHM() {
                return this.unk3300ONPKNIAHPHM_;
            }

            public Builder setUnk3300ONPKNIAHPHM(int value) {
                this.unk3300ONPKNIAHPHM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ONPKNIAHPHM() {
                this.unk3300ONPKNIAHPHM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public boolean getUnk3300GDKMJJNFIPP() {
                return this.unk3300GDKMJJNFIPP_;
            }

            public Builder setUnk3300GDKMJJNFIPP(boolean value) {
                this.unk3300GDKMJJNFIPP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GDKMJJNFIPP() {
                this.unk3300GDKMJJNFIPP_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public boolean hasSingleBestTeamInfo() {
                return (this.singleBestTeamInfoBuilder_ == null && this.singleBestTeamInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData getSingleBestTeamInfo() {
                if (this.singleBestTeamInfoBuilder_ == null) {
                    return this.singleBestTeamInfo_ == null ? CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.getDefaultInstance() : this.singleBestTeamInfo_;
                }
                return this.singleBestTeamInfoBuilder_.getMessage();
            }

            public Builder setSingleBestTeamInfo(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData value) {
                if (this.singleBestTeamInfoBuilder_ != null) {
                    this.singleBestTeamInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.singleBestTeamInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setSingleBestTeamInfo(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder builderForValue) {
                if (this.singleBestTeamInfoBuilder_ == null) {
                    this.singleBestTeamInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.singleBestTeamInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeSingleBestTeamInfo(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData value) {
                if (this.singleBestTeamInfoBuilder_ == null) {
                    if (this.singleBestTeamInfo_ != null) {
                        this.singleBestTeamInfo_ = CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.newBuilder(this.singleBestTeamInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.singleBestTeamInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.singleBestTeamInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearSingleBestTeamInfo() {
                if (this.singleBestTeamInfoBuilder_ == null) {
                    this.singleBestTeamInfo_ = null;
                    onChanged();
                } else {
                    this.singleBestTeamInfo_ = null;
                    this.singleBestTeamInfoBuilder_ = null;
                }
                return this;
            }

            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder getSingleBestTeamInfoBuilder() {
                onChanged();
                return getSingleBestTeamInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder getSingleBestTeamInfoOrBuilder() {
                if (this.singleBestTeamInfoBuilder_ != null) {
                    return this.singleBestTeamInfoBuilder_.getMessageOrBuilder();
                }
                return this.singleBestTeamInfo_ == null ? CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.getDefaultInstance() : this.singleBestTeamInfo_;
            }

            private SingleFieldBuilderV3<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> getSingleBestTeamInfoFieldBuilder() {
                if (this.singleBestTeamInfoBuilder_ == null) {
                    this.singleBestTeamInfoBuilder_ = new SingleFieldBuilderV3<>(getSingleBestTeamInfo(), getParentForChildren(), isClean());
                    this.singleBestTeamInfo_ = null;
                }
                return this.singleBestTeamInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public int getUnk3300HINHOCILNJC() {
                return this.unk3300HINHOCILNJC_;
            }

            public Builder setUnk3300HINHOCILNJC(int value) {
                this.unk3300HINHOCILNJC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HINHOCILNJC() {
                this.unk3300HINHOCILNJC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public int getUnk3300ALILGJBDOMD() {
                return this.unk3300ALILGJBDOMD_;
            }

            public Builder setUnk3300ALILGJBDOMD(int value) {
                this.unk3300ALILGJBDOMD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ALILGJBDOMD() {
                this.unk3300ALILGJBDOMD_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public boolean getUnk3300OLNMJJHJAGK() {
                return this.unk3300OLNMJJHJAGK_;
            }

            public Builder setUnk3300OLNMJJHJAGK(boolean value) {
                this.unk3300OLNMJJHJAGK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OLNMJJHJAGK() {
                this.unk3300OLNMJJHJAGK_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public int getUnk3300LOPHGLMNDCP() {
                return this.unk3300LOPHGLMNDCP_;
            }

            public Builder setUnk3300LOPHGLMNDCP(int value) {
                this.unk3300LOPHGLMNDCP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LOPHGLMNDCP() {
                this.unk3300LOPHGLMNDCP_ = 0;
                onChanged();
                return this;
            }

            private void ensureDoubleBestTeamInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.doubleBestTeamInfoList_ = new ArrayList(this.doubleBestTeamInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public List<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData> getDoubleBestTeamInfoListList() {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.doubleBestTeamInfoList_);
                }
                return this.doubleBestTeamInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public int getDoubleBestTeamInfoListCount() {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    return this.doubleBestTeamInfoList_.size();
                }
                return this.doubleBestTeamInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData getDoubleBestTeamInfoList(int index) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    return this.doubleBestTeamInfoList_.get(index);
                }
                return this.doubleBestTeamInfoListBuilder_.getMessage(index);
            }

            public Builder setDoubleBestTeamInfoList(int index, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData value) {
                if (this.doubleBestTeamInfoListBuilder_ != null) {
                    this.doubleBestTeamInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDoubleBestTeamInfoList(int index, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder builderForValue) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.doubleBestTeamInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDoubleBestTeamInfoList(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData value) {
                if (this.doubleBestTeamInfoListBuilder_ != null) {
                    this.doubleBestTeamInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDoubleBestTeamInfoList(int index, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData value) {
                if (this.doubleBestTeamInfoListBuilder_ != null) {
                    this.doubleBestTeamInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDoubleBestTeamInfoList(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder builderForValue) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.doubleBestTeamInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDoubleBestTeamInfoList(int index, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder builderForValue) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.doubleBestTeamInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDoubleBestTeamInfoList(Iterable<? extends CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData> values) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    ensureDoubleBestTeamInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.doubleBestTeamInfoList_);
                    onChanged();
                } else {
                    this.doubleBestTeamInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDoubleBestTeamInfoList() {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    this.doubleBestTeamInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.doubleBestTeamInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDoubleBestTeamInfoList(int index) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    ensureDoubleBestTeamInfoListIsMutable();
                    this.doubleBestTeamInfoList_.remove(index);
                    onChanged();
                } else {
                    this.doubleBestTeamInfoListBuilder_.remove(index);
                }
                return this;
            }

            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder getDoubleBestTeamInfoListBuilder(int index) {
                return getDoubleBestTeamInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder getDoubleBestTeamInfoListOrBuilder(int index) {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    return this.doubleBestTeamInfoList_.get(index);
                }
                return this.doubleBestTeamInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public List<? extends CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> getDoubleBestTeamInfoListOrBuilderList() {
                if (this.doubleBestTeamInfoListBuilder_ != null) {
                    return this.doubleBestTeamInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.doubleBestTeamInfoList_);
            }

            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder addDoubleBestTeamInfoListBuilder() {
                return getDoubleBestTeamInfoListFieldBuilder().addBuilder(CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.getDefaultInstance());
            }

            public CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder addDoubleBestTeamInfoListBuilder(int index) {
                return getDoubleBestTeamInfoListFieldBuilder().addBuilder(index, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.getDefaultInstance());
            }

            public List<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder> getDoubleBestTeamInfoListBuilderList() {
                return getDoubleBestTeamInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoData.Builder, CoinCollectTeamInfoDataOuterClass.CoinCollectTeamInfoDataOrBuilder> getDoubleBestTeamInfoListFieldBuilder() {
                if (this.doubleBestTeamInfoListBuilder_ == null) {
                    this.doubleBestTeamInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.doubleBestTeamInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.doubleBestTeamInfoList_ = null;
                }
                return this.doubleBestTeamInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CoinCollectLevelDataOuterClass.CoinCollectLevelDataOrBuilder
            public boolean getUnk3300JDBOOHBJFCP() {
                return this.unk3300JDBOOHBJFCP_;
            }

            public Builder setUnk3300JDBOOHBJFCP(boolean value) {
                this.unk3300JDBOOHBJFCP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JDBOOHBJFCP() {
                this.unk3300JDBOOHBJFCP_ = false;
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

        public static CoinCollectLevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CoinCollectLevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CoinCollectLevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CoinCollectLevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CoinCollectTeamInfoDataOuterClass.getDescriptor();
    }
}
