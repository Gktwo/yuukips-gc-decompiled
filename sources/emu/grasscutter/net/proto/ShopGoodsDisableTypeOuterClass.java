package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopGoodsDisableTypeOuterClass.class */
public final class ShopGoodsDisableTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aShopGoodsDisableType.proto*³\u0001\n\u0014ShopGoodsDisableType\u0012\u001b\n\u0017SHOP_GOODS_DISABLE_NONE\u0010��\u0012\"\n\u001eSHOP_GOODS_DISABLE_TALENT_FULL\u0010\u0001\u00121\n-SHOP_GOODS_DISABLE_FURNITURE_FORMULA_UNLOCKED\u0010\u0002\u0012'\n#SHOP_GOODS_DISABLE_COSTUME_UNLOCKED\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ShopGoodsDisableTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ShopGoodsDisableTypeOuterClass$ShopGoodsDisableType.class */
    public enum ShopGoodsDisableType implements ProtocolMessageEnum {
        SHOP_GOODS_DISABLE_NONE(0),
        SHOP_GOODS_DISABLE_TALENT_FULL(1),
        SHOP_GOODS_DISABLE_FURNITURE_FORMULA_UNLOCKED(2),
        SHOP_GOODS_DISABLE_COSTUME_UNLOCKED(3),
        UNRECOGNIZED(-1);
        
        public static final int SHOP_GOODS_DISABLE_NONE_VALUE = 0;
        public static final int SHOP_GOODS_DISABLE_TALENT_FULL_VALUE = 1;
        public static final int SHOP_GOODS_DISABLE_FURNITURE_FORMULA_UNLOCKED_VALUE = 2;
        public static final int SHOP_GOODS_DISABLE_COSTUME_UNLOCKED_VALUE = 3;
        private static final Internal.EnumLiteMap<ShopGoodsDisableType> internalValueMap = new Internal.EnumLiteMap<ShopGoodsDisableType>() { // from class: emu.grasscutter.net.proto.ShopGoodsDisableTypeOuterClass.ShopGoodsDisableType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ShopGoodsDisableType findValueByNumber(int number) {
                return ShopGoodsDisableType.forNumber(number);
            }
        };
        private static final ShopGoodsDisableType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ShopGoodsDisableType valueOf(int value) {
            return forNumber(value);
        }

        public static ShopGoodsDisableType forNumber(int value) {
            switch (value) {
                case 0:
                    return SHOP_GOODS_DISABLE_NONE;
                case 1:
                    return SHOP_GOODS_DISABLE_TALENT_FULL;
                case 2:
                    return SHOP_GOODS_DISABLE_FURNITURE_FORMULA_UNLOCKED;
                case 3:
                    return SHOP_GOODS_DISABLE_COSTUME_UNLOCKED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ShopGoodsDisableType> internalGetValueMap() {
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
            return ShopGoodsDisableTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ShopGoodsDisableType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ShopGoodsDisableType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
