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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassProductOuterClass.class */
public final class BattlePassProductOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017BattlePassProduct.proto\"^\n\u0011BattlePassProduct\u0012\u0017\n\u000fnormalProductId\u0018\u0004 \u0001(\t\u0012\u0016\n\u000eextraProductId\u0018\u000e \u0001(\t\u0012\u0018\n\u0010upgradeProductId\u0018\u0007 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BattlePassProduct_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassProduct_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassProduct_descriptor, new String[]{"NormalProductId", "ExtraProductId", "UpgradeProductId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassProductOuterClass$BattlePassProductOrBuilder.class */
    public interface BattlePassProductOrBuilder extends MessageOrBuilder {
        String getNormalProductId();

        ByteString getNormalProductIdBytes();

        String getExtraProductId();

        ByteString getExtraProductIdBytes();

        String getUpgradeProductId();

        ByteString getUpgradeProductIdBytes();
    }

    private BattlePassProductOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassProductOuterClass$BattlePassProduct.class */
    public static final class BattlePassProduct extends GeneratedMessageV3 implements BattlePassProductOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NORMALPRODUCTID_FIELD_NUMBER = 4;
        private volatile Object normalProductId_;
        public static final int EXTRAPRODUCTID_FIELD_NUMBER = 14;
        private volatile Object extraProductId_;
        public static final int UPGRADEPRODUCTID_FIELD_NUMBER = 7;
        private volatile Object upgradeProductId_;
        private byte memoizedIsInitialized;
        private static final BattlePassProduct DEFAULT_INSTANCE = new BattlePassProduct();
        private static final Parser<BattlePassProduct> PARSER = new AbstractParser<BattlePassProduct>() { // from class: emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProduct.1
            @Override // com.google.protobuf.Parser
            public BattlePassProduct parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassProduct(input, extensionRegistry);
            }
        };

        private BattlePassProduct(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassProduct() {
            this.memoizedIsInitialized = -1;
            this.normalProductId_ = "";
            this.extraProductId_ = "";
            this.upgradeProductId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassProduct();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassProduct(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                this.normalProductId_ = input.readStringRequireUtf8();
                                break;
                            case 58:
                                this.upgradeProductId_ = input.readStringRequireUtf8();
                                break;
                            case 114:
                                this.extraProductId_ = input.readStringRequireUtf8();
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
            return BattlePassProductOuterClass.internal_static_BattlePassProduct_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassProductOuterClass.internal_static_BattlePassProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassProduct.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
        public String getNormalProductId() {
            Object ref = this.normalProductId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.normalProductId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
        public ByteString getNormalProductIdBytes() {
            Object ref = this.normalProductId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.normalProductId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
        public String getExtraProductId() {
            Object ref = this.extraProductId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.extraProductId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
        public ByteString getExtraProductIdBytes() {
            Object ref = this.extraProductId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.extraProductId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
        public String getUpgradeProductId() {
            Object ref = this.upgradeProductId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.upgradeProductId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
        public ByteString getUpgradeProductIdBytes() {
            Object ref = this.upgradeProductId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.upgradeProductId_ = b;
            return b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.normalProductId_)) {
                GeneratedMessageV3.writeString(output, 4, this.normalProductId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.upgradeProductId_)) {
                GeneratedMessageV3.writeString(output, 7, this.upgradeProductId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.extraProductId_)) {
                GeneratedMessageV3.writeString(output, 14, this.extraProductId_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.normalProductId_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(4, this.normalProductId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.upgradeProductId_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.upgradeProductId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.extraProductId_)) {
                size2 += GeneratedMessageV3.computeStringSize(14, this.extraProductId_);
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
            if (!(obj instanceof BattlePassProduct)) {
                return equals(obj);
            }
            BattlePassProduct other = (BattlePassProduct) obj;
            return getNormalProductId().equals(other.getNormalProductId()) && getExtraProductId().equals(other.getExtraProductId()) && getUpgradeProductId().equals(other.getUpgradeProductId()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getNormalProductId().hashCode())) + 14)) + getExtraProductId().hashCode())) + 7)) + getUpgradeProductId().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BattlePassProduct parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassProduct parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassProduct parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassProduct parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassProduct parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassProduct parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassProduct parseFrom(InputStream input) throws IOException {
            return (BattlePassProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassProduct parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassProduct parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassProduct parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassProduct) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassProduct parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassProduct) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassProduct parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassProduct) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassProduct prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassProductOuterClass$BattlePassProduct$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassProductOrBuilder {
            private Object normalProductId_ = "";
            private Object extraProductId_ = "";
            private Object upgradeProductId_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassProductOuterClass.internal_static_BattlePassProduct_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassProductOuterClass.internal_static_BattlePassProduct_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassProduct.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassProduct.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.normalProductId_ = "";
                this.extraProductId_ = "";
                this.upgradeProductId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassProductOuterClass.internal_static_BattlePassProduct_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassProduct getDefaultInstanceForType() {
                return BattlePassProduct.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassProduct build() {
                BattlePassProduct result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassProduct buildPartial() {
                BattlePassProduct result = new BattlePassProduct(this);
                result.normalProductId_ = this.normalProductId_;
                result.extraProductId_ = this.extraProductId_;
                result.upgradeProductId_ = this.upgradeProductId_;
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
                if (other instanceof BattlePassProduct) {
                    return mergeFrom((BattlePassProduct) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassProduct other) {
                if (other == BattlePassProduct.getDefaultInstance()) {
                    return this;
                }
                if (!other.getNormalProductId().isEmpty()) {
                    this.normalProductId_ = other.normalProductId_;
                    onChanged();
                }
                if (!other.getExtraProductId().isEmpty()) {
                    this.extraProductId_ = other.extraProductId_;
                    onChanged();
                }
                if (!other.getUpgradeProductId().isEmpty()) {
                    this.upgradeProductId_ = other.upgradeProductId_;
                    onChanged();
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
                BattlePassProduct parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassProduct.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassProduct) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
            public String getNormalProductId() {
                Object ref = this.normalProductId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.normalProductId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
            public ByteString getNormalProductIdBytes() {
                Object ref = this.normalProductId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.normalProductId_ = b;
                return b;
            }

            public Builder setNormalProductId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.normalProductId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNormalProductId() {
                this.normalProductId_ = BattlePassProduct.getDefaultInstance().getNormalProductId();
                onChanged();
                return this;
            }

            public Builder setNormalProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                BattlePassProduct.checkByteStringIsUtf8(value);
                this.normalProductId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
            public String getExtraProductId() {
                Object ref = this.extraProductId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.extraProductId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
            public ByteString getExtraProductIdBytes() {
                Object ref = this.extraProductId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.extraProductId_ = b;
                return b;
            }

            public Builder setExtraProductId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.extraProductId_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtraProductId() {
                this.extraProductId_ = BattlePassProduct.getDefaultInstance().getExtraProductId();
                onChanged();
                return this;
            }

            public Builder setExtraProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                BattlePassProduct.checkByteStringIsUtf8(value);
                this.extraProductId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
            public String getUpgradeProductId() {
                Object ref = this.upgradeProductId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.upgradeProductId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.BattlePassProductOuterClass.BattlePassProductOrBuilder
            public ByteString getUpgradeProductIdBytes() {
                Object ref = this.upgradeProductId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.upgradeProductId_ = b;
                return b;
            }

            public Builder setUpgradeProductId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.upgradeProductId_ = value;
                onChanged();
                return this;
            }

            public Builder clearUpgradeProductId() {
                this.upgradeProductId_ = BattlePassProduct.getDefaultInstance().getUpgradeProductId();
                onChanged();
                return this;
            }

            public Builder setUpgradeProductIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                BattlePassProduct.checkByteStringIsUtf8(value);
                this.upgradeProductId_ = value;
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

        public static BattlePassProduct getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassProduct> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassProduct> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassProduct getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
