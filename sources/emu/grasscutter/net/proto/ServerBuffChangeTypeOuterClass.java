package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeTypeOuterClass.class */
public final class ServerBuffChangeTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aServerBuffChangeType.proto*p\n\u0014ServerBuffChangeType\u0012+\n'SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF\u0010��\u0012+\n'SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ServerBuffChangeTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeTypeOuterClass$ServerBuffChangeType.class */
    public enum ServerBuffChangeType implements ProtocolMessageEnum {
        SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF(0),
        SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF(1),
        UNRECOGNIZED(-1);
        
        public static final int SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF_VALUE = 0;
        public static final int SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF_VALUE = 1;
        private static final Internal.EnumLiteMap<ServerBuffChangeType> internalValueMap = new Internal.EnumLiteMap<ServerBuffChangeType>() { // from class: emu.grasscutter.net.proto.ServerBuffChangeTypeOuterClass.ServerBuffChangeType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ServerBuffChangeType findValueByNumber(int number) {
                return ServerBuffChangeType.forNumber(number);
            }
        };
        private static final ServerBuffChangeType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ServerBuffChangeType valueOf(int value) {
            return forNumber(value);
        }

        public static ServerBuffChangeType forNumber(int value) {
            switch (value) {
                case 0:
                    return SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF;
                case 1:
                    return SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ServerBuffChangeType> internalGetValueMap() {
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
            return ServerBuffChangeTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ServerBuffChangeType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ServerBuffChangeType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
