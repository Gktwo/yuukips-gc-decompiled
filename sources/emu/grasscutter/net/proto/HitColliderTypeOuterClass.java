package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitColliderTypeOuterClass.class */
public final class HitColliderTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015HitColliderType.proto*\u0001\n\u000fHitColliderType\u0012\u001d\n\u0019HIT_COLLIDER_TYPE_INVALID\u0010��\u0012\u001d\n\u0019HIT_COLLIDER_TYPE_HIT_BOX\u0010\u0001\u0012!\n\u001dHIT_COLLIDER_TYPE_WET_HIT_BOX\u0010\u0002\u0012\u001e\n\u001aHIT_COLLIDER_TYPE_HEAD_BOX\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private HitColliderTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitColliderTypeOuterClass$HitColliderType.class */
    public enum HitColliderType implements ProtocolMessageEnum {
        HIT_COLLIDER_TYPE_INVALID(0),
        HIT_COLLIDER_TYPE_HIT_BOX(1),
        HIT_COLLIDER_TYPE_WET_HIT_BOX(2),
        HIT_COLLIDER_TYPE_HEAD_BOX(3),
        UNRECOGNIZED(-1);
        
        public static final int HIT_COLLIDER_TYPE_INVALID_VALUE = 0;
        public static final int HIT_COLLIDER_TYPE_HIT_BOX_VALUE = 1;
        public static final int HIT_COLLIDER_TYPE_WET_HIT_BOX_VALUE = 2;
        public static final int HIT_COLLIDER_TYPE_HEAD_BOX_VALUE = 3;
        private static final Internal.EnumLiteMap<HitColliderType> internalValueMap = new Internal.EnumLiteMap<HitColliderType>() { // from class: emu.grasscutter.net.proto.HitColliderTypeOuterClass.HitColliderType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public HitColliderType findValueByNumber(int number) {
                return HitColliderType.forNumber(number);
            }
        };
        private static final HitColliderType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static HitColliderType valueOf(int value) {
            return forNumber(value);
        }

        public static HitColliderType forNumber(int value) {
            switch (value) {
                case 0:
                    return HIT_COLLIDER_TYPE_INVALID;
                case 1:
                    return HIT_COLLIDER_TYPE_HIT_BOX;
                case 2:
                    return HIT_COLLIDER_TYPE_WET_HIT_BOX;
                case 3:
                    return HIT_COLLIDER_TYPE_HEAD_BOX;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<HitColliderType> internalGetValueMap() {
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
            return HitColliderTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static HitColliderType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        HitColliderType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
