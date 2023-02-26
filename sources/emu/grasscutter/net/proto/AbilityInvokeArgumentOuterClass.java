package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeArgumentOuterClass.class */
public final class AbilityInvokeArgumentOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAbilityInvokeArgument.proto*Ý\u001a\n\u0015AbilityInvokeArgument\u0012 \n\u001cABILITY_INVOKE_ARGUMENT_NONE\u0010��\u00120\n,ABILITY_INVOKE_ARGUMENT_META_MODIFIER_CHANGE\u0010\u0001\u0012@\n<ABILITY_INVOKE_ARGUMENT_META_COMMAND_MODIFIER_CHANGE_REQUEST\u0010\u0002\u00127\n3ABILITY_INVOKE_ARGUMENT_META_SPECIAL_FLOAT_ARGUMENT\u0010\u0003\u0012/\n+ABILITY_INVOKE_ARGUMENT_META_OVERRIDE_PARAM\u0010\u0004\u00125\n1ABILITY_INVOKE_ARGUMENT_META_CLEAR_OVERRIDE_PARAM\u0010\u0005\u00123\n/ABILITY_INVOKE_ARGUMENT_META_REINIT_OVERRIDEMAP\u0010\u0006\u00123\n/ABILITY_INVOKE_ARGUMENT_META_GLOBAL_FLOAT_VALUE\u0010\u0007\u00129\n5ABILITY_INVOKE_ARGUMENT_META_CLEAR_GLOBAL_FLOAT_VALUE\u0010\b\u00129\n5ABILITY_INVOKE_ARGUMENT_META_ABILITY_ELEMENT_STRENGTH\u0010\t\u0012?\n;ABILITY_INVOKE_ARGUMENT_META_ADD_OR_GET_ABILITY_AND_TRIGGER\u0010\n\u00121\n-ABILITY_INVOKE_ARGUMENT_META_SET_KILLED_STATE\u0010\u000b\u00124\n0ABILITY_INVOKE_ARGUMENT_META_SET_ABILITY_TRIGGER\u0010\f\u00120\n,ABILITY_INVOKE_ARGUMENT_META_ADD_NEW_ABILITY\u0010\r\u0012/\n+ABILITY_INVOKE_ARGUMENT_META_REMOVE_ABILITY\u0010\u000e\u0012:\n6ABILITY_INVOKE_ARGUMENT_META_SET_MODIFIER_APPLY_ENTITY\u0010\u000f\u0012;\n7ABILITY_INVOKE_ARGUMENT_META_MODIFIER_DURABILITY_CHANGE\u0010\u0010\u00128\n4ABILITY_INVOKE_ARGUMENT_META_ELEMENT_REACTION_VISUAL\u0010\u0011\u00123\n/ABILITY_INVOKE_ARGUMENT_META_SET_POSE_PARAMETER\u0010\u0012\u0012<\n8ABILITY_INVOKE_ARGUMENT_META_UPDATE_BASE_REACTION_DAMAGE\u0010\u0013\u00129\n5ABILITY_INVOKE_ARGUMENT_META_TRIGGER_ELEMENT_REACTION\u0010\u0014\u0012(\n$ABILITY_INVOKE_ARGUMENT_META_LOSE_HP\u0010\u0015\u00123\n/ABILITY_INVOKE_ARGUMENT_META_DURABILITY_IS_ZERO\u0010\u0016\u00122\n.ABILITY_INVOKE_ARGUMENT_ACTION_TRIGGER_ABILITY\u00102\u00123\n/ABILITY_INVOKE_ARGUMENT_ACTION_SET_CRASH_DAMAGE\u00103\u0012)\n%ABILITY_INVOKE_ARGUMENT_ACTION_EFFECT\u00104\u0012)\n%ABILITY_INVOKE_ARGUMENT_ACTION_SUMMON\u00105\u0012(\n$ABILITY_INVOKE_ARGUMENT_ACTION_BLINK\u00106\u00120\n,ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_GADGET\u00107\u00127\n3ABILITY_INVOKE_ARGUMENT_ACTION_APPLY_LEVEL_MODIFIER\u00108\u00125\n1ABILITY_INVOKE_ARGUMENT_ACTION_GENERATE_ELEM_BALL\u00109\u0012@\n<ABILITY_INVOKE_ARGUMENT_ACTION_SET_RANDOM_OVERRIDE_MAP_VALUE\u0010:\u00125\n1ABILITY_INVOKE_ARGUMENT_ACTION_SERVER_MONSTER_LOG\u0010;\u0012.\n*ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_TILE\u0010<\u0012/\n+ABILITY_INVOKE_ARGUMENT_ACTION_DESTROY_TILE\u0010=\u00123\n/ABILITY_INVOKE_ARGUMENT_ACTION_FIRE_AFTER_IMAGE\u0010>\u00121\n-ABILITY_INVOKE_ARGUMENT_ACTION_DEDUCT_STAMINA\u0010?\u0012-\n)ABILITY_INVOKE_ARGUMENT_ACTION_HIT_EFFECT\u0010@\u0012:\n6ABILITY_INVOKE_ARGUMENT_ACTION_SET_BULLET_TRACK_TARGET\u0010A\u0012\u0017\n\u0013Unk3400_GHKNBDBFGLN\u0010B\u00128\n4ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_STEER_BY_CAMERA\u0010d\u00120\n,ABILITY_INVOKE_ARGUMENT_MIXIN_MONSTER_DEFEND\u0010e\u0012+\n'ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_ZONE\u0010f\u0012.\n*ABILITY_INVOKE_ARGUMENT_MIXIN_COST_STAMINA\u0010g\u0012.\n*ABILITY_INVOKE_ARGUMENT_MIXIN_ELITE_SHIELD\u0010h\u00120\n,ABILITY_INVOKE_ARGUMENT_MIXIN_ELEMENT_SHIELD\u0010i\u0012/\n+ABILITY_INVOKE_ARGUMENT_MIXIN_GLOBAL_SHIELD\u0010j\u0012,\n(ABILITY_INVOKE_ARGUMENT_MIXIN_SHIELD_BAR\u0010k\u00123\n/ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_SEED_SPAWNER\u0010l\u0012?\n;ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_ELEMENT_REACTION\u0010m\u0012;\n7ABILITY_INVOKE_ARGUMENT_MIXIN_FIELD_ENTITY_COUNT_CHANGE\u0010n\u00121\n-ABILITY_INVOKE_ARGUMENT_MIXIN_SCENE_PROP_SYNC\u0010o\u00123\n/ABILITY_INVOKE_ARGUMENT_MIXIN_WIDGET_MP_SUPPORT\u0010p\u0012U\nQABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_SELF_MODIFIER_ELEMENT_DURABILITY_RATIO\u0010q\u00124\n0ABILITY_INVOKE_ARGUMENT_MIXIN_FIREWORKS_LAUNCHER\u0010r\u0012<\n8ABILITY_INVOKE_ARGUMENT_MIXIN_ATTACK_RESULT_CREATE_COUNT\u0010s\u00122\n.ABILITY_INVOKE_ARGUMENT_MIXIN_UGC_TIME_CONTROL\u0010t\u0012/\n+ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_COMBAT\u0010u\u0012@\n<ABILITY_INVOKE_ARGUMENT_MIXIN_DEATH_ZONE_REGIONAL_PLAY_MIXIN\u0010v\u0012-\n)ABILITY_INVOKE_ARGUMENT_MIXIN_UI_INTERACT\u0010w\u00123\n/ABILITY_INVOKE_ARGUMENT_MIXIN_SHOOT_FROM_CAMERA\u0010x\u00126\n2ABILITY_INVOKE_ARGUMENT_MIXIN_ERASE_BRICK_ACTIVITY\u0010y\u0012*\n&ABILITY_INVOKE_ARGUMENT_MIXIN_BREAKOUT\u0010z\u0012\u0017\n\u0013Unk3400_BFBGAADHEJC\u0010{\u0012\u0017\n\u0013Unk3400_HGOJHAPAJLD\u0010|B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AbilityInvokeArgumentOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeArgumentOuterClass$AbilityInvokeArgument.class */
    public enum AbilityInvokeArgument implements ProtocolMessageEnum {
        ABILITY_INVOKE_ARGUMENT_NONE(0),
        ABILITY_INVOKE_ARGUMENT_META_MODIFIER_CHANGE(1),
        ABILITY_INVOKE_ARGUMENT_META_COMMAND_MODIFIER_CHANGE_REQUEST(2),
        ABILITY_INVOKE_ARGUMENT_META_SPECIAL_FLOAT_ARGUMENT(3),
        ABILITY_INVOKE_ARGUMENT_META_OVERRIDE_PARAM(4),
        ABILITY_INVOKE_ARGUMENT_META_CLEAR_OVERRIDE_PARAM(5),
        ABILITY_INVOKE_ARGUMENT_META_REINIT_OVERRIDEMAP(6),
        ABILITY_INVOKE_ARGUMENT_META_GLOBAL_FLOAT_VALUE(7),
        ABILITY_INVOKE_ARGUMENT_META_CLEAR_GLOBAL_FLOAT_VALUE(8),
        ABILITY_INVOKE_ARGUMENT_META_ABILITY_ELEMENT_STRENGTH(9),
        ABILITY_INVOKE_ARGUMENT_META_ADD_OR_GET_ABILITY_AND_TRIGGER(10),
        ABILITY_INVOKE_ARGUMENT_META_SET_KILLED_STATE(11),
        ABILITY_INVOKE_ARGUMENT_META_SET_ABILITY_TRIGGER(12),
        ABILITY_INVOKE_ARGUMENT_META_ADD_NEW_ABILITY(13),
        ABILITY_INVOKE_ARGUMENT_META_REMOVE_ABILITY(14),
        ABILITY_INVOKE_ARGUMENT_META_SET_MODIFIER_APPLY_ENTITY(15),
        ABILITY_INVOKE_ARGUMENT_META_MODIFIER_DURABILITY_CHANGE(16),
        ABILITY_INVOKE_ARGUMENT_META_ELEMENT_REACTION_VISUAL(17),
        ABILITY_INVOKE_ARGUMENT_META_SET_POSE_PARAMETER(18),
        ABILITY_INVOKE_ARGUMENT_META_UPDATE_BASE_REACTION_DAMAGE(19),
        ABILITY_INVOKE_ARGUMENT_META_TRIGGER_ELEMENT_REACTION(20),
        ABILITY_INVOKE_ARGUMENT_META_LOSE_HP(21),
        ABILITY_INVOKE_ARGUMENT_META_DURABILITY_IS_ZERO(22),
        ABILITY_INVOKE_ARGUMENT_ACTION_TRIGGER_ABILITY(50),
        ABILITY_INVOKE_ARGUMENT_ACTION_SET_CRASH_DAMAGE(51),
        ABILITY_INVOKE_ARGUMENT_ACTION_EFFECT(52),
        ABILITY_INVOKE_ARGUMENT_ACTION_SUMMON(53),
        ABILITY_INVOKE_ARGUMENT_ACTION_BLINK(54),
        ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_GADGET(55),
        ABILITY_INVOKE_ARGUMENT_ACTION_APPLY_LEVEL_MODIFIER(56),
        ABILITY_INVOKE_ARGUMENT_ACTION_GENERATE_ELEM_BALL(57),
        ABILITY_INVOKE_ARGUMENT_ACTION_SET_RANDOM_OVERRIDE_MAP_VALUE(58),
        ABILITY_INVOKE_ARGUMENT_ACTION_SERVER_MONSTER_LOG(59),
        ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_TILE(60),
        ABILITY_INVOKE_ARGUMENT_ACTION_DESTROY_TILE(61),
        ABILITY_INVOKE_ARGUMENT_ACTION_FIRE_AFTER_IMAGE(62),
        ABILITY_INVOKE_ARGUMENT_ACTION_DEDUCT_STAMINA(63),
        ABILITY_INVOKE_ARGUMENT_ACTION_HIT_EFFECT(64),
        ABILITY_INVOKE_ARGUMENT_ACTION_SET_BULLET_TRACK_TARGET(65),
        Unk3400_GHKNBDBFGLN(66),
        ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_STEER_BY_CAMERA(100),
        ABILITY_INVOKE_ARGUMENT_MIXIN_MONSTER_DEFEND(101),
        ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_ZONE(102),
        ABILITY_INVOKE_ARGUMENT_MIXIN_COST_STAMINA(103),
        ABILITY_INVOKE_ARGUMENT_MIXIN_ELITE_SHIELD(104),
        ABILITY_INVOKE_ARGUMENT_MIXIN_ELEMENT_SHIELD(105),
        ABILITY_INVOKE_ARGUMENT_MIXIN_GLOBAL_SHIELD(106),
        ABILITY_INVOKE_ARGUMENT_MIXIN_SHIELD_BAR(107),
        ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_SEED_SPAWNER(108),
        ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_ELEMENT_REACTION(109),
        ABILITY_INVOKE_ARGUMENT_MIXIN_FIELD_ENTITY_COUNT_CHANGE(110),
        ABILITY_INVOKE_ARGUMENT_MIXIN_SCENE_PROP_SYNC(111),
        ABILITY_INVOKE_ARGUMENT_MIXIN_WIDGET_MP_SUPPORT(112),
        ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_SELF_MODIFIER_ELEMENT_DURABILITY_RATIO(113),
        ABILITY_INVOKE_ARGUMENT_MIXIN_FIREWORKS_LAUNCHER(114),
        ABILITY_INVOKE_ARGUMENT_MIXIN_ATTACK_RESULT_CREATE_COUNT(115),
        ABILITY_INVOKE_ARGUMENT_MIXIN_UGC_TIME_CONTROL(116),
        ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_COMBAT(117),
        ABILITY_INVOKE_ARGUMENT_MIXIN_DEATH_ZONE_REGIONAL_PLAY_MIXIN(118),
        ABILITY_INVOKE_ARGUMENT_MIXIN_UI_INTERACT(119),
        ABILITY_INVOKE_ARGUMENT_MIXIN_SHOOT_FROM_CAMERA(120),
        ABILITY_INVOKE_ARGUMENT_MIXIN_ERASE_BRICK_ACTIVITY(121),
        ABILITY_INVOKE_ARGUMENT_MIXIN_BREAKOUT(122),
        Unk3400_BFBGAADHEJC(123),
        Unk3400_HGOJHAPAJLD(124),
        UNRECOGNIZED(-1);
        
        public static final int ABILITY_INVOKE_ARGUMENT_NONE_VALUE = 0;
        public static final int ABILITY_INVOKE_ARGUMENT_META_MODIFIER_CHANGE_VALUE = 1;

        /* renamed from: ABILITY_INVOKE_ARGUMENT_META_COMMAND_MODIFIER_CHANGE_REQUEST_VALUE */
        public static final int f607x52200d9c = 2;
        public static final int ABILITY_INVOKE_ARGUMENT_META_SPECIAL_FLOAT_ARGUMENT_VALUE = 3;
        public static final int ABILITY_INVOKE_ARGUMENT_META_OVERRIDE_PARAM_VALUE = 4;
        public static final int ABILITY_INVOKE_ARGUMENT_META_CLEAR_OVERRIDE_PARAM_VALUE = 5;
        public static final int ABILITY_INVOKE_ARGUMENT_META_REINIT_OVERRIDEMAP_VALUE = 6;
        public static final int ABILITY_INVOKE_ARGUMENT_META_GLOBAL_FLOAT_VALUE_VALUE = 7;
        public static final int ABILITY_INVOKE_ARGUMENT_META_CLEAR_GLOBAL_FLOAT_VALUE_VALUE = 8;
        public static final int ABILITY_INVOKE_ARGUMENT_META_ABILITY_ELEMENT_STRENGTH_VALUE = 9;

        /* renamed from: ABILITY_INVOKE_ARGUMENT_META_ADD_OR_GET_ABILITY_AND_TRIGGER_VALUE */
        public static final int f608x7beeb170 = 10;
        public static final int ABILITY_INVOKE_ARGUMENT_META_SET_KILLED_STATE_VALUE = 11;
        public static final int ABILITY_INVOKE_ARGUMENT_META_SET_ABILITY_TRIGGER_VALUE = 12;
        public static final int ABILITY_INVOKE_ARGUMENT_META_ADD_NEW_ABILITY_VALUE = 13;
        public static final int ABILITY_INVOKE_ARGUMENT_META_REMOVE_ABILITY_VALUE = 14;
        public static final int ABILITY_INVOKE_ARGUMENT_META_SET_MODIFIER_APPLY_ENTITY_VALUE = 15;
        public static final int ABILITY_INVOKE_ARGUMENT_META_MODIFIER_DURABILITY_CHANGE_VALUE = 16;
        public static final int ABILITY_INVOKE_ARGUMENT_META_ELEMENT_REACTION_VISUAL_VALUE = 17;
        public static final int ABILITY_INVOKE_ARGUMENT_META_SET_POSE_PARAMETER_VALUE = 18;
        public static final int ABILITY_INVOKE_ARGUMENT_META_UPDATE_BASE_REACTION_DAMAGE_VALUE = 19;
        public static final int ABILITY_INVOKE_ARGUMENT_META_TRIGGER_ELEMENT_REACTION_VALUE = 20;
        public static final int ABILITY_INVOKE_ARGUMENT_META_LOSE_HP_VALUE = 21;
        public static final int ABILITY_INVOKE_ARGUMENT_META_DURABILITY_IS_ZERO_VALUE = 22;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_TRIGGER_ABILITY_VALUE = 50;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_SET_CRASH_DAMAGE_VALUE = 51;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_EFFECT_VALUE = 52;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_SUMMON_VALUE = 53;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_BLINK_VALUE = 54;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_GADGET_VALUE = 55;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_APPLY_LEVEL_MODIFIER_VALUE = 56;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_GENERATE_ELEM_BALL_VALUE = 57;

        /* renamed from: ABILITY_INVOKE_ARGUMENT_ACTION_SET_RANDOM_OVERRIDE_MAP_VALUE_VALUE */
        public static final int f609x8bf87733 = 58;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_SERVER_MONSTER_LOG_VALUE = 59;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_TILE_VALUE = 60;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_DESTROY_TILE_VALUE = 61;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_FIRE_AFTER_IMAGE_VALUE = 62;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_DEDUCT_STAMINA_VALUE = 63;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_HIT_EFFECT_VALUE = 64;
        public static final int ABILITY_INVOKE_ARGUMENT_ACTION_SET_BULLET_TRACK_TARGET_VALUE = 65;
        public static final int Unk3400_GHKNBDBFGLN_VALUE = 66;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_STEER_BY_CAMERA_VALUE = 100;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_MONSTER_DEFEND_VALUE = 101;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_ZONE_VALUE = 102;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_COST_STAMINA_VALUE = 103;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_ELITE_SHIELD_VALUE = 104;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_ELEMENT_SHIELD_VALUE = 105;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_GLOBAL_SHIELD_VALUE = 106;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_SHIELD_BAR_VALUE = 107;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_SEED_SPAWNER_VALUE = 108;

        /* renamed from: ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_ELEMENT_REACTION_VALUE */
        public static final int f610xb0cf9523 = 109;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_FIELD_ENTITY_COUNT_CHANGE_VALUE = 110;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_SCENE_PROP_SYNC_VALUE = 111;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_WIDGET_MP_SUPPORT_VALUE = 112;

        /* renamed from: ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_SELF_MODIFIER_ELEMENT_DURABILITY_RATIO_VALUE */
        public static final int f611xa43bade4 = 113;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_FIREWORKS_LAUNCHER_VALUE = 114;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_ATTACK_RESULT_CREATE_COUNT_VALUE = 115;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_UGC_TIME_CONTROL_VALUE = 116;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_COMBAT_VALUE = 117;

        /* renamed from: ABILITY_INVOKE_ARGUMENT_MIXIN_DEATH_ZONE_REGIONAL_PLAY_MIXIN_VALUE */
        public static final int f612x7bb83fee = 118;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_UI_INTERACT_VALUE = 119;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_SHOOT_FROM_CAMERA_VALUE = 120;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_ERASE_BRICK_ACTIVITY_VALUE = 121;
        public static final int ABILITY_INVOKE_ARGUMENT_MIXIN_BREAKOUT_VALUE = 122;
        public static final int Unk3400_BFBGAADHEJC_VALUE = 123;
        public static final int Unk3400_HGOJHAPAJLD_VALUE = 124;
        private static final Internal.EnumLiteMap<AbilityInvokeArgument> internalValueMap = new Internal.EnumLiteMap<AbilityInvokeArgument>() { // from class: emu.grasscutter.net.proto.AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AbilityInvokeArgument findValueByNumber(int number) {
                return AbilityInvokeArgument.forNumber(number);
            }
        };
        private static final AbilityInvokeArgument[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AbilityInvokeArgument valueOf(int value) {
            return forNumber(value);
        }

        public static AbilityInvokeArgument forNumber(int value) {
            switch (value) {
                case 0:
                    return ABILITY_INVOKE_ARGUMENT_NONE;
                case 1:
                    return ABILITY_INVOKE_ARGUMENT_META_MODIFIER_CHANGE;
                case 2:
                    return ABILITY_INVOKE_ARGUMENT_META_COMMAND_MODIFIER_CHANGE_REQUEST;
                case 3:
                    return ABILITY_INVOKE_ARGUMENT_META_SPECIAL_FLOAT_ARGUMENT;
                case 4:
                    return ABILITY_INVOKE_ARGUMENT_META_OVERRIDE_PARAM;
                case 5:
                    return ABILITY_INVOKE_ARGUMENT_META_CLEAR_OVERRIDE_PARAM;
                case 6:
                    return ABILITY_INVOKE_ARGUMENT_META_REINIT_OVERRIDEMAP;
                case 7:
                    return ABILITY_INVOKE_ARGUMENT_META_GLOBAL_FLOAT_VALUE;
                case 8:
                    return ABILITY_INVOKE_ARGUMENT_META_CLEAR_GLOBAL_FLOAT_VALUE;
                case 9:
                    return ABILITY_INVOKE_ARGUMENT_META_ABILITY_ELEMENT_STRENGTH;
                case 10:
                    return ABILITY_INVOKE_ARGUMENT_META_ADD_OR_GET_ABILITY_AND_TRIGGER;
                case 11:
                    return ABILITY_INVOKE_ARGUMENT_META_SET_KILLED_STATE;
                case 12:
                    return ABILITY_INVOKE_ARGUMENT_META_SET_ABILITY_TRIGGER;
                case 13:
                    return ABILITY_INVOKE_ARGUMENT_META_ADD_NEW_ABILITY;
                case 14:
                    return ABILITY_INVOKE_ARGUMENT_META_REMOVE_ABILITY;
                case 15:
                    return ABILITY_INVOKE_ARGUMENT_META_SET_MODIFIER_APPLY_ENTITY;
                case 16:
                    return ABILITY_INVOKE_ARGUMENT_META_MODIFIER_DURABILITY_CHANGE;
                case 17:
                    return ABILITY_INVOKE_ARGUMENT_META_ELEMENT_REACTION_VISUAL;
                case 18:
                    return ABILITY_INVOKE_ARGUMENT_META_SET_POSE_PARAMETER;
                case 19:
                    return ABILITY_INVOKE_ARGUMENT_META_UPDATE_BASE_REACTION_DAMAGE;
                case 20:
                    return ABILITY_INVOKE_ARGUMENT_META_TRIGGER_ELEMENT_REACTION;
                case 21:
                    return ABILITY_INVOKE_ARGUMENT_META_LOSE_HP;
                case 22:
                    return ABILITY_INVOKE_ARGUMENT_META_DURABILITY_IS_ZERO;
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                default:
                    return null;
                case 50:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_TRIGGER_ABILITY;
                case 51:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_SET_CRASH_DAMAGE;
                case 52:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_EFFECT;
                case 53:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_SUMMON;
                case 54:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_BLINK;
                case 55:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_GADGET;
                case 56:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_APPLY_LEVEL_MODIFIER;
                case 57:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_GENERATE_ELEM_BALL;
                case 58:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_SET_RANDOM_OVERRIDE_MAP_VALUE;
                case 59:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_SERVER_MONSTER_LOG;
                case 60:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_CREATE_TILE;
                case 61:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_DESTROY_TILE;
                case 62:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_FIRE_AFTER_IMAGE;
                case 63:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_DEDUCT_STAMINA;
                case 64:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_HIT_EFFECT;
                case 65:
                    return ABILITY_INVOKE_ARGUMENT_ACTION_SET_BULLET_TRACK_TARGET;
                case 66:
                    return Unk3400_GHKNBDBFGLN;
                case 100:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_STEER_BY_CAMERA;
                case 101:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_MONSTER_DEFEND;
                case 102:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_ZONE;
                case 103:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_COST_STAMINA;
                case 104:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_ELITE_SHIELD;
                case 105:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_ELEMENT_SHIELD;
                case 106:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_GLOBAL_SHIELD;
                case 107:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_SHIELD_BAR;
                case 108:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_WIND_SEED_SPAWNER;
                case 109:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_ELEMENT_REACTION;
                case 110:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_FIELD_ENTITY_COUNT_CHANGE;
                case 111:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_SCENE_PROP_SYNC;
                case 112:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_WIDGET_MP_SUPPORT;
                case 113:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_DO_ACTION_BY_SELF_MODIFIER_ELEMENT_DURABILITY_RATIO;
                case 114:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_FIREWORKS_LAUNCHER;
                case 115:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_ATTACK_RESULT_CREATE_COUNT;
                case 116:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_UGC_TIME_CONTROL;
                case 117:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_AVATAR_COMBAT;
                case 118:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_DEATH_ZONE_REGIONAL_PLAY_MIXIN;
                case 119:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_UI_INTERACT;
                case 120:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_SHOOT_FROM_CAMERA;
                case 121:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_ERASE_BRICK_ACTIVITY;
                case 122:
                    return ABILITY_INVOKE_ARGUMENT_MIXIN_BREAKOUT;
                case 123:
                    return Unk3400_BFBGAADHEJC;
                case 124:
                    return Unk3400_HGOJHAPAJLD;
            }
        }

        public static Internal.EnumLiteMap<AbilityInvokeArgument> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return AbilityInvokeArgumentOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AbilityInvokeArgument valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AbilityInvokeArgument(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
