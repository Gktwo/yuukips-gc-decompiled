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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSlipRevivePointActivateReqOuterClass.class */
public final class DungeonSlipRevivePointActivateReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'DungeonSlipRevivePointActivateReq.proto\"A\n!DungeonSlipRevivePointActivateReq\u0012\u001c\n\u0014slip_revive_point_id\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DungeonSlipRevivePointActivateReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_DungeonSlipRevivePointActivateReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f693xb88ee1f1 = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonSlipRevivePointActivateReq_descriptor, new String[]{"SlipRevivePointId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSlipRevivePointActivateReqOuterClass$DungeonSlipRevivePointActivateReqOrBuilder.class */
    public interface DungeonSlipRevivePointActivateReqOrBuilder extends MessageOrBuilder {
        int getSlipRevivePointId();
    }

    private DungeonSlipRevivePointActivateReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSlipRevivePointActivateReqOuterClass$DungeonSlipRevivePointActivateReq.class */
    public static final class DungeonSlipRevivePointActivateReq extends GeneratedMessageV3 implements DungeonSlipRevivePointActivateReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SLIP_REVIVE_POINT_ID_FIELD_NUMBER = 8;
        private int slipRevivePointId_;
        private byte memoizedIsInitialized;
        private static final DungeonSlipRevivePointActivateReq DEFAULT_INSTANCE = new DungeonSlipRevivePointActivateReq();
        private static final Parser<DungeonSlipRevivePointActivateReq> PARSER = new AbstractParser<DungeonSlipRevivePointActivateReq>() { // from class: emu.grasscutter.net.proto.DungeonSlipRevivePointActivateReqOuterClass.DungeonSlipRevivePointActivateReq.1
            @Override // com.google.protobuf.Parser
            public DungeonSlipRevivePointActivateReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonSlipRevivePointActivateReq(input, extensionRegistry);
            }
        };

        private DungeonSlipRevivePointActivateReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DungeonSlipRevivePointActivateReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonSlipRevivePointActivateReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonSlipRevivePointActivateReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.slipRevivePointId_ = input.readUInt32();
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
            return DungeonSlipRevivePointActivateReqOuterClass.internal_static_DungeonSlipRevivePointActivateReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonSlipRevivePointActivateReqOuterClass.f693xb88ee1f1.ensureFieldAccessorsInitialized(DungeonSlipRevivePointActivateReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonSlipRevivePointActivateReqOuterClass.DungeonSlipRevivePointActivateReqOrBuilder
        public int getSlipRevivePointId() {
            return this.slipRevivePointId_;
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
            if (this.slipRevivePointId_ != 0) {
                output.writeUInt32(8, this.slipRevivePointId_);
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
            if (this.slipRevivePointId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.slipRevivePointId_);
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
            if (!(obj instanceof DungeonSlipRevivePointActivateReq)) {
                return equals(obj);
            }
            DungeonSlipRevivePointActivateReq other = (DungeonSlipRevivePointActivateReq) obj;
            return getSlipRevivePointId() == other.getSlipRevivePointId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getSlipRevivePointId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(InputStream input) throws IOException {
            return (DungeonSlipRevivePointActivateReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSlipRevivePointActivateReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonSlipRevivePointActivateReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonSlipRevivePointActivateReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonSlipRevivePointActivateReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSlipRevivePointActivateReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(CodedInputStream input) throws IOException {
            return (DungeonSlipRevivePointActivateReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonSlipRevivePointActivateReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonSlipRevivePointActivateReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonSlipRevivePointActivateReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonSlipRevivePointActivateReqOuterClass$DungeonSlipRevivePointActivateReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonSlipRevivePointActivateReqOrBuilder {
            private int slipRevivePointId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonSlipRevivePointActivateReqOuterClass.internal_static_DungeonSlipRevivePointActivateReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonSlipRevivePointActivateReqOuterClass.f693xb88ee1f1.ensureFieldAccessorsInitialized(DungeonSlipRevivePointActivateReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonSlipRevivePointActivateReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.slipRevivePointId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonSlipRevivePointActivateReqOuterClass.internal_static_DungeonSlipRevivePointActivateReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonSlipRevivePointActivateReq getDefaultInstanceForType() {
                return DungeonSlipRevivePointActivateReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonSlipRevivePointActivateReq build() {
                DungeonSlipRevivePointActivateReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonSlipRevivePointActivateReq buildPartial() {
                DungeonSlipRevivePointActivateReq result = new DungeonSlipRevivePointActivateReq(this);
                result.slipRevivePointId_ = this.slipRevivePointId_;
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
                if (other instanceof DungeonSlipRevivePointActivateReq) {
                    return mergeFrom((DungeonSlipRevivePointActivateReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonSlipRevivePointActivateReq other) {
                if (other == DungeonSlipRevivePointActivateReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getSlipRevivePointId() != 0) {
                    setSlipRevivePointId(other.getSlipRevivePointId());
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
                DungeonSlipRevivePointActivateReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonSlipRevivePointActivateReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonSlipRevivePointActivateReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonSlipRevivePointActivateReqOuterClass.DungeonSlipRevivePointActivateReqOrBuilder
            public int getSlipRevivePointId() {
                return this.slipRevivePointId_;
            }

            public Builder setSlipRevivePointId(int value) {
                this.slipRevivePointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSlipRevivePointId() {
                this.slipRevivePointId_ = 0;
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

        public static DungeonSlipRevivePointActivateReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonSlipRevivePointActivateReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonSlipRevivePointActivateReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonSlipRevivePointActivateReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
