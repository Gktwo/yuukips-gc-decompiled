package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProtEntityTypeOuterClass.class */
public final class ProtEntityTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ProtEntityType.proto*Ñ\u0003\n\u000eProtEntityType\u0012\u0019\n\u0015PROT_ENTITY_TYPE_NONE\u0010��\u0012\u001b\n\u0017PROT_ENTITY_TYPE_AVATAR\u0010\u0001\u0012\u001c\n\u0018PROT_ENTITY_TYPE_MONSTER\u0010\u0002\u0012\u0018\n\u0014PROT_ENTITY_TYPE_NPC\u0010\u0003\u0012\u001b\n\u0017PROT_ENTITY_TYPE_GADGET\u0010\u0004\u0012\u001b\n\u0017PROT_ENTITY_TYPE_REGION\u0010\u0005\u0012\u001b\n\u0017PROT_ENTITY_TYPE_WEAPON\u0010\u0006\u0012\u001c\n\u0018PROT_ENTITY_TYPE_WEATHER\u0010\u0007\u0012\u001a\n\u0016PROT_ENTITY_TYPE_SCENE\u0010\b\u0012\u0019\n\u0015PROT_ENTITY_TYPE_TEAM\u0010\t\u0012#\n\u001fPROT_ENTITY_TYPE_MASSIVE_ENTITY\u0010\n\u0012\u001d\n\u0019PROT_ENTITY_TYPE_MP_LEVEL\u0010\u000b\u0012%\n!PROT_ENTITY_TYPE_PLAY_TEAM_ENTITY\u0010\f\u0012\u001e\n\u001aPROT_ENTITY_TYPE_EYE_POINT\u0010\r\u0012\u0018\n\u0014PROT_ENTITY_TYPE_MAX\u0010\u000eB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ProtEntityTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ProtEntityTypeOuterClass$ProtEntityType.class */
    public enum ProtEntityType implements ProtocolMessageEnum {
        PROT_ENTITY_TYPE_NONE(0),
        PROT_ENTITY_TYPE_AVATAR(1),
        PROT_ENTITY_TYPE_MONSTER(2),
        PROT_ENTITY_TYPE_NPC(3),
        PROT_ENTITY_TYPE_GADGET(4),
        PROT_ENTITY_TYPE_REGION(5),
        PROT_ENTITY_TYPE_WEAPON(6),
        PROT_ENTITY_TYPE_WEATHER(7),
        PROT_ENTITY_TYPE_SCENE(8),
        PROT_ENTITY_TYPE_TEAM(9),
        PROT_ENTITY_TYPE_MASSIVE_ENTITY(10),
        PROT_ENTITY_TYPE_MP_LEVEL(11),
        PROT_ENTITY_TYPE_PLAY_TEAM_ENTITY(12),
        PROT_ENTITY_TYPE_EYE_POINT(13),
        PROT_ENTITY_TYPE_MAX(14),
        UNRECOGNIZED(-1);
        
        public static final int PROT_ENTITY_TYPE_NONE_VALUE = 0;
        public static final int PROT_ENTITY_TYPE_AVATAR_VALUE = 1;
        public static final int PROT_ENTITY_TYPE_MONSTER_VALUE = 2;
        public static final int PROT_ENTITY_TYPE_NPC_VALUE = 3;
        public static final int PROT_ENTITY_TYPE_GADGET_VALUE = 4;
        public static final int PROT_ENTITY_TYPE_REGION_VALUE = 5;
        public static final int PROT_ENTITY_TYPE_WEAPON_VALUE = 6;
        public static final int PROT_ENTITY_TYPE_WEATHER_VALUE = 7;
        public static final int PROT_ENTITY_TYPE_SCENE_VALUE = 8;
        public static final int PROT_ENTITY_TYPE_TEAM_VALUE = 9;
        public static final int PROT_ENTITY_TYPE_MASSIVE_ENTITY_VALUE = 10;
        public static final int PROT_ENTITY_TYPE_MP_LEVEL_VALUE = 11;
        public static final int PROT_ENTITY_TYPE_PLAY_TEAM_ENTITY_VALUE = 12;
        public static final int PROT_ENTITY_TYPE_EYE_POINT_VALUE = 13;
        public static final int PROT_ENTITY_TYPE_MAX_VALUE = 14;
        private static final Internal.EnumLiteMap<ProtEntityType> internalValueMap = new Internal.EnumLiteMap<ProtEntityType>() { // from class: emu.grasscutter.net.proto.ProtEntityTypeOuterClass.ProtEntityType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ProtEntityType findValueByNumber(int number) {
                return ProtEntityType.forNumber(number);
            }
        };
        private static final ProtEntityType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ProtEntityType valueOf(int value) {
            return forNumber(value);
        }

        public static ProtEntityType forNumber(int value) {
            switch (value) {
                case 0:
                    return PROT_ENTITY_TYPE_NONE;
                case 1:
                    return PROT_ENTITY_TYPE_AVATAR;
                case 2:
                    return PROT_ENTITY_TYPE_MONSTER;
                case 3:
                    return PROT_ENTITY_TYPE_NPC;
                case 4:
                    return PROT_ENTITY_TYPE_GADGET;
                case 5:
                    return PROT_ENTITY_TYPE_REGION;
                case 6:
                    return PROT_ENTITY_TYPE_WEAPON;
                case 7:
                    return PROT_ENTITY_TYPE_WEATHER;
                case 8:
                    return PROT_ENTITY_TYPE_SCENE;
                case 9:
                    return PROT_ENTITY_TYPE_TEAM;
                case 10:
                    return PROT_ENTITY_TYPE_MASSIVE_ENTITY;
                case 11:
                    return PROT_ENTITY_TYPE_MP_LEVEL;
                case 12:
                    return PROT_ENTITY_TYPE_PLAY_TEAM_ENTITY;
                case 13:
                    return PROT_ENTITY_TYPE_EYE_POINT;
                case 14:
                    return PROT_ENTITY_TYPE_MAX;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ProtEntityType> internalGetValueMap() {
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
            return ProtEntityTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ProtEntityType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ProtEntityType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
