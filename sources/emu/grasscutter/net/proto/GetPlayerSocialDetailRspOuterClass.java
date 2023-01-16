package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.SocialDetailOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerSocialDetailRspOuterClass.class */
public final class GetPlayerSocialDetailRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eGetPlayerSocialDetailRsp.proto\u001a\u0012SocialDetail.proto\"O\n\u0018GetPlayerSocialDetailRsp\u0012\"\n\u000bdetail_data\u0018\u0006 \u0001(\u000b2\r.SocialDetail\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SocialDetailOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetPlayerSocialDetailRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetPlayerSocialDetailRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetPlayerSocialDetailRsp_descriptor, new String[]{"DetailData", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerSocialDetailRspOuterClass$GetPlayerSocialDetailRspOrBuilder.class */
    public interface GetPlayerSocialDetailRspOrBuilder extends MessageOrBuilder {
        boolean hasDetailData();

        SocialDetailOuterClass.SocialDetail getDetailData();

        SocialDetailOuterClass.SocialDetailOrBuilder getDetailDataOrBuilder();

        int getRetcode();
    }

    private GetPlayerSocialDetailRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerSocialDetailRspOuterClass$GetPlayerSocialDetailRsp.class */
    public static final class GetPlayerSocialDetailRsp extends GeneratedMessageV3 implements GetPlayerSocialDetailRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DETAIL_DATA_FIELD_NUMBER = 6;
        private SocialDetailOuterClass.SocialDetail detailData_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetPlayerSocialDetailRsp DEFAULT_INSTANCE = new GetPlayerSocialDetailRsp();
        private static final Parser<GetPlayerSocialDetailRsp> PARSER = new AbstractParser<GetPlayerSocialDetailRsp>() { // from class: emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRsp.1
            @Override // com.google.protobuf.Parser
            public GetPlayerSocialDetailRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetPlayerSocialDetailRsp(input, extensionRegistry);
            }
        };

        private GetPlayerSocialDetailRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetPlayerSocialDetailRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetPlayerSocialDetailRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetPlayerSocialDetailRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 50:
                                    SocialDetailOuterClass.SocialDetail.Builder subBuilder = this.detailData_ != null ? this.detailData_.toBuilder() : null;
                                    this.detailData_ = (SocialDetailOuterClass.SocialDetail) input.readMessage(SocialDetailOuterClass.SocialDetail.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.detailData_);
                                        this.detailData_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 112:
                                    this.retcode_ = input.readInt32();
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
                        }
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
            return GetPlayerSocialDetailRspOuterClass.internal_static_GetPlayerSocialDetailRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetPlayerSocialDetailRspOuterClass.internal_static_GetPlayerSocialDetailRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerSocialDetailRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
        public boolean hasDetailData() {
            return this.detailData_ != null;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
        public SocialDetailOuterClass.SocialDetail getDetailData() {
            return this.detailData_ == null ? SocialDetailOuterClass.SocialDetail.getDefaultInstance() : this.detailData_;
        }

        @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
        public SocialDetailOuterClass.SocialDetailOrBuilder getDetailDataOrBuilder() {
            return getDetailData();
        }

        @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.detailData_ != null) {
                output.writeMessage(6, getDetailData());
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (this.detailData_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(6, getDetailData());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof GetPlayerSocialDetailRsp)) {
                return equals(obj);
            }
            GetPlayerSocialDetailRsp other = (GetPlayerSocialDetailRsp) obj;
            if (hasDetailData() != other.hasDetailData()) {
                return false;
            }
            return (!hasDetailData() || getDetailData().equals(other.getDetailData())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasDetailData()) {
                hash = (53 * ((37 * hash) + 6)) + getDetailData().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetPlayerSocialDetailRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerSocialDetailRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerSocialDetailRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerSocialDetailRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerSocialDetailRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetPlayerSocialDetailRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetPlayerSocialDetailRsp parseFrom(InputStream input) throws IOException {
            return (GetPlayerSocialDetailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerSocialDetailRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerSocialDetailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerSocialDetailRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetPlayerSocialDetailRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetPlayerSocialDetailRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerSocialDetailRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetPlayerSocialDetailRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetPlayerSocialDetailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetPlayerSocialDetailRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetPlayerSocialDetailRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetPlayerSocialDetailRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetPlayerSocialDetailRspOuterClass$GetPlayerSocialDetailRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetPlayerSocialDetailRspOrBuilder {
            private SocialDetailOuterClass.SocialDetail detailData_;
            private SingleFieldBuilderV3<SocialDetailOuterClass.SocialDetail, SocialDetailOuterClass.SocialDetail.Builder, SocialDetailOuterClass.SocialDetailOrBuilder> detailDataBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetPlayerSocialDetailRspOuterClass.internal_static_GetPlayerSocialDetailRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetPlayerSocialDetailRspOuterClass.internal_static_GetPlayerSocialDetailRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetPlayerSocialDetailRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetPlayerSocialDetailRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.detailDataBuilder_ == null) {
                    this.detailData_ = null;
                } else {
                    this.detailData_ = null;
                    this.detailDataBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetPlayerSocialDetailRspOuterClass.internal_static_GetPlayerSocialDetailRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetPlayerSocialDetailRsp getDefaultInstanceForType() {
                return GetPlayerSocialDetailRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerSocialDetailRsp build() {
                GetPlayerSocialDetailRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetPlayerSocialDetailRsp buildPartial() {
                GetPlayerSocialDetailRsp result = new GetPlayerSocialDetailRsp(this);
                if (this.detailDataBuilder_ == null) {
                    result.detailData_ = this.detailData_;
                } else {
                    result.detailData_ = this.detailDataBuilder_.build();
                }
                result.retcode_ = this.retcode_;
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
                if (other instanceof GetPlayerSocialDetailRsp) {
                    return mergeFrom((GetPlayerSocialDetailRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetPlayerSocialDetailRsp other) {
                if (other == GetPlayerSocialDetailRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasDetailData()) {
                    mergeDetailData(other.getDetailData());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                GetPlayerSocialDetailRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetPlayerSocialDetailRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetPlayerSocialDetailRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
            public boolean hasDetailData() {
                return (this.detailDataBuilder_ == null && this.detailData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
            public SocialDetailOuterClass.SocialDetail getDetailData() {
                if (this.detailDataBuilder_ == null) {
                    return this.detailData_ == null ? SocialDetailOuterClass.SocialDetail.getDefaultInstance() : this.detailData_;
                }
                return this.detailDataBuilder_.getMessage();
            }

            public Builder setDetailData(SocialDetailOuterClass.SocialDetail value) {
                if (this.detailDataBuilder_ != null) {
                    this.detailDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detailData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDetailData(SocialDetailOuterClass.SocialDetail.Builder builderForValue) {
                if (this.detailDataBuilder_ == null) {
                    this.detailData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.detailDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDetailData(SocialDetailOuterClass.SocialDetail value) {
                if (this.detailDataBuilder_ == null) {
                    if (this.detailData_ != null) {
                        this.detailData_ = SocialDetailOuterClass.SocialDetail.newBuilder(this.detailData_).mergeFrom(value).buildPartial();
                    } else {
                        this.detailData_ = value;
                    }
                    onChanged();
                } else {
                    this.detailDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDetailData() {
                if (this.detailDataBuilder_ == null) {
                    this.detailData_ = null;
                    onChanged();
                } else {
                    this.detailData_ = null;
                    this.detailDataBuilder_ = null;
                }
                return this;
            }

            public SocialDetailOuterClass.SocialDetail.Builder getDetailDataBuilder() {
                onChanged();
                return getDetailDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
            public SocialDetailOuterClass.SocialDetailOrBuilder getDetailDataOrBuilder() {
                if (this.detailDataBuilder_ != null) {
                    return this.detailDataBuilder_.getMessageOrBuilder();
                }
                return this.detailData_ == null ? SocialDetailOuterClass.SocialDetail.getDefaultInstance() : this.detailData_;
            }

            private SingleFieldBuilderV3<SocialDetailOuterClass.SocialDetail, SocialDetailOuterClass.SocialDetail.Builder, SocialDetailOuterClass.SocialDetailOrBuilder> getDetailDataFieldBuilder() {
                if (this.detailDataBuilder_ == null) {
                    this.detailDataBuilder_ = new SingleFieldBuilderV3<>(getDetailData(), getParentForChildren(), isClean());
                    this.detailData_ = null;
                }
                return this.detailDataBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static GetPlayerSocialDetailRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetPlayerSocialDetailRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetPlayerSocialDetailRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetPlayerSocialDetailRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SocialDetailOuterClass.getDescriptor();
    }
}
