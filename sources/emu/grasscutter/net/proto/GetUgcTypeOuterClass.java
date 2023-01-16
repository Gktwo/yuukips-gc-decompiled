package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcTypeOuterClass.class */
public final class GetUgcTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010GetUgcType.proto*T\n\nGetUgcType\u0012\u0015\n\u0011GET_UGC_TYPE_NONE\u0010��\u0012\u0015\n\u0011GET_UGC_TYPE_MINE\u0010\u0001\u0012\u0018\n\u0014GET_UGC_TYPE_PUBLISH\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private GetUgcTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetUgcTypeOuterClass$GetUgcType.class */
    public enum GetUgcType implements ProtocolMessageEnum {
        GET_UGC_TYPE_NONE(0),
        GET_UGC_TYPE_MINE(1),
        GET_UGC_TYPE_PUBLISH(2),
        UNRECOGNIZED(-1);
        
        public static final int GET_UGC_TYPE_NONE_VALUE = 0;
        public static final int GET_UGC_TYPE_MINE_VALUE = 1;
        public static final int GET_UGC_TYPE_PUBLISH_VALUE = 2;
        private static final Internal.EnumLiteMap<GetUgcType> internalValueMap = new Internal.EnumLiteMap<GetUgcType>() { // from class: emu.grasscutter.net.proto.GetUgcTypeOuterClass.GetUgcType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public GetUgcType findValueByNumber(int number) {
                return GetUgcType.forNumber(number);
            }
        };
        private static final GetUgcType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static GetUgcType valueOf(int value) {
            return forNumber(value);
        }

        public static GetUgcType forNumber(int value) {
            switch (value) {
                case 0:
                    return GET_UGC_TYPE_NONE;
                case 1:
                    return GET_UGC_TYPE_MINE;
                case 2:
                    return GET_UGC_TYPE_PUBLISH;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<GetUgcType> internalGetValueMap() {
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
            return GetUgcTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static GetUgcType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        GetUgcType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
