package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendOnlineStateOuterClass.class */
public final class FriendOnlineStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017FriendOnlineState.proto*W\n\u0011FriendOnlineState\u0012\"\n\u001eFRIEND_ONLINE_STATE_DISCONNECT\u0010��\u0012\u001e\n\u001aFRIEND_ONLINE_STATE_ONLINE\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private FriendOnlineStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FriendOnlineStateOuterClass$FriendOnlineState.class */
    public enum FriendOnlineState implements ProtocolMessageEnum {
        FRIEND_ONLINE_STATE_DISCONNECT(0),
        FRIEND_ONLINE_STATE_ONLINE(1),
        UNRECOGNIZED(-1);
        
        public static final int FRIEND_ONLINE_STATE_DISCONNECT_VALUE = 0;
        public static final int FRIEND_ONLINE_STATE_ONLINE_VALUE = 1;
        private static final Internal.EnumLiteMap<FriendOnlineState> internalValueMap = new Internal.EnumLiteMap<FriendOnlineState>() { // from class: emu.grasscutter.net.proto.FriendOnlineStateOuterClass.FriendOnlineState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FriendOnlineState findValueByNumber(int number) {
                return FriendOnlineState.forNumber(number);
            }
        };
        private static final FriendOnlineState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static FriendOnlineState valueOf(int value) {
            return forNumber(value);
        }

        public static FriendOnlineState forNumber(int value) {
            switch (value) {
                case 0:
                    return FRIEND_ONLINE_STATE_DISCONNECT;
                case 1:
                    return FRIEND_ONLINE_STATE_ONLINE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<FriendOnlineState> internalGetValueMap() {
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
            return FriendOnlineStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static FriendOnlineState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        FriendOnlineState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
