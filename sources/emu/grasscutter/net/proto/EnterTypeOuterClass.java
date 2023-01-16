package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterTypeOuterClass.class */
public final class EnterTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fEnterType.proto*³\u0002\n\tEnterType\u0012\u0013\n\u000fENTER_TYPE_NONE\u0010��\u0012\u0013\n\u000fENTER_TYPE_SELF\u0010\u0001\u0012\u0013\n\u000fENTER_TYPE_GOTO\u0010\u0002\u0012\u0013\n\u000fENTER_TYPE_JUMP\u0010\u0003\u0012\u0014\n\u0010ENTER_TYPE_OTHER\u0010\u0004\u0012\u0013\n\u000fENTER_TYPE_BACK\u0010\u0005\u0012\u0016\n\u0012ENTER_TYPE_DUNGEON\u0010\u0006\u0012\u001d\n\u0019ENTER_TYPE_DUNGEON_REPLAY\u0010\u0007\u0012\u001d\n\u0019ENTER_TYPE_GOTO_BY_PORTAL\u0010\b\u0012\u0018\n\u0014ENTER_TYPE_SELF_HOME\u0010\t\u0012\u0019\n\u0015ENTER_TYPE_OTHER_HOME\u0010\n\u0012\u001c\n\u0018ENTER_TYPE_GOTO_RECREATE\u0010\u000bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private EnterTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EnterTypeOuterClass$EnterType.class */
    public enum EnterType implements ProtocolMessageEnum {
        ENTER_TYPE_NONE(0),
        ENTER_TYPE_SELF(1),
        ENTER_TYPE_GOTO(2),
        ENTER_TYPE_JUMP(3),
        ENTER_TYPE_OTHER(4),
        ENTER_TYPE_BACK(5),
        ENTER_TYPE_DUNGEON(6),
        ENTER_TYPE_DUNGEON_REPLAY(7),
        ENTER_TYPE_GOTO_BY_PORTAL(8),
        ENTER_TYPE_SELF_HOME(9),
        ENTER_TYPE_OTHER_HOME(10),
        ENTER_TYPE_GOTO_RECREATE(11),
        UNRECOGNIZED(-1);
        
        public static final int ENTER_TYPE_NONE_VALUE = 0;
        public static final int ENTER_TYPE_SELF_VALUE = 1;
        public static final int ENTER_TYPE_GOTO_VALUE = 2;
        public static final int ENTER_TYPE_JUMP_VALUE = 3;
        public static final int ENTER_TYPE_OTHER_VALUE = 4;
        public static final int ENTER_TYPE_BACK_VALUE = 5;
        public static final int ENTER_TYPE_DUNGEON_VALUE = 6;
        public static final int ENTER_TYPE_DUNGEON_REPLAY_VALUE = 7;
        public static final int ENTER_TYPE_GOTO_BY_PORTAL_VALUE = 8;
        public static final int ENTER_TYPE_SELF_HOME_VALUE = 9;
        public static final int ENTER_TYPE_OTHER_HOME_VALUE = 10;
        public static final int ENTER_TYPE_GOTO_RECREATE_VALUE = 11;
        private static final Internal.EnumLiteMap<EnterType> internalValueMap = new Internal.EnumLiteMap<EnterType>() { // from class: emu.grasscutter.net.proto.EnterTypeOuterClass.EnterType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public EnterType findValueByNumber(int number) {
                return EnterType.forNumber(number);
            }
        };
        private static final EnterType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static EnterType valueOf(int value) {
            return forNumber(value);
        }

        public static EnterType forNumber(int value) {
            switch (value) {
                case 0:
                    return ENTER_TYPE_NONE;
                case 1:
                    return ENTER_TYPE_SELF;
                case 2:
                    return ENTER_TYPE_GOTO;
                case 3:
                    return ENTER_TYPE_JUMP;
                case 4:
                    return ENTER_TYPE_OTHER;
                case 5:
                    return ENTER_TYPE_BACK;
                case 6:
                    return ENTER_TYPE_DUNGEON;
                case 7:
                    return ENTER_TYPE_DUNGEON_REPLAY;
                case 8:
                    return ENTER_TYPE_GOTO_BY_PORTAL;
                case 9:
                    return ENTER_TYPE_SELF_HOME;
                case 10:
                    return ENTER_TYPE_OTHER_HOME;
                case 11:
                    return ENTER_TYPE_GOTO_RECREATE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<EnterType> internalGetValueMap() {
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
            return EnterTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static EnterType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        EnterType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
