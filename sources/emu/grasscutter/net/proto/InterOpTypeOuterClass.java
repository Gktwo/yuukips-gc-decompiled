package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InterOpTypeOuterClass.class */
public final class InterOpTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011InterOpType.proto*@\n\u000bInterOpType\u0012\u0018\n\u0014INTER_OP_TYPE_FINISH\u0010��\u0012\u0017\n\u0013INTER_OP_TYPE_START\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private InterOpTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InterOpTypeOuterClass$InterOpType.class */
    public enum InterOpType implements ProtocolMessageEnum {
        INTER_OP_TYPE_FINISH(0),
        INTER_OP_TYPE_START(1),
        UNRECOGNIZED(-1);
        
        public static final int INTER_OP_TYPE_FINISH_VALUE = 0;
        public static final int INTER_OP_TYPE_START_VALUE = 1;
        private static final Internal.EnumLiteMap<InterOpType> internalValueMap = new Internal.EnumLiteMap<InterOpType>() { // from class: emu.grasscutter.net.proto.InterOpTypeOuterClass.InterOpType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InterOpType findValueByNumber(int number) {
                return InterOpType.forNumber(number);
            }
        };
        private static final InterOpType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static InterOpType valueOf(int value) {
            return forNumber(value);
        }

        public static InterOpType forNumber(int value) {
            switch (value) {
                case 0:
                    return INTER_OP_TYPE_FINISH;
                case 1:
                    return INTER_OP_TYPE_START;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<InterOpType> internalGetValueMap() {
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
            return InterOpTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static InterOpType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        InterOpType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
