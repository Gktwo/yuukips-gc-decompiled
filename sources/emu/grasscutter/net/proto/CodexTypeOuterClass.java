package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeOuterClass.class */
public final class CodexTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fCodexType.proto*Û\u0001\n\tCodexType\u0012\u0013\n\u000fCODEX_TYPE_NONE\u0010��\u0012\u0014\n\u0010CODEX_TYPE_QUEST\u0010\u0001\u0012\u0015\n\u0011CODEX_TYPE_WEAPON\u0010\u0002\u0012\u0015\n\u0011CODEX_TYPE_ANIMAL\u0010\u0003\u0012\u0017\n\u0013CODEX_TYPE_MATERIAL\u0010\u0004\u0012\u0014\n\u0010CODEX_TYPE_BOOKS\u0010\u0005\u0012\u0017\n\u0013CODEX_TYPE_PUSHTIPS\u0010\u0006\u0012\u0013\n\u000fCODEX_TYPE_VIEW\u0010\u0007\u0012\u0018\n\u0014CODEX_TYPE_RELIQUARY\u0010\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private CodexTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CodexTypeOuterClass$CodexType.class */
    public enum CodexType implements ProtocolMessageEnum {
        CODEX_TYPE_NONE(0),
        CODEX_TYPE_QUEST(1),
        CODEX_TYPE_WEAPON(2),
        CODEX_TYPE_ANIMAL(3),
        CODEX_TYPE_MATERIAL(4),
        CODEX_TYPE_BOOKS(5),
        CODEX_TYPE_PUSHTIPS(6),
        CODEX_TYPE_VIEW(7),
        CODEX_TYPE_RELIQUARY(8),
        UNRECOGNIZED(-1);
        
        public static final int CODEX_TYPE_NONE_VALUE = 0;
        public static final int CODEX_TYPE_QUEST_VALUE = 1;
        public static final int CODEX_TYPE_WEAPON_VALUE = 2;
        public static final int CODEX_TYPE_ANIMAL_VALUE = 3;
        public static final int CODEX_TYPE_MATERIAL_VALUE = 4;
        public static final int CODEX_TYPE_BOOKS_VALUE = 5;
        public static final int CODEX_TYPE_PUSHTIPS_VALUE = 6;
        public static final int CODEX_TYPE_VIEW_VALUE = 7;
        public static final int CODEX_TYPE_RELIQUARY_VALUE = 8;
        private static final Internal.EnumLiteMap<CodexType> internalValueMap = new Internal.EnumLiteMap<CodexType>() { // from class: emu.grasscutter.net.proto.CodexTypeOuterClass.CodexType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CodexType findValueByNumber(int number) {
                return CodexType.forNumber(number);
            }
        };
        private static final CodexType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static CodexType valueOf(int value) {
            return forNumber(value);
        }

        public static CodexType forNumber(int value) {
            switch (value) {
                case 0:
                    return CODEX_TYPE_NONE;
                case 1:
                    return CODEX_TYPE_QUEST;
                case 2:
                    return CODEX_TYPE_WEAPON;
                case 3:
                    return CODEX_TYPE_ANIMAL;
                case 4:
                    return CODEX_TYPE_MATERIAL;
                case 5:
                    return CODEX_TYPE_BOOKS;
                case 6:
                    return CODEX_TYPE_PUSHTIPS;
                case 7:
                    return CODEX_TYPE_VIEW;
                case 8:
                    return CODEX_TYPE_RELIQUARY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<CodexType> internalGetValueMap() {
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
            return CodexTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static CodexType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        CodexType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
