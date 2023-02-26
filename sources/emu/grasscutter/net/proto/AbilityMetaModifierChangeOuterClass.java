package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityAttachedModifierOuterClass;
import emu.grasscutter.net.proto.AbilityStringOuterClass;
import emu.grasscutter.net.proto.ModifierActionOuterClass;
import emu.grasscutter.net.proto.ModifierPropertyOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaModifierChangeOuterClass.class */
public final class AbilityMetaModifierChangeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fAbilityMetaModifierChange.proto\u001a\u001dAbilityAttachedModifier.proto\u001a\u0013AbilityString.proto\u001a\u0014ModifierAction.proto\u001a\u0016ModifierProperty.proto\"\u0003\n\u0019AbilityMetaModifierChange\u0012\u0015\n\rapplyEntityId\u0018\b \u0001(\r\u0012;\n\u0019attachedInstancedModifier\u0018\u0007 \u0001(\u000b2\u0018.AbilityAttachedModifier\u0012\u001a\n\u0012is_durability_zero\u0018\u0001 \u0001(\b\u0012%\n\nproperties\u0018\r \u0003(\u000b2\u0011.ModifierProperty\u0012)\n\u0011parentAbilityName\u0018\n \u0001(\u000b2\u000e.AbilityString\u0012-\n\u0015parentAbilityOverride\u0018\u0005 \u0001(\u000b2\u000e.AbilityString\u0012\u0016\n\u000eis_mute_remote\u0018\u000b \u0001(\b\u0012\u001f\n\u0017isAttachedParentAbility\u0018\u0003 \u0001(\b\u0012\u0015\n\rserverBuffUid\u0018\t \u0001(\r\u0012\u0017\n\u000fmodifierLocalId\u0018\u0006 \u0001(\u0005\u0012\u001f\n\u0006action\u0018\u0002 \u0001(\u000e2\u000f.ModifierActionB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityAttachedModifierOuterClass.getDescriptor(), AbilityStringOuterClass.getDescriptor(), ModifierActionOuterClass.getDescriptor(), ModifierPropertyOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityMetaModifierChange_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityMetaModifierChange_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityMetaModifierChange_descriptor, new String[]{"ApplyEntityId", "AttachedInstancedModifier", "IsDurabilityZero", "Properties", "ParentAbilityName", "ParentAbilityOverride", "IsMuteRemote", "IsAttachedParentAbility", "ServerBuffUid", "ModifierLocalId", "Action"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaModifierChangeOuterClass$AbilityMetaModifierChangeOrBuilder.class */
    public interface AbilityMetaModifierChangeOrBuilder extends MessageOrBuilder {
        int getApplyEntityId();

        boolean hasAttachedInstancedModifier();

        AbilityAttachedModifierOuterClass.AbilityAttachedModifier getAttachedInstancedModifier();

        AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder getAttachedInstancedModifierOrBuilder();

        boolean getIsDurabilityZero();

        List<ModifierPropertyOuterClass.ModifierProperty> getPropertiesList();

        ModifierPropertyOuterClass.ModifierProperty getProperties(int i);

        int getPropertiesCount();

        List<? extends ModifierPropertyOuterClass.ModifierPropertyOrBuilder> getPropertiesOrBuilderList();

        ModifierPropertyOuterClass.ModifierPropertyOrBuilder getPropertiesOrBuilder(int i);

        boolean hasParentAbilityName();

        AbilityStringOuterClass.AbilityString getParentAbilityName();

        AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityNameOrBuilder();

        boolean hasParentAbilityOverride();

        AbilityStringOuterClass.AbilityString getParentAbilityOverride();

        AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityOverrideOrBuilder();

        boolean getIsMuteRemote();

        boolean getIsAttachedParentAbility();

        int getServerBuffUid();

        int getModifierLocalId();

        int getActionValue();

        ModifierActionOuterClass.ModifierAction getAction();
    }

    private AbilityMetaModifierChangeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaModifierChangeOuterClass$AbilityMetaModifierChange.class */
    public static final class AbilityMetaModifierChange extends GeneratedMessageV3 implements AbilityMetaModifierChangeOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int APPLYENTITYID_FIELD_NUMBER = 8;
        private int applyEntityId_;
        public static final int ATTACHEDINSTANCEDMODIFIER_FIELD_NUMBER = 7;
        private AbilityAttachedModifierOuterClass.AbilityAttachedModifier attachedInstancedModifier_;
        public static final int IS_DURABILITY_ZERO_FIELD_NUMBER = 1;
        private boolean isDurabilityZero_;
        public static final int PROPERTIES_FIELD_NUMBER = 13;
        private List<ModifierPropertyOuterClass.ModifierProperty> properties_;
        public static final int PARENTABILITYNAME_FIELD_NUMBER = 10;
        private AbilityStringOuterClass.AbilityString parentAbilityName_;
        public static final int PARENTABILITYOVERRIDE_FIELD_NUMBER = 5;
        private AbilityStringOuterClass.AbilityString parentAbilityOverride_;
        public static final int IS_MUTE_REMOTE_FIELD_NUMBER = 11;
        private boolean isMuteRemote_;
        public static final int ISATTACHEDPARENTABILITY_FIELD_NUMBER = 3;
        private boolean isAttachedParentAbility_;
        public static final int SERVERBUFFUID_FIELD_NUMBER = 9;
        private int serverBuffUid_;
        public static final int MODIFIERLOCALID_FIELD_NUMBER = 6;
        private int modifierLocalId_;
        public static final int ACTION_FIELD_NUMBER = 2;
        private int action_;
        private byte memoizedIsInitialized;
        private static final AbilityMetaModifierChange DEFAULT_INSTANCE = new AbilityMetaModifierChange();
        private static final Parser<AbilityMetaModifierChange> PARSER = new AbstractParser<AbilityMetaModifierChange>() { // from class: emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChange.1
            @Override // com.google.protobuf.Parser
            public AbilityMetaModifierChange parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityMetaModifierChange(input, extensionRegistry);
            }
        };

        private AbilityMetaModifierChange(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityMetaModifierChange() {
            this.memoizedIsInitialized = -1;
            this.properties_ = Collections.emptyList();
            this.action_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityMetaModifierChange();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityMetaModifierChange(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                this.isDurabilityZero_ = input.readBool();
                                break;
                            case 16:
                                this.action_ = input.readEnum();
                                break;
                            case 24:
                                this.isAttachedParentAbility_ = input.readBool();
                                break;
                            case 42:
                                AbilityStringOuterClass.AbilityString.Builder subBuilder = this.parentAbilityOverride_ != null ? this.parentAbilityOverride_.toBuilder() : null;
                                this.parentAbilityOverride_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.parentAbilityOverride_);
                                    this.parentAbilityOverride_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 48:
                                this.modifierLocalId_ = input.readInt32();
                                break;
                            case 58:
                                AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder subBuilder2 = this.attachedInstancedModifier_ != null ? this.attachedInstancedModifier_.toBuilder() : null;
                                this.attachedInstancedModifier_ = (AbilityAttachedModifierOuterClass.AbilityAttachedModifier) input.readMessage(AbilityAttachedModifierOuterClass.AbilityAttachedModifier.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.attachedInstancedModifier_);
                                    this.attachedInstancedModifier_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 64:
                                this.applyEntityId_ = input.readUInt32();
                                break;
                            case 72:
                                this.serverBuffUid_ = input.readUInt32();
                                break;
                            case 82:
                                AbilityStringOuterClass.AbilityString.Builder subBuilder3 = this.parentAbilityName_ != null ? this.parentAbilityName_.toBuilder() : null;
                                this.parentAbilityName_ = (AbilityStringOuterClass.AbilityString) input.readMessage(AbilityStringOuterClass.AbilityString.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.parentAbilityName_);
                                    this.parentAbilityName_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 88:
                                this.isMuteRemote_ = input.readBool();
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.properties_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.properties_.add((ModifierPropertyOuterClass.ModifierProperty) input.readMessage(ModifierPropertyOuterClass.ModifierProperty.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.properties_ = Collections.unmodifiableList(this.properties_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilityMetaModifierChangeOuterClass.internal_static_AbilityMetaModifierChange_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityMetaModifierChangeOuterClass.internal_static_AbilityMetaModifierChange_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityMetaModifierChange.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public int getApplyEntityId() {
            return this.applyEntityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public boolean hasAttachedInstancedModifier() {
            return this.attachedInstancedModifier_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public AbilityAttachedModifierOuterClass.AbilityAttachedModifier getAttachedInstancedModifier() {
            return this.attachedInstancedModifier_ == null ? AbilityAttachedModifierOuterClass.AbilityAttachedModifier.getDefaultInstance() : this.attachedInstancedModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder getAttachedInstancedModifierOrBuilder() {
            return getAttachedInstancedModifier();
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public boolean getIsDurabilityZero() {
            return this.isDurabilityZero_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public List<ModifierPropertyOuterClass.ModifierProperty> getPropertiesList() {
            return this.properties_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public List<? extends ModifierPropertyOuterClass.ModifierPropertyOrBuilder> getPropertiesOrBuilderList() {
            return this.properties_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public int getPropertiesCount() {
            return this.properties_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public ModifierPropertyOuterClass.ModifierProperty getProperties(int index) {
            return this.properties_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public ModifierPropertyOuterClass.ModifierPropertyOrBuilder getPropertiesOrBuilder(int index) {
            return this.properties_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public boolean hasParentAbilityName() {
            return this.parentAbilityName_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public AbilityStringOuterClass.AbilityString getParentAbilityName() {
            return this.parentAbilityName_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityName_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityNameOrBuilder() {
            return getParentAbilityName();
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public boolean hasParentAbilityOverride() {
            return this.parentAbilityOverride_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public AbilityStringOuterClass.AbilityString getParentAbilityOverride() {
            return this.parentAbilityOverride_ == null ? AbilityStringOuterClass.AbilityString.getDefaultInstance() : this.parentAbilityOverride_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public AbilityStringOuterClass.AbilityStringOrBuilder getParentAbilityOverrideOrBuilder() {
            return getParentAbilityOverride();
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public boolean getIsMuteRemote() {
            return this.isMuteRemote_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public boolean getIsAttachedParentAbility() {
            return this.isAttachedParentAbility_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public int getServerBuffUid() {
            return this.serverBuffUid_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public int getModifierLocalId() {
            return this.modifierLocalId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public int getActionValue() {
            return this.action_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
        public ModifierActionOuterClass.ModifierAction getAction() {
            ModifierActionOuterClass.ModifierAction result = ModifierActionOuterClass.ModifierAction.valueOf(this.action_);
            return result == null ? ModifierActionOuterClass.ModifierAction.UNRECOGNIZED : result;
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
            if (this.isDurabilityZero_) {
                output.writeBool(1, this.isDurabilityZero_);
            }
            if (this.action_ != ModifierActionOuterClass.ModifierAction.MODIFIER_ACTION_ADDED.getNumber()) {
                output.writeEnum(2, this.action_);
            }
            if (this.isAttachedParentAbility_) {
                output.writeBool(3, this.isAttachedParentAbility_);
            }
            if (this.parentAbilityOverride_ != null) {
                output.writeMessage(5, getParentAbilityOverride());
            }
            if (this.modifierLocalId_ != 0) {
                output.writeInt32(6, this.modifierLocalId_);
            }
            if (this.attachedInstancedModifier_ != null) {
                output.writeMessage(7, getAttachedInstancedModifier());
            }
            if (this.applyEntityId_ != 0) {
                output.writeUInt32(8, this.applyEntityId_);
            }
            if (this.serverBuffUid_ != 0) {
                output.writeUInt32(9, this.serverBuffUid_);
            }
            if (this.parentAbilityName_ != null) {
                output.writeMessage(10, getParentAbilityName());
            }
            if (this.isMuteRemote_) {
                output.writeBool(11, this.isMuteRemote_);
            }
            for (int i = 0; i < this.properties_.size(); i++) {
                output.writeMessage(13, this.properties_.get(i));
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
            if (this.isDurabilityZero_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isDurabilityZero_);
            }
            if (this.action_ != ModifierActionOuterClass.ModifierAction.MODIFIER_ACTION_ADDED.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(2, this.action_);
            }
            if (this.isAttachedParentAbility_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isAttachedParentAbility_);
            }
            if (this.parentAbilityOverride_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getParentAbilityOverride());
            }
            if (this.modifierLocalId_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.modifierLocalId_);
            }
            if (this.attachedInstancedModifier_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getAttachedInstancedModifier());
            }
            if (this.applyEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.applyEntityId_);
            }
            if (this.serverBuffUid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.serverBuffUid_);
            }
            if (this.parentAbilityName_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getParentAbilityName());
            }
            if (this.isMuteRemote_) {
                size2 += CodedOutputStream.computeBoolSize(11, this.isMuteRemote_);
            }
            for (int i = 0; i < this.properties_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.properties_.get(i));
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
            if (!(obj instanceof AbilityMetaModifierChange)) {
                return equals(obj);
            }
            AbilityMetaModifierChange other = (AbilityMetaModifierChange) obj;
            if (getApplyEntityId() != other.getApplyEntityId() || hasAttachedInstancedModifier() != other.hasAttachedInstancedModifier()) {
                return false;
            }
            if ((hasAttachedInstancedModifier() && !getAttachedInstancedModifier().equals(other.getAttachedInstancedModifier())) || getIsDurabilityZero() != other.getIsDurabilityZero() || !getPropertiesList().equals(other.getPropertiesList()) || hasParentAbilityName() != other.hasParentAbilityName()) {
                return false;
            }
            if ((!hasParentAbilityName() || getParentAbilityName().equals(other.getParentAbilityName())) && hasParentAbilityOverride() == other.hasParentAbilityOverride()) {
                return (!hasParentAbilityOverride() || getParentAbilityOverride().equals(other.getParentAbilityOverride())) && getIsMuteRemote() == other.getIsMuteRemote() && getIsAttachedParentAbility() == other.getIsAttachedParentAbility() && getServerBuffUid() == other.getServerBuffUid() && getModifierLocalId() == other.getModifierLocalId() && this.action_ == other.action_ && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getApplyEntityId();
            if (hasAttachedInstancedModifier()) {
                hash = (53 * ((37 * hash) + 7)) + getAttachedInstancedModifier().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 1)) + Internal.hashBoolean(getIsDurabilityZero());
            if (getPropertiesCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getPropertiesList().hashCode();
            }
            if (hasParentAbilityName()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getParentAbilityName().hashCode();
            }
            if (hasParentAbilityOverride()) {
                hash2 = (53 * ((37 * hash2) + 5)) + getParentAbilityOverride().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 11)) + Internal.hashBoolean(getIsMuteRemote()))) + 3)) + Internal.hashBoolean(getIsAttachedParentAbility()))) + 9)) + getServerBuffUid())) + 6)) + getModifierLocalId())) + 2)) + this.action_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static AbilityMetaModifierChange parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMetaModifierChange parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMetaModifierChange parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMetaModifierChange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMetaModifierChange parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMetaModifierChange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMetaModifierChange parseFrom(InputStream input) throws IOException {
            return (AbilityMetaModifierChange) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityMetaModifierChange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMetaModifierChange) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityMetaModifierChange parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityMetaModifierChange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityMetaModifierChange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMetaModifierChange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityMetaModifierChange parseFrom(CodedInputStream input) throws IOException {
            return (AbilityMetaModifierChange) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityMetaModifierChange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMetaModifierChange) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityMetaModifierChange prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaModifierChangeOuterClass$AbilityMetaModifierChange$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityMetaModifierChangeOrBuilder {
            private int bitField0_;
            private int applyEntityId_;
            private AbilityAttachedModifierOuterClass.AbilityAttachedModifier attachedInstancedModifier_;
            private SingleFieldBuilderV3<AbilityAttachedModifierOuterClass.AbilityAttachedModifier, AbilityAttachedModifierOuterClass.AbilityAttachedModifier.Builder, AbilityAttachedModifierOuterClass.AbilityAttachedModifierOrBuilder> attachedInstancedModifierBuilder_;
            private boolean isDurabilityZero_;
            private RepeatedFieldBuilderV3<ModifierPropertyOuterClass.ModifierProperty, ModifierPropertyOuterClass.ModifierProperty.Builder, ModifierPropertyOuterClass.ModifierPropertyOrBuilder> propertiesBuilder_;
            private AbilityStringOuterClass.AbilityString parentAbilityName_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> parentAbilityNameBuilder_;
            private AbilityStringOuterClass.AbilityString parentAbilityOverride_;
            private SingleFieldBuilderV3<AbilityStringOuterClass.AbilityString, AbilityStringOuterClass.AbilityString.Builder, AbilityStringOuterClass.AbilityStringOrBuilder> parentAbilityOverrideBuilder_;
            private boolean isMuteRemote_;
            private boolean isAttachedParentAbility_;
            private int serverBuffUid_;
            private int modifierLocalId_;
            private List<ModifierPropertyOuterClass.ModifierProperty> properties_ = Collections.emptyList();
            private int action_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityMetaModifierChangeOuterClass.internal_static_AbilityMetaModifierChange_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityMetaModifierChangeOuterClass.internal_static_AbilityMetaModifierChange_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityMetaModifierChange.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityMetaModifierChange.alwaysUseFieldBuilders) {
                    getPropertiesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.applyEntityId_ = 0;
                if (this.attachedInstancedModifierBuilder_ == null) {
                    this.attachedInstancedModifier_ = null;
                } else {
                    this.attachedInstancedModifier_ = null;
                    this.attachedInstancedModifierBuilder_ = null;
                }
                this.isDurabilityZero_ = false;
                if (this.propertiesBuilder_ == null) {
                    this.properties_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.propertiesBuilder_.clear();
                }
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
                this.isMuteRemote_ = false;
                this.isAttachedParentAbility_ = false;
                this.serverBuffUid_ = 0;
                this.modifierLocalId_ = 0;
                this.action_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityMetaModifierChangeOuterClass.internal_static_AbilityMetaModifierChange_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityMetaModifierChange getDefaultInstanceForType() {
                return AbilityMetaModifierChange.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityMetaModifierChange build() {
                AbilityMetaModifierChange result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityMetaModifierChange buildPartial() {
                AbilityMetaModifierChange result = new AbilityMetaModifierChange(this);
                int i = this.bitField0_;
                result.applyEntityId_ = this.applyEntityId_;
                if (this.attachedInstancedModifierBuilder_ == null) {
                    result.attachedInstancedModifier_ = this.attachedInstancedModifier_;
                } else {
                    result.attachedInstancedModifier_ = this.attachedInstancedModifierBuilder_.build();
                }
                result.isDurabilityZero_ = this.isDurabilityZero_;
                if (this.propertiesBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.properties_ = Collections.unmodifiableList(this.properties_);
                        this.bitField0_ &= -2;
                    }
                    result.properties_ = this.properties_;
                } else {
                    result.properties_ = this.propertiesBuilder_.build();
                }
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
                result.isMuteRemote_ = this.isMuteRemote_;
                result.isAttachedParentAbility_ = this.isAttachedParentAbility_;
                result.serverBuffUid_ = this.serverBuffUid_;
                result.modifierLocalId_ = this.modifierLocalId_;
                result.action_ = this.action_;
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
                if (other instanceof AbilityMetaModifierChange) {
                    return mergeFrom((AbilityMetaModifierChange) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityMetaModifierChange other) {
                if (other == AbilityMetaModifierChange.getDefaultInstance()) {
                    return this;
                }
                if (other.getApplyEntityId() != 0) {
                    setApplyEntityId(other.getApplyEntityId());
                }
                if (other.hasAttachedInstancedModifier()) {
                    mergeAttachedInstancedModifier(other.getAttachedInstancedModifier());
                }
                if (other.getIsDurabilityZero()) {
                    setIsDurabilityZero(other.getIsDurabilityZero());
                }
                if (this.propertiesBuilder_ == null) {
                    if (!other.properties_.isEmpty()) {
                        if (this.properties_.isEmpty()) {
                            this.properties_ = other.properties_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropertiesIsMutable();
                            this.properties_.addAll(other.properties_);
                        }
                        onChanged();
                    }
                } else if (!other.properties_.isEmpty()) {
                    if (this.propertiesBuilder_.isEmpty()) {
                        this.propertiesBuilder_.dispose();
                        this.propertiesBuilder_ = null;
                        this.properties_ = other.properties_;
                        this.bitField0_ &= -2;
                        this.propertiesBuilder_ = AbilityMetaModifierChange.alwaysUseFieldBuilders ? getPropertiesFieldBuilder() : null;
                    } else {
                        this.propertiesBuilder_.addAllMessages(other.properties_);
                    }
                }
                if (other.hasParentAbilityName()) {
                    mergeParentAbilityName(other.getParentAbilityName());
                }
                if (other.hasParentAbilityOverride()) {
                    mergeParentAbilityOverride(other.getParentAbilityOverride());
                }
                if (other.getIsMuteRemote()) {
                    setIsMuteRemote(other.getIsMuteRemote());
                }
                if (other.getIsAttachedParentAbility()) {
                    setIsAttachedParentAbility(other.getIsAttachedParentAbility());
                }
                if (other.getServerBuffUid() != 0) {
                    setServerBuffUid(other.getServerBuffUid());
                }
                if (other.getModifierLocalId() != 0) {
                    setModifierLocalId(other.getModifierLocalId());
                }
                if (other.action_ != 0) {
                    setActionValue(other.getActionValue());
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
                AbilityMetaModifierChange parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityMetaModifierChange.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityMetaModifierChange) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public boolean hasAttachedInstancedModifier() {
                return (this.attachedInstancedModifierBuilder_ == null && this.attachedInstancedModifier_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public boolean getIsDurabilityZero() {
                return this.isDurabilityZero_;
            }

            public Builder setIsDurabilityZero(boolean value) {
                this.isDurabilityZero_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDurabilityZero() {
                this.isDurabilityZero_ = false;
                onChanged();
                return this;
            }

            private void ensurePropertiesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.properties_ = new ArrayList(this.properties_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public List<ModifierPropertyOuterClass.ModifierProperty> getPropertiesList() {
                if (this.propertiesBuilder_ == null) {
                    return Collections.unmodifiableList(this.properties_);
                }
                return this.propertiesBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public int getPropertiesCount() {
                if (this.propertiesBuilder_ == null) {
                    return this.properties_.size();
                }
                return this.propertiesBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public ModifierPropertyOuterClass.ModifierProperty getProperties(int index) {
                if (this.propertiesBuilder_ == null) {
                    return this.properties_.get(index);
                }
                return this.propertiesBuilder_.getMessage(index);
            }

            public Builder setProperties(int index, ModifierPropertyOuterClass.ModifierProperty value) {
                if (this.propertiesBuilder_ != null) {
                    this.propertiesBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropertiesIsMutable();
                    this.properties_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setProperties(int index, ModifierPropertyOuterClass.ModifierProperty.Builder builderForValue) {
                if (this.propertiesBuilder_ == null) {
                    ensurePropertiesIsMutable();
                    this.properties_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propertiesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addProperties(ModifierPropertyOuterClass.ModifierProperty value) {
                if (this.propertiesBuilder_ != null) {
                    this.propertiesBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropertiesIsMutable();
                    this.properties_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addProperties(int index, ModifierPropertyOuterClass.ModifierProperty value) {
                if (this.propertiesBuilder_ != null) {
                    this.propertiesBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropertiesIsMutable();
                    this.properties_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addProperties(ModifierPropertyOuterClass.ModifierProperty.Builder builderForValue) {
                if (this.propertiesBuilder_ == null) {
                    ensurePropertiesIsMutable();
                    this.properties_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.propertiesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addProperties(int index, ModifierPropertyOuterClass.ModifierProperty.Builder builderForValue) {
                if (this.propertiesBuilder_ == null) {
                    ensurePropertiesIsMutable();
                    this.properties_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propertiesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllProperties(Iterable<? extends ModifierPropertyOuterClass.ModifierProperty> values) {
                if (this.propertiesBuilder_ == null) {
                    ensurePropertiesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.properties_);
                    onChanged();
                } else {
                    this.propertiesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearProperties() {
                if (this.propertiesBuilder_ == null) {
                    this.properties_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.propertiesBuilder_.clear();
                }
                return this;
            }

            public Builder removeProperties(int index) {
                if (this.propertiesBuilder_ == null) {
                    ensurePropertiesIsMutable();
                    this.properties_.remove(index);
                    onChanged();
                } else {
                    this.propertiesBuilder_.remove(index);
                }
                return this;
            }

            public ModifierPropertyOuterClass.ModifierProperty.Builder getPropertiesBuilder(int index) {
                return getPropertiesFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public ModifierPropertyOuterClass.ModifierPropertyOrBuilder getPropertiesOrBuilder(int index) {
                if (this.propertiesBuilder_ == null) {
                    return this.properties_.get(index);
                }
                return this.propertiesBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public List<? extends ModifierPropertyOuterClass.ModifierPropertyOrBuilder> getPropertiesOrBuilderList() {
                if (this.propertiesBuilder_ != null) {
                    return this.propertiesBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.properties_);
            }

            public ModifierPropertyOuterClass.ModifierProperty.Builder addPropertiesBuilder() {
                return getPropertiesFieldBuilder().addBuilder(ModifierPropertyOuterClass.ModifierProperty.getDefaultInstance());
            }

            public ModifierPropertyOuterClass.ModifierProperty.Builder addPropertiesBuilder(int index) {
                return getPropertiesFieldBuilder().addBuilder(index, ModifierPropertyOuterClass.ModifierProperty.getDefaultInstance());
            }

            public List<ModifierPropertyOuterClass.ModifierProperty.Builder> getPropertiesBuilderList() {
                return getPropertiesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ModifierPropertyOuterClass.ModifierProperty, ModifierPropertyOuterClass.ModifierProperty.Builder, ModifierPropertyOuterClass.ModifierPropertyOrBuilder> getPropertiesFieldBuilder() {
                if (this.propertiesBuilder_ == null) {
                    this.propertiesBuilder_ = new RepeatedFieldBuilderV3<>(this.properties_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.properties_ = null;
                }
                return this.propertiesBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public boolean hasParentAbilityName() {
                return (this.parentAbilityNameBuilder_ == null && this.parentAbilityName_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public boolean hasParentAbilityOverride() {
                return (this.parentAbilityOverrideBuilder_ == null && this.parentAbilityOverride_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public boolean getIsMuteRemote() {
                return this.isMuteRemote_;
            }

            public Builder setIsMuteRemote(boolean value) {
                this.isMuteRemote_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsMuteRemote() {
                this.isMuteRemote_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public int getActionValue() {
                return this.action_;
            }

            public Builder setActionValue(int value) {
                this.action_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaModifierChangeOuterClass.AbilityMetaModifierChangeOrBuilder
            public ModifierActionOuterClass.ModifierAction getAction() {
                ModifierActionOuterClass.ModifierAction result = ModifierActionOuterClass.ModifierAction.valueOf(this.action_);
                return result == null ? ModifierActionOuterClass.ModifierAction.UNRECOGNIZED : result;
            }

            public Builder setAction(ModifierActionOuterClass.ModifierAction value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.action_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAction() {
                this.action_ = 0;
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

        public static AbilityMetaModifierChange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityMetaModifierChange> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityMetaModifierChange> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityMetaModifierChange getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityAttachedModifierOuterClass.getDescriptor();
        AbilityStringOuterClass.getDescriptor();
        ModifierActionOuterClass.getDescriptor();
        ModifierPropertyOuterClass.getDescriptor();
    }
}
