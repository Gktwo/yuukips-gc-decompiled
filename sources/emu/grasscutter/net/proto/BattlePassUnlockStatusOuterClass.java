package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassUnlockStatusOuterClass.class */
public final class BattlePassUnlockStatusOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cBattlePassUnlockStatus.proto*\u0001\n\u0016BattlePassUnlockStatus\u0012%\n!BATTLE_PASS_UNLOCK_STATUS_INVALID\u0010��\u0012\"\n\u001eBATTLE_PASS_UNLOCK_STATUS_FREE\u0010\u0001\u0012\"\n\u001eBATTLE_PASS_UNLOCK_STATUS_PAID\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private BattlePassUnlockStatusOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassUnlockStatusOuterClass$BattlePassUnlockStatus.class */
    public enum BattlePassUnlockStatus implements ProtocolMessageEnum {
        BATTLE_PASS_UNLOCK_STATUS_INVALID(0),
        BATTLE_PASS_UNLOCK_STATUS_FREE(1),
        BATTLE_PASS_UNLOCK_STATUS_PAID(2),
        UNRECOGNIZED(-1);
        
        public static final int BATTLE_PASS_UNLOCK_STATUS_INVALID_VALUE = 0;
        public static final int BATTLE_PASS_UNLOCK_STATUS_FREE_VALUE = 1;
        public static final int BATTLE_PASS_UNLOCK_STATUS_PAID_VALUE = 2;
        private static final Internal.EnumLiteMap<BattlePassUnlockStatus> internalValueMap = new Internal.EnumLiteMap<BattlePassUnlockStatus>() { // from class: emu.grasscutter.net.proto.BattlePassUnlockStatusOuterClass.BattlePassUnlockStatus.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public BattlePassUnlockStatus findValueByNumber(int number) {
                return BattlePassUnlockStatus.forNumber(number);
            }
        };
        private static final BattlePassUnlockStatus[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static BattlePassUnlockStatus valueOf(int value) {
            return forNumber(value);
        }

        public static BattlePassUnlockStatus forNumber(int value) {
            switch (value) {
                case 0:
                    return BATTLE_PASS_UNLOCK_STATUS_INVALID;
                case 1:
                    return BATTLE_PASS_UNLOCK_STATUS_FREE;
                case 2:
                    return BATTLE_PASS_UNLOCK_STATUS_PAID;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<BattlePassUnlockStatus> internalGetValueMap() {
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
            return BattlePassUnlockStatusOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static BattlePassUnlockStatus valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        BattlePassUnlockStatus(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
