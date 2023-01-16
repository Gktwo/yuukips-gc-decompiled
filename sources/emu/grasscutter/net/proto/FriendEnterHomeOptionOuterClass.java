package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendEnterHomeOptionOuterClass.class */
public final class FriendEnterHomeOptionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bFriendEnterHomeOption.proto*\u0001\n\u0015FriendEnterHomeOption\u0012)\n%FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM\u0010��\u0012#\n\u001fFRIEND_ENTER_HOME_OPTION_REFUSE\u0010\u0001\u0012#\n\u001fFRIEND_ENTER_HOME_OPTION_DIRECT\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private FriendEnterHomeOptionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendEnterHomeOptionOuterClass$FriendEnterHomeOption.class */
    public enum FriendEnterHomeOption implements ProtocolMessageEnum {
        FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM(0),
        FRIEND_ENTER_HOME_OPTION_REFUSE(1),
        FRIEND_ENTER_HOME_OPTION_DIRECT(2),
        UNRECOGNIZED(-1);
        
        public static final int FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM_VALUE = 0;
        public static final int FRIEND_ENTER_HOME_OPTION_REFUSE_VALUE = 1;
        public static final int FRIEND_ENTER_HOME_OPTION_DIRECT_VALUE = 2;
        private static final Internal.EnumLiteMap<FriendEnterHomeOption> internalValueMap = new Internal.EnumLiteMap<FriendEnterHomeOption>() { // from class: emu.grasscutter.net.proto.FriendEnterHomeOptionOuterClass.FriendEnterHomeOption.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FriendEnterHomeOption findValueByNumber(int number) {
                return FriendEnterHomeOption.forNumber(number);
            }
        };
        private static final FriendEnterHomeOption[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static FriendEnterHomeOption valueOf(int value) {
            return forNumber(value);
        }

        public static FriendEnterHomeOption forNumber(int value) {
            switch (value) {
                case 0:
                    return FRIEND_ENTER_HOME_OPTION_NEED_CONFIRM;
                case 1:
                    return FRIEND_ENTER_HOME_OPTION_REFUSE;
                case 2:
                    return FRIEND_ENTER_HOME_OPTION_DIRECT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<FriendEnterHomeOption> internalGetValueMap() {
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
            return FriendEnterHomeOptionOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static FriendEnterHomeOption valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        FriendEnterHomeOption(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
