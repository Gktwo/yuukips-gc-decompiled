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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBriefInfoOuterClass.class */
public final class MusicBriefInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014MusicBriefInfo.proto\"Ã\u0004\n\u000eMusicBriefInfo\u0012\u001b\n\u0013Unk2700_JNENCBCGPGO\u0018\u0005 \u0001(\u0004\u0012\u001b\n\u0013Unk2700_OJBPHCIDAEB\u0018\b \u0001(\b\u0012\u001b\n\u0013Unk2700_FGCJEGHOKPG\u0018\u0001 \u0001(\b\u0012\u001b\n\u0013Unk2700_DFIBAIILJHN\u0018\u0002 \u0001(\r\u0012\u001c\n\u0013Unk2700_MKBNLEKMIMD\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk2700_PINGIIAANMO\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk2700_MONNIDCNDFI\u0018\n \u0001(\t\u0012\u000f\n\u0007version\u0018\u000f \u0001(\r\u0012\u001b\n\u0013Unk2700_GGHNLPMAGME\u0018\u0003 \u0001(\r\u0012\u001c\n\u0013Unk2700_GDCGOMNBMEO\u0018ê\u0007 \u0003(\r\u0012\u001c\n\u0013Unk2700_JAEONBMBFJJ\u0018Ö\u0007 \u0003(\r\u0012\u001b\n\u0013Unk2700_GBCGGDONMCD\u0018\t \u0001(\b\u0012\u001c\n\u0013Unk2700_LPEKFJBNEJM\u0018\u000e \u0001(\r\u0012\u001b\n\u0013Unk2700_DNLEGADDHKM\u0018\u000b \u0001(\b\u0012\u001b\n\u0013Unk2700_BFMNMPPNBHH\u0018\r \u0001(\r\u0012\u0011\n\tmax_score\u0018\u000e \u0001(\r\u0012\u001c\n\u0013Unk2700_KAMOCHAKPGP\u0018À\u0004 \u0001(\r\u0012\u001b\n\u0013Unk2700_KLPHBLCIOEC\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk2700_CEPGMKAHHCD\u0018\u0004 \u0001(\u0004\u0012\u001b\n\u0013Unk2700_PMCPLPMJCEC\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MusicBriefInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicBriefInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicBriefInfo_descriptor, new String[]{"Unk2700JNENCBCGPGO", "Unk2700OJBPHCIDAEB", "Unk2700FGCJEGHOKPG", "Unk2700DFIBAIILJHN", "Unk2700MKBNLEKMIMD", "Unk2700PINGIIAANMO", "Unk2700MONNIDCNDFI", "Version", "Unk2700GGHNLPMAGME", "Unk2700GDCGOMNBMEO", "Unk2700JAEONBMBFJJ", "Unk2700GBCGGDONMCD", "Unk2700LPEKFJBNEJM", "Unk2700DNLEGADDHKM", "Unk2700BFMNMPPNBHH", "MaxScore", "Unk2700KAMOCHAKPGP", "Unk2700KLPHBLCIOEC", "Unk2700CEPGMKAHHCD", "Unk2700PMCPLPMJCEC"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBriefInfoOuterClass$MusicBriefInfoOrBuilder.class */
    public interface MusicBriefInfoOrBuilder extends MessageOrBuilder {
        long getUnk2700JNENCBCGPGO();

        boolean getUnk2700OJBPHCIDAEB();

        boolean getUnk2700FGCJEGHOKPG();

        int getUnk2700DFIBAIILJHN();

        int getUnk2700MKBNLEKMIMD();

        int getUnk2700PINGIIAANMO();

        String getUnk2700MONNIDCNDFI();

        ByteString getUnk2700MONNIDCNDFIBytes();

        int getVersion();

        int getUnk2700GGHNLPMAGME();

        List<Integer> getUnk2700GDCGOMNBMEOList();

        int getUnk2700GDCGOMNBMEOCount();

        int getUnk2700GDCGOMNBMEO(int i);

        List<Integer> getUnk2700JAEONBMBFJJList();

        int getUnk2700JAEONBMBFJJCount();

        int getUnk2700JAEONBMBFJJ(int i);

        boolean getUnk2700GBCGGDONMCD();

        int getUnk2700LPEKFJBNEJM();

        boolean getUnk2700DNLEGADDHKM();

        int getUnk2700BFMNMPPNBHH();

        int getMaxScore();

        int getUnk2700KAMOCHAKPGP();

        int getUnk2700KLPHBLCIOEC();

        long getUnk2700CEPGMKAHHCD();

        int getUnk2700PMCPLPMJCEC();
    }

    private MusicBriefInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBriefInfoOuterClass$MusicBriefInfo.class */
    public static final class MusicBriefInfo extends GeneratedMessageV3 implements MusicBriefInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK2700_JNENCBCGPGO_FIELD_NUMBER = 5;
        private long unk2700JNENCBCGPGO_;
        public static final int UNK2700_OJBPHCIDAEB_FIELD_NUMBER = 8;
        private boolean unk2700OJBPHCIDAEB_;
        public static final int UNK2700_FGCJEGHOKPG_FIELD_NUMBER = 1;
        private boolean unk2700FGCJEGHOKPG_;
        public static final int UNK2700_DFIBAIILJHN_FIELD_NUMBER = 2;
        private int unk2700DFIBAIILJHN_;
        public static final int UNK2700_MKBNLEKMIMD_FIELD_NUMBER = 1182;
        private int unk2700MKBNLEKMIMD_;
        public static final int UNK2700_PINGIIAANMO_FIELD_NUMBER = 12;
        private int unk2700PINGIIAANMO_;
        public static final int UNK2700_MONNIDCNDFI_FIELD_NUMBER = 10;
        private volatile Object unk2700MONNIDCNDFI_;
        public static final int VERSION_FIELD_NUMBER = 15;
        private int version_;
        public static final int UNK2700_GGHNLPMAGME_FIELD_NUMBER = 3;
        private int unk2700GGHNLPMAGME_;
        public static final int UNK2700_GDCGOMNBMEO_FIELD_NUMBER = 1002;
        private Internal.IntList unk2700GDCGOMNBMEO_;
        private int unk2700GDCGOMNBMEOMemoizedSerializedSize;
        public static final int UNK2700_JAEONBMBFJJ_FIELD_NUMBER = 982;
        private Internal.IntList unk2700JAEONBMBFJJ_;
        private int unk2700JAEONBMBFJJMemoizedSerializedSize;
        public static final int UNK2700_GBCGGDONMCD_FIELD_NUMBER = 9;
        private boolean unk2700GBCGGDONMCD_;
        public static final int UNK2700_LPEKFJBNEJM_FIELD_NUMBER = 1822;
        private int unk2700LPEKFJBNEJM_;
        public static final int UNK2700_DNLEGADDHKM_FIELD_NUMBER = 11;
        private boolean unk2700DNLEGADDHKM_;
        public static final int UNK2700_BFMNMPPNBHH_FIELD_NUMBER = 13;
        private int unk2700BFMNMPPNBHH_;
        public static final int MAX_SCORE_FIELD_NUMBER = 14;
        private int maxScore_;
        public static final int UNK2700_KAMOCHAKPGP_FIELD_NUMBER = 576;
        private int unk2700KAMOCHAKPGP_;
        public static final int UNK2700_KLPHBLCIOEC_FIELD_NUMBER = 7;
        private int unk2700KLPHBLCIOEC_;
        public static final int UNK2700_CEPGMKAHHCD_FIELD_NUMBER = 4;
        private long unk2700CEPGMKAHHCD_;
        public static final int UNK2700_PMCPLPMJCEC_FIELD_NUMBER = 6;
        private int unk2700PMCPLPMJCEC_;
        private byte memoizedIsInitialized;
        private static final MusicBriefInfo DEFAULT_INSTANCE = new MusicBriefInfo();
        private static final Parser<MusicBriefInfo> PARSER = new AbstractParser<MusicBriefInfo>() { // from class: emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfo.1
            @Override // com.google.protobuf.Parser
            public MusicBriefInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicBriefInfo(input, extensionRegistry);
            }
        };

        private MusicBriefInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk2700GDCGOMNBMEOMemoizedSerializedSize = -1;
            this.unk2700JAEONBMBFJJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MusicBriefInfo() {
            this.unk2700GDCGOMNBMEOMemoizedSerializedSize = -1;
            this.unk2700JAEONBMBFJJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk2700MONNIDCNDFI_ = "";
            this.unk2700GDCGOMNBMEO_ = emptyIntList();
            this.unk2700JAEONBMBFJJ_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicBriefInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0296 */
        private MusicBriefInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.unk2700FGCJEGHOKPG_ = input.readBool();
                                    break;
                                case 16:
                                    this.unk2700DFIBAIILJHN_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.unk2700GGHNLPMAGME_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.unk2700CEPGMKAHHCD_ = input.readUInt64();
                                    break;
                                case 40:
                                    this.unk2700JNENCBCGPGO_ = input.readUInt64();
                                    break;
                                case 48:
                                    this.unk2700PMCPLPMJCEC_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.unk2700KLPHBLCIOEC_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.unk2700OJBPHCIDAEB_ = input.readBool();
                                    break;
                                case 72:
                                    this.unk2700GBCGGDONMCD_ = input.readBool();
                                    break;
                                case 82:
                                    this.unk2700MONNIDCNDFI_ = input.readStringRequireUtf8();
                                    break;
                                case 88:
                                    this.unk2700DNLEGADDHKM_ = input.readBool();
                                    break;
                                case 96:
                                    this.unk2700PINGIIAANMO_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.unk2700BFMNMPPNBHH_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.maxScore_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.version_ = input.readUInt32();
                                    break;
                                case 4608:
                                    this.unk2700KAMOCHAKPGP_ = input.readUInt32();
                                    break;
                                case 7856:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.unk2700JAEONBMBFJJ_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.unk2700JAEONBMBFJJ_.addInt(input.readUInt32());
                                    break;
                                case 7858:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk2700JAEONBMBFJJ_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk2700JAEONBMBFJJ_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 8016:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk2700GDCGOMNBMEO_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unk2700GDCGOMNBMEO_.addInt(input.readUInt32());
                                    break;
                                case 8018:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk2700GDCGOMNBMEO_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk2700GDCGOMNBMEO_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 9456:
                                    this.unk2700MKBNLEKMIMD_ = input.readUInt32();
                                    break;
                                case 14576:
                                    this.unk2700LPEKFJBNEJM_ = input.readUInt32();
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk2700JAEONBMBFJJ_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk2700GDCGOMNBMEO_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicBriefInfoOuterClass.internal_static_MusicBriefInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicBriefInfoOuterClass.internal_static_MusicBriefInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicBriefInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public long getUnk2700JNENCBCGPGO() {
            return this.unk2700JNENCBCGPGO_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public boolean getUnk2700OJBPHCIDAEB() {
            return this.unk2700OJBPHCIDAEB_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public boolean getUnk2700FGCJEGHOKPG() {
            return this.unk2700FGCJEGHOKPG_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700DFIBAIILJHN() {
            return this.unk2700DFIBAIILJHN_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700MKBNLEKMIMD() {
            return this.unk2700MKBNLEKMIMD_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700PINGIIAANMO() {
            return this.unk2700PINGIIAANMO_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public String getUnk2700MONNIDCNDFI() {
            Object ref = this.unk2700MONNIDCNDFI_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk2700MONNIDCNDFI_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public ByteString getUnk2700MONNIDCNDFIBytes() {
            Object ref = this.unk2700MONNIDCNDFI_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk2700MONNIDCNDFI_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700GGHNLPMAGME() {
            return this.unk2700GGHNLPMAGME_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public List<Integer> getUnk2700GDCGOMNBMEOList() {
            return this.unk2700GDCGOMNBMEO_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700GDCGOMNBMEOCount() {
            return this.unk2700GDCGOMNBMEO_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700GDCGOMNBMEO(int index) {
            return this.unk2700GDCGOMNBMEO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public List<Integer> getUnk2700JAEONBMBFJJList() {
            return this.unk2700JAEONBMBFJJ_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700JAEONBMBFJJCount() {
            return this.unk2700JAEONBMBFJJ_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700JAEONBMBFJJ(int index) {
            return this.unk2700JAEONBMBFJJ_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public boolean getUnk2700GBCGGDONMCD() {
            return this.unk2700GBCGGDONMCD_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700LPEKFJBNEJM() {
            return this.unk2700LPEKFJBNEJM_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public boolean getUnk2700DNLEGADDHKM() {
            return this.unk2700DNLEGADDHKM_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700BFMNMPPNBHH() {
            return this.unk2700BFMNMPPNBHH_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getMaxScore() {
            return this.maxScore_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700KAMOCHAKPGP() {
            return this.unk2700KAMOCHAKPGP_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700KLPHBLCIOEC() {
            return this.unk2700KLPHBLCIOEC_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public long getUnk2700CEPGMKAHHCD() {
            return this.unk2700CEPGMKAHHCD_;
        }

        @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
        public int getUnk2700PMCPLPMJCEC() {
            return this.unk2700PMCPLPMJCEC_;
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
            if (this.unk2700FGCJEGHOKPG_) {
                output.writeBool(1, this.unk2700FGCJEGHOKPG_);
            }
            if (this.unk2700DFIBAIILJHN_ != 0) {
                output.writeUInt32(2, this.unk2700DFIBAIILJHN_);
            }
            if (this.unk2700GGHNLPMAGME_ != 0) {
                output.writeUInt32(3, this.unk2700GGHNLPMAGME_);
            }
            if (this.unk2700CEPGMKAHHCD_ != 0) {
                output.writeUInt64(4, this.unk2700CEPGMKAHHCD_);
            }
            if (this.unk2700JNENCBCGPGO_ != 0) {
                output.writeUInt64(5, this.unk2700JNENCBCGPGO_);
            }
            if (this.unk2700PMCPLPMJCEC_ != 0) {
                output.writeUInt32(6, this.unk2700PMCPLPMJCEC_);
            }
            if (this.unk2700KLPHBLCIOEC_ != 0) {
                output.writeUInt32(7, this.unk2700KLPHBLCIOEC_);
            }
            if (this.unk2700OJBPHCIDAEB_) {
                output.writeBool(8, this.unk2700OJBPHCIDAEB_);
            }
            if (this.unk2700GBCGGDONMCD_) {
                output.writeBool(9, this.unk2700GBCGGDONMCD_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk2700MONNIDCNDFI_)) {
                GeneratedMessageV3.writeString(output, 10, this.unk2700MONNIDCNDFI_);
            }
            if (this.unk2700DNLEGADDHKM_) {
                output.writeBool(11, this.unk2700DNLEGADDHKM_);
            }
            if (this.unk2700PINGIIAANMO_ != 0) {
                output.writeUInt32(12, this.unk2700PINGIIAANMO_);
            }
            if (this.unk2700BFMNMPPNBHH_ != 0) {
                output.writeUInt32(13, this.unk2700BFMNMPPNBHH_);
            }
            if (this.maxScore_ != 0) {
                output.writeUInt32(14, this.maxScore_);
            }
            if (this.version_ != 0) {
                output.writeUInt32(15, this.version_);
            }
            if (this.unk2700KAMOCHAKPGP_ != 0) {
                output.writeUInt32(UNK2700_KAMOCHAKPGP_FIELD_NUMBER, this.unk2700KAMOCHAKPGP_);
            }
            if (getUnk2700JAEONBMBFJJList().size() > 0) {
                output.writeUInt32NoTag(7858);
                output.writeUInt32NoTag(this.unk2700JAEONBMBFJJMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk2700JAEONBMBFJJ_.size(); i++) {
                output.writeUInt32NoTag(this.unk2700JAEONBMBFJJ_.getInt(i));
            }
            if (getUnk2700GDCGOMNBMEOList().size() > 0) {
                output.writeUInt32NoTag(8018);
                output.writeUInt32NoTag(this.unk2700GDCGOMNBMEOMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk2700GDCGOMNBMEO_.size(); i2++) {
                output.writeUInt32NoTag(this.unk2700GDCGOMNBMEO_.getInt(i2));
            }
            if (this.unk2700MKBNLEKMIMD_ != 0) {
                output.writeUInt32(1182, this.unk2700MKBNLEKMIMD_);
            }
            if (this.unk2700LPEKFJBNEJM_ != 0) {
                output.writeUInt32(1822, this.unk2700LPEKFJBNEJM_);
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
            if (this.unk2700FGCJEGHOKPG_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.unk2700FGCJEGHOKPG_);
            }
            if (this.unk2700DFIBAIILJHN_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.unk2700DFIBAIILJHN_);
            }
            if (this.unk2700GGHNLPMAGME_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.unk2700GGHNLPMAGME_);
            }
            if (this.unk2700CEPGMKAHHCD_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.unk2700CEPGMKAHHCD_);
            }
            if (this.unk2700JNENCBCGPGO_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(5, this.unk2700JNENCBCGPGO_);
            }
            if (this.unk2700PMCPLPMJCEC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.unk2700PMCPLPMJCEC_);
            }
            if (this.unk2700KLPHBLCIOEC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk2700KLPHBLCIOEC_);
            }
            if (this.unk2700OJBPHCIDAEB_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.unk2700OJBPHCIDAEB_);
            }
            if (this.unk2700GBCGGDONMCD_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.unk2700GBCGGDONMCD_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk2700MONNIDCNDFI_)) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.unk2700MONNIDCNDFI_);
            }
            if (this.unk2700DNLEGADDHKM_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.unk2700DNLEGADDHKM_);
            }
            if (this.unk2700PINGIIAANMO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk2700PINGIIAANMO_);
            }
            if (this.unk2700BFMNMPPNBHH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk2700BFMNMPPNBHH_);
            }
            if (this.maxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.maxScore_);
            }
            if (this.version_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.version_);
            }
            if (this.unk2700KAMOCHAKPGP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK2700_KAMOCHAKPGP_FIELD_NUMBER, this.unk2700KAMOCHAKPGP_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk2700JAEONBMBFJJ_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk2700JAEONBMBFJJ_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnk2700JAEONBMBFJJList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk2700JAEONBMBFJJMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk2700GDCGOMNBMEO_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk2700GDCGOMNBMEO_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk2700GDCGOMNBMEOList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk2700GDCGOMNBMEOMemoizedSerializedSize = dataSize2;
            if (this.unk2700MKBNLEKMIMD_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(1182, this.unk2700MKBNLEKMIMD_);
            }
            if (this.unk2700LPEKFJBNEJM_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(1822, this.unk2700LPEKFJBNEJM_);
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
            if (!(obj instanceof MusicBriefInfo)) {
                return equals(obj);
            }
            MusicBriefInfo other = (MusicBriefInfo) obj;
            return getUnk2700JNENCBCGPGO() == other.getUnk2700JNENCBCGPGO() && getUnk2700OJBPHCIDAEB() == other.getUnk2700OJBPHCIDAEB() && getUnk2700FGCJEGHOKPG() == other.getUnk2700FGCJEGHOKPG() && getUnk2700DFIBAIILJHN() == other.getUnk2700DFIBAIILJHN() && getUnk2700MKBNLEKMIMD() == other.getUnk2700MKBNLEKMIMD() && getUnk2700PINGIIAANMO() == other.getUnk2700PINGIIAANMO() && getUnk2700MONNIDCNDFI().equals(other.getUnk2700MONNIDCNDFI()) && getVersion() == other.getVersion() && getUnk2700GGHNLPMAGME() == other.getUnk2700GGHNLPMAGME() && getUnk2700GDCGOMNBMEOList().equals(other.getUnk2700GDCGOMNBMEOList()) && getUnk2700JAEONBMBFJJList().equals(other.getUnk2700JAEONBMBFJJList()) && getUnk2700GBCGGDONMCD() == other.getUnk2700GBCGGDONMCD() && getUnk2700LPEKFJBNEJM() == other.getUnk2700LPEKFJBNEJM() && getUnk2700DNLEGADDHKM() == other.getUnk2700DNLEGADDHKM() && getUnk2700BFMNMPPNBHH() == other.getUnk2700BFMNMPPNBHH() && getMaxScore() == other.getMaxScore() && getUnk2700KAMOCHAKPGP() == other.getUnk2700KAMOCHAKPGP() && getUnk2700KLPHBLCIOEC() == other.getUnk2700KLPHBLCIOEC() && getUnk2700CEPGMKAHHCD() == other.getUnk2700CEPGMKAHHCD() && getUnk2700PMCPLPMJCEC() == other.getUnk2700PMCPLPMJCEC() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashLong(getUnk2700JNENCBCGPGO()))) + 8)) + Internal.hashBoolean(getUnk2700OJBPHCIDAEB()))) + 1)) + Internal.hashBoolean(getUnk2700FGCJEGHOKPG()))) + 2)) + getUnk2700DFIBAIILJHN())) + 1182)) + getUnk2700MKBNLEKMIMD())) + 12)) + getUnk2700PINGIIAANMO())) + 10)) + getUnk2700MONNIDCNDFI().hashCode())) + 15)) + getVersion())) + 3)) + getUnk2700GGHNLPMAGME();
            if (getUnk2700GDCGOMNBMEOCount() > 0) {
                hash = (53 * ((37 * hash) + 1002)) + getUnk2700GDCGOMNBMEOList().hashCode();
            }
            if (getUnk2700JAEONBMBFJJCount() > 0) {
                hash = (53 * ((37 * hash) + 982)) + getUnk2700JAEONBMBFJJList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getUnk2700GBCGGDONMCD()))) + 1822)) + getUnk2700LPEKFJBNEJM())) + 11)) + Internal.hashBoolean(getUnk2700DNLEGADDHKM()))) + 13)) + getUnk2700BFMNMPPNBHH())) + 14)) + getMaxScore())) + UNK2700_KAMOCHAKPGP_FIELD_NUMBER)) + getUnk2700KAMOCHAKPGP())) + 7)) + getUnk2700KLPHBLCIOEC())) + 4)) + Internal.hashLong(getUnk2700CEPGMKAHHCD()))) + 6)) + getUnk2700PMCPLPMJCEC())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicBriefInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBriefInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBriefInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBriefInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBriefInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicBriefInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicBriefInfo parseFrom(InputStream input) throws IOException {
            return (MusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicBriefInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicBriefInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicBriefInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicBriefInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBriefInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicBriefInfo parseFrom(CodedInputStream input) throws IOException {
            return (MusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicBriefInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicBriefInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicBriefInfoOuterClass$MusicBriefInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicBriefInfoOrBuilder {
            private int bitField0_;
            private long unk2700JNENCBCGPGO_;
            private boolean unk2700OJBPHCIDAEB_;
            private boolean unk2700FGCJEGHOKPG_;
            private int unk2700DFIBAIILJHN_;
            private int unk2700MKBNLEKMIMD_;
            private int unk2700PINGIIAANMO_;
            private int version_;
            private int unk2700GGHNLPMAGME_;
            private boolean unk2700GBCGGDONMCD_;
            private int unk2700LPEKFJBNEJM_;
            private boolean unk2700DNLEGADDHKM_;
            private int unk2700BFMNMPPNBHH_;
            private int maxScore_;
            private int unk2700KAMOCHAKPGP_;
            private int unk2700KLPHBLCIOEC_;
            private long unk2700CEPGMKAHHCD_;
            private int unk2700PMCPLPMJCEC_;
            private Object unk2700MONNIDCNDFI_ = "";
            private Internal.IntList unk2700GDCGOMNBMEO_ = MusicBriefInfo.emptyIntList();
            private Internal.IntList unk2700JAEONBMBFJJ_ = MusicBriefInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicBriefInfoOuterClass.internal_static_MusicBriefInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicBriefInfoOuterClass.internal_static_MusicBriefInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicBriefInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicBriefInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk2700JNENCBCGPGO_ = 0;
                this.unk2700OJBPHCIDAEB_ = false;
                this.unk2700FGCJEGHOKPG_ = false;
                this.unk2700DFIBAIILJHN_ = 0;
                this.unk2700MKBNLEKMIMD_ = 0;
                this.unk2700PINGIIAANMO_ = 0;
                this.unk2700MONNIDCNDFI_ = "";
                this.version_ = 0;
                this.unk2700GGHNLPMAGME_ = 0;
                this.unk2700GDCGOMNBMEO_ = MusicBriefInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.unk2700JAEONBMBFJJ_ = MusicBriefInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unk2700GBCGGDONMCD_ = false;
                this.unk2700LPEKFJBNEJM_ = 0;
                this.unk2700DNLEGADDHKM_ = false;
                this.unk2700BFMNMPPNBHH_ = 0;
                this.maxScore_ = 0;
                this.unk2700KAMOCHAKPGP_ = 0;
                this.unk2700KLPHBLCIOEC_ = 0;
                this.unk2700CEPGMKAHHCD_ = 0;
                this.unk2700PMCPLPMJCEC_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicBriefInfoOuterClass.internal_static_MusicBriefInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicBriefInfo getDefaultInstanceForType() {
                return MusicBriefInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicBriefInfo build() {
                MusicBriefInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicBriefInfo buildPartial() {
                MusicBriefInfo result = new MusicBriefInfo(this);
                int i = this.bitField0_;
                result.unk2700JNENCBCGPGO_ = this.unk2700JNENCBCGPGO_;
                result.unk2700OJBPHCIDAEB_ = this.unk2700OJBPHCIDAEB_;
                result.unk2700FGCJEGHOKPG_ = this.unk2700FGCJEGHOKPG_;
                result.unk2700DFIBAIILJHN_ = this.unk2700DFIBAIILJHN_;
                result.unk2700MKBNLEKMIMD_ = this.unk2700MKBNLEKMIMD_;
                result.unk2700PINGIIAANMO_ = this.unk2700PINGIIAANMO_;
                result.unk2700MONNIDCNDFI_ = this.unk2700MONNIDCNDFI_;
                result.version_ = this.version_;
                result.unk2700GGHNLPMAGME_ = this.unk2700GGHNLPMAGME_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk2700GDCGOMNBMEO_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk2700GDCGOMNBMEO_ = this.unk2700GDCGOMNBMEO_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk2700JAEONBMBFJJ_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk2700JAEONBMBFJJ_ = this.unk2700JAEONBMBFJJ_;
                result.unk2700GBCGGDONMCD_ = this.unk2700GBCGGDONMCD_;
                result.unk2700LPEKFJBNEJM_ = this.unk2700LPEKFJBNEJM_;
                result.unk2700DNLEGADDHKM_ = this.unk2700DNLEGADDHKM_;
                result.unk2700BFMNMPPNBHH_ = this.unk2700BFMNMPPNBHH_;
                result.maxScore_ = this.maxScore_;
                result.unk2700KAMOCHAKPGP_ = this.unk2700KAMOCHAKPGP_;
                result.unk2700KLPHBLCIOEC_ = this.unk2700KLPHBLCIOEC_;
                result.unk2700CEPGMKAHHCD_ = this.unk2700CEPGMKAHHCD_;
                result.unk2700PMCPLPMJCEC_ = this.unk2700PMCPLPMJCEC_;
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
                if (other instanceof MusicBriefInfo) {
                    return mergeFrom((MusicBriefInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicBriefInfo other) {
                if (other == MusicBriefInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk2700JNENCBCGPGO() != 0) {
                    setUnk2700JNENCBCGPGO(other.getUnk2700JNENCBCGPGO());
                }
                if (other.getUnk2700OJBPHCIDAEB()) {
                    setUnk2700OJBPHCIDAEB(other.getUnk2700OJBPHCIDAEB());
                }
                if (other.getUnk2700FGCJEGHOKPG()) {
                    setUnk2700FGCJEGHOKPG(other.getUnk2700FGCJEGHOKPG());
                }
                if (other.getUnk2700DFIBAIILJHN() != 0) {
                    setUnk2700DFIBAIILJHN(other.getUnk2700DFIBAIILJHN());
                }
                if (other.getUnk2700MKBNLEKMIMD() != 0) {
                    setUnk2700MKBNLEKMIMD(other.getUnk2700MKBNLEKMIMD());
                }
                if (other.getUnk2700PINGIIAANMO() != 0) {
                    setUnk2700PINGIIAANMO(other.getUnk2700PINGIIAANMO());
                }
                if (!other.getUnk2700MONNIDCNDFI().isEmpty()) {
                    this.unk2700MONNIDCNDFI_ = other.unk2700MONNIDCNDFI_;
                    onChanged();
                }
                if (other.getVersion() != 0) {
                    setVersion(other.getVersion());
                }
                if (other.getUnk2700GGHNLPMAGME() != 0) {
                    setUnk2700GGHNLPMAGME(other.getUnk2700GGHNLPMAGME());
                }
                if (!other.unk2700GDCGOMNBMEO_.isEmpty()) {
                    if (this.unk2700GDCGOMNBMEO_.isEmpty()) {
                        this.unk2700GDCGOMNBMEO_ = other.unk2700GDCGOMNBMEO_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk2700GDCGOMNBMEOIsMutable();
                        this.unk2700GDCGOMNBMEO_.addAll(other.unk2700GDCGOMNBMEO_);
                    }
                    onChanged();
                }
                if (!other.unk2700JAEONBMBFJJ_.isEmpty()) {
                    if (this.unk2700JAEONBMBFJJ_.isEmpty()) {
                        this.unk2700JAEONBMBFJJ_ = other.unk2700JAEONBMBFJJ_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk2700JAEONBMBFJJIsMutable();
                        this.unk2700JAEONBMBFJJ_.addAll(other.unk2700JAEONBMBFJJ_);
                    }
                    onChanged();
                }
                if (other.getUnk2700GBCGGDONMCD()) {
                    setUnk2700GBCGGDONMCD(other.getUnk2700GBCGGDONMCD());
                }
                if (other.getUnk2700LPEKFJBNEJM() != 0) {
                    setUnk2700LPEKFJBNEJM(other.getUnk2700LPEKFJBNEJM());
                }
                if (other.getUnk2700DNLEGADDHKM()) {
                    setUnk2700DNLEGADDHKM(other.getUnk2700DNLEGADDHKM());
                }
                if (other.getUnk2700BFMNMPPNBHH() != 0) {
                    setUnk2700BFMNMPPNBHH(other.getUnk2700BFMNMPPNBHH());
                }
                if (other.getMaxScore() != 0) {
                    setMaxScore(other.getMaxScore());
                }
                if (other.getUnk2700KAMOCHAKPGP() != 0) {
                    setUnk2700KAMOCHAKPGP(other.getUnk2700KAMOCHAKPGP());
                }
                if (other.getUnk2700KLPHBLCIOEC() != 0) {
                    setUnk2700KLPHBLCIOEC(other.getUnk2700KLPHBLCIOEC());
                }
                if (other.getUnk2700CEPGMKAHHCD() != 0) {
                    setUnk2700CEPGMKAHHCD(other.getUnk2700CEPGMKAHHCD());
                }
                if (other.getUnk2700PMCPLPMJCEC() != 0) {
                    setUnk2700PMCPLPMJCEC(other.getUnk2700PMCPLPMJCEC());
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
                MusicBriefInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicBriefInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicBriefInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public long getUnk2700JNENCBCGPGO() {
                return this.unk2700JNENCBCGPGO_;
            }

            public Builder setUnk2700JNENCBCGPGO(long value) {
                this.unk2700JNENCBCGPGO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700JNENCBCGPGO() {
                this.unk2700JNENCBCGPGO_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public boolean getUnk2700OJBPHCIDAEB() {
                return this.unk2700OJBPHCIDAEB_;
            }

            public Builder setUnk2700OJBPHCIDAEB(boolean value) {
                this.unk2700OJBPHCIDAEB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700OJBPHCIDAEB() {
                this.unk2700OJBPHCIDAEB_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public boolean getUnk2700FGCJEGHOKPG() {
                return this.unk2700FGCJEGHOKPG_;
            }

            public Builder setUnk2700FGCJEGHOKPG(boolean value) {
                this.unk2700FGCJEGHOKPG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700FGCJEGHOKPG() {
                this.unk2700FGCJEGHOKPG_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700DFIBAIILJHN() {
                return this.unk2700DFIBAIILJHN_;
            }

            public Builder setUnk2700DFIBAIILJHN(int value) {
                this.unk2700DFIBAIILJHN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700DFIBAIILJHN() {
                this.unk2700DFIBAIILJHN_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700MKBNLEKMIMD() {
                return this.unk2700MKBNLEKMIMD_;
            }

            public Builder setUnk2700MKBNLEKMIMD(int value) {
                this.unk2700MKBNLEKMIMD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700MKBNLEKMIMD() {
                this.unk2700MKBNLEKMIMD_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700PINGIIAANMO() {
                return this.unk2700PINGIIAANMO_;
            }

            public Builder setUnk2700PINGIIAANMO(int value) {
                this.unk2700PINGIIAANMO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700PINGIIAANMO() {
                this.unk2700PINGIIAANMO_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public String getUnk2700MONNIDCNDFI() {
                Object ref = this.unk2700MONNIDCNDFI_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk2700MONNIDCNDFI_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public ByteString getUnk2700MONNIDCNDFIBytes() {
                Object ref = this.unk2700MONNIDCNDFI_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk2700MONNIDCNDFI_ = b;
                return b;
            }

            public Builder setUnk2700MONNIDCNDFI(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk2700MONNIDCNDFI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700MONNIDCNDFI() {
                this.unk2700MONNIDCNDFI_ = MusicBriefInfo.getDefaultInstance().getUnk2700MONNIDCNDFI();
                onChanged();
                return this;
            }

            public Builder setUnk2700MONNIDCNDFIBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                MusicBriefInfo.checkByteStringIsUtf8(value);
                this.unk2700MONNIDCNDFI_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getVersion() {
                return this.version_;
            }

            public Builder setVersion(int value) {
                this.version_ = value;
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.version_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700GGHNLPMAGME() {
                return this.unk2700GGHNLPMAGME_;
            }

            public Builder setUnk2700GGHNLPMAGME(int value) {
                this.unk2700GGHNLPMAGME_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700GGHNLPMAGME() {
                this.unk2700GGHNLPMAGME_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk2700GDCGOMNBMEOIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk2700GDCGOMNBMEO_ = MusicBriefInfo.mutableCopy(this.unk2700GDCGOMNBMEO_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public List<Integer> getUnk2700GDCGOMNBMEOList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk2700GDCGOMNBMEO_) : this.unk2700GDCGOMNBMEO_;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700GDCGOMNBMEOCount() {
                return this.unk2700GDCGOMNBMEO_.size();
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700GDCGOMNBMEO(int index) {
                return this.unk2700GDCGOMNBMEO_.getInt(index);
            }

            public Builder setUnk2700GDCGOMNBMEO(int index, int value) {
                ensureUnk2700GDCGOMNBMEOIsMutable();
                this.unk2700GDCGOMNBMEO_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk2700GDCGOMNBMEO(int value) {
                ensureUnk2700GDCGOMNBMEOIsMutable();
                this.unk2700GDCGOMNBMEO_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk2700GDCGOMNBMEO(Iterable<? extends Integer> values) {
                ensureUnk2700GDCGOMNBMEOIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk2700GDCGOMNBMEO_);
                onChanged();
                return this;
            }

            public Builder clearUnk2700GDCGOMNBMEO() {
                this.unk2700GDCGOMNBMEO_ = MusicBriefInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk2700JAEONBMBFJJIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk2700JAEONBMBFJJ_ = MusicBriefInfo.mutableCopy(this.unk2700JAEONBMBFJJ_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public List<Integer> getUnk2700JAEONBMBFJJList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk2700JAEONBMBFJJ_) : this.unk2700JAEONBMBFJJ_;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700JAEONBMBFJJCount() {
                return this.unk2700JAEONBMBFJJ_.size();
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700JAEONBMBFJJ(int index) {
                return this.unk2700JAEONBMBFJJ_.getInt(index);
            }

            public Builder setUnk2700JAEONBMBFJJ(int index, int value) {
                ensureUnk2700JAEONBMBFJJIsMutable();
                this.unk2700JAEONBMBFJJ_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk2700JAEONBMBFJJ(int value) {
                ensureUnk2700JAEONBMBFJJIsMutable();
                this.unk2700JAEONBMBFJJ_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk2700JAEONBMBFJJ(Iterable<? extends Integer> values) {
                ensureUnk2700JAEONBMBFJJIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk2700JAEONBMBFJJ_);
                onChanged();
                return this;
            }

            public Builder clearUnk2700JAEONBMBFJJ() {
                this.unk2700JAEONBMBFJJ_ = MusicBriefInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public boolean getUnk2700GBCGGDONMCD() {
                return this.unk2700GBCGGDONMCD_;
            }

            public Builder setUnk2700GBCGGDONMCD(boolean value) {
                this.unk2700GBCGGDONMCD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700GBCGGDONMCD() {
                this.unk2700GBCGGDONMCD_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700LPEKFJBNEJM() {
                return this.unk2700LPEKFJBNEJM_;
            }

            public Builder setUnk2700LPEKFJBNEJM(int value) {
                this.unk2700LPEKFJBNEJM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700LPEKFJBNEJM() {
                this.unk2700LPEKFJBNEJM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public boolean getUnk2700DNLEGADDHKM() {
                return this.unk2700DNLEGADDHKM_;
            }

            public Builder setUnk2700DNLEGADDHKM(boolean value) {
                this.unk2700DNLEGADDHKM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700DNLEGADDHKM() {
                this.unk2700DNLEGADDHKM_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700BFMNMPPNBHH() {
                return this.unk2700BFMNMPPNBHH_;
            }

            public Builder setUnk2700BFMNMPPNBHH(int value) {
                this.unk2700BFMNMPPNBHH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700BFMNMPPNBHH() {
                this.unk2700BFMNMPPNBHH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700KAMOCHAKPGP() {
                return this.unk2700KAMOCHAKPGP_;
            }

            public Builder setUnk2700KAMOCHAKPGP(int value) {
                this.unk2700KAMOCHAKPGP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700KAMOCHAKPGP() {
                this.unk2700KAMOCHAKPGP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700KLPHBLCIOEC() {
                return this.unk2700KLPHBLCIOEC_;
            }

            public Builder setUnk2700KLPHBLCIOEC(int value) {
                this.unk2700KLPHBLCIOEC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700KLPHBLCIOEC() {
                this.unk2700KLPHBLCIOEC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public long getUnk2700CEPGMKAHHCD() {
                return this.unk2700CEPGMKAHHCD_;
            }

            public Builder setUnk2700CEPGMKAHHCD(long value) {
                this.unk2700CEPGMKAHHCD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700CEPGMKAHHCD() {
                this.unk2700CEPGMKAHHCD_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder
            public int getUnk2700PMCPLPMJCEC() {
                return this.unk2700PMCPLPMJCEC_;
            }

            public Builder setUnk2700PMCPLPMJCEC(int value) {
                this.unk2700PMCPLPMJCEC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700PMCPLPMJCEC() {
                this.unk2700PMCPLPMJCEC_ = 0;
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

        public static MusicBriefInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicBriefInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicBriefInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicBriefInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
