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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetShopmallDataRspOuterClass.class */
public final class GetShopmallDataRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018GetShopmallDataRsp.proto\";\n\u0012GetShopmallDataRsp\u0012\u0014\n\fshopTypeList\u0018\n \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetShopmallDataRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetShopmallDataRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetShopmallDataRsp_descriptor, new String[]{"ShopTypeList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetShopmallDataRspOuterClass$GetShopmallDataRspOrBuilder.class */
    public interface GetShopmallDataRspOrBuilder extends MessageOrBuilder {
        List<Integer> getShopTypeListList();

        int getShopTypeListCount();

        int getShopTypeList(int i);

        int getRetcode();
    }

    private GetShopmallDataRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetShopmallDataRspOuterClass$GetShopmallDataRsp.class */
    public static final class GetShopmallDataRsp extends GeneratedMessageV3 implements GetShopmallDataRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SHOPTYPELIST_FIELD_NUMBER = 10;
        private Internal.IntList shopTypeList_;
        private int shopTypeListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetShopmallDataRsp DEFAULT_INSTANCE = new GetShopmallDataRsp();
        private static final Parser<GetShopmallDataRsp> PARSER = new AbstractParser<GetShopmallDataRsp>() { // from class: emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRsp.1
            @Override // com.google.protobuf.Parser
            public GetShopmallDataRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetShopmallDataRsp(input, extensionRegistry);
            }
        };

        private GetShopmallDataRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.shopTypeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetShopmallDataRsp() {
            this.shopTypeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.shopTypeList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetShopmallDataRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetShopmallDataRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.shopTypeList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.shopTypeList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.shopTypeList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.shopTypeList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                    this.shopTypeList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetShopmallDataRspOuterClass.internal_static_GetShopmallDataRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetShopmallDataRspOuterClass.internal_static_GetShopmallDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetShopmallDataRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
        public List<Integer> getShopTypeListList() {
            return this.shopTypeList_;
        }

        @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
        public int getShopTypeListCount() {
            return this.shopTypeList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
        public int getShopTypeList(int index) {
            return this.shopTypeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
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
            getSerializedSize();
            if (this.retcode_ != 0) {
                output.writeInt32(3, this.retcode_);
            }
            if (getShopTypeListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.shopTypeListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.shopTypeList_.size(); i++) {
                output.writeUInt32NoTag(this.shopTypeList_.getInt(i));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.shopTypeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.shopTypeList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getShopTypeListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.shopTypeListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetShopmallDataRsp)) {
                return equals(obj);
            }
            GetShopmallDataRsp other = (GetShopmallDataRsp) obj;
            return getShopTypeListList().equals(other.getShopTypeListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getShopTypeListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getShopTypeListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetShopmallDataRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetShopmallDataRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopmallDataRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetShopmallDataRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopmallDataRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetShopmallDataRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetShopmallDataRsp parseFrom(InputStream input) throws IOException {
            return (GetShopmallDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetShopmallDataRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopmallDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetShopmallDataRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetShopmallDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetShopmallDataRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopmallDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetShopmallDataRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetShopmallDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetShopmallDataRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetShopmallDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetShopmallDataRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetShopmallDataRspOuterClass$GetShopmallDataRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetShopmallDataRspOrBuilder {
            private int bitField0_;
            private Internal.IntList shopTypeList_ = GetShopmallDataRsp.emptyIntList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetShopmallDataRspOuterClass.internal_static_GetShopmallDataRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetShopmallDataRspOuterClass.internal_static_GetShopmallDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetShopmallDataRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetShopmallDataRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.shopTypeList_ = GetShopmallDataRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetShopmallDataRspOuterClass.internal_static_GetShopmallDataRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetShopmallDataRsp getDefaultInstanceForType() {
                return GetShopmallDataRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetShopmallDataRsp build() {
                GetShopmallDataRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetShopmallDataRsp buildPartial() {
                GetShopmallDataRsp result = new GetShopmallDataRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.shopTypeList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.shopTypeList_ = this.shopTypeList_;
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
                if (other instanceof GetShopmallDataRsp) {
                    return mergeFrom((GetShopmallDataRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetShopmallDataRsp other) {
                if (other == GetShopmallDataRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.shopTypeList_.isEmpty()) {
                    if (this.shopTypeList_.isEmpty()) {
                        this.shopTypeList_ = other.shopTypeList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureShopTypeListIsMutable();
                        this.shopTypeList_.addAll(other.shopTypeList_);
                    }
                    onChanged();
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
                GetShopmallDataRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetShopmallDataRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetShopmallDataRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureShopTypeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.shopTypeList_ = GetShopmallDataRsp.mutableCopy(this.shopTypeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
            public List<Integer> getShopTypeListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.shopTypeList_) : this.shopTypeList_;
            }

            @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
            public int getShopTypeListCount() {
                return this.shopTypeList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
            public int getShopTypeList(int index) {
                return this.shopTypeList_.getInt(index);
            }

            public Builder setShopTypeList(int index, int value) {
                ensureShopTypeListIsMutable();
                this.shopTypeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addShopTypeList(int value) {
                ensureShopTypeListIsMutable();
                this.shopTypeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllShopTypeList(Iterable<? extends Integer> values) {
                ensureShopTypeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.shopTypeList_);
                onChanged();
                return this;
            }

            public Builder clearShopTypeList() {
                this.shopTypeList_ = GetShopmallDataRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetShopmallDataRspOuterClass.GetShopmallDataRspOrBuilder
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

        public static GetShopmallDataRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetShopmallDataRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetShopmallDataRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetShopmallDataRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
