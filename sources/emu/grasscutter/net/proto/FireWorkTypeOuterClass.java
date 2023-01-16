package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkTypeOuterClass.class */
public final class FireWorkTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012FireWorkType.proto*Â\u0001\n\fFireWorkType\u0012\u001c\n\u0018FireWorkType_ODJKANKMPPJ\u0010��\u0012\u001c\n\u0018FireWorkType_EFGLHEIODFN\u0010\u0001\u0012\u001c\n\u0018FireWorkType_JPBBBCFGHAK\u0010\u0002\u0012\u001c\n\u0018FireWorkType_IDCMGHBHBFH\u0010\u0003\u0012\u001c\n\u0018FireWorkType_ODDBNNDFMBO\u0010\u0004\u0012\u001c\n\u0018FireWorkType_AGIDMOGJOBD\u0010\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private FireWorkTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkTypeOuterClass$FireWorkType.class */
    public enum FireWorkType implements ProtocolMessageEnum {
        FireWorkType_ODJKANKMPPJ(0),
        FireWorkType_EFGLHEIODFN(1),
        FireWorkType_JPBBBCFGHAK(2),
        FireWorkType_IDCMGHBHBFH(3),
        FireWorkType_ODDBNNDFMBO(4),
        FireWorkType_AGIDMOGJOBD(5),
        UNRECOGNIZED(-1);
        
        public static final int FireWorkType_ODJKANKMPPJ_VALUE = 0;
        public static final int FireWorkType_EFGLHEIODFN_VALUE = 1;
        public static final int FireWorkType_JPBBBCFGHAK_VALUE = 2;
        public static final int FireWorkType_IDCMGHBHBFH_VALUE = 3;
        public static final int FireWorkType_ODDBNNDFMBO_VALUE = 4;
        public static final int FireWorkType_AGIDMOGJOBD_VALUE = 5;
        private static final Internal.EnumLiteMap<FireWorkType> internalValueMap = new Internal.EnumLiteMap<FireWorkType>() { // from class: emu.grasscutter.net.proto.FireWorkTypeOuterClass.FireWorkType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FireWorkType findValueByNumber(int number) {
                return FireWorkType.forNumber(number);
            }
        };
        private static final FireWorkType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static FireWorkType valueOf(int value) {
            return forNumber(value);
        }

        public static FireWorkType forNumber(int value) {
            switch (value) {
                case 0:
                    return FireWorkType_ODJKANKMPPJ;
                case 1:
                    return FireWorkType_EFGLHEIODFN;
                case 2:
                    return FireWorkType_JPBBBCFGHAK;
                case 3:
                    return FireWorkType_IDCMGHBHBFH;
                case 4:
                    return FireWorkType_ODDBNNDFMBO;
                case 5:
                    return FireWorkType_AGIDMOGJOBD;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<FireWorkType> internalGetValueMap() {
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
            return FireWorkTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static FireWorkType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        FireWorkType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
