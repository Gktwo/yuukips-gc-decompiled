package emu.grasscutter.game.entity.gadget.chest;

import emu.grasscutter.game.entity.gadget.GadgetChest;
import emu.grasscutter.game.player.Player;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/chest/ChestInteractHandler.class */
public interface ChestInteractHandler {
    boolean isTwoStep();

    boolean onInteract(GadgetChest gadgetChest, Player player);
}
