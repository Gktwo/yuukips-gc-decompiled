package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AStarMethodOuterClass.class */
public final class AStarMethodOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011AStarMethod.proto*~\n\u000bAStarMethod\u0012\u0019\n\u0015A_STAR_METHOD_CLASSIC\u0010��\u0012\u001a\n\u0016A_STAR_METHOD_TENDENCY\u0010\u0001\u0012\u001a\n\u0016A_STAR_METHOD_ADAPTIVE\u0010\u0002\u0012\u001c\n\u0018A_STAR_METHOD_INFLECTION\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private AStarMethodOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AStarMethodOuterClass$AStarMethod.class */
    public enum AStarMethod implements ProtocolMessageEnum {
        A_STAR_METHOD_CLASSIC(0),
        A_STAR_METHOD_TENDENCY(1),
        A_STAR_METHOD_ADAPTIVE(2),
        A_STAR_METHOD_INFLECTION(3),
        UNRECOGNIZED(-1);
        
        public static final int A_STAR_METHOD_CLASSIC_VALUE = 0;
        public static final int A_STAR_METHOD_TENDENCY_VALUE = 1;
        public static final int A_STAR_METHOD_ADAPTIVE_VALUE = 2;
        public static final int A_STAR_METHOD_INFLECTION_VALUE = 3;
        private static final Internal.EnumLiteMap<AStarMethod> internalValueMap = new Internal.EnumLiteMap<AStarMethod>() { // from class: emu.grasscutter.net.proto.AStarMethodOuterClass.AStarMethod.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AStarMethod findValueByNumber(int number) {
                return AStarMethod.forNumber(number);
            }
        };
        private static final AStarMethod[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static AStarMethod valueOf(int value) {
            return forNumber(value);
        }

        public static AStarMethod forNumber(int value) {
            switch (value) {
                case 0:
                    return A_STAR_METHOD_CLASSIC;
                case 1:
                    return A_STAR_METHOD_TENDENCY;
                case 2:
                    return A_STAR_METHOD_ADAPTIVE;
                case 3:
                    return A_STAR_METHOD_INFLECTION;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AStarMethod> internalGetValueMap() {
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
            return AStarMethodOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AStarMethod valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        AStarMethod(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
