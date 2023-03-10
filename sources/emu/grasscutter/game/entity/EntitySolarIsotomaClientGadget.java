package emu.grasscutter.game.entity;

import emu.grasscutter.game.entity.platform.EntityPlatform;
import emu.grasscutter.game.entity.platform.EntitySolarIsotomaElevatorPlatform;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntitySolarIsotomaClientGadget.class */
public class EntitySolarIsotomaClientGadget extends EntityClientGadget {
    public static final int GADGET_ID = 41038001;
    public static final int ELEVATOR_GADGET_ID = 41038002;
    private EntityPlatform platformGadget;

    public EntityPlatform getPlatformGadget() {
        return this.platformGadget;
    }

    public EntitySolarIsotomaClientGadget(Scene scene, Player player, EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotify notify) {
        super(scene, player, notify);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onCreate() {
        this.platformGadget = new EntitySolarIsotomaElevatorPlatform(this, getScene(), getOwner(), ELEVATOR_GADGET_ID, getPosition(), getRotation());
        getScene().addEntity(this.platformGadget);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onRemoved() {
        getScene().removeEntity(this.platformGadget);
    }
}
