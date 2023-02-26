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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinRspOuterClass.class */
public final class McoinExchangeHcoinRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bMcoinExchangeHcoinRsp.proto\"J\n\u0015McoinExchangeHcoinRsp\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005\u0012\u0011\n\tmcoinCost\u0018\u000b \u0001(\r\u0012\r\n\u0005hcoin\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_McoinExchangeHcoinRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_McoinExchangeHcoinRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_McoinExchangeHcoinRsp_descriptor, new String[]{"Retcode", "McoinCost", "Hcoin"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinRspOuterClass$McoinExchangeHcoinRspOrBuilder.class */
    public interface McoinExchangeHcoinRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getMcoinCost();

        int getHcoin();
    }

    private McoinExchangeHcoinRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinRspOuterClass$McoinExchangeHcoinRsp.class */
    public static final class McoinExchangeHcoinRsp extends GeneratedMessageV3 implements McoinExchangeHcoinRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        public static final int MCOINCOST_FIELD_NUMBER = 11;
        private int mcoinCost_;
        public static final int HCOIN_FIELD_NUMBER = 15;
        private int hcoin_;
        private byte memoizedIsInitialized;
        private static final McoinExchangeHcoinRsp DEFAULT_INSTANCE = new McoinExchangeHcoinRsp();
        private static final Parser<McoinExchangeHcoinRsp> PARSER = new AbstractParser<McoinExchangeHcoinRsp>() { // from class: emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRsp.1
            @Override // com.google.protobuf.Parser
            public McoinExchangeHcoinRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new McoinExchangeHcoinRsp(input, extensionRegistry);
            }
        };

        private McoinExchangeHcoinRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private McoinExchangeHcoinRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new McoinExchangeHcoinRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private McoinExchangeHcoinRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 88:
                                    this.mcoinCost_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.hcoin_ = input.readUInt32();
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
            return McoinExchangeHcoinRspOuterClass.internal_static_McoinExchangeHcoinRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return McoinExchangeHcoinRspOuterClass.internal_static_McoinExchangeHcoinRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(McoinExchangeHcoinRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRspOrBuilder
        public int getMcoinCost() {
            return this.mcoinCost_;
        }

        @Override // emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRspOrBuilder
        public int getHcoin() {
            return this.hcoin_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
            }
            if (this.mcoinCost_ != 0) {
                output.writeUInt32(11, this.mcoinCost_);
            }
            if (this.hcoin_ != 0) {
                output.writeUInt32(15, this.hcoin_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.mcoinCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.mcoinCost_);
            }
            if (this.hcoin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.hcoin_);
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
            if (!(obj instanceof McoinExchangeHcoinRsp)) {
                return equals(obj);
            }
            McoinExchangeHcoinRsp other = (McoinExchangeHcoinRsp) obj;
            return getRetcode() == other.getRetcode() && getMcoinCost() == other.getMcoinCost() && getHcoin() == other.getHcoin() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getRetcode())) + 11)) + getMcoinCost())) + 15)) + getHcoin())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static McoinExchangeHcoinRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static McoinExchangeHcoinRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static McoinExchangeHcoinRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static McoinExchangeHcoinRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static McoinExchangeHcoinRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static McoinExchangeHcoinRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static McoinExchangeHcoinRsp parseFrom(InputStream input) throws IOException {
            return (McoinExchangeHcoinRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static McoinExchangeHcoinRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (McoinExchangeHcoinRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static McoinExchangeHcoinRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (McoinExchangeHcoinRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static McoinExchangeHcoinRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (McoinExchangeHcoinRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static McoinExchangeHcoinRsp parseFrom(CodedInputStream input) throws IOException {
            return (McoinExchangeHcoinRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static McoinExchangeHcoinRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (McoinExchangeHcoinRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(McoinExchangeHcoinRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/McoinExchangeHcoinRspOuterClass$McoinExchangeHcoinRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements McoinExchangeHcoinRspOrBuilder {
            private int retcode_;
            private int mcoinCost_;
            private int hcoin_;

            public static final Descriptors.Descriptor getDescriptor() {
                return McoinExchangeHcoinRspOuterClass.internal_static_McoinExchangeHcoinRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return McoinExchangeHcoinRspOuterClass.internal_static_McoinExchangeHcoinRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(McoinExchangeHcoinRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (McoinExchangeHcoinRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.mcoinCost_ = 0;
                this.hcoin_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return McoinExchangeHcoinRspOuterClass.internal_static_McoinExchangeHcoinRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public McoinExchangeHcoinRsp getDefaultInstanceForType() {
                return McoinExchangeHcoinRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public McoinExchangeHcoinRsp build() {
                McoinExchangeHcoinRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public McoinExchangeHcoinRsp buildPartial() {
                McoinExchangeHcoinRsp result = new McoinExchangeHcoinRsp(this);
                result.retcode_ = this.retcode_;
                result.mcoinCost_ = this.mcoinCost_;
                result.hcoin_ = this.hcoin_;
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
                if (other instanceof McoinExchangeHcoinRsp) {
                    return mergeFrom((McoinExchangeHcoinRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(McoinExchangeHcoinRsp other) {
                if (other == McoinExchangeHcoinRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getMcoinCost() != 0) {
                    setMcoinCost(other.getMcoinCost());
                }
                if (other.getHcoin() != 0) {
                    setHcoin(other.getHcoin());
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
                McoinExchangeHcoinRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = McoinExchangeHcoinRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (McoinExchangeHcoinRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.McoinExchangeHcoinRspOuterClass.McoinExchangeHcoinRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static McoinExchangeHcoinRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<McoinExchangeHcoinRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<McoinExchangeHcoinRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public McoinExchangeHcoinRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
