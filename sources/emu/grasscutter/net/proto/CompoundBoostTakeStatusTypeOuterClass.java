package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CompoundBoostTakeStatusTypeOuterClass.class */
public final class CompoundBoostTakeStatusTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!CompoundBoostTakeStatusType.proto*Ù\u0001\n\u001bCompoundBoostTakeStatusType\u0012(\n$COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE\u0010��\u0012.\n*COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_ONLY\u0010\u0001\u00122\n.COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_AND_TAKE\u0010\u0002\u0012,\n(COMPOUND_BOOST_TAKE_STATUS_TYPE_BAG_FULL\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private CompoundBoostTakeStatusTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CompoundBoostTakeStatusTypeOuterClass$CompoundBoostTakeStatusType.class */
    public enum CompoundBoostTakeStatusType implements ProtocolMessageEnum {
        COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE(0),
        COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_ONLY(1),
        COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_AND_TAKE(2),
        COMPOUND_BOOST_TAKE_STATUS_TYPE_BAG_FULL(3),
        UNRECOGNIZED(-1);
        
        public static final int COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE_VALUE = 0;
        public static final int COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_ONLY_VALUE = 1;
        public static final int COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_AND_TAKE_VALUE = 2;
        public static final int COMPOUND_BOOST_TAKE_STATUS_TYPE_BAG_FULL_VALUE = 3;
        private static final Internal.EnumLiteMap<CompoundBoostTakeStatusType> internalValueMap = new Internal.EnumLiteMap<CompoundBoostTakeStatusType>() { // from class: emu.grasscutter.net.proto.CompoundBoostTakeStatusTypeOuterClass.CompoundBoostTakeStatusType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CompoundBoostTakeStatusType findValueByNumber(int number) {
                return CompoundBoostTakeStatusType.forNumber(number);
            }
        };
        private static final CompoundBoostTakeStatusType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static CompoundBoostTakeStatusType valueOf(int value) {
            return forNumber(value);
        }

        public static CompoundBoostTakeStatusType forNumber(int value) {
            switch (value) {
                case 0:
                    return COMPOUND_BOOST_TAKE_STATUS_TYPE_NONE;
                case 1:
                    return COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_ONLY;
                case 2:
                    return COMPOUND_BOOST_TAKE_STATUS_TYPE_BOOST_AND_TAKE;
                case 3:
                    return COMPOUND_BOOST_TAKE_STATUS_TYPE_BAG_FULL;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<CompoundBoostTakeStatusType> internalGetValueMap() {
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
            return CompoundBoostTakeStatusTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static CompoundBoostTakeStatusType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        CompoundBoostTakeStatusType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
