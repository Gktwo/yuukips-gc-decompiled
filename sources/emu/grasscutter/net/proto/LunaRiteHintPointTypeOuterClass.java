package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintPointTypeOuterClass.class */
public final class LunaRiteHintPointTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bLunaRiteHintPointType.proto*\u0001\n\u0015LunaRiteHintPointType\u0012\"\n\u001eLUNA_RITE_HINT_POINT_TYPE_NONE\u0010��\u0012\"\n\u001eLUNA_RITE_HINT_POINT_TYPE_RUNE\u0010\u0001\u0012#\n\u001fLUNA_RITE_HINT_POINT_TYPE_CHEST\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private LunaRiteHintPointTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintPointTypeOuterClass$LunaRiteHintPointType.class */
    public enum LunaRiteHintPointType implements ProtocolMessageEnum {
        LUNA_RITE_HINT_POINT_TYPE_NONE(0),
        LUNA_RITE_HINT_POINT_TYPE_RUNE(1),
        LUNA_RITE_HINT_POINT_TYPE_CHEST(2),
        UNRECOGNIZED(-1);
        
        public static final int LUNA_RITE_HINT_POINT_TYPE_NONE_VALUE = 0;
        public static final int LUNA_RITE_HINT_POINT_TYPE_RUNE_VALUE = 1;
        public static final int LUNA_RITE_HINT_POINT_TYPE_CHEST_VALUE = 2;
        private static final Internal.EnumLiteMap<LunaRiteHintPointType> internalValueMap = new Internal.EnumLiteMap<LunaRiteHintPointType>() { // from class: emu.grasscutter.net.proto.LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LunaRiteHintPointType findValueByNumber(int number) {
                return LunaRiteHintPointType.forNumber(number);
            }
        };
        private static final LunaRiteHintPointType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static LunaRiteHintPointType valueOf(int value) {
            return forNumber(value);
        }

        public static LunaRiteHintPointType forNumber(int value) {
            switch (value) {
                case 0:
                    return LUNA_RITE_HINT_POINT_TYPE_NONE;
                case 1:
                    return LUNA_RITE_HINT_POINT_TYPE_RUNE;
                case 2:
                    return LUNA_RITE_HINT_POINT_TYPE_CHEST;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LunaRiteHintPointType> internalGetValueMap() {
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
            return LunaRiteHintPointTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static LunaRiteHintPointType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        LunaRiteHintPointType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
