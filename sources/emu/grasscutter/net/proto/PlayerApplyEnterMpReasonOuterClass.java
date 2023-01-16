package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpReasonOuterClass.class */
public final class PlayerApplyEnterMpReasonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001ePlayerApplyEnterMpReason.proto*Ï\u0002\n\u0018PlayerApplyEnterMpReason\u0012\u000f\n\u000bPlayerJudge\u0010��\u0012\u0014\n\u0010SceneCannotEnter\u0010\u0001\u0012\u0017\n\u0013PlayerCannotEnterMp\u0010\u0002\u0012\u000f\n\u000bSystemJudge\u0010\u0003\u0012\u0018\n\u0014AllowEnterPlayerFull\u0010\u0004\u0012\u001b\n\u0017WorldLevelLowerThanHost\u0010\u0005\u0012\u000f\n\u000bHostInMatch\u0010\u0006\u0012\u0015\n\u0011PlayerInBlacklist\u0010\u0007\u0012\u001b\n\u0017PsPlayerNotAcceptOthers\u0010\b\u0012\u0011\n\rHostIsBlocked\u0010\t\u0012\u001d\n\u0019OtherDataVersionNotLatest\u0010\n\u0012\u0018\n\u0014DataVersionNotLatest\u0010\u000b\u0012\u001a\n\u0016PlayerNotInPlayerWorld\u0010\fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private PlayerApplyEnterMpReasonOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PlayerApplyEnterMpReasonOuterClass$PlayerApplyEnterMpReason.class */
    public enum PlayerApplyEnterMpReason implements ProtocolMessageEnum {
        PlayerJudge(0),
        SceneCannotEnter(1),
        PlayerCannotEnterMp(2),
        SystemJudge(3),
        AllowEnterPlayerFull(4),
        WorldLevelLowerThanHost(5),
        HostInMatch(6),
        PlayerInBlacklist(7),
        PsPlayerNotAcceptOthers(8),
        HostIsBlocked(9),
        OtherDataVersionNotLatest(10),
        DataVersionNotLatest(11),
        PlayerNotInPlayerWorld(12),
        UNRECOGNIZED(-1);
        
        public static final int PlayerJudge_VALUE = 0;
        public static final int SceneCannotEnter_VALUE = 1;
        public static final int PlayerCannotEnterMp_VALUE = 2;
        public static final int SystemJudge_VALUE = 3;
        public static final int AllowEnterPlayerFull_VALUE = 4;
        public static final int WorldLevelLowerThanHost_VALUE = 5;
        public static final int HostInMatch_VALUE = 6;
        public static final int PlayerInBlacklist_VALUE = 7;
        public static final int PsPlayerNotAcceptOthers_VALUE = 8;
        public static final int HostIsBlocked_VALUE = 9;
        public static final int OtherDataVersionNotLatest_VALUE = 10;
        public static final int DataVersionNotLatest_VALUE = 11;
        public static final int PlayerNotInPlayerWorld_VALUE = 12;
        private static final Internal.EnumLiteMap<PlayerApplyEnterMpReason> internalValueMap = new Internal.EnumLiteMap<PlayerApplyEnterMpReason>() { // from class: emu.grasscutter.net.proto.PlayerApplyEnterMpReasonOuterClass.PlayerApplyEnterMpReason.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PlayerApplyEnterMpReason findValueByNumber(int number) {
                return PlayerApplyEnterMpReason.forNumber(number);
            }
        };
        private static final PlayerApplyEnterMpReason[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static PlayerApplyEnterMpReason valueOf(int value) {
            return forNumber(value);
        }

        public static PlayerApplyEnterMpReason forNumber(int value) {
            switch (value) {
                case 0:
                    return PlayerJudge;
                case 1:
                    return SceneCannotEnter;
                case 2:
                    return PlayerCannotEnterMp;
                case 3:
                    return SystemJudge;
                case 4:
                    return AllowEnterPlayerFull;
                case 5:
                    return WorldLevelLowerThanHost;
                case 6:
                    return HostInMatch;
                case 7:
                    return PlayerInBlacklist;
                case 8:
                    return PsPlayerNotAcceptOthers;
                case 9:
                    return HostIsBlocked;
                case 10:
                    return OtherDataVersionNotLatest;
                case 11:
                    return DataVersionNotLatest;
                case 12:
                    return PlayerNotInPlayerWorld;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<PlayerApplyEnterMpReason> internalGetValueMap() {
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
            return PlayerApplyEnterMpReasonOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static PlayerApplyEnterMpReason valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        PlayerApplyEnterMpReason(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
