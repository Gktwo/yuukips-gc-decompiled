package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MovingPlatformTypeOuterClass.class */
public final class MovingPlatformTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018MovingPlatformType.proto*\u0001\n\u0012MovingPlatformType\u0012\u001d\n\u0019MOVING_PLATFORM_TYPE_NONE\u0010��\u0012#\n\u001fMOVING_PLATFORM_TYPE_USE_CONFIG\u0010\u0001\u0012 \n\u001cMOVING_PLATFORM_TYPE_ABILITY\u0010\u0002\u0012\u001e\n\u001aMOVING_PLATFORM_TYPE_ROUTE\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MovingPlatformTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MovingPlatformTypeOuterClass$MovingPlatformType.class */
    public enum MovingPlatformType implements ProtocolMessageEnum {
        MOVING_PLATFORM_TYPE_NONE(0),
        MOVING_PLATFORM_TYPE_USE_CONFIG(1),
        MOVING_PLATFORM_TYPE_ABILITY(2),
        MOVING_PLATFORM_TYPE_ROUTE(3),
        UNRECOGNIZED(-1);
        
        public static final int MOVING_PLATFORM_TYPE_NONE_VALUE = 0;
        public static final int MOVING_PLATFORM_TYPE_USE_CONFIG_VALUE = 1;
        public static final int MOVING_PLATFORM_TYPE_ABILITY_VALUE = 2;
        public static final int MOVING_PLATFORM_TYPE_ROUTE_VALUE = 3;
        private static final Internal.EnumLiteMap<MovingPlatformType> internalValueMap = new Internal.EnumLiteMap<MovingPlatformType>() { // from class: emu.grasscutter.net.proto.MovingPlatformTypeOuterClass.MovingPlatformType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MovingPlatformType findValueByNumber(int number) {
                return MovingPlatformType.forNumber(number);
            }
        };
        private static final MovingPlatformType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MovingPlatformType valueOf(int value) {
            return forNumber(value);
        }

        public static MovingPlatformType forNumber(int value) {
            switch (value) {
                case 0:
                    return MOVING_PLATFORM_TYPE_NONE;
                case 1:
                    return MOVING_PLATFORM_TYPE_USE_CONFIG;
                case 2:
                    return MOVING_PLATFORM_TYPE_ABILITY;
                case 3:
                    return MOVING_PLATFORM_TYPE_ROUTE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MovingPlatformType> internalGetValueMap() {
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
            return MovingPlatformTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MovingPlatformType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MovingPlatformType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
