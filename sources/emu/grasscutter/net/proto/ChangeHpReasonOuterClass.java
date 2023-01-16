package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeHpReasonOuterClass.class */
public final class ChangeHpReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ChangeHpReason.proto*¦\b\n\u000eChangeHpReason\u0012\u0019\n\u0015CHANGE_HP_REASON_NONE\u0010��\u0012\u001f\n\u001bCHANGE_HP_REASON_SUB_AVATAR\u0010\u0001\u0012 \n\u001cCHANGE_HP_REASON_SUB_MONSTER\u0010\u0002\u0012\u001d\n\u0019CHANGE_HP_REASON_SUB_GEAR\u0010\u0003\u0012\u001e\n\u001aCHANGE_HP_REASON_SUB_ENVIR\u0010\u0004\u0012\u001d\n\u0019CHANGE_HP_REASON_SUB_FALL\u0010\u0005\u0012\u001e\n\u001aCHANGE_HP_REASON_SUB_DRAWN\u0010\u0006\u0012\u001e\n\u001aCHANGE_HP_REASON_SUB_ABYSS\u0010\u0007\u0012 \n\u001cCHANGE_HP_REASON_SUB_ABILITY\u0010\b\u0012\u001f\n\u001bCHANGE_HP_REASON_SUB_SUMMON\u0010\t\u0012\u001f\n\u001bCHANGE_HP_REASON_SUB_SCRIPT\u0010\n\u0012\u001b\n\u0017CHANGE_HP_REASON_SUB_GM\u0010\u000b\u0012\"\n\u001eCHANGE_HP_REASON_SUB_KILL_SELF\u0010\f\u0012%\n!CHANGE_HP_REASON_SUB_CLIMATE_COLD\u0010\r\u0012(\n$CHANGE_HP_REASON_SUB_STORM_LIGHTNING\u0010\u000e\u0012+\n'CHANGE_HP_REASON_SUB_KILL_SERVER_GADGET\u0010\u000f\u0012 \n\u001cCHANGE_HP_REASON_SUB_REPLACE\u0010\u0010\u0012%\n!CHANGE_HP_REASON_SUB_PLAYER_LEAVE\u0010\u0011\u0012%\n!CHANGE_HP_REASON_ATTACK_BY_ENERGY\u0010\u0012\u0012&\n\"CHANGE_HP_REASON_ATTACK_BY_RECYCLE\u0010\u0013\u0012\u001b\n\u0017CHANGE_HP_REASON_BY_LUA\u00103\u0012 \n\u001cCHANGE_HP_REASON_ADD_ABILITY\u0010e\u0012\u001d\n\u0019CHANGE_HP_REASON_ADD_ITEM\u0010f\u0012\u001f\n\u001bCHANGE_HP_REASON_ADD_REVIVE\u0010g\u0012 \n\u001cCHANGE_HP_REASON_ADD_UPGRADE\u0010h\u0012\u001f\n\u001bCHANGE_HP_REASON_ADD_STATUE\u0010i\u0012#\n\u001fCHANGE_HP_REASON_ADD_BACKGROUND\u0010j\u0012\u001b\n\u0017CHANGE_HP_REASON_ADD_GM\u0010k\u0012.\n*CHANGE_HP_REASON_ADD_TRIAL_AVATAR_ACTIVITY\u0010l\u0012)\n%CHANGE_HP_REASON_ADD_ROGUELIKE_SPRING\u0010mB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ChangeHpReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeHpReasonOuterClass$ChangeHpReason.class */
    public enum ChangeHpReason implements ProtocolMessageEnum {
        CHANGE_HP_REASON_NONE(0),
        CHANGE_HP_REASON_SUB_AVATAR(1),
        CHANGE_HP_REASON_SUB_MONSTER(2),
        CHANGE_HP_REASON_SUB_GEAR(3),
        CHANGE_HP_REASON_SUB_ENVIR(4),
        CHANGE_HP_REASON_SUB_FALL(5),
        CHANGE_HP_REASON_SUB_DRAWN(6),
        CHANGE_HP_REASON_SUB_ABYSS(7),
        CHANGE_HP_REASON_SUB_ABILITY(8),
        CHANGE_HP_REASON_SUB_SUMMON(9),
        CHANGE_HP_REASON_SUB_SCRIPT(10),
        CHANGE_HP_REASON_SUB_GM(11),
        CHANGE_HP_REASON_SUB_KILL_SELF(12),
        CHANGE_HP_REASON_SUB_CLIMATE_COLD(13),
        CHANGE_HP_REASON_SUB_STORM_LIGHTNING(14),
        CHANGE_HP_REASON_SUB_KILL_SERVER_GADGET(15),
        CHANGE_HP_REASON_SUB_REPLACE(16),
        CHANGE_HP_REASON_SUB_PLAYER_LEAVE(17),
        CHANGE_HP_REASON_ATTACK_BY_ENERGY(18),
        CHANGE_HP_REASON_ATTACK_BY_RECYCLE(19),
        CHANGE_HP_REASON_BY_LUA(51),
        CHANGE_HP_REASON_ADD_ABILITY(101),
        CHANGE_HP_REASON_ADD_ITEM(102),
        CHANGE_HP_REASON_ADD_REVIVE(103),
        CHANGE_HP_REASON_ADD_UPGRADE(104),
        CHANGE_HP_REASON_ADD_STATUE(105),
        CHANGE_HP_REASON_ADD_BACKGROUND(106),
        CHANGE_HP_REASON_ADD_GM(107),
        CHANGE_HP_REASON_ADD_TRIAL_AVATAR_ACTIVITY(108),
        CHANGE_HP_REASON_ADD_ROGUELIKE_SPRING(109),
        UNRECOGNIZED(-1);
        
        public static final int CHANGE_HP_REASON_NONE_VALUE = 0;
        public static final int CHANGE_HP_REASON_SUB_AVATAR_VALUE = 1;
        public static final int CHANGE_HP_REASON_SUB_MONSTER_VALUE = 2;
        public static final int CHANGE_HP_REASON_SUB_GEAR_VALUE = 3;
        public static final int CHANGE_HP_REASON_SUB_ENVIR_VALUE = 4;
        public static final int CHANGE_HP_REASON_SUB_FALL_VALUE = 5;
        public static final int CHANGE_HP_REASON_SUB_DRAWN_VALUE = 6;
        public static final int CHANGE_HP_REASON_SUB_ABYSS_VALUE = 7;
        public static final int CHANGE_HP_REASON_SUB_ABILITY_VALUE = 8;
        public static final int CHANGE_HP_REASON_SUB_SUMMON_VALUE = 9;
        public static final int CHANGE_HP_REASON_SUB_SCRIPT_VALUE = 10;
        public static final int CHANGE_HP_REASON_SUB_GM_VALUE = 11;
        public static final int CHANGE_HP_REASON_SUB_KILL_SELF_VALUE = 12;
        public static final int CHANGE_HP_REASON_SUB_CLIMATE_COLD_VALUE = 13;
        public static final int CHANGE_HP_REASON_SUB_STORM_LIGHTNING_VALUE = 14;
        public static final int CHANGE_HP_REASON_SUB_KILL_SERVER_GADGET_VALUE = 15;
        public static final int CHANGE_HP_REASON_SUB_REPLACE_VALUE = 16;
        public static final int CHANGE_HP_REASON_SUB_PLAYER_LEAVE_VALUE = 17;
        public static final int CHANGE_HP_REASON_ATTACK_BY_ENERGY_VALUE = 18;
        public static final int CHANGE_HP_REASON_ATTACK_BY_RECYCLE_VALUE = 19;
        public static final int CHANGE_HP_REASON_BY_LUA_VALUE = 51;
        public static final int CHANGE_HP_REASON_ADD_ABILITY_VALUE = 101;
        public static final int CHANGE_HP_REASON_ADD_ITEM_VALUE = 102;
        public static final int CHANGE_HP_REASON_ADD_REVIVE_VALUE = 103;
        public static final int CHANGE_HP_REASON_ADD_UPGRADE_VALUE = 104;
        public static final int CHANGE_HP_REASON_ADD_STATUE_VALUE = 105;
        public static final int CHANGE_HP_REASON_ADD_BACKGROUND_VALUE = 106;
        public static final int CHANGE_HP_REASON_ADD_GM_VALUE = 107;
        public static final int CHANGE_HP_REASON_ADD_TRIAL_AVATAR_ACTIVITY_VALUE = 108;
        public static final int CHANGE_HP_REASON_ADD_ROGUELIKE_SPRING_VALUE = 109;
        private static final Internal.EnumLiteMap<ChangeHpReason> internalValueMap = new Internal.EnumLiteMap<ChangeHpReason>() { // from class: emu.grasscutter.net.proto.ChangeHpReasonOuterClass.ChangeHpReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChangeHpReason findValueByNumber(int number) {
                return ChangeHpReason.forNumber(number);
            }
        };
        private static final ChangeHpReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ChangeHpReason valueOf(int value) {
            return forNumber(value);
        }

        public static ChangeHpReason forNumber(int value) {
            switch (value) {
                case 0:
                    return CHANGE_HP_REASON_NONE;
                case 1:
                    return CHANGE_HP_REASON_SUB_AVATAR;
                case 2:
                    return CHANGE_HP_REASON_SUB_MONSTER;
                case 3:
                    return CHANGE_HP_REASON_SUB_GEAR;
                case 4:
                    return CHANGE_HP_REASON_SUB_ENVIR;
                case 5:
                    return CHANGE_HP_REASON_SUB_FALL;
                case 6:
                    return CHANGE_HP_REASON_SUB_DRAWN;
                case 7:
                    return CHANGE_HP_REASON_SUB_ABYSS;
                case 8:
                    return CHANGE_HP_REASON_SUB_ABILITY;
                case 9:
                    return CHANGE_HP_REASON_SUB_SUMMON;
                case 10:
                    return CHANGE_HP_REASON_SUB_SCRIPT;
                case 11:
                    return CHANGE_HP_REASON_SUB_GM;
                case 12:
                    return CHANGE_HP_REASON_SUB_KILL_SELF;
                case 13:
                    return CHANGE_HP_REASON_SUB_CLIMATE_COLD;
                case 14:
                    return CHANGE_HP_REASON_SUB_STORM_LIGHTNING;
                case 15:
                    return CHANGE_HP_REASON_SUB_KILL_SERVER_GADGET;
                case 16:
                    return CHANGE_HP_REASON_SUB_REPLACE;
                case 17:
                    return CHANGE_HP_REASON_SUB_PLAYER_LEAVE;
                case 18:
                    return CHANGE_HP_REASON_ATTACK_BY_ENERGY;
                case 19:
                    return CHANGE_HP_REASON_ATTACK_BY_RECYCLE;
                case 20:
                case 21:
                case 22:
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
                case 50:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
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
                case 100:
                default:
                    return null;
                case 51:
                    return CHANGE_HP_REASON_BY_LUA;
                case 101:
                    return CHANGE_HP_REASON_ADD_ABILITY;
                case 102:
                    return CHANGE_HP_REASON_ADD_ITEM;
                case 103:
                    return CHANGE_HP_REASON_ADD_REVIVE;
                case 104:
                    return CHANGE_HP_REASON_ADD_UPGRADE;
                case 105:
                    return CHANGE_HP_REASON_ADD_STATUE;
                case 106:
                    return CHANGE_HP_REASON_ADD_BACKGROUND;
                case 107:
                    return CHANGE_HP_REASON_ADD_GM;
                case 108:
                    return CHANGE_HP_REASON_ADD_TRIAL_AVATAR_ACTIVITY;
                case 109:
                    return CHANGE_HP_REASON_ADD_ROGUELIKE_SPRING;
            }
        }

        public static Internal.EnumLiteMap<ChangeHpReason> internalGetValueMap() {
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
            return ChangeHpReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ChangeHpReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ChangeHpReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
