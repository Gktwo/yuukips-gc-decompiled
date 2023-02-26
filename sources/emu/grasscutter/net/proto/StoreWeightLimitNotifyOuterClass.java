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
import emu.grasscutter.net.proto.StoreTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreWeightLimitNotifyOuterClass.class */
public final class StoreWeightLimitNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cStoreWeightLimitNotify.proto\u001a\u000fStoreType.proto\"¼\u0001\n\u0016StoreWeightLimitNotify\u0012\u001b\n\u0013furnitureCountLimit\u0018\u0002 \u0001(\r\u0012\u001a\n\u0012materialCountLimit\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013reliquaryCountLimit\u0018\u0005 \u0001(\r\u0012\u0013\n\u000bweightLimit\u0018\u000e \u0001(\r\u0012\u001d\n\tstoreType\u0018\u000b \u0001(\u000e2\n.StoreType\u0012\u0018\n\u0010weaponCountLimit\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{StoreTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_StoreWeightLimitNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_StoreWeightLimitNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_StoreWeightLimitNotify_descriptor, new String[]{"FurnitureCountLimit", "MaterialCountLimit", "ReliquaryCountLimit", "WeightLimit", "StoreType", "WeaponCountLimit"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreWeightLimitNotifyOuterClass$StoreWeightLimitNotifyOrBuilder.class */
    public interface StoreWeightLimitNotifyOrBuilder extends MessageOrBuilder {
        int getFurnitureCountLimit();

        int getMaterialCountLimit();

        int getReliquaryCountLimit();

        int getWeightLimit();

        int getStoreTypeValue();

        StoreTypeOuterClass.StoreType getStoreType();

        int getWeaponCountLimit();
    }

    private StoreWeightLimitNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreWeightLimitNotifyOuterClass$StoreWeightLimitNotify.class */
    public static final class StoreWeightLimitNotify extends GeneratedMessageV3 implements StoreWeightLimitNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FURNITURECOUNTLIMIT_FIELD_NUMBER = 2;
        private int furnitureCountLimit_;
        public static final int MATERIALCOUNTLIMIT_FIELD_NUMBER = 3;
        private int materialCountLimit_;
        public static final int RELIQUARYCOUNTLIMIT_FIELD_NUMBER = 5;
        private int reliquaryCountLimit_;
        public static final int WEIGHTLIMIT_FIELD_NUMBER = 14;
        private int weightLimit_;
        public static final int STORETYPE_FIELD_NUMBER = 11;
        private int storeType_;
        public static final int WEAPONCOUNTLIMIT_FIELD_NUMBER = 9;
        private int weaponCountLimit_;
        private byte memoizedIsInitialized;
        private static final StoreWeightLimitNotify DEFAULT_INSTANCE = new StoreWeightLimitNotify();
        private static final Parser<StoreWeightLimitNotify> PARSER = new AbstractParser<StoreWeightLimitNotify>() { // from class: emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotify.1
            @Override // com.google.protobuf.Parser
            public StoreWeightLimitNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new StoreWeightLimitNotify(input, extensionRegistry);
            }
        };

        private StoreWeightLimitNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private StoreWeightLimitNotify() {
            this.memoizedIsInitialized = -1;
            this.storeType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new StoreWeightLimitNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private StoreWeightLimitNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.furnitureCountLimit_ = input.readUInt32();
                                break;
                            case 24:
                                this.materialCountLimit_ = input.readUInt32();
                                break;
                            case 40:
                                this.reliquaryCountLimit_ = input.readUInt32();
                                break;
                            case 72:
                                this.weaponCountLimit_ = input.readUInt32();
                                break;
                            case 88:
                                this.storeType_ = input.readEnum();
                                break;
                            case 112:
                                this.weightLimit_ = input.readUInt32();
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
            return StoreWeightLimitNotifyOuterClass.internal_static_StoreWeightLimitNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StoreWeightLimitNotifyOuterClass.internal_static_StoreWeightLimitNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(StoreWeightLimitNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public int getFurnitureCountLimit() {
            return this.furnitureCountLimit_;
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public int getMaterialCountLimit() {
            return this.materialCountLimit_;
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public int getReliquaryCountLimit() {
            return this.reliquaryCountLimit_;
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public int getWeightLimit() {
            return this.weightLimit_;
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public int getStoreTypeValue() {
            return this.storeType_;
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public StoreTypeOuterClass.StoreType getStoreType() {
            StoreTypeOuterClass.StoreType result = StoreTypeOuterClass.StoreType.valueOf(this.storeType_);
            return result == null ? StoreTypeOuterClass.StoreType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
        public int getWeaponCountLimit() {
            return this.weaponCountLimit_;
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
            if (this.furnitureCountLimit_ != 0) {
                output.writeUInt32(2, this.furnitureCountLimit_);
            }
            if (this.materialCountLimit_ != 0) {
                output.writeUInt32(3, this.materialCountLimit_);
            }
            if (this.reliquaryCountLimit_ != 0) {
                output.writeUInt32(5, this.reliquaryCountLimit_);
            }
            if (this.weaponCountLimit_ != 0) {
                output.writeUInt32(9, this.weaponCountLimit_);
            }
            if (this.storeType_ != StoreTypeOuterClass.StoreType.STORE_TYPE_NONE.getNumber()) {
                output.writeEnum(11, this.storeType_);
            }
            if (this.weightLimit_ != 0) {
                output.writeUInt32(14, this.weightLimit_);
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
            if (this.furnitureCountLimit_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.furnitureCountLimit_);
            }
            if (this.materialCountLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.materialCountLimit_);
            }
            if (this.reliquaryCountLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.reliquaryCountLimit_);
            }
            if (this.weaponCountLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.weaponCountLimit_);
            }
            if (this.storeType_ != StoreTypeOuterClass.StoreType.STORE_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(11, this.storeType_);
            }
            if (this.weightLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.weightLimit_);
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
            if (!(obj instanceof StoreWeightLimitNotify)) {
                return equals(obj);
            }
            StoreWeightLimitNotify other = (StoreWeightLimitNotify) obj;
            return getFurnitureCountLimit() == other.getFurnitureCountLimit() && getMaterialCountLimit() == other.getMaterialCountLimit() && getReliquaryCountLimit() == other.getReliquaryCountLimit() && getWeightLimit() == other.getWeightLimit() && this.storeType_ == other.storeType_ && getWeaponCountLimit() == other.getWeaponCountLimit() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getFurnitureCountLimit())) + 3)) + getMaterialCountLimit())) + 5)) + getReliquaryCountLimit())) + 14)) + getWeightLimit())) + 11)) + this.storeType_)) + 9)) + getWeaponCountLimit())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static StoreWeightLimitNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StoreWeightLimitNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StoreWeightLimitNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StoreWeightLimitNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StoreWeightLimitNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static StoreWeightLimitNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static StoreWeightLimitNotify parseFrom(InputStream input) throws IOException {
            return (StoreWeightLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StoreWeightLimitNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StoreWeightLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static StoreWeightLimitNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (StoreWeightLimitNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static StoreWeightLimitNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StoreWeightLimitNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static StoreWeightLimitNotify parseFrom(CodedInputStream input) throws IOException {
            return (StoreWeightLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static StoreWeightLimitNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StoreWeightLimitNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(StoreWeightLimitNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreWeightLimitNotifyOuterClass$StoreWeightLimitNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StoreWeightLimitNotifyOrBuilder {
            private int furnitureCountLimit_;
            private int materialCountLimit_;
            private int reliquaryCountLimit_;
            private int weightLimit_;
            private int storeType_ = 0;
            private int weaponCountLimit_;

            public static final Descriptors.Descriptor getDescriptor() {
                return StoreWeightLimitNotifyOuterClass.internal_static_StoreWeightLimitNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return StoreWeightLimitNotifyOuterClass.internal_static_StoreWeightLimitNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(StoreWeightLimitNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (StoreWeightLimitNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.furnitureCountLimit_ = 0;
                this.materialCountLimit_ = 0;
                this.reliquaryCountLimit_ = 0;
                this.weightLimit_ = 0;
                this.storeType_ = 0;
                this.weaponCountLimit_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return StoreWeightLimitNotifyOuterClass.internal_static_StoreWeightLimitNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public StoreWeightLimitNotify getDefaultInstanceForType() {
                return StoreWeightLimitNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StoreWeightLimitNotify build() {
                StoreWeightLimitNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public StoreWeightLimitNotify buildPartial() {
                StoreWeightLimitNotify result = new StoreWeightLimitNotify(this);
                result.furnitureCountLimit_ = this.furnitureCountLimit_;
                result.materialCountLimit_ = this.materialCountLimit_;
                result.reliquaryCountLimit_ = this.reliquaryCountLimit_;
                result.weightLimit_ = this.weightLimit_;
                result.storeType_ = this.storeType_;
                result.weaponCountLimit_ = this.weaponCountLimit_;
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
                if (other instanceof StoreWeightLimitNotify) {
                    return mergeFrom((StoreWeightLimitNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(StoreWeightLimitNotify other) {
                if (other == StoreWeightLimitNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getFurnitureCountLimit() != 0) {
                    setFurnitureCountLimit(other.getFurnitureCountLimit());
                }
                if (other.getMaterialCountLimit() != 0) {
                    setMaterialCountLimit(other.getMaterialCountLimit());
                }
                if (other.getReliquaryCountLimit() != 0) {
                    setReliquaryCountLimit(other.getReliquaryCountLimit());
                }
                if (other.getWeightLimit() != 0) {
                    setWeightLimit(other.getWeightLimit());
                }
                if (other.storeType_ != 0) {
                    setStoreTypeValue(other.getStoreTypeValue());
                }
                if (other.getWeaponCountLimit() != 0) {
                    setWeaponCountLimit(other.getWeaponCountLimit());
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
                StoreWeightLimitNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = StoreWeightLimitNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (StoreWeightLimitNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public int getFurnitureCountLimit() {
                return this.furnitureCountLimit_;
            }

            public Builder setFurnitureCountLimit(int value) {
                this.furnitureCountLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearFurnitureCountLimit() {
                this.furnitureCountLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public int getMaterialCountLimit() {
                return this.materialCountLimit_;
            }

            public Builder setMaterialCountLimit(int value) {
                this.materialCountLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaterialCountLimit() {
                this.materialCountLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public int getReliquaryCountLimit() {
                return this.reliquaryCountLimit_;
            }

            public Builder setReliquaryCountLimit(int value) {
                this.reliquaryCountLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearReliquaryCountLimit() {
                this.reliquaryCountLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public int getWeightLimit() {
                return this.weightLimit_;
            }

            public Builder setWeightLimit(int value) {
                this.weightLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearWeightLimit() {
                this.weightLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public int getStoreTypeValue() {
                return this.storeType_;
            }

            public Builder setStoreTypeValue(int value) {
                this.storeType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public StoreTypeOuterClass.StoreType getStoreType() {
                StoreTypeOuterClass.StoreType result = StoreTypeOuterClass.StoreType.valueOf(this.storeType_);
                return result == null ? StoreTypeOuterClass.StoreType.UNRECOGNIZED : result;
            }

            public Builder setStoreType(StoreTypeOuterClass.StoreType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.storeType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStoreType() {
                this.storeType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.StoreWeightLimitNotifyOuterClass.StoreWeightLimitNotifyOrBuilder
            public int getWeaponCountLimit() {
                return this.weaponCountLimit_;
            }

            public Builder setWeaponCountLimit(int value) {
                this.weaponCountLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearWeaponCountLimit() {
                this.weaponCountLimit_ = 0;
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

        public static StoreWeightLimitNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StoreWeightLimitNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<StoreWeightLimitNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public StoreWeightLimitNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        StoreTypeOuterClass.getDescriptor();
    }
}
