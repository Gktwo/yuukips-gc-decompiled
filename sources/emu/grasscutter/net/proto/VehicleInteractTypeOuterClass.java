package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractTypeOuterClass.class */
public final class VehicleInteractTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019VehicleInteractType.proto*r\n\u0013VehicleInteractType\u0012\u001e\n\u001aVEHICLE_INTERACT_TYPE_NONE\u0010��\u0012\u001c\n\u0018VEHICLE_INTERACT_TYPE_IN\u0010\u0001\u0012\u001d\n\u0019VEHICLE_INTERACT_TYPE_OUT\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private VehicleInteractTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VehicleInteractTypeOuterClass$VehicleInteractType.class */
    public enum VehicleInteractType implements ProtocolMessageEnum {
        VEHICLE_INTERACT_TYPE_NONE(0),
        VEHICLE_INTERACT_TYPE_IN(1),
        VEHICLE_INTERACT_TYPE_OUT(2),
        UNRECOGNIZED(-1);
        
        public static final int VEHICLE_INTERACT_TYPE_NONE_VALUE = 0;
        public static final int VEHICLE_INTERACT_TYPE_IN_VALUE = 1;
        public static final int VEHICLE_INTERACT_TYPE_OUT_VALUE = 2;
        private static final Internal.EnumLiteMap<VehicleInteractType> internalValueMap = new Internal.EnumLiteMap<VehicleInteractType>() { // from class: emu.grasscutter.net.proto.VehicleInteractTypeOuterClass.VehicleInteractType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public VehicleInteractType findValueByNumber(int number) {
                return VehicleInteractType.forNumber(number);
            }
        };
        private static final VehicleInteractType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static VehicleInteractType valueOf(int value) {
            return forNumber(value);
        }

        public static VehicleInteractType forNumber(int value) {
            switch (value) {
                case 0:
                    return VEHICLE_INTERACT_TYPE_NONE;
                case 1:
                    return VEHICLE_INTERACT_TYPE_IN;
                case 2:
                    return VEHICLE_INTERACT_TYPE_OUT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<VehicleInteractType> internalGetValueMap() {
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
            return VehicleInteractTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static VehicleInteractType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        VehicleInteractType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
