package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterLevelStateOuterClass.class */
public final class ReliquaryFilterLevelStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fReliquaryFilterLevelState.proto* \u0001\n\u0019ReliquaryFilterLevelState\u0012%\n!RELIQUARY_FILTER_LEVEL_STATE_NONE\u0010��\u0012+\n'RELIQUARY_FILTER_LEVEL_STATE_FULL_LEVEL\u0010\u0001\u0012/\n+RELIQUARY_FILTER_LEVEL_STATE_NOT_FULL_LEVEL\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ReliquaryFilterLevelStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterLevelStateOuterClass$ReliquaryFilterLevelState.class */
    public enum ReliquaryFilterLevelState implements ProtocolMessageEnum {
        RELIQUARY_FILTER_LEVEL_STATE_NONE(0),
        RELIQUARY_FILTER_LEVEL_STATE_FULL_LEVEL(1),
        RELIQUARY_FILTER_LEVEL_STATE_NOT_FULL_LEVEL(2),
        UNRECOGNIZED(-1);
        
        public static final int RELIQUARY_FILTER_LEVEL_STATE_NONE_VALUE = 0;
        public static final int RELIQUARY_FILTER_LEVEL_STATE_FULL_LEVEL_VALUE = 1;
        public static final int RELIQUARY_FILTER_LEVEL_STATE_NOT_FULL_LEVEL_VALUE = 2;
        private static final Internal.EnumLiteMap<ReliquaryFilterLevelState> internalValueMap = new Internal.EnumLiteMap<ReliquaryFilterLevelState>() { // from class: emu.grasscutter.net.proto.ReliquaryFilterLevelStateOuterClass.ReliquaryFilterLevelState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ReliquaryFilterLevelState findValueByNumber(int number) {
                return ReliquaryFilterLevelState.forNumber(number);
            }
        };
        private static final ReliquaryFilterLevelState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ReliquaryFilterLevelState valueOf(int value) {
            return forNumber(value);
        }

        public static ReliquaryFilterLevelState forNumber(int value) {
            switch (value) {
                case 0:
                    return RELIQUARY_FILTER_LEVEL_STATE_NONE;
                case 1:
                    return RELIQUARY_FILTER_LEVEL_STATE_FULL_LEVEL;
                case 2:
                    return RELIQUARY_FILTER_LEVEL_STATE_NOT_FULL_LEVEL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ReliquaryFilterLevelState> internalGetValueMap() {
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
            return ReliquaryFilterLevelStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ReliquaryFilterLevelState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ReliquaryFilterLevelState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
