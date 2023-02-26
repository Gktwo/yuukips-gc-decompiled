package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingTypeOuterClass.class */
public final class ItemGivingTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ItemGivingType.proto*H\n\u000eItemGivingType\u0012\u0019\n\u0015ITEM_GIVING_TYPE_NONE\u0010��\u0012\u001b\n\u0017ITEM_GIVING_TYPE_GADGET\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ItemGivingTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ItemGivingTypeOuterClass$ItemGivingType.class */
    public enum ItemGivingType implements ProtocolMessageEnum {
        ITEM_GIVING_TYPE_NONE(0),
        ITEM_GIVING_TYPE_GADGET(1),
        UNRECOGNIZED(-1);
        
        public static final int ITEM_GIVING_TYPE_NONE_VALUE = 0;
        public static final int ITEM_GIVING_TYPE_GADGET_VALUE = 1;
        private static final Internal.EnumLiteMap<ItemGivingType> internalValueMap = new Internal.EnumLiteMap<ItemGivingType>() { // from class: emu.grasscutter.net.proto.ItemGivingTypeOuterClass.ItemGivingType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ItemGivingType findValueByNumber(int number) {
                return ItemGivingType.forNumber(number);
            }
        };
        private static final ItemGivingType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ItemGivingType valueOf(int value) {
            return forNumber(value);
        }

        public static ItemGivingType forNumber(int value) {
            switch (value) {
                case 0:
                    return ITEM_GIVING_TYPE_NONE;
                case 1:
                    return ITEM_GIVING_TYPE_GADGET;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ItemGivingType> internalGetValueMap() {
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
            return ItemGivingTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ItemGivingType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ItemGivingType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
