package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeEnergyReasonOuterClass.class */
public final class ChangeEnergyReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ChangeEnergyReason.proto*Y\n\u0012ChangeEnergyReason\u0012\u001d\n\u0019CHANGE_ENERGY_REASON_NONE\u0010��\u0012$\n CHANGE_ENERGY_REASON_SKILL_START\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ChangeEnergyReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChangeEnergyReasonOuterClass$ChangeEnergyReason.class */
    public enum ChangeEnergyReason implements ProtocolMessageEnum {
        CHANGE_ENERGY_REASON_NONE(0),
        CHANGE_ENERGY_REASON_SKILL_START(1),
        UNRECOGNIZED(-1);
        
        public static final int CHANGE_ENERGY_REASON_NONE_VALUE = 0;
        public static final int CHANGE_ENERGY_REASON_SKILL_START_VALUE = 1;
        private static final Internal.EnumLiteMap<ChangeEnergyReason> internalValueMap = new Internal.EnumLiteMap<ChangeEnergyReason>() { // from class: emu.grasscutter.net.proto.ChangeEnergyReasonOuterClass.ChangeEnergyReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChangeEnergyReason findValueByNumber(int number) {
                return ChangeEnergyReason.forNumber(number);
            }
        };
        private static final ChangeEnergyReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ChangeEnergyReason valueOf(int value) {
            return forNumber(value);
        }

        public static ChangeEnergyReason forNumber(int value) {
            switch (value) {
                case 0:
                    return CHANGE_ENERGY_REASON_NONE;
                case 1:
                    return CHANGE_ENERGY_REASON_SKILL_START;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ChangeEnergyReason> internalGetValueMap() {
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
            return ChangeEnergyReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ChangeEnergyReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ChangeEnergyReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
