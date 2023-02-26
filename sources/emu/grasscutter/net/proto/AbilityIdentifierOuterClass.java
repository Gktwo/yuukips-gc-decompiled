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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityIdentifierOuterClass.class */
public final class AbilityIdentifierOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017AbilityIdentifier.proto\"­\u0001\n\u0011AbilityIdentifier\u0012\u0017\n\u000fmodifierOwnerId\u0018\u0003 \u0001(\r\u0012\u0017\n\u000fabilityCasterId\u0018\n \u0001(\r\u0012\u001a\n\u0012instancedAbilityId\u0018\u0005 \u0001(\r\u0012\u001c\n\u0014isServerbuffModifier\u0018\u0004 \u0001(\b\u0012\u000f\n\u0007localId\u0018\b \u0001(\u0005\u0012\u001b\n\u0013instancedModifierId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityIdentifier_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityIdentifier_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityIdentifier_descriptor, new String[]{"ModifierOwnerId", "AbilityCasterId", "InstancedAbilityId", "IsServerbuffModifier", "LocalId", "InstancedModifierId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityIdentifierOuterClass$AbilityIdentifierOrBuilder.class */
    public interface AbilityIdentifierOrBuilder extends MessageOrBuilder {
        int getModifierOwnerId();

        int getAbilityCasterId();

        int getInstancedAbilityId();

        boolean getIsServerbuffModifier();

        int getLocalId();

        int getInstancedModifierId();
    }

    private AbilityIdentifierOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityIdentifierOuterClass$AbilityIdentifier.class */
    public static final class AbilityIdentifier extends GeneratedMessageV3 implements AbilityIdentifierOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MODIFIEROWNERID_FIELD_NUMBER = 3;
        private int modifierOwnerId_;
        public static final int ABILITYCASTERID_FIELD_NUMBER = 10;
        private int abilityCasterId_;
        public static final int INSTANCEDABILITYID_FIELD_NUMBER = 5;
        private int instancedAbilityId_;
        public static final int ISSERVERBUFFMODIFIER_FIELD_NUMBER = 4;
        private boolean isServerbuffModifier_;
        public static final int LOCALID_FIELD_NUMBER = 8;
        private int localId_;
        public static final int INSTANCEDMODIFIERID_FIELD_NUMBER = 11;
        private int instancedModifierId_;
        private byte memoizedIsInitialized;
        private static final AbilityIdentifier DEFAULT_INSTANCE = new AbilityIdentifier();
        private static final Parser<AbilityIdentifier> PARSER = new AbstractParser<AbilityIdentifier>() { // from class: emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifier.1
            @Override // com.google.protobuf.Parser
            public AbilityIdentifier parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityIdentifier(input, extensionRegistry);
            }
        };

        private AbilityIdentifier(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityIdentifier() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityIdentifier();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityIdentifier(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.modifierOwnerId_ = input.readUInt32();
                                break;
                            case 32:
                                this.isServerbuffModifier_ = input.readBool();
                                break;
                            case 40:
                                this.instancedAbilityId_ = input.readUInt32();
                                break;
                            case 64:
                                this.localId_ = input.readInt32();
                                break;
                            case 80:
                                this.abilityCasterId_ = input.readUInt32();
                                break;
                            case 88:
                                this.instancedModifierId_ = input.readUInt32();
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
            return AbilityIdentifierOuterClass.internal_static_AbilityIdentifier_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityIdentifierOuterClass.internal_static_AbilityIdentifier_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityIdentifier.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
        public int getModifierOwnerId() {
            return this.modifierOwnerId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
        public int getAbilityCasterId() {
            return this.abilityCasterId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
        public int getInstancedAbilityId() {
            return this.instancedAbilityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
        public boolean getIsServerbuffModifier() {
            return this.isServerbuffModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
        public int getInstancedModifierId() {
            return this.instancedModifierId_;
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
            if (this.modifierOwnerId_ != 0) {
                output.writeUInt32(3, this.modifierOwnerId_);
            }
            if (this.isServerbuffModifier_) {
                output.writeBool(4, this.isServerbuffModifier_);
            }
            if (this.instancedAbilityId_ != 0) {
                output.writeUInt32(5, this.instancedAbilityId_);
            }
            if (this.localId_ != 0) {
                output.writeInt32(8, this.localId_);
            }
            if (this.abilityCasterId_ != 0) {
                output.writeUInt32(10, this.abilityCasterId_);
            }
            if (this.instancedModifierId_ != 0) {
                output.writeUInt32(11, this.instancedModifierId_);
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
            if (this.modifierOwnerId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.modifierOwnerId_);
            }
            if (this.isServerbuffModifier_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isServerbuffModifier_);
            }
            if (this.instancedAbilityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.instancedAbilityId_);
            }
            if (this.localId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.localId_);
            }
            if (this.abilityCasterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.abilityCasterId_);
            }
            if (this.instancedModifierId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.instancedModifierId_);
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
            if (!(obj instanceof AbilityIdentifier)) {
                return equals(obj);
            }
            AbilityIdentifier other = (AbilityIdentifier) obj;
            return getModifierOwnerId() == other.getModifierOwnerId() && getAbilityCasterId() == other.getAbilityCasterId() && getInstancedAbilityId() == other.getInstancedAbilityId() && getIsServerbuffModifier() == other.getIsServerbuffModifier() && getLocalId() == other.getLocalId() && getInstancedModifierId() == other.getInstancedModifierId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getModifierOwnerId())) + 10)) + getAbilityCasterId())) + 5)) + getInstancedAbilityId())) + 4)) + Internal.hashBoolean(getIsServerbuffModifier()))) + 8)) + getLocalId())) + 11)) + getInstancedModifierId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AbilityIdentifier parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityIdentifier parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityIdentifier parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityIdentifier parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityIdentifier parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityIdentifier parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityIdentifier parseFrom(InputStream input) throws IOException {
            return (AbilityIdentifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityIdentifier parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityIdentifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityIdentifier parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityIdentifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityIdentifier parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityIdentifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityIdentifier parseFrom(CodedInputStream input) throws IOException {
            return (AbilityIdentifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityIdentifier parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityIdentifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityIdentifier prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityIdentifierOuterClass$AbilityIdentifier$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityIdentifierOrBuilder {
            private int modifierOwnerId_;
            private int abilityCasterId_;
            private int instancedAbilityId_;
            private boolean isServerbuffModifier_;
            private int localId_;
            private int instancedModifierId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityIdentifierOuterClass.internal_static_AbilityIdentifier_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityIdentifierOuterClass.internal_static_AbilityIdentifier_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityIdentifier.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityIdentifier.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.modifierOwnerId_ = 0;
                this.abilityCasterId_ = 0;
                this.instancedAbilityId_ = 0;
                this.isServerbuffModifier_ = false;
                this.localId_ = 0;
                this.instancedModifierId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityIdentifierOuterClass.internal_static_AbilityIdentifier_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityIdentifier getDefaultInstanceForType() {
                return AbilityIdentifier.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityIdentifier build() {
                AbilityIdentifier result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityIdentifier buildPartial() {
                AbilityIdentifier result = new AbilityIdentifier(this);
                result.modifierOwnerId_ = this.modifierOwnerId_;
                result.abilityCasterId_ = this.abilityCasterId_;
                result.instancedAbilityId_ = this.instancedAbilityId_;
                result.isServerbuffModifier_ = this.isServerbuffModifier_;
                result.localId_ = this.localId_;
                result.instancedModifierId_ = this.instancedModifierId_;
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
                if (other instanceof AbilityIdentifier) {
                    return mergeFrom((AbilityIdentifier) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityIdentifier other) {
                if (other == AbilityIdentifier.getDefaultInstance()) {
                    return this;
                }
                if (other.getModifierOwnerId() != 0) {
                    setModifierOwnerId(other.getModifierOwnerId());
                }
                if (other.getAbilityCasterId() != 0) {
                    setAbilityCasterId(other.getAbilityCasterId());
                }
                if (other.getInstancedAbilityId() != 0) {
                    setInstancedAbilityId(other.getInstancedAbilityId());
                }
                if (other.getIsServerbuffModifier()) {
                    setIsServerbuffModifier(other.getIsServerbuffModifier());
                }
                if (other.getLocalId() != 0) {
                    setLocalId(other.getLocalId());
                }
                if (other.getInstancedModifierId() != 0) {
                    setInstancedModifierId(other.getInstancedModifierId());
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
                AbilityIdentifier parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityIdentifier.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityIdentifier) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
            public int getModifierOwnerId() {
                return this.modifierOwnerId_;
            }

            public Builder setModifierOwnerId(int value) {
                this.modifierOwnerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModifierOwnerId() {
                this.modifierOwnerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
            public int getAbilityCasterId() {
                return this.abilityCasterId_;
            }

            public Builder setAbilityCasterId(int value) {
                this.abilityCasterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityCasterId() {
                this.abilityCasterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
            public int getInstancedAbilityId() {
                return this.instancedAbilityId_;
            }

            public Builder setInstancedAbilityId(int value) {
                this.instancedAbilityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInstancedAbilityId() {
                this.instancedAbilityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            public Builder setLocalId(int value) {
                this.localId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AbilityIdentifier getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityIdentifier> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityIdentifier> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityIdentifier getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
