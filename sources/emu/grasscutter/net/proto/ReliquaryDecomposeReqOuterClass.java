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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeReqOuterClass.class */
public final class ReliquaryDecomposeReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bReliquaryDecomposeReq.proto\"P\n\u0015ReliquaryDecomposeReq\u0012\u0013\n\u000btargetCount\u0018\u0005 \u0001(\r\u0012\u0010\n\bconfigId\u0018\r \u0001(\r\u0012\u0010\n\bguidList\u0018\u0002 \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ReliquaryDecomposeReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ReliquaryDecomposeReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ReliquaryDecomposeReq_descriptor, new String[]{"TargetCount", "ConfigId", "GuidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeReqOuterClass$ReliquaryDecomposeReqOrBuilder.class */
    public interface ReliquaryDecomposeReqOrBuilder extends MessageOrBuilder {
        int getTargetCount();

        int getConfigId();

        List<Long> getGuidListList();

        int getGuidListCount();

        long getGuidList(int i);
    }

    private ReliquaryDecomposeReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeReqOuterClass$ReliquaryDecomposeReq.class */
    public static final class ReliquaryDecomposeReq extends GeneratedMessageV3 implements ReliquaryDecomposeReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TARGETCOUNT_FIELD_NUMBER = 5;
        private int targetCount_;
        public static final int CONFIGID_FIELD_NUMBER = 13;
        private int configId_;
        public static final int GUIDLIST_FIELD_NUMBER = 2;
        private Internal.LongList guidList_;
        private int guidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ReliquaryDecomposeReq DEFAULT_INSTANCE = new ReliquaryDecomposeReq();
        private static final Parser<ReliquaryDecomposeReq> PARSER = new AbstractParser<ReliquaryDecomposeReq>() { // from class: emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReq.1
            @Override // com.google.protobuf.Parser
            public ReliquaryDecomposeReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ReliquaryDecomposeReq(input, extensionRegistry);
            }
        };

        private ReliquaryDecomposeReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.guidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ReliquaryDecomposeReq() {
            this.guidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.guidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ReliquaryDecomposeReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReliquaryDecomposeReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.guidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.guidList_.addLong(input.readUInt64());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.guidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.guidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                this.targetCount_ = input.readUInt32();
                                break;
                            case 104:
                                this.configId_ = input.readUInt32();
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
                    this.guidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReliquaryDecomposeReqOuterClass.internal_static_ReliquaryDecomposeReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryDecomposeReqOuterClass.internal_static_ReliquaryDecomposeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryDecomposeReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
        public int getTargetCount() {
            return this.targetCount_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
        public List<Long> getGuidListList() {
            return this.guidList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
        public int getGuidListCount() {
            return this.guidList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
        public long getGuidList(int index) {
            return this.guidList_.getLong(index);
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
            if (getGuidListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.guidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.guidList_.size(); i++) {
                output.writeUInt64NoTag(this.guidList_.getLong(i));
            }
            if (this.targetCount_ != 0) {
                output.writeUInt32(5, this.targetCount_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(13, this.configId_);
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
            for (int i = 0; i < this.guidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.guidList_.getLong(i));
            }
            int size2 = 0 + dataSize;
            if (!getGuidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.guidListMemoizedSerializedSize = dataSize;
            if (this.targetCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.targetCount_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.configId_);
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
            if (!(obj instanceof ReliquaryDecomposeReq)) {
                return equals(obj);
            }
            ReliquaryDecomposeReq other = (ReliquaryDecomposeReq) obj;
            return getTargetCount() == other.getTargetCount() && getConfigId() == other.getConfigId() && getGuidListList().equals(other.getGuidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getTargetCount())) + 13)) + getConfigId();
            if (getGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getGuidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ReliquaryDecomposeReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryDecomposeReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryDecomposeReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryDecomposeReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryDecomposeReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryDecomposeReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryDecomposeReq parseFrom(InputStream input) throws IOException {
            return (ReliquaryDecomposeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryDecomposeReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryDecomposeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryDecomposeReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ReliquaryDecomposeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ReliquaryDecomposeReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryDecomposeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryDecomposeReq parseFrom(CodedInputStream input) throws IOException {
            return (ReliquaryDecomposeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryDecomposeReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryDecomposeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReliquaryDecomposeReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeReqOuterClass$ReliquaryDecomposeReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryDecomposeReqOrBuilder {
            private int bitField0_;
            private int targetCount_;
            private int configId_;
            private Internal.LongList guidList_ = ReliquaryDecomposeReq.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryDecomposeReqOuterClass.internal_static_ReliquaryDecomposeReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryDecomposeReqOuterClass.internal_static_ReliquaryDecomposeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryDecomposeReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ReliquaryDecomposeReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.targetCount_ = 0;
                this.configId_ = 0;
                this.guidList_ = ReliquaryDecomposeReq.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryDecomposeReqOuterClass.internal_static_ReliquaryDecomposeReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReliquaryDecomposeReq getDefaultInstanceForType() {
                return ReliquaryDecomposeReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryDecomposeReq build() {
                ReliquaryDecomposeReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryDecomposeReq buildPartial() {
                ReliquaryDecomposeReq result = new ReliquaryDecomposeReq(this);
                int i = this.bitField0_;
                result.targetCount_ = this.targetCount_;
                result.configId_ = this.configId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.guidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.guidList_ = this.guidList_;
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
                if (other instanceof ReliquaryDecomposeReq) {
                    return mergeFrom((ReliquaryDecomposeReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ReliquaryDecomposeReq other) {
                if (other == ReliquaryDecomposeReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getTargetCount() != 0) {
                    setTargetCount(other.getTargetCount());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (!other.guidList_.isEmpty()) {
                    if (this.guidList_.isEmpty()) {
                        this.guidList_ = other.guidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGuidListIsMutable();
                        this.guidList_.addAll(other.guidList_);
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
                ReliquaryDecomposeReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ReliquaryDecomposeReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ReliquaryDecomposeReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
            public int getTargetCount() {
                return this.targetCount_;
            }

            public Builder setTargetCount(int value) {
                this.targetCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetCount() {
                this.targetCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            private void ensureGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.guidList_ = ReliquaryDecomposeReq.mutableCopy(this.guidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
            public List<Long> getGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.guidList_) : this.guidList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
            public int getGuidListCount() {
                return this.guidList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeReqOuterClass.ReliquaryDecomposeReqOrBuilder
            public long getGuidList(int index) {
                return this.guidList_.getLong(index);
            }

            public Builder setGuidList(int index, long value) {
                ensureGuidListIsMutable();
                this.guidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addGuidList(long value) {
                ensureGuidListIsMutable();
                this.guidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllGuidList(Iterable<? extends Long> values) {
                ensureGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.guidList_);
                onChanged();
                return this;
            }

            public Builder clearGuidList() {
                this.guidList_ = ReliquaryDecomposeReq.emptyLongList();
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

        public static ReliquaryDecomposeReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReliquaryDecomposeReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReliquaryDecomposeReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReliquaryDecomposeReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
