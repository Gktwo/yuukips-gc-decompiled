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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityStringOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierPropertyOuterClass.class */
public final class ModifierPropertyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016ModifierProperty.proto\u001a\u0013AbilityString.proto\">\n\u0010ModifierProperty\u0012\u001b\n\u0003key\u0018\b \u0001(\u000b2\u000e.AbilityString\u0012\r\n\u0005value\u0018\u000e \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityStringOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ModifierProperty_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ModifierProperty_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ModifierProperty_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierPropertyOuterClass$ModifierPropertyOrBuilder.class */
    public interface ModifierPropertyOrBuilder extends MessageOrBuilder {
        boolean hasKey();

        AbilityStringOuterClass.AbilityString getKey();

        AbilityStringOuterClass.AbilityStringOrBuilder getKeyOrBuilder();

        float getValue();
    }

    private ModifierPropertyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierPropertyOuterClass$ModifierProperty.class */
    public static final class ModifierProperty extends GeneratedMessageV3 implements ModifierPropertyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int KEY_FIELD_NUMBER = 8;
        private AbilityStringOuterClass.AbilityString key_;
        public static final int VALUE_FIELD_NUMBER = 14;
        private float value_;
        private byte memoizedIsInitialized;
        private static final ModifierProperty DEFAULT_INSTANCE = new ModifierProperty();
        private static final Parser<ModifierProperty> PARSER = new AbstractParser<ModifierProperty>() { // from class: emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierProperty.1
            @Override // com.google.protobuf.Parser
            public ModifierProperty parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ModifierProperty(input, extensionRegistry);
            }
        };

        private ModifierProperty(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ModifierProperty() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ModifierProperty();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ModifierProperty(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 66:
                                    AbilityStringOuterClass.AbilityString.Builder subBuilder = this.key_ != null ? this.key_.toBuilder() : null;
                                    this.key_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.key_);
                                        this.key_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 117:
                                    this.value_ = input.readFloat();
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
            return ModifierPropertyOuterClass.internal_static_ModifierProperty_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ModifierPropertyOuterClass.internal_static_ModifierProperty_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifierProperty.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
        public boolean hasKey() {
            return this.key_ != null;
        }

        @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
        public AbilityStringOuterClass.AbilityString getKey() {
            return this.key_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.key_;
        }

        @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getKeyOrBuilder() {
            return getKey();
        }

        @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
        public float getValue() {
            return this.value_;
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
            if (this.key_ != null) {
                output.writeMessage(8, getKey());
            }
            if (this.value_ != 0.0f) {
                output.writeFloat(14, this.value_);
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
            if (this.key_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(8, getKey());
            }
            if (this.value_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(14, this.value_);
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
            if (!(obj instanceof ModifierProperty)) {
                return equals(obj);
            }
            ModifierProperty other = (ModifierProperty) obj;
            if (hasKey() != other.hasKey()) {
                return false;
            }
            return (!hasKey() || getKey().equals(other.getKey())) && Float.floatToIntBits(getValue()) == Float.floatToIntBits(other.getValue()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasKey()) {
                hash = (53 * ((37 * hash) + 8)) + getKey().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + Float.floatToIntBits(getValue()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ModifierProperty parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ModifierProperty parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ModifierProperty parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ModifierProperty parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ModifierProperty parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ModifierProperty parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ModifierProperty parseFrom(InputStream input) throws IOException {
            return (ModifierProperty) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ModifierProperty parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ModifierProperty) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ModifierProperty parseDelimitedFrom(InputStream input) throws IOException {
            return (ModifierProperty) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ModifierProperty parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ModifierProperty) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ModifierProperty parseFrom(CodedInputStream input) throws IOException {
            return (ModifierProperty) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ModifierProperty parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ModifierProperty) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ModifierProperty prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierPropertyOuterClass$ModifierProperty$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ModifierPropertyOrBuilder {
            private AbilityStringOuterClass.AbilityString key_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> keyBuilder_;
            private float value_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ModifierPropertyOuterClass.internal_static_ModifierProperty_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ModifierPropertyOuterClass.internal_static_ModifierProperty_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifierProperty.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ModifierProperty.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.keyBuilder_ == null) {
                    this.key_ = null;
                } else {
                    this.key_ = null;
                    this.keyBuilder_ = null;
                }
                this.value_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ModifierPropertyOuterClass.internal_static_ModifierProperty_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ModifierProperty getDefaultInstanceForType() {
                return ModifierProperty.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ModifierProperty build() {
                ModifierProperty result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ModifierProperty buildPartial() {
                ModifierProperty result = new ModifierProperty(this);
                if (this.keyBuilder_ == null) {
                    result.key_ = this.key_;
                } else {
                    result.key_ = this.keyBuilder_.build();
                }
                result.value_ = this.value_;
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
                if (other instanceof ModifierProperty) {
                    return mergeFrom((ModifierProperty) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ModifierProperty other) {
                if (other == ModifierProperty.getDefaultInstance()) {
                    return this;
                }
                if (other.hasKey()) {
                    mergeKey(other.getKey());
                }
                if (other.getValue() != 0.0f) {
                    setValue(other.getValue());
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
                ModifierProperty parsedMessage = null;
                try {
                    try {
                        parsedMessage = ModifierProperty.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ModifierProperty) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
            public boolean hasKey() {
                return (this.keyBuilder_ == null && this.key_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
            public AbilityStringOuterClass.AbilityString getKey() {
                if (this.keyBuilder_ == null) {
                    return this.key_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.key_;
                }
                return this.keyBuilder_.getMessage();
            }

            public Builder setKey(AbilityStringOuterClass.AbilityString value) {
                if (this.keyBuilder_ != null) {
                    this.keyBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.key_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setKey(AbilityStringOuterClass.AbilityString.Builder builderForValue) {
                if (this.keyBuilder_ == null) {
                    this.key_ = builderForValue.build();
                    onChanged();
                } else {
                    this.keyBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeKey(AbilityStringOuterClass.AbilityString value) {
                if (this.keyBuilder_ == null) {
                    if (this.key_ != null) {
                        this.key_ = AbilityStringOuterClass.AbilityString.newBuilder(this.key_).mergeFrom(value).buildPartial();
                    } else {
                        this.key_ = value;
                    }
                    onChanged();
                } else {
                    this.keyBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearKey() {
                if (this.keyBuilder_ == null) {
                    this.key_ = null;
                    onChanged();
                } else {
                    this.key_ = null;
                    this.keyBuilder_ = null;
                }
                return this;
            }

            public AbilityStringOuterClass.AbilityString.Builder getKeyBuilder() {
                onChanged();
                return getKeyFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
            public AbilityStringOuterClass.AbilityStringOrBuilder getKeyOrBuilder() {
                if (this.keyBuilder_ != null) {
                    return this.keyBuilder_.getMessageOrBuilder();
                }
                return this.key_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.key_;
            }

            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> getKeyFieldBuilder() {
                if (this.keyBuilder_ == null) {
                    this.keyBuilder_ = new SingleFieldBuilderV3<>(getKey(), getParentForChildren(), isClean());
                    this.key_ = null;
                }
                return this.keyBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ModifierPropertyOuterClass.ModifierPropertyOrBuilder
            public float getValue() {
                return this.value_;
            }

            public Builder setValue(float value) {
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.value_ = 0.0f;
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

        public static ModifierProperty getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ModifierProperty> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ModifierProperty> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ModifierProperty getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityStringOuterClass.getDescriptor();
    }
}
