package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailCollectStateOuterClass.class */
public final class MailCollectStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MailCollectState.proto*Ä\u0001\n\u0010MailCollectState\u0012*\n&MAIL_COLLECT_STATE_COLLECTIBLE_UNKNOWN\u0010��\u0012&\n\"MAIL_COLLECT_STATE_NOT_COLLECTIBLE\u0010\u0001\u0012.\n*MAIL_COLLECT_STATE_COLLECTIBLE_UNCOLLECTED\u0010\u0002\u0012,\n(MAIL_COLLECT_STATE_COLLECTIBLE_COLLECTED\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MailCollectStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailCollectStateOuterClass$MailCollectState.class */
    public enum MailCollectState implements ProtocolMessageEnum {
        MAIL_COLLECT_STATE_COLLECTIBLE_UNKNOWN(0),
        MAIL_COLLECT_STATE_NOT_COLLECTIBLE(1),
        MAIL_COLLECT_STATE_COLLECTIBLE_UNCOLLECTED(2),
        MAIL_COLLECT_STATE_COLLECTIBLE_COLLECTED(3),
        UNRECOGNIZED(-1);
        
        public static final int MAIL_COLLECT_STATE_COLLECTIBLE_UNKNOWN_VALUE = 0;
        public static final int MAIL_COLLECT_STATE_NOT_COLLECTIBLE_VALUE = 1;
        public static final int MAIL_COLLECT_STATE_COLLECTIBLE_UNCOLLECTED_VALUE = 2;
        public static final int MAIL_COLLECT_STATE_COLLECTIBLE_COLLECTED_VALUE = 3;
        private static final Internal.EnumLiteMap<MailCollectState> internalValueMap = new Internal.EnumLiteMap<MailCollectState>() { // from class: emu.grasscutter.net.proto.MailCollectStateOuterClass.MailCollectState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MailCollectState findValueByNumber(int number) {
                return MailCollectState.forNumber(number);
            }
        };
        private static final MailCollectState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MailCollectState valueOf(int value) {
            return forNumber(value);
        }

        public static MailCollectState forNumber(int value) {
            switch (value) {
                case 0:
                    return MAIL_COLLECT_STATE_COLLECTIBLE_UNKNOWN;
                case 1:
                    return MAIL_COLLECT_STATE_NOT_COLLECTIBLE;
                case 2:
                    return MAIL_COLLECT_STATE_COLLECTIBLE_UNCOLLECTED;
                case 3:
                    return MAIL_COLLECT_STATE_COLLECTIBLE_COLLECTED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MailCollectState> internalGetValueMap() {
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
            return MailCollectStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MailCollectState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MailCollectState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
