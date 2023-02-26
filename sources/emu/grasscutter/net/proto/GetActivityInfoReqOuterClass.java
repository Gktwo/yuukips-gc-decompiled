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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoReqOuterClass.class */
public final class GetActivityInfoReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018GetActivityInfoReq.proto\",\n\u0012GetActivityInfoReq\u0012\u0016\n\u000eactivityIdList\u0018\u000f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetActivityInfoReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetActivityInfoReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetActivityInfoReq_descriptor, new String[]{"ActivityIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoReqOuterClass$GetActivityInfoReqOrBuilder.class */
    public interface GetActivityInfoReqOrBuilder extends MessageOrBuilder {
        List<Integer> getActivityIdListList();

        int getActivityIdListCount();

        int getActivityIdList(int i);
    }

    private GetActivityInfoReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoReqOuterClass$GetActivityInfoReq.class */
    public static final class GetActivityInfoReq extends GeneratedMessageV3 implements GetActivityInfoReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVITYIDLIST_FIELD_NUMBER = 15;
        private Internal.IntList activityIdList_;
        private int activityIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final GetActivityInfoReq DEFAULT_INSTANCE = new GetActivityInfoReq();
        private static final Parser<GetActivityInfoReq> PARSER = new AbstractParser<GetActivityInfoReq>() { // from class: emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReq.1
            @Override // com.google.protobuf.Parser
            public GetActivityInfoReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetActivityInfoReq(input, extensionRegistry);
            }
        };

        private GetActivityInfoReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.activityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetActivityInfoReq() {
            this.activityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.activityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetActivityInfoReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetActivityInfoReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 120:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.activityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.activityIdList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.activityIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.activityIdList_.addInt(input.readUInt32());
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
                    this.activityIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetActivityInfoReqOuterClass.internal_static_GetActivityInfoReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetActivityInfoReqOuterClass.internal_static_GetActivityInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetActivityInfoReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReqOrBuilder
        public List<Integer> getActivityIdListList() {
            return this.activityIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReqOrBuilder
        public int getActivityIdListCount() {
            return this.activityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReqOrBuilder
        public int getActivityIdList(int index) {
            return this.activityIdList_.getInt(index);
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
            if (getActivityIdListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.activityIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.activityIdList_.size(); i++) {
                output.writeUInt32NoTag(this.activityIdList_.getInt(i));
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
            for (int i = 0; i < this.activityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.activityIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getActivityIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.activityIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetActivityInfoReq)) {
                return equals(obj);
            }
            GetActivityInfoReq other = (GetActivityInfoReq) obj;
            return getActivityIdListList().equals(other.getActivityIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getActivityIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getActivityIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetActivityInfoReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityInfoReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityInfoReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityInfoReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityInfoReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetActivityInfoReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetActivityInfoReq parseFrom(InputStream input) throws IOException {
            return (GetActivityInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetActivityInfoReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetActivityInfoReq parseDelimitedFrom(InputStream input) throws IOException {
            return (GetActivityInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetActivityInfoReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetActivityInfoReq parseFrom(CodedInputStream input) throws IOException {
            return (GetActivityInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetActivityInfoReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetActivityInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetActivityInfoReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetActivityInfoReqOuterClass$GetActivityInfoReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetActivityInfoReqOrBuilder {
            private int bitField0_;
            private Internal.IntList activityIdList_ = GetActivityInfoReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetActivityInfoReqOuterClass.internal_static_GetActivityInfoReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetActivityInfoReqOuterClass.internal_static_GetActivityInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(GetActivityInfoReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetActivityInfoReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activityIdList_ = GetActivityInfoReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetActivityInfoReqOuterClass.internal_static_GetActivityInfoReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetActivityInfoReq getDefaultInstanceForType() {
                return GetActivityInfoReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetActivityInfoReq build() {
                GetActivityInfoReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetActivityInfoReq buildPartial() {
                GetActivityInfoReq result = new GetActivityInfoReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.activityIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.activityIdList_ = this.activityIdList_;
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
                if (other instanceof GetActivityInfoReq) {
                    return mergeFrom((GetActivityInfoReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetActivityInfoReq other) {
                if (other == GetActivityInfoReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.activityIdList_.isEmpty()) {
                    if (this.activityIdList_.isEmpty()) {
                        this.activityIdList_ = other.activityIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureActivityIdListIsMutable();
                        this.activityIdList_.addAll(other.activityIdList_);
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
                GetActivityInfoReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetActivityInfoReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetActivityInfoReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureActivityIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.activityIdList_ = GetActivityInfoReq.mutableCopy(this.activityIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReqOrBuilder
            public List<Integer> getActivityIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.activityIdList_) : this.activityIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReqOrBuilder
            public int getActivityIdListCount() {
                return this.activityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetActivityInfoReqOuterClass.GetActivityInfoReqOrBuilder
            public int getActivityIdList(int index) {
                return this.activityIdList_.getInt(index);
            }

            public Builder setActivityIdList(int index, int value) {
                ensureActivityIdListIsMutable();
                this.activityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addActivityIdList(int value) {
                ensureActivityIdListIsMutable();
                this.activityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllActivityIdList(Iterable<? extends Integer> values) {
                ensureActivityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activityIdList_);
                onChanged();
                return this;
            }

            public Builder clearActivityIdList() {
                this.activityIdList_ = GetActivityInfoReq.emptyIntList();
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

        public static GetActivityInfoReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetActivityInfoReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetActivityInfoReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetActivityInfoReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
