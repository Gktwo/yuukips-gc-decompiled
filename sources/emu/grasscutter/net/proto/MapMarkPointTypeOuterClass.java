package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkPointTypeOuterClass.class */
public final class MapMarkPointTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MapMarkPointType.proto*õ\u0001\n\u0010MapMarkPointType\u0012\u001b\n\u0017MAP_MARK_POINT_TYPE_NPC\u0010��\u0012\u001d\n\u0019MAP_MARK_POINT_TYPE_QUEST\u0010\u0001\u0012\u001f\n\u001bMAP_MARK_POINT_TYPE_SPECIAL\u0010\u0002\u0012\u001c\n\u0018MAP_MARK_POINT_TYPE_MINE\u0010\u0003\u0012\"\n\u001eMAP_MARK_POINT_TYPE_COLLECTION\u0010\u0004\u0012\u001f\n\u001bMAP_MARK_POINT_TYPE_MONSTER\u0010\u0005\u0012!\n\u001dMAP_MARK_POINT_TYPE_FISH_POOL\u0010\u0006B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MapMarkPointTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkPointTypeOuterClass$MapMarkPointType.class */
    public enum MapMarkPointType implements ProtocolMessageEnum {
        MAP_MARK_POINT_TYPE_NPC(0),
        MAP_MARK_POINT_TYPE_QUEST(1),
        MAP_MARK_POINT_TYPE_SPECIAL(2),
        MAP_MARK_POINT_TYPE_MINE(3),
        MAP_MARK_POINT_TYPE_COLLECTION(4),
        MAP_MARK_POINT_TYPE_MONSTER(5),
        MAP_MARK_POINT_TYPE_FISH_POOL(6),
        UNRECOGNIZED(-1);
        
        public static final int MAP_MARK_POINT_TYPE_NPC_VALUE = 0;
        public static final int MAP_MARK_POINT_TYPE_QUEST_VALUE = 1;
        public static final int MAP_MARK_POINT_TYPE_SPECIAL_VALUE = 2;
        public static final int MAP_MARK_POINT_TYPE_MINE_VALUE = 3;
        public static final int MAP_MARK_POINT_TYPE_COLLECTION_VALUE = 4;
        public static final int MAP_MARK_POINT_TYPE_MONSTER_VALUE = 5;
        public static final int MAP_MARK_POINT_TYPE_FISH_POOL_VALUE = 6;
        private static final Internal.EnumLiteMap<MapMarkPointType> internalValueMap = new Internal.EnumLiteMap<MapMarkPointType>() { // from class: emu.grasscutter.net.proto.MapMarkPointTypeOuterClass.MapMarkPointType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MapMarkPointType findValueByNumber(int number) {
                return MapMarkPointType.forNumber(number);
            }
        };
        private static final MapMarkPointType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MapMarkPointType valueOf(int value) {
            return forNumber(value);
        }

        public static MapMarkPointType forNumber(int value) {
            switch (value) {
                case 0:
                    return MAP_MARK_POINT_TYPE_NPC;
                case 1:
                    return MAP_MARK_POINT_TYPE_QUEST;
                case 2:
                    return MAP_MARK_POINT_TYPE_SPECIAL;
                case 3:
                    return MAP_MARK_POINT_TYPE_MINE;
                case 4:
                    return MAP_MARK_POINT_TYPE_COLLECTION;
                case 5:
                    return MAP_MARK_POINT_TYPE_MONSTER;
                case 6:
                    return MAP_MARK_POINT_TYPE_FISH_POOL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MapMarkPointType> internalGetValueMap() {
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
            return MapMarkPointTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MapMarkPointType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MapMarkPointType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
