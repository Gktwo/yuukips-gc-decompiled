package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PathStatusTypeOuterClass.class */
public final class PathStatusTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014PathStatusType.proto*d\n\u000ePathStatusType\u0012\u0019\n\u0015PATH_STATUS_TYPE_FAIL\u0010��\u0012\u0019\n\u0015PATH_STATUS_TYPE_SUCC\u0010\u0001\u0012\u001c\n\u0018PATH_STATUS_TYPE_PARTIAL\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private PathStatusTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PathStatusTypeOuterClass$PathStatusType.class */
    public enum PathStatusType implements ProtocolMessageEnum {
        PATH_STATUS_TYPE_FAIL(0),
        PATH_STATUS_TYPE_SUCC(1),
        PATH_STATUS_TYPE_PARTIAL(2),
        UNRECOGNIZED(-1);
        
        public static final int PATH_STATUS_TYPE_FAIL_VALUE = 0;
        public static final int PATH_STATUS_TYPE_SUCC_VALUE = 1;
        public static final int PATH_STATUS_TYPE_PARTIAL_VALUE = 2;
        private static final Internal.EnumLiteMap<PathStatusType> internalValueMap = new Internal.EnumLiteMap<PathStatusType>() { // from class: emu.grasscutter.net.proto.PathStatusTypeOuterClass.PathStatusType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PathStatusType findValueByNumber(int number) {
                return PathStatusType.forNumber(number);
            }
        };
        private static final PathStatusType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static PathStatusType valueOf(int value) {
            return forNumber(value);
        }

        public static PathStatusType forNumber(int value) {
            switch (value) {
                case 0:
                    return PATH_STATUS_TYPE_FAIL;
                case 1:
                    return PATH_STATUS_TYPE_SUCC;
                case 2:
                    return PATH_STATUS_TYPE_PARTIAL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<PathStatusType> internalGetValueMap() {
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
            return PathStatusTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static PathStatusType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        PathStatusType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
