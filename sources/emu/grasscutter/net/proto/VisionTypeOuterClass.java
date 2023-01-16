package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VisionTypeOuterClass.class */
public final class VisionTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010VisionType.proto*®\u0004\n\nVisionType\u0012\u0014\n\u0010VISION_TYPE_NONE\u0010��\u0012\u0014\n\u0010VISION_TYPE_MEET\u0010\u0001\u0012\u0016\n\u0012VISION_TYPE_REBORN\u0010\u0002\u0012\u0017\n\u0013VISION_TYPE_REPLACE\u0010\u0003\u0012\u001f\n\u001bVISION_TYPE_WAYPOINT_REBORN\u0010\u0004\u0012\u0014\n\u0010VISION_TYPE_MISS\u0010\u0005\u0012\u0013\n\u000fVISION_TYPE_DIE\u0010\u0006\u0012\u001d\n\u0019VISION_TYPE_GATHER_ESCAPE\u0010\u0007\u0012\u0017\n\u0013VISION_TYPE_REFRESH\u0010\b\u0012\u0019\n\u0015VISION_TYPE_TRANSPORT\u0010\t\u0012\u001b\n\u0017VISION_TYPE_REPLACE_DIE\u0010\n\u0012!\n\u001dVISION_TYPE_REPLACE_NO_NOTIFY\u0010\u000b\u0012\u0014\n\u0010VISION_TYPE_BORN\u0010\f\u0012\u0016\n\u0012VISION_TYPE_PICKUP\u0010\r\u0012\u0016\n\u0012VISION_TYPE_REMOVE\u0010\u000e\u0012\u001e\n\u001aVISION_TYPE_CHANGE_COSTUME\u0010\u000f\u0012\u001c\n\u0018VISION_TYPE_FISH_REFRESH\u0010\u0010\u0012\u001e\n\u001aVISION_TYPE_FISH_BIG_SHOCK\u0010\u0011\u0012\u001d\n\u0019VISION_TYPE_FISH_QTE_SUCC\u0010\u0012\u0012!\n\u001dVISION_TYPE_CAPTURE_DISAPPEAR\u0010\u0013B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private VisionTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VisionTypeOuterClass$VisionType.class */
    public enum VisionType implements ProtocolMessageEnum {
        VISION_TYPE_NONE(0),
        VISION_TYPE_MEET(1),
        VISION_TYPE_REBORN(2),
        VISION_TYPE_REPLACE(3),
        VISION_TYPE_WAYPOINT_REBORN(4),
        VISION_TYPE_MISS(5),
        VISION_TYPE_DIE(6),
        VISION_TYPE_GATHER_ESCAPE(7),
        VISION_TYPE_REFRESH(8),
        VISION_TYPE_TRANSPORT(9),
        VISION_TYPE_REPLACE_DIE(10),
        VISION_TYPE_REPLACE_NO_NOTIFY(11),
        VISION_TYPE_BORN(12),
        VISION_TYPE_PICKUP(13),
        VISION_TYPE_REMOVE(14),
        VISION_TYPE_CHANGE_COSTUME(15),
        VISION_TYPE_FISH_REFRESH(16),
        VISION_TYPE_FISH_BIG_SHOCK(17),
        VISION_TYPE_FISH_QTE_SUCC(18),
        VISION_TYPE_CAPTURE_DISAPPEAR(19),
        UNRECOGNIZED(-1);
        
        public static final int VISION_TYPE_NONE_VALUE = 0;
        public static final int VISION_TYPE_MEET_VALUE = 1;
        public static final int VISION_TYPE_REBORN_VALUE = 2;
        public static final int VISION_TYPE_REPLACE_VALUE = 3;
        public static final int VISION_TYPE_WAYPOINT_REBORN_VALUE = 4;
        public static final int VISION_TYPE_MISS_VALUE = 5;
        public static final int VISION_TYPE_DIE_VALUE = 6;
        public static final int VISION_TYPE_GATHER_ESCAPE_VALUE = 7;
        public static final int VISION_TYPE_REFRESH_VALUE = 8;
        public static final int VISION_TYPE_TRANSPORT_VALUE = 9;
        public static final int VISION_TYPE_REPLACE_DIE_VALUE = 10;
        public static final int VISION_TYPE_REPLACE_NO_NOTIFY_VALUE = 11;
        public static final int VISION_TYPE_BORN_VALUE = 12;
        public static final int VISION_TYPE_PICKUP_VALUE = 13;
        public static final int VISION_TYPE_REMOVE_VALUE = 14;
        public static final int VISION_TYPE_CHANGE_COSTUME_VALUE = 15;
        public static final int VISION_TYPE_FISH_REFRESH_VALUE = 16;
        public static final int VISION_TYPE_FISH_BIG_SHOCK_VALUE = 17;
        public static final int VISION_TYPE_FISH_QTE_SUCC_VALUE = 18;
        public static final int VISION_TYPE_CAPTURE_DISAPPEAR_VALUE = 19;
        private static final Internal.EnumLiteMap<VisionType> internalValueMap = new Internal.EnumLiteMap<VisionType>() { // from class: emu.grasscutter.net.proto.VisionTypeOuterClass.VisionType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public VisionType findValueByNumber(int number) {
                return VisionType.forNumber(number);
            }
        };
        private static final VisionType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static VisionType valueOf(int value) {
            return forNumber(value);
        }

        public static VisionType forNumber(int value) {
            switch (value) {
                case 0:
                    return VISION_TYPE_NONE;
                case 1:
                    return VISION_TYPE_MEET;
                case 2:
                    return VISION_TYPE_REBORN;
                case 3:
                    return VISION_TYPE_REPLACE;
                case 4:
                    return VISION_TYPE_WAYPOINT_REBORN;
                case 5:
                    return VISION_TYPE_MISS;
                case 6:
                    return VISION_TYPE_DIE;
                case 7:
                    return VISION_TYPE_GATHER_ESCAPE;
                case 8:
                    return VISION_TYPE_REFRESH;
                case 9:
                    return VISION_TYPE_TRANSPORT;
                case 10:
                    return VISION_TYPE_REPLACE_DIE;
                case 11:
                    return VISION_TYPE_REPLACE_NO_NOTIFY;
                case 12:
                    return VISION_TYPE_BORN;
                case 13:
                    return VISION_TYPE_PICKUP;
                case 14:
                    return VISION_TYPE_REMOVE;
                case 15:
                    return VISION_TYPE_CHANGE_COSTUME;
                case 16:
                    return VISION_TYPE_FISH_REFRESH;
                case 17:
                    return VISION_TYPE_FISH_BIG_SHOCK;
                case 18:
                    return VISION_TYPE_FISH_QTE_SUCC;
                case 19:
                    return VISION_TYPE_CAPTURE_DISAPPEAR;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<VisionType> internalGetValueMap() {
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
            return VisionTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static VisionType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        VisionType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
