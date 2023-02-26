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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendRspOuterClass.class */
public final class DealAddFriendRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016DealAddFriendRsp.proto\u001a\u001dDealAddFriendResultType.proto\"m\n\u0010DealAddFriendRsp\u00125\n\u0013dealAddFriendResult\u0018\u0002 \u0001(\u000e2\u0018.DealAddFriendResultType\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005\u0012\u0011\n\ttargetUid\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DealAddFriendResultTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DealAddFriendRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DealAddFriendRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DealAddFriendRsp_descriptor, new String[]{"DealAddFriendResult", "Retcode", "TargetUid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendRspOuterClass$DealAddFriendRspOrBuilder.class */
    public interface DealAddFriendRspOrBuilder extends MessageOrBuilder {
        int getDealAddFriendResultValue();

        DealAddFriendResultTypeOuterClass.DealAddFriendResultType getDealAddFriendResult();

        int getRetcode();

        int getTargetUid();
    }

    private DealAddFriendRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendRspOuterClass$DealAddFriendRsp.class */
    public static final class DealAddFriendRsp extends GeneratedMessageV3 implements DealAddFriendRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DEALADDFRIENDRESULT_FIELD_NUMBER = 2;
        private int dealAddFriendResult_;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        public static final int TARGETUID_FIELD_NUMBER = 4;
        private int targetUid_;
        private byte memoizedIsInitialized;
        private static final DealAddFriendRsp DEFAULT_INSTANCE = new DealAddFriendRsp();
        private static final Parser<DealAddFriendRsp> PARSER = new AbstractParser<DealAddFriendRsp>() { // from class: emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRsp.1
            @Override // com.google.protobuf.Parser
            public DealAddFriendRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DealAddFriendRsp(input, extensionRegistry);
            }
        };

        private DealAddFriendRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DealAddFriendRsp() {
            this.memoizedIsInitialized = -1;
            this.dealAddFriendResult_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DealAddFriendRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DealAddFriendRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.dealAddFriendResult_ = input.readEnum();
                                break;
                            case 24:
                                this.retcode_ = input.readInt32();
                                break;
                            case 32:
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
            return DealAddFriendRspOuterClass.internal_static_DealAddFriendRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DealAddFriendRspOuterClass.internal_static_DealAddFriendRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DealAddFriendRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
        public int getDealAddFriendResultValue() {
            return this.dealAddFriendResult_;
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
        public DealAddFriendResultTypeOuterClass.DealAddFriendResultType getDealAddFriendResult() {
            DealAddFriendResultTypeOuterClass.DealAddFriendResultType result = DealAddFriendResultTypeOuterClass.DealAddFriendResultType.valueOf(this.dealAddFriendResult_);
            return result == null ? DealAddFriendResultTypeOuterClass.DealAddFriendResultType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
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
                output.writeEnum(2, this.dealAddFriendResult_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(3, this.retcode_);
            }
            if (this.targetUid_ != 0) {
                output.writeUInt32(4, this.targetUid_);
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
                size2 = 0 + CodedOutputStream.computeEnumSize(2, this.dealAddFriendResult_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            if (this.targetUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.targetUid_);
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
            if (!(obj instanceof DealAddFriendRsp)) {
                return equals(obj);
            }
            DealAddFriendRsp other = (DealAddFriendRsp) obj;
            return this.dealAddFriendResult_ == other.dealAddFriendResult_ && getRetcode() == other.getRetcode() && getTargetUid() == other.getTargetUid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + this.dealAddFriendResult_)) + 3)) + getRetcode())) + 4)) + getTargetUid())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DealAddFriendRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DealAddFriendRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DealAddFriendRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DealAddFriendRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DealAddFriendRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DealAddFriendRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DealAddFriendRsp parseFrom(InputStream input) throws IOException {
            return (DealAddFriendRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DealAddFriendRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DealAddFriendRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DealAddFriendRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (DealAddFriendRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DealAddFriendRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DealAddFriendRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DealAddFriendRsp parseFrom(CodedInputStream input) throws IOException {
            return (DealAddFriendRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DealAddFriendRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DealAddFriendRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DealAddFriendRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendRspOuterClass$DealAddFriendRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DealAddFriendRspOrBuilder {
            private int dealAddFriendResult_ = 0;
            private int retcode_;
            private int targetUid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DealAddFriendRspOuterClass.internal_static_DealAddFriendRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DealAddFriendRspOuterClass.internal_static_DealAddFriendRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DealAddFriendRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DealAddFriendRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dealAddFriendResult_ = 0;
                this.retcode_ = 0;
                this.targetUid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DealAddFriendRspOuterClass.internal_static_DealAddFriendRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DealAddFriendRsp getDefaultInstanceForType() {
                return DealAddFriendRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DealAddFriendRsp build() {
                DealAddFriendRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DealAddFriendRsp buildPartial() {
                DealAddFriendRsp result = new DealAddFriendRsp(this);
                result.dealAddFriendResult_ = this.dealAddFriendResult_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof DealAddFriendRsp) {
                    return mergeFrom((DealAddFriendRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DealAddFriendRsp other) {
                if (other == DealAddFriendRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.dealAddFriendResult_ != 0) {
                    setDealAddFriendResultValue(other.getDealAddFriendResultValue());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                DealAddFriendRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = DealAddFriendRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DealAddFriendRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
            public int getDealAddFriendResultValue() {
                return this.dealAddFriendResult_;
            }

            public Builder setDealAddFriendResultValue(int value) {
                this.dealAddFriendResult_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.DealAddFriendRspOuterClass.DealAddFriendRspOrBuilder
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

        public static DealAddFriendRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DealAddFriendRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DealAddFriendRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DealAddFriendRsp getDefaultInstanceForType() {
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
