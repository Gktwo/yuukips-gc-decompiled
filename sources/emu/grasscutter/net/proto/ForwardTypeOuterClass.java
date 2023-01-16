package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForwardTypeOuterClass.class */
public final class ForwardTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011ForwardType.proto*\u0002\n\u000bForwardType\u0012\u0016\n\u0012FORWARD_TYPE_LOCAL\u0010��\u0012\u0017\n\u0013FORWARD_TYPE_TO_ALL\u0010\u0001\u0012\"\n\u001eFORWARD_TYPE_TO_ALL_EXCEPT_CUR\u0010\u0002\u0012\u0018\n\u0014FORWARD_TYPE_TO_HOST\u0010\u0003\u0012\u001d\n\u0019FORWARD_TYPE_TO_ALL_GUEST\u0010\u0004\u0012\u0018\n\u0014FORWARD_TYPE_TO_PEER\u0010\u0005\u0012\u0019\n\u0015FORWARD_TYPE_TO_PEERS\u0010\u0006\u0012\u001c\n\u0018FORWARD_TYPE_ONLY_SERVER\u0010\u0007\u0012(\n$FORWARD_TYPE_TO_ALL_EXIST_EXCEPT_CUR\u0010\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ForwardTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ForwardTypeOuterClass$ForwardType.class */
    public enum ForwardType implements ProtocolMessageEnum {
        FORWARD_TYPE_LOCAL(0),
        FORWARD_TYPE_TO_ALL(1),
        FORWARD_TYPE_TO_ALL_EXCEPT_CUR(2),
        FORWARD_TYPE_TO_HOST(3),
        FORWARD_TYPE_TO_ALL_GUEST(4),
        FORWARD_TYPE_TO_PEER(5),
        FORWARD_TYPE_TO_PEERS(6),
        FORWARD_TYPE_ONLY_SERVER(7),
        FORWARD_TYPE_TO_ALL_EXIST_EXCEPT_CUR(8),
        UNRECOGNIZED(-1);
        
        public static final int FORWARD_TYPE_LOCAL_VALUE = 0;
        public static final int FORWARD_TYPE_TO_ALL_VALUE = 1;
        public static final int FORWARD_TYPE_TO_ALL_EXCEPT_CUR_VALUE = 2;
        public static final int FORWARD_TYPE_TO_HOST_VALUE = 3;
        public static final int FORWARD_TYPE_TO_ALL_GUEST_VALUE = 4;
        public static final int FORWARD_TYPE_TO_PEER_VALUE = 5;
        public static final int FORWARD_TYPE_TO_PEERS_VALUE = 6;
        public static final int FORWARD_TYPE_ONLY_SERVER_VALUE = 7;
        public static final int FORWARD_TYPE_TO_ALL_EXIST_EXCEPT_CUR_VALUE = 8;
        private static final Internal.EnumLiteMap<ForwardType> internalValueMap = new Internal.EnumLiteMap<ForwardType>() { // from class: emu.grasscutter.net.proto.ForwardTypeOuterClass.ForwardType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ForwardType findValueByNumber(int number) {
                return ForwardType.forNumber(number);
            }
        };
        private static final ForwardType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ForwardType valueOf(int value) {
            return forNumber(value);
        }

        public static ForwardType forNumber(int value) {
            switch (value) {
                case 0:
                    return FORWARD_TYPE_LOCAL;
                case 1:
                    return FORWARD_TYPE_TO_ALL;
                case 2:
                    return FORWARD_TYPE_TO_ALL_EXCEPT_CUR;
                case 3:
                    return FORWARD_TYPE_TO_HOST;
                case 4:
                    return FORWARD_TYPE_TO_ALL_GUEST;
                case 5:
                    return FORWARD_TYPE_TO_PEER;
                case 6:
                    return FORWARD_TYPE_TO_PEERS;
                case 7:
                    return FORWARD_TYPE_ONLY_SERVER;
                case 8:
                    return FORWARD_TYPE_TO_ALL_EXIST_EXCEPT_CUR;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ForwardType> internalGetValueMap() {
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
            return ForwardTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ForwardType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ForwardType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
