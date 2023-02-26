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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CardProductRewardNotifyOuterClass.class */
public final class CardProductRewardNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCardProductRewardNotify.proto\"O\n\u0017CardProductRewardNotify\u0012\u0011\n\tproductId\u0018\t \u0001(\t\u0012\r\n\u0005hcoin\u0018\u0006 \u0001(\r\u0012\u0012\n\nremainDays\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CardProductRewardNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CardProductRewardNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CardProductRewardNotify_descriptor, new String[]{"ProductId", "Hcoin", "RemainDays"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CardProductRewardNotifyOuterClass$CardProductRewardNotifyOrBuilder.class */
    public interface CardProductRewardNotifyOrBuilder extends MessageOrBuilder {
        String getProductId();

        ByteString getProductIdBytes();

        int getHcoin();

        int getRemainDays();
    }

    private CardProductRewardNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CardProductRewardNotifyOuterClass$CardProductRewardNotify.class */
    public static final class CardProductRewardNotify extends GeneratedMessageV3 implements CardProductRewardNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PRODUCTID_FIELD_NUMBER = 9;
        private volatile Object productId_;
        public static final int HCOIN_FIELD_NUMBER = 6;
        private int hcoin_;
        public static final int REMAINDAYS_FIELD_NUMBER = 7;
        private int remainDays_;
        private byte memoizedIsInitialized;
        private static final CardProductRewardNotify DEFAULT_INSTANCE = new CardProductRewardNotify();
        private static final Parser<CardProductRewardNotify> PARSER = new AbstractParser<CardProductRewardNotify>() { // from class: emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotify.1
            @Override // com.google.protobuf.Parser
            public CardProductRewardNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CardProductRewardNotify(input, extensionRegistry);
            }
        };

        private CardProductRewardNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CardProductRewardNotify() {
            this.memoizedIsInitialized = -1;
            this.productId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CardProductRewardNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CardProductRewardNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.hcoin_ = input.readUInt32();
                                break;
                            case 56:
                                this.remainDays_ = input.readUInt32();
                                break;
                            case 74:
                                this.productId_ = input.readStringRequireUtf8();
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
            return CardProductRewardNotifyOuterClass.internal_static_CardProductRewardNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CardProductRewardNotifyOuterClass.internal_static_CardProductRewardNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CardProductRewardNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
        public String getProductId() {
            Object ref = this.productId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.productId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
        public ByteString getProductIdBytes() {
            Object ref = this.productId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.productId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
        public int getHcoin() {
            return this.hcoin_;
        }

        @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
        public int getRemainDays() {
            return this.remainDays_;
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
                output.writeUInt32(6, this.hcoin_);
            }
            if (this.remainDays_ != 0) {
                output.writeUInt32(7, this.remainDays_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.productId_)) {
                GeneratedMessageV3.writeString(output, 9, this.productId_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.hcoin_);
            }
            if (this.remainDays_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.remainDays_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.productId_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.productId_);
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
            if (!(obj instanceof CardProductRewardNotify)) {
                return equals(obj);
            }
            CardProductRewardNotify other = (CardProductRewardNotify) obj;
            return getProductId().equals(other.getProductId()) && getHcoin() == other.getHcoin() && getRemainDays() == other.getRemainDays() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getProductId().hashCode())) + 6)) + getHcoin())) + 7)) + getRemainDays())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CardProductRewardNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CardProductRewardNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CardProductRewardNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CardProductRewardNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CardProductRewardNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CardProductRewardNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CardProductRewardNotify parseFrom(InputStream input) throws IOException {
            return (CardProductRewardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CardProductRewardNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CardProductRewardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CardProductRewardNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CardProductRewardNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CardProductRewardNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CardProductRewardNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CardProductRewardNotify parseFrom(CodedInputStream input) throws IOException {
            return (CardProductRewardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CardProductRewardNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CardProductRewardNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CardProductRewardNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CardProductRewardNotifyOuterClass$CardProductRewardNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CardProductRewardNotifyOrBuilder {
            private Object productId_ = "";
            private int hcoin_;
            private int remainDays_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CardProductRewardNotifyOuterClass.internal_static_CardProductRewardNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CardProductRewardNotifyOuterClass.internal_static_CardProductRewardNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CardProductRewardNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CardProductRewardNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.productId_ = "";
                this.hcoin_ = 0;
                this.remainDays_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CardProductRewardNotifyOuterClass.internal_static_CardProductRewardNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CardProductRewardNotify getDefaultInstanceForType() {
                return CardProductRewardNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CardProductRewardNotify build() {
                CardProductRewardNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CardProductRewardNotify buildPartial() {
                CardProductRewardNotify result = new CardProductRewardNotify(this);
                result.productId_ = this.productId_;
                result.hcoin_ = this.hcoin_;
                result.remainDays_ = this.remainDays_;
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
                if (other instanceof CardProductRewardNotify) {
                    return mergeFrom((CardProductRewardNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CardProductRewardNotify other) {
                if (other == CardProductRewardNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.getProductId().isEmpty()) {
                    this.productId_ = other.productId_;
                    onChanged();
                }
                if (other.getHcoin() != 0) {
                    setHcoin(other.getHcoin());
                }
                if (other.getRemainDays() != 0) {
                    setRemainDays(other.getRemainDays());
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
                CardProductRewardNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CardProductRewardNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CardProductRewardNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
            public String getProductId() {
                Object ref = this.productId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.productId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
            public ByteString getProductIdBytes() {
                Object ref = this.productId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.productId_ = b;
                return b;
            }

            public Builder setProductId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.productId_ = value;
                onChanged();
                return this;
            }

            public Builder clearProductId() {
                this.productId_ = CardProductRewardNotify.getDefaultInstance().getProductId();
                onChanged();
                return this;
            }

            public Builder setProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                CardProductRewardNotify.checkByteStringIsUtf8(value);
                this.productId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass.CardProductRewardNotifyOrBuilder
            public int getRemainDays() {
                return this.remainDays_;
            }

            public Builder setRemainDays(int value) {
                this.remainDays_ = value;
                onChanged();
                return this;
            }

            public Builder clearRemainDays() {
                this.remainDays_ = 0;
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

        public static CardProductRewardNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CardProductRewardNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CardProductRewardNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CardProductRewardNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
