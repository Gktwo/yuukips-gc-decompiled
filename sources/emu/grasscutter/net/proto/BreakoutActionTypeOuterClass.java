package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionTypeOuterClass.class */
public final class BreakoutActionTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018BreakoutActionType.proto*Ë\u0001\n\u0012BreakoutActionType\u0012\u001d\n\u0019BREAKOUT_ACTION_TYPE_NONE\u0010��\u0012$\n BREAKOUT_ACTION_TYPE_LAUNCH_BALL\u0010\u0001\u0012%\n!BREAKOUT_ACTION_TYPE_DESTROY_BALL\u0010\u0002\u0012'\n#BREAKOUT_ACTION_TYPE_FALLING_OBJECT\u0010\u0003\u0012 \n\u001cBREAKOUT_ACTION_TYPE_MISSILE\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private BreakoutActionTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutActionTypeOuterClass$BreakoutActionType.class */
    public enum BreakoutActionType implements ProtocolMessageEnum {
        BREAKOUT_ACTION_TYPE_NONE(0),
        BREAKOUT_ACTION_TYPE_LAUNCH_BALL(1),
        BREAKOUT_ACTION_TYPE_DESTROY_BALL(2),
        BREAKOUT_ACTION_TYPE_FALLING_OBJECT(3),
        BREAKOUT_ACTION_TYPE_MISSILE(4),
        UNRECOGNIZED(-1);
        
        public static final int BREAKOUT_ACTION_TYPE_NONE_VALUE = 0;
        public static final int BREAKOUT_ACTION_TYPE_LAUNCH_BALL_VALUE = 1;
        public static final int BREAKOUT_ACTION_TYPE_DESTROY_BALL_VALUE = 2;
        public static final int BREAKOUT_ACTION_TYPE_FALLING_OBJECT_VALUE = 3;
        public static final int BREAKOUT_ACTION_TYPE_MISSILE_VALUE = 4;
        private static final Internal.EnumLiteMap<BreakoutActionType> internalValueMap = new Internal.EnumLiteMap<BreakoutActionType>() { // from class: emu.grasscutter.net.proto.BreakoutActionTypeOuterClass.BreakoutActionType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public BreakoutActionType findValueByNumber(int number) {
                return BreakoutActionType.forNumber(number);
            }
        };
        private static final BreakoutActionType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static BreakoutActionType valueOf(int value) {
            return forNumber(value);
        }

        public static BreakoutActionType forNumber(int value) {
            switch (value) {
                case 0:
                    return BREAKOUT_ACTION_TYPE_NONE;
                case 1:
                    return BREAKOUT_ACTION_TYPE_LAUNCH_BALL;
                case 2:
                    return BREAKOUT_ACTION_TYPE_DESTROY_BALL;
                case 3:
                    return BREAKOUT_ACTION_TYPE_FALLING_OBJECT;
                case 4:
                    return BREAKOUT_ACTION_TYPE_MISSILE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<BreakoutActionType> internalGetValueMap() {
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
            return BreakoutActionTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static BreakoutActionType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        BreakoutActionType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
