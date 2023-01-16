package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTypeOuterClass.class */
public final class AvatarTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010AvatarType.proto*i\n\nAvatarType\u0012\u0014\n\u0010AVATAR_TYPE_NONE\u0010��\u0012\u0016\n\u0012AVATAR_TYPE_FORMAL\u0010\u0001\u0012\u0015\n\u0011AVATAR_TYPE_TRIAL\u0010\u0002\u0012\u0016\n\u0012AVATAR_TYPE_MIRROR\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AvatarTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTypeOuterClass$AvatarType.class */
    public enum AvatarType implements ProtocolMessageEnum {
        AVATAR_TYPE_NONE(0),
        AVATAR_TYPE_FORMAL(1),
        AVATAR_TYPE_TRIAL(2),
        AVATAR_TYPE_MIRROR(3),
        UNRECOGNIZED(-1);
        
        public static final int AVATAR_TYPE_NONE_VALUE = 0;
        public static final int AVATAR_TYPE_FORMAL_VALUE = 1;
        public static final int AVATAR_TYPE_TRIAL_VALUE = 2;
        public static final int AVATAR_TYPE_MIRROR_VALUE = 3;
        private static final Internal.EnumLiteMap<AvatarType> internalValueMap = new Internal.EnumLiteMap<AvatarType>() { // from class: emu.grasscutter.net.proto.AvatarTypeOuterClass.AvatarType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AvatarType findValueByNumber(int number) {
                return AvatarType.forNumber(number);
            }
        };
        private static final AvatarType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AvatarType valueOf(int value) {
            return forNumber(value);
        }

        public static AvatarType forNumber(int value) {
            switch (value) {
                case 0:
                    return AVATAR_TYPE_NONE;
                case 1:
                    return AVATAR_TYPE_FORMAL;
                case 2:
                    return AVATAR_TYPE_TRIAL;
                case 3:
                    return AVATAR_TYPE_MIRROR;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AvatarType> internalGetValueMap() {
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
            return AvatarTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AvatarType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AvatarType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
