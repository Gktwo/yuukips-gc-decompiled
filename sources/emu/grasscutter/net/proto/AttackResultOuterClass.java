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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityIdentifierOuterClass;
import emu.grasscutter.net.proto.AttackHitEffectResultOuterClass;
import emu.grasscutter.net.proto.HitCollisionOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultOuterClass.class */
public final class AttackResultOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012AttackResult.proto\u001a\u0017AbilityIdentifier.proto\u001a\u001bAttackHitEffectResult.proto\u001a\u0012HitCollision.proto\u001a\fVector.proto\"Û\u0006\n\fAttackResult\u0012\u0012\n\ndefense_id\u0018\u0002 \u0001(\r\u0012\u0013\n\u000battacker_id\u0018\u0001 \u0001(\r\u0012\u0014\n\u000btarget_type\u0018Î\u000e \u0001(\r\u0012\u0015\n\fendure_delta\u0018£\u0006 \u0001(\u0002\u0012\u001c\n\u0013Unk3300_DOMAOPGPHMD\u0018Æ\u0003 \u0001(\b\u0012\u0014\n\felement_type\u0018\f \u0001(\r\u0012\u001c\n\u0013Unk3300_BALCPHMFIBC\u0018\u000b \u0001(\r\u0012\u000e\n\u0006damage\u0018\n \u0001(\u0002\u0012\u001d\n\u0014hashed_anim_event_id\u0018Û\b \u0001(\r\u0012\u0016\n\rcritical_rand\u0018\u0005 \u0001(\r\u0012\u001c\n\u0013Unk3300_ABJJNNNKGBB\u0018Î\r \u0001(\r\u0012\u001c\n\u0013Unk3300_KPKAECBFABP\u0018Ü\u000f \u0001(\r\u0012.\n\u000ehit_eff_result\u0018\b \u0001(\u000b2\u0016.AttackHitEffectResult\u0012\u0014\n\fendure_break\u0018\u000e \u0001(\r\u0012.\n\u0012ability_identifier\u0018\u0007 \u0001(\u000b2\u0012.AbilityIdentifier\u0012\u0014\n\fhit_pos_type\u0018\u0003 \u0001(\r\u0012\u001c\n\u0013attack_timestamp_ms\u0018ö\r \u0001(\r\u0012\u0016\n\rdamage_shield\u0018\u000f \u0001(\u0002\u0012\u0015\n\fattack_count\u0018Ì\u000b \u0001(\r\u0012\u0017\n\u000eis_resist_text\u0018ù\u0004 \u0001(\b\u0012 \n\u0018hit_retreat_angle_compat\u0018\u0005 \u0001(\u0005\u0012$\n\rhit_collision\u0018\u000f \u0001(\u000b2\r.HitCollision\u0012\u001c\n\u0013Unk3300_MGIMJGMIPLD\u0018Ü\u0005 \u0001(\b\u0012\u000f\n\u0007is_crit\u0018\u0006 \u0001(\b\u0012\u001d\n\fresolved_dir\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012\u001c\n\u0014element_amplify_rate\u0018\u001c \u0001(\u0002\u0012\u0015\n\ranim_event_id\u0018\u0004 \u0001(\t\u0012\u001c\n\u0013Unk3300_GBPJCELJKJA\u0018´\u000e \u0001(\r\u0012\u001c\n\u0013Unk3300_JMJHGJCAOBH\u0018\u0007 \u0001(\r\u0012'\n\u001eelement_durability_attenuation\u0018\u0006 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityIdentifierOuterClass.getDescriptor(), AttackHitEffectResultOuterClass.getDescriptor(), HitCollisionOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AttackResult_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AttackResult_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AttackResult_descriptor, new String[]{"DefenseId", "AttackerId", "TargetType", "EndureDelta", "Unk3300DOMAOPGPHMD", "ElementType", "Unk3300BALCPHMFIBC", "Damage", "HashedAnimEventId", "CriticalRand", "Unk3300ABJJNNNKGBB", "Unk3300KPKAECBFABP", "HitEffResult", "EndureBreak", "AbilityIdentifier", "HitPosType", "AttackTimestampMs", "DamageShield", "AttackCount", "IsResistText", "HitRetreatAngleCompat", "HitCollision", "Unk3300MGIMJGMIPLD", "IsCrit", "ResolvedDir", "ElementAmplifyRate", "AnimEventId", "Unk3300GBPJCELJKJA", "Unk3300JMJHGJCAOBH", "ElementDurabilityAttenuation"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultOuterClass$AttackResultOrBuilder.class */
    public interface AttackResultOrBuilder extends MessageOrBuilder {
        int getDefenseId();

        int getAttackerId();

        int getTargetType();

        float getEndureDelta();

        boolean getUnk3300DOMAOPGPHMD();

        int getElementType();

        int getUnk3300BALCPHMFIBC();

        float getDamage();

        int getHashedAnimEventId();

        int getCriticalRand();

        int getUnk3300ABJJNNNKGBB();

        int getUnk3300KPKAECBFABP();

        boolean hasHitEffResult();

        AttackHitEffectResultOuterClass.AttackHitEffectResult getHitEffResult();

        AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder getHitEffResultOrBuilder();

        int getEndureBreak();

        boolean hasAbilityIdentifier();

        AbilityIdentifierOuterClass.AbilityIdentifier getAbilityIdentifier();

        AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder getAbilityIdentifierOrBuilder();

        int getHitPosType();

        int getAttackTimestampMs();

        float getDamageShield();

        int getAttackCount();

        boolean getIsResistText();

        int getHitRetreatAngleCompat();

        boolean hasHitCollision();

        HitCollisionOuterClass.HitCollision getHitCollision();

        HitCollisionOuterClass.HitCollisionOrBuilder getHitCollisionOrBuilder();

        boolean getUnk3300MGIMJGMIPLD();

        boolean getIsCrit();

        boolean hasResolvedDir();

        VectorOuterClass.Vector getResolvedDir();

        VectorOuterClass.VectorOrBuilder getResolvedDirOrBuilder();

        float getElementAmplifyRate();

        String getAnimEventId();

        ByteString getAnimEventIdBytes();

        int getUnk3300GBPJCELJKJA();

        int getUnk3300JMJHGJCAOBH();

        float getElementDurabilityAttenuation();
    }

    private AttackResultOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultOuterClass$AttackResult.class */
    public static final class AttackResult extends GeneratedMessageV3 implements AttackResultOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DEFENSE_ID_FIELD_NUMBER = 2;
        private int defenseId_;
        public static final int ATTACKER_ID_FIELD_NUMBER = 1;
        private int attackerId_;
        public static final int TARGET_TYPE_FIELD_NUMBER = 1870;
        private int targetType_;
        public static final int ENDURE_DELTA_FIELD_NUMBER = 803;
        private float endureDelta_;
        public static final int UNK3300_DOMAOPGPHMD_FIELD_NUMBER = 454;
        private boolean unk3300DOMAOPGPHMD_;
        public static final int ELEMENT_TYPE_FIELD_NUMBER = 12;
        private int elementType_;
        public static final int UNK3300_BALCPHMFIBC_FIELD_NUMBER = 1438;
        private int unk3300BALCPHMFIBC_;
        public static final int DAMAGE_FIELD_NUMBER = 10;
        private float damage_;
        public static final int HASHED_ANIM_EVENT_ID_FIELD_NUMBER = 1115;
        private int hashedAnimEventId_;
        public static final int CRITICAL_RAND_FIELD_NUMBER = 645;
        private int criticalRand_;
        public static final int UNK3300_ABJJNNNKGBB_FIELD_NUMBER = 1742;
        private int unk3300ABJJNNNKGBB_;
        public static final int UNK3300_KPKAECBFABP_FIELD_NUMBER = 2012;
        private int unk3300KPKAECBFABP_;
        public static final int HIT_EFF_RESULT_FIELD_NUMBER = 8;
        private AttackHitEffectResultOuterClass.AttackHitEffectResult hitEffResult_;
        public static final int ENDURE_BREAK_FIELD_NUMBER = 14;
        private int endureBreak_;
        public static final int ABILITY_IDENTIFIER_FIELD_NUMBER = 7;
        private AbilityIdentifierOuterClass.AbilityIdentifier abilityIdentifier_;
        public static final int HIT_POS_TYPE_FIELD_NUMBER = 3;
        private int hitPosType_;
        public static final int ATTACK_TIMESTAMP_MS_FIELD_NUMBER = 1782;
        private int attackTimestampMs_;
        public static final int DAMAGE_SHIELD_FIELD_NUMBER = 1932;
        private float damageShield_;
        public static final int ATTACK_COUNT_FIELD_NUMBER = 1484;
        private int attackCount_;
        public static final int IS_RESIST_TEXT_FIELD_NUMBER = 633;
        private boolean isResistText_;
        public static final int HIT_RETREAT_ANGLE_COMPAT_FIELD_NUMBER = 5;
        private int hitRetreatAngleCompat_;
        public static final int HIT_COLLISION_FIELD_NUMBER = 15;
        private HitCollisionOuterClass.HitCollision hitCollision_;
        public static final int UNK3300_MGIMJGMIPLD_FIELD_NUMBER = 732;
        private boolean unk3300MGIMJGMIPLD_;
        public static final int IS_CRIT_FIELD_NUMBER = 6;
        private boolean isCrit_;
        public static final int RESOLVED_DIR_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector resolvedDir_;
        public static final int ELEMENT_AMPLIFY_RATE_FIELD_NUMBER = 28;
        private float elementAmplifyRate_;
        public static final int ANIM_EVENT_ID_FIELD_NUMBER = 4;
        private volatile Object animEventId_;
        public static final int UNK3300_GBPJCELJKJA_FIELD_NUMBER = 1844;
        private int unk3300GBPJCELJKJA_;
        public static final int UNK3300_JMJHGJCAOBH_FIELD_NUMBER = 914;
        private int unk3300JMJHGJCAOBH_;
        public static final int ELEMENT_DURABILITY_ATTENUATION_FIELD_NUMBER = 775;
        private float elementDurabilityAttenuation_;
        private byte memoizedIsInitialized;
        private static final AttackResult DEFAULT_INSTANCE = new AttackResult();
        private static final Parser<AttackResult> PARSER = new AbstractParser<AttackResult>() { // from class: emu.grasscutter.net.proto.AttackResultOuterClass.AttackResult.1
            @Override // com.google.protobuf.Parser
            public AttackResult parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AttackResult(input, extensionRegistry);
            }
        };

        private AttackResult(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AttackResult() {
            this.memoizedIsInitialized = -1;
            this.animEventId_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AttackResult();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AttackResult(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.attackerId_ = input.readUInt32();
                                break;
                            case 16:
                                this.defenseId_ = input.readUInt32();
                                break;
                            case 24:
                                this.hitPosType_ = input.readUInt32();
                                break;
                            case 34:
                                this.animEventId_ = input.readStringRequireUtf8();
                                break;
                            case 40:
                                this.hitRetreatAngleCompat_ = input.readInt32();
                                break;
                            case 48:
                                this.isCrit_ = input.readBool();
                                break;
                            case 58:
                                AbilityIdentifierOuterClass.AbilityIdentifier.Builder subBuilder = this.abilityIdentifier_ != null ? this.abilityIdentifier_.toBuilder() : null;
                                this.abilityIdentifier_ = (AbilityIdentifierOuterClass.AbilityIdentifier) input.readMessage(AbilityIdentifierOuterClass.AbilityIdentifier.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.abilityIdentifier_);
                                    this.abilityIdentifier_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 66:
                                AttackHitEffectResultOuterClass.AttackHitEffectResult.Builder subBuilder2 = this.hitEffResult_ != null ? this.hitEffResult_.toBuilder() : null;
                                this.hitEffResult_ = (AttackHitEffectResultOuterClass.AttackHitEffectResult) input.readMessage(AttackHitEffectResultOuterClass.AttackHitEffectResult.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.hitEffResult_);
                                    this.hitEffResult_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 85:
                                this.damage_ = input.readFloat();
                                break;
                            case 90:
                                VectorOuterClass.Vector.Builder subBuilder3 = this.resolvedDir_ != null ? this.resolvedDir_.toBuilder() : null;
                                this.resolvedDir_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.resolvedDir_);
                                    this.resolvedDir_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 96:
                                this.elementType_ = input.readUInt32();
                                break;
                            case 112:
                                this.endureBreak_ = input.readUInt32();
                                break;
                            case 122:
                                HitCollisionOuterClass.HitCollision.Builder subBuilder4 = this.hitCollision_ != null ? this.hitCollision_.toBuilder() : null;
                                this.hitCollision_ = (HitCollisionOuterClass.HitCollision) input.readMessage(HitCollisionOuterClass.HitCollision.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.hitCollision_);
                                    this.hitCollision_ = subBuilder4.buildPartial();
                                    break;
                                }
                            case PacketOpcodes.WorldPlayerReviveReq:
                                this.elementAmplifyRate_ = input.readFloat();
                                break;
                            case 3632:
                                this.unk3300DOMAOPGPHMD_ = input.readBool();
                                break;
                            case 5064:
                                this.isResistText_ = input.readBool();
                                break;
                            case 5160:
                                this.criticalRand_ = input.readUInt32();
                                break;
                            case 5856:
                                this.unk3300MGIMJGMIPLD_ = input.readBool();
                                break;
                            case PacketOpcodes.GetCustomDungeonReq:
                                this.elementDurabilityAttenuation_ = input.readFloat();
                                break;
                            case 6429:
                                this.endureDelta_ = input.readFloat();
                                break;
                            case 7312:
                                this.unk3300JMJHGJCAOBH_ = input.readUInt32();
                                break;
                            case 8920:
                                this.hashedAnimEventId_ = input.readUInt32();
                                break;
                            case 11504:
                                this.unk3300BALCPHMFIBC_ = input.readUInt32();
                                break;
                            case 11872:
                                this.attackCount_ = input.readUInt32();
                                break;
                            case 13936:
                                this.unk3300ABJJNNNKGBB_ = input.readUInt32();
                                break;
                            case 14256:
                                this.attackTimestampMs_ = input.readUInt32();
                                break;
                            case 14752:
                                this.unk3300GBPJCELJKJA_ = input.readUInt32();
                                break;
                            case 14960:
                                this.targetType_ = input.readUInt32();
                                break;
                            case 15461:
                                this.damageShield_ = input.readFloat();
                                break;
                            case 16096:
                                this.unk3300KPKAECBFABP_ = input.readUInt32();
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
            return AttackResultOuterClass.internal_static_AttackResult_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AttackResultOuterClass.internal_static_AttackResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AttackResult.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getDefenseId() {
            return this.defenseId_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getAttackerId() {
            return this.attackerId_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getTargetType() {
            return this.targetType_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public float getEndureDelta() {
            return this.endureDelta_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean getUnk3300DOMAOPGPHMD() {
            return this.unk3300DOMAOPGPHMD_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getElementType() {
            return this.elementType_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getUnk3300BALCPHMFIBC() {
            return this.unk3300BALCPHMFIBC_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public float getDamage() {
            return this.damage_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getHashedAnimEventId() {
            return this.hashedAnimEventId_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getCriticalRand() {
            return this.criticalRand_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getUnk3300ABJJNNNKGBB() {
            return this.unk3300ABJJNNNKGBB_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getUnk3300KPKAECBFABP() {
            return this.unk3300KPKAECBFABP_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean hasHitEffResult() {
            return this.hitEffResult_ != null;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public AttackHitEffectResultOuterClass.AttackHitEffectResult getHitEffResult() {
            return this.hitEffResult_ == null ? AttackHitEffectResultOuterClass.AttackHitEffectResult.getDefaultInstance() : this.hitEffResult_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder getHitEffResultOrBuilder() {
            return getHitEffResult();
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getEndureBreak() {
            return this.endureBreak_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean hasAbilityIdentifier() {
            return this.abilityIdentifier_ != null;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public AbilityIdentifierOuterClass.AbilityIdentifier getAbilityIdentifier() {
            return this.abilityIdentifier_ == null ? AbilityIdentifierOuterClass.AbilityIdentifier.getDefaultInstance() : this.abilityIdentifier_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder getAbilityIdentifierOrBuilder() {
            return getAbilityIdentifier();
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getHitPosType() {
            return this.hitPosType_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getAttackTimestampMs() {
            return this.attackTimestampMs_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public float getDamageShield() {
            return this.damageShield_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getAttackCount() {
            return this.attackCount_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean getIsResistText() {
            return this.isResistText_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getHitRetreatAngleCompat() {
            return this.hitRetreatAngleCompat_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean hasHitCollision() {
            return this.hitCollision_ != null;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public HitCollisionOuterClass.HitCollision getHitCollision() {
            return this.hitCollision_ == null ? HitCollisionOuterClass.HitCollision.getDefaultInstance() : this.hitCollision_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public HitCollisionOuterClass.HitCollisionOrBuilder getHitCollisionOrBuilder() {
            return getHitCollision();
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean getUnk3300MGIMJGMIPLD() {
            return this.unk3300MGIMJGMIPLD_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean getIsCrit() {
            return this.isCrit_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public boolean hasResolvedDir() {
            return this.resolvedDir_ != null;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public VectorOuterClass.Vector getResolvedDir() {
            return this.resolvedDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.resolvedDir_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public VectorOuterClass.VectorOrBuilder getResolvedDirOrBuilder() {
            return getResolvedDir();
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public float getElementAmplifyRate() {
            return this.elementAmplifyRate_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public String getAnimEventId() {
            Object ref = this.animEventId_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.animEventId_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public ByteString getAnimEventIdBytes() {
            Object ref = this.animEventId_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.animEventId_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getUnk3300GBPJCELJKJA() {
            return this.unk3300GBPJCELJKJA_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public int getUnk3300JMJHGJCAOBH() {
            return this.unk3300JMJHGJCAOBH_;
        }

        @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
        public float getElementDurabilityAttenuation() {
            return this.elementDurabilityAttenuation_;
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
            if (this.attackerId_ != 0) {
                output.writeUInt32(1, this.attackerId_);
            }
            if (this.defenseId_ != 0) {
                output.writeUInt32(2, this.defenseId_);
            }
            if (this.hitPosType_ != 0) {
                output.writeUInt32(3, this.hitPosType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.animEventId_)) {
                GeneratedMessageV3.writeString(output, 4, this.animEventId_);
            }
            if (this.hitRetreatAngleCompat_ != 0) {
                output.writeInt32(5, this.hitRetreatAngleCompat_);
            }
            if (this.isCrit_) {
                output.writeBool(6, this.isCrit_);
            }
            if (this.abilityIdentifier_ != null) {
                output.writeMessage(7, getAbilityIdentifier());
            }
            if (this.hitEffResult_ != null) {
                output.writeMessage(8, getHitEffResult());
            }
            if (this.damage_ != 0.0f) {
                output.writeFloat(10, this.damage_);
            }
            if (this.resolvedDir_ != null) {
                output.writeMessage(11, getResolvedDir());
            }
            if (this.elementType_ != 0) {
                output.writeUInt32(12, this.elementType_);
            }
            if (this.endureBreak_ != 0) {
                output.writeUInt32(14, this.endureBreak_);
            }
            if (this.hitCollision_ != null) {
                output.writeMessage(15, getHitCollision());
            }
            if (this.elementAmplifyRate_ != 0.0f) {
                output.writeFloat(28, this.elementAmplifyRate_);
            }
            if (this.unk3300DOMAOPGPHMD_) {
                output.writeBool(454, this.unk3300DOMAOPGPHMD_);
            }
            if (this.isResistText_) {
                output.writeBool(633, this.isResistText_);
            }
            if (this.criticalRand_ != 0) {
                output.writeUInt32(645, this.criticalRand_);
            }
            if (this.unk3300MGIMJGMIPLD_) {
                output.writeBool(UNK3300_MGIMJGMIPLD_FIELD_NUMBER, this.unk3300MGIMJGMIPLD_);
            }
            if (this.elementDurabilityAttenuation_ != 0.0f) {
                output.writeFloat(ELEMENT_DURABILITY_ATTENUATION_FIELD_NUMBER, this.elementDurabilityAttenuation_);
            }
            if (this.endureDelta_ != 0.0f) {
                output.writeFloat(803, this.endureDelta_);
            }
            if (this.unk3300JMJHGJCAOBH_ != 0) {
                output.writeUInt32(UNK3300_JMJHGJCAOBH_FIELD_NUMBER, this.unk3300JMJHGJCAOBH_);
            }
            if (this.hashedAnimEventId_ != 0) {
                output.writeUInt32(1115, this.hashedAnimEventId_);
            }
            if (this.unk3300BALCPHMFIBC_ != 0) {
                output.writeUInt32(UNK3300_BALCPHMFIBC_FIELD_NUMBER, this.unk3300BALCPHMFIBC_);
            }
            if (this.attackCount_ != 0) {
                output.writeUInt32(ATTACK_COUNT_FIELD_NUMBER, this.attackCount_);
            }
            if (this.unk3300ABJJNNNKGBB_ != 0) {
                output.writeUInt32(UNK3300_ABJJNNNKGBB_FIELD_NUMBER, this.unk3300ABJJNNNKGBB_);
            }
            if (this.attackTimestampMs_ != 0) {
                output.writeUInt32(1782, this.attackTimestampMs_);
            }
            if (this.unk3300GBPJCELJKJA_ != 0) {
                output.writeUInt32(1844, this.unk3300GBPJCELJKJA_);
            }
            if (this.targetType_ != 0) {
                output.writeUInt32(1870, this.targetType_);
            }
            if (this.damageShield_ != 0.0f) {
                output.writeFloat(DAMAGE_SHIELD_FIELD_NUMBER, this.damageShield_);
            }
            if (this.unk3300KPKAECBFABP_ != 0) {
                output.writeUInt32(2012, this.unk3300KPKAECBFABP_);
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
            if (this.attackerId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.attackerId_);
            }
            if (this.defenseId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.defenseId_);
            }
            if (this.hitPosType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.hitPosType_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.animEventId_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.animEventId_);
            }
            if (this.hitRetreatAngleCompat_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.hitRetreatAngleCompat_);
            }
            if (this.isCrit_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isCrit_);
            }
            if (this.abilityIdentifier_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getAbilityIdentifier());
            }
            if (this.hitEffResult_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getHitEffResult());
            }
            if (this.damage_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(10, this.damage_);
            }
            if (this.resolvedDir_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getResolvedDir());
            }
            if (this.elementType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.elementType_);
            }
            if (this.endureBreak_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.endureBreak_);
            }
            if (this.hitCollision_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getHitCollision());
            }
            if (this.elementAmplifyRate_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(28, this.elementAmplifyRate_);
            }
            if (this.unk3300DOMAOPGPHMD_) {
                size2 += CodedOutputStream.computeBoolSize(454, this.unk3300DOMAOPGPHMD_);
            }
            if (this.isResistText_) {
                size2 += CodedOutputStream.computeBoolSize(633, this.isResistText_);
            }
            if (this.criticalRand_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(645, this.criticalRand_);
            }
            if (this.unk3300MGIMJGMIPLD_) {
                size2 += CodedOutputStream.computeBoolSize(UNK3300_MGIMJGMIPLD_FIELD_NUMBER, this.unk3300MGIMJGMIPLD_);
            }
            if (this.elementDurabilityAttenuation_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(ELEMENT_DURABILITY_ATTENUATION_FIELD_NUMBER, this.elementDurabilityAttenuation_);
            }
            if (this.endureDelta_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(803, this.endureDelta_);
            }
            if (this.unk3300JMJHGJCAOBH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_JMJHGJCAOBH_FIELD_NUMBER, this.unk3300JMJHGJCAOBH_);
            }
            if (this.hashedAnimEventId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1115, this.hashedAnimEventId_);
            }
            if (this.unk3300BALCPHMFIBC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_BALCPHMFIBC_FIELD_NUMBER, this.unk3300BALCPHMFIBC_);
            }
            if (this.attackCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(ATTACK_COUNT_FIELD_NUMBER, this.attackCount_);
            }
            if (this.unk3300ABJJNNNKGBB_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(UNK3300_ABJJNNNKGBB_FIELD_NUMBER, this.unk3300ABJJNNNKGBB_);
            }
            if (this.attackTimestampMs_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1782, this.attackTimestampMs_);
            }
            if (this.unk3300GBPJCELJKJA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1844, this.unk3300GBPJCELJKJA_);
            }
            if (this.targetType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(1870, this.targetType_);
            }
            if (this.damageShield_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(DAMAGE_SHIELD_FIELD_NUMBER, this.damageShield_);
            }
            if (this.unk3300KPKAECBFABP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2012, this.unk3300KPKAECBFABP_);
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
            if (!(obj instanceof AttackResult)) {
                return equals(obj);
            }
            AttackResult other = (AttackResult) obj;
            if (getDefenseId() != other.getDefenseId() || getAttackerId() != other.getAttackerId() || getTargetType() != other.getTargetType() || Float.floatToIntBits(getEndureDelta()) != Float.floatToIntBits(other.getEndureDelta()) || getUnk3300DOMAOPGPHMD() != other.getUnk3300DOMAOPGPHMD() || getElementType() != other.getElementType() || getUnk3300BALCPHMFIBC() != other.getUnk3300BALCPHMFIBC() || Float.floatToIntBits(getDamage()) != Float.floatToIntBits(other.getDamage()) || getHashedAnimEventId() != other.getHashedAnimEventId() || getCriticalRand() != other.getCriticalRand() || getUnk3300ABJJNNNKGBB() != other.getUnk3300ABJJNNNKGBB() || getUnk3300KPKAECBFABP() != other.getUnk3300KPKAECBFABP() || hasHitEffResult() != other.hasHitEffResult()) {
                return false;
            }
            if ((hasHitEffResult() && !getHitEffResult().equals(other.getHitEffResult())) || getEndureBreak() != other.getEndureBreak() || hasAbilityIdentifier() != other.hasAbilityIdentifier()) {
                return false;
            }
            if ((hasAbilityIdentifier() && !getAbilityIdentifier().equals(other.getAbilityIdentifier())) || getHitPosType() != other.getHitPosType() || getAttackTimestampMs() != other.getAttackTimestampMs() || Float.floatToIntBits(getDamageShield()) != Float.floatToIntBits(other.getDamageShield()) || getAttackCount() != other.getAttackCount() || getIsResistText() != other.getIsResistText() || getHitRetreatAngleCompat() != other.getHitRetreatAngleCompat() || hasHitCollision() != other.hasHitCollision()) {
                return false;
            }
            if ((!hasHitCollision() || getHitCollision().equals(other.getHitCollision())) && getUnk3300MGIMJGMIPLD() == other.getUnk3300MGIMJGMIPLD() && getIsCrit() == other.getIsCrit() && hasResolvedDir() == other.hasResolvedDir()) {
                return (!hasResolvedDir() || getResolvedDir().equals(other.getResolvedDir())) && Float.floatToIntBits(getElementAmplifyRate()) == Float.floatToIntBits(other.getElementAmplifyRate()) && getAnimEventId().equals(other.getAnimEventId()) && getUnk3300GBPJCELJKJA() == other.getUnk3300GBPJCELJKJA() && getUnk3300JMJHGJCAOBH() == other.getUnk3300JMJHGJCAOBH() && Float.floatToIntBits(getElementDurabilityAttenuation()) == Float.floatToIntBits(other.getElementDurabilityAttenuation()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getDefenseId())) + 1)) + getAttackerId())) + 1870)) + getTargetType())) + 803)) + Float.floatToIntBits(getEndureDelta()))) + 454)) + Internal.hashBoolean(getUnk3300DOMAOPGPHMD()))) + 12)) + getElementType())) + UNK3300_BALCPHMFIBC_FIELD_NUMBER)) + getUnk3300BALCPHMFIBC())) + 10)) + Float.floatToIntBits(getDamage()))) + 1115)) + getHashedAnimEventId())) + 645)) + getCriticalRand())) + UNK3300_ABJJNNNKGBB_FIELD_NUMBER)) + getUnk3300ABJJNNNKGBB())) + 2012)) + getUnk3300KPKAECBFABP();
            if (hasHitEffResult()) {
                hash = (53 * ((37 * hash) + 8)) + getHitEffResult().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 14)) + getEndureBreak();
            if (hasAbilityIdentifier()) {
                hash2 = (53 * ((37 * hash2) + 7)) + getAbilityIdentifier().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 3)) + getHitPosType())) + 1782)) + getAttackTimestampMs())) + DAMAGE_SHIELD_FIELD_NUMBER)) + Float.floatToIntBits(getDamageShield()))) + ATTACK_COUNT_FIELD_NUMBER)) + getAttackCount())) + 633)) + Internal.hashBoolean(getIsResistText()))) + 5)) + getHitRetreatAngleCompat();
            if (hasHitCollision()) {
                hash3 = (53 * ((37 * hash3) + 15)) + getHitCollision().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * hash3) + UNK3300_MGIMJGMIPLD_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300MGIMJGMIPLD()))) + 6)) + Internal.hashBoolean(getIsCrit());
            if (hasResolvedDir()) {
                hash4 = (53 * ((37 * hash4) + 11)) + getResolvedDir().hashCode();
            }
            int hash5 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash4) + 28)) + Float.floatToIntBits(getElementAmplifyRate()))) + 4)) + getAnimEventId().hashCode())) + 1844)) + getUnk3300GBPJCELJKJA())) + UNK3300_JMJHGJCAOBH_FIELD_NUMBER)) + getUnk3300JMJHGJCAOBH())) + ELEMENT_DURABILITY_ATTENUATION_FIELD_NUMBER)) + Float.floatToIntBits(getElementDurabilityAttenuation()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash5;
            return hash5;
        }

        public static AttackResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AttackResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AttackResult parseFrom(InputStream input) throws IOException {
            return (AttackResult) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AttackResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackResult) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AttackResult parseDelimitedFrom(InputStream input) throws IOException {
            return (AttackResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AttackResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AttackResult parseFrom(CodedInputStream input) throws IOException {
            return (AttackResult) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AttackResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AttackResult) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AttackResult prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AttackResultOuterClass$AttackResult$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttackResultOrBuilder {
            private int defenseId_;
            private int attackerId_;
            private int targetType_;
            private float endureDelta_;
            private boolean unk3300DOMAOPGPHMD_;
            private int elementType_;
            private int unk3300BALCPHMFIBC_;
            private float damage_;
            private int hashedAnimEventId_;
            private int criticalRand_;
            private int unk3300ABJJNNNKGBB_;
            private int unk3300KPKAECBFABP_;
            private AttackHitEffectResultOuterClass.AttackHitEffectResult hitEffResult_;
            private SingleFieldBuilderV3<AttackHitEffectResultOuterClass.AttackHitEffectResult, AttackHitEffectResultOuterClass.AttackHitEffectResult.Builder, AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder> hitEffResultBuilder_;
            private int endureBreak_;
            private AbilityIdentifierOuterClass.AbilityIdentifier abilityIdentifier_;
            private SingleFieldBuilderV3<AbilityIdentifierOuterClass.AbilityIdentifier, AbilityIdentifierOuterClass.AbilityIdentifier.Builder, AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder> abilityIdentifierBuilder_;
            private int hitPosType_;
            private int attackTimestampMs_;
            private float damageShield_;
            private int attackCount_;
            private boolean isResistText_;
            private int hitRetreatAngleCompat_;
            private HitCollisionOuterClass.HitCollision hitCollision_;
            private SingleFieldBuilderV3<HitCollisionOuterClass.HitCollision, HitCollisionOuterClass.HitCollision.Builder, HitCollisionOuterClass.HitCollisionOrBuilder> hitCollisionBuilder_;
            private boolean unk3300MGIMJGMIPLD_;
            private boolean isCrit_;
            private VectorOuterClass.Vector resolvedDir_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> resolvedDirBuilder_;
            private float elementAmplifyRate_;
            private Object animEventId_ = "";
            private int unk3300GBPJCELJKJA_;
            private int unk3300JMJHGJCAOBH_;
            private float elementDurabilityAttenuation_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AttackResultOuterClass.internal_static_AttackResult_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AttackResultOuterClass.internal_static_AttackResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AttackResult.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AttackResult.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.defenseId_ = 0;
                this.attackerId_ = 0;
                this.targetType_ = 0;
                this.endureDelta_ = 0.0f;
                this.unk3300DOMAOPGPHMD_ = false;
                this.elementType_ = 0;
                this.unk3300BALCPHMFIBC_ = 0;
                this.damage_ = 0.0f;
                this.hashedAnimEventId_ = 0;
                this.criticalRand_ = 0;
                this.unk3300ABJJNNNKGBB_ = 0;
                this.unk3300KPKAECBFABP_ = 0;
                if (this.hitEffResultBuilder_ == null) {
                    this.hitEffResult_ = null;
                } else {
                    this.hitEffResult_ = null;
                    this.hitEffResultBuilder_ = null;
                }
                this.endureBreak_ = 0;
                if (this.abilityIdentifierBuilder_ == null) {
                    this.abilityIdentifier_ = null;
                } else {
                    this.abilityIdentifier_ = null;
                    this.abilityIdentifierBuilder_ = null;
                }
                this.hitPosType_ = 0;
                this.attackTimestampMs_ = 0;
                this.damageShield_ = 0.0f;
                this.attackCount_ = 0;
                this.isResistText_ = false;
                this.hitRetreatAngleCompat_ = 0;
                if (this.hitCollisionBuilder_ == null) {
                    this.hitCollision_ = null;
                } else {
                    this.hitCollision_ = null;
                    this.hitCollisionBuilder_ = null;
                }
                this.unk3300MGIMJGMIPLD_ = false;
                this.isCrit_ = false;
                if (this.resolvedDirBuilder_ == null) {
                    this.resolvedDir_ = null;
                } else {
                    this.resolvedDir_ = null;
                    this.resolvedDirBuilder_ = null;
                }
                this.elementAmplifyRate_ = 0.0f;
                this.animEventId_ = "";
                this.unk3300GBPJCELJKJA_ = 0;
                this.unk3300JMJHGJCAOBH_ = 0;
                this.elementDurabilityAttenuation_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AttackResultOuterClass.internal_static_AttackResult_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AttackResult getDefaultInstanceForType() {
                return AttackResult.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AttackResult build() {
                AttackResult result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AttackResult buildPartial() {
                AttackResult result = new AttackResult(this);
                result.defenseId_ = this.defenseId_;
                result.attackerId_ = this.attackerId_;
                result.targetType_ = this.targetType_;
                result.endureDelta_ = this.endureDelta_;
                result.unk3300DOMAOPGPHMD_ = this.unk3300DOMAOPGPHMD_;
                result.elementType_ = this.elementType_;
                result.unk3300BALCPHMFIBC_ = this.unk3300BALCPHMFIBC_;
                result.damage_ = this.damage_;
                result.hashedAnimEventId_ = this.hashedAnimEventId_;
                result.criticalRand_ = this.criticalRand_;
                result.unk3300ABJJNNNKGBB_ = this.unk3300ABJJNNNKGBB_;
                result.unk3300KPKAECBFABP_ = this.unk3300KPKAECBFABP_;
                if (this.hitEffResultBuilder_ == null) {
                    result.hitEffResult_ = this.hitEffResult_;
                } else {
                    result.hitEffResult_ = this.hitEffResultBuilder_.build();
                }
                result.endureBreak_ = this.endureBreak_;
                if (this.abilityIdentifierBuilder_ == null) {
                    result.abilityIdentifier_ = this.abilityIdentifier_;
                } else {
                    result.abilityIdentifier_ = this.abilityIdentifierBuilder_.build();
                }
                result.hitPosType_ = this.hitPosType_;
                result.attackTimestampMs_ = this.attackTimestampMs_;
                result.damageShield_ = this.damageShield_;
                result.attackCount_ = this.attackCount_;
                result.isResistText_ = this.isResistText_;
                result.hitRetreatAngleCompat_ = this.hitRetreatAngleCompat_;
                if (this.hitCollisionBuilder_ == null) {
                    result.hitCollision_ = this.hitCollision_;
                } else {
                    result.hitCollision_ = this.hitCollisionBuilder_.build();
                }
                result.unk3300MGIMJGMIPLD_ = this.unk3300MGIMJGMIPLD_;
                result.isCrit_ = this.isCrit_;
                if (this.resolvedDirBuilder_ == null) {
                    result.resolvedDir_ = this.resolvedDir_;
                } else {
                    result.resolvedDir_ = this.resolvedDirBuilder_.build();
                }
                result.elementAmplifyRate_ = this.elementAmplifyRate_;
                result.animEventId_ = this.animEventId_;
                result.unk3300GBPJCELJKJA_ = this.unk3300GBPJCELJKJA_;
                result.unk3300JMJHGJCAOBH_ = this.unk3300JMJHGJCAOBH_;
                result.elementDurabilityAttenuation_ = this.elementDurabilityAttenuation_;
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
                if (other instanceof AttackResult) {
                    return mergeFrom((AttackResult) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AttackResult other) {
                if (other == AttackResult.getDefaultInstance()) {
                    return this;
                }
                if (other.getDefenseId() != 0) {
                    setDefenseId(other.getDefenseId());
                }
                if (other.getAttackerId() != 0) {
                    setAttackerId(other.getAttackerId());
                }
                if (other.getTargetType() != 0) {
                    setTargetType(other.getTargetType());
                }
                if (other.getEndureDelta() != 0.0f) {
                    setEndureDelta(other.getEndureDelta());
                }
                if (other.getUnk3300DOMAOPGPHMD()) {
                    setUnk3300DOMAOPGPHMD(other.getUnk3300DOMAOPGPHMD());
                }
                if (other.getElementType() != 0) {
                    setElementType(other.getElementType());
                }
                if (other.getUnk3300BALCPHMFIBC() != 0) {
                    setUnk3300BALCPHMFIBC(other.getUnk3300BALCPHMFIBC());
                }
                if (other.getDamage() != 0.0f) {
                    setDamage(other.getDamage());
                }
                if (other.getHashedAnimEventId() != 0) {
                    setHashedAnimEventId(other.getHashedAnimEventId());
                }
                if (other.getCriticalRand() != 0) {
                    setCriticalRand(other.getCriticalRand());
                }
                if (other.getUnk3300ABJJNNNKGBB() != 0) {
                    setUnk3300ABJJNNNKGBB(other.getUnk3300ABJJNNNKGBB());
                }
                if (other.getUnk3300KPKAECBFABP() != 0) {
                    setUnk3300KPKAECBFABP(other.getUnk3300KPKAECBFABP());
                }
                if (other.hasHitEffResult()) {
                    mergeHitEffResult(other.getHitEffResult());
                }
                if (other.getEndureBreak() != 0) {
                    setEndureBreak(other.getEndureBreak());
                }
                if (other.hasAbilityIdentifier()) {
                    mergeAbilityIdentifier(other.getAbilityIdentifier());
                }
                if (other.getHitPosType() != 0) {
                    setHitPosType(other.getHitPosType());
                }
                if (other.getAttackTimestampMs() != 0) {
                    setAttackTimestampMs(other.getAttackTimestampMs());
                }
                if (other.getDamageShield() != 0.0f) {
                    setDamageShield(other.getDamageShield());
                }
                if (other.getAttackCount() != 0) {
                    setAttackCount(other.getAttackCount());
                }
                if (other.getIsResistText()) {
                    setIsResistText(other.getIsResistText());
                }
                if (other.getHitRetreatAngleCompat() != 0) {
                    setHitRetreatAngleCompat(other.getHitRetreatAngleCompat());
                }
                if (other.hasHitCollision()) {
                    mergeHitCollision(other.getHitCollision());
                }
                if (other.getUnk3300MGIMJGMIPLD()) {
                    setUnk3300MGIMJGMIPLD(other.getUnk3300MGIMJGMIPLD());
                }
                if (other.getIsCrit()) {
                    setIsCrit(other.getIsCrit());
                }
                if (other.hasResolvedDir()) {
                    mergeResolvedDir(other.getResolvedDir());
                }
                if (other.getElementAmplifyRate() != 0.0f) {
                    setElementAmplifyRate(other.getElementAmplifyRate());
                }
                if (!other.getAnimEventId().isEmpty()) {
                    this.animEventId_ = other.animEventId_;
                    onChanged();
                }
                if (other.getUnk3300GBPJCELJKJA() != 0) {
                    setUnk3300GBPJCELJKJA(other.getUnk3300GBPJCELJKJA());
                }
                if (other.getUnk3300JMJHGJCAOBH() != 0) {
                    setUnk3300JMJHGJCAOBH(other.getUnk3300JMJHGJCAOBH());
                }
                if (other.getElementDurabilityAttenuation() != 0.0f) {
                    setElementDurabilityAttenuation(other.getElementDurabilityAttenuation());
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
                AttackResult parsedMessage = null;
                try {
                    try {
                        parsedMessage = AttackResult.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AttackResult) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getDefenseId() {
                return this.defenseId_;
            }

            public Builder setDefenseId(int value) {
                this.defenseId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDefenseId() {
                this.defenseId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getAttackerId() {
                return this.attackerId_;
            }

            public Builder setAttackerId(int value) {
                this.attackerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackerId() {
                this.attackerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getTargetType() {
                return this.targetType_;
            }

            public Builder setTargetType(int value) {
                this.targetType_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetType() {
                this.targetType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public float getEndureDelta() {
                return this.endureDelta_;
            }

            public Builder setEndureDelta(float value) {
                this.endureDelta_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndureDelta() {
                this.endureDelta_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean getUnk3300DOMAOPGPHMD() {
                return this.unk3300DOMAOPGPHMD_;
            }

            public Builder setUnk3300DOMAOPGPHMD(boolean value) {
                this.unk3300DOMAOPGPHMD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DOMAOPGPHMD() {
                this.unk3300DOMAOPGPHMD_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getElementType() {
                return this.elementType_;
            }

            public Builder setElementType(int value) {
                this.elementType_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementType() {
                this.elementType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getUnk3300BALCPHMFIBC() {
                return this.unk3300BALCPHMFIBC_;
            }

            public Builder setUnk3300BALCPHMFIBC(int value) {
                this.unk3300BALCPHMFIBC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BALCPHMFIBC() {
                this.unk3300BALCPHMFIBC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public float getDamage() {
                return this.damage_;
            }

            public Builder setDamage(float value) {
                this.damage_ = value;
                onChanged();
                return this;
            }

            public Builder clearDamage() {
                this.damage_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getHashedAnimEventId() {
                return this.hashedAnimEventId_;
            }

            public Builder setHashedAnimEventId(int value) {
                this.hashedAnimEventId_ = value;
                onChanged();
                return this;
            }

            public Builder clearHashedAnimEventId() {
                this.hashedAnimEventId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getCriticalRand() {
                return this.criticalRand_;
            }

            public Builder setCriticalRand(int value) {
                this.criticalRand_ = value;
                onChanged();
                return this;
            }

            public Builder clearCriticalRand() {
                this.criticalRand_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getUnk3300ABJJNNNKGBB() {
                return this.unk3300ABJJNNNKGBB_;
            }

            public Builder setUnk3300ABJJNNNKGBB(int value) {
                this.unk3300ABJJNNNKGBB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ABJJNNNKGBB() {
                this.unk3300ABJJNNNKGBB_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getUnk3300KPKAECBFABP() {
                return this.unk3300KPKAECBFABP_;
            }

            public Builder setUnk3300KPKAECBFABP(int value) {
                this.unk3300KPKAECBFABP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KPKAECBFABP() {
                this.unk3300KPKAECBFABP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean hasHitEffResult() {
                return (this.hitEffResultBuilder_ == null && this.hitEffResult_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public AttackHitEffectResultOuterClass.AttackHitEffectResult getHitEffResult() {
                if (this.hitEffResultBuilder_ == null) {
                    return this.hitEffResult_ == null ? AttackHitEffectResultOuterClass.AttackHitEffectResult.getDefaultInstance() : this.hitEffResult_;
                }
                return this.hitEffResultBuilder_.getMessage();
            }

            public Builder setHitEffResult(AttackHitEffectResultOuterClass.AttackHitEffectResult value) {
                if (this.hitEffResultBuilder_ != null) {
                    this.hitEffResultBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.hitEffResult_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setHitEffResult(AttackHitEffectResultOuterClass.AttackHitEffectResult.Builder builderForValue) {
                if (this.hitEffResultBuilder_ == null) {
                    this.hitEffResult_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hitEffResultBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeHitEffResult(AttackHitEffectResultOuterClass.AttackHitEffectResult value) {
                if (this.hitEffResultBuilder_ == null) {
                    if (this.hitEffResult_ != null) {
                        this.hitEffResult_ = AttackHitEffectResultOuterClass.AttackHitEffectResult.newBuilder(this.hitEffResult_).mergeFrom(value).buildPartial();
                    } else {
                        this.hitEffResult_ = value;
                    }
                    onChanged();
                } else {
                    this.hitEffResultBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearHitEffResult() {
                if (this.hitEffResultBuilder_ == null) {
                    this.hitEffResult_ = null;
                    onChanged();
                } else {
                    this.hitEffResult_ = null;
                    this.hitEffResultBuilder_ = null;
                }
                return this;
            }

            public AttackHitEffectResultOuterClass.AttackHitEffectResult.Builder getHitEffResultBuilder() {
                onChanged();
                return getHitEffResultFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder getHitEffResultOrBuilder() {
                if (this.hitEffResultBuilder_ != null) {
                    return this.hitEffResultBuilder_.getMessageOrBuilder();
                }
                return this.hitEffResult_ == null ? AttackHitEffectResultOuterClass.AttackHitEffectResult.getDefaultInstance() : this.hitEffResult_;
            }

            private SingleFieldBuilderV3<AttackHitEffectResultOuterClass.AttackHitEffectResult, AttackHitEffectResultOuterClass.AttackHitEffectResult.Builder, AttackHitEffectResultOuterClass.AttackHitEffectResultOrBuilder> getHitEffResultFieldBuilder() {
                if (this.hitEffResultBuilder_ == null) {
                    this.hitEffResultBuilder_ = new SingleFieldBuilderV3<>(getHitEffResult(), getParentForChildren(), isClean());
                    this.hitEffResult_ = null;
                }
                return this.hitEffResultBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getEndureBreak() {
                return this.endureBreak_;
            }

            public Builder setEndureBreak(int value) {
                this.endureBreak_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndureBreak() {
                this.endureBreak_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean hasAbilityIdentifier() {
                return (this.abilityIdentifierBuilder_ == null && this.abilityIdentifier_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public AbilityIdentifierOuterClass.AbilityIdentifier getAbilityIdentifier() {
                if (this.abilityIdentifierBuilder_ == null) {
                    return this.abilityIdentifier_ == null ? AbilityIdentifierOuterClass.AbilityIdentifier.getDefaultInstance() : this.abilityIdentifier_;
                }
                return this.abilityIdentifierBuilder_.getMessage();
            }

            public Builder setAbilityIdentifier(AbilityIdentifierOuterClass.AbilityIdentifier value) {
                if (this.abilityIdentifierBuilder_ != null) {
                    this.abilityIdentifierBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.abilityIdentifier_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityIdentifier(AbilityIdentifierOuterClass.AbilityIdentifier.Builder builderForValue) {
                if (this.abilityIdentifierBuilder_ == null) {
                    this.abilityIdentifier_ = builderForValue.build();
                    onChanged();
                } else {
                    this.abilityIdentifierBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAbilityIdentifier(AbilityIdentifierOuterClass.AbilityIdentifier value) {
                if (this.abilityIdentifierBuilder_ == null) {
                    if (this.abilityIdentifier_ != null) {
                        this.abilityIdentifier_ = AbilityIdentifierOuterClass.AbilityIdentifier.newBuilder(this.abilityIdentifier_).mergeFrom(value).buildPartial();
                    } else {
                        this.abilityIdentifier_ = value;
                    }
                    onChanged();
                } else {
                    this.abilityIdentifierBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAbilityIdentifier() {
                if (this.abilityIdentifierBuilder_ == null) {
                    this.abilityIdentifier_ = null;
                    onChanged();
                } else {
                    this.abilityIdentifier_ = null;
                    this.abilityIdentifierBuilder_ = null;
                }
                return this;
            }

            public AbilityIdentifierOuterClass.AbilityIdentifier.Builder getAbilityIdentifierBuilder() {
                onChanged();
                return getAbilityIdentifierFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder getAbilityIdentifierOrBuilder() {
                if (this.abilityIdentifierBuilder_ != null) {
                    return this.abilityIdentifierBuilder_.getMessageOrBuilder();
                }
                return this.abilityIdentifier_ == null ? AbilityIdentifierOuterClass.AbilityIdentifier.getDefaultInstance() : this.abilityIdentifier_;
            }

            private SingleFieldBuilderV3<AbilityIdentifierOuterClass.AbilityIdentifier, AbilityIdentifierOuterClass.AbilityIdentifier.Builder, AbilityIdentifierOuterClass.AbilityIdentifierOrBuilder> getAbilityIdentifierFieldBuilder() {
                if (this.abilityIdentifierBuilder_ == null) {
                    this.abilityIdentifierBuilder_ = new SingleFieldBuilderV3<>(getAbilityIdentifier(), getParentForChildren(), isClean());
                    this.abilityIdentifier_ = null;
                }
                return this.abilityIdentifierBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getHitPosType() {
                return this.hitPosType_;
            }

            public Builder setHitPosType(int value) {
                this.hitPosType_ = value;
                onChanged();
                return this;
            }

            public Builder clearHitPosType() {
                this.hitPosType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getAttackTimestampMs() {
                return this.attackTimestampMs_;
            }

            public Builder setAttackTimestampMs(int value) {
                this.attackTimestampMs_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackTimestampMs() {
                this.attackTimestampMs_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public float getDamageShield() {
                return this.damageShield_;
            }

            public Builder setDamageShield(float value) {
                this.damageShield_ = value;
                onChanged();
                return this;
            }

            public Builder clearDamageShield() {
                this.damageShield_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getAttackCount() {
                return this.attackCount_;
            }

            public Builder setAttackCount(int value) {
                this.attackCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackCount() {
                this.attackCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean getIsResistText() {
                return this.isResistText_;
            }

            public Builder setIsResistText(boolean value) {
                this.isResistText_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsResistText() {
                this.isResistText_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getHitRetreatAngleCompat() {
                return this.hitRetreatAngleCompat_;
            }

            public Builder setHitRetreatAngleCompat(int value) {
                this.hitRetreatAngleCompat_ = value;
                onChanged();
                return this;
            }

            public Builder clearHitRetreatAngleCompat() {
                this.hitRetreatAngleCompat_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean hasHitCollision() {
                return (this.hitCollisionBuilder_ == null && this.hitCollision_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public HitCollisionOuterClass.HitCollision getHitCollision() {
                if (this.hitCollisionBuilder_ == null) {
                    return this.hitCollision_ == null ? HitCollisionOuterClass.HitCollision.getDefaultInstance() : this.hitCollision_;
                }
                return this.hitCollisionBuilder_.getMessage();
            }

            public Builder setHitCollision(HitCollisionOuterClass.HitCollision value) {
                if (this.hitCollisionBuilder_ != null) {
                    this.hitCollisionBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.hitCollision_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setHitCollision(HitCollisionOuterClass.HitCollision.Builder builderForValue) {
                if (this.hitCollisionBuilder_ == null) {
                    this.hitCollision_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hitCollisionBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeHitCollision(HitCollisionOuterClass.HitCollision value) {
                if (this.hitCollisionBuilder_ == null) {
                    if (this.hitCollision_ != null) {
                        this.hitCollision_ = HitCollisionOuterClass.HitCollision.newBuilder(this.hitCollision_).mergeFrom(value).buildPartial();
                    } else {
                        this.hitCollision_ = value;
                    }
                    onChanged();
                } else {
                    this.hitCollisionBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearHitCollision() {
                if (this.hitCollisionBuilder_ == null) {
                    this.hitCollision_ = null;
                    onChanged();
                } else {
                    this.hitCollision_ = null;
                    this.hitCollisionBuilder_ = null;
                }
                return this;
            }

            public HitCollisionOuterClass.HitCollision.Builder getHitCollisionBuilder() {
                onChanged();
                return getHitCollisionFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public HitCollisionOuterClass.HitCollisionOrBuilder getHitCollisionOrBuilder() {
                if (this.hitCollisionBuilder_ != null) {
                    return this.hitCollisionBuilder_.getMessageOrBuilder();
                }
                return this.hitCollision_ == null ? HitCollisionOuterClass.HitCollision.getDefaultInstance() : this.hitCollision_;
            }

            private SingleFieldBuilderV3<HitCollisionOuterClass.HitCollision, HitCollisionOuterClass.HitCollision.Builder, HitCollisionOuterClass.HitCollisionOrBuilder> getHitCollisionFieldBuilder() {
                if (this.hitCollisionBuilder_ == null) {
                    this.hitCollisionBuilder_ = new SingleFieldBuilderV3<>(getHitCollision(), getParentForChildren(), isClean());
                    this.hitCollision_ = null;
                }
                return this.hitCollisionBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean getUnk3300MGIMJGMIPLD() {
                return this.unk3300MGIMJGMIPLD_;
            }

            public Builder setUnk3300MGIMJGMIPLD(boolean value) {
                this.unk3300MGIMJGMIPLD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MGIMJGMIPLD() {
                this.unk3300MGIMJGMIPLD_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean getIsCrit() {
                return this.isCrit_;
            }

            public Builder setIsCrit(boolean value) {
                this.isCrit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCrit() {
                this.isCrit_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public boolean hasResolvedDir() {
                return (this.resolvedDirBuilder_ == null && this.resolvedDir_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public VectorOuterClass.Vector getResolvedDir() {
                if (this.resolvedDirBuilder_ == null) {
                    return this.resolvedDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.resolvedDir_;
                }
                return this.resolvedDirBuilder_.getMessage();
            }

            public Builder setResolvedDir(VectorOuterClass.Vector value) {
                if (this.resolvedDirBuilder_ != null) {
                    this.resolvedDirBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.resolvedDir_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setResolvedDir(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.resolvedDirBuilder_ == null) {
                    this.resolvedDir_ = builderForValue.build();
                    onChanged();
                } else {
                    this.resolvedDirBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeResolvedDir(VectorOuterClass.Vector value) {
                if (this.resolvedDirBuilder_ == null) {
                    if (this.resolvedDir_ != null) {
                        this.resolvedDir_ = VectorOuterClass.Vector.newBuilder(this.resolvedDir_).mergeFrom(value).buildPartial();
                    } else {
                        this.resolvedDir_ = value;
                    }
                    onChanged();
                } else {
                    this.resolvedDirBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearResolvedDir() {
                if (this.resolvedDirBuilder_ == null) {
                    this.resolvedDir_ = null;
                    onChanged();
                } else {
                    this.resolvedDir_ = null;
                    this.resolvedDirBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getResolvedDirBuilder() {
                onChanged();
                return getResolvedDirFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public VectorOuterClass.VectorOrBuilder getResolvedDirOrBuilder() {
                if (this.resolvedDirBuilder_ != null) {
                    return this.resolvedDirBuilder_.getMessageOrBuilder();
                }
                return this.resolvedDir_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.resolvedDir_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getResolvedDirFieldBuilder() {
                if (this.resolvedDirBuilder_ == null) {
                    this.resolvedDirBuilder_ = new SingleFieldBuilderV3<>(getResolvedDir(), getParentForChildren(), isClean());
                    this.resolvedDir_ = null;
                }
                return this.resolvedDirBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public float getElementAmplifyRate() {
                return this.elementAmplifyRate_;
            }

            public Builder setElementAmplifyRate(float value) {
                this.elementAmplifyRate_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementAmplifyRate() {
                this.elementAmplifyRate_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public String getAnimEventId() {
                Object ref = this.animEventId_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.animEventId_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public ByteString getAnimEventIdBytes() {
                Object ref = this.animEventId_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.animEventId_ = b;
                return b;
            }

            public Builder setAnimEventId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.animEventId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAnimEventId() {
                this.animEventId_ = AttackResult.getDefaultInstance().getAnimEventId();
                onChanged();
                return this;
            }

            public Builder setAnimEventIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AttackResult.checkByteStringIsUtf8(value);
                this.animEventId_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getUnk3300GBPJCELJKJA() {
                return this.unk3300GBPJCELJKJA_;
            }

            public Builder setUnk3300GBPJCELJKJA(int value) {
                this.unk3300GBPJCELJKJA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GBPJCELJKJA() {
                this.unk3300GBPJCELJKJA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public int getUnk3300JMJHGJCAOBH() {
                return this.unk3300JMJHGJCAOBH_;
            }

            public Builder setUnk3300JMJHGJCAOBH(int value) {
                this.unk3300JMJHGJCAOBH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JMJHGJCAOBH() {
                this.unk3300JMJHGJCAOBH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AttackResultOuterClass.AttackResultOrBuilder
            public float getElementDurabilityAttenuation() {
                return this.elementDurabilityAttenuation_;
            }

            public Builder setElementDurabilityAttenuation(float value) {
                this.elementDurabilityAttenuation_ = value;
                onChanged();
                return this;
            }

            public Builder clearElementDurabilityAttenuation() {
                this.elementDurabilityAttenuation_ = 0.0f;
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

        public static AttackResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AttackResult> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AttackResult> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AttackResult getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityIdentifierOuterClass.getDescriptor();
        AttackHitEffectResultOuterClass.getDescriptor();
        HitCollisionOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
