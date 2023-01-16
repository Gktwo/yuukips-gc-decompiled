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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryHeadOuterClass.class */
public final class AbilityInvokeEntryHeadOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cAbilityInvokeEntryHead.proto\"Õ\u0001\n\u0016AbilityInvokeEntryHead\u0012\u001c\n\u0014instanced_ability_id\u0018\b \u0001(\r\u0012\u0011\n\ttarget_id\u0018\u0006 \u0001(\r\u0012\u0017\n\u000fserver_buff_uid\u0018\u0001 \u0001(\r\u0012\u0010\n\blocal_id\u0018\f \u0001(\u0005\u0012 \n\u0018modifier_config_local_id\u0018\u0007 \u0001(\u0005\u0012\u001e\n\u0016is_serverbuff_modifier\u0018\u000f \u0001(\b\u0012\u001d\n\u0015instanced_modifier_id\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityInvokeEntryHead_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityInvokeEntryHead_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityInvokeEntryHead_descriptor, new String[]{"InstancedAbilityId", "TargetId", "ServerBuffUid", "LocalId", "ModifierConfigLocalId", "IsServerbuffModifier", "InstancedModifierId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryHeadOuterClass$AbilityInvokeEntryHeadOrBuilder.class */
    public interface AbilityInvokeEntryHeadOrBuilder extends MessageOrBuilder {
        int getInstancedAbilityId();

        int getTargetId();

        int getServerBuffUid();

        int getLocalId();

        int getModifierConfigLocalId();

        boolean getIsServerbuffModifier();

        int getInstancedModifierId();
    }

    private AbilityInvokeEntryHeadOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryHeadOuterClass$AbilityInvokeEntryHead.class */
    public static final class AbilityInvokeEntryHead extends GeneratedMessageV3 implements AbilityInvokeEntryHeadOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INSTANCED_ABILITY_ID_FIELD_NUMBER = 8;
        private int instancedAbilityId_;
        public static final int TARGET_ID_FIELD_NUMBER = 6;
        private int targetId_;
        public static final int SERVER_BUFF_UID_FIELD_NUMBER = 1;
        private int serverBuffUid_;
        public static final int LOCAL_ID_FIELD_NUMBER = 12;
        private int localId_;
        public static final int MODIFIER_CONFIG_LOCAL_ID_FIELD_NUMBER = 7;
        private int modifierConfigLocalId_;
        public static final int IS_SERVERBUFF_MODIFIER_FIELD_NUMBER = 15;
        private boolean isServerbuffModifier_;
        public static final int INSTANCED_MODIFIER_ID_FIELD_NUMBER = 10;
        private int instancedModifierId_;
        private byte memoizedIsInitialized;
        private static final AbilityInvokeEntryHead DEFAULT_INSTANCE = new AbilityInvokeEntryHead();
        private static final Parser<AbilityInvokeEntryHead> PARSER = new AbstractParser<AbilityInvokeEntryHead>() { // from class: emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.1
            @Override // com.google.protobuf.Parser
            public AbilityInvokeEntryHead parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityInvokeEntryHead(input, extensionRegistry);
            }
        };

        private AbilityInvokeEntryHead(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityInvokeEntryHead() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityInvokeEntryHead();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityInvokeEntryHead(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.serverBuffUid_ = input.readUInt32();
                                break;
                            case 48:
                                this.targetId_ = input.readUInt32();
                                break;
                            case 56:
                                this.modifierConfigLocalId_ = input.readInt32();
                                break;
                            case 64:
                                this.instancedAbilityId_ = input.readUInt32();
                                break;
                            case 80:
                                this.instancedModifierId_ = input.readUInt32();
                                break;
                            case 96:
                                this.localId_ = input.readInt32();
                                break;
                            case 120:
                                this.isServerbuffModifier_ = input.readBool();
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
            return AbilityInvokeEntryHeadOuterClass.internal_static_AbilityInvokeEntryHead_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityInvokeEntryHeadOuterClass.internal_static_AbilityInvokeEntryHead_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityInvokeEntryHead.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getInstancedAbilityId() {
            return this.instancedAbilityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getTargetId() {
            return this.targetId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getServerBuffUid() {
            return this.serverBuffUid_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getModifierConfigLocalId() {
            return this.modifierConfigLocalId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public boolean getIsServerbuffModifier() {
            return this.isServerbuffModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
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
            if (this.serverBuffUid_ != 0) {
                output.writeUInt32(1, this.serverBuffUid_);
            }
            if (this.targetId_ != 0) {
                output.writeUInt32(6, this.targetId_);
            }
            if (this.modifierConfigLocalId_ != 0) {
                output.writeInt32(7, this.modifierConfigLocalId_);
            }
            if (this.instancedAbilityId_ != 0) {
                output.writeUInt32(8, this.instancedAbilityId_);
            }
            if (this.instancedModifierId_ != 0) {
                output.writeUInt32(10, this.instancedModifierId_);
            }
            if (this.localId_ != 0) {
                output.writeInt32(12, this.localId_);
            }
            if (this.isServerbuffModifier_) {
                output.writeBool(15, this.isServerbuffModifier_);
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
            if (this.serverBuffUid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.serverBuffUid_);
            }
            if (this.targetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.targetId_);
            }
            if (this.modifierConfigLocalId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.modifierConfigLocalId_);
            }
            if (this.instancedAbilityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.instancedAbilityId_);
            }
            if (this.instancedModifierId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.instancedModifierId_);
            }
            if (this.localId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.localId_);
            }
            if (this.isServerbuffModifier_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isServerbuffModifier_);
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
            if (!(obj instanceof AbilityInvokeEntryHead)) {
                return equals(obj);
            }
            AbilityInvokeEntryHead other = (AbilityInvokeEntryHead) obj;
            return getInstancedAbilityId() == other.getInstancedAbilityId() && getTargetId() == other.getTargetId() && getServerBuffUid() == other.getServerBuffUid() && getLocalId() == other.getLocalId() && getModifierConfigLocalId() == other.getModifierConfigLocalId() && getIsServerbuffModifier() == other.getIsServerbuffModifier() && getInstancedModifierId() == other.getInstancedModifierId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getInstancedAbilityId())) + 6)) + getTargetId())) + 1)) + getServerBuffUid())) + 12)) + getLocalId())) + 7)) + getModifierConfigLocalId())) + 15)) + Internal.hashBoolean(getIsServerbuffModifier()))) + 10)) + getInstancedModifierId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AbilityInvokeEntryHead parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityInvokeEntryHead parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityInvokeEntryHead parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityInvokeEntryHead parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityInvokeEntryHead parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityInvokeEntryHead parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityInvokeEntryHead parseFrom(InputStream input) throws IOException {
            return (AbilityInvokeEntryHead) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityInvokeEntryHead parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityInvokeEntryHead) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityInvokeEntryHead parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityInvokeEntryHead) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityInvokeEntryHead parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityInvokeEntryHead) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityInvokeEntryHead parseFrom(CodedInputStream input) throws IOException {
            return (AbilityInvokeEntryHead) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityInvokeEntryHead parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityInvokeEntryHead) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityInvokeEntryHead prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryHeadOuterClass$AbilityInvokeEntryHead$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityInvokeEntryHeadOrBuilder {
            private int instancedAbilityId_;
            private int targetId_;
            private int serverBuffUid_;
            private int localId_;
            private int modifierConfigLocalId_;
            private boolean isServerbuffModifier_;
            private int instancedModifierId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityInvokeEntryHeadOuterClass.internal_static_AbilityInvokeEntryHead_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityInvokeEntryHeadOuterClass.internal_static_AbilityInvokeEntryHead_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityInvokeEntryHead.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityInvokeEntryHead.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.instancedAbilityId_ = 0;
                this.targetId_ = 0;
                this.serverBuffUid_ = 0;
                this.localId_ = 0;
                this.modifierConfigLocalId_ = 0;
                this.isServerbuffModifier_ = false;
                this.instancedModifierId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityInvokeEntryHeadOuterClass.internal_static_AbilityInvokeEntryHead_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityInvokeEntryHead getDefaultInstanceForType() {
                return AbilityInvokeEntryHead.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityInvokeEntryHead build() {
                AbilityInvokeEntryHead result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityInvokeEntryHead buildPartial() {
                AbilityInvokeEntryHead result = new AbilityInvokeEntryHead(this);
                result.instancedAbilityId_ = this.instancedAbilityId_;
                result.targetId_ = this.targetId_;
                result.serverBuffUid_ = this.serverBuffUid_;
                result.localId_ = this.localId_;
                result.modifierConfigLocalId_ = this.modifierConfigLocalId_;
                result.isServerbuffModifier_ = this.isServerbuffModifier_;
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
                if (other instanceof AbilityInvokeEntryHead) {
                    return mergeFrom((AbilityInvokeEntryHead) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityInvokeEntryHead other) {
                if (other == AbilityInvokeEntryHead.getDefaultInstance()) {
                    return this;
                }
                if (other.getInstancedAbilityId() != 0) {
                    setInstancedAbilityId(other.getInstancedAbilityId());
                }
                if (other.getTargetId() != 0) {
                    setTargetId(other.getTargetId());
                }
                if (other.getServerBuffUid() != 0) {
                    setServerBuffUid(other.getServerBuffUid());
                }
                if (other.getLocalId() != 0) {
                    setLocalId(other.getLocalId());
                }
                if (other.getModifierConfigLocalId() != 0) {
                    setModifierConfigLocalId(other.getModifierConfigLocalId());
                }
                if (other.getIsServerbuffModifier()) {
                    setIsServerbuffModifier(other.getIsServerbuffModifier());
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
                AbilityInvokeEntryHead parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityInvokeEntryHead.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityInvokeEntryHead) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
            public int getTargetId() {
                return this.targetId_;
            }

            public Builder setTargetId(int value) {
                this.targetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetId() {
                this.targetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
            public int getServerBuffUid() {
                return this.serverBuffUid_;
            }

            public Builder setServerBuffUid(int value) {
                this.serverBuffUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerBuffUid() {
                this.serverBuffUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
            public int getModifierConfigLocalId() {
                return this.modifierConfigLocalId_;
            }

            public Builder setModifierConfigLocalId(int value) {
                this.modifierConfigLocalId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModifierConfigLocalId() {
                this.modifierConfigLocalId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
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

        public static AbilityInvokeEntryHead getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityInvokeEntryHead> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityInvokeEntryHead> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityInvokeEntryHead getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
