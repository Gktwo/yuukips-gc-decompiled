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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.MusicBeatmapOuterClass;
import emu.grasscutter.net.proto.MusicBriefInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameGetBeatmapReqTypeOuterClass;
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapRspOuterClass.class */
public final class MusicGameGetBeatmapRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cMusicGameGetBeatmapRsp.proto\u001a MusicGameGetBeatmapReqType.proto\u001a\u0012MusicBeatmap.proto\u001a\u0014MusicBriefInfo.proto\u001a\u001bMusicGameUnknown1Enum.proto\"\u0002\n\u0016MusicGameGetBeatmapRsp\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005\u0012-\n\runknown_enum1\u0018\u0001 \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012\u0016\n\u000emusic_share_id\u0018\u0005 \u0001(\u0004\u0012-\n\breq_type\u0018\u0002 \u0001(\u000e2\u001b.MusicGameGetBeatmapReqType\u0012%\n\fmusic_record\u0018\t \u0001(\u000b2\r.MusicBeatmapH��\u0012,\n\u0010music_brief_info\u0018¹\u0007 \u0001(\u000b2\u000f.MusicBriefInfoH\u0001B\t\n\u0007beatmapB\f\n\nbrief_infoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicGameGetBeatmapReqTypeOuterClass.getDescriptor(), MusicBeatmapOuterClass.getDescriptor(), MusicBriefInfoOuterClass.getDescriptor(), MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameGetBeatmapRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameGetBeatmapRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameGetBeatmapRsp_descriptor, new String[]{"Retcode", "UnknownEnum1", "MusicShareId", "ReqType", "MusicRecord", "MusicBriefInfo", "Beatmap", "BriefInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapRspOuterClass$MusicGameGetBeatmapRspOrBuilder.class */
    public interface MusicGameGetBeatmapRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        long getMusicShareId();

        int getReqTypeValue();

        MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType getReqType();

        boolean hasMusicRecord();

        MusicBeatmapOuterClass.MusicBeatmap getMusicRecord();

        MusicBeatmapOuterClass.MusicBeatmapOrBuilder getMusicRecordOrBuilder();

        boolean hasMusicBriefInfo();

        MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo();

        MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder();

        MusicGameGetBeatmapRsp.BeatmapCase getBeatmapCase();

        MusicGameGetBeatmapRsp.BriefInfoCase getBriefInfoCase();
    }

    private MusicGameGetBeatmapRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapRspOuterClass$MusicGameGetBeatmapRsp.class */
    public static final class MusicGameGetBeatmapRsp extends GeneratedMessageV3 implements MusicGameGetBeatmapRspOrBuilder {
        private static final long serialVersionUID = 0;
        private int beatmapCase_;
        private Object beatmap_;
        private int briefInfoCase_;
        private Object briefInfo_;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 1;
        private int unknownEnum1_;
        public static final int MUSIC_SHARE_ID_FIELD_NUMBER = 5;
        private long musicShareId_;
        public static final int REQ_TYPE_FIELD_NUMBER = 2;
        private int reqType_;
        public static final int MUSIC_RECORD_FIELD_NUMBER = 9;
        public static final int MUSIC_BRIEF_INFO_FIELD_NUMBER = 953;
        private byte memoizedIsInitialized;
        private static final MusicGameGetBeatmapRsp DEFAULT_INSTANCE = new MusicGameGetBeatmapRsp();
        private static final Parser<MusicGameGetBeatmapRsp> PARSER = new AbstractParser<MusicGameGetBeatmapRsp>() { // from class: emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRsp.1
            @Override // com.google.protobuf.Parser
            public MusicGameGetBeatmapRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameGetBeatmapRsp(input, extensionRegistry);
            }
        };

        private MusicGameGetBeatmapRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.beatmapCase_ = 0;
            this.briefInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private MusicGameGetBeatmapRsp() {
            this.beatmapCase_ = 0;
            this.briefInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
            this.reqType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameGetBeatmapRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameGetBeatmapRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.unknownEnum1_ = input.readEnum();
                                break;
                            case 16:
                                this.reqType_ = input.readEnum();
                                break;
                            case 40:
                                this.musicShareId_ = input.readUInt64();
                                break;
                            case 74:
                                MusicBeatmapOuterClass.MusicBeatmap.Builder subBuilder = this.beatmapCase_ == 9 ? ((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_).toBuilder() : null;
                                this.beatmap_ = input.readMessage(MusicBeatmapOuterClass.MusicBeatmap.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_);
                                    this.beatmap_ = subBuilder.buildPartial();
                                }
                                this.beatmapCase_ = 9;
                                break;
                            case 104:
                                this.retcode_ = input.readInt32();
                                break;
                            case 7626:
                                MusicBriefInfoOuterClass.MusicBriefInfo.Builder subBuilder2 = this.briefInfoCase_ == 953 ? ((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_).toBuilder() : null;
                                this.briefInfo_ = input.readMessage(MusicBriefInfoOuterClass.MusicBriefInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_);
                                    this.briefInfo_ = subBuilder2.buildPartial();
                                }
                                this.briefInfoCase_ = 953;
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicGameGetBeatmapRspOuterClass.internal_static_MusicGameGetBeatmapRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameGetBeatmapRspOuterClass.internal_static_MusicGameGetBeatmapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameGetBeatmapRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapRspOuterClass$MusicGameGetBeatmapRsp$BeatmapCase.class */
        public enum BeatmapCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_RECORD(9),
            BEATMAP_NOT_SET(0);
            
            private final int value;

            BeatmapCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static BeatmapCase valueOf(int value) {
                return forNumber(value);
            }

            public static BeatmapCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return BEATMAP_NOT_SET;
                    case 9:
                        return MUSIC_RECORD;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public BeatmapCase getBeatmapCase() {
            return BeatmapCase.forNumber(this.beatmapCase_);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapRspOuterClass$MusicGameGetBeatmapRsp$BriefInfoCase.class */
        public enum BriefInfoCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_BRIEF_INFO(953),
            BRIEFINFO_NOT_SET(0);
            
            private final int value;

            BriefInfoCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static BriefInfoCase valueOf(int value) {
                return forNumber(value);
            }

            public static BriefInfoCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return BRIEFINFO_NOT_SET;
                    case 953:
                        return MUSIC_BRIEF_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public BriefInfoCase getBriefInfoCase() {
            return BriefInfoCase.forNumber(this.briefInfoCase_);
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public long getMusicShareId() {
            return this.musicShareId_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public int getReqTypeValue() {
            return this.reqType_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType getReqType() {
            MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType result = MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.valueOf(this.reqType_);
            return result == null ? MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public boolean hasMusicRecord() {
            return this.beatmapCase_ == 9;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public MusicBeatmapOuterClass.MusicBeatmap getMusicRecord() {
            if (this.beatmapCase_ == 9) {
                return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
            }
            return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public MusicBeatmapOuterClass.MusicBeatmapOrBuilder getMusicRecordOrBuilder() {
            if (this.beatmapCase_ == 9) {
                return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
            }
            return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public boolean hasMusicBriefInfo() {
            return this.briefInfoCase_ == 953;
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo() {
            if (this.briefInfoCase_ == 953) {
                return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
            }
            return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
        public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
            if (this.briefInfoCase_ == 953) {
                return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
            }
            return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
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
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                output.writeEnum(1, this.unknownEnum1_);
            }
            if (this.reqType_ != MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.MusicGameGetBeatmapReqType_u1.getNumber()) {
                output.writeEnum(2, this.reqType_);
            }
            if (this.musicShareId_ != 0) {
                output.writeUInt64(5, this.musicShareId_);
            }
            if (this.beatmapCase_ == 9) {
                output.writeMessage(9, (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
            }
            if (this.briefInfoCase_ == 953) {
                output.writeMessage(953, (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_);
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
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(1, this.unknownEnum1_);
            }
            if (this.reqType_ != MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.MusicGameGetBeatmapReqType_u1.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.reqType_);
            }
            if (this.musicShareId_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(5, this.musicShareId_);
            }
            if (this.beatmapCase_ == 9) {
                size2 += CodedOutputStream.computeMessageSize(9, (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(13, this.retcode_);
            }
            if (this.briefInfoCase_ == 953) {
                size2 += CodedOutputStream.computeMessageSize(953, (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_);
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
            if (!(obj instanceof MusicGameGetBeatmapRsp)) {
                return equals(obj);
            }
            MusicGameGetBeatmapRsp other = (MusicGameGetBeatmapRsp) obj;
            if (getRetcode() != other.getRetcode() || this.unknownEnum1_ != other.unknownEnum1_ || getMusicShareId() != other.getMusicShareId() || this.reqType_ != other.reqType_ || !getBeatmapCase().equals(other.getBeatmapCase())) {
                return false;
            }
            switch (this.beatmapCase_) {
                case 9:
                    if (!getMusicRecord().equals(other.getMusicRecord())) {
                        return false;
                    }
                    break;
            }
            if (!getBriefInfoCase().equals(other.getBriefInfoCase())) {
                return false;
            }
            switch (this.briefInfoCase_) {
                case 953:
                    if (!getMusicBriefInfo().equals(other.getMusicBriefInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getRetcode())) + 1)) + this.unknownEnum1_)) + 5)) + Internal.hashLong(getMusicShareId()))) + 2)) + this.reqType_;
            switch (this.beatmapCase_) {
                case 9:
                    hash = (53 * ((37 * hash) + 9)) + getMusicRecord().hashCode();
                    break;
            }
            switch (this.briefInfoCase_) {
                case 953:
                    hash = (53 * ((37 * hash) + 953)) + getMusicBriefInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicGameGetBeatmapRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameGetBeatmapRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameGetBeatmapRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameGetBeatmapRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameGetBeatmapRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameGetBeatmapRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameGetBeatmapRsp parseFrom(InputStream input) throws IOException {
            return (MusicGameGetBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameGetBeatmapRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameGetBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameGetBeatmapRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameGetBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameGetBeatmapRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameGetBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameGetBeatmapRsp parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameGetBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameGetBeatmapRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameGetBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameGetBeatmapRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapRspOuterClass$MusicGameGetBeatmapRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameGetBeatmapRspOrBuilder {
            private Object beatmap_;
            private Object briefInfo_;
            private int retcode_;
            private long musicShareId_;
            private SingleFieldBuilderV3<MusicBeatmapOuterClass.MusicBeatmap, MusicBeatmapOuterClass.MusicBeatmap.Builder, MusicBeatmapOuterClass.MusicBeatmapOrBuilder> musicRecordBuilder_;
            private SingleFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> musicBriefInfoBuilder_;
            private int beatmapCase_ = 0;
            private int briefInfoCase_ = 0;
            private int unknownEnum1_ = 0;
            private int reqType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameGetBeatmapRspOuterClass.internal_static_MusicGameGetBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameGetBeatmapRspOuterClass.internal_static_MusicGameGetBeatmapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameGetBeatmapRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameGetBeatmapRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.unknownEnum1_ = 0;
                this.musicShareId_ = 0;
                this.reqType_ = 0;
                this.beatmapCase_ = 0;
                this.beatmap_ = null;
                this.briefInfoCase_ = 0;
                this.briefInfo_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameGetBeatmapRspOuterClass.internal_static_MusicGameGetBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameGetBeatmapRsp getDefaultInstanceForType() {
                return MusicGameGetBeatmapRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameGetBeatmapRsp build() {
                MusicGameGetBeatmapRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameGetBeatmapRsp buildPartial() {
                MusicGameGetBeatmapRsp result = new MusicGameGetBeatmapRsp(this);
                result.retcode_ = this.retcode_;
                result.unknownEnum1_ = this.unknownEnum1_;
                result.musicShareId_ = this.musicShareId_;
                result.reqType_ = this.reqType_;
                if (this.beatmapCase_ == 9) {
                    if (this.musicRecordBuilder_ == null) {
                        result.beatmap_ = this.beatmap_;
                    } else {
                        result.beatmap_ = this.musicRecordBuilder_.build();
                    }
                }
                if (this.briefInfoCase_ == 953) {
                    if (this.musicBriefInfoBuilder_ == null) {
                        result.briefInfo_ = this.briefInfo_;
                    } else {
                        result.briefInfo_ = this.musicBriefInfoBuilder_.build();
                    }
                }
                result.beatmapCase_ = this.beatmapCase_;
                result.briefInfoCase_ = this.briefInfoCase_;
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
                if (other instanceof MusicGameGetBeatmapRsp) {
                    return mergeFrom((MusicGameGetBeatmapRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameGetBeatmapRsp other) {
                if (other == MusicGameGetBeatmapRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.unknownEnum1_ != 0) {
                    setUnknownEnum1Value(other.getUnknownEnum1Value());
                }
                if (other.getMusicShareId() != 0) {
                    setMusicShareId(other.getMusicShareId());
                }
                if (other.reqType_ != 0) {
                    setReqTypeValue(other.getReqTypeValue());
                }
                switch (other.getBeatmapCase()) {
                    case MUSIC_RECORD:
                        mergeMusicRecord(other.getMusicRecord());
                        break;
                }
                switch (other.getBriefInfoCase()) {
                    case MUSIC_BRIEF_INFO:
                        mergeMusicBriefInfo(other.getMusicBriefInfo());
                        break;
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
                MusicGameGetBeatmapRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameGetBeatmapRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameGetBeatmapRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public BeatmapCase getBeatmapCase() {
                return BeatmapCase.forNumber(this.beatmapCase_);
            }

            public Builder clearBeatmap() {
                this.beatmapCase_ = 0;
                this.beatmap_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public BriefInfoCase getBriefInfoCase() {
                return BriefInfoCase.forNumber(this.briefInfoCase_);
            }

            public Builder clearBriefInfo() {
                this.briefInfoCase_ = 0;
                this.briefInfo_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
                MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
                return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
            }

            public Builder setUnknownEnum1(MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unknownEnum1_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUnknownEnum1() {
                this.unknownEnum1_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public long getMusicShareId() {
                return this.musicShareId_;
            }

            public Builder setMusicShareId(long value) {
                this.musicShareId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicShareId() {
                this.musicShareId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public int getReqTypeValue() {
                return this.reqType_;
            }

            public Builder setReqTypeValue(int value) {
                this.reqType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType getReqType() {
                MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType result = MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.valueOf(this.reqType_);
                return result == null ? MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.UNRECOGNIZED : result;
            }

            public Builder setReqType(MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.reqType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearReqType() {
                this.reqType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public boolean hasMusicRecord() {
                return this.beatmapCase_ == 9;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public MusicBeatmapOuterClass.MusicBeatmap getMusicRecord() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.beatmapCase_ == 9) {
                        return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
                    }
                    return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
                } else if (this.beatmapCase_ == 9) {
                    return this.musicRecordBuilder_.getMessage();
                } else {
                    return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
                }
            }

            public Builder setMusicRecord(MusicBeatmapOuterClass.MusicBeatmap value) {
                if (this.musicRecordBuilder_ != null) {
                    this.musicRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.beatmap_ = value;
                    onChanged();
                }
                this.beatmapCase_ = 9;
                return this;
            }

            public Builder setMusicRecord(MusicBeatmapOuterClass.MusicBeatmap.Builder builderForValue) {
                if (this.musicRecordBuilder_ == null) {
                    this.beatmap_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicRecordBuilder_.setMessage(builderForValue.build());
                }
                this.beatmapCase_ = 9;
                return this;
            }

            public Builder mergeMusicRecord(MusicBeatmapOuterClass.MusicBeatmap value) {
                if (this.musicRecordBuilder_ == null) {
                    if (this.beatmapCase_ != 9 || this.beatmap_ == MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance()) {
                        this.beatmap_ = value;
                    } else {
                        this.beatmap_ = MusicBeatmapOuterClass.MusicBeatmap.newBuilder((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.beatmapCase_ == 9) {
                        this.musicRecordBuilder_.mergeFrom(value);
                    }
                    this.musicRecordBuilder_.setMessage(value);
                }
                this.beatmapCase_ = 9;
                return this;
            }

            public Builder clearMusicRecord() {
                if (this.musicRecordBuilder_ != null) {
                    if (this.beatmapCase_ == 9) {
                        this.beatmapCase_ = 0;
                        this.beatmap_ = null;
                    }
                    this.musicRecordBuilder_.clear();
                } else if (this.beatmapCase_ == 9) {
                    this.beatmapCase_ = 0;
                    this.beatmap_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicBeatmapOuterClass.MusicBeatmap.Builder getMusicRecordBuilder() {
                return getMusicRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public MusicBeatmapOuterClass.MusicBeatmapOrBuilder getMusicRecordOrBuilder() {
                if (this.beatmapCase_ == 9 && this.musicRecordBuilder_ != null) {
                    return this.musicRecordBuilder_.getMessageOrBuilder();
                }
                if (this.beatmapCase_ == 9) {
                    return (MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_;
                }
                return MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicBeatmapOuterClass.MusicBeatmap, MusicBeatmapOuterClass.MusicBeatmap.Builder, MusicBeatmapOuterClass.MusicBeatmapOrBuilder> getMusicRecordFieldBuilder() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.beatmapCase_ != 9) {
                        this.beatmap_ = MusicBeatmapOuterClass.MusicBeatmap.getDefaultInstance();
                    }
                    this.musicRecordBuilder_ = new SingleFieldBuilderV3<>((MusicBeatmapOuterClass.MusicBeatmap) this.beatmap_, getParentForChildren(), isClean());
                    this.beatmap_ = null;
                }
                this.beatmapCase_ = 9;
                onChanged();
                return this.musicRecordBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public boolean hasMusicBriefInfo() {
                return this.briefInfoCase_ == 953;
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfo getMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefInfoCase_ == 953) {
                        return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
                    }
                    return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                } else if (this.briefInfoCase_ == 953) {
                    return this.musicBriefInfoBuilder_.getMessage();
                } else {
                    return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                }
            }

            public Builder setMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ != null) {
                    this.musicBriefInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.briefInfo_ = value;
                    onChanged();
                }
                this.briefInfoCase_ = 953;
                return this;
            }

            public Builder setMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo.Builder builderForValue) {
                if (this.musicBriefInfoBuilder_ == null) {
                    this.briefInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicBriefInfoBuilder_.setMessage(builderForValue.build());
                }
                this.briefInfoCase_ = 953;
                return this;
            }

            public Builder mergeMusicBriefInfo(MusicBriefInfoOuterClass.MusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefInfoCase_ != 953 || this.briefInfo_ == MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance()) {
                        this.briefInfo_ = value;
                    } else {
                        this.briefInfo_ = MusicBriefInfoOuterClass.MusicBriefInfo.newBuilder((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.briefInfoCase_ == 953) {
                        this.musicBriefInfoBuilder_.mergeFrom(value);
                    }
                    this.musicBriefInfoBuilder_.setMessage(value);
                }
                this.briefInfoCase_ = 953;
                return this;
            }

            public Builder clearMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ != null) {
                    if (this.briefInfoCase_ == 953) {
                        this.briefInfoCase_ = 0;
                        this.briefInfo_ = null;
                    }
                    this.musicBriefInfoBuilder_.clear();
                } else if (this.briefInfoCase_ == 953) {
                    this.briefInfoCase_ = 0;
                    this.briefInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicBriefInfoOuterClass.MusicBriefInfo.Builder getMusicBriefInfoBuilder() {
                return getMusicBriefInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MusicGameGetBeatmapRspOuterClass.MusicGameGetBeatmapRspOrBuilder
            public MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
                if (this.briefInfoCase_ == 953 && this.musicBriefInfoBuilder_ != null) {
                    return this.musicBriefInfoBuilder_.getMessageOrBuilder();
                }
                if (this.briefInfoCase_ == 953) {
                    return (MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_;
                }
                return MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicBriefInfoOuterClass.MusicBriefInfo, MusicBriefInfoOuterClass.MusicBriefInfo.Builder, MusicBriefInfoOuterClass.MusicBriefInfoOrBuilder> getMusicBriefInfoFieldBuilder() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefInfoCase_ != 953) {
                        this.briefInfo_ = MusicBriefInfoOuterClass.MusicBriefInfo.getDefaultInstance();
                    }
                    this.musicBriefInfoBuilder_ = new SingleFieldBuilderV3<>((MusicBriefInfoOuterClass.MusicBriefInfo) this.briefInfo_, getParentForChildren(), isClean());
                    this.briefInfo_ = null;
                }
                this.briefInfoCase_ = 953;
                onChanged();
                return this.musicBriefInfoBuilder_;
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

        public static MusicGameGetBeatmapRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameGetBeatmapRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameGetBeatmapRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameGetBeatmapRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicGameGetBeatmapReqTypeOuterClass.getDescriptor();
        MusicBeatmapOuterClass.getDescriptor();
        MusicBriefInfoOuterClass.getDescriptor();
        MusicGameUnknown1EnumOuterClass.getDescriptor();
    }
}
