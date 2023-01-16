package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkFromTypeOuterClass.class */
public final class MapMarkFromTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015MapMarkFromType.proto*l\n\u000fMapMarkFromType\u0012\u001b\n\u0017MAP_MARK_FROM_TYPE_NONE\u0010��\u0012\u001e\n\u001aMAP_MARK_FROM_TYPE_MONSTER\u0010\u0001\u0012\u001c\n\u0018MAP_MARK_FROM_TYPE_QUEST\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MapMarkFromTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkFromTypeOuterClass$MapMarkFromType.class */
    public enum MapMarkFromType implements ProtocolMessageEnum {
        MAP_MARK_FROM_TYPE_NONE(0),
        MAP_MARK_FROM_TYPE_MONSTER(1),
        MAP_MARK_FROM_TYPE_QUEST(2),
        UNRECOGNIZED(-1);
        
        public static final int MAP_MARK_FROM_TYPE_NONE_VALUE = 0;
        public static final int MAP_MARK_FROM_TYPE_MONSTER_VALUE = 1;
        public static final int MAP_MARK_FROM_TYPE_QUEST_VALUE = 2;
        private static final Internal.EnumLiteMap<MapMarkFromType> internalValueMap = new Internal.EnumLiteMap<MapMarkFromType>() { // from class: emu.grasscutter.net.proto.MapMarkFromTypeOuterClass.MapMarkFromType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MapMarkFromType findValueByNumber(int number) {
                return MapMarkFromType.forNumber(number);
            }
        };
        private static final MapMarkFromType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MapMarkFromType valueOf(int value) {
            return forNumber(value);
        }

        public static MapMarkFromType forNumber(int value) {
            switch (value) {
                case 0:
                    return MAP_MARK_FROM_TYPE_NONE;
                case 1:
                    return MAP_MARK_FROM_TYPE_MONSTER;
                case 2:
                    return MAP_MARK_FROM_TYPE_QUEST;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MapMarkFromType> internalGetValueMap() {
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
            return MapMarkFromTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MapMarkFromType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MapMarkFromType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
