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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityEmbryoOuterClass.class */
public final class AbilityEmbryoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013AbilityEmbryo.proto\"\\\n\rAbilityEmbryo\u0012\u0011\n\tabilityId\u0018\u0001 \u0001(\r\u0012\u0017\n\u000fabilityNameHash\u0018\u0002 \u0001(\u0007\u0012\u001f\n\u0017abilityOverrideNameHash\u0018\u0003 \u0001(\u0007B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityEmbryo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityEmbryo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityEmbryo_descriptor, new String[]{"AbilityId", "AbilityNameHash", "AbilityOverrideNameHash"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityEmbryoOuterClass$AbilityEmbryoOrBuilder.class */
    public interface AbilityEmbryoOrBuilder extends MessageOrBuilder {
        int getAbilityId();

        int getAbilityNameHash();

        int getAbilityOverrideNameHash();
    }

    private AbilityEmbryoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityEmbryoOuterClass$AbilityEmbryo.class */
    public static final class AbilityEmbryo extends GeneratedMessageV3 implements AbilityEmbryoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ABILITYID_FIELD_NUMBER = 1;
        private int abilityId_;
        public static final int ABILITYNAMEHASH_FIELD_NUMBER = 2;
        private int abilityNameHash_;
        public static final int ABILITYOVERRIDENAMEHASH_FIELD_NUMBER = 3;
        private int abilityOverrideNameHash_;
        private byte memoizedIsInitialized;
        private static final AbilityEmbryo DEFAULT_INSTANCE = new AbilityEmbryo();
        private static final Parser<AbilityEmbryo> PARSER = new AbstractParser<AbilityEmbryo>() { // from class: emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryo.1
            @Override // com.google.protobuf.Parser
            public AbilityEmbryo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityEmbryo(input, extensionRegistry);
            }
        };

        private AbilityEmbryo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityEmbryo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityEmbryo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityEmbryo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.abilityId_ = input.readUInt32();
                                    break;
                                case 21:
                                    this.abilityNameHash_ = input.readFixed32();
                                    break;
                                case 29:
                                    this.abilityOverrideNameHash_ = input.readFixed32();
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
            return AbilityEmbryoOuterClass.internal_static_AbilityEmbryo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityEmbryoOuterClass.internal_static_AbilityEmbryo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityEmbryo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder
        public int getAbilityId() {
            return this.abilityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder
        public int getAbilityNameHash() {
            return this.abilityNameHash_;
        }

        @Override // emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder
        public int getAbilityOverrideNameHash() {
            return this.abilityOverrideNameHash_;
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
            if (this.abilityId_ != 0) {
                output.writeUInt32(1, this.abilityId_);
            }
            if (this.abilityNameHash_ != 0) {
                output.writeFixed32(2, this.abilityNameHash_);
            }
            if (this.abilityOverrideNameHash_ != 0) {
                output.writeFixed32(3, this.abilityOverrideNameHash_);
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
            if (this.abilityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.abilityId_);
            }
            if (this.abilityNameHash_ != 0) {
                size2 += CodedOutputStream.computeFixed32Size(2, this.abilityNameHash_);
            }
            if (this.abilityOverrideNameHash_ != 0) {
                size2 += CodedOutputStream.computeFixed32Size(3, this.abilityOverrideNameHash_);
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
            if (!(obj instanceof AbilityEmbryo)) {
                return equals(obj);
            }
            AbilityEmbryo other = (AbilityEmbryo) obj;
            return getAbilityId() == other.getAbilityId() && getAbilityNameHash() == other.getAbilityNameHash() && getAbilityOverrideNameHash() == other.getAbilityOverrideNameHash() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getAbilityId())) + 2)) + getAbilityNameHash())) + 3)) + getAbilityOverrideNameHash())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AbilityEmbryo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityEmbryo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityEmbryo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityEmbryo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityEmbryo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityEmbryo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityEmbryo parseFrom(InputStream input) throws IOException {
            return (AbilityEmbryo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityEmbryo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityEmbryo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityEmbryo parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityEmbryo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityEmbryo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityEmbryo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityEmbryo parseFrom(CodedInputStream input) throws IOException {
            return (AbilityEmbryo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityEmbryo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityEmbryo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityEmbryo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityEmbryoOuterClass$AbilityEmbryo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityEmbryoOrBuilder {
            private int abilityId_;
            private int abilityNameHash_;
            private int abilityOverrideNameHash_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityEmbryoOuterClass.internal_static_AbilityEmbryo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityEmbryoOuterClass.internal_static_AbilityEmbryo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityEmbryo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityEmbryo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.abilityId_ = 0;
                this.abilityNameHash_ = 0;
                this.abilityOverrideNameHash_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityEmbryoOuterClass.internal_static_AbilityEmbryo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityEmbryo getDefaultInstanceForType() {
                return AbilityEmbryo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityEmbryo build() {
                AbilityEmbryo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityEmbryo buildPartial() {
                AbilityEmbryo result = new AbilityEmbryo(this);
                result.abilityId_ = this.abilityId_;
                result.abilityNameHash_ = this.abilityNameHash_;
                result.abilityOverrideNameHash_ = this.abilityOverrideNameHash_;
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
                if (other instanceof AbilityEmbryo) {
                    return mergeFrom((AbilityEmbryo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityEmbryo other) {
                if (other == AbilityEmbryo.getDefaultInstance()) {
                    return this;
                }
                if (other.getAbilityId() != 0) {
                    setAbilityId(other.getAbilityId());
                }
                if (other.getAbilityNameHash() != 0) {
                    setAbilityNameHash(other.getAbilityNameHash());
                }
                if (other.getAbilityOverrideNameHash() != 0) {
                    setAbilityOverrideNameHash(other.getAbilityOverrideNameHash());
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
                AbilityEmbryo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityEmbryo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityEmbryo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder
            public int getAbilityId() {
                return this.abilityId_;
            }

            public Builder setAbilityId(int value) {
                this.abilityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityId() {
                this.abilityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder
            public int getAbilityOverrideNameHash() {
                return this.abilityOverrideNameHash_;
            }

            public Builder setAbilityOverrideNameHash(int value) {
                this.abilityOverrideNameHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityOverrideNameHash() {
                this.abilityOverrideNameHash_ = 0;
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

        public static AbilityEmbryo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityEmbryo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityEmbryo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityEmbryo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
