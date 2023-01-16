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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterReqOuterClass.class */
public final class GetInvestigationMonsterReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n GetInvestigationMonsterReq.proto\"G\n\u001aGetInvestigationMonsterReq\u0012\u0013\n\u000bis_for_mark\u0018\b \u0001(\b\u0012\u0014\n\fcity_id_list\u0018\u000b \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetInvestigationMonsterReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetInvestigationMonsterReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetInvestigationMonsterReq_descriptor, new String[]{"IsForMark", "CityIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterReqOuterClass$GetInvestigationMonsterReqOrBuilder.class */
    public interface GetInvestigationMonsterReqOrBuilder extends MessageOrBuilder {
        boolean getIsForMark();

        List<Integer> getCityIdListList();

        int getCityIdListCount();

        int getCityIdList(int i);
    }

    private GetInvestigationMonsterReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterReqOuterClass$GetInvestigationMonsterReq.class */
    public static final class GetInvestigationMonsterReq extends GeneratedMessageV3 implements GetInvestigationMonsterReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FOR_MARK_FIELD_NUMBER = 8;
        private boolean isForMark_;
        public static final int CITY_ID_LIST_FIELD_NUMBER = 11;
        private Internal.IntList cityIdList_;
        private int cityIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GetInvestigationMonsterReq DEFAULT_INSTANCE = new GetInvestigationMonsterReq();
        private static final Parser<GetInvestigationMonsterReq> PARSER = new AbstractParser<GetInvestigationMonsterReq>() { // from class: emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReq.1
            @Override // com.google.protobuf.Parser
            public GetInvestigationMonsterReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetInvestigationMonsterReq(input, extensionRegistry);
            }
        };

        private GetInvestigationMonsterReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.cityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetInvestigationMonsterReq() {
            this.cityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.cityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetInvestigationMonsterReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetInvestigationMonsterReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 64:
                                    this.isForMark_ = input.readBool();
                                    break;
                                case 88:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.cityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.cityIdList_.addInt(input.readUInt32());
                                    break;
                                case 90:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
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
            return GetInvestigationMonsterReqOuterClass.internal_static_GetInvestigationMonsterReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetInvestigationMonsterReqOuterClass.internal_static_GetInvestigationMonsterReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetInvestigationMonsterReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
        public boolean getIsForMark() {
            return this.isForMark_;
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
        public List<Integer> getCityIdListList() {
            return this.cityIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
        public int getCityIdListCount() {
            return this.cityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
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
            if (this.isForMark_) {
                output.writeBool(8, this.isForMark_);
            }
            if (getCityIdListList().size() > 0) {
                output.writeUInt32NoTag(90);
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
            int size2 = 0;
            if (this.isForMark_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(8, this.isForMark_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.cityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.cityIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getCityIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.cityIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetInvestigationMonsterReq)) {
                return equals(obj);
            }
            GetInvestigationMonsterReq other = (GetInvestigationMonsterReq) obj;
            return getIsForMark() == other.getIsForMark() && getCityIdListList().equals(other.getCityIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsForMark());
            if (getCityIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getCityIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetInvestigationMonsterReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetInvestigationMonsterReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetInvestigationMonsterReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetInvestigationMonsterReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetInvestigationMonsterReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetInvestigationMonsterReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetInvestigationMonsterReq parseFrom(InputStream input) throws IOException {
            return (GetInvestigationMonsterReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetInvestigationMonsterReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetInvestigationMonsterReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetInvestigationMonsterReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetInvestigationMonsterReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetInvestigationMonsterReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetInvestigationMonsterReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetInvestigationMonsterReq parseFrom(CodedInputStream input) throws IOException {
            return (GetInvestigationMonsterReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetInvestigationMonsterReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetInvestigationMonsterReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetInvestigationMonsterReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetInvestigationMonsterReqOuterClass$GetInvestigationMonsterReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetInvestigationMonsterReqOrBuilder {
            private int bitField0_;
            private boolean isForMark_;
            private Internal.IntList cityIdList_ = GetInvestigationMonsterReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetInvestigationMonsterReqOuterClass.internal_static_GetInvestigationMonsterReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetInvestigationMonsterReqOuterClass.internal_static_GetInvestigationMonsterReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetInvestigationMonsterReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetInvestigationMonsterReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isForMark_ = false;
                this.cityIdList_ = GetInvestigationMonsterReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetInvestigationMonsterReqOuterClass.internal_static_GetInvestigationMonsterReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetInvestigationMonsterReq getDefaultInstanceForType() {
                return GetInvestigationMonsterReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetInvestigationMonsterReq build() {
                GetInvestigationMonsterReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetInvestigationMonsterReq buildPartial() {
                GetInvestigationMonsterReq result = new GetInvestigationMonsterReq(this);
                int i = this.bitField0_;
                result.isForMark_ = this.isForMark_;
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
                if (other instanceof GetInvestigationMonsterReq) {
                    return mergeFrom((GetInvestigationMonsterReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetInvestigationMonsterReq other) {
                if (other == GetInvestigationMonsterReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsForMark()) {
                    setIsForMark(other.getIsForMark());
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
                GetInvestigationMonsterReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetInvestigationMonsterReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetInvestigationMonsterReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
            public boolean getIsForMark() {
                return this.isForMark_;
            }

            public Builder setIsForMark(boolean value) {
                this.isForMark_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsForMark() {
                this.isForMark_ = false;
                onChanged();
                return this;
            }

            private void ensureCityIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.cityIdList_ = GetInvestigationMonsterReq.mutableCopy(this.cityIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
            public List<Integer> getCityIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.cityIdList_) : this.cityIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
            public int getCityIdListCount() {
                return this.cityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReqOrBuilder
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
                this.cityIdList_ = GetInvestigationMonsterReq.emptyIntList();
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

        public static GetInvestigationMonsterReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetInvestigationMonsterReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetInvestigationMonsterReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetInvestigationMonsterReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
