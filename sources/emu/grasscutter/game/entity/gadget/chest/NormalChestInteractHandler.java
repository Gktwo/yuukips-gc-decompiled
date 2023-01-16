package emu.grasscutter.game.entity.gadget.chest;

import emu.grasscutter.game.entity.gadget.GadgetChest;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.ItemDef;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.world.ChestReward;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/chest/NormalChestInteractHandler.class */
public class NormalChestInteractHandler implements ChestInteractHandler {
    private final ChestReward chestReward;

    public NormalChestInteractHandler(ChestReward rewardData) {
        this.chestReward = rewardData;
    }

    @Override // emu.grasscutter.game.entity.gadget.chest.ChestInteractHandler
    public boolean isTwoStep() {
        return false;
    }

    @Override // emu.grasscutter.game.entity.gadget.chest.ChestInteractHandler
    public boolean onInteract(GadgetChest chest, Player player) {
        List<GameItem> items = new ArrayList<>();
        if (this.chestReward.getAdvExp() >= 1) {
            items.add(new GameItem(102, this.chestReward.getAdvExp()));
        }
        if (this.chestReward.getResin() >= 1) {
            items.add(new GameItem(106, this.chestReward.getResin()));
        }
        if (this.chestReward.getPrimogem() >= 1) {
            items.add(new GameItem(201, (int) (((double) this.chestReward.getPrimogem()) * (1.0d + (((double) (player.getWorldLevel() - 1)) * 0.5d)))));
        }
        if (this.chestReward.getMora() >= 1) {
            items.add(new GameItem(202, (int) (((double) this.chestReward.getMora()) * (1.0d + (((double) (player.getWorldLevel() - 1)) * 0.5d)))));
        }
        player.getInventory().addItems(items, ActionReason.SubfieldDrop);
        for (int i = 0; i < this.chestReward.getContent().size(); i++) {
            chest.getGadget().getScene().addItemEntity(this.chestReward.getContent().get(i).getItemId(), this.chestReward.getContent().get(i).getCount(), chest.getGadget());
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i2 = 0; i2 < this.chestReward.getRandomCount(); i2++) {
            ItemDef item = this.chestReward.getRandomContent().get(random.nextInt(this.chestReward.getRandomContent().size()));
            chest.getGadget().getScene().addItemEntity(item.getItemId(), item.getCount(), chest.getGadget());
        }
        return true;
    }
}
