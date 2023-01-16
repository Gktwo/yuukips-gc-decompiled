package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GalleryStopReasonOuterClass.class */
public final class GalleryStopReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017GalleryStopReason.proto*\u0004\n\u0011GalleryStopReason\u0012\u001c\n\u0018GALLERY_STOP_REASON_NONE\u0010��\u0012\u001e\n\u001aGALLERY_STOP_REASON_TIMEUP\u0010\u0001\u0012(\n$GALLERY_STOP_REASON_CLIENT_INTERRUPT\u0010\u0002\u0012-\n)GALLERY_STOP_REASON_LUA_INTERRUPT_SUCCESS\u0010\u0003\u0012*\n&GALLERY_STOP_REASON_LUA_INTERRUPT_FAIL\u0010\u0004\u0012)\n%GALLERY_STOP_REASON_OWNER_LEAVE_SCENE\u0010\u0005\u0012(\n$GALLERY_STOP_REASON_PLAY_INIT_FAILED\u0010\u0006\u0012*\n&GALLERY_STOP_REASON_OTHER_PLAYER_ENTER\u0010\u0007\u0012\"\n\u001eGALLERY_STOP_REASON_AVATAR_DIE\u0010\b\u0012 \n\u001cGALLERY_STOP_REASON_FINISHED\u0010\t\u0012&\n\"GALLERY_STOP_REASON_FUNGUS_ALL_DIE\u0010\n\u0012'\n#GALLERY_STOP_REASON_LIFE_COUNT_ZERO\u0010\u000b\u0012+\n'GALLERY_STOP_REASON_Unk3300_DFPLGCGIIDM\u0010\fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private GalleryStopReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GalleryStopReasonOuterClass$GalleryStopReason.class */
    public enum GalleryStopReason implements ProtocolMessageEnum {
        GALLERY_STOP_REASON_NONE(0),
        GALLERY_STOP_REASON_TIMEUP(1),
        GALLERY_STOP_REASON_CLIENT_INTERRUPT(2),
        GALLERY_STOP_REASON_LUA_INTERRUPT_SUCCESS(3),
        GALLERY_STOP_REASON_LUA_INTERRUPT_FAIL(4),
        GALLERY_STOP_REASON_OWNER_LEAVE_SCENE(5),
        GALLERY_STOP_REASON_PLAY_INIT_FAILED(6),
        GALLERY_STOP_REASON_OTHER_PLAYER_ENTER(7),
        GALLERY_STOP_REASON_AVATAR_DIE(8),
        GALLERY_STOP_REASON_FINISHED(9),
        GALLERY_STOP_REASON_FUNGUS_ALL_DIE(10),
        GALLERY_STOP_REASON_LIFE_COUNT_ZERO(11),
        GALLERY_STOP_REASON_Unk3300_DFPLGCGIIDM(12),
        UNRECOGNIZED(-1);
        
        public static final int GALLERY_STOP_REASON_NONE_VALUE = 0;
        public static final int GALLERY_STOP_REASON_TIMEUP_VALUE = 1;
        public static final int GALLERY_STOP_REASON_CLIENT_INTERRUPT_VALUE = 2;
        public static final int GALLERY_STOP_REASON_LUA_INTERRUPT_SUCCESS_VALUE = 3;
        public static final int GALLERY_STOP_REASON_LUA_INTERRUPT_FAIL_VALUE = 4;
        public static final int GALLERY_STOP_REASON_OWNER_LEAVE_SCENE_VALUE = 5;
        public static final int GALLERY_STOP_REASON_PLAY_INIT_FAILED_VALUE = 6;
        public static final int GALLERY_STOP_REASON_OTHER_PLAYER_ENTER_VALUE = 7;
        public static final int GALLERY_STOP_REASON_AVATAR_DIE_VALUE = 8;
        public static final int GALLERY_STOP_REASON_FINISHED_VALUE = 9;
        public static final int GALLERY_STOP_REASON_FUNGUS_ALL_DIE_VALUE = 10;
        public static final int GALLERY_STOP_REASON_LIFE_COUNT_ZERO_VALUE = 11;
        public static final int GALLERY_STOP_REASON_Unk3300_DFPLGCGIIDM_VALUE = 12;
        private static final Internal.EnumLiteMap<GalleryStopReason> internalValueMap = new Internal.EnumLiteMap<GalleryStopReason>() { // from class: emu.grasscutter.net.proto.GalleryStopReasonOuterClass.GalleryStopReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public GalleryStopReason findValueByNumber(int number) {
                return GalleryStopReason.forNumber(number);
            }
        };
        private static final GalleryStopReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static GalleryStopReason valueOf(int value) {
            return forNumber(value);
        }

        public static GalleryStopReason forNumber(int value) {
            switch (value) {
                case 0:
                    return GALLERY_STOP_REASON_NONE;
                case 1:
                    return GALLERY_STOP_REASON_TIMEUP;
                case 2:
                    return GALLERY_STOP_REASON_CLIENT_INTERRUPT;
                case 3:
                    return GALLERY_STOP_REASON_LUA_INTERRUPT_SUCCESS;
                case 4:
                    return GALLERY_STOP_REASON_LUA_INTERRUPT_FAIL;
                case 5:
                    return GALLERY_STOP_REASON_OWNER_LEAVE_SCENE;
                case 6:
                    return GALLERY_STOP_REASON_PLAY_INIT_FAILED;
                case 7:
                    return GALLERY_STOP_REASON_OTHER_PLAYER_ENTER;
                case 8:
                    return GALLERY_STOP_REASON_AVATAR_DIE;
                case 9:
                    return GALLERY_STOP_REASON_FINISHED;
                case 10:
                    return GALLERY_STOP_REASON_FUNGUS_ALL_DIE;
                case 11:
                    return GALLERY_STOP_REASON_LIFE_COUNT_ZERO;
                case 12:
                    return GALLERY_STOP_REASON_Unk3300_DFPLGCGIIDM;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<GalleryStopReason> internalGetValueMap() {
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
            return GalleryStopReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static GalleryStopReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        GalleryStopReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
