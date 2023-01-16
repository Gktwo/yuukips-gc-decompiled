package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStateOuterClass.class */
public final class AvatarExpeditionStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAvatarExpeditionState.proto*â\u0001\n\u0015AvatarExpeditionState\u0012 \n\u001cAVATAR_EXPEDITION_STATE_NONE\u0010��\u0012!\n\u001dAVATAR_EXPEDITION_STATE_DOING\u0010\u0001\u0012.\n*AVATAR_EXPEDITION_STATE_FINISH_WAIT_REWARD\u0010\u0002\u00120\n,AVATAR_EXPEDITION_STATE_CALLBACK_WAIT_REWARD\u0010\u0003\u0012\"\n\u001eAVATAR_EXPEDITION_STATE_LOCKED\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AvatarExpeditionStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarExpeditionStateOuterClass$AvatarExpeditionState.class */
    public enum AvatarExpeditionState implements ProtocolMessageEnum {
        AVATAR_EXPEDITION_STATE_NONE(0),
        AVATAR_EXPEDITION_STATE_DOING(1),
        AVATAR_EXPEDITION_STATE_FINISH_WAIT_REWARD(2),
        AVATAR_EXPEDITION_STATE_CALLBACK_WAIT_REWARD(3),
        AVATAR_EXPEDITION_STATE_LOCKED(4),
        UNRECOGNIZED(-1);
        
        public static final int AVATAR_EXPEDITION_STATE_NONE_VALUE = 0;
        public static final int AVATAR_EXPEDITION_STATE_DOING_VALUE = 1;
        public static final int AVATAR_EXPEDITION_STATE_FINISH_WAIT_REWARD_VALUE = 2;
        public static final int AVATAR_EXPEDITION_STATE_CALLBACK_WAIT_REWARD_VALUE = 3;
        public static final int AVATAR_EXPEDITION_STATE_LOCKED_VALUE = 4;
        private static final Internal.EnumLiteMap<AvatarExpeditionState> internalValueMap = new Internal.EnumLiteMap<AvatarExpeditionState>() { // from class: emu.grasscutter.net.proto.AvatarExpeditionStateOuterClass.AvatarExpeditionState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AvatarExpeditionState findValueByNumber(int number) {
                return AvatarExpeditionState.forNumber(number);
            }
        };
        private static final AvatarExpeditionState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AvatarExpeditionState valueOf(int value) {
            return forNumber(value);
        }

        public static AvatarExpeditionState forNumber(int value) {
            switch (value) {
                case 0:
                    return AVATAR_EXPEDITION_STATE_NONE;
                case 1:
                    return AVATAR_EXPEDITION_STATE_DOING;
                case 2:
                    return AVATAR_EXPEDITION_STATE_FINISH_WAIT_REWARD;
                case 3:
                    return AVATAR_EXPEDITION_STATE_CALLBACK_WAIT_REWARD;
                case 4:
                    return AVATAR_EXPEDITION_STATE_LOCKED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AvatarExpeditionState> internalGetValueMap() {
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
            return AvatarExpeditionStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AvatarExpeditionState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AvatarExpeditionState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
