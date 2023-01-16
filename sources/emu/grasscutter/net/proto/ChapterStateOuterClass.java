package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateOuterClass.class */
public final class ChapterStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012ChapterState.proto*|\n\fChapterState\u0012\u0019\n\u0015CHAPTER_STATE_INVALID\u0010��\u0012!\n\u001dCHAPTER_STATE_UNABLE_TO_BEGIN\u0010\u0001\u0012\u0017\n\u0013CHAPTER_STATE_BEGIN\u0010\u0002\u0012\u0015\n\u0011CHAPTER_STATE_END\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ChapterStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateOuterClass$ChapterState.class */
    public enum ChapterState implements ProtocolMessageEnum {
        CHAPTER_STATE_INVALID(0),
        CHAPTER_STATE_UNABLE_TO_BEGIN(1),
        CHAPTER_STATE_BEGIN(2),
        CHAPTER_STATE_END(3),
        UNRECOGNIZED(-1);
        
        public static final int CHAPTER_STATE_INVALID_VALUE = 0;
        public static final int CHAPTER_STATE_UNABLE_TO_BEGIN_VALUE = 1;
        public static final int CHAPTER_STATE_BEGIN_VALUE = 2;
        public static final int CHAPTER_STATE_END_VALUE = 3;
        private static final Internal.EnumLiteMap<ChapterState> internalValueMap = new Internal.EnumLiteMap<ChapterState>() { // from class: emu.grasscutter.net.proto.ChapterStateOuterClass.ChapterState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChapterState findValueByNumber(int number) {
                return ChapterState.forNumber(number);
            }
        };
        private static final ChapterState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ChapterState valueOf(int value) {
            return forNumber(value);
        }

        public static ChapterState forNumber(int value) {
            switch (value) {
                case 0:
                    return CHAPTER_STATE_INVALID;
                case 1:
                    return CHAPTER_STATE_UNABLE_TO_BEGIN;
                case 2:
                    return CHAPTER_STATE_BEGIN;
                case 3:
                    return CHAPTER_STATE_END;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ChapterState> internalGetValueMap() {
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
            return ChapterStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ChapterState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ChapterState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
