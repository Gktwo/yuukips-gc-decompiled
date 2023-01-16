package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoopChapterStateOuterClass.class */
public final class CoopChapterStateOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016CoopChapterState.proto*H\n\u0010CoopChapterState\u0012\t\n\u0005Close\u0010��\u0012\u000f\n\u000bCondNotMeet\u0010\u0001\u0012\f\n\bCondMeet\u0010\u0002\u0012\n\n\u0006Accept\u0010\u0003B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private CoopChapterStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CoopChapterStateOuterClass$CoopChapterState.class */
    public enum CoopChapterState implements ProtocolMessageEnum {
        Close(0),
        CondNotMeet(1),
        CondMeet(2),
        Accept(3),
        UNRECOGNIZED(-1);
        
        public static final int Close_VALUE = 0;
        public static final int CondNotMeet_VALUE = 1;
        public static final int CondMeet_VALUE = 2;
        public static final int Accept_VALUE = 3;
        private static final Internal.EnumLiteMap<CoopChapterState> internalValueMap = new Internal.EnumLiteMap<CoopChapterState>() { // from class: emu.grasscutter.net.proto.CoopChapterStateOuterClass.CoopChapterState.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CoopChapterState findValueByNumber(int number) {
                return CoopChapterState.forNumber(number);
            }
        };
        private static final CoopChapterState[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static CoopChapterState valueOf(int value) {
            return forNumber(value);
        }

        public static CoopChapterState forNumber(int value) {
            switch (value) {
                case 0:
                    return Close;
                case 1:
                    return CondNotMeet;
                case 2:
                    return CondMeet;
                case 3:
                    return Accept;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<CoopChapterState> internalGetValueMap() {
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
            return CoopChapterStateOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static CoopChapterState valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        CoopChapterState(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
