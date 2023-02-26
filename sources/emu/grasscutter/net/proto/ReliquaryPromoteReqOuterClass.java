package emu.grasscutter.net.proto;

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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteReqOuterClass.class */
public final class ReliquaryPromoteReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ReliquaryPromoteReq.proto\";\n\u0013ReliquaryPromoteReq\u0012\u0010\n\bitemGuid\u0018\n \u0001(\u0004\u0012\u0012\n\ntargetGuid\u0018\f \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ReliquaryPromoteReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ReliquaryPromoteReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ReliquaryPromoteReq_descriptor, new String[]{"ItemGuid", "TargetGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteReqOuterClass$ReliquaryPromoteReqOrBuilder.class */
    public interface ReliquaryPromoteReqOrBuilder extends MessageOrBuilder {
        long getItemGuid();

        long getTargetGuid();
    }

    private ReliquaryPromoteReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteReqOuterClass$ReliquaryPromoteReq.class */
    public static final class ReliquaryPromoteReq extends GeneratedMessageV3 implements ReliquaryPromoteReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ITEMGUID_FIELD_NUMBER = 10;
        private long itemGuid_;
        public static final int TARGETGUID_FIELD_NUMBER = 12;
        private long targetGuid_;
        private byte memoizedIsInitialized;
        private static final ReliquaryPromoteReq DEFAULT_INSTANCE = new ReliquaryPromoteReq();
        private static final Parser<ReliquaryPromoteReq> PARSER = new AbstractParser<ReliquaryPromoteReq>() { // from class: emu.grasscutter.net.proto.ReliquaryPromoteReqOuterClass.ReliquaryPromoteReq.1
            @Override // com.google.protobuf.Parser
            public ReliquaryPromoteReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ReliquaryPromoteReq(input, extensionRegistry);
            }
        };

        private ReliquaryPromoteReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ReliquaryPromoteReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ReliquaryPromoteReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ReliquaryPromoteReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 80:
                                this.itemGuid_ = input.readUInt64();
                                break;
                            case 96:
                                this.targetGuid_ = input.readUInt64();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReliquaryPromoteReqOuterClass.internal_static_ReliquaryPromoteReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryPromoteReqOuterClass.internal_static_ReliquaryPromoteReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryPromoteReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteReqOuterClass.ReliquaryPromoteReqOrBuilder
        public long getItemGuid() {
            return this.itemGuid_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteReqOuterClass.ReliquaryPromoteReqOrBuilder
        public long getTargetGuid() {
            return this.targetGuid_;
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
            if (this.itemGuid_ != 0) {
                output.writeUInt64(10, this.itemGuid_);
            }
            if (this.targetGuid_ != 0) {
                output.writeUInt64(12, this.targetGuid_);
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
            if (this.itemGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(10, this.itemGuid_);
            }
            if (this.targetGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(12, this.targetGuid_);
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
            if (!(obj instanceof ReliquaryPromoteReq)) {
                return equals(obj);
            }
            ReliquaryPromoteReq other = (ReliquaryPromoteReq) obj;
            return getItemGuid() == other.getItemGuid() && getTargetGuid() == other.getTargetGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Internal.hashLong(getItemGuid()))) + 12)) + Internal.hashLong(getTargetGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ReliquaryPromoteReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryPromoteReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryPromoteReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryPromoteReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryPromoteReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryPromoteReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryPromoteReq parseFrom(InputStream input) throws IOException {
            return (ReliquaryPromoteReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryPromoteReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryPromoteReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryPromoteReq parseDelimitedFrom(InputStream input) throws IOException {
            return (ReliquaryPromoteReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ReliquaryPromoteReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryPromoteReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryPromoteReq parseFrom(CodedInputStream input) throws IOException {
            return (ReliquaryPromoteReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryPromoteReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryPromoteReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReliquaryPromoteReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteReqOuterClass$ReliquaryPromoteReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryPromoteReqOrBuilder {
            private long itemGuid_;
            private long targetGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryPromoteReqOuterClass.internal_static_ReliquaryPromoteReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryPromoteReqOuterClass.internal_static_ReliquaryPromoteReq_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryPromoteReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ReliquaryPromoteReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.itemGuid_ = 0;
                this.targetGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryPromoteReqOuterClass.internal_static_ReliquaryPromoteReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReliquaryPromoteReq getDefaultInstanceForType() {
                return ReliquaryPromoteReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryPromoteReq build() {
                ReliquaryPromoteReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryPromoteReq buildPartial() {
                ReliquaryPromoteReq result = new ReliquaryPromoteReq(this);
                result.itemGuid_ = this.itemGuid_;
                result.targetGuid_ = this.targetGuid_;
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
                if (other instanceof ReliquaryPromoteReq) {
                    return mergeFrom((ReliquaryPromoteReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ReliquaryPromoteReq other) {
                if (other == ReliquaryPromoteReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getItemGuid() != 0) {
                    setItemGuid(other.getItemGuid());
                }
                if (other.getTargetGuid() != 0) {
                    setTargetGuid(other.getTargetGuid());
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
                ReliquaryPromoteReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = ReliquaryPromoteReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ReliquaryPromoteReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteReqOuterClass.ReliquaryPromoteReqOrBuilder
            public long getItemGuid() {
                return this.itemGuid_;
            }

            public Builder setItemGuid(long value) {
                this.itemGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearItemGuid() {
                this.itemGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteReqOuterClass.ReliquaryPromoteReqOrBuilder
            public long getTargetGuid() {
                return this.targetGuid_;
            }

            public Builder setTargetGuid(long value) {
                this.targetGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetGuid() {
                this.targetGuid_ = 0;
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

        public static ReliquaryPromoteReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReliquaryPromoteReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReliquaryPromoteReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReliquaryPromoteReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
