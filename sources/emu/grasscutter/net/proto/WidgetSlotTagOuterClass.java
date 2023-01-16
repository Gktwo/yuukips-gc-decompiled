package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotTagOuterClass.class */
public final class WidgetSlotTagOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013WidgetSlotTag.proto*Q\n\rWidgetSlotTag\u0012\u001d\n\u0019WIDGET_SLOT_TAG_QUICK_USE\u0010��\u0012!\n\u001dWIDGET_SLOT_TAG_ATTACH_AVATAR\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private WidgetSlotTagOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotTagOuterClass$WidgetSlotTag.class */
    public enum WidgetSlotTag implements ProtocolMessageEnum {
        WIDGET_SLOT_TAG_QUICK_USE(0),
        WIDGET_SLOT_TAG_ATTACH_AVATAR(1),
        UNRECOGNIZED(-1);
        
        public static final int WIDGET_SLOT_TAG_QUICK_USE_VALUE = 0;
        public static final int WIDGET_SLOT_TAG_ATTACH_AVATAR_VALUE = 1;
        private static final Internal.EnumLiteMap<WidgetSlotTag> internalValueMap = new Internal.EnumLiteMap<WidgetSlotTag>() { // from class: emu.grasscutter.net.proto.WidgetSlotTagOuterClass.WidgetSlotTag.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public WidgetSlotTag findValueByNumber(int number) {
                return WidgetSlotTag.forNumber(number);
            }
        };
        private static final WidgetSlotTag[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static WidgetSlotTag valueOf(int value) {
            return forNumber(value);
        }

        public static WidgetSlotTag forNumber(int value) {
            switch (value) {
                case 0:
                    return WIDGET_SLOT_TAG_QUICK_USE;
                case 1:
                    return WIDGET_SLOT_TAG_ATTACH_AVATAR;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<WidgetSlotTag> internalGetValueMap() {
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
            return WidgetSlotTagOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static WidgetSlotTag valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        WidgetSlotTag(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
