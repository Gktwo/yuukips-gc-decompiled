package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameUnknown2EnumOuterClass.class */
public final class MusicGameUnknown2EnumOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bMusicGameUnknown2Enum.proto*s\n\u0015MusicGameUnknown2Enum\u0012\u001c\n\u0018MusicGameUnknown2Enum_u1\u0010��\u0012\u001e\n\u001aMusicGameUnknown2Enum_MINE\u0010\u0001\u0012\u001c\n\u0018MusicGameUnknown2Enum_u3\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MusicGameUnknown2EnumOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameUnknown2EnumOuterClass$MusicGameUnknown2Enum.class */
    public enum MusicGameUnknown2Enum implements ProtocolMessageEnum {
        MusicGameUnknown2Enum_u1(0),
        MusicGameUnknown2Enum_MINE(1),
        MusicGameUnknown2Enum_u3(2),
        UNRECOGNIZED(-1);
        
        public static final int MusicGameUnknown2Enum_u1_VALUE = 0;
        public static final int MusicGameUnknown2Enum_MINE_VALUE = 1;
        public static final int MusicGameUnknown2Enum_u3_VALUE = 2;
        private static final Internal.EnumLiteMap<MusicGameUnknown2Enum> internalValueMap = new Internal.EnumLiteMap<MusicGameUnknown2Enum>() { // from class: emu.grasscutter.net.proto.MusicGameUnknown2EnumOuterClass.MusicGameUnknown2Enum.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MusicGameUnknown2Enum findValueByNumber(int number) {
                return MusicGameUnknown2Enum.forNumber(number);
            }
        };
        private static final MusicGameUnknown2Enum[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MusicGameUnknown2Enum valueOf(int value) {
            return forNumber(value);
        }

        public static MusicGameUnknown2Enum forNumber(int value) {
            switch (value) {
                case 0:
                    return MusicGameUnknown2Enum_u1;
                case 1:
                    return MusicGameUnknown2Enum_MINE;
                case 2:
                    return MusicGameUnknown2Enum_u3;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MusicGameUnknown2Enum> internalGetValueMap() {
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
            return MusicGameUnknown2EnumOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MusicGameUnknown2Enum valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MusicGameUnknown2Enum(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
