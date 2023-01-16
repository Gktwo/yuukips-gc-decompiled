package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarTypeOuterClass.class */
public final class AbilityScalarTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017AbilityScalarType.proto*í\u0001\n\u0011AbilityScalarType\u0012\u001f\n\u001bABILITY_SCALAR_TYPE_UNKNOWN\u0010��\u0012\u001d\n\u0019ABILITY_SCALAR_TYPE_FLOAT\u0010\u0001\u0012\u001b\n\u0017ABILITY_SCALAR_TYPE_INT\u0010\u0002\u0012\u001c\n\u0018ABILITY_SCALAR_TYPE_BOOL\u0010\u0003\u0012\u001f\n\u001bABILITY_SCALAR_TYPE_TRIGGER\u0010\u0004\u0012\u001e\n\u001aABILITY_SCALAR_TYPE_STRING\u0010\u0005\u0012\u001c\n\u0018ABILITY_SCALAR_TYPE_UINT\u0010\u0006B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AbilityScalarTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityScalarTypeOuterClass$AbilityScalarType.class */
    public enum AbilityScalarType implements ProtocolMessageEnum {
        ABILITY_SCALAR_TYPE_UNKNOWN(0),
        ABILITY_SCALAR_TYPE_FLOAT(1),
        ABILITY_SCALAR_TYPE_INT(2),
        ABILITY_SCALAR_TYPE_BOOL(3),
        ABILITY_SCALAR_TYPE_TRIGGER(4),
        ABILITY_SCALAR_TYPE_STRING(5),
        ABILITY_SCALAR_TYPE_UINT(6),
        UNRECOGNIZED(-1);
        
        public static final int ABILITY_SCALAR_TYPE_UNKNOWN_VALUE = 0;
        public static final int ABILITY_SCALAR_TYPE_FLOAT_VALUE = 1;
        public static final int ABILITY_SCALAR_TYPE_INT_VALUE = 2;
        public static final int ABILITY_SCALAR_TYPE_BOOL_VALUE = 3;
        public static final int ABILITY_SCALAR_TYPE_TRIGGER_VALUE = 4;
        public static final int ABILITY_SCALAR_TYPE_STRING_VALUE = 5;
        public static final int ABILITY_SCALAR_TYPE_UINT_VALUE = 6;
        private static final Internal.EnumLiteMap<AbilityScalarType> internalValueMap = new Internal.EnumLiteMap<AbilityScalarType>() { // from class: emu.grasscutter.net.proto.AbilityScalarTypeOuterClass.AbilityScalarType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AbilityScalarType findValueByNumber(int number) {
                return AbilityScalarType.forNumber(number);
            }
        };
        private static final AbilityScalarType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AbilityScalarType valueOf(int value) {
            return forNumber(value);
        }

        public static AbilityScalarType forNumber(int value) {
            switch (value) {
                case 0:
                    return ABILITY_SCALAR_TYPE_UNKNOWN;
                case 1:
                    return ABILITY_SCALAR_TYPE_FLOAT;
                case 2:
                    return ABILITY_SCALAR_TYPE_INT;
                case 3:
                    return ABILITY_SCALAR_TYPE_BOOL;
                case 4:
                    return ABILITY_SCALAR_TYPE_TRIGGER;
                case 5:
                    return ABILITY_SCALAR_TYPE_STRING;
                case 6:
                    return ABILITY_SCALAR_TYPE_UINT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AbilityScalarType> internalGetValueMap() {
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
            return AbilityScalarTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AbilityScalarType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AbilityScalarType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
