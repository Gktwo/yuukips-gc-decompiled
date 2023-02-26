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
import emu.grasscutter.net.proto.MusicRecordOuterClass;
import emu.grasscutter.net.proto.RecordUsageOuterClass;
import emu.grasscutter.net.proto.UgcTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass.class */
public final class GetUgcRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fGetUgcRsp.proto\u001a\rUgcType.proto\u001a\u0011RecordUsage.proto\u001a\u0011MusicRecord.proto\"\u0001\n\tGetUgcRsp\u0012\u0019\n\u0007ugcType\u0018\f \u0001(\u000e2\b.UgcType\u0012\u000f\n\u0007retcode\u0018\b \u0001(\u0005\u0012$\n\u000eugcRecordUsage\u0018\u0007 \u0001(\u000e2\f.RecordUsage\u0012\u000f\n\u0007ugcGuid\u0018\t \u0001(\u0004\u0012$\n\fmusic_record\u0018\u0001 \u0001(\u000b2\f.MusicRecordH��B\b\n\u0006recordB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{UgcTypeOuterClass.getDescriptor(), RecordUsageOuterClass.getDescriptor(), MusicRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetUgcRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetUgcRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetUgcRsp_descriptor, new String[]{"UgcType", "Retcode", "UgcRecordUsage", "UgcGuid", "MusicRecord", "Record"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcRspOuterClass$GetUgcRspOrBuilder.class */
    public interface GetUgcRspOrBuilder extends MessageOrBuilder {
        int getUgcTypeValue();

        UgcTypeOuterClass.UgcType getUgcType();

        int getRetcode();

        int getUgcRecordUsageValue();

        RecordUsageOuterClass.RecordUsage getUgcRecordUsage();

        long getUgcGuid();

        boolean hasMusicRecord();

        MusicRecordOuterClass.MusicRecord getMusicRecord();

        MusicRecordOuterClass.MusicRecordOrBuilder getMusicRecordOrBuilder();

        GetUgcRsp.RecordCase getRecordCase();
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
        public static final int UGCTYPE_FIELD_NUMBER = 12;
        private int ugcType_;
        public static final int RETCODE_FIELD_NUMBER = 8;
        private int retcode_;
        public static final int UGCRECORDUSAGE_FIELD_NUMBER = 7;
        private int ugcRecordUsage_;
        public static final int UGCGUID_FIELD_NUMBER = 9;
        private long ugcGuid_;
        public static final int MUSIC_RECORD_FIELD_NUMBER = 1;
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
            this.memoizedIsInitialized = -1;
        }

        private GetUgcRsp() {
            this.recordCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.ugcType_ = 0;
            this.ugcRecordUsage_ = 0;
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
                            case 10:
                                MusicRecordOuterClass.MusicRecord.Builder subBuilder = this.recordCase_ == 1 ? ((MusicRecordOuterClass.MusicRecord) this.record_).toBuilder() : null;
                                this.record_ = input.readMessage(MusicRecordOuterClass.MusicRecord.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((MusicRecordOuterClass.MusicRecord) this.record_);
                                    this.record_ = subBuilder.buildPartial();
                                }
                                this.recordCase_ = 1;
                                break;
                            case 56:
                                this.ugcRecordUsage_ = input.readEnum();
                                break;
                            case 64:
                                this.retcode_ = input.readInt32();
                                break;
                            case 72:
                                this.ugcGuid_ = input.readUInt64();
                                break;
                            case 96:
                                this.ugcType_ = input.readEnum();
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
            MUSIC_RECORD(1),
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
                    case 1:
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
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public boolean hasMusicRecord() {
            return this.recordCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public MusicRecordOuterClass.MusicRecord getMusicRecord() {
            if (this.recordCase_ == 1) {
                return (MusicRecordOuterClass.MusicRecord) this.record_;
            }
            return MusicRecordOuterClass.MusicRecord.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
        public MusicRecordOuterClass.MusicRecordOrBuilder getMusicRecordOrBuilder() {
            if (this.recordCase_ == 1) {
                return (MusicRecordOuterClass.MusicRecord) this.record_;
            }
            return MusicRecordOuterClass.MusicRecord.getDefaultInstance();
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
            if (this.recordCase_ == 1) {
                output.writeMessage(1, (MusicRecordOuterClass.MusicRecord) this.record_);
            }
            if (this.ugcRecordUsage_ != RecordUsageOuterClass.RecordUsage.RECORD_USAGE_UGC_RECORD_USAGE_NONE.getNumber()) {
                output.writeEnum(7, this.ugcRecordUsage_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(8, this.retcode_);
            }
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(9, this.ugcGuid_);
            }
            if (this.ugcType_ != UgcTypeOuterClass.UgcType.UGC_TYPE_NONE.getNumber()) {
                output.writeEnum(12, this.ugcType_);
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
            if (this.recordCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, (MusicRecordOuterClass.MusicRecord) this.record_);
            }
            if (this.ugcRecordUsage_ != RecordUsageOuterClass.RecordUsage.RECORD_USAGE_UGC_RECORD_USAGE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(7, this.ugcRecordUsage_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.retcode_);
            }
            if (this.ugcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(9, this.ugcGuid_);
            }
            if (this.ugcType_ != UgcTypeOuterClass.UgcType.UGC_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.ugcType_);
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
            if (this.ugcType_ != other.ugcType_ || getRetcode() != other.getRetcode() || this.ugcRecordUsage_ != other.ugcRecordUsage_ || getUgcGuid() != other.getUgcGuid() || !getRecordCase().equals(other.getRecordCase())) {
                return false;
            }
            switch (this.recordCase_) {
                case 1:
                    if (!getMusicRecord().equals(other.getMusicRecord())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + this.ugcType_)) + 8)) + getRetcode())) + 7)) + this.ugcRecordUsage_)) + 9)) + Internal.hashLong(getUgcGuid());
            switch (this.recordCase_) {
                case 1:
                    hash = (53 * ((37 * hash) + 1)) + getMusicRecord().hashCode();
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
            private int retcode_;
            private long ugcGuid_;
            private SingleFieldBuilderV3<MusicRecordOuterClass.MusicRecord, MusicRecordOuterClass.MusicRecord.Builder, MusicRecordOuterClass.MusicRecordOrBuilder> musicRecordBuilder_;
            private int recordCase_ = 0;
            private int ugcType_ = 0;
            private int ugcRecordUsage_ = 0;

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
                this.ugcType_ = 0;
                this.retcode_ = 0;
                this.ugcRecordUsage_ = 0;
                this.ugcGuid_ = 0;
                this.recordCase_ = 0;
                this.record_ = null;
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
                result.ugcType_ = this.ugcType_;
                result.retcode_ = this.retcode_;
                result.ugcRecordUsage_ = this.ugcRecordUsage_;
                result.ugcGuid_ = this.ugcGuid_;
                if (this.recordCase_ == 1) {
                    if (this.musicRecordBuilder_ == null) {
                        result.record_ = this.record_;
                    } else {
                        result.record_ = this.musicRecordBuilder_.build();
                    }
                }
                result.recordCase_ = this.recordCase_;
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
                if (other.ugcType_ != 0) {
                    setUgcTypeValue(other.getUgcTypeValue());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.ugcRecordUsage_ != 0) {
                    setUgcRecordUsageValue(other.getUgcRecordUsageValue());
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                switch (other.getRecordCase()) {
                    case MUSIC_RECORD:
                        mergeMusicRecord(other.getMusicRecord());
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
                return this.recordCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public MusicRecordOuterClass.MusicRecord getMusicRecord() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.recordCase_ == 1) {
                        return (MusicRecordOuterClass.MusicRecord) this.record_;
                    }
                    return MusicRecordOuterClass.MusicRecord.getDefaultInstance();
                } else if (this.recordCase_ == 1) {
                    return this.musicRecordBuilder_.getMessage();
                } else {
                    return MusicRecordOuterClass.MusicRecord.getDefaultInstance();
                }
            }

            public Builder setMusicRecord(MusicRecordOuterClass.MusicRecord value) {
                if (this.musicRecordBuilder_ != null) {
                    this.musicRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.record_ = value;
                    onChanged();
                }
                this.recordCase_ = 1;
                return this;
            }

            public Builder setMusicRecord(MusicRecordOuterClass.MusicRecord.Builder builderForValue) {
                if (this.musicRecordBuilder_ == null) {
                    this.record_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicRecordBuilder_.setMessage(builderForValue.build());
                }
                this.recordCase_ = 1;
                return this;
            }

            public Builder mergeMusicRecord(MusicRecordOuterClass.MusicRecord value) {
                if (this.musicRecordBuilder_ == null) {
                    if (this.recordCase_ != 1 || this.record_ == MusicRecordOuterClass.MusicRecord.getDefaultInstance()) {
                        this.record_ = value;
                    } else {
                        this.record_ = MusicRecordOuterClass.MusicRecord.newBuilder((MusicRecordOuterClass.MusicRecord) this.record_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.recordCase_ == 1) {
                        this.musicRecordBuilder_.mergeFrom(value);
                    }
                    this.musicRecordBuilder_.setMessage(value);
                }
                this.recordCase_ = 1;
                return this;
            }

            public Builder clearMusicRecord() {
                if (this.musicRecordBuilder_ != null) {
                    if (this.recordCase_ == 1) {
                        this.recordCase_ = 0;
                        this.record_ = null;
                    }
                    this.musicRecordBuilder_.clear();
                } else if (this.recordCase_ == 1) {
                    this.recordCase_ = 0;
                    this.record_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicRecordOuterClass.MusicRecord.Builder getMusicRecordBuilder() {
                return getMusicRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetUgcRspOuterClass.GetUgcRspOrBuilder
            public MusicRecordOuterClass.MusicRecordOrBuilder getMusicRecordOrBuilder() {
                if (this.recordCase_ == 1 && this.musicRecordBuilder_ != null) {
                    return this.musicRecordBuilder_.getMessageOrBuilder();
                }
                if (this.recordCase_ == 1) {
                    return (MusicRecordOuterClass.MusicRecord) this.record_;
                }
                return MusicRecordOuterClass.MusicRecord.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicRecordOuterClass.MusicRecord, MusicRecordOuterClass.MusicRecord.Builder, MusicRecordOuterClass.MusicRecordOrBuilder> getMusicRecordFieldBuilder() {
                if (this.musicRecordBuilder_ == null) {
                    if (this.recordCase_ != 1) {
                        this.record_ = MusicRecordOuterClass.MusicRecord.getDefaultInstance();
                    }
                    this.musicRecordBuilder_ = new SingleFieldBuilderV3<>((MusicRecordOuterClass.MusicRecord) this.record_, getParentForChildren(), isClean());
                    this.record_ = null;
                }
                this.recordCase_ = 1;
                onChanged();
                return this.musicRecordBuilder_;
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
        UgcTypeOuterClass.getDescriptor();
        RecordUsageOuterClass.getDescriptor();
        MusicRecordOuterClass.getDescriptor();
    }
}
