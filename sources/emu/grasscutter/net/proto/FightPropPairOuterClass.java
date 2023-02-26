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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FightPropPairOuterClass.class */
public final class FightPropPairOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013FightPropPair.proto\"4\n\rFightPropPair\u0012\u0010\n\bpropType\u0018\u0001 \u0001(\r\u0012\u0011\n\tpropValue\u0018\u0002 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FightPropPair_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FightPropPair_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FightPropPair_descriptor, new String[]{"PropType", "PropValue"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FightPropPairOuterClass$FightPropPairOrBuilder.class */
    public interface FightPropPairOrBuilder extends MessageOrBuilder {
        int getPropType();

        float getPropValue();
    }

    private FightPropPairOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FightPropPairOuterClass$FightPropPair.class */
    public static final class FightPropPair extends GeneratedMessageV3 implements FightPropPairOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROPTYPE_FIELD_NUMBER = 1;
        private int propType_;
        public static final int PROPVALUE_FIELD_NUMBER = 2;
        private float propValue_;
        private byte memoizedIsInitialized;
        private static final FightPropPair DEFAULT_INSTANCE = new FightPropPair();
        private static final Parser<FightPropPair> PARSER = new AbstractParser<FightPropPair>() { // from class: emu.grasscutter.net.proto.FightPropPairOuterClass.FightPropPair.1
            @Override // com.google.protobuf.Parser
            public FightPropPair parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FightPropPair(input, extensionRegistry);
            }
        };

        private FightPropPair(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FightPropPair() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FightPropPair();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FightPropPair(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.propType_ = input.readUInt32();
                                break;
                            case 21:
                                this.propValue_ = input.readFloat();
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
            return FightPropPairOuterClass.internal_static_FightPropPair_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FightPropPairOuterClass.internal_static_FightPropPair_fieldAccessorTable.ensureFieldAccessorsInitialized(FightPropPair.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FightPropPairOuterClass.FightPropPairOrBuilder
        public int getPropType() {
            return this.propType_;
        }

        @Override // emu.grasscutter.net.proto.FightPropPairOuterClass.FightPropPairOrBuilder
        public float getPropValue() {
            return this.propValue_;
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
            if (this.propType_ != 0) {
                output.writeUInt32(1, this.propType_);
            }
            if (this.propValue_ != 0.0f) {
                output.writeFloat(2, this.propValue_);
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
            if (this.propType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.propType_);
            }
            if (this.propValue_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(2, this.propValue_);
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
            if (!(obj instanceof FightPropPair)) {
                return equals(obj);
            }
            FightPropPair other = (FightPropPair) obj;
            return getPropType() == other.getPropType() && Float.floatToIntBits(getPropValue()) == Float.floatToIntBits(other.getPropValue()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getPropType())) + 2)) + Float.floatToIntBits(getPropValue()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FightPropPair parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FightPropPair parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FightPropPair parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FightPropPair parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FightPropPair parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FightPropPair parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FightPropPair parseFrom(InputStream input) throws IOException {
            return (FightPropPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FightPropPair parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FightPropPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FightPropPair parseDelimitedFrom(InputStream input) throws IOException {
            return (FightPropPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FightPropPair parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FightPropPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FightPropPair parseFrom(CodedInputStream input) throws IOException {
            return (FightPropPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FightPropPair parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FightPropPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FightPropPair prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FightPropPairOuterClass$FightPropPair$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FightPropPairOrBuilder {
            private int propType_;
            private float propValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FightPropPairOuterClass.internal_static_FightPropPair_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FightPropPairOuterClass.internal_static_FightPropPair_fieldAccessorTable.ensureFieldAccessorsInitialized(FightPropPair.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FightPropPair.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.propType_ = 0;
                this.propValue_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FightPropPairOuterClass.internal_static_FightPropPair_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FightPropPair getDefaultInstanceForType() {
                return FightPropPair.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FightPropPair build() {
                FightPropPair result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FightPropPair buildPartial() {
                FightPropPair result = new FightPropPair(this);
                result.propType_ = this.propType_;
                result.propValue_ = this.propValue_;
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
                if (other instanceof FightPropPair) {
                    return mergeFrom((FightPropPair) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FightPropPair other) {
                if (other == FightPropPair.getDefaultInstance()) {
                    return this;
                }
                if (other.getPropType() != 0) {
                    setPropType(other.getPropType());
                }
                if (other.getPropValue() != 0.0f) {
                    setPropValue(other.getPropValue());
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
                FightPropPair parsedMessage = null;
                try {
                    try {
                        parsedMessage = FightPropPair.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FightPropPair) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FightPropPairOuterClass.FightPropPairOrBuilder
            public int getPropType() {
                return this.propType_;
            }

            public Builder setPropType(int value) {
                this.propType_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropType() {
                this.propType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FightPropPairOuterClass.FightPropPairOrBuilder
            public float getPropValue() {
                return this.propValue_;
            }

            public Builder setPropValue(float value) {
                this.propValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearPropValue() {
                this.propValue_ = 0.0f;
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

        public static FightPropPair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FightPropPair> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FightPropPair> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FightPropPair getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
