package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientInputTypeOuterClass.class */
public final class ClientInputTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015ClientInputType.proto*\u0001\n\u000fClientInputType\u0012\u001a\n\u0016CLIENT_INPUT_TYPE_NONE\u0010��\u0012$\n CLIENT_INPUT_TYPE_KEYBOARD_MOUSE\u0010\u0001\u0012\u001d\n\u0019CLIENT_INPUT_TYPE_GAMEPAD\u0010\u0002\u0012!\n\u001dCLIENT_INPUT_TYPE_TOUCH_PANEL\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ClientInputTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientInputTypeOuterClass$ClientInputType.class */
    public enum ClientInputType implements ProtocolMessageEnum {
        CLIENT_INPUT_TYPE_NONE(0),
        CLIENT_INPUT_TYPE_KEYBOARD_MOUSE(1),
        CLIENT_INPUT_TYPE_GAMEPAD(2),
        CLIENT_INPUT_TYPE_TOUCH_PANEL(3),
        UNRECOGNIZED(-1);
        
        public static final int CLIENT_INPUT_TYPE_NONE_VALUE = 0;
        public static final int CLIENT_INPUT_TYPE_KEYBOARD_MOUSE_VALUE = 1;
        public static final int CLIENT_INPUT_TYPE_GAMEPAD_VALUE = 2;
        public static final int CLIENT_INPUT_TYPE_TOUCH_PANEL_VALUE = 3;
        private static final Internal.EnumLiteMap<ClientInputType> internalValueMap = new Internal.EnumLiteMap<ClientInputType>() { // from class: emu.grasscutter.net.proto.ClientInputTypeOuterClass.ClientInputType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ClientInputType findValueByNumber(int number) {
                return ClientInputType.forNumber(number);
            }
        };
        private static final ClientInputType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ClientInputType valueOf(int value) {
            return forNumber(value);
        }

        public static ClientInputType forNumber(int value) {
            switch (value) {
                case 0:
                    return CLIENT_INPUT_TYPE_NONE;
                case 1:
                    return CLIENT_INPUT_TYPE_KEYBOARD_MOUSE;
                case 2:
                    return CLIENT_INPUT_TYPE_GAMEPAD;
                case 3:
                    return CLIENT_INPUT_TYPE_TOUCH_PANEL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ClientInputType> internalGetValueMap() {
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
            return ClientInputTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ClientInputType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ClientInputType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
