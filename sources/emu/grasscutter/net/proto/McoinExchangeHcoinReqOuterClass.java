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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinReqOuterClass.class */
public final class McoinExchangeHcoinReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bMcoinExchangeHcoinReq.proto\":\n\u0015McoinExchangeHcoinReq\u0012\r\n\u0005hcoin\u0018\u0001 \u0001(\r\u0012\u0012\n\nmcoin_cost\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_McoinExchangeHcoinReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_McoinExchangeHcoinReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_McoinExchangeHcoinReq_descriptor, new String[]{"Hcoin", "McoinCost"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinReqOuterClass$McoinExchangeHcoinReqOrBuilder.class */
    public interface McoinExchangeHcoinReqOrBuilder extends MessageOrBuilder {
        int getHcoin();

        int getMcoinCost();
    }

    private McoinExchangeHcoinReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinReqOuterClass$McoinExchangeHcoinReq.class */
    public static final class McoinExchangeHcoinReq extends GeneratedMessageV3 implements McoinExchangeHcoinReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HCOIN_FIELD_NUMBER = 1;
        private int hcoin_;
        public static final int MCOIN_COST_FIELD_NUMBER = 3;
        private int mcoinCost_;
        private byte memoizedIsInitialized;
        private static final McoinExchangeHcoinReq DEFAULT_INSTANCE = new McoinExchangeHcoinReq();
        private static final Parser<McoinExchangeHcoinReq> PARSER = new AbstractParser<McoinExchangeHcoinReq>() { // from class: emu.grasscutter.net.proto.McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReq.1
            @Override // com.google.protobuf.Parser
            public McoinExchangeHcoinReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new McoinExchangeHcoinReq(input, extensionRegistry);
            }
        };

        private McoinExchangeHcoinReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private McoinExchangeHcoinReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new McoinExchangeHcoinReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private McoinExchangeHcoinReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.hcoin_ = input.readUInt32();
                                break;
                            case 24:
                                this.mcoinCost_ = input.readUInt32();
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
            return McoinExchangeHcoinReqOuterClass.internal_static_McoinExchangeHcoinReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return McoinExchangeHcoinReqOuterClass.internal_static_McoinExchangeHcoinReq_fieldAccessorTable.ensureFieldAccessorsInitialized(McoinExchangeHcoinReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReqOrBuilder
        public int getHcoin() {
            return this.hcoin_;
        }

        @Override // emu.grasscutter.net.proto.McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReqOrBuilder
        public int getMcoinCost() {
            return this.mcoinCost_;
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
            if (this.hcoin_ != 0) {
                output.writeUInt32(1, this.hcoin_);
            }
            if (this.mcoinCost_ != 0) {
                output.writeUInt32(3, this.mcoinCost_);
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
            if (this.hcoin_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.hcoin_);
            }
            if (this.mcoinCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.mcoinCost_);
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
            if (!(obj instanceof McoinExchangeHcoinReq)) {
                return equals(obj);
            }
            McoinExchangeHcoinReq other = (McoinExchangeHcoinReq) obj;
            return getHcoin() == other.getHcoin() && getMcoinCost() == other.getMcoinCost() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getHcoin())) + 3)) + getMcoinCost())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static McoinExchangeHcoinReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static McoinExchangeHcoinReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static McoinExchangeHcoinReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static McoinExchangeHcoinReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static McoinExchangeHcoinReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static McoinExchangeHcoinReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static McoinExchangeHcoinReq parseFrom(InputStream input) throws IOException {
            return (McoinExchangeHcoinReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static McoinExchangeHcoinReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (McoinExchangeHcoinReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static McoinExchangeHcoinReq parseDelimitedFrom(InputStream input) throws IOException {
            return (McoinExchangeHcoinReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static McoinExchangeHcoinReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (McoinExchangeHcoinReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static McoinExchangeHcoinReq parseFrom(CodedInputStream input) throws IOException {
            return (McoinExchangeHcoinReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static McoinExchangeHcoinReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (McoinExchangeHcoinReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(McoinExchangeHcoinReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinReqOuterClass$McoinExchangeHcoinReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements McoinExchangeHcoinReqOrBuilder {
            private int hcoin_;
            private int mcoinCost_;

            public static final Descriptors.Descriptor getDescriptor() {
                return McoinExchangeHcoinReqOuterClass.internal_static_McoinExchangeHcoinReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return McoinExchangeHcoinReqOuterClass.internal_static_McoinExchangeHcoinReq_fieldAccessorTable.ensureFieldAccessorsInitialized(McoinExchangeHcoinReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (McoinExchangeHcoinReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.hcoin_ = 0;
                this.mcoinCost_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return McoinExchangeHcoinReqOuterClass.internal_static_McoinExchangeHcoinReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public McoinExchangeHcoinReq getDefaultInstanceForType() {
                return McoinExchangeHcoinReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public McoinExchangeHcoinReq build() {
                McoinExchangeHcoinReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public McoinExchangeHcoinReq buildPartial() {
                McoinExchangeHcoinReq result = new McoinExchangeHcoinReq(this);
                result.hcoin_ = this.hcoin_;
                result.mcoinCost_ = this.mcoinCost_;
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
                if (other instanceof McoinExchangeHcoinReq) {
                    return mergeFrom((McoinExchangeHcoinReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(McoinExchangeHcoinReq other) {
                if (other == McoinExchangeHcoinReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getHcoin() != 0) {
                    setHcoin(other.getHcoin());
                }
                if (other.getMcoinCost() != 0) {
                    setMcoinCost(other.getMcoinCost());
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
                McoinExchangeHcoinReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = McoinExchangeHcoinReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (McoinExchangeHcoinReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReqOrBuilder
            public int getHcoin() {
                return this.hcoin_;
            }

            public Builder setHcoin(int value) {
                this.hcoin_ = value;
                onChanged();
                return this;
            }

            public Builder clearHcoin() {
                this.hcoin_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReqOrBuilder
            public int getMcoinCost() {
                return this.mcoinCost_;
            }

            public Builder setMcoinCost(int value) {
                this.mcoinCost_ = value;
                onChanged();
                return this;
            }

            public Builder clearMcoinCost() {
                this.mcoinCost_ = 0;
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

        public static McoinExchangeHcoinReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<McoinExchangeHcoinReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<McoinExchangeHcoinReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public McoinExchangeHcoinReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
