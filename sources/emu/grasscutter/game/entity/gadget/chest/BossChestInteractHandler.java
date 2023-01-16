package emu.grasscutter.game.entity.gadget.chest;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.RewardPreviewData;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.gadget.GadgetChest;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.managers.ResinManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.scripts.data.SceneGadget;
import emu.grasscutter.scripts.data.SceneMonster;
import emu.grasscutter.server.packet.send.PacketGadgetAutoPickDropInfoNotify;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/chest/BossChestInteractHandler.class */
public class BossChestInteractHandler implements ChestInteractHandler {
    @Override // emu.grasscutter.game.entity.gadget.chest.ChestInteractHandler
    public boolean isTwoStep() {
        return true;
    }

    @Override // emu.grasscutter.game.entity.gadget.chest.ChestInteractHandler
    public boolean onInteract(GadgetChest chest, Player player) {
        return onInteract(chest, player, false);
    }

    public boolean onInteract(GadgetChest chest, Player player, boolean useCondensedResin) {
        List<GameItem> blossomRewards = player.getScene().getBlossomManager().onReward(player, chest.getGadget(), useCondensedResin);
        if (blossomRewards != null) {
            player.getInventory().addItems(blossomRewards, ActionReason.OpenWorldBossChest);
            player.sendPacket(new PacketGadgetAutoPickDropInfoNotify(blossomRewards));
            return true;
        }
        List<GameItem> rewards = new ArrayList<>();
        EntityGadget gadget = chest.getGadget();
        if (gadget == null) {
            Grasscutter.getLogger().error("Could not found GadgetChest with gadget null");
            return false;
        }
        SceneGadget meta = gadget.getMetaGadget();
        if (meta.group == null) {
            Grasscutter.getLogger().error("Could not found GadgetChest with metal grup null");
            return false;
        } else if (meta.boss_chest == null) {
            Grasscutter.getLogger().error("Could not found GadgetChest with metal boss_chest null");
            return false;
        } else {
            int monster_config_id = meta.boss_chest.monster_config_id;
            SceneMonster monster = meta.group.monsters.get(Integer.valueOf(meta.boss_chest.monster_config_id));
            if (monster == null) {
                Grasscutter.getLogger().error("Could not found boss monster {}", Integer.valueOf(monster_config_id));
                return false;
            }
            RewardPreviewData reward = gadget.getScene().getWorld().getServer().getWorldDataSystem().getRewardByBossId(monster.monster_id);
            if (reward == null) {
                Grasscutter.getLogger().warn("Could not found the reward of boss monster {}", Integer.valueOf(monster.monster_id));
                rewards.add(new GameItem(201, 100));
                player.sendNotif("While reward for this scene is not available, but we will replace it with primogem 100x :)");
            } else {
                ResinManager resinManager = player.getResinManager();
                if (!(useCondensedResin ? resinManager.useCondensedResin(1) : resinManager.useResin(20))) {
                    return false;
                }
                ItemParamData[] previewItems = reward.getPreviewItems();
                for (ItemParamData param : previewItems) {
                    rewards.add(new GameItem(param.getId(), Math.max(param.getCount(), 1)));
                }
            }
            player.getInventory().addItems(rewards, ActionReason.OpenWorldBossChest);
            player.sendPacket(new PacketGadgetAutoPickDropInfoNotify(rewards));
            return true;
        }
    }
}
