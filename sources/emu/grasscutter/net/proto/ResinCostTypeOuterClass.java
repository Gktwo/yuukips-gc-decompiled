package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResinCostTypeOuterClass.class */
public final class ResinCostTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013ResinCostType.proto*É\u0001\n\rResinCostType\u0012\u0018\n\u0014RESIN_COST_TYPE_NONE\u0010��\u0012\u001a\n\u0016RESIN_COST_TYPE_NORMAL\u0010\u0001\u0012\u001c\n\u0018RESIN_COST_TYPE_CONDENSE\u0010\u0002\u0012%\n!RESIN_COST_TYPE_REUNION_PRIVILEGE\u0010\u0003\u0012\u001f\n\u001bRESIN_COST_TYPE_OP_ACTIVITY\u0010\u0004\u0012\u001c\n\u0018RESIN_COST_TYPE_MATERIAL\u0010\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ResinCostTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResinCostTypeOuterClass$ResinCostType.class */
    public enum ResinCostType implements ProtocolMessageEnum {
        RESIN_COST_TYPE_NONE(0),
        RESIN_COST_TYPE_NORMAL(1),
        RESIN_COST_TYPE_CONDENSE(2),
        RESIN_COST_TYPE_REUNION_PRIVILEGE(3),
        RESIN_COST_TYPE_OP_ACTIVITY(4),
        RESIN_COST_TYPE_MATERIAL(5),
        UNRECOGNIZED(-1);
        
        public static final int RESIN_COST_TYPE_NONE_VALUE = 0;
        public static final int RESIN_COST_TYPE_NORMAL_VALUE = 1;
        public static final int RESIN_COST_TYPE_CONDENSE_VALUE = 2;
        public static final int RESIN_COST_TYPE_REUNION_PRIVILEGE_VALUE = 3;
        public static final int RESIN_COST_TYPE_OP_ACTIVITY_VALUE = 4;
        public static final int RESIN_COST_TYPE_MATERIAL_VALUE = 5;
        private static final Internal.EnumLiteMap<ResinCostType> internalValueMap = new Internal.EnumLiteMap<ResinCostType>() { // from class: emu.grasscutter.net.proto.ResinCostTypeOuterClass.ResinCostType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ResinCostType findValueByNumber(int number) {
                return ResinCostType.forNumber(number);
            }
        };
        private static final ResinCostType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ResinCostType valueOf(int value) {
            return forNumber(value);
        }

        public static ResinCostType forNumber(int value) {
            switch (value) {
                case 0:
                    return RESIN_COST_TYPE_NONE;
                case 1:
                    return RESIN_COST_TYPE_NORMAL;
                case 2:
                    return RESIN_COST_TYPE_CONDENSE;
                case 3:
                    return RESIN_COST_TYPE_REUNION_PRIVILEGE;
                case 4:
                    return RESIN_COST_TYPE_OP_ACTIVITY;
                case 5:
                    return RESIN_COST_TYPE_MATERIAL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ResinCostType> internalGetValueMap() {
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
            return ResinCostTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ResinCostType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ResinCostType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
