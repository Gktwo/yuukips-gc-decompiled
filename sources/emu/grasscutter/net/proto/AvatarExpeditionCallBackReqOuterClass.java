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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackReqOuterClass.class */
public final class AvatarExpeditionCallBackReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!AvatarExpeditionCallBackReq.proto\"1\n\u001bAvatarExpeditionCallBackReq\u0012\u0012\n\navatarGuid\u0018\u000e \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarExpeditionCallBackReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarExpeditionCallBackReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarExpeditionCallBackReq_descriptor, new String[]{"AvatarGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackReqOuterClass$AvatarExpeditionCallBackReqOrBuilder.class */
    public interface AvatarExpeditionCallBackReqOrBuilder extends MessageOrBuilder {
        List<Long> getAvatarGuidList();

        int getAvatarGuidCount();

        long getAvatarGuid(int i);
    }

    private AvatarExpeditionCallBackReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackReqOuterClass$AvatarExpeditionCallBackReq.class */
    public static final class AvatarExpeditionCallBackReq extends GeneratedMessageV3 implements AvatarExpeditionCallBackReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AVATARGUID_FIELD_NUMBER = 14;
        private Internal.LongList avatarGuid_;
        private int avatarGuidMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final AvatarExpeditionCallBackReq DEFAULT_INSTANCE = new AvatarExpeditionCallBackReq();
        private static final Parser<AvatarExpeditionCallBackReq> PARSER = new AbstractParser<AvatarExpeditionCallBackReq>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReq.1
            @Override // com.google.protobuf.Parser
            public AvatarExpeditionCallBackReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarExpeditionCallBackReq(input, extensionRegistry);
            }
        };

        private AvatarExpeditionCallBackReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarGuidMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarExpeditionCallBackReq() {
            this.avatarGuidMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarGuid_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarExpeditionCallBackReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarExpeditionCallBackReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 112:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.avatarGuid_ = newLongList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.avatarGuid_.addLong(input.readUInt64());
                                    break;
                                case 114:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.avatarGuid_ = newLongList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.avatarGuid_.addLong(input.readUInt64());
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
                    this.avatarGuid_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarExpeditionCallBackReqOuterClass.internal_static_AvatarExpeditionCallBackReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarExpeditionCallBackReqOuterClass.internal_static_AvatarExpeditionCallBackReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionCallBackReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReqOrBuilder
        public List<Long> getAvatarGuidList() {
            return this.avatarGuid_;
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReqOrBuilder
        public int getAvatarGuidCount() {
            return this.avatarGuid_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReqOrBuilder
        public long getAvatarGuid(int index) {
            return this.avatarGuid_.getLong(index);
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
            if (getAvatarGuidList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.avatarGuidMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarGuid_.size(); i++) {
                output.writeUInt64NoTag(this.avatarGuid_.getLong(i));
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
            for (int i = 0; i < this.avatarGuid_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.avatarGuid_.getLong(i));
            }
            int size2 = 0 + dataSize;
            if (!getAvatarGuidList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarGuidMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AvatarExpeditionCallBackReq)) {
                return equals(obj);
            }
            AvatarExpeditionCallBackReq other = (AvatarExpeditionCallBackReq) obj;
            return getAvatarGuidList().equals(other.getAvatarGuidList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAvatarGuidCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getAvatarGuidList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarExpeditionCallBackReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionCallBackReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionCallBackReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionCallBackReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionCallBackReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarExpeditionCallBackReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarExpeditionCallBackReq parseFrom(InputStream input) throws IOException {
            return (AvatarExpeditionCallBackReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionCallBackReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionCallBackReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionCallBackReq parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarExpeditionCallBackReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarExpeditionCallBackReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionCallBackReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarExpeditionCallBackReq parseFrom(CodedInputStream input) throws IOException {
            return (AvatarExpeditionCallBackReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarExpeditionCallBackReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarExpeditionCallBackReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarExpeditionCallBackReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionCallBackReqOuterClass$AvatarExpeditionCallBackReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarExpeditionCallBackReqOrBuilder {
            private int bitField0_;
            private Internal.LongList avatarGuid_ = AvatarExpeditionCallBackReq.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarExpeditionCallBackReqOuterClass.internal_static_AvatarExpeditionCallBackReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarExpeditionCallBackReqOuterClass.internal_static_AvatarExpeditionCallBackReq_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarExpeditionCallBackReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarExpeditionCallBackReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.avatarGuid_ = AvatarExpeditionCallBackReq.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarExpeditionCallBackReqOuterClass.internal_static_AvatarExpeditionCallBackReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarExpeditionCallBackReq getDefaultInstanceForType() {
                return AvatarExpeditionCallBackReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionCallBackReq build() {
                AvatarExpeditionCallBackReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarExpeditionCallBackReq buildPartial() {
                AvatarExpeditionCallBackReq result = new AvatarExpeditionCallBackReq(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarGuid_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarGuid_ = this.avatarGuid_;
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
                if (other instanceof AvatarExpeditionCallBackReq) {
                    return mergeFrom((AvatarExpeditionCallBackReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarExpeditionCallBackReq other) {
                if (other == AvatarExpeditionCallBackReq.getDefaultInstance()) {
                    return this;
                }
                if (!other.avatarGuid_.isEmpty()) {
                    if (this.avatarGuid_.isEmpty()) {
                        this.avatarGuid_ = other.avatarGuid_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAvatarGuidIsMutable();
                        this.avatarGuid_.addAll(other.avatarGuid_);
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
                AvatarExpeditionCallBackReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarExpeditionCallBackReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarExpeditionCallBackReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAvatarGuidIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarGuid_ = AvatarExpeditionCallBackReq.mutableCopy(this.avatarGuid_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReqOrBuilder
            public List<Long> getAvatarGuidList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarGuid_) : this.avatarGuid_;
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReqOrBuilder
            public int getAvatarGuidCount() {
                return this.avatarGuid_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarExpeditionCallBackReqOuterClass.AvatarExpeditionCallBackReqOrBuilder
            public long getAvatarGuid(int index) {
                return this.avatarGuid_.getLong(index);
            }

            public Builder setAvatarGuid(int index, long value) {
                ensureAvatarGuidIsMutable();
                this.avatarGuid_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarGuid(long value) {
                ensureAvatarGuidIsMutable();
                this.avatarGuid_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarGuid(Iterable<? extends Long> values) {
                ensureAvatarGuidIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarGuid_);
                onChanged();
                return this;
            }

            public Builder clearAvatarGuid() {
                this.avatarGuid_ = AvatarExpeditionCallBackReq.emptyLongList();
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

        public static AvatarExpeditionCallBackReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarExpeditionCallBackReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarExpeditionCallBackReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarExpeditionCallBackReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
