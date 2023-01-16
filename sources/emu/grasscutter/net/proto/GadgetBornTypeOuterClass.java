package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetBornTypeOuterClass.class */
public final class GadgetBornTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014GadgetBornType.proto*ã\u0001\n\u000eGadgetBornType\u0012\u0019\n\u0015GADGET_BORN_TYPE_NONE\u0010��\u0012\u001b\n\u0017GADGET_BORN_TYPE_IN_AIR\u0010\u0001\u0012\u001b\n\u0017GADGET_BORN_TYPE_PLAYER\u0010\u0002\u0012 \n\u001cGADGET_BORN_TYPE_MONSTER_HIT\u0010\u0003\u0012 \n\u001cGADGET_BORN_TYPE_MONSTER_DIE\u0010\u0004\u0012\u001b\n\u0017GADGET_BORN_TYPE_GADGET\u0010\u0005\u0012\u001b\n\u0017GADGET_BORN_TYPE_GROUND\u0010\u0006B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private GadgetBornTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetBornTypeOuterClass$GadgetBornType.class */
    public enum GadgetBornType implements ProtocolMessageEnum {
        GADGET_BORN_TYPE_NONE(0),
        GADGET_BORN_TYPE_IN_AIR(1),
        GADGET_BORN_TYPE_PLAYER(2),
        GADGET_BORN_TYPE_MONSTER_HIT(3),
        GADGET_BORN_TYPE_MONSTER_DIE(4),
        GADGET_BORN_TYPE_GADGET(5),
        GADGET_BORN_TYPE_GROUND(6),
        UNRECOGNIZED(-1);
        
        public static final int GADGET_BORN_TYPE_NONE_VALUE = 0;
        public static final int GADGET_BORN_TYPE_IN_AIR_VALUE = 1;
        public static final int GADGET_BORN_TYPE_PLAYER_VALUE = 2;
        public static final int GADGET_BORN_TYPE_MONSTER_HIT_VALUE = 3;
        public static final int GADGET_BORN_TYPE_MONSTER_DIE_VALUE = 4;
        public static final int GADGET_BORN_TYPE_GADGET_VALUE = 5;
        public static final int GADGET_BORN_TYPE_GROUND_VALUE = 6;
        private static final Internal.EnumLiteMap<GadgetBornType> internalValueMap = new Internal.EnumLiteMap<GadgetBornType>() { // from class: emu.grasscutter.net.proto.GadgetBornTypeOuterClass.GadgetBornType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public GadgetBornType findValueByNumber(int number) {
                return GadgetBornType.forNumber(number);
            }
        };
        private static final GadgetBornType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static GadgetBornType valueOf(int value) {
            return forNumber(value);
        }

        public static GadgetBornType forNumber(int value) {
            switch (value) {
                case 0:
                    return GADGET_BORN_TYPE_NONE;
                case 1:
                    return GADGET_BORN_TYPE_IN_AIR;
                case 2:
                    return GADGET_BORN_TYPE_PLAYER;
                case 3:
                    return GADGET_BORN_TYPE_MONSTER_HIT;
                case 4:
                    return GADGET_BORN_TYPE_MONSTER_DIE;
                case 5:
                    return GADGET_BORN_TYPE_GADGET;
                case 6:
                    return GADGET_BORN_TYPE_GROUND;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<GadgetBornType> internalGetValueMap() {
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
            return GadgetBornTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static GadgetBornType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        GadgetBornType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
