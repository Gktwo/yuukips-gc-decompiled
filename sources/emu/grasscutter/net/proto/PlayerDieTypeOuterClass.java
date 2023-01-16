package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDieTypeOuterClass.class */
public final class PlayerDieTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013PlayerDieType.proto*\u0002\n\rPlayerDieType\u0012\u0018\n\u0014PLAYER_DIE_TYPE_NONE\u0010��\u0012#\n\u001fPLAYER_DIE_TYPE_KILL_BY_MONSTER\u0010\u0001\u0012 \n\u001cPLAYER_DIE_TYPE_KILL_BY_GEAR\u0010\u0002\u0012\u0018\n\u0014PLAYER_DIE_TYPE_FALL\u0010\u0003\u0012\u0019\n\u0015PLAYER_DIE_TYPE_DRAWN\u0010\u0004\u0012\u0019\n\u0015PLAYER_DIE_TYPE_ABYSS\u0010\u0005\u0012\u0016\n\u0012PLAYER_DIE_TYPE_GM\u0010\u0006\u0012 \n\u001cPLAYER_DIE_TYPE_CLIMATE_COLD\u0010\u0007\u0012\"\n\u001ePLAYER_DIE_TYPE_STORM_LIGHTING\u0010\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private PlayerDieTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerDieTypeOuterClass$PlayerDieType.class */
    public enum PlayerDieType implements ProtocolMessageEnum {
        PLAYER_DIE_TYPE_NONE(0),
        PLAYER_DIE_TYPE_KILL_BY_MONSTER(1),
        PLAYER_DIE_TYPE_KILL_BY_GEAR(2),
        PLAYER_DIE_TYPE_FALL(3),
        PLAYER_DIE_TYPE_DRAWN(4),
        PLAYER_DIE_TYPE_ABYSS(5),
        PLAYER_DIE_TYPE_GM(6),
        PLAYER_DIE_TYPE_CLIMATE_COLD(7),
        PLAYER_DIE_TYPE_STORM_LIGHTING(8),
        UNRECOGNIZED(-1);
        
        public static final int PLAYER_DIE_TYPE_NONE_VALUE = 0;
        public static final int PLAYER_DIE_TYPE_KILL_BY_MONSTER_VALUE = 1;
        public static final int PLAYER_DIE_TYPE_KILL_BY_GEAR_VALUE = 2;
        public static final int PLAYER_DIE_TYPE_FALL_VALUE = 3;
        public static final int PLAYER_DIE_TYPE_DRAWN_VALUE = 4;
        public static final int PLAYER_DIE_TYPE_ABYSS_VALUE = 5;
        public static final int PLAYER_DIE_TYPE_GM_VALUE = 6;
        public static final int PLAYER_DIE_TYPE_CLIMATE_COLD_VALUE = 7;
        public static final int PLAYER_DIE_TYPE_STORM_LIGHTING_VALUE = 8;
        private static final Internal.EnumLiteMap<PlayerDieType> internalValueMap = new Internal.EnumLiteMap<PlayerDieType>() { // from class: emu.grasscutter.net.proto.PlayerDieTypeOuterClass.PlayerDieType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PlayerDieType findValueByNumber(int number) {
                return PlayerDieType.forNumber(number);
            }
        };
        private static final PlayerDieType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static PlayerDieType valueOf(int value) {
            return forNumber(value);
        }

        public static PlayerDieType forNumber(int value) {
            switch (value) {
                case 0:
                    return PLAYER_DIE_TYPE_NONE;
                case 1:
                    return PLAYER_DIE_TYPE_KILL_BY_MONSTER;
                case 2:
                    return PLAYER_DIE_TYPE_KILL_BY_GEAR;
                case 3:
                    return PLAYER_DIE_TYPE_FALL;
                case 4:
                    return PLAYER_DIE_TYPE_DRAWN;
                case 5:
                    return PLAYER_DIE_TYPE_ABYSS;
                case 6:
                    return PLAYER_DIE_TYPE_GM;
                case 7:
                    return PLAYER_DIE_TYPE_CLIMATE_COLD;
                case 8:
                    return PLAYER_DIE_TYPE_STORM_LIGHTING;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<PlayerDieType> internalGetValueMap() {
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
            return PlayerDieTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static PlayerDieType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        PlayerDieType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
