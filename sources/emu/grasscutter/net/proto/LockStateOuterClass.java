package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockStateOuterClass.class */
public final class LockStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fLockState.proto*6\n\tLockState\u0012\u0013\n\u000fLOCK_STATE_NONE\u0010��\u0012\u0014\n\u0010LOCK_STATE_QUEST\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private LockStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockStateOuterClass$LockState.class */
    public enum LockState implements ProtocolMessageEnum {
        LOCK_STATE_NONE(0),
        LOCK_STATE_QUEST(1),
        UNRECOGNIZED(-1);
        
        public static final int LOCK_STATE_NONE_VALUE = 0;
        public static final int LOCK_STATE_QUEST_VALUE = 1;
        private static final Internal.EnumLiteMap<LockState> internalValueMap = new Internal.EnumLiteMap<LockState>() { // from class: emu.grasscutter.net.proto.LockStateOuterClass.LockState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LockState findValueByNumber(int number) {
                return LockState.forNumber(number);
            }
        };
        private static final LockState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static LockState valueOf(int value) {
            return forNumber(value);
        }

        public static LockState forNumber(int value) {
            switch (value) {
                case 0:
                    return LOCK_STATE_NONE;
                case 1:
                    return LOCK_STATE_QUEST;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LockState> internalGetValueMap() {
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
            return LockStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static LockState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        LockState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
