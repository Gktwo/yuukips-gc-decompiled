package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpTypeOuterClass.class */
public final class OpTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\fOpType.proto*H\n\u0006OpType\u0012\u0010\n\fOP_TYPE_NONE\u0010��\u0012\u0014\n\u0010OP_TYPE_ACTIVATE\u0010\u0001\u0012\u0016\n\u0012OP_TYPE_DEACTIVATE\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private OpTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OpTypeOuterClass$OpType.class */
    public enum OpType implements ProtocolMessageEnum {
        OP_TYPE_NONE(0),
        OP_TYPE_ACTIVATE(1),
        OP_TYPE_DEACTIVATE(2),
        UNRECOGNIZED(-1);
        
        public static final int OP_TYPE_NONE_VALUE = 0;
        public static final int OP_TYPE_ACTIVATE_VALUE = 1;
        public static final int OP_TYPE_DEACTIVATE_VALUE = 2;
        private static final Internal.EnumLiteMap<OpType> internalValueMap = new Internal.EnumLiteMap<OpType>() { // from class: emu.grasscutter.net.proto.OpTypeOuterClass.OpType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OpType findValueByNumber(int number) {
                return OpType.forNumber(number);
            }
        };
        private static final OpType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static OpType valueOf(int value) {
            return forNumber(value);
        }

        public static OpType forNumber(int value) {
            switch (value) {
                case 0:
                    return OP_TYPE_NONE;
                case 1:
                    return OP_TYPE_ACTIVATE;
                case 2:
                    return OP_TYPE_DEACTIVATE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<OpType> internalGetValueMap() {
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
            return OpTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static OpType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        OpType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
