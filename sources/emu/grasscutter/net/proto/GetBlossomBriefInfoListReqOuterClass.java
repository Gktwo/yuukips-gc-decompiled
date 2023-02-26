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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListReqOuterClass.class */
public final class GetBlossomBriefInfoListReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n GetBlossomBriefInfoListReq.proto\"0\n\u001aGetBlossomBriefInfoListReq\u0012\u0012\n\ncityIdList\u0018\u0005 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetBlossomBriefInfoListReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetBlossomBriefInfoListReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetBlossomBriefInfoListReq_descriptor, new String[]{"CityIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListReqOuterClass$GetBlossomBriefInfoListReqOrBuilder.class */
    public interface GetBlossomBriefInfoListReqOrBuilder extends MessageOrBuilder {
        List<Integer> getCityIdListList();

        int getCityIdListCount();

        int getCityIdList(int i);
    }

    private GetBlossomBriefInfoListReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListReqOuterClass$GetBlossomBriefInfoListReq.class */
    public static final class GetBlossomBriefInfoListReq extends GeneratedMessageV3 implements GetBlossomBriefInfoListReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CITYIDLIST_FIELD_NUMBER = 5;
        private Internal.IntList cityIdList_;
        private int cityIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GetBlossomBriefInfoListReq DEFAULT_INSTANCE = new GetBlossomBriefInfoListReq();
        private static final Parser<GetBlossomBriefInfoListReq> PARSER = new AbstractParser<GetBlossomBriefInfoListReq>() { // from class: emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReq.1
            @Override // com.google.protobuf.Parser
            public GetBlossomBriefInfoListReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetBlossomBriefInfoListReq(input, extensionRegistry);
            }
        };

        private GetBlossomBriefInfoListReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.cityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetBlossomBriefInfoListReq() {
            this.cityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.cityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetBlossomBriefInfoListReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetBlossomBriefInfoListReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.cityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.cityIdList_.addInt(input.readUInt32());
                                    break;
                                case 42:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.cityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.cityIdList_.addInt(input.readUInt32());
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
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.cityIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetBlossomBriefInfoListReqOuterClass.internal_static_GetBlossomBriefInfoListReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetBlossomBriefInfoListReqOuterClass.internal_static_GetBlossomBriefInfoListReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetBlossomBriefInfoListReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReqOrBuilder
        public List<Integer> getCityIdListList() {
            return this.cityIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReqOrBuilder
        public int getCityIdListCount() {
            return this.cityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReqOrBuilder
        public int getCityIdList(int index) {
            return this.cityIdList_.getInt(index);
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
            if (getCityIdListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.cityIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.cityIdList_.size(); i++) {
                output.writeUInt32NoTag(this.cityIdList_.getInt(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.cityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.cityIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getCityIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.cityIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetBlossomBriefInfoListReq)) {
                return equals(obj);
            }
            GetBlossomBriefInfoListReq other = (GetBlossomBriefInfoListReq) obj;
            return getCityIdListList().equals(other.getCityIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCityIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getCityIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetBlossomBriefInfoListReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetBlossomBriefInfoListReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetBlossomBriefInfoListReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetBlossomBriefInfoListReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetBlossomBriefInfoListReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetBlossomBriefInfoListReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetBlossomBriefInfoListReq parseFrom(InputStream input) throws IOException {
            return (GetBlossomBriefInfoListReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetBlossomBriefInfoListReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetBlossomBriefInfoListReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetBlossomBriefInfoListReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetBlossomBriefInfoListReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetBlossomBriefInfoListReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetBlossomBriefInfoListReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetBlossomBriefInfoListReq parseFrom(CodedInputStream input) throws IOException {
            return (GetBlossomBriefInfoListReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetBlossomBriefInfoListReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetBlossomBriefInfoListReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetBlossomBriefInfoListReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetBlossomBriefInfoListReqOuterClass$GetBlossomBriefInfoListReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetBlossomBriefInfoListReqOrBuilder {
            private int bitField0_;
            private Internal.IntList cityIdList_ = GetBlossomBriefInfoListReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetBlossomBriefInfoListReqOuterClass.internal_static_GetBlossomBriefInfoListReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetBlossomBriefInfoListReqOuterClass.internal_static_GetBlossomBriefInfoListReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetBlossomBriefInfoListReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetBlossomBriefInfoListReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.cityIdList_ = GetBlossomBriefInfoListReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetBlossomBriefInfoListReqOuterClass.internal_static_GetBlossomBriefInfoListReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetBlossomBriefInfoListReq getDefaultInstanceForType() {
                return GetBlossomBriefInfoListReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetBlossomBriefInfoListReq build() {
                GetBlossomBriefInfoListReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetBlossomBriefInfoListReq buildPartial() {
                GetBlossomBriefInfoListReq result = new GetBlossomBriefInfoListReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.cityIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.cityIdList_ = this.cityIdList_;
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
                if (other instanceof GetBlossomBriefInfoListReq) {
                    return mergeFrom((GetBlossomBriefInfoListReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetBlossomBriefInfoListReq other) {
                if (other == GetBlossomBriefInfoListReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.cityIdList_.isEmpty()) {
                    if (this.cityIdList_.isEmpty()) {
                        this.cityIdList_ = other.cityIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCityIdListIsMutable();
                        this.cityIdList_.addAll(other.cityIdList_);
                    }
                    onChanged();
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
                GetBlossomBriefInfoListReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetBlossomBriefInfoListReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetBlossomBriefInfoListReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCityIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.cityIdList_ = GetBlossomBriefInfoListReq.mutableCopy(this.cityIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReqOrBuilder
            public List<Integer> getCityIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.cityIdList_) : this.cityIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReqOrBuilder
            public int getCityIdListCount() {
                return this.cityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetBlossomBriefInfoListReqOuterClass.GetBlossomBriefInfoListReqOrBuilder
            public int getCityIdList(int index) {
                return this.cityIdList_.getInt(index);
            }

            public Builder setCityIdList(int index, int value) {
                ensureCityIdListIsMutable();
                this.cityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCityIdList(int value) {
                ensureCityIdListIsMutable();
                this.cityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCityIdList(Iterable<? extends Integer> values) {
                ensureCityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.cityIdList_);
                onChanged();
                return this;
            }

            public Builder clearCityIdList() {
                this.cityIdList_ = GetBlossomBriefInfoListReq.emptyIntList();
                this.bitField0_ &= -2;
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

        public static GetBlossomBriefInfoListReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetBlossomBriefInfoListReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetBlossomBriefInfoListReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetBlossomBriefInfoListReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
