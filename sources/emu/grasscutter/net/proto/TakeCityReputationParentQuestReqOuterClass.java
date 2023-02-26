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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestReqOuterClass.class */
public final class TakeCityReputationParentQuestReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&TakeCityReputationParentQuestReq.proto\"K\n TakeCityReputationParentQuestReq\u0012\u0017\n\u000fparentQuestList\u0018\u0001 \u0003(\r\u0012\u000e\n\u0006cityId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakeCityReputationParentQuestReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TakeCityReputationParentQuestReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f855xac76548c = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeCityReputationParentQuestReq_descriptor, new String[]{"ParentQuestList", "CityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestReqOuterClass$TakeCityReputationParentQuestReqOrBuilder.class */
    public interface TakeCityReputationParentQuestReqOrBuilder extends MessageOrBuilder {
        List<Integer> getParentQuestListList();

        int getParentQuestListCount();

        int getParentQuestList(int i);

        int getCityId();
    }

    private TakeCityReputationParentQuestReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestReqOuterClass$TakeCityReputationParentQuestReq.class */
    public static final class TakeCityReputationParentQuestReq extends GeneratedMessageV3 implements TakeCityReputationParentQuestReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PARENTQUESTLIST_FIELD_NUMBER = 1;
        private Internal.IntList parentQuestList_;
        private int parentQuestListMemoizedSerializedSize;
        public static final int CITYID_FIELD_NUMBER = 9;
        private int cityId_;
        private byte memoizedIsInitialized;
        private static final TakeCityReputationParentQuestReq DEFAULT_INSTANCE = new TakeCityReputationParentQuestReq();
        private static final Parser<TakeCityReputationParentQuestReq> PARSER = new AbstractParser<TakeCityReputationParentQuestReq>() { // from class: emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReq.1
            @Override // com.google.protobuf.Parser
            public TakeCityReputationParentQuestReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeCityReputationParentQuestReq(input, extensionRegistry);
            }
        };

        private TakeCityReputationParentQuestReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.parentQuestListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TakeCityReputationParentQuestReq() {
            this.parentQuestListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.parentQuestList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeCityReputationParentQuestReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeCityReputationParentQuestReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.parentQuestList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.parentQuestList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.parentQuestList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.parentQuestList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 72:
                                    this.cityId_ = input.readUInt32();
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
                    this.parentQuestList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeCityReputationParentQuestReqOuterClass.internal_static_TakeCityReputationParentQuestReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeCityReputationParentQuestReqOuterClass.f855xac76548c.ensureFieldAccessorsInitialized(TakeCityReputationParentQuestReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
        public List<Integer> getParentQuestListList() {
            return this.parentQuestList_;
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
        public int getParentQuestListCount() {
            return this.parentQuestList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
        public int getParentQuestList(int index) {
            return this.parentQuestList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
        public int getCityId() {
            return this.cityId_;
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
            if (getParentQuestListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.parentQuestListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.parentQuestList_.size(); i++) {
                output.writeUInt32NoTag(this.parentQuestList_.getInt(i));
            }
            if (this.cityId_ != 0) {
                output.writeUInt32(9, this.cityId_);
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
            for (int i = 0; i < this.parentQuestList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.parentQuestList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getParentQuestListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.parentQuestListMemoizedSerializedSize = dataSize;
            if (this.cityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.cityId_);
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
            if (!(obj instanceof TakeCityReputationParentQuestReq)) {
                return equals(obj);
            }
            TakeCityReputationParentQuestReq other = (TakeCityReputationParentQuestReq) obj;
            return getParentQuestListList().equals(other.getParentQuestListList()) && getCityId() == other.getCityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getParentQuestListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getParentQuestListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getCityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TakeCityReputationParentQuestReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCityReputationParentQuestReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCityReputationParentQuestReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCityReputationParentQuestReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCityReputationParentQuestReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeCityReputationParentQuestReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeCityReputationParentQuestReq parseFrom(InputStream input) throws IOException {
            return (TakeCityReputationParentQuestReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeCityReputationParentQuestReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCityReputationParentQuestReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeCityReputationParentQuestReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeCityReputationParentQuestReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeCityReputationParentQuestReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCityReputationParentQuestReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeCityReputationParentQuestReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeCityReputationParentQuestReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeCityReputationParentQuestReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeCityReputationParentQuestReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeCityReputationParentQuestReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeCityReputationParentQuestReqOuterClass$TakeCityReputationParentQuestReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeCityReputationParentQuestReqOrBuilder {
            private int bitField0_;
            private Internal.IntList parentQuestList_ = TakeCityReputationParentQuestReq.emptyIntList();
            private int cityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeCityReputationParentQuestReqOuterClass.internal_static_TakeCityReputationParentQuestReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeCityReputationParentQuestReqOuterClass.f855xac76548c.ensureFieldAccessorsInitialized(TakeCityReputationParentQuestReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeCityReputationParentQuestReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.parentQuestList_ = TakeCityReputationParentQuestReq.emptyIntList();
                this.bitField0_ &= -2;
                this.cityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeCityReputationParentQuestReqOuterClass.internal_static_TakeCityReputationParentQuestReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeCityReputationParentQuestReq getDefaultInstanceForType() {
                return TakeCityReputationParentQuestReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeCityReputationParentQuestReq build() {
                TakeCityReputationParentQuestReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeCityReputationParentQuestReq buildPartial() {
                TakeCityReputationParentQuestReq result = new TakeCityReputationParentQuestReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.parentQuestList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.parentQuestList_ = this.parentQuestList_;
                result.cityId_ = this.cityId_;
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
                if (other instanceof TakeCityReputationParentQuestReq) {
                    return mergeFrom((TakeCityReputationParentQuestReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeCityReputationParentQuestReq other) {
                if (other == TakeCityReputationParentQuestReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.parentQuestList_.isEmpty()) {
                    if (this.parentQuestList_.isEmpty()) {
                        this.parentQuestList_ = other.parentQuestList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureParentQuestListIsMutable();
                        this.parentQuestList_.addAll(other.parentQuestList_);
                    }
                    onChanged();
                }
                if (other.getCityId() != 0) {
                    setCityId(other.getCityId());
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
                TakeCityReputationParentQuestReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeCityReputationParentQuestReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeCityReputationParentQuestReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureParentQuestListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.parentQuestList_ = TakeCityReputationParentQuestReq.mutableCopy(this.parentQuestList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
            public List<Integer> getParentQuestListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.parentQuestList_) : this.parentQuestList_;
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
            public int getParentQuestListCount() {
                return this.parentQuestList_.size();
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
            public int getParentQuestList(int index) {
                return this.parentQuestList_.getInt(index);
            }

            public Builder setParentQuestList(int index, int value) {
                ensureParentQuestListIsMutable();
                this.parentQuestList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addParentQuestList(int value) {
                ensureParentQuestListIsMutable();
                this.parentQuestList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllParentQuestList(Iterable<? extends Integer> values) {
                ensureParentQuestListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.parentQuestList_);
                onChanged();
                return this;
            }

            public Builder clearParentQuestList() {
                this.parentQuestList_ = TakeCityReputationParentQuestReq.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeCityReputationParentQuestReqOuterClass.TakeCityReputationParentQuestReqOrBuilder
            public int getCityId() {
                return this.cityId_;
            }

            public Builder setCityId(int value) {
                this.cityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCityId() {
                this.cityId_ = 0;
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

        public static TakeCityReputationParentQuestReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeCityReputationParentQuestReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeCityReputationParentQuestReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeCityReputationParentQuestReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
