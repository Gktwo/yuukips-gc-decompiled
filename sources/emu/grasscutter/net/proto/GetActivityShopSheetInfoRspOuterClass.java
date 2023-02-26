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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityShopSheetInfoRspOuterClass.class */
public final class GetActivityShopSheetInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!GetActivityShopSheetInfoRsp.proto\u001a\u001bActivityShopSheetInfo.proto\"o\n\u001bGetActivityShopSheetInfoRsp\u0012\u0010\n\bshopType\u0018\u0007 \u0001(\r\u0012-\n\rsheetInfoList\u0018\n \u0003(\u000b2\u0016.ActivityShopSheetInfo\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityShopSheetInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetActivityShopSheetInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetActivityShopSheetInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetActivityShopSheetInfoRsp_descriptor, new String[]{"ShopType", "SheetInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityShopSheetInfoRspOuterClass$GetActivityShopSheetInfoRspOrBuilder.class */
    public interface GetActivityShopSheetInfoRspOrBuilder extends MessageOrBuilder {
        int getShopType();

        List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> getSheetInfoListList();

        ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo getSheetInfoList(int i);

        int getSheetInfoListCount();

        List<? extends ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder> getSheetInfoListOrBuilderList();

        ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder getSheetInfoListOrBuilder(int i);

        int getRetcode();
    }

    private GetActivityShopSheetInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityShopSheetInfoRspOuterClass$GetActivityShopSheetInfoRsp.class */
    public static final class GetActivityShopSheetInfoRsp extends GeneratedMessageV3 implements GetActivityShopSheetInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOPTYPE_FIELD_NUMBER = 7;
        private int shopType_;
        public static final int SHEETINFOLIST_FIELD_NUMBER = 10;
        private List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> sheetInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetActivityShopSheetInfoRsp DEFAULT_INSTANCE = new GetActivityShopSheetInfoRsp();
        private static final Parser<GetActivityShopSheetInfoRsp> PARSER = new AbstractParser<GetActivityShopSheetInfoRsp>() { // from class: emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetActivityShopSheetInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetActivityShopSheetInfoRsp(input, extensionRegistry);
            }
        };

        private GetActivityShopSheetInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetActivityShopSheetInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.sheetInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetActivityShopSheetInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetActivityShopSheetInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.retcode_ = input.readInt32();
                                break;
                            case 56:
                                this.shopType_ = input.readUInt32();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.sheetInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.sheetInfoList_.add((ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo) input.readMessage(ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.sheetInfoList_ = Collections.unmodifiableList(this.sheetInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetActivityShopSheetInfoRspOuterClass.internal_static_GetActivityShopSheetInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetActivityShopSheetInfoRspOuterClass.internal_static_GetActivityShopSheetInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetActivityShopSheetInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
        public int getShopType() {
            return this.shopType_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
        public List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> getSheetInfoListList() {
            return this.sheetInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
        public List<? extends ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder> getSheetInfoListOrBuilderList() {
            return this.sheetInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
        public int getSheetInfoListCount() {
            return this.sheetInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
        public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo getSheetInfoList(int index) {
            return this.sheetInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
        public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder getSheetInfoListOrBuilder(int index) {
            return this.sheetInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (this.shopType_ != 0) {
                output.writeUInt32(7, this.shopType_);
            }
            for (int i = 0; i < this.sheetInfoList_.size(); i++) {
                output.writeMessage(10, this.sheetInfoList_.get(i));
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            if (this.shopType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.shopType_);
            }
            for (int i = 0; i < this.sheetInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.sheetInfoList_.get(i));
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
            if (!(obj instanceof GetActivityShopSheetInfoRsp)) {
                return equals(obj);
            }
            GetActivityShopSheetInfoRsp other = (GetActivityShopSheetInfoRsp) obj;
            return getShopType() == other.getShopType() && getSheetInfoListList().equals(other.getSheetInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getShopType();
            if (getSheetInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getSheetInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 5)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetActivityShopSheetInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetActivityShopSheetInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityShopSheetInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetActivityShopSheetInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetActivityShopSheetInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetActivityShopSheetInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityShopSheetInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetActivityShopSheetInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetActivityShopSheetInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityShopSheetInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetActivityShopSheetInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityShopSheetInfoRspOuterClass$GetActivityShopSheetInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetActivityShopSheetInfoRspOrBuilder {
            private int bitField0_;
            private int shopType_;
            private List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> sheetInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder> sheetInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetActivityShopSheetInfoRspOuterClass.internal_static_GetActivityShopSheetInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetActivityShopSheetInfoRspOuterClass.internal_static_GetActivityShopSheetInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetActivityShopSheetInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetActivityShopSheetInfoRsp.alwaysUseFieldBuilders) {
                    getSheetInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.shopType_ = 0;
                if (this.sheetInfoListBuilder_ == null) {
                    this.sheetInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.sheetInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetActivityShopSheetInfoRspOuterClass.internal_static_GetActivityShopSheetInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetActivityShopSheetInfoRsp getDefaultInstanceForType() {
                return GetActivityShopSheetInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetActivityShopSheetInfoRsp build() {
                GetActivityShopSheetInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetActivityShopSheetInfoRsp buildPartial() {
                GetActivityShopSheetInfoRsp result = new GetActivityShopSheetInfoRsp(this);
                int i = this.bitField0_;
                result.shopType_ = this.shopType_;
                if (this.sheetInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.sheetInfoList_ = Collections.unmodifiableList(this.sheetInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.sheetInfoList_ = this.sheetInfoList_;
                } else {
                    result.sheetInfoList_ = this.sheetInfoListBuilder_.build();
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
                if (other instanceof GetActivityShopSheetInfoRsp) {
                    return mergeFrom((GetActivityShopSheetInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetActivityShopSheetInfoRsp other) {
                if (other == GetActivityShopSheetInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getShopType() != 0) {
                    setShopType(other.getShopType());
                }
                if (this.sheetInfoListBuilder_ == null) {
                    if (!other.sheetInfoList_.isEmpty()) {
                        if (this.sheetInfoList_.isEmpty()) {
                            this.sheetInfoList_ = other.sheetInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSheetInfoListIsMutable();
                            this.sheetInfoList_.addAll(other.sheetInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.sheetInfoList_.isEmpty()) {
                    if (this.sheetInfoListBuilder_.isEmpty()) {
                        this.sheetInfoListBuilder_.dispose();
                        this.sheetInfoListBuilder_ = null;
                        this.sheetInfoList_ = other.sheetInfoList_;
                        this.bitField0_ &= -2;
                        this.sheetInfoListBuilder_ = GetActivityShopSheetInfoRsp.alwaysUseFieldBuilders ? getSheetInfoListFieldBuilder() : null;
                    } else {
                        this.sheetInfoListBuilder_.addAllMessages(other.sheetInfoList_);
                    }
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
                GetActivityShopSheetInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetActivityShopSheetInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetActivityShopSheetInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
            public int getShopType() {
                return this.shopType_;
            }

            public Builder setShopType(int value) {
                this.shopType_ = value;
                onChanged();
                return this;
            }

            public Builder clearShopType() {
                this.shopType_ = 0;
                onChanged();
                return this;
            }

            private void ensureSheetInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sheetInfoList_ = new ArrayList(this.sheetInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
            public List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> getSheetInfoListList() {
                if (this.sheetInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.sheetInfoList_);
                }
                return this.sheetInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
            public int getSheetInfoListCount() {
                if (this.sheetInfoListBuilder_ == null) {
                    return this.sheetInfoList_.size();
                }
                return this.sheetInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
            public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo getSheetInfoList(int index) {
                if (this.sheetInfoListBuilder_ == null) {
                    return this.sheetInfoList_.get(index);
                }
                return this.sheetInfoListBuilder_.getMessage(index);
            }

            public Builder setSheetInfoList(int index, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo value) {
                if (this.sheetInfoListBuilder_ != null) {
                    this.sheetInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSheetInfoList(int index, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder builderForValue) {
                if (this.sheetInfoListBuilder_ == null) {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sheetInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSheetInfoList(ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo value) {
                if (this.sheetInfoListBuilder_ != null) {
                    this.sheetInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSheetInfoList(int index, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo value) {
                if (this.sheetInfoListBuilder_ != null) {
                    this.sheetInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSheetInfoList(ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder builderForValue) {
                if (this.sheetInfoListBuilder_ == null) {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.sheetInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSheetInfoList(int index, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder builderForValue) {
                if (this.sheetInfoListBuilder_ == null) {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sheetInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSheetInfoList(Iterable<? extends ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> values) {
                if (this.sheetInfoListBuilder_ == null) {
                    ensureSheetInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sheetInfoList_);
                    onChanged();
                } else {
                    this.sheetInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSheetInfoList() {
                if (this.sheetInfoListBuilder_ == null) {
                    this.sheetInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.sheetInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSheetInfoList(int index) {
                if (this.sheetInfoListBuilder_ == null) {
                    ensureSheetInfoListIsMutable();
                    this.sheetInfoList_.remove(index);
                    onChanged();
                } else {
                    this.sheetInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder getSheetInfoListBuilder(int index) {
                return getSheetInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
            public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder getSheetInfoListOrBuilder(int index) {
                if (this.sheetInfoListBuilder_ == null) {
                    return this.sheetInfoList_.get(index);
                }
                return this.sheetInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
            public List<? extends ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder> getSheetInfoListOrBuilderList() {
                if (this.sheetInfoListBuilder_ != null) {
                    return this.sheetInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sheetInfoList_);
            }

            public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder addSheetInfoListBuilder() {
                return getSheetInfoListFieldBuilder().addBuilder(ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.getDefaultInstance());
            }

            public ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder addSheetInfoListBuilder(int index) {
                return getSheetInfoListFieldBuilder().addBuilder(index, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.getDefaultInstance());
            }

            public List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder> getSheetInfoListBuilderList() {
                return getSheetInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.Builder, ActivityShopSheetInfoOuterClass.ActivityShopSheetInfoOrBuilder> getSheetInfoListFieldBuilder() {
                if (this.sheetInfoListBuilder_ == null) {
                    this.sheetInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.sheetInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.sheetInfoList_ = null;
                }
                return this.sheetInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRspOrBuilder
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

        public static GetActivityShopSheetInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetActivityShopSheetInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetActivityShopSheetInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetActivityShopSheetInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ActivityShopSheetInfoOuterClass.getDescriptor();
    }
}
