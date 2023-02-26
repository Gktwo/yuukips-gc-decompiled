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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelMailReqOuterClass.class */
public final class DelMailReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010DelMailReq.proto\" \n\nDelMailReq\u0012\u0012\n\nmailIdList\u0018\r \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DelMailReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DelMailReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DelMailReq_descriptor, new String[]{"MailIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelMailReqOuterClass$DelMailReqOrBuilder.class */
    public interface DelMailReqOrBuilder extends MessageOrBuilder {
        List<Integer> getMailIdListList();

        int getMailIdListCount();

        int getMailIdList(int i);
    }

    private DelMailReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelMailReqOuterClass$DelMailReq.class */
    public static final class DelMailReq extends GeneratedMessageV3 implements DelMailReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAILIDLIST_FIELD_NUMBER = 13;
        private Internal.IntList mailIdList_;
        private int mailIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final DelMailReq DEFAULT_INSTANCE = new DelMailReq();
        private static final Parser<DelMailReq> PARSER = new AbstractParser<DelMailReq>() { // from class: emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReq.1
            @Override // com.google.protobuf.Parser
            public DelMailReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DelMailReq(input, extensionRegistry);
            }
        };

        private DelMailReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.mailIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private DelMailReq() {
            this.mailIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.mailIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DelMailReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DelMailReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 104:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.mailIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.mailIdList_.addInt(input.readUInt32());
                                    break;
                                case 106:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.mailIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.mailIdList_.addInt(input.readUInt32());
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
                    this.mailIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DelMailReqOuterClass.internal_static_DelMailReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DelMailReqOuterClass.internal_static_DelMailReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DelMailReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReqOrBuilder
        public List<Integer> getMailIdListList() {
            return this.mailIdList_;
        }

        @Override // emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReqOrBuilder
        public int getMailIdListCount() {
            return this.mailIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReqOrBuilder
        public int getMailIdList(int index) {
            return this.mailIdList_.getInt(index);
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
            if (getMailIdListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.mailIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.mailIdList_.size(); i++) {
                output.writeUInt32NoTag(this.mailIdList_.getInt(i));
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
            for (int i = 0; i < this.mailIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.mailIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getMailIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.mailIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DelMailReq)) {
                return equals(obj);
            }
            DelMailReq other = (DelMailReq) obj;
            return getMailIdListList().equals(other.getMailIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMailIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getMailIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DelMailReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelMailReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelMailReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelMailReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelMailReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DelMailReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DelMailReq parseFrom(InputStream input) throws IOException {
            return (DelMailReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DelMailReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelMailReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DelMailReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DelMailReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DelMailReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelMailReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DelMailReq parseFrom(CodedInputStream input) throws IOException {
            return (DelMailReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DelMailReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DelMailReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DelMailReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DelMailReqOuterClass$DelMailReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DelMailReqOrBuilder {
            private int bitField0_;
            private Internal.IntList mailIdList_ = DelMailReq.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DelMailReqOuterClass.internal_static_DelMailReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DelMailReqOuterClass.internal_static_DelMailReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DelMailReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DelMailReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.mailIdList_ = DelMailReq.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DelMailReqOuterClass.internal_static_DelMailReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DelMailReq getDefaultInstanceForType() {
                return DelMailReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DelMailReq build() {
                DelMailReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DelMailReq buildPartial() {
                DelMailReq result = new DelMailReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.mailIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.mailIdList_ = this.mailIdList_;
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
                if (other instanceof DelMailReq) {
                    return mergeFrom((DelMailReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DelMailReq other) {
                if (other == DelMailReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.mailIdList_.isEmpty()) {
                    if (this.mailIdList_.isEmpty()) {
                        this.mailIdList_ = other.mailIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMailIdListIsMutable();
                        this.mailIdList_.addAll(other.mailIdList_);
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
                DelMailReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DelMailReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DelMailReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMailIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.mailIdList_ = DelMailReq.mutableCopy(this.mailIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReqOrBuilder
            public List<Integer> getMailIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.mailIdList_) : this.mailIdList_;
            }

            @Override // emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReqOrBuilder
            public int getMailIdListCount() {
                return this.mailIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.DelMailReqOuterClass.DelMailReqOrBuilder
            public int getMailIdList(int index) {
                return this.mailIdList_.getInt(index);
            }

            public Builder setMailIdList(int index, int value) {
                ensureMailIdListIsMutable();
                this.mailIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addMailIdList(int value) {
                ensureMailIdListIsMutable();
                this.mailIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllMailIdList(Iterable<? extends Integer> values) {
                ensureMailIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mailIdList_);
                onChanged();
                return this;
            }

            public Builder clearMailIdList() {
                this.mailIdList_ = DelMailReq.emptyIntList();
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

        public static DelMailReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DelMailReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DelMailReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DelMailReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
