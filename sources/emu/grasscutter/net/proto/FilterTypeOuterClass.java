package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FilterTypeOuterClass.class */
public final class FilterTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010FilterType.proto*M\n\nFilterType\u0012\u0013\n\u000fFILTER_TYPE_ALL\u0010��\u0012\u0013\n\u000fFILTER_TYPE_AIR\u0010\u0001\u0012\u0015\n\u0011FILTER_TYPE_WATER\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private FilterTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FilterTypeOuterClass$FilterType.class */
    public enum FilterType implements ProtocolMessageEnum {
        FILTER_TYPE_ALL(0),
        FILTER_TYPE_AIR(1),
        FILTER_TYPE_WATER(2),
        UNRECOGNIZED(-1);
        
        public static final int FILTER_TYPE_ALL_VALUE = 0;
        public static final int FILTER_TYPE_AIR_VALUE = 1;
        public static final int FILTER_TYPE_WATER_VALUE = 2;
        private static final Internal.EnumLiteMap<FilterType> internalValueMap = new Internal.EnumLiteMap<FilterType>() { // from class: emu.grasscutter.net.proto.FilterTypeOuterClass.FilterType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FilterType findValueByNumber(int number) {
                return FilterType.forNumber(number);
            }
        };
        private static final FilterType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static FilterType valueOf(int value) {
            return forNumber(value);
        }

        public static FilterType forNumber(int value) {
            switch (value) {
                case 0:
                    return FILTER_TYPE_ALL;
                case 1:
                    return FILTER_TYPE_AIR;
                case 2:
                    return FILTER_TYPE_WATER;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<FilterType> internalGetValueMap() {
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
            return FilterTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static FilterType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        FilterType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
