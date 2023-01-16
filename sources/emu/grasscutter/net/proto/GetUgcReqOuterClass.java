package emu.grasscutter.net.proto;

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
import emu.grasscutter.net.proto.GetUgcTypeOuterClass;
import emu.grasscutter.net.proto.RecordUsageOuterClass;
import emu.grasscutter.net.proto.UgcTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcReqOuterClass.class */
public final class GetUgcReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fGetUgcReq.proto\u001a\u0010GetUgcType.proto\u001a\u0011RecordUsage.proto\u001a\rUgcType.proto\"\u0001\n\tGetUgcReq\u0012\u0010\n\bugc_guid\u0018\u0006 \u0001(\u0004\u0012\u001a\n\bugc_type\u0018\u0002 \u0001(\u000e2\b.UgcType\u0012!\n\fget_ugc_type\u0018\f \u0001(\u000e2\u000b.GetUgcType\u0012&\n\u0010ugc_record_usage\u0018\r \u0001(\u000e2\f.RecordUsage\u0012\u0018\n\u0010is_require_brief\u0018\u0007 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GetUgcTypeOuterClass.getDescriptor(), RecordUsageOuterClass.getDescriptor(), UgcTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetUgcReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetUgcReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetUgcReq_descriptor, new String[]{"UgcGuid", "UgcType", "GetUgcType", "UgcRecordUsage", "IsRequireBrief"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcReqOuterClass$GetUgcReqOrBuilder.class */
    public interface GetUgcReqOrBuilder extends MessageOrBuilder {
        long getUgcGuid();

        int getUgcTypeValue();

        UgcTypeOuterClass.UgcType getUgcType();

        int getGetUgcTypeValue();

        GetUgcTypeOuterClass.GetUgcType getGetUgcType();

        int getUgcRecordUsageValue();

        RecordUsageOuterClass.RecordUsage getUgcRecordUsage();

        boolean getIsRequireBrief();
    }

    private GetUgcReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcReqOuterClass$GetUgcReq.class */
    public static final class GetUgcReq extends GeneratedMessageV3 implements GetUgcReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UGC_GUID_FIELD_NUMBER = 6;
        private long ugcGuid_;
        public static final int UGC_TYPE_FIELD_NUMBER = 2;
        private int ugcType_;
        public static final int GET_UGC_TYPE_FIELD_NUMBER = 12;
        private int getUgcType_;
        public static final int UGC_RECORD_USAGE_FIELD_NUMBER = 13;
        private int ugcRecordUsage_;
        public static final int IS_REQUIRE_BRIEF_FIELD_NUMBER = 7;
        private boolean isRequireBrief_;
        private byte memoizedIsInitialized;
        private static final GetUgcReq DEFAULT_INSTANCE = new GetUgcReq();
        private static final Parser<GetUgcReq> PARSER = new AbstractParser<GetUgcReq>() { // from class: emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReq.1
            @Override // com.google.protobuf.Parser
            public GetUgcReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetUgcReq(input, extensionRegistry);
            }
        };

        private GetUgcReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetUgcReq() {
            this.memoizedIsInitialized = -1;
            this.ugcType_ = 0;
            this.getUgcType_ = 0;
            this.ugcRecordUsage_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetUgcReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetUgcReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 16:
                                    this.ugcType_ = input.readEnum();
                                    break;
                                case 48:
                                    this.ugcGuid_ = input.readUInt64();
                                    break;
                                case 56:
                                    this.isRequireBrief_ = input.readBool();
                                    break;
                                case 96:
                                    this.getUgcType_ = input.readEnum();
                                    break;
                                case 104:
                                    this.ugcRecordUsage_ = input.readEnum();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetUgcReqOuterClass.internal_static_GetUgcReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetUgcReqOuterClass.internal_static_GetUgcReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetUgcReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public int getUgcTypeValue() {
            return this.ugcType_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public UgcTypeOuterClass.UgcType getUgcType() {
            UgcTypeOuterClass.UgcType result = UgcTypeOuterClass.UgcType.valueOf(this.ugcType_);
            return result == null ? UgcTypeOuterClass.UgcType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public int getGetUgcTypeValue() {
            return this.getUgcType_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public GetUgcTypeOuterClass.GetUgcType getGetUgcType() {
            GetUgcTypeOuterClass.GetUgcType result = GetUgcTypeOuterClass.GetUgcType.valueOf(this.getUgcType_);
            return result == null ? GetUgcTypeOuterClass.GetUgcType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public int getUgcRecordUsageValue() {
            return this.ugcRecordUsage_;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public RecordUsageOuterClass.RecordUsage getUgcRecordUsage() {
            RecordUsageOuterClass.RecordUsage result = RecordUsageOuterClass.RecordUsage.valueOf(this.ugcRecordUsage_);
            return result == null ? RecordUsageOuterClass.RecordUsage.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
        public boolean getIsRequireBrief() {
            return this.isRequireBrief_;
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
            if (this.ugcType_ != UgcTypeOuterClass.UgcType.UGC_TYPE_NONE.getNumber()) {
                output.writeEnum(2, this.ugcType_);
            }
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(6, this.ugcGuid_);
            }
            if (this.isRequireBrief_) {
                output.writeBool(7, this.isRequireBrief_);
            }
            if (this.getUgcType_ != GetUgcTypeOuterClass.GetUgcType.GET_UGC_TYPE_NONE.getNumber()) {
                output.writeEnum(12, this.getUgcType_);
            }
            if (this.ugcRecordUsage_ != RecordUsageOuterClass.RecordUsage.RECORD_USAGE_UGC_RECORD_USAGE_NONE.getNumber()) {
                output.writeEnum(13, this.ugcRecordUsage_);
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
            if (this.ugcType_ != UgcTypeOuterClass.UgcType.UGC_TYPE_NONE.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(2, this.ugcType_);
            }
            if (this.ugcGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(6, this.ugcGuid_);
            }
            if (this.isRequireBrief_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isRequireBrief_);
            }
            if (this.getUgcType_ != GetUgcTypeOuterClass.GetUgcType.GET_UGC_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.getUgcType_);
            }
            if (this.ugcRecordUsage_ != RecordUsageOuterClass.RecordUsage.RECORD_USAGE_UGC_RECORD_USAGE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.ugcRecordUsage_);
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
            if (!(obj instanceof GetUgcReq)) {
                return equals(obj);
            }
            GetUgcReq other = (GetUgcReq) obj;
            return getUgcGuid() == other.getUgcGuid() && this.ugcType_ == other.ugcType_ && this.getUgcType_ == other.getUgcType_ && this.ugcRecordUsage_ == other.ugcRecordUsage_ && getIsRequireBrief() == other.getIsRequireBrief() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashLong(getUgcGuid()))) + 2)) + this.ugcType_)) + 12)) + this.getUgcType_)) + 13)) + this.ugcRecordUsage_)) + 7)) + Internal.hashBoolean(getIsRequireBrief()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GetUgcReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetUgcReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetUgcReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetUgcReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetUgcReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetUgcReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetUgcReq parseFrom(InputStream input) throws IOException {
            return (GetUgcReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetUgcReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetUgcReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetUgcReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetUgcReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetUgcReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetUgcReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetUgcReq parseFrom(CodedInputStream input) throws IOException {
            return (GetUgcReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetUgcReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetUgcReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetUgcReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcReqOuterClass$GetUgcReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetUgcReqOrBuilder {
            private long ugcGuid_;
            private int ugcType_ = 0;
            private int getUgcType_ = 0;
            private int ugcRecordUsage_ = 0;
            private boolean isRequireBrief_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetUgcReqOuterClass.internal_static_GetUgcReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetUgcReqOuterClass.internal_static_GetUgcReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetUgcReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetUgcReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.ugcGuid_ = 0;
                this.ugcType_ = 0;
                this.getUgcType_ = 0;
                this.ugcRecordUsage_ = 0;
                this.isRequireBrief_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetUgcReqOuterClass.internal_static_GetUgcReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetUgcReq getDefaultInstanceForType() {
                return GetUgcReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetUgcReq build() {
                GetUgcReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetUgcReq buildPartial() {
                GetUgcReq result = new GetUgcReq(this);
                result.ugcGuid_ = this.ugcGuid_;
                result.ugcType_ = this.ugcType_;
                result.getUgcType_ = this.getUgcType_;
                result.ugcRecordUsage_ = this.ugcRecordUsage_;
                result.isRequireBrief_ = this.isRequireBrief_;
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
                if (other instanceof GetUgcReq) {
                    return mergeFrom((GetUgcReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetUgcReq other) {
                if (other == GetUgcReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                if (other.ugcType_ != 0) {
                    setUgcTypeValue(other.getUgcTypeValue());
                }
                if (other.getUgcType_ != 0) {
                    setGetUgcTypeValue(other.getGetUgcTypeValue());
                }
                if (other.ugcRecordUsage_ != 0) {
                    setUgcRecordUsageValue(other.getUgcRecordUsageValue());
                }
                if (other.getIsRequireBrief()) {
                    setIsRequireBrief(other.getIsRequireBrief());
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
                GetUgcReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetUgcReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetUgcReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
            public int getUgcTypeValue() {
                return this.ugcType_;
            }

            public Builder setUgcTypeValue(int value) {
                this.ugcType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
            public int getGetUgcTypeValue() {
                return this.getUgcType_;
            }

            public Builder setGetUgcTypeValue(int value) {
                this.getUgcType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
            public GetUgcTypeOuterClass.GetUgcType getGetUgcType() {
                GetUgcTypeOuterClass.GetUgcType result = GetUgcTypeOuterClass.GetUgcType.valueOf(this.getUgcType_);
                return result == null ? GetUgcTypeOuterClass.GetUgcType.UNRECOGNIZED : result;
            }

            public Builder setGetUgcType(GetUgcTypeOuterClass.GetUgcType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.getUgcType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearGetUgcType() {
                this.getUgcType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
            public int getUgcRecordUsageValue() {
                return this.ugcRecordUsage_;
            }

            public Builder setUgcRecordUsageValue(int value) {
                this.ugcRecordUsage_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.GetUgcReqOuterClass.GetUgcReqOrBuilder
            public boolean getIsRequireBrief() {
                return this.isRequireBrief_;
            }

            public Builder setIsRequireBrief(boolean value) {
                this.isRequireBrief_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsRequireBrief() {
                this.isRequireBrief_ = false;
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

        public static GetUgcReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetUgcReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetUgcReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetUgcReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GetUgcTypeOuterClass.getDescriptor();
        RecordUsageOuterClass.getDescriptor();
        UgcTypeOuterClass.getDescriptor();
    }
}
