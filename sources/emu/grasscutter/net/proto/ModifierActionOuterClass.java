package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierActionOuterClass.class */
public final class ModifierActionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014ModifierAction.proto*H\n\u000eModifierAction\u0012\u0019\n\u0015MODIFIER_ACTION_ADDED\u0010��\u0012\u001b\n\u0017MODIFIER_ACTION_REMOVED\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ModifierActionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ModifierActionOuterClass$ModifierAction.class */
    public enum ModifierAction implements ProtocolMessageEnum {
        MODIFIER_ACTION_ADDED(0),
        MODIFIER_ACTION_REMOVED(1),
        UNRECOGNIZED(-1);
        
        public static final int MODIFIER_ACTION_ADDED_VALUE = 0;
        public static final int MODIFIER_ACTION_REMOVED_VALUE = 1;
        private static final Internal.EnumLiteMap<ModifierAction> internalValueMap = new Internal.EnumLiteMap<ModifierAction>() { // from class: emu.grasscutter.net.proto.ModifierActionOuterClass.ModifierAction.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ModifierAction findValueByNumber(int number) {
                return ModifierAction.forNumber(number);
            }
        };
        private static final ModifierAction[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ModifierAction valueOf(int value) {
            return forNumber(value);
        }

        public static ModifierAction forNumber(int value) {
            switch (value) {
                case 0:
                    return MODIFIER_ACTION_ADDED;
                case 1:
                    return MODIFIER_ACTION_REMOVED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ModifierAction> internalGetValueMap() {
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
            return ModifierActionOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ModifierAction valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ModifierAction(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
