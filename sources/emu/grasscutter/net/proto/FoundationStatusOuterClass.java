package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FoundationStatusOuterClass.class */
public final class FoundationStatusOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016FoundationStatus.proto*\u0001\n\u0010FoundationStatus\u0012\u001a\n\u0016FOUNDATION_STATUS_NONE\u0010��\u0012\u001a\n\u0016FOUNDATION_STATUS_INIT\u0010\u0001\u0012\u001e\n\u001aFOUNDATION_STATUS_BUILDING\u0010\u0002\u0012\u001b\n\u0017FOUNDATION_STATUS_BUILT\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private FoundationStatusOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FoundationStatusOuterClass$FoundationStatus.class */
    public enum FoundationStatus implements ProtocolMessageEnum {
        FOUNDATION_STATUS_NONE(0),
        FOUNDATION_STATUS_INIT(1),
        FOUNDATION_STATUS_BUILDING(2),
        FOUNDATION_STATUS_BUILT(3),
        UNRECOGNIZED(-1);
        
        public static final int FOUNDATION_STATUS_NONE_VALUE = 0;
        public static final int FOUNDATION_STATUS_INIT_VALUE = 1;
        public static final int FOUNDATION_STATUS_BUILDING_VALUE = 2;
        public static final int FOUNDATION_STATUS_BUILT_VALUE = 3;
        private static final Internal.EnumLiteMap<FoundationStatus> internalValueMap = new Internal.EnumLiteMap<FoundationStatus>() { // from class: emu.grasscutter.net.proto.FoundationStatusOuterClass.FoundationStatus.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FoundationStatus findValueByNumber(int number) {
                return FoundationStatus.forNumber(number);
            }
        };
        private static final FoundationStatus[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static FoundationStatus valueOf(int value) {
            return forNumber(value);
        }

        public static FoundationStatus forNumber(int value) {
            switch (value) {
                case 0:
                    return FOUNDATION_STATUS_NONE;
                case 1:
                    return FOUNDATION_STATUS_INIT;
                case 2:
                    return FOUNDATION_STATUS_BUILDING;
                case 3:
                    return FOUNDATION_STATUS_BUILT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<FoundationStatus> internalGetValueMap() {
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
            return FoundationStatusOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static FoundationStatus valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        FoundationStatus(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
