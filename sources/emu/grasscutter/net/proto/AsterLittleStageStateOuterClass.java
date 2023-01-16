package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterLittleStageStateOuterClass.class */
public final class AsterLittleStageStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bAsterLittleStageState.proto*¯\u0001\n\u0015AsterLittleStageState\u0012!\n\u001dASTER_LITTLE_STAGE_STATE_NONE\u0010��\u0012&\n\"ASTER_LITTLE_STAGE_STATE_UNSTARTED\u0010\u0001\u0012$\n ASTER_LITTLE_STAGE_STATE_STARTED\u0010\u0002\u0012%\n!ASTER_LITTLE_STAGE_STATE_FINISHED\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AsterLittleStageStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterLittleStageStateOuterClass$AsterLittleStageState.class */
    public enum AsterLittleStageState implements ProtocolMessageEnum {
        ASTER_LITTLE_STAGE_STATE_NONE(0),
        ASTER_LITTLE_STAGE_STATE_UNSTARTED(1),
        ASTER_LITTLE_STAGE_STATE_STARTED(2),
        ASTER_LITTLE_STAGE_STATE_FINISHED(3),
        UNRECOGNIZED(-1);
        
        public static final int ASTER_LITTLE_STAGE_STATE_NONE_VALUE = 0;
        public static final int ASTER_LITTLE_STAGE_STATE_UNSTARTED_VALUE = 1;
        public static final int ASTER_LITTLE_STAGE_STATE_STARTED_VALUE = 2;
        public static final int ASTER_LITTLE_STAGE_STATE_FINISHED_VALUE = 3;
        private static final Internal.EnumLiteMap<AsterLittleStageState> internalValueMap = new Internal.EnumLiteMap<AsterLittleStageState>() { // from class: emu.grasscutter.net.proto.AsterLittleStageStateOuterClass.AsterLittleStageState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AsterLittleStageState findValueByNumber(int number) {
                return AsterLittleStageState.forNumber(number);
            }
        };
        private static final AsterLittleStageState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AsterLittleStageState valueOf(int value) {
            return forNumber(value);
        }

        public static AsterLittleStageState forNumber(int value) {
            switch (value) {
                case 0:
                    return ASTER_LITTLE_STAGE_STATE_NONE;
                case 1:
                    return ASTER_LITTLE_STAGE_STATE_UNSTARTED;
                case 2:
                    return ASTER_LITTLE_STAGE_STATE_STARTED;
                case 3:
                    return ASTER_LITTLE_STAGE_STATE_FINISHED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AsterLittleStageState> internalGetValueMap() {
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
            return AsterLittleStageStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AsterLittleStageState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AsterLittleStageState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
