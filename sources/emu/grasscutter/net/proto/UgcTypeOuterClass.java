package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcTypeOuterClass.class */
public final class UgcTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rUgcType.proto*5\n\u0007UgcType\u0012\u0011\n\rUGC_TYPE_NONE\u0010��\u0012\u0017\n\u0013UGC_TYPE_MUSIC_GAME\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private UgcTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UgcTypeOuterClass$UgcType.class */
    public enum UgcType implements ProtocolMessageEnum {
        UGC_TYPE_NONE(0),
        UGC_TYPE_MUSIC_GAME(1),
        UNRECOGNIZED(-1);
        
        public static final int UGC_TYPE_NONE_VALUE = 0;
        public static final int UGC_TYPE_MUSIC_GAME_VALUE = 1;
        private static final Internal.EnumLiteMap<UgcType> internalValueMap = new Internal.EnumLiteMap<UgcType>() { // from class: emu.grasscutter.net.proto.UgcTypeOuterClass.UgcType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public UgcType findValueByNumber(int number) {
                return UgcType.forNumber(number);
            }
        };
        private static final UgcType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static UgcType valueOf(int value) {
            return forNumber(value);
        }

        public static UgcType forNumber(int value) {
            switch (value) {
                case 0:
                    return UGC_TYPE_NONE;
                case 1:
                    return UGC_TYPE_MUSIC_GAME;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<UgcType> internalGetValueMap() {
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
            return UgcTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static UgcType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        UgcType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
