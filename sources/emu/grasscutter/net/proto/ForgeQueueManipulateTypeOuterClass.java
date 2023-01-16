package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateTypeOuterClass.class */
public final class ForgeQueueManipulateTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eForgeQueueManipulateType.proto*v\n\u0018ForgeQueueManipulateType\u0012.\n*FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT\u0010��\u0012*\n&FORGE_QUEUE_MANIPULATE_TYPE_STOP_FORGE\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ForgeQueueManipulateTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForgeQueueManipulateTypeOuterClass$ForgeQueueManipulateType.class */
    public enum ForgeQueueManipulateType implements ProtocolMessageEnum {
        FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT(0),
        FORGE_QUEUE_MANIPULATE_TYPE_STOP_FORGE(1),
        UNRECOGNIZED(-1);
        
        public static final int FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT_VALUE = 0;
        public static final int FORGE_QUEUE_MANIPULATE_TYPE_STOP_FORGE_VALUE = 1;
        private static final Internal.EnumLiteMap<ForgeQueueManipulateType> internalValueMap = new Internal.EnumLiteMap<ForgeQueueManipulateType>() { // from class: emu.grasscutter.net.proto.ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ForgeQueueManipulateType findValueByNumber(int number) {
                return ForgeQueueManipulateType.forNumber(number);
            }
        };
        private static final ForgeQueueManipulateType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ForgeQueueManipulateType valueOf(int value) {
            return forNumber(value);
        }

        public static ForgeQueueManipulateType forNumber(int value) {
            switch (value) {
                case 0:
                    return FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT;
                case 1:
                    return FORGE_QUEUE_MANIPULATE_TYPE_STOP_FORGE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ForgeQueueManipulateType> internalGetValueMap() {
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
            return ForgeQueueManipulateTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ForgeQueueManipulateType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ForgeQueueManipulateType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
