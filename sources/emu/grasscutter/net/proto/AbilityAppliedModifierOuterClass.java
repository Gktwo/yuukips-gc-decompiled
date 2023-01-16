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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass;
import emu.grasscutter.net.proto.AbilityStringOuterClass;
import emu.grasscutter.net.proto.ModifierDurabilityOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedModifierOuterClass.class */
public final class AbilityAppliedModifierOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cAbilityAppliedModifier.proto\u001a\u001dAbilityAttachedModifier.proto\u001a\u0013AbilityString.proto\u001a\u0018ModifierDurability.proto\"é\u0003\n\u0016AbilityAppliedModifier\u0012\u0019\n\u0011modifier_local_id\u0018\u0001 \u0001(\u0005\u0012 \n\u0018parent_ability_entity_id\u0018\u0002 \u0001(\r\u0012+\n\u0013parent_ability_name\u0018\u0003 \u0001(\u000b2\u000e.AbilityString\u0012/\n\u0017parent_ability_override\u0018\u0004 \u0001(\u000b2\u000e.AbilityString\u0012\u001c\n\u0014instanced_ability_id\u0018\u0005 \u0001(\r\u0012\u001d\n\u0015instanced_modifier_id\u0018\u0006 \u0001(\r\u0012\u0016\n\u000eexist_duration\u0018\u0007 \u0001(\u0002\u0012=\n\u001battached_instanced_modifier\u0018\b \u0001(\u000b2\u0018.AbilityAttachedModifier\u0012\u0017\n\u000fapply_entity_id\u0018\t \u0001(\r\u0012\"\n\u001ais_attached_parent_ability\u0018\n \u0001(\b\u00120\n\u0013modifier_durability\u0018\u000b \u0001(\u000b2\u0013.ModifierDurability\u0012\u0011\n\tsbuff_uid\u0018\f \u0001(\r\u0012\u001e\n\u0016is_serverbuff_modifier\u0018\r \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityAttachedModifierOuterClass.getDescriptor(), AbilityStringOuterClass.getDescriptor(), ModifierDurabilityOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityAppliedModifier_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityAppliedModifier_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityAppliedModifier_descriptor, new String[]{"ModifierLocalId", "ParentAbilityEntityId", "ParentAbilityName", "ParentAbilityOverride", "InstancedAbilityId", "InstancedModifierId", "ExistDuration", "AttachedInstancedModifier", "ApplyEntityId", "IsAttachedParentAbility", "ModifierDurability", "SbuffUid", "IsServerbuffModifier"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedModifierOuterClass$AbilityAppliedModifierOrBuilder.class */
    public interface AbilityAppliedModifierOrBuilder extends MessageOrBuilder {
        int getModifierLocalId();

        int getParentAbilityEntityId();

        boolean hasParentAbilityName();

        AbilityStringOuterClass.AbilityString getParentAbilityName();

        AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityNameOrBuilder();

        boolean hasParentAbilityOverride();

        AbilityStringOuterClass.AbilityString getParentAbilityOverride();

        AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityOverrideOrBuilder();

        int getInstancedAbilityId();

        int getInstancedModifierId();

        float getExistDuration();

        boolean hasAttachedInstancedModifier();

        AbilityAttachedModifierOuterClass.AbilityAttachedModifier getAttachedInstancedModifier();

        AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder getAttachedInstancedModifierOrBuilder();

        int getApplyEntityId();

        boolean getIsAttachedParentAbility();

        boolean hasModifierDurability();

        ModifierDurabilityOuterClass.ModifierDurability getModifierDurability();

        ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder getModifierDurabilityOrBuilder();

        int getSbuffUid();

        boolean getIsServerbuffModifier();
    }

    private AbilityAppliedModifierOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedModifierOuterClass$AbilityAppliedModifier.class */
    public static final class AbilityAppliedModifier extends GeneratedMessageV3 implements AbilityAppliedModifierOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MODIFIER_LOCAL_ID_FIELD_NUMBER = 1;
        private int modifierLocalId_;
        public static final int PARENT_ABILITY_ENTITY_ID_FIELD_NUMBER = 2;
        private int parentAbilityEntityId_;
        public static final int PARENT_ABILITY_NAME_FIELD_NUMBER = 3;
        private AbilityStringOuterClass.AbilityString parentAbilityName_;
        public static final int PARENT_ABILITY_OVERRIDE_FIELD_NUMBER = 4;
        private AbilityStringOuterClass.AbilityString parentAbilityOverride_;
        public static final int INSTANCED_ABILITY_ID_FIELD_NUMBER = 5;
        private int instancedAbilityId_;
        public static final int INSTANCED_MODIFIER_ID_FIELD_NUMBER = 6;
        private int instancedModifierId_;
        public static final int EXIST_DURATION_FIELD_NUMBER = 7;
        private float existDuration_;
        public static final int ATTACHED_INSTANCED_MODIFIER_FIELD_NUMBER = 8;
        private AbilityAttachedModifierOuterClass.AbilityAttachedModifier attachedInstancedModifier_;
        public static final int APPLY_ENTITY_ID_FIELD_NUMBER = 9;
        private int applyEntityId_;
        public static final int IS_ATTACHED_PARENT_ABILITY_FIELD_NUMBER = 10;
        private boolean isAttachedParentAbility_;
        public static final int MODIFIER_DURABILITY_FIELD_NUMBER = 11;
        private ModifierDurabilityOuterClass.ModifierDurability modifierDurability_;
        public static final int SBUFF_UID_FIELD_NUMBER = 12;
        private int sbuffUid_;
        public static final int IS_SERVERBUFF_MODIFIER_FIELD_NUMBER = 13;
        private boolean isServerbuffModifier_;
        private byte memoizedIsInitialized;
        private static final AbilityAppliedModifier DEFAULT_INSTANCE = new AbilityAppliedModifier();
        private static final Parser<AbilityAppliedModifier> PARSER = new AbstractParser<AbilityAppliedModifier>() { // from class: emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifier.1
            @Override // com.google.protobuf.Parser
            public AbilityAppliedModifier parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityAppliedModifier(input, extensionRegistry);
            }
        };

        private AbilityAppliedModifier(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityAppliedModifier() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityAppliedModifier();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityAppliedModifier(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.modifierLocalId_ = input.readInt32();
                                break;
                            case 16:
                                this.parentAbilityEntityId_ = input.readUInt32();
                                break;
                            case 26:
                                AbilityStringOuterClass.AbilityString.Builder subBuilder = this.parentAbilityName_ != null ? this.parentAbilityName_.toBuilder() : null;
                                this.parentAbilityName_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.parentAbilityName_);
                                    this.parentAbilityName_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 34:
                                AbilityStringOuterClass.AbilityString.Builder subBuilder2 = this.parentAbilityOverride_ != null ? this.parentAbilityOverride_.toBuilder() : null;
                                this.parentAbilityOverride_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.parentAbilityOverride_);
                                    this.parentAbilityOverride_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 40:
                                this.instancedAbilityId_ = input.readUInt32();
                                break;
                            case 48:
                                this.instancedModifierId_ = input.readUInt32();
                                break;
                            case 61:
                                this.existDuration_ = input.readFloat();
                                break;
                            case 66:
                                AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder subBuilder3 = this.attachedInstancedModifier_ != null ? this.attachedInstancedModifier_.toBuilder() : null;
                                this.attachedInstancedModifier_ = (AbilityAttachedModifierOuterClass.AbilityAttachedModifier) input.readMessage(AbilityAttachedModifierOuterClass.AbilityAttachedModifier.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.attachedInstancedModifier_);
                                    this.attachedInstancedModifier_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 72:
                                this.applyEntityId_ = input.readUInt32();
                                break;
                            case 80:
                                this.isAttachedParentAbility_ = input.readBool();
                                break;
                            case 90:
                                ModifierDurabilityOuterClass.ModifierDurability.Builder subBuilder4 = this.modifierDurability_ != null ? this.modifierDurability_.toBuilder() : null;
                                this.modifierDurability_ = (ModifierDurabilityOuterClass.ModifierDurability) input.readMessage(ModifierDurabilityOuterClass.ModifierDurability.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.modifierDurability_);
                                    this.modifierDurability_ = subBuilder4.buildPartial();
                                    break;
                                }
                            case 96:
                                this.sbuffUid_ = input.readUInt32();
                                break;
                            case 104:
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
            return AbilityAppliedModifierOuterClass.internal_static_AbilityAppliedModifier_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityAppliedModifierOuterClass.internal_static_AbilityAppliedModifier_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityAppliedModifier.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public int getModifierLocalId() {
            return this.modifierLocalId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public int getParentAbilityEntityId() {
            return this.parentAbilityEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public boolean hasParentAbilityName() {
            return this.parentAbilityName_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public AbilityStringOuterClass.AbilityString getParentAbilityName() {
            return this.parentAbilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityName_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityNameOrBuilder() {
            return getParentAbilityName();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public boolean hasParentAbilityOverride() {
            return this.parentAbilityOverride_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public AbilityStringOuterClass.AbilityString getParentAbilityOverride() {
            return this.parentAbilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityOverride_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityOverrideOrBuilder() {
            return getParentAbilityOverride();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public int getInstancedAbilityId() {
            return this.instancedAbilityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public int getInstancedModifierId() {
            return this.instancedModifierId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public float getExistDuration() {
            return this.existDuration_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public boolean hasAttachedInstancedModifier() {
            return this.attachedInstancedModifier_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public AbilityAttachedModifierOuterClass.AbilityAttachedModifier getAttachedInstancedModifier() {
            return this.attachedInstancedModifier_ == null ? AbilityAttachedModifierOuterClass.AbilityAttachedModifier.getDefaultInstance() : this.attachedInstancedModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder getAttachedInstancedModifierOrBuilder() {
            return getAttachedInstancedModifier();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public int getApplyEntityId() {
            return this.applyEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public boolean getIsAttachedParentAbility() {
            return this.isAttachedParentAbility_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public boolean hasModifierDurability() {
            return this.modifierDurability_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public ModifierDurabilityOuterClass.ModifierDurability getModifierDurability() {
            return this.modifierDurability_ == null ? ModifierDurabilityOuterClass.ModifierDurability.getDefaultInstance() : this.modifierDurability_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder getModifierDurabilityOrBuilder() {
            return getModifierDurability();
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public int getSbuffUid() {
            return this.sbuffUid_;
        }

        @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
        public boolean getIsServerbuffModifier() {
            return this.isServerbuffModifier_;
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
            if (this.modifierLocalId_ != 0) {
                output.writeInt32(1, this.modifierLocalId_);
            }
            if (this.parentAbilityEntityId_ != 0) {
                output.writeUInt32(2, this.parentAbilityEntityId_);
            }
            if (this.parentAbilityName_ != null) {
                output.writeMessage(3, getParentAbilityName());
            }
            if (this.parentAbilityOverride_ != null) {
                output.writeMessage(4, getParentAbilityOverride());
            }
            if (this.instancedAbilityId_ != 0) {
                output.writeUInt32(5, this.instancedAbilityId_);
            }
            if (this.instancedModifierId_ != 0) {
                output.writeUInt32(6, this.instancedModifierId_);
            }
            if (this.existDuration_ != 0.0f) {
                output.writeFloat(7, this.existDuration_);
            }
            if (this.attachedInstancedModifier_ != null) {
                output.writeMessage(8, getAttachedInstancedModifier());
            }
            if (this.applyEntityId_ != 0) {
                output.writeUInt32(9, this.applyEntityId_);
            }
            if (this.isAttachedParentAbility_) {
                output.writeBool(10, this.isAttachedParentAbility_);
            }
            if (this.modifierDurability_ != null) {
                output.writeMessage(11, getModifierDurability());
            }
            if (this.sbuffUid_ != 0) {
                output.writeUInt32(12, this.sbuffUid_);
            }
            if (this.isServerbuffModifier_) {
                output.writeBool(13, this.isServerbuffModifier_);
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
            if (this.modifierLocalId_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.modifierLocalId_);
            }
            if (this.parentAbilityEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.parentAbilityEntityId_);
            }
            if (this.parentAbilityName_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getParentAbilityName());
            }
            if (this.parentAbilityOverride_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getParentAbilityOverride());
            }
            if (this.instancedAbilityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.instancedAbilityId_);
            }
            if (this.instancedModifierId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.instancedModifierId_);
            }
            if (this.existDuration_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(7, this.existDuration_);
            }
            if (this.attachedInstancedModifier_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getAttachedInstancedModifier());
            }
            if (this.applyEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.applyEntityId_);
            }
            if (this.isAttachedParentAbility_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.isAttachedParentAbility_);
            }
            if (this.modifierDurability_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getModifierDurability());
            }
            if (this.sbuffUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.sbuffUid_);
            }
            if (this.isServerbuffModifier_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isServerbuffModifier_);
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
            if (!(obj instanceof AbilityAppliedModifier)) {
                return equals(obj);
            }
            AbilityAppliedModifier other = (AbilityAppliedModifier) obj;
            if (getModifierLocalId() != other.getModifierLocalId() || getParentAbilityEntityId() != other.getParentAbilityEntityId() || hasParentAbilityName() != other.hasParentAbilityName()) {
                return false;
            }
            if ((hasParentAbilityName() && !getParentAbilityName().equals(other.getParentAbilityName())) || hasParentAbilityOverride() != other.hasParentAbilityOverride()) {
                return false;
            }
            if ((hasParentAbilityOverride() && !getParentAbilityOverride().equals(other.getParentAbilityOverride())) || getInstancedAbilityId() != other.getInstancedAbilityId() || getInstancedModifierId() != other.getInstancedModifierId() || Float.floatToIntBits(getExistDuration()) != Float.floatToIntBits(other.getExistDuration()) || hasAttachedInstancedModifier() != other.hasAttachedInstancedModifier()) {
                return false;
            }
            if ((!hasAttachedInstancedModifier() || getAttachedInstancedModifier().equals(other.getAttachedInstancedModifier())) && getApplyEntityId() == other.getApplyEntityId() && getIsAttachedParentAbility() == other.getIsAttachedParentAbility() && hasModifierDurability() == other.hasModifierDurability()) {
                return (!hasModifierDurability() || getModifierDurability().equals(other.getModifierDurability())) && getSbuffUid() == other.getSbuffUid() && getIsServerbuffModifier() == other.getIsServerbuffModifier() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getModifierLocalId())) + 2)) + getParentAbilityEntityId();
            if (hasParentAbilityName()) {
                hash = (53 * ((37 * hash) + 3)) + getParentAbilityName().hashCode();
            }
            if (hasParentAbilityOverride()) {
                hash = (53 * ((37 * hash) + 4)) + getParentAbilityOverride().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getInstancedAbilityId())) + 6)) + getInstancedModifierId())) + 7)) + Float.floatToIntBits(getExistDuration());
            if (hasAttachedInstancedModifier()) {
                hash2 = (53 * ((37 * hash2) + 8)) + getAttachedInstancedModifier().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 9)) + getApplyEntityId())) + 10)) + Internal.hashBoolean(getIsAttachedParentAbility());
            if (hasModifierDurability()) {
                hash3 = (53 * ((37 * hash3) + 11)) + getModifierDurability().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * hash3) + 12)) + getSbuffUid())) + 13)) + Internal.hashBoolean(getIsServerbuffModifier()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static AbilityAppliedModifier parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAppliedModifier parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAppliedModifier parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAppliedModifier parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAppliedModifier parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityAppliedModifier parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityAppliedModifier parseFrom(InputStream input) throws IOException {
            return (AbilityAppliedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityAppliedModifier parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAppliedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityAppliedModifier parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityAppliedModifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityAppliedModifier parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAppliedModifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityAppliedModifier parseFrom(CodedInputStream input) throws IOException {
            return (AbilityAppliedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityAppliedModifier parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityAppliedModifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityAppliedModifier prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityAppliedModifierOuterClass$AbilityAppliedModifier$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityAppliedModifierOrBuilder {
            private int modifierLocalId_;
            private int parentAbilityEntityId_;
            private AbilityStringOuterClass.AbilityString parentAbilityName_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> parentAbilityNameBuilder_;
            private AbilityStringOuterClass.AbilityString parentAbilityOverride_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> parentAbilityOverrideBuilder_;
            private int instancedAbilityId_;
            private int instancedModifierId_;
            private float existDuration_;
            private AbilityAttachedModifierOuterClass.AbilityAttachedModifier attachedInstancedModifier_;
            private SingleFieldBuilderV3<AbilityAttachedModifierOuterClass.AbilityAttachedModifier, AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder, AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder> attachedInstancedModifierBuilder_;
            private int applyEntityId_;
            private boolean isAttachedParentAbility_;
            private ModifierDurabilityOuterClass.ModifierDurability modifierDurability_;
            private SingleFieldBuilderV3<ModifierDurabilityOuterClass.ModifierDurability, ModifierDurabilityOuterClass.ModifierDurability.Builder, ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder> modifierDurabilityBuilder_;
            private int sbuffUid_;
            private boolean isServerbuffModifier_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityAppliedModifierOuterClass.internal_static_AbilityAppliedModifier_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityAppliedModifierOuterClass.internal_static_AbilityAppliedModifier_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityAppliedModifier.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityAppliedModifier.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.modifierLocalId_ = 0;
                this.parentAbilityEntityId_ = 0;
                if (this.parentAbilityNameBuilder_ == null) {
                    this.parentAbilityName_ = null;
                } else {
                    this.parentAbilityName_ = null;
                    this.parentAbilityNameBuilder_ = null;
                }
                if (this.parentAbilityOverrideBuilder_ == null) {
                    this.parentAbilityOverride_ = null;
                } else {
                    this.parentAbilityOverride_ = null;
                    this.parentAbilityOverrideBuilder_ = null;
                }
                this.instancedAbilityId_ = 0;
                this.instancedModifierId_ = 0;
                this.existDuration_ = 0.0f;
                if (this.attachedInstancedModifierBuilder_ == null) {
                    this.attachedInstancedModifier_ = null;
                } else {
                    this.attachedInstancedModifier_ = null;
                    this.attachedInstancedModifierBuilder_ = null;
                }
                this.applyEntityId_ = 0;
                this.isAttachedParentAbility_ = false;
                if (this.modifierDurabilityBuilder_ == null) {
                    this.modifierDurability_ = null;
                } else {
                    this.modifierDurability_ = null;
                    this.modifierDurabilityBuilder_ = null;
                }
                this.sbuffUid_ = 0;
                this.isServerbuffModifier_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityAppliedModifierOuterClass.internal_static_AbilityAppliedModifier_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityAppliedModifier getDefaultInstanceForType() {
                return AbilityAppliedModifier.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityAppliedModifier build() {
                AbilityAppliedModifier result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityAppliedModifier buildPartial() {
                AbilityAppliedModifier result = new AbilityAppliedModifier(this);
                result.modifierLocalId_ = this.modifierLocalId_;
                result.parentAbilityEntityId_ = this.parentAbilityEntityId_;
                if (this.parentAbilityNameBuilder_ == null) {
                    result.parentAbilityName_ = this.parentAbilityName_;
                } else {
                    result.parentAbilityName_ = this.parentAbilityNameBuilder_.build();
                }
                if (this.parentAbilityOverrideBuilder_ == null) {
                    result.parentAbilityOverride_ = this.parentAbilityOverride_;
                } else {
                    result.parentAbilityOverride_ = this.parentAbilityOverrideBuilder_.build();
                }
                result.instancedAbilityId_ = this.instancedAbilityId_;
                result.instancedModifierId_ = this.instancedModifierId_;
                result.existDuration_ = this.existDuration_;
                if (this.attachedInstancedModifierBuilder_ == null) {
                    result.attachedInstancedModifier_ = this.attachedInstancedModifier_;
                } else {
                    result.attachedInstancedModifier_ = this.attachedInstancedModifierBuilder_.build();
                }
                result.applyEntityId_ = this.applyEntityId_;
                result.isAttachedParentAbility_ = this.isAttachedParentAbility_;
                if (this.modifierDurabilityBuilder_ == null) {
                    result.modifierDurability_ = this.modifierDurability_;
                } else {
                    result.modifierDurability_ = this.modifierDurabilityBuilder_.build();
                }
                result.sbuffUid_ = this.sbuffUid_;
                result.isServerbuffModifier_ = this.isServerbuffModifier_;
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
                if (other instanceof AbilityAppliedModifier) {
                    return mergeFrom((AbilityAppliedModifier) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityAppliedModifier other) {
                if (other == AbilityAppliedModifier.getDefaultInstance()) {
                    return this;
                }
                if (other.getModifierLocalId() != 0) {
                    setModifierLocalId(other.getModifierLocalId());
                }
                if (other.getParentAbilityEntityId() != 0) {
                    setParentAbilityEntityId(other.getParentAbilityEntityId());
                }
                if (other.hasParentAbilityName()) {
                    mergeParentAbilityName(other.getParentAbilityName());
                }
                if (other.hasParentAbilityOverride()) {
                    mergeParentAbilityOverride(other.getParentAbilityOverride());
                }
                if (other.getInstancedAbilityId() != 0) {
                    setInstancedAbilityId(other.getInstancedAbilityId());
                }
                if (other.getInstancedModifierId() != 0) {
                    setInstancedModifierId(other.getInstancedModifierId());
                }
                if (other.getExistDuration() != 0.0f) {
                    setExistDuration(other.getExistDuration());
                }
                if (other.hasAttachedInstancedModifier()) {
                    mergeAttachedInstancedModifier(other.getAttachedInstancedModifier());
                }
                if (other.getApplyEntityId() != 0) {
                    setApplyEntityId(other.getApplyEntityId());
                }
                if (other.getIsAttachedParentAbility()) {
                    setIsAttachedParentAbility(other.getIsAttachedParentAbility());
                }
                if (other.hasModifierDurability()) {
                    mergeModifierDurability(other.getModifierDurability());
                }
                if (other.getSbuffUid() != 0) {
                    setSbuffUid(other.getSbuffUid());
                }
                if (other.getIsServerbuffModifier()) {
                    setIsServerbuffModifier(other.getIsServerbuffModifier());
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
                AbilityAppliedModifier parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityAppliedModifier.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityAppliedModifier) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public int getModifierLocalId() {
                return this.modifierLocalId_;
            }

            public Builder setModifierLocalId(int value) {
                this.modifierLocalId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModifierLocalId() {
                this.modifierLocalId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public int getParentAbilityEntityId() {
                return this.parentAbilityEntityId_;
            }

            public Builder setParentAbilityEntityId(int value) {
                this.parentAbilityEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearParentAbilityEntityId() {
                this.parentAbilityEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public boolean hasParentAbilityName() {
                return (this.parentAbilityNameBuilder_ == null && this.parentAbilityName_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public AbilityStringOuterClass.AbilityString getParentAbilityName() {
                if (this.parentAbilityNameBuilder_ == null) {
                    return this.parentAbilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityName_;
                }
                return this.parentAbilityNameBuilder_.getMessage();
            }

            public Builder setParentAbilityName(AbilityStringOuterClass.AbilityString value) {
                if (this.parentAbilityNameBuilder_ != null) {
                    this.parentAbilityNameBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.parentAbilityName_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setParentAbilityName(AbilityStringOuterClass.AbilityString.Builder builderForValue) {
                if (this.parentAbilityNameBuilder_ == null) {
                    this.parentAbilityName_ = builderForValue.build();
                    onChanged();
                } else {
                    this.parentAbilityNameBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeParentAbilityName(AbilityStringOuterClass.AbilityString value) {
                if (this.parentAbilityNameBuilder_ == null) {
                    if (this.parentAbilityName_ != null) {
                        this.parentAbilityName_ = AbilityStringOuterClass.AbilityString.newBuilder(this.parentAbilityName_).mergeFrom(value).buildPartial();
                    } else {
                        this.parentAbilityName_ = value;
                    }
                    onChanged();
                } else {
                    this.parentAbilityNameBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearParentAbilityName() {
                if (this.parentAbilityNameBuilder_ == null) {
                    this.parentAbilityName_ = null;
                    onChanged();
                } else {
                    this.parentAbilityName_ = null;
                    this.parentAbilityNameBuilder_ = null;
                }
                return this;
            }

            public AbilityStringOuterClass.AbilityString.Builder getParentAbilityNameBuilder() {
                onChanged();
                return getParentAbilityNameFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityNameOrBuilder() {
                if (this.parentAbilityNameBuilder_ != null) {
                    return this.parentAbilityNameBuilder_.getMessageOrBuilder();
                }
                return this.parentAbilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityName_;
            }

            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> getParentAbilityNameFieldBuilder() {
                if (this.parentAbilityNameBuilder_ == null) {
                    this.parentAbilityNameBuilder_ = new SingleFieldBuilderV3<>(getParentAbilityName(), getParentForChildren(), isClean());
                    this.parentAbilityName_ = null;
                }
                return this.parentAbilityNameBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public boolean hasParentAbilityOverride() {
                return (this.parentAbilityOverrideBuilder_ == null && this.parentAbilityOverride_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public AbilityStringOuterClass.AbilityString getParentAbilityOverride() {
                if (this.parentAbilityOverrideBuilder_ == null) {
                    return this.parentAbilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityOverride_;
                }
                return this.parentAbilityOverrideBuilder_.getMessage();
            }

            public Builder setParentAbilityOverride(AbilityStringOuterClass.AbilityString value) {
                if (this.parentAbilityOverrideBuilder_ != null) {
                    this.parentAbilityOverrideBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.parentAbilityOverride_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setParentAbilityOverride(AbilityStringOuterClass.AbilityString.Builder builderForValue) {
                if (this.parentAbilityOverrideBuilder_ == null) {
                    this.parentAbilityOverride_ = builderForValue.build();
                    onChanged();
                } else {
                    this.parentAbilityOverrideBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeParentAbilityOverride(AbilityStringOuterClass.AbilityString value) {
                if (this.parentAbilityOverrideBuilder_ == null) {
                    if (this.parentAbilityOverride_ != null) {
                        this.parentAbilityOverride_ = AbilityStringOuterClass.AbilityString.newBuilder(this.parentAbilityOverride_).mergeFrom(value).buildPartial();
                    } else {
                        this.parentAbilityOverride_ = value;
                    }
                    onChanged();
                } else {
                    this.parentAbilityOverrideBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearParentAbilityOverride() {
                if (this.parentAbilityOverrideBuilder_ == null) {
                    this.parentAbilityOverride_ = null;
                    onChanged();
                } else {
                    this.parentAbilityOverride_ = null;
                    this.parentAbilityOverrideBuilder_ = null;
                }
                return this;
            }

            public AbilityStringOuterClass.AbilityString.Builder getParentAbilityOverrideBuilder() {
                onChanged();
                return getParentAbilityOverrideFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityOverrideOrBuilder() {
                if (this.parentAbilityOverrideBuilder_ != null) {
                    return this.parentAbilityOverrideBuilder_.getMessageOrBuilder();
                }
                return this.parentAbilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityOverride_;
            }

            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> getParentAbilityOverrideFieldBuilder() {
                if (this.parentAbilityOverrideBuilder_ == null) {
                    this.parentAbilityOverrideBuilder_ = new SingleFieldBuilderV3<>(getParentAbilityOverride(), getParentForChildren(), isClean());
                    this.parentAbilityOverride_ = null;
                }
                return this.parentAbilityOverrideBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public float getExistDuration() {
                return this.existDuration_;
            }

            public Builder setExistDuration(float value) {
                this.existDuration_ = value;
                onChanged();
                return this;
            }

            public Builder clearExistDuration() {
                this.existDuration_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public boolean hasAttachedInstancedModifier() {
                return (this.attachedInstancedModifierBuilder_ == null && this.attachedInstancedModifier_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public AbilityAttachedModifierOuterClass.AbilityAttachedModifier getAttachedInstancedModifier() {
                if (this.attachedInstancedModifierBuilder_ == null) {
                    return this.attachedInstancedModifier_ == null ? AbilityAttachedModifierOuterClass.AbilityAttachedModifier.getDefaultInstance() : this.attachedInstancedModifier_;
                }
                return this.attachedInstancedModifierBuilder_.getMessage();
            }

            public Builder setAttachedInstancedModifier(AbilityAttachedModifierOuterClass.AbilityAttachedModifier value) {
                if (this.attachedInstancedModifierBuilder_ != null) {
                    this.attachedInstancedModifierBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.attachedInstancedModifier_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAttachedInstancedModifier(AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder builderForValue) {
                if (this.attachedInstancedModifierBuilder_ == null) {
                    this.attachedInstancedModifier_ = builderForValue.build();
                    onChanged();
                } else {
                    this.attachedInstancedModifierBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAttachedInstancedModifier(AbilityAttachedModifierOuterClass.AbilityAttachedModifier value) {
                if (this.attachedInstancedModifierBuilder_ == null) {
                    if (this.attachedInstancedModifier_ != null) {
                        this.attachedInstancedModifier_ = AbilityAttachedModifierOuterClass.AbilityAttachedModifier.newBuilder(this.attachedInstancedModifier_).mergeFrom(value).buildPartial();
                    } else {
                        this.attachedInstancedModifier_ = value;
                    }
                    onChanged();
                } else {
                    this.attachedInstancedModifierBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAttachedInstancedModifier() {
                if (this.attachedInstancedModifierBuilder_ == null) {
                    this.attachedInstancedModifier_ = null;
                    onChanged();
                } else {
                    this.attachedInstancedModifier_ = null;
                    this.attachedInstancedModifierBuilder_ = null;
                }
                return this;
            }

            public AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder getAttachedInstancedModifierBuilder() {
                onChanged();
                return getAttachedInstancedModifierFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder getAttachedInstancedModifierOrBuilder() {
                if (this.attachedInstancedModifierBuilder_ != null) {
                    return this.attachedInstancedModifierBuilder_.getMessageOrBuilder();
                }
                return this.attachedInstancedModifier_ == null ? AbilityAttachedModifierOuterClass.AbilityAttachedModifier.getDefaultInstance() : this.attachedInstancedModifier_;
            }

            private SingleFieldBuilderV3<AbilityAttachedModifierOuterClass.AbilityAttachedModifier, AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder, AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder> getAttachedInstancedModifierFieldBuilder() {
                if (this.attachedInstancedModifierBuilder_ == null) {
                    this.attachedInstancedModifierBuilder_ = new SingleFieldBuilderV3<>(getAttachedInstancedModifier(), getParentForChildren(), isClean());
                    this.attachedInstancedModifier_ = null;
                }
                return this.attachedInstancedModifierBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public int getApplyEntityId() {
                return this.applyEntityId_;
            }

            public Builder setApplyEntityId(int value) {
                this.applyEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearApplyEntityId() {
                this.applyEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public boolean getIsAttachedParentAbility() {
                return this.isAttachedParentAbility_;
            }

            public Builder setIsAttachedParentAbility(boolean value) {
                this.isAttachedParentAbility_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAttachedParentAbility() {
                this.isAttachedParentAbility_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public boolean hasModifierDurability() {
                return (this.modifierDurabilityBuilder_ == null && this.modifierDurability_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public ModifierDurabilityOuterClass.ModifierDurability getModifierDurability() {
                if (this.modifierDurabilityBuilder_ == null) {
                    return this.modifierDurability_ == null ? ModifierDurabilityOuterClass.ModifierDurability.getDefaultInstance() : this.modifierDurability_;
                }
                return this.modifierDurabilityBuilder_.getMessage();
            }

            public Builder setModifierDurability(ModifierDurabilityOuterClass.ModifierDurability value) {
                if (this.modifierDurabilityBuilder_ != null) {
                    this.modifierDurabilityBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.modifierDurability_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setModifierDurability(ModifierDurabilityOuterClass.ModifierDurability.Builder builderForValue) {
                if (this.modifierDurabilityBuilder_ == null) {
                    this.modifierDurability_ = builderForValue.build();
                    onChanged();
                } else {
                    this.modifierDurabilityBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeModifierDurability(ModifierDurabilityOuterClass.ModifierDurability value) {
                if (this.modifierDurabilityBuilder_ == null) {
                    if (this.modifierDurability_ != null) {
                        this.modifierDurability_ = ModifierDurabilityOuterClass.ModifierDurability.newBuilder(this.modifierDurability_).mergeFrom(value).buildPartial();
                    } else {
                        this.modifierDurability_ = value;
                    }
                    onChanged();
                } else {
                    this.modifierDurabilityBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearModifierDurability() {
                if (this.modifierDurabilityBuilder_ == null) {
                    this.modifierDurability_ = null;
                    onChanged();
                } else {
                    this.modifierDurability_ = null;
                    this.modifierDurabilityBuilder_ = null;
                }
                return this;
            }

            public ModifierDurabilityOuterClass.ModifierDurability.Builder getModifierDurabilityBuilder() {
                onChanged();
                return getModifierDurabilityFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder getModifierDurabilityOrBuilder() {
                if (this.modifierDurabilityBuilder_ != null) {
                    return this.modifierDurabilityBuilder_.getMessageOrBuilder();
                }
                return this.modifierDurability_ == null ? ModifierDurabilityOuterClass.ModifierDurability.getDefaultInstance() : this.modifierDurability_;
            }

            private SingleFieldBuilderV3<ModifierDurabilityOuterClass.ModifierDurability, ModifierDurabilityOuterClass.ModifierDurability.Builder, ModifierDurabilityOuterClass.ModifierDurabilityOrBuilder> getModifierDurabilityFieldBuilder() {
                if (this.modifierDurabilityBuilder_ == null) {
                    this.modifierDurabilityBuilder_ = new SingleFieldBuilderV3<>(getModifierDurability(), getParentForChildren(), isClean());
                    this.modifierDurability_ = null;
                }
                return this.modifierDurabilityBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
            public int getSbuffUid() {
                return this.sbuffUid_;
            }

            public Builder setSbuffUid(int value) {
                this.sbuffUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearSbuffUid() {
                this.sbuffUid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AbilityAppliedModifier getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityAppliedModifier> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityAppliedModifier> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityAppliedModifier getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityAttachedModifierOuterClass.getDescriptor();
        AbilityStringOuterClass.getDescriptor();
        ModifierDurabilityOuterClass.getDescriptor();
    }
}
