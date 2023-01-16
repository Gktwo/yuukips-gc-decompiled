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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopMcoinProductOuterClass.class */
public final class ShopMcoinProductOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016ShopMcoinProduct.proto\"¢\u0001\n\u0010ShopMcoinProduct\u0012\u0012\n\nproduct_id\u0018\u0001 \u0001(\t\u0012\u0012\n\nprice_tier\u0018\u0002 \u0001(\t\u0012\u0012\n\nmcoin_base\u0018\u0003 \u0001(\r\u0012\u0017\n\u000fmcoin_non_first\u0018\u0004 \u0001(\r\u0012\u0013\n\u000bmcoin_first\u0018\u0005 \u0001(\r\u0012\u0012\n\nbought_num\u0018\u0006 \u0001(\r\u0012\u0010\n\bis_audit\u0018\u0007 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ShopMcoinProduct_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShopMcoinProduct_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShopMcoinProduct_descriptor, new String[]{"ProductId", "PriceTier", "McoinBase", "McoinNonFirst", "McoinFirst", "BoughtNum", "IsAudit"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopMcoinProductOuterClass$ShopMcoinProductOrBuilder.class */
    public interface ShopMcoinProductOrBuilder extends MessageOrBuilder {
        String getProductId();

        ByteString getProductIdBytes();

        String getPriceTier();

        ByteString getPriceTierBytes();

        int getMcoinBase();

        int getMcoinNonFirst();

        int getMcoinFirst();

        int getBoughtNum();

        boolean getIsAudit();
    }

    private ShopMcoinProductOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopMcoinProductOuterClass$ShopMcoinProduct.class */
    public static final class ShopMcoinProduct extends GeneratedMessageV3 implements ShopMcoinProductOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PRODUCT_ID_FIELD_NUMBER = 1;
        private volatile Object productId_;
        public static final int PRICE_TIER_FIELD_NUMBER = 2;
        private volatile Object priceTier_;
        public static final int MCOIN_BASE_FIELD_NUMBER = 3;
        private int mcoinBase_;
        public static final int MCOIN_NON_FIRST_FIELD_NUMBER = 4;
        private int mcoinNonFirst_;
        public static final int MCOIN_FIRST_FIELD_NUMBER = 5;
        private int mcoinFirst_;
        public static final int BOUGHT_NUM_FIELD_NUMBER = 6;
        private int boughtNum_;
        public static final int IS_AUDIT_FIELD_NUMBER = 7;
        private boolean isAudit_;
        private byte memoizedIsInitialized;
        private static final ShopMcoinProduct DEFAULT_INSTANCE = new ShopMcoinProduct();
        private static final Parser<ShopMcoinProduct> PARSER = new AbstractParser<ShopMcoinProduct>() { // from class: emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProduct.1
            @Override // com.google.protobuf.Parser
            public ShopMcoinProduct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopMcoinProduct(input, extensionRegistry);
            }
        };

        private ShopMcoinProduct(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ShopMcoinProduct() {
            this.memoizedIsInitialized = -1;
            this.productId_ = "";
            this.priceTier_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShopMcoinProduct();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShopMcoinProduct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.productId_ = input.readStringRequireUtf8();
                                break;
                            case 18:
                                this.priceTier_ = input.readStringRequireUtf8();
                                break;
                            case 24:
                                this.mcoinBase_ = input.readUInt32();
                                break;
                            case 32:
                                this.mcoinNonFirst_ = input.readUInt32();
                                break;
                            case 40:
                                this.mcoinFirst_ = input.readUInt32();
                                break;
                            case 48:
                                this.boughtNum_ = input.readUInt32();
                                break;
                            case 56:
                                this.isAudit_ = input.readBool();
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
            return ShopMcoinProductOuterClass.internal_static_ShopMcoinProduct_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopMcoinProductOuterClass.internal_static_ShopMcoinProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMcoinProduct.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public String getProductId() {
            Object ref = this.productId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.productId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public ByteString getProductIdBytes() {
            Object ref = this.productId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.productId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public String getPriceTier() {
            Object ref = this.priceTier_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.priceTier_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public ByteString getPriceTierBytes() {
            Object ref = this.priceTier_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.priceTier_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public int getMcoinBase() {
            return this.mcoinBase_;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public int getMcoinNonFirst() {
            return this.mcoinNonFirst_;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public int getMcoinFirst() {
            return this.mcoinFirst_;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public int getBoughtNum() {
            return this.boughtNum_;
        }

        @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
        public boolean getIsAudit() {
            return this.isAudit_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.productId_)) {
                GeneratedMessageV3.writeString(output, 1, this.productId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.priceTier_)) {
                GeneratedMessageV3.writeString(output, 2, this.priceTier_);
            }
            if (this.mcoinBase_ != 0) {
                output.writeUInt32(3, this.mcoinBase_);
            }
            if (this.mcoinNonFirst_ != 0) {
                output.writeUInt32(4, this.mcoinNonFirst_);
            }
            if (this.mcoinFirst_ != 0) {
                output.writeUInt32(5, this.mcoinFirst_);
            }
            if (this.boughtNum_ != 0) {
                output.writeUInt32(6, this.boughtNum_);
            }
            if (this.isAudit_) {
                output.writeBool(7, this.isAudit_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.productId_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.productId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.priceTier_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.priceTier_);
            }
            if (this.mcoinBase_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.mcoinBase_);
            }
            if (this.mcoinNonFirst_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.mcoinNonFirst_);
            }
            if (this.mcoinFirst_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.mcoinFirst_);
            }
            if (this.boughtNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.boughtNum_);
            }
            if (this.isAudit_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isAudit_);
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
            if (!(obj instanceof ShopMcoinProduct)) {
                return equals(obj);
            }
            ShopMcoinProduct other = (ShopMcoinProduct) obj;
            return getProductId().equals(other.getProductId()) && getPriceTier().equals(other.getPriceTier()) && getMcoinBase() == other.getMcoinBase() && getMcoinNonFirst() == other.getMcoinNonFirst() && getMcoinFirst() == other.getMcoinFirst() && getBoughtNum() == other.getBoughtNum() && getIsAudit() == other.getIsAudit() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getProductId().hashCode())) + 2)) + getPriceTier().hashCode())) + 3)) + getMcoinBase())) + 4)) + getMcoinNonFirst())) + 5)) + getMcoinFirst())) + 6)) + getBoughtNum())) + 7)) + Internal.hashBoolean(getIsAudit()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ShopMcoinProduct parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopMcoinProduct parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopMcoinProduct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopMcoinProduct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopMcoinProduct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopMcoinProduct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopMcoinProduct parseFrom(InputStream input) throws IOException {
            return (ShopMcoinProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopMcoinProduct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopMcoinProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopMcoinProduct parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopMcoinProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShopMcoinProduct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopMcoinProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopMcoinProduct parseFrom(CodedInputStream input) throws IOException {
            return (ShopMcoinProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopMcoinProduct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopMcoinProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShopMcoinProduct prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopMcoinProductOuterClass$ShopMcoinProduct$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShopMcoinProductOrBuilder {
            private Object productId_ = "";
            private Object priceTier_ = "";
            private int mcoinBase_;
            private int mcoinNonFirst_;
            private int mcoinFirst_;
            private int boughtNum_;
            private boolean isAudit_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopMcoinProductOuterClass.internal_static_ShopMcoinProduct_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopMcoinProductOuterClass.internal_static_ShopMcoinProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopMcoinProduct.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopMcoinProduct.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.productId_ = "";
                this.priceTier_ = "";
                this.mcoinBase_ = 0;
                this.mcoinNonFirst_ = 0;
                this.mcoinFirst_ = 0;
                this.boughtNum_ = 0;
                this.isAudit_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShopMcoinProductOuterClass.internal_static_ShopMcoinProduct_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShopMcoinProduct getDefaultInstanceForType() {
                return ShopMcoinProduct.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopMcoinProduct build() {
                ShopMcoinProduct result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopMcoinProduct buildPartial() {
                ShopMcoinProduct result = new ShopMcoinProduct(this);
                result.productId_ = this.productId_;
                result.priceTier_ = this.priceTier_;
                result.mcoinBase_ = this.mcoinBase_;
                result.mcoinNonFirst_ = this.mcoinNonFirst_;
                result.mcoinFirst_ = this.mcoinFirst_;
                result.boughtNum_ = this.boughtNum_;
                result.isAudit_ = this.isAudit_;
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
                if (other instanceof ShopMcoinProduct) {
                    return mergeFrom((ShopMcoinProduct) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopMcoinProduct other) {
                if (other == ShopMcoinProduct.getDefaultInstance()) {
                    return this;
                }
                if (!other.getProductId().isEmpty()) {
                    this.productId_ = other.productId_;
                    onChanged();
                }
                if (!other.getPriceTier().isEmpty()) {
                    this.priceTier_ = other.priceTier_;
                    onChanged();
                }
                if (other.getMcoinBase() != 0) {
                    setMcoinBase(other.getMcoinBase());
                }
                if (other.getMcoinNonFirst() != 0) {
                    setMcoinNonFirst(other.getMcoinNonFirst());
                }
                if (other.getMcoinFirst() != 0) {
                    setMcoinFirst(other.getMcoinFirst());
                }
                if (other.getBoughtNum() != 0) {
                    setBoughtNum(other.getBoughtNum());
                }
                if (other.getIsAudit()) {
                    setIsAudit(other.getIsAudit());
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
                ShopMcoinProduct parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShopMcoinProduct.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShopMcoinProduct) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public String getProductId() {
                Object ref = this.productId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.productId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
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
                this.productId_ = ShopMcoinProduct.getDefaultInstance().getProductId();
                onChanged();
                return this;
            }

            public Builder setProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ShopMcoinProduct.checkByteStringIsUtf8(value);
                this.productId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public String getPriceTier() {
                Object ref = this.priceTier_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.priceTier_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public ByteString getPriceTierBytes() {
                Object ref = this.priceTier_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.priceTier_ = b;
                return b;
            }

            public Builder setPriceTier(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.priceTier_ = value;
                onChanged();
                return this;
            }

            public Builder clearPriceTier() {
                this.priceTier_ = ShopMcoinProduct.getDefaultInstance().getPriceTier();
                onChanged();
                return this;
            }

            public Builder setPriceTierBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ShopMcoinProduct.checkByteStringIsUtf8(value);
                this.priceTier_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public int getMcoinBase() {
                return this.mcoinBase_;
            }

            public Builder setMcoinBase(int value) {
                this.mcoinBase_ = value;
                onChanged();
                return this;
            }

            public Builder clearMcoinBase() {
                this.mcoinBase_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public int getMcoinNonFirst() {
                return this.mcoinNonFirst_;
            }

            public Builder setMcoinNonFirst(int value) {
                this.mcoinNonFirst_ = value;
                onChanged();
                return this;
            }

            public Builder clearMcoinNonFirst() {
                this.mcoinNonFirst_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public int getMcoinFirst() {
                return this.mcoinFirst_;
            }

            public Builder setMcoinFirst(int value) {
                this.mcoinFirst_ = value;
                onChanged();
                return this;
            }

            public Builder clearMcoinFirst() {
                this.mcoinFirst_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public int getBoughtNum() {
                return this.boughtNum_;
            }

            public Builder setBoughtNum(int value) {
                this.boughtNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearBoughtNum() {
                this.boughtNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopMcoinProductOuterClass.ShopMcoinProductOrBuilder
            public boolean getIsAudit() {
                return this.isAudit_;
            }

            public Builder setIsAudit(boolean value) {
                this.isAudit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAudit() {
                this.isAudit_ = false;
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

        public static ShopMcoinProduct getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShopMcoinProduct> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShopMcoinProduct> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShopMcoinProduct getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
