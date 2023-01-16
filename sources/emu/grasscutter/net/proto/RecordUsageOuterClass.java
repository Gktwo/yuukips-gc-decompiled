package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RecordUsageOuterClass.class */
public final class RecordUsageOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011RecordUsage.proto*Û\u0001\n\u000bRecordUsage\u0012&\n\"RECORD_USAGE_UGC_RECORD_USAGE_NONE\u0010��\u0012(\n$RECORD_USAGE_UGC_RECORD_USAGE_IMPORT\u0010\u0001\u0012&\n\"RECORD_USAGE_UGC_RECORD_USAGE_PLAY\u0010\u0002\u0012'\n#RECORD_USAGE_UGC_RECORD_USAGE_TRIAL\u0010\u0003\u0012)\n%RECORD_USAGE_UGC_RECORD_USAGE_COMPARE\u0010\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private RecordUsageOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RecordUsageOuterClass$RecordUsage.class */
    public enum RecordUsage implements ProtocolMessageEnum {
        RECORD_USAGE_UGC_RECORD_USAGE_NONE(0),
        RECORD_USAGE_UGC_RECORD_USAGE_IMPORT(1),
        RECORD_USAGE_UGC_RECORD_USAGE_PLAY(2),
        RECORD_USAGE_UGC_RECORD_USAGE_TRIAL(3),
        RECORD_USAGE_UGC_RECORD_USAGE_COMPARE(4),
        UNRECOGNIZED(-1);
        
        public static final int RECORD_USAGE_UGC_RECORD_USAGE_NONE_VALUE = 0;
        public static final int RECORD_USAGE_UGC_RECORD_USAGE_IMPORT_VALUE = 1;
        public static final int RECORD_USAGE_UGC_RECORD_USAGE_PLAY_VALUE = 2;
        public static final int RECORD_USAGE_UGC_RECORD_USAGE_TRIAL_VALUE = 3;
        public static final int RECORD_USAGE_UGC_RECORD_USAGE_COMPARE_VALUE = 4;
        private static final Internal.EnumLiteMap<RecordUsage> internalValueMap = new Internal.EnumLiteMap<RecordUsage>() { // from class: emu.grasscutter.net.proto.RecordUsageOuterClass.RecordUsage.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public RecordUsage findValueByNumber(int number) {
                return RecordUsage.forNumber(number);
            }
        };
        private static final RecordUsage[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static RecordUsage valueOf(int value) {
            return forNumber(value);
        }

        public static RecordUsage forNumber(int value) {
            switch (value) {
                case 0:
                    return RECORD_USAGE_UGC_RECORD_USAGE_NONE;
                case 1:
                    return RECORD_USAGE_UGC_RECORD_USAGE_IMPORT;
                case 2:
                    return RECORD_USAGE_UGC_RECORD_USAGE_PLAY;
                case 3:
                    return RECORD_USAGE_UGC_RECORD_USAGE_TRIAL;
                case 4:
                    return RECORD_USAGE_UGC_RECORD_USAGE_COMPARE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<RecordUsage> internalGetValueMap() {
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
            return RecordUsageOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static RecordUsage valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        RecordUsage(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
