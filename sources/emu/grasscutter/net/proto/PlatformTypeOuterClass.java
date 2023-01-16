package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformTypeOuterClass.class */
public final class PlatformTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012PlatformType.proto*¼\u0003\n\fPlatformType\u0012\u0018\n\u0014PLATFORM_TYPE_EDITOR\u0010��\u0012\u0015\n\u0011PLATFORM_TYPE_IOS\u0010\u0001\u0012\u0019\n\u0015PLATFORM_TYPE_ANDROID\u0010\u0002\u0012\u0014\n\u0010PLATFORM_TYPE_PC\u0010\u0003\u0012\u0015\n\u0011PLATFORM_TYPE_PS4\u0010\u0004\u0012\u0018\n\u0014PLATFORM_TYPE_SERVER\u0010\u0005\u0012\u001f\n\u001bPLATFORM_TYPE_CLOUD_ANDROID\u0010\u0006\u0012\u001b\n\u0017PLATFORM_TYPE_CLOUD_IOS\u0010\u0007\u0012\u0015\n\u0011PLATFORM_TYPE_PS5\u0010\b\u0012\u001b\n\u0017PLATFORM_TYPE_CLOUD_WEB\u0010\t\u0012\u001a\n\u0016PLATFORM_TYPE_CLOUD_TV\u0010\n\u0012\u001b\n\u0017PLATFORM_TYPE_CLOUD_MAC\u0010\u000b\u0012\u001a\n\u0016PLATFORM_TYPE_CLOUD_PC\u0010\f\u0012*\n&PLATFORM_TYPE_CLOUD_THIRD_PARTY_MOBILE\u0010\r\u0012&\n\"PLATFORM_TYPE_CLOUD_THIRD_PARTY_PC\u0010\u000eB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private PlatformTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlatformTypeOuterClass$PlatformType.class */
    public enum PlatformType implements ProtocolMessageEnum {
        PLATFORM_TYPE_EDITOR(0),
        PLATFORM_TYPE_IOS(1),
        PLATFORM_TYPE_ANDROID(2),
        PLATFORM_TYPE_PC(3),
        PLATFORM_TYPE_PS4(4),
        PLATFORM_TYPE_SERVER(5),
        PLATFORM_TYPE_CLOUD_ANDROID(6),
        PLATFORM_TYPE_CLOUD_IOS(7),
        PLATFORM_TYPE_PS5(8),
        PLATFORM_TYPE_CLOUD_WEB(9),
        PLATFORM_TYPE_CLOUD_TV(10),
        PLATFORM_TYPE_CLOUD_MAC(11),
        PLATFORM_TYPE_CLOUD_PC(12),
        PLATFORM_TYPE_CLOUD_THIRD_PARTY_MOBILE(13),
        PLATFORM_TYPE_CLOUD_THIRD_PARTY_PC(14),
        UNRECOGNIZED(-1);
        
        public static final int PLATFORM_TYPE_EDITOR_VALUE = 0;
        public static final int PLATFORM_TYPE_IOS_VALUE = 1;
        public static final int PLATFORM_TYPE_ANDROID_VALUE = 2;
        public static final int PLATFORM_TYPE_PC_VALUE = 3;
        public static final int PLATFORM_TYPE_PS4_VALUE = 4;
        public static final int PLATFORM_TYPE_SERVER_VALUE = 5;
        public static final int PLATFORM_TYPE_CLOUD_ANDROID_VALUE = 6;
        public static final int PLATFORM_TYPE_CLOUD_IOS_VALUE = 7;
        public static final int PLATFORM_TYPE_PS5_VALUE = 8;
        public static final int PLATFORM_TYPE_CLOUD_WEB_VALUE = 9;
        public static final int PLATFORM_TYPE_CLOUD_TV_VALUE = 10;
        public static final int PLATFORM_TYPE_CLOUD_MAC_VALUE = 11;
        public static final int PLATFORM_TYPE_CLOUD_PC_VALUE = 12;
        public static final int PLATFORM_TYPE_CLOUD_THIRD_PARTY_MOBILE_VALUE = 13;
        public static final int PLATFORM_TYPE_CLOUD_THIRD_PARTY_PC_VALUE = 14;
        private static final Internal.EnumLiteMap<PlatformType> internalValueMap = new Internal.EnumLiteMap<PlatformType>() { // from class: emu.grasscutter.net.proto.PlatformTypeOuterClass.PlatformType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PlatformType findValueByNumber(int number) {
                return PlatformType.forNumber(number);
            }
        };
        private static final PlatformType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static PlatformType valueOf(int value) {
            return forNumber(value);
        }

        public static PlatformType forNumber(int value) {
            switch (value) {
                case 0:
                    return PLATFORM_TYPE_EDITOR;
                case 1:
                    return PLATFORM_TYPE_IOS;
                case 2:
                    return PLATFORM_TYPE_ANDROID;
                case 3:
                    return PLATFORM_TYPE_PC;
                case 4:
                    return PLATFORM_TYPE_PS4;
                case 5:
                    return PLATFORM_TYPE_SERVER;
                case 6:
                    return PLATFORM_TYPE_CLOUD_ANDROID;
                case 7:
                    return PLATFORM_TYPE_CLOUD_IOS;
                case 8:
                    return PLATFORM_TYPE_PS5;
                case 9:
                    return PLATFORM_TYPE_CLOUD_WEB;
                case 10:
                    return PLATFORM_TYPE_CLOUD_TV;
                case 11:
                    return PLATFORM_TYPE_CLOUD_MAC;
                case 12:
                    return PLATFORM_TYPE_CLOUD_PC;
                case 13:
                    return PLATFORM_TYPE_CLOUD_THIRD_PARTY_MOBILE;
                case 14:
                    return PLATFORM_TYPE_CLOUD_THIRD_PARTY_PC;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<PlatformType> internalGetValueMap() {
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
            return PlatformTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static PlatformType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        PlatformType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
