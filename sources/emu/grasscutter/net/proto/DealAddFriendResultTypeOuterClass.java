package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendResultTypeOuterClass.class */
public final class DealAddFriendResultTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dDealAddFriendResultType.proto*i\n\u0017DealAddFriendResultType\u0012&\n\"DEAL_ADD_FRIEND_RESULT_TYPE_REJECT\u0010��\u0012&\n\"DEAL_ADD_FRIEND_RESULT_TYPE_ACCEPT\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private DealAddFriendResultTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DealAddFriendResultTypeOuterClass$DealAddFriendResultType.class */
    public enum DealAddFriendResultType implements ProtocolMessageEnum {
        DEAL_ADD_FRIEND_RESULT_TYPE_REJECT(0),
        DEAL_ADD_FRIEND_RESULT_TYPE_ACCEPT(1),
        UNRECOGNIZED(-1);
        
        public static final int DEAL_ADD_FRIEND_RESULT_TYPE_REJECT_VALUE = 0;
        public static final int DEAL_ADD_FRIEND_RESULT_TYPE_ACCEPT_VALUE = 1;
        private static final Internal.EnumLiteMap<DealAddFriendResultType> internalValueMap = new Internal.EnumLiteMap<DealAddFriendResultType>() { // from class: emu.grasscutter.net.proto.DealAddFriendResultTypeOuterClass.DealAddFriendResultType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public DealAddFriendResultType findValueByNumber(int number) {
                return DealAddFriendResultType.forNumber(number);
            }
        };
        private static final DealAddFriendResultType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static DealAddFriendResultType valueOf(int value) {
            return forNumber(value);
        }

        public static DealAddFriendResultType forNumber(int value) {
            switch (value) {
                case 0:
                    return DEAL_ADD_FRIEND_RESULT_TYPE_REJECT;
                case 1:
                    return DEAL_ADD_FRIEND_RESULT_TYPE_ACCEPT;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<DealAddFriendResultType> internalGetValueMap() {
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
            return DealAddFriendResultTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static DealAddFriendResultType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        DealAddFriendResultType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
