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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShortAbilityHashPairOuterClass.class */
public final class ShortAbilityHashPairOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aShortAbilityHashPair.proto\"N\n\u0014ShortAbilityHashPair\u0012\u0019\n\u0011ability_name_hash\u0018\u0006 \u0001(\u000f\u0012\u001b\n\u0013ability_config_hash\u0018\u000f \u0001(\u000fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ShortAbilityHashPair_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ShortAbilityHashPair_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ShortAbilityHashPair_descriptor, new String[]{"AbilityNameHash", "AbilityConfigHash"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShortAbilityHashPairOuterClass$ShortAbilityHashPairOrBuilder.class */
    public interface ShortAbilityHashPairOrBuilder extends MessageOrBuilder {
        int getAbilityNameHash();

        int getAbilityConfigHash();
    }

    private ShortAbilityHashPairOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShortAbilityHashPairOuterClass$ShortAbilityHashPair.class */
    public static final class ShortAbilityHashPair extends GeneratedMessageV3 implements ShortAbilityHashPairOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ABILITY_NAME_HASH_FIELD_NUMBER = 6;
        private int abilityNameHash_;
        public static final int ABILITY_CONFIG_HASH_FIELD_NUMBER = 15;
        private int abilityConfigHash_;
        private byte memoizedIsInitialized;
        private static final ShortAbilityHashPair DEFAULT_INSTANCE = new ShortAbilityHashPair();
        private static final Parser<ShortAbilityHashPair> PARSER = new AbstractParser<ShortAbilityHashPair>() { // from class: emu.grasscutter.net.proto.ShortAbilityHashPairOuterClass.ShortAbilityHashPair.1
            @Override // com.google.protobuf.Parser
            public ShortAbilityHashPair parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ShortAbilityHashPair(input, extensionRegistry);
            }
        };

        private ShortAbilityHashPair(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ShortAbilityHashPair() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ShortAbilityHashPair();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ShortAbilityHashPair(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 53:
                                this.abilityNameHash_ = input.readSFixed32();
                                break;
                            case 125:
                                this.abilityConfigHash_ = input.readSFixed32();
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
            return ShortAbilityHashPairOuterClass.internal_static_ShortAbilityHashPair_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ShortAbilityHashPairOuterClass.internal_static_ShortAbilityHashPair_fieldAccessorTable.ensureFieldAccessorsInitialized(ShortAbilityHashPair.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder
        public int getAbilityNameHash() {
            return this.abilityNameHash_;
        }

        @Override // emu.grasscutter.net.proto.ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder
        public int getAbilityConfigHash() {
            return this.abilityConfigHash_;
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
            if (this.abilityNameHash_ != 0) {
                output.writeSFixed32(6, this.abilityNameHash_);
            }
            if (this.abilityConfigHash_ != 0) {
                output.writeSFixed32(15, this.abilityConfigHash_);
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
            if (this.abilityNameHash_ != 0) {
                size2 = 0 + CodedOutputStream.computeSFixed32Size(6, this.abilityNameHash_);
            }
            if (this.abilityConfigHash_ != 0) {
                size2 += CodedOutputStream.computeSFixed32Size(15, this.abilityConfigHash_);
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
            if (!(obj instanceof ShortAbilityHashPair)) {
                return equals(obj);
            }
            ShortAbilityHashPair other = (ShortAbilityHashPair) obj;
            return getAbilityNameHash() == other.getAbilityNameHash() && getAbilityConfigHash() == other.getAbilityConfigHash() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getAbilityNameHash())) + 15)) + getAbilityConfigHash())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ShortAbilityHashPair parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShortAbilityHashPair parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShortAbilityHashPair parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShortAbilityHashPair parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShortAbilityHashPair parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ShortAbilityHashPair parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ShortAbilityHashPair parseFrom(InputStream input) throws IOException {
            return (ShortAbilityHashPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShortAbilityHashPair parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShortAbilityHashPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShortAbilityHashPair parseDelimitedFrom(InputStream input) throws IOException {
            return (ShortAbilityHashPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ShortAbilityHashPair parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShortAbilityHashPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ShortAbilityHashPair parseFrom(CodedInputStream input) throws IOException {
            return (ShortAbilityHashPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ShortAbilityHashPair parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ShortAbilityHashPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ShortAbilityHashPair prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShortAbilityHashPairOuterClass$ShortAbilityHashPair$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ShortAbilityHashPairOrBuilder {
            private int abilityNameHash_;
            private int abilityConfigHash_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ShortAbilityHashPairOuterClass.internal_static_ShortAbilityHashPair_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ShortAbilityHashPairOuterClass.internal_static_ShortAbilityHashPair_fieldAccessorTable.ensureFieldAccessorsInitialized(ShortAbilityHashPair.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ShortAbilityHashPair.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.abilityNameHash_ = 0;
                this.abilityConfigHash_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ShortAbilityHashPairOuterClass.internal_static_ShortAbilityHashPair_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ShortAbilityHashPair getDefaultInstanceForType() {
                return ShortAbilityHashPair.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShortAbilityHashPair build() {
                ShortAbilityHashPair result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ShortAbilityHashPair buildPartial() {
                ShortAbilityHashPair result = new ShortAbilityHashPair(this);
                result.abilityNameHash_ = this.abilityNameHash_;
                result.abilityConfigHash_ = this.abilityConfigHash_;
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
                if (other instanceof ShortAbilityHashPair) {
                    return mergeFrom((ShortAbilityHashPair) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ShortAbilityHashPair other) {
                if (other == ShortAbilityHashPair.getDefaultInstance()) {
                    return this;
                }
                if (other.getAbilityNameHash() != 0) {
                    setAbilityNameHash(other.getAbilityNameHash());
                }
                if (other.getAbilityConfigHash() != 0) {
                    setAbilityConfigHash(other.getAbilityConfigHash());
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
                ShortAbilityHashPair parsedMessage = null;
                try {
                    try {
                        parsedMessage = ShortAbilityHashPair.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ShortAbilityHashPair) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder
            public int getAbilityNameHash() {
                return this.abilityNameHash_;
            }

            public Builder setAbilityNameHash(int value) {
                this.abilityNameHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityNameHash() {
                this.abilityNameHash_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ShortAbilityHashPairOuterClass.ShortAbilityHashPairOrBuilder
            public int getAbilityConfigHash() {
                return this.abilityConfigHash_;
            }

            public Builder setAbilityConfigHash(int value) {
                this.abilityConfigHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityConfigHash() {
                this.abilityConfigHash_ = 0;
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

        public static ShortAbilityHashPair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ShortAbilityHashPair> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ShortAbilityHashPair> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ShortAbilityHashPair getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
