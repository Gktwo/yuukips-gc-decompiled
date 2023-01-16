package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatTypeArgumentOuterClass.class */
public final class CombatTypeArgumentOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018CombatTypeArgument.proto*È\u0006\n\u0012CombatTypeArgument\u0012\u001d\n\u0019COMBAT_TYPE_ARGUMENT_NONE\u0010��\u0012&\n\"COMBAT_TYPE_ARGUMENT_EVT_BEING_HIT\u0010\u0001\u0012/\n+COMBAT_TYPE_ARGUMENT_ANIMATOR_STATE_CHANGED\u0010\u0002\u0012$\n COMBAT_TYPE_ARGUMENT_FACE_TO_DIR\u0010\u0003\u0012*\n&COMBAT_TYPE_ARGUMENT_SET_ATTACK_TARGET\u0010\u0004\u0012\"\n\u001eCOMBAT_TYPE_ARGUMENT_RUSH_MOVE\u0010\u0005\u00123\n/COMBAT_TYPE_ARGUMENT_ANIMATOR_PARAMETER_CHANGED\u0010\u0006\u0012$\n COMBAT_TYPE_ARGUMENT_ENTITY_MOVE\u0010\u0007\u0012-\n)COMBAT_TYPE_ARGUMENT_SYNC_ENTITY_POSITION\u0010\b\u0012*\n&COMBAT_TYPE_ARGUMENT_STEER_MOTION_INFO\u0010\t\u0012+\n'COMBAT_TYPE_ARGUMENT_FORCE_SET_POS_INFO\u0010\n\u0012,\n(COMBAT_TYPE_ARGUMENT_COMPENSATE_POS_DIFF\u0010\u000b\u0012)\n%COMBAT_TYPE_ARGUMENT_MONSTER_DO_BLINK\u0010\f\u0012(\n$COMBAT_TYPE_ARGUMENT_FIXED_RUSH_MOVE\u0010\r\u0012'\n#COMBAT_TYPE_ARGUMENT_SYNC_TRANSFORM\u0010\u000e\u0012(\n$COMBAT_TYPE_ARGUMENT_LIGHT_CORE_MOVE\u0010\u000f\u0012)\n%COMBAT_TYPE_ARGUMENT_BEING_HEALED_NTF\u0010\u0010\u00122\n.COMBAT_TYPE_ARGUMENT_SKILL_ANCHOR_POSITION_NTF\u0010\u0011\u0012,\n(COMBAT_TYPE_ARGUMENT_GRAPPLING_HOOK_MOVE\u0010\u0012B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private CombatTypeArgumentOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatTypeArgumentOuterClass$CombatTypeArgument.class */
    public enum CombatTypeArgument implements ProtocolMessageEnum {
        COMBAT_TYPE_ARGUMENT_NONE(0),
        COMBAT_TYPE_ARGUMENT_EVT_BEING_HIT(1),
        COMBAT_TYPE_ARGUMENT_ANIMATOR_STATE_CHANGED(2),
        COMBAT_TYPE_ARGUMENT_FACE_TO_DIR(3),
        COMBAT_TYPE_ARGUMENT_SET_ATTACK_TARGET(4),
        COMBAT_TYPE_ARGUMENT_RUSH_MOVE(5),
        COMBAT_TYPE_ARGUMENT_ANIMATOR_PARAMETER_CHANGED(6),
        COMBAT_TYPE_ARGUMENT_ENTITY_MOVE(7),
        COMBAT_TYPE_ARGUMENT_SYNC_ENTITY_POSITION(8),
        COMBAT_TYPE_ARGUMENT_STEER_MOTION_INFO(9),
        COMBAT_TYPE_ARGUMENT_FORCE_SET_POS_INFO(10),
        COMBAT_TYPE_ARGUMENT_COMPENSATE_POS_DIFF(11),
        COMBAT_TYPE_ARGUMENT_MONSTER_DO_BLINK(12),
        COMBAT_TYPE_ARGUMENT_FIXED_RUSH_MOVE(13),
        COMBAT_TYPE_ARGUMENT_SYNC_TRANSFORM(14),
        COMBAT_TYPE_ARGUMENT_LIGHT_CORE_MOVE(15),
        COMBAT_TYPE_ARGUMENT_BEING_HEALED_NTF(16),
        COMBAT_TYPE_ARGUMENT_SKILL_ANCHOR_POSITION_NTF(17),
        COMBAT_TYPE_ARGUMENT_GRAPPLING_HOOK_MOVE(18),
        UNRECOGNIZED(-1);
        
        public static final int COMBAT_TYPE_ARGUMENT_NONE_VALUE = 0;
        public static final int COMBAT_TYPE_ARGUMENT_EVT_BEING_HIT_VALUE = 1;
        public static final int COMBAT_TYPE_ARGUMENT_ANIMATOR_STATE_CHANGED_VALUE = 2;
        public static final int COMBAT_TYPE_ARGUMENT_FACE_TO_DIR_VALUE = 3;
        public static final int COMBAT_TYPE_ARGUMENT_SET_ATTACK_TARGET_VALUE = 4;
        public static final int COMBAT_TYPE_ARGUMENT_RUSH_MOVE_VALUE = 5;
        public static final int COMBAT_TYPE_ARGUMENT_ANIMATOR_PARAMETER_CHANGED_VALUE = 6;
        public static final int COMBAT_TYPE_ARGUMENT_ENTITY_MOVE_VALUE = 7;
        public static final int COMBAT_TYPE_ARGUMENT_SYNC_ENTITY_POSITION_VALUE = 8;
        public static final int COMBAT_TYPE_ARGUMENT_STEER_MOTION_INFO_VALUE = 9;
        public static final int COMBAT_TYPE_ARGUMENT_FORCE_SET_POS_INFO_VALUE = 10;
        public static final int COMBAT_TYPE_ARGUMENT_COMPENSATE_POS_DIFF_VALUE = 11;
        public static final int COMBAT_TYPE_ARGUMENT_MONSTER_DO_BLINK_VALUE = 12;
        public static final int COMBAT_TYPE_ARGUMENT_FIXED_RUSH_MOVE_VALUE = 13;
        public static final int COMBAT_TYPE_ARGUMENT_SYNC_TRANSFORM_VALUE = 14;
        public static final int COMBAT_TYPE_ARGUMENT_LIGHT_CORE_MOVE_VALUE = 15;
        public static final int COMBAT_TYPE_ARGUMENT_BEING_HEALED_NTF_VALUE = 16;
        public static final int COMBAT_TYPE_ARGUMENT_SKILL_ANCHOR_POSITION_NTF_VALUE = 17;
        public static final int COMBAT_TYPE_ARGUMENT_GRAPPLING_HOOK_MOVE_VALUE = 18;
        private static final Internal.EnumLiteMap<CombatTypeArgument> internalValueMap = new Internal.EnumLiteMap<CombatTypeArgument>() { // from class: emu.grasscutter.net.proto.CombatTypeArgumentOuterClass.CombatTypeArgument.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CombatTypeArgument findValueByNumber(int number) {
                return CombatTypeArgument.forNumber(number);
            }
        };
        private static final CombatTypeArgument[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static CombatTypeArgument valueOf(int value) {
            return forNumber(value);
        }

        public static CombatTypeArgument forNumber(int value) {
            switch (value) {
                case 0:
                    return COMBAT_TYPE_ARGUMENT_NONE;
                case 1:
                    return COMBAT_TYPE_ARGUMENT_EVT_BEING_HIT;
                case 2:
                    return COMBAT_TYPE_ARGUMENT_ANIMATOR_STATE_CHANGED;
                case 3:
                    return COMBAT_TYPE_ARGUMENT_FACE_TO_DIR;
                case 4:
                    return COMBAT_TYPE_ARGUMENT_SET_ATTACK_TARGET;
                case 5:
                    return COMBAT_TYPE_ARGUMENT_RUSH_MOVE;
                case 6:
                    return COMBAT_TYPE_ARGUMENT_ANIMATOR_PARAMETER_CHANGED;
                case 7:
                    return COMBAT_TYPE_ARGUMENT_ENTITY_MOVE;
                case 8:
                    return COMBAT_TYPE_ARGUMENT_SYNC_ENTITY_POSITION;
                case 9:
                    return COMBAT_TYPE_ARGUMENT_STEER_MOTION_INFO;
                case 10:
                    return COMBAT_TYPE_ARGUMENT_FORCE_SET_POS_INFO;
                case 11:
                    return COMBAT_TYPE_ARGUMENT_COMPENSATE_POS_DIFF;
                case 12:
                    return COMBAT_TYPE_ARGUMENT_MONSTER_DO_BLINK;
                case 13:
                    return COMBAT_TYPE_ARGUMENT_FIXED_RUSH_MOVE;
                case 14:
                    return COMBAT_TYPE_ARGUMENT_SYNC_TRANSFORM;
                case 15:
                    return COMBAT_TYPE_ARGUMENT_LIGHT_CORE_MOVE;
                case 16:
                    return COMBAT_TYPE_ARGUMENT_BEING_HEALED_NTF;
                case 17:
                    return COMBAT_TYPE_ARGUMENT_SKILL_ANCHOR_POSITION_NTF;
                case 18:
                    return COMBAT_TYPE_ARGUMENT_GRAPPLING_HOOK_MOVE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<CombatTypeArgument> internalGetValueMap() {
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
            return CombatTypeArgumentOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static CombatTypeArgument valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        CombatTypeArgument(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
