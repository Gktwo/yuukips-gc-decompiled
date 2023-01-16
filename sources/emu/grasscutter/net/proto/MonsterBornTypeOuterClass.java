package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterBornTypeOuterClass.class */
public final class MonsterBornTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015MonsterBornType.proto*j\n\u000fMonsterBornType\u0012\u001a\n\u0016MONSTER_BORN_TYPE_NONE\u0010��\u0012\u001d\n\u0019MONSTER_BORN_TYPE_DEFAULT\u0010\u0001\u0012\u001c\n\u0018MONSTER_BORN_TYPE_RANDOM\u0010\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private MonsterBornTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterBornTypeOuterClass$MonsterBornType.class */
    public enum MonsterBornType implements ProtocolMessageEnum {
        MONSTER_BORN_TYPE_NONE(0),
        MONSTER_BORN_TYPE_DEFAULT(1),
        MONSTER_BORN_TYPE_RANDOM(2),
        UNRECOGNIZED(-1);
        
        public static final int MONSTER_BORN_TYPE_NONE_VALUE = 0;
        public static final int MONSTER_BORN_TYPE_DEFAULT_VALUE = 1;
        public static final int MONSTER_BORN_TYPE_RANDOM_VALUE = 2;
        private static final Internal.EnumLiteMap<MonsterBornType> internalValueMap = new Internal.EnumLiteMap<MonsterBornType>() { // from class: emu.grasscutter.net.proto.MonsterBornTypeOuterClass.MonsterBornType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MonsterBornType findValueByNumber(int number) {
                return MonsterBornType.forNumber(number);
            }
        };
        private static final MonsterBornType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MonsterBornType valueOf(int value) {
            return forNumber(value);
        }

        public static MonsterBornType forNumber(int value) {
            switch (value) {
                case 0:
                    return MONSTER_BORN_TYPE_NONE;
                case 1:
                    return MONSTER_BORN_TYPE_DEFAULT;
                case 2:
                    return MONSTER_BORN_TYPE_RANDOM;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<MonsterBornType> internalGetValueMap() {
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
            return MonsterBornTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static MonsterBornType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        MonsterBornType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
