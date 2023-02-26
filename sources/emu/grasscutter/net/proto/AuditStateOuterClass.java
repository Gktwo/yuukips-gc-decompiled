package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AuditStateOuterClass.class */
public final class AuditStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010AuditState.proto*S\n\nAuditState\u0012\u0014\n\u0010AUDIT_STATE_NONE\u0010��\u0012\u0017\n\u0013AUDIT_STATE_WAITING\u0010\u0001\u0012\u0016\n\u0012AUDIT_STATE_FAILED\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AuditStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AuditStateOuterClass$AuditState.class */
    public enum AuditState implements ProtocolMessageEnum {
        AUDIT_STATE_NONE(0),
        AUDIT_STATE_WAITING(1),
        AUDIT_STATE_FAILED(2),
        UNRECOGNIZED(-1);
        
        public static final int AUDIT_STATE_NONE_VALUE = 0;
        public static final int AUDIT_STATE_WAITING_VALUE = 1;
        public static final int AUDIT_STATE_FAILED_VALUE = 2;
        private static final Internal.EnumLiteMap<AuditState> internalValueMap = new Internal.EnumLiteMap<AuditState>() { // from class: emu.grasscutter.net.proto.AuditStateOuterClass.AuditState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AuditState findValueByNumber(int number) {
                return AuditState.forNumber(number);
            }
        };
        private static final AuditState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AuditState valueOf(int value) {
            return forNumber(value);
        }

        public static AuditState forNumber(int value) {
            switch (value) {
                case 0:
                    return AUDIT_STATE_NONE;
                case 1:
                    return AUDIT_STATE_WAITING;
                case 2:
                    return AUDIT_STATE_FAILED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AuditState> internalGetValueMap() {
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
            return AuditStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AuditState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AuditState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
