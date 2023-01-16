package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityPushTipsStateOuterClass.class */
public final class ActivityPushTipsStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bActivityPushTipsState.proto*\u0001\n\u0015ActivityPushTipsState\u0012!\n\u001dACTIVITY_PUSH_TIPS_STATE_NONE\u0010��\u0012\"\n\u001eACTIVITY_PUSH_TIPS_STATE_START\u0010\u0001\u0012!\n\u001dACTIVITY_PUSH_TIPS_STATE_READ\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ActivityPushTipsStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityPushTipsStateOuterClass$ActivityPushTipsState.class */
    public enum ActivityPushTipsState implements ProtocolMessageEnum {
        ACTIVITY_PUSH_TIPS_STATE_NONE(0),
        ACTIVITY_PUSH_TIPS_STATE_START(1),
        ACTIVITY_PUSH_TIPS_STATE_READ(2),
        UNRECOGNIZED(-1);
        
        public static final int ACTIVITY_PUSH_TIPS_STATE_NONE_VALUE = 0;
        public static final int ACTIVITY_PUSH_TIPS_STATE_START_VALUE = 1;
        public static final int ACTIVITY_PUSH_TIPS_STATE_READ_VALUE = 2;
        private static final Internal.EnumLiteMap<ActivityPushTipsState> internalValueMap = new Internal.EnumLiteMap<ActivityPushTipsState>() { // from class: emu.grasscutter.net.proto.ActivityPushTipsStateOuterClass.ActivityPushTipsState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ActivityPushTipsState findValueByNumber(int number) {
                return ActivityPushTipsState.forNumber(number);
            }
        };
        private static final ActivityPushTipsState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ActivityPushTipsState valueOf(int value) {
            return forNumber(value);
        }

        public static ActivityPushTipsState forNumber(int value) {
            switch (value) {
                case 0:
                    return ACTIVITY_PUSH_TIPS_STATE_NONE;
                case 1:
                    return ACTIVITY_PUSH_TIPS_STATE_START;
                case 2:
                    return ACTIVITY_PUSH_TIPS_STATE_READ;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ActivityPushTipsState> internalGetValueMap() {
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
            return ActivityPushTipsStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ActivityPushTipsState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ActivityPushTipsState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
