package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCreatorOpTypeOuterClass.class */
public final class WidgetCreatorOpTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019WidgetCreatorOpType.proto*\u0001\n\u0013WidgetCreatorOpType\u0012\u001f\n\u001bWIDGET_CREATOR_OP_TYPE_NONE\u0010��\u0012\"\n\u001eWIDGET_CREATOR_OP_TYPE_RETRACT\u0010\u0001\u0012-\n)WIDGET_CREATOR_OP_TYPE_RETRACT_AND_CREATE\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private WidgetCreatorOpTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetCreatorOpTypeOuterClass$WidgetCreatorOpType.class */
    public enum WidgetCreatorOpType implements ProtocolMessageEnum {
        WIDGET_CREATOR_OP_TYPE_NONE(0),
        WIDGET_CREATOR_OP_TYPE_RETRACT(1),
        WIDGET_CREATOR_OP_TYPE_RETRACT_AND_CREATE(2),
        UNRECOGNIZED(-1);
        
        public static final int WIDGET_CREATOR_OP_TYPE_NONE_VALUE = 0;
        public static final int WIDGET_CREATOR_OP_TYPE_RETRACT_VALUE = 1;
        public static final int WIDGET_CREATOR_OP_TYPE_RETRACT_AND_CREATE_VALUE = 2;
        private static final Internal.EnumLiteMap<WidgetCreatorOpType> internalValueMap = new Internal.EnumLiteMap<WidgetCreatorOpType>() { // from class: emu.grasscutter.net.proto.WidgetCreatorOpTypeOuterClass.WidgetCreatorOpType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public WidgetCreatorOpType findValueByNumber(int number) {
                return WidgetCreatorOpType.forNumber(number);
            }
        };
        private static final WidgetCreatorOpType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static WidgetCreatorOpType valueOf(int value) {
            return forNumber(value);
        }

        public static WidgetCreatorOpType forNumber(int value) {
            switch (value) {
                case 0:
                    return WIDGET_CREATOR_OP_TYPE_NONE;
                case 1:
                    return WIDGET_CREATOR_OP_TYPE_RETRACT;
                case 2:
                    return WIDGET_CREATOR_OP_TYPE_RETRACT_AND_CREATE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<WidgetCreatorOpType> internalGetValueMap() {
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
            return WidgetCreatorOpTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static WidgetCreatorOpType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        WidgetCreatorOpType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
