package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintStatusTypeOuterClass.class */
public final class LunaRiteHintStatusTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cLunaRiteHintStatusType.proto*\u0001\n\u0016LunaRiteHintStatusType\u0012&\n\"LUNA_RITE_HINT_STATUS_TYPE_DEFAULT\u0010��\u0012'\n#LUNA_RITE_HINT_STATUS_TYPE_NO_COUNT\u0010\u0001\u0012%\n!LUNA_RITE_HINT_STATUS_TYPE_FINISH\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private LunaRiteHintStatusTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintStatusTypeOuterClass$LunaRiteHintStatusType.class */
    public enum LunaRiteHintStatusType implements ProtocolMessageEnum {
        LUNA_RITE_HINT_STATUS_TYPE_DEFAULT(0),
        LUNA_RITE_HINT_STATUS_TYPE_NO_COUNT(1),
        LUNA_RITE_HINT_STATUS_TYPE_FINISH(2),
        UNRECOGNIZED(-1);
        
        public static final int LUNA_RITE_HINT_STATUS_TYPE_DEFAULT_VALUE = 0;
        public static final int LUNA_RITE_HINT_STATUS_TYPE_NO_COUNT_VALUE = 1;
        public static final int LUNA_RITE_HINT_STATUS_TYPE_FINISH_VALUE = 2;
        private static final Internal.EnumLiteMap<LunaRiteHintStatusType> internalValueMap = new Internal.EnumLiteMap<LunaRiteHintStatusType>() { // from class: emu.grasscutter.net.proto.LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LunaRiteHintStatusType findValueByNumber(int number) {
                return LunaRiteHintStatusType.forNumber(number);
            }
        };
        private static final LunaRiteHintStatusType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static LunaRiteHintStatusType valueOf(int value) {
            return forNumber(value);
        }

        public static LunaRiteHintStatusType forNumber(int value) {
            switch (value) {
                case 0:
                    return LUNA_RITE_HINT_STATUS_TYPE_DEFAULT;
                case 1:
                    return LUNA_RITE_HINT_STATUS_TYPE_NO_COUNT;
                case 2:
                    return LUNA_RITE_HINT_STATUS_TYPE_FINISH;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LunaRiteHintStatusType> internalGetValueMap() {
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
            return LunaRiteHintStatusTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static LunaRiteHintStatusType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        LunaRiteHintStatusType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
