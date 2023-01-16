package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ItemUseTarget;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/UseItemParams.class */
public class UseItemParams {
    public Player player;
    public ItemUseTarget itemUseTarget;
    public Avatar targetAvatar;
    public int count;
    public int optionId;
    public boolean isEnterMpDungeonTeam;
    public int usedItemId;

    public UseItemParams(Player player, ItemUseTarget itemUseTarget, Avatar targetAvatar, int count, int optionId, boolean isEnterMpDungeonTeam) {
        this.targetAvatar = null;
        this.count = 1;
        this.optionId = 0;
        this.isEnterMpDungeonTeam = false;
        this.usedItemId = 0;
        this.player = player;
        this.itemUseTarget = itemUseTarget;
        this.targetAvatar = targetAvatar;
        this.count = count;
        this.optionId = optionId;
        this.isEnterMpDungeonTeam = isEnterMpDungeonTeam;
    }

    public UseItemParams(Player player, ItemUseTarget itemUseTarget) {
        this.targetAvatar = null;
        this.count = 1;
        this.optionId = 0;
        this.isEnterMpDungeonTeam = false;
        this.usedItemId = 0;
        this.player = player;
        this.itemUseTarget = itemUseTarget;
    }
}
