package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnTypeOuterClass.class */
public final class MaterialDeleteReturnTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eMaterialDeleteReturnType.proto*e\n\u0018MaterialDeleteReturnType\u0012#\n\u001fMATERIAL_DELETE_RETURN_TYPE_BAG\u0010��\u0012$\n MATERIAL_DELETE_RETURN_TYPE_SEED\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MaterialDeleteReturnTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteReturnTypeOuterClass$MaterialDeleteReturnType.class */
    public enum MaterialDeleteReturnType implements ProtocolMessageEnum {
        MATERIAL_DELETE_RETURN_TYPE_BAG(0),
        MATERIAL_DELETE_RETURN_TYPE_SEED(1),
        UNRECOGNIZED(-1);
        
        public static final int MATERIAL_DELETE_RETURN_TYPE_BAG_VALUE = 0;
        public static final int MATERIAL_DELETE_RETURN_TYPE_SEED_VALUE = 1;
        private static final Internal.EnumLiteMap<MaterialDeleteReturnType> internalValueMap = new Internal.EnumLiteMap<MaterialDeleteReturnType>() { // from class: emu.grasscutter.net.proto.MaterialDeleteReturnTypeOuterClass.MaterialDeleteReturnType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MaterialDeleteReturnType findValueByNumber(int number) {
                return MaterialDeleteReturnType.forNumber(number);
            }
        };
        private static final MaterialDeleteReturnType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MaterialDeleteReturnType valueOf(int value) {
            return forNumber(value);
        }

        public static MaterialDeleteReturnType forNumber(int value) {
            switch (value) {
                case 0:
                    return MATERIAL_DELETE_RETURN_TYPE_BAG;
                case 1:
                    return MATERIAL_DELETE_RETURN_TYPE_SEED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MaterialDeleteReturnType> internalGetValueMap() {
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
            return MaterialDeleteReturnTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MaterialDeleteReturnType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MaterialDeleteReturnType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
