package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropChangeReasonOuterClass.class */
public final class PropChangeReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016PropChangeReason.proto*\u0004\n\u0010PropChangeReason\u0012\u001b\n\u0017PROP_CHANGE_REASON_NONE\u0010��\u0012%\n!PROP_CHANGE_REASON_STATUE_RECOVER\u0010\u0001\u0012\"\n\u001ePROP_CHANGE_REASON_ENERGY_BALL\u0010\u0002\u0012\u001e\n\u001aPROP_CHANGE_REASON_ABILITY\u0010\u0003\u0012\u001e\n\u001aPROP_CHANGE_REASON_LEVELUP\u0010\u0004\u0012\u001b\n\u0017PROP_CHANGE_REASON_ITEM\u0010\u0005\u0012\"\n\u001ePROP_CHANGE_REASON_AVATAR_CARD\u0010\u0006\u0012#\n\u001fPROP_CHANGE_REASON_CITY_LEVELUP\u0010\u0007\u0012%\n!PROP_CHANGE_REASON_AVATAR_UPGRADE\u0010\b\u0012%\n!PROP_CHANGE_REASON_AVATAR_PROMOTE\u0010\t\u0012%\n!PROP_CHANGE_REASON_PLAYER_ADD_EXP\u0010\n\u0012#\n\u001fPROP_CHANGE_REASON_FINISH_QUEST\u0010\u000b\u0012\u0019\n\u0015PROP_CHANGE_REASON_GM\u0010\f\u00120\n,PROP_CHANGE_REASON_MANUAL_ADJUST_WORLD_LEVEL\u0010\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private PropChangeReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PropChangeReasonOuterClass$PropChangeReason.class */
    public enum PropChangeReason implements ProtocolMessageEnum {
        PROP_CHANGE_REASON_NONE(0),
        PROP_CHANGE_REASON_STATUE_RECOVER(1),
        PROP_CHANGE_REASON_ENERGY_BALL(2),
        PROP_CHANGE_REASON_ABILITY(3),
        PROP_CHANGE_REASON_LEVELUP(4),
        PROP_CHANGE_REASON_ITEM(5),
        PROP_CHANGE_REASON_AVATAR_CARD(6),
        PROP_CHANGE_REASON_CITY_LEVELUP(7),
        PROP_CHANGE_REASON_AVATAR_UPGRADE(8),
        PROP_CHANGE_REASON_AVATAR_PROMOTE(9),
        PROP_CHANGE_REASON_PLAYER_ADD_EXP(10),
        PROP_CHANGE_REASON_FINISH_QUEST(11),
        PROP_CHANGE_REASON_GM(12),
        PROP_CHANGE_REASON_MANUAL_ADJUST_WORLD_LEVEL(13),
        UNRECOGNIZED(-1);
        
        public static final int PROP_CHANGE_REASON_NONE_VALUE = 0;
        public static final int PROP_CHANGE_REASON_STATUE_RECOVER_VALUE = 1;
        public static final int PROP_CHANGE_REASON_ENERGY_BALL_VALUE = 2;
        public static final int PROP_CHANGE_REASON_ABILITY_VALUE = 3;
        public static final int PROP_CHANGE_REASON_LEVELUP_VALUE = 4;
        public static final int PROP_CHANGE_REASON_ITEM_VALUE = 5;
        public static final int PROP_CHANGE_REASON_AVATAR_CARD_VALUE = 6;
        public static final int PROP_CHANGE_REASON_CITY_LEVELUP_VALUE = 7;
        public static final int PROP_CHANGE_REASON_AVATAR_UPGRADE_VALUE = 8;
        public static final int PROP_CHANGE_REASON_AVATAR_PROMOTE_VALUE = 9;
        public static final int PROP_CHANGE_REASON_PLAYER_ADD_EXP_VALUE = 10;
        public static final int PROP_CHANGE_REASON_FINISH_QUEST_VALUE = 11;
        public static final int PROP_CHANGE_REASON_GM_VALUE = 12;
        public static final int PROP_CHANGE_REASON_MANUAL_ADJUST_WORLD_LEVEL_VALUE = 13;
        private static final Internal.EnumLiteMap<PropChangeReason> internalValueMap = new Internal.EnumLiteMap<PropChangeReason>() { // from class: emu.grasscutter.net.proto.PropChangeReasonOuterClass.PropChangeReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PropChangeReason findValueByNumber(int number) {
                return PropChangeReason.forNumber(number);
            }
        };
        private static final PropChangeReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static PropChangeReason valueOf(int value) {
            return forNumber(value);
        }

        public static PropChangeReason forNumber(int value) {
            switch (value) {
                case 0:
                    return PROP_CHANGE_REASON_NONE;
                case 1:
                    return PROP_CHANGE_REASON_STATUE_RECOVER;
                case 2:
                    return PROP_CHANGE_REASON_ENERGY_BALL;
                case 3:
                    return PROP_CHANGE_REASON_ABILITY;
                case 4:
                    return PROP_CHANGE_REASON_LEVELUP;
                case 5:
                    return PROP_CHANGE_REASON_ITEM;
                case 6:
                    return PROP_CHANGE_REASON_AVATAR_CARD;
                case 7:
                    return PROP_CHANGE_REASON_CITY_LEVELUP;
                case 8:
                    return PROP_CHANGE_REASON_AVATAR_UPGRADE;
                case 9:
                    return PROP_CHANGE_REASON_AVATAR_PROMOTE;
                case 10:
                    return PROP_CHANGE_REASON_PLAYER_ADD_EXP;
                case 11:
                    return PROP_CHANGE_REASON_FINISH_QUEST;
                case 12:
                    return PROP_CHANGE_REASON_GM;
                case 13:
                    return PROP_CHANGE_REASON_MANUAL_ADJUST_WORLD_LEVEL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<PropChangeReason> internalGetValueMap() {
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
            return PropChangeReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static PropChangeReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        PropChangeReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
