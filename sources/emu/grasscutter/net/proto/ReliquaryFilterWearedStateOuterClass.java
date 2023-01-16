package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterWearedStateOuterClass.class */
public final class ReliquaryFilterWearedStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ReliquaryFilterWearedState.proto*®\u0001\n\u001aReliquaryFilterWearedState\u0012&\n\"RELIQUARY_FILTER_WEARED_STATE_NONE\u0010��\u00121\n-RELIQUARY_FILTER_WEARED_STATE_HAS_BEEN_WEARED\u0010\u0001\u00125\n1RELIQUARY_FILTER_WEARED_STATE_HAS_NOT_BEEN_WEARED\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ReliquaryFilterWearedStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterWearedStateOuterClass$ReliquaryFilterWearedState.class */
    public enum ReliquaryFilterWearedState implements ProtocolMessageEnum {
        RELIQUARY_FILTER_WEARED_STATE_NONE(0),
        RELIQUARY_FILTER_WEARED_STATE_HAS_BEEN_WEARED(1),
        RELIQUARY_FILTER_WEARED_STATE_HAS_NOT_BEEN_WEARED(2),
        UNRECOGNIZED(-1);
        
        public static final int RELIQUARY_FILTER_WEARED_STATE_NONE_VALUE = 0;
        public static final int RELIQUARY_FILTER_WEARED_STATE_HAS_BEEN_WEARED_VALUE = 1;
        public static final int RELIQUARY_FILTER_WEARED_STATE_HAS_NOT_BEEN_WEARED_VALUE = 2;
        private static final Internal.EnumLiteMap<ReliquaryFilterWearedState> internalValueMap = new Internal.EnumLiteMap<ReliquaryFilterWearedState>() { // from class: emu.grasscutter.net.proto.ReliquaryFilterWearedStateOuterClass.ReliquaryFilterWearedState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ReliquaryFilterWearedState findValueByNumber(int number) {
                return ReliquaryFilterWearedState.forNumber(number);
            }
        };
        private static final ReliquaryFilterWearedState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ReliquaryFilterWearedState valueOf(int value) {
            return forNumber(value);
        }

        public static ReliquaryFilterWearedState forNumber(int value) {
            switch (value) {
                case 0:
                    return RELIQUARY_FILTER_WEARED_STATE_NONE;
                case 1:
                    return RELIQUARY_FILTER_WEARED_STATE_HAS_BEEN_WEARED;
                case 2:
                    return RELIQUARY_FILTER_WEARED_STATE_HAS_NOT_BEEN_WEARED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ReliquaryFilterWearedState> internalGetValueMap() {
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
            return ReliquaryFilterWearedStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ReliquaryFilterWearedState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ReliquaryFilterWearedState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
