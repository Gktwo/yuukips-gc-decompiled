package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VirtualItemOuterClass.class */
public final class VirtualItemOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011VirtualItem.proto*\u0015\n\u000bVirtualItem\u0012\u001d\n\u0019VIRTUAL_ITEM_VIRTUAL_NONE\u0010��\u0012#\n\u001fVIRTUAL_ITEM_VIRTUAL_AVATAR_EXP\u0010e\u0012#\n\u001fVIRTUAL_ITEM_VIRTUAL_PLAYER_EXP\u0010f\u0012#\n\u001fVIRTUAL_ITEM_VIRTUAL_FETTER_EXP\u0010i\u0012\u001e\n\u001aVIRTUAL_ITEM_VIRTUAL_RESIN\u0010j\u0012&\n\"VIRTUAL_ITEM_VIRTUAL_LEGENDARY_KEY\u0010k\u0012'\n#VIRTUAL_ITEM_VIRTUAL_ASTER_PROGRESS\u0010l\u0012%\n!VIRTUAL_ITEM_VIRTUAL_ASTER_CREDIT\u0010m\u0012$\n VIRTUAL_ITEM_VIRTUAL_ASTER_TOKEN\u0010n\u0012+\n'VIRTUAL_ITEM_VIRTUAL_SHIMMERING_ESSENCE\u0010o\u0012%\n!VIRTUAL_ITEM_VIRTUAL_WARM_ESSENCE\u0010p\u0012)\n%VIRTUAL_ITEM_VIRTUAL_WONDROUS_ESSENCE\u0010q\u0012+\n'VIRTUAL_ITEM_VIRTUAL_TREASURE_MAP_TOKEN\u0010r\u0012&\n\"VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_COIN\u0010s\u0012,\n(VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_POPULARITY\u0010t\u0012(\n$VIRTUAL_ITEM_VIRTUAL_MECHANICUS_COIN\u0010u\u0012*\n&VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_CREDIT\u0010v\u0012)\n%VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_TOKEN\u0010w\u0012*\n&VIRTUAL_ITEM_VIRTUAL_WATER_SPIRIT_COIN\u0010x\u0012!\n\u001dVIRTUAL_ITEM_VIRTUAL_HOME_EXP\u0010y\u0012.\n*VIRTUAL_ITEM_VIRTUAL_CHANNELLER_SLAB_TOKEN\u0010z\u0012+\n'VIRTUAL_ITEM_VIRTUAL_HIDE_AND_SEEK_COIN\u0010{\u0012/\n+VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_DRAFT_WOOD\u0010|\u00123\n/VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_MINI_HARPASTUM\u0010}\u0012.\n*VIRTUAL_ITEM_VIRTUAL_BOUNCE_CONJURING_COIN\u0010~\u0012*\n&VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_A\u0010\u0012+\n&VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_B\u0010\u0001\u0012#\n\u001eVIRTUAL_ITEM_VIRTUAL_CHESS_EXP\u0010\u0001\u0012$\n\u001fVIRTUAL_ITEM_VIRTUAL_CHESS_COIN\u0010\u0001\u0012.\n)VIRTUAL_ITEM_VIRTUAL_LUNA_RITE_ATMOSPHERE\u0010\u0001\u0012*\n%VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_A\u0010\u0001\u0012*\n%VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_B\u0010\u0001\u0012*\n%VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_C\u0010\u0001\u0012,\n'VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_A\u0010\u0001\u0012,\n'VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_B\u0010\u0001\u0012-\n(VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_A\u0010\u0001\u0012-\n(VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_B\u0010\u0001\u0012-\n(VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_C\u0010\u0001\u0012*\n%VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_COIN\u0010\u0001\u0012-\n(VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_V2_COIN\u0010\u0001\u00122\n-VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_DUNGEON_COIN\u0010\u0001\u00121\n,VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_A\u0010\u0001\u00121\n,VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_B\u0010\u0001\u0012.\n)VIRTUAL_ITEM_VIRTUAL_TREASURE_SEELIE_COIN\u0010\u0001\u0012,\n'VIRTUAL_ITEM_VIRTUAL_VINTAGE_POPULARITY\u0010\u0001\u0012!\n\u001cVIRTUAL_ITEM_VIRTUAL_GCG_EXP\u0010\u0001\u0012/\n*VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_A\u0010\u0001\u0012/\n*VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_B\u0010\u0001\u0012/\n*VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_C\u0010\u0001\u00125\n0VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_CAPTURE_COIN\u0010\u0001\u00126\n1VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_TRAINING_COIN\u0010\u0001\u00122\n-VIRTUAL_ITEM_VIRTUAL_EFFIGY_CHALLENGE_V2_COIN\u0010\u0001\u0012,\n'VIRTUAL_ITEM_VIRTUAL_BRICK_BREAKER_COIN\u0010\u0001\u0012\u001f\n\u001aVIRTUAL_ITEM_VIRTUAL_HCOIN\u0010É\u0001\u0012\u001f\n\u001aVIRTUAL_ITEM_VIRTUAL_SCOIN\u0010Ê\u0001\u0012\u001f\n\u001aVIRTUAL_ITEM_VIRTUAL_MCOIN\u0010Ë\u0001\u0012#\n\u001eVIRTUAL_ITEM_VIRTUAL_HOME_COIN\u0010Ì\u0001\u0012\"\n\u001dVIRTUAL_ITEM_VIRTUAL_GCG_COIN\u0010Í\u0001\u0012,\n'VIRTUAL_ITEM_VIRTUAL_INAZUMA_REPUTATION\u0010º\u0002\u0012+\n&VIRTUAL_ITEM_VIRTUAL_MENGDE_REPUTATION\u0010»\u0002\u0012+\n&VIRTUAL_ITEM_VIRTUAL_SUMERU_REPUTATION\u0010¼\u0002\u0012*\n%VIRTUAL_ITEM_VIRTUAL_LIYUE_REPUTATION\u0010½\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private VirtualItemOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VirtualItemOuterClass$VirtualItem.class */
    public enum VirtualItem implements ProtocolMessageEnum {
        VIRTUAL_ITEM_VIRTUAL_NONE(0),
        VIRTUAL_ITEM_VIRTUAL_AVATAR_EXP(101),
        VIRTUAL_ITEM_VIRTUAL_PLAYER_EXP(102),
        VIRTUAL_ITEM_VIRTUAL_FETTER_EXP(105),
        VIRTUAL_ITEM_VIRTUAL_RESIN(106),
        VIRTUAL_ITEM_VIRTUAL_LEGENDARY_KEY(107),
        VIRTUAL_ITEM_VIRTUAL_ASTER_PROGRESS(108),
        VIRTUAL_ITEM_VIRTUAL_ASTER_CREDIT(109),
        VIRTUAL_ITEM_VIRTUAL_ASTER_TOKEN(110),
        VIRTUAL_ITEM_VIRTUAL_SHIMMERING_ESSENCE(111),
        VIRTUAL_ITEM_VIRTUAL_WARM_ESSENCE(112),
        VIRTUAL_ITEM_VIRTUAL_WONDROUS_ESSENCE(113),
        VIRTUAL_ITEM_VIRTUAL_TREASURE_MAP_TOKEN(114),
        VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_COIN(115),
        VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_POPULARITY(116),
        VIRTUAL_ITEM_VIRTUAL_MECHANICUS_COIN(117),
        VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_CREDIT(118),
        VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_TOKEN(119),
        VIRTUAL_ITEM_VIRTUAL_WATER_SPIRIT_COIN(120),
        VIRTUAL_ITEM_VIRTUAL_HOME_EXP(121),
        VIRTUAL_ITEM_VIRTUAL_CHANNELLER_SLAB_TOKEN(122),
        VIRTUAL_ITEM_VIRTUAL_HIDE_AND_SEEK_COIN(123),
        VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_DRAFT_WOOD(124),
        VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_MINI_HARPASTUM(125),
        VIRTUAL_ITEM_VIRTUAL_BOUNCE_CONJURING_COIN(126),
        VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_A(127),
        VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_B(128),
        VIRTUAL_ITEM_VIRTUAL_CHESS_EXP(129),
        VIRTUAL_ITEM_VIRTUAL_CHESS_COIN(130),
        VIRTUAL_ITEM_VIRTUAL_LUNA_RITE_ATMOSPHERE(131),
        VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_A(132),
        VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_B(133),
        VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_C(134),
        VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_A(135),
        VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_B(136),
        VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_A(137),
        VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_B(138),
        VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_C(139),
        VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_COIN(140),
        VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_V2_COIN(141),
        VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_DUNGEON_COIN(142),
        VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_A(143),
        VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_B(144),
        VIRTUAL_ITEM_VIRTUAL_TREASURE_SEELIE_COIN(145),
        VIRTUAL_ITEM_VIRTUAL_VINTAGE_POPULARITY(147),
        VIRTUAL_ITEM_VIRTUAL_GCG_EXP(146),
        VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_A(148),
        VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_B(149),
        VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_C(150),
        VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_CAPTURE_COIN(151),
        VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_TRAINING_COIN(152),
        VIRTUAL_ITEM_VIRTUAL_EFFIGY_CHALLENGE_V2_COIN(153),
        VIRTUAL_ITEM_VIRTUAL_BRICK_BREAKER_COIN(155),
        VIRTUAL_ITEM_VIRTUAL_HCOIN(201),
        VIRTUAL_ITEM_VIRTUAL_SCOIN(202),
        VIRTUAL_ITEM_VIRTUAL_MCOIN(203),
        VIRTUAL_ITEM_VIRTUAL_HOME_COIN(204),
        VIRTUAL_ITEM_VIRTUAL_GCG_COIN(205),
        VIRTUAL_ITEM_VIRTUAL_INAZUMA_REPUTATION(314),
        VIRTUAL_ITEM_VIRTUAL_MENGDE_REPUTATION(315),
        VIRTUAL_ITEM_VIRTUAL_SUMERU_REPUTATION(316),
        VIRTUAL_ITEM_VIRTUAL_LIYUE_REPUTATION(317),
        UNRECOGNIZED(-1);
        
        public static final int VIRTUAL_ITEM_VIRTUAL_NONE_VALUE = 0;
        public static final int VIRTUAL_ITEM_VIRTUAL_AVATAR_EXP_VALUE = 101;
        public static final int VIRTUAL_ITEM_VIRTUAL_PLAYER_EXP_VALUE = 102;
        public static final int VIRTUAL_ITEM_VIRTUAL_FETTER_EXP_VALUE = 105;
        public static final int VIRTUAL_ITEM_VIRTUAL_RESIN_VALUE = 106;
        public static final int VIRTUAL_ITEM_VIRTUAL_LEGENDARY_KEY_VALUE = 107;
        public static final int VIRTUAL_ITEM_VIRTUAL_ASTER_PROGRESS_VALUE = 108;
        public static final int VIRTUAL_ITEM_VIRTUAL_ASTER_CREDIT_VALUE = 109;
        public static final int VIRTUAL_ITEM_VIRTUAL_ASTER_TOKEN_VALUE = 110;
        public static final int VIRTUAL_ITEM_VIRTUAL_SHIMMERING_ESSENCE_VALUE = 111;
        public static final int VIRTUAL_ITEM_VIRTUAL_WARM_ESSENCE_VALUE = 112;
        public static final int VIRTUAL_ITEM_VIRTUAL_WONDROUS_ESSENCE_VALUE = 113;
        public static final int VIRTUAL_ITEM_VIRTUAL_TREASURE_MAP_TOKEN_VALUE = 114;
        public static final int VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_COIN_VALUE = 115;
        public static final int VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_POPULARITY_VALUE = 116;
        public static final int VIRTUAL_ITEM_VIRTUAL_MECHANICUS_COIN_VALUE = 117;
        public static final int VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_CREDIT_VALUE = 118;
        public static final int VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_TOKEN_VALUE = 119;
        public static final int VIRTUAL_ITEM_VIRTUAL_WATER_SPIRIT_COIN_VALUE = 120;
        public static final int VIRTUAL_ITEM_VIRTUAL_HOME_EXP_VALUE = 121;
        public static final int VIRTUAL_ITEM_VIRTUAL_CHANNELLER_SLAB_TOKEN_VALUE = 122;
        public static final int VIRTUAL_ITEM_VIRTUAL_HIDE_AND_SEEK_COIN_VALUE = 123;
        public static final int VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_DRAFT_WOOD_VALUE = 124;
        public static final int VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_MINI_HARPASTUM_VALUE = 125;
        public static final int VIRTUAL_ITEM_VIRTUAL_BOUNCE_CONJURING_COIN_VALUE = 126;
        public static final int VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_A_VALUE = 127;
        public static final int VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_B_VALUE = 128;
        public static final int VIRTUAL_ITEM_VIRTUAL_CHESS_EXP_VALUE = 129;
        public static final int VIRTUAL_ITEM_VIRTUAL_CHESS_COIN_VALUE = 130;
        public static final int VIRTUAL_ITEM_VIRTUAL_LUNA_RITE_ATMOSPHERE_VALUE = 131;
        public static final int VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_A_VALUE = 132;
        public static final int VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_B_VALUE = 133;
        public static final int VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_C_VALUE = 134;
        public static final int VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_A_VALUE = 135;
        public static final int VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_B_VALUE = 136;
        public static final int VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_A_VALUE = 137;
        public static final int VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_B_VALUE = 138;
        public static final int VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_C_VALUE = 139;
        public static final int VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_COIN_VALUE = 140;
        public static final int VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_V2_COIN_VALUE = 141;
        public static final int VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_DUNGEON_COIN_VALUE = 142;
        public static final int VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_A_VALUE = 143;
        public static final int VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_B_VALUE = 144;
        public static final int VIRTUAL_ITEM_VIRTUAL_TREASURE_SEELIE_COIN_VALUE = 145;
        public static final int VIRTUAL_ITEM_VIRTUAL_VINTAGE_POPULARITY_VALUE = 147;
        public static final int VIRTUAL_ITEM_VIRTUAL_GCG_EXP_VALUE = 146;
        public static final int VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_A_VALUE = 148;
        public static final int VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_B_VALUE = 149;
        public static final int VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_C_VALUE = 150;
        public static final int VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_CAPTURE_COIN_VALUE = 151;
        public static final int VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_TRAINING_COIN_VALUE = 152;
        public static final int VIRTUAL_ITEM_VIRTUAL_EFFIGY_CHALLENGE_V2_COIN_VALUE = 153;
        public static final int VIRTUAL_ITEM_VIRTUAL_BRICK_BREAKER_COIN_VALUE = 155;
        public static final int VIRTUAL_ITEM_VIRTUAL_HCOIN_VALUE = 201;
        public static final int VIRTUAL_ITEM_VIRTUAL_SCOIN_VALUE = 202;
        public static final int VIRTUAL_ITEM_VIRTUAL_MCOIN_VALUE = 203;
        public static final int VIRTUAL_ITEM_VIRTUAL_HOME_COIN_VALUE = 204;
        public static final int VIRTUAL_ITEM_VIRTUAL_GCG_COIN_VALUE = 205;
        public static final int VIRTUAL_ITEM_VIRTUAL_INAZUMA_REPUTATION_VALUE = 314;
        public static final int VIRTUAL_ITEM_VIRTUAL_MENGDE_REPUTATION_VALUE = 315;
        public static final int VIRTUAL_ITEM_VIRTUAL_SUMERU_REPUTATION_VALUE = 316;
        public static final int VIRTUAL_ITEM_VIRTUAL_LIYUE_REPUTATION_VALUE = 317;
        private static final Internal.EnumLiteMap<VirtualItem> internalValueMap = new Internal.EnumLiteMap<VirtualItem>() { // from class: emu.grasscutter.net.proto.VirtualItemOuterClass.VirtualItem.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public VirtualItem findValueByNumber(int number) {
                return VirtualItem.forNumber(number);
            }
        };
        private static final VirtualItem[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static VirtualItem valueOf(int value) {
            return forNumber(value);
        }

        public static VirtualItem forNumber(int value) {
            switch (value) {
                case 0:
                    return VIRTUAL_ITEM_VIRTUAL_NONE;
                case 101:
                    return VIRTUAL_ITEM_VIRTUAL_AVATAR_EXP;
                case 102:
                    return VIRTUAL_ITEM_VIRTUAL_PLAYER_EXP;
                case 105:
                    return VIRTUAL_ITEM_VIRTUAL_FETTER_EXP;
                case 106:
                    return VIRTUAL_ITEM_VIRTUAL_RESIN;
                case 107:
                    return VIRTUAL_ITEM_VIRTUAL_LEGENDARY_KEY;
                case 108:
                    return VIRTUAL_ITEM_VIRTUAL_ASTER_PROGRESS;
                case 109:
                    return VIRTUAL_ITEM_VIRTUAL_ASTER_CREDIT;
                case 110:
                    return VIRTUAL_ITEM_VIRTUAL_ASTER_TOKEN;
                case 111:
                    return VIRTUAL_ITEM_VIRTUAL_SHIMMERING_ESSENCE;
                case 112:
                    return VIRTUAL_ITEM_VIRTUAL_WARM_ESSENCE;
                case 113:
                    return VIRTUAL_ITEM_VIRTUAL_WONDROUS_ESSENCE;
                case 114:
                    return VIRTUAL_ITEM_VIRTUAL_TREASURE_MAP_TOKEN;
                case 115:
                    return VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_COIN;
                case 116:
                    return VIRTUAL_ITEM_VIRTUAL_SEA_LAMP_POPULARITY;
                case 117:
                    return VIRTUAL_ITEM_VIRTUAL_MECHANICUS_COIN;
                case 118:
                    return VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_CREDIT;
                case 119:
                    return VIRTUAL_ITEM_VIRTUAL_FLEUR_FAIR_TOKEN;
                case 120:
                    return VIRTUAL_ITEM_VIRTUAL_WATER_SPIRIT_COIN;
                case 121:
                    return VIRTUAL_ITEM_VIRTUAL_HOME_EXP;
                case 122:
                    return VIRTUAL_ITEM_VIRTUAL_CHANNELLER_SLAB_TOKEN;
                case 123:
                    return VIRTUAL_ITEM_VIRTUAL_HIDE_AND_SEEK_COIN;
                case 124:
                    return VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_DRAFT_WOOD;
                case 125:
                    return VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_MINI_HARPASTUM;
                case 126:
                    return VIRTUAL_ITEM_VIRTUAL_BOUNCE_CONJURING_COIN;
                case 127:
                    return VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_A;
                case 128:
                    return VIRTUAL_ITEM_VIRTUAL_BLITZ_RUSH_COIN_B;
                case 129:
                    return VIRTUAL_ITEM_VIRTUAL_CHESS_EXP;
                case 130:
                    return VIRTUAL_ITEM_VIRTUAL_CHESS_COIN;
                case 131:
                    return VIRTUAL_ITEM_VIRTUAL_LUNA_RITE_ATMOSPHERE;
                case 132:
                    return VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_A;
                case 133:
                    return VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_B;
                case 134:
                    return VIRTUAL_ITEM_VIRTUAL_ROGUELIKE_COIN_C;
                case 135:
                    return VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_A;
                case 136:
                    return VIRTUAL_ITEM_VIRTUAL_WINTER_CAMP_COIN_B;
                case 137:
                    return VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_A;
                case 138:
                    return VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_B;
                case 139:
                    return VIRTUAL_ITEM_VIRTUAL_LANTERN_RITE_COIN_C;
                case 140:
                    return VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_COIN;
                case 141:
                    return VIRTUAL_ITEM_VIRTUAL_SUMMER_TIME_V2_COIN;
                case 142:
                    return VIRTUAL_ITEM_VIRTUAL_ROGUE_DIARY_DUNGEON_COIN;
                case 143:
                    return VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_A;
                case 144:
                    return VIRTUAL_ITEM_VIRTUAL_GRAVEN_INNOCENCE_COIN_B;
                case 145:
                    return VIRTUAL_ITEM_VIRTUAL_TREASURE_SEELIE_COIN;
                case 146:
                    return VIRTUAL_ITEM_VIRTUAL_GCG_EXP;
                case 147:
                    return VIRTUAL_ITEM_VIRTUAL_VINTAGE_POPULARITY;
                case 148:
                    return VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_A;
                case 149:
                    return VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_B;
                case 150:
                    return VIRTUAL_ITEM_VIRTUAL_VINTAGE_MARKET_COIN_C;
                case 151:
                    return VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_CAPTURE_COIN;
                case 152:
                    return VIRTUAL_ITEM_VIRTUAL_FUNGUS_FIGHTER_TRAINING_COIN;
                case 153:
                    return VIRTUAL_ITEM_VIRTUAL_EFFIGY_CHALLENGE_V2_COIN;
                case 155:
                    return VIRTUAL_ITEM_VIRTUAL_BRICK_BREAKER_COIN;
                case 201:
                    return VIRTUAL_ITEM_VIRTUAL_HCOIN;
                case 202:
                    return VIRTUAL_ITEM_VIRTUAL_SCOIN;
                case 203:
                    return VIRTUAL_ITEM_VIRTUAL_MCOIN;
                case 204:
                    return VIRTUAL_ITEM_VIRTUAL_HOME_COIN;
                case 205:
                    return VIRTUAL_ITEM_VIRTUAL_GCG_COIN;
                case 314:
                    return VIRTUAL_ITEM_VIRTUAL_INAZUMA_REPUTATION;
                case 315:
                    return VIRTUAL_ITEM_VIRTUAL_MENGDE_REPUTATION;
                case 316:
                    return VIRTUAL_ITEM_VIRTUAL_SUMERU_REPUTATION;
                case 317:
                    return VIRTUAL_ITEM_VIRTUAL_LIYUE_REPUTATION;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<VirtualItem> internalGetValueMap() {
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
            return VirtualItemOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static VirtualItem valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        VirtualItem(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
