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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeReqOuterClass.class */
public final class TryEnterHomeReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015TryEnterHomeReq.proto\"^\n\u000fTryEnterHomeReq\u0012!\n\u0019is_transfer_to_safe_point\u0018\r \u0001(\b\u0012\u0014\n\ftarget_point\u0018\n \u0001(\r\u0012\u0012\n\ntarget_uid\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TryEnterHomeReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TryEnterHomeReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TryEnterHomeReq_descriptor, new String[]{"IsTransferToSafePoint", "TargetPoint", "TargetUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeReqOuterClass$TryEnterHomeReqOrBuilder.class */
    public interface TryEnterHomeReqOrBuilder extends MessageOrBuilder {
        boolean getIsTransferToSafePoint();

        int getTargetPoint();

        int getTargetUid();
    }

    private TryEnterHomeReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeReqOuterClass$TryEnterHomeReq.class */
    public static final class TryEnterHomeReq extends GeneratedMessageV3 implements TryEnterHomeReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_TRANSFER_TO_SAFE_POINT_FIELD_NUMBER = 13;
        private boolean isTransferToSafePoint_;
        public static final int TARGET_POINT_FIELD_NUMBER = 10;
        private int targetPoint_;
        public static final int TARGET_UID_FIELD_NUMBER = 1;
        private int targetUid_;
        private byte memoizedIsInitialized;
        private static final TryEnterHomeReq DEFAULT_INSTANCE = new TryEnterHomeReq();
        private static final Parser<TryEnterHomeReq> PARSER = new AbstractParser<TryEnterHomeReq>() { // from class: emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReq.1
            @Override // com.google.protobuf.Parser
            public TryEnterHomeReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TryEnterHomeReq(input, extensionRegistry);
            }
        };

        private TryEnterHomeReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TryEnterHomeReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TryEnterHomeReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TryEnterHomeReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.targetUid_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.targetPoint_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.isTransferToSafePoint_ = input.readBool();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TryEnterHomeReqOuterClass.internal_static_TryEnterHomeReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TryEnterHomeReqOuterClass.internal_static_TryEnterHomeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TryEnterHomeReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReqOrBuilder
        public boolean getIsTransferToSafePoint() {
            return this.isTransferToSafePoint_;
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReqOrBuilder
        public int getTargetPoint() {
            return this.targetPoint_;
        }

        @Override // emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReqOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
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
            if (this.targetUid_ != 0) {
                output.writeUInt32(1, this.targetUid_);
            }
            if (this.targetPoint_ != 0) {
                output.writeUInt32(10, this.targetPoint_);
            }
            if (this.isTransferToSafePoint_) {
                output.writeBool(13, this.isTransferToSafePoint_);
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
            if (this.targetUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.targetUid_);
            }
            if (this.targetPoint_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.targetPoint_);
            }
            if (this.isTransferToSafePoint_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isTransferToSafePoint_);
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
            if (!(obj instanceof TryEnterHomeReq)) {
                return equals(obj);
            }
            TryEnterHomeReq other = (TryEnterHomeReq) obj;
            return getIsTransferToSafePoint() == other.getIsTransferToSafePoint() && getTargetPoint() == other.getTargetPoint() && getTargetUid() == other.getTargetUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + Internal.hashBoolean(getIsTransferToSafePoint()))) + 10)) + getTargetPoint())) + 1)) + getTargetUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TryEnterHomeReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TryEnterHomeReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TryEnterHomeReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TryEnterHomeReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TryEnterHomeReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TryEnterHomeReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TryEnterHomeReq parseFrom(InputStream input) throws IOException {
            return (TryEnterHomeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TryEnterHomeReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TryEnterHomeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TryEnterHomeReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TryEnterHomeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TryEnterHomeReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TryEnterHomeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TryEnterHomeReq parseFrom(CodedInputStream input) throws IOException {
            return (TryEnterHomeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TryEnterHomeReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TryEnterHomeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TryEnterHomeReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TryEnterHomeReqOuterClass$TryEnterHomeReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TryEnterHomeReqOrBuilder {
            private boolean isTransferToSafePoint_;
            private int targetPoint_;
            private int targetUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TryEnterHomeReqOuterClass.internal_static_TryEnterHomeReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TryEnterHomeReqOuterClass.internal_static_TryEnterHomeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TryEnterHomeReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TryEnterHomeReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isTransferToSafePoint_ = false;
                this.targetPoint_ = 0;
                this.targetUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TryEnterHomeReqOuterClass.internal_static_TryEnterHomeReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TryEnterHomeReq getDefaultInstanceForType() {
                return TryEnterHomeReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TryEnterHomeReq build() {
                TryEnterHomeReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TryEnterHomeReq buildPartial() {
                TryEnterHomeReq result = new TryEnterHomeReq(this);
                result.isTransferToSafePoint_ = this.isTransferToSafePoint_;
                result.targetPoint_ = this.targetPoint_;
                result.targetUid_ = this.targetUid_;
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
                if (other instanceof TryEnterHomeReq) {
                    return mergeFrom((TryEnterHomeReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TryEnterHomeReq other) {
                if (other == TryEnterHomeReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsTransferToSafePoint()) {
                    setIsTransferToSafePoint(other.getIsTransferToSafePoint());
                }
                if (other.getTargetPoint() != 0) {
                    setTargetPoint(other.getTargetPoint());
                }
                if (other.getTargetUid() != 0) {
                    setTargetUid(other.getTargetUid());
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
                TryEnterHomeReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TryEnterHomeReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TryEnterHomeReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReqOrBuilder
            public boolean getIsTransferToSafePoint() {
                return this.isTransferToSafePoint_;
            }

            public Builder setIsTransferToSafePoint(boolean value) {
                this.isTransferToSafePoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsTransferToSafePoint() {
                this.isTransferToSafePoint_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReqOrBuilder
            public int getTargetPoint() {
                return this.targetPoint_;
            }

            public Builder setTargetPoint(int value) {
                this.targetPoint_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetPoint() {
                this.targetPoint_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TryEnterHomeReqOuterClass.TryEnterHomeReqOrBuilder
            public int getTargetUid() {
                return this.targetUid_;
            }

            public Builder setTargetUid(int value) {
                this.targetUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = 0;
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

        public static TryEnterHomeReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TryEnterHomeReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TryEnterHomeReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TryEnterHomeReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
