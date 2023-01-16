package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanStatusTypeOuterClass.class */
public final class SalesmanStatusTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018SalesmanStatusType.proto*\u0001\n\u0012SalesmanStatusType\u0012\u001d\n\u0019SALESMAN_STATUS_TYPE_NONE\u0010��\u0012\"\n\u001eSALESMAN_STATUS_TYPE_UNSTARTED\u0010\u0001\u0012 \n\u001cSALESMAN_STATUS_TYPE_STARTED\u0010\u0002\u0012\"\n\u001eSALESMAN_STATUS_TYPE_DELIVERED\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private SalesmanStatusTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalesmanStatusTypeOuterClass$SalesmanStatusType.class */
    public enum SalesmanStatusType implements ProtocolMessageEnum {
        SALESMAN_STATUS_TYPE_NONE(0),
        SALESMAN_STATUS_TYPE_UNSTARTED(1),
        SALESMAN_STATUS_TYPE_STARTED(2),
        SALESMAN_STATUS_TYPE_DELIVERED(3),
        UNRECOGNIZED(-1);
        
        public static final int SALESMAN_STATUS_TYPE_NONE_VALUE = 0;
        public static final int SALESMAN_STATUS_TYPE_UNSTARTED_VALUE = 1;
        public static final int SALESMAN_STATUS_TYPE_STARTED_VALUE = 2;
        public static final int SALESMAN_STATUS_TYPE_DELIVERED_VALUE = 3;
        private static final Internal.EnumLiteMap<SalesmanStatusType> internalValueMap = new Internal.EnumLiteMap<SalesmanStatusType>() { // from class: emu.grasscutter.net.proto.SalesmanStatusTypeOuterClass.SalesmanStatusType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SalesmanStatusType findValueByNumber(int number) {
                return SalesmanStatusType.forNumber(number);
            }
        };
        private static final SalesmanStatusType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static SalesmanStatusType valueOf(int value) {
            return forNumber(value);
        }

        public static SalesmanStatusType forNumber(int value) {
            switch (value) {
                case 0:
                    return SALESMAN_STATUS_TYPE_NONE;
                case 1:
                    return SALESMAN_STATUS_TYPE_UNSTARTED;
                case 2:
                    return SALESMAN_STATUS_TYPE_STARTED;
                case 3:
                    return SALESMAN_STATUS_TYPE_DELIVERED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<SalesmanStatusType> internalGetValueMap() {
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
            return SalesmanStatusTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static SalesmanStatusType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        SalesmanStatusType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
