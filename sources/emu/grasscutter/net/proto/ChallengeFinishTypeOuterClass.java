package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeFinishTypeOuterClass.class */
public final class ChallengeFinishTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ChallengeFinishType.proto*\u0001\n\u0013ChallengeFinishType\u0012\u001e\n\u001aCHALLENGE_FINISH_TYPE_NONE\u0010��\u0012\u001e\n\u001aCHALLENGE_FINISH_TYPE_FAIL\u0010\u0001\u0012\u001e\n\u001aCHALLENGE_FINISH_TYPE_SUCC\u0010\u0002\u0012\u001f\n\u001bCHALLENGE_FINISH_TYPE_PAUSE\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private ChallengeFinishTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChallengeFinishTypeOuterClass$ChallengeFinishType.class */
    public enum ChallengeFinishType implements ProtocolMessageEnum {
        CHALLENGE_FINISH_TYPE_NONE(0),
        CHALLENGE_FINISH_TYPE_FAIL(1),
        CHALLENGE_FINISH_TYPE_SUCC(2),
        CHALLENGE_FINISH_TYPE_PAUSE(3),
        UNRECOGNIZED(-1);
        
        public static final int CHALLENGE_FINISH_TYPE_NONE_VALUE = 0;
        public static final int CHALLENGE_FINISH_TYPE_FAIL_VALUE = 1;
        public static final int CHALLENGE_FINISH_TYPE_SUCC_VALUE = 2;
        public static final int CHALLENGE_FINISH_TYPE_PAUSE_VALUE = 3;
        private static final Internal.EnumLiteMap<ChallengeFinishType> internalValueMap = new Internal.EnumLiteMap<ChallengeFinishType>() { // from class: emu.grasscutter.net.proto.ChallengeFinishTypeOuterClass.ChallengeFinishType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChallengeFinishType findValueByNumber(int number) {
                return ChallengeFinishType.forNumber(number);
            }
        };
        private static final ChallengeFinishType[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ChallengeFinishType valueOf(int value) {
            return forNumber(value);
        }

        public static ChallengeFinishType forNumber(int value) {
            switch (value) {
                case 0:
                    return CHALLENGE_FINISH_TYPE_NONE;
                case 1:
                    return CHALLENGE_FINISH_TYPE_FAIL;
                case 2:
                    return CHALLENGE_FINISH_TYPE_SUCC;
                case 3:
                    return CHALLENGE_FINISH_TYPE_PAUSE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ChallengeFinishType> internalGetValueMap() {
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
            return ChallengeFinishTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static ChallengeFinishType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        ChallengeFinishType(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
