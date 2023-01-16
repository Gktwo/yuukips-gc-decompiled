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
import emu.grasscutter.net.proto.RecordUsageOuterClass;
import emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass;
import emu.grasscutter.net.proto.UgcMusicRecordOuterClass;
import emu.grasscutter.net.proto.UgcTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass.class */
public final class GetUgcRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fGetUgcRsp.proto\u001a\u0011RecordUsage.proto\u001a\u0017UgcMusicBriefInfo.proto\u001a\u0014UgcMusicRecord.proto\u001a\rUgcType.proto\"ß\u0001\n\tGetUgcRsp\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012&\n\u0010ugc_record_usage\u0018\u0005 \u0001(\u000e2\f.RecordUsage\u0012\u001a\n\bugc_type\u0018\u0006 \u0001(\u000e2\b.UgcType\u0012\u0010\n\bugc_guid\u0018\u0003 \u0001(\u0004\u0012'\n\fmusic_record\u0018\u0002 \u0001(\u000b2\u000f.UgcMusicRecordH��\u0012/\n\u0010music_brief_info\u0018\f \u0001(\u000b2\u0012.UgcMusicBriefInfoH\u0001B\b\n\u0006recordB\u0007\n\u0005briefB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RecordUsageOuterClass.getDescriptor(), UgcMusicBriefInfoOuterClass.getDescriptor(), UgcMusicRecordOuterClass.getDescriptor(), UgcTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetUgcRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetUgcRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetUgcRsp_descriptor, new String[]{"Retcode", "UgcRecordUsage", "UgcType", "UgcGuid", "MusicRecord", "MusicBriefInfo", "Record", "Brief"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass$GetUgcRspOrBuilder.class */
    public interface GetUgcRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getUgcRecordUsageValue();

        RecordUsageOuterClass.RecordUsage getUgcRecordUsage();

        int getUgcTypeValue();

        UgcTypeOuterClass.UgcType getUgcType();

        long getUgcGuid();

        boolean hasMusicRecord();

        UgcMusicRecordOuterClass.UgcMusicRecord getMusicRecord();

        UgcMusicRecordOuterClass.UgcMusicRecordOrBuilder getMusicRecordOrBuilder();

        boolean hasMusicBriefInfo();

        UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo getMusicBriefInfo();

        UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder();

        GetUgcRsp.RecordCase getRecordCase();

        GetUgcRsp.BriefCase getBriefCase();
    }

    private GetUgcRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass$GetUgcRsp.class */
    public static final class GetUgcRsp extends GeneratedMessageV3 implements GetUgcRspOrBuilder {
        private static final long serialVersionUID = 0;
        private int recordCase_;
        private Object record_;
        private int briefCase_;
        private Object brief_;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int UGC_RECORD_USAGE_FIELD_NUMBER = 5;
        private int ugcRecordUsage_;
        public static final int UGC_TYPE_FIELD_NUMBER = 6;
        private int ugcType_;
        public static final int UGC_GUID_FIELD_NUMBER = 3;
        private long ugcGuid_;
        public static final int MUSIC_RECORD_FIELD_NUMBER = 2;
        public static final int MUSIC_BRIEF_INFO_FIELD_NUMBER = 1540;
        private byte memoizedIsInitialized;
        private static final GetUgcRsp DEFAULT_INSTANCE = new GetUgcRsp();
        private static final Parser<GetUgcRsp> PARSER = new AbstractParser<GetUgcRsp>() { // from class: emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRsp.1
            @Override // com.google.protobuf.Parser
            public GetUgcRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetUgcRsp(input, extensionRegistry);
            }
        };

        private GetUgcRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.recordCase_ = 0;
            this.briefCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private GetUgcRsp() {
            this.recordCase_ = 0;
            this.briefCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.ugcRecordUsage_ = 0;
            this.ugcType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetUgcRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetUgcRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                UgcMusicRecordOuterClass.UgcMusicRecord.Builder subBuilder = this.recordCase_ == 2 ? ((UgcMusicRecordOuterClass.UgcMusicRecord) this.record_).toBuilder() : null;
                                this.record_ = input.readMessage(UgcMusicRecordOuterClass.UgcMusicRecord.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((UgcMusicRecordOuterClass.UgcMusicRecord) this.record_);
                                    this.record_ = subBuilder.buildPartial();
                                }
                                this.recordCase_ = 2;
                                break;
                            case 24:
                                this.ugcGuid_ = input.readUInt64();
                                break;
                            case 40:
                                this.ugcRecordUsage_ = input.readEnum();
                                break;
                            case 48:
                                this.ugcType_ = input.readEnum();
                                break;
                            case 80:
                                this.retcode_ = input.readInt32();
                                break;
                            case 12322:
                                UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder subBuilder2 = this.briefCase_ == 1540 ? ((UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_).toBuilder() : null;
                                this.brief_ = input.readMessage(UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_);
                                    this.brief_ = subBuilder2.buildPartial();
                                }
                                this.briefCase_ = MUSIC_BRIEF_INFO_FIELD_NUMBER;
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
            return GetUgcRspOuterClass.internal_static_GetUgcRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetUgcRspOuterClass.internal_static_GetUgcRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetUgcRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass$GetUgcRsp$RecordCase.class */
        public enum RecordCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_RECORD(2),
            RECORD_NOT_SET(0);
            
            private final int value;

            RecordCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static RecordCase valueOf(int value) {
                return forNumber(value);
            }

            public static RecordCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return RECORD_NOT_SET;
                    case 2:
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

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public RecordCase getRecordCase() {
            return RecordCase.forNumber(this.recordCase_);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass$GetUgcRsp$BriefCase.class */
        public enum BriefCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            MUSIC_BRIEF_INFO(GetUgcRsp.MUSIC_BRIEF_INFO_FIELD_NUMBER),
            BRIEF_NOT_SET(0);
            
            private final int value;

            BriefCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static BriefCase valueOf(int value) {
                return forNumber(value);
            }

            public static BriefCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return BRIEF_NOT_SET;
                    case GetUgcRsp.MUSIC_BRIEF_INFO_FIELD_NUMBER /* 1540 */:
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

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public BriefCase getBriefCase() {
            return BriefCase.forNumber(this.briefCase_);
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public int getUgcRecordUsageValue() {
            return this.ugcRecordUsage_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public RecordUsageOuterClass.RecordUsage getUgcRecordUsage() {
            RecordUsageOuterClass.RecordUsage result = RecordUsageOuterClass.RecordUsage.valueOf(this.ugcRecordUsage_);
            return result == null ? RecordUsageOuterClass.RecordUsage.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public int getUgcTypeValue() {
            return this.ugcType_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public UgcTypeOuterClass.UgcType getUgcType() {
            UgcTypeOuterClass.UgcType result = UgcTypeOuterClass.UgcType.valueOf(this.ugcType_);
            return result == null ? UgcTypeOuterClass.UgcType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public boolean hasMusicRecord() {
            return this.recordCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public UgcMusicRecordOuterClass.UgcMusicRecord getMusicRecord() {
            if (this.recordCase_ == 2) {
                return (UgcMusicRecordOuterClass.UgcMusicRecord) this.record_;
            }
            return UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public UgcMusicRecordOuterClass.UgcMusicRecordOrBuilder getMusicRecordOrBuilder() {
            if (this.recordCase_ == 2) {
                return (UgcMusicRecordOuterClass.UgcMusicRecord) this.record_;
            }
            return UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public boolean hasMusicBriefInfo() {
            return this.briefCase_ == 1540;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo getMusicBriefInfo() {
            if (this.briefCase_ == 1540) {
                return (UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_;
            }
            return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
            if (this.briefCase_ == 1540) {
                return (UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_;
            }
            return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance();
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
            if (this.recordCase_ == 2) {
                output.writeMessage(2, (UgcMusicRecordOuterClass.UgcMusicRecord) this.record_);
            }
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(3, this.ugcGuid_);
            }
            if (this.ugcRecordUsage_ != RecordUsageOuterClass.RecordUsage.RECORD_USAGE_UGC_RECORD_USAGE_NONE.getNumber()) {
                output.writeEnum(5, this.ugcRecordUsage_);
            }
            if (this.ugcType_ != UgcTypeOuterClass.UgcType.UGC_TYPE_NONE.getNumber()) {
                output.writeEnum(6, this.ugcType_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
            }
            if (this.briefCase_ == 1540) {
                output.writeMessage(MUSIC_BRIEF_INFO_FIELD_NUMBER, (UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_);
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
            if (this.recordCase_ == 2) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, (UgcMusicRecordOuterClass.UgcMusicRecord) this.record_);
            }
            if (this.ugcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(3, this.ugcGuid_);
            }
            if (this.ugcRecordUsage_ != RecordUsageOuterClass.RecordUsage.RECORD_USAGE_UGC_RECORD_USAGE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(5, this.ugcRecordUsage_);
            }
            if (this.ugcType_ != UgcTypeOuterClass.UgcType.UGC_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.ugcType_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.retcode_);
            }
            if (this.briefCase_ == 1540) {
                size2 += CodedOutputStream.computeMessageSize(MUSIC_BRIEF_INFO_FIELD_NUMBER, (UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_);
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
            if (!(obj instanceof GetUgcRsp)) {
                return equals(obj);
            }
            GetUgcRsp other = (GetUgcRsp) obj;
            if (getRetcode() != other.getRetcode() || this.ugcRecordUsage_ != other.ugcRecordUsage_ || this.ugcType_ != other.ugcType_ || getUgcGuid() != other.getUgcGuid() || !getRecordCase().equals(other.getRecordCase())) {
                return false;
            }
            switch (this.recordCase_) {
                case 2:
                    if (!getMusicRecord().equals(other.getMusicRecord())) {
                        return false;
                    }
                    break;
            }
            if (!getBriefCase().equals(other.getBriefCase())) {
                return false;
            }
            switch (this.briefCase_) {
                case MUSIC_BRIEF_INFO_FIELD_NUMBER /* 1540 */:
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getRetcode())) + 5)) + this.ugcRecordUsage_)) + 6)) + this.ugcType_)) + 3)) + Internal.hashLong(getUgcGuid());
            switch (this.recordCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getMusicRecord().hashCode();
                    break;
            }
            switch (this.briefCase_) {
                case MUSIC_BRIEF_INFO_FIELD_NUMBER /* 1540 */:
                    hash = (53 * ((37 * hash) + MUSIC_BRIEF_INFO_FIELD_NUMBER)) + getMusicBriefInfo().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetUgcRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetUgcRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetUgcRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetUgcRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetUgcRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetUgcRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetUgcRsp parseFrom(InputStream input) throws IOException {
            return (GetUgcRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetUgcRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetUgcRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetUgcRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetUgcRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetUgcRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetUgcRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetUgcRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetUgcRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetUgcRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetUgcRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetUgcRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass$GetUgcRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetUgcRspOrBuilder {
            private Object record_;
            private Object brief_;
            private int retcode_;
            private long ugcGuid_;
            private SingleFieldBuilderV3<UgcMusicRecordOuterClass.UgcMusicRecord, UgcMusicRecordOuterClass.UgcMusicRecord.Builder, UgcMusicRecordOuterClass.UgcMusicRecordOrBuilder> musicRecordBuilder_;
            private SingleFieldBuilderV3<UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo, UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder, UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder> musicBriefInfoBuilder_;
            private int recordCase_ = 0;
            private int briefCase_ = 0;
            private int ugcRecordUsage_ = 0;
            private int ugcType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetUgcRspOuterClass.internal_static_GetUgcRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetUgcRspOuterClass.internal_static_GetUgcRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetUgcRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetUgcRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.ugcRecordUsage_ = 0;
                this.ugcType_ = 0;
                this.ugcGuid_ = 0;
                this.recordCase_ = 0;
                this.record_ = null;
                this.briefCase_ = 0;
                this.brief_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetUgcRspOuterClass.internal_static_GetUgcRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetUgcRsp getDefaultInstanceForType() {
                return GetUgcRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetUgcRsp build() {
                GetUgcRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetUgcRsp buildPartial() {
                GetUgcRsp result = new GetUgcRsp(this);
                result.retcode_ = this.retcode_;
                result.ugcRecordUsage_ = this.ugcRecordUsage_;
                result.ugcType_ = this.ugcType_;
                result.ugcGuid_ = this.ugcGuid_;
                if (this.recordCase_ == 2) {
                    if (this.musicRecordBuilder_ == null) {
                        result.record_ = this.record_;
                    } else {
                        result.record_ = this.musicRecordBuilder_.build();
                    }
                }
                if (this.briefCase_ == 1540) {
                    if (this.musicBriefInfoBuilder_ == null) {
                        result.brief_ = this.brief_;
                    } else {
                        result.brief_ = this.musicBriefInfoBuilder_.build();
                    }
                }
                result.recordCase_ = this.recordCase_;
                result.briefCase_ = this.briefCase_;
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
                if (other instanceof GetUgcRsp) {
                    return mergeFrom((GetUgcRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetUgcRsp other) {
                if (other == GetUgcRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.ugcRecordUsage_ != 0) {
                    setUgcRecordUsageValue(other.getUgcRecordUsageValue());
                }
                if (other.ugcType_ != 0) {
                    setUgcTypeValue(other.getUgcTypeValue());
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                switch (other.getRecordCase()) {
                    case MUSIC_RECORD:
                        mergeMusicRecord(other.getMusicRecord());
                        break;
                }
                switch (other.getBriefCase()) {
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
                GetUgcRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetUgcRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetUgcRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public RecordCase getRecordCase() {
                return RecordCase.forNumber(this.recordCase_);
            }

            public Builder clearRecord() {
                this.recordCase_ = 0;
                this.record_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public BriefCase getBriefCase() {
                return BriefCase.forNumber(this.briefCase_);
            }

            public Builder clearBrief() {
                this.briefCase_ = 0;
                this.brief_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public int getUgcRecordUsageValue() {
                return this.ugcRecordUsage_;
            }

            public Builder setUgcRecordUsageValue(int value) {
                this.ugcRecordUsage_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public RecordUsageOuterClass.RecordUsage getUgcRecordUsage() {
                RecordUsageOuterClass.RecordUsage result = RecordUsageOuterClass.RecordUsage.valueOf(this.ugcRecordUsage_);
                return result == null ? RecordUsageOuterClass.RecordUsage.UNRECOGNIZED : result;
            }

            public Builder setUgcRecordUsage(RecordUsageOuterClass.RecordUsage value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ugcRecordUsage_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUgcRecordUsage() {
                this.ugcRecordUsage_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public int getUgcTypeValue() {
                return this.ugcType_;
            }

            public Builder setUgcTypeValue(int value) {
                this.ugcType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public UgcTypeOuterClass.UgcType getUgcType() {
                UgcTypeOuterClass.UgcType result = UgcTypeOuterClass.UgcType.valueOf(this.ugcType_);
                return result == null ? UgcTypeOuterClass.UgcType.UNRECOGNIZED : result;
            }

            public Builder setUgcType(UgcTypeOuterClass.UgcType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ugcType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUgcType() {
                this.ugcType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public boolean hasMusicRecord() {
                return this.recordCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public UgcMusicRecordOuterClass.UgcMusicRecord getMusicRecord() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.recordCase_ == 2) {
                        return (UgcMusicRecordOuterClass.UgcMusicRecord) this.record_;
                    }
                    return UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance();
                } else if (this.recordCase_ == 2) {
                    return this.musicRecordBuilder_.getMessage();
                } else {
                    return UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance();
                }
            }

            public Builder setMusicRecord(UgcMusicRecordOuterClass.UgcMusicRecord value) {
                if (this.musicRecordBuilder_ != null) {
                    this.musicRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.record_ = value;
                    onChanged();
                }
                this.recordCase_ = 2;
                return this;
            }

            public Builder setMusicRecord(UgcMusicRecordOuterClass.UgcMusicRecord.Builder builderForValue) {
                if (this.musicRecordBuilder_ == null) {
                    this.record_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicRecordBuilder_.setMessage(builderForValue.build());
                }
                this.recordCase_ = 2;
                return this;
            }

            public Builder mergeMusicRecord(UgcMusicRecordOuterClass.UgcMusicRecord value) {
                if (this.musicRecordBuilder_ == null) {
                    if (this.recordCase_ != 2 || this.record_ == UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance()) {
                        this.record_ = value;
                    } else {
                        this.record_ = UgcMusicRecordOuterClass.UgcMusicRecord.newBuilder((UgcMusicRecordOuterClass.UgcMusicRecord) this.record_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.recordCase_ == 2) {
                        this.musicRecordBuilder_.mergeFrom(value);
                    }
                    this.musicRecordBuilder_.setMessage(value);
                }
                this.recordCase_ = 2;
                return this;
            }

            public Builder clearMusicRecord() {
                if (this.musicRecordBuilder_ != null) {
                    if (this.recordCase_ == 2) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    this.musicRecordBuilder_.clear();
                } else if (this.recordCase_ == 2) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public UgcMusicRecordOuterClass.UgcMusicRecord.Builder getMusicRecordBuilder() {
                return getMusicRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public UgcMusicRecordOuterClass.UgcMusicRecordOrBuilder getMusicRecordOrBuilder() {
                if (this.recordCase_ == 2 && this.musicRecordBuilder_ != null) {
                    return this.musicRecordBuilder_.getMessageOrBuilder();
                }
                if (this.recordCase_ == 2) {
                    return (UgcMusicRecordOuterClass.UgcMusicRecord) this.record_;
                }
                return UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance();
            }

            private SingleFieldBuilderV3<UgcMusicRecordOuterClass.UgcMusicRecord, UgcMusicRecordOuterClass.UgcMusicRecord.Builder, UgcMusicRecordOuterClass.UgcMusicRecordOrBuilder> getMusicRecordFieldBuilder() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.recordCase_ != 2) {
                        this.record_ = UgcMusicRecordOuterClass.UgcMusicRecord.getDefaultInstance();
                    }
                    this.musicRecordBuilder_ = new SingleFieldBuilderV3<>((UgcMusicRecordOuterClass.UgcMusicRecord) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 2;
                onChanged();
                return this.musicRecordBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public boolean hasMusicBriefInfo() {
                return this.briefCase_ == 1540;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo getMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefCase_ == 1540) {
                        return (UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_;
                    }
                    return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance();
                } else if (this.briefCase_ == 1540) {
                    return this.musicBriefInfoBuilder_.getMessage();
                } else {
                    return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance();
                }
            }

            public Builder setMusicBriefInfo(UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ != null) {
                    this.musicBriefInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.brief_ = value;
                    onChanged();
                }
                this.briefCase_ = GetUgcRsp.MUSIC_BRIEF_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setMusicBriefInfo(UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder builderForValue) {
                if (this.musicBriefInfoBuilder_ == null) {
                    this.brief_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicBriefInfoBuilder_.setMessage(builderForValue.build());
                }
                this.briefCase_ = GetUgcRsp.MUSIC_BRIEF_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeMusicBriefInfo(UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo value) {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefCase_ != 1540 || this.brief_ == UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance()) {
                        this.brief_ = value;
                    } else {
                        this.brief_ = UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.newBuilder((UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.briefCase_ == 1540) {
                        this.musicBriefInfoBuilder_.mergeFrom(value);
                    }
                    this.musicBriefInfoBuilder_.setMessage(value);
                }
                this.briefCase_ = GetUgcRsp.MUSIC_BRIEF_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearMusicBriefInfo() {
                if (this.musicBriefInfoBuilder_ != null) {
                    if (this.briefCase_ == 1540) {
                        this.briefCase_ = 0;
                        this.brief_ = null;
                    }
                    this.musicBriefInfoBuilder_.clear();
                } else if (this.briefCase_ == 1540) {
                    this.briefCase_ = 0;
                    this.brief_ = null;
                    onChanged();
                }
                return this;
            }

            public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder getMusicBriefInfoBuilder() {
                return getMusicBriefInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder getMusicBriefInfoOrBuilder() {
                if (this.briefCase_ == 1540 && this.musicBriefInfoBuilder_ != null) {
                    return this.musicBriefInfoBuilder_.getMessageOrBuilder();
                }
                if (this.briefCase_ == 1540) {
                    return (UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_;
                }
                return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo, UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder, UgcMusicBriefInfoOuterClass.UgcMusicBriefInfoOrBuilder> getMusicBriefInfoFieldBuilder() {
                if (this.musicBriefInfoBuilder_ == null) {
                    if (this.briefCase_ != 1540) {
                        this.brief_ = UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.getDefaultInstance();
                    }
                    this.musicBriefInfoBuilder_ = new SingleFieldBuilderV3<>((UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo) this.brief_, getParentForChildren(), isClean());
                    this.brief_ = null;
                }
                this.briefCase_ = GetUgcRsp.MUSIC_BRIEF_INFO_FIELD_NUMBER;
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

        public static GetUgcRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetUgcRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetUgcRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetUgcRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RecordUsageOuterClass.getDescriptor();
        UgcMusicBriefInfoOuterClass.getDescriptor();
        UgcMusicRecordOuterClass.getDescriptor();
        UgcTypeOuterClass.getDescriptor();
    }
}
