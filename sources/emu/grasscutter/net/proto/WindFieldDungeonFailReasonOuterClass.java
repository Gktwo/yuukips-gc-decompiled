package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldDungeonFailReasonOuterClass.class */
public final class WindFieldDungeonFailReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n WindFieldDungeonFailReason.proto*\u0002\n\u001aWindFieldDungeonFailReason\u0012'\n#WIND_FIELD_DUNGEON_FAIL_REASON_NONE\u0010��\u0012)\n%WIND_FIELD_DUNGEON_FAIL_REASON_CANCEL\u0010\u0001\u0012*\n&WIND_FIELD_DUNGEON_FAIL_REASON_TIMEOUT\u0010\u0002\u00121\n-WIND_FIELD_DUNGEON_FAIL_REASON_ALL_AVATAR_DIE\u0010\u0003\u00120\n,WIND_FIELD_DUNGEON_FAIL_REASON_LUA_INTERRUPT\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private WindFieldDungeonFailReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldDungeonFailReasonOuterClass$WindFieldDungeonFailReason.class */
    public enum WindFieldDungeonFailReason implements ProtocolMessageEnum {
        WIND_FIELD_DUNGEON_FAIL_REASON_NONE(0),
        WIND_FIELD_DUNGEON_FAIL_REASON_CANCEL(1),
        WIND_FIELD_DUNGEON_FAIL_REASON_TIMEOUT(2),
        WIND_FIELD_DUNGEON_FAIL_REASON_ALL_AVATAR_DIE(3),
        WIND_FIELD_DUNGEON_FAIL_REASON_LUA_INTERRUPT(4),
        UNRECOGNIZED(-1);
        
        public static final int WIND_FIELD_DUNGEON_FAIL_REASON_NONE_VALUE = 0;
        public static final int WIND_FIELD_DUNGEON_FAIL_REASON_CANCEL_VALUE = 1;
        public static final int WIND_FIELD_DUNGEON_FAIL_REASON_TIMEOUT_VALUE = 2;
        public static final int WIND_FIELD_DUNGEON_FAIL_REASON_ALL_AVATAR_DIE_VALUE = 3;
        public static final int WIND_FIELD_DUNGEON_FAIL_REASON_LUA_INTERRUPT_VALUE = 4;
        private static final Internal.EnumLiteMap<WindFieldDungeonFailReason> internalValueMap = new Internal.EnumLiteMap<WindFieldDungeonFailReason>() { // from class: emu.grasscutter.net.proto.WindFieldDungeonFailReasonOuterClass.WindFieldDungeonFailReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public WindFieldDungeonFailReason findValueByNumber(int number) {
                return WindFieldDungeonFailReason.forNumber(number);
            }
        };
        private static final WindFieldDungeonFailReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static WindFieldDungeonFailReason valueOf(int value) {
            return forNumber(value);
        }

        public static WindFieldDungeonFailReason forNumber(int value) {
            switch (value) {
                case 0:
                    return WIND_FIELD_DUNGEON_FAIL_REASON_NONE;
                case 1:
                    return WIND_FIELD_DUNGEON_FAIL_REASON_CANCEL;
                case 2:
                    return WIND_FIELD_DUNGEON_FAIL_REASON_TIMEOUT;
                case 3:
                    return WIND_FIELD_DUNGEON_FAIL_REASON_ALL_AVATAR_DIE;
                case 4:
                    return WIND_FIELD_DUNGEON_FAIL_REASON_LUA_INTERRUPT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<WindFieldDungeonFailReason> internalGetValueMap() {
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
            return WindFieldDungeonFailReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static WindFieldDungeonFailReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        WindFieldDungeonFailReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
