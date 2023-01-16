package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.player.TeamManager;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseAddEnergy.class */
public abstract class ItemUseAddEnergy extends C1378ItemUseAction {
    public abstract float getAddEnergy(ElementType elementType);

    public float getAddEnergy(AvatarSkillDepotData depot) {
        ElementType element;
        if (depot == null || (element = depot.getElementType()) == null) {
            return 0.0f;
        }
        return getAddEnergy(element);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        float offFieldRatio;
        TeamManager teamManager = params.player.getTeamManager();
        switch (params.itemUseTarget) {
            case ITEM_USE_TARGET_CUR_AVATAR:
                addEnergy(teamManager.getCurrentAvatarEntity().getAvatar(), (float) params.count);
                return true;
            case ITEM_USE_TARGET_CUR_TEAM:
                List<EntityAvatar> activeTeam = teamManager.getActiveTeam();
                switch (activeTeam.size()) {
                    case 2:
                        offFieldRatio = 0.8f;
                        break;
                    case 3:
                        offFieldRatio = 0.7f;
                        break;
                    default:
                        offFieldRatio = 0.6f;
                        break;
                }
                int currentCharacterIndex = teamManager.getCurrentCharacterIndex();
                for (int i = 0; i < activeTeam.size(); i++) {
                    Avatar avatar = activeTeam.get(i).getAvatar();
                    if (i == currentCharacterIndex) {
                        addEnergy(avatar, (float) params.count);
                    } else {
                        addEnergy(avatar, ((float) params.count) * offFieldRatio);
                    }
                }
                return true;
            case ITEM_USE_TARGET_SPECIFY_AVATAR:
            case ITEM_USE_TARGET_SPECIFY_ALIVE_AVATAR:
            case ITEM_USE_TARGET_SPECIFY_DEAD_AVATAR:
                return addEnergy(params.targetAvatar, (float) params.count);
            case ITEM_USE_TARGET_NONE:
                return false;
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    private boolean addEnergy(Avatar avatar, float multiplier) {
        float energy = getAddEnergy(avatar.getSkillDepot()) * multiplier;
        if (energy < 0.01f) {
            return false;
        }
        avatar.getAsEntity().addEnergy(energy, PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_ENERGY_BALL);
        return true;
    }
}
