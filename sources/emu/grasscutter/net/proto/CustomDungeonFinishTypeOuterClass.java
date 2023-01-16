package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomDungeonFinishTypeOuterClass.class */
public final class CustomDungeonFinishTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCustomDungeonFinishType.proto*È\u0001\n\u0017CustomDungeonFinishType\u0012*\n&CUSTOM_DUNGEON_FINISH_TYPE_PLAY_NORMAL\u0010��\u0012'\n#CUSTOM_DUNGEON_FINISH_TYPE_PLAY_TRY\u0010\u0001\u0012'\n#CUSTOM_DUNGEON_FINISH_TYPE_EDIT_TRY\u0010\u0002\u0012/\n+CUSTOM_DUNGEON_FINISH_TYPE_SELF_PLAY_NORMAL\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private CustomDungeonFinishTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CustomDungeonFinishTypeOuterClass$CustomDungeonFinishType.class */
    public enum CustomDungeonFinishType implements ProtocolMessageEnum {
        CUSTOM_DUNGEON_FINISH_TYPE_PLAY_NORMAL(0),
        CUSTOM_DUNGEON_FINISH_TYPE_PLAY_TRY(1),
        CUSTOM_DUNGEON_FINISH_TYPE_EDIT_TRY(2),
        CUSTOM_DUNGEON_FINISH_TYPE_SELF_PLAY_NORMAL(3),
        UNRECOGNIZED(-1);
        
        public static final int CUSTOM_DUNGEON_FINISH_TYPE_PLAY_NORMAL_VALUE = 0;
        public static final int CUSTOM_DUNGEON_FINISH_TYPE_PLAY_TRY_VALUE = 1;
        public static final int CUSTOM_DUNGEON_FINISH_TYPE_EDIT_TRY_VALUE = 2;
        public static final int CUSTOM_DUNGEON_FINISH_TYPE_SELF_PLAY_NORMAL_VALUE = 3;
        private static final Internal.EnumLiteMap<CustomDungeonFinishType> internalValueMap = new Internal.EnumLiteMap<CustomDungeonFinishType>() { // from class: emu.grasscutter.net.proto.CustomDungeonFinishTypeOuterClass.CustomDungeonFinishType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CustomDungeonFinishType findValueByNumber(int number) {
                return CustomDungeonFinishType.forNumber(number);
            }
        };
        private static final CustomDungeonFinishType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static CustomDungeonFinishType valueOf(int value) {
            return forNumber(value);
        }

        public static CustomDungeonFinishType forNumber(int value) {
            switch (value) {
                case 0:
                    return CUSTOM_DUNGEON_FINISH_TYPE_PLAY_NORMAL;
                case 1:
                    return CUSTOM_DUNGEON_FINISH_TYPE_PLAY_TRY;
                case 2:
                    return CUSTOM_DUNGEON_FINISH_TYPE_EDIT_TRY;
                case 3:
                    return CUSTOM_DUNGEON_FINISH_TYPE_SELF_PLAY_NORMAL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<CustomDungeonFinishType> internalGetValueMap() {
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
            return CustomDungeonFinishTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static CustomDungeonFinishType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        CustomDungeonFinishType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
