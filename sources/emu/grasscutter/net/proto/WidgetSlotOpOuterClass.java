package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotOpOuterClass.class */
public final class WidgetSlotOpOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012WidgetSlotOp.proto*D\n\fWidgetSlotOp\u0012\u0019\n\u0015WIDGET_SLOT_OP_ATTACH\u0010��\u0012\u0019\n\u0015WIDGET_SLOT_OP_DETACH\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private WidgetSlotOpOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotOpOuterClass$WidgetSlotOp.class */
    public enum WidgetSlotOp implements ProtocolMessageEnum {
        WIDGET_SLOT_OP_ATTACH(0),
        WIDGET_SLOT_OP_DETACH(1),
        UNRECOGNIZED(-1);
        
        public static final int WIDGET_SLOT_OP_ATTACH_VALUE = 0;
        public static final int WIDGET_SLOT_OP_DETACH_VALUE = 1;
        private static final Internal.EnumLiteMap<WidgetSlotOp> internalValueMap = new Internal.EnumLiteMap<WidgetSlotOp>() { // from class: emu.grasscutter.net.proto.WidgetSlotOpOuterClass.WidgetSlotOp.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public WidgetSlotOp findValueByNumber(int number) {
                return WidgetSlotOp.forNumber(number);
            }
        };
        private static final WidgetSlotOp[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static WidgetSlotOp valueOf(int value) {
            return forNumber(value);
        }

        public static WidgetSlotOp forNumber(int value) {
            switch (value) {
                case 0:
                    return WIDGET_SLOT_OP_ATTACH;
                case 1:
                    return WIDGET_SLOT_OP_DETACH;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<WidgetSlotOp> internalGetValueMap() {
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
            return WidgetSlotOpOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static WidgetSlotOp valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        WidgetSlotOp(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
