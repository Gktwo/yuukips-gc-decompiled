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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyBattlePassLevelReqOuterClass.class */
public final class BuyBattlePassLevelReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bBuyBattlePassLevelReq.proto\"*\n\u0015BuyBattlePassLevelReq\u0012\u0011\n\tbuy_level\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BuyBattlePassLevelReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BuyBattlePassLevelReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BuyBattlePassLevelReq_descriptor, new String[]{"BuyLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyBattlePassLevelReqOuterClass$BuyBattlePassLevelReqOrBuilder.class */
    public interface BuyBattlePassLevelReqOrBuilder extends MessageOrBuilder {
        int getBuyLevel();
    }

    private BuyBattlePassLevelReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyBattlePassLevelReqOuterClass$BuyBattlePassLevelReq.class */
    public static final class BuyBattlePassLevelReq extends GeneratedMessageV3 implements BuyBattlePassLevelReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BUY_LEVEL_FIELD_NUMBER = 15;
        private int buyLevel_;
        private byte memoizedIsInitialized;
        private static final BuyBattlePassLevelReq DEFAULT_INSTANCE = new BuyBattlePassLevelReq();
        private static final Parser<BuyBattlePassLevelReq> PARSER = new AbstractParser<BuyBattlePassLevelReq>() { // from class: emu.grasscutter.net.proto.BuyBattlePassLevelReqOuterClass.BuyBattlePassLevelReq.1
            @Override // com.google.protobuf.Parser
            public BuyBattlePassLevelReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BuyBattlePassLevelReq(input, extensionRegistry);
            }
        };

        private BuyBattlePassLevelReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BuyBattlePassLevelReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BuyBattlePassLevelReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BuyBattlePassLevelReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 120:
                                this.buyLevel_ = input.readUInt32();
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
            return BuyBattlePassLevelReqOuterClass.internal_static_BuyBattlePassLevelReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BuyBattlePassLevelReqOuterClass.internal_static_BuyBattlePassLevelReq_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyBattlePassLevelReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BuyBattlePassLevelReqOuterClass.BuyBattlePassLevelReqOrBuilder
        public int getBuyLevel() {
            return this.buyLevel_;
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
            if (this.buyLevel_ != 0) {
                output.writeUInt32(15, this.buyLevel_);
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
            if (this.buyLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(15, this.buyLevel_);
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
            if (!(obj instanceof BuyBattlePassLevelReq)) {
                return equals(obj);
            }
            BuyBattlePassLevelReq other = (BuyBattlePassLevelReq) obj;
            return getBuyLevel() == other.getBuyLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getBuyLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BuyBattlePassLevelReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyBattlePassLevelReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyBattlePassLevelReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyBattlePassLevelReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyBattlePassLevelReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BuyBattlePassLevelReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BuyBattlePassLevelReq parseFrom(InputStream input) throws IOException {
            return (BuyBattlePassLevelReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuyBattlePassLevelReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyBattlePassLevelReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuyBattlePassLevelReq parseDelimitedFrom(InputStream input) throws IOException {
            return (BuyBattlePassLevelReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BuyBattlePassLevelReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyBattlePassLevelReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BuyBattlePassLevelReq parseFrom(CodedInputStream input) throws IOException {
            return (BuyBattlePassLevelReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BuyBattlePassLevelReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuyBattlePassLevelReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BuyBattlePassLevelReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BuyBattlePassLevelReqOuterClass$BuyBattlePassLevelReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BuyBattlePassLevelReqOrBuilder {
            private int buyLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BuyBattlePassLevelReqOuterClass.internal_static_BuyBattlePassLevelReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BuyBattlePassLevelReqOuterClass.internal_static_BuyBattlePassLevelReq_fieldAccessorTable.ensureFieldAccessorsInitialized(BuyBattlePassLevelReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BuyBattlePassLevelReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.buyLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BuyBattlePassLevelReqOuterClass.internal_static_BuyBattlePassLevelReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BuyBattlePassLevelReq getDefaultInstanceForType() {
                return BuyBattlePassLevelReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuyBattlePassLevelReq build() {
                BuyBattlePassLevelReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BuyBattlePassLevelReq buildPartial() {
                BuyBattlePassLevelReq result = new BuyBattlePassLevelReq(this);
                result.buyLevel_ = this.buyLevel_;
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
                if (other instanceof BuyBattlePassLevelReq) {
                    return mergeFrom((BuyBattlePassLevelReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BuyBattlePassLevelReq other) {
                if (other == BuyBattlePassLevelReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getBuyLevel() != 0) {
                    setBuyLevel(other.getBuyLevel());
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
                BuyBattlePassLevelReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = BuyBattlePassLevelReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BuyBattlePassLevelReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BuyBattlePassLevelReqOuterClass.BuyBattlePassLevelReqOrBuilder
            public int getBuyLevel() {
                return this.buyLevel_;
            }

            public Builder setBuyLevel(int value) {
                this.buyLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuyLevel() {
                this.buyLevel_ = 0;
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

        public static BuyBattlePassLevelReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BuyBattlePassLevelReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BuyBattlePassLevelReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BuyBattlePassLevelReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
