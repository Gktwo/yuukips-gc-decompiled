package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MpSettingTypeOuterClass.class */
public final class MpSettingTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013MpSettingType.proto*v\n\rMpSettingType\u0012\u001c\n\u0018MP_SETTING_TYPE_NO_ENTER\u0010��\u0012 \n\u001cMP_SETTING_TYPE_ENTER_FREELY\u0010\u0001\u0012%\n!MP_SETTING_TYPE_ENTER_AFTER_APPLY\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MpSettingTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MpSettingTypeOuterClass$MpSettingType.class */
    public enum MpSettingType implements ProtocolMessageEnum {
        MP_SETTING_TYPE_NO_ENTER(0),
        MP_SETTING_TYPE_ENTER_FREELY(1),
        MP_SETTING_TYPE_ENTER_AFTER_APPLY(2),
        UNRECOGNIZED(-1);
        
        public static final int MP_SETTING_TYPE_NO_ENTER_VALUE = 0;
        public static final int MP_SETTING_TYPE_ENTER_FREELY_VALUE = 1;
        public static final int MP_SETTING_TYPE_ENTER_AFTER_APPLY_VALUE = 2;
        private static final Internal.EnumLiteMap<MpSettingType> internalValueMap = new Internal.EnumLiteMap<MpSettingType>() { // from class: emu.grasscutter.net.proto.MpSettingTypeOuterClass.MpSettingType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MpSettingType findValueByNumber(int number) {
                return MpSettingType.forNumber(number);
            }
        };
        private static final MpSettingType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MpSettingType valueOf(int value) {
            return forNumber(value);
        }

        public static MpSettingType forNumber(int value) {
            switch (value) {
                case 0:
                    return MP_SETTING_TYPE_NO_ENTER;
                case 1:
                    return MP_SETTING_TYPE_ENTER_FREELY;
                case 2:
                    return MP_SETTING_TYPE_ENTER_AFTER_APPLY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MpSettingType> internalGetValueMap() {
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
            return MpSettingTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MpSettingType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MpSettingType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
