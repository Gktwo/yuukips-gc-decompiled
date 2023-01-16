package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapReqTypeOuterClass.class */
public final class MusicGameGetBeatmapReqTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n MusicGameGetBeatmapReqType.proto*Ë\u0001\n\u001aMusicGameGetBeatmapReqType\u0012!\n\u001dMusicGameGetBeatmapReqType_u1\u0010��\u0012!\n\u001dMusicGameGetBeatmapReqType_u2\u0010\u0001\u0012!\n\u001dMusicGameGetBeatmapReqType_u3\u0010\u0002\u0012!\n\u001dMusicGameGetBeatmapReqType_u4\u0010\u0003\u0012!\n\u001dMusicGameGetBeatmapReqType_u5\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MusicGameGetBeatmapReqTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameGetBeatmapReqTypeOuterClass$MusicGameGetBeatmapReqType.class */
    public enum MusicGameGetBeatmapReqType implements ProtocolMessageEnum {
        MusicGameGetBeatmapReqType_u1(0),
        MusicGameGetBeatmapReqType_u2(1),
        MusicGameGetBeatmapReqType_u3(2),
        MusicGameGetBeatmapReqType_u4(3),
        MusicGameGetBeatmapReqType_u5(4),
        UNRECOGNIZED(-1);
        
        public static final int MusicGameGetBeatmapReqType_u1_VALUE = 0;
        public static final int MusicGameGetBeatmapReqType_u2_VALUE = 1;
        public static final int MusicGameGetBeatmapReqType_u3_VALUE = 2;
        public static final int MusicGameGetBeatmapReqType_u4_VALUE = 3;
        public static final int MusicGameGetBeatmapReqType_u5_VALUE = 4;
        private static final Internal.EnumLiteMap<MusicGameGetBeatmapReqType> internalValueMap = new Internal.EnumLiteMap<MusicGameGetBeatmapReqType>() { // from class: emu.grasscutter.net.proto.MusicGameGetBeatmapReqTypeOuterClass.MusicGameGetBeatmapReqType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MusicGameGetBeatmapReqType findValueByNumber(int number) {
                return MusicGameGetBeatmapReqType.forNumber(number);
            }
        };
        private static final MusicGameGetBeatmapReqType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MusicGameGetBeatmapReqType valueOf(int value) {
            return forNumber(value);
        }

        public static MusicGameGetBeatmapReqType forNumber(int value) {
            switch (value) {
                case 0:
                    return MusicGameGetBeatmapReqType_u1;
                case 1:
                    return MusicGameGetBeatmapReqType_u2;
                case 2:
                    return MusicGameGetBeatmapReqType_u3;
                case 3:
                    return MusicGameGetBeatmapReqType_u4;
                case 4:
                    return MusicGameGetBeatmapReqType_u5;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MusicGameGetBeatmapReqType> internalGetValueMap() {
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
            return MusicGameGetBeatmapReqTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MusicGameGetBeatmapReqType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MusicGameGetBeatmapReqType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
