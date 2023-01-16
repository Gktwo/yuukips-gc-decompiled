package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionStateOuterClass.class */
public final class ExpeditionStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015ExpeditionState.proto*¥\u0001\n\u000fExpeditionState\u0012\u0019\n\u0015EXPEDITION_STATE_NONE\u0010��\u0012\u001c\n\u0018EXPEDITION_STATE_STARTED\u0010\u0001\u0012\u001d\n\u0019EXPEDITION_STATE_FINISHED\u0010\u0002\u0012\u001d\n\u0019EXPEDITION_STATE_REWARDED\u0010\u0003\u0012\u001b\n\u0017EXPEDITION_STATE_LOCKED\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ExpeditionStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ExpeditionStateOuterClass$ExpeditionState.class */
    public enum ExpeditionState implements ProtocolMessageEnum {
        EXPEDITION_STATE_NONE(0),
        EXPEDITION_STATE_STARTED(1),
        EXPEDITION_STATE_FINISHED(2),
        EXPEDITION_STATE_REWARDED(3),
        EXPEDITION_STATE_LOCKED(4),
        UNRECOGNIZED(-1);
        
        public static final int EXPEDITION_STATE_NONE_VALUE = 0;
        public static final int EXPEDITION_STATE_STARTED_VALUE = 1;
        public static final int EXPEDITION_STATE_FINISHED_VALUE = 2;
        public static final int EXPEDITION_STATE_REWARDED_VALUE = 3;
        public static final int EXPEDITION_STATE_LOCKED_VALUE = 4;
        private static final Internal.EnumLiteMap<ExpeditionState> internalValueMap = new Internal.EnumLiteMap<ExpeditionState>() { // from class: emu.grasscutter.net.proto.ExpeditionStateOuterClass.ExpeditionState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ExpeditionState findValueByNumber(int number) {
                return ExpeditionState.forNumber(number);
            }
        };
        private static final ExpeditionState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ExpeditionState valueOf(int value) {
            return forNumber(value);
        }

        public static ExpeditionState forNumber(int value) {
            switch (value) {
                case 0:
                    return EXPEDITION_STATE_NONE;
                case 1:
                    return EXPEDITION_STATE_STARTED;
                case 2:
                    return EXPEDITION_STATE_FINISHED;
                case 3:
                    return EXPEDITION_STATE_REWARDED;
                case 4:
                    return EXPEDITION_STATE_LOCKED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ExpeditionState> internalGetValueMap() {
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
            return ExpeditionStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ExpeditionState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ExpeditionState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
