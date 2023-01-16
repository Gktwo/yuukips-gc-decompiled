package emu.grasscutter.game.entity.gadget;

import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/GadgetContent.class */
public abstract class GadgetContent {
    private final EntityGadget gadget;

    public abstract boolean onInteract(Player player, GadgetInteractReqOuterClass.GadgetInteractReq gadgetInteractReq);

    public abstract void onBuildProto(SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder builder);

    public GadgetContent(EntityGadget gadget) {
        this.gadget = gadget;
    }

    public EntityGadget getGadget() {
        return this.gadget;
    }
}
