package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.DealAddFriendResultTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendReqOuterClass.class */
public final class DealAddFriendReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016DealAddFriendReq.proto\u001a\u001dDealAddFriendResultType.proto\"`\n\u0010DealAddFriendReq\u00128\n\u0016deal_add_friend_result\u0018\u0007 \u0001(\u000e2\u0018.DealAddFriendResultType\u0012\u0012\n\ntarget_uid\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DealAddFriendResultTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DealAddFriendReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DealAddFriendReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DealAddFriendReq_descriptor, new String[]{"DealAddFriendResult", "TargetUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendReqOuterClass$DealAddFriendReqOrBuilder.class */
    public interface DealAddFriendReqOrBuilder extends MessageOrBuilder {
        int getDealAddFriendResultValue();

        DealAddFriendResultTypeOuterClass.DealAddFriendResultType getDealAddFriendResult();

        int getTargetUid();
    }

    private DealAddFriendReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendReqOuterClass$DealAddFriendReq.class */
    public static final class DealAddFriendReq extends GeneratedMessageV3 implements DealAddFriendReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DEAL_ADD_FRIEND_RESULT_FIELD_NUMBER = 7;
        private int dealAddFriendResult_;
        public static final int TARGET_UID_FIELD_NUMBER = 10;
        private int targetUid_;
        private byte memoizedIsInitialized;
        private static final DealAddFriendReq DEFAULT_INSTANCE = new DealAddFriendReq();
        private static final Parser<DealAddFriendReq> PARSER = new AbstractParser<DealAddFriendReq>() { // from class: emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReq.1
            @Override // com.google.protobuf.Parser
            public DealAddFriendReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DealAddFriendReq(input, extensionRegistry);
            }
        };

        private DealAddFriendReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DealAddFriendReq() {
            this.memoizedIsInitialized = -1;
            this.dealAddFriendResult_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DealAddFriendReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DealAddFriendReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.dealAddFriendResult_ = input.readEnum();
                                    break;
                                case 80:
                                    this.targetUid_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DealAddFriendReqOuterClass.internal_static_DealAddFriendReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DealAddFriendReqOuterClass.internal_static_DealAddFriendReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DealAddFriendReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReqOrBuilder
        public int getDealAddFriendResultValue() {
            return this.dealAddFriendResult_;
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReqOrBuilder
        public DealAddFriendResultTypeOuterClass.DealAddFriendResultType getDealAddFriendResult() {
            DealAddFriendResultTypeOuterClass.DealAddFriendResultType result = DealAddFriendResultTypeOuterClass.DealAddFriendResultType.valueOf(this.dealAddFriendResult_);
            return result == null ? DealAddFriendResultTypeOuterClass.DealAddFriendResultType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReqOrBuilder
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
            if (this.dealAddFriendResult_ != DealAddFriendResultTypeOuterClass.DealAddFriendResultType.DEAL_ADD_FRIEND_RESULT_TYPE_REJECT.getNumber()) {
                output.writeEnum(7, this.dealAddFriendResult_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(10, this.targetUid_);
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
            if (this.dealAddFriendResult_ != DealAddFriendResultTypeOuterClass.DealAddFriendResultType.DEAL_ADD_FRIEND_RESULT_TYPE_REJECT.getNumber()) {
                size2 = 0 + CodedOutputStream.computeEnumSize(7, this.dealAddFriendResult_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.targetUid_);
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
            if (!(obj instanceof DealAddFriendReq)) {
                return equals(obj);
            }
            DealAddFriendReq other = (DealAddFriendReq) obj;
            return this.dealAddFriendResult_ == other.dealAddFriendResult_ && getTargetUid() == other.getTargetUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + this.dealAddFriendResult_)) + 10)) + getTargetUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DealAddFriendReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DealAddFriendReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DealAddFriendReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DealAddFriendReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DealAddFriendReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DealAddFriendReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DealAddFriendReq parseFrom(InputStream input) throws IOException {
            return (DealAddFriendReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DealAddFriendReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DealAddFriendReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DealAddFriendReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DealAddFriendReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DealAddFriendReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DealAddFriendReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DealAddFriendReq parseFrom(CodedInputStream input) throws IOException {
            return (DealAddFriendReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DealAddFriendReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DealAddFriendReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DealAddFriendReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendReqOuterClass$DealAddFriendReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DealAddFriendReqOrBuilder {
            private int dealAddFriendResult_ = 0;
            private int targetUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DealAddFriendReqOuterClass.internal_static_DealAddFriendReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DealAddFriendReqOuterClass.internal_static_DealAddFriendReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DealAddFriendReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DealAddFriendReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dealAddFriendResult_ = 0;
                this.targetUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DealAddFriendReqOuterClass.internal_static_DealAddFriendReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DealAddFriendReq getDefaultInstanceForType() {
                return DealAddFriendReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DealAddFriendReq build() {
                DealAddFriendReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DealAddFriendReq buildPartial() {
                DealAddFriendReq result = new DealAddFriendReq(this);
                result.dealAddFriendResult_ = this.dealAddFriendResult_;
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
                if (other instanceof DealAddFriendReq) {
                    return mergeFrom((DealAddFriendReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DealAddFriendReq other) {
                if (other == DealAddFriendReq.getDefaultInstance()) {
                    return this;
                }
                if (other.dealAddFriendResult_ != 0) {
                    setDealAddFriendResultValue(other.getDealAddFriendResultValue());
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
                DealAddFriendReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DealAddFriendReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DealAddFriendReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReqOrBuilder
            public int getDealAddFriendResultValue() {
                return this.dealAddFriendResult_;
            }

            public Builder setDealAddFriendResultValue(int value) {
                this.dealAddFriendResult_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReqOrBuilder
            public DealAddFriendResultTypeOuterClass.DealAddFriendResultType getDealAddFriendResult() {
                DealAddFriendResultTypeOuterClass.DealAddFriendResultType result = DealAddFriendResultTypeOuterClass.DealAddFriendResultType.valueOf(this.dealAddFriendResult_);
                return result == null ? DealAddFriendResultTypeOuterClass.DealAddFriendResultType.UNRECOGNIZED : result;
            }

            public Builder setDealAddFriendResult(DealAddFriendResultTypeOuterClass.DealAddFriendResultType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dealAddFriendResult_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearDealAddFriendResult() {
                this.dealAddFriendResult_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DealAddFriendReqOuterClass.DealAddFriendReqOrBuilder
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

        public static DealAddFriendReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DealAddFriendReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DealAddFriendReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DealAddFriendReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DealAddFriendResultTypeOuterClass.getDescriptor();
    }
}
