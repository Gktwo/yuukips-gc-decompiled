package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OptionTypeOuterClass.class */
public final class OptionTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010OptionType.proto*X\n\nOptionType\u0012\u0014\n\u0010OPTION_TYPE_NONE\u0010��\u0012\u0016\n\u0012OPTION_TYPE_NORMAL\u0010\u0001\u0012\u001c\n\u0018OPTION_TYPE_FIRST_CAN_GO\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private OptionTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OptionTypeOuterClass$OptionType.class */
    public enum OptionType implements ProtocolMessageEnum {
        OPTION_TYPE_NONE(0),
        OPTION_TYPE_NORMAL(1),
        OPTION_TYPE_FIRST_CAN_GO(2),
        UNRECOGNIZED(-1);
        
        public static final int OPTION_TYPE_NONE_VALUE = 0;
        public static final int OPTION_TYPE_NORMAL_VALUE = 1;
        public static final int OPTION_TYPE_FIRST_CAN_GO_VALUE = 2;
        private static final Internal.EnumLiteMap<OptionType> internalValueMap = new Internal.EnumLiteMap<OptionType>() { // from class: emu.grasscutter.net.proto.OptionTypeOuterClass.OptionType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OptionType findValueByNumber(int number) {
                return OptionType.forNumber(number);
            }
        };
        private static final OptionType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static OptionType valueOf(int value) {
            return forNumber(value);
        }

        public static OptionType forNumber(int value) {
            switch (value) {
                case 0:
                    return OPTION_TYPE_NONE;
                case 1:
                    return OPTION_TYPE_NORMAL;
                case 2:
                    return OPTION_TYPE_FIRST_CAN_GO;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<OptionType> internalGetValueMap() {
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
            return OptionTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static OptionType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        OptionType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
