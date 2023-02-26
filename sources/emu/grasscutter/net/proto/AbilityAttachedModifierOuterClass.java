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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAttachedModifierOuterClass.class */
public final class AbilityAttachedModifierOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAbilityAttachedModifier.proto\"\u0001\n\u0017AbilityAttachedModifier\u0012\u0011\n\tisInvalid\u0018\u0001 \u0001(\b\u0012\u0015\n\rownerEntityId\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013instancedModifierId\u0018\u0003 \u0001(\r\u0012\u001c\n\u0014isServerbuffModifier\u0018\u0004 \u0001(\b\u0012\u0016\n\u000eattachNameHash\u0018\u0005 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityAttachedModifier_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityAttachedModifier_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityAttachedModifier_descriptor, new String[]{"IsInvalid", "OwnerEntityId", "InstancedModifierId", "IsServerbuffModifier", "AttachNameHash"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAttachedModifierOuterClass$AbilityAttachedModifierOrBuilder.class */
    public interface AbilityAttachedModifierOrBuilder extends MessageOrBuilder {
        boolean getIsInvalid();

        int getOwnerEntityId();

        int getInstancedModifierId();

        boolean getIsServerbuffModifier();

        int getAttachNameHash();
    }

    private AbilityAttachedModifierOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAttachedModifierOuterClass$AbilityAttachedModifier.class */
    public static final class AbilityAttachedModifier extends GeneratedMessageV3 implements AbilityAttachedModifierOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISINVALID_FIELD_NUMBER = 1;
        private boolean isInvalid_;
        public static final int OWNERENTITYID_FIELD_NUMBER = 2;
        private int ownerEntityId_;
        public static final int INSTANCEDMODIFIERID_FIELD_NUMBER = 3;
        private int instancedModifierId_;
        public static final int ISSERVERBUFFMODIFIER_FIELD_NUMBER = 4;
        private boolean isServerbuffModifier_;
        public static final int ATTACHNAMEHASH_FIELD_NUMBER = 5;
        private int attachNameHash_;
        private byte memoizedIsInitialized;
        private static final AbilityAttachedModifier DEFAULT_INSTANCE = new AbilityAttachedModifier();
        private static final Parser<AbilityAttachedModifier> PARSER = new AbstractParser<AbilityAttachedModifier>() { // from class: emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifier.1
            @Override // com.google.protobuf.Parser
            public AbilityAttachedModifier parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityAttachedModifier(input, extensionRegistry);
            }
        };

        private AbilityAttachedModifier(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityAttachedModifier() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityAttachedModifier();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityAttachedModifier(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isInvalid_ = input.readBool();
                                break;
                            case 16:
                                this.ownerEntityId_ = input.readUInt32();
                                break;
                            case 24:
                                this.instancedModifierId_ = input.readUInt32();
                                break;
                            case 32:
                                this.isServerbuffModifier_ = input.readBool();
                                break;
                            case 40:
                                this.attachNameHash_ = input.readInt32();
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
            return AbilityAttachedModifierOuterClass.internal_static_AbilityAttachedModifier_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityAttachedModifierOuterClass.internal_static_AbilityAttachedModifier_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityAttachedModifier.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
        public boolean getIsInvalid() {
            return this.isInvalid_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
        public int getOwnerEntityId() {
            return this.ownerEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
        public int getInstancedModifierId() {
            return this.instancedModifierId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
        public boolean getIsServerbuffModifier() {
            return this.isServerbuffModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
        public int getAttachNameHash() {
            return this.attachNameHash_;
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
            if (this.isInvalid_) {
                output.writeBool(1, this.isInvalid_);
            }
            if (this.ownerEntityId_ != 0) {
                output.writeUInt32(2, this.ownerEntityId_);
            }
            if (this.instancedModifierId_ != 0) {
                output.writeUInt32(3, this.instancedModifierId_);
            }
            if (this.isServerbuffModifier_) {
                output.writeBool(4, this.isServerbuffModifier_);
            }
            if (this.attachNameHash_ != 0) {
                output.writeInt32(5, this.attachNameHash_);
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
            if (this.isInvalid_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isInvalid_);
            }
            if (this.ownerEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.ownerEntityId_);
            }
            if (this.instancedModifierId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.instancedModifierId_);
            }
            if (this.isServerbuffModifier_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isServerbuffModifier_);
            }
            if (this.attachNameHash_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.attachNameHash_);
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
            if (!(obj instanceof AbilityAttachedModifier)) {
                return equals(obj);
            }
            AbilityAttachedModifier other = (AbilityAttachedModifier) obj;
            return getIsInvalid() == other.getIsInvalid() && getOwnerEntityId() == other.getOwnerEntityId() && getInstancedModifierId() == other.getInstancedModifierId() && getIsServerbuffModifier() == other.getIsServerbuffModifier() && getAttachNameHash() == other.getAttachNameHash() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsInvalid()))) + 2)) + getOwnerEntityId())) + 3)) + getInstancedModifierId())) + 4)) + Internal.hashBoolean(getIsServerbuffModifier()))) + 5)) + getAttachNameHash())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AbilityAttachedModifier parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAttachedModifier parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAttachedModifier parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAttachedModifier parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAttachedModifier parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAttachedModifier parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAttachedModifier parseFrom(InputStream input) throws IOException {
            return (AbilityAttachedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityAttachedModifier parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAttachedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityAttachedModifier parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityAttachedModifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityAttachedModifier parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAttachedModifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityAttachedModifier parseFrom(CodedInputStream input) throws IOException {
            return (AbilityAttachedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityAttachedModifier parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAttachedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityAttachedModifier prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAttachedModifierOuterClass$AbilityAttachedModifier$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityAttachedModifierOrBuilder {
            private boolean isInvalid_;
            private int ownerEntityId_;
            private int instancedModifierId_;
            private boolean isServerbuffModifier_;
            private int attachNameHash_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityAttachedModifierOuterClass.internal_static_AbilityAttachedModifier_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityAttachedModifierOuterClass.internal_static_AbilityAttachedModifier_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityAttachedModifier.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityAttachedModifier.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isInvalid_ = false;
                this.ownerEntityId_ = 0;
                this.instancedModifierId_ = 0;
                this.isServerbuffModifier_ = false;
                this.attachNameHash_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityAttachedModifierOuterClass.internal_static_AbilityAttachedModifier_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityAttachedModifier getDefaultInstanceForType() {
                return AbilityAttachedModifier.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityAttachedModifier build() {
                AbilityAttachedModifier result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityAttachedModifier buildPartial() {
                AbilityAttachedModifier result = new AbilityAttachedModifier(this);
                result.isInvalid_ = this.isInvalid_;
                result.ownerEntityId_ = this.ownerEntityId_;
                result.instancedModifierId_ = this.instancedModifierId_;
                result.isServerbuffModifier_ = this.isServerbuffModifier_;
                result.attachNameHash_ = this.attachNameHash_;
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
                if (other instanceof AbilityAttachedModifier) {
                    return mergeFrom((AbilityAttachedModifier) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityAttachedModifier other) {
                if (other == AbilityAttachedModifier.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsInvalid()) {
                    setIsInvalid(other.getIsInvalid());
                }
                if (other.getOwnerEntityId() != 0) {
                    setOwnerEntityId(other.getOwnerEntityId());
                }
                if (other.getInstancedModifierId() != 0) {
                    setInstancedModifierId(other.getInstancedModifierId());
                }
                if (other.getIsServerbuffModifier()) {
                    setIsServerbuffModifier(other.getIsServerbuffModifier());
                }
                if (other.getAttachNameHash() != 0) {
                    setAttachNameHash(other.getAttachNameHash());
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
                AbilityAttachedModifier parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityAttachedModifier.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityAttachedModifier) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
            public boolean getIsInvalid() {
                return this.isInvalid_;
            }

            public Builder setIsInvalid(boolean value) {
                this.isInvalid_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInvalid() {
                this.isInvalid_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
            public int getOwnerEntityId() {
                return this.ownerEntityId_;
            }

            public Builder setOwnerEntityId(int value) {
                this.ownerEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearOwnerEntityId() {
                this.ownerEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
            public int getInstancedModifierId() {
                return this.instancedModifierId_;
            }

            public Builder setInstancedModifierId(int value) {
                this.instancedModifierId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstancedModifierId() {
                this.instancedModifierId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
            public boolean getIsServerbuffModifier() {
                return this.isServerbuffModifier_;
            }

            public Builder setIsServerbuffModifier(boolean value) {
                this.isServerbuffModifier_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsServerbuffModifier() {
                this.isServerbuffModifier_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder
            public int getAttachNameHash() {
                return this.attachNameHash_;
            }

            public Builder setAttachNameHash(int value) {
                this.attachNameHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttachNameHash() {
                this.attachNameHash_ = 0;
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

        public static AbilityAttachedModifier getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityAttachedModifier> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityAttachedModifier> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityAttachedModifier getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
