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
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cAbilityInvokeEntryHead.proto\"È\u0001\n\u0016AbilityInvokeEntryHead\u0012\u000f\n\u0007localId\u0018\u0007 \u0001(\u0005\u0012\u0015\n\rserverBuffUid\u0018\u000f \u0001(\r\u0012\u0010\n\btargetId\u0018\u0005 \u0001(\r\u0012\u001a\n\u0012instancedAbilityId\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013instancedModifierId\u0018\t \u0001(\r\u0012\u001c\n\u0014isServerbuffModifier\u0018\n \u0001(\b\u0012\u001d\n\u0015modifierConfigLocalId\u0018\b \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityInvokeEntryHead_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityInvokeEntryHead_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityInvokeEntryHead_descriptor, new String[]{"LocalId", "ServerBuffUid", "TargetId", "InstancedAbilityId", "InstancedModifierId", "IsServerbuffModifier", "ModifierConfigLocalId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryHeadOuterClass$AbilityInvokeEntryHeadOrBuilder.class */
    public interface AbilityInvokeEntryHeadOrBuilder extends MessageOrBuilder {
        int getLocalId();

        int getServerBuffUid();

        int getTargetId();

        int getInstancedAbilityId();

        int getInstancedModifierId();

        boolean getIsServerbuffModifier();

        int getModifierConfigLocalId();
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
        public static final int LOCALID_FIELD_NUMBER = 7;
        private int localId_;
        public static final int SERVERBUFFUID_FIELD_NUMBER = 15;
        private int serverBuffUid_;
        public static final int TARGETID_FIELD_NUMBER = 5;
        private int targetId_;
        public static final int INSTANCEDABILITYID_FIELD_NUMBER = 2;
        private int instancedAbilityId_;
        public static final int INSTANCEDMODIFIERID_FIELD_NUMBER = 9;
        private int instancedModifierId_;
        public static final int ISSERVERBUFFMODIFIER_FIELD_NUMBER = 10;
        private boolean isServerbuffModifier_;
        public static final int MODIFIERCONFIGLOCALID_FIELD_NUMBER = 8;
        private int modifierConfigLocalId_;
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
                            case 16:
                                this.instancedAbilityId_ = input.readUInt32();
                                break;
                            case 40:
                                this.targetId_ = input.readUInt32();
                                break;
                            case 56:
                                this.localId_ = input.readInt32();
                                break;
                            case 64:
                                this.modifierConfigLocalId_ = input.readInt32();
                                break;
                            case 72:
                                this.instancedModifierId_ = input.readUInt32();
                                break;
                            case 80:
                                this.isServerbuffModifier_ = input.readBool();
                                break;
                            case 120:
                                this.serverBuffUid_ = input.readUInt32();
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
        public int getLocalId() {
            return this.localId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getServerBuffUid() {
            return this.serverBuffUid_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getTargetId() {
            return this.targetId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getInstancedAbilityId() {
            return this.instancedAbilityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getInstancedModifierId() {
            return this.instancedModifierId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public boolean getIsServerbuffModifier() {
            return this.isServerbuffModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder
        public int getModifierConfigLocalId() {
            return this.modifierConfigLocalId_;
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
            if (this.instancedAbilityId_ != 0) {
                output.writeUInt32(2, this.instancedAbilityId_);
            }
            if (this.targetId_ != 0) {
                output.writeUInt32(5, this.targetId_);
            }
            if (this.localId_ != 0) {
                output.writeInt32(7, this.localId_);
            }
            if (this.modifierConfigLocalId_ != 0) {
                output.writeInt32(8, this.modifierConfigLocalId_);
            }
            if (this.instancedModifierId_ != 0) {
                output.writeUInt32(9, this.instancedModifierId_);
            }
            if (this.isServerbuffModifier_) {
                output.writeBool(10, this.isServerbuffModifier_);
            }
            if (this.serverBuffUid_ != 0) {
                output.writeUInt32(15, this.serverBuffUid_);
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
            if (this.instancedAbilityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.instancedAbilityId_);
            }
            if (this.targetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.targetId_);
            }
            if (this.localId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.localId_);
            }
            if (this.modifierConfigLocalId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.modifierConfigLocalId_);
            }
            if (this.instancedModifierId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.instancedModifierId_);
            }
            if (this.isServerbuffModifier_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isServerbuffModifier_);
            }
            if (this.serverBuffUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.serverBuffUid_);
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
            return getLocalId() == other.getLocalId() && getServerBuffUid() == other.getServerBuffUid() && getTargetId() == other.getTargetId() && getInstancedAbilityId() == other.getInstancedAbilityId() && getInstancedModifierId() == other.getInstancedModifierId() && getIsServerbuffModifier() == other.getIsServerbuffModifier() && getModifierConfigLocalId() == other.getModifierConfigLocalId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getLocalId())) + 15)) + getServerBuffUid())) + 5)) + getTargetId())) + 2)) + getInstancedAbilityId())) + 9)) + getInstancedModifierId())) + 10)) + Internal.hashBoolean(getIsServerbuffModifier()))) + 8)) + getModifierConfigLocalId())) + this.unknownFields.hashCode();
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
            private int localId_;
            private int serverBuffUid_;
            private int targetId_;
            private int instancedAbilityId_;
            private int instancedModifierId_;
            private boolean isServerbuffModifier_;
            private int modifierConfigLocalId_;

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
                this.localId_ = 0;
                this.serverBuffUid_ = 0;
                this.targetId_ = 0;
                this.instancedAbilityId_ = 0;
                this.instancedModifierId_ = 0;
                this.isServerbuffModifier_ = false;
                this.modifierConfigLocalId_ = 0;
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
                result.localId_ = this.localId_;
                result.serverBuffUid_ = this.serverBuffUid_;
                result.targetId_ = this.targetId_;
                result.instancedAbilityId_ = this.instancedAbilityId_;
                result.instancedModifierId_ = this.instancedModifierId_;
                result.isServerbuffModifier_ = this.isServerbuffModifier_;
                result.modifierConfigLocalId_ = this.modifierConfigLocalId_;
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
                if (other.getLocalId() != 0) {
                    setLocalId(other.getLocalId());
                }
                if (other.getServerBuffUid() != 0) {
                    setServerBuffUid(other.getServerBuffUid());
                }
                if (other.getTargetId() != 0) {
                    setTargetId(other.getTargetId());
                }
                if (other.getInstancedAbilityId() != 0) {
                    setInstancedAbilityId(other.getInstancedAbilityId());
                }
                if (other.getInstancedModifierId() != 0) {
                    setInstancedModifierId(other.getInstancedModifierId());
                }
                if (other.getIsServerbuffModifier()) {
                    setIsServerbuffModifier(other.getIsServerbuffModifier());
                }
                if (other.getModifierConfigLocalId() != 0) {
                    setModifierConfigLocalId(other.getModifierConfigLocalId());
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
