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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicBriefInfoOuterClass.class */
public final class UgcMusicBriefInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017UgcMusicBriefInfo.proto\" \u0004\n\u0011UgcMusicBriefInfo\u0012\u000f\n\u0007ugcGuid\u0018\b \u0001(\u0004\u0012\u001b\n\u0013Unk3300_CCMMPAHIMDO\u0018X \u0001(\r\u0012\u001b\n\u0013Unk3300_PLNOFOHFAPE\u0018\u000f \u0001(\r\u0012\u001c\n\u0013Unk3300_HKBHAIMOBKO\u0018Ó\n \u0003(\r\u0012\u001b\n\u0013Unk3300_FKIGPAJFPLG\u0018\u0005 \u0001(\b\u0012\u0019\n\u0011importFromUgcGuid\u0018\u0006 \u0001(\u0004\u0012\u000f\n\u0007musicId\u0018\u000e \u0001(\r\u0012\u001c\n\u0013Unk3300_JEEBFPFEHHG\u0018¦\b \u0003(\r\u0012\u001c\n\u0013Unk3300_MBKDGBNFPOA\u0018­\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_OJOKFBJALIJ\u0018\u0007 \u0001(\r\u0012\u001c\n\u0013Unk3300_EGIGIOOKBAB\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013Unk3300_OBBMCFADNIN\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013Unk3300_PBENMAHHGIL\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_NCDKCNOLGKB\u0018\u0004 \u0001(\b\u0012\u000f\n\u0007version\u0018\u0001 \u0001(\r\u0012\u0017\n\u000fcreatorNickname\u0018\u0003 \u0001(\t\u0012\u001b\n\u0013Unk3300_GDNAPNAINBA\u0018\u000b \u0001(\b\u0012\u0010\n\bmaxScore\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_KMMBLIMKJCM\u0018\n \u0001(\r\u0012\u0015\n\risPsnPlatform\u0018\r \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UgcMusicBriefInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UgcMusicBriefInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UgcMusicBriefInfo_descriptor, new String[]{"UgcGuid", "Unk3300CCMMPAHIMDO", "Unk3300PLNOFOHFAPE", "Unk3300HKBHAIMOBKO", "Unk3300FKIGPAJFPLG", "ImportFromUgcGuid", "MusicId", "Unk3300JEEBFPFEHHG", "Unk3300MBKDGBNFPOA", "Unk3300OJOKFBJALIJ", "Unk3300EGIGIOOKBAB", "Unk3300OBBMCFADNIN", "Unk3300PBENMAHHGIL", "Unk3300NCDKCNOLGKB", "Version", "CreatorNickname", "Unk3300GDNAPNAINBA", "MaxScore", "Unk3300KMMBLIMKJCM", "IsPsnPlatform"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicBriefInfoOuterClass$UgcMusicBriefInfoOrBuilder.class */
    public interface UgcMusicBriefInfoOrBuilder extends MessageOrBuilder {
        long getUgcGuid();

        int getUnk3300CCMMPAHIMDO();

        int getUnk3300PLNOFOHFAPE();

        List<Integer> getUnk3300HKBHAIMOBKOList();

        int getUnk3300HKBHAIMOBKOCount();

        int getUnk3300HKBHAIMOBKO(int i);

        boolean getUnk3300FKIGPAJFPLG();

        long getImportFromUgcGuid();

        int getMusicId();

        List<Integer> getUnk3300JEEBFPFEHHGList();

        int getUnk3300JEEBFPFEHHGCount();

        int getUnk3300JEEBFPFEHHG(int i);

        int getUnk3300MBKDGBNFPOA();

        int getUnk3300OJOKFBJALIJ();

        int getUnk3300EGIGIOOKBAB();

        int getUnk3300OBBMCFADNIN();

        int getUnk3300PBENMAHHGIL();

        boolean getUnk3300NCDKCNOLGKB();

        int getVersion();

        String getCreatorNickname();

        ByteString getCreatorNicknameBytes();

        boolean getUnk3300GDNAPNAINBA();

        int getMaxScore();

        int getUnk3300KMMBLIMKJCM();

        boolean getIsPsnPlatform();
    }

    private UgcMusicBriefInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicBriefInfoOuterClass$UgcMusicBriefInfo.class */
    public static final class UgcMusicBriefInfo extends GeneratedMessageV3 implements UgcMusicBriefInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UGCGUID_FIELD_NUMBER = 8;
        private long ugcGuid_;
        public static final int UNK3300_CCMMPAHIMDO_FIELD_NUMBER = 88;
        private int unk3300CCMMPAHIMDO_;
        public static final int UNK3300_PLNOFOHFAPE_FIELD_NUMBER = 15;
        private int unk3300PLNOFOHFAPE_;
        public static final int UNK3300_HKBHAIMOBKO_FIELD_NUMBER = 1363;
        private Internal.IntList unk3300HKBHAIMOBKO_;
        private int unk3300HKBHAIMOBKOMemoizedSerializedSize;
        public static final int UNK3300_FKIGPAJFPLG_FIELD_NUMBER = 5;
        private boolean unk3300FKIGPAJFPLG_;
        public static final int IMPORTFROMUGCGUID_FIELD_NUMBER = 6;
        private long importFromUgcGuid_;
        public static final int MUSICID_FIELD_NUMBER = 14;
        private int musicId_;
        public static final int UNK3300_JEEBFPFEHHG_FIELD_NUMBER = 1062;
        private Internal.IntList unk3300JEEBFPFEHHG_;
        private int unk3300JEEBFPFEHHGMemoizedSerializedSize;
        public static final int UNK3300_MBKDGBNFPOA_FIELD_NUMBER = 1837;
        private int unk3300MBKDGBNFPOA_;
        public static final int UNK3300_OJOKFBJALIJ_FIELD_NUMBER = 7;
        private int unk3300OJOKFBJALIJ_;
        public static final int UNK3300_EGIGIOOKBAB_FIELD_NUMBER = 287;
        private int unk3300EGIGIOOKBAB_;
        public static final int UNK3300_OBBMCFADNIN_FIELD_NUMBER = 2;
        private int unk3300OBBMCFADNIN_;
        public static final int UNK3300_PBENMAHHGIL_FIELD_NUMBER = 9;
        private int unk3300PBENMAHHGIL_;
        public static final int UNK3300_NCDKCNOLGKB_FIELD_NUMBER = 4;
        private boolean unk3300NCDKCNOLGKB_;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int version_;
        public static final int CREATORNICKNAME_FIELD_NUMBER = 3;
        private volatile Object creatorNickname_;
        public static final int UNK3300_GDNAPNAINBA_FIELD_NUMBER = 11;
        private boolean unk3300GDNAPNAINBA_;
        public static final int MAXSCORE_FIELD_NUMBER = 12;
        private int maxScore_;
        public static final int UNK3300_KMMBLIMKJCM_FIELD_NUMBER = 10;
        private int unk3300KMMBLIMKJCM_;
        public static final int ISPSNPLATFORM_FIELD_NUMBER = 13;
        private boolean isPsnPlatform_;
        private byte memoizedIsInitialized;
        private static final UgcMusicBriefInfo DEFAULT_INSTANCE = new UgcMusicBriefInfo();
        private static final Parser<UgcMusicBriefInfo> PARSER = new AbstractParser<UgcMusicBriefInfo>() { // from class: emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.1
            @Override // com.google.protobuf.Parser
            public UgcMusicBriefInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UgcMusicBriefInfo(input, extensionRegistry);
            }
        };

        private UgcMusicBriefInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300HKBHAIMOBKOMemoizedSerializedSize = -1;
            this.unk3300JEEBFPFEHHGMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private UgcMusicBriefInfo() {
            this.unk3300HKBHAIMOBKOMemoizedSerializedSize = -1;
            this.unk3300JEEBFPFEHHGMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300HKBHAIMOBKO_ = emptyIntList();
            this.unk3300JEEBFPFEHHG_ = emptyIntList();
            this.creatorNickname_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UgcMusicBriefInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0296 */
        private UgcMusicBriefInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.version_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.unk3300OBBMCFADNIN_ = input.readUInt32();
                                    break;
                                case 26:
                                    this.creatorNickname_ = input.readStringRequireUtf8();
                                    break;
                                case 32:
                                    this.unk3300NCDKCNOLGKB_ = input.readBool();
                                    break;
                                case 40:
                                    this.unk3300FKIGPAJFPLG_ = input.readBool();
                                    break;
                                case 48:
                                    this.importFromUgcGuid_ = input.readUInt64();
                                    break;
                                case 56:
                                    this.unk3300OJOKFBJALIJ_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.ugcGuid_ = input.readUInt64();
                                    break;
                                case 72:
                                    this.unk3300PBENMAHHGIL_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.unk3300KMMBLIMKJCM_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.unk3300GDNAPNAINBA_ = input.readBool();
                                    break;
                                case 96:
                                    this.maxScore_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isPsnPlatform_ = input.readBool();
                                    break;
                                case 112:
                                    this.musicId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.unk3300PLNOFOHFAPE_ = input.readUInt32();
                                    break;
                                case RET_GOODS_BUY_NUM_NOT_ENOUGH_VALUE:
                                    this.unk3300CCMMPAHIMDO_ = input.readUInt32();
                                    break;
                                case 2296:
                                    this.unk3300EGIGIOOKBAB_ = input.readUInt32();
                                    break;
                                case 8496:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.unk3300JEEBFPFEHHG_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.unk3300JEEBFPFEHHG_.addInt(input.readUInt32());
                                    break;
                                case 8498:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300JEEBFPFEHHG_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300JEEBFPFEHHG_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 10904:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk3300HKBHAIMOBKO_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unk3300HKBHAIMOBKO_.addInt(input.readUInt32());
                                    break;
                                case 10906:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300HKBHAIMOBKO_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300HKBHAIMOBKO_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 14696:
                                    this.unk3300MBKDGBNFPOA_ = input.readUInt32();
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
                    this.unk3300JEEBFPFEHHG_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300HKBHAIMOBKO_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UgcMusicBriefInfoOuterClass.internal_static_UgcMusicBriefInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UgcMusicBriefInfoOuterClass.internal_static_UgcMusicBriefInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcMusicBriefInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300CCMMPAHIMDO() {
            return this.unk3300CCMMPAHIMDO_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300PLNOFOHFAPE() {
            return this.unk3300PLNOFOHFAPE_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public List<Integer> getUnk3300HKBHAIMOBKOList() {
            return this.unk3300HKBHAIMOBKO_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300HKBHAIMOBKOCount() {
            return this.unk3300HKBHAIMOBKO_.size();
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300HKBHAIMOBKO(int index) {
            return this.unk3300HKBHAIMOBKO_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public boolean getUnk3300FKIGPAJFPLG() {
            return this.unk3300FKIGPAJFPLG_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public long getImportFromUgcGuid() {
            return this.importFromUgcGuid_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getMusicId() {
            return this.musicId_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public List<Integer> getUnk3300JEEBFPFEHHGList() {
            return this.unk3300JEEBFPFEHHG_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300JEEBFPFEHHGCount() {
            return this.unk3300JEEBFPFEHHG_.size();
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300JEEBFPFEHHG(int index) {
            return this.unk3300JEEBFPFEHHG_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300MBKDGBNFPOA() {
            return this.unk3300MBKDGBNFPOA_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300OJOKFBJALIJ() {
            return this.unk3300OJOKFBJALIJ_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300EGIGIOOKBAB() {
            return this.unk3300EGIGIOOKBAB_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300OBBMCFADNIN() {
            return this.unk3300OBBMCFADNIN_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300PBENMAHHGIL() {
            return this.unk3300PBENMAHHGIL_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public boolean getUnk3300NCDKCNOLGKB() {
            return this.unk3300NCDKCNOLGKB_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public String getCreatorNickname() {
            Object ref = this.creatorNickname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.creatorNickname_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public ByteString getCreatorNicknameBytes() {
            Object ref = this.creatorNickname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.creatorNickname_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public boolean getUnk3300GDNAPNAINBA() {
            return this.unk3300GDNAPNAINBA_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getMaxScore() {
            return this.maxScore_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public int getUnk3300KMMBLIMKJCM() {
            return this.unk3300KMMBLIMKJCM_;
        }

        @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
        public boolean getIsPsnPlatform() {
            return this.isPsnPlatform_;
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
            if (this.version_ != 0) {
                output.writeUInt32(1, this.version_);
            }
            if (this.unk3300OBBMCFADNIN_ != 0) {
                output.writeUInt32(2, this.unk3300OBBMCFADNIN_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.creatorNickname_)) {
                GeneratedMessageV3.writeString(output, 3, this.creatorNickname_);
            }
            if (this.unk3300NCDKCNOLGKB_) {
                output.writeBool(4, this.unk3300NCDKCNOLGKB_);
            }
            if (this.unk3300FKIGPAJFPLG_) {
                output.writeBool(5, this.unk3300FKIGPAJFPLG_);
            }
            if (this.importFromUgcGuid_ != 0) {
                output.writeUInt64(6, this.importFromUgcGuid_);
            }
            if (this.unk3300OJOKFBJALIJ_ != 0) {
                output.writeUInt32(7, this.unk3300OJOKFBJALIJ_);
            }
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(8, this.ugcGuid_);
            }
            if (this.unk3300PBENMAHHGIL_ != 0) {
                output.writeUInt32(9, this.unk3300PBENMAHHGIL_);
            }
            if (this.unk3300KMMBLIMKJCM_ != 0) {
                output.writeUInt32(10, this.unk3300KMMBLIMKJCM_);
            }
            if (this.unk3300GDNAPNAINBA_) {
                output.writeBool(11, this.unk3300GDNAPNAINBA_);
            }
            if (this.maxScore_ != 0) {
                output.writeUInt32(12, this.maxScore_);
            }
            if (this.isPsnPlatform_) {
                output.writeBool(13, this.isPsnPlatform_);
            }
            if (this.musicId_ != 0) {
                output.writeUInt32(14, this.musicId_);
            }
            if (this.unk3300PLNOFOHFAPE_ != 0) {
                output.writeUInt32(15, this.unk3300PLNOFOHFAPE_);
            }
            if (this.unk3300CCMMPAHIMDO_ != 0) {
                output.writeUInt32(88, this.unk3300CCMMPAHIMDO_);
            }
            if (this.unk3300EGIGIOOKBAB_ != 0) {
                output.writeUInt32(287, this.unk3300EGIGIOOKBAB_);
            }
            if (getUnk3300JEEBFPFEHHGList().size() > 0) {
                output.writeUInt32NoTag(8498);
                output.writeUInt32NoTag(this.unk3300JEEBFPFEHHGMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300JEEBFPFEHHG_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300JEEBFPFEHHG_.getInt(i));
            }
            if (getUnk3300HKBHAIMOBKOList().size() > 0) {
                output.writeUInt32NoTag(10906);
                output.writeUInt32NoTag(this.unk3300HKBHAIMOBKOMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300HKBHAIMOBKO_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300HKBHAIMOBKO_.getInt(i2));
            }
            if (this.unk3300MBKDGBNFPOA_ != 0) {
                output.writeUInt32(1837, this.unk3300MBKDGBNFPOA_);
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
            if (this.version_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.version_);
            }
            if (this.unk3300OBBMCFADNIN_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.unk3300OBBMCFADNIN_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.creatorNickname_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.creatorNickname_);
            }
            if (this.unk3300NCDKCNOLGKB_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.unk3300NCDKCNOLGKB_);
            }
            if (this.unk3300FKIGPAJFPLG_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.unk3300FKIGPAJFPLG_);
            }
            if (this.importFromUgcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(6, this.importFromUgcGuid_);
            }
            if (this.unk3300OJOKFBJALIJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300OJOKFBJALIJ_);
            }
            if (this.ugcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.ugcGuid_);
            }
            if (this.unk3300PBENMAHHGIL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300PBENMAHHGIL_);
            }
            if (this.unk3300KMMBLIMKJCM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300KMMBLIMKJCM_);
            }
            if (this.unk3300GDNAPNAINBA_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.unk3300GDNAPNAINBA_);
            }
            if (this.maxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.maxScore_);
            }
            if (this.isPsnPlatform_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isPsnPlatform_);
            }
            if (this.musicId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.musicId_);
            }
            if (this.unk3300PLNOFOHFAPE_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.unk3300PLNOFOHFAPE_);
            }
            if (this.unk3300CCMMPAHIMDO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(88, this.unk3300CCMMPAHIMDO_);
            }
            if (this.unk3300EGIGIOOKBAB_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(287, this.unk3300EGIGIOOKBAB_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300JEEBFPFEHHG_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300JEEBFPFEHHG_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300JEEBFPFEHHGList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300JEEBFPFEHHGMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300HKBHAIMOBKO_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300HKBHAIMOBKO_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300HKBHAIMOBKOList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300HKBHAIMOBKOMemoizedSerializedSize = dataSize2;
            if (this.unk3300MBKDGBNFPOA_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(1837, this.unk3300MBKDGBNFPOA_);
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
            if (!(obj instanceof UgcMusicBriefInfo)) {
                return equals(obj);
            }
            UgcMusicBriefInfo other = (UgcMusicBriefInfo) obj;
            return getUgcGuid() == other.getUgcGuid() && getUnk3300CCMMPAHIMDO() == other.getUnk3300CCMMPAHIMDO() && getUnk3300PLNOFOHFAPE() == other.getUnk3300PLNOFOHFAPE() && getUnk3300HKBHAIMOBKOList().equals(other.getUnk3300HKBHAIMOBKOList()) && getUnk3300FKIGPAJFPLG() == other.getUnk3300FKIGPAJFPLG() && getImportFromUgcGuid() == other.getImportFromUgcGuid() && getMusicId() == other.getMusicId() && getUnk3300JEEBFPFEHHGList().equals(other.getUnk3300JEEBFPFEHHGList()) && getUnk3300MBKDGBNFPOA() == other.getUnk3300MBKDGBNFPOA() && getUnk3300OJOKFBJALIJ() == other.getUnk3300OJOKFBJALIJ() && getUnk3300EGIGIOOKBAB() == other.getUnk3300EGIGIOOKBAB() && getUnk3300OBBMCFADNIN() == other.getUnk3300OBBMCFADNIN() && getUnk3300PBENMAHHGIL() == other.getUnk3300PBENMAHHGIL() && getUnk3300NCDKCNOLGKB() == other.getUnk3300NCDKCNOLGKB() && getVersion() == other.getVersion() && getCreatorNickname().equals(other.getCreatorNickname()) && getUnk3300GDNAPNAINBA() == other.getUnk3300GDNAPNAINBA() && getMaxScore() == other.getMaxScore() && getUnk3300KMMBLIMKJCM() == other.getUnk3300KMMBLIMKJCM() && getIsPsnPlatform() == other.getIsPsnPlatform() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashLong(getUgcGuid()))) + 88)) + getUnk3300CCMMPAHIMDO())) + 15)) + getUnk3300PLNOFOHFAPE();
            if (getUnk3300HKBHAIMOBKOCount() > 0) {
                hash = (53 * ((37 * hash) + 1363)) + getUnk3300HKBHAIMOBKOList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + Internal.hashBoolean(getUnk3300FKIGPAJFPLG()))) + 6)) + Internal.hashLong(getImportFromUgcGuid()))) + 14)) + getMusicId();
            if (getUnk3300JEEBFPFEHHGCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1062)) + getUnk3300JEEBFPFEHHGList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 1837)) + getUnk3300MBKDGBNFPOA())) + 7)) + getUnk3300OJOKFBJALIJ())) + 287)) + getUnk3300EGIGIOOKBAB())) + 2)) + getUnk3300OBBMCFADNIN())) + 9)) + getUnk3300PBENMAHHGIL())) + 4)) + Internal.hashBoolean(getUnk3300NCDKCNOLGKB()))) + 1)) + getVersion())) + 3)) + getCreatorNickname().hashCode())) + 11)) + Internal.hashBoolean(getUnk3300GDNAPNAINBA()))) + 12)) + getMaxScore())) + 10)) + getUnk3300KMMBLIMKJCM())) + 13)) + Internal.hashBoolean(getIsPsnPlatform()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static UgcMusicBriefInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcMusicBriefInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcMusicBriefInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcMusicBriefInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcMusicBriefInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UgcMusicBriefInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UgcMusicBriefInfo parseFrom(InputStream input) throws IOException {
            return (UgcMusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcMusicBriefInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcMusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcMusicBriefInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (UgcMusicBriefInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UgcMusicBriefInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcMusicBriefInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UgcMusicBriefInfo parseFrom(CodedInputStream input) throws IOException {
            return (UgcMusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UgcMusicBriefInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UgcMusicBriefInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UgcMusicBriefInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcMusicBriefInfoOuterClass$UgcMusicBriefInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UgcMusicBriefInfoOrBuilder {
            private int bitField0_;
            private long ugcGuid_;
            private int unk3300CCMMPAHIMDO_;
            private int unk3300PLNOFOHFAPE_;
            private boolean unk3300FKIGPAJFPLG_;
            private long importFromUgcGuid_;
            private int musicId_;
            private int unk3300MBKDGBNFPOA_;
            private int unk3300OJOKFBJALIJ_;
            private int unk3300EGIGIOOKBAB_;
            private int unk3300OBBMCFADNIN_;
            private int unk3300PBENMAHHGIL_;
            private boolean unk3300NCDKCNOLGKB_;
            private int version_;
            private boolean unk3300GDNAPNAINBA_;
            private int maxScore_;
            private int unk3300KMMBLIMKJCM_;
            private boolean isPsnPlatform_;
            private Internal.IntList unk3300HKBHAIMOBKO_ = UgcMusicBriefInfo.emptyIntList();
            private Internal.IntList unk3300JEEBFPFEHHG_ = UgcMusicBriefInfo.emptyIntList();
            private Object creatorNickname_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return UgcMusicBriefInfoOuterClass.internal_static_UgcMusicBriefInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UgcMusicBriefInfoOuterClass.internal_static_UgcMusicBriefInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UgcMusicBriefInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UgcMusicBriefInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.ugcGuid_ = 0;
                this.unk3300CCMMPAHIMDO_ = 0;
                this.unk3300PLNOFOHFAPE_ = 0;
                this.unk3300HKBHAIMOBKO_ = UgcMusicBriefInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300FKIGPAJFPLG_ = false;
                this.importFromUgcGuid_ = 0;
                this.musicId_ = 0;
                this.unk3300JEEBFPFEHHG_ = UgcMusicBriefInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unk3300MBKDGBNFPOA_ = 0;
                this.unk3300OJOKFBJALIJ_ = 0;
                this.unk3300EGIGIOOKBAB_ = 0;
                this.unk3300OBBMCFADNIN_ = 0;
                this.unk3300PBENMAHHGIL_ = 0;
                this.unk3300NCDKCNOLGKB_ = false;
                this.version_ = 0;
                this.creatorNickname_ = "";
                this.unk3300GDNAPNAINBA_ = false;
                this.maxScore_ = 0;
                this.unk3300KMMBLIMKJCM_ = 0;
                this.isPsnPlatform_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UgcMusicBriefInfoOuterClass.internal_static_UgcMusicBriefInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UgcMusicBriefInfo getDefaultInstanceForType() {
                return UgcMusicBriefInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcMusicBriefInfo build() {
                UgcMusicBriefInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UgcMusicBriefInfo buildPartial() {
                UgcMusicBriefInfo result = new UgcMusicBriefInfo(this);
                int i = this.bitField0_;
                result.ugcGuid_ = this.ugcGuid_;
                result.unk3300CCMMPAHIMDO_ = this.unk3300CCMMPAHIMDO_;
                result.unk3300PLNOFOHFAPE_ = this.unk3300PLNOFOHFAPE_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300HKBHAIMOBKO_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300HKBHAIMOBKO_ = this.unk3300HKBHAIMOBKO_;
                result.unk3300FKIGPAJFPLG_ = this.unk3300FKIGPAJFPLG_;
                result.importFromUgcGuid_ = this.importFromUgcGuid_;
                result.musicId_ = this.musicId_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300JEEBFPFEHHG_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300JEEBFPFEHHG_ = this.unk3300JEEBFPFEHHG_;
                result.unk3300MBKDGBNFPOA_ = this.unk3300MBKDGBNFPOA_;
                result.unk3300OJOKFBJALIJ_ = this.unk3300OJOKFBJALIJ_;
                result.unk3300EGIGIOOKBAB_ = this.unk3300EGIGIOOKBAB_;
                result.unk3300OBBMCFADNIN_ = this.unk3300OBBMCFADNIN_;
                result.unk3300PBENMAHHGIL_ = this.unk3300PBENMAHHGIL_;
                result.unk3300NCDKCNOLGKB_ = this.unk3300NCDKCNOLGKB_;
                result.version_ = this.version_;
                result.creatorNickname_ = this.creatorNickname_;
                result.unk3300GDNAPNAINBA_ = this.unk3300GDNAPNAINBA_;
                result.maxScore_ = this.maxScore_;
                result.unk3300KMMBLIMKJCM_ = this.unk3300KMMBLIMKJCM_;
                result.isPsnPlatform_ = this.isPsnPlatform_;
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
                if (other instanceof UgcMusicBriefInfo) {
                    return mergeFrom((UgcMusicBriefInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UgcMusicBriefInfo other) {
                if (other == UgcMusicBriefInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                if (other.getUnk3300CCMMPAHIMDO() != 0) {
                    setUnk3300CCMMPAHIMDO(other.getUnk3300CCMMPAHIMDO());
                }
                if (other.getUnk3300PLNOFOHFAPE() != 0) {
                    setUnk3300PLNOFOHFAPE(other.getUnk3300PLNOFOHFAPE());
                }
                if (!other.unk3300HKBHAIMOBKO_.isEmpty()) {
                    if (this.unk3300HKBHAIMOBKO_.isEmpty()) {
                        this.unk3300HKBHAIMOBKO_ = other.unk3300HKBHAIMOBKO_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300HKBHAIMOBKOIsMutable();
                        this.unk3300HKBHAIMOBKO_.addAll(other.unk3300HKBHAIMOBKO_);
                    }
                    onChanged();
                }
                if (other.getUnk3300FKIGPAJFPLG()) {
                    setUnk3300FKIGPAJFPLG(other.getUnk3300FKIGPAJFPLG());
                }
                if (other.getImportFromUgcGuid() != 0) {
                    setImportFromUgcGuid(other.getImportFromUgcGuid());
                }
                if (other.getMusicId() != 0) {
                    setMusicId(other.getMusicId());
                }
                if (!other.unk3300JEEBFPFEHHG_.isEmpty()) {
                    if (this.unk3300JEEBFPFEHHG_.isEmpty()) {
                        this.unk3300JEEBFPFEHHG_ = other.unk3300JEEBFPFEHHG_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300JEEBFPFEHHGIsMutable();
                        this.unk3300JEEBFPFEHHG_.addAll(other.unk3300JEEBFPFEHHG_);
                    }
                    onChanged();
                }
                if (other.getUnk3300MBKDGBNFPOA() != 0) {
                    setUnk3300MBKDGBNFPOA(other.getUnk3300MBKDGBNFPOA());
                }
                if (other.getUnk3300OJOKFBJALIJ() != 0) {
                    setUnk3300OJOKFBJALIJ(other.getUnk3300OJOKFBJALIJ());
                }
                if (other.getUnk3300EGIGIOOKBAB() != 0) {
                    setUnk3300EGIGIOOKBAB(other.getUnk3300EGIGIOOKBAB());
                }
                if (other.getUnk3300OBBMCFADNIN() != 0) {
                    setUnk3300OBBMCFADNIN(other.getUnk3300OBBMCFADNIN());
                }
                if (other.getUnk3300PBENMAHHGIL() != 0) {
                    setUnk3300PBENMAHHGIL(other.getUnk3300PBENMAHHGIL());
                }
                if (other.getUnk3300NCDKCNOLGKB()) {
                    setUnk3300NCDKCNOLGKB(other.getUnk3300NCDKCNOLGKB());
                }
                if (other.getVersion() != 0) {
                    setVersion(other.getVersion());
                }
                if (!other.getCreatorNickname().isEmpty()) {
                    this.creatorNickname_ = other.creatorNickname_;
                    onChanged();
                }
                if (other.getUnk3300GDNAPNAINBA()) {
                    setUnk3300GDNAPNAINBA(other.getUnk3300GDNAPNAINBA());
                }
                if (other.getMaxScore() != 0) {
                    setMaxScore(other.getMaxScore());
                }
                if (other.getUnk3300KMMBLIMKJCM() != 0) {
                    setUnk3300KMMBLIMKJCM(other.getUnk3300KMMBLIMKJCM());
                }
                if (other.getIsPsnPlatform()) {
                    setIsPsnPlatform(other.getIsPsnPlatform());
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
                UgcMusicBriefInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = UgcMusicBriefInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UgcMusicBriefInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300CCMMPAHIMDO() {
                return this.unk3300CCMMPAHIMDO_;
            }

            public Builder setUnk3300CCMMPAHIMDO(int value) {
                this.unk3300CCMMPAHIMDO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CCMMPAHIMDO() {
                this.unk3300CCMMPAHIMDO_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300PLNOFOHFAPE() {
                return this.unk3300PLNOFOHFAPE_;
            }

            public Builder setUnk3300PLNOFOHFAPE(int value) {
                this.unk3300PLNOFOHFAPE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PLNOFOHFAPE() {
                this.unk3300PLNOFOHFAPE_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300HKBHAIMOBKOIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300HKBHAIMOBKO_ = UgcMusicBriefInfo.mutableCopy(this.unk3300HKBHAIMOBKO_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public List<Integer> getUnk3300HKBHAIMOBKOList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300HKBHAIMOBKO_) : this.unk3300HKBHAIMOBKO_;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300HKBHAIMOBKOCount() {
                return this.unk3300HKBHAIMOBKO_.size();
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300HKBHAIMOBKO(int index) {
                return this.unk3300HKBHAIMOBKO_.getInt(index);
            }

            public Builder setUnk3300HKBHAIMOBKO(int index, int value) {
                ensureUnk3300HKBHAIMOBKOIsMutable();
                this.unk3300HKBHAIMOBKO_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300HKBHAIMOBKO(int value) {
                ensureUnk3300HKBHAIMOBKOIsMutable();
                this.unk3300HKBHAIMOBKO_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300HKBHAIMOBKO(Iterable<? extends Integer> values) {
                ensureUnk3300HKBHAIMOBKOIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300HKBHAIMOBKO_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300HKBHAIMOBKO() {
                this.unk3300HKBHAIMOBKO_ = UgcMusicBriefInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public boolean getUnk3300FKIGPAJFPLG() {
                return this.unk3300FKIGPAJFPLG_;
            }

            public Builder setUnk3300FKIGPAJFPLG(boolean value) {
                this.unk3300FKIGPAJFPLG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FKIGPAJFPLG() {
                this.unk3300FKIGPAJFPLG_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public long getImportFromUgcGuid() {
                return this.importFromUgcGuid_;
            }

            public Builder setImportFromUgcGuid(long value) {
                this.importFromUgcGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearImportFromUgcGuid() {
                this.importFromUgcGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getMusicId() {
                return this.musicId_;
            }

            public Builder setMusicId(int value) {
                this.musicId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicId() {
                this.musicId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300JEEBFPFEHHGIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300JEEBFPFEHHG_ = UgcMusicBriefInfo.mutableCopy(this.unk3300JEEBFPFEHHG_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public List<Integer> getUnk3300JEEBFPFEHHGList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300JEEBFPFEHHG_) : this.unk3300JEEBFPFEHHG_;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300JEEBFPFEHHGCount() {
                return this.unk3300JEEBFPFEHHG_.size();
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300JEEBFPFEHHG(int index) {
                return this.unk3300JEEBFPFEHHG_.getInt(index);
            }

            public Builder setUnk3300JEEBFPFEHHG(int index, int value) {
                ensureUnk3300JEEBFPFEHHGIsMutable();
                this.unk3300JEEBFPFEHHG_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300JEEBFPFEHHG(int value) {
                ensureUnk3300JEEBFPFEHHGIsMutable();
                this.unk3300JEEBFPFEHHG_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300JEEBFPFEHHG(Iterable<? extends Integer> values) {
                ensureUnk3300JEEBFPFEHHGIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300JEEBFPFEHHG_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300JEEBFPFEHHG() {
                this.unk3300JEEBFPFEHHG_ = UgcMusicBriefInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300MBKDGBNFPOA() {
                return this.unk3300MBKDGBNFPOA_;
            }

            public Builder setUnk3300MBKDGBNFPOA(int value) {
                this.unk3300MBKDGBNFPOA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MBKDGBNFPOA() {
                this.unk3300MBKDGBNFPOA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300OJOKFBJALIJ() {
                return this.unk3300OJOKFBJALIJ_;
            }

            public Builder setUnk3300OJOKFBJALIJ(int value) {
                this.unk3300OJOKFBJALIJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OJOKFBJALIJ() {
                this.unk3300OJOKFBJALIJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300EGIGIOOKBAB() {
                return this.unk3300EGIGIOOKBAB_;
            }

            public Builder setUnk3300EGIGIOOKBAB(int value) {
                this.unk3300EGIGIOOKBAB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EGIGIOOKBAB() {
                this.unk3300EGIGIOOKBAB_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300OBBMCFADNIN() {
                return this.unk3300OBBMCFADNIN_;
            }

            public Builder setUnk3300OBBMCFADNIN(int value) {
                this.unk3300OBBMCFADNIN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OBBMCFADNIN() {
                this.unk3300OBBMCFADNIN_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300PBENMAHHGIL() {
                return this.unk3300PBENMAHHGIL_;
            }

            public Builder setUnk3300PBENMAHHGIL(int value) {
                this.unk3300PBENMAHHGIL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PBENMAHHGIL() {
                this.unk3300PBENMAHHGIL_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public boolean getUnk3300NCDKCNOLGKB() {
                return this.unk3300NCDKCNOLGKB_;
            }

            public Builder setUnk3300NCDKCNOLGKB(boolean value) {
                this.unk3300NCDKCNOLGKB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NCDKCNOLGKB() {
                this.unk3300NCDKCNOLGKB_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public String getCreatorNickname() {
                Object ref = this.creatorNickname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.creatorNickname_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public ByteString getCreatorNicknameBytes() {
                Object ref = this.creatorNickname_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.creatorNickname_ = b;
                return b;
            }

            public Builder setCreatorNickname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.creatorNickname_ = value;
                onChanged();
                return this;
            }

            public Builder clearCreatorNickname() {
                this.creatorNickname_ = UgcMusicBriefInfo.getDefaultInstance().getCreatorNickname();
                onChanged();
                return this;
            }

            public Builder setCreatorNicknameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                UgcMusicBriefInfo.checkByteStringIsUtf8(value);
                this.creatorNickname_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public boolean getUnk3300GDNAPNAINBA() {
                return this.unk3300GDNAPNAINBA_;
            }

            public Builder setUnk3300GDNAPNAINBA(boolean value) {
                this.unk3300GDNAPNAINBA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GDNAPNAINBA() {
                this.unk3300GDNAPNAINBA_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public int getUnk3300KMMBLIMKJCM() {
                return this.unk3300KMMBLIMKJCM_;
            }

            public Builder setUnk3300KMMBLIMKJCM(int value) {
                this.unk3300KMMBLIMKJCM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KMMBLIMKJCM() {
                this.unk3300KMMBLIMKJCM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder
            public boolean getIsPsnPlatform() {
                return this.isPsnPlatform_;
            }

            public Builder setIsPsnPlatform(boolean value) {
                this.isPsnPlatform_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsPsnPlatform() {
                this.isPsnPlatform_ = false;
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

        public static UgcMusicBriefInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UgcMusicBriefInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UgcMusicBriefInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UgcMusicBriefInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
