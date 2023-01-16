package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterLockStateOuterClass.class */
public final class ReliquaryFilterLockStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eReliquaryFilterLockState.proto*\u0001\n\u0018ReliquaryFilterLockState\u0012$\n RELIQUARY_FILTER_LOCK_STATE_NONE\u0010��\u0012$\n RELIQUARY_FILTER_LOCK_STATE_LOCK\u0010\u0001\u0012&\n\"RELIQUARY_FILTER_LOCK_STATE_UNLOCK\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ReliquaryFilterLockStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterLockStateOuterClass$ReliquaryFilterLockState.class */
    public enum ReliquaryFilterLockState implements ProtocolMessageEnum {
        RELIQUARY_FILTER_LOCK_STATE_NONE(0),
        RELIQUARY_FILTER_LOCK_STATE_LOCK(1),
        RELIQUARY_FILTER_LOCK_STATE_UNLOCK(2),
        UNRECOGNIZED(-1);
        
        public static final int RELIQUARY_FILTER_LOCK_STATE_NONE_VALUE = 0;
        public static final int RELIQUARY_FILTER_LOCK_STATE_LOCK_VALUE = 1;
        public static final int RELIQUARY_FILTER_LOCK_STATE_UNLOCK_VALUE = 2;
        private static final Internal.EnumLiteMap<ReliquaryFilterLockState> internalValueMap = new Internal.EnumLiteMap<ReliquaryFilterLockState>() { // from class: emu.grasscutter.net.proto.ReliquaryFilterLockStateOuterClass.ReliquaryFilterLockState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ReliquaryFilterLockState findValueByNumber(int number) {
                return ReliquaryFilterLockState.forNumber(number);
            }
        };
        private static final ReliquaryFilterLockState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ReliquaryFilterLockState valueOf(int value) {
            return forNumber(value);
        }

        public static ReliquaryFilterLockState forNumber(int value) {
            switch (value) {
                case 0:
                    return RELIQUARY_FILTER_LOCK_STATE_NONE;
                case 1:
                    return RELIQUARY_FILTER_LOCK_STATE_LOCK;
                case 2:
                    return RELIQUARY_FILTER_LOCK_STATE_UNLOCK;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ReliquaryFilterLockState> internalGetValueMap() {
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
            return ReliquaryFilterLockStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ReliquaryFilterLockState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ReliquaryFilterLockState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
