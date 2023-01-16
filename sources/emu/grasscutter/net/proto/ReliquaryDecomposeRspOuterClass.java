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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeRspOuterClass.class */
public final class ReliquaryDecomposeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bReliquaryDecomposeRsp.proto\";\n\u0015ReliquaryDecomposeRsp\u0012\u0011\n\tguid_list\u0018\u0006 \u0003(\u0004\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ReliquaryDecomposeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ReliquaryDecomposeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ReliquaryDecomposeRsp_descriptor, new String[]{"GuidList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeRspOuterClass$ReliquaryDecomposeRspOrBuilder.class */
    public interface ReliquaryDecomposeRspOrBuilder extends MessageOrBuilder {
        List<Long> getGuidListList();

        int getGuidListCount();

        long getGuidList(int i);

        int getRetcode();
    }

    private ReliquaryDecomposeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeRspOuterClass$ReliquaryDecomposeRsp.class */
    public static final class ReliquaryDecomposeRsp extends GeneratedMessageV3 implements ReliquaryDecomposeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUID_LIST_FIELD_NUMBER = 6;
        private Internal.LongList guidList_;
        private int guidListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final ReliquaryDecomposeRsp DEFAULT_INSTANCE = new ReliquaryDecomposeRsp();
        private static final Parser<ReliquaryDecomposeRsp> PARSER = new AbstractParser<ReliquaryDecomposeRsp>() { // from class: emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRsp.1
            @Override // com.google.protobuf.Parser
            public ReliquaryDecomposeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ReliquaryDecomposeRsp(input, extensionRegistry);
            }
        };

        private ReliquaryDecomposeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.guidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ReliquaryDecomposeRsp() {
            this.guidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.guidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ReliquaryDecomposeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReliquaryDecomposeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.guidList_ = newLongList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.guidList_.addLong(input.readUInt64());
                                    break;
                                case 50:
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
                                case 88:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
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
            return ReliquaryDecomposeRspOuterClass.internal_static_ReliquaryDecomposeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryDecomposeRspOuterClass.internal_static_ReliquaryDecomposeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryDecomposeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
        public List<Long> getGuidListList() {
            return this.guidList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
        public int getGuidListCount() {
            return this.guidList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
        public long getGuidList(int index) {
            return this.guidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
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
            if (getGuidListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.guidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.guidList_.size(); i++) {
                output.writeUInt64NoTag(this.guidList_.getLong(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
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
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.retcode_);
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
            if (!(obj instanceof ReliquaryDecomposeRsp)) {
                return equals(obj);
            }
            ReliquaryDecomposeRsp other = (ReliquaryDecomposeRsp) obj;
            return getGuidListList().equals(other.getGuidListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getGuidListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ReliquaryDecomposeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryDecomposeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryDecomposeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryDecomposeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryDecomposeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryDecomposeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryDecomposeRsp parseFrom(InputStream input) throws IOException {
            return (ReliquaryDecomposeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryDecomposeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryDecomposeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryDecomposeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ReliquaryDecomposeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ReliquaryDecomposeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryDecomposeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryDecomposeRsp parseFrom(CodedInputStream input) throws IOException {
            return (ReliquaryDecomposeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryDecomposeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryDecomposeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReliquaryDecomposeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryDecomposeRspOuterClass$ReliquaryDecomposeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryDecomposeRspOrBuilder {
            private int bitField0_;
            private Internal.LongList guidList_ = ReliquaryDecomposeRsp.emptyLongList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryDecomposeRspOuterClass.internal_static_ReliquaryDecomposeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryDecomposeRspOuterClass.internal_static_ReliquaryDecomposeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryDecomposeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ReliquaryDecomposeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guidList_ = ReliquaryDecomposeRsp.emptyLongList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryDecomposeRspOuterClass.internal_static_ReliquaryDecomposeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReliquaryDecomposeRsp getDefaultInstanceForType() {
                return ReliquaryDecomposeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryDecomposeRsp build() {
                ReliquaryDecomposeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryDecomposeRsp buildPartial() {
                ReliquaryDecomposeRsp result = new ReliquaryDecomposeRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.guidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.guidList_ = this.guidList_;
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
                if (other instanceof ReliquaryDecomposeRsp) {
                    return mergeFrom((ReliquaryDecomposeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ReliquaryDecomposeRsp other) {
                if (other == ReliquaryDecomposeRsp.getDefaultInstance()) {
                    return this;
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
                ReliquaryDecomposeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ReliquaryDecomposeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ReliquaryDecomposeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.guidList_ = ReliquaryDecomposeRsp.mutableCopy(this.guidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
            public List<Long> getGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.guidList_) : this.guidList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
            public int getGuidListCount() {
                return this.guidList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
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
                this.guidList_ = ReliquaryDecomposeRsp.emptyLongList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryDecomposeRspOuterClass.ReliquaryDecomposeRspOrBuilder
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

        public static ReliquaryDecomposeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReliquaryDecomposeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReliquaryDecomposeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReliquaryDecomposeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
