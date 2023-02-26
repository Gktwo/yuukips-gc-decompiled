package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockReasonOuterClass.class */
public final class LockReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010LockReason.proto*:\n\nLockReason\u0012\u0015\n\u0011LOCK_REASON_LEVEL\u0010��\u0012\u0015\n\u0011LOCK_REASON_QUEST\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private LockReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockReasonOuterClass$LockReason.class */
    public enum LockReason implements ProtocolMessageEnum {
        LOCK_REASON_LEVEL(0),
        LOCK_REASON_QUEST(1),
        UNRECOGNIZED(-1);
        
        public static final int LOCK_REASON_LEVEL_VALUE = 0;
        public static final int LOCK_REASON_QUEST_VALUE = 1;
        private static final Internal.EnumLiteMap<LockReason> internalValueMap = new Internal.EnumLiteMap<LockReason>() { // from class: emu.grasscutter.net.proto.LockReasonOuterClass.LockReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public LockReason findValueByNumber(int number) {
                return LockReason.forNumber(number);
            }
        };
        private static final LockReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static LockReason valueOf(int value) {
            return forNumber(value);
        }

        public static LockReason forNumber(int value) {
            switch (value) {
                case 0:
                    return LOCK_REASON_LEVEL;
                case 1:
                    return LOCK_REASON_QUEST;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<LockReason> internalGetValueMap() {
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
            return LockReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static LockReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        LockReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
