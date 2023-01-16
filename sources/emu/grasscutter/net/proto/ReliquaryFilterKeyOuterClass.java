package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterKeyOuterClass.class */
public final class ReliquaryFilterKeyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ReliquaryFilterKey.proto*\u0001\n\u0012ReliquaryFilterKey\u0012\u001d\n\u0019RELIQUARY_FILTER_KEY_NONE\u0010��\u0012\u001d\n\u0019RELIQUARY_FILTER_KEY_LOCK\u0010\u0001\u0012\u001e\n\u001aRELIQUARY_FILTER_KEY_LEVEL\u0010\u0002\u0012 \n\u001cRELIQUARY_FILTER_KEY_WEARING\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ReliquaryFilterKeyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryFilterKeyOuterClass$ReliquaryFilterKey.class */
    public enum ReliquaryFilterKey implements ProtocolMessageEnum {
        RELIQUARY_FILTER_KEY_NONE(0),
        RELIQUARY_FILTER_KEY_LOCK(1),
        RELIQUARY_FILTER_KEY_LEVEL(2),
        RELIQUARY_FILTER_KEY_WEARING(3),
        UNRECOGNIZED(-1);
        
        public static final int RELIQUARY_FILTER_KEY_NONE_VALUE = 0;
        public static final int RELIQUARY_FILTER_KEY_LOCK_VALUE = 1;
        public static final int RELIQUARY_FILTER_KEY_LEVEL_VALUE = 2;
        public static final int RELIQUARY_FILTER_KEY_WEARING_VALUE = 3;
        private static final Internal.EnumLiteMap<ReliquaryFilterKey> internalValueMap = new Internal.EnumLiteMap<ReliquaryFilterKey>() { // from class: emu.grasscutter.net.proto.ReliquaryFilterKeyOuterClass.ReliquaryFilterKey.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ReliquaryFilterKey findValueByNumber(int number) {
                return ReliquaryFilterKey.forNumber(number);
            }
        };
        private static final ReliquaryFilterKey[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ReliquaryFilterKey valueOf(int value) {
            return forNumber(value);
        }

        public static ReliquaryFilterKey forNumber(int value) {
            switch (value) {
                case 0:
                    return RELIQUARY_FILTER_KEY_NONE;
                case 1:
                    return RELIQUARY_FILTER_KEY_LOCK;
                case 2:
                    return RELIQUARY_FILTER_KEY_LEVEL;
                case 3:
                    return RELIQUARY_FILTER_KEY_WEARING;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ReliquaryFilterKey> internalGetValueMap() {
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
            return ReliquaryFilterKeyOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ReliquaryFilterKey valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ReliquaryFilterKey(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
