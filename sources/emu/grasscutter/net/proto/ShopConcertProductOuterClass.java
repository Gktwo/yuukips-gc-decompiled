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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopConcertProductOuterClass.class */
public final class ShopConcertProductOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ShopConcertProduct.proto\"\u0001\n\u0012ShopConcertProduct\u0012\u0011\n\tproductId\u0018\u0001 \u0001(\t\u0012\u0011\n\tpriceTier\u0018\u0002 \u0001(\t\u0012\u0013\n\u000bobtainCount\u0018\u0003 \u0001(\r\u0012\u0013\n\u000bobtainLimit\u0018\u0004 \u0001(\r\u0012\u0011\n\tbeginTime\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007endTime\u0018\u0006 \u0001(\r\u0012\u0010\n\bbuyTimes\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ShopConcertProduct_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShopConcertProduct_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShopConcertProduct_descriptor, new String[]{"ProductId", "PriceTier", "ObtainCount", "ObtainLimit", "BeginTime", "EndTime", "BuyTimes"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopConcertProductOuterClass$ShopConcertProductOrBuilder.class */
    public interface ShopConcertProductOrBuilder extends MessageOrBuilder {
        String getProductId();

        ByteString getProductIdBytes();

        String getPriceTier();

        ByteString getPriceTierBytes();

        int getObtainCount();

        int getObtainLimit();

        int getBeginTime();

        int getEndTime();

        int getBuyTimes();
    }

    private ShopConcertProductOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopConcertProductOuterClass$ShopConcertProduct.class */
    public static final class ShopConcertProduct extends GeneratedMessageV3 implements ShopConcertProductOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PRODUCTID_FIELD_NUMBER = 1;
        private volatile Object productId_;
        public static final int PRICETIER_FIELD_NUMBER = 2;
        private volatile Object priceTier_;
        public static final int OBTAINCOUNT_FIELD_NUMBER = 3;
        private int obtainCount_;
        public static final int OBTAINLIMIT_FIELD_NUMBER = 4;
        private int obtainLimit_;
        public static final int BEGINTIME_FIELD_NUMBER = 5;
        private int beginTime_;
        public static final int ENDTIME_FIELD_NUMBER = 6;
        private int endTime_;
        public static final int BUYTIMES_FIELD_NUMBER = 7;
        private int buyTimes_;
        private byte memoizedIsInitialized;
        private static final ShopConcertProduct DEFAULT_INSTANCE = new ShopConcertProduct();
        private static final Parser<ShopConcertProduct> PARSER = new AbstractParser<ShopConcertProduct>() { // from class: emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProduct.1
            @Override // com.google.protobuf.Parser
            public ShopConcertProduct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShopConcertProduct(input, extensionRegistry);
            }
        };

        private ShopConcertProduct(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ShopConcertProduct() {
            this.memoizedIsInitialized = -1;
            this.productId_ = "";
            this.priceTier_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShopConcertProduct();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShopConcertProduct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.obtainCount_ = input.readUInt32();
                                break;
                            case 32:
                                this.obtainLimit_ = input.readUInt32();
                                break;
                            case 40:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 48:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 56:
                                this.buyTimes_ = input.readUInt32();
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
            return ShopConcertProductOuterClass.internal_static_ShopConcertProduct_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShopConcertProductOuterClass.internal_static_ShopConcertProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopConcertProduct.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public String getProductId() {
            Object ref = this.productId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.productId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public ByteString getProductIdBytes() {
            Object ref = this.productId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.productId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public String getPriceTier() {
            Object ref = this.priceTier_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.priceTier_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public ByteString getPriceTierBytes() {
            Object ref = this.priceTier_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.priceTier_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public int getObtainCount() {
            return this.obtainCount_;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public int getObtainLimit() {
            return this.obtainLimit_;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
        public int getBuyTimes() {
            return this.buyTimes_;
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
            if (this.obtainCount_ != 0) {
                output.writeUInt32(3, this.obtainCount_);
            }
            if (this.obtainLimit_ != 0) {
                output.writeUInt32(4, this.obtainLimit_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(5, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(6, this.endTime_);
            }
            if (this.buyTimes_ != 0) {
                output.writeUInt32(7, this.buyTimes_);
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
            if (this.obtainCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.obtainCount_);
            }
            if (this.obtainLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.obtainLimit_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.endTime_);
            }
            if (this.buyTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.buyTimes_);
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
            if (!(obj instanceof ShopConcertProduct)) {
                return equals(obj);
            }
            ShopConcertProduct other = (ShopConcertProduct) obj;
            return getProductId().equals(other.getProductId()) && getPriceTier().equals(other.getPriceTier()) && getObtainCount() == other.getObtainCount() && getObtainLimit() == other.getObtainLimit() && getBeginTime() == other.getBeginTime() && getEndTime() == other.getEndTime() && getBuyTimes() == other.getBuyTimes() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getProductId().hashCode())) + 2)) + getPriceTier().hashCode())) + 3)) + getObtainCount())) + 4)) + getObtainLimit())) + 5)) + getBeginTime())) + 6)) + getEndTime())) + 7)) + getBuyTimes())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ShopConcertProduct parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopConcertProduct parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopConcertProduct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopConcertProduct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopConcertProduct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShopConcertProduct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShopConcertProduct parseFrom(InputStream input) throws IOException {
            return (ShopConcertProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopConcertProduct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopConcertProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopConcertProduct parseDelimitedFrom(InputStream input) throws IOException {
            return (ShopConcertProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShopConcertProduct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopConcertProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShopConcertProduct parseFrom(CodedInputStream input) throws IOException {
            return (ShopConcertProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShopConcertProduct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShopConcertProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShopConcertProduct prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopConcertProductOuterClass$ShopConcertProduct$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShopConcertProductOrBuilder {
            private Object productId_ = "";
            private Object priceTier_ = "";
            private int obtainCount_;
            private int obtainLimit_;
            private int beginTime_;
            private int endTime_;
            private int buyTimes_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShopConcertProductOuterClass.internal_static_ShopConcertProduct_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShopConcertProductOuterClass.internal_static_ShopConcertProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(ShopConcertProduct.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShopConcertProduct.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.productId_ = "";
                this.priceTier_ = "";
                this.obtainCount_ = 0;
                this.obtainLimit_ = 0;
                this.beginTime_ = 0;
                this.endTime_ = 0;
                this.buyTimes_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShopConcertProductOuterClass.internal_static_ShopConcertProduct_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShopConcertProduct getDefaultInstanceForType() {
                return ShopConcertProduct.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopConcertProduct build() {
                ShopConcertProduct result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShopConcertProduct buildPartial() {
                ShopConcertProduct result = new ShopConcertProduct(this);
                result.productId_ = this.productId_;
                result.priceTier_ = this.priceTier_;
                result.obtainCount_ = this.obtainCount_;
                result.obtainLimit_ = this.obtainLimit_;
                result.beginTime_ = this.beginTime_;
                result.endTime_ = this.endTime_;
                result.buyTimes_ = this.buyTimes_;
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
                if (other instanceof ShopConcertProduct) {
                    return mergeFrom((ShopConcertProduct) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShopConcertProduct other) {
                if (other == ShopConcertProduct.getDefaultInstance()) {
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
                if (other.getObtainCount() != 0) {
                    setObtainCount(other.getObtainCount());
                }
                if (other.getObtainLimit() != 0) {
                    setObtainLimit(other.getObtainLimit());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getBuyTimes() != 0) {
                    setBuyTimes(other.getBuyTimes());
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
                ShopConcertProduct parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShopConcertProduct.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShopConcertProduct) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public String getProductId() {
                Object ref = this.productId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.productId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
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
                this.productId_ = ShopConcertProduct.getDefaultInstance().getProductId();
                onChanged();
                return this;
            }

            public Builder setProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ShopConcertProduct.checkByteStringIsUtf8(value);
                this.productId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public String getPriceTier() {
                Object ref = this.priceTier_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.priceTier_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
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
                this.priceTier_ = ShopConcertProduct.getDefaultInstance().getPriceTier();
                onChanged();
                return this;
            }

            public Builder setPriceTierBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ShopConcertProduct.checkByteStringIsUtf8(value);
                this.priceTier_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public int getObtainCount() {
                return this.obtainCount_;
            }

            public Builder setObtainCount(int value) {
                this.obtainCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearObtainCount() {
                this.obtainCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public int getObtainLimit() {
                return this.obtainLimit_;
            }

            public Builder setObtainLimit(int value) {
                this.obtainLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearObtainLimit() {
                this.obtainLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShopConcertProductOuterClass.ShopConcertProductOrBuilder
            public int getBuyTimes() {
                return this.buyTimes_;
            }

            public Builder setBuyTimes(int value) {
                this.buyTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuyTimes() {
                this.buyTimes_ = 0;
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

        public static ShopConcertProduct getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShopConcertProduct> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShopConcertProduct> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShopConcertProduct getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
