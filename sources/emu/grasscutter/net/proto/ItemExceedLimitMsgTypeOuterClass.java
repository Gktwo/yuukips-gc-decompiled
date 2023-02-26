package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemExceedLimitMsgTypeOuterClass.class */
public final class ItemExceedLimitMsgTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cItemExceedLimitMsgType.proto*¼\u0001\n\u0016ItemExceedLimitMsgType\u0012&\n\"ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT\u0010��\u0012#\n\u001fITEM_EXCEED_LIMIT_MSG_TYPE_TEXT\u0010\u0001\u0012%\n!ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG\u0010\u0002\u0012.\n*ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ItemExceedLimitMsgTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemExceedLimitMsgTypeOuterClass$ItemExceedLimitMsgType.class */
    public enum ItemExceedLimitMsgType implements ProtocolMessageEnum {
        ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT(0),
        ITEM_EXCEED_LIMIT_MSG_TYPE_TEXT(1),
        ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG(2),
        ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK(3),
        UNRECOGNIZED(-1);
        
        public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT_VALUE = 0;
        public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_TEXT_VALUE = 1;
        public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_VALUE = 2;
        public static final int ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK_VALUE = 3;
        private static final Internal.EnumLiteMap<ItemExceedLimitMsgType> internalValueMap = new Internal.EnumLiteMap<ItemExceedLimitMsgType>() { // from class: emu.grasscutter.net.proto.ItemExceedLimitMsgTypeOuterClass.ItemExceedLimitMsgType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ItemExceedLimitMsgType findValueByNumber(int number) {
                return ItemExceedLimitMsgType.forNumber(number);
            }
        };
        private static final ItemExceedLimitMsgType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ItemExceedLimitMsgType valueOf(int value) {
            return forNumber(value);
        }

        public static ItemExceedLimitMsgType forNumber(int value) {
            switch (value) {
                case 0:
                    return ITEM_EXCEED_LIMIT_MSG_TYPE_DEFAULT;
                case 1:
                    return ITEM_EXCEED_LIMIT_MSG_TYPE_TEXT;
                case 2:
                    return ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG;
                case 3:
                    return ITEM_EXCEED_LIMIT_MSG_TYPE_DIALOG_NONBLOCK;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ItemExceedLimitMsgType> internalGetValueMap() {
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
            return ItemExceedLimitMsgTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ItemExceedLimitMsgType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ItemExceedLimitMsgType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
