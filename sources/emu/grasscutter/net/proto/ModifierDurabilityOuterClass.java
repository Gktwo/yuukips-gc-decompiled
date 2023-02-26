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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierDurabilityOuterClass.class */
public final class ModifierDurabilityOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ModifierDurability.proto\"F\n\u0012ModifierDurability\u0012\u0013\n\u000breduceRatio\u0018\u0001 \u0001(\u0002\u0012\u001b\n\u0013remainingDurability\u0018\u0002 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ModifierDurability_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ModifierDurability_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ModifierDurability_descriptor, new String[]{"ReduceRatio", "RemainingDurability"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierDurabilityOuterClass$ModifierDurabilityOrBuilder.class */
    public interface ModifierDurabilityOrBuilder extends MessageOrBuilder {
        float getReduceRatio();

        float getRemainingDurability();
    }

    private ModifierDurabilityOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierDurabilityOuterClass$ModifierDurability.class */
    public static final class ModifierDurability extends GeneratedMessageV3 implements ModifierDurabilityOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REDUCERATIO_FIELD_NUMBER = 1;
        private float reduceRatio_;
        public static final int REMAININGDURABILITY_FIELD_NUMBER = 2;
        private float remainingDurability_;
        private byte memoizedIsInitialized;
        private static final ModifierDurability DEFAULT_INSTANCE = new ModifierDurability();
        private static final Parser<ModifierDurability> PARSER = new AbstractParser<ModifierDurability>() { // from class: emu.grasscutter.net.proto.ModifierDurabilityOuterClass.ModifierDurability.1
            @Override // com.google.protobuf.Parser
            public ModifierDurability parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ModifierDurability(input, extensionRegistry);
            }
        };

        private ModifierDurability(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ModifierDurability() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ModifierDurability();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ModifierDurability(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 13:
                                this.reduceRatio_ = input.readFloat();
                                break;
                            case 21:
                                this.remainingDurability_ = input.readFloat();
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
            return ModifierDurabilityOuterClass.internal_static_ModifierDurability_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ModifierDurabilityOuterClass.internal_static_ModifierDurability_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifierDurability.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder
        public float getReduceRatio() {
            return this.reduceRatio_;
        }

        @Override // emu.grasscutter.net.proto.ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder
        public float getRemainingDurability() {
            return this.remainingDurability_;
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
            if (this.reduceRatio_ != 0.0f) {
                output.writeFloat(1, this.reduceRatio_);
            }
            if (this.remainingDurability_ != 0.0f) {
                output.writeFloat(2, this.remainingDurability_);
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
            if (this.reduceRatio_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(1, this.reduceRatio_);
            }
            if (this.remainingDurability_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.remainingDurability_);
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
            if (!(obj instanceof ModifierDurability)) {
                return equals(obj);
            }
            ModifierDurability other = (ModifierDurability) obj;
            return Float.floatToIntBits(getReduceRatio()) == Float.floatToIntBits(other.getReduceRatio()) && Float.floatToIntBits(getRemainingDurability()) == Float.floatToIntBits(other.getRemainingDurability()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Float.floatToIntBits(getReduceRatio()))) + 2)) + Float.floatToIntBits(getRemainingDurability()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ModifierDurability parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ModifierDurability parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ModifierDurability parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ModifierDurability parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ModifierDurability parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ModifierDurability parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ModifierDurability parseFrom(InputStream input) throws IOException {
            return (ModifierDurability) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ModifierDurability parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ModifierDurability) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ModifierDurability parseDelimitedFrom(InputStream input) throws IOException {
            return (ModifierDurability) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ModifierDurability parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ModifierDurability) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ModifierDurability parseFrom(CodedInputStream input) throws IOException {
            return (ModifierDurability) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ModifierDurability parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ModifierDurability) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ModifierDurability prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierDurabilityOuterClass$ModifierDurability$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ModifierDurabilityOrBuilder {
            private float reduceRatio_;
            private float remainingDurability_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ModifierDurabilityOuterClass.internal_static_ModifierDurability_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ModifierDurabilityOuterClass.internal_static_ModifierDurability_fieldAccessorTable.ensureFieldAccessorsInitialized(ModifierDurability.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ModifierDurability.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.reduceRatio_ = 0.0f;
                this.remainingDurability_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ModifierDurabilityOuterClass.internal_static_ModifierDurability_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ModifierDurability getDefaultInstanceForType() {
                return ModifierDurability.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ModifierDurability build() {
                ModifierDurability result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ModifierDurability buildPartial() {
                ModifierDurability result = new ModifierDurability(this);
                result.reduceRatio_ = this.reduceRatio_;
                result.remainingDurability_ = this.remainingDurability_;
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
                if (other instanceof ModifierDurability) {
                    return mergeFrom((ModifierDurability) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ModifierDurability other) {
                if (other == ModifierDurability.getDefaultInstance()) {
                    return this;
                }
                if (other.getReduceRatio() != 0.0f) {
                    setReduceRatio(other.getReduceRatio());
                }
                if (other.getRemainingDurability() != 0.0f) {
                    setRemainingDurability(other.getRemainingDurability());
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
                ModifierDurability parsedMessage = null;
                try {
                    try {
                        parsedMessage = ModifierDurability.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ModifierDurability) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder
            public float getReduceRatio() {
                return this.reduceRatio_;
            }

            public Builder setReduceRatio(float value) {
                this.reduceRatio_ = value;
                onChanged();
                return this;
            }

            public Builder clearReduceRatio() {
                this.reduceRatio_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder
            public float getRemainingDurability() {
                return this.remainingDurability_;
            }

            public Builder setRemainingDurability(float value) {
                this.remainingDurability_ = value;
                onChanged();
                return this;
            }

            public Builder clearRemainingDurability() {
                this.remainingDurability_ = 0.0f;
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

        public static ModifierDurability getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ModifierDurability> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ModifierDurability> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ModifierDurability getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
