package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameUnknown1EnumOuterClass.class */
public final class MusicGameUnknown1EnumOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bMusicGameUnknown1Enum.proto*U\n\u0015MusicGameUnknown1Enum\u0012\u001e\n\u001aMusicGameUnknown1Enum_NONE\u0010��\u0012\u001c\n\u0018MusicGameUnknown1Enum_u2\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MusicGameUnknown1EnumOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameUnknown1EnumOuterClass$MusicGameUnknown1Enum.class */
    public enum MusicGameUnknown1Enum implements ProtocolMessageEnum {
        MusicGameUnknown1Enum_NONE(0),
        MusicGameUnknown1Enum_u2(1),
        UNRECOGNIZED(-1);
        
        public static final int MusicGameUnknown1Enum_NONE_VALUE = 0;
        public static final int MusicGameUnknown1Enum_u2_VALUE = 1;
        private static final Internal.EnumLiteMap<MusicGameUnknown1Enum> internalValueMap = new Internal.EnumLiteMap<MusicGameUnknown1Enum>() { // from class: emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MusicGameUnknown1Enum findValueByNumber(int number) {
                return MusicGameUnknown1Enum.forNumber(number);
            }
        };
        private static final MusicGameUnknown1Enum[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MusicGameUnknown1Enum valueOf(int value) {
            return forNumber(value);
        }

        public static MusicGameUnknown1Enum forNumber(int value) {
            switch (value) {
                case 0:
                    return MusicGameUnknown1Enum_NONE;
                case 1:
                    return MusicGameUnknown1Enum_u2;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MusicGameUnknown1Enum> internalGetValueMap() {
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
            return MusicGameUnknown1EnumOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MusicGameUnknown1Enum valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MusicGameUnknown1Enum(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
