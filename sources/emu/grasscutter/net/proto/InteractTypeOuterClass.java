package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InteractTypeOuterClass.class */
public final class InteractTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012InteractType.proto*\u0004\n\fInteractType\u0012\u0016\n\u0012INTERACT_TYPE_NONE\u0010��\u0012\u001b\n\u0017INTERACT_TYPE_PICK_ITEM\u0010\u0001\u0012\u0018\n\u0014INTERACT_TYPE_GATHER\u0010\u0002\u0012\u001c\n\u0018INTERACT_TYPE_OPEN_CHEST\u0010\u0003\u0012\u001d\n\u0019INTERACT_TYPE_OPEN_STATUE\u0010\u0004\u0012\u0019\n\u0015INTERACT_TYPE_CONSUME\u0010\u0005\u0012 \n\u001cINTERACT_TYPE_MP_PLAY_REWARD\u0010\u0006\u0012\u0016\n\u0012INTERACT_TYPE_VIEW\u0010\u0007\u0012 \n\u001cINTERACT_TYPE_GENERAL_REWARD\u0010\b\u0012\u001e\n\u001aINTERACT_TYPE_MIRACLE_RING\u0010\t\u0012\u001c\n\u0018INTERACT_TYPE_FOUNDATION\u0010\n\u0012\u001c\n\u0018INTERACT_TYPE_ECHO_SHELL\u0010\u000b\u0012\u001d\n\u0019INTERACT_TYPE_HOME_GATHER\u0010\f\u0012\u001c\n\u0018INTERACT_TYPE_ENV_ANIMAL\u0010\r\u0012\u001e\n\u001aINTERACT_TYPE_QUEST_GADGET\u0010\u000e\u0012\u001d\n\u0019INTERACT_TYPE_UI_INTERACT\u0010\u000f\u0012!\n\u001dINTERACT_TYPE_DESHRET_OBELISK\u0010\u0010B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private InteractTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InteractTypeOuterClass$InteractType.class */
    public enum InteractType implements ProtocolMessageEnum {
        INTERACT_TYPE_NONE(0),
        INTERACT_TYPE_PICK_ITEM(1),
        INTERACT_TYPE_GATHER(2),
        INTERACT_TYPE_OPEN_CHEST(3),
        INTERACT_TYPE_OPEN_STATUE(4),
        INTERACT_TYPE_CONSUME(5),
        INTERACT_TYPE_MP_PLAY_REWARD(6),
        INTERACT_TYPE_VIEW(7),
        INTERACT_TYPE_GENERAL_REWARD(8),
        INTERACT_TYPE_MIRACLE_RING(9),
        INTERACT_TYPE_FOUNDATION(10),
        INTERACT_TYPE_ECHO_SHELL(11),
        INTERACT_TYPE_HOME_GATHER(12),
        INTERACT_TYPE_ENV_ANIMAL(13),
        INTERACT_TYPE_QUEST_GADGET(14),
        INTERACT_TYPE_UI_INTERACT(15),
        INTERACT_TYPE_DESHRET_OBELISK(16),
        UNRECOGNIZED(-1);
        
        public static final int INTERACT_TYPE_NONE_VALUE = 0;
        public static final int INTERACT_TYPE_PICK_ITEM_VALUE = 1;
        public static final int INTERACT_TYPE_GATHER_VALUE = 2;
        public static final int INTERACT_TYPE_OPEN_CHEST_VALUE = 3;
        public static final int INTERACT_TYPE_OPEN_STATUE_VALUE = 4;
        public static final int INTERACT_TYPE_CONSUME_VALUE = 5;
        public static final int INTERACT_TYPE_MP_PLAY_REWARD_VALUE = 6;
        public static final int INTERACT_TYPE_VIEW_VALUE = 7;
        public static final int INTERACT_TYPE_GENERAL_REWARD_VALUE = 8;
        public static final int INTERACT_TYPE_MIRACLE_RING_VALUE = 9;
        public static final int INTERACT_TYPE_FOUNDATION_VALUE = 10;
        public static final int INTERACT_TYPE_ECHO_SHELL_VALUE = 11;
        public static final int INTERACT_TYPE_HOME_GATHER_VALUE = 12;
        public static final int INTERACT_TYPE_ENV_ANIMAL_VALUE = 13;
        public static final int INTERACT_TYPE_QUEST_GADGET_VALUE = 14;
        public static final int INTERACT_TYPE_UI_INTERACT_VALUE = 15;
        public static final int INTERACT_TYPE_DESHRET_OBELISK_VALUE = 16;
        private static final Internal.EnumLiteMap<InteractType> internalValueMap = new Internal.EnumLiteMap<InteractType>() { // from class: emu.grasscutter.net.proto.InteractTypeOuterClass.InteractType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public InteractType findValueByNumber(int number) {
                return InteractType.forNumber(number);
            }
        };
        private static final InteractType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static InteractType valueOf(int value) {
            return forNumber(value);
        }

        public static InteractType forNumber(int value) {
            switch (value) {
                case 0:
                    return INTERACT_TYPE_NONE;
                case 1:
                    return INTERACT_TYPE_PICK_ITEM;
                case 2:
                    return INTERACT_TYPE_GATHER;
                case 3:
                    return INTERACT_TYPE_OPEN_CHEST;
                case 4:
                    return INTERACT_TYPE_OPEN_STATUE;
                case 5:
                    return INTERACT_TYPE_CONSUME;
                case 6:
                    return INTERACT_TYPE_MP_PLAY_REWARD;
                case 7:
                    return INTERACT_TYPE_VIEW;
                case 8:
                    return INTERACT_TYPE_GENERAL_REWARD;
                case 9:
                    return INTERACT_TYPE_MIRACLE_RING;
                case 10:
                    return INTERACT_TYPE_FOUNDATION;
                case 11:
                    return INTERACT_TYPE_ECHO_SHELL;
                case 12:
                    return INTERACT_TYPE_HOME_GATHER;
                case 13:
                    return INTERACT_TYPE_ENV_ANIMAL;
                case 14:
                    return INTERACT_TYPE_QUEST_GADGET;
                case 15:
                    return INTERACT_TYPE_UI_INTERACT;
                case 16:
                    return INTERACT_TYPE_DESHRET_OBELISK;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<InteractType> internalGetValueMap() {
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
            return InteractTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static InteractType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        InteractType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
