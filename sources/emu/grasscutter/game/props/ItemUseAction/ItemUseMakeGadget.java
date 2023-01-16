package emu.grasscutter.game.props.ItemUseAction;

import emu.grasscutter.game.entity.EntityVehicle;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ItemUseOp;
import emu.grasscutter.game.world.Scene;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseMakeGadget.class */
public class ItemUseMakeGadget extends ItemUseInt {
    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public ItemUseOp getItemUseOp() {
        return ItemUseOp.ITEM_USE_MAKE_GADGET;
    }

    public ItemUseMakeGadget(String[] useParam) {
        super(useParam);
    }

    @Override // emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction
    public boolean useItem(UseItemParams params) {
        Player player = params.player;
        Scene scene = player.getScene();
        scene.addEntity(new EntityVehicle(scene, player, this.f589i, 0, player.getPosition().nearby2d(1.0f), player.getRotation().clone()));
        return true;
    }
}
