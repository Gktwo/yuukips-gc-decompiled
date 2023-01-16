package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreTypeOuterClass.class */
public final class StoreTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fStoreType.proto*K\n\tStoreType\u0012\u0013\n\u000fSTORE_TYPE_NONE\u0010��\u0012\u0013\n\u000fSTORE_TYPE_PACK\u0010\u0001\u0012\u0014\n\u0010STORE_TYPE_DEPOT\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private StoreTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/StoreTypeOuterClass$StoreType.class */
    public enum StoreType implements ProtocolMessageEnum {
        STORE_TYPE_NONE(0),
        STORE_TYPE_PACK(1),
        STORE_TYPE_DEPOT(2),
        UNRECOGNIZED(-1);
        
        public static final int STORE_TYPE_NONE_VALUE = 0;
        public static final int STORE_TYPE_PACK_VALUE = 1;
        public static final int STORE_TYPE_DEPOT_VALUE = 2;
        private static final Internal.EnumLiteMap<StoreType> internalValueMap = new Internal.EnumLiteMap<StoreType>() { // from class: emu.grasscutter.net.proto.StoreTypeOuterClass.StoreType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public StoreType findValueByNumber(int number) {
                return StoreType.forNumber(number);
            }
        };
        private static final StoreType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static StoreType valueOf(int value) {
            return forNumber(value);
        }

        public static StoreType forNumber(int value) {
            switch (value) {
                case 0:
                    return STORE_TYPE_NONE;
                case 1:
                    return STORE_TYPE_PACK;
                case 2:
                    return STORE_TYPE_DEPOT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<StoreType> internalGetValueMap() {
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
            return StoreTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static StoreType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        StoreType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
